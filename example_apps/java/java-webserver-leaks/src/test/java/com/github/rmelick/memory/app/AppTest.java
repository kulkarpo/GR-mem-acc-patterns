package com.github.rmelick.memory.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rmelick.memory.api.DeviceUpdateMessage;
import com.github.rmelick.memory.api.DeviceUpdateMessages;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpClientRequest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This test runs the application
 */
public class AppTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final int DELAY_BETWEEN_BATCHES_SEC = 1;
  private static final int SINGLE_REQUEST_TIMEOUT = 10;

  private final HttpClient httpClient;

  public AppTest() {
    HttpClientOptions clientOptions = new HttpClientOptions();
    clientOptions.setDefaultHost("localhost");
    clientOptions.setDefaultPort(8080);
    httpClient = Vertx.vertx().createHttpClient(clientOptions);
  }

  @Test
  public void testApp() throws InterruptedException {
    List<DeviceSimulator> devices = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      devices.add(DeviceSimulator.random());
    }

    AtomicLong batchCounter = new AtomicLong(0);

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.scheduleWithFixedDelay(
      () -> {
        long batch = batchCounter.incrementAndGet();
        try {
          List<DeviceUpdateMessage> messages = new ArrayList<>();
          for (DeviceSimulator device : devices) {
            messages.add(device.getUpdate());
          }
          updateDevice(new DeviceUpdateMessages(messages), batch);
        } catch (Throwable t) {
          LOGGER.error("Failed to update batch " + batch, t);
        }
      },
      0,
      DELAY_BETWEEN_BATCHES_SEC,
      TimeUnit.SECONDS
    );

    new CountDownLatch(1).await(30, TimeUnit.MINUTES);
  }

  private void updateDevice(DeviceUpdateMessages updateMessages, long batchId) throws JsonProcessingException, InterruptedException {
    CountDownLatch requestComplete = new CountDownLatch(1);
    HttpClientRequest request = httpClient.post("some-uri", response -> {
      LOGGER.info("Batch {}, {} {}", batchId, response.statusCode(), response.statusMessage());
      requestComplete.countDown();
    });
    //request.setTimeout(TimeUnit.SECONDS.toMillis(DELAY_BETWEEN_BATCHES_SEC) - 100);
    request.exceptionHandler(throwable -> {
      LOGGER.error("Batch {}, error {}", batchId, throwable.getClass());
      requestComplete.countDown();
    });
    request.end(OBJECT_MAPPER.writeValueAsString(updateMessages));

    if (!requestComplete.await(SINGLE_REQUEST_TIMEOUT, TimeUnit.SECONDS)) {
      LOGGER.error("Batch {} timeout", batchId);
    }
  }
}

package com.github.rmelick.memory.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rmelick.memory.api.DeviceService;
import com.github.rmelick.memory.api.DeviceUpdateMessages;
import com.github.rmelick.memory.service.DeviceServiceImpl;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws InterruptedException {
        new App().run(args);
    }

    public void run(String[] args) throws InterruptedException {
        LOGGER.info("Starting application");
        final DeviceService deviceService = new DeviceServiceImpl();

        AtomicLong requestCounter = new AtomicLong(0);
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(request -> {
            request.bodyHandler(body -> {
                try {
                    LOGGER.info("Received request " + requestCounter.incrementAndGet());
                    DeviceUpdateMessages parsedMessage = OBJECT_MAPPER.readValue(body.toString(), DeviceUpdateMessages.class);
                    deviceService.receiveMessage(parsedMessage);
                    request.response().end();
                } catch (IOException e) {
                    LOGGER.error("Could not parse incoming message", e);
                }
            });
        });
        httpServer.listen(8080, "0.0.0.0", startupComplete -> {
            if (startupComplete.succeeded()) {
                LOGGER.info("Application startup complete");
            } else {
                LOGGER.error("Application startup failed", startupComplete.cause());
            }
        });
    }
}

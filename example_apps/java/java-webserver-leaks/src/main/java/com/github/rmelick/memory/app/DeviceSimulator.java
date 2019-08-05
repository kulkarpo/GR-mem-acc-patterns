package com.github.rmelick.memory.app;

import com.github.rmelick.memory.api.DeviceUpdateMessage;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 *
 */
public class DeviceSimulator {
  private static final Random RANDOM = new Random();

  private final String guid;
  private final Map<String, Double> tagValues;
  public static final int NUMBER_OF_TAGS = 100;

  public static DeviceSimulator random() {
    String guid = UUID.randomUUID().toString();
    List<String> tagNames = new ArrayList<>(NUMBER_OF_TAGS);
    for (int i = 0; i < NUMBER_OF_TAGS; i++) {
      tagNames.add(RandomStringUtils.randomAlphabetic(10));
    }
    return new DeviceSimulator(guid, tagNames);
  }

  private DeviceSimulator(String guid, List<String> tagNames) {
    this.guid = guid;
    this.tagValues = new HashMap<>(tagNames.size());
    for (String tagName : tagNames) {
      tagValues.put(tagName, RANDOM.nextDouble());
    }
  }

  private void updateValues() {
    for (String tagName : tagValues.keySet()) {
      tagValues.put(tagName, RANDOM.nextDouble());
    }
  }

  public DeviceUpdateMessage getUpdate() {
    updateValues();
    return new DeviceUpdateMessage(guid, System.currentTimeMillis(), tagValues);
  }


}

package com.github.rmelick.memory.service.cache;

import com.github.rmelick.memory.api.DeviceUpdateMessage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class DeviceCache {
  private final ConcurrentHashMap<GuidAndName, TimestampedValue> cache = new ConcurrentHashMap<>();

  public void updateFromMessage(DeviceUpdateMessage deviceUpdateMessage) {
    String deviceGuid = deviceUpdateMessage.getDeviceGuid();
    long timestampMs = deviceUpdateMessage.getTimestampMs();
    for (Map.Entry<String, Double> tagWithValue : deviceUpdateMessage.getTagValues().entrySet()) {
      String tagName = tagWithValue.getKey();
      Double tagValue = tagWithValue.getValue();
      GuidAndName guidAndName = new GuidAndName(deviceGuid, tagName);
      TimestampedValue timestampedValue = new TimestampedValue(timestampMs, tagValue);
      synchronized (cache) {
        TimestampedValue existingValue = cache.get(guidAndName);
        if (existingValue == null || existingValue.getTimestampMs() < timestampedValue.getTimestampMs()) {
          cache.put(guidAndName, timestampedValue);
        }
      }
    }
  }

  public Double getCurrentValue(String deviceGuid, String tagName) {
    GuidAndName guidAndName = new GuidAndName(deviceGuid, tagName);
    TimestampedValue timestampedValue = cache.get(guidAndName);
    return timestampedValue!= null ? timestampedValue.getValue() : null;
  }

}

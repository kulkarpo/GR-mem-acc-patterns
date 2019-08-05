package com.github.rmelick.memory.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * The public api for a message that enters the system
 */
public class DeviceUpdateMessage {
  private final String deviceGuid;
  private final long timestampMs;
  private final Map<String, Double> tagValues;

  public DeviceUpdateMessage(@JsonProperty("deviceGuid") String deviceGuid,
                             @JsonProperty("timestampMs") long timestampMs,
                             @JsonProperty("tagValues") Map<String, Double> tagValues) {
    this.deviceGuid = deviceGuid;
    this.timestampMs = timestampMs;
    this.tagValues = tagValues;
  }

  public String getDeviceGuid() {
    return deviceGuid;
  }

  public long getTimestampMs() {
    return timestampMs;
  }

  public Map<String, Double> getTagValues() {
    return tagValues;
  }
}

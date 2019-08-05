package com.github.rmelick.memory.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 */
public class DeviceUpdateMessages {
  private final List<DeviceUpdateMessage> deviceUpdateMessages;

  public DeviceUpdateMessages(@JsonProperty("deviceUpdateMessages") List<DeviceUpdateMessage> deviceUpdateMessages) {
    this.deviceUpdateMessages = deviceUpdateMessages;
  }

  public List<DeviceUpdateMessage> getDeviceUpdateMessages() {
    return deviceUpdateMessages;
  }
}

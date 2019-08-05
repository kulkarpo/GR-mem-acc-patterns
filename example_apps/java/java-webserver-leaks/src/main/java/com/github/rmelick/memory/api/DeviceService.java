package com.github.rmelick.memory.api;

/**
 * Our web application
 */
public interface DeviceService {
  void receiveMessage(DeviceUpdateMessages deviceUpdateMessages);

  Double getCurrentValue(String deviceGuid, String tagName);
}

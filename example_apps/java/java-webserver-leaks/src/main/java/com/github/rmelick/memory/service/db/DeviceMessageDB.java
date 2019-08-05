package com.github.rmelick.memory.service.db;

import com.github.rmelick.memory.api.DeviceUpdateMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class DeviceMessageDB {
  private final Map<DeviceId, DeviceUpdateMessage> mostRecentUpdates = new ConcurrentHashMap<>();

  public void updateFromMessage(DeviceUpdateMessage deviceUpdateMessage) {
    DeviceId key = new DeviceId(deviceUpdateMessage.getDeviceGuid());
    mostRecentUpdates.put(key, deviceUpdateMessage);
  }

  public DeviceUpdateMessage getMostRecentUpdate(String deviceGuid) {
    DeviceId key = new DeviceId(deviceGuid);
    return mostRecentUpdates.get(key);
  }
}

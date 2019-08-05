package com.github.rmelick.memory.service;

import com.github.rmelick.memory.api.DeviceService;
import com.github.rmelick.memory.api.DeviceUpdateMessage;
import com.github.rmelick.memory.api.DeviceUpdateMessages;
import com.github.rmelick.memory.service.cache.DeviceCache;
import com.github.rmelick.memory.service.db.DeviceMessageDB;

/**
 *
 */
public class DeviceServiceImpl implements DeviceService {
  private final DeviceCache deviceCache = new DeviceCache();
  private final DeviceMessageDB deviceMessageDB = new DeviceMessageDB();

  @Override
  public void receiveMessage(DeviceUpdateMessages deviceUpdateMessages) {
    for (DeviceUpdateMessage deviceUpdateMessage : deviceUpdateMessages.getDeviceUpdateMessages()) {
      deviceCache.updateFromMessage(deviceUpdateMessage);
      deviceMessageDB.updateFromMessage(deviceUpdateMessage);
    }
  }

  @Override
  public Double getCurrentValue(String deviceGuid, String tagName) {
    Double cacheValue = deviceCache.getCurrentValue(deviceGuid, tagName);
    Double dbValue = deviceMessageDB.getMostRecentUpdate(deviceGuid).getTagValues().get(tagName);
    if (!cacheValue.equals(dbValue)) {
      throw new IllegalStateException("Cache and db values do not match");
    }
    return cacheValue;
  }
}

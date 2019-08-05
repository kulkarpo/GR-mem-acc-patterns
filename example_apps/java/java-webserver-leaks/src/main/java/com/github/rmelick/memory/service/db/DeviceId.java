package com.github.rmelick.memory.service.db;

/**
 *
 */
public class DeviceId {
  // currently the only thing used to identify a device is the guid, perhaps later we will use owner or channel
  private final String guid;

  public DeviceId(String guid) {
    this.guid = guid;
  }
}

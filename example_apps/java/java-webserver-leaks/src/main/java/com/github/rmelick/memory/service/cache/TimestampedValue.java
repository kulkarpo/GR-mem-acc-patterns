package com.github.rmelick.memory.service.cache;

/**
 * Value and a timestamp
 */
public class TimestampedValue {
  private final long timestampMs;
  private final Double value;

  public TimestampedValue(long timestampMs, Double value) {
    this.timestampMs = timestampMs;
    this.value = value;
  }

  public long getTimestampMs() {
    return timestampMs;
  }

  public Double getValue() {
    return value;
  }
}

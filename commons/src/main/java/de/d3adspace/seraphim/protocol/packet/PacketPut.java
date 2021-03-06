/*
 * Copyright (c) 2017 - 2019 D3adspace
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.d3adspace.seraphim.protocol.packet;


import de.d3adspace.skylla.commons.buffer.SkyllaBuffer;
import de.d3adspace.skylla.commons.protocol.packet.SkyllaPacket;
import de.d3adspace.skylla.commons.protocol.packet.SkyllaPacketMeta;

/**
 * @author Felix 'SasukeKawaii' Klauke
 */
@SkyllaPacketMeta(id = 3)
public class PacketPut extends SkyllaPacket {

  /**
   * The key of the value to cache.
   */
  private Object key;

  /**
   * The value to cache.
   */
  private Object value;

  /**
   * Time to live for the value.
   */
  private long expiry;

  /**
   * Create a new Request.
   *
   * @param key The key.
   * @param value The value.
   * @param expiry The time to live.
   */
  public PacketPut(Object key, Object value, long expiry) {
    this.key = key;
    this.value = value;
    this.expiry = expiry;
  }

  /**
   * Packet Constructor
   */
  public PacketPut() {
  }

  /**
   * Get the key of the object to cache.
   *
   * @return The key.
   */
  public Object getKey() {
    return key;
  }

  /**
   * Get the value to cache.
   *
   * @return The value.
   */
  public Object getValue() {
    return value;
  }

  /**
   * Get the time to live of the value.
   *
   * @return The time to live.
   */
  public long getExpiry() {
    return expiry;
  }

  @Override
  public void write(SkyllaBuffer skyllaBuffer) {
    skyllaBuffer.writeObject(key);
    skyllaBuffer.writeObject(value);
    skyllaBuffer.writeLong(expiry);
  }

  @Override
  public void read(SkyllaBuffer skyllaBuffer) {
    key = skyllaBuffer.readObject();
    value = skyllaBuffer.readObject();
    expiry = skyllaBuffer.readLong();
  }

  @Override
  public String toString() {
    return "PacketPut{" +
        "key=" + key +
        ", value=" + value +
        ", expiry=" + expiry +
        '}';
  }
}

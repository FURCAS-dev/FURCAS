/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.Map.Entry;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public final class RpcMap_CustomFieldSerializer {

  public static void deserialize(SerializationStreamReader streamReader, RpcMap instance)
      throws SerializationException {
    int size = streamReader.readInt();

    for (int i = 0; i < size; ++i) {
      String key = streamReader.readString();
      Object value = streamReader.readObject();

      instance.put(key, value);
    }
  }

  public static void serialize(SerializationStreamWriter streamWriter, RpcMap instance)
      throws SerializationException {
    int size = instance.size();
    streamWriter.writeInt(size);

    for (Entry<String, Object> entry : instance.entrySet()) {
      streamWriter.writeString(entry.getKey());
      streamWriter.writeObject(entry.getValue());
    }
  }

}
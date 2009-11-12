/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core;

import java.util.HashMap;
import java.util.Map;

public class TemplatesCache {

  public static Cache INSTANCE = new Cache();

  public static class Cache {

    private Map<Key, Object> cacheMap = new HashMap<Key, Object>();

    public Object get(Object... keyValues) {
      return cacheMap.get(new Key(keyValues));
    }

    public void put(Object template, Object... keyValues) {
      cacheMap.put(new Key(keyValues), template);
    }

    public static class Key {
      private Object keyValues[] = null;

      public Key(Object... keyValues) {
        this.keyValues = keyValues;
      }

      @Override
      public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Key)) {
          return false;
        }
        Key other = (Key) obj;
        if (other.keyValues == null && keyValues == null) {
          return true;
        }
        if (other.keyValues == null || keyValues == null
            || other.keyValues.length != keyValues.length) {
          return false;
        }
        for (int i = 0; i < keyValues.length; i++) {
          if (!(keyValues[i] == other.keyValues[i] || (keyValues[i] != null && keyValues[i].equals(other.keyValues[i])))) {
            return false;
          }
        }
        return true;
      }

      @Override
      public int hashCode() {
        int result = 17;

        if (keyValues != null) {
          for (Object object : keyValues) {
            result = 37 * result + (object == null ? 1 : object.hashCode());
          }
        }
        return result;
      }

      @Override
      public String toString() {
        StringBuffer sb = new StringBuffer("{");
        boolean first = true;

        if (keyValues != null) {
          for (Object object : keyValues) {
            if (!first) {
              sb.append(',');
            } else {
              first = false;
            }
            sb.append(object == null ? "null" : object.toString());
          }
        }
        sb.append('}');
        return sb.toString();
      }

    }
  }
}

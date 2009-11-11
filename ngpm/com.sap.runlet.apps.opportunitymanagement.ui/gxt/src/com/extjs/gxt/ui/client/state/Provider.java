/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.state;

import java.util.Date;
import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.StateEvent;

/**
 * Abstract base class for state provider implementations. This class provides
 * methods for encoding and decoding objects.
 */
public abstract class Provider extends BaseObservable {

  protected StateManager manager;

  protected void bind(StateManager manager) {
    this.manager = manager;
  }

  /**
   * Clears a value.
   * 
   * @param name the key name
   */
  public void clear(String name) {
    clearKey(name);
    StateEvent se = new StateEvent(manager);
    se.setName(name);
    fireEvent(Events.StateChange, se);
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public Object get(String name) {
    String val = getValue(name);
    if (val == null) return null;
    Object obj = decodeValue(val);
    return obj;
  }

  @SuppressWarnings("unchecked")
  public Map<String, Object> getMap(String name) {
    String val = getValue(name);
    if (val == null) return null;
    Map<String, Object> map = (Map) decodeValue(val);
    return map;
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public String getString(String name) {
    String val = getValue(name);
    if (val == null) return null;
    String obj = (String) decodeValue(val);
    return obj;
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public boolean getBoolean(String name) {
    String val = getValue(name);
    if (val == null) return false;
    Boolean bVal = (Boolean) decodeValue(val);
    return bVal.booleanValue();
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public Date getDate(String name) {
    String val = getValue(name);
    if (val == null) return null;
    Date date = (Date) decodeValue(val);
    return date;
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value or -1
   */
  public int getInteger(String name) {
    String val = getValue(name);
    Integer iVal = (Integer) decodeValue(val);
    if (iVal == null) {
      return -1;
    }
    return iVal.intValue();
  }

  /**
   * Sets a key.
   * 
   * @param name the key name
   * @param value the value
   */
  public void set(String name, Object value) {
    String val = encodeValue(value);
    setValue(name, val);
    StateEvent re = new StateEvent(manager, name, value);
    re.setName(name);
    re.setValue(value);
    fireEvent(Events.StateChange, re);
  }

  protected abstract void clearKey(String name);

  protected Map<String, Object> decodeMap(String value) {
    Map<String, Object> map = new FastMap<Object>();
    String vals = value.substring(2);
    String[] values = vals.split(",");
    for (String s : values) {
      String key = s.substring(0, s.indexOf("|"));
      Object val = decodeValue(s.substring(s.indexOf("|") + 1));
      map.put(key, val);
    }

    return map;
  }

  protected Object decodeValue(String value) {
    try {
      if (value == null || value.length() < 3) {
        return null;
      }
      String type = value.substring(0, 2);
      String val = value.substring(2);
      if (type.equals("m:")) {
        return decodeMap(value);
      } else if (type.equals("i:")) {
        return Integer.decode(val);
      } else if (type.equals("d:")) {
        long time = Long.parseLong(val);
        return new Date(time);
      } else if (type.equals("f:")) {
        return new Float(val);
      } else if (type.equals("b:")) {
        return new Boolean(val);
      }
      return val;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

  }

  protected String encodeMap(Map<String, Object> map) {
    StringBuffer sb = new StringBuffer();
    sb.append("m:");
    for (String key : map.keySet()) {
      String val = encodeValue(map.get(key));
      sb.append(key + "|" + val + ",");
    }
    int end = sb.length() - (sb.length() > 2 ? 1 : 0);
    String encode = sb.toString().substring(0, end);
    return encode;
  }

  @SuppressWarnings("unchecked")
  protected String encodeValue(Object value) {
    if (value instanceof Map) {
      return encodeMap((Map) value);
    } else if (value instanceof Date) {
      return "d:" + ((Date) value).getTime();
    } else if (value instanceof Integer) {
      return "i:" + value;
    } else if (value instanceof Float) {
      return "f:" + value;
    } else if (value instanceof Boolean) {
      return "b:" + value;
    }
    return "s:" + value.toString();
  }

  protected abstract String getValue(String name);

  protected abstract void setValue(String name, String value);

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.js.JsObject;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Aggregates both a list of values and a map of named values. Allows methods to
 * support both list and maps in a single parameter.
 * <p>
 * Note that only one type of values should be specified.
 * </p>
 */
public class Params {

  private List<Object> values;
  private Map<String, Object> mapValues;

  public boolean isList = false;

  public boolean isMap = false;

  /**
   * Creates a new params instance.
   */
  public Params() {

  }

  /**
   * Creates a new params instance.
   * 
   * @param values the initial values
   */
  public Params(Object... values) {
    for (int i = 0; i < values.length; i++) {
      add(values[i]);
    }
  }

  /**
   * Creates a new parameters instance.
   * 
   * @param key the key
   * @param value the value
   */
  public Params(String key, Object value) {
    mapValues = new FastMap<Object>();
    mapValues.put(key, value);
  }

  /**
   * Creates a new params instance.
   * 
   * @param values the initial values
   */
  public Params(Map<String, Object> values) {
    mapValues = values;
  }

  /**
   * Adds a value.
   * 
   * @param value the value to add
   * @return this
   */
  public Params add(Object value) {
    isList = true;
    if (values == null) values = new ArrayList<Object>();
    values.add(value);
    return this;
  }

  /**
   * Sets a value.
   * 
   * @param key the key
   * @param value the value
   * @return this
   */
  public Params set(String key, Object value) {
    isMap = true;
    if (value == null) return this;
    if (mapValues == null) {
      mapValues = new FastMap<Object>();
    }
    mapValues.put(key, value);
    return this;
  }

  public Map<String, Object> getMap() {
    return mapValues;
  }

  public List<Object> getList() {
    return values;
  }

  public JavaScriptObject getValues() {
    if (values != null) {
      return JsUtil.toJavaScriptArray(values.toArray());
    } else if (mapValues != null) {
      return JsUtil.toJavaScriptObject(mapValues);
    }
    return new JsObject().getJsObject();
  }

}

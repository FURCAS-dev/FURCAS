/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.js;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Wraps a native javascript object.
 */
public class JsObject implements JsWrapper {

  /**
   * The native javascript object.
   */
  protected JavaScriptObject jsObject;

  /**
   * Creates a new instance.
   */
  public JsObject() {
    jsObject = JsUtil.eval("[{}]");
  }

  /**
   * Creates a new object from the given JSON text.
   * 
   * @param data the JSON text
   */
  public JsObject(String data) {
    jsObject = JsUtil.eval("[{" + data + "}]");
  }

  /**
   * Returns a property value.
   * 
   * @param name the property name
   * @return the value
   */
  public native Object get(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public native boolean getBoolean(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public native byte getByte(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public native char getChar(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public native double getDouble(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public native float getFloat(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public JavaScriptObject getJsObject() {
    return jsObject;
  }

  /**
   * Returns a property value.
   * 
   * @param name the property name
   * @return the value
   */
  public native int getInt(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public native short getShort(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  /**
   * Returns a property value.
   * 
   * @param name the property name
   * @return the value
   */
  public native String getString(String name) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    return js[name];
  }-*/;

  public native void set(String name, boolean value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  public native void set(String name, int value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  public native void set(String name, short value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  public native void set(String name, char value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  public native void set(String name, double value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  public native void set(String name, byte value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  public native void set(String name, float value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  public native void set(String name, JavaScriptObject value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  /**
   * Sets a property.
   * 
   * @param name the property name
   * @param wrapper the property value
   */
  public void set(String name, JsWrapper wrapper) {
    set(name, wrapper.getJsObject());
  }

  public void set(String name, Object value) {
    if (value instanceof Boolean) {
      set(name, (boolean) (Boolean) value);
    } else if (value instanceof Long) {
      set(name, (double) (Long) value);
    } else if (value instanceof Integer) {
      set(name, (int) (Integer) value);
    } else if (value instanceof Short) {
      set(name, (short) (Short) value);
    } else if (value instanceof Double) {
      set(name, (double) (Double) value);
    } else if (value instanceof Float) {
      set(name, (float) (Float) value);
    } else if (value instanceof Character) {
      set(name, (char) (Character) value);
    } else if (value instanceof Byte) {
      set(name, (byte) (Byte) value);
    } else {
      setObjectInternal(name, value);
    }
  }

  public native void set(String name, String value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

  protected native JavaScriptObject create() /*-{
    return {};
  }-*/;

  private native void setObjectInternal(String name, Object value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsObject::jsObject;
    js[name] = value;
  }-*/;

}

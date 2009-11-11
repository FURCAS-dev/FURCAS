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
 * Wraps a native javascript array.
 */
public class JsArray implements JsWrapper {

  /**
   * The wrapped javascript object.
   */
  protected JavaScriptObject jsArray;

  /**
   * Creates a new instance.
   */
  public JsArray() {
    jsArray = create();
  }

  public JavaScriptObject getJsObject() {
    return jsArray;
  }

  /**
   * Adds a string value to the array.
   * 
   * @param value the value to add
   */
  public native void add(String value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsArray::jsArray;
    js[js.length] = value;
  }-*/;

  /**
   * Adds a object to the array.
   * 
   * @param value the object to add
   */
  public native void add(Object value) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsArray::jsArray;
    js[js.length] = value;
  }-*/;

  /**
   * Adds a native javascript object to the array.
   * 
   * @param object the object to add
   */
  public native void add(JavaScriptObject object) /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsArray::jsArray;
    js[js.length] = object;
  }-*/;

  /**
   * Returns the size of the array.
   * 
   * @return the size
   */
  public native int size() /*-{
    var js = this.@com.extjs.gxt.ui.client.js.JsArray::jsArray;
    return js.length;
  }-*/;

  protected native JavaScriptObject create() /*-{
    return new Array();
  }-*/;

  public static native JavaScriptObject eval(String code) /*-{
    var x = eval(code);
    return x[0];
  }-*/;

}

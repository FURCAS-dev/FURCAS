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
 * Interface for objects that wrap a native javascript object.
 */
public interface JsWrapper {

  /**
   * Returns the javscript object.
   * 
   * @return the object
   */
  public JavaScriptObject getJsObject();

}

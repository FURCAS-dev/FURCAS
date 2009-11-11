/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * Basic implementation of the <code>ModelStringProvider</code> interface.
 * Simply calls toSring on the value.
 */
public class BaseModelStringProvider<M extends ModelData> implements ModelStringProvider<M> {

  public String getStringValue(M model, String property) {
    Object value = model.get(property);
    return value == null ? "" : value.toString();
  }

}

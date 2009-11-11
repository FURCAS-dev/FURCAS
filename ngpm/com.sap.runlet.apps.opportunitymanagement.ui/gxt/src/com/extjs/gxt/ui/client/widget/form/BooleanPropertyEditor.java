/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

/**
 * <code>PropertyEditor</code> for boolean values.
 */
public class BooleanPropertyEditor implements PropertyEditor<Boolean> {

  public Boolean convertStringValue(String value) {
    String v = value != null ? value.toString().toLowerCase() : null;
    if (v != null && (v.equals("true") || v.equals("on"))) {
      return true;
    } else {
      return false;
    }
  }

  public String getStringValue(Boolean value) {
    return value.toString();
  }

}

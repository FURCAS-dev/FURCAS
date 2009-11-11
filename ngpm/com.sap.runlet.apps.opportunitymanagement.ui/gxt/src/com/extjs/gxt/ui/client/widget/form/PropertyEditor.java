/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

/**
 * Interface for obtaining a string representation of a typed value, and
 * converting a string to a typed value instance.
 * 
 * @param <Data> the data type
 */
public interface PropertyEditor<Data> {

  public static final PropertyEditor<Object> DEFAULT = new PropertyEditor<Object>() {

    public String getStringValue(Object value) {
      return value.toString();
    }

    public Object convertStringValue(String value) {
      return value;
    }

  };

  /**
   * Returns the data as a string.
   * 
   * @param value the typed value
   * @return the value as a string
   */
  public String getStringValue(Data value);

  /**
   * Converts a string to the typed value.
   * 
   * @param value the string value
   * @return the type value or null if value cannot be converted
   */
  public Data convertStringValue(String value);

}

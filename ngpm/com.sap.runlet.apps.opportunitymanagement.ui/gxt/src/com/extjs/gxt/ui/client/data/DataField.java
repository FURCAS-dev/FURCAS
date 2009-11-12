/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * Describes a field in a <code>Model</code>. Used when mapping raw data to a
 * model's properties.
 */
public class DataField {

  /**
   * Field type constant for dates.
   */
  public static final String DATE_TYPE = "date";

  private String format;
  private String map;
  private String name;
  private Class<?> type;

  /**
   * Creates a new field.
   * 
   * @param name the name
   */
  public DataField(String name) {
    this.name = name;
  }

  /**
   * Creates a new field instance.
   * 
   * @param name the field name
   * @param map the map name
   */
  public DataField(String name, String map) {
    this.name = name;
    this.map = map;
  }

  /**
   * Returns the format used when the type has been set to java.util.Date.
   * 
   * @return the format
   */
  public String getFormat() {
    return format;
  }

  /**
   * Returns the map.
   * 
   * @return the map
   */
  public String getMap() {
    return map;
  }

  /**
   * Returns the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the type.
   * 
   * @return the type
   */
  public Class<?> getType() {
    return type;
  }

  /**
   * Format is used when converting raw data to object instances. Format only
   * applies when #setType is used with java.util.Date. The value is a date time
   * format as defined by @link {@link DateTimeFormat}. If the raw data is a
   * timestamp, the format should be set to "timestamp".
   * 
   * @param format the format
   */
  public void setFormat(String format) {
    this.format = format;
  }

  /**
   * An optional field used when the property name of the model is different
   * than the property name of the raw data. When used with a
   * <code>XmlReader</code> the map value is treated as a xpath selector.
   * 
   * @param map the map
   */
  public void setMap(String map) {
    this.map = map;
  }

  /**
   * Sets the name of the field.
   * 
   * @param name the field
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The data type of the field used when converting the raw value.
   * 
   * <p />
   * Valid values:
   * <ul>
   * <li>Integer.class</li>
   * <li>Long.class</li>
   * <li>Float.class</li>
   * <li>Double.class</li>
   * <li>Date.class</li>
   * </ul>
   * 
   * @param type
   */
  public void setType(Class<?> type) {
    this.type = type;
  }

}

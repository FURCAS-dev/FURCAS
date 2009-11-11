/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * A <code>PropertyEditor</code> implementation for Dates. This implementation
 * delegates formatting and parsing the to the underlying @link
 * {@link DateTimeFormat}. @link {@link DateTimeFormat#getShortDateFormat()} is
 * the default format.
 * <p />
 * By default, strings are parsed with the @link
 * {@link DateTimeFormat#parse(String)}, to parse "strictly" use
 * {@link #setParseStrict(boolean)} to enable. When true, strings are parsed
 * with @link {@link DateTimeFormat#parseStrict(String)}.
 * 
 * @see DateTimeFormat
 */
public class DateTimePropertyEditor implements PropertyEditor<Date> {

  protected DateTimeFormat format = DateTimeFormat.getShortDateFormat();
  protected boolean parseStrict = true;

  /**
   * Creates a new date time property editor.
   */
  public DateTimePropertyEditor() {

  }

  /**
   * Creates a new date time property editor.
   * 
   * @param format the date time format
   */
  public DateTimePropertyEditor(DateTimeFormat format) {
    this.format = format;
  }

  /**
   * Creates a new date time property editor.
   * 
   * @param pattern the pattern used to create a new @link
   *          {@link DateTimeFormat}.
   */
  public DateTimePropertyEditor(String pattern) {
    this.format = DateTimeFormat.getFormat(pattern);
  }

  public Date convertStringValue(String value) {
    if (parseStrict) {
      return format.parseStrict(value);
    } else {
      return format.parse(value);
    }
  }

  /**
   * Returns the date time format.
   * 
   * @return the date time format
   */
  public DateTimeFormat getFormat() {
    return format;
  }

  public String getStringValue(Date value) {
    return format.format(value);
  }

  /**
   * Returns true if parsing stictly.
   * 
   * @return the parse strict state
   */
  public boolean isParseStrict() {
    return parseStrict;
  }

  /**
   * Sets the date time format.
   * 
   * @param format the format
   */
  public void setFormat(DateTimeFormat format) {
    this.format = format;
  }

  /**
   * True to parse dates strictly (defaults to true). See @link
   * {@link DateTimeFormat#parseStrict(String)}.
   * 
   * @param parseStrict true to parse strictly
   */
  public void setParseStrict(boolean parseStrict) {
    this.parseStrict = parseStrict;
  }

}

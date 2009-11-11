/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binding;

import java.util.Date;

import com.extjs.gxt.ui.client.widget.form.Time;
import com.extjs.gxt.ui.client.widget.form.TimeField;

/**
 * A specialized binding that automatically handles data conversion when dates
 * are bound to a time field.
 * 
 * @see TimeField
 */
public class TimeFieldBinding extends FieldBinding {

  protected TimeField timeField;

  /**
   * Creates a new time field binding instance.
   * 
   * @param field the time field
   * @param property the property name
   */
  public TimeFieldBinding(TimeField field, String property) {
    super(field, property);
    this.timeField = field;
  }

  @Override
  protected Object onConvertFieldValue(Object value) {
    if (value == null) {
      return null;
    }
    Time time = (Time) value;
    return time.getDate();
  }

  @Override
  protected Object onConvertModelValue(Object value) {
    if (value == null) {
      return null;
    }
    Date date = (Date) value;
    return timeField.findModel(date);
  }

}

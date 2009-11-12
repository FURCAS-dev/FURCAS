/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.Date;

import com.extjs.gxt.ui.client.widget.DatePicker;

/**
 * DatePicker event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see DatePicker
 */
public class DatePickerEvent extends ComponentEvent {

  private DatePicker datePicker;
  private Date date;

  public DatePickerEvent(DatePicker datePicker) {
    super(datePicker);
    this.datePicker = datePicker;
  }

  /**
   * Returns the source date picker.
   * 
   * @return the date picker
   */
  public DatePicker getDatePicker() {
    return datePicker;
  }

  /**
   * Returns the date.
   * 
   * @return the date
   */
  public Date getDate() {
    return date;
  }

  /**
   * Sets the date.
   * 
   * @param date the date
   */
  public void setDate(Date date) {
    this.date = date;
  }

}

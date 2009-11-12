/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import java.util.Date;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.DatePicker;

/**
 * A Menu for choosing a date.
 */
public class DateMenu extends Menu {

  /**
   * The internal date picker.
   */
  protected DatePicker picker;

  public DateMenu() {
    super();
    picker = new DatePicker();
    add(picker);
    addStyleName("x-date-menu");
    setAutoHeight(true);
    plain = true;
    showSeparator = false;
    setEnableScrolling(false);
  }

  /**
   * Returns the selected date.
   * 
   * @return the date
   */
  public Date getDate() {
    return picker.getValue();
  }

  /**
   * Returns the date picker.
   * 
   * @return the date picker
   */
  public DatePicker getDatePicker() {
    return picker;
  }

  protected void onClick(ComponentEvent ce) {
    hide(true);
  }

}

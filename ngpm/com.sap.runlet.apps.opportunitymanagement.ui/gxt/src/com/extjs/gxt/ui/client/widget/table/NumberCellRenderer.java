/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.table;

import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.i18n.client.NumberFormat;

/**
 * A <code>CellRenderer</code> implementation for numbers.
 * 
 * @see NumberFormat
 */
public class NumberCellRenderer<T extends Component> implements CellRenderer<T> {

  private NumberFormat format;

  /**
   * Creates a new number cell renderer.
   * 
   * @param pattern the pattern used by {@link NumberFormat}
   */
  public NumberCellRenderer(String pattern) {
    this.format = NumberFormat.getFormat(pattern);
  }

  /**
   * Creates a new number cell renderer.
   * 
   * @param format the number format
   */
  public NumberCellRenderer(NumberFormat format) {
    this.format = format;
  }

  public String render(T item, String property, Object value) {
    if (value instanceof Double) {
      return format.format(((Double) value).doubleValue());
    } else if (value instanceof Float) {
      return format.format(((Float) value).floatValue());
    } else if (value instanceof Long) {
      return format.format(((Long) value).longValue());
    } else if (value instanceof Integer) {
      return format.format(((Integer) value).intValue());
    }
    return null;
  }

}

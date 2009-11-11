/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.table;

import com.extjs.gxt.ui.client.widget.Component;

/**
 * Allows cell values to be modified before being displayed.
 */
public interface CellRenderer<T extends Component> {

  /**
   * Returns the formatted cell value.
   * 
   * @param item the source item
   * @param property the property being modified
   * @param value the property value
   * @return the new value as HTML
   */
  public String render(T item, String property, Object value);

}

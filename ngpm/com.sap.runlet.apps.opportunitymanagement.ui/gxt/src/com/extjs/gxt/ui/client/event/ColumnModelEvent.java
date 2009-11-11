/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.grid.ColumnModel;

/**
 * ColumnModel event.
 * 
 * @see ColumnModel
 */
public class ColumnModelEvent extends BaseEvent {

  /**
   * The column index.
   */
  private int colIndex;

  /**
   * The source column model.
   */
  private ColumnModel columnModel;

  /**
   * The column header.
   */
  private String header;

  /**
   * The column hidden state.
   */
  private boolean hidden;

  /**
   * The column width.
   */
  private int width;

  /**
   * Creates a new column model event.
   * 
   * @param cm the column model event
   */
  public ColumnModelEvent(ColumnModel cm) {
    super(cm);
    this.columnModel = cm;
  }

  /**
   * Creates a new column model event.
   * 
   * @param cm the source column model
   * @param colIndex the column index
   */
  public ColumnModelEvent(ColumnModel cm, int colIndex) {
    super(cm);
    this.colIndex = colIndex;
    this.columnModel = cm;
  }

  /**
   * Returns the column's index.
   * 
   * @return the column index
   */
  public int getColIndex() {
    return colIndex;
  }

  /**
   * Returns the source column model.
   * 
   * @return the column model
   */
  public ColumnModel getColumnModel() {
    return columnModel;
  }

  /**
   * Returns the column's header text.
   * 
   * @return the header text
   */
  public String getHeader() {
    return header;
  }

  /**
   * Returns the column width.
   * 
   * @return the column width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns true if the column is hidden.
   * 
   * @return true if hidden
   */
  public boolean isHidden() {
    return hidden;
  }

  /**
   * Sets the column's index.
   * 
   * @param colIndex the column index
   */
  public void setColIndex(int colIndex) {
    this.colIndex = colIndex;
  }

  /**
   * Sets the column header text.
   * 
   * @param header the header text
   */
  public void setHeader(String header) {
    this.header = header;
  }

  /**
   * Sets the column's hidden state.
   * 
   * @param hidden true if hidden
   */
  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  public void setWidth(int width) {
    this.width = width;
  }

}

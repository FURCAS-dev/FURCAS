/*
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.SortInfo;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.user.client.Event;

/**
 * Grid event type.
 * 
 * @see Grid
 */
public class GridEvent<M extends ModelData> extends BoxComponentEvent {

  /**
   * The column index.
   */
  private int colIndex = -1;

  /**
   * The source grid.
   */
  private Grid<M> grid;

  /**
   * The context menu.
   */
  private Menu menu;

  /**
   * The model.
   */
  private M model;

  /**
   * The property name.
   */
  private String property;

  /**
   * The record.
   */
  private Record record;

  /**
   * The row index.
   */
  private int rowIndex = -1;

  /**
   * The scroll left value.
   */
  private int scrollLeft;

  /**
   * The scroll top value.
   */
  private int scrollTop;

  /**
   * SortInfo value.
   */
  private SortInfo sortInfo;

  /**
   * The start value.
   */
  private Object startValue;

  /**
   * The value.
   */
  private Object value;

  /**
   * The width.
   */
  private int width;

  public GridEvent(Grid<M> grid) {
    super(grid);
    this.grid = grid;
  }

  public GridEvent(Grid<M> grid, Event event) {
    this(grid);
    this.event = event;
  }

  /**
   * Returns the column index.
   * 
   * @return the column index
   */
  public int getColIndex() {
    if (colIndex == -1) {
      colIndex = grid.getView().findCellIndex(getTarget(), null);
    }
    return colIndex;
  }

  /**
   * Returns the source grid.
   * 
   * @return the source grid
   */
  public Grid<M> getGrid() {
    return grid;
  }

  /**
   * Returns the menu.
   * 
   * @return the menu
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * Returns the model.
   * 
   * @return the model
   */
  public M getModel() {
    if (getRowIndex() != -1) {
      model = grid.getStore().getAt(rowIndex);
    }
    return model;
  }

  /**
   * Returns the property name.
   * 
   * @return the property name
   */
  public String getProperty() {
    return property;
  }

  /**
   * Returns the record.
   * 
   * @return the record
   */
  public Record getRecord() {
    return record;
  }

  /**
   * Returns the row index.
   * 
   * @return the row index
   */
  public int getRowIndex() {
    if (rowIndex == -1) {
      rowIndex = grid.getView().findRowIndex(getTarget());
    }
    return rowIndex;
  }

  /**
   * Returns the scroll left value.
   * 
   * @return the scroll left value
   */
  public int getScrollLeft() {
    return scrollLeft;
  }

  /**
   * Returns the scroll top value.
   * 
   * @return the scroll top value
   */
  public int getScrollTop() {
    return scrollTop;
  }

  /**
   * Returns the sort info.
   * 
   * @return the sort info
   */
  public SortInfo getSortInfo() {
    return sortInfo;
  }

  /**
   * Returns the start value.
   * 
   * @return the start value
   */
  public Object getStartValue() {
    return startValue;
  }

  /**
   * Returns the value.
   * 
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * Returns the width.
   * 
   * @return the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Sets the column index.
   * 
   * @param colIndex the column index
   */
  public void setColIndex(int colIndex) {
    this.colIndex = colIndex;
  }

  /**
   * Sets the source grid.
   * 
   * @param grid the source grid
   */
  public void setGrid(Grid<M> grid) {
    this.grid = grid;
  }

  /**
   * Sets the menu.
   * 
   * @param menu the menu
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  /**
   * Sets the model.
   * 
   * @param model the model
   */
  public void setModel(M model) {
    this.model = model;
  }

  /**
   * Sets the property name.
   * 
   * @param property the property name
   */
  public void setProperty(String property) {
    this.property = property;
  }

  /**
   * Sets the record.
   * 
   * @param record the record
   */
  public void setRecord(Record record) {
    this.record = record;
  }

  /**
   * Sets the row index.
   * 
   * @param rowIndex the row index
   */
  public void setRowIndex(int rowIndex) {
    this.rowIndex = rowIndex;
  }

  /**
   * Sets the scroll left value.
   * 
   * @param scrollLeft the scroll left value
   */
  public void setScrollLeft(int scrollLeft) {
    this.scrollLeft = scrollLeft;
  }

  /**
   * Sets the scroll top value.
   * 
   * @param scrollTop the scroll top value
   */
  public void setScrollTop(int scrollTop) {
    this.scrollTop = scrollTop;
  }

  /**
   * Sets the sort info.
   * 
   * @param sortInfo the sort info
   */
  public void setSortInfo(SortInfo sortInfo) {
    this.sortInfo = sortInfo;
  }

  /**
   * Sets the start value.
   * 
   * @param startValue the start value
   */
  public void setStartValue(Object startValue) {
    this.startValue = startValue;
  }

  /**
   * Sets the value.
   * 
   * @param value the value
   */
  public void setValue(Object value) {
    this.value = value;
  }

  /**
   * Sets the width.
   * 
   * @param width the width
   */
  public void setWidth(int width) {
    this.width = width;
  }

}

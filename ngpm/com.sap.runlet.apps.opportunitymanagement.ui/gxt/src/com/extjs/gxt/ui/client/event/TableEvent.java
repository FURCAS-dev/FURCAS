/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableItem;

/**
 * Table event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see Table
 * 
 * @deprecated see {@link Grid}
 */
public class TableEvent extends ContainerEvent<Table, TableItem> {

  /**
   * The cell index.
   */
  private int cellIndex = -1;

  /**
   * The column index.
   */
  private int columnIndex = -1;

  /**
   * The context menu.
   */
  private Menu menu;

  /**
   * The row index.
   */
  private int rowIndex = -1;

  /**
   * The sort direction.
   */
  private SortDir sortDir = SortDir.NONE;

  /**
   * The width.
   */
  private float width;

  /**
   * Creates a new table event.
   * 
   * @param table the event source
   */
  public TableEvent(Table table) {
    super(table);
  }

  public TableEvent(Table table, TableItem item) {
    super(table, item);
  }

  /**
   * Returns the cell index.
   * 
   * @return the cell index
   */
  public int getCellIndex() {
    return cellIndex;
  }

  /**
   * Returns the column index.
   * 
   * @return the column index
   */
  public int getColumnIndex() {
    return columnIndex;
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
   * Returns the row index.
   * 
   * @return the row index
   */
  public int getRowIndex() {
    return rowIndex;
  }

  /**
   * Returns the sort direction.
   * 
   * @return the sort direction
   */
  public SortDir getSortDir() {
    return sortDir;
  }

  /**
   * Returns the width.
   * 
   * @return the width.
   */
  public float getTableWidth() {
    return width;
  }

  /**
   * Sets the cell index.
   * 
   * @param cellIndex the cell index
   */
  public void setCellIndex(int cellIndex) {
    this.cellIndex = cellIndex;
  }

  /**
   * Sets the column index.
   * 
   * @param columnIndex the column index
   */
  public void setColumnIndex(int columnIndex) {
    this.columnIndex = columnIndex;
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
   * Sets the row index.
   * 
   * @param rowIndex the row index
   */
  public void setRowIndex(int rowIndex) {
    this.rowIndex = rowIndex;
  }

  /**
   * Sets the sort direction.
   * 
   * @param sortDir the sort direction.
   */
  public void setSortDir(SortDir sortDir) {
    this.sortDir = sortDir;
  }

  /**
   * Sets the width.
   * 
   * @param width the width
   */
  public void setTableWidth(float width) {
    this.width = width;
  }

}

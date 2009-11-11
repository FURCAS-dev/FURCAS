/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.grid.Grid;


/**
 * Event listener for table events.
 * 
 * @deprecated see {@link Grid}
 */
public class TableListener implements Listener<TableEvent> {

  public void handleEvent(TableEvent e) {
    EventType type = e.getType();
    if (type == Events.CellClick) {
      tableCellClick(e);
    } else if (type == Events.CellDoubleClick) {
      tableCellDoubleClick(e);
    } else if (type == Events.ColumnClick) {
      tableColumnClick(e);
    } else if (type == Events.RowClick) {
      tableRowClick(e);
    } else if (type == Events.RowDoubleClick) {
      tableRowDoubleClick(e);
    } else if (type == Events.SortChange) {
      tableSortChange(e);
    } 
  }

  /**
   * Fired after a cell is clicked
   * 
   * @param te the table event
   */
  public void tableCellClick(TableEvent te) {

  }

  /**
   * Fires after a cell is double clicked.
   * 
   * @param te the table event
   */
  public void tableCellDoubleClick(TableEvent te) {

  }

  /**
   * Fired after a column is clicked.
   * 
   * @param te the table event
   */
  public void tableColumnClick(TableEvent te) {

  }

  /**
   * Fired after a row is clicked
   * 
   * @param te the table event
   */
  public void tableRowClick(TableEvent te) {

  }

  /**
   * Fires after a row is double clicked.
   * 
   * @param te the table event
   */
  public void tableRowDoubleClick(TableEvent te) {

  }

  /**
   * Fires before the table is sorted.
   * 
   * @param te the table event
   */
  public void tableSortChange(TableEvent te) {

  }

}

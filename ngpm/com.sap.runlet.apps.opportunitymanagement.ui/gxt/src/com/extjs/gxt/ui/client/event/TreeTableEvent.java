/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treetable.TreeTable;

/**
 * TreeTable event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see TreeTable
 * 
 * @deprecated see {@link TreeGrid}
 */
public class TreeTableEvent extends TreeEvent {

  /**
   * The source tree table.
   */
  private TreeTable treeTable;

  /**
   * The column index.
   */
  private int columnIndex;

  /**
   * The cell index.
   */
  private int cellIndex;

  /**
   * The row index.
   */
  private int rowIndex;

  /**
   * The sort direction.
   */
  private SortDir sortDir = SortDir.NONE;

  public TreeTableEvent(TreeTable treeTable) {
    super(treeTable);
    this.treeTable = treeTable;
  }

  public TreeTableEvent(TreeTable treeTable, TreeItem item) {
    super(treeTable);
    this.treeTable = treeTable;
    if (item != null) this.setItem(item);
  }

  /**
   * Returns the source tree table.
   * 
   * @return the tree table
   */
  public TreeTable getTreeTable() {
    return treeTable;
  }

  /**
   * Sets the source tree table.
   * 
   * @param treeTable the source tree table
   */
  public void setTreeTable(TreeTable treeTable) {
    this.treeTable = treeTable;
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
   * Sets the column index.
   * 
   * @param columnIndex the column index
   */
  public void setColumnIndex(int columnIndex) {
    this.columnIndex = columnIndex;
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
   * Sets the cell index.
   * 
   * @param cellIndex the cell index
   */
  public void setCellIndex(int cellIndex) {
    this.cellIndex = cellIndex;
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
   * Sets the row index.
   * 
   * @param rowIndex the row index
   */
  public void setRowIndex(int rowIndex) {
    this.rowIndex = rowIndex;
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
   * Sets the sort direction.
   * 
   * @param sortDir the sort direction
   */
  public void setSortDir(SortDir sortDir) {
    this.sortDir = sortDir;
  }

}

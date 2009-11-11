/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.TableEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.grid.Grid;

/**
 * This is the default implementation of a ColumnModel used by the Table.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>Resize</b> : TableEvent(table, columnIndex, width)<br>
 * <div>Fires after a column is resized.</div>
 * <ul>
 * <li>table : table</li>
 * <li>columnIndex : columnIndex</li>
 * <li>tableWidth : the new column width</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HeaderChange</b> : TableEvent(table, columnIndex)<br>
 * <div>Fires when the text of a header changes.</div>
 * <ul>
 * <li>table : table</li>
 * <li>columnIndex : columnIndex</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>WidthChange</b> : TableEvent(table, columnIndex)<br>
 * <div>Fires when the width of a column changes.</div>
 * <ul>
 * <li>table : table</li>
 * <li>columnIndex : columnIndex</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 * 
 * @deprecated see {@link Grid}
 */
public class TableColumnModel extends BaseObservable {

  protected Component table;
  protected List<? extends TableColumn> columns;

  /**
   * Constructs a new instance.
   */
  public TableColumnModel(List<? extends TableColumn> columns) {
    assert columns != null;
    this.columns = columns;
    for (int i = 0; i < columns.size(); i++) {
      columns.get(i).index = i;
      columns.get(i).cm = this;
    }
  }

  /**
   * Constructs a new instance.
   */
  public TableColumnModel(TableColumn... columns) {
    this(columns == null ? null : Arrays.asList(columns));
  }

  /**
   * Returns the column at the given, zero-relative index or <code>null</code>
   * if the index is out of range.
   * 
   * @param index the index of the column to return
   * @return the column at the given index
   */
  public TableColumn getColumn(int index) {
    if ((index < 0) || (index >= getColumnCount())) return null;
    return columns.get(index);
  }

  /**
   * Returns the column with the given name.
   * 
   * @param name the column name
   * @return the column or <code>null</code> if no match
   */
  public TableColumn getColumn(String name) {
    for (int i = 0; i < columns.size(); i++) {
      TableColumn column = getColumn(i);
      if (column.getId().equals(name)) {
        return column;
      }
    }
    return null;
  }

  /**
   * Returns the number of columns contained in the table.
   * 
   * @return the number of columns
   */
  public int getColumnCount() {
    return columns.size();
  }

  /**
   * Returns the colum model's column.
   * 
   * @return the columns
   */
  public List<TableColumn> getColumns() {
    return new ArrayList<TableColumn>(columns);
  }

  public Component getTable() {
    return table;
  }

  /**
   * Returns the total column model width.
   * 
   * @return the width in pixels
   */
  public int getTotalWidth() {
    int total = 0;
    int cols = getColumnCount();
    for (int i = 0; i < cols; i++) {
      TableColumn col = getColumn(i);
      if (!col.isHidden()) {
        total += getWidthInPixels(col.index);
      }

    }
    return total;
  }

  /**
   * Returns the number of visible columns.
   * 
   * @return the visible column count
   */
  public int getVisibleColumnCount() {
    int count = 0;
    for (int i = 0; i < getColumnCount(); i++) {
      TableColumn column = getColumn(i);
      if (!column.isHidden()) {
        count++;
      }
    }
    return count;
  }

  /**
   * Returns the index of the column.
   * 
   * @param column the column
   * @return the column index
   */
  public int indexOf(TableColumn column) {
    return columns.indexOf(column);
  }

  /**
   * Sets the column's width.
   * 
   * @param index the column index
   * @param width the new width
   */
  public void setColumnWidth(int index, float width) {
    TableColumn col = getColumn(index);
    col.setWidth(width);
    TableEvent ce = new TableEvent((Table) table);
    ce.setColumnIndex(index);
    ce.setTableWidth(width);
    fireEvent(Events.Resize);
  }

  public void setTable(Component table) {
    this.table = table;
  }

  protected int getVariableColumnCount() {
    int count = 0;
    for (int i = 0; i < getColumnCount(); i++) {
      TableColumn col = getColumn(i);
      if (col.getWidth() <= 1) {
        count++;
      }
    }
    return count;
  }

  protected int getVariableWidth() {
    return (int) (.99 * (table.getOffsetWidth() - XDOM.getScrollBarWidth()) - getFixedWidth());
  }

  protected int getWidthInPixels(int index) {
    // TODO: need to stop calcs when column size has not changed
    TableColumn col = getColumn(index);
    float width = getColumn(index).getWidth();
    if (width <= 1) {
      if (getVariableColumnCount() == 1) {
        return getVariableWidth() - 25;
      }
      int w = (int) (getVariableWidth() * getColumn(index).getWidth());
      w = Math.max(col.getMinWidth(), w);
      w = Math.min(col.getMaxWidth(), w);
      return w;
    } else {
      return (int) getColumn(index).getWidth();
    }
  }

  protected void setWidthAsPercent(int index, float width) {
    TableColumn col = getColumn(index);
    col.setWidth(getAdjustedWidth(col, width));

    float o = 0;
    for (int i = 0; i < getColumnCount(); i++) {
      TableColumn tc = getColumn(i);
      if (tc != col && tc.getWidth() < 1.1) {
        o += tc.getWidth();
      }
    }

    float dif = 1 - col.getWidth() - o;

    int afterCols = 0;
    for (int i = (index + 1); i < getColumnCount(); i++) {
      TableColumn tc = getColumn(i);
      if (tc.getWidth() < 1.1) {
        afterCols++;
      }
    }

    float adj = dif / (afterCols);
    for (int i = (index + 1); i < getColumnCount(); i++) {
      TableColumn other = getColumn(i);
      if (other.getWidth() <= 1) {
        if (other != col) {
          other.setWidth(other.getWidth() + adj);
        }
      }
    }
  }

  int getFixedWidth() {
    int cols = getColumnCount();
    int total = 0;
    for (int i = 0; i < cols; i++) {
      TableColumn col = getColumn(i);
      if (col.isHidden()) {
        continue;
      }
      if (col.getWidth() > 1) {
        total += col.getWidth();
      }
    }
    return total;
  }

  private float getAdjustedWidth(TableColumn col, float width) {
    int totalWidth = getTotalWidth();
    int pixels = (int) (width * totalWidth);
    if (pixels < col.getMinWidth()) {
      width = (float) col.getMinWidth() / totalWidth;
    }
    if (pixels > col.getMaxWidth()) {
      width = (float) col.getMaxWidth() / totalWidth;
    }

    return width;
  }
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ColumnModelEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.util.Rectangle;

/**
 * This is the default implementation of a ColumnModel.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>WidthChange</b> : ColumnModelEvent(cm, colIndex)<br>
 * <div>Fires when the width of a column changes.</div>
 * <ul>
 * <li>cm : column model</li>
 * <li>colIndex : the column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HeaderChange</b> : ColumnModelEvent(cm, colIndex)<br>
 * <div>Fires when the text of a header changes.</div>
 * <ul>
 * <li>cm : column model</li>
 * <li>colIndex : the column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HiddenChange</b> : ColumnModelEvent(cm, colIndex)<br>
 * <div>Fires when a column is hidden or "unhidden".</div>
 * <ul>
 * <li>cm : column model</li>
 * <li>colIndex : the column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ColumnMove</b> : ColumnModelEvent(cm, colIndex)<br>
 * <div>Fires when a column is moved.</div>
 * <ul>
 * <li>cm : column model</li>
 * <li>colIndex : the column index</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 */
public class ColumnModel extends BaseObservable {

  protected List<ColumnConfig> configs;
  protected Grid<ModelData> grid;
  protected List<HeaderGroupConfig> groups = new ArrayList<HeaderGroupConfig>();
  protected List<AggregationRowConfig<?>> rows = new ArrayList<AggregationRowConfig<?>>();
  
  /**
   * Creates a new column model.
   * 
   * @param columns the columns
   */
  public ColumnModel(List<ColumnConfig> columns) {
    this.configs = columns;
  }
  
  /**
   * Adds an aggregation row config to the column model.
   * 
   * @param row the aggregation row
   */
  public void addAggregationRow(AggregationRowConfig<?> row) {
    rows.add(row);
  }
  
  /**
   * Returns the aggregation row.
   * 
   * @param rowIndex the row index
   * @return the aggregation row
   */
  public AggregationRowConfig<?> getAggregationRow(int rowIndex) {
    return rowIndex < rows.size() ? rows.get(rowIndex) : null;
  }
  
  /**
   * Adds a group to the column model.
   * 
   * @param row the row
   * @param column the column
   * @param config the header group config
   */
  public void addHeaderGroup(int row, int column, HeaderGroupConfig config) {
    config.setRow(row);
    config.setColumn(column);
    groups.add(config);
  }
  
  /**
   * Finds the index of the first matching column for the given dataIndex.
   * 
   * @param dataIndex the data index
   * @return the column index, or -1 if no match was found
   */
  public int findColumnIndex(String dataIndex) {
    for (int i = 0, len = configs.size(); i < len; i++) {
      if (configs.get(i).getDataIndex().equals(dataIndex)) {
        return i;
      }
    }
    return -1;
  }
  
  /**
   * Returns the aggregation rows.
   * 
   * @return the aggregation rows
   */
  public List<AggregationRowConfig<?>> getAggregationRows() {
    return rows;
  }
  
  /**
   * Returns the column at the given index.
   * 
   * @param colIndex the column index
   * @return the column or null
   */
  public ColumnConfig getColumn(int colIndex) {
    return colIndex < configs.size() ? configs.get(colIndex) : null;
  }
  
  /**
   * Returns the column's alignment.
   * 
   * @param colIndex the column index
   * @return the alignment
   */
  public HorizontalAlignment getColumnAlignment(int colIndex) {
    return configs.get(colIndex).getAlignment();
  }

  /**
   * Returns the column for a specified id.
   * 
   * @param id the column id
   * @return the column
   */
  public ColumnConfig getColumnById(String id) {
    for (ColumnConfig c : configs) {
      if (c.getId() != null && c.getId().equals(id)) {
        return c;
      }
    }
    return null;
  }

  /**
   * Returns the column count.
   * 
   * @return the column count
   */
  public int getColumnCount() {
    return getColumnCount(false);
  }

  /**
   * Returns the number of visible columns.
   * 
   * @return the visible column count
   */
  public int getColumnCount(boolean visibleOnly) {
    if (visibleOnly) {
      int count = 0;
      for (ColumnConfig c : configs) {
        if (!c.isHidden()) {
          count++;
        }
      }
      return count;
    }
    return configs.size();
  }

  /**
   * Returns the header for the specified column.
   * 
   * @param colIndex the column index
   * @return the header
   */
  public String getColumnHeader(int colIndex) {
    return configs.get(colIndex).getHeader();
  }

  /**
   * Returns the id of the column at the specified index.
   * 
   * @param colIndex the column index
   * @return the id
   */
  public String getColumnId(int colIndex) {
    return configs.get(colIndex).getId();
  }

  /**
   * Returns the column configs.
   * 
   * @return the column configs
   */
  public List<ColumnConfig> getColumns() {
    return configs;
  }

  /**
   * Returns the column's style.
   * 
   * @param colIndex the column index
   * @return the column style
   */
  public String getColumnStyle(int colIndex) {
    return configs.get(colIndex).getStyle();
  }

  /**
   * Returns the tooltip for the specified column.
   * 
   * @param colIndex the column index
   * @return the tooltip
   */
  public String getColumnToolTip(int colIndex) {
    return configs.get(colIndex).getToolTip();
  }

  /**
   * Returns the column width.
   * 
   * @param colIndex the column index
   * @return the width
   */
  public int getColumnWidth(int colIndex) {
    return configs.get(colIndex).getWidth();
  }

  /**
   * Returns the data index for the specified column.
   * 
   * @param colIndex the column index
   * @return the data index
   */
  public String getDataIndex(int colIndex) {
    return configs.get(colIndex).getDataIndex();
  }

  /**
   * Returns the column's editor.
   * 
   * @param colIndex the column index
   * @return the cell editor
   */
  public CellEditor getEditor(int colIndex) {
    return configs.get(colIndex).getEditor();
  }

  /**
   * Returns the header groups.
   * 
   * @return the header groups
   */
  public List<HeaderGroupConfig> getHeaderGroups() {
    return groups;
  }

  /**
   * Returns the index for a specified column id.
   * 
   * @param id the column id
   * @return the index, or -1 if not found
   */
  public int getIndexById(String id) {
    ColumnConfig c = getColumnById(id);
    if (c != null) {
      return configs.indexOf(c);
    }
    return -1;
  }

  /**
   * Returns the cell renderer.
   * 
   * @param colIndex the column index
   * @return the cell renderer
   */
  public GridCellRenderer<ModelData> getRenderer(int colIndex) {
    return configs.get(colIndex).getRenderer();
  }

  /**
   * Returns the total width of all columns.
   * 
   * @return the total width
   */
  public int getTotalWidth() {
    return getTotalWidth(false);
  }

  /**
   * Returns the total width of all columns.
   * 
   * @param includeHidden true to include hidden column widths
   * @return the total
   */
  public int getTotalWidth(boolean includeHidden) {
    int w = 0;
    for (ColumnConfig c : configs) {
      if (includeHidden || !c.isHidden()) {
        w += c.getWidth();
      }
    }
    return w;
  }

  /**
   * Returns the index of the column.
   * 
   * @param column the column
   * @return the column index
   */
  public int indexOf(ColumnConfig column) {
    return configs.indexOf(column);
  }

  /**
   * Returns true if the cell is editable.
   * 
   * @param colIndex the column index
   * @return true if editable
   */
  public boolean isCellEditable(int colIndex) {
    return configs.get(colIndex).getEditor() != null;
  }

  /**
   * Returns true if the column can be resized.
   * 
   * @param colIndex the column index
   * @return true if fixed
   */
  public boolean isFixed(int colIndex) {
    return configs.get(colIndex).isFixed();
  }

  /**
   * Returns true if the column is groupable. Applies when using a
   * {@link GroupingView}.
   * 
   * @param colIndex the column index
   * @return true if the column is groupable.
   */
  public boolean isGroupable(int colIndex) {
    return configs.get(colIndex).isGroupable();
  }

  /**
   * Returns true if the column is hidden.
   * 
   * @param colIndex the column index
   * @return true if hidden
   */
  public boolean isHidden(int colIndex) {
    return configs.get(colIndex).isHidden();
  }

  /**
   * Returns true if the specified column menu is disabled.
   * 
   * @param colIndex the column index
   * @return true if disabled
   */
  public boolean isMenuDisabled(int colIndex) {
    return configs.get(colIndex).isMenuDisabled();
  }

  /**
   * Returns true if the column can be resized.
   * 
   * @param colIndex the column index
   * @return true if resizable
   */
  public boolean isResizable(int colIndex) {
    return colIndex >= 0 && configs.get(colIndex).isResizable()
        && !configs.get(colIndex).isFixed();
  }

  /**
   * Returns true if the specified column is sortable.
   * 
   * @param colIndex the column index
   * @return true if the column is sortable
   */
  public boolean isSortable(int colIndex) {
    return configs.get(colIndex).isSortable();
  }

  /**
   * Sets the header for a column.
   * 
   * @param colIndex the column index
   * @param header the header
   */
  public void setColumnHeader(int colIndex, String header) {
    configs.get(colIndex).setHeader(header);
    ColumnModelEvent e = new ColumnModelEvent(this, colIndex);
    e.setHeader(header);
    fireEvent(Events.HeaderChange, e);
  }

  /**
   * Sets the column's width.
   * 
   * @param colIndex the column index
   * @param width the width
   */
  public void setColumnWidth(int colIndex, int width) {
    setColumnWidth(colIndex, width, false);
  }

  /**
   * Sets the column's width.
   * 
   * @param colIndex the column index
   * @param width the width
   * @param supressEvent true to suppress width change event
   */
  public void setColumnWidth(int colIndex, int width, boolean supressEvent) {
    configs.get(colIndex).setWidth(width);
    if (!supressEvent) {
      ColumnModelEvent e = new ColumnModelEvent(this, colIndex);
      e.setWidth(width);
      fireEvent(Events.WidthChange, e);
    }
  }

  /**
   * Sets the dataIndex for a column.
   * 
   * @param colIndex the column index
   * @param dataIndex the data index
   */
  public void setDataIndex(int colIndex, String dataIndex) {
    configs.get(colIndex).setDataIndex(dataIndex);
  }

  /**
   * Sets the editor for the column.
   * 
   * @param colIndex the column index
   * @param editor the editor
   */
  public void setEditor(int colIndex, CellEditor editor) {
    configs.get(colIndex).setEditor(editor);
  }

  /**
   * Sets if a column is hidden.
   * 
   * @param colIndex the column index
   * @param hidden true to hide the column
   */
  public void setHidden(int colIndex, boolean hidden) {
    ColumnConfig c = configs.get(colIndex);
    if (c.isHidden() != hidden) {
      c.setHidden(hidden);
      ColumnModelEvent e = new ColumnModelEvent(this, colIndex);
      e.setHidden(hidden);
      fireEvent(Events.HiddenChange, e);
    }
  }

  protected HeaderGroupConfig getGroup(int row, int column) {
    for (HeaderGroupConfig config : getHeaderGroups()) {
      Rectangle r = new Rectangle();
      r.x = config.getColumn();
      r.y = config.getRow();
      
      r.width = config.getColspan();
      r.height = config.getRowspan();
      
      if (r.contains(column, row)) {
        return config;
      }
    }
    return null;
  }

  protected boolean hasGroup(int row, int column) {
    return getGroup(row, column) != null;
  }

}

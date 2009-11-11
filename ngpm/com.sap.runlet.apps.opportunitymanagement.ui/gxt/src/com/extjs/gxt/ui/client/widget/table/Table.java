/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.table;

import java.util.List;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TableEvent;
import com.extjs.gxt.ui.client.event.TableListener;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.selection.Selectable;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * The table is used to display two-dimensional table of cells.
 * 
 * <p /> When using custom cell renderers or nested widgets within cells it may
 * be nesseccary to increase the cell selector depth to account for the new
 * nested elements within each cell. For example, if nesting a table structure
 * in a cell, the selector depth should be increased to at least a value of 10 (@see
 * {@link TableView#setCellSelectorDepth(int)}.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : TableEvent(table, item, rowIndex)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>table : this</li>
 * <li>item : the item being added</li>
 * <li>rowIndex : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : TableEvent(table, item, rowIndex)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>table : this</li>
 * <li>item : the item being removed</li>
 * <li>rowIndex : the index of the removed item</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : TableEvent(table, item, rowIndex)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>table : this</li>
 * <li>item : the item that was added</li>
 * <li>rowIndex : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : TableEvent(table, item, rowIndex)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>table : this</li>
 * <li>item : the item that was removed</li>
 * <li>rowIndex : the index of the item that was removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>SelectionChange</b> : TableEvent(table this)<br>
 * <div>Fired after the selection has changed</div>
 * <ul>
 * <li>table : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ContextMenu</b> : TableEvent(table)<br>
 * <div>Fires before the tables context menu is shown. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>table : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CellClick</b> : TableEvent(table, rowIndex, cellIndex, event)<br>
 * <div>Fires after a cell is clicked.</div>
 * <ul>
 * <li>table : this</li>
 * <li>rowIndex : row index</li>
 * <li>cellIndex : cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CellDoubleClick</b> : TableEvent(table, rowIndex, cellIndex, event)<br>
 * <div>Fires after a cell is double clicked.</div>
 * <ul>
 * <li>table : this</li>
 * <li>rowIndex : row index</li>
 * <li>cellIndex : cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ColumnClick</b> : TableEvent(table, columnIndex)<br>
 * <div>Fires after a column is clicked.</div>
 * <ul>
 * <li>table : this</li>
 * <li>columnIndex : the column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>RowClick</b> : TableEvent(table, rowIndex, cell index, event)<br>
 * <div>Fires after a row is clicked.</div>
 * <ul>
 * <li>table : this</li>
 * <li>rowIndex : the row index</li>
 * <li>index : the cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>RowDoubleClick</b> : TableEvent(table, rowIndex, cellIndex, event)<br>
 * <div>Fires after a row is double clicked.</div>
 * <ul>
 * <li>table : this</li>
 * <li>rowIndex : the row index</li>
 * <li>index : the cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>SortChange</b> : TableEvent(table, colIndex, sortDir)<br>
 * <div>Fires before the table is sorted. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>table : this</li>
 * <li>colIndex : the column index</li>
 * <li>sortDir : the sort direction</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeSelect</b> : TableEvent(table, item)<br>
 * <div>Fires before a item is selected. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>table : this</li>
 * <li>item : the selected item</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>SelectionChange</b> : TableEvent(table, selected)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>table : this</li>
 * <li>selected : the selected items</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>KeyPress</b> : TableEvent(table)<br>
 * <div>Fires before the table is sorted. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>table : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HeaderContextMenu</b> : TableEvent(table, colIndex, menu)<br>
 * <div>Fires right before the header's context menu is displayed.</div>
 * <ul>
 * <li>table : this</li>
 * <li>colIndex : the column index</li>
 * <li>menu : the context menu</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 * 
 * <dl>
 * <dt><b>CSS:</b></dt>
 * <dd>.my-tbl-col-[column id] { each column }</dd>
 * <dd>.my-tbl-td-[column index] { cell td }</dd>
 * </dd>
 * <dd>.my-tbl-td-inner-[column index] { cell inner element }</dd>
 * <dd>.my-tbl-td-cell-[column index] { cell text element }</dd>
 * </dl>
 * 
 * @see TableColumn
 * @see TableColumnModel
 * 
 * @deprecated see {@link Grid}
 */
public class Table extends Container<TableItem> implements BaseTable, Selectable<TableItem> {

  /**
   * The table's column model.
   */
  protected TableColumnModel cm;

  /**
   * The selection model.
   */
  protected TableSelectionModel sm;

  /**
   * The table header.
   */
  protected TableHeader header;

  protected boolean bulkRender = true;

  private boolean highlight = true;
  private boolean columnContextMenu = true;
  private boolean verticalLines;
  private boolean horizontalScroll = true;
  private TableView view;
  private Size lastSize;
  private int lastLeft;
  private boolean stripeRows;

  private DelayedTask scrollTask = new DelayedTask(new Listener<ComponentEvent>() {
    public void handleEvent(ComponentEvent ce) {
      header.updateSplitBars();
    }
  });

  private DelayedTask recaluateTask = new DelayedTask(new Listener<ComponentEvent>() {
    public void handleEvent(ComponentEvent ce) {
      recalculate();
    }
  });

  /**
   * Creates a new single select table. A column model must be set before the
   * table is rendered.
   */
  public Table() {
    focusable = true;
    baseStyle = "my-tbl";
    attachChildren = false;
    setSelectionModel(new TableSelectionModel());
  }

  /**
   * Creates a new table.
   * 
   * @param cm the column model
   */
  public Table(TableColumnModel cm) {
    this();
    this.cm = cm;
    cm.table = this;
  }

  @Override
  public boolean add(TableItem item) {
    return super.add(item);
  }

  /**
   * Adds a table listener.
   * 
   * @param listener thet able listener
   */
  public void addTableListener(TableListener listener) {
    addListener(Events.ColumnClick, listener);
    addListener(Events.SortChange, listener);
    addListener(Events.CellClick, listener);
    addListener(Events.CellDoubleClick, listener);
    addListener(Events.RowClick, listener);
    addListener(Events.RowDoubleClick, listener);
  }

  @Override
  public TableItem findItem(Element elem) {
    if (rendered && view != null) {
      int idx = view.findRowIndex(elem);
      TableItem item = idx != -1 ? getItem(idx) : super.findItem(elem);
      return item;
    }
    return super.findItem(elem);
  }

  /**
   * Returns true if bulk rendering is enabled.
   * 
   * @return the bulk rendering state
   */
  public boolean getBulkRender() {
    return bulkRender;
  }

  /**
   * Returns the column at the specified index.
   * 
   * @param index the column index
   * @return the column
   */
  public TableColumn getColumn(int index) {
    return cm.getColumn(index);
  }

  /**
   * Returns the column with the given id.
   * 
   * @param id the column id
   * @return the column
   */
  public TableColumn getColumn(String id) {
    return cm.getColumn(id);
  }

  /**
   * Returns the column context menu enabed state.
   * 
   * @return <code>true</code> if enabled, <code>false</code> otherwise.
   */
  public boolean getColumnContextMenu() {
    return columnContextMenu;
  }

  /**
   * Returns the number of columns contained in the table.
   * 
   * @return the number of columns
   */
  public int getColumnCount() {
    return cm.getColumnCount();
  }

  /**
   * Returns the table's column model.
   * 
   * @return the column model
   */
  public TableColumnModel getColumnModel() {
    return cm;
  }

  public Menu getContextMenu() {
    return super.getContextMenu();
  }

  /**
   * Returns true if highlights are enabled.
   * 
   * @return true if mouse overs are enable
   */
  public boolean getHighlight() {
    return highlight;
  }

  /**
   * Returns true if horizontal scrolling is enabled
   * 
   * @return the horizontal scroll state
   */
  public boolean getHorizontalScroll() {
    return horizontalScroll;
  }

  public TableItem getSelectedItem() {
    return (TableItem) sm.getSelectedItem();
  }

  public List<TableItem> getSelectedItems() {
    return sm.getSelectedItems();
  }

  public SelectionMode getSelectionMode() {
    return sm.getSelectionMode();
  }

  /**
   * Returns the table's selection model.
   * 
   * @return the selection model
   */
  public TableSelectionModel getSelectionModel() {
    return sm;
  }

  /**
   * Returns the table's header.
   * 
   * @return the table header
   */
  public TableHeader getTableHeader() {
    if (header == null) {
      header = new TableHeader(this);
    }
    return header;
  }

  /**
   * Returns true if vertical lines are enabled.
   * 
   * @return the vertical lines state
   */
  public boolean getVerticalLines() {
    return verticalLines;
  }

  /**
   * Returns the table's view.
   * 
   * @return the view
   */
  public TableView getView() {
    if (view == null) {
      view = new TableView();
    }
    return view;
  }

  @Override
  public boolean insert(TableItem item, int index) {
    boolean added = super.insert(item, index);
    if (added) {
      if (rendered) {
        view.renderItem(item, index);
      }
      if (rendered) {
        recaluateTask.delay(100);
      }
    }
    return added;
  }

  /**
   * Returns true if row striping is enabled.
   * 
   * @return the strip row state
   */
  public boolean isStripeRows() {
    return stripeRows;
  }

  @Override
  public void onAttach() {
    super.onAttach();
    header.resizeColumns(false, true);
  }

  public void onBrowserEvent(Event event) {
    super.onBrowserEvent(event);
    int type = DOM.eventGetType(event);

    if (type == Event.ONSCROLL) {
      int left = view.getScrollEl().getScrollLeft();
      if (left == lastLeft) {
        return;
      }
      lastLeft = left;
      header.el().setLeft(-left);
      scrollTask.delay(400);
    }
  }

  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    TableItem item = findItem(ce.getTarget());
    if (item != null) {
      item.onComponentEvent(ce);
    }
  }

  public void onSelectChange(TableItem item, boolean select) {
    getView().onSelectItem(item, select);
  }

  @Override
  public void recalculate() {
    if (rendered) {
      header.resizeColumns(false, true);
    }
  }

  @Override
  public boolean remove(TableItem item) {
    return super.remove(item);
  }

  /**
   * Remvoves a table listener.
   * 
   * @param listener the table listener
   */
  public void removeTableLisetener(TableListener listener) {
    removeListener(Events.ColumnClick, listener);
    removeListener(Events.SortChange, listener);
    removeListener(Events.CellClick, listener);
    removeListener(Events.CellDoubleClick, listener);
    removeListener(Events.RowClick, listener);
    removeListener(Events.RowDoubleClick, listener);
  }

  @Override
  public void scrollIntoView(TableItem item) {
    item.el().scrollIntoView(view.getScrollEl().dom, false);
  }

  /**
   * True to bulk render the table when first rendered (defaults to true). When
   * true, widget are not supported in table cells.
   * 
   * @param bulkRender true for bulk rendering
   */
  public void setBulkRender(boolean bulkRender) {
    this.bulkRender = bulkRender;
  }

  /**
   * Sets whether the table header context menu is displayed (defaults to true).
   * 
   * @param columnContextMenu the column context menu sate
   */
  public void setColumnContextMenu(boolean columnContextMenu) {
    this.columnContextMenu = columnContextMenu;
  }

  /**
   * Sets the table's column model.
   * 
   * @param cm the column model
   */
  public void setColumnModel(TableColumnModel cm) {
    this.cm = cm;
    cm.table = this;
  }

  @Override
  public void setContextMenu(Menu menu) {
    super.setContextMenu(menu);
  }

  /**
   * True to highlight the current row (defaults to true).
   * 
   * @param highlight the highlight state
   */
  public void setHighlight(boolean highlight) {
    this.highlight = highlight;
  }

  /**
   * True to display a horizonatal scroll bar when needed (defaults to true).
   * 
   * @param horizontalScroll the horizontal scroll state
   */
  public void setHorizontalScroll(boolean horizontalScroll) {
    this.horizontalScroll = horizontalScroll;
  }

  public void setSelectedItem(TableItem item) {
    sm.select(item, false);
  }

  public void setSelectedItems(List<TableItem> items) {
    sm.select(items, false);
  }

  /**
   * Sets the table's selection mode.
   * 
   * @param mode the selection mode
   */
  public void setSelectionMode(SelectionMode mode) {
    setSelectionModel(new TableSelectionModel(mode));
  }

  /**
   * Sets the table's selection model.
   * 
   * @param sm the selection model
   */
  public void setSelectionModel(TableSelectionModel sm) {
    assert sm != null;
    if (this.sm != null) {
      this.sm.bind(null);
    }
    this.sm = sm;
    sm.bind(this);
  }

  /**
   * True to stripe the rows (defaults to false).
   * 
   * @param stripeRows true to strip rows
   */
  public void setStripeRows(boolean stripeRows) {
    this.stripeRows = stripeRows;
  }

  /**
   * Sets the table's header. Should only be called when providing a custom
   * table header. Has no effect if called after the table has been rendered.
   * 
   * @param header the table header
   */
  public void setTableHeader(TableHeader header) {
    if (!isRendered()) {
      header.table = this;
      this.header = header;
    }
  }

  /**
   * True to display vertical borders on the table data (defaults to false).
   * 
   * @param verticalLines true for vertical lines
   */
  public void setVerticalLines(boolean verticalLines) {
    this.verticalLines = verticalLines;
  }

  /**
   * Sets the table's view. Provides a way to provide specialized views. table
   * views.
   * 
   * @param view the view
   */
  public void setView(TableView view) {
    this.view = view;
  }

  /**
   * Sorts the table using the specified column index.
   * 
   * @param index the column index
   * @param sortDir the direction to sort (NONE, ASC, DESC)
   */
  public void sort(int index, SortDir sortDir) {
    if (rendered) {
      TableEvent te = new TableEvent(this);
      te.setColumnIndex(index);
      te.setSortDir(sortDir);
      if (fireEvent(Events.SortChange, te)) {
        getTableHeader().sort(index, sortDir);
        getView().sort(index, sortDir);
      }
    } else {
      TableColumn col = getColumn(index);
      col.sortDir = sortDir;
    }
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    TableEvent te = new TableEvent(this);
    te.setEvent(event);
    if (view != null && event != null) {
      Element target = event.getEventTarget().cast();
      int idx = view.findRowIndex(target);
      if (idx != -1) {
        te.setItem(idx != -1 ? getItem(idx) : null);
        te.setCellIndex(view.findCellIndex(target));
      }
    }
    return te;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected ContainerEvent createContainerEvent(TableItem item) {
    return new TableEvent(this, item);
  }

  protected void doAttachChildren() {
    if (header != null) ComponentHelper.doAttach(header);
    if (!bulkRender) {
      int count = getItemCount();
      for (int i = 0; i < count; i++) {
        TableItem item = getItem(i);
        if (item.hasWidgets) {
          int ct = item.getValues().length;
          for (int j = 0; j < ct; j++) {
            Object obj = item.getValue(j);
            if (obj != null && obj instanceof Widget) {
              ComponentHelper.doAttach((Widget) item.getValue(j));
            }
          }
        }
      }
    }
  }

  protected void doDetachChildren() {
    if (header != null) ComponentHelper.doDetach(header);
    if (!getBulkRender()) {
      int count = getItemCount();
      for (int i = 0; i < count; i++) {
        TableItem item = getItem(i);
        if (item.hasWidgets) {
          int ct = item.getValues().length;
          for (int j = 0; j < ct; j++) {
            Object obj = item.getValue(j);
            if (obj != null && obj instanceof Widget) {
              ComponentHelper.doDetach((Widget) item.getValue(j));
            }
          }
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  protected String getRenderedValue(TableItem item, int column, Object value) {
    TableColumn col = cm.getColumn(column);
    CellRenderer r = col.getRenderer();
    if (r != null) {
      return r.render(item, col.getId(), value);
    } else {
      if (value != null) {
        return value.toString();
      }
      return "&nbsp;";
    }
  }

  protected void onKeyPress(TableEvent te) {
    TableEvent e = new TableEvent(this);
    e.setEvent(te.getEvent());
    e.setItem(te.getItem());
    fireEvent(Events.KeyPress, e);
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);

    new KeyNav<ComponentEvent>(this) {
      @Override
      public void onKeyPress(ComponentEvent ce) {
        Table.this.onKeyPress((TableEvent) ce);
      }
    };

    header = getTableHeader();
    header.render(el().dom);
    header.init(this);

    for (TableColumn col : getColumnModel().getColumns()) {
      if (col.sortDir != SortDir.NONE) {
        header.onSortChange(col, col.sortDir);
      }
    }

    view = getView();
    view.init(this);
    view.render();
    view.renderItems();
  }

  protected void onResize(int width, int height) {
    int h = width;
    int w = height;
    if (lastSize != null) {
      if (lastSize.width == w && lastSize.height == h) {
        return;
      }
    }
    lastSize = new Size(w, h);
    header.resizeColumns(false, true);
  }

  @Override
  protected void onShowContextMenu(int x, int y) {
    super.onShowContextMenu(x, y);
    getView().clearHoverStyles();
  }

  @Override
  protected ComponentEvent previewEvent(EventType type, ComponentEvent ce) {
    if (type == Events.Remove || type == Events.Add) {
      TableEvent te = (TableEvent) ce;
      te.setRowIndex(te.getIndex());
    }
    return super.previewEvent(type, ce);
  }

}

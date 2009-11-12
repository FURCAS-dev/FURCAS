/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelStringProvider;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel.Callback;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * This class represents the primary interface of a component based grid
 * control.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>CellClick</b> : GridEvent(grid, rowIndex, cellIndex, event)<br>
 * <div>Fires after a cell is clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : row index</li>
 * <li>cellIndex : cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CellDoubleClick</b> : GridEvent(grid, rowIndex, cellIndex, event)<br>
 * <div>Fires after a cell is double clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : row index</li>
 * <li>cellIndex : cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CellMouseDown</b> : GridEvent(grid, rowIndex, cellIndex, event)<br>
 * <div>Fires before a cell is clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : row index</li>
 * <li>cellIndex : cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>RowClick</b> : GridEvent(grid, rowIndex, cellIndex, event)<br>
 * <div>Fires after a row is clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : the row index</li>
 * <li>cellIndex : cell index</li>
 * <li>index : the cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>RowDoubleClick</b> : GridEvent(grid, rowIndex, cellIndex, event)<br>
 * <div>Fires after a row is double clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : the row index</li>
 * <li>index : the cell index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>RowMouseDown</b> : GridEvent(grid, rowIndex, colIndex, event)<br>
 * <div>Fires before a row is clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : row index</li>
 * <li>colIndex : column index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HeaderClick</b> : GridEvent(grid, rowIndex, colIndex, event)<br>
 * <div>Fires a header is clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : row index</li>
 * <li>colIndex : column index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HeaderDoubleClick</b> : GridEvent(grid, rowIndex, colIndex, event)<br>
 * <div>Fires a header is double clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : row index</li>
 * <li>colIndex : column index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HeaderMouseDown</b> : GridEvent(grid, rowIndex, colIndex, event)<br>
 * <div>Fires before a header is clicked.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>rowIndex : row index</li>
 * <li>colIndex : column index</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ContextMenu</b> : GridEvent(grid)<br>
 * <div>Fires before the grid's context menu is shown. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>grid : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>HeaderContextMenu</b> : TableEvent(grid, colIndex, menu)<br>
 * <div>Fires right before the header's context menu is displayed.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>colIndex : the column index</li>
 * <li>menu : the context menu</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BodyScroll</b> : GridEvent(grid, srollLeft, scrollTop)<br>
 * <div>Fires when the body element is scrolled.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>scrollLeft : scrollLeft</li>
 * <li>scrollTop : scrollTop</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ColumnResize</b> : GridEvent(grid, colIndex, width)<br>
 * <div>Fires when the user resizes a column.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>colIndex : the column index</li>
 * <li>width : the new column width</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ColumnMove</b> : GridEvent(grid, colIndex, size)<br>
 * <div>Fires when the user moves a column.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>oldIndex : the old column index</li>
 * <li>newIndex : the new column index</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>SortChange</b> : GridEvent(grid, sortInfo)<br>
 * <div>Fires when the grid's store sort changes.</div>
 * <ul>
 * <li>grid : this</li>
 * <li>sortInfo : the sort field and direction</li>
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
 * @param <M> the model type
 */
public class Grid<M extends ModelData> extends BoxComponent {

  protected ColumnModel cm;
  protected GridSelectionModel<M> sm;
  protected ListStore<M> store;
  protected GridView view;
  protected boolean viewReady;
  protected ModelStringProvider<M> stringProvider;

  // config
  private int minColumnWidth = 25;
  private boolean trackMouseOver = true;
  private boolean stripeRows;
  private String autoExpandColumn;
  private int autoExpandMax = 500;
  private int autoExpandMin = 25;
  private boolean enableColumnResize = true;
  private boolean hideHeaders;
  private boolean loadMask;

  protected Grid() {

  }

  /**
   * Creates a new grid.
   * 
   * @param store the data store
   * @param cm the column model
   */
  public Grid(ListStore<M> store, ColumnModel cm) {
    this.store = store;
    this.cm = cm;
    this.view = new GridView();
    focusable = true;
    baseStyle = "x-grid-panel";
    setSelectionModel(new GridSelectionModel<M>());
  }

  /**
   * Returns the auto expand column id.
   * 
   * @return the auto expand column id
   */
  public String getAutoExpandColumn() {
    return autoExpandColumn;
  }

  /**
   * Returns the auto expand maximum width.
   * 
   * @return the max width in pixels
   */
  public int getAutoExpandMax() {
    return autoExpandMax;
  }

  /**
   * Returns the auto expand miniumum width.
   * 
   * @return the minimum width in pixels
   */
  public int getAutoExpandMin() {
    return autoExpandMin;
  }

  /**
   * Returns the column model.
   * 
   * @return the colum model
   */
  public ColumnModel getColumnModel() {
    return cm;
  }

  /**
   * Returns the minimum column width.
   * 
   * @return the min width in pixels
   */
  public int getMinColumnWidth() {
    return minColumnWidth;
  }

  /**
   * Returns the grid's selection model.
   * 
   * @return the selection model
   */
  public GridSelectionModel<M> getSelectionModel() {
    return sm;
  }

  /**
   * Returns the grid's store.
   * 
   * @return the store
   */
  public ListStore<M> getStore() {
    return store;
  }

  /**
   * Returns the grid's view.
   * 
   * @return the grid view
   */
  public GridView getView() {
    return view;
  }

  /**
   * Returns true if column resizing is enabled.
   * 
   * @return true if resizing is enabled
   */
  public boolean isEnableColumnResize() {
    return enableColumnResize;
  }

  /**
   * Returns true if the header is hidden.
   * 
   * @return true for hidden
   */
  public boolean isHideHeaders() {
    return hideHeaders;
  }

  /**
   * Returns true if the load mask in enabled.
   * 
   * @return the load mask state
   */
  public boolean isLoadMask() {
    return loadMask;
  }

  /**
   * Returns true if row striping is enabled.
   * 
   * @return the strip row state
   */
  public boolean isStripeRows() {
    return stripeRows;
  }

  /**
   * Returns true if rows are highlighted on mouse over.
   * 
   * @return the track mouse state
   */
  public boolean isTrackMouseOver() {
    return trackMouseOver;
  }

  /**
   * Returns true if the view is ready.
   * 
   * @return the view ready state
   */
  public boolean isViewReady() {
    return viewReady;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    GridEvent ge = (GridEvent) ce;
    switch (ce.getEventTypeInt()) {
      case Event.ONCLICK:
        onClick(ge);
        break;
      case Event.ONDBLCLICK:
        onDoubleClick(ge);
        break;
      case Event.ONMOUSEDOWN:
        onMouseDown(ge);
        break;
    }
    view.handleComponentEvent(ge);
  }

  /**
   * Reconfigures the grid to use a different Store and Column Model. The View
   * will be bound to the new objects and refreshed.
   * 
   * @param store the new store
   * @param cm the new column model
   */
  public void reconfigure(ListStore<M> store, ColumnModel cm) {
    if (loadMask && rendered) {
      mask(GXT.MESSAGES.loadMask_msg());
    }
    view.initData(store, cm);
    this.store = store;
    this.cm = cm;
    // rebind the sm
    setSelectionModel(sm);
    if (rendered) {
      view.refresh(true);
    }
  }

  /**
   * The id of a column in this grid that should expand to fill unused space
   * (pre-render). This id can not be 0.
   * 
   * @param autoExpandColumn the auto expand column id
   */
  public void setAutoExpandColumn(String autoExpandColumn) {
    this.autoExpandColumn = autoExpandColumn;
  }

  /**
   * The maximum width the autoExpandColumn can have (if enabled) (defaults to
   * 1000, pre-render).
   * 
   * @param autoExpandMax the auto expand max
   */
  public void setAutoExpandMax(int autoExpandMax) {
    this.autoExpandMax = autoExpandMax;
  }

  /**
   * The minimum width the autoExpandColumn can have (if enabled)(pre-render).
   * 
   * @param autoExpandMin the auto expand min width
   */
  public void setAutoExpandMin(int autoExpandMin) {
    this.autoExpandMin = autoExpandMin;
  }

  @Override
  public void setContextMenu(Menu menu) {
    // make public
    super.setContextMenu(menu);
  }

  /**
   * Sets whether columns may be resized (defaults to true).
   * 
   * @param enableColumnResize true to allow column resizing
   */
  public void setEnableColumnResize(boolean enableColumnResize) {
    this.enableColumnResize = enableColumnResize;
  }

  /**
   * Sets whether the header should be hidden (defaults to false).
   * 
   * @param hideHeaders true to hide the header
   */
  public void setHideHeaders(boolean hideHeaders) {
    this.hideHeaders = hideHeaders;
  }

  /**
   * Sets whether a load mask should be displayed during load operations
   * (defaults to false).
   * 
   * @param loadMask true to show a mask
   */
  public void setLoadMask(boolean loadMask) {
    this.loadMask = loadMask;
  }

  /**
   * The minimum width a column can be resized to (defaults to 25).
   * 
   * @param minColumnWidth the min column width
   */
  public void setMinColumnWidth(int minColumnWidth) {
    this.minColumnWidth = minColumnWidth;
  }

  /**
   * Sets the grid selection model.
   * 
   * @param sm the selection model
   */
  public void setSelectionModel(GridSelectionModel<M> sm) {
    if (this.sm != null) {
      this.sm.bindGrid(null);
    }
    this.sm = sm;
    if (sm != null) {
      sm.bindGrid(this);
    }
  }

  /**
   * Sets the binder's string provider.
   * 
   * @param stringProvider the string provider
   */
  public void setStringProvider(ModelStringProvider<M> stringProvider) {
    this.stringProvider = stringProvider;
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
   * True to highlight rows when the mouse is over (defaults to true).
   * 
   * @param trackMouseOver true to highlight rows on mouse over
   */
  public void setTrackMouseOver(boolean trackMouseOver) {
    this.trackMouseOver = trackMouseOver;
  }

  /**
   * Sets the view's grid (pre-render).
   * 
   * @param view the view
   */
  public void setView(GridView view) {
    this.view = view;
    // rebind the sm
    setSelectionModel(sm);
  }

  protected void afterRender() {
    super.afterRender();
    view.init(this);
    view.render();
    view.afterRender();
    viewReady = true;
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new GridEvent<M>(this, event);
  }
  


  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    view.doAttach();
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    view.doDetach();
  }

  protected void onClick(GridEvent<M> e) {
    if (e.getRowIndex() != -1) {
      fireEvent(Events.RowClick, e);
      if (e.getColIndex() != -1) {
        fireEvent(Events.CellClick, e);
      }
    }
  }

  protected void onDoubleClick(GridEvent<M> e) {
    if (e.getRowIndex() != -1) {
      fireEvent(Events.RowDoubleClick, e);
      if (e.getColIndex() != -1) {
        fireEvent(Events.CellDoubleClick, e);
      }
    }
  }

  protected void onMouseDown(GridEvent<M> e) {
    int row = e.getRowIndex();
    int cell = e.getColIndex();
    if (row != -1) {
      e.setRowIndex(row);
      e.setColIndex(cell);
      fireEvent(Events.RowMouseDown, e);
      if (cell != -1) {
        fireEvent(Events.CellMouseDown, e);
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    super.onRender(target, index);
    el().setStyleAttribute("position", "relative");
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    if (viewReady) {
      view.calculateVBar(true);
    }
  }

  @SuppressWarnings("unchecked")
  protected Cell walkCells(int row, int col, int step, Callback callback,
      boolean acceptNavs) {
    boolean first = true;
    int clen = cm.getColumnCount();
    int rlen = store.getCount();
    if (step < 0) {
      if (col < 0) {
        row--;
        first = false;
      }
      while (row >= 0) {
        if (!first) {
          col = clen - 1;
        }
        first = false;
        while (col >= 0) {
          if (callback.isSelectable(row, col, acceptNavs)) {
            return new Cell(row, col);
          }
          col--;
        }
        row--;
      }
    } else {
      if (col >= clen) {
        row++;
        first = false;
      }
      while (row < rlen) {
        if (!first) {
          col = 0;
        }
        first = false;
        while (col < clen) {
          if (callback.isSelectable(row, col, acceptNavs)) {
            return new Cell(row, col);
          }
          col++;
        }
        row++;
      }
    }
    return null;
  }

}

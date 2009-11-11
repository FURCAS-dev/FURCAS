/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.Arrays;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.DomEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.widget.selection.AbstractStoreSelectionModel;
import com.google.gwt.event.dom.client.KeyCodes;

/**
 * Grid selection model.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>AbstractStoreSelectionModel BeforeSelect</dd>
 * <dd>AbstractStoreSelectionModel SelectionChange</dd>
 * </dl>
 */
public class GridSelectionModel<M extends ModelData> extends
    AbstractStoreSelectionModel<M> implements Listener<BaseEvent> {

  @SuppressWarnings("unchecked")
  class Callback {

    private GridSelectionModel sm;

    public Callback(GridSelectionModel sm) {
      this.sm = sm;
    }

    public boolean isSelectable(int row, int cell, boolean acceptsNav) {
      return sm.isSelectable(row, cell, acceptsNav);
    }
  }

  protected Grid<M> grid;
  protected ListStore<M> listStore;
  protected KeyNav<GridEvent<M>> keyNav = new KeyNav<GridEvent<M>>() {

    @Override
    public void onDown(GridEvent<M> e) {
      onKeyDown(e);
    }

    @Override
    public void onKeyPress(GridEvent<M> ce) {
      GridSelectionModel.this.onKeyPress(ce);
    }

    @Override
    public void onLeft(GridEvent<M> ce) {
      onKeyLeft(ce);
    }

    @Override
    public void onRight(GridEvent<M> ce) {
      onKeyRight(ce);
    }

    @Override
    public void onUp(GridEvent<M> e) {
      onKeyUp(e);
    }

  };

  private Callback callback = new Callback(this);
  private boolean moveEditorOnEnter;

  @SuppressWarnings("unchecked")
  public void bindGrid(Grid grid) {
    if (this.grid != null) {
      this.grid.removeListener(Events.RowMouseDown, this);
      this.grid.removeListener(Events.ContextMenu, this);
      this.grid.getView().removeListener(Events.RowUpdated, this);
      this.grid.getView().removeListener(Events.Refresh, this);
      keyNav.bind(null);
      bind(null);
    }
    this.grid = grid;
    if (grid != null) {
      grid.addListener(Events.RowMouseDown, this);
      grid.addListener(Events.ContextMenu, this);
      grid.getView().addListener(Events.RowUpdated, this);
      grid.getView().addListener(Events.Refresh, this);
      keyNav.bind(grid);
      bind(grid.getStore());
      this.listStore = (ListStore) grid.getStore();
    }
    bind(grid != null ? grid.getStore() : null);
  }

  @SuppressWarnings("unchecked")
  public void handleEvent(BaseEvent e) {
    EventType type = e.getType();
    if (type == Events.RowMouseDown) {
      handleMouseDown((GridEvent) e);
    } else if (type == Events.RowUpdated) {
      onRowUpdated((GridEvent) e);
    } else if (type == Events.Refresh) {
      refresh();
    }
  }

  public boolean isLocked() {
    return false;
  }

  /**
   * Returns true of the editor moves on enter.
   * 
   * @return true if editor moves on enter
   */
  public boolean isMoveEditorOnEnter() {
    return moveEditorOnEnter;
  }

  /**
   * Selects the next row.
   * 
   * @param keepexisting true to keep existing selections
   */
  public void selectNext(boolean keepexisting) {
    if (hasNext()) {
      int idx = listStore.indexOf(lastSelected) + 1;
      select(idx, keepexisting);
      grid.getView().focusRow(idx);
    }
  }

  /**
   * Selects the previous row.
   * 
   * @param keepexisting true to keep existing selections
   */
  public void selectPrevious(boolean keepexisting) {
    if (hasPrevious()) {
      int idx = listStore.indexOf(lastSelected) - 1;
      select(idx, keepexisting);
      grid.getView().focusRow(idx);
    }
  }

  /**
   * Set this to true to move the editor to the next editable cell on pressing
   * enter.
   * 
   * @param moveEditorOnEnter true to move the editor on pressing enter.
   */
  public void setMoveEditorOnEnter(boolean moveEditorOnEnter) {
    this.moveEditorOnEnter = moveEditorOnEnter;
  }

  protected void doFocus(int row, int cell) {
    GridView view = grid.getView();
    view.focusRow(row);
  }

  @SuppressWarnings("unchecked")
  protected void handleMouseDown(GridEvent<M> e) {
    if (isLocked()) {
      return;
    }
    if (e.isRightClick()) {
      if (e.getRowIndex() != -1) {
        if (isSelected(listStore.getAt(e.getRowIndex()))
            && selectionMode != SelectionMode.SINGLE) {
          return;
        }
        select(e.getRowIndex(), false);
      }
    } else {
      GridView view = grid.getView();
      M sel = listStore.getAt(e.getRowIndex());

      if (selectionMode == SelectionMode.SINGLE) {
        if (isSelected(sel) && e.isControlKey()) {
          deselect(sel);
        } else if (!isSelected(sel)) {
          select(sel, false);
          view.focusCell(e.getRowIndex(), e.getColIndex(), true);
        }
      } else {
        if (e.isShiftKey() && lastSelected != null) {
          int last = listStore.indexOf(lastSelected);
          int index = e.getRowIndex();
          int a = (last > index) ? index : last;
          int b = (last < index) ? index : last;
          select(a, b, e.isControlKey());
          lastSelected = listStore.getAt(last);
          view.focusCell(index, e.getColIndex(), true);
        } else if (isSelected(sel) && e.isControlKey()) {
          doDeselect(Arrays.asList(sel), false);
        } else {
          doSelect(Arrays.asList(sel), e.isControlKey(), false);
          view.focusCell(e.getRowIndex(), e.getColIndex(), true);
        }
      }
    }
  }

  protected boolean hasNext() {
    return lastSelected != null
        && listStore.indexOf(lastSelected) < (listStore.getCount() - 1);
  }

  protected boolean hasPrevious() {
    return lastSelected != null && listStore.indexOf(lastSelected) > 0;
  }

  protected boolean isSelectable(int row, int cell, boolean acceptsNav) {
    if (acceptsNav) {
      return !grid.getColumnModel().isHidden(cell)
          && grid.getColumnModel().isCellEditable(cell);
    } else {
      return !grid.getColumnModel().isHidden(cell);
    }
  }

  public void onEditorKey(DomEvent e) {
    EditSupport editGrid = (EditSupport) grid;
    int k = e.getKeyCode();
    Cell newCell = null;
    CellEditor editor = editGrid.getActiveEditor();
    switch (k) {
      case KeyCodes.KEY_ENTER:
      case KeyCodes.KEY_TAB:
        e.stopEvent();
        editor.completeEdit();
        if ((k == KeyCodes.KEY_ENTER && moveEditorOnEnter) || k == KeyCodes.KEY_TAB) {
          if (e.isShiftKey()) {
            newCell = grid.walkCells(editor.row, editor.col - 1, -1, callback, true);
          } else {
            newCell = grid.walkCells(editor.row, editor.col + 1, 1, callback, true);
          }
        }
        break;
      case KeyCodes.KEY_ESCAPE:
        editor.cancelEdit();
        break;
    }
    if (newCell != null) {
      editGrid.startEditing(newCell.row, newCell.cell);
    } else {
      if (k == KeyCodes.KEY_ENTER || k == KeyCodes.KEY_TAB || k == KeyCodes.KEY_ESCAPE) {
        grid.getView().focusCell(editor.row, editor.col, false);
      }
    }
  }

  protected void onKeyDown(GridEvent<M> e) {
    selectNext(e.isShiftKey());
    e.preventDefault();
  }

  protected void onKeyLeft(GridEvent<M> ce) {

  }

  protected void onKeyPress(GridEvent<M> e) {

  }

  protected void onKeyRight(GridEvent<M> ce) {

  }

  protected void onKeyUp(GridEvent<M> e) {
    selectPrevious(e.isShiftKey());
    e.preventDefault();
  }

  protected void onRowUpdated(GridEvent<M> ge) {
    if (isSelected(ge.getModel())) {
      grid.getView().onRowSelect(ge.getRowIndex());
    }
  }

  @Override
  protected void onSelectChange(M model, boolean select) {
    int idx = listStore.indexOf(model);
    if (idx == -1) {
      return;
    }
    if (select) {
      grid.getView().onRowSelect(listStore.indexOf(model));
    } else {
      grid.getView().onRowDeselect(listStore.indexOf(model));
    }
  }
}

class Cell {
  public int row;
  public int cell;

  public Cell(int row, int cell) {
    this.row = row;
    this.cell = cell;
  }

}
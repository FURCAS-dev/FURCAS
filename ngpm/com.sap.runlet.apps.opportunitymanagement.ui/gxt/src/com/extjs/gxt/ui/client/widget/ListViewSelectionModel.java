/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.Arrays;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.ListViewEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.widget.selection.AbstractStoreSelectionModel;

/**
 * ListView selection model.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>AbstractStoreSelectionModel BeforeSelect</dd>
 * <dd>AbstractStoreSelectionModel SelectionChange</dd>
 * </dl>
 */
public class ListViewSelectionModel<M extends ModelData> extends AbstractStoreSelectionModel<M>
    implements Listener<ListViewEvent<M>> {

  protected ListView<M> listView;
  protected ListStore<M> listStore;
  protected KeyNav<ComponentEvent> keyNav = new KeyNav<ComponentEvent>() {

    @Override
    public void onDown(ComponentEvent e) {
      onKeyDown(e);
    }

    @Override
    public void onKeyPress(ComponentEvent ce) {
      ListViewSelectionModel.this.onKeyPress(ce);
    }

    @Override
    public void onUp(ComponentEvent e) {
      onKeyUp(e);
    }

  };

  /**
   * Binds the list view to the selection model.
   * 
   * @param listView the list view
   */
  @SuppressWarnings("unchecked")
  public void bindList(ListView<M> listView) {
    if (this.listView != null) {
      this.listView.removeListener(Events.Select, this);
      this.listView.removeListener(Events.RowUpdated, this);
      this.listView.removeListener(Events.Refresh, this);
      keyNav.bind(null);
      bind(null);
    }
    this.listView = listView;
    if (listView != null) {
      listView.addListener(Events.Select, this);
      listView.addListener(Events.Refresh, this);
      listView.addListener(Events.RowUpdated, this);
      keyNav.bind(listView);
      bind(listView.getStore());
      this.listStore = (ListStore)listView.getStore();
    }
    bind(listView != null ? listView.getStore() : null);
  }

  public void handleEvent(ListViewEvent<M> e) {
    EventType type = e.getType();
    if (type == Events.Select) {
      onSelect(e);
    } else if (type == Events.RowUpdated) {
      onRowUpdated(e);
    } else if (type == Events.Refresh) {
      refresh();
    }
  }

  @SuppressWarnings("unchecked")
  protected void handleMouseDown(ListViewEvent<M> e) {
    if (locked) return;
    M sel = listStore.getAt(e.getIndex());
    
    if (isSelected(sel) && !e.isControlKey()) {
      return;
    }

    if (selectionMode == SelectionMode.SINGLE) {
      if (isSelected(sel) && e.isControlKey()) {
        deselect(sel);
      } else if (!isSelected(sel)) {
        select(sel, false);
      }
    } else {
      if (e.isShiftKey() && lastSelected != null) {
        int last = listStore.indexOf(lastSelected);
        int index = e.getIndex();
        int a = (last > index) ? index : last;
        int b = (last < index) ? index : last;
        select(a, b, e.isControlKey());
        lastSelected = listStore.getAt(last);
        listView.focusItem(index);
        // view.focusRow(index);
      } else if (isSelected(sel) && e.isControlKey()) {
        doDeselect(Arrays.asList(sel), false);
      } else {
        doSelect(Arrays.asList(sel), e.isControlKey(), false);
        listView.focusItem(e.getIndex());
        // view.focusRow(e.rowIndex);
      }
    }
  }

  protected boolean hasNext() {
    return lastSelected != null && listStore.indexOf(lastSelected) < (listStore.getCount() - 1);
  }

  protected boolean hasPrevious() {
    return lastSelected != null && listStore.indexOf(lastSelected) > 0;
  }

  protected void onKeyDown(ComponentEvent e) {
    selectNext(e.isShiftKey());
    e.preventDefault();
  }

  protected void onKeyPress(ComponentEvent e) {

  }

  protected void onKeyUp(ComponentEvent e) {
    selectPrevious(e.isShiftKey());
    e.preventDefault();
  }

  protected void onRowUpdated(ListViewEvent<M> ge) {
    if (isSelected(ge.getModel())) {
      onSelectChange(ge.getModel(), true);
    }
  }

  protected void onSelect(ListViewEvent<M> e) {
    handleMouseDown(e);
  }

  @Override
  protected void onSelectChange(M model, boolean select) {
    listView.onSelectChange(model, select);
  }

  protected void selectNext(boolean keepexisting) {
    if (hasNext()) {
      int idx = listStore.indexOf(lastSelected) + 1;
      select(idx, keepexisting);
      listView.focusItem(idx);
    }
  }

  protected void selectPrevious(boolean keepexisting) {
    if (hasPrevious()) {
      int idx = listStore.indexOf(lastSelected) - 1;
      select(idx, keepexisting);
      listView.focusItem(idx);
    }
  }

}

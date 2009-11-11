/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TableEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.table.TableItem;

/**
 * A <code>StoreBinder</code> implementation for Tables.
 * 
 * @param <M> the model type
 * 
 * @deprecated see {@link Grid}
 */
public class TableBinder<M extends ModelData> extends StoreBinder<ListStore<M>, Table, M> {

  private Table table;
  private ListStore<M> store;

  /**
   * Creates a new table binder. {@link #init()} must be called after
   * configuring the binder.
   * 
   * @param table the table
   * @param store the list store
   */
  public TableBinder(final Table table, ListStore<M> store) {
    super(store, table);
    this.table = table;
    this.store = store;

    setMask(true);

    table.addListener(Events.SortChange, new Listener<TableEvent>() {
      public void handleEvent(TableEvent te) {
        handleTableSort(te);
      }
    });
  }

  @Override
  public Component findItem(M model) {
    for (TableItem item : table.getItems()) {
      if (store.getModelComparer().equals(item.<M>getModel(), model)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Returns the binder's store.
   * 
   * @return the store
   */
  public ListStore<M> getStore() {
    return store;
  }

  /**
   * Returns the binder's table.
   * 
   * @return the table
   */
  public Table getTable() {
    return table;
  }

  @Override
  protected void removeAll() {
    table.removeAll();
  }

  @Override
  protected void update(M model) {
    TableItem item = (TableItem) findItem(model);
    if (item != null) {
      setModel(item, model);
      updateItemStyles(item);
      updateItemValues(item);
    }
  }

  @Override
  protected void createAll() {
    table.removeAll();
    for (M m : store.getModels()) {
      table.add(createItem(m));
    }
    if (isAutoSelect() && store.getCount() > 0) {
      setSelection(store.getAt(0));
    }
  }

  protected TableItem createItem(M model) {
    TableItem item = new TableItem(new Object[table.getColumnCount()]);
    setModel(item, model);
    updateItemValues(item);
    updateItemStyles(item);
    return item;
  }

  protected String getColumnId(int column) {
    return table.getColumn(column).getId();
  }

  @Override
  protected List<M> getSelectionFromComponent() {
    List<M> selection = new ArrayList<M>();
    List<TableItem> sel = table.getSelectedItems();
    for (TableItem item : sel) {
      selection.add(item.<M>getModel());
    }
    return selection;
  }

  protected void handleTableSort(TableEvent te) {
    TableColumn col = table.getColumn(te.getColumnIndex());
    SortDir dir = col.getSortDir();
    dir = dir == SortDir.ASC ? SortDir.DESC : SortDir.ASC;
    store.sort(col.getId(), dir);
    te.setCancelled(true);
  }

  @Override
  protected void onAdd(StoreEvent<M> be) {
    List<M> models = be.getModels();
    for (int i = models.size() - 1; i >= 0; i--) {
      table.insert(createItem(models.get(i)), be.getIndex());
    }
  }

  @Override
  protected void onClear(StoreEvent<M> se) {
    table.removeAll();
  }

  @Override
  protected void onDataChanged(StoreEvent<M> se) {
    super.onDataChanged(se);
    createAll();

    String sf = store.getSortField();
    if (sf != null && sf.length() > 0) {
      TableColumn col = table.getColumnModel().getColumn(sf);
      table.getTableHeader().onSortChange(col, store.getSortDir());
    } else {
      table.getTableHeader().clearSort();
    }

    if (table != null && table.isRendered()) {
      table.getView().resize();
    }
  }

  @Override
  protected void onFilter(StoreEvent<M> se) {
    if (store.isFiltered()) {
      for (TableItem item : table.getItems()) {
        M model = item.<M>getModel();
        item.setVisible(store.contains(model));
      }
    } else {
      for (TableItem item : table.getItems()) {
        item.setVisible(true);
      }
    }
  }

  @Override
  protected void onRemove(StoreEvent<M> se) {
    TableItem item = (TableItem) findItem(se.getModel());
    if (item != null) {
      table.remove(item);
    }
  }

  @Override
  protected void onSort(StoreEvent<M> se) {
    String id = store.getSortField();
    table.getTableHeader().onSortChange(table.getColumn(id), store.getSortDir());

    Collections.sort(table.getItems(), new Comparator<TableItem>() {
      public int compare(TableItem o1, TableItem o2) {
        int idx1 = store.indexOf(o1.<M>getModel());
        int idx2 = store.indexOf(o2.<M>getModel());
        return idx1 < idx2 ? -1 : 1;
      }
    });
    int rows = table.getItemCount();
    for (int i = 0; i < rows; i++) {
      TableItem item = table.getItem(i);
      table.getView().getDataEl().dom.appendChild(item.getElement());
    }
  }

  @Override
  protected void onUpdate(StoreEvent<M> se) {
    if (se.getModel() != null) {
      update(se.getModel());
    }
  }

  @Override
  protected void setSelectionFromProvider(List<M> selection) {
    List<TableItem> sel = new ArrayList<TableItem>();
    for (M m : selection) {
      TableItem item = (TableItem) findItem(m);
      if (item != null) {
        sel.add(item);
      }
    }
    table.setSelectedItems(sel);
  }

  private void updateItemStyles(TableItem item) {
    M model = item.<M>getModel();
    int cols = table.getColumnCount();
    for (int i = 0; i < cols; i++) {
      String id = getColumnId(i);
      String style = (styleProvider == null) ? null : styleProvider.getStringValue(model, id);
      item.setCellStyle(i, style == null ? "" : style);
    }
  }

  private void updateItemValues(TableItem item) {
    M model = item.<M>getModel();
    int cols = table.getColumnCount();
    for (int j = 0; j < cols; j++) {
      String id = getColumnId(j);
      Object val = getTextValue(model, id);
      if (val == null) val = model.get(id);
      item.setValue(j, val);
    }
  }

}

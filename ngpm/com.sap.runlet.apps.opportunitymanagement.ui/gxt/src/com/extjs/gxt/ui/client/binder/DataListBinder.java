/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.CheckChangedEvent;
import com.extjs.gxt.ui.client.event.CheckChangedListener;
import com.extjs.gxt.ui.client.event.CheckProvider;
import com.extjs.gxt.ui.client.event.DataListEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.DataList;
import com.extjs.gxt.ui.client.widget.DataListItem;
import com.extjs.gxt.ui.client.widget.ListView;

/**
 * A <code>StoreBinder</code> implementation for <code>DataList</code>.
 * 
 * @param <M> the model type
 * 
 * @deprecated see {@link ListView}
 */
public class DataListBinder<M extends ModelData> extends StoreBinder<ListStore<M>, DataList, M>
    implements CheckProvider<M> {

  private DataList list;
  private ListStore<M> store;
  private String displayProperty;
  private List<CheckChangedListener<M>> checkListeners;
  private boolean silent;

  /**
   * Creates a new data list store binder.
   * 
   * @param list the data list
   * @param store the list store
   */
  public DataListBinder(final DataList list, ListStore<M> store) {
    super(store, list);
    this.list = list;
    this.store = store;
  }

  public void addCheckListener(CheckChangedListener<M> listener) {
    if (checkListeners == null) {
      checkListeners = new ArrayList<CheckChangedListener<M>>();
    }
    if (!checkListeners.contains(listener)) {
      checkListeners.add(listener);
    }
  }

  @Override
  public Component findItem(M model) {
    for (DataListItem item : list.getItems()) {
      if (store.getModelComparer().equals(item.<M>getModel(), model)) {
        return item;
      }
    }
    return null;
  }

  public List<M> getCheckedSelection() {
    List<M> selection = new ArrayList<M>();
    for (DataListItem item : list.getChecked()) {
      selection.add(item.<M>getModel());
    }
    return selection;
  }

  /**
   * Returns the display property.
   * 
   * @return the display property
   */
  public String getDisplayProperty() {
    return displayProperty;
  }

  /**
   * Returns the data list.
   * 
   * @return this list
   */
  public DataList getList() {
    return list;
  }

  /**
   * Returns the list store.
   * 
   * @return the store
   */
  public ListStore<M> getStore() {
    return store;
  }

  public boolean isChecked(M model) {
    DataListItem item = (DataListItem) findItem(model);
    if (item != null) {
      return item.isChecked();
    }
    return false;
  }

  public void removeCheckListener(CheckChangedListener<M> listener) {
    if (checkListeners != null) {
      checkListeners.remove(checkListeners);
    }
  }

  public void setCheckedSelection(List<M> selection) {
    silent = true;
    for (DataListItem item : list.getChecked()) {
      if (item.isChecked()) {
        item.setChecked(false);
      }
    }
    for (M m : selection) {
      DataListItem item = (DataListItem) findItem(m);
      if (item != null) {
        item.setChecked(true);
      }
    }
    silent = false;
    fireCheckChanged(getCheckedSelection());
  }

  /**
   * Sets the display property name used for the item's text.
   * 
   * @param displayProperty the property
   */
  public void setDisplayProperty(String displayProperty) {
    this.displayProperty = displayProperty;
  }

  @Override
  protected void createAll() {
    list.removeAll();
    for (M m : store.getModels()) {
      list.add(createItem(m));
    }
  }

  protected DataListItem createItem(M model) {
    DataListItem item = new DataListItem();
    item.setText(getTextValue(model, displayProperty, true));
    item.setIconStyle(getIconValue(model, displayProperty));
    String style = (styleProvider == null) ? null : styleProvider.getStringValue(model,
        displayProperty);
    item.setTextStyle(style);
    setModel(item, model);
    return item;
  }

  protected void fireCheckChanged(List<M> selection) {
    if (checkListeners != null) {
      CheckChangedEvent<M> evt = new CheckChangedEvent<M>(this, selection);
      for (CheckChangedListener<M> listener : checkListeners) {
        listener.checkChanged(evt);
      }
    }
  }

  @Override
  protected List<M> getSelectionFromComponent() {
    List<M> selection = new ArrayList<M>();
    List<DataListItem> sel = list.getSelectedItems();
    for (DataListItem item : sel) {
      selection.add(item.<M>getModel());
    }
    return selection;
  }

  @Override
  protected void hook() {
    super.hook();
    component.addListener(Events.CheckChange, new Listener<DataListEvent>() {
      public void handleEvent(DataListEvent be) {
        if (!silent) {
          fireCheckChanged(getCheckedSelection());
        }
      }
    });
  }

  @Override
  protected void onAdd(StoreEvent<M> se) {
    List<M> models = se.getModels();
    for (int i = models.size() - 1; i >= 0; i--) {
      list.insert(createItem(models.get(i)), se.getIndex());
    }
  }

  @Override
  protected void onDataChanged(StoreEvent<M> se) {
    super.onDataChanged(se);
    createAll();
  }

  @Override
  protected void onFilter(StoreEvent<M> se) {
    if (store.isFiltered()) {
      for (DataListItem item : list.getItems()) {
        M m = item.<M>getModel();
        item.setVisible(store.contains(m));
      }
    } else {
      for (DataListItem item : list.getItems()) {
        item.setVisible(true);
      }
    }
  }

  @Override
  protected void onRemove(StoreEvent<M> se) {
    DataListItem item = (DataListItem) findItem((M) se.getModel());
    if (item != null) {
      list.remove(item);
    }
  }

  @Override
  protected void onSort(StoreEvent<M> se) {
    if (list.getItemCount() > 0) {
      list.sort(new Comparator<DataListItem>() {
        public int compare(DataListItem o1, DataListItem o2) {
          int idx1 = store.indexOf(o1.<M>getModel());
          int idx2 = store.indexOf(o2.<M>getModel());
          return idx1 < idx2 ? -1 : 1;
        }
      });
    }
  }

  @Override
  protected void onUpdate(StoreEvent<M> se) {
    if (se.getModel() != null) {
      update(se.getModel());
    }
  }

  @Override
  protected void removeAll() {
    list.removeAll();
  }

  @Override
  protected void setSelectionFromProvider(List<M> selection) {
    List<DataListItem> sel = new ArrayList<DataListItem>();
    for (M m : selection) {
      DataListItem item = (DataListItem) findItem(m);
      if (item != null) {
        sel.add(item);
      }
    }
    list.setSelectedItems(sel);
  }

  @Override
  protected void update(M model) {
    DataListItem item = (DataListItem) findItem(model);
    if (item != null) {
      setModel(item, model);
      item.setText(getTextValue(model, displayProperty, true));
      item.setIconStyle(getIconValue(model, displayProperty));
      String style = (styleProvider == null) ? null : styleProvider.getStringValue(model,
          displayProperty);
      item.setTextStyle(style);
    }
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.ListLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.Loader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.SortInfo;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

/**
 * The store class encapsulates a client side cache of {@link ModelData} objects
 * which provide input data for Components such as the {@link ComboBox} and
 * {@link ListView ListView}
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Store.BeforeDataChanged</b> : StoreEvent(store)<br>
 * <div>Fires before the store's data is changed. Apply applies when a store is
 * bound to a loader.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.DataChange</b> : StoreEvent(store)<br>
 * <div>Fires when the data cache has changed, and a widget which is using this
 * Store as a ModelData cache should refresh its view.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Filter</b> : StoreEvent(store)<br>
 * <div>Fires when filters are applied and removed from the store.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Sort</b> : StoreEvent(store)<br>
 * <div>Fires after the store's data has been changed due to sorting.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Add</b> : StoreEvent(store, models, index)<br>
 * <div>Fires when models have been added to the store.</div>
 * <ul>
 * <li>store : this</li>
 * <li>models : the added models</li>
 * <li>index : the index at which the model(s) were added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Remove</b> : StoreEvent(store, model)<br>
 * <div>Fires when a model has been removed from the store.</div>
 * <ul>
 * <li>store : this</li>
 * <li>model : the model that was removed</li>
 * <li>index : the index at which the model was removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Update</b> : StoreEvent(store, model, record)<br>
 * <div>Fires when a model has been updated via its record.</div>
 * <ul>
 * <li>store : this</li>
 * <li>model : the model that was updated</li>
 * <li>record : the record that was updated</li>
 * <li>operation : the update operation being performed.</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Store.Clear</b> : StoreEvent(store)<br>
 * <div>Fires when the data cache has been cleared.</div>
 * <ul>
 * <li>store : this</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 */
public class ListStore<M extends ModelData> extends Store<M> {

  protected ListLoader<ListLoadResult<M>> loader;
  protected ListLoadConfig config;

  /**
   * Creates a new store.
   */
  public ListStore() {

  }

  /**
   * Creates a new store.
   * 
   * @param loader the loader instance
   */
  @SuppressWarnings("unchecked")
  public ListStore(ListLoader loader) {
    this.loader = loader;
    loader.addLoadListener(new LoadListener() {

      public void loaderBeforeLoad(LoadEvent le) {
        onBeforeLoad(le);
      }

      public void loaderLoad(LoadEvent le) {
        onLoad(le);
      }

      public void loaderLoadException(LoadEvent le) {
        onLoadException(le);
      }

    });
  }

  /**
   * Adds the models to the store and fires the <i>Add</i> event.
   * 
   * @param models the models to add
   */
  public void add(List<? extends M> models) {
    insert(models, getCount());
  }

  /**
   * Adds the model to the store and fires the <i>Add</i> event.
   * 
   * @param model the model to add
   */
  public void add(M model) {
    insert(model, getCount());
  }

  /**
   * Get the model at the specified index.
   * 
   * @param index the index of the model to find
   * @return the model at the passed index
   */
  public M getAt(int index) {
    return index < all.size() ? all.get(index) : null;
  }

  /**
   * Gets the number of cached records.
   * 
   * @return the number of models in the store's cache.
   */
  public int getCount() {
    return all.size();
  }

  /**
   * Returns the store's last processed load config if available.
   * 
   * @return the load config
   */
  public ListLoadConfig getLoadConfig() {
    return config;
  }

  /**
   * Returns the store's loader
   * 
   * @return the loader or null
   */
  public ListLoader<? extends ListLoadResult<M>> getLoader() {
    return loader;
  }

  /**
   * Returns a range of models between specified indices.
   * 
   * @param start the starting index
   * @param end the ending index
   * @return the list of models
   */
  public List<M> getRange(int start, int end) {
    List<M> temp = new ArrayList<M>();
    for (int i = start; i <= end; i++) {
      temp.add(getAt(i));
    }
    return temp;
  }

  /**
   * Returns the current sort direction.
   * 
   * @return the sort direction
   */
  public SortDir getSortDir() {
    return sortInfo.getSortDir();
  }

  /**
   * Returns the current sort field.
   * 
   * @return the sort field
   */
  public String getSortField() {
    return sortInfo.getSortField();
  }

  /**
   * Returns the current sort state of this store.
   * 
   * @return the sort state
   */
  public SortInfo getSortState() {
    return sortInfo;
  }

  /**
   * Returns the index of the model in this store.
   * 
   * @param model the model
   * @return the index
   */
  public int indexOf(M model) {
    for (int i = 0; i < all.size(); i++) {
      M m = all.get(i);
      if (equals(model, m)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Inserts the models to the store at the given index and fires the <i>Add</i>
   * event.
   * 
   * @param models the models to insert
   * @param index the insert location
   */
  public void insert(List<? extends M> models, int index) {
    insert(models, index, false);
  }

  /**
   * Inserts the model to the store at the given index and fires the <i>Add</i>
   * event.
   * 
   * @param model the model to insert
   * @param index the insert location
   */
  public void insert(M model, int index) {
    List<M> temp = new ArrayList<M>();
    temp.add(model);
    insert(temp, index);
  }

  /**
   * Remove a item from the store and fires the <i>Remove</i> event.
   * 
   * @param model the model to remove
   */
  public void remove(M model) {
    int index = indexOf(model);
    if (all.remove(model)) {
      modified.remove(recordMap.get(model));
      if (isFiltered()) {
        snapshot.remove(model);
      }
      unregisterModel(model);
      StoreEvent<M> se = createStoreEvent();
      se.setModel(model);
      se.setIndex(index);
      fireEvent(Remove, se);
    }
  }

  /**
   * Sets the default sort column and order to be used by the next load
   * operation.
   * 
   * @param field the name of the field to sort by
   * @param dir the sort direction
   */
  public void setDefaultSort(String field, SortDir dir) {
    sortInfo = new SortInfo(field, dir);
  }

  /**
   * Ses the sort direction.
   * 
   * @param dir the sort direction
   */
  public void setSortDir(SortDir dir) {
    sortInfo.setSortDir(dir);
  }

  /**
   * Sets the sort field.
   * 
   * @param field the sort field
   */
  public void setSortField(String field) {
    sortInfo.setSortField(field);
  }

  /**
   * Sort the store.
   * 
   * <p/>
   * If remote sorting is used, the sort is performed on the server, and the
   * cache is reloaded. If local sorting is used, the cache is sorted
   * internally.
   * 
   * @param field the field to sort by
   * @param sortDir the sort dir
   */
  public void sort(String field, SortDir sortDir) {
    SortInfo prev = new SortInfo(sortInfo.getSortField(), sortInfo.getSortDir());

    if (sortDir == null) {
      if (sortInfo.getSortField() != null && !sortInfo.getSortField().equals(field)) {
        sortInfo.setSortDir(SortDir.NONE);
      }
      switch (sortInfo.getSortDir()) {
        case ASC:
          sortDir = SortDir.DESC;
          break;
        case DESC:
        case NONE:
          sortDir = SortDir.ASC;
          break;
      }

    }

    sortInfo.setSortField(field);
    sortInfo.setSortDir(sortDir);

    if (loader != null && loader.isRemoteSort()) {
      Listener<LoadEvent> l = new Listener<LoadEvent>() {
        public void handleEvent(LoadEvent le) {
          loader.removeListener(Sort, this);
          sortInfo = le.<ListLoadConfig> getConfig().getSortInfo();
          fireEvent(Sort, createStoreEvent());
        }
      };
      loader.addListener(Loader.Load, l);
      loader.setSortDir(sortDir);
      loader.setSortField(field);
      if (!loader.load()) {
        loader.removeListener(Sort, l);
        sortInfo.setSortField(prev.getSortField());
        sortInfo.setSortDir(prev.getSortDir());
      }
    } else {
      applySort(false);
      fireEvent(DataChanged, createStoreEvent());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void applySort(boolean supressEvent) {
    if ((loader == null || !loader.isRemoteSort())) {
      storeSorter = storeSorter == null ? new StoreSorter() : storeSorter;
      Collections.sort(all, new Comparator<M>() {
        public int compare(M m1, M m2) {
          return storeSorter.compare(ListStore.this, m1, m2, sortInfo.getSortField());
        }
      });
      if (sortInfo.getSortDir() == SortDir.DESC) {
        Collections.reverse(all);
      }
      if (!supressEvent) {
        fireEvent(Sort, createStoreEvent());
      }
    }
  }

  @SuppressWarnings("unchecked")
  protected void insert(List<? extends M> items, int index, boolean supressEvent) {
    if (items.size() > 0) {
      List<M> added = new ArrayList<M>();
      if (storeSorter != null) {
        boolean defer = index == 0 && getCount() == 0;
        for (M m : items) {
          if (isFiltered()) {
            snapshot.add(m);
            if (!isFiltered(m, filterProperty)) {
              all.add(m);
              added.add(m);
            }
          } else {
            all.add(m);
            added.add(m);
          }
          applySort(true);
          int idx = indexOf(m);
          registerModel(m);
          if (!defer && !supressEvent && added.contains(m)) {
            StoreEvent evt = createStoreEvent();
            evt.setModels(Util.createList(m));
            evt.setIndex(idx);
            fireEvent(Add, evt);
          }
        }
        if (defer && !supressEvent && added.size() > 0) {
          StoreEvent evt = createStoreEvent();
          evt.setModels(getModels());
          evt.setIndex(index);
          fireEvent(Add, evt);
        }
      } else {
        if (!isFiltered()) {
          all.addAll(index, items);
          added.addAll(items);
        } else {
          snapshot.addAll(index, items);
        }

        for (M m : items) {
          registerModel(m);
          if (isFiltered() && !isFiltered(m, filterProperty)) {
            all.add(index, m);
            added.add(m);
          }
        }
        if (!supressEvent && added.size() > 0) {
          StoreEvent evt = createStoreEvent();
          evt.setModels(added);
          evt.setIndex(index);
          fireEvent(Add, evt);
        }
      }
    }
  }

  protected void onBeforeLoad(LoadEvent le) {
    if (!fireEvent(BeforeDataChanged, createStoreEvent())) {
      le.setCancelled(true);
    }
  }

  @SuppressWarnings("unchecked")
  protected void onLoad(LoadEvent le) {
    this.config = (ListLoadConfig) le.getConfig();

    Object data = le.getData();

    removeAll();

    if (data instanceof List) {
      List<M> list = (List) le.getData();
      all = list;

    } else if (data instanceof ListLoadResult) {
      all = ((ListLoadResult) data).getData();
    }

    for (M m : all) {
      registerModel(m);
    }

    if (le.<Object> getConfig() instanceof ListLoadConfig) {
      ListLoadConfig config = le.getConfig();
      if (config.getSortInfo().getSortField() != null) {
        sortInfo = config.getSortInfo();
      } else {
        sortInfo = new SortInfo();
      }
    }

    if (filtersEnabled) {
      filtersEnabled = false;
      applyFilters(filterProperty);
    }
    if (storeSorter != null) {
      applySort(true);
    }
    fireEvent(DataChanged, createStoreEvent());
  }

  protected void onLoadException(LoadEvent le) {

  }

  @SuppressWarnings("unchecked")
  protected void sortData(final String field, SortDir direction) {
    direction = direction == null ? SortDir.ASC : direction;
    storeSorter = storeSorter == null ? new StoreSorter() : storeSorter;
    Collections.sort(all, new Comparator<M>() {
      public int compare(M m1, M m2) {
        return storeSorter.compare(ListStore.this, m1, m2, field);
      }
    });
    if (direction == SortDir.DESC) {
      Collections.reverse(all);
    }
  }

}

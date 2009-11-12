/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.data.ChangeEvent;
import com.extjs.gxt.ui.client.data.ChangeEventSource;
import com.extjs.gxt.ui.client.data.ChangeListener;
import com.extjs.gxt.ui.client.data.DefaultModelComparer;
import com.extjs.gxt.ui.client.data.ModelComparer;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.SortInfo;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.store.Record.RecordUpdate;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

/**
 * The store class encapsulates a client side cache of {@link ModelData} objects
 * which provide input data for components such as the {@link ComboBox} and
 * {@link ListView ListView}.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Store.Filter</b> : StoreEvent(store)<br>
 * <div>Fires when filters are applied and removed from the store.</div>
 * <ul>
 * <li>store : this</li>
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
 * 
 * @param <M> the model data type
 */
public abstract class Store<M extends ModelData> extends BaseObservable {

  /**
   * BeforeDataChanged event type.
   */
  public static final EventType BeforeDataChanged = new EventType();

  /**
   * DataChanged event type.
   */
  public static final EventType DataChanged = new EventType();

  /**
   * Filter event type.
   */
  public static final EventType Filter = new EventType();

  /**
   * Filter event type.
   */
  public static final EventType Sort = new EventType();

  /**
   * Add event type.
   */
  public static final EventType Add = new EventType();

  /**
   * Remove event type.
   */
  public static final EventType Remove = new EventType();

  /**
   * Update event type.
   */
  public static final EventType Update = new EventType();

  /**
   * Clear event type.
   */
  public static final EventType Clear = new EventType();

  protected List<M> all = new ArrayList<M>();
  protected Map<M, Record> recordMap = new HashMap<M, Record>();
  protected List<M> filtered;
  protected List<Record> modified = new ArrayList<Record>();
  protected SortInfo sortInfo = new SortInfo();
  protected StoreSorter<M> storeSorter;
  protected String filterProperty;
  protected String filterBeginsWidth;
  protected boolean filtersEnabled;
  protected List<M> snapshot;
  protected List<StoreFilter<M>> filters;

  private ModelComparer<M> comparer;
  private ChangeListener changeListener;
  private boolean monitorChanges;

  @SuppressWarnings("unchecked")
  public Store() {
    comparer = DefaultModelComparer.DFFAULT;
  }

  /**
   * Adds a filter to the store.
   * 
   * @param filter the store filter to add
   */
  public void addFilter(StoreFilter<M> filter) {
    if (filters == null) {
      filters = new ArrayList<StoreFilter<M>>();
    }
    filters.add(filter);
  }

  /**
   * Adds a store listener.
   * 
   * @param listener the listener to add
   */
  public void addStoreListener(StoreListener<M> listener) {
    addListener(Filter, listener);
    addListener(Sort, listener);
    addListener(BeforeDataChanged, listener);
    addListener(DataChanged, listener);
    addListener(Add, listener);
    addListener(Remove, listener);
    addListener(Update, listener);
    addListener(Clear, listener);
  }

  /**
   * Applies the current filters to the store.
   * 
   * @param property the optional active property
   */
  public void applyFilters(String property) {
    if (filters != null && filters.size() == 0) {
      return;
    }
    filterProperty = property;
    if (!filtersEnabled) {
      snapshot = all;
    }

    filtersEnabled = true;
    filtered = new ArrayList<M>();
    for (M items : snapshot) {
      if (filterBeginsWidth != null) {
        Object o = items.get(property);
        if (o != null) {
          if (!o.toString().toLowerCase().startsWith(filterBeginsWidth.toLowerCase())) {
            continue;
          }
        }
      }
      if (!isFiltered(items, property)) {
        filtered.add(items);
      }
    }
    all = filtered;

    if (storeSorter != null) {
      applySort(false);
    }

    fireEvent(Filter, createStoreEvent());
  }

  /**
   * Revert to a view of this store with no filtering applied.
   */
  public void clearFilters() {
    if (isFiltered()) {
      filtersEnabled = false;
      all = snapshot;
      snapshot = null;
      fireEvent(Filter, createStoreEvent());
    }
  }

  /**
   * Commit all items with outstanding changes. To handle updates for changes,
   * subscribe to the Store's <i>Update</i> event, and perform updating when the
   * operation parameter is {@link RecordUpdate#COMMIT}.
   */
  public void commitChanges() {
    List<Record> mod = new ArrayList<Record>(modified);
    for (Record r : mod) {
      r.commit(false);
    }
    modified = new ArrayList<Record>();
  }

  /**
   * Returns true if the item is in this store.
   * 
   * @param item the item
   * @return true if container
   */
  public boolean contains(ModelData item) {
    return all.contains(item);
  }

  /**
   * Filters the store using the given property.
   * 
   * @param property the property to filter by
   */
  public void filter(String property) {
    filterProperty = property;
    filterBeginsWidth = null;
    applyFilters(property);
  }

  /**
   * Filters the store using the given property.
   * 
   * @param property the property to filter by
   * @param beginsWith a string the value should begin with
   */
  public void filter(String property, String beginsWith) {
    filterProperty = property;
    filterBeginsWidth = beginsWith;
    applyFilters(property);
  }

  /**
   * Returns the matching model in the cache using the model comparer to test
   * for equality.
   * 
   * @param model the model
   * @return the matching model or null if no match
   */
  public M findModel(M model) {
    for (M m : all) {
      if (comparer.equals(m, model)) {
        return m;
      }
    }
    return null;
  }

  /**
   * Returns true if the two models are equal as defined by the model comparer.
   * 
   * @param model1 the first model
   * @param model2 the second model
   * @return true if equals
   */
  public boolean equals(M model1, M model2) {
    return comparer.equals(model1, model2);
  }

  /**
   * Returns the first model whose property matches the given value.
   * 
   * @param property the property name
   * @param value the value to match
   * @return the model or null if no match
   */
  public M findModel(String property, Object value) {
    for (M m : all) {
      Object val = m.get(property);
      if (val == value || (val != null && val.equals(value))) {
        return m;
      }
    }
    return null;
  }

  /**
   * Returns a list of all matching models whose property matches the given
   * value.
   * 
   * @param property the property name
   * @param value the value to match
   * @return the list of matching models
   */
  public List<M> findModels(String property, Object value) {
    List<M> models = new ArrayList<M>();
    for (M m : all) {
      Object val = m.get(property);
      if (val == value || (val != null && val.equals(value))) {
        models.add(m);
      }
    }
    return models;
  }

  /**
   * Returns the store's filters.
   * 
   * @return the filters
   */
  public List<StoreFilter<M>> getFilters() {
    return filters;
  }

  /**
   * Returns the comparer used to compare model instances.
   * 
   * @return the comparer
   */
  public ModelComparer<M> getModelComparer() {
    return comparer;
  }

  /**
   * Returns the store's models.
   * 
   * @return the items
   */
  public List<M> getModels() {
    return new ArrayList<M>(all);
  }

  /**
   * Gets all records modified since the last commit. Modified records are
   * persisted across load operations (e.g., during paging).
   * 
   * @return a list of modified records
   */
  public List<Record> getModifiedRecords() {
    return new ArrayList<Record>(modified);
  }

  /**
   * Returns the record instance for the item. Records are created on-demand and
   * are cleared after a stores modifications are accepted or rejected.
   * 
   * @param model the item
   * @return the record for the item
   */
  public Record getRecord(M model) {
    Record record = recordMap.get(model);
    if (record == null) {
      record = new Record(model);
      record.join(this);
      recordMap.put(model, record);
    }
    return record;
  }

  /**
   * Returns the store sorter.
   * 
   * @return the store sorter
   */
  public StoreSorter<M> getStoreSorter() {
    return storeSorter;
  }

  /**
   * Returns true if a record exists for the given model.
   * 
   * @param model the model
   * @return true if a record exists
   */
  public boolean hasRecord(M model) {
    return recordMap.containsKey(model);
  }

  /**
   * Returns true if this store is currently filtered.
   * 
   * @return true if the store is filtered
   */
  public boolean isFiltered() {
    return filtersEnabled;
  }

  /**
   * Returns true if the store is monitoring changes.
   * 
   * @return the montitro changes state
   */
  public boolean isMonitorChanges() {
    return monitorChanges;
  }

  /**
   * Cancel outstanding changes on all changed records.
   */
  public void rejectChanges() {
    for (Record r : new ArrayList<Record>(modified)) {
      r.reject(false);
    }
    modified.clear();
  }

  /**
   * Remove all items from the store and fires the <i>Clear</i> event.
   */
  public void removeAll() {
    for (M m : all) {
      unregisterModel(m);
    }
    all.clear();
    modified.clear();
    recordMap.clear();
    if (snapshot != null) {
      snapshot.clear();
    }
    fireEvent(Clear, createStoreEvent());
  }

  /**
   * Removes a previously added filter.
   * 
   * @param filter the filter to remove
   */
  public void removeFilter(StoreFilter<M> filter) {
    if (filters != null) {
      filters.remove(filter);
    }
  }

  /**
   * Removes a store listener.
   * 
   * @param listener the store listener to remove
   */
  public void removeStoreListener(StoreListener<M> listener) {
    removeListener(Sort, listener);
    removeListener(Filter, listener);
    removeListener(BeforeDataChanged, listener);
    removeListener(DataChanged, listener);
    removeListener(Add, listener);
    removeListener(Remove, listener);
    removeListener(Update, listener);
    removeListener(Clear, listener);
  }

  /**
   * Sets the comparer to be used when comparing model instances.
   * 
   * @param comparer the comparer
   */
  public void setModelComparer(ModelComparer<M> comparer) {
    this.comparer = comparer;
  }

  /**
   * Sets whether the store should listen to change events on its children
   * (defaults to false). This method should be called prior to any models being
   * added to the store when monitoring changes. Only model instances which
   * implement {@link ChangeEventSource} may be monitored.
   * 
   * @param monitorChanges true to monitor changes
   */
  public void setMonitorChanges(boolean monitorChanges) {
    if (changeListener == null) {
      changeListener = new ChangeListener() {

        public void modelChanged(ChangeEvent event) {
          onModelChange(event);
        }

      };
    }
    this.monitorChanges = monitorChanges;
  }

  /**
   * Sets the store's sorter.
   * 
   * @param storeSorter the sorter
   */
  public void setStoreSorter(StoreSorter<M> storeSorter) {
    this.storeSorter = storeSorter;
  }

  /**
   * Notifies the store that the model has been updated and fires the
   * <i>Update</i> event.
   * 
   * @param model the updated model
   */
  public void update(M model) {
    M m = findModel(model);
    if (m != null) {
      if (m != model) {
        swapModelInstance(m, model);
      }
      StoreEvent<M> evt = createStoreEvent();
      evt.setModel(model);
      evt.setIndex(all.indexOf(m));
      fireEvent(Update, evt);
    }
  }

  protected void afterCommit(Record record) {
    modified.remove(record);
    fireStoreEvent(Update, RecordUpdate.COMMIT, record);
  }

  protected void afterEdit(Record record) {
    if (record.isDirty()) {
      if (!modified.contains(record)) {
        modified.add(record);
      }
    } else {
      modified.remove(record);
    }
    fireStoreEvent(Update, RecordUpdate.EDIT, record);
  }

  protected void afterReject(Record record) {
    modified.remove(record);
    fireStoreEvent(Update, RecordUpdate.REJECT, record);
  }

  protected void applySort(boolean supressEvent) {

  }

  protected StoreEvent<M> createStoreEvent() {
    return new StoreEvent<M>(this);
  }

  @SuppressWarnings("unchecked")
  protected void fireStoreEvent(EventType type, RecordUpdate operation, Record record) {
    StoreEvent<M> evt = createStoreEvent();
    evt.setOperation(operation);
    evt.setRecord(record);
    evt.setModel((M) record.getModel());
    fireEvent(type, evt);
  }

  @SuppressWarnings("unchecked")
  protected boolean isFiltered(ModelData record, String property) {
    if (filters != null) {
      for (StoreFilter filter : filters) {
        boolean result = filter.select(this, record, record, property);
        if (!result) {
          return true;
        }
      }
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  protected void onModelChange(ChangeEvent ce) {
    if (ce.getType() == ChangeEventSource.Update) {
      // ignore updates when in edit mode
      M m = (M) ce.getSource();
      boolean rec = hasRecord(m);
      if (!rec || (rec && !getRecord(m).isEditing())) {
        update((M) ce.getSource());
      }
    }
  }

  /**
   * Subclasses must register any model instance being inserted into the store.
   * 
   * @param model the model
   */
  protected void registerModel(M model) {
    if (monitorChanges && model instanceof ChangeEventSource) {
      ((ChangeEventSource) model).addChangeListener(changeListener);
    }
  }

  protected void swapModelInstance(M oldModel, M newModel) {
    int index = all.indexOf(oldModel);
    if (index != -1) {
      all.remove(oldModel);
      all.add(index, newModel);
      unregisterModel(oldModel);
      registerModel(newModel);
    }
    if (isFiltered()) {
      index = snapshot.indexOf(oldModel);
      if (index != -1) {
        snapshot.remove(oldModel);
        snapshot.add(index, newModel);
      }
    }
  }

  /**
   * Subclasses must unregister any model instance being removed from the store.
   * 
   * @param model the model
   */
  protected void unregisterModel(M model) {
    if (monitorChanges && model instanceof ChangeEventSource) {
      ((ChangeEventSource) model).removeChangeListener(changeListener);
    }
    recordMap.remove(model);
  }

}

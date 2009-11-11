/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;

/**
 * Store event listener.
 */
public class StoreListener<M extends ModelData> implements Listener<StoreEvent<M>> {

  public void handleEvent(StoreEvent<M> e) {
    EventType type = e.getType();
    if (type == Store.Add) {
      storeAdd(e);
    } else if (type == Store.Clear) {
      storeClear(e);
    } else if (type == Store.BeforeDataChanged) {
      storeBeforeDataChanged(e);
    } else if (type == Store.DataChanged) {
      storeDataChanged(e);
    } else if (type == Store.Filter) {
      storeFilter(e);
    } else if (type == Store.Remove) {
      storeRemove(e);
    } else if (type == Store.Sort) {
      storeSort(e);
    } else if (type == Store.Update) {
      storeUpdate(e);
    }
  }

  /**
   * Fires when records have been added to the store.
   * 
   * @param se the store event
   */
  public void storeAdd(StoreEvent<M> se) {

  }

  /**
   * Fires when the data cache has been cleared.
   * 
   * @param se the store event
   */
  public void storeClear(StoreEvent<M> se) {

  }

  /**
   * Fires before the data cache has changed.
   * 
   * @param se the store event
   */
  public void storeBeforeDataChanged(StoreEvent<M> se) {

  }

  /**
   * Fires when the data cache has changed, and a widget which is using this
   * Store as a Record cache should refresh its view.
   * 
   * @param se the store event
   */
  public void storeDataChanged(StoreEvent<M> se) {

  }

  /**
   * Fires after filters have been applied or removed. See
   * {@link ListStore#isFiltered()} to determine if filters are applied.
   * 
   * @param se the store event
   */
  public void storeFilter(StoreEvent<M> se) {

  }

  /**
   * Fires when a tecord has been removed from the store.
   * 
   * @param se the store event
   */
  public void storeRemove(StoreEvent<M> se) {

  }

  /**
   * Fires after the store has been sorted.
   * 
   * @param se the store event
   */
  public void storeSort(StoreEvent<M> se) {

  }

  /**
   * Fires when a tecord has been updated.
   * 
   * @param se the store event
   */
  public void storeUpdate(StoreEvent<M> se) {

  }

}

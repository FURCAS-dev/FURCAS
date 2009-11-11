/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * Interface for store filters.
 * 
 * @param <T> the model type
 */
public interface StoreFilter<T extends ModelData> {

  /**
   * Determines if the given record should be selected.
   * 
   * @param store the source store
   * @param parent the parent item, only applies to TreeStores
   * @param item the item
   * @param property the active property
   * @return true to select, false to filter
   */
  public boolean select(Store<T> store, T parent, T item, String property);

}

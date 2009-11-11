/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import java.util.Comparator;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.util.DefaultComparator;

/**
 * Sorts the records in a store.
 * 
 * @param <M> the record type
 */
public class StoreSorter<M extends ModelData> {

  /**
   * The default comparator instance.
   */
  public static DefaultComparator<Object> DEFAULT_COMPARATOR = new DefaultComparator<Object>();

  protected Comparator<Object> comparator;

  /**
   * Creates a new store sorter.
   */
  public StoreSorter() {
    comparator = DEFAULT_COMPARATOR;
  }

  /**
   * Creates a new store sorter.
   * 
   * @param comparator the comparator
   */
  public StoreSorter(Comparator<Object> comparator) {
    this.comparator = comparator;
  }

  public int compare(Store<M> store, M m1, M m2, String property) {
    if (property != null) {
      Object v1 = m1.get(property);
      Object v2 = m2.get(property);
      return comparator.compare(v1, v2);
    }
    return comparator.compare(m1, m2);
  }
}

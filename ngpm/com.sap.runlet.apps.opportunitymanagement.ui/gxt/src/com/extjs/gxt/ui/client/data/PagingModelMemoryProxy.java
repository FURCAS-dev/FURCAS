/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.extjs.gxt.ui.client.util.DefaultComparator;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * A specialized <code>DataProxy</code> the supports paging when the entire data
 * set is in memory.
 */
public class PagingModelMemoryProxy implements
    DataProxy<PagingLoadResult<? extends ModelData>> {

  private Comparator<Object> comparator;
  private List<? extends ModelData> data;

  @SuppressWarnings("unchecked")
  public PagingModelMemoryProxy(List data) {
    this.data = data;
  }

  /**
   * Returns the comparator.
   * 
   * @return the comparator
   */
  public Comparator<Object> getComparator() {
    return comparator;
  }

  /**
   * Returns the data.
   * 
   * @return the data
   */
  public List<? extends ModelData> getData() {
    return data;
  }

  public void load(DataReader<PagingLoadResult<? extends ModelData>> reader,
      Object loadConfig, AsyncCallback<PagingLoadResult<? extends ModelData>> callback) {

    PagingLoadConfig config = (PagingLoadConfig) loadConfig;

    if (config.getSortInfo().getSortField() != null) {
      final String sortField = config.getSortInfo().getSortField();
      if (sortField != null) {
        Collections.sort(data, config.getSortInfo().getSortDir().comparator(
            new Comparator<ModelData>() {

              public int compare(ModelData o1, ModelData o2) {
                Object v1 = (Object) o1.get(sortField);
                Object v2 = (Object) o2.get(sortField);

                if (comparator != null) {
                  return comparator.compare(v1, v2);
                } else {
                  return DefaultComparator.INSTANCE.compare(v1, v2);
                }

              }
            }));
      }

    }
    ArrayList<ModelData> sublist = new ArrayList<ModelData>();
    int start = config.getOffset();
    int limit = data.size();
    if (config.getLimit() > 0) {
      limit = Math.min(start + config.getLimit(), limit);
    }
    for (int i = config.getOffset(); i < limit; i++) {
      sublist.add(data.get(i));
    }
    callback.onSuccess(new BasePagingLoadResult<ModelData>(sublist, config.getOffset(),
        data.size()));
  }

  /**
   * Sets the comparator used to sort the list of models (default to
   * DefaultComparator).
   * 
   * @param comparator the comparator
   */
  public void setComparator(Comparator<Object> comparator) {
    this.comparator = comparator;
  }

}

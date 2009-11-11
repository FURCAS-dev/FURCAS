/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>DataReader</code> implementation for <code>Model</code> instances.
 */
public class ModelReader implements DataReader<ListLoadResult<? extends ModelData>> {

  @SuppressWarnings("unchecked")
  public ListLoadResult<ModelData> read(Object loadConfig, Object data) {
    if (data instanceof ModelData) {
      List list = new ArrayList();
      list.add(data);
      return newLoadResult(loadConfig, list);
    } else if (data instanceof List) {
      return newLoadResult(loadConfig, (List) data);
    } else if (data instanceof ListLoadResult) {
      return (ListLoadResult) data;
    } else {
      throw new RuntimeException("Error converting data");
    }
  }

  /**
   * Template method that provides load result.
   * 
   * @param models the models
   * @return the load result
   */
  protected ListLoadResult<ModelData> newLoadResult(Object loadConfig,
      List<ModelData> models) {
    return new BaseListLoadResult<ModelData>(models);
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.io.Serializable;
import java.util.List;

/**
 * Default implementation of the <code>ListLoadResult</code> interface.
 * 
 * @param <Data> the result data type
 */
public class BaseListLoadResult<Data> implements ListLoadResult<Data>, Serializable {

  /**
   * The remote data.
   */
  protected List<Data> list;

  BaseListLoadResult() {

  }

  /**
   * Creates a new list load result.
   * 
   * @param list the data
   */
  public BaseListLoadResult(List<Data> list) {
    this.list = list;
  }

  public List<Data> getData() {
    return list;
  }

  public void setData(List<Data> list) {
    this.list = list;
  }

}

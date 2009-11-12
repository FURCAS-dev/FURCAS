/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * A <code>DataProxy</code> implementation that simply passes the data specified
 * in the constructor to the reader when its load method is called.
 * 
 * @param <D> the data type being returned by the proxy
 */
public class MemoryProxy<D> implements DataProxy<D> {

  protected D data;

  /**
   * Creates new memory proxy.
   * 
   * @param data the local data
   */
  public MemoryProxy(D data) {
    this.data = data;
  }

  /**
   * Returns the proxy data.
   * 
   * @return the data
   */
  public D getData() {
    return data;
  }

  public void load(DataReader<D> reader, Object loadConfig, AsyncCallback<D> callback) {
    try {
      D d = null;
      if (reader != null) {
        d = reader.read(loadConfig, data);
      } else {
        d = (D) data;
      }
      callback.onSuccess(d);
    } catch (Exception e) {
      callback.onFailure(e);
    }
  }

  /**
   * Sets the proxy data.
   * 
   * @param data the data
   */
  public void setData(D data) {
    this.data = data;
  }

}

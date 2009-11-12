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
 * Defines the interface for objects that can retrieve data.
 *
 * @param <D> the data typed being returned by the proxy
 */
public interface DataProxy<D> {

  /**
   * Data should be retrieved using the specified load config.
   * 
   * @param reader the reader instance
   * @param loadConfig the config
   * @param callback the data callback
   */
  public void load(DataReader<D> reader, Object loadConfig, AsyncCallback<D> callback);

}

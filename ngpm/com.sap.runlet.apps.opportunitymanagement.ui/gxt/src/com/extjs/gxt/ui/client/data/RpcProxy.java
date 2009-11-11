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
 * <code>DataProxy</code> implementation that retrieves data using GWT RPC.
 *
 * @param <D> the data type being returned by the proxy
 */
public abstract class RpcProxy<D> implements DataProxy<D> {

  public void load(final DataReader<D> reader, final Object loadConfig,
      final AsyncCallback<D> callback) {
    load(loadConfig, new AsyncCallback<D>() {

      public void onFailure(Throwable caught) {
        callback.onFailure(caught);
      }

      @SuppressWarnings("unchecked")
      public void onSuccess(Object result) {
        try {
          D data = null;
          if (reader != null) {
            data = reader.read(loadConfig, result);
          } else {
            data = (D) result;
          }
          callback.onSuccess(data);
        } catch (Exception e) {
          callback.onFailure(e);
        }
      }

    });
  }

  /**
   * Subclasses should make RPC call using the load configuration.
   * 
   * @param callback the callback to be used when making the rpc call.
   */
  protected abstract void load(Object loadConfig, AsyncCallback<D> callback);

}

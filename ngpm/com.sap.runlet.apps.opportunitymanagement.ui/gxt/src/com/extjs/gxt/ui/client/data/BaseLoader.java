/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Abstract base loader implementation.
 * 
 * @param <D> the data type being returned by this loader
 */
public class BaseLoader<D> extends BaseObservable implements Loader<D> {

  protected DataProxy<D> proxy;
  protected DataReader<D> reader;
  protected Object lastConfig;
  protected boolean reuseConfig;

  /**
   * Creates a new base loader instance.
   * 
   * @param proxy the data proxy
   */
  public BaseLoader(DataProxy<D> proxy) {
    this.proxy = proxy;
  }

  /**
   * Creates a new loader with the given proxy and reader.
   * 
   * @param proxy the data proxy
   * @param reader an optional data reader, if null, null will be passed to
   *          proxy.load(Reader, LoadConfig, DataCallback)
   */
  public BaseLoader(DataProxy<D> proxy, DataReader<D> reader) {
    this(proxy);
    this.reader = reader;
  }

  /**
   * Creates a new base loader instance.
   * 
   * @param reader the reader
   */
  public BaseLoader(DataReader<D> reader) {
    this.reader = reader;
  }

  public void addLoadListener(LoadListener listener) {
    addListener(BeforeLoad, listener);
    addListener(LoadException, listener);
    addListener(Load, listener);
  }

  /**
   * Returns the last config.
   * 
   * @return the last config
   */
  public Object getLastConfig() {
    return lastConfig;
  }

  /**
   * Returns the loader's data proxy.
   * 
   * @return the data proxy
   */
  public DataProxy<? extends D> getProxy() {
    return proxy;
  }

  /**
   * Returns true if the load config is being reused.
   * 
   * @return the reuse load config state
   */
  public boolean isReuseLoadConfig() {
    return reuseConfig;
  }

  public boolean load() {
    Object config = (reuseConfig && lastConfig != null) ? lastConfig : newLoadConfig();
    config = prepareLoadConfig(config);
    return load(config);
  }

  public boolean load(Object loadConfig) {
    if (fireEvent(BeforeLoad, new LoadEvent(this, loadConfig))) {
      lastConfig = loadConfig;
      loadData(loadConfig);
      return true;
    }
    return false;
  }

  public void removeLoadListener(LoadListener listener) {
    removeListener(BeforeLoad, listener);
    removeListener(LoadException, listener);
    removeListener(Load, listener);
  }

  /**
   * Sets whether the same load config instance should be used for load
   * operations.
   * 
   * @param reuseLoadConfig true to reuse
   */
  public void setReuseLoadConfig(boolean reuseLoadConfig) {
    this.reuseConfig = reuseLoadConfig;
  }

  protected void loadData(final Object config) {
    AsyncCallback<D> callback = new AsyncCallback<D>() {
      public void onFailure(Throwable caught) {
        onLoadFailure(config, caught);
      }

      public void onSuccess(D result) {
        onLoadSuccess(config, result);
      }
    };
    if (proxy == null) {
      loadData(config, callback);
      return;
    }
    proxy.load(reader, config, callback);
  }

  /**
   * Called when a proxy is not being used.
   * 
   * @param config the load config
   * @param callback the callback
   */
  protected void loadData(final Object config, AsyncCallback<D> callback) {

  }

  /**
   * Template method to allow custom BaseLoader subclasses to provide their own
   * implementation of LoadConfig
   */
  protected Object newLoadConfig() {
    return null;
  }

  /**
   * Called when a load operation fails.
   * 
   * @param loadConfig the load config
   * @param t the exception
   */
  protected void onLoadFailure(Object loadConfig, Throwable t) {
    LoadEvent evt = new LoadEvent(this, loadConfig, t);
    fireEvent(LoadException, evt);
  }

  /**
   * Called when the remote data has been received.
   * 
   * @param loadConfig the load config
   * @param data data
   */
  protected void onLoadSuccess(Object loadConfig, D data) {
    LoadEvent evt = new LoadEvent(this, loadConfig, data);
    fireEvent(Load, evt);
  }

  /**
   * Template method to allow custom subclasses to prepare the load config prior
   * to loading data
   */
  protected Object prepareLoadConfig(Object config) {
    return config;
  }

}

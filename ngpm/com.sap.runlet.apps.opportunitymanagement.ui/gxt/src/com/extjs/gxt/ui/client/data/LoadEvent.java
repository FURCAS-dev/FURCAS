/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.extjs.gxt.ui.client.event.BaseEvent;

/**
 * Instances of this class are sent as a result of load operations.
 */
public class LoadEvent extends BaseEvent {

  public Throwable exception;

  /**
   * The loader that triggered this event.
   */
  public Loader<?> loader;

  private Object config;
  private Object data;

  /**
   * Creates a new load event.
   * 
   * @param loader the data loader
   */
  public LoadEvent(Loader<?> loader) {
    super(loader);
    this.loader = loader;
  }

  /**
   * Creates a new load event.
   * 
   * @param loader the data loader
   * @param config the config object
   */
  public LoadEvent(Loader<?> loader, Object config) {
    this(loader);
    this.config = config;
  }

  /**
   * Creates a new load event.
   * 
   * @param loader the data loader
   * @param config the config object
   * @param data the data
   */
  public LoadEvent(Loader<?> loader, Object config, Object data) {
    this(loader, config);
    this.data = data;
  }

  /**
   * Creates a new load event.
   * 
   * @param loader the data loader
   * @param config the config object
   * @param t the exception
   */
  public LoadEvent(Loader<?> loader, Object config, Throwable t) {
    this(loader, config);
    this.exception = t;
  }

  /**
   * Returns the load config.
   * 
   * @param <X> the load config type
   * @return the load config
   */
  @SuppressWarnings("unchecked")
  public <X> X getConfig() {
    return (X) config;
  }

  /**
   * Returns the data from the load request.
   * 
   * @param <X> the data type
   * @return the data
   */
  @SuppressWarnings("unchecked")
  public <X> X getData() {
    return (X) data;
  }

}

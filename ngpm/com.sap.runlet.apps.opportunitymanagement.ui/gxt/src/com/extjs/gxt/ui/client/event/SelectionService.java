/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * Provides a selection service where <code>SelectionProviders</code> can
 * register, allowing any listeners to be notified of selection events.
 */
public class SelectionService {

  private static SelectionService instance = new SelectionService();

  /**
   * Returns the singleton instance.
   * 
   * @return the service
   */
  public static SelectionService get() {
    return instance;
  }

  private SelectionChangedListener<ModelData> listener;
  private List<SelectionProvider<ModelData>> providers;
  private List<SelectionChangedListener<ModelData>> listeners;

  private SelectionService() {
    listener = new SelectionChangedListener<ModelData>() {
      public void selectionChanged(SelectionChangedEvent<ModelData> event) {
        onSelectionChanged(event);
      }
    };
    listeners = new ArrayList<SelectionChangedListener<ModelData>>();
    providers = new ArrayList<SelectionProvider<ModelData>>();
  }

  /**
   * Adds a listener to be notified of selection events from any registered
   * selection providers.
   * 
   * @param listener the listener to add
   */
  @SuppressWarnings("unchecked")
  public void addListener(SelectionChangedListener<? extends ModelData> listener) {
    listeners.add((SelectionChangedListener)listener);
  }

  /**
   * Returns a list of all current listeners.
   * 
   * @return the listeners
   */
  public List<SelectionChangedListener<ModelData>> getListeners() {
    return new ArrayList<SelectionChangedListener<ModelData>>(listeners);
  }

  /**
   * Returns the list of current providers.
   * 
   * @return the providers
   */
  public List<SelectionProvider<ModelData>> getProviders() {
    return new ArrayList<SelectionProvider<ModelData>>(providers);
  }

  /**
   * Registers a selection provider.
   * 
   * @param provider the provider to add
   */
  public void register(SelectionProvider<ModelData> provider) {
    provider.addSelectionChangedListener(listener);
    providers.add(provider);
  }

  /**
   * Removes a previously added listener.
   * 
   * @param listener the listener to remove
   */
  public void removeListener(SelectionChangedListener<? extends ModelData> listener) {
    listeners.remove(listener);
  }

  /**
   * Unregisters a selection provider.
   * 
   * @param provider the provider to unregister
   */
  public void unregister(SelectionProvider<ModelData> provider) {
    provider.removeSelectionListener(listener);
    providers.remove(provider);
  }

  /**
   * Called when any selection changed event is received from any registered
   * providers.
   * 
   * @param event the selection changed event
   */
  protected void onSelectionChanged(SelectionChangedEvent<ModelData> event) {
    for (SelectionChangedListener<ModelData> l : listeners) {
      l.selectionChanged(event);
    }
  }
}

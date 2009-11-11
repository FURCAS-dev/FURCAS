/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.util.Util;

/**
 * Check change event type.
 * 
 * @param <M> the data type
 */
public class CheckChangedEvent<M extends ModelData> extends BaseEvent {

  private CheckProvider<M> provider;
  private List<M> selection;

  /**
   * Creates a new selection event.
   * 
   * @param provider the selection provider
   * @param selection the selection
   */
  @SuppressWarnings("unchecked")
  public CheckChangedEvent(CheckProvider<M> provider, M selection) {
    super(provider);
    this.provider = provider;
    this.selection = Util.createList(selection);
  }

  /**
   * Creates a new selection event.
   * 
   * @param provider the selection provider
   * @param selection the selection
   */
  public CheckChangedEvent(CheckProvider<M> provider, List<M> selection) {
    super(provider);
    this.provider = provider;
    this.selection = selection;
  }

  /**
   * Returns the checked selection.
   * 
   * @return the checked selection
   */
  public List<M> getCheckedSelection() {
    return selection;
  }

  /**
   * Returns the selection provider.
   * 
   * @return the provider
   */
  public CheckProvider<M> getCheckProvider() {
    return provider;
  }
}

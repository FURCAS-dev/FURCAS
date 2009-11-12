/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * Selection event type. A selection event is fired when the selection state of
 * a individual model changes. A <code>SelectionChangedEvent</code> is fired
 * when the overall selection state of a component changes.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @param <M> the model data type
 * 
 * @see SelectionChangedEvent
 */
public class SelectionEvent<M extends ModelData> extends BaseEvent {

  /**
   * The model.
   */
  private M model;

  /**
   * The index.
   */
  private int index;

  public SelectionEvent(Object source, M model) {
    super(source);
    this.model = model;
  }

  /**
   * Returns the model.
   * 
   * @return the model
   */
  public M getModel() {
    return model;
  }

  /**
   * Sets the model.
   * 
   * @param model the model
   */
  public void setModel(M model) {
    this.model = model;
  }

  /**
   * Returns the index.
   * 
   * @return the index
   */
  public int getIndex() {
    return index;
  }

  /**
   * Sets the index.
   * 
   * @param index
   */
  public void setIndex(int index) {
    this.index = index;
  }

}

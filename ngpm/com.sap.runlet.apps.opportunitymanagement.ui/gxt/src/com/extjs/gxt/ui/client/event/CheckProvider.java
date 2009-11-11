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

/**
 * Interface for objects that provide check state.
 * 
 * @param <M> the model type
 */
public interface CheckProvider<M extends ModelData> {

  /**
   * Returns the current checked selection.
   * 
   * @return the checked selection
   */
  public List<M> getCheckedSelection();

  /**
   * Returns true if the model is checked.
   * 
   * @param model the model
   * @return the check state
   */
  public boolean isChecked(M model);

  /**
   * Sets the current checked selection.
   * 
   * @param selection the checked selection
   */
  public void setCheckedSelection(List<M> selection);

  /**
   * Adds the check change listener.
   * 
   * @param listener the listener to be added
   */
  public void addCheckListener(CheckChangedListener<M> listener);

  /**
   * Removes the check change listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeCheckListener(CheckChangedListener<M> listener);

}

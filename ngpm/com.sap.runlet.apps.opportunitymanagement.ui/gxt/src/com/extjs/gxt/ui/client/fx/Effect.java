/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

/**
 * Effect interface defines the lifecyle methods for an effect.
 */
public interface Effect {

  /**
   * Fires after the effect is cancelled.
   */
  public void onCancel();

  /**
   * Fires after the effect is complete.
   */
  public void onComplete();

  /**
   * Fires after the effect is started.
   */
  public void onStart();

  /**
   * Fires after the effect is updated.
   * 
   * @param progress the progress betwee 0 and 1
   */
  public void onUpdate(double progress);
}

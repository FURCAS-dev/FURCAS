/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.Loader;

/**
 * Listener for <code>Loader</code> events.
 */
public class LoadListener implements Listener<LoadEvent> {

  public void handleEvent(LoadEvent e) {
    EventType type = e.getType();
    if (type == Loader.BeforeLoad) {
      loaderBeforeLoad(e);
    } else if (type == Loader.Load) {
      loaderLoad(e);
    } else if (type == Loader.LoadException) {
      loaderLoadException(e);
    }
  }

  /**
   * Fires before a load operation begins. Action can be cancelled by calling
   * {@link BaseEvent#setCancelled(boolean)}.
   * 
   * @param le the load event
   */
  public void loaderBeforeLoad(LoadEvent le) {

  }

  /**
   * Fires when an exception occurs during a load operation.
   * 
   * @param le the load event
   */
  public void loaderLoadException(LoadEvent le) {

  }

  /**
   * Fires after a load operation completes.
   * 
   * @param le the load event
   */
  public void loaderLoad(LoadEvent le) {

  }
}

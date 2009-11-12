/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.mvc;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MvcEvent;

/**
 * Event listener for dispatcher events.
 */
public class DispatcherListener implements Listener<MvcEvent> {

  public void handleEvent(MvcEvent e) {
    EventType type = e.getType();
    if (type == Dispatcher.BeforeDispatch) {
      beforeDispatch(e);
    } else if (type == Dispatcher.AfterDispatch) {
      afterDispatch(e);
    }
  }

  /**
   * Fires before an event is dispatched. Listeners can cancel the action by
   * calling {@link BaseEvent#setCancelled(boolean)}.
   * 
   * @param mvce the application event to be dispatched
   */
  public void beforeDispatch(MvcEvent mvce) {

  }

  /**
   * Fires after an event has been dispatched.
   * 
   * @param mvce the event that was dispatched
   */
  public void afterDispatch(MvcEvent mvce) {

  }

}

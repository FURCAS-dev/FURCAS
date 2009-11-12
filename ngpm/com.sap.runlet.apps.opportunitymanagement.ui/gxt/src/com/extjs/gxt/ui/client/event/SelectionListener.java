/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;


/**
 * Listener for components that can be "selected". Selection is a GXT application
 * event which should not be confused with the browser click event.
 */
public abstract class SelectionListener<E extends ComponentEvent> implements Listener<E> {

  public void handleEvent(E e) {
    EventType type = e.getType();
    if (type == Events.Select) {
      componentSelected(e);
    }
  }

  /**
   * Fires after a component is selected.
   * 
   * @param ce the component event
   */
  public abstract void componentSelected(E ce);

}

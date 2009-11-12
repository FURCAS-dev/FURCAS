/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentManager;

/**
 * Event type for ComponentManager.
 */
public class ComponentManagerEvent extends BaseEvent {

  /**
   * The component being registered or unregistered.
   */
  private Component component;

  public ComponentManagerEvent(ComponentManager manager, Component component) {
    super(manager);
    this.component = component;
  }

  /**
   * Returns the component being registered or unregistered.
   * 
   * @return the component
   */
  public Component getComponent() {
    return component;
  }

}

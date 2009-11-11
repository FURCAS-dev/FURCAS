/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

/**
 * Defines the interface for component plugins. Component will call the
 * {@link #init(Component)} method where each plugin can then call methods or
 * respond to events on the component as needed to provide its functionality.
 */
public interface ComponentPlugin {

  /**
   * Initializes the plugin when the component is created.
   * 
   * @param component the source component
   */
  public void init(Component component);

}

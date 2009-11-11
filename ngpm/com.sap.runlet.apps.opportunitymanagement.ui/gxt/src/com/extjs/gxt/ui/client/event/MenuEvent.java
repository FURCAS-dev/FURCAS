/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.menu.Menu;

/**
 * Menu event type.
 * 
 * <p/>Note: For a given event, only the fields which are appropriate will be
 * filled in. The appropriate fields for each event are documented by the event
 * source.
 * 
 * @see Menu
 */
public class MenuEvent extends ContainerEvent<Menu, Component> {

  public MenuEvent(Menu menu) {
    super(menu);
  }

  public MenuEvent(Menu container, Component component) {
    super(container, component);
  }

}

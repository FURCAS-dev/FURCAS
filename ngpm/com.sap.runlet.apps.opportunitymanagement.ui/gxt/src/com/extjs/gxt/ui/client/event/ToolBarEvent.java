/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

/**
 * ToolBar event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see ToolBar
 */
public class ToolBarEvent extends ContainerEvent<ToolBar, Component> {

  public ToolBarEvent(ToolBar toolBar, Component item) {
    super(toolBar, item);
  }

  public ToolBarEvent(ToolBar toolBar) {
    super(toolBar);
  }

}
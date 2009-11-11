/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Layout;

public class LayoutEvent extends BaseEvent {

  private Container<?> container;
  private Layout layout;

  public LayoutEvent(Container<?> container, Layout layout) {
    super(container);
    this.container = container;
    this.layout = layout;
  }

  public Container<?> getContainer() {
    return container;
  }

  public void setContainer(Container<?> container) {
    this.container = container;
  }

  public Layout getLayout() {
    return layout;
  }

  public void setLayout(Layout layout) {
    this.layout = layout;
  }
  
  
}

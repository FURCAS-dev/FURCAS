/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Layout;

/**
 * <code>CenterLayout</code> centers a single widget within its container.
 */
public class CenterLayout extends Layout {

  public CenterLayout() {
    monitorResize = true;
  }
  
  @Override
  protected void renderComponent(Component component, int index, El target) {
    super.renderComponent(component, index, target);
  }

  @Override
  protected void onLayout(Container<?> container, El target) {
    super.onLayout(container, target);
    Component c = container.getItem(0);
    if (c != null) {
      c.el().center(container.el().dom);
    }
  }
}

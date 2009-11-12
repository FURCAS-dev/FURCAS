/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.core.XDOM;
import com.google.gwt.user.client.Element;

/**
 * Adds a separator bar to a menu, used to divide logical groups of menu items.
 */
public class SeparatorMenuItem extends Item {

  /**
   * Creates a new separator menu item.
   */
  public SeparatorMenuItem() {
    hideOnClick = false;
  }

  @Override
  protected void onRender(Element target, int index) {
    Element span = XDOM.create("<span class=x-menu-sep>&#160;</span>");
    setElement(span, target, index);
    fly(target).addStyleName("x-menu-sep-li");
  }
}

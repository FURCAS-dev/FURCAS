/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.custom;

import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;

/**
 * A specialized content panel contained in a Portal.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>ContentPanel BeforeExpand</dd>
 * <dd>ContentPanel Expand</dd>
 * <dd>ContentPanel BeforeCollapse</dd>
 * <dd>ContentPanel Collapse</dd>
 * <dd>ContentPanel BeforeClose</dd>
 * <dd>ContentPanel Close</dd>
 * <dd>LayoutContainer AfterLayout</dd>
 * <dd>ScrollContainer Scroll</dd>
 * <dd>Container BeforeAdd</dd>
 * <dd>Container Add</dd>
 * <dd>Container BeforeRemove</dd>
 * <dd>Container Remove</dd>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 */
public class Portlet extends ContentPanel {

  private boolean pinned = false;

  public Portlet() {
    this(new FlowLayout());
    addStyleName("x-portlet");
  }

  public Portlet(Layout layout) {
    super(layout);
    setFrame(true);
    getHeader().setStyleAttribute("cursor", "move");
    setBodyStyle("backgroundColor: white;");
  }

  /**
   * True to "pin" the porlet and stop the user from being able to move the
   * portlet (defauls to false).
   * 
   * @param pinned true for pinned
   */
  public void setPinned(boolean pinned) {
    this.pinned = pinned;
    String c = pinned ? "default" : "move";
    getHeader().setStyleAttribute("cursor", c);
    if (getData("gxt.draggable") != null) {
      Draggable d = (Draggable) getData("gxt.draggable");
      d.setEnabled(!pinned);
    }
  }

  /**
   * Returns true if the portal is pinned.
   * 
   * @return true if pinned
   */
  public boolean isPinned() {
    return pinned;
  }

}

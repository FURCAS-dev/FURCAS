/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.widget.layout.CardLayout;

/**
 * This container contains multiple widgets, each fit to the container, where
 * only a single widget can be visible at any given time. This style is most
 * commonly used for wizards, tab implementations, etc.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
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
public class CardPanel extends LayoutContainer {

  protected CardLayout layout;

  /**
   * Creates a new card panel.
   */
  public CardPanel() {
    layout = new CardLayout();
    setLayout(layout);
  }

  /**
   * Returns the active component.
   * 
   * @return the top widget
   */
  public Component getActiveItem() {
    return layout.getActiveItem();
  }

  /**
   * Returns true if deferred render.
   * 
   * @return the deferred render state
   */
  public boolean isDeferredRender() {
    return layout.isDeferredRender();
  }

  /**
   * Sets the active (visible) item in the layout.
   * 
   * @param component the active widget
   */
  public void setActiveItem(Component component) {
    layout.setActiveItem(component);
  }

  /**
   * Sets the deferred render state
   * 
   * @param deferredRender the deferredRender state
   */
  public void setDeferredRender(boolean deferredRender) {
    layout.setDeferredRender(deferredRender);
  }

}

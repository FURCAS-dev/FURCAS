/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Component;

/**
 * The base class for all items that render into menus. BaseItem provides
 * default rendering, activated state management.
 */
public abstract class Item extends Component {

  /**
   * True if this item can be visually activated (defaults to false).
   */
  protected boolean canActivate;

  /**
   * True to hide the containing menu after this item is clicked (defaults to
   * true).
   */
  protected boolean hideOnClick = true;

  /**
   * The item's containing menu.
   */
  protected Menu parentMenu;

  private String activeStyle = "x-menu-item-active";

  public Item() {
    disabledStyle = "x-item-disabled";
  }

  /**
   * Adds a selection listener.
   * 
   * @param listener the listener to add
   */
  public void addSelectionListener(SelectionListener<? extends MenuEvent> listener) {
    addListener(Events.Select, listener);
  }

  /**
   * Returns the active style.
   * 
   * @return the style
   */
  public String getActiveStyle() {
    return activeStyle;
  }

  /**
   * Returns the hide on click state.
   * 
   * @return the hide on click state
   */
  public boolean getHideOnClick() {
    return hideOnClick;
  }

  /**
   * Returns the item's containing menu.
   * 
   * @return the menu
   */
  public Menu getParentMenu() {
    return parentMenu;
  }

  /**
   * Removes a previously added listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeSelectionListener(SelectionListener<? extends ComponentEvent> listener) {
    removeListener(Events.Select, listener);
  }

  /**
   * The CSS class to use when the item becomes activated (defaults to
   * "x-menu-item-active").
   * 
   * @param activeStyle the active style
   */
  public void setActiveStyle(String activeStyle) {
    this.activeStyle = activeStyle;
  }

  /**
   * True to hide the containing menu after this item is clicked (defaults to
   * true).
   * 
   * @param hideOnClick true to hide, otherwise false
   */
  public void setHideOnClick(boolean hideOnClick) {
    this.hideOnClick = hideOnClick;
  }

  protected void activate(boolean autoExpand) {
    if (disabled) {
      return;
    }
    
    El li = el().getParent();
    li.addStyleName(activeStyle);
    MenuEvent me = new MenuEvent(parentMenu);
    me.setItem(this);
    fireEvent(Events.Activate, me);
  }

  protected void deactivate() {
    El li = el().getParent();
    li.removeStyleName(activeStyle);
    MenuEvent me = new MenuEvent(parentMenu);
    me.setItem(this);
    fireEvent(Events.Deactivate, me);
  }

  protected void expandMenu(boolean autoActivate) {

  }

  protected void handleClick(ComponentEvent be) {
    if (hideOnClick && parentMenu != null) {
      parentMenu.hide(true);
    }
  }

  protected void onClick(ComponentEvent be) {
    MenuEvent me = new MenuEvent(parentMenu);
    me.setItem(this);
    if (!disabled && fireEvent(Events.Select, me)) {
      handleClick(be);
    }
  }

  @Override
  protected void onDisable() {
    super.onDisable();
    El li = el().getParent();
    if (li != null) {
      li.addStyleName(disabledStyle);
    }
  }

  @Override
  protected void onEnable() {
    super.onEnable();
    El li = el().getParent();
    if (li != null) {
      li.removeStyleName(disabledStyle);
    }
  }

  protected boolean shouldDeactivate(ComponentEvent ce) {
    return true;
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.IconSupport;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * A base class for all menu items that require menu-related functionality (like
 * sub-menus) and are not static display items. Item extends the base
 * functionality of {@link Item} by adding menu-specific activation and click
 * handling.
 */
public class MenuItem extends Item implements IconSupport {

  protected Menu subMenu;
  protected String itemStyle = "x-menu-item";
  protected AbstractImagePrototype icon;
  protected String text;

  /**
   * Creates a new item.
   */
  public MenuItem() {
    canActivate = true;
  }

  /**
   * Creates a new item with the given text.
   * 
   * @param text the item's text
   */
  public MenuItem(String text) {
    this();
    this.text = text;
  }

  /**
   * Creates a new item.
   * 
   * @param text the item text
   * @param listener the selection listener
   */
  public MenuItem(String text, SelectionListener<? extends MenuEvent> listener) {
    this(text);
    addSelectionListener(listener);
  }

  /**
   * Creates a new item.
   * 
   * @param text the item's text
   * @param icon the item's icon
   */
  public MenuItem(String text, AbstractImagePrototype icon) {
    this(text);
    setIcon(icon);
  }

  /**
   * Creates a new item.
   * 
   * @param text the item's text
   * @param icon the item's icon
   * @param listener the selection listener
   */
  public MenuItem(String text, AbstractImagePrototype icon,
      SelectionListener<? extends MenuEvent> listener) {
    this(text, icon);
    addSelectionListener(listener);
  }

  /**
   * Expands the item's sub menu.
   */
  public void expandMenu() {
    if (isEnabled() && subMenu != null) {
      subMenu.setFocusOnShow(true);
      subMenu.show(el().dom, "tl-tr?");
    }
  }

  /**
   * Returns the item's icon style.
   * 
   * @return the icon style
   */
  public AbstractImagePrototype getIcon() {
    return icon;
  }

  /**
   * Returns the item's sub menu.
   * 
   * @return the sub menu
   */
  public Menu getSubMenu() {
    return subMenu;
  }

  /**
   * Returns the item's text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the item's icon style. The style name should match a CSS style that
   * specifies a background image using the following format:
   * 
   * <pre>
   * &lt;code&gt;
   * .my-icon {
   *    background: url(images/icons/my-icon.png) no-repeat center left !important;
   * }
   * &lt;/code&gt;
   * </pre>
   * 
   * @param icon the icon
   */
  public void setIcon(AbstractImagePrototype icon) {
    if (rendered) {
      
      if (el().selectNode("img") != null) {
        el().selectNode("img").remove();
      }
      if (icon != null) {
        Element e = icon.createElement().cast();
        El.fly(e).addStyleName("x-menu-item-icon");
        el().insertChild(e, 0);
      }
    }
    this.icon = icon;
  }

  public void setIconStyle(String icon) {
    setIcon(IconHelper.create(icon));
  }

  /**
   * Sets the item's sub menu.
   * 
   * @param menu the sub menu
   */
  public void setSubMenu(Menu menu) {
    this.subMenu = menu;
    menu.parentItem = this;

  }

  /**
   * Sets the item's text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
    if (rendered) {
      el().removeChildren();
      el().update(text == null || (text != null && text.equals("")) ? "&#160;" : text);
      setIcon(icon);
    }
  }

  @Override
  protected void activate(boolean autoExpand) {
    super.activate(autoExpand);
    if (autoExpand && subMenu != null) {
      expandMenu();
    }
  }

  @Override
  protected void expandMenu(boolean autoActivate) {
    if (!disabled && subMenu != null) {
      if (!subMenu.isVisible()) {
        expandMenu();
        subMenu.tryActivate(0, 1);
      }
    }
  }

  @Override
  protected void afterRender() {
    super.afterRender();
    setText(text);
  }

  @Override
  protected void deactivate() {
    super.deactivate();
    if (subMenu != null && subMenu.isVisible()) {
      subMenu.hide();
    }
  }

  @Override
  protected void onHide() {
    super.onHide();
    el().getParent().setVisible(false);
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createAnchor(), target, index);

    if (GXT.isAriaEnabled()) {
      Accessibility.setRole(getElement(), Accessibility.ROLE_MENUITEM);
    } else {
      getElement().setPropertyString("href", "#");
    }

    String s = itemStyle + (subMenu != null ? " x-menu-item-arrow" : "");
    setStyleName(s);

    setText(text);

    if (subMenu != null) {
      Accessibility.setState(getElement(), "aria-haspopup", "true");
    }

  }

  @Override
  protected void onShow() {
    super.onShow();
    el().getParent().setVisible(true);
  }

  @Override
  protected boolean shouldDeactivate(ComponentEvent ce) {
    if (super.shouldDeactivate(ce)) {
      if (subMenu != null && subMenu.isVisible()) {
        return !subMenu.el().getBounds().contains(ce.getXY());
      }
    }
    return true;
  }

}

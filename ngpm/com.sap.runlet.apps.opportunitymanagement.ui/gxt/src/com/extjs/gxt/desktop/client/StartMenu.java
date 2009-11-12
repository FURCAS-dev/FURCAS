/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.desktop.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.menu.Item;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A start menu component. Menu items can be added to the main region of the
 * start menu, or to the "tool" area, which is located to the right.
 */
public class StartMenu extends Menu {

  private List<Item> tools = new ArrayList<Item>();;
  private String heading;
  private String iconStyle;
  private El header, headerText, menuBWrap, menuPanel, toolsPanel;

  public StartMenu() {
    addStyleName("ux-start-menu");
    setWidth(300);
  }

  /**
   * Adds a item to the "tool" area of the start menu.
   * 
   * @param item the item to add
   */
  public void addTool(Item item) {
    tools.add(item);
  }

  /**
   * Adds a seperator to the "too" area.
   */
  public void addToolSeperator() {
    SeparatorMenuItem sep = new SeparatorMenuItem();
    sep.setStyleName("ux-toolmenu-sep");
    addTool(sep);
  }

  /**
   * Returns the start menu's heading.
   * 
   * @return the heading
   */
  public String getHeading() {
    return heading;
  }

  /**
   * Returns the menu's icon style.
   * 
   * @return the icon style
   */
  public String getIconStyle() {
    return iconStyle;
  }

  /**
   * Sets the menu's heading text.
   * 
   * @param heading the heading
   */
  public void setHeading(String heading) {
    this.heading = heading;
    if (rendered) {
      headerText.setInnerHtml(heading);
    }
  }

  /**
   * Sets the menu's icon style.
   * 
   * @param iconStyle the icon style
   */
  public void setIconStyle(String iconStyle) {
    this.iconStyle = iconStyle;
  }

  @Override
  public void show(Element elem, String pos) {
    super.show(elem, pos);
    int tPanelWidth = 100;
    Rectangle box = menuBWrap.getBounds();
    menuPanel.setWidth(box.width - tPanelWidth, true);
    menuPanel.setHeight(box.height, true);
    toolsPanel.setWidth(tPanelWidth, true);
    toolsPanel.setHeight(box.height, true);
    toolsPanel.alignTo(menuPanel.dom, "tl-tr", null);
  }

  @Override
  public Component findItem(Element elem) {
    Component item = super.findItem(elem);
    if (item == null) {
      for (Item c : tools) {
        if (DOM.isOrHasChild(c.getElement(), elem)) {
          return c;
        }
      }
    } else {
      return item;
    }
    return null;
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    for (Item item : tools) {
      ComponentHelper.doAttach(item);
    }
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    for (Item item : tools) {
      ComponentHelper.doDetach(item);
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    el().setStyleName("x-menu ux-start-menu");
    
    El tl = el().createChild("<div class='ux-start-menu-tl'></div>");
    El tr = tl.createChild("<div class='ux-start-menu-tr'></div>");
    El tc = tr.createChild("<div class='ux-start-menu-tc'></div>");
    header = tc.createChild("<div class='x-window-header x-unselectable x-panel-icon "
        + iconStyle + "'></div>");
    headerText = header.createChild("<span class='x-window-header-text'></span>");
    headerText.setInnerHtml(heading);

    El bwrap = el().createChild("<div class='x-window-bwrap'></div>");

    El ml = bwrap.createChild("<div class='ux-start-menu-ml'></div>");
    El mc = ml.createChild("<div class='x-window-mc ux-start-menu-bwrap' style='border:none'></div>");

    El bl = bwrap.createChild("<div class='ux-start-menu-bl x-panel-nofooter'></div>");
    El br = bl.createChild("<div class='ux-start-menu-br'></div>");
    br.createChild("<div class='ux-start-menu-bc'></div>");

    menuBWrap = mc.createChild("<div class='x-window-body ux-start-menu-body' style='position:relative;border: none'></div>");
    menuBWrap.setHeight(300);

    menuPanel = menuBWrap.createChild("<div class='x-panel x-border-panel ux-start-menu-apps-panel' style='border: none;padding: 2px'></div>");
    toolsPanel = menuBWrap.createChild("<div class='x-panel x-border-panel ux-start-menu-tools-panel' style='padding: 2px'></div>");

    ul = menuPanel.createChild("<ul class='x-menu-list'></ul>");
    El toolsUl = toolsPanel.createChild("<ul class='x-menu-list'></ul>");

    for (Item item : tools) {
      Element li = DOM.createElement("li");
      li.setClassName("x-menu-list-item");
      toolsUl.dom.appendChild(li);
      item.render(li);
      item.addSelectionListener(new SelectionListener<MenuEvent>() {

        @Override
        public void componentSelected(MenuEvent ce) {
          hide();
        }
      });
    }

    eventPreview.getIgnoreList().add(getElement());
    sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS | Event.KEYEVENTS);
  }
  
  public El getFocusEl() {
    return el();
  }
  
  @Override
  public El getLayoutTarget() {
    return menuPanel.firstChild();
  }

}
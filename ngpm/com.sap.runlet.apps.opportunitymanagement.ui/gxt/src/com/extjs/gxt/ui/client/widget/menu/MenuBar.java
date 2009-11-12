/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.aria.FocusFrame;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.widget.Container;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * A horizontal menu bar.
 */
public class MenuBar extends Container<MenuBarItem> {

  private MenuBarItem active;

  public MenuBar() {
    baseStyle = "x-menubar";
    enableLayout = true;
    attachChildren = false;
  }

  @Override
  public boolean add(MenuBarItem item) {
    return super.add(item);
  }

  @Override
  public boolean insert(MenuBarItem item, int index) {
    return super.insert(item, index);
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);

    int type = ce.getEventTypeInt();
    switch (type) {
      case Event.ONMOUSEOVER:
        onMouseOver(ce);
        break;
      case Event.ONMOUSEOUT:
        onMouseOut(ce);
        break;
      case Event.ONCLICK:
        onClick(ce);
        break;
      case Event.ONFOCUS:
        if (active == null && getItemCount() > 0) {
          setActiveItem(getItem(0), false);
        }
        break;
      case Event.ONBLUR:
        if (active != null && !active.expanded) {
          onDeactivate(active);
        }
        break;
    }
  }

  @Override
  public boolean remove(MenuBarItem item) {
    return super.remove(item);
  }

  /**
   * Sets the active item.
   * 
   * @param item the item to activate
   * @param expand true to expand the item's menu
   */
  public void setActiveItem(MenuBarItem item, boolean expand) {
    if (active != item) {
      if (active != null) {
        onDeactivate(active);
      }
      onActivate(item);
      
      if (GXT.isAriaEnabled()) {
        FocusFrame.get().frame(active);
      }
      
      if (expand) {
        expand(item);
      }
    }
  }

  /**
   * Toggles the given item.
   * 
   * @param item the item to toggle
   */
  public void toggle(MenuBarItem item) {
    if (item == active) {
      if (item.expanded) {
        collapse(item);
      } else {
        expand(item);
      }
    } else {
      setActiveItem(item, true);
    }
  }

  protected void collapse(MenuBarItem item) {
    item.menu.hide();
    item.expanded = false;
  }

  protected void expand(MenuBarItem item) {
    item.menu.setFocusOnShow(false);
    item.menu.show(item.getElement(), "tl-bl", new int[] {0, 1});
    item.expanded = true;
  }

  protected void onActivate(MenuBarItem item) {
    active = item;
    Accessibility.setState(getElement(), "aria-activedescendant", item.getId());
    item.addStyleName(item.getBaseStyle() + "-active");
    item.addStyleName(item.getBaseStyle() + "-over");
  }

  protected void onDeactivate(MenuBarItem item) {
    if (item.expanded = true) {
      item.menu.hide();
      item.expanded = false;
    }

    item.removeStyleName(item.getBaseStyle() + "-active");
    item.removeStyleName(item.getBaseStyle() + "-over");
    
    FocusFrame.get().unframe();

    if (active == item) {
      active = null;
    }
  }

  @Override
  protected void onInsert(final MenuBarItem item, int index) {
    super.onInsert(item, index);
    item.menu.addListener(Events.Hide, new Listener<MenuEvent>() {
      public void handleEvent(MenuEvent be) {
        onDeactivate(item);
        focus();
        setActiveItem(item, false);
      }
    });
    item.menu.addListener(Events.AutoHide, new Listener<MenuEvent>() {
      public void handleEvent(MenuEvent be) {
        if (item.getElement().isOrHasChild(be.getTarget())) {
          be.setCancelled(true);
        }
      }
    });
  }

  protected void onKeyPress(ComponentEvent ce) {
    switch (ce.getKeyCode()) {
      case KeyCodes.KEY_DOWN:
        onDown(ce);
        break;
      case KeyCodes.KEY_LEFT:
        onLeft(ce);
        break;
      case KeyCodes.KEY_RIGHT:
        onRight(ce);
        break;
    }
  }

  protected void onLeft(ComponentEvent ce) {
    if (active != null && getItemCount() > 1) {
      int idx = indexOf(active);
      if (idx != 0) {
        setActiveItem(getItem(idx - 1), true);
      } else {
        setActiveItem(getItem(getItemCount() - 1), true);
      }
    }
  }

  protected void onMouseOver(ComponentEvent ce) {
    MenuBarItem item = findItem(ce.getTarget());
    if (item != null && item != active) {
      setActiveItem(item, active != null && active.expanded);
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createDiv(), target, index);

    el().setTabIndex(0);
    el().setElementAttribute("hideFocus", "true");

    if (GXT.isAriaEnabled()) {
      Accessibility.setRole(getElement(), Accessibility.ROLE_MENUBAR);
    }

    new KeyNav<ComponentEvent>(this) {
      @Override
      public void onKeyPress(ComponentEvent ce) {
        MenuBar.this.onKeyPress(ce);
      }
    };
    
    layout();
    
    sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS | Event.ONFOCUS | Event.ONBLUR);
  }

  @Override
  protected void onResize(int width, int height) {

  }

  protected void onRight(ComponentEvent ce) {
    if (active != null && getItemCount() > 1) {
      int idx = indexOf(active);
      if (idx != getItemCount() - 1) {
        setActiveItem(getItem(idx + 1), true);
      } else {
        setActiveItem(getItem(0), true);
      }
    }
  }

  private void onClick(ComponentEvent ce) {
    ce.stopEvent();
    MenuBarItem item = findItem(ce.getTarget());
    if (item != null) {
      toggle(item);
    }
  }

  private void onDown(ComponentEvent ce) {
    if (active != null && getItemCount() > 0) {
      if (active.expanded) {
        active.menu.focus();
        active.menu.setActiveItem(active.menu.getItem(0), false);
      } else {
        expand(active);
      }
    }
  }

  private void onMouseOut(ComponentEvent ce) {
    MenuBarItem item = findItem((Element) ce.getEvent().getRelatedEventTarget().cast());
    if (item == null && active != null && !active.expanded) {
      onDeactivate(active);
    }
  }
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.aria.FocusFrame;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ClickRepeaterEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.PreviewEvent;
import com.extjs.gxt.ui.client.util.BaseEventPreview;
import com.extjs.gxt.ui.client.util.ClickRepeater;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.layout.MenuLayout;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Accessibility;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A menu component.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeShow</b> : MenuEvent(container)<br>
 * <div>Fires before this menu is displayed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Show</b> : MenuEvent(container)<br>
 * <div>Fires after this menu is displayed.</div>
 * <ul>
 * <li>container : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeHide</b> : MenuEvent(container)<br>
 * <div>Fired before the menu is hidden. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Hide</b> : MenuEvent(container)<br>
 * <div>Fires after this menu is hidden.</div>
 * <ul>
 * <li>container : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeAdd</b> : MenuEvent(container, item, index)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : MenuEvent(container, item)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : MenuEvent(container, item, index)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : MenuEvent(container, item)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
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
public class Menu extends Container<Component> {

  protected KeyNav<ComponentEvent> keyNav;
  protected Item parentItem;
  protected BaseEventPreview eventPreview;
  protected boolean plain;
  protected boolean showSeparator = true;
  protected El ul;

  private String subMenuAlign = "tl-tr?";
  private String defaultAlign = "tl-bl?";

  private int minWidth = 120;
  private Item activeItem;
  private boolean showing;
  private boolean constrainViewport = true;
  private El focusEl;
  private boolean focusOnShow = true;
  private int maxHeight = Style.DEFAULT;
  private boolean enableScrolling = true;
  private int scrollIncrement = 24;
  private int scrollerHeight = 8;
  private int activeMax;

  /**
   * Creates a new menu.
   */
  public Menu() {
    baseStyle = "x-menu";
    shim = true;
    monitorWindowResize = true;
    setShadow(true);
    setLayoutOnChange(true);

    enableLayout = true;
    setLayout(new MenuLayout());
    eventPreview = new BaseEventPreview() {
      @Override
      protected boolean onAutoHide(PreviewEvent pe) {
        return Menu.this.onAutoHide(pe);
      }

      @Override
      protected void onPreviewKeyPress(PreviewEvent pe) {
        super.onPreviewKeyPress(pe);
        if (pe.getKeyCode() == KeyCodes.KEY_ESCAPE) {
          hide(true);
        }
      }
    };
  }

  /**
   * Adds a item to the menu.
   * 
   * @param item the new item
   */
  @Override
  public boolean add(Component item) {
    return super.add(item);
  }

  /**
   * Returns the default alignment.
   * 
   * @return the default align
   */
  public String getDefaultAlign() {
    return defaultAlign;
  }

  public El getFocusEl() {
    return focusEl;
  }

  @Override
  public El getLayoutTarget() {
    return ul;
  }

  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   * Returns the menu's minimum width.
   * 
   * @return the width
   */
  public int getMinWidth() {
    return minWidth;
  }

  /**
   * Returns the menu's parent item.
   * 
   * @return the parent item
   */
  public Item getParentItem() {
    return parentItem;
  }

  /**
   * Returns the sub menu alignment.
   * 
   * @return the alignment
   */
  public String getSubMenuAlign() {
    return subMenuAlign;
  }

  /**
   * Hides the menu.
   */
  public void hide() {
    hide(false);
  }

  /**
   * Hides this menu and optionally all parent menus
   * 
   * @param deep true to close all parent menus
   * @return this
   */
  public Menu hide(boolean deep) {
    if (showing) {
      MenuEvent me = new MenuEvent(this);
      if (fireEvent(Events.BeforeHide, me)) {
        if (activeItem != null) {
          activeItem.deactivate();
          activeItem = null;
        }
        onHide();
        RootPanel.get().remove(this);
        eventPreview.remove();
        showing = false;
        hidden = true;
        fireEvent(Events.Hide, me);
      }
      if (deep && parentItem != null) {
        parentItem.parentMenu.hide(true);
      }
    }
    return this;
  }

  /**
   * Inserts an item into the menu.
   * 
   * @param item the item to insert
   * @param index the insert location
   */
  @Override
  public boolean insert(Component item, int index) {
    if (item instanceof Item) {
      ((Item) item).parentMenu = this;
    }
    return super.insert(item, index);
  }

  /**
   * Returns true if constrain to viewport is enabled.
   * 
   * @return the constrain to viewport state
   */
  public boolean isConstrainViewport() {
    return constrainViewport;
  }

  public boolean isEnableScrolling() {
    return enableScrolling;
  }

  public boolean isFocusOnShow() {
    return focusOnShow;
  }

  @Override
  public boolean isVisible() {
    return showing;
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    switch (ce.getEventTypeInt()) {
      case Event.ONCLICK:
        onClick(ce);
        break;
      case Event.ONMOUSEOVER:
        onMouseOver(ce);
        break;
      case Event.ONMOUSEOUT:
        onMouseOut(ce);
        break;
      case Event.ONMOUSEWHEEL:
        if (enableScrolling) {
          scrollMenu(ce.getEvent().getMouseWheelVelocityY() < 0);
        }
    }
    El t = ce.getTargetEl();
    if (enableScrolling && t.is(".x-menu-scroller")) {
      switch (ce.getEventTypeInt()) {
        case Event.ONMOUSEOVER:
          deactiveActiveItem();
          onScrollerIn(t);
          break;
        case Event.ONMOUSEOUT:
          onScrollerOut(t);
          break;
      }
    }
  }

  /**
   * Removes a item from the menu.
   * 
   * @param item the menu to remove
   */
  @Override
  public boolean remove(Component item) {
    return super.remove(item);
  }

  /**
   * Sets whether the menu should be constrained to the viewport when shown.
   * Only applies when using {@link #showAt(int, int)}.
   * 
   * @param constrainViewport true to contrain
   */
  public void setConstrainViewport(boolean constrainViewport) {
    this.constrainViewport = constrainViewport;
  }

  /**
   * Sets the default {@link El#alignTo} anchor position value for this menu
   * relative to its element of origin (defaults to "tl-bl?").
   * 
   * @param defaultAlign the default align
   */
  public void setDefaultAlign(String defaultAlign) {
    this.defaultAlign = defaultAlign;
  }

  public void setEnableScrolling(boolean enableScrolling) {
    this.enableScrolling = enableScrolling;
  }

  public void setFocusOnShow(boolean focusOnShow) {
    this.focusOnShow = focusOnShow;
  }

  public void setMaxHeight(int maxHeight) {
    this.maxHeight = maxHeight;
  }

  /**
   * Sets he minimum width of the menu in pixels (defaults to 120).
   * 
   * @param minWidth the min width
   */
  public void setMinWidth(int minWidth) {
    this.minWidth = minWidth;
  }

  /**
   * The {@link El#alignTo} anchor position value to use for submenus of this
   * menu (defaults to "tl-tr-?").
   * 
   * @param subMenuAlign the sub alignment
   */
  public void setSubMenuAlign(String subMenuAlign) {
    this.subMenuAlign = subMenuAlign;
  }

  /**
   * Displays this menu relative to another element.
   * 
   * @param elem the element to align to
   * @param pos the {@link El#alignTo} anchor position to use in aligning to the
   *          element (defaults to defaultAlign)
   */
  public void show(Element elem, String pos) {
    show(elem, pos, new int[] {0, 0});
  }

  /**
   * Displays this menu relative to another element.
   * 
   * @param elem the element to align to
   * @param pos the {@link El#alignTo} anchor position to use in aligning to the
   *          element (defaults to defaultAlign)
   * @param offsets the menu align offsets
   */
  public void show(Element elem, String pos, int[] offsets) {
    MenuEvent me = new MenuEvent(this);
    if (fireEvent(Events.BeforeShow, me)) {
      RootPanel.get().add(this);

      showing = true;
      el().makePositionable(true);

      onShow();
      el().updateZIndex(0);
      // autoSizing when visible
      layout();
      el().alignTo(elem, pos, offsets);

      if (enableScrolling) {
        constrainScroll(el().getY());
      }
      el().show();

      eventPreview.add();

      if (focusOnShow) {
        focus();
      }

      fireEvent(Events.Show, me);
    }
  }

  /**
   * Displays this menu relative to the widget using the default alignment.
   * 
   * @param widget the align widget
   */
  public void show(Widget widget) {
    show(widget.getElement(), defaultAlign);
  }

  /**
   * Displays this menu at a specific xy position.
   * 
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public void showAt(int x, int y) {
    MenuEvent me = new MenuEvent(this);
    if (fireEvent(Events.BeforeShow, me)) {
      RootPanel.get().add(this);
      showing = true;
      el().makePositionable(true);

      onShow();
      el().updateZIndex(0);
      // autoSizing when visible
      layout();

      if (constrainViewport) {
        Point p = el().adjustForConstraints(new Point(x, y));
        x = p.x;
        y = p.y;
      }
      setPagePosition(x + XDOM.getBodyScrollLeft(), y + XDOM.getBodyScrollTop());
      if (enableScrolling) {
        constrainScroll(y);
      }

      el().show();
      eventPreview.add();

      if (focusOnShow) {
        focus();
      }

      fireEvent(Events.Show, me);
    }
  }

  protected void constrainScroll(int y) {
    int full = ul.setHeight("auto").getHeight();

    int max = maxHeight != Style.DEFAULT ? maxHeight : (XDOM.getViewHeight(false) - y);
    if (full > max && max > 0) {
      activeMax = max - 10 - scrollerHeight * 2;
      ul.setHeight(activeMax, true);
      createScrollers();
    } else {
      ul.setHeight(full, true);
      NodeList<Element> nodes = el().select(".x-menu-scroller");
      for (int i = 0; i < nodes.getLength(); i++) {
        fly(nodes.getItem(i)).hide();
      }
    }
    ul.setScrollTop(0);
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new MenuEvent(this);
  }

  @Override
  protected ContainerEvent<Menu, Component> createContainerEvent(Component item) {
    return new MenuEvent(this, item);
  }

  protected void createScrollers() {

    if (el().select(".x-menu-scroller").getLength() == 0) {
      Listener<ClickRepeaterEvent> listener = new Listener<ClickRepeaterEvent>() {
        public void handleEvent(ClickRepeaterEvent be) {
          onScroll(be);
        }
      };

      El scroller;

      scroller = new El(DOM.createDiv());
      scroller.addStyleName("x-menu-scroller", "x-menu-scroller-top");
      scroller.setInnerHtml("&nbsp;");
      ClickRepeater cr = new ClickRepeater(scroller);
      cr.doAttach();
      cr.addListener(Events.OnClick, listener);
      addAttachable(cr);

      el().insertFirst(scroller.dom);

      scroller = new El(DOM.createDiv());
      scroller.addStyleName("x-menu-scroller", "x-menu-scroller-bottom");
      scroller.setInnerHtml("&nbsp;");
      cr = new ClickRepeater(scroller);
      cr.doAttach();
      cr.addListener(Events.OnClick, listener);
      addAttachable(cr);

      el().appendChild(scroller.dom);
    }
  }

  protected void deactiveActiveItem() {
    if (activeItem != null) {
      activeItem.deactivate();
      activeItem = null;
    }
  }

  protected boolean onAutoHide(PreviewEvent pe) {
    if (pe.within(getElement()) || pe.getTarget(".x-menu", 20) != null) {
      return false;
    }
    MenuEvent me = new MenuEvent(this);
    me.setEvent(pe.getEvent());
    if (fireEvent(Events.AutoHide, me)) {
      hide(true);
      return true;
    }
    return false;
  }

  protected void onClick(ComponentEvent ce) {
    ce.stopEvent();
    Component item = findItem(ce.getTarget());
    if (item != null && item instanceof Item) {
      ((Item) item).onClick(ce);
    }
  }

  @Override
  protected void onDetach() {
    super.onDetach();
    if (eventPreview != null) {
      eventPreview.remove();
    }
  }

  protected void onHide() {
    super.onHide();
    deactiveActiveItem();
  }

  protected void onMouseOut(ComponentEvent ce) {
    Component item = findItem(ce.getTarget());
    if (item != null) {
      if (item == activeItem && !ce.within(getElement()) && activeItem.shouldDeactivate(ce)) {
        deactiveActiveItem();
      }
    } else {
      if (activeItem != null && activeItem.shouldDeactivate(ce)) {
        deactiveActiveItem();
      }
    }
  }

  protected void onMouseOver(ComponentEvent ce) {
    Component c = findItem(ce.getTarget());
    if (c != null) {
      if (c instanceof Item) {
        Item item = (Item) c;
        if (item.canActivate && item.isEnabled()) {
          setActiveItem(item, true);
        }
      }
    }
  }

  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    el().makePositionable(true);
    super.onRender(target, index);

    keyNav = new KeyNav<ComponentEvent>(this) {
      public void onDown(ComponentEvent be) {
        if (tryActivate(indexOf(activeItem) + 1, 1) == null) {
          tryActivate(0, 1);
        }
      }

      public void onEnter(ComponentEvent be) {
        if (activeItem != null) {
          be.cancelBubble();
          activeItem.onClick(be);
        }
      }

      public void onLeft(ComponentEvent be) {
        hide();
        if (parentItem != null) {
          parentItem.parentMenu.focus();
          if (GXT.isAriaEnabled()) {
            FocusFrame.get().frame(parentItem);
          }
        }
      }

      public void onRight(ComponentEvent be) {
        if (activeItem != null) {

          activeItem.expandMenu(true);
        }
      }

      public void onUp(ComponentEvent be) {
        if (tryActivate(indexOf(activeItem) - 1, -1) == null) {
          tryActivate(getItemCount() - 1, -1);
        }
      }
    };

    focusEl = new El(DOM.createAnchor());
    focusEl.addStyleName("x-menu-focus");
    focusEl.setTabIndex(-1);

    getElement().appendChild(focusEl.dom);
    swallowEvent(Events.OnClick, focusEl.dom, true);

    ul = new El(DOM.createElement("ul"));
    ul.addStyleName(baseStyle + "-list");

    getElement().appendChild(ul.dom);

    // add menu to ignore list
    eventPreview.getIgnoreList().add(getElement());

    el().setTabIndex(0);
    el().setElementAttribute("hideFocus", "true");

    if (GXT.isAriaEnabled()) {
      Accessibility.setRole(getElement(), "menu");
      Accessibility.setRole(ul.dom, "presentation");
    }

    if (plain) {
      addStyleName("x-menu-plain");
    }
    if (!showSeparator) {
      addStyleName("x-menu-nosep");
    }

    sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS | Event.KEYEVENTS | Event.ONMOUSEWHEEL);
  }

  protected void onScroll(ClickRepeaterEvent ce) {
    El target = ce.getEl();
    boolean top = target.is(".x-menu-scroller-top");
    scrollMenu(top);

    if (top ? ul.getScrollTop() <= 0 : ul.getScrollTop() + activeMax >= ul.dom.getPropertyInt("scrollHeight")) {
      onScrollerOut(target);
    }

  }

  // private
  protected void onScrollerIn(El t) {
    boolean top = t.is(".x-menu-scroller-top");
    if (top ? ul.getScrollTop() > 0 : ul.getScrollTop() + this.activeMax < ul.dom.getPropertyInt("scrollHeight")) {
      t.addStyleName("x-menu-item-active", "x-menu-scroller-active");
    }
  }

  // private
  protected void onScrollerOut(El t) {
    t.removeStyleName("x-menu-item-active", "x-menu-scroller-active");
  }

  protected void onWindowResize(int width, int height) {
    hide(true);
  }

  protected void scrollMenu(boolean top) {
    ul.setScrollTop(ul.getScrollTop() + scrollIncrement * (top ? -1 : 1));

  }

  protected void setActiveItem(Component c, boolean autoExpand) {
    if (c instanceof Item) {
      Item item = (Item) c;
      if (item != activeItem) {
        deactiveActiveItem();

        this.activeItem = item;
        item.activate(autoExpand);
        item.el().scrollIntoView(ul.dom, false);
        focus();

        if (GXT.isAriaEnabled()) {
          FocusFrame.get().frame(item);
          Accessibility.setState(getElement(), "aria-activedescendant", item.getId());
        }

      } else if (autoExpand) {
        item.expandMenu(autoExpand);
      }
    }
  }

  protected Item tryActivate(int start, int step) {
    for (int i = start, len = getItemCount(); i >= 0 && i < len; i += step) {
      Component c = getItem(i);
      if (c instanceof Item) {
        Item item = (Item) c;
        if (item.canActivate && item.isEnabled()) {
          setActiveItem(item, false);
          return item;
        }
      }
    }
    return null;
  }
}

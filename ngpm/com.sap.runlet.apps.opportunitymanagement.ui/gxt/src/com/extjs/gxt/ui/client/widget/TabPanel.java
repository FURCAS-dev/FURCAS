/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.aria.FocusFrame;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FxEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.layout.CardLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * A basic tab container.
 * 
 * <pre>
 * TabPanel panel = new TabPanel();
 * panel.setResizeTabs(true);
 * panel.setEnableTabScroll(true);
 * panel.setAnimScroll(true);
 * 
 * TabItem item = new TabItem();
 * item.setClosable(true);
 * item.setText(&quot;Tab Item&quot;);
 * 
 * item.setLayout(new FitLayout());
 * item.add(new Label(&quot;Test Content&quot;));
 * 
 * panel.add(item);
 * </pre>
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeSelect</b> : TabPanelEvent(container, item)<br>
 * <div>Fires after an item is selected. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item about to be selected.</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Select</b> : TabPanelEvent(container, item)<br>
 * <div>Fires after a item is selected.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item that was selected</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeAdd</b> : TabPanelEvent(container, item, index)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : TabPanelEvent(container, item)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : TabPanelEvent(container, item, index)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : TabPanelEvent(container, item)<br>
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
public class TabPanel extends Container<TabItem> {

  /**
   * TabPanel messages.
   */
  public class TabPanelMessages {

    private String closeText = GXT.MESSAGES.tabPanelItem_closeText();
    private String closeOtherText = GXT.MESSAGES.tabPanelItem_closeOtherText();

    /**
     * Returns the close other text.
     * 
     * @return the close other text
     */
    public String getCloseOtherText() {
      return closeOtherText;
    }

    /**
     * Returns the close text.
     * 
     * @return the close text
     */
    public String getCloseText() {
      return closeText;
    }

    /**
     * Sets the close other text for the close context menu (defaults to 'Close
     * all other tabs').
     * 
     * @param closeOtherText the close other text
     */
    public void setCloseOtherText(String closeOtherText) {
      this.closeOtherText = closeOtherText;
    }

    /**
     * Sets the close text for the close context menu (default to 'Close this
     * tab').
     * 
     * @param closeText the close text
     */
    public void setCloseText(String closeText) {
      this.closeText = closeText;
    }

  }

  /**
   * Tab position enumeration.
   */
  public enum TabPosition {
    TOP, BOTTOM;
  }

  private class AccessStack {

    Stack<TabItem> stack = new Stack<TabItem>();

    void add(TabItem item) {
      if (stack.contains(item)) {
        stack.remove(item);
      }
      stack.add(item);
      if (stack.size() > 10) {
        stack.remove(0);
      }
    }

    void clear() {
      stack.clear();
    }

    TabItem next() {
      return stack.size() > 0 ? stack.pop() : null;
    }

    void remove(TabItem item) {
      stack.remove(item);
    }
  }

  /**
   * Default tab item template.
   */
  public static Template itemTemplate;

  protected Menu closeContextMenu;

  private boolean bodyBorder = true;
  private boolean border = true;
  private int tabMargin = 2;
  private int scrollIncrement = 100;
  private int minTabWidth = 30;
  private int scrollDuration = 150;
  private boolean resizeTabs = false;
  private TabPosition tabPosition = TabPosition.TOP;
  private int tabWidth = 120;
  private boolean tabScroll = false;
  private boolean autoSelect = true;
  private boolean animScroll = false;
  private TabItem activeItem;
  private El body, bar, stripWrap, strip;
  private El edge, scrollLeft, scrollRight;
  private CardLayout cardLayout;
  private boolean scrolling;
  private AccessStack stack;
  private boolean plain;
  private boolean closeMenu = false;
  private TabPanelMessages messages;

  /**
   * Creates a new tab panel.
   */
  public TabPanel() {
    baseStyle = "x-tab-panel";
    cardLayout = new CardLayout();
    setLayout(cardLayout);
    enableLayout = true;
    setMessages(new TabPanelMessages());
    setDeferHeight(true);
  }

  /**
   * Adds a tab item. Fires the <i>BeforeAdd</i> event before inserting, then
   * fires the <i>Add</i> event after the widget has been inserted.
   * 
   * @param item the item to be added
   */
  public boolean add(TabItem item) {
    return super.add(item);
  }

  /**
   * Searches for an item based on its id and optionally the item's text.
   * 
   * @param id the item id
   * @param checkText true to match the items id and text
   * @return the item
   */
  public TabItem findItem(String id, boolean checkText) {
    int count = getItemCount();
    for (int i = 0; i < count; i++) {
      TabItem item = getItem(i);
      if (item.getItemId().equals(id) || item.getId().equals(id) || (checkText && item.getText().equals(id))) {
        return item;
      }
    }
    return null;
  }

  /**
   * Returns true if scrolling is animated.
   * 
   * @return the anim scroll state
   */
  public boolean getAnimScroll() {
    return animScroll;
  }

  /**
   * Returns true if the body border is enabled.
   * 
   * @return the body border state
   */
  public boolean getBodyBorder() {
    return bodyBorder;
  }

  /**
   * Returns true if the border style is enabled.
   * 
   * @return the border style
   */
  public boolean getBorderStyle() {
    return border;
  }

  @Override
  public CardLayout getLayout() {
    return cardLayout;
  }

  @Override
  public El getLayoutTarget() {
    return body;
  }

  /**
   * Returns the tab panel messages.
   * 
   * @return the messages
   */
  public TabPanelMessages getMessages() {
    return messages;
  }

  /**
   * Returns the minimum tab width.
   * 
   * @return the minimum tab width
   */
  public int getMinTabWidth() {
    return minTabWidth;
  }

  /**
   * Returns true if tab resizing is enabled.
   * 
   * @return the tab resizing state
   */
  public boolean getResizeTabs() {
    return resizeTabs;
  }

  /**
   * Returns the scroll duration in milliseconds.
   * 
   * @return the duration
   */
  public int getScrollDuration() {
    return scrollDuration;
  }

  /**
   * Returns the current selection tab item.
   * 
   * @return the selected item
   */
  public TabItem getSelectedItem() {
    return activeItem;
  }

  /**
   * Returns the panel's tab margin.
   * 
   * @return the margin
   */
  public int getTabMargin() {
    return tabMargin;
  }

  /**
   * Returns the tab position.
   * 
   * @return the tab position
   */
  public TabPosition getTabPosition() {
    return tabPosition;
  }

  /**
   * Returns true if tab scrolling is enabled.
   * 
   * @return the tab scroll state
   */
  public boolean getTabScroll() {
    return tabScroll;
  }

  /**
   * Returns the default tab width.
   * 
   * @return the width
   */
  public int getTabWidth() {
    return tabWidth;
  }

  /**
   * Adds a tab item. Fires the <i>BeforeAdd</i> event before inserting, then
   * fires the <i>Add</i> event after the widget has been inserted.
   * 
   * @param item the item to be inserted
   * @param index the insert position
   */
  @Override
  public boolean insert(TabItem item, int index) {
    return super.insert(item, index);
  }

  /**
   * Returns true if auto select is enabled.
   * 
   * @return the auto select state
   */
  public boolean isAutoSelect() {
    return autoSelect;
  }

  /**
   * Returns true if close context menu is enabled.
   * 
   * @return the close menu state
   */
  public boolean isCloseContextMenu() {
    return closeMenu;
  }

  /**
   * Returns true if children items are rendered when first accessed.
   * 
   * @return true to defer rendering
   */
  public boolean isDeferredRender() {
    return cardLayout.isDeferredRender();
  }

  /**
   * Returns true if the tab strip will be rendered without a background.
   * 
   * @return the plain state
   */
  public boolean isPlain() {
    return plain;
  }

  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    if (ce.getEventTypeInt() == Event.ONCLICK) {
      El target = ce.getTargetEl();
      if (target.is(".x-tab-scroller-left")) {
        ce.cancelBubble();
        onScrollLeft();
      }
      if (target.is(".x-tab-scroller-right")) {
        ce.cancelBubble();
        onScrollRight();
      }
    }
    if (ce.getEventTypeInt() == Event.ONBLUR) {
      FocusFrame.get().unframe();
    }
    if (ce.getEventTypeInt() == Event.ONFOCUS) {
      if (activeItem != null) {
        FocusFrame.get().frame(activeItem.getHeader());
      }
    }

  }

  /**
   * Removes the tab item. Fires the <i>BeforeRemove</i> event before removing,
   * then fires the <i>Remove</i> event after the widget has been removed.
   * 
   * @param item the item to be removed
   */
  public boolean remove(TabItem item) {
    boolean removed = super.remove(item);
    if (removed) {
      if (stack != null) {
        stack.remove(item);
      }
      if (rendered) {
        if (item.header.isRendered()) {
          item.header.removeStyleName("x-tab-strip-active");
          strip.dom.removeChild(item.header.getElement());
          ComponentHelper.doDetach(item.header);
        }
        if (item == activeItem) {
          activeItem = null;
          TabItem next = this.stack.next();
          if (next != null) {
            setSelection(next);
          } else if (getItemCount() > 0) {
            setSelection(getItem(0));
          } else {
            getLayout().activeItem = null;
          }
        }
      }
      delegateUpdates();
    }

    return removed;
  }

  @Override
  public boolean removeAll() {
    int count = getItemCount();
    TabItem current = getSelectedItem();
    for (int i = count - 1; i >= 0; i--) {
      TabItem item = getItem(i);
      if (current != item) {
        remove(item);
      }
    }
    if (current != null) {
      remove(current);
    }
    return getItemCount() == 0;
  }

  /**
   * Scrolls to a particular tab if tab scrolling is enabled.
   * 
   * @param item the item to scroll to
   * @param animate true to animate the scroll
   */
  public void scrollToTab(TabItem item, boolean animate) {
    if (item == null) return;
    int pos = getScollPos();
    int area = getScrollArea();
    El itemEl = item.header.el();
    int left = itemEl.getOffsetsTo(stripWrap.dom).x + pos;
    int right = left + itemEl.getWidth();
    if (left < pos) {
      scrollTo(left, animate);
    } else if (right > (pos + area)) {
      scrollTo(right - area, animate);
    }
  }

  /**
   * True to animate tab scrolling so that hidden tabs slide smoothly into view
   * (defaults to true). Only applies when {@link #tabScroll} = true.
   * 
   * @param animScroll the anim scroll state
   */
  public void setAnimScroll(boolean animScroll) {
    this.animScroll = animScroll;
  }

  @Override
  public void setAutoHeight(boolean autoHeight) {
    super.setAutoHeight(autoHeight);
    for (TabItem item : getItems()) {
      item.setAutoHeight(autoHeight);
    }
  }

  /**
   * True to have the first item selected when the panel is displayed for the
   * first time if there is not selection (defaults to true).
   * 
   * @param autoSelect the auto select state
   */
  public void setAutoSelect(boolean autoSelect) {
    this.autoSelect = autoSelect;
  }

  /**
   * True to display an interior border on the body element of the panel, false
   * to hide it (defaults to true, pre-render).
   * 
   * @param bodyBorder the body border style
   */
  public void setBodyBorder(boolean bodyBorder) {
    this.bodyBorder = bodyBorder;
  }

  /**
   * True to display a border around the tabs (defaults to true).
   * 
   * @param border true for borders
   */
  public void setBorderStyle(boolean border) {
    this.border = border;
  }

  /**
   * True to show the close context menu (defaults to false).
   * 
   * @param closeMenu true to show it
   */
  public void setCloseContextMenu(boolean closeMenu) {
    this.closeMenu = closeMenu;
  }

  /**
   * True to render each child tab item when it accessed, false to render all
   * (defaults to true). Setting to false would be useful when using forms as
   * validation would need to be applied to all children even if they had not
   * been selected.
   * 
   * @param deferredRender true to defer rendering
   */
  public void setDeferredRender(boolean deferredRender) {
    cardLayout.setDeferredRender(deferredRender);
  }

  /**
   * Sets the tab panel messages.
   * 
   * @param messages the messages
   */
  public void setMessages(TabPanelMessages messages) {
    this.messages = messages;
  }

  /**
   * The minimum width in pixels for each tab when {@link #resizeTabs} = true
   * (defaults to 30).
   * 
   * @param minTabWidth the minimum tab width
   */
  public void setMinTabWidth(int minTabWidth) {
    this.minTabWidth = minTabWidth;
  }

  /**
   * True to render the tab strip without a background container image (defaults
   * to false, pre-render).
   * 
   * @param plain
   */
  public void setPlain(boolean plain) {
    assertPreRender();
    this.plain = plain;
  }

  /**
   * True to automatically resize each tab so that the tabs will completely fill
   * the tab strip (defaults to false). Setting this to true may cause specific
   * widths that might be set per tab to be overridden in order to fit them all
   * into view (although {@link #minTabWidth} will always be honored).
   * 
   * @param resizeTabs true to enable tab resizing
   */
  public void setResizeTabs(boolean resizeTabs) {
    this.resizeTabs = resizeTabs;
  }

  /**
   * Sets the number of milliseconds that each scroll animation should last
   * (defaults to 150).
   * 
   * @param scrollDuration the scroll duration
   */
  public void setScrollDuration(int scrollDuration) {
    this.scrollDuration = scrollDuration;
  }

  /**
   * Sets the number of pixels to scroll each time a tab scroll button is
   * pressed (defaults to 100, or if {@link #setResizeTabs(boolean)} = true, the
   * calculated tab width). Only applies when {@link #setTabScroll(boolean)} =
   * true.
   * 
   * @param scrollIncrement the scroll increment
   */
  public void setScrollIncrement(int scrollIncrement) {
    this.scrollIncrement = scrollIncrement;
  }

  /**
   * Sets the selected tab item. Fires the <i>BeforeSelect</i> event before
   * selecting, then fires the <i>Select</i> event after the widget has been
   * selected.
   * 
   * @param item the item to be selected
   */
  public void setSelection(TabItem item) {
    TabPanelEvent tpe = new TabPanelEvent(this, item);
    if (item == null || !fireEvent(Events.BeforeSelect, tpe)) {
      return;
    }

    if (!rendered) {
      activeItem = item;
      return;
    }

    if (activeItem != item) {
      if (activeItem != null) {
        activeItem.header.removeStyleName("x-tab-strip-active");
      }
      item.header.addStyleName("x-tab-strip-active");
      activeItem = item;
      stack.add(activeItem);
      cardLayout.setActiveItem(activeItem);

      if (scrolling) {
        scrollToTab(item, getAnimScroll());
      }

      focusTab(activeItem);

      fireEvent(Events.Select, tpe);
      item.fireEvent(Events.Select, tpe);
    }
  }

  /**
   * The number of pixels of space to calculate into the sizing and scrolling of
   * tabs (defaults to 2).
   * 
   * @param tabMargin the tab margin
   */
  public void setTabMargin(int tabMargin) {
    this.tabMargin = tabMargin;
  }

  /**
   * Sets the position where the tab strip should be rendered (defaults to TOP,
   * pre-render). The only other supported value is BOTTOM. Note that tab
   * scrolling is only supported for position TOP.
   * 
   * @param tabPosition the tab position
   */
  public void setTabPosition(TabPosition tabPosition) {
    this.tabPosition = tabPosition;
  }

  /**
   * True to enable scrolling to tabs that may be invisible due to overflowing
   * the overall TabPanel width. Only available with tabs on top. (defaults to
   * false).
   * 
   * @param tabScroll true to enable tab scrolling
   */
  public void setTabScroll(boolean tabScroll) {
    this.tabScroll = tabScroll;
  }

  /**
   * Sets the initial width in pixels of each new tab (defaults to 120).
   * 
   * @param tabWidth
   */
  public void setTabWidth(int tabWidth) {
    this.tabWidth = tabWidth;
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new TabPanelEvent(this);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected ContainerEvent createContainerEvent(TabItem item) {
    return new TabPanelEvent(this, item);
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    for (TabItem item : getItems()) {
      ComponentHelper.doAttach(item.header);
    }
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    for (TabItem item : getItems()) {
      ComponentHelper.doDetach(item.header);
    }
  }

  @Override
  protected void onAfterLayout() {
    delegateUpdates();
  }

  @Override
  protected void onAttach() {
    super.onAttach();
    bar.disableTextSelection(true);
    if (activeItem != null) {
      TabItem item = activeItem;
      activeItem = null;
      setSelection(item);
    } else if (activeItem == null && autoSelect && getItemCount() > 0) {
      setSelection(getItem(0));
    }

    if (GXT.isAriaEnabled()) {
      FocusFrame.get().unframe();
    }

    if (resizeTabs) {
      autoSizeTabs();
    }
  }

  @Override
  protected void onDetach() {
    bar.disableTextSelection(false);
    super.onDetach();
  }

  protected void onItemContextMenu(TabItem item, int x, int y) {
    if (closeMenu) {
      if (closeContextMenu == null) {
        closeContextMenu = new Menu();
        closeContextMenu.add(new MenuItem(messages.getCloseText(), new SelectionListener<MenuEvent>() {
          @Override
          public void componentSelected(MenuEvent ce) {
            ((TabItem) ce.getContainer().getData("tab")).close();
          }
        }));
        closeContextMenu.add(new MenuItem(messages.getCloseOtherText(), new SelectionListener<MenuEvent>() {

          @Override
          public void componentSelected(MenuEvent ce) {
            TabItem item = (TabItem) ce.getContainer().getData("tab");
            List<TabItem> items = new ArrayList<TabItem>();
            items.addAll(getItems());
            for (TabItem currentItem : items) {
              if (currentItem != item && currentItem.isClosable()) {
                currentItem.close();
              }
            }
          }

        }));
      }

      closeContextMenu.getItem(0).setEnabled(item.isClosable());
      closeContextMenu.setData("tab", item);
      boolean hasClosable = false;
      for (TabItem item2 : getItems()) {
        if (item2.isClosable() && item2 != item) {
          hasClosable = true;
          break;
        }
      }
      closeContextMenu.getItem(1).setEnabled(hasClosable);
      closeContextMenu.showAt(x, y);
    }
  }

  protected void onInsert(TabItem item, int index) {
    super.onInsert(item, index);
    item.tabPanel = this;
    item.setAutoHeight(isAutoHeight());
    if (rendered) {
      renderItem(item, index);
      if (isAttached()) {
        ComponentHelper.doAttach(item.header);
      }
      if (activeItem == null && autoSelect) {
        setSelection(item);
      }
      delegateUpdates();
    }
  }

  protected void onLeft(ComponentEvent ce) {
    if (activeItem != null && ce.getTarget() == getElement()) {
      int idx = indexOf(activeItem);
      if (idx > 0) {
        setSelection(getItem(idx - 1));
        focusTab(activeItem);
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);

    stack = new AccessStack();

    if (tabPosition == TabPosition.TOP) {
      bar = el().createChild("<div class='x-tab-panel-header'></div>");
      body = el().createChild("<div class='x-tab-panel-body x-tab-panel-body-top'></div");
    } else {
      body = el().createChild("<div class='x-tab-panel-body x-tab-panel-body-bottom'></div");
      bar = el().createChild("<div class='x-tab-panel-footer'></div>");
    }

    if (!bodyBorder) {
      body.setStyleAttribute("border", "none");
    }

    if (!border && tabPosition == TabPosition.TOP) {
      bar.setStyleAttribute("borderLeft", "none");
      bar.setStyleAttribute("borderRight", "none");
      bar.setStyleAttribute("borderTop", "none");
    }
    if (!border && tabPosition == TabPosition.BOTTOM) {
      bar.setStyleAttribute("borderLeft", "none");
      bar.setStyleAttribute("borderRight", "none");
      bar.setStyleAttribute("borderBottom", "none");
    }

    String pos = tabPosition == TabPosition.BOTTOM ? "bottom" : "top";
    stripWrap = bar.createChild("<div class=x-tab-strip-wrap role='presentation'><ul class='x-tab-strip x-tab-strip-"
        + pos + "'></ul>");
    bar.createChild("<div class=x-tab-strip-spacer></div>");
    strip = stripWrap.firstChild();
    edge = strip.createChild("<li class=x-tab-edge></li>");
    strip.createChild("<div class=x-clear></div>");

    if (plain) {
      String p = tabPosition == TabPosition.BOTTOM ? "bottom" : "header";
      bar.addStyleName("x-tab-panel-" + p + "-plain");
    }

    if (itemTemplate == null) {
      StringBuffer sb = new StringBuffer();
      sb.append("<li class='{style}' id={id} role='tab'><a class=x-tab-strip-close onclick='return false;' role='presentation'></a>");
      sb.append("<a class='x-tab-right' role='tab'><em class='x-tab-left'>");
      sb.append("<span class='x-tab-strip-inner'><span class='x-tab-strip-text {textStyle} {iconStyle}'>{text}</span></span>");
      sb.append("</em></a></li>");
      itemTemplate = new Template(sb.toString());
      itemTemplate.compile();
    }

    renderAll();

    new KeyNav<ComponentEvent>(this) {
      @Override
      public void onLeft(ComponentEvent ce) {
        TabPanel.this.onLeft(ce);
      }

      @Override
      public void onRight(ComponentEvent ce) {
        TabPanel.this.onRight(ce);
      }

    };

    Accessibility.setRole(getElement(), Accessibility.ROLE_TABLIST);
    el().setTabIndex(0);
    el().setElementAttribute("hideFocus", "true");

    el().addEventsSunk(Event.ONCLICK | Event.MOUSEEVENTS | Event.ONKEYUP | Event.FOCUSEVENTS);
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    stripWrap.setScrollLeft(0);

    int hh = getFrameHeight();
    width -= el().getFrameWidth("lr");
    if (height != Style.DEFAULT) {
      body.setHeight(height - hh, true);
    } else {
      body.setHeight("auto");
    }
    if (width != Style.DEFAULT) {
      bar.setWidth(width, true);
      body.setWidth(width, true);
    }

    delegateUpdates();
  }

  protected void onRight(ComponentEvent ce) {
    if (activeItem != null && ce.getTarget() == getElement()) {
      int idx = indexOf(activeItem);
      if (idx < getItemCount()) {
        setSelection(getItem(idx + 1));
        focusTab(activeItem);
      }
    }
  }

  protected void onUnload() {
    if (stack != null) {
      stack.clear();
    }
  }

  void onItemClick(TabItem item, ComponentEvent ce) {
    ce.stopEvent();
    Element target = ce.getTarget();
    if (fly(target).getStyleName().equals("x-tab-strip-close")) {
      TabPanelEvent e = new TabPanelEvent(this, item);
      if (item.fireEvent(Events.BeforeClose, e) && remove(item)) {
        item.fireEvent(Events.Close, new TabPanelEvent(this, item));
      }
      return;
    } else if (item != activeItem) {
      setSelection(item);
    }
  }

  void onItemOver(TabItem item, boolean over) {
    item.header.el().setStyleName("x-tab-strip-over", over);
  }

  void onItemRender(TabItem item, Element target, int pos) {
    item.header.disabledStyle = "x-item-disabled";

    String style = item.isClosable() ? "x-tab-strip-closable " : "";
    if (!item.header.isEnabled()) {
      style += " x-item-disabled";
    }
    if (item.getIcon() != null) {
      style += " x-tab-with-icon";
    }
    Params p = new Params();
    p.set("id", getId() + "__" + item.getId());
    p.set("text", item.getText());
    p.set("style", style);
    p.set("textStyle", item.getTextStyle());
    if (item.template == null) {
      item.template = itemTemplate;
    }
    item.header.setElement(item.template.create(p));
    item.header.sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS);

    if (item.getIcon() != null) {
      Element e = item.getIcon().createElement().cast();
      item.header.el().selectNode(".x-tab-strip-inner").insertChild(e, 0);
      El.fly(e).setStyleAttribute("position", "absolute");
      El.fly(e).setStyleAttribute("top", "3px");
    }
    DOM.insertChild(target, item.header.getElement(), pos);

  }

  private void autoScrollTabs() {
    int count = getItemCount();
    int tw = bar.getClientWidth();

    int cw = stripWrap.getWidth();
    int pos = getScollPos();
    int l = edge.getOffsetsTo(stripWrap.dom).x + pos;

    if (!getTabScroll() || count < 1 || cw < 20) {
      return;
    }

    if (l <= tw) {
      stripWrap.setScrollLeft(0);
      stripWrap.setWidth(tw);
      if (scrolling) {
        scrolling = false;
        bar.removeStyleName("x-tab-scrolling");
        scrollLeft.setVisible(false);
        scrollRight.setVisible(false);
      }
    } else {
      if (!scrolling) {
        bar.addStyleName("x-tab-scrolling");
      }
      tw -= 36;
      stripWrap.setWidth(tw > 20 ? tw : 20);
      if (!scrolling) {
        if (scrollLeft == null) {
          createScrollers();
        } else {
          scrollLeft.setVisible(true);
          scrollRight.setVisible(true);
        }
      }
      scrolling = true;
      if (pos > (l - tw)) {
        stripWrap.setScrollLeft(l - tw);
      } else {
        scrollToTab(activeItem, false);
      }
      updateScrollButtons();
    }
  }

  private void autoSizeTabs() {
    int count = getItemCount();
    if (count == 0) return;
    int aw = bar.getClientWidth();
    int each = (int) Math.max(Math.min(Math.floor((aw - 4) / count) - getTabMargin(), tabWidth), getMinTabWidth());

    for (int i = 0; i < count; i++) {
      El el = getItem(i).header.el();
      Element inner = el.childNode(1).firstChild().firstChild().dom;
      int tw = el.getWidth();
      int iw = fly(inner).getWidth();
      fly(inner).setWidth(each - (tw - iw));
    }
  }

  private void createScrollers() {
    int h = stripWrap.getHeight();
    scrollLeft = bar.insertFirst("<div class='x-tab-scroller-left'></div>");
    addStyleOnOver(scrollLeft.dom, "x-tab-scroller-left-over");
    scrollLeft.setHeight(h);

    scrollRight = bar.insertFirst("<div class='x-tab-scroller-right'></div>");
    addStyleOnOver(scrollRight.dom, "x-tab-scroller-right-over");
    scrollRight.setHeight(h);
  }

  private void delegateUpdates() {
    if (resizeTabs && rendered) {
      autoSizeTabs();
    }
    if (tabScroll && rendered) {
      autoScrollTabs();
    }
  }

  private void focusTab(TabItem item) {
    Accessibility.setState(getElement(), "aria-activedescendant", getId() + "__" + item.getId());
    if (GXT.isAriaEnabled()) {
      FocusFrame.get().frame(item.getHeader());
    }

  }

  private int getFrameHeight() {
    int h = el().getFrameWidth("tb");
    h += bar.getHeight();
    return h;
  }

  private int getScollPos() {
    return stripWrap.getScrollLeft();
  }

  private int getScrollArea() {
    return Math.max(0, stripWrap.getClientWidth());
  }

  private int getScrollIncrement() {
    return scrollIncrement;
  }

  private int getScrollWidth() {
    return edge.getOffsetsTo(stripWrap.dom).x + getScollPos();
  }

  private void onScrollLeft() {
    int pos = getScollPos();
    int s = Math.max(0, pos - getScrollIncrement());
    if (s != pos) {
      scrollTo(s, getAnimScroll());
    }
  }

  private void onScrollRight() {
    int sw = getScrollWidth() - getScrollArea();
    int pos = getScollPos();
    int s = Math.min(sw, pos + getScrollIncrement());
    if (s != pos) {
      scrollTo(s, getAnimScroll());
    }
  }

  private void renderAll() {
    int count = getItemCount();
    for (int i = 0; i < count; i++) {
      TabItem item = getItem(i);
      renderItem(item, i);
    }
  }

  private void renderItem(TabItem item, int index) {
    if (item.header.isRendered()) {
      strip.insertChild(item.header.getElement(), index);
    } else {
      item.header.render(strip.dom, index);
    }
  }

  private void scrollTo(int pos, boolean animate) {
    if (animate) {
      stripWrap.scrollTo("left", pos, new FxConfig(new Listener<FxEvent>() {
        public void handleEvent(FxEvent fe) {
          updateScrollButtons();
        }
      }));
    } else {
      stripWrap.scrollTo("left", pos);
      updateScrollButtons();
    }
  }

  private void updateScrollButtons() {
    int pos = getScollPos();
    scrollLeft.setStyleName("x-tab-scroller-left-disabled", pos == 0);
    scrollRight.setStyleName("x-tab-scroller-right-disabled", pos >= (getScrollWidth() - getScrollArea() - 2));
  }
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.DataListEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.button.IconButton;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.selection.Selectable;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * Displays a list of list items.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : DateListEvent(dataList, item, index)<br>
 * <div>Fires before an item is added or inserted. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>item : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : DateListEvent(dataList, item, index)<br>
 * <div>Fires before an item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>item : the item being removed</li>
 * <li>index : the index of the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : DateListEvent(dataList, item, index)<br>
 * <div>Fires after an item has been added or inserted.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>item : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : DateListEvent(dataList, item, index)<br>
 * <div>Fires after an item has been removed.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>item : the item that was removed</li>
 * <li>index : the index of the item that was removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeSelect</b> : DateListEvent(dataList, item)<br>
 * <div>Fires before a item is selected. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>item : the selected item</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>SelectionChange</b> : DateListEvent(dataList, selected)<br>
 * <div>Fires after the selection changes.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>selected : the selected items</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ContextMenu</b> : DateListEvent(dataList)<br>
 * <div>Fires before the list's context menu is shown. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>menu : menu</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CheckChange</b> : DateListEvent(dataList, item)<br>
 * <div>Fires after an item is selected.</div>
 * <ul>
 * <li>dataList : this</li>
 * <li>item : the item that was is checked</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
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
 * 
 * <dl>
 * <dt><b>CSS:</b></dt>
 * <dd>.my-list (the list itself)</dd>
 * <dd>.my-listitem (list item)</dd>
 * <dd>.my-listitem .my-listitem-text (list item text)</dd>
 * </dl>
 * 
 * @deprecated see {@link ListView}
 */
public class DataList extends ScrollContainer<DataListItem> implements
    Selectable<DataListItem> {

  /**
   * The default template for data list items.
   */
  public static Template defaultItemTemplate;

  static {
    StringBuffer sb = new StringBuffer();
    sb.append("<table id='{id}' class='{style}' cellpadding=0 cellspacing=0><tbody><tr>");
    sb.append("<td class='{style}-l'><div>&nbsp;</div></td>");
    sb.append("<td class='{style}-icon' style='{icon}'><div class='x-icon-btn {iconStyle}'></div></td>");
    sb.append("<td class='{style}-c'><span class='{style}-text {textStyle}'>{text}</span></td>");
    sb.append("<td class='{style}-r'><div>&nbsp;</div></td>");
    sb.append("</tr></tbody></table>");
    defaultItemTemplate = new Template(sb.toString());
    defaultItemTemplate.compile();
  }

  /**
   * The max number of parent nodes to search in {@link #findItem(Element)}
   * (defaults to 15).
   */
  protected int maxDepth = 15;

  String itemStyle;
  private boolean flat;
  private boolean checkable;
  private Template itemTemplate;
  private El inner;
  private List<DataListItem> checked;
  private DataListSelectionModel sm;
  private boolean trackMouseOver = true;
  private DataListItem overItem;

  /**
   * Creates a new single select list.
   */
  public DataList() {
    focusable = true;
    baseStyle = "my-list";
    itemStyle = "my-list-item";
    checked = new ArrayList<DataListItem>();
    setScrollMode(Scroll.AUTOY);
    sm = new DataListSelectionModel(SelectionMode.SINGLE);
    sm.bind(this);
  }

  /**
   * Creates then adds an item to the list. Fires the <i>BeforeAdd</i> event
   * before inserting, then fires the <i>Add</i> event after the widget has been
   * inserted.
   * 
   * @param component the dataListItem to add
   */
  public boolean add(DataListItem component) {
    return super.add(component);
  }

  /**
   * Creates then adds an item to the list. Fires the <i>BeforeAdd</i> event
   * before inserting, then fires the <i>Add</i> event after the widget has been
   * inserted.
   * 
   * @param text the item's text
   * @return the newly created item, or null if the add was cancelled
   */
  public DataListItem add(String text) {
    DataListItem item = new DataListItem(text);
    return add(item) ? item : null;
  }

  /**
   * Returns an array of checked items.
   * 
   * @return the checked items
   */
  public List<DataListItem> getChecked() {
    return new ArrayList<DataListItem>(checked);
  }

  @Override
  public Menu getContextMenu() {
    return super.getContextMenu();
  }

  @Override
  public El getLayoutTarget() {
    return inner;
  }

  public DataListItem getSelectedItem() {
    return (DataListItem) sm.getSelectedItem();
  }

  public List<DataListItem> getSelectedItems() {
    return sm.getSelectedItems();
  }

  public SelectionMode getSelectionMode() {
    return sm.getSelectionMode();
  }

  /**
   * Returns the list's selection model.
   * 
   * @return the selection model
   */
  public DataListSelectionModel getSelectionModel() {
    return sm;
  }

  /**
   * Inserts an item into the list at the given index. Fires the
   * <i>BeforeAdd</i> event before inserting, then fires the <i>Add</i> event
   * after the widget has been inserted.
   * 
   * @param item the item
   * @param index the insert location
   */
  @Override
  public boolean insert(DataListItem item, int index) {
    boolean added = super.insert(item, index);
    if (added) {
      item.list = this;
      if (checkable) {
        // item.markup = Markup.ITEM_CHECK;
      }
      if (rendered) {
        item.render(inner.dom, index);
      }
    }
    return added;
  }

  /**
   * Returns true if check boxes are enabled.
   * 
   * @return the check box state
   */
  public boolean isCheckable() {
    return checkable;
  }

  /**
   * Returns true if the list is using the "flat" style.
   * 
   * @return the flat state
   */
  public boolean isFlat() {
    return flat;
  }

  /**
   * Returns true if rows are highlighted on mouse over.
   * 
   * @return the track mouse state
   */
  public boolean isTrackMouseOver() {
    return trackMouseOver;
  }

  /**
   * Moves the current selections down one level.
   */
  public void moveSelectedDown() {
    List<DataListItem> selected = sm.getSelectedItems();
    if (selected.size() == 0) {
      return;
    }

    Collections.sort(selected, new Comparator<DataListItem>() {
      public int compare(DataListItem o1, DataListItem o2) {
        return indexOf(o1) < indexOf(o2) ? 1 : 0;
      }
    });

    for (DataListItem item : selected) {
      int index = indexOf(item);
      if (index < getItemCount() - 1) {
        inner.insertChild(item.getElement(), index + 2);
        getItems().remove(item);
        getItems().add(index + 1, item);
      }
    }
  }

  /**
   * Moves the current selections up one level.
   */
  public void moveSelectedUp() {
    List<DataListItem> selected = sm.getSelectedItems();
    if (selected.size() == 0) {
      return;
    }

    Collections.sort(selected, new Comparator<DataListItem>() {
      public int compare(DataListItem o1, DataListItem o2) {
        return indexOf(o1) > indexOf(o2) ? 1 : 0;
      }
    });

    for (DataListItem item : selected) {
      int index = indexOf(item);
      if (index > 0) {
        inner.insertChild(item.getElement(), index - 1);
        getItems().remove(item);
        getItems().add(index - 1, item);
      }
    }
  }

  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    DataListItem item = findItem(ce.getTarget());
    DataListEvent dle = (DataListEvent) ce;
    switch (ce.getEventTypeInt()) {
      case Event.ONMOUSEOVER:
        if (item != null) {
          onOverChange(item, true, dle);
        }
        break;
      case Event.ONMOUSEOUT:
        if (overItem != null) {
          onOverChange(overItem, false, dle);
        }
        break;
      case Event.ONCLICK:
        if (item != null) {
          onClick(item, dle);
        }
    }
    if (item != null) {
      item.onComponentEvent(ce);
    }
  }

  public void onSelectChange(DataListItem item, boolean select) {
    if (select) {
      item.removeStyleName(itemStyle + "-over");
      item.addStyleName(itemStyle + "-sel");
    } else {
      item.removeStyleName(itemStyle + "-sel");
    }
  }

  /**
   * Removes the item from the list.
   * 
   * @param item the item to be removed
   * @return true if the item was removed
   */
  @Override
  public boolean remove(DataListItem item) {
    return remove(item, false);
  }

  /**
   * Removes the item from the list.
   * 
   * @param item the item to be removed
   * @param force true to force
   * @return true if the item was removed
   */
  @Override
  public boolean remove(DataListItem item, boolean force) {
    DataListEvent dle = new DataListEvent(this);
    dle.setItem(item);
    if (fireEvent(Events.BeforeRemove, dle)) {
      checked.remove(item);
      item.list = null;
      boolean result = super.remove(item, force);
      fireEvent(Events.Remove, dle);
      return result;
    }
    return false;
  }

  /**
   * Scrolls the item into view.
   * 
   * @param item the item
   */
  public void scrollIntoView(DataListItem item) {
    item.el().scrollIntoView(inner.dom, false);
  }

  /**
   * Sets whether items shoud have a check box (defaults to false, pre-render).
   * 
   * @param checkable true to enable checbox
   */
  public void setCheckable(boolean checkable) {
    this.checkable = checkable;
  }

  @Override
  public void setContextMenu(Menu menu) {
    super.setContextMenu(menu);
  }

  /**
   * Sets whether the list should use a "flat" style without rounded corners
   * (defaults to false, pre-render). The flat style supports variable height
   * list items.
   * 
   * @param flat the flat state
   */
  public void setFlatStyle(boolean flat) {
    this.flat = flat;
  }

  /**
   * Sets the optional template to be used by the data list items (pre-render).
   * The custom template will be rendered with the following parameters: id,
   * style, iconStyle, text.
   * 
   * @param itemTemplate the template
   */
  public void setItemTemplate(Template itemTemplate) {
    this.itemTemplate = itemTemplate;
  }

  public void setSelectedItem(DataListItem item) {
    sm.select(item, false);
  }

  public void setSelectedItems(List<DataListItem> items) {
    sm.select(items, false);
  }

  /**
   * Sets the list's selection mode.
   * 
   * @param mode the selection mode
   */
  public void setSelectionMode(SelectionMode mode) {
    setSelectionModel(new DataListSelectionModel(mode));
  }

  /**
   * Sets the list's selection model.
   * 
   * @param sm the selection model
   */
  public void setSelectionModel(DataListSelectionModel sm) {
    assert sm != null;
    if (this.sm != null) {
      this.sm.bind(null);
    }
    this.sm = sm;
    sm.bind(this);
  }

  /**
   * True to highlight items when the mouse is over (defaults to true).
   * 
   * @param trackMouseOver true to highlight items on mouse over
   */
  public void setTrackMouseOver(boolean trackMouseOver) {
    this.trackMouseOver = trackMouseOver;
  }

  /**
   * Sorts the data list.
   * 
   * @param comparator the comparator
   */
  public void sort(Comparator<DataListItem> comparator) {
    List<DataListItem> list = getItems();
    Collections.sort(list, comparator);
    if (rendered) {
      int count = getItemCount();
      for (int i = 0; i < count; i++) {
        DataListItem item = getItem(i);
        inner.dom.appendChild(item.getElement());
      }
    }
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new DataListEvent(this, (event == null) ? null
        : findItem(DOM.eventGetTarget(event)));
  }

  @SuppressWarnings("unchecked")
  @Override
  protected ContainerEvent createContainerEvent(DataListItem item) {
    return new DataListEvent(this, item);
  }

  @Override
  protected void createStyles(String baseStyle) {
    if (itemStyle == null) {
      itemStyle = baseStyle + "-item";
    }
  }

  protected void onCheckChange(DataListItem item, boolean checked) {
    String s = checked ? "my-list-checked" : "my-list-notchecked";
    item.checkBtn.changeStyle(s);
    if (checked) {
      this.checked.add(item);
    } else {
      this.checked.remove(item);
    }
    fireEvent(Events.CheckChange, new DataListEvent(this, item));
  }

  protected void onClick(DataListItem item, DataListEvent dle) {
    El e = item.el().selectNode(".my-list-item-icon");
    if (checkable && dle.within(e.dom)) {
      dle.stopEvent();
      item.setChecked(!item.isChecked());
    }
  }

  protected void onKeyPress(DataListEvent e) {
    fireEvent(Events.KeyPress, e);
  }

  protected void onOverChange(DataListItem item, boolean over, DataListEvent e) {
    if (trackMouseOver) {
      item.el().setStyleName(itemStyle + "-over", over);
      if (over) {
        overItem = item;
      } else {
        overItem = null;
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createDiv(), target, index);
    inner = new El(DOM.createDiv());
    getElement().appendChild(inner.dom);

    inner.dom.setClassName(baseStyle + "-inner");

    if (flat) {
      setStyleName(baseStyle + "-flat");
    } else {
      setStyleName(baseStyle);
    }

    setScrollMode(getScrollMode());
    disableTextSelection(true);

    new KeyNav<DataListEvent>(this) {

      @Override
      public void onDown(DataListEvent e) {
        DataList.this.onKeyPress(e);
      }

      @Override
      public void onUp(DataListEvent e) {
        DataList.this.onKeyPress(e);
      }
    };

    if (itemTemplate == null) {
      itemTemplate = defaultItemTemplate;
    }

    renderAll();

    sinkEvents(Event.ONCLICK | Event.ONDBLCLICK | Event.KEYEVENTS | Event.MOUSEEVENTS);
  }

  protected void onRenderItem(DataListItem item, Element target, int index) {
    Params p = new Params();
    p.set("style", itemStyle);
    p.set("iconStyle", item.getIconStyle());
    p.set("textStyle", item.getTextStyle() != null ? item.getTextStyle() : "");
    p.set("icon", item.getIconStyle() != null ? "" : "display: none");
    p.set("text", item.getText());
    p.set("id", item.getId());
    item.setElement(itemTemplate.create(p), target, index);

    if (!GXT.isIE) {
      item.el().setTabIndex(0);
    }

    if (checkable) {
      item.checkBtn = new IconButton("my-list-notchecked");
      El e = item.el().selectNode(".my-list-item-icon");
      e.removeChildren();
      e.setVisible(true);
      item.checkBtn.render(e.dom);

      if (item.isChecked()) {
        item.setChecked(true);
      }
    }
  }

  protected void onResize(int width, int height) {
    if (height != Style.DEFAULT) {
      height -= el().getBorderWidth("tb");
      inner.setHeight(height, true);
    }
    if (width != Style.DEFAULT) {
      width -= el().getBorderWidth("lr");
      inner.setWidth(width, true);
    }
  }

  protected void renderAll() {
    int ct = getItemCount();
    for (int i = 0; i < ct; i++) {
      DataListItem item = getItem(i);
      item.render(inner.dom);
    }
  }

}

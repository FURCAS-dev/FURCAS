/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.List;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.binder.DataViewBinder;
import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.DataViewEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.selection.AbstractSelectionModel;
import com.extjs.gxt.ui.client.widget.selection.Selectable;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A mechanism for displaying data using custom layout templates. DataView uses
 * an {@link Template} as its internal templating mechanism.
 * 
 * <p />
 * A {@link #itemSelector} MUST be provided for the DataView to determine what
 * nodes it will be working with.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : DataViewEvent(view, item, index)<br>
 * <div>Fires before an item is added or inserted. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>view : this</li>
 * <li>item : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : DataViewEvent(view, item)<br>
 * <div>Fires before an item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>view : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : DataViewEvent(view, item, index)<br>
 * <div>Fires after an item has been added or inserted.</div>
 * <ul>
 * <li>view : this</li>
 * <li>item : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : DataViewEvent(view, item)<br>
 * <div>Fires after an item has been removed.</div>
 * <ul>
 * <li>view : this</li>
 * <li>item : the item that was removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>SelectionChange</b> : DataViewEvent(view, selected)<br>
 * <div>Fires after the selection changes.</div>
 * <ul>
 * <li>view : this</li>
 * <li>selected : the selected items</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ContextMenu</b> : DataViewEvent(view)<br>
 * <div>Fires before the view's context menu is shown. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>view : this</li>
 * <li>menu : menu</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>ScrollContainer Scroll</dd>
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
 * @deprecated see {@link ListView}
 */
public class DataView extends ScrollContainer<DataViewItem> implements
    Selectable<DataViewItem> {

  /**
   * Data view selection model.
   */
  public class DataViewSelectionModel extends
      AbstractSelectionModel<DataView, DataViewItem> {

    public DataViewSelectionModel() {
      super();
    }

    public DataViewSelectionModel(SelectionMode mode) {
      super(mode);
    }

  }

  /**
   * The view's selection model.
   */
  protected DataViewSelectionModel sm;

  private String itemSelector = ".x-view-item";
  private String selectStyle = "x-view-item-sel";
  private String overStyle = "x-view-item-over";
  private Template template;
  private String defaultTemplate = "<div class=x-view-item>{text}</div>";
  private DataViewBinder<?> binder;
  private boolean selectOnHover;
  private String containerTagName = "div";

  /**
   * Creates a new data view.
   */
  public DataView() {
    baseStyle = "x-view";
    setSelectionMode(SelectionMode.SINGLE);
  }

  /**
   * Creates a new data view with the given template.
   * 
   * @param template the template
   */
  public DataView(Template template) {
    this();
    this.template = template;
  }

  @Override
  public boolean add(DataViewItem component) {
    return super.add(component);
  }

  /**
   * Returns the view's binder. Only applies when set
   * {@link #setStore(ListStore)} is used.
   * 
   * @return the binder
   */
  public DataViewBinder<?> getBinder() {
    return binder;
  }

  /**
   * Returns the container's tag name.
   * 
   * @return the container tag name
   */
  public String getContainerTagName() {
    return containerTagName;
  }

  @Override
  public Menu getContextMenu() {
    return super.getContextMenu();
  }

  /**
   * Returns the default template.
   * 
   * @return the default template
   */
  public String getDefaultTemplate() {
    return defaultTemplate;
  }

  /**
   * Returns the item selector.
   * 
   * @return the selector
   */
  public String getItemSelector() {
    return itemSelector;
  }

  /**
   * Returns the over style.
   * 
   * @return the over style
   */
  public String getOverStyle() {
    return overStyle;
  }

  public DataViewItem getSelectedItem() {
    return (DataViewItem) sm.getSelectedItem();
  }

  public List<DataViewItem> getSelectedItems() {
    return sm.getSelectedItems();
  }

  /**
   * Returns the view's selection mode.
   * 
   * @return the selection mode.
   */
  public SelectionMode getSelectionMode() {
    return sm.getSelectionMode();
  }

  /**
   * Returns the view's selection model.
   * 
   * @return the selection model
   */
  public DataViewSelectionModel getSelectionModel() {
    return sm;
  }

  /**
   * Returns true if select on hover is enabled.
   * 
   * @return the select on hover state
   */
  public boolean getSelectOnOver() {
    return selectOnHover;
  }

  /**
   * Returns the select style.
   * 
   * @return the select style
   */
  public String getSelectStyle() {
    return selectStyle;
  }

  /**
   * Returns the view's template.
   * 
   * @return the template
   */
  public Template getTemplate() {
    return template;
  }

  @Override
  public boolean insert(DataViewItem item, int index) {
    boolean added = super.insert(item, index);
    if (added) {
      if (rendered) {
        renderItem(item, index);
      }
    }
    return added;
  }

  public void onComponentEvent(ComponentEvent ce) {
    DataViewItem item = findItem(ce.getTarget());
    if (item != null) {
      switch (ce.getEventTypeInt()) {
        case Event.ONMOUSEOVER:
          onMouseOver(item);
          break;
        case Event.ONMOUSEOUT:
          onMouseOut(item);
          break;
      }
      item.onComponentEvent(ce);
    }
  }

  public void onSelectChange(DataViewItem item, boolean select) {
    item.el().setStyleName(selectStyle, select);
  }

  @Override
  public boolean remove(DataViewItem component) {
    return super.remove(component);
  }

  /**
   * Sets the container's tag name (defaults to 'div', pre-render).
   * 
   * @param containerTagName
   */
  public void setContainerTagName(String containerTagName) {
    assertPreRender();
    this.containerTagName = containerTagName;
  }

  @Override
  public void setContextMenu(Menu menu) {
    super.setContextMenu(menu);
  }

  /**
   * Sets the default template.
   * 
   * @param defaultTemplate the default template
   */
  public void setDefaultTemplate(String defaultTemplate) {
    this.defaultTemplate = defaultTemplate;
  }

  /**
   * This is a required setting. A simple CSS selector (e.g. div.some-class or
   * span:first-child) that will be used to determine what nodes this DataView
   * will be working with (defaults to 'x-view-item').
   * 
   * @param itemSelector the item selector
   */
  public void setItemSelector(String itemSelector) {
    this.itemSelector = itemSelector;
  }

  /**
   * Sets the style name to be applied on mouse over (defaults to
   * 'x-view-item-over').
   * 
   * @param overStyle the over style
   */
  public void setOverStyle(String overStyle) {
    this.overStyle = overStyle;
  }

  public void setSelectedItem(DataViewItem item) {
    sm.select(item, false);
  }

  public void setSelectedItems(List<DataViewItem> items) {
    sm.select(items, false);
  }

  /**
   * Sets the list's selection mode.
   * 
   * @param mode the selection mode
   */
  public void setSelectionMode(SelectionMode mode) {
    setSelectionModel(new DataViewSelectionModel(mode));
  }

  /**
   * True to select the item when mousing over a element (defaults to false).
   * 
   * @param selectOnHover true to select on mouse over
   */
  public void setSelectOnOver(boolean selectOnHover) {
    this.selectOnHover = selectOnHover;
  }

  /**
   * The style to be applied to each selected item (defaults to
   * 'x-view-item-sel').
   * 
   * @param selectStyle the select style
   */
  public void setSelectStyle(String selectStyle) {
    this.selectStyle = selectStyle;
  }

  /**
   * Convenience method that create a new {@link DataViewBinder} using the given
   * store.
   * 
   * @param store the store
   */
  @SuppressWarnings("unchecked")
  public void setStore(ListStore store) {
    binder = new DataViewBinder(this, store);
    binder.init();
  }

  /**
   * Sets the view's template.
   * 
   * @param html the HTML fragment
   */
  public void setTemplate(String html) {
    setTemplate(new Template(html));
  }

  /**
   * Sets the view's template.
   * 
   * @param template the template
   */
  public void setTemplate(Template template) {
    this.template = template;
  }

  protected String bulkRenderItem(DataViewItem item) {
    return template.applyTemplate(new Params(item.getValues()));
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new DataViewEvent(this, (event == null) ? null
        : findItem(DOM.eventGetTarget(event)));
  }

  @SuppressWarnings("unchecked")
  @Override
  protected ContainerEvent createContainerEvent(DataViewItem item) {
    return new DataViewEvent(this, item);
  }

  protected void onMouseOut(DataViewItem item) {
    item.el().removeStyleName(overStyle);
  }

  protected void onMouseOver(DataViewItem item) {
    if (el() != null) {
      if (selectOnHover) {
        setSelectedItem(item);
      } else {
        item.el().addStyleName(overStyle);
      }
    }
  }

  protected void onRender(Element target, int index) {
    setElement(DOM.createElement(containerTagName), target, index);
    setStyleAttribute("overflow", "auto");

    renderAll();

    el().addEventsSunk(
        Event.ONCLICK | Event.ONDBLCLICK | Event.MOUSEEVENTS | Event.KEYEVENTS);
  }

  protected void renderAll() {
    if (template == null) {
      template = new Template(defaultTemplate);
    }

    StringBuffer sb = new StringBuffer();
    for (DataViewItem item : getItems()) {
      sb.append(bulkRenderItem(item));
    }
    getElement().setInnerHTML(sb.toString());

    NodeList<Element> elems = el().select(itemSelector);

    for (int i = 0; i < elems.getLength(); i++) {
      DataViewItem item = getItem(i);
      item.setElement(elems.getItem(i));
    }
  }

  protected void renderItem(DataViewItem item, int index) {
    item.setElement(XDOM.create(template.applyTemplate(new Params(item.getValues()))));
    el().insertChild(item.getElement(), index);
  }

  protected void setSelectionModel(DataViewSelectionModel sm) {
    assert sm != null;
    if (this.sm != null) {
      this.sm.bind(null);
    }
    this.sm = sm;
    sm.bind(this);
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.toolbar;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.ToolBarLayout;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A standard tool bar.
 * 
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : ToolBarEvent(container, item, index)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : ToolBarEvent(container, item)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : ToolBarEvent(container, item, index)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : ToolBarEvent(container, item)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * <dl>
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
 * 
 * <dl>
 * <dt><b>CSS:</b></dt>
 * <dd>x-toolbar (the tool bar)</dd>
 * </dl>
 */
public class ToolBar extends Container<Component> {

  private HorizontalAlignment alignment = HorizontalAlignment.LEFT;
  private int minButtonWidth = Style.DEFAULT;
  private boolean enableOverflow = true;
  private int spacing = 0;

  /**
   * Creates a new tool bar.
   */
  public ToolBar() {
    setLayoutOnChange(true);
    enableLayout = true;
    addStyleName("x-toolbar");
    setLayout(new ToolBarLayout());
  }

  /**
   * Adds a item to the tool bar.
   * 
   * @param item the item to add
   */
  @Override
  public boolean add(Component item) {
    return super.add(item);
  }

  /**
   * Returns the alignment of the items.
   * 
   * @return the alignment
   */
  public HorizontalAlignment getAlignment() {
    return alignment;
  }

  /**
   * Returns the min button width.
   * 
   * @return the min button width
   */
  public int getMinButtonWidth() {
    return minButtonWidth;
  }

  /**
   * Returns the child component spacing.
   * 
   * @return the spacing
   */
  public int getSpacing() {
    return spacing;
  }

  /**
   * Inserts a item into the tool bar.
   * 
   * @param item the item to add
   * @param index the insert location
   */
  public boolean insert(Component item, int index) {
    boolean result = super.insert(item, index);
    if (item instanceof Button && ((Button) item).getMinWidth() == Style.DEFAULT) {
      ((Button) item).setMinWidth(minButtonWidth);
    }
    return result;
  }

  /**
   * Returns true if overflow is enabled.
   * 
   * @return the overflow state
   */
  public boolean isEnableOverflow() {
    return enableOverflow;
  }

  @Override
  public boolean layout() {
    return super.layout();
  }

  /**
   * Removes a component from the tool bar.
   * 
   * @param item the item to be removed
   */
  public boolean remove(Component item) {
    return super.remove(item);
  }

  /**
   * Sets the ailgnment of the items. Defaults to left.
   * 
   * @param alignment the alignment to set
   */
  public void setAlignment(HorizontalAlignment alignment) {
    this.alignment = alignment;
  }

  /**
   * Sets the minWidth for any Component of type Button
   * 
   * @param minButtonWidth the min button width to set
   */
  public void setMinButtonWidth(int minButtonWidth) {
    this.minButtonWidth = minButtonWidth;
    for (Component c : getItems()) {
      if (c instanceof Button && ((Button) c).getMinWidth() == Style.DEFAULT) {
        ((Button) c).setMinWidth(minButtonWidth);
      }
    }
  }

  /**
   * True to show a drop down icon when the available width is less than the
   * required width (defaults to false).
   * 
   * @param enableOverflow true to enable overflow support
   */
  public void setEnableOverflow(boolean enableOverflow) {
    this.enableOverflow = enableOverflow;
  }

  /**
   * Sets the spacing between child items (defaults to 0).
   * 
   * @param spacing the spacing
   */
  public void setSpacing(int spacing) {
    this.spacing = spacing;
    ((ToolBarLayout) getLayout()).setSpacing(spacing);
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new ToolBarEvent(this);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected ContainerEvent createContainerEvent(Component item) {
    return new ToolBarEvent(this, item);
  }

  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    super.onRender(target, index);
    addStyleName("x-small-editor");
  }

}

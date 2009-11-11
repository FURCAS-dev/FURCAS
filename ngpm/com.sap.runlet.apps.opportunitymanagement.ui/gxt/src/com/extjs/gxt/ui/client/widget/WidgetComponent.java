/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Creates a component from a widget. This allows widget instances to be treated
 * as components.
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
public class WidgetComponent extends BoxComponent {

  /**
   * The wrapped widget.
   */
  protected Widget widget;

  /**
   * Creates a new component wrapper.
   * 
   * @param widget the widget to be wrapped
   */
  public WidgetComponent(Widget widget) {
    assert widget != null : "widget must not be null";
    this.widget = widget;
  }

  /**
   * Returns the underlying widget.
   * 
   * @return the widget
   */
  public Widget getWidget() {
    return widget;
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    ComponentHelper.doAttach(widget);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(widget);
  }

  @Override
  protected void onDisable() {
    super.onDisable();
    DOM.setElementPropertyBoolean(widget.getElement(), "disabled", true);
  }

  @Override
  protected void onEnable() {
    super.onEnable();
    DOM.setElementPropertyBoolean(widget.getElement(), "disabled", false);
  }

  @Override
  protected void onRender(Element target, int index) {
    // we need this to have component listener to work
    setElement(DOM.createDiv(), target, index);
    getElement().appendChild(widget.getElement());
    super.onRender(target, index);
  }

  protected void onResize(int width, int height) {
    super.onResize(width, height);
    el().firstChild().setSize(width, height, true);
  }

}

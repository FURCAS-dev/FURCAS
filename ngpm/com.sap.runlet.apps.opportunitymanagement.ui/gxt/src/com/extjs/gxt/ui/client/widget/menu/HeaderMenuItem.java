/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * A menu item for headings.
 */
public class HeaderMenuItem extends Item {
  private String itemStyle = "x-menu-text";
  private String text;

  /**
   * Creates a new text menu item.
   */
  public HeaderMenuItem() {
    super();
    setHideOnClick(false);
  }

  public HeaderMenuItem(String text) {
    this();
    this.text = text;
  }

  /**
   * Returns the item's text.
   * 
   * @return the item text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the item's text.
   * 
   * @param text the item's text
   */
  public void setText(String text) {
    this.text = text;
    if (rendered && text != null) {
      el().update(text);
    }
  }

  protected void onRender(Element target, int index) {
    Element span = DOM.createSpan();    
    span.setClassName(itemStyle);
    setElement(span, target, index);
    super.onRender(target, index);
    setText(text);
  }

}

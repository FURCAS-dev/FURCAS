/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * Base class for an OFC text element
 */
public class Text extends BaseModel {

  /**
   * Create a new Text instance with the given text and no style.
   * 
   * @param text the text
   */
  public Text(String text) {
    setText(text);
    setStyle(null);
  }

  /**
   * Create a new Text instance with the given text and style. Style is a CSS
   * string for formatting text.
   * 
   * @param text the text
   * @param style the style string
   */
  public Text(String text, String style) {
    setText(text);
    setStyle(style);
  }

  /**
   * Returns the style
   * 
   * @return String style
   */
  public String getStyle() {
    return get("style");
  }

  /**
   * Returns the text
   * 
   * @return String text
   */
  public String getText() {
    return (String)get("text");
  }

  /**
   * Sets the style.
   * 
   * @param style the style
   */
  public void setStyle(String style) {
    set("style", style);
  }

  /**
   * Sets the text string.
   * 
   * @param text the text
   */
  public void setText(String text) {
    set("text", text);
  }
}

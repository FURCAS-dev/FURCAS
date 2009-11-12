/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Provides precise pixel measurements for blocks of text so that you can
 * determine exactly how high and wide, in pixels, a given block of text will
 * be.
 */
public class TextMetrics {

  private static TextMetrics instance;

  static {
    instance = new TextMetrics();
  }

  /**
   * Returns the singleton instance.
   * 
   * @return the text metrics instance
   */
  public static TextMetrics get() {
    return instance;
  }

  private El el;

  private TextMetrics() {
    el = new El(DOM.createDiv());
    DOM.appendChild(XDOM.getBody(), el.dom);
    el.makePositionable(true);
    el.setLeftTop(-10000, -10000);
    el.setVisibility(false);
  }

  /**
   * Binds this TextMetrics instance to an element from which to copy existing
   * CSS styles that can affect the size of the rendered text.
   * 
   * @param el the element
   */
  public void bind(Element el) {
    bind(new El(el));
  }

  /**
   * Binds this TextMetrics instance to an element from which to copy existing
   * CSS styles that can affect the size of the rendered text.
   * 
   * @param el the element
   */
  public void bind(El el) {
    this.el.setStyleAttribute("fontSize", el.getStyleAttribute("fontSize"));
    this.el.setStyleAttribute("fontWeight", el.getStyleAttribute("fontWeight"));
    this.el.setStyleAttribute("fontStyle", el.getStyleAttribute("fontStyle"));
    this.el.setStyleAttribute("fontFamily", el.getStyleAttribute("fontFamily"));
    this.el.setStyleAttribute("lineHeight", el.getStyleAttribute("lineHeight"));
    this.el.setStyleAttribute("textTransform", el.getStyleAttribute("textTransform"));
    this.el.setStyleAttribute("letterSpacing", el.getStyleAttribute("letterSpacing"));
  }

  /**
   * Returns the measured height of the specified text. For multiline text, be
   * sure to call {@link #setFixedWidth} if necessary.
   * 
   * @param text the text to be measured
   * @return the height in pixels
   */
  public int getHeight(String text) {
    return getSize(text).height;
  }

  /**
   * Returns the size of the specified text based on the internal element's
   * style and width properties.
   * 
   * @param text the text to measure
   * @return the size
   */
  public Size getSize(String text) {
    el.dom.setInnerHTML(text);
    Size size = el.getSize();
    el.dom.setInnerHTML("");
    return size;
  }

  /**
   * Returns the measured width of the specified text.
   * 
   * @param text the text to measure
   * @return the width in pixels
   */
  public int getWidth(String text) {
    el.setStyleAttribute("width", "auto");
    return getSize(text).width;
  }

  /**
   * Sets a fixed width on the internal measurement element. If the text will be
   * multiline, you have to set a fixed width in order to accurately measure the
   * text height.
   * 
   * @param width the width to set on the element
   */
  public void setFixedWidth(int width) {
    el.setWidth(width);
  }

}

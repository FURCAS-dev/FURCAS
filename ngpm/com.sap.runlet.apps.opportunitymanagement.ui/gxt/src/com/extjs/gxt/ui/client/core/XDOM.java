/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Provides additional static methods that allow you to manipulate the browser's
 * Document Object Model (DOM).
 * 
 * @see DOM
 */
public final class XDOM {

  /**
   * Returns true if the browser uses a visible box.
   */
  private static El bodyEl;
  private static int scrollBarHeight = Style.DEFAULT;
  private static int autoId = 0;
  private static int zIndexId = 1000;

  static {
    GXT.init();
  }

  /**
   * Creates an element form the given markup.
   * 
   * @param html the markup
   * @return the new element
   */
  public static Element create(String html) {
    Element div = DOM.createDiv();
    DOM.setInnerHTML(div, html);
    Element firstChild = DOM.getFirstChild(div);
    // support text node creation
    return (firstChild != null) ? firstChild : div;
  }

  /**
   * Returns the body element.
   * 
   * @return the body
   */
  public static native Element getBody() /*-{
    return $doc.body || $doc.documentElement;
  }-*/;

  /**
   * Returns the body El.
   * 
   * @return the body
   */
  public static El getBodyEl() {
    if (bodyEl == null) {
      bodyEl = new El(getBody());
    }
    return bodyEl;
  }

  /**
   * Returns the body elements horizontal scroll.
   * 
   * @return the scroll amount in pixels
   */
  public static native int getBodyScrollLeft() /*-{
    if(@com.extjs.gxt.ui.client.GXT::isIE && @com.extjs.gxt.ui.client.GXT::isStrict){
      return $doc.documentElement.scrollLeft || $doc.body.scrollLeft || 0;
    } else {
      return $wnd.pageXOffset || $doc.body.scrollLeft || 0;
    }
  }-*/;

  /**
   * Return the body elements vertical scroll.
   * 
   * @return the scroll amount in pixels
   */
  public static native int getBodyScrollTop() /*-{
    if(@com.extjs.gxt.ui.client.GXT::isIE && @com.extjs.gxt.ui.client.GXT::isStrict){
      return $doc.documentElement.scrollTop || $doc.body.scrollTop || 0;
    } else {
      return $wnd.pageYOffset || $doc.body.scrollTop || 0;
    }
  }-*/;

  public static native int getDocumentHeight()/*-{
    var scrollHeight = ($doc.compatMode != "CSS1Compat") ? $doc.body.scrollHeight : $doc.documentElement.scrollHeight;
    return Math.max(scrollHeight, @com.extjs.gxt.ui.client.core.XDOM::getViewportHeight()());
  }-*/;

  public static native int getDocumentWidth()/*-{
    var scrollWidth = ($doc.compatMode != "CSS1Compat") ? $doc.body.scrollWidth : $doc.documentElement.scrollWidth;
    return Math.max(scrollWidth, @com.extjs.gxt.ui.client.core.XDOM::getViewportWidth()());
  }-*/;

  /**
   * Returns the HTML head element.
   * 
   * @return the head
   */
  public static native Element getHead() /*-{
    return $doc.getElementsByTagName('head')[0];
  }-*/;

  /**
   * Returns the document element.
   * 
   * @return the docuemnt
   */
  public static native Element getDocument() /*-{
    return $doc;
  }-*/;

  /**
   * Returns the element with the unique id.
   * 
   * @param id the id
   * @return the element, or null if no match
   */
  public static Element getElementById(String id) {
    return DOM.getElementById(id);
  }

  /**
   * Returns the width of the scroll bar.
   * 
   * @return the scroll bar width
   */
  public static int getScrollBarWidth() {
    if (scrollBarHeight == Style.DEFAULT) {
      scrollBarHeight = getScrollBarWidthInternal();
    }
    return scrollBarHeight;
  }

  /**
   * Increments and returns the top z-index value.
   * 
   * @return the z-index
   */
  public static int getTopZIndex() {
    return ++zIndexId;
  }

  public static int getTopZIndex(int i) {
    zIndexId += i + 1;
    return zIndexId;
  }

  /**
   * Returns an unique id.
   * 
   * @return the id
   */
  public static String getUniqueId() {
    return "x-auto-" + autoId++;
  }

  public static int getViewHeight(boolean full) {
    return full ? getDocumentHeight() : getViewportHeight();
  }

  public static native int getViewportHeight()/*-{
    if(@com.extjs.gxt.ui.client.GXT::isIE){
        return @com.extjs.gxt.ui.client.GXT::isStrict ? $doc.documentElement.clientHeight :
                 $doc.body.clientHeight;
    }else{
        return $wnd.self.innerHeight;
    }
  }-*/;

  public static native int getViewportWidth() /*-{
    if(@com.extjs.gxt.ui.client.GXT::isIE){
        return @com.extjs.gxt.ui.client.GXT::isStrict ? $doc.documentElement.clientWidth :
                 $doc.body.clientWidth;
    }else{
        return $wnd.self.innerWidth;
    }
  }-*/;

  public static int getViewWidth(boolean full) {
    return full ? getDocumentWidth() : getViewportWidth();
  }

  /**
   * Returns the viewports size.
   * 
   * @return the size
   */
  public static Size getViewportSize() {
    return new Size(getViewportWidth(), getViewportHeight());
  }

  /**
   * Reloads the page.
   */
  public native static void reload() /*-{
    $wnd.location.reload();
  }-*/;

  private static int getScrollBarWidthInternal() {
    LayoutContainer wc = new LayoutContainer();
    RootPanel.get().add(wc);
    wc.el().setVisibility(false);
    wc.setScrollMode(Scroll.AUTO);
    wc.setSize(300, 300);

    Html html = new Html("sdff");
    html.setHeight("284");
    html.setWidth("500");

    wc.add(html);

    int height = 17;

    for (int i = 280; i < 300; i++) {
      html.setHeight("" + i);
      wc.setVScrollPosition(20);
      if (wc.getVScrollPosition() == 1) {
        height = 300 - i + 1;
      }
    }
    RootPanel.get().remove(wc);
    return height;
  }

  private XDOM() {

  }

}
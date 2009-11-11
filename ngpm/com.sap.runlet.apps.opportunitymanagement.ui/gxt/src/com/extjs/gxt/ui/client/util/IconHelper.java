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
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.impl.ClippedImagePrototype;

public class IconHelper {

  private static boolean initialized;
  private static El el;

  public static AbstractImagePrototype createPath(String url) {
    return createPath(url, 16, 16);
  }

  public static AbstractImagePrototype createPath(String url, int width, int height) {
    ClippedImagePrototype c = new ClippedImagePrototype(url, 0, 0, width, height);
    return c;
  }

  public static AbstractImagePrototype createStyle(String styleName) {
    return createStyle(styleName, 16, 16);
  }

  public static AbstractImagePrototype createStyle(String styleName, int width, int height) {
    if (!initialized) {
      el = new El(DOM.createDiv());
      DOM.appendChild(XDOM.getBody(), el.dom);
      el.makePositionable(true);
      el.setLeftTop(-10000, -10000);
      el.setVisibility(false);
      initialized = true;
    }

    el.addStyleName(styleName);
    String s = el.getStyleAttribute("backgroundImage").replace("\")", "").replace(")", "").replace(
        "url(\"", "").replace("url(", "");
    el.removeStyleName(styleName);

    return createPath(s, width, height);
  }

  public static AbstractImagePrototype create(String s) {
    return create(s, 16, 16);
  }

  public static AbstractImagePrototype create(String s, int width, int height) {
    return Util.isImagePath(s) ? createPath(s, width, height) : createStyle(s, width,
        height);
  }

}

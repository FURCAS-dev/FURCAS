/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.impl;

import com.extjs.gxt.ui.client.widget.PngImage;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * PNG support.
 * <p>
 * Implementation adapted from GWT Widget Library
 * (http://gwt-widget.sourceforge.net/).
 * </p>
 * 
 */
public class PngImageImpl {

  public Element createElement(String url, int width, int height) {
    Element result = DOM.createImg();
    DOM.setElementProperty(result, "src", url);
    DOM.setElementPropertyInt(result, "width", width);
    DOM.setElementPropertyInt(result, "height", height);
    return result;
  }

  public String getUrl(PngImage image) {
    return DOM.getElementProperty(image.getElement(), "src");
  }

}

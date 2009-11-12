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
public class PngImageImplIE6 extends PngImageImpl {
  private String url;
  private boolean isPng;

  public Element createElement(String url, int width, int height) {
    this.url = url;

    if (url.endsWith(".png") || url.endsWith(".PNG")) {
      isPng = true;
    } else {
      isPng = false;
    }

    if (isPng) {
      Element div = DOM.createDiv();
      DOM.setInnerHTML(div, "<div style=\"position: relative;width:" + width + "px;height:"
          + height + "px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + url
          + "', sizingMethod='scale')\"></div>");

      return DOM.getFirstChild(div);
    } else {
      return super.createElement(url, width, height);
    }
  }

  public String getUrl(PngImage image) {
    if (isPng) {
      return url;
    } else {
      return super.getUrl(image);
    }
  }

}

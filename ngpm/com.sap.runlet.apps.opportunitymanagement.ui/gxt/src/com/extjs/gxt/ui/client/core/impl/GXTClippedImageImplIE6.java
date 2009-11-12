/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core.impl;

import com.extjs.gxt.ui.client.GXT;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.impl.ClippedImageImplIE6;

//we need this as IE7 and above can handle png transparency images. The normal GWT IMPL doesn't now that.
public class GXTClippedImageImplIE6 extends ClippedImageImplIE6 {
  private static native void injectGlobalHandler() /*-{
    $wnd.__gwt_transparentImgHandler = function (elem) {
      elem.onerror = null;
      @com.google.gwt.user.client.DOM::setImgSrc(Lcom/google/gwt/user/client/Element;Ljava/lang/String;)(elem, @com.google.gwt.core.client.GWT::getModuleBaseURL()() + "clear.cache.gif");
    };
  }-*/;

  public GXTClippedImageImplIE6() {
    if (GXT.isIE6) {
      injectGlobalHandler();
    }
  }

  public void adjust(Element img, String url, int left, int top, int width, int height) {
    if (GXT.isIE && !GXT.isIE6) {
      String style = "url(" + url + ") no-repeat " + (-left + "px ") + (-top + "px");
      img.getStyle().setProperty("background", style);
      img.getStyle().setPropertyPx("width", width);
      img.getStyle().setPropertyPx("height", height);
    } else {
      super.adjust(img, url, left, top, width, height);
    }
  }

  @Override
  public Element createStructure(String url, int left, int top, int width, int height) {
    if (GXT.isIE && !GXT.isIE6) {
      Element tmp = Document.get().createSpanElement();
      tmp.setInnerHTML(getHTML(url, left, top, width, height));
      return tmp.getFirstChildElement();
    } else {
      return super.createStructure(url, left, top, width, height);
    }
  }

  public void fireSyntheticLoadEvent(final Image image) {
    if (GXT.isIE && !GXT.isIE6) {
      DeferredCommand.addCommand(new Command() {
        public void execute() {
          NativeEvent evt = Document.get().createLoadEvent();
          image.getElement().dispatchEvent(evt);
        }
      });
    } else {
      super.fireSyntheticLoadEvent(image);
    }
  }

  @Override
  public String getHTML(String url, int left, int top, int width, int height) {
    if (GXT.isIE && !GXT.isIE6) {
      String style = "width: " + width + "px; height: " + height + "px; background: url("
          + url + ") no-repeat " + (-left + "px ") + (-top + "px");

      String clippedImgHtml = "<img src='" + GWT.getModuleBaseURL()
          + "clear.cache.gif' style='" + style + "' border='0'>";
      return clippedImgHtml;
    } else {
      return super.getHTML(url, left, top, width, height);
    }

  }
}

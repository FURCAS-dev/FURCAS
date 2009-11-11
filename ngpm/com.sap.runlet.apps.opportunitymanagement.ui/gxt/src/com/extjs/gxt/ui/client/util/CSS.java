/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import com.extjs.gxt.ui.client.core.XDOM;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Provides functions for removing and adding stylesheets.
 */
public class CSS {

  /**
   * Removes a style or link tag by id.
   * 
   * @param id the id of the tag
   */
  public static void removeStyleSheet(String id) {
    Element elem = DOM.getElementById(id);
    if (elem != null) {
      Element p = DOM.getParent(elem);
      DOM.setElementProperty(p, "disabled", "disabled");
      DOM.removeChild(p, elem);
    }
  }

  /**
   * Adds a stylesheet to the document.
   * 
   * @param id the id
   * @param url the stylesheet url
   */
  public static void addStyleSheet(String id, String url) {
    Element link = DOM.createElement("link");
    link.setPropertyString("rel", "stylesheet");
    link.setPropertyString("type", "text/css");
    link.setPropertyString("id", id);
    link.setPropertyString("href", url);
    link.setPropertyString("disabled", "");

    Element elem = XDOM.getHead();

    Element all = null;

    for (int i = 0; i < elem.getChildNodes().getLength(); i++) {
      Node node = elem.getChildNodes().getItem(i).cast();
      if (node instanceof Element) {
        Element child = (Element) node;
        String tag = child.getTagName();
        if (tag != null && child.getTagName().equalsIgnoreCase("link")) {
          String href = child.getAttribute("href");
          if (href.length() != 0 && href.indexOf("gxt-all.css") != -1) {
            all = child;
            break;
          }
        }
      }
    }

    if (all != null) {
      int idx = DOM.getChildIndex(elem, all);
      DOM.insertChild(elem, link, idx + 1);
    } else {
      DOM.appendChild(elem, link);
    }

  }

  /**
   * Adds a rules string in a <code>&ltdstyle&gt&ltd/style&gt</code> element.
   * 
   * @param style the <code>&ltdstyle&gt&ltd/style&gt</code> element
   * @param cssStr the rules string
   */
  native public static void setRules(Element style, String cssStr) /*-{
    style.setAttribute("type", "text/css");
    if(style.styleSheet){// IE
    style.styleSheet.cssText = cssStr;
    } else {// w3c
    while (style.firstChild) {
    style.removeChild(style.firstChild);
    }
    var cssText = $doc.createTextNode(cssStr);
    style.appendChild(cssText);
    }
  }-*/;

}

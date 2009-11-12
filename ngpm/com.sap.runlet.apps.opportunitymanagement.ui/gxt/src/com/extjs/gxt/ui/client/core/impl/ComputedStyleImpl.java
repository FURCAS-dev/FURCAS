/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core.impl;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Format;
import com.google.gwt.user.client.Element;

public class ComputedStyleImpl {

  public String getStyleAttribute(El elem, String name) {
    return getStyleAttribute(elem.dom, name);
  }

  public String getStyleAttribute(Element elem, String name) {
    return getComputedStyle(elem, Format.hyphenize(getPropertyName(name)), null);
  }
  
  public void setStyleAttribute(Element elem, String name, Object value){
    elem.getStyle().setProperty(Format.camelize(getPropertyName(name)), String.valueOf(value));
  }

  protected String getPropertyName(String name) {
    if ("float".equals(name)) {
      return "cssFloat";
    } else if ("class".equals(name)) {
      return "className";
    } else if ("for".equals(name)) {
      return "htmlFor";
    }
    return name;
  }

  protected native String getComputedStyle(Element elem, String name, String pseudo) /*-{
    var cStyle = $doc.defaultView.getComputedStyle(elem, pseudo);
    var v;
    if(v = elem.style[name]){
      v;
    }
    return cStyle ? String(cStyle.getPropertyValue(name)) : null;
  }-*/;

}

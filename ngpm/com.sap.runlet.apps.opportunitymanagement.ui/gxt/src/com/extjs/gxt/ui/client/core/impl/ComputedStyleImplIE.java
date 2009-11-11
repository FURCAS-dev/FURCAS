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

public class ComputedStyleImplIE extends ComputedStyleImpl {
  @Override
  public String getStyleAttribute(Element elem, String name) {
    return getComputedStyle(elem, Format.camelize(getPropertyName(name)), null);
  }

  @Override
  protected String getPropertyName(String name) {
    if ("float".equals(name)) {
      return "styleFloat";
    } else if ("class".equals(name)) {
      return "className";
    } else if ("for".equals(name)) {
      return "htmlFor";
    }
    return name;
  }

  @Override
  public void setStyleAttribute(Element elem, String name, Object value) {
    if ("opacity".equals(name)) {
      setOpacity(elem, Double.valueOf((String.valueOf(value))));
    } else {
      super.setStyleAttribute(elem, name, value);
    }
  }

  @Override
  protected native String getComputedStyle(Element elem, String name, String pseudo) /*-{
    if(name == "opacity"){
      if(typeof el.style.filter == "string"){
        var m = el.style.filter.match(/alpha\(opacity=(.*)\)/i);
        if(m){
          var fv = parseFloat(m[1]);
          if(!isNaN(fv)){
            return fv ? fv / 100 : 0;
          }
        }
      }
      return 1;
    }

    var v, cs;
    if(v = elem.style[name]){
      return String(v);
    } else if(cs = elem.currentStyle) {
      var ret = cs[name];
      return String(ret);
    }
    return null;
  }-*/;

  protected native El setOpacity(Element dom, double opacity)/*-{
    dom.style.zoom = 1;
    dom.style.filter = (dom.style.filter || '').replace(/alpha\([^\)]*\)/gi,"") + (opacity == 1 ? "" : " alpha(opacity=" + opacity * 100 + ")");
  }-*/;

}

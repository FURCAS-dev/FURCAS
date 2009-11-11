/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core;

import com.google.gwt.user.client.Element;

/**
 * Utility class for creating elements from HTML fragments.
 */
public class DomHelper {

  /**
   * Creates new DOM element(s) and appends them to el.
   * 
   * @param elem the context element
   * @param html raw HTML fragment
   * @return the new element
   */
  public static native Element append(Element elem, String html) /*-{
     return $wnd.GXT.Ext.DomHelper.append(elem, html, false);
   }-*/;

  /**
   * Creates new DOM element(s) and inserts them after el.
   * 
   * @param elem the context element
   * @param html raw HTML fragment
   * @return the new element
   */
  public static native Element insertAfter(Element elem, String html) /*-{
      return $wnd.GXT.Ext.DomHelper.doInsert(elem, html, false, "afterEnd", "nextSibling");
    }-*/;

  /**
   * Creates new DOM element(s) and inserts them before el.
   * 
   * @param elem the context element
   * @param html raw HTML fragment
   * @return the new element
   */
  public static native Element insertBefore(Element elem, String html) /*-{
      return $wnd.GXT.Ext.DomHelper.doInsert(elem, html, false, "beforeBegin");
    }-*/;

  /**
   * Creates new DOM element(s) and inserts them as the first child of el.
   * 
   * @param elem the context element
   * @param html raw HTML fragment
   * @return the new element
   */
  public static native Element insertFirst(Element elem, String html) /*-{
      return $wnd.GXT.Ext.DomHelper.doInsert(elem, html, false, "afterBegin", "firstChild");
    }-*/;

  /**
   * Inserts an HTML fragment into the DOM.
   * 
   * @param where where to insert the html in relation to el - beforeBegin,
   *          afterBegin, beforeEnd, afterEnd.
   * @param el the context element
   * @param html the HTML fragment
   * @return the new element
   */
  public static native Element insertHtml(String where, Element el, String html) /*-{
     return $wnd.GXT.Ext.DomHelper.insertHtml(where, el, html);
   }-*/;

  /**
   * Creates new DOM element(s) and overwrites the contents of el with them.
   * 
   * @param elem the context element
   * @param html raw HTML fragment
   * @return the new element
   */
  public static native Element overwrite(Element elem, String html) /*-{
     $wnd.GXT.Ext.DomHelper.overwite(elem, html);
   }-*/;

}

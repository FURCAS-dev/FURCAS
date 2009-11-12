/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core;

import com.extjs.gxt.ui.client.GXT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * A template class that supports advanced functionality like autofilling
 * arrays, conditional processing with basic comparison operators,
 * sub-templates, basic math function support, special built-in template
 * variables, inline code execution and more.
 */
public final class XTemplate extends JavaScriptObject {

  static {
    GXT.init();
  }

  /**
   * Specifies the maxiumum number of nested models to search when preparing the
   * templates data (defaults to 4).
   * 
   * @param maxDepth the maximum number of nested childen
   */
  public final native void setMaxDepth(int maxDepth) /*-{
     this.maxDepth = maxDepth;
   }-*/;

  /**
   * Returns the maximum number of nested children to process when preparing the
   * template's data.
   * 
   * @return the max depth
   */
  public final native int getMaxDepth() /*-{
     if (!this.maxDepth) {
       this.maxDepth = 4;
     }
     return this.maxDepth;
   }-*/;

  /**
   * Returns a new template instance using the given html.
   * 
   * @param html the template
   * @return a new template instance
   */
  public static native XTemplate create(String html) /*-{
    return new $wnd.GXT.Ext.XTemplate(html);
    }-*/;

  protected XTemplate() {

  }

  public final native Element append(Element elem, JavaScriptObject values) /*-{
    return this.append(elem, values);
    }-*/;

  /**
   * Returns an HTML fragment of this template with the specified values
   * applied.
   * 
   * @param values the substitution values
   * @return the html fragment
   */
  public final native String applyTemplate(JavaScriptObject values) /*-{
    return this.applyTemplate(values);
    }-*/;

  /**
   * Compiles the template into an internal function, eliminating the regex
   * overhead.
   */
  public final native void compile() /*-{
    this.compile();
    }-*/;

  /**
   * Applies the supplied values to the template and inserts the new node(s)
   * after elem.
   * 
   * @param elem the context element
   * @param values the substitution values
   */
  public final native void insertAfter(Element elem, JavaScriptObject values) /*-{
    this.insertAfter(elem, values);
    }-*/;

  /**
   * Applies the supplied values to the template and inserts the new node(s)
   * before elem.
   * 
   * @param elem the context element
   * @param values the substitution values
   */
  public final native void insertBefore(Element elem, JavaScriptObject values) /*-{
    this.insertBefore(elem, values);
    }-*/;

  /**
   * Applies the supplied values to the template and overwrites the content of
   * elem with the new node(s).
   * 
   * @param elem the context element
   * @param values the substitution values
   */
  public final native void overwrite(Element elem, JavaScriptObject values) /*-{
    this.overwrite(elem, values);
    }-*/;

}

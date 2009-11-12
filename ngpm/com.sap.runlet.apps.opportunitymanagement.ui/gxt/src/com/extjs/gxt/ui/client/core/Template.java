/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.core;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelStringProvider;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.util.Params;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Represents an HTML fragment template. Templates can be precompiled for
 * greater performance.
 */
public class Template {

  static {
    GXT.init();
  }

  private native static Element appendInternal(JavaScriptObject t, Element el,
      JavaScriptObject values) /*-{
    return t.append(el, values);
    }-*/;

  private native static String applyInternal(JavaScriptObject t, JavaScriptObject values) /*-{
    return t.applyTemplate(values);
    }-*/;

  private native static JavaScriptObject create(String html) /*-{
    return new $wnd.GXT.Ext.Template(html);
    }-*/;

  private native static String getHtml(JavaScriptObject t) /*-{
    return t.html;
    }-*/;

  private native static Element insertInternal(String method, JavaScriptObject t, Element el,
      JavaScriptObject values) /*-{
    return t[method](el, values);
    }-*/;

  private JavaScriptObject t;

  private ModelStringProvider<ModelData> stringProvider;

  /**
   * Creates a new template with the given html.
   * 
   * @param html the HTML fragment or an array
   */
  public Template(String html) {
    t = create(html);
  }

  /**
   * Applies the supplied values to the template and appends the new node(s) to
   * el.
   * 
   * @param el the context element
   * @param values the positional template values
   * @return the new element
   */
  public Element append(Element el, Object... values) {
    return appendInternal(t, el, JsUtil.toJavaScriptArray(values));
  }

  /**
   * Applies the supplied values to the template and appends the new node(s) to
   * el.
   * 
   * @param el the context element
   * @param values the template values
   * @return the new element
   */
  public Element append(Element el, Params values) {
    return appendInternal(t, el, values.getValues());
  }

  /**
   * Returns an HTML fragment of this template with the specified values
   * applied.
   * 
   * @param values the substitution values
   * @return the html frament
   */
  public String applyTemplate(JavaScriptObject values) {
    return applyInternal(t, values);
  }

  /**
   * Returns an HTML fragment of this template with the specified values
   * applied.
   * 
   * @param values the values
   * @return the html fragment
   */
  public String applyTemplate(Params values) {
    return applyInternal(t, values.getValues());
  }

  /**
   * Compiles the template into an internal function, eliminating the regex
   * overhead.
   */
  public native void compile() /*-{
    var t = this.@com.extjs.gxt.ui.client.core.Template::t;
    t.compile();
    }-*/;

  /**
   * Creates a new element.
   * 
   * @param values the substitution values
   * @return the new element
   */
  public Element create(Object... values) {
    return create(new Params(values));
  }

  /**
   * Creates a new element.
   * 
   * @param values the substitution values
   * @return the new element
   */
  public Element create(Params values) {
    return XDOM.create(applyTemplate(values));
  }

  public String getHtml() {
    return getHtml(t);
  }

  /**
   * Returns the template's string provider.
   * 
   * @return the string provider
   */
  public ModelStringProvider<ModelData> getStringProvider() {
    return stringProvider;
  }

  /**
   * Applies the supplied values to the template and inserts the new node(s) at
   * the given index.
   * 
   * @param el the context element
   * @param index the insert index
   * @param values the values
   * @return the new element
   */
  public Element insert(Element el, int index, Params values) {
    int count = DOM.getChildCount(el);
    Element before = el.getChildNodes().getItem(index).cast();
    if (count == 0 || before == null) {
      return appendInternal(t, el, values.getValues());
    } else {
      return insertBefore(before, values);
    }
  }

  /**
   * Applies the supplied values to the template and inserts the new node(s)
   * after el.
   * 
   * @param el the context element
   * @param params the values
   * @return the new element
   */
  public Element insertAfter(Element el, Params params) {
    return insertInternal("insertAfter", t, el, params.getValues());
  }

  /**
   * Applies the supplied values to the template and inserts the new node(s)
   * before el.
   * 
   * @param el the context element
   * @param values the values
   * @return the new element
   */
  public Element insertBefore(Element el, Params values) {
    return insertInternal("insertBefore", t, el, values.getValues());
  }

  /**
   * Applies the supplied values to the template and inserts the new node(s) as
   * the first child of el.
   * 
   * @param el the context element
   * @param values the values
   * @return the new element
   */
  public Element insertFirst(Element el, Params values) {
    return insertInternal("insertFirst", t, el, values.getValues());
  }

  /**
   * Applies the supplied values to the template and overwrites the content of
   * el with the new node(s).
   * 
   * @param el the context element
   * @param values the values
   * @return the new element
   */
  public Element overwrite(Element el, Params values) {
    return insertInternal("overwrite", t, el, values.getValues());
  }

  /**
   * Applies the supplied values to the template and overwrites the content of
   * el with the new node(s).
   * 
   * @param el the context element
   * @param values the values
   * @return the new element
   */
  public Element overwrite(Element el, JavaScriptObject values) {
    return insertInternal("overwrite", t, el, values);
  }

  /**
   * Sets the HTML used as the template and optionally compiles it.
   * 
   * @param html the html fragment
   * @param compile <code>true<code> to compile
   */
  public native void set(String html, boolean compile) /*-{
    var t = this.@com.extjs.gxt.ui.client.core.Template::t;
    t.set(html, compile);
    }-*/;

  /**
   * Sets the string provider for the template.
   * 
   * @param stringProvider the string provider
   */
  public void setStringProvider(ModelStringProvider<ModelData> stringProvider) {
    this.stringProvider = stringProvider;
  }

}

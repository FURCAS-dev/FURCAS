/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.desktop.client;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.IconSupport;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * A selectable icon and text added to the desktop. Each shortcut requires an id
 * that has matching css styles for the icon.
 * 
 * <pre>
 * &lt;code&gt;
 * Shortcut s2 = new Shortcut();
 * s2.setText(&quot;Accordion Window&quot;);
 * s2.setId(&quot;acc-win-shortcut&quot;);
 * 
 * #acc-win-shortcut img {
 *  width: 48px;
 *  height: 48px;
 *  background-image: url(../images/im48x48.png);
 * }
 * 
 * &lt;/code&gt;
 * </pre>
 */
public class Shortcut extends Component implements IconSupport {

  private String text;
  private AbstractImagePrototype icon;
  private El iconEl;

  /**
   * Creates a new shortcut.
   */
  public Shortcut() {

  }

  /**
   * Creates a new shortcut.
   * 
   * @param id the shortcut id
   * @param text the shortcut text
   */
  public Shortcut(String id, String text) {
    setId(id);
    setText(text);
  }

  /**
   * Adds a selection listener.
   * 
   * @param listener the listener to add
   */
  public void addSelectionListener(SelectionListener<? extends ComponentEvent> listener) {
    addListener(Events.Select, listener);
  }

  public AbstractImagePrototype getIcon() {
    return icon;
  }

  /**
   * Returns the shortcuts text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    if (ce.getEventTypeInt() == Event.ONCLICK) {
      onClick(ce);
    }
  }

  /**
   * Removes a previously added listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeSelectionListener(SelectionListener<? extends ComponentEvent> listener) {
    removeListener(Events.Select, listener);
  }

  public void setIcon(AbstractImagePrototype icon) {
    if (rendered) {
      iconEl.setInnerHtml("");
      iconEl.appendChild((Element) icon.createElement().cast());
    }
    this.icon = icon;

  }

  public void setIconStyle(String icon) {
    setIcon(IconHelper.create(icon, 48, 48));

  }

  /**
   * Sets the shortcuts text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
  }

  protected void onClick(ComponentEvent ce) {
    ce.stopEvent();
    fireEvent(Events.Select, ce);
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createElement("dt"), target, index);
    El a = el().createChild("<a href='#'></a>");
    iconEl = a.createChild("<div><img src='" + GXT.BLANK_IMAGE_URL + "' /></div>");
    El txt = a.createChild("<div></div>");

    if (txt != null) {
      txt.setInnerHtml(text);
    }
    el().updateZIndex(0);
    sinkEvents(Event.ONCLICK);
    if (icon != null) {
      setIcon(icon);
    }
  }

}

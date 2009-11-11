/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.TextMetrics;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Status component typically used within a <code>ToolBar</code>.
 */
public class Status extends BoxComponent {

  private String text;
  private String iconStyle;
  private boolean box;
  private El textEl;

  public Status() {
    baseStyle = "x-status";
  }

  /**
   * Clears the current status by removing the current icon and change the text.
   * 
   * @param text the new text value
   */
  public void clearStatus(String text) {
    setIconStyle(null);
    setText(text);
  }

  /**
   * Returns the icon style.
   * 
   * @return the icon style
   */
  public String getIconStyle() {
    return iconStyle;
  }

  /**
   * Returns the text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Returns true if the box effect is enabled.
   * 
   * @return the box state
   */
  public boolean isBox() {
    return box;
  }

  /**
   * True to enable a 3D insert border (defaults to false).
   * 
   * @param box true for the box effect
   */
  public void setBox(boolean box) {
    this.box = box;
    if (rendered) {
      if (box) {
        addStyleName("x-status-text-panel");
      } else {
        removeStyleName("x-status-text-panel");
      }
    }
  }

  /**
   * Enables a busy icon and displays the given text.
   * 
   * @param text the text to display
   */
  public void setBusy(String text) {
    setIconStyle("x-status-busy");
    setText(text);
  }

  /**
   * Sets the icon style.
   * 
   * @param iconStyle the CSS style name
   */
  public void setIconStyle(String iconStyle) {
    if (rendered) {
      if (this.iconStyle != null) {
        textEl.removeStyleName("x-status-icon");
        textEl.removeStyleName(this.iconStyle);
      }
      if (iconStyle != null) {
        textEl.addStyleName("x-status-icon");
        textEl.addStyleName(iconStyle);
      }
      autoWidth();
    }
    this.iconStyle = iconStyle;
  }

  /**
   * Sets both the text and icon style.
   * 
   * @param text the text to display
   * @param iconStyle the icon style
   */
  public void setStatus(String text, String iconStyle) {
    setText(text);
    setIconStyle(iconStyle);
  }

  /**
   * Sets the text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
    if (rendered) {
      textEl.update((text == null || text.length() == 0) ? "&nbsp;" : text);
      autoWidth();
    }
  }

  protected void autoWidth() {
    if (rendered && isAutoWidth()) {
      setWidth("auto");
      if (GXT.isIE) {
        if (textEl != null) {
          textEl.clip();
          TextMetrics.get().bind(textEl.dom);
          int adj = iconStyle != null ? 25 : 0;
          int w = TextMetrics.get().getWidth(text) + adj;
          textEl.setWidth(w, true);
        }
      }
    }
  }

  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    textEl = new El(DOM.createSpan());
    textEl.addStyleName("x-status-text");
    getElement().appendChild(textEl.dom);
    super.onRender(target, index);
    disableTextSelection(true);
    setBox(box);
    setStatus(text, iconStyle);
  }
}

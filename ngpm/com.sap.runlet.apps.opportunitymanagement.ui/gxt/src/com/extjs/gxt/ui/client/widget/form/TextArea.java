/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Multiline text field. Can be used as a direct replacement for traditional
 * textarea fields.
 */
public class TextArea extends TextField<String> {

  private boolean preventScrollbars = false;

  public int getCursorPos() {
    return impl.getTextAreaCursorPos(getInputEl().dom);
  }
  
  /**
   * Returns true if scroll bars are disabled.
   * 
   * @return the scroll bar state
   */
  public boolean isPreventScrollbars() {
    return preventScrollbars;
  }

  /**
   * True to prevent scrollbars from appearing regardless of how much text is in
   * the field (equivalent to setting overflow: hidden, defaults to false,
   * pre-render).
   * 
   * @param preventScrollbars true to disable scroll bars
   */
  public void setPreventScrollbars(boolean preventScrollbars) {
    this.preventScrollbars = preventScrollbars;
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createTextArea(), target, index);
    el().setSize(100, 60);
    getElement().setPropertyString("autocomplete", "off");

    if (preventScrollbars) {
      el().setStyleAttribute("overflow", "hidden");
    }
    super.onRender(target, index);
    
    addInputStyleName("x-form-textarea");
  }

}

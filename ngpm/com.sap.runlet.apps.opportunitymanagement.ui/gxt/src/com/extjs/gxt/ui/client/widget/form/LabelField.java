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
 * Displays static text.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>Field Focus</dd>
 * <dd>Field Blur</dd>
 * <dd>Field Change</dd>
 * <dd>Field Invalid</dd>
 * <dd>Field Valid</dd>
 * <dd>Field KeyPress</dd>
 * <dd>Field SpecialKey</dd>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 */
public class LabelField extends Field<Object> {

  private String text;

  /**
   * Creates a new label field.
   */
  public LabelField() {
    baseStyle = "x-form-label";
    focusStyle = null;
    setLabelSeparator("");
  }

  /**
   * Creates a new label field.
   * 
   * @param text the label text
   */
  public LabelField(String text) {
    this();
    setText(text);
  }

  /**
   * Returns the field's text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  @Override
  public Object getValue() {
    return getText();
  }

  @Override
  public boolean isValid(boolean silent) {
    return true;
  }

  @Override
  public void markInvalid(String msg) {

  }

  /**
   * Sets the lable's text.
   * 
   * @param text the text as HTML
   */
  public void setText(String text) {
    this.text = text;
    if (rendered) {
      getElement().setInnerHTML(text != null ? text : "&nbsp;");
    }
  }

  @Override
  public void setValue(Object value) {
    setText(value != null ? value.toString() : null);
  }

  @Override
  public boolean validate(boolean silent) {
    return true;
  }

  @Override
  protected void onRender(Element parent, int index) {
    setElement(DOM.createDiv(), parent, index);
    if (text != null) {
      setText(text);
    }
  }

  @Override
  protected boolean validateValue(String value) {
    return true;
  }

}

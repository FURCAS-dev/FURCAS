/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Single checkbox field. Unlike other fields, checkbox fires change events when
 * the radios state is changed, not on blur.
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
public class CheckBox extends Field<Boolean> {

  protected El wrap, input, boxLabelEl;
  private String boxLabel;
  private String valueAttribute;

  public CheckBox() {
    value = false;
    propertyEditor = new BooleanPropertyEditor();
  }

  @Override
  public void clearInvalid() {
    // do nothing
  }

  public String getBoxLabel() {
    return boxLabel;
  }

  @Override
  public String getRawValue() {
    if (!rendered) {
      return value.toString();
    }
    return String.valueOf(((InputElement) getInputEl().dom.cast()).isChecked());
  }

  /**
   * 
   * Returns the value property of the input element
   */
  public String getValueAttribute() {
    if (rendered) {
      input.getValue();
    }
    return valueAttribute;
  }

  @Override
  public void markInvalid(String msg) {

  }

  /**
   * The text that appears beside the checkbox (defaults to null).
   * 
   * @param boxLabel the box label
   */
  public void setBoxLabel(String boxLabel) {
    this.boxLabel = boxLabel;
    if (rendered) {
      boxLabelEl.update(getBoxLabel());
    }
  }

  @Override
  public void setRawValue(String value) {
    boolean b = Boolean.valueOf(value).booleanValue();
    ((InputElement) getInputEl().dom.cast()).setChecked(b);
  }

  /**
   * Sets a new value attribute to the input element
   * 
   * @param valueAttribute the value attribute to set
   */
  public void setValueAttribute(String valueAttribute) {
    this.valueAttribute = valueAttribute;
    if (rendered) {
      input.setValue(valueAttribute);
    }
  }

  protected void alignElements() {
    if (boxLabel == null) {
      input.alignTo(getElement(), "c-c", null);
    } else {
      input.alignTo(getElement(), "l-l", new int[] {0, 0});
      boxLabelEl.alignTo(input.dom, "l-r", new int[] {5, 0});
    }
  }

  @Override
  protected El getFocusEl() {
    return input;
  }

  @Override
  protected El getInputEl() {
    return input;
  }

  @Override
  protected El getStyleEl() {
    return input;
  }

  @Override
  protected void initValue() {
    if (value != null) {
      setRawValue(value.toString());
    }
  }

  protected void onAttach() {
    super.onAttach();
    alignElements();
  }

  @Override
  protected void onClick(ComponentEvent ce) {
    if (readOnly) {
      ce.stopEvent();
      return;
    }
    boolean v = getInputEl().dom.getPropertyBoolean("checked");
    setValue(v);
  }

  @Override
  protected void onRender(Element target, int index) {
    if (this instanceof Radio) {
      input = new El(DOM.createInputRadio(""));
    } else {
      input = new El(DOM.createInputCheck());
    }

    input.setId(XDOM.getUniqueId());

    wrap = new El(DOM.createDiv());
    wrap.dom.setPropertyString("hideFocus", "hideFocus");
    wrap.dom.setClassName("x-form-check-wrap");
    wrap.dom.appendChild(input.dom);

    setElement(wrap.dom, target, index);

    if (boxLabel != null) {
      boxLabelEl = new El(DOM.createLabel());
      boxLabelEl.setStyleAttribute("position", "static");
      boxLabelEl.setElementAttribute("for", input.getId());
      boxLabelEl.setElementAttribute("htmlFor", input.getId());
      boxLabelEl.dom.setClassName("x-form-cb-label");
      wrap.dom.appendChild(boxLabelEl.dom);
      setBoxLabel(boxLabel);
    }

    super.onRender(target, index);

    setValueAttribute(valueAttribute);

    focusStyle = null;
  }

  protected void onResize(int width, int height) {
    super.onResize(width, height);
    alignElements();
  }
}

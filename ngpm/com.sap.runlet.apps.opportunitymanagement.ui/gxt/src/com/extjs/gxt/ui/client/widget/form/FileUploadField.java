/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.extjs.gxt.ui.client.util.BaseEventPreview;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.ComponentEvent;

/**
 * A file upload filed. When using this field, the containing form panel's
 * encoding must be set to MULTIPART using @link
 * {@link FormPanel#setEncoding(Encoding)}. In addition, the method should be
 * set to POST using
 * {@link FormPanel#setMethod(com.extjs.gxt.ui.client.widget.form.FormPanel.Method)}
 * .
 */
public class FileUploadField extends TextField<String> {

  public class FileUploadFieldMessages extends TextFieldMessages {

    private String browseText = GXT.MESSAGES.uploadField_browseText();

    /**
     * Returns the browse text.
     * 
     * @return the browse text
     */
    public String getBrowseText() {
      return browseText;
    }

    /**
     * Sets the browse text.
     * 
     * @param browseText the browse text
     */
    public void setBrowseText(String browseText) {
      this.browseText = browseText;
    }

  }

  private Button button;
  private AbstractImagePrototype buttonIcon;
  private int buttonOffset = 3;
  private El file;
  private BaseEventPreview focusPreview;
  private El input;
  private El wrap;

  /**
   * Creates a new file upload field.
   */
  public FileUploadField() {
    focusPreview = new BaseEventPreview();
    focusPreview.setAutoHide(false);
    messages = new FileUploadFieldMessages();
  }

  /**
   * Returns the button icon class.
   */
  public AbstractImagePrototype getButtonIconStyle() {
    return buttonIcon;
  }

  /**
   * Returns the button offset.
   */
  public int getButtonOffset() {
    return buttonOffset;
  }

  /**
   * Returns the file input element.
   */
  public InputElement getFileInput() {
    return (InputElement) file.dom.cast();
  }

  @Override
  public FileUploadFieldMessages getMessages() {
    return (FileUploadFieldMessages) messages;
  }

  @Override
  public String getName() {
    if (rendered) {
      String n = file.dom.getAttribute("name");
      if (!n.equals("")) {
        return n;
      }
    }
    return super.getName();
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    switch (ce.getEventTypeInt()) {
      case Event.ONCHANGE:
        onChange(ce);
        break;
    }
  }

  @Override
  public void reset() {
    super.reset();
    getFileInput().setValue(null);
  }

  /**
   * Sets the button icon class.
   * 
   * @param buttonIconStyle the button icon style
   */
  public void setButtonIcon(AbstractImagePrototype buttonIconStyle) {
    this.buttonIcon = buttonIconStyle;
  }

  /**
   * Sets the number of pixels between the input element and the browser button
   * (defaults to 3).
   */
  public void setButtonOffset(int buttonOffset) {
    this.buttonOffset = buttonOffset;
  }

  @Override
  public void setName(String name) {
    super.setName(name);
    if (rendered) {
      file.dom.removeAttribute("name");
      getInputEl().dom.removeAttribute("name");
      if (name != null) {
        file.setElementAttribute("name", name);
      }
    }
  }

  @Override
  public void setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
    if (button != null) {
      button.setEnabled(!readOnly);
    }
    if (file != null) {
      file.setEnabled(!readOnly);
    }
  }

  @Override
  protected void afterRender() {
    super.afterRender();
    wrap.removeStyleName(fieldStyle);
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    ComponentHelper.doAttach(button);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(button);
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
  protected void onBlur(ComponentEvent ce) {
    Rectangle rec = button.el().getBounds();
    if (rec.contains(BaseEventPreview.getLastXY())) {
      ce.stopEvent();
      return;
    }
    super.onBlur(ce);
    focusPreview.remove();
  }

  protected void onChange(ComponentEvent ce) {
    setValue(getFileInput().getValue());
  }

  @Override
  protected void onDetach() {
    super.onDetach();
    if (focusPreview != null) {
      focusPreview.remove();
    }
  }

  @Override
  protected void onFocus(ComponentEvent ce) {
    super.onFocus(ce);
    focusPreview.add();
  }

  @Override
  protected void onRender(Element target, int index) {
    wrap = new El(DOM.createDiv());
    wrap.addStyleName("x-form-field-wrap");
    wrap.addStyleName("x-form-file-wrap");

    input = new El(DOM.createInputText());
    input.addStyleName(fieldStyle);
    input.addStyleName("x-form-file-text");
    input.setId(XDOM.getUniqueId());

    if (GXT.isIE && target.getTagName().equals("TD")) {
      input.setStyleAttribute("position", "static");
    }

    file = new El((Element) Document.get().createFileInputElement().cast());
    file.setElementAttribute("size", 1);
    file.addStyleName("x-form-file");
    file.addEventsSunk(Event.ONCHANGE | Event.FOCUSEVENTS);
    file.setId(XDOM.getUniqueId());

    wrap.appendChild(input.dom);
    wrap.appendChild(file.dom);

    setElement(wrap.dom, target, index);

    button = new Button(getMessages().getBrowseText());
    button.addStyleName("x-form-file-btn");
    button.setIcon(buttonIcon);
    button.render(wrap.dom);

    super.onRender(target, index);
    super.setReadOnly(true);
    setName(getName());

    if (width == null) {
      setWidth(150);
    }
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    input.setWidth(adjustWidth("input", width - button.el().getWidth() - buttonOffset), true);
  }
}
/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.impl.FormPanelImpl;
import com.google.gwt.user.client.ui.impl.FormPanelImplHost;

/**
 * A panel for displaying form widgets. By default, FormPanel uses a FormLayout,
 * but this may be overridden when using nested layouts. See {@link FormLayout}
 * for more documentation.
 * 
 * <p/>
 * FormPanel supports nested layout containers. Fields should only be added to
 * layout containers with a form layout. The form panel settings only apply to
 * the panel's direct children.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeSubmit</b> : FormEvent(this)<br>
 * <div>Fires before the form is submitted. Only applies when using HTML
 * submits. Listeners can cancel the action by calling
 * {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>formPanel : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Submit</b> : FormEvent(this, resultHtml)<br>
 * <div>Fires after the form has been submitted. Only applies when using HTML
 * submits.</div>
 * <ul>
 * <li>formPanel : this</li>
 * <li>resultHtml : the response html</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>ContentPanel BeforeExpand</dd>
 * <dd>ContentPanel Expand</dd>
 * <dd>ContentPanel BeforeCollapse</dd>
 * <dd>ContentPanel Collapse</dd>
 * <dd>ContentPanel BeforeClose</dd>
 * <dd>ContentPanel Close</dd>
 * <dd>LayoutContainer AfterLayout</dd>
 * <dd>ScrollContainer Scroll</dd>
 * <dd>Container BeforeAdd</dd>
 * <dd>Container Add</dd>
 * <dd>Container BeforeRemove</dd>
 * <dd>Container Remove</dd>
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
public class FormPanel extends ContentPanel implements FormPanelImplHost {

  /**
   * Form encoding enumeration.
   */
  public enum Encoding {
    MULTIPART("multipart/form-data"), URLENCODED("application/x-www-form-urlencoded");
    private final String value;

    private Encoding(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }
  }

  /**
   * Label alignment enumeration.
   */
  public enum LabelAlign {
    LEFT, TOP, RIGHT;
  }

  /**
   * Form method enumeration.
   */
  public enum Method {
    GET, POST;
  }

  private static FormPanelImpl impl = GWT.create(FormPanelImpl.class);
  private static int formId = 0;
  private LabelAlign labelAlign = LabelAlign.LEFT;
  private int labelWidth = 75;
  private int fieldWidth = 210;
  private String labelSeparator = ":";
  private boolean hideLabels;
  private int padding = 10;
  private El form;
  private Method method = Method.GET;
  private Encoding encoding;
  private String action = "javascript:;";
  private String frameName;
  private Element iframe;
  private String target;

  /**
   * Creates a new form panel.
   */
  public FormPanel() {
    frameName = "gxt.formpanel-" + (++formId);
    setTarget(frameName);
  }

  /**
   * Clears all values from all fields.
   */
  public void clear() {
    for (Field<?> f : getFields()) {
      f.setValue(null);
    }
  }

  /**
   * Resets all field values.
   */
  public void reset() {
    for (Field<?> f : getFields()) {
      f.reset();
    }
  }

  /**
   * Returns the form's action.
   * 
   * @return the action url
   */
  public String getAction() {
    return action;
  }

  /**
   * Returns the encoding.
   * 
   * @return the encoding
   */
  public Encoding getEncoding() {
    return encoding;
  }

  /**
   * Returns all of the panel's child fields. Fields in nested containers are
   * included in the returned list.
   * 
   * @return the fields
   */
  public List<Field<?>> getFields() {
    List<Field<?>> fields = new ArrayList<Field<?>>();
    getChildFields(this, fields);
    return fields;
  }

  /**
   * Returns the field width.
   * 
   * @return the field width
   */
  public int getFieldWidth() {
    return fieldWidth;
  }

  /**
   * Returns true if labels are being hidden.
   * 
   * @return the hide label state
   */
  public boolean getHideLabels() {
    return hideLabels;
  }

  /**
   * Returns the label alignment.
   * 
   * @return the label alignment
   */
  public LabelAlign getLabelAlign() {
    return labelAlign;
  }

  /**
   * Returns the label separator.
   * 
   * @return the label separator
   */
  public String getLabelSeparator() {
    return labelSeparator;
  }

  /**
   * Returns the default width.
   * 
   * @return the label width
   */
  public int getLabelWidth() {
    return labelWidth;
  }

  @Override
  public El getLayoutTarget() {
    return form;
  }

  /**
   * Returns the form's method. Only applies when using standard HTML form
   * submits.
   * 
   * @return the method the method
   */
  public Method getMethod() {
    return method;
  }

  /**
   * Returns the panel's padding.
   * 
   * @return the padding
   */
  public int getPadding() {
    return padding;
  }

  /**
   * Gets the form's "target".
   * 
   * @return the form's target.
   */
  public String getTarget() {
    return target;
  }

  /**
   * Returns true if any of the form's fields are dirty.
   * 
   * @return true for dirty
   */
  public boolean isDirty() {
    for (Field<?> f : getFields()) {
      if (f.isDirty()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns true if the form is invalid.
   * 
   * @return true if all fields are valid
   */
  public boolean isValid() {
    return isValid(false);
  }

  /**
   * Returns the form's valid state by querying all child fields.
   * 
   * @param preventMark true for silent validation (no invalid event and field
   *          is not marked invalid)
   * 
   * @return true if all fields are valid
   */
  public boolean isValid(boolean preventMark) {
    boolean valid = true;
    for (Field<?> f : getFields()) {
      if (!f.isValid(preventMark)) {
        valid = false;
      }
    }
    return valid;
  }

  public boolean onFormSubmit() {
    UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
    if (handler != null) {
      return onFormSubmitAndCatch(handler);
    } else {
      return onFormSubmitImpl();
    }
  }

  public void onFrameLoad() {
    UncaughtExceptionHandler handler = GWT.getUncaughtExceptionHandler();
    if (handler != null) {
      onFrameLoadAndCatch(handler);
    } else {
      onFrameLoadImpl();
    }
  }

  /**
   * Sets the action of the form.
   * 
   * @param url the action
   */
  public void setAction(String url) {
    this.action = url;
    if (rendered) {
      form.dom.setAttribute("action", url);
    }
  }

  /**
   * Sets the encoding used for submitting this form.
   * 
   * @param encoding the encoding
   */
  public void setEncoding(Encoding encoding) {
    this.encoding = encoding;
    if (rendered) {
      impl.setEncoding(form.dom, encoding.value);
    }
  }

  /**
   * Sets the default field width (defaults to 210).
   * 
   * @param fieldWidth the field width
   */
  public void setFieldWidth(int fieldWidth) {
    this.fieldWidth = fieldWidth;
  }

  /**
   * True to hide field labels by default (defaults to false).
   * 
   * @param hideLabels true to hide labels
   */
  public void setHideLabels(boolean hideLabels) {
    this.hideLabels = hideLabels;
  }

  /**
   * Sets the label alignment.
   * 
   * @param align the alignment
   */
  public void setLabelAlign(LabelAlign align) {
    this.labelAlign = align;
  }

  /**
   * Sets the label separator (defaults to ':').
   * 
   * @param labelSeparator the label separator
   */
  public void setLabelSeparator(String labelSeparator) {
    this.labelSeparator = labelSeparator;
  }

  /**
   * Sets the default label width.
   * 
   * @param labelWidth the label width
   */
  public void setLabelWidth(int labelWidth) {
    this.labelWidth = labelWidth;
  }

  /**
   * Specifies if the form will be submitted using an HTTP Post or Get request
   * (defaults to GET).
   * 
   * @param method the method
   */
  public void setMethod(Method method) {
    this.method = method;
    if (rendered) {
      form.dom.setAttribute("method", method.name().toLowerCase());
    }
  }

  /**
   * Sets the padding to be applied to the forms children (defaults to 10).
   * 
   * @param padding the padding
   */
  public void setPadding(int padding) {
    this.padding = padding;
  }

  /**
   * Sets all of the panel's fields read only state.
   * 
   * @param readOnly true for read only
   */
  public void setReadOnly(boolean readOnly) {
    for (Field<?> f : getFields()) {
      f.setReadOnly(readOnly);
    }
  }

  /**
   * Submits the form.
   */
  public void submit() {
    if (fireEvent(Events.BeforeSubmit, new FormEvent(this))) {
      impl.submit(form.dom, iframe);
    }
  }

  @Override
  protected void onAttach() {
    super.onAttach();
    createFrame();
    XDOM.getBody().appendChild(iframe);
    impl.hookEvents(iframe, form.dom, this);
  }

  @Override
  protected void onDetach() {
    super.onDetach();
    impl.unhookEvents(iframe, form.dom);
    XDOM.getBody().removeChild(iframe);
    iframe = null;
  }

  @Override
  protected void onRemove(Component item) {
    super.onRemove(item);
    if (rendered && item.isRendered()) {
      El wrap = item.el().findParent(".x-form-item", 3);
      if (wrap != null) {
        wrap.removeFromParent();
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    body.setStyleAttribute("background", "none");

    form = new El(DOM.createForm());
    form.setStyleAttribute("overflow", "hidden");
    body.appendChild(form.dom);

    setMethod(method);
    setTarget(this.target);

    if (encoding != null) {
      setEncoding(encoding);
    }
    if (action != null) {
      setAction(action);
    }

    getLayoutTarget().setStyleAttribute("padding", padding + "px");

    if (getLayout() == null) {
      FormLayout layout = new FormLayout();
      layout.setDefaultWidth(fieldWidth);
      layout.setLabelWidth(labelWidth);
      layout.setLabelAlign(labelAlign);
      layout.setLabelSeparator(labelSeparator);
      layout.setHideLabels(hideLabels);
      setLayout(layout);
    }

    form.addEventsSunk(Event.ONLOAD);
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    if (!isAutoWidth() && !frame && GXT.isIE) {
      getLayoutTarget().setWidth(width - getFrameWidth() - 2, true);
    }
  }

  private void createFrame() {
    Element dummy = DOM.createDiv();
    DOM.setInnerHTML(dummy, "<iframe src=\"javascript:''\" name='" + frameName
        + "' style='position:absolute;width:0;height:0;border:0'>");

    iframe = DOM.getFirstChild(dummy);
  }

  @SuppressWarnings("unchecked")
  private void getChildFields(Container<Component> c, List<Field<?>> fields) {
    for (Component comp : c.getItems()) {
      if (comp instanceof Field) {
        fields.add((Field) comp);
      } else if (comp instanceof Container) {
        getChildFields((Container) comp, fields);
      }
    }
  }

  private boolean onFormSubmitAndCatch(UncaughtExceptionHandler handler) {
    try {
      return onFormSubmitImpl();
    } catch (Throwable e) {
      handler.onUncaughtException(e);
      return false;
    }
  }

  private boolean onFormSubmitImpl() {
    return fireEvent(Events.BeforeSubmit, new FormEvent(this));
  }

  private void onFrameLoadAndCatch(UncaughtExceptionHandler handler) {
    try {
      onFrameLoadImpl();
    } catch (Throwable e) {
      handler.onUncaughtException(e);
    }
  }

  private void onFrameLoadImpl() {
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        fireEvent(Events.Submit, new FormEvent(FormPanel.this, impl.getContents(iframe)));
      }
    });
  }

  private void setTarget(String target) {
    this.target = target;
    if (rendered) {
      form.dom.setPropertyString("target", target);
    }
  }

}

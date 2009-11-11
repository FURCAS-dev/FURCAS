/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.form.AdapterField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.google.gwt.user.client.Element;

/**
 * Layout for form fields and their labels. FormLayout will only render Field
 * subclasses. All other components will be ignored.
 * 
 * <p/>
 * To add a component that is not a Field subclass, see {@link AdapterField}. To
 * add plain text see {@link LabelField}.
 */
public class FormLayout extends AnchorLayout {

  private LabelAlign labelAlign = LabelAlign.LEFT;
  private boolean hideLabels;
  private String labelSeparator = ":";
  private int labelWidth = 100;
  private int defaultWidth = 200;
  private Template fieldTemplate;
  private String labelStyle;
  private String elementStyle;
  private int labelPad = 5;
  private int labelAdjust;

  /**
   * Creates a new form layout.
   */
  public FormLayout() {
  }

  /**
   * Creates a new form layout.
   * 
   * @param labelAlign the label alignment
   */
  public FormLayout(LabelAlign labelAlign) {
    this();
    this.labelAlign = labelAlign;
  }

  /**
   * Returns the default field width.
   * 
   * @return the default field width
   */
  public int getDefaultWidth() {
    return defaultWidth;
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
   * Returns the label pad.
   * 
   * @return the label pad
   */
  public int getLabelPad() {
    return labelPad;
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
   * Returns the label width.
   * 
   * @return the label width
   */
  public int getLabelWidth() {
    return labelWidth;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void setContainer(final Container ct) {
    super.setContainer(ct);

    if (labelAlign != null) {
      ct.addStyleName("x-form-label-" + labelAlign.name().toLowerCase());
    }

    if (hideLabels) {
      labelStyle = "display:none";
      elementStyle = "padding-left:0;";
      labelAdjust = 0;
    } else {
      int pad = labelPad != 0 ? labelPad : 5;
      labelAdjust = labelWidth + pad;
      labelStyle = "width:" + (labelWidth) + "px";
      elementStyle = "padding-left:" + (labelWidth + pad) + "px";
      if (labelAlign == LabelAlign.TOP) {
        labelStyle = "width:auto;";
        elementStyle = "padding-left:0;";
        labelAdjust = 0;
      }
    }

    if (fieldTemplate == null) {
      StringBuffer sb = new StringBuffer();
      sb.append("<div class='x-form-item {5}' tabIndex='-1'>");
      sb.append("<label for={0} style='{2};{7}' class=x-form-item-label>{1}{4}</label>");
      sb.append("<div class='x-form-element' id='x-form-el-{0}' style='{3}'>");
      sb.append("</div><div class='{6}'></div>");
      sb.append("</div>");
      fieldTemplate = new Template(sb.toString());
      fieldTemplate.compile();
    }

  }

  /**
   * Sets the default width for fields (defaults to 200).
   * 
   * @param defaultWidth the default width
   */
  public void setDefaultWidth(int defaultWidth) {
    this.defaultWidth = defaultWidth;
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
   * @param labelAlign the label align
   */
  public void setLabelAlign(LabelAlign labelAlign) {
    this.labelAlign = labelAlign;
  }

  /**
   * The default padding in pixels for field labels (defaults to 0). labelPad
   * only applies if labelWidth is also specified, otherwise it will be ignored.
   * 
   * @param labelPad the label pad
   */
  public void setLabelPad(int labelPad) {
    this.labelPad = labelPad;
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
   * Sets the default width in pixels of field labels (defaults to 100).
   * 
   * @param labelWidth the label width
   */
  public void setLabelWidth(int labelWidth) {
    this.labelWidth = labelWidth;
  }

  @Override
  protected int adjustWidthAnchor(int width, Component comp) {
    if (comp instanceof Field) {
      Field<?> f = (Field<?>) comp;
      width = width - (f.isHideLabel() ? 0 : labelAdjust);
    }
    return super.adjustWidthAnchor(width, comp);
  }

  @Override
  protected boolean isValidParent(Element elem, Element parent) {
    return true;
  }

  protected void onRemove(Component field) {
    if (field.isRendered()) {
      El elem = field.el().findParent(".x-form-item", 5);
      if (elem != null) {
        elem.removeFromParent();
      }
    }
  }

  @Override
  protected void renderComponent(Component component, int index, El target) {
    if (component instanceof Field && !(component instanceof HiddenField)) {
      Field<?> f = (Field<?>) component;
      renderField((Field<?>) component, index, target);
      FormData formData = (FormData) getLayoutData(f);
      if (formData == null) {
        formData = f.getData("formData");
      }

      f.setWidth(defaultWidth);
      if (formData != null) {
        if (formData.getWidth() > 0) {
          f.setWidth(formData.getWidth());
        }
        if (formData.getHeight() > 0) {
          f.setHeight(formData.getHeight());
        }
      }
    } else {
      super.renderComponent(component, index, target);
    }
  }

  private void renderField(Field<?> field, int index, El target) {
    if (field != null && !field.isRendered()) {
      String ls = field.getLabelSeparator() != null ? field.getLabelSeparator()
          : labelSeparator;
      field.setLabelSeparator(ls);

      Params p = new Params();
      p.add(field.getId());
      p.add(field.getFieldLabel());
      p.add(labelStyle);
      p.add(elementStyle);
      p.add(ls);
      p.add(field.isHideLabel() ? "x-hide-label" : "");
      p.add("x-form-clear-left");
      p.add(field.getLabelStyle());

      fieldTemplate.insert(target.dom, index, p);
      field.render(target.selectNode("#x-form-el-" + field.getId()).dom);
    } else {
      super.renderComponent(field, index, target);
    }
  }

}

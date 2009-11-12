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
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A field that displays multiple fields in a single row or column.
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
public class MultiField<D> extends Field<D> {

  protected List<Field<?>> fields;
  protected LayoutContainer lc;
  protected Validator validator;
  protected Orientation orientation = Orientation.HORIZONTAL;
  protected int spacing;
  private boolean resizeFields;

  /**
   * Creates a new multi-field.
   */
  public MultiField() {
    fields = new ArrayList<Field<?>>();
    baseStyle = "x-form-group";
    invalidStyle = "none";
  }

  /**
   * Creates a new multi-field.
   * 
   * @param fieldLabel the field label
   * @param fields the field(s) to add
   */
  public MultiField(String fieldLabel, Field<?>... fields) {
    this();
    setFieldLabel(fieldLabel);
    for (Field<?> f : fields) {
      add(f);
    }
  }

  /**
   * Adds a field (pre-render).
   * 
   * @param field the field to add
   */
  public void add(Field<?> field) {
    assertPreRender();
    fields.add(field);
  }

  @Override
  public void disable() {
    super.disable();
    for (Field<?> field : fields) {
      field.disable();
    }
  }

  @Override
  public void enable() {
    super.enable();
    for (Field<?> field : fields) {
      field.enable();
    }
  }

  /**
   * Returns the field at the index.
   * 
   * @param index the index
   * @return the field
   */
  public Field<?> get(int index) {
    return fields.get(index);
  }

  /**
   * Returns all the child field's.
   * 
   * @return the fields
   */
  public List<Field<?>> getAll() {
    return new ArrayList<Field<?>>(fields);
  }

  /**
   * Returns the fields orientation.
   * 
   * @return the orientation
   */
  public Orientation getOrientation() {
    return (orientation);
  }

  /**
   * Returns the field's spacing.
   * 
   * @return the spacing
   */
  public int getSpacing() {
    return spacing;
  }

  /**
   * Returns the field's validator.
   * 
   * @return the validator
   */
  public Validator getValidator() {
    return validator;
  }

  /**
   * Returns true if child fields are being resized.
   * 
   * @return the resize field state
   */
  public boolean isResizeFields() {
    return resizeFields;
  }

  @Override
  public boolean isValid(boolean silent) {
    boolean ret = super.isValid(silent);
    for (Field<?> f : fields) {
      if (!f.isValid(silent)) {
        return false;
      }
    }
    return ret;
  }

  @Override
  public void onBrowserEvent(Event event) {

  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {

  }

  @Override
  public void reset() {
    for (Field<?> f : fields) {
      f.reset();
    }
  }

  /**
   * Sets the fields orientation (defaults to horizontal).
   * 
   * @param orientation the orientation
   */
  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
  }

  @Override
  public void setReadOnly(boolean readOnly) {
    for (Field<?> field : fields) {
      field.setReadOnly(readOnly);
    }
  }

  /**
   * True to resize the child fields to fit available space (defaults to false).
   * 
   * @param resizeFields true to resize children
   */
  public void setResizeFields(boolean resizeFields) {
    this.resizeFields = resizeFields;
  }

  /**
   * Sets the amount of spacing between fields. Spacing is applied to the right
   * of each field for horizontal orientation and applied to the bottom of each
   * field for vertical orientation (defaults to 0, pre-render).
   * 
   * @param spacing the spacing in pixels
   */
  public void setSpacing(int spacing) {
    this.spacing = spacing;
  }

  /**
   * Sets the field's validator.
   * 
   * @param validator the validator
   */
  public void setValidator(Validator validator) {
    this.validator = validator;
  }

  @Override
  protected void doAttachChildren() {
    ComponentHelper.doAttach(lc);
  }

  @Override
  protected void doDetachChildren() {
    ComponentHelper.doDetach(lc);
  }

  @Override
  protected El getInputEl() {
    if (fields.size() > 0) {
      return fields.get(0).getInputEl();
    }
    return super.getInputEl();
  }

  @Override
  protected void onRender(Element target, int index) {
    boolean vertical = orientation == Orientation.VERTICAL;
    if (vertical) {
      lc = new VerticalPanel();
    } else {
      lc = new HorizontalPanel();
    }
    
    if(GXT.isIE) {
      lc.setStyleAttribute("position", "relative");
    }

    for (int i = 0, len = fields.size(); i < len; i++) {
      Field<?> f = fields.get(i);
      boolean last = i == (fields.size() - 1);
      TableData data = (TableData) ComponentHelper.getLayoutData(f);
      if (data == null) {
        data = new TableData();
      }
      String style = "position: static;";

      if (vertical && !last && spacing > 0) {
        style += "paddingBottom:" + spacing + "px;";
      } else if (!vertical && spacing > 0) {
        style += "paddingRight:" + spacing + "px;";
      }
      data.setStyle(style);

      lc.add(f, data);
    }

    lc.render(target, index);
    setElement(lc.getElement());
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    if (resizeFields) {
      if (orientation == Orientation.HORIZONTAL) {
        int w = width / fields.size();
        w -= (fields.size() * spacing);
        for (Field<?> f : fields) {
          f.setWidth(w);
        }
      } else {
        for (Field<?> f : fields) {
          f.setWidth(width);
        }
      }
    }
    if(GXT.isIE){
      el().repaint();
    }
  }

  @Override
  protected boolean validateValue(String value) {
    // validate multi field
    if (validator != null) {
      String msg = validator.validate(this, value);
      if (msg != null) {
        markInvalid(msg);
        return false;
      }
    }

    clearInvalid();
    return true;
  }
}

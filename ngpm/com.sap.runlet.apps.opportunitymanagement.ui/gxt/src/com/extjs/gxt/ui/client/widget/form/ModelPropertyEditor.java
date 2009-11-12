/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * <code>PropertyEditor</code> for model instances.
 * 
 * @param <Data> the model type
 */
public abstract class ModelPropertyEditor<Data extends ModelData> implements PropertyEditor<Data> {

  protected String displayProperty = "text";

  /**
   * Creates a new model property editor.
   */
  public ModelPropertyEditor() {

  }

  /**
   * Creates a new model property editor.
   * 
   * @param displayProperty the display property
   */
  public ModelPropertyEditor(String displayProperty) {
    this.displayProperty = displayProperty;
  }

  /**
   * Returns the display property.
   * 
   * @return the display property name
   */
  public String getDisplayProperty() {
    return displayProperty;
  }

  public String getStringValue(Data value) {
    Object obj = value.get(displayProperty);
    if (obj != null) {
      return obj.toString();
    }
    return null;
  }

  /**
   * Sets the display property name.
   * 
   * @param displayProperty the display property name
   */
  public void setDisplayProperty(String displayProperty) {
    this.displayProperty = displayProperty;
  }

}

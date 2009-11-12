/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * <code>PropertyEditor</code> for a list of model instances.
 * 
 * @param <Data> the model data type
 */
public class ListModelPropertyEditor<Data extends ModelData> extends ModelPropertyEditor<Data> {

  protected List<Data> models;

  /**
   * Creates a new property editor.
   */
  public ListModelPropertyEditor() {

  }

  /**
   * Creates a new property editor.
   * 
   * @param displayProperty the display property name
   */
  public ListModelPropertyEditor(String displayProperty) {
    super(displayProperty);
  }

  /**
   * Sets the list of models.
   * 
   * @param models the list of models
   */
  public void setList(List<Data> models) {
    this.models = models;
  }

  public Data convertStringValue(String value) {
    for (Data d : models) {
      Object val = d.get(displayProperty);
      if (value.equals(val != null ? val.toString() : null)) {
        return d;
      }
    }
    return null;
  }

}

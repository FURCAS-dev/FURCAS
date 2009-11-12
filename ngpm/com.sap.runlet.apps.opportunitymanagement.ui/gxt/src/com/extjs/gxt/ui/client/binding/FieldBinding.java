/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binding;

import com.extjs.gxt.ui.client.data.ChangeEvent;
import com.extjs.gxt.ui.client.data.ChangeEventSource;
import com.extjs.gxt.ui.client.data.ChangeListener;
import com.extjs.gxt.ui.client.data.Model;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PropertyChangeEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.form.Field;

/**
 * A two-way binding between a ModelData and Field instance. The binding will be
 * 1-way when the bound model does not support change events.
 * 
 * @see ModelData
 * @see Field
 */
@SuppressWarnings("unchecked")
public class FieldBinding {

  protected Field field;
  protected ModelData model;
  protected String property;
  protected Store store;

  private Listener<FieldEvent> changeListener;
  private ChangeListener modelListener;
  private Converter convertor;

  /**
   * Creates a new binding instance.
   * 
   * @param field the bound field for the binding
   */
  public FieldBinding(Field field, String property) {
    this.field = field;
    this.property = property;

    changeListener = new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        onFieldChange(be);
      }
    };

    modelListener = new ChangeListener() {
      public void modelChanged(ChangeEvent event) {
        if (event.getType() == ChangeEventSource.Update) {
          onModelChange((PropertyChangeEvent) event);
        }
      }
    };
  }

  /**
   * Binds the model and field.
   * 
   * @param model the model to be bound
   */
  public void bind(ModelData model) {
    if (this.model != null) {
      unbind();
    }
    this.model = model;
    field.addListener(Events.Change, changeListener);
    if (model instanceof Model) {
      ((Model) model).addChangeListener(modelListener);
    }
    updateField();
  }

  /**
   * Returns the bindings converter.
   * 
   * @return the converter
   */
  public Converter getConvertor() {
    return convertor;
  }

  /**
   * Returns the bound field.
   * 
   * @return the field
   */
  public Field<Object> getField() {
    return field;
  }

  /**
   * Returns the bound model instance.
   * 
   * @return the model
   */
  public ModelData getModel() {
    return model;
  }

  /**
   * Returns the model's bound property name.
   * 
   * @return the property name
   */
  public String getProperty() {
    return property;
  }

  /**
   * Returns the binding's store.
   * 
   * @return the store or null
   */
  public Store getStore() {
    return store;
  }

  /**
   * Sets the converter which is used to translate data types when updating
   * either the field or model.
   * 
   * @param convertor the converter
   */
  public void setConvertor(Converter convertor) {
    this.convertor = convertor;
  }

  /**
   * Sets the store for the binding. When a store is specified edits are done
   * via Records instances obtained from the Store.
   * 
   * @param store the store
   */
  public void setStore(Store<? extends ModelData> store) {
    this.store = store;
  }

  /**
   * Unbinds the model and field by removing all listeners.
   */
  public void unbind() {
    if (model != null) {
      if (model instanceof Model) {
        ((Model) model).removeChangeListener(modelListener);
      }
      model = null;
    }
    field.removeListener(Events.Change, changeListener);
  }

  /**
   * Updates the field's value with the model value.
   */
  public void updateField() {
    Object val = onConvertModelValue(model.get(property));
    field.setValue(val);
  }
  
  /**
   * Updates the model's value with the field value.
   */
  public void updateModel() {
    Object val = onConvertFieldValue(field.getValue());
    if (store != null) {
      Record r = store.getRecord(model);
      if (r != null) {
        r.setValid(property, field.isValid());
        r.set(property, val);
      }
    } else {
      model.set(property, val);
    }

  }
  
  protected Object onConvertFieldValue(Object value) {
    if (convertor != null) {
      return convertor.convertFieldValue(value);
    }
    return value;
  }

  protected Object onConvertModelValue(Object value) {
    if (convertor != null) {
      return convertor.convertModelValue(value);
    }
    return value;
  }

  protected void onFieldChange(FieldEvent e) {
    updateModel();
  }

  protected void onModelChange(PropertyChangeEvent event) {
    if (event.getName().equals(property)) {
      updateField();
    }
  }

}

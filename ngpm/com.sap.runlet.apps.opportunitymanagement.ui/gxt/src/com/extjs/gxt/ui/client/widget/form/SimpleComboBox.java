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

import com.extjs.gxt.ui.client.store.ListStore;

/**
 * A <code>ComboBox</code> subclass that supports any simple data types.
 * SimpleComboBox creates and manages a <code>ListStore</code> of
 * <code>SimpleComboBox</code> instances. You can call
 * {@link SimpleComboValue#getValue()} to obtain the simple value.
 * 
 * <pre><code>
 * SimpleComboBox<String> combo = new SimpleComboBox<String>();
 * combo.add("Darrell");
 * combo.add("Maro");
 * combo.add("Lia");
 * combo.setSimpleValue("Maro");
 * </code></pre>
 * 
 * @param <T> the data type
 */
public class SimpleComboBox<T> extends ComboBox<SimpleComboValue<T>> {

  /**
   * Creates a new simple combo box.
   */
  public SimpleComboBox() {
    setDisplayField("value");
    setStore(new ListStore<SimpleComboValue<T>>());
  }

  /**
   * Adds the values to the list.
   * 
   * @param values the values
   */
  @SuppressWarnings("unchecked")
  public void add(List<T> values) {
    List list = new ArrayList();
    for (T t : values) {
      list.add(new SimpleComboValue(t));
    }
    store.add(list);
  }

  /**
   * Adds the value.
   * 
   * @param value the value
   */
  public void add(T value) {
    store.add(new SimpleComboValue<T>(value));
  }

  /**
   * Returns the model for the given value.
   * 
   * @param value the value
   * @return the corresponding model for the value
   */
  public SimpleComboValue<T> findModel(T value) {
    SimpleComboValue<T> val = null;
    for (SimpleComboValue<T> c : store.getModels()) {
      if (c.getValue().equals(value)) {
        val = c;
        break;
      }
    }
    return val;
  }

  /**
   * Returns the selected index.
   * 
   * @return the index or -1 if no selection
   */
  public int getSelectedIndex() {
    SimpleComboValue<T> c = getValue();
    if (c != null) {
      return store.indexOf(c);
    }
    return -1;
  }

  /**
   * Returns the simple value.
   * 
   * @return the value
   */
  @SuppressWarnings("unchecked")
  public T getSimpleValue() {
    SimpleComboValue<T> c = getValue();
    if (c != null) {
      return c.<T> get("value");
    }
    try {
      return (T) getRawValue();
    } catch (Exception e) {
      return null;
    }

  }

  /**
   * Removes the value.
   * 
   * @param value the value
   */
  public void remove(T value) {
    for (SimpleComboValue<T> c : store.getModels()) {
      if (c.getValue().equals(value)) {
        store.remove(c);
      }
    }
  }

  /**
   * Removes all the values.
   */
  public void removeAll() {
    store.removeAll();
  }

  /**
   * Sets the combo value.
   * 
   * @param value the value
   */
  public void setSimpleValue(T value) {
    SimpleComboValue<T> c = findModel(value);
    if (c != null) {
      setValue(c);
    }
  }

}

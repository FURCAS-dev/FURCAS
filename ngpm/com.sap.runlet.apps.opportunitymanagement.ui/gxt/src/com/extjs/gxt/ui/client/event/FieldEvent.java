/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.user.client.Event;

/**
 * Field event type.
 * 
 * @see Field
 */
public class FieldEvent extends BoxComponentEvent {

  /**
   * The source field.
   */
  private Field<?> field;

  /**
   * The message.
   */
  private String message;

  /**
   * The old value.
   */
  private Object oldValue;

  /**
   * The new value.
   */
  private Object value;

  public FieldEvent(Field<?> field) {
    super(field);
    this.field = field;
  }

  public FieldEvent(Field<?> field, Event event) {
    this(field);
    this.event = event;
  }

  /**
   * Returns the source field.
   * 
   * @return the field
   */
  public Field<?> getField() {
    return field;
  }

  /**
   * Returns the message.
   * 
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Returns the old value.
   * 
   * @return the old value
   */
  public Object getOldValue() {
    return oldValue;
  }

  /**
   * Returns the value.
   * 
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * Sets the field.
   * 
   * @param field the field
   */
  public void setField(Field<?> field) {
    this.field = field;
  }

  /**
   * Sets the message.
   * 
   * @param message the message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Sets the old value.
   * 
   * @param oldValue the old value
   */
  public void setOldValue(Object oldValue) {
    this.oldValue = oldValue;
  }

  /**
   * Sets the value.
   * 
   * @param value the value
   */
  public void setValue(Object value) {
    this.value = value;
  }

}

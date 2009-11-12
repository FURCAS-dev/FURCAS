/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.Editor;

/**
 * Editor event type.
 * 
 * @see Editor
 */
public class EditorEvent extends DomEvent {

  /**
   * The underlying element bound to the editor.
   */
  private El boundEl;

  /**
   * The source editor.
   */
  private Editor editor;

  /**
   * The start value.
   */
  private Object startValue;

  /**
   * The current field value.
   */
  private Object value;

  public EditorEvent(Editor editor) {
    super(editor);
    this.editor = editor;
  }

  /**
   * Returns the bound element.
   * 
   * @return the element
   */
  public El getBoundEl() {
    return boundEl;
  }

  /**
   * Returns the source editor.
   * 
   * @return the editor
   */
  public Editor getEditor() {
    return editor;
  }

  /**
   * Returns the start value.
   * 
   * @return the start value
   */
  public Object getStartValue() {
    return startValue;
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
   * Sets the bound element.
   * 
   * @param boundEl the element
   */
  public void setBoundEl(El boundEl) {
    this.boundEl = boundEl;
  }

  /**
   * Sets the source editor.
   * 
   * @param editor the editor
   */
  public void setEditor(Editor editor) {
    this.editor = editor;
  }

  /**
   * Sets the start value.
   * 
   * @param startValue the start value
   */
  public void setStartValue(Object startValue) {
    this.startValue = startValue;
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

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.Map;

import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;

/**
 * RowEditor event type.
 */
public class RowEditorEvent extends BoxComponentEvent {

  private RowEditor<?> editor;
  private int rowIndex;
  private Record record;
  private Map<String, Object> changes;
  
  @SuppressWarnings("unchecked")
  public RowEditorEvent(RowEditor editor) {
    super(editor);
    this.editor = editor;
  }
  
  @SuppressWarnings("unchecked")
  public RowEditorEvent(RowEditor editor, int rowIndex) {
    this(editor);
    this.rowIndex = rowIndex;
  }

  public Map<String, Object> getChanges() {
    return changes;
  }

  public RowEditor<?> getEditor() {
    return editor;
  }

  public Record getRecord() {
    return record;
  }

  public int getRowIndex() {
    return rowIndex;
  }

  public void setChanges(Map<String, Object> changes) {
    this.changes = changes;
  }

  public void setEditor(RowEditor<?> editor) {
    this.editor = editor;
  }

  public void setRecord(Record record) {
    this.record = record;
  }

  public void setRowIndex(int rowIndex) {
    this.rowIndex = rowIndex;
  }

}

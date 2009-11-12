/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

public interface EditSupport {

  public CellEditor getActiveEditor();
  
  public void startEditing(final int row, final int col);
  
  public boolean isEditing();
  
}

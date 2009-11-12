/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.table;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.selection.AbstractSelectionModel;

/**
 * Table selection model.
 * 
 * @deprecated see {@link Grid}
 */
public class TableSelectionModel extends AbstractSelectionModel<Table, TableItem> {

  public TableSelectionModel() {
    super();
  }

  public TableSelectionModel(SelectionMode mode) {
    super(mode);
  }

  @Override
  protected void doSelectChange(TableItem item, boolean select) {
    if (locked) return;
    container.getView().onSelectItem(item, select);
  }

}

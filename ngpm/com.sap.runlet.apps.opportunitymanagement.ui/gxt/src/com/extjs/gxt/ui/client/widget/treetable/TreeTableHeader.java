/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treetable;

import com.extjs.gxt.ui.client.widget.table.BaseTable;
import com.extjs.gxt.ui.client.widget.table.TableHeader;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;

/**
 * @deprecated see @link {@link TreeGrid}
 */
public class TreeTableHeader extends TableHeader {

  public TreeTableHeader(TreeTable treeTable) {
    super(treeTable);
  }

  public void init(BaseTable table) {
    super.init(table);
  }

  protected void updateSplitBars() {
    super.updateSplitBars();
  }

  protected void resizeColumns(boolean fireEvent, boolean resizeBody) {
    super.resizeColumns(fireEvent, resizeBody);
  }

  protected void doTableComponentResize() {
    if (table instanceof TreeTable) {
      ((TreeTable) table).getView().resize();
    } else {
      super.doTableComponentResize();
    }
  }

  protected void doTableComponentResizeCells(int columnIndex) {
    if (table instanceof TreeTable) {
      ((TreeTable) table).getView().resizeCells(columnIndex);
    } else {
      super.doTableComponentResizeCells(columnIndex);
    }
  }

  protected void doTableComponentShowColumn(int index, boolean show) {
    if (table instanceof TreeTable) {
      ((TreeTable) table).getView().showColumn(index, show);
    } else {
      super.doTableComponentShowColumn(index, show);
    }
  }
}

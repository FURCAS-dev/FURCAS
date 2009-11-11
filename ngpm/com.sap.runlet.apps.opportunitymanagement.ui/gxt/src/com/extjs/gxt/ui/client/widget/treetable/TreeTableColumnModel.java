/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treetable;

import java.util.List;

import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;

/**
 * ColumnModel used by the <code>TreeTable</code>.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>Resize</b> : (this,widget,index)<br>
 * <div>Fires after a column is resized.</div>
 * <ul>
 * <li>source : this</li>
 * <li>widget : table</li>
 * <li>index : column index</li>
 * </ul>
 * </dd>
 * 
 * @deprecated see @link {@link TreeGrid}
 */
public class TreeTableColumnModel extends TableColumnModel {

  /**
   * Constructs a new instance.
   */
  public TreeTableColumnModel(List<TreeTableColumn> columns) {
    super(columns);
  }

  @Override
  protected int getVariableColumnCount() {
    return super.getVariableColumnCount();
  }

  @Override
  protected int getVariableWidth() {
    return super.getVariableWidth();
  }

  @Override
  protected int getWidthInPixels(int index) {
    return super.getWidthInPixels(index);
  }

  @Override
  protected void setWidthAsPercent(int index, float width) {
    super.setWidthAsPercent(index, width);
  }
}

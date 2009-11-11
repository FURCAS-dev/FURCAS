/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treetable;

import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;

/**
 * A column in a <code>TreeTable</code>. Column sizes can be specified as either
 * pixels or percentages. Width values less than or equal to 1 are treated as
 * percentages.
 * 
 * <p>
 * Note: Public members should not be modified after the column is added to a
 * column model.
 * </p>
 * 
 * @deprecated see {@link TreeGrid}
 */
public class TreeTableColumn extends TableColumn {

  /**
   * Creates a new column instance.
   * 
   * @param id the column id
   * @param width the column width, widths that are 1 or less are treated as
   *          percentages.
   */
  public TreeTableColumn(String id, float width) {
    super(id, width);
    this.setSortable(false);
  }

  /**
   * Creates a new column instance.
   * 
   * @param id the column id
   * @param text the column text
   * @param width the width
   */
  public TreeTableColumn(String id, String text, float width) {
    super(id, text, width);
    this.setSortable(false);
  }

  /**
   * Creates a new column instance.
   * 
   * @param id the column id
   * @param text the column text
   */
  public TreeTableColumn(String id, String text) {
    super(id, text);
    this.setSortable(false);
  }

  protected void setIndex(int index) {
    super.setIndex(index);
  }

  protected int getIndex() {
    return super.getIndex();
  }

}

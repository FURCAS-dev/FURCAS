/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.google.gwt.user.client.Event;

@SuppressWarnings("unchecked")
public class TreeGridEvent<M extends ModelData> extends GridEvent<M> {

  private TreeGrid<M> treeGrid;

  public TreeGridEvent(TreeGrid<M> grid, Event event) {
    super(grid, event);
    this.treeGrid = (TreeGrid) grid;
  }

  public TreeGridEvent(TreeGrid<M> grid) {
    super(grid);
    this.treeGrid = (TreeGrid) grid;
  }

  public TreeGrid<M> getTreeGrid() {
    return treeGrid;
  }

  public void setTreeGrid(TreeGrid<M> treeGrid) {
    this.treeGrid = treeGrid;
  }

}

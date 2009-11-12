/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treegrid;

import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.Joint;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * A <code>GridCellRenderer</code> that renders a tree into it's column.
 * Renderer may be used in any column, not just the first.
 */
public class TreeGridCellRenderer<M extends ModelData> implements GridCellRenderer<M> {
  
  @SuppressWarnings("unchecked")
  public Object render(M model, String property, ColumnData config, int rowIndex,
      int colIndex, ListStore<M> store, Grid<M> grid) {
    config.css = "x-treegrid-column";
    
    TreeGrid tree = (TreeGrid)grid;
    TreeStore ts = tree.getTreeStore();
    Joint j = tree.calcualteJoint(model);
    AbstractImagePrototype iconStyle = tree.calculateIconStyle(model);
    int level = ts.getDepth(model);
    
    
    
    String text = model.get(property);
    String id = XDOM.getUniqueId();
    return tree.getTreeView().getTemplate(model, id, text, iconStyle, false, j, level - 1);
  }
}

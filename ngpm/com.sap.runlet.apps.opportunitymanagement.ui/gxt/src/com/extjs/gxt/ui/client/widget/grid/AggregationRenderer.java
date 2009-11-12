/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;

/**
 * Renderer for aggregation rows in a grid.
 * 
 * @param <M> the model type
 */
public interface AggregationRenderer<M extends ModelData> {

  /**
   * Returns the rendered HTML or Widget for the given cell.
   * 
   * @param value the calculated value if a summary type has been specified
   * @param colIndex the column index
   * @param grid the containing grid
   * @param store the list store
   * @return the rendered data either as a string or widget
   */
  public Object render(Number value, int colIndex, Grid<M> grid, ListStore<M> store);

}

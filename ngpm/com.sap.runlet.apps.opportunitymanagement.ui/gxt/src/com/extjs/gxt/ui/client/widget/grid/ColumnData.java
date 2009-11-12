/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import com.extjs.gxt.ui.client.data.ModelData;

public class ColumnData {

  /**
   * The cell renderer.
   */
  public GridCellRenderer<ModelData> renderer;

  /**
   * The column id.
   */
  public String id;

  /**
   * The column name.
   */
  public String name;

  /**
   * The column style.
   */
  public String style;

  /**
   * The column cell attributes.
   */
  public String cellAttr;

  /**
   * The column css.
   */
  public String css;

}

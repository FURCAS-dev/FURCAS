/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

/**
 * Renderer used to render a grids group row.
 */
public interface GridGroupRenderer {

  /**
   * Returns the HTML for a group.
   * 
   * @param data the group column data
   * @return the HTML
   */
  public String render(GroupColumnData data);

}

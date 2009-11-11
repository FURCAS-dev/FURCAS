/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * List load config with support for grouping.
 */
public interface GroupingLoadConfig extends ListLoadConfig {

  /**
   * Returns the group by field.
   * 
   * @return the group by field
   */
  public String getGroupBy();

  /**
   * Sets the group by field.
   * 
   * @param groupBy the group by field
   */
  public void setGroupBy(String groupBy);

}

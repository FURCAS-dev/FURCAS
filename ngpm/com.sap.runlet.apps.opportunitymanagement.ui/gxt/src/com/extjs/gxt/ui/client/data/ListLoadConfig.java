/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.extjs.gxt.ui.client.Style.SortDir;

/**
 * Load config interface for list based data.
 */
public interface ListLoadConfig extends LoadConfig {

  public SortDir getSortDir();

  public String getSortField();

  /**
   * Returns the sort info.
   */
  public SortInfo getSortInfo();

  public void setSortDir(SortDir sortDir);

  public void setSortField(String sortField);

  /**
   * Sets the sort info.
   */
  public void setSortInfo(SortInfo info);
}
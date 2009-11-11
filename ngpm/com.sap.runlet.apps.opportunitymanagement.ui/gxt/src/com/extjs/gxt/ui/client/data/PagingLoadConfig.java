/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * A <code>ListLoadConfig</code> with support for limit and offset values.
 */
public interface PagingLoadConfig extends ListLoadConfig {

  /**
   * Sets the limit.
   * 
   * @param limit the limit
   */
  public void setLimit(int limit);

  /**
   * Sets the offset.
   * 
   * @param offset the offset
   */
  public void setOffset(int offset);

  /**
   * The number of records being requested.
   */
  public int getLimit();

  /**
   * The offset for the first record to retrieve.
   */
  public int getOffset();
}

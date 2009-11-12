/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * A <code>LoadResult</code> for paging loaders.
 * 
 * @param <Data> the data type
 */
public interface PagingLoadResult<Data> extends ListLoadResult<Data> {

  /**
   * Returns the current offset of the results.
   * 
   * @return the offset
   */
  public int getOffset();

  /**
   * Returns the total count. This value will not equal the number of records
   * being returned when paging is used.
   * 
   * @return the total count
   */
  public int getTotalLength();

  /**
   * Sets the offset.
   * 
   * @param offset the offset
   */
  public void setOffset(int offset);

  /**
   * Sets the total length.
   * 
   * @param totalLength the total length
   */
  public void setTotalLength(int totalLength);
}

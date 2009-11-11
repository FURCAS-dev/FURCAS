/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * A loader for a pageable set of data.
 * 
 * @param <D> the <code>PagingLoadResult</code> type being returned by the
 *          loader
 */
public interface PagingLoader<D extends PagingLoadResult<?>> extends ListLoader<D> {

  /**
   * Returns the current limit.
   * 
   * @return the current limit
   */
  public int getLimit();

  /**
   * Returns the offset of the first record.
   * 
   * @return the current offset
   */
  public int getOffset();

  /**
   * Returns the total number of models in the dataset as returned by the
   * server.
   * 
   * @return the number of models as passed from the server
   */
  public int getTotalCount();

  /**
   * Loads the data using the specified configuration.
   * 
   * @param offset the offset of the first record to return
   * @param pageSize the page size
   */
  public void load(int offset, int pageSize);

  /**
   * Sets the limit size.
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

}

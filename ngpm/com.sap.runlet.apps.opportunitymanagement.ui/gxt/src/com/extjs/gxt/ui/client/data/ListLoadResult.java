/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.List;

/**
 * Load result interface for list based load results.
 * 
 * @param <Data> the result data type
 */
public interface ListLoadResult<Data> {

  /**
   * Returns the remote data.
   * 
   * @return the data
   */
  public List<Data> getData();

}

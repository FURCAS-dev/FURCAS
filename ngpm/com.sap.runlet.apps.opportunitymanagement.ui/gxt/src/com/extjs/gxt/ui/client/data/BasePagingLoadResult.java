/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.io.Serializable;
import java.util.List;

/**
 * Default implementation of the <code>PagingLoadResult</code> interface.
 * 
 * @param <Data> the data type
 */
public class BasePagingLoadResult<Data> extends BaseListLoadResult<Data> implements
    PagingLoadResult<Data>, Serializable {

  protected int offset = 0;
  protected int totalLength = 0;

  /**
   * Creates a new paging load result.
   * 
   * @param data the data
   */
  public BasePagingLoadResult(List<Data> data) {
    super(data);
  }

  /**
   * Creates a new paging load result.
   * 
   * @param data the data
   * @param offset the offset
   * @param totalLength the total length
   */
  public BasePagingLoadResult(List<Data> data, int offset, int totalLength) {
    this(data);
    this.offset = offset;
    this.totalLength = totalLength;
  }

  BasePagingLoadResult() {

  }

  public int getOffset() {
    return offset;
  }

  public int getTotalLength() {
    return totalLength;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public void setTotalLength(int totalLength) {
    this.totalLength = totalLength;
  }

}

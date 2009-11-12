/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.io.Serializable;

/**
 * Default implementation of the <code>PagingLoadConfig</code>.
 */
public class BasePagingLoadConfig extends BaseListLoadConfig implements PagingLoadConfig,
    Serializable {

  /**
   * Creates a new paging load config.
   */
  public BasePagingLoadConfig() {
    this(0, 50);
  }

  /**
   * Creates a new paging load config.
   * 
   * @param offset the offset
   * @param limit the limit
   */
  public BasePagingLoadConfig(int offset, int limit) {
    setOffset(offset);
    setLimit(limit);
  }

  public int getLimit() {
    return (Integer) get("limit");
  }

  public int getOffset() {
    return (Integer) get("offset");
  }

  public void setLimit(int limit) {
    set("limit", limit);
  }

  public void setOffset(int offset) {
    set("offset", offset);
  }

}

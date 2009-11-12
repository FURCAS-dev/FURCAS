/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * Default implementation of the <code>PagingLoader</code> interface.
 * 
 * @param <D> the <code>PagingLoadResult</code> type being returned by this
 *          loader
 */
public class BasePagingLoader<D extends PagingLoadResult<?>> extends BaseListLoader<D>
    implements PagingLoader<D> {

  protected int offset = 0;
  protected int limit = 50;
  protected int totalCount;

  /**
   * Creates a new paging loader instance.
   * 
   * @param proxy the data proxy
   */
  @SuppressWarnings("unchecked")
  public BasePagingLoader(DataProxy proxy) {
    super(proxy);
  }

  /**
   * Creates a new paging loader instance.
   * 
   * @param proxy the data proxy
   * @param reader the data reader
   */
  @SuppressWarnings("unchecked")
  public BasePagingLoader(DataProxy proxy, DataReader reader) {
    super(proxy, reader);
  }

  public int getLimit() {
    return limit;
  }

  public int getOffset() {
    return offset;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void load(int offset, int limit) {
    this.offset = offset;
    this.limit = limit;
    load();
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  /**
   * Use the specified LoadConfig for all load calls. The {@link #reuseConfig}
   * will be set to true.
   */
  public void useLoadConfig(Object loadConfig) {
    super.useLoadConfig(loadConfig);
    PagingLoadConfig pagingConfig = (PagingLoadConfig) loadConfig;
    offset = pagingConfig.getOffset();
    limit = pagingConfig.getLimit();
  }

  @Override
  protected Object newLoadConfig() {
    return new BasePagingLoadConfig();
  }

  @Override
  protected void onLoadSuccess(Object loadConfig, D result) {
    LoadEvent evt = new LoadEvent(this, loadConfig, result);
    totalCount = result.getTotalLength();
    offset = result.getOffset();
    fireEvent(Load, evt);
  }

  @Override
  protected Object prepareLoadConfig(Object config) {
    config = super.prepareLoadConfig(config);
    PagingLoadConfig pagingConfig = (PagingLoadConfig) config;
    pagingConfig.setOffset(offset);
    pagingConfig.setLimit(limit);
    return config;
  }

}

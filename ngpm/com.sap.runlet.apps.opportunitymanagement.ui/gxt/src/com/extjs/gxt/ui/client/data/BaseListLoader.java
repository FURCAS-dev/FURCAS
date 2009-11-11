/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.event.BaseEvent;

/**
 * Default implementation of the <code>ListLoader</code> interface.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeLoad</b> : LoadEvent(loader, config)<br>
 * <div>Fires before a load operation. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>loader : this</li>
 * <li>config : the load config</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Load</b> : LoadEvent(loader, config, result)<br>
 * <div>Fires after the button is selected.</div>
 * <ul>
 * <li>loader : this</li>
 * <li>config : the load config</li>
 * <li>result : the load result</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>LoadException</b> : LoadEvent(loader, config, result)<br>
 * <div>Fires after the button is selected.</div>
 * <ul>
 * <li>loader : this</li>
 * <li>config : the load config</li>
 * <li>result : the load result</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * @param <D> the list load result type
 */
public class BaseListLoader<D extends ListLoadResult<?>> extends BaseLoader<D> implements
    ListLoader<D> {

  private boolean remoteSort;
  private String sortField;
  private SortDir sortDir = SortDir.NONE;

  /**
   * Creates a new loader instance with the given proxy. A reader is not
   * specified and will not be passed to the proxy at load time.
   * 
   * @param proxy the data proxy
   */
  @SuppressWarnings("unchecked")
  public BaseListLoader(DataProxy proxy) {
    super(proxy);
  }

  /**
   * Creates a new loader instance.
   * 
   * @param proxy the data proxy
   * @param reader the data reader
   */
  @SuppressWarnings("unchecked")
  public BaseListLoader(DataProxy proxy, DataReader reader) {
    super(proxy, reader);
  }

  public SortDir getSortDir() {
    return sortDir;
  }

  public String getSortField() {
    return sortField;
  }

  public boolean isRemoteSort() {
    return remoteSort;
  }

  public void setRemoteSort(boolean remoteSort) {
    this.remoteSort = remoteSort;
  }

  public void setSortDir(SortDir sortDir) {
    this.sortDir = sortDir == null ? SortDir.NONE : sortDir;
  }

  public void setSortField(String sortField) {
    this.sortField = sortField;
  }

  /**
   * Use the specified LoadConfig for all load calls. The {@link #reuseConfig}
   * will be set to true.
   */
  public void useLoadConfig(Object loadConfig) {
    setReuseLoadConfig(true);
    lastConfig = loadConfig;
    ListLoadConfig listConfig = (ListLoadConfig) loadConfig;
    sortDir = listConfig.getSortInfo().getSortDir();
    sortField = listConfig.getSortInfo().getSortField();
  }

  /**
   * Template method to allow custom BaseLoader subclasses to provide their own
   * implementation of LoadConfig
   */
  protected Object newLoadConfig() {
    return new BaseListLoadConfig();
  }

  /**
   * Template method to allow custom subclasses to prepare the load config prior
   * to loading data
   */
  protected Object prepareLoadConfig(Object config) {
    super.prepareLoadConfig(config);
    ListLoadConfig listConfig = (ListLoadConfig) config;
    listConfig.setSortField(sortField);
    listConfig.setSortDir(sortDir);
    return config;
  }

}

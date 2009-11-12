/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Default implementation of the <code>TreeLoader</code> interface.
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
 * @param <M> the model data type
 */
public class BaseTreeLoader<M extends ModelData> extends BaseLoader<List<M>> implements
    TreeLoader<M> {

  protected List<M> children = new ArrayList<M>();

  /**
   * Creates a new tree loader instance.
   * 
   * @param proxy the data reader
   */
  @SuppressWarnings("unchecked")
  public BaseTreeLoader(DataProxy proxy) {
    super(proxy);
  }

  /**
   * Creates a new tree loader instance.
   * 
   * @param reader the data reader
   */
  @SuppressWarnings("unchecked")
  public BaseTreeLoader(DataReader reader) {
    super(reader);
  }

  /**
   * Creates a new tree loader instance.
   * 
   * @param proxy the data proxy
   * @param reader the data reader
   */
  @SuppressWarnings("unchecked")
  public BaseTreeLoader(DataProxy proxy, DataReader reader) {
    super(proxy, reader);
  }

  public boolean loadChildren(M parent) {
    children.add(parent);
    return load(parent);
  }

  public boolean hasChildren(M parent) {
    if (parent instanceof TreeModel) {
      return !((TreeModel) parent).isLeaf();
    }
    return false;
  }

  @Override
  protected void loadData(Object config, AsyncCallback<List<M>> callback) {
    try {
      List<M> data = (List<M>) reader.read(config, config);
      callback.onSuccess(data);
    } catch (Exception e) {
      callback.onFailure(e);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  protected void onLoadFailure(Object loadConfig, Throwable t) {
    TreeLoadEvent evt = new TreeLoadEvent(this, (M) loadConfig, t);
    if (loadConfig != null && children.contains(loadConfig)) {
      evt.parent = (M) loadConfig;
      children.remove(loadConfig);
    }
    fireEvent(LoadException, evt);
  }
  
  @Override
  @SuppressWarnings("unchecked")
  protected void onLoadSuccess(Object loadConfig, List<M> result) {
    TreeLoadEvent evt = new TreeLoadEvent(this, (M) loadConfig, result);
    if (loadConfig != null && children.contains(loadConfig)) {
      evt.parent = (M) loadConfig;
      children.remove(loadConfig);
    }
    fireEvent(Load, evt);
  }

}

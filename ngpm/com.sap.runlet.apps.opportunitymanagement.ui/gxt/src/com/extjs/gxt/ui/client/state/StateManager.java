/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.state;

import java.util.Date;
import java.util.Map;

/**
 * This is the global state manager. In order for this class to be useful, it
 * must be initialized with a provider when your application initializes. By
 * default, GXT initializes the StateManager with a CookieProvider. The provider
 * can be replaced as needed.
 * 
 * <dl>
 * <dt>Events:</dt>
 * <dd><b>StateChange</b> : (manager, name, value) <br>
 * <div>Fires after a state change.</div>
 * <ul>
 * <li>manager : the state manager</li>
 * <li>name : the key name</li>
 * <li>value : the value or <code>null</code> if cleared</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class StateManager {

  private static StateManager instance = new StateManager();

  /**
   * Returns the singleton instance.
   * 
   * @return the state mananger
   */
  public static StateManager get() {
    return instance;
  }

  private Provider provider;

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public Object get(String name) {
    return provider.get(name);
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value as a map
   */
  public Map<String, Object> getMap(String name) {
    try {
      return provider.getMap(name);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public Date getDate(String name) {
    return provider.getDate(name);
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public int getInteger(String name) {
    return provider.getInteger(name);
  }

  /**
   * Returns the manager's state provider.
   * 
   * @return the provider
   */
  public Provider getProvider() {
    return provider;
  }

  /**
   * Returns the current value for a key.
   * 
   * @param name the key name
   * @return the value
   */
  public String getString(String name) {
    return provider.getString(name);
  }

  /**
   * Sets a key.
   * 
   * @param name the key name
   * @param value the value
   */
  public void set(String name, Object value) {
    provider.set(name, value);
  }

  /**
   * Sets the manager's state provider.
   * 
   * @param stateProvider the provider
   */
  public void setProvider(Provider stateProvider) {
    provider = stateProvider;
    provider.bind(this);
  }

}

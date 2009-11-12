/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.state.StateManager;

/**
 * StateManager event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see StateManager
 */
public class StateEvent extends BaseEvent {

  /**
   * The state provider.
   */
  private StateManager manager;

  /**
   * The property name.
   */
  private String name;

  /**
   * The property value.
   */
  private Object value;

  /**
   * Creates a new state event.
   * 
   * @param manager the source manager
   */
  public StateEvent(StateManager manager) {
    super(manager);
    this.manager = manager;
  }

  /**
   * Creates a new state event.
   * 
   * @param manager the source manager
   * @param name the property name
   * @param value the property value
   */
  public StateEvent(StateManager manager, String name, Object value) {
    super(manager);
    this.manager = manager;
    this.name = name;
    this.value = value;
  }

  /**
   * Returns the state manager.
   * 
   * @return the state manager
   */
  public StateManager getManager() {
    return manager;
  }

  /**
   * Returns the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the value.
   * 
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * Sets the state manager.
   * 
   * @param manager the state manager
   */
  public void setManager(StateManager manager) {
    this.manager = manager;
  }

  /**
   * Sets the name.
   * 
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the value.
   * 
   * @param value the value
   */
  public void setValue(Object value) {
    this.value = value;
  }

}

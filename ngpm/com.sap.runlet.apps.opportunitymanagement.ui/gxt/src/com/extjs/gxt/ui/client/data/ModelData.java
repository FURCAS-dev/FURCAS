/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.Collection;
import java.util.Map;

/**
 * Primary interface for GXT model objects without support events. Models
 * support a form of "introspection" as property names and values can be
 * retrieved at runtime.
 * 
 * <p/>
 * For models with event support see {@link Model}.
 * 
 * <p/>
 * For a default implementation see {@link BaseModelData}.
 */
public interface ModelData {

  /**
   * Returns the named property from this model instance.
   * 
   * @param property the property name
   * @return the value
   */
  public <X> X get(String property);

  /**
   * Returns the model's properties and values as a map.
   * 
   * <p/>
   * Changes to the returned collection should not mutate this model instance.
   * 
   * @return the properties and values
   */
  public Map<String, Object> getProperties();

  /**
   * Returns an collection of the model's property names.
   * 
   * <p/>
   * The collection should be a snapshot of the property names that the model
   * represents.
   * 
   * <p/>
   * Changes to the returned collection should not mutate this model instance.
   */
  public Collection<String> getPropertyNames();

  /**
   * Removes the named property from this model instance.
   * 
   * @param property the property name
   * @return the old value for the property
   */
  public <X> X remove(String property);

  /**
   * Sets a property.
   * 
   * @param property the property name
   * @param value property value
   * @return the old value for the property
   */
  public <X> X set(String property, X value);

}

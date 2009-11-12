/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;

/**
 * Allows multiple providers to be registered by data type and property name.
 */
public class AggregateModelStringProvider<M extends ModelData> implements ModelStringProvider<M> {

  private static ModelStringProvider<ModelData> defaultProvider = new ModelStringProvider<ModelData>() {
    public String getStringValue(ModelData model, String property) {
      Object value = model.get(property);
      return value != null ? value.toString() : null;
    }
  };

  private ModelStringProvider<M> stringProvider;
  private Map<String, ModelStringProvider<M>> propertyProviders;
  private Map<Class<?>, ModelStringProvider<M>> classProviders;

  /**
   * Registers a provider by property name.
   * 
   * @param property the property name
   * @param provider the string provider
   */
  public void register(String property, ModelStringProvider<M> provider) {
    if (propertyProviders == null) {
      propertyProviders = new FastMap<ModelStringProvider<M>>();
    }
    propertyProviders.put(property, provider);
  }

  /**
   * Registers a provider by type.
   * 
   * @param type the type
   * @param provider the string provider
   */
  public void register(Class<?> type, ModelStringProvider<M> provider) {
    if (classProviders == null) {
      classProviders = new HashMap<Class<?>, ModelStringProvider<M>>();
    }
    classProviders.put(type, provider);
  }

  /**
   * Sets the default provider. This provider will be used of no others
   * providers match the request.
   * 
   * @param provider the default string provider
   */
  public void setDefault(ModelStringProvider<M> provider) {
    this.stringProvider = provider;
  }

  @SuppressWarnings("unchecked")
  public String getStringValue(M model, String property) {
    if (propertyProviders != null && propertyProviders.containsKey(property)) {
      return propertyProviders.get(property).getStringValue(model, property);
    }

    if (classProviders != null && model.get(property) != null) {
      Class<?> clz = model.<Object> get(property).getClass();
      if (classProviders.containsKey(clz)) {
        return classProviders.get(clz).getStringValue(model, property);
      }
    }
    ModelStringProvider<M> temp = stringProvider != null ? stringProvider : (ModelStringProvider)defaultProvider;
    return temp.getStringValue(model, property);
  }

}

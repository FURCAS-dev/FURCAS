/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.google.gwt.core.client.GWT;

/**
 * Returns <code>BeanModelFactories</code> for java beans. Java beans can be
 * converted to "models" via 2 methods. The first method requires a new
 * interface that extends <code>BeanModelMarker</code> and uses annotations.
 * This method does not require the JavaBean to be modified. With the second
 * method, your Java Bean implements the <code>BeanModelTag</code> interface.
 * 
 * @see BeanModelMarker
 * @see BeanModelTag
 */
public abstract class BeanModelLookup {

  private static BeanModelLookup instance = (BeanModelLookup) GWT.create(BeanModelLookup.class);

  /**
   * Returns the singleton bean model lookup.
   * 
   * @return the singleton instance
   */
  public static BeanModelLookup get() {
    return instance;
  }

  /**
   * Returns the factory for the given bean.
   * 
   * @param bean the bean class
   * @return the factory
   */
  public abstract BeanModelFactory getFactory(Class<?> bean);

}

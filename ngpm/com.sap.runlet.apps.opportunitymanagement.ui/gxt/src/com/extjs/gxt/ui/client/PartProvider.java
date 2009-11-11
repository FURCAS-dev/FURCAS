/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client;

/**
 * Interface for objects that can return new object instances based on a part
 * id.
 */
public interface PartProvider {
  /**
   * Returns a new object instance given the part id.
   * 
   * @param partId the part id
   * @return the new object, or null if provider cannot handle given id
   */
  public Object createPart(String partId);
}

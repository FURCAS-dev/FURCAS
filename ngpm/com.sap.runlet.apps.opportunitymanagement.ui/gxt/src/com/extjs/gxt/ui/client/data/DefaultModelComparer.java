/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * Default <code>ModelComparer</code>
 * 
 * @param <M> the model type
 */
public class DefaultModelComparer<M extends ModelData> implements ModelComparer<M> {

  /**
   * Global instance.
   */
  @SuppressWarnings("unchecked")
  public static final DefaultModelComparer DFFAULT = new DefaultModelComparer();

  public boolean equals(M a, M b) {
    return (a == b || (a != null && a.equals(b)));
  }

}

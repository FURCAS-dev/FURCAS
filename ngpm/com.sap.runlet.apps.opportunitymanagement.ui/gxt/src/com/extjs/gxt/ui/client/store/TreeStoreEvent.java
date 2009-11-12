/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * A tree store event.
 * 
 * @param <M> the model type
 */
public class TreeStoreEvent<M extends ModelData> extends StoreEvent<M> {

  private M child;
  private List<M> children;
  private M parent;

  /**
   * Creates a new tree store event.
   * 
   * @param store the source store
   */
  public TreeStoreEvent(TreeStore<M> store) {
    super(store);
  }

  /**
   * Returns the child.
   * 
   * @return the child
   */
  public M getChild() {
    return child;
  }

  /**
   * Returns the children.
   * 
   * @return the children
   */
  public List<M> getChildren() {
    return children;
  }

  /**
   * Returns the parent.
   * 
   * @return the parent
   */
  public M getParent() {
    return parent;
  }

  /**
   * Sets the child.
   * 
   * @param child the child
   */
  public void setChild(M child) {
    this.child = child;
  }

  /**
   * Sets the children.
   * 
   * @param children the children
   */
  public void setChildren(List<M> children) {
    this.children = children;
  }

  /**
   * Sets the parent.
   * 
   * @param parent the parent
   */
  public void setParent(M parent) {
    this.parent = parent;
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel.TreeNode;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * <code>TreePanel</code> event type.
 * 
 * @param <M> the model type contained in the tree
 */
@SuppressWarnings("unchecked")
public class TreePanelEvent<M extends ModelData> extends BoxComponentEvent {

  private M parent;
  private M child;
  private M item;
  private TreeStore<M> store;
  private TreeNode node;
  private TreePanel<M> treePanel;
  private boolean checked;

  public TreePanelEvent(TreePanel tree) {
    super(tree);
    this.treePanel = tree;
  }

  public TreePanelEvent(TreePanel tree, Event event) {
    super(tree, event);
    this.treePanel = tree;
  }

  public TreePanelEvent(TreePanel tree, M item) {
    this(tree);
    setItem(item);
  }

  public ModelData getChild() {
    return child;
  }

  public ModelData getItem() {
    if (item == null) {
      if (getNode() != null) {
        item = (M) getNode().getModel();
      }
    }
    return item;
  }

  public TreeNode getNode() {
    if (node == null) {
      TreeNode n = treePanel.findNode((Element) event.getEventTarget().cast());
      if (n != null) {
        node = n;
      }
    }
    return node;
  }

  public ModelData getParent() {
    return parent;
  }

  public TreeStore getStore() {
    return store;
  }

  public TreePanel<M> getTreePanel() {
    return treePanel;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public void setChild(M child) {
    this.child = child;
  }

  public void setItem(M item) {
    this.item = item;
  }

  public void setNode(TreeNode node) {
    this.node = node;
  }

  public void setParent(M parent) {
    this.parent = parent;
  }

  public void setStore(TreeStore store) {
    this.store = store;
  }

  public void setTreePanel(TreePanel<M> treePanel) {
    this.treePanel = treePanel;
  }

}

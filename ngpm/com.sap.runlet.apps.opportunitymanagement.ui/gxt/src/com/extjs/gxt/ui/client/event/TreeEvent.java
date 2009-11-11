/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.tree.Tree;
import com.extjs.gxt.ui.client.widget.tree.TreeItem;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;

/**
 * Tree event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see Tree
 * 
 * @deprecated see {@link TreePanel}
 */
public class TreeEvent extends ContainerEvent<Tree, TreeItem> {

  /**
   * The parent item.
   */
  private TreeItem parent;

  /**
   * The source tree.
   */
  private Tree tree;

  /**
   * Creates a new tree event.
   * 
   * @param tree the source tree
   */
  public TreeEvent(Tree tree) {
    super(tree);
    this.tree = tree;
  }

  /**
   * Creates a new tree event.
   * 
   * @param tree the source tree
   * @param item the tree item
   */
  public TreeEvent(Tree tree, TreeItem item) {
    super(tree, item);
    this.tree = tree;
  }

  /**
   * Returns the parent.
   * 
   * @return the parent
   */
  public TreeItem getParent() {
    return parent;
  }

  /**
   * Returns the source tree.
   * 
   * @return the source tree
   */
  public Tree getTree() {
    return tree;
  }

  /**
   * Sets the parent.
   * 
   * @param parent the parent
   */
  public void setParent(TreeItem parent) {
    this.parent = parent;
  }

  /**
   * Sets the source tree.
   * 
   * @param tree the source tree
   */
  public void setTree(Tree tree) {
    this.tree = tree;
  }

}

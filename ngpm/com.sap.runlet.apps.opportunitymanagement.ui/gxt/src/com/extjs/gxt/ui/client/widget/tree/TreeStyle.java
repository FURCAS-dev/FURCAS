/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tree;

/**
 * Style information for Trees. There are 2 types for tree items: nodes and
 * leafs. Leafs are tree items without children. Nodes are items with children
 * or items with their leaf flag set to false.
 */
public class TreeStyle {

  private String nodeOpenIconStyle = "tree-folder-open";
  private String nodeCloseIconStyle = "tree-folder";
  private String leafIconStyle;
  private String itemStyle = "my-treeitem";

  /**
   * Returns the style name that is added to all items.
   * 
   * @return the style name
   */
  public String getItemStyle() {
    return itemStyle;
  }

  /**
   * Returns the icon style for leaf items.
   * 
   * @return the icon style
   */
  public String getLeafIconStyle() {
    return leafIconStyle;
  }

  /**
   * Returns the global icon style for closed nodes.
   * 
   * @return the style name
   */
  public String getNodeCloseIconStyle() {
    return nodeCloseIconStyle;
  }

  /**
   * Returns the global icon style for open nodes.
   * 
   * @return the style name
   */
  public String getNodeOpenIconStyle() {
    return nodeOpenIconStyle;
  }

  /**
   * The global icon style for tree items with children (defaults to
   * 'tree-folder'). Individual tree items can override this value by setting
   * the the item's icon style.
   * 
   * @param itemStyle the node icon style
   */
  public void setItemStyle(String itemStyle) {
    this.itemStyle = itemStyle;
  }

  /**
   * Sets the global icon style for leaf tree items. Individual tree items can
   * override this value by setting the the item's icon style.
   * 
   * @param itemIconStyle the image style
   */
  public void setLeafIconStyle(String itemIconStyle) {
    this.leafIconStyle = itemIconStyle;
  }

  /**
   * Sets the icon style used for closed tree items.
   * 
   * @param folderCloseIconStyle the style name
   */
  public void setNodeCloseIconStyle(String folderCloseIconStyle) {
    this.nodeCloseIconStyle = folderCloseIconStyle;
  }

  /**
   * Sets the global icon style for expanded tree items (defaults to
   * 'tree-folder-open'). Individual tree items can override this value by
   * setting the the item's icon style.
   * 
   * @param folderOpenIconStyle the open node icon style
   */
  public void setNodeOpenIconStyle(String folderOpenIconStyle) {
    this.nodeOpenIconStyle = folderOpenIconStyle;
  }

}

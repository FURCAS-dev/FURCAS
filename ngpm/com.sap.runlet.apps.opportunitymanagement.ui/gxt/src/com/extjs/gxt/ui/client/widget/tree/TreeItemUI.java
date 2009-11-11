/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tree;

import com.extjs.gxt.ui.client.event.TreeEvent;
import com.extjs.gxt.ui.client.widget.tree.Tree.Joint;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Element;

/**
 * Interface for TreeItem UI providers.
 * 
 * @deprecated see {@link TreePanel}
 */
public interface TreeItemUI {

  /**
   * Called after the nodes UI has been rendered. At this time, the tree item's
   * element has been set, and any element initialization should occur.
   */
  public void afterRender();

  /**
   * Binds the UI instance to a tree item.
   * 
   * @param item bound tree item
   */
  public void bind(TreeItem item);

  /**
   * Collapses a nodes children.
   */
  public void collapse();

  /**
   * Expands the nodes children.
   */
  public void expand();

  /**
   * Returns the check element. The check element only applies when the tree
   * item is checkable.
   * 
   * @return the check element
   */
  public Element getCheckElement();

  /**
   * Returns the container element. The container element is the element that
   * wraps all a nodes child items.
   * 
   * @return the container element
   */
  public Element getContainerElement();

  /**
   * Returns the joint element. The joint is the element used to expand and
   * collapse nodes.
   * 
   * @return the joint element
   */
  public Element getJointElement();

  /**
   * Returns the html markup used to render a tree item.
   * 
   * @param id the item id
   * @param text the item's text
   * @return the html markup
   */
  public String getTemplate(String id, String text, String icon, int joint, int level);

  /**
   * Receives all tree item events.
   * 
   * @param e the tree event
   */
  public void handleEvent(TreeEvent e);

  /**
   * Returns whether the element is a selectable target.
   * 
   * @param target the target element
   * @return true if selectable
   */
  public boolean isSelectableTarget(Element target);

  /**
   * Called when the check state changes.
   * 
   * @param checked true for checked, false otherwise.
   */
  public void onCheckChange(boolean checked);

  /**
   * Called when the nodes icon style changes.
   * 
   * @param iconStyle the icon style
   */
  public void onIconStyleChange(String iconStyle);

  /**
   * Called when the nodes indentation changes.
   * 
   * @param level the items depth
   */
  public void onIndentChange(int level);

  /**
   * Called when the nodes joint is updated.
   * 
   * @param joint the joint
   */
  public void onJointChange(Joint joint);

  /**
   * Called when the node is "loading". Applies when children are loaded
   * asynchronously.
   * 
   * @param loading true for loading
   */
  public void onLoadingChange(boolean loading);

  /**
   * Called when the nodes hover style changes.
   * 
   * @param over true for hover, otherwise false
   */
  public void onOverChange(boolean over);

  /**
   * Called when a nodes child is removed.
   * 
   * @param child the child to be removed
   */
  public void onRemoveChild(TreeItem child);

  /**
   * Called when the selected state of a node changes.
   * 
   * @param selected true if selected
   */
  public void onSelectedChange(boolean selected);

  /**
   * Called when the nodes text changes.
   * 
   * @param text the new text
   */
  public void onTextChange(String text);

  /**
   * Called when the nodes text style changes.
   * 
   * @param style the style name
   */
  public void onTextStyleChange(String style);
  
  /**
   * Refreshes the UI.
   */
  public void refresh();

}

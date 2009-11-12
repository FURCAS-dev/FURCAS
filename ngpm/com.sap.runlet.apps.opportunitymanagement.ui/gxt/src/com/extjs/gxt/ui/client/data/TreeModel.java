/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.List;

/**
 * A Model that supports parent and children. Change events bubble to parent
 * elements.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Update</b> : ChangeEvent(source)<br>
 * <div>Fires after the the model is updated.</div>
 * <ul>
 * <li>source : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : ChangeEvent(source, parent, item, index)<br>
 * <div>Fires after a child model is added.</div>
 * <ul>
 * <li>source : this (events bubble)</li>
 * <li>parent : the parent model</li>
 * <li>item : the item that was added</li>
 * <li>index : the insert location</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : ChangeEvent(source, parent, item)<br>
 * <div>Fires after a child model is added.</div>
 * <ul>
 * <li>source : this (events bubble)</li>
 * <li>parent : the parent model</li>
 * <li>item : the item that was removed</li>
 * </ul>
 * </dd>
 * 
 * </dl>
 */
public interface TreeModel extends Model {

  /**
   * Adds a child to the model.
   * 
   * @param child the model to add
   */
  public void add(ModelData child);

  /**
   * Returns the child at the given index.
   * 
   * @param index the index
   * @return the child
   */
  public ModelData getChild(int index);

  /**
   * Returns the child count.
   * 
   * @return the child count
   */
  public int getChildCount();

  /**
   * Returns the model's children.
   * 
   * @return the children
   */
  public List<ModelData> getChildren();

  /**
   * Returns the model's parent.
   * 
   * @return the parent
   */
  public TreeModel getParent();

  /**
   * Returns the index of the child.
   * 
   * @param child the child
   * @return the index
   */
  public int indexOf(ModelData child);

  /**
   * Inserts a child.
   * 
   * @param child the child to add
   * @param index the insert location
   */
  public void insert(ModelData child, int index);

  /**
   * Returns true if the model is a leaf and has children. The method provides
   * the ability to mark a model as having children before the children have
   * been added.
   * 
   * @return true for leaf
   */
  public boolean isLeaf();

  /**
   * Removes a child.
   * 
   * @param child the child to remove
   */
  public void remove(ModelData child);

  /**
   * Removes all the children.
   */
  public void removeAll();

  /**
   * Sets the model's parent.
   * 
   * @param parent the new parent
   */
  public void setParent(TreeModel parent);

}
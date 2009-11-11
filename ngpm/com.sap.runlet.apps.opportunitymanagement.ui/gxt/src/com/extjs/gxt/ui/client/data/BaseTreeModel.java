/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Default implementation of the <code>TreeModel</code> interface.
 */
public class BaseTreeModel extends BaseModel implements TreeModel {

  /**
   * The model's parent.
   */
  protected TreeModel parent;

  /**
   * The model's children.
   */
  protected List<ModelData> children;

  /**
   * Creates a new model instance.
   */
  public BaseTreeModel() {
    children = new ArrayList<ModelData>();
  }

  /**
   * Creates a new model instance with the specified properties.
   * 
   * @param properties the initial properties
   */
  public BaseTreeModel(Map<String, Object> properties) {
    super(properties);
    children = new ArrayList<ModelData>();
  }

  /**
   * Creates a new model instance.
   * 
   * @param parent the parent
   */
  public BaseTreeModel(TreeModel parent) {
    this();
    parent.add(this);
  }

  /**
   * Adds a child to the model and fires an {@link ChangeEventSource#Add} event.
   * 
   * @param child the child to be added
   */
  public void add(ModelData child) {
    insert(child, getChildCount());
  }

  /**
   * Returns the child at the given index or <code>null</code> if the index is
   * out of range.
   * 
   * @param index the index to be retrieved
   * @return the model at the index
   */
  public ModelData getChild(int index) {
    if ((index < 0) || (index >= children.size())) return null;
    return children.get(index);
  }

  /**
   * Returns the number of children.
   * 
   * @return the number of children
   */
  public int getChildCount() {
    return children.size();
  }

  /**
   * Returns the model's children.
   * 
   * @return the children
   */
  public List<ModelData> getChildren() {
    return children;
  }

  /**
   * Returns the model's parent or <code>null</code> if no parent.
   * 
   * @return the parent
   */
  public TreeModel getParent() {
    return parent;
  }

  public int indexOf(ModelData child) {
    return children.indexOf(child);
  }

  /**
   * Inserts a child to the model and fires an {@link ChangeEventSource#Add}
   * event.
   * 
   * @param child the child to be inserted
   * @param index the location to insert the child
   */
  public void insert(ModelData child, int index) {
    adopt(child);
    children.add(index, child);
    ChangeEvent evt = new ChangeEvent(Add, this);
    evt.setParent(this);
    evt.setItem(child);
    evt.setIndex(index);
    notify(evt);
  }

  public boolean isLeaf() {
    return children.size() == 0;
  }

  @Override
  public void notify(ChangeEvent evt) {
    super.notify(evt);
    if (parent != null && parent instanceof ChangeEventSource) {
      evt.setSource(parent);
      ((ChangeEventSource) parent).notify(evt);
    }
  }

  /**
   * Removes the child at the given index.
   * 
   * @param index the child index
   */
  public void remove(int index) {
    if (index >= 0 && index < getChildCount()) {
      remove(getChild(index));
    }
  }

  /**
   * Removes the child from the model and fires a
   * {@link ChangeEventSource#Remove} event.
   * 
   * @param child the child to be removed
   */
  public void remove(ModelData child) {
    orphan(child);
    children.remove(child);
    ChangeEvent evt = new ChangeEvent(Remove, this);
    evt.setParent(this);
    evt.setItem(child);
    notify(evt);
  }

  public void removeAll() {
    for (int i = children.size() - 1; i >= 0; i--) {
      remove(getChild(i));
    }
  }

  /**
   * Sets the model's children. All existing children are first removed.
   * 
   * @param children the children to be set
   */
  public void setChildren(List<ModelData> children) {
    removeAll();
    if (children != null) {
      for (ModelData child : children) {
        add(child);
      }
    }
  }

  public void setParent(TreeModel parent) {
    this.parent = parent;
  }
  
  
  
  private void setParentInternal(ModelData child) {
    if (child instanceof TreeModel) {
      TreeModel treeChild = (TreeModel)child;
      treeChild.setParent(this);
    } else {
      child.set("gxt.parent", child);
    }
  }
  
  private TreeModel getParentInternal(ModelData child) {
    if (child instanceof TreeModel) {
      TreeModel treeChild = (TreeModel)child;
      return treeChild.getParent();
    } else {
      return (TreeModel)child.get("gxt.parent");
    }
  }

  private void adopt(ModelData child) {
    TreeModel p = getParentInternal(child);
    if (p != null && p != this) {
      p.remove(child);
    }
    setParentInternal(child);
  }
  
  private void orphan(ModelData child) {
    if (child instanceof TreeModel) {
      TreeModel treeChild = (TreeModel)child;
      treeChild.setParent(null);
    } else {
      child.remove("gxt.parent");
    }
  }

}

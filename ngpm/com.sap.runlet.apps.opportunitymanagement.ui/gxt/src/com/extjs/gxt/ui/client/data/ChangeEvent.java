/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

/**
 * Instances of this class are sent as a result of model changes.
 * 
 * @see ChangeEventSource
 */
public class ChangeEvent {

  private int type;
  private Model source;
  private ModelData item;
  private Model parent;
  private int index;

  /**
   * Creates a new instance.
   * 
   * @param type the change type
   * @param source the object that was changed
   */
  public ChangeEvent(int type, Model source) {
    this.type = type;
    this.source = source;
  }

  /**
   * Creates a new instance.
   * 
   * @param type the change type
   * @param source the object that has changed
   * @param item the item that was added or removed
   */
  public ChangeEvent(int type, Model source, Model item) {
    this(type, source);
    this.item = item;
  }

  /**
   * Returns the type.
   * 
   * @see ChangeEventSource#Add
   * @see ChangeEventSource#Remove
   * @see ChangeEventSource#Update
   * 
   * @return the type
   */
  public int getType() {
    return type;
  }

  /**
   * Sets the type.
   * 
   * @param type the type
   */
  public void setType(int type) {
    this.type = type;
  }

  /**
   * Returns the source model.
   * 
   * @return the source model.
   */
  public Model getSource() {
    return source;
  }

  /**
   * Sets the source model.
   * 
   * @param source the source
   */
  public void setSource(Model source) {
    this.source = source;
  }

  /**
   * Returns the item being added or removed.
   * 
   * @return the item
   */
  public ModelData getItem() {
    return item;
  }

  /**
   * Sets the item being added or removed.
   * 
   * @param item the item
   */
  public void setItem(ModelData item) {
    this.item = item;
  }

  /**
   * Returns the parent.
   * 
   * @return the parent
   */
  public Model getParent() {
    return parent;
  }

  /**
   * Sets the parent.
   * 
   * @param parent the parent
   */
  public void setParent(Model parent) {
    this.parent = parent;
  }

  /**
   * Returns the index.
   * 
   * @return the index
   */
  public int getIndex() {
    return index;
  }

  /**
   * Sets the index.
   * 
   * @param index the index
   */
  public void setIndex(int index) {
    this.index = index;
  }

}

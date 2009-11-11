/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.List;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.LayoutContainer;

/**
 * Container event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see LayoutContainer
 */
@SuppressWarnings("unchecked")
public class ContainerEvent<C extends Container, I extends Component> extends
    BoxComponentEvent {

  /**
   * The source container.
   */
  private C container;

  /**
   * The insert index.
   */
  private int index;

  /**
   * The child item.
   */
  private I item;

  /**
   * The selected items.
   */
  private List<I> selected;

  /**
   * Creates a new event.
   * 
   * @param container the source container
   */
  public ContainerEvent(C container) {
    this(container, null);
  }

  /**
   * Creates a new event.
   * 
   * @param container the source container
   * @param component the related component
   */
  public ContainerEvent(C container, I component) {
    super(container);
    this.container = container;
    this.item = component;
  }

  public C getContainer() {
    return container;
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
   * Returns the item.
   * 
   * @return the item
   */
  public I getItem() {
    return item;
  }

  /**
   * Returns the selected items.
   * 
   * @return the selected items
   */
  public List<I> getSelected() {
    return selected;
  }

  /**
   * Sets the source container.
   * 
   * @param container the container
   */
  public void setContainer(C container) {
    this.container = container;
  }

  /**
   * Sets the index.
   * 
   * @param index the index
   */
  public void setIndex(int index) {
    this.index = index;
  }

  /**
   * Sets the item.
   * 
   * @param item the item
   */
  public void setItem(I item) {
    this.item = item;
  }

  /**
   * Sets the selected items.
   * 
   * @param selected the selected items
   */
  public void setSelected(List<I> selected) {
    this.selected = selected;
  }

}

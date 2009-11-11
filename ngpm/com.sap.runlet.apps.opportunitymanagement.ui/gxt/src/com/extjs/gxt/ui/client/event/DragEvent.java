/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.Element;

/**
 * Draggable event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see Draggable
 */
public class DragEvent extends DomEvent {

  /**
   * The component being dragged.
   */
  private Component component;

  /**
   * The draggable instance.
   */
  private Draggable draggable;

  /**
   * The current height.
   */
  private int height;

  /**
   * The current width.
   */
  private int width;

  /**
   * The current x-coordinate value.
   */
  private int x;

  /**
   * The current y-coordinate value.
   */
  private int y;

  /**
   * Creates a new drag event.
   * 
   * @param draggable the draggable
   */
  public DragEvent(Draggable draggable) {
    super(draggable);
    this.draggable = draggable;
  }

  /**
   * Returns the source component.
   * 
   * @return the source component
   */
  public Component getComponent() {
    return component;
  }

  /**
   * Returns the source draggable.
   * 
   * @return the source draggable
   */
  public Draggable getDraggable() {
    return draggable;
  }

  /**
   * Returns the current height.
   * 
   * @return the height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Returns the event target.
   * 
   * @return the target
   */
  public Element getTarget() {
    return getEvent().getRelatedEventTarget().cast();
  }

  /**
   * Returns the current width.
   * 
   * @return the current width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns the current x-coordinate value.
   * 
   * @return the x-coordinate value
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the current y-coordinate value
   * 
   * @return the y-coordinate value
   */
  public int getY() {
    return y;
  }

  /**
   * Sets the source component.
   * 
   * @param component the component
   */
  public void setComponent(Component component) {
    this.component = component;
  }

  /**
   * Sets the source draggable.
   * 
   * @param draggable the draggable
   */
  public void setDraggable(Draggable draggable) {
    this.draggable = draggable;
  }

  /**
   * Sets the current height.
   * 
   * @param height the current height
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Sets the current width.
   * 
   * @param width the width
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Sets the current x-coordinate value.
   * 
   * @param x the x-coordinate value
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Sets the current y-coordinate value.
   * 
   * @param y the y-coordinate value
   */
  public void setY(int y) {
    this.y = y;
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.google.gwt.user.client.Event;

/**
 * BoxComponent event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 */
public class BoxComponentEvent extends ComponentEvent {

  /**
   * The event source.
   */
  private BoxComponent boxComponent;

  /**
   * X coordinate
   */
  private int x;

  /**
   * Y coordinate
   */
  private int y;

  /**
   * The width.
   */
  private int width;

  /**
   * The height.
   */
  private int height;

  /**
   * The size.
   */
  private int size;

  /**
   * Creates a new event.
   * 
   * @param component the event source
   */
  public BoxComponentEvent(BoxComponent component) {
    super(component);
    this.boxComponent = component;
  }

  /**
   * Creates a new event.
   * 
   * @param component the event source
   * @param event the event
   */
  public BoxComponentEvent(BoxComponent component, Event event) {
    super(component, event);
    this.boxComponent = component;
    this.event = event;
  }

  /**
   * Creates a new event.
   * 
   * @param component the box component
   * @param width the width
   * @param height the height
   */
  public BoxComponentEvent(BoxComponent component, int width, int height) {
    super(component);
    this.boxComponent = component;
    this.width = width;
    this.height = height;
  }

  public BoxComponent getBoxComponent() {
    return boxComponent;
  }

  public void setBoxComponent(BoxComponent boxComponent) {
    this.boxComponent = boxComponent;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
  
  
}

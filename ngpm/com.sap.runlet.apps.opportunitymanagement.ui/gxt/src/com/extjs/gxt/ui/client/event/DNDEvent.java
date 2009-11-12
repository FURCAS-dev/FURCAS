/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.dnd.DragSource;
import com.extjs.gxt.ui.client.dnd.DropTarget;
import com.extjs.gxt.ui.client.dnd.StatusProxy;
import com.extjs.gxt.ui.client.dnd.DND.Operation;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.Event;

/**
 * Drag and drop event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 */
public class DNDEvent extends DomEvent {

  private Component component;
  private Object data;
  private DragEvent dragEvent;
  private DragSource dragSource;
  private DropTarget dropTarget;
  private Operation operation;
  private StatusProxy status;

  public DNDEvent(DragSource source) {
    super(source);
    this.dragSource = source;
  }

  public DNDEvent(DragSource source, Event event) {
    super(source, event);
    this.dragSource = source;
  }

  /**
   * Returns the source component.
   * 
   * @return the component
   */
  public Component getComponent() {
    return component;
  }

  /**
   * Returns the dnd data.
   * 
   * @param <X> the data type
   * @return the data
   */
  @SuppressWarnings("unchecked")
  public <X> X getData() {
    return (X) data;
  }

  /**
   * Returns the drag event.
   * 
   * @return the drag event
   */
  public DragEvent getDragEvent() {
    return dragEvent;
  }

  /**
   * Returns the drag source.
   * 
   * @return the drag source.
   */
  public DragSource getDragSource() {
    return dragSource;
  }

  /**
   * Returns the drop target.
   * 
   * @return the drop target
   */
  public DropTarget getDropTarget() {
    return dropTarget;
  }

  /**
   * Returns the operation.
   * 
   * @return the operation
   */
  public Operation getOperation() {
    return operation;
  }

  /**
   * Returns the status proxy.
   * 
   * @return the proxy
   */
  public StatusProxy getStatus() {
    return status;
  }

  /**
   * Sets the source component
   * 
   * @param component the source component
   */
  public void setComponent(Component component) {
    this.component = component;
  }

  /**
   * Sets the drag and drop data.
   * 
   * @param data the data
   */
  public void setData(Object data) {
    this.data = data;
  }

  /**
   * Sets the drag event.
   * 
   * @param dragEvent the drag event
   */
  public void setDragEvent(DragEvent dragEvent) {
    this.dragEvent = dragEvent;
  }

  /**
   * Sets the drag source.
   * 
   * @param dragSource the drag source
   */
  public void setDragSource(DragSource dragSource) {
    this.dragSource = dragSource;
  }

  /**
   * Sets the drop target.
   * 
   * @param dragTarget the drop target
   */
  public void setDropTarget(DropTarget dragTarget) {
    this.dropTarget = dragTarget;
  }

  /**
   * Sets the operation.
   * 
   * @param operation the operation
   */
  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  /**
   * Sets the status proxy.
   * 
   * @param status the status proxy
   */
  public void setStatus(StatusProxy status) {
    this.status = status;
  }

}

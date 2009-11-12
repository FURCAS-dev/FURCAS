/*
 * Ext GWT - Ext for GWT 
 * 
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.dnd;

import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.event.DNDListener;
import com.extjs.gxt.ui.client.event.DragEvent;
import com.extjs.gxt.ui.client.event.DragListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.widget.Component;

/**
 * Identifies a component that drag and drops can be initiated from.
 * <p />
 * Drag sources must set the data that will be dragged during a drag operation.
 * The data can be specified either by using {@link #setData(Object)} or,
 * setting the data via the DND event when a drag begins.
 * 
 * <p />
 * Drag sources are responsible for removing the dragged data from the source
 * component after a valid drop. Use {@link DropTarget#getOperation()} to
 * determine if the data was copied or moved. The target is accessible via the
 * DNDEvent passed to {@link #onDragDrop(DNDEvent)} and listeners.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * <dd><b>DragStart</b> : DNDEvent(source, component, event, dragEvent, status)<br>
 * <div>Fires after the user begins a drag and drop operation.</div>
 * <ul>
 * <li>source : this</li>
 * <li>component : the source component</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * <li>status : the status object</li>
 * </ul>
 * 
 * </dd>
 * <dd><b>DragCancel</b> : DNDEvent(source, component, event, dragEvent)<br>
 * <div>Fires after a drag is cancelled.</div>
 * <ul>
 * <li>source : this</li>
 * <li>component : the source component</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Drop</b> : DNDEvent(source, component, data, event, dragEvent, status)
 * <br>
 * <div>Fires after a drop occurs.</div>
 * <ul>
 * <li>source : this</li>
 * <li>component : the source component</li>
 * <li>data : the transferred data</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * <li>status : the status object</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class DragSource extends BaseObservable {

  protected Component component;
  protected Draggable draggable;
  protected DragListener listener;
  protected Object data;
  protected StatusProxy statusProxy = StatusProxy.get();

  private String statusText;
  private String group = "";
  private boolean enabled = true;

  /**
   * @param component
   */
  public DragSource(Component component) {
    this.component = component;

    listener = new DragListener() {

      @Override
      public void dragCancel(DragEvent de) {
        onDraggableDragCancel(de);
      }

      @Override
      public void dragEnd(DragEvent de) {
        onDraggableDragEnd(de);
      }

      @Override
      public void dragMove(DragEvent de) {
        onDraggableDragMove(de);
      }

      @Override
      public void dragStart(DragEvent de) {
        onDraggableDragStart(de);
      }

    };

    draggable = new Draggable(component);
    draggable.setUseProxy(true);
    draggable.setSizeProxyToSource(false);
    draggable.setMoveAfterProxyDrag(false);
    draggable.addDragListener(listener);
  }

  /**
   * Adds a drag and drop listener.
   * 
   * @param listener the listener to add
   */
  public void addDNDListener(DNDListener listener) {
    addListener(Events.DragStart, listener);
    addListener(Events.Drop, listener);
  }

  /**
   * Disables the drag source.
   */
  public void disable() {
    enabled = false;
  }

  /**
   * Enables the drag source.
   */
  public void enable() {
    enabled = true;
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
   * Returns the data to be moved or copied.
   * 
   * @return the data
   */
  public Object getData() {
    return data;
  }

  /**
   * Returns the draggable instance.
   * 
   * @return the draggable instance
   */
  public Draggable getDraggable() {
    return draggable;
  }

  /**
   * Returns the source's drag drop group.
   * 
   * @return the group name or null if not specified
   */
  public String getGroup() {
    return group;
  }

  /**
   * Returns the status text.
   * 
   * @return the text
   */
  public String getStatusText() {
    return statusText;
  }

  /**
   * Returns true if the drag source is enabled.
   * 
   * @return true for enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * Removes the drag and drop listener.
   * 
   * @param listener the listener to remove
   */
  public void removeDNDListener(DNDListener listener) {
    removeListener(Events.DragStart, listener);
    removeListener(Events.Drop, listener);
  }

  /**
   * Sets the data for the drag drop operation.
   * 
   * @param data the data
   */
  public void setData(Object data) {
    this.data = data;
  }

  /**
   * Sets the drag drop group. If specified, drops will only be allowed on drop
   * targets with the same group value.
   * 
   * @param group the group name
   */
  public void setGroup(String group) {
    this.group = group;
  }

  /**
   * Sets the text to be used on the status proxy object. If the drag source
   * supports selection, {0} will be substituted with the selection size.
   * 
   * @param statusText the status text
   */
  public void setStatusText(String statusText) {
    this.statusText = statusText;
  }

  /**
   * Called when a drag operation has been cancelled.
   * 
   * @param event the dnd event
   */
  protected void onDragCancelled(DNDEvent event) {

  }

  protected void onDragDrop(DNDEvent event) {

  }

  /**
   * Called when a drag operation begins on the target component. Subclasses or
   * any listeners can cancel the action by calling
   * {@link BaseEvent#setCancelled(boolean)}.
   * 
   * @param event the dnd event
   */
  protected void onDragStart(DNDEvent event) {

  }

  private void onDraggableDragCancel(DragEvent de) {
    DNDEvent e = new DNDEvent(this);
    e.setEvent(de.getEvent());
    e.setDragEvent(de);
    e.setComponent(component);
    DNDManager.get().handleDragCancelled(this, e);
  }

  private void onDraggableDragEnd(DragEvent de) {
    DNDEvent e = new DNDEvent(this, de.getEvent());
    e.setData(data);
    e.setDragEvent(de);
    e.setComponent(component);
    e.setStatus(statusProxy);
    if (e.getData() != null) {
      DNDManager.get().handleDragEnd(this, e);
    }
  }

  private void onDraggableDragMove(DragEvent de) {
    de.setX(de.getClientX() + 12 + XDOM.getBodyScrollLeft());
    de.setY(de.getClientY() + 12 + XDOM.getBodyScrollTop());

    DNDEvent e = new DNDEvent(this, de.getEvent());
    e.setDragEvent(de);
    e.setComponent(component);
    e.setData(data);
    e.setStatus(statusProxy);
    DNDManager.get().handleDragMove(this, e);
  }

  private void onDraggableDragStart(DragEvent de) {
    if (!isEnabled() || !component.isEnabled()) {
      de.setCancelled(true);
      return;
    }
    DNDEvent e = new DNDEvent(this, de.getEvent());
    e.setData(data);
    e.setDragEvent(de);
    e.setComponent(component);
    e.setStatus(statusProxy);
    DNDManager.get().handleDragStart(this, e);
    // instruct draggable
    de.setCancelled(e.isCancelled());
  }

}

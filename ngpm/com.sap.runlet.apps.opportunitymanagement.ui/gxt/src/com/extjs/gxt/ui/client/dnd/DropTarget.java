/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.dnd;

import com.extjs.gxt.ui.client.dnd.DND.Feedback;
import com.extjs.gxt.ui.client.dnd.DND.Operation;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.event.DNDListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.Component;

/**
 * Identifies components that can receive data from a drag and drop operations.
 * 
 * <p />
 * While the cursor is over a target, the target is responsible for determining
 * if the drop is valid and showing any visual indicators for the drop. The @link
 * {@link StatusProxy} object should be used to specify if the drop is valid,
 * and can also be used to change the values of the proxy object displayed by
 * the cursor. The status proxy is accessible via the DNDEvent.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>DragEnter</b> : DNDEvent(target, source, component, event, dragEvent,
 * status)<br>
 * <div>Fires after the cursor enters the target's boundaries.</div>
 * <ul>
 * <li>target : this</li>
 * <li>source : the drag source
 * <li>component : the source component</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * <li>status : the status object</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>DragLeave</b> : DNDEvent(target, source, component, event, dragEvent,
 * status)<br>
 * <div>Fires after the cursor leaves the target's boundaries.</div>
 * <ul>
 * <li>target : this</li>
 * <li>source : the drag source
 * <li>component : the source component</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * <li>status : the status object</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>DragCancel</b> : DNDEvent(target, source, component, event, dragEvent,
 * status)<br>
 * <div>Fires after the user when a drag operation is cancelled.</div>
 * <ul>
 * <li>target : this</li>
 * <li>source : the drag source
 * <li>component : the source component</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * <li>status : the status object</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>DragMove</b> : DNDEvent(target, source, component, event, dragEvent,
 * status)<br>
 * <div>Fires after the user begins a drag and drop operation.</div>
 * <ul>
 * <li>target : this</li>
 * <li>source : the drag source
 * <li>component : the source component</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * <li>status : the status object</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>DragDrop</b> : DNDEvent(target, source, data, component, event,
 * dragEvent, status)<br>
 * <div>Fires after the user drops data over the target.</div>
 * <ul>
 * <li>target : this</li>
 * <li>source : the drag source
 * <li>data : the data being dragged
 * <li>component : the source component</li>
 * <li>event : the dom event</li>
 * <li>dragEvent : the drag event (draggable)</li>
 * <li>status : the status object</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class DropTarget extends BaseObservable {

  protected Component component;
  protected String overStyle;
  protected Operation operation;
  protected Feedback feedback;

  private boolean allowSelfAsSource;
  private String group = "";
  private boolean enabled = true;

  /**
   * Creates a new drop target.
   * 
   * @param target the target component
   */
  public DropTarget(Component target) {
    this.component = target;
    this.operation = Operation.MOVE;
    this.feedback = Feedback.APPEND;
    DNDManager.get().registerDropTarget(this);
  }

  /**
   * Adds the listener to the target.
   * 
   * @param listener the listener to add
   */
  public void addDNDListener(DNDListener listener) {
    addListener(Events.DragEnter, listener);
    addListener(Events.DragLeave, listener);
    addListener(Events.DragCancel, listener);
    addListener(Events.Drop, listener);
    addListener(Events.DragMove, listener);
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
   * Returns the target's component.
   * 
   * @return the component
   */
  public Component getComponent() {
    return component;
  }

  /**
   * Returns the target's feedback setting.
   * 
   * @return the feedback
   */
  public Feedback getFeedback() {
    return feedback;
  }

  /**
   * Returns the target's group name.
   * 
   * @return the group name
   */
  public String getGroup() {
    return group;
  }

  /**
   * Returns the target's operation.
   * 
   * @return the operation
   */
  public Operation getOperation() {
    return operation;
  }

  /**
   * Returns the target's over style.
   * 
   * @return the over style
   */
  public String getOverStyle() {
    return overStyle;
  }

  /**
   * Returns true if internal drops are allowed.
   * 
   * @return true for internal drops
   */
  public boolean isAllowSelfAsSource() {
    return allowSelfAsSource;
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
   * Unregisters the target as a drop target.
   */
  public void release() {
    DNDManager.get().unregisterDropTarget(this);
  }

  /**
   * Removes the listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeDNDListener(DNDListener listener) {
    removeListener(Events.DragStart, listener);
    removeListener(Events.DragLeave, listener);
    removeListener(Events.DragMove, listener);
    removeListener(Events.DragCancel, listener);
    removeListener(Events.Drop, listener);
  }

  /**
   * Sets whether internal drops are allowed (defaults to false).
   * 
   * @param allowSelfAsSource true to allow internal drops
   */
  public void setAllowSelfAsSource(boolean allowSelfAsSource) {
    this.allowSelfAsSource = allowSelfAsSource;
  }

  /**
   * Sets the target's feedback. Feedback determines the type of visual
   * indicators a drop target supports. Subclasses will determine range of valid
   * values.
   * 
   * @param feedback the feedback
   */
  public void setFeedback(Feedback feedback) {
    this.feedback = feedback;
  }

  /**
   * Sets the drag group. If specified, only drag sources with the same group
   * value are allowed.
   * 
   * @param group the group name
   */
  public void setGroup(String group) {
    this.group = group;
  }

  /**
   * Sets the operation for the drop target which specifies if data should be
   * moved or copied when dropped. Drag sources use this value to determine if
   * the target data should be removed from the source component.
   * 
   * @param operation the operation
   */
  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  /**
   * Sets the style name to be applied when the cursor is over the target
   * (defaults to null).
   * 
   * @param overStyle the over style
   */
  public void setOverStyle(String overStyle) {
    this.overStyle = overStyle;
  }

  /**
   * Called if the user cancels the drag operations while the mouse is over the
   * target.
   * 
   * @param event the dd event
   */
  protected void onDragCancelled(DNDEvent event) {
    Insert.get().hide();
  }

  /**
   * Called when the user releases the mouse over the target component.
   * 
   * @param event the dd event
   */
  protected void onDragDrop(DNDEvent event) {

  }

  /**
   * Called when the cursor first enters the bounds of the drop target.
   * Subclasses or listeners can change the status of status proxy via the
   * passed event.
   * 
   * @param event the dd event
   */
  protected void onDragEnter(DNDEvent event) {

  }

  /**
   * Called when the cursor leaves the target.
   * 
   * @param event the dd event
   */
  protected void onDragLeave(DNDEvent event) {

  }

  /**
   * Called when the cursor is moved within the target component. Subclasses or
   * listeners can change the status of status proxy via the passed event. If
   * either a subclass or listener sets {@link BaseEvent#setCancelled(boolean)}
   * to true, {@link #showFeedback(DNDEvent)} will be called.
   * 
   * @param event the dd event
   */
  protected void onDragMove(DNDEvent event) {

  }

  /**
   * Called as the mouse is moved over the target component. The default
   * implementation does nothing.
   * 
   * @param event the dd event
   */
  protected void showFeedback(DNDEvent event) {

  }

  boolean handleDragEnter(DNDEvent event) {
    event.setCancelled(false);
    event.getStatus().setStatus(true);
    onDragEnter(event);
    if (!fireEvent(Events.DragEnter, event)) {
      event.getStatus().setStatus(false);
      return false;
    }
    if (overStyle != null) {
      component.addStyleName(overStyle);
    }
    return true;
  }

  void handleDragLeave(DNDEvent event) {
    if (overStyle != null) {
      component.removeStyleName(overStyle);
    }
    event.getStatus().setStatus(false);
    Insert.get().hide();
    onDragLeave(event);
  }

  void handleDragMove(DNDEvent event) {
    showFeedback(event);
    onDragMove(event);
  }

  void handleDrop(DNDEvent event) {
    Insert.get().hide();
    if (overStyle != null) {
      component.removeStyleName(overStyle);
    }
    onDragDrop(event);
  }

}

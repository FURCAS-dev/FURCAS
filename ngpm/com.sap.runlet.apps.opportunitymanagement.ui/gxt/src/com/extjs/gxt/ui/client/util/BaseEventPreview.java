/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import com.extjs.gxt.ui.client.core.CompositeElement;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.PreviewEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;

/**
 * Specialized <code>EventPreview</code>. Provides auto hide support and the
 * ability to add elements which should be ignored when auto hide is enabled.
 * 
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Add</b> : PreviewEvent(preview, event, target)<br>
 * <div>Fires after event preview is added.</div>
 * <ul>
 * <li>preview : this</li>
 * <li>event : the dom event</li>
 * <li>target : the target element</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : PreviewEvent(preview)<br>
 * <div>Fires after event preview has been removed.</div>
 * <ul>
 * <li>preview : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>KeyPress</b> : PreviewEvent(preview, target, event)<br>
 * <div>Fires when a key is pressed while event preview is active.</div>
 * <ul>
 * <li>preview : this</li>
 * <li>target : the target element</li>
 * <li>event : event</li>
 * </ul>
 * </dd> </dt>
 */
public class BaseEventPreview extends BaseObservable implements NativePreviewHandler {

  private static int lastX, lastY;

  /**
   * Returns the last client x value when a base event preview is on top of the
   * preview stack.
   * 
   * @return the last client y value
   */
  public static int getLastClientX() {
    return lastX;
  }

  /**
   * Returns the last xy value when a base event preview is on top of the
   * preview stack.
   * 
   * @return the last client x and client y
   */
  public static Point getLastXY() {
    return new Point(lastX, lastY);
  }

  /**
   * Returns the last client y value when a base event preview is on top of the
   * preview stack.
   * 
   * @return the last client y value
   */
  public static int getLastClientY() {
    return lastY;
  }

  private CompositeElement ignoreList = new CompositeElement();
  private boolean autoHide = true;
  private boolean autoHideAllowEvent;
  private HandlerRegistration handler;

  /**
   * Adds this instance to the event preview stack.
   */
  public void add() {
    if (handler == null) {
      handler = Event.addNativePreviewHandler(this);
      onAdd();
      fireEvent(Events.Add);
    }
  }

  /**
   * Returns the ignore list.
   * 
   * @return this list
   */
  public CompositeElement getIgnoreList() {
    return ignoreList;
  }

  /**
   * Returns true if auto hide is enabled.
   * 
   * @return the auto hide state
   */
  public boolean isAutoHide() {
    return autoHide;
  }

  /**
   * Returns true if the auto hide event is cancelled.
   * 
   * @return the auto hide event
   */
  public boolean isAutoHideAllowEvent() {
    return autoHideAllowEvent;
  }

  public void onPreviewNativeEvent(NativePreviewEvent event) {
    Event e = event.getNativeEvent().<Event> cast();

    PreviewEvent pe = new PreviewEvent(this, event);
    pe.setType(new EventType(e.getTypeInt()));
    pe.setEvent(e);

    lastX = pe.getClientX();
    lastY = pe.getClientY();

    if (autoHide && onAutoHidePreview(pe)) {
      if (autoHideAllowEvent) {
        event.cancel();
      }
      remove();
    }

    if (!onPreview(pe)) {
      event.cancel();
    }
  }

  /**
   * Pushes the event preview to the stop of the stack.
   */
  public void push() {
    if (handler != null) {
      remove();
      add();
    }
  }

  /**
   * Removes event preview.
   */
  public void remove() {
    if (handler != null) {
      handler.removeHandler();
      handler = null;
      onRemove();
      fireEvent(Events.Remove);
    }
  }

  /**
   * True to remove the event preview when the user clicks on an element not it
   * the ignore list (default to true).
   * 
   * @param autoHide the auto hide state
   */
  public void setAutoHide(boolean autoHide) {
    this.autoHide = autoHide;
  }

  /**
   * Sets if the event that removes event preview is cancelled (default to
   * true). Only applies when {@link #setAutoHide(boolean)} is true.
   * 
   * @param autoHideAllowEvent true to cancel the event
   */
  public void setAutoHideCancelEvent(boolean autoHideAllowEvent) {
    this.autoHideAllowEvent = autoHideAllowEvent;
  }

  /**
   * List of elements to be ignored when autoHide is enabled. An example of
   * usage would be a menu item that displays a sub menu. When the sub menu is
   * displayed, the menu item is added to the ignore list so that the sub menu
   * will not close when the mousing over the item.
   * 
   * @param ignoreList the ignore list
   */
  public void setIgnoreList(CompositeElement ignoreList) {
    this.ignoreList = ignoreList;
  }

  protected void onAdd() {

  }

  /**
   * Called right before event preview will be removed from auto hide.
   * 
   * @param ce the component event
   * @return true to allow auto hide, false to cancel
   */
  protected boolean onAutoHide(PreviewEvent ce) {
    return true;
  }

  /**
   * Called when a preview event is received and {@link #autoHide} is enabled.
   * 
   * @param ce the component event
   * @return true to remove event preview
   */
  protected boolean onAutoHidePreview(PreviewEvent ce) {
    switch (ce.getType().getEventCode()) {
      case Event.ONMOUSEDOWN:
      case Event.ONMOUSEUP:
      case Event.ONCLICK:
      case Event.ONDBLCLICK: {
        boolean ignore = getIgnoreList().is(ce.getTarget());
        if (!ignore && onAutoHide(ce)) {
          return true;
        }
      }
    }
    return false;
  }

  protected void onClick(PreviewEvent pe) {

  }

  /**
   * Called when a preview event is received.
   * 
   * @param pe the component event
   * @return true to allow the event
   */
  protected boolean onPreview(PreviewEvent pe) {
    switch (pe.getType().getEventCode()) {
      case Event.ONKEYPRESS:

        if (KeyNav.getKeyEvent().getEventCode() == Event.ONKEYPRESS) {
          onPreviewKeyPress(pe);
        }
        break;
      case Event.ONKEYDOWN:
        if (KeyNav.getKeyEvent().getEventCode() == Event.ONKEYDOWN) {
          onPreviewKeyPress(pe);
        }
        break;
      case Event.ONCLICK:
        onClick(pe);
    }
    return true;
  }

  protected void onPreviewKeyPress(PreviewEvent pe) {
    fireEvent(Events.KeyPress, pe);
  }

  protected void onRemove() {

  }

}

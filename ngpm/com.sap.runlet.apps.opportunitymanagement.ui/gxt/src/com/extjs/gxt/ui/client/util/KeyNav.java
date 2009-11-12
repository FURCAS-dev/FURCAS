/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyboardEvents;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyCodes;

/**
 * Provides a convenient wrapper for normalized keyboard navigation. Provides an
 * easy way to implement custom navigation schemes for any UI component.
 */
public class KeyNav<E extends ComponentEvent> extends BaseObservable implements Listener<E> {

  private static EventType keyEvent;
  private Component component;
  private boolean cancelBubble;
  private boolean preventDefault;

  static {
    // mods press up
    // Safari no yes
    // IE yes yes
    // FF yes no
    // Opera yes no

    // nav press down
    // IE no yes
    // FF yes yes
    // Safari no yes
    // Opera yes yes
    if (GXT.isIE || GXT.isWebKit || GXT.isGecko) {
      keyEvent = Events.OnKeyDown;
    } else {
      keyEvent = Events.OnKeyPress;
    }
  }

  public static EventType getKeyEvent() {
    return keyEvent;
  }

  /**
   * Creates a new KeyNav without a target component. Events must be passed to
   * the {@link #handleEvent(BaseEvent)} method.
   */
  public KeyNav() {

  }

  /**
   * Creates a new key nav for the specified target. The KeyNav will listen for
   * the key events.
   * 
   * @param target the target component
   */
  public KeyNav(Component target) {
    bind(target);
  }

  public void addKeyNavListener(KeyNavListener listener) {
    addListener(KeyboardEvents.Alt, listener);
    addListener(KeyboardEvents.BackSpace, listener);
    addListener(KeyboardEvents.Control, listener);
    addListener(KeyboardEvents.Delete, listener);
    addListener(KeyboardEvents.Down, listener);
    addListener(KeyboardEvents.End, listener);
    addListener(KeyboardEvents.Enter, listener);
    addListener(KeyboardEvents.Escape, listener);
    addListener(KeyboardEvents.Home, listener);
    addListener(KeyboardEvents.Left, listener);
    addListener(KeyboardEvents.PageDown, listener);
    addListener(KeyboardEvents.PageUp, listener);
    addListener(KeyboardEvents.Right, listener);
    addListener(KeyboardEvents.Shift, listener);
    addListener(KeyboardEvents.Tab, listener);
    addListener(KeyboardEvents.Up, listener);
  }

  /**
   * Binds the key nav to the component.
   * 
   * @param target the target component
   */
  public void bind(final Component target) {
    if (this.component != null) {
      this.component.removeListener(keyEvent, this);
    }
    if (target != null) {
      target.addListener(keyEvent, this);
      target.sinkEvents(keyEvent.getEventCode());
    }
    this.component = target;
  }

  /**
   * Returns the cancel bubble state.
   * 
   * @return true if bubbling is cancelled
   */
  public boolean getCancelBubble() {
    return cancelBubble;
  }

  /**
   * Returns the target component.
   * 
   * @return the target component
   */
  public Component getComponent() {
    return component;
  }

  /**
   * Returns true if the default event action is being cancelled.
   * 
   * @return true if preventing default
   */
  public boolean getPreventDefault() {
    return preventDefault;
  }

  @SuppressWarnings("unchecked")
  public void handleEvent(ComponentEvent ce) {
    if (ce.getType() == keyEvent) {
      if (component.getElement() != (Element) ce.getEvent().getCurrentEventTarget().cast()) {
        return;
      }
      if (cancelBubble) {
        ce.cancelBubble();
      }
      if (preventDefault) {
        ce.preventDefault();
      }

      int code = ce.getKeyCode();

      E e = (E) ce;

      onKeyPress(e);

      switch (code) {
        case KeyCodes.KEY_ALT:
          onAlt(e);
          break;
        case KeyCodes.KEY_BACKSPACE:
          onBackspace(e);
          break;
        case KeyCodes.KEY_CTRL:
          onControl(e);
          break;
        case KeyCodes.KEY_DELETE:
          onDelete(e);
          break;
        case KeyCodes.KEY_DOWN:
          onDown(e);
          break;
        case KeyCodes.KEY_END:
          onEnd(e);
          break;
        case KeyCodes.KEY_ENTER:
          onEnter(e);
          break;
        case KeyCodes.KEY_ESCAPE:
          onEsc(e);
          break;
        case KeyCodes.KEY_HOME:
          onHome(e);
          break;
        case KeyCodes.KEY_LEFT:
          onLeft(e);
          break;
        case KeyCodes.KEY_PAGEDOWN:
          onPageDown(e);
          break;
        case KeyCodes.KEY_PAGEUP:
          onPageUp(e);
          break;
        case KeyCodes.KEY_SHIFT:
          onShift(e);
          break;
        case KeyCodes.KEY_TAB:
          onTab(e);
          break;
        case KeyCodes.KEY_RIGHT:
          onRight(e);
          break;
        case KeyCodes.KEY_UP:
          onUp(e);
          break;
      }

      fireEvent(new EventType(code), e);
    }
  }

  public void onKeyPress(E ce) {

  }

  public void onAlt(E ce) {

  }

  public void onBackspace(E ce) {

  }

  public void onControl(E ce) {

  }

  public void onDelete(E ce) {

  }

  public void onDown(E ce) {

  }

  public void onEnd(E ce) {

  }

  public void onEnter(E ce) {

  }

  public void onEsc(E ce) {

  }

  public void onHome(E ce) {

  }

  public void onLeft(E ce) {

  }

  public void onPageDown(E ce) {

  }

  public void onPageUp(E ce) {

  }

  public void onRight(E ce) {

  }

  public void onShift(E ce) {

  }

  public void onTab(E ce) {

  }

  public void onUp(E ce) {

  }

  public void removeKeyNavListener(KeyNavListener listener) {
    removeListener(KeyboardEvents.Alt, listener);
    removeListener(KeyboardEvents.BackSpace, listener);
    removeListener(KeyboardEvents.Control, listener);
    removeListener(KeyboardEvents.Delete, listener);
    removeListener(KeyboardEvents.Down, listener);
    removeListener(KeyboardEvents.End, listener);
    removeListener(KeyboardEvents.Enter, listener);
    removeListener(KeyboardEvents.Escape, listener);
    removeListener(KeyboardEvents.Home, listener);
    removeListener(KeyboardEvents.Left, listener);
    removeListener(KeyboardEvents.PageDown, listener);
    removeListener(KeyboardEvents.PageUp, listener);
    removeListener(KeyboardEvents.Right, listener);
    removeListener(KeyboardEvents.Shift, listener);
    removeListener(KeyboardEvents.Tab, listener);
    removeListener(KeyboardEvents.Up, listener);
  }

  /**
   * True to stop event bubbling when the key nav intercepts a key (defaults to
   * false).
   * 
   * @param cancelBubble the cancel bubble state
   */
  public void setCancelBubble(boolean cancelBubble) {
    this.cancelBubble = cancelBubble;
  }

  /**
   * True to prevent the default action of the key event when the key nav
   * intercepts a key (defaults to false).
   * 
   * @param preventDefault true to prevent the default
   */
  public void setPreventDefault(boolean preventDefault) {
    this.preventDefault = preventDefault;
  }

}

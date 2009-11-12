/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Point;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A <code>BaseEvent</code> that wraps a browser event and provides a set of DOM
 * related method.
 * 
 * <pre>
    Button btn = new Button();
    btn.addListener(Event.ONCLICK, new Listener&lt;ButtonEvent>() {
      public void handleEvent(ButtonEvent be) {
        // ButtonEvent is a DomEvent subclass
        
        // retrieve the event target
        Element target = be.getTarget();
        
        // get the mouse location
        Point point = be.getXY();
        
        // is the control key pressed?
        boolean control = be.isControlKey();
        
        // cancel event bubbling
        be.cancelBubble();
      }
    });
 * </pre>
 */
public class DomEvent extends BaseEvent {

  protected Event event;

  private El el;

  /**
   * Creates a new base event.
   * 
   * @param source the source object
   */
  public DomEvent(Object source) {
    super(source);
  }
  
  /**
   * Creates a new base event.
   * 
   * @param source the source object
   */
  public DomEvent(Object source, Event event) {
    super(source);
    this.event = event;
  }

  /**
   * Cancels bubbling for the given event. This will stop the event from being
   * propagated to parent elements.
   */
  public void cancelBubble() {
    if (event != null) {
      DOM.eventCancelBubble(event, true);
    }
  }

  /**
   * Returns the event's x coordinate.
   * 
   * @return the x coordinate or -1 if no dom event.
   */
  public int getClientX() {
    if (event != null) {
      return DOM.eventGetClientX(event);
    }
    return -1;
  }

  /**
   * Returns the event's y coordinate.
   * 
   * @return the y coordinate or -1 if no dom event.
   */
  public int getClientY() {
    if (event != null) {
      return DOM.eventGetClientY(event);
    }
    return -1;
  }

  /**
   * Returns the dom event.
   * 
   * @return the dom event
   */
  public Event getEvent() {
    return event;
  }

  /**
   * Returns the dom event type int.
   * 
   * @return the event type
   */
  public int getEventTypeInt() {
    return event == null ? -1 : DOM.eventGetType(event);
  }

  /**
   * Returns the key code associated with this event.
   * 
   * @return the key code
   */
  public int getKeyCode() {
    return event == null ? -1 : DOM.eventGetKeyCode(event);
  }

  /**
   * Returns the event's target element.
   * 
   * @return the target element or <code>null</code> if no dom event
   */
  public Element getTarget() {
    return event == null ? null : DOM.eventGetTarget(event);
  }

  /**
   * Returns the matching parent using the specified selector.
   * 
   * @param selector the CSS selector
   * @param maxDepth the maximum number of parents to search
   * @return the matching element or null
   */
  public El getTarget(String selector, int maxDepth) {
    return getTargetEl().findParent(selector, maxDepth);
  }

  /**
   * Returns the event's target element.
   * 
   * @return the target element or <code>null</code> if no dom event
   */
  public El getTargetEl() {
    if (event != null) {
      if (el == null) {
        el = new El(getTarget());
      }
      return el;
    }
    return null;
  }

  /**
   * Returns the mouse location.
   * 
   * @return the mouse location
   */
  public Point getXY() {
    if (event != null) {
      return new Point(getClientX(), getClientY());
    }
    return null;
  }

  /**
   * Returns <code>true</code> if the control, alt, shift, or meta key is
   * pressed.
   * 
   * @return the modifier state
   */
  public boolean hasModifier() {
    if (event != null) {
      if (DOM.eventGetAltKey(event) || DOM.eventGetCtrlKey(event)
          || DOM.eventGetShiftKey(event) || DOM.eventGetMetaKey(event)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns <code>true</code> if the alt key is pressed.
   * 
   * @return the alt key state
   */
  public boolean isAltKey() {
    return event == null ? false : DOM.eventGetAltKey(event);
  }

  /**
   * Returns <code>true</code> if the control key (or meta key) is pressed.
   * 
   * @return the control key state
   */
  public boolean isControlKey() {
    return event == null ? false
        : (DOM.eventGetCtrlKey(event) || DOM.eventGetMetaKey(event));
  }

  /**
   * Returns true if the key is a "navigation" key.
   * 
   * @return the nav state
   */
  public boolean isNavKeyPress() {
    int k = getKeyCode();
    
    return (k >= 33 && k <= 40) || k == KeyCodes.KEY_ESCAPE || k == KeyCodes.KEY_ENTER || k == KeyCodes.KEY_TAB;
  }

  /**
   * Returns <code>true</code> if the event is a right click.
   * 
   * @return the right click state
   */
  public boolean isRightClick() {
    if (event != null) {
      if (DOM.eventGetButton(event) == Event.BUTTON_RIGHT
          || (GXT.isMac && DOM.eventGetCtrlKey(event))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns <code>true</code> if the shift key is pressed.
   * 
   * @return the shift key state
   */
  public boolean isShiftKey() {
    return event == null ? false : DOM.eventGetShiftKey(event);
  }

  /**
   * Returns true if the key is a "special" key.
   * 
   * @return the special state
   */
  public boolean isSpecialKey() {
    return isSpecialKey(getKeyCode());
  }

  /**
   * Returns true if the key is a "special" key.
   * 
   * @param k the key code
   * @return the special state
   */
  public boolean isSpecialKey(int k) {
    return k == 17 || k == 9 || k == 13 || k == 40 || k == 27 || (k == 16) || (k == 17)
        || (k >= 18 && k <= 20) || (k >= 33 && k <= 35) || (k >= 36 && k <= 39)
        || (k >= 44 && k <= 45);
  }

  /**
   * Prevents the browser from taking its default action for the given event.
   */
  public void preventDefault() {
    if (event != null) {
      DOM.eventPreventDefault(event);
    }
  }

  /**
   * Sets the dom event.
   * 
   * @param event the dom event
   */
  public void setEvent(Event event) {
    this.event = event;
  }

  /**
   * Stops the event (preventDefault and cancelBubble).
   */
  public void stopEvent() {
    cancelBubble();
    preventDefault();
  }

  /**
   * Returns <code>true</code> if the target of this event equals or is a child
   * of the given element.
   * 
   * @param element the element
   * @return the within state
   */
  public boolean within(Element element) {
    if (event != null) {
      return DOM.isOrHasChild(element, getTarget());
    }
    return false;
  }

  /**
   * Returns <code>true</code> if the target of this event equals or is a child
   * of the given element.
   * 
   * @param element the element
   * @param toElement true to use {@link Event#getToElement()}
   * @return the within state
   */
  public boolean within(Element element, boolean toElement) {
    if (!toElement) {
      return within(element);
    } else {
      if (event != null) {
        Element to = event.getRelatedEventTarget().cast();
        return DOM.isOrHasChild(element, to);
      }
    }
    return false;
  }
}

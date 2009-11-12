/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.google.gwt.user.client.Event;

/**
 * Base class for all events types.
 */
public class EventType {

  private int eventCode = -1;

  /**
   * Creates a new event type.
   */
  public EventType() {

  }

  /**
   * Creates a new browser based event type.
   * 
   * @param eventCode additional information about the event
   */
  public EventType(int eventCode) {
    this.eventCode = eventCode;
  }

  /**
   * Returns the event code.
   * 
   * @return the event code
   * @see Event
   */
  public int getEventCode() {
    return eventCode;
  }

  /**
   * Returns true if the event type represents a browser event type (GWT event).
   * 
   * @return true for browser event types
   */
  public boolean isBrowserEvent() {
    return eventCode != -1;
  }

}

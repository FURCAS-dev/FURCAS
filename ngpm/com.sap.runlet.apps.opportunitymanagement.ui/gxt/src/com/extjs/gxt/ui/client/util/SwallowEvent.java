/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import com.extjs.gxt.ui.client.event.EventType;
import com.google.gwt.user.client.Element;

public class SwallowEvent {
  
  private EventType eventType;
  private Element element;
  private boolean preventDefault;

  public SwallowEvent(EventType eventType, Element element, boolean preventDefault) {
    this.preventDefault = preventDefault;
    this.element = element;
    this.eventType = eventType;
  }

  public Element getElement() {
    return element;
  }

  public EventType getEventType() {
    return eventType;
  }

  public boolean isPreventDefault() {
    return preventDefault;
  }

  public void setElement(Element element) {
    this.element = element;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public void setPreventDefault(boolean preventDefault) {
    this.preventDefault = preventDefault;
  }
}

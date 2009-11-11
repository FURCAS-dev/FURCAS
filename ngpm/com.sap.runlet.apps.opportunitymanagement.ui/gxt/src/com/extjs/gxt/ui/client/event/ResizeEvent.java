/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.fx.Resizable;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.Event;

/**
 * Resizable event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see Resizable
 */
public class ResizeEvent extends BaseEvent {

  /**
   * The component being resized.
   */
  private Component component;

  /**
   * The DOM event.
   */
  private Event event;

  /**
   * The resizable instance.
   */
  private Resizable resizable;

  public ResizeEvent(Resizable resizable) {
    super(resizable);
    this.resizable = resizable;
  }

  public ResizeEvent(Resizable resizable, Component component, Event event) {
    super(resizable);
    this.resizable = resizable;
    this.component = component;
    this.event = event;
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
   * Returns the event.
   * 
   * @return the event
   */
  public Event getEvent() {
    return event;
  }

  /**
   * Returns the source resizable instance.
   * 
   * @return the source resizable instance
   */
  public Resizable getResizable() {
    return resizable;
  }

  /**
   * Sets the source component.
   * 
   * @param component the source component
   */
  public void setComponent(Component component) {
    this.component = component;
  }

  /**
   * Sets the event.
   * 
   * @param event the event
   */
  public void setEvent(Event event) {
    this.event = event;
  }

  /**
   * Sets the source resizable instance.
   * 
   * @param resizable the source resizable instance
   */
  public void setResizable(Resizable resizable) {
    this.resizable = resizable;
  }

}

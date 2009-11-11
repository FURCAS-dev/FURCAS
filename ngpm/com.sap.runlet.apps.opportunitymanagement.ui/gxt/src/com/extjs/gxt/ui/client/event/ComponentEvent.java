/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import java.util.Map;

import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.Event;

/**
 * Component event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see Component
 */
public class ComponentEvent extends DomEvent {

  /**
   * The component that issued the event.
   */
  private Component component;

  /**
   * The component state.
   */
  private Map<String, Object> state;

  /**
   * Creates a new base event.
   * 
   * @param component the source component
   */
  public ComponentEvent(Component component) {
    super(component);
    this.component = component;
  }

  /**
   * Creates a new base event.
   * 
   * @param component the source component
   */
  public ComponentEvent(Component component, Event event) {
    super(component, event);
    this.component = component;
  }

  /**
   * Returns the source component.
   * 
   * @return the component
   */
  @SuppressWarnings("unchecked")
  public <X extends Component> X getComponent() {
    return (X) component;
  }

  /**
   * Returns the component state.
   * 
   * @return the state
   */
  public Map<String, Object> getState() {
    return state;
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
   * Sets the component state.
   * 
   * @param state the state
   */
  public void setState(Map<String, Object> state) {
    this.state = state;
  }

}

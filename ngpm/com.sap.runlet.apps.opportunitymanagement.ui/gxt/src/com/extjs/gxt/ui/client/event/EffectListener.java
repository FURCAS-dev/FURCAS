/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;


/**
 * Event interface for effect events.
 */
public class EffectListener implements Listener<BaseEvent> {

  public void handleEvent(BaseEvent e) {
    EventType type = e.getType();
    if (type == Events.EffectCancel) {
      effectStart(e);
    } else if (type == Events.EffectComplete){
      effectComplete(e);
    } else if (type == Events.EffectStart) {
      effectStart(e);
    }
  }

  /**
   * Fires prior to an effect starting.
   * 
   * @param be an event containing information about the event
   */
  public void effectStart(BaseEvent be) {

  }

  /**
   * Fires after an effect has been cancelled.
   * 
   * @param be an event containing information about the event
   */
  public void effectCancel(BaseEvent be) {

  }

  /**
   * Fires after an effect has completed.
   * 
   * @param be an event containing information about the event
   */
  public void effectComplete(BaseEvent be) {

  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;


/**
 * Resize listener.
 */
public class ResizeListener implements Listener<ResizeEvent> {

  public void handleEvent(ResizeEvent e) {
    EventType type = e.getType();
    if (type == Events.ResizeStart) {
      resizeStart(e);
    } else if (type == Events.ResizeEnd){
      resizeEnd(e);
    }
  }

  public void resizeStart(ResizeEvent re) {

  }

  public void resizeEnd(ResizeEvent re) {

  }

}

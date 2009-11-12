/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;


/**
 * Drag listener.
 */
public class DragListener implements Listener<DragEvent> {

  public void handleEvent(DragEvent de) {
    EventType type = de.getType();
    if (type == Events.DragCancel) {
      dragCancel(de);
    } else if (type == Events.DragEnd){
      dragEnd(de);
    } else if (type == Events.DragMove) {
      dragMove(de);
    } else if (type == Events.DragStart) {
      dragStart(de);
    } 
  }

  /**
   * Fires after a drag begins.
   * 
   * @param de the drag event
   */
  public void dragStart(DragEvent de) {

  }

  /**
   * Fires after the mouse moves.
   * 
   * @param de the drag event
   */
  public void dragMove(DragEvent de) {

  }

  /**
   * Fires after a drag ends.
   * 
   * @param de the drag event
   */
  public void dragEnd(DragEvent de) {

  }

  /**
   * Fires after a drag is cancelled.
   * 
   * @param de the drag event
   */
  public void dragCancel(DragEvent de) {

  }

}

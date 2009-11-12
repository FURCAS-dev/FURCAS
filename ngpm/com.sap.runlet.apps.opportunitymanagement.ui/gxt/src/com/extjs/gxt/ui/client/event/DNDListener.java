/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;


public class DNDListener implements Listener<DNDEvent> {

  public void handleEvent(DNDEvent e) {
    EventType type = e.getType();
    if (type == Events.DragStart) {
      dragStart(e);
    } else if (type == Events.DragEnter){
      dragEnter(e);
    } else if (type == Events.DragLeave) {
      dragLeave(e);
    } else if (type == Events.DragMove) {
      dragMove(e);
    } else if (type == Events.Drop) {
      dragDrop(e);
    }
  }

  public void dragMove(DNDEvent e) {

  }

  public void dragStart(DNDEvent e) {

  }

  public void dragEnter(DNDEvent e) {

  }

  public void dragLeave(DNDEvent e) {

  }

  public void dragDrop(DNDEvent e) {

  }

}

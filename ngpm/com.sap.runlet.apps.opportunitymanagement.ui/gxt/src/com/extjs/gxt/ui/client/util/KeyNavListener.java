/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.event.dom.client.KeyCodes;

/**
 * Listener for key navs.
 * 
 * @see KeyNav
 */
public class KeyNavListener implements Listener<ComponentEvent> {

  public void handleEvent(ComponentEvent e) {
    EventType type = e.getType();
    switch (type.getEventCode()) {
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
  }

  public void onDelete(ComponentEvent ce) {

  }

  public void onDown(ComponentEvent ce) {

  }

  public void onEnd(ComponentEvent ce) {

  }

  public void onEnter(ComponentEvent ce) {

  }

  public void onEscape(ComponentEvent ce) {

  }

  public void onHome(ComponentEvent ce) {

  }

  public void onKeyPress(ComponentEvent ce) {

  }

  public void onLeft(ComponentEvent ce) {

  }

  public void onRight(ComponentEvent ce) {

  }

  public void onUp(ComponentEvent ce) {

  }

  public void onPageDown(ComponentEvent ce) {

  }

  public void onPageUp(ComponentEvent ce) {

  }

  public void onTab(ComponentEvent ce) {

  }

}

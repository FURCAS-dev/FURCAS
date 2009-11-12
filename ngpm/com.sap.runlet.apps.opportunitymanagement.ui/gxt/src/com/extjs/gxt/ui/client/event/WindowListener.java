/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;


/**
 * Event interface for windows.
 */
public class WindowListener implements Listener<WindowEvent> {

  public void handleEvent(WindowEvent e) {
    EventType type = e.getType();
    if (type == Events.Activate) {
      windowActivate(e);
    } else if (type == Events.Deactivate) {
      windowDeactivate(e);
    } else if (type == Events.Hide) {
      windowHide(e);
    } else if (type == Events.Maximize) {
      windowMaximize(e);
    } else if (type == Events.Minimize) {
      windowMinimize(e);
    } else if (type == Events.Restore) {
      windowRestore(e);
    } else if (type == Events.Show) {
      windowShow(e);
    }
  }

  /**
   * Fires after the window is activated.
   * 
   * @param we the window event
   */
  public void windowActivate(WindowEvent we) {

  }

  /**
   * Fires after the window is deactivate.
   * 
   * @param we the window event
   */
  public void windowDeactivate(WindowEvent we) {

  }

  /**
   * Fires after the window is hidden.
   * 
   * @param we the window event
   */
  public void windowHide(WindowEvent we) {

  }

  /**
   * Fires after a window is opened.
   * 
   * @param we the window event
   */
  public void windowShow(WindowEvent we) {

  }

  /**
   * Fires after the window is maximized.
   * 
   * @param we the window event
   */
  public void windowMaximize(WindowEvent we) {

  }

  /**
   * Fires after the window is minmized.
   * 
   * @param we the window event
   */
  public void windowMinimize(WindowEvent we) {

  }

  /**
   * Fires after the window is restored.
   * 
   * @param we the window event
   */
  public void windowRestore(WindowEvent we) {

  }

}

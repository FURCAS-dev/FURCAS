/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.WindowManager;

public class WindowManagerEvent extends BaseEvent {

  /**
   * The window manager.
   */
  public WindowManager manager;

  /**
   * The window.
   */
  public Window window;

  public WindowManagerEvent(WindowManager manager) {
    super(manager);
    this.manager = manager;
  }

  public WindowManagerEvent(WindowManager manager, Window window) {
    this(manager);
    this.window = window;
  }

}

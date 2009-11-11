/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.user.client.Timer;

/**
 * A <code>Timer</code> that is cancelled if a new request is made.
 */
public class DelayedTask {

  private Timer timer;
  private Listener<?> listener;

  /**
   * Creates a new delayed task.
   * 
   * @param listener the listener to be called
   */
  public DelayedTask(final Listener<?> listener) {
    this.listener = listener;
    timer = new Timer() {
      public void run() {
        DelayedTask.this.listener.handleEvent(null);
      }
    };
  }

  /**
   * Cancels the task.
   */
  public void cancel() {
    timer.cancel();
  }

  /**
   * Cancels any running timers and starts a new one.
   * 
   * @param delay the delay in ms
   */
  public void delay(int delay) {
    timer.cancel();
    if (delay > 0) {
      timer.schedule(delay);
    } else {
      timer.run();
    }
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.form;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.Timer;

/**
 * Monitors the valid state of a form and enabled / disabled all buttons.
 */
public class FormButtonBinding {

  private FormPanel panel;
  private Timer timer;
  private int interval = 500;
  private Listener<ComponentEvent> listener;
  private List<Button> buttons;

  public FormButtonBinding(FormPanel panel) {
    this.panel = panel;

    buttons = new ArrayList<Button>();
    timer = new Timer() {
      @Override
      public void run() {
        FormButtonBinding.this.checkPanel();
      }
    };
    listener = new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent be) {
        if (be.getType() == Events.Attach) {
          FormButtonBinding.this.startMonitoring();
        } else if (be.getType() == Events.Detach) {
          FormButtonBinding.this.stopMonitoring();
        }
      }
    };
    panel.addListener(Events.Attach, listener);
    timer.scheduleRepeating(interval);

    if (panel.isAttached()) {
      startMonitoring();
    }

  }

  public void addButton(Button button) {
    buttons.add(button);
  }

  public int getInterval() {
    return interval;
  }

  public void removeButton(Button button) {
    buttons.remove(button);
  }

  public void setInterval(int interval) {
    this.interval = interval;
  }

  public void startMonitoring() {
    timer.run();
    timer.scheduleRepeating(interval);
  }

  public void stopMonitoring() {
    timer.cancel();
  }

  protected boolean checkPanel() {
    boolean v = panel.isValid(true);
    for (Button button : buttons) {
      button.setEnabled(v);
    }
    return v;

  }

}

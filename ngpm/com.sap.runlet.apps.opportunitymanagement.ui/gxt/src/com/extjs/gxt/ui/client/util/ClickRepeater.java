/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import java.util.Date;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ClickRepeaterEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.PreviewEvent;
import com.extjs.gxt.ui.client.widget.ComponentAttachable;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Timer;

public class ClickRepeater extends BaseObservable implements ComponentAttachable {
  private boolean accelerate;
  private int delay = 250;
  private El el;
  private int interval = 20;
  private Date mousedownTime;
  private BaseEventPreview preview;

  private String pressClass;

  private Timer timer;

  private boolean waitForMouseOut;

  private boolean waitForMouseOver;

  public ClickRepeater(El el) {
    this.el = el;
    preview = new BaseEventPreview() {
      protected boolean onPreview(PreviewEvent pe) {
        if (pe.getEventTypeInt() == Event.ONMOUSEUP) {
          ClickRepeater.this.handleMouseUp();
        }
        return true;
      }
    };
    preview.setAutoHide(false);
    el.addEventsSunk(Event.ONMOUSEDOWN | Event.ONMOUSEOUT | Event.ONMOUSEOVER);
  }

  public void doAttach() {
    DOM.setEventListener(el.dom, new EventListener() {
      public void onBrowserEvent(Event event) {
        switch (event.getTypeInt()) {
          case Event.ONMOUSEDOWN:
            handleMouseDown();
            break;
          case Event.ONMOUSEOUT:
            handleMouseOut();
            break;
          case Event.ONMOUSEOVER:
            handleMouseReturn();
            break;
        }
      }
    });

    el.disableTextSelection(true);
    preview.add();
  }

  public void doDetach() {
    DOM.setEventListener(el.dom, null);
    el.disableTextSelection(false);
    preview.remove();
  }

  public boolean fireEvent(EventType eventType) {
    return fireEvent(eventType, new ClickRepeaterEvent(this, el));
  }

  public int getDelay() {
    return delay;
  }

  public El getEl() {
    return el;
  }

  public int getInterval() {
    return interval;
  }

  public String getPressClass() {
    return pressClass;
  }

  public boolean isAccelerate() {
    return accelerate;
  }

  public void setAccelerate(boolean accelerate) {
    this.accelerate = accelerate;
  }

  public void setDelay(int delay) {
    this.delay = delay;
  }

  public void setInterval(int interval) {
    this.interval = interval;
  }

  public void setPressClass(String pressClass) {
    this.pressClass = pressClass;
  }

  // private
  protected void click() {
    fireEvent(Events.OnClick);
    timer.schedule(accelerate ? easeOutExpo(new Date().getTime()
        - mousedownTime.getTime(), 400, -390, 12000) : interval);
  }

  protected int easeOutExpo(long t, int b, int c, int d) {
    return (int) ((t == d) ? b + c : c * (-Math.pow(2, -10 * t / d) + 1) + b);
  }

  protected void handleMouseDown() {
    if (timer == null) {
      timer = new Timer() {
        public void run() {
          click();
        }
      };
    }
    timer.cancel();
    el.blur();

    if (pressClass != null) {
      el.addStyleName(pressClass);
    }
    mousedownTime = new Date();

    waitForMouseOut = true;
    fireEvent(Events.OnMouseDown);
    fireEvent(Events.OnClick);

    // Do not honor delay or interval if acceleration wanted.
    if (accelerate) {
      delay = 400;
    }
    timer.schedule(delay);
  }

  protected void handleMouseUp() {
    if (waitForMouseOut) {
      timer.cancel();
      waitForMouseOut = false;
      waitForMouseOver = false;
      el.removeStyleName(pressClass);
      fireEvent(Events.OnMouseUp);
    }
  }

  protected void handleMouseOut() {
    if (waitForMouseOut) {
      timer.cancel();
      if (pressClass != null) {
        el.removeStyleName(pressClass);
      }
      waitForMouseOver = true;
    }
  }

  protected void handleMouseReturn() {
    if (waitForMouseOver) {
      waitForMouseOver = false;
      if (pressClass != null) {
        el.addStyleName(pressClass);
      }
      click();
    }
  }
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.core.CompositeElement;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.util.Params;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;

/**
 * An updateable progress bar component. The progress bar supports two different
 * modes: manual and automatic.
 * 
 * <p />
 * In manual mode, you are responsible for showing, updating (via
 * {@link #updateProgress}) and clearing the progress bar as needed from your
 * own code. This method is most appropriate when you want to show progress
 * throughout an operation that has predictable points of interest at which you
 * can update the control.
 * 
 * <p />
 * In automatic mode, you simply call {@link #auto} and let the progress bar run
 * indefinitely, only clearing it once the operation is complete. You can
 * optionally have the progress bar wait for a specific amount of time and then
 * clear itself. Automatic mode is most appropriate for timed operations or
 * asynchronous operations in which you have no need for indicating intermediate
 * progress.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 */
public class ProgressBar extends BoxComponent {

  private String text = "";
  private int duration = Style.DEFAULT;
  private int interval = 300;
  private int increment = 10;
  private El progressBar;
  private El textTopElem, textBackElem;
  private CompositeElement textEl;
  private Timer timer;
  private boolean running;
  private int i = 0;
  private double value;

  /**
   * Creates a new progress bar.
   */
  public ProgressBar() {
    baseStyle = "x-progress";
  }

  /**
   * Initiates an auto-updating progress bar using the current duration,
   * increment, and interval.
   * 
   * @return this
   */
  public ProgressBar auto() {
    if (timer == null) {
      timer = new Timer() {
        public void run() {
          int inc = getIncrement();
          updateProgress(((((i++ + inc) % inc) + 1) * (100 / inc)) * .01, null);
        }
      };
    }
    timer.scheduleRepeating(getInterval());
    running = true;
    return this;
  }

  /**
   * Returns the duration.
   * 
   * @return the duration
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Returns the bar's increment value.
   * 
   * @return the increment the increment
   */
  public int getIncrement() {
    return increment;
  }

  /**
   * Returns the bar's interval value.
   * 
   * @return the interval in millseconds
   */
  public int getInterval() {
    return interval;
  }

  /**
   * Returns the current value.
   * 
   * @return the value
   */
  public double getValue() {
    return value;
  }

  /**
   * Returns true if the progress bar is currently in a {@link #auto} operation.
   * 
   * @return true if waiting, else false
   */
  public boolean isRunning() {
    return running;
  }

  /**
   * Resets the progress bar value to 0 and text to empty string.
   * 
   * @return this
   */
  public ProgressBar reset() {
    updateProgress(0, text);
    if (timer != null) {
      timer.cancel();
    }
    running = false;
    return this;
  }

  /**
   * The length of time in milliseconds that the progress bar should run before
   * resetting itself (defaults to DEFAULT, in which case it will run
   * indefinitely until reset is called)
   * 
   * @param duration the duration in milliseconds
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  /**
   * The number of progress update segments to display within the progress bar
   * (defaults to 10). If the bar reaches the end and is still updating, it will
   * automatically wrap back to the beginning.
   * 
   * @param increment the new increment
   */
  public void setIncrement(int increment) {
    this.increment = increment;
  }

  /**
   * Sets the length of time in milliseconds between each progress update
   * (defaults to 300 ms).
   * 
   * @param interval the interval to set
   */
  public void setInterval(int interval) {
    this.interval = interval;
  }

  /**
   * Updates the progress bar value, and optionally its text. If the text
   * argument is not specified, any existing text value will be unchanged. To
   * blank out existing text, pass "". Note that even if the progress bar value
   * exceeds 1, it will never automatically reset -- you are responsible for
   * determining when the progress is complete and calling {@link #reset} to
   * clear and/or hide the control.
   * 
   * @param value A value between 0 and 1 (e.g., .5, defaults to 0)
   * @param text The string to display in the progress text element or null.
   * @return this
   */
  public ProgressBar updateProgress(double value, String text) {
    if (value > 1) {
      value = 1;
    } else if (value < 0) {
      value = 0;
    }
    this.value = value;
    if (text != null) {
      updateText(text);
    }
    if (!rendered) {
      return this;
    }
    double w = Math.floor(value * el().firstChild().getWidth());
    progressBar.setWidth((int) w);
    if (textTopElem != null && w != 0) {
      textTopElem.removeStyleName("x-hidden").setWidth((int) w, true);
    } else if (textTopElem != null && w == 0) {
      textTopElem.addStyleName("x-hidden");
    }
    fireEvent(Events.Update, new ComponentEvent(this));
    return this;
  }

  /**
   * Updates the progress bar text. If specified, textEl will be updated,
   * otherwise the progress bar itself will display the updated text.
   * 
   * @param text The string to display in the progress text element
   */
  public void updateText(String text) {
    this.text = text != null ? text : "&#160;";
    if (rendered) {
      textEl.setInnerHtml(this.text);
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    StringBuffer sb = new StringBuffer();
    sb.append("<div class='{cls}-wrap'><div class='{cls}-inner'><div class='{cls}-bar'>");
    sb.append("<div class='{cls}-text'><div>&#160;</div></div></div>");
    sb.append("<div class='{cls}-text {cls}-text-back'><div>&#160;</div></div></div></div>");
  
    Template t = new Template(sb.toString());
    setElement(t.create(new Params("cls", baseStyle)), target, index);
  
    final El inner = el().firstChild();
    progressBar = inner.firstChild();
    textTopElem = progressBar.firstChild();
    textBackElem = inner.childNode(1);
    textTopElem.setStyleAttribute("zIndex", 99).addStyleName("x-hidden");
  
    textEl = new CompositeElement();
    textEl.add(textTopElem.firstChild().dom);
    textEl.add(textBackElem.firstChild().dom);
  
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        textEl.setWidth(inner.getWidth());
      }
    });
  
    if (text != null) {
      updateText(text);
    }
    if (value > 0) {
      updateProgress(value, text);
    }
  
  }

}

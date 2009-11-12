/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

import com.extjs.gxt.ui.client.core.El;

public class SingleStyleEffect extends BaseEffect {
  /**
   * The css style be adjusted.
   */
  public String style;

  /**
   * The start value.
   */
  public double from;

  /**
   * The end value.
   */
  public double to;

  public SingleStyleEffect(El el) {
    super(el);
  }

  public SingleStyleEffect(El el, String style, double from, double to) {
    this(el);
    this.style = style;
    this.from = from;
    this.to = to;
  }

  public void increase(double value) {
    el.setStyleAttribute(style, value);
  }

  public void onUpdate(double progress) {
    double v = (from + ((to - from) * progress));
    increase(v);
  }

}

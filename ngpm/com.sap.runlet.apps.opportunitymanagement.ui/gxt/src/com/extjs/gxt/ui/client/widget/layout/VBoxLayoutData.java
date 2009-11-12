/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.util.Margins;

/**
 * Layout data for {@link VBoxLayout}
 */
public class VBoxLayoutData extends MarginData {

  private double flex;
  private int minWidth = 0;;
  private int maxWidth = 1000000;

  /**
   * Creates a new vbox layout.
   */
  public VBoxLayoutData() {
    this(0, 0, 0, 0);
  }

  /**
   * Creates a new vbox layout.
   * 
   * @param m the margins
   */
  public VBoxLayoutData(Margins m) {
    super(m);
  }

  /**
   * Creates a new vbox layout.
   * 
   * @param top the top margin
   * @param right the right margin
   * @param bottom the bottom margin
   * @param left the left margin
   */
  public VBoxLayoutData(int top, int right, int bottom, int left) {
    super(top, right, bottom, left);
  }

  /**
   * Returns the flex value which is a weight used by the layout for sizing
   * calculations.
   * 
   * @return the flex
   */
  public double getFlex() {
    return flex;
  }

  /**
   * Returns the max width.
   * 
   * @return the max width
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Returns the minimum width.
   * 
   * @return the minimum width
   */
  public int getMinWidth() {
    return minWidth;
  }

  /**
   * Sets the weighted flex value. Each child item with a <tt>flex</tt> value
   * will be flexed <b>vertically</b> according to each item's <b>relative</b>
   * <tt>flex</tt> value compared to the sum of all items with a <tt>flex</tt>
   * value specified. Values of 0 (default) will cause the child to not be
   * 'flexed' with the initial height not being changed.
   * 
   * @param flex the flex value
   */
  public void setFlex(double flex) {
    this.flex = flex;
  }

  /**
   * Sets the max width (default to 1000000).
   * 
   * @param maxWidth the max width
   */
  public void setMaxWidth(int maxWidth) {
    this.maxWidth = maxWidth;
  }

  /**
   * Sets the minimum width (default to 0).
   * 
   * @param minWidth the minimum width
   */
  public void setMinWidth(int minWidth) {
    this.minWidth = minWidth;
  }

}

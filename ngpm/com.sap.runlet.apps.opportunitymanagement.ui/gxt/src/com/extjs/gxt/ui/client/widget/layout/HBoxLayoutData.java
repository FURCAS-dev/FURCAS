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
 * Layout data for {@link HBoxLayout}.
 */
public class HBoxLayoutData extends MarginData {

  private double flex;
  private int minHeight = 0;;
  private int maxHeight = 1000000;

  /**
   * Creates a new hbox layout.
   */
  public HBoxLayoutData() {
    this(0, 0, 0, 0);
  }

  /**
   * Creates a new hbox layout.
   * 
   * @param m the margins
   */
  public HBoxLayoutData(Margins m) {
    super(m);
  }

  /**
   * Creates a new hbox layout.
   * 
   * @param top the top margin
   * @param right the right margin
   * @param bottom the bottom margin
   * @param left the left margin
   */
  public HBoxLayoutData(int top, int right, int bottom, int left) {
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
   * Returns the max height.
   * 
   * @return the max height
   */
  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   * Returns the minimum height.
   * 
   * @return the minimum height
   */
  public int getMinHeight() {
    return minHeight;
  }

  /**
   * Sets the weighted flex value. Each child item with a <tt>flex</tt> value
   * will be flexed <b>horizontally</b> according to each item's <b>relative</b>
   * <tt>flex</tt> value compared to the sum of all items with a <tt>flex</tt>
   * value specified. Values of 0 (default) will cause the child to not be
   * 'flexed' with the initial width not being changed.
   * 
   * @param flex the flex value
   */
  public void setFlex(double flex) {
    this.flex = flex;
  }

  /**
   * Sets the max height (defaults to 1000000).
   * 
   * @param maxHeight the max height
   */
  public void setMaxHeight(int maxHeight) {
    this.maxHeight = maxHeight;
  }

  /**
   * Sets the minimum height (defaults to 0).
   * 
   * @param minHeight the minimum
   */
  public void setMinHeight(int minHeight) {
    this.minHeight = minHeight;
  }

}

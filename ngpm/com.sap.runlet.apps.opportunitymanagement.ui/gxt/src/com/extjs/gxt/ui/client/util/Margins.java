/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

/**
 * Represents 4-side margins.
 */
public class Margins {

  /**
   * The left margin.
   */
  public int left;

  /**
   * The right margin.
   */
  public int right;

  /**
   * The top margin.
   */
  public int top;

  /**
   * The bottom margin.
   */
  public int bottom;

  /**
   * Creates a new margins instance with 0 values for all sides.
   */
  public Margins() {

  }

  /**
   * Creates a new margins instance.
   * 
   * @param margin the margin value for all 4 sides.
   */
  public Margins(int margin) {
    this(margin, margin, margin, margin);
  }

  /**
   * Creates a new margin instance.
   * 
   * @param top the top margin
   * @param right the right margin
   * @param bottom the bottom margin
   * @param left the left margin
   */
  public Margins(int top, int right, int bottom, int left) {
    this.top = top;
    this.right = right;
    this.bottom = bottom;
    this.left = left;
  }

}

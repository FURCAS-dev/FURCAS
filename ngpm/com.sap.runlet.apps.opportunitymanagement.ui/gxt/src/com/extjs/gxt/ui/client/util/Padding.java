/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

public class Padding extends Margins {
  /**
   * Creates a new padding instance with 0 values for all sides.
   */
  public Padding() {

  }

  /**
   * Creates a new padding instance.
   * 
   * @param padding the padding value for all 4 sides.
   */
  public Padding(int padding) {
    this(padding, padding, padding, padding);
  }

  /**
   * Creates a new padding instance.
   * 
   * @param top the top padding
   * @param right the right padding
   * @param bottom the bottom padding
   * @param left the left padding
   */
  public Padding(int top, int right, int bottom, int left) {
    this.top = top;
    this.right = right;
    this.bottom = bottom;
    this.left = left;
  }
}

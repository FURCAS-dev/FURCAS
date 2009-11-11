/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

/**
 * Represents a region in the coordinate system.
 */
public class Region {

  /**
   * The left value.
   */
  public int left;

  /**
   * The top value.
   */
  public int top;

  /**
   * The right value.
   */
  public int right;

  /**
   * The bottom value.
   */
  public int bottom;

  public Region() {

  }

  public Region(int top, int right, int bottom, int left) {
    this.left = left;
    this.top = top;
    this.right = right;
    this.bottom = bottom;
  }

}

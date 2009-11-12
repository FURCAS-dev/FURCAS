/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

/**
 * Instances of this class represent places on the (x, y) coordinate plane.
 * 
 * @see Rectangle
 */
public class Point {

  /**
   * The x coordinate of the point
   */
  public int x;

  /**
   * The y coordinate of the point
   */
  public int y;

  /**
   * Constructs a new point with the given x and y coordinates.
   * 
   * @param x the x coordinate of the new point
   * @param y the y coordinate of the new point
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return ("x: " + x + ", y: " + y);
  }

}
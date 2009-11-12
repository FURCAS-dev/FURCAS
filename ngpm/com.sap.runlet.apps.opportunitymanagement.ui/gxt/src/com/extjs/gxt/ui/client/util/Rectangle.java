/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

/**
 * Represents an area in a coordinate system.
 * 
 * @see Point
 */
public class Rectangle {

  /**
   * The x coordinate.
   */
  public int x;

  /**
   * The y coordinate.
   */
  public int y;

  /**
   * The width of the rectangle.
   */
  public int width;

  /**
   * The height of the rectangle.
   */
  public int height;

  /**
   * Create a new rectangle instance.
   */
  public Rectangle() {

  }

  /**
   * Creates a new rectangle instance.
   * 
   * @param x the x value
   * @param y the y value
   * @param width the rectangle's width
   * @param height the rectangle's height
   */
  public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Returns true if the point is within the rectangle's region.
   * 
   * @param x the x coordinate value
   * @param y the y coordinate value
   * @return true if xy is contained within the rectangle
   */
  public boolean contains(int x, int y) {
    return (x >= this.x) && (y >= this.y) && ((x - this.x) < width) && ((y - this.y) < height);
  }

  /**
   * Returns true if the point is within the rectangle.
   * 
   * @param p the point
   * @return true if the point is contained within the rectangle
   */
  public boolean contains(Point p) {
    return contains(p.x, p.y);
  }

  public String toString() {
    return "left: " + x + " top: " + y + " width: " + width + " height: " + height;
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;

import java.util.Arrays;
import java.util.Collection;

/**
 * OFC shape (polygon drawn within a chart)
 */
public class Shape extends ChartConfig {

  /**
   * Shape chart data type.
   */
  public static class Point extends DataConfig {

    /**
     * Creates a new point.
     * 
     * @param x the x
     * @param y the y
     */
    public Point(Number x, Number y) {
      super(x);
      setXY(x,y);
    }

    /**
     * Gets the x.
     * 
     * @return the x
     */
    public Number getX() {
      return (Number)get("x");
    }

    /**
     * Gets the y.
     * 
     * @return the y
     */
    public Number getY() {
      return (Number)get("y");
    }

    /**
     * Sets the x and y
     * 
     * @param x the new x
     * @param y the new y
     */
    public void setXY(Number x, Number y) {
      setX(x);
      setY(y);
    }

    /**
     * Sets the x.
     * 
     * @param x the new x
     */
    public void setX(Number x) {
      set("x", x);
    }

    /**
     * Sets the y.
     * 
     * @param y the new y
     */
    public void setY(Number y) {
      set("y", y);
    }
  }

  /**
   * Creates a new shape.
   */
  public Shape() {
    super("shape");
  }

  /**
   * Adds the point.
   * 
   * @param x the x
   * @param y the y
   */
  public void addPoint(Number x, Number y) {
    addPoints(new Point(x, y));
  }

  /**
   * Adds the points.
   * 
   * @param points the points
   */
  public void addPoints(Collection<Point> points) {
    getValues().addAll(points);
  }

  /**
   * Adds the points.
   * 
   * @param points the points
   */
  public void addPoints(Point... points) {
    getValues().addAll(Arrays.asList(points));
  }

  /**
   * Returns the alpha value.
   * 
   * @return the alpha value
   */
  public Float getAlpha() {
    return (Float) get("alpha");
  }

  /**
   * Returns the colour.
   * 
   * @return the colour
   */
  public String getColour() {
    return (String)get("colour");
  }

  /**
   * Sets the alpha value.
   * 
   * @param alpha the alpha value
   */
  public void setAlpha(Float alpha) {
    set("alpha", alpha);
  }

  /**
   * Sets the colour in HTML hex format (#ffffff).
   * 
   * @param colour the new colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }
}

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

import com.extjs.gxt.charts.client.model.charts.dots.BaseDot;


/**
 * OFC scatter chart
 */
public class ScatterChart extends ChartConfig {

  public static enum ScatterStyle {

    LINE("scatter_line"), POINT("scatter");

    private String style;

    ScatterStyle(String style) {
      this.style = style;
    }
    
    public String getStyle() {
      return style;
    }
  }

  /**
   * Creates a new scatter chart with ScatterStyle.POINT style
   */
  public ScatterChart() {
    this(ScatterStyle.POINT);
  }

  /**
   * Creates a new scatter chart with provided style.
   */
  public ScatterChart(ScatterStyle style) {
    super(style.getStyle());
  }

  /**
   * Adds the point.
   * 
   * @param x the x
   * @param y the y
   */
  public void addPoint(Number x, Number y) {
    BaseDot bd = new BaseDot() {};
    bd.setXY(x, y);
    addPoints(bd);
  }

  /**
   * Adds the points.
   * 
   * @param points the points
   */
  public void addPoints(Collection<BaseDot> points) {
    getValues().addAll(points);
  }

  /**
   * Adds the points.
   * 
   * @param points the points
   */
  public void addPoints(BaseDot... points) {
    getValues().addAll(Arrays.asList(points));
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
   * Returns the dot size.
   * 
   * @return the dot size
   */
  public Integer getDotSize() {
    return (Integer)get("dot-size");
  }

  /**
   * Sets the colour in HTML hex format (#ffffff).
   * 
   * @param colour the new colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }

  /**
   * Sets the dot size.
   * 
   * @param dotSize the new dot size
   */
  public void setDotSize(Integer dotSize) {
    set("dot-size", dotSize);
  }
}

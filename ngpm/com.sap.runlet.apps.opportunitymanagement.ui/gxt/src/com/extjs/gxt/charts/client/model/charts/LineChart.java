/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;

import java.util.Arrays;
import java.util.List;

import com.extjs.gxt.charts.client.model.LineDataProvider;
import com.extjs.gxt.charts.client.model.charts.dots.BaseDot;
import com.extjs.gxt.charts.client.model.charts.dots.Dot;
import com.extjs.gxt.charts.client.model.charts.dots.SolidDot;
import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * OFC line chart
 */
public class LineChart extends ChartConfig {

  public static class LineStyle extends BaseModel {

    /**
     * Line style - dash
     * 
     * @param on the on
     * @param off the off
     */
    public LineStyle(Number on, Number off) {
      set("style", "dash");
      set("on", on);
      set("off", off);
    }
  }

  /**
   * Creates a new line chart with normal style.
   */
  public LineChart() {
    this("line");
  }

  /**
   * Creates a new line chart.
   * 
   * @param type the type
   */
  protected LineChart(String type) {
    super(type);
    setDotStyle(new SolidDot());
  }

  /**
   * Adds the dots.
   * 
   * @param dots the dots
   */
  public void addDots(BaseDot... dots) {
    addDots(Arrays.asList(dots));
  }

  /**
   * Adds the dots.
   * 
   * @param dots the dots
   */
  public void addDots(List<BaseDot> dots) {
    getValues().addAll(dots);
  }

  /**
   * Adds the values.
   * 
   * @param values the values
   */
  public void addValues(List<Number> values) {
    for (Number n : values) {
      getValues().add(new Dot(n));
    }
  }

  /**
   * Adds the values.
   * 
   * @param values the values
   */
  public void addValues(Number... values) {
    addValues(Arrays.asList(values));
  }

  /**
   * Returns the colour.
   * 
   * @return the colour
   */
  public String getColour() {
    return (String) get("colour");
  }

  /**
   * Sets the dot style.
   * 
   * @param dotStyle
   *            the new dot style
   */
  public void setDotStyle(BaseDot dotStyle) {
      set("dot-style", dotStyle);
  }

  /**
   * Sets the line style.
   * 
   * @param lineStyle
   *            the new line style
   */
  public void setLineStyle(LineStyle lineStyle) {
    set("line-style", lineStyle);
  }

  /**
   * Returns the dot style.
   * 
   * @return the dot style
   */
  public BaseDot getDotStyle() {
    return (BaseDot) get("dot-style");
  }

  /**
   * Returns the line style.
   * 
   * @return the line style
   */
  public LineStyle getLineStyle() {
    return (LineStyle) get("line-style");
  }

  /**
   * Returns true if the line chart should use right Y axis
   * 
   * @return true if use of right axis is enabled.
   */
  public boolean isRightAxis() {
    String r = (String) get("axis");
    if (r != null) return r.equals("right");
    return false;
  }

  /**
   * Returns the width.
   * 
   * @return the width
   */
  public Integer getWidth() {
    return (Integer) get("width");
  }

  /**
   * Sets the colour.
   * 
   * @param colour the new colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }

  /**
   * Sets the charts data provider.
   * 
   * @param dataProvider the data provider
   */
  public void setDataProvider(LineDataProvider dataProvider) {
    super.setDataProvider(dataProvider);
  }

  /**
   * Sets the line chart to use the right axis if true, or left if false
   * 
   * @param rightAxis true or false
   */
  public void setRightAxis(boolean rightAxis) {
    if (rightAxis) {
      set("axis", "right");
    } else {
      remove("axis");
    }
  }

  /**
   * Sets the width.
   * 
   * @param width the new width
   */
  public void setWidth(Integer width) {
    set("width", width);
  }
}

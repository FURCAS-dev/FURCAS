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

import com.extjs.gxt.charts.client.model.BarDataProvider;

/**
 * OFC Bar Chart.
 */
public class BarChart extends ChartConfig {

  public static class Bar extends DataConfig {

    /**
     * Creates a new bar.
     * 
     * @param top the top
     */
    public Bar(Number top) {
      this(top, null, null);
    }

    /**
     * Creates a new bar.
     * 
     * @param top the top
     * @param bottom the bottom
     */
    public Bar(Number top, Number bottom) {
      this(top, bottom, null);
    }

    /**
     * Creates a new bar.
     * 
     * @param top the top
     * @param bottom the bottom
     * @param colour the colour
     */
    public Bar(Number top, Number bottom, String colour) {
      super(top);
      setTop(top);
      if (bottom != null) setBottom(bottom);
      if (colour != null) setColour(colour);
    }

    /**
     * Creates a new bar.
     * 
     * @param top the top
     * @param colour the colour
     */
    public Bar(Number top, String colour) {
      this(top, null, colour);
    }

    /**
     * Gets the bottom.
     * 
     * @return the bottom
     */
    public Number getBottom() {
      return (Number) get("bottom");
    }

    /**
     * Gets the colour.
     * 
     * @return the colour
     */
    public String getColour() {
      return (String) get("colour");
    }

    /**
     * Gets the tooltip.
     * 
     * @return the tooltip
     */
    public String getTooltip() {
      return (String) get("tip");
    }

    /**
     * Gets the top.
     * 
     * @return the top
     */
    public Number getTop() {
      return (Number) get("top");
    }

    /**
     * Sets the bottom.
     * 
     * @param bottom the new bottom
     */
    public void setBottom(Number bottom) {
      set("bottom", bottom);
    }

    /**
     * Sets the colour in HTML hex format (#ffffff)
     * 
     * @param colour the new colour
     */
    public void setColour(String colour) {
      set("colour", colour);
    }

    /**
     * Sets the tooltip.
     * 
     * @param tooltip the new tooltip
     */
    public void setTooltip(String tooltip) {
      set("tip", tooltip);
    }

    /**
     * Sets the top.
     * 
     * @param top the new top
     */
    public void setTop(Number top) {
      set("top", top);
    }
  }

  public static enum BarStyle {

    NORMAL("bar"), THREED("bar_3d"), GLASS("bar_glass");

    private String style;

    BarStyle(String style) {
      this.style = style;
    }

    public String getStyle() {
      return style;
    }
  }

  /**
   * Creates a new bar chart with normal style.
   */
  public BarChart() {
    this(BarStyle.NORMAL);
  }

  /**
   * Creates a new bar chart.
   * 
   * @param style the style
   */
  public BarChart(BarStyle style) {
    super(style.getStyle());
  }

  protected BarChart(String style) {
    super(style);
  }

  /**
   * Adds the bars.
   * 
   * @param bars the bars
   */
  public void addBars(Bar... bars) {
    getValues().addAll(Arrays.asList(bars));
  }

  /**
   * Adds the bars.
   * 
   * @param bars the bars
   */
  public void addBars(List<Bar> bars) {
    getValues().addAll(bars);
  }

  /**
   * Adds the values.
   * 
   * @param values the values
   */
  public void addValues(List<Number> values) {
    for (Number n : values) {
      addBars(new Bar(n));
    }
  }

  /**
   * Adds the values.
   * 
   * @param values the values
   */
  public void addValues(Number... values) {
    for (Number n : values) {
      addBars(new Bar(n));
    }
  }

  /**
   * Gets the colour.
   * 
   * @return the colour
   */
  public String getColour() {
    return get("colour");
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
   * Sets the charts data provider.
   * 
   * @param dataProvider the data provider
   */
  public void setDataProvider(BarDataProvider dataProvider) {
    super.setDataProvider(dataProvider);
  }
}

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

/**
 * OFC horizontal bar chart.
 */
public class HorizontalBarChart extends ChartConfig {

  public static class Bar extends DataConfig {

    /**
     * Creates a new bar.
     * 
     * @param right the right
     */
    public Bar(Number right) {
      this(null, right, null);
    }

    /**
     * Creates a new bar.
     * 
     * @param left the left
     * @param right the right
     */
    public Bar(Number left, Number right) {
      this(left, right, null);
    }

    /**
     * Creates a new bar.
     * 
     * @param right the right
     * @param colour the colour
     */
    public Bar(Number right, String colour) {
      this(null, right, colour);
    }

    /**
     * Creates a new bar.
     * 
     * @param left the left
     * @param right the right
     * @param colour the colour
     */
    public Bar(Number left, Number right, String colour) {
      super(right);
      setRight(right);
      if (left != null) setLeft(left);
      if (colour != null) setColour(colour);
    }

    /**
     * Gets the colour.
     * 
     * @return the colour
     */
    public String getColour() {
      return (String)get("colour");
    }

    /**
     * Gets the left.
     * 
     * @return the left
     */
    public Number getLeft() {
      return (Number)get("left");
    }

    /**
     * Gets the right.
     * 
     * @return the right
     */
    public Number getRight() {
      return (Number)get("right");
    }

    /**
     * Gets the tooltip.
     * 
     * @return the tooltip
     */
    public String getTooltip() {
      return (String)get("tip");
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
     * Sets the left.
     * 
     * @param left the new left
     */
    public void setLeft(Number left) {
      set("left", left);
    }

    /**
     * Sets the right.
     * 
     * @param right the new right
     */
    public void setRight(Number right) {
      set("right", right);
    }

    /**
     * Sets the tooltip.
     * 
     * @param tooltip the new tooltip
     */
    public void setTooltip(String tooltip) {
      set("tip", tooltip);
    }
  }

  /**
   * Creates a new horizontal bar chart.
   */
  public HorizontalBarChart() {
    super("hbar");
  }

  /**
   * Adds the bar.
   * 
   * @param left the left
   * @param right the right
   */
  public void addBar(Number left, Number right) {
    addBars(new Bar(left, right));
  }

  /**
   * Adds the bars.
   * 
   * @param values the values
   */
  public void addBars(Bar... values) {
    getValues().addAll(Arrays.asList(values));
  }

  /**
   * Adds the bars.
   * 
   * @param values the values
   */
  public void addBars(List<Bar> values) {
    getValues().addAll(values);
  }

  /**
   * Adds bars with right side values.
   * 
   * @param values the right side values
   */
  public void addValues(List<Number> values) {
    for (Number n : values) {
      addBars(new Bar(n, ""));
    }
  }

  /**
   * Adds bars with right side values.
   * 
   * @param values the right side values
   */
  public void addValues(Number... values) {
    Bar[] v = new Bar[values.length];
    for (int i = 0; i < values.length; ++i) {
      v[i] = new Bar(values[i]);
    }
    addBars(v);
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
   * Sets the colour in HTML hex format (#ffffff)
   * 
   * @param colour the new colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;


/**
 * OFC filled bar chart (outlined) 
 */
public class FilledBarChart extends BarChart {

  /**
   * FilledBarChart data type.
   */
  public static class Bar extends BarChart.Bar {

    /**
     * Creates a new bar.
     * 
     * @param top the top
     */
    public Bar(Number top) {
      super(top);
    }

    /**
     * Creates a new bar.
     * 
     * @param top the top
     * @param bottom the bottom
     */
    public Bar(Number top, Number bottom) {
      super(top, bottom);
    }

    /**
     * Creates a new bar.
     * 
     * @param top the top
     * @param bottom the bottom
     * @param colour the colour
     * @param outlineColour the outline colour
     */
    public Bar(Number top, Number bottom, String colour, String outlineColour) {
      super(top, bottom);
      setColour(colour);
      setOutlineColour(outlineColour);
    }

    /**
     * Gets the outline colour.
     * 
     * @return the outline colour
     */
    public String getOutlineColour() {
      return (String)get("outline-colour");
    }

    /**
     * Sets the outline colour in HTML hex format (#ffffff)
     * 
     * @param outlineColour the new outline colour
     */
    public void setOutlineColour(String outlineColour) {
      set("outline-colour", outlineColour);
    }
  }

  /**
   * Creates a new filled bar chart.
   */
  public FilledBarChart() {
    super("bar_filled");
  }

  /**
   * Creates a new filled bar chart.
   * 
   * @param colour the colour
   * @param outlineColour the outline colour
   */
  public FilledBarChart(String colour, String outlineColour) {
    super("bar_filled");
    setColour(colour);
    setOutlineColour(outlineColour);
  }

  protected FilledBarChart(String style) {
    super(style);
  }

  /**
   * Gets the outline colour.
   * 
   * @return the outline colour
   */
  public String getOutlineColour() {
    return (String)get("outline-colour");
  }

  /**
   * Sets the outline colour in HTML hex format (#ffffff)
   * 
   * @param outlineColour the new outline colour
   */
  public void setOutlineColour(String outlineColour) {
    set("outline-colour", outlineColour);
  }
}

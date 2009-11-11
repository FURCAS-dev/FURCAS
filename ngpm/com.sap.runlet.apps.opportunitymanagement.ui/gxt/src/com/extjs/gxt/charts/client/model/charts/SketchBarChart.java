/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;


/**
 * OFC sketch bar chart (drawn).
 */
public class SketchBarChart extends FilledBarChart {

  /**
   * SketchBar data type.
   */
  public static class SketchBar extends FilledBarChart.Bar {

    /**
     * Creates a new bar.
     * 
     * @param top the top
     */
    public SketchBar(Number top) {
      super(top);
    }

    /**
     * Creates a new bar.
     * 
     * @param top the top
     * @param offset the offset
     */
    public SketchBar(Number top, Integer offset) {
      super(top);
      setOffset(offset);
    }

    /**
     * Creates a new bar.
     * 
     * @param top the top
     * @param bottom the bottom
     * @param offset the offset
     */
    public SketchBar(Number top, Number bottom, Integer offset) {
      super(top, bottom);
      setOffset(offset);
    }

    /**
     * Returns the offset.
     * 
     * @return the offset
     */
    public Integer getOffset() {
      return (Integer)get("offset");
    }

    /**
     * Sets the offset (the fun factor).
     * 
     * @param offset the new offset
     */
    public void setOffset(Integer offset) {
      set("offset",offset);
    }
  }

  /**
   * Creates a new sketch bar chart.
   */
  public SketchBarChart() {
    super("bar_sketch");
  }

  /**
   * Creates a new sketch bar chart.
   * 
   * @param colour the colour
   * @param outlineColour the outline colour
   * @param offset the offset
   */
  public SketchBarChart(String colour, String outlineColour, Integer offset) {
    super("bar_sketch");
    setColour(colour);
    setOutlineColour(outlineColour);
    setOffset(offset);
  }

  /**
   * Gets the offset.
   * 
   * @return the offset
   */
  public Integer getOffset() {
    return (Integer)get("offset");
  }

  /**
   * Sets the offset (the fun factor).
   * 
   * @param offset the new offset
   */
  public void setOffset(Integer offset) {
    set("offset",offset);
  }
}
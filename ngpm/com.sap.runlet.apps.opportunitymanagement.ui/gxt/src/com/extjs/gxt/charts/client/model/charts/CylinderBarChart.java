/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;


/**
 * OFC cylinder bar chart.
 */
public class CylinderBarChart extends BarChart {

  /**
   * CylinderBarChart data type.
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
      set("outline-colour",outlineColour);
    }
  }

  /**
   * Enumeration CylinderStyle - used with CylinderChart.
   */
  public static enum CylinderStyle {
    
    NORMAL("bar_cylinder"), OUTLINE("bar_cylinder_outline"),
    GLASS("bar_round_glass"), ROUND("bar_round"), DOME("bar_dome");

    private String style;

    CylinderStyle(String style) {
      this.style = style;
    }

    public String getStyle() {
      return style;
    }
  }

  /**
   * Creates a new cylinder bar chart with normal style.
   */
  public CylinderBarChart() {
    this(CylinderStyle.NORMAL);
  }

  /**
   * Creates a new cylinder bar chart.
   * 
   * @param style the style
   */
  public CylinderBarChart(CylinderStyle style) {
    super(style.getStyle());
  }

  /**
   * Creates a new cylinder bar chart.
   * 
   * @param colour the colour
   * @param outlineColour the outline colour
   */
  public CylinderBarChart(String colour, String outlineColour) {
    this();
    setColour(colour);
    setOutlineColour(outlineColour);
  }

  /**
   * Gets the alpha.
   * 
   * @return the alpha
   */
  public Float getAlpha() {
    return (Float)get("alpha");
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
   * Sets the alpha.
   * 
   * @param alpha the alpha
   */
  public void setAlpha(Float alpha) {
    set("alpha",alpha);
  }

  /**
   * Sets the outline colour in HTML hex format (#ffffff)
   * 
   * @param outlineColour the new outline colour
   */
  public void setOutlineColour(String outlineColour) {
    set("outline-colour",outlineColour);
  }
}

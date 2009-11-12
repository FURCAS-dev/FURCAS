/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;


/**
 * OFC area chart
 */
public class AreaChart extends LineChart {
  /**
   * Creates a new area chart with AreaStyle.LINE style
   */
  public AreaChart() {
    super("area");
  }
  
  /**
   * Gets the fill alpha.
   * 
   * @return the fill alpha
   */
  public Float getFillAlpha() {
    return (Float) get("fill-alpha");
  }

  /**
   * Gets the fill colour.
   * 
   * @return the fill colour
   */
  public String getFillColour() {
    return (String)get("fill");
  }

  /**
   * Gets the loop value
   * 
   * @return true if loop is enabled
   */
  public Boolean isLoop() {
    return (Boolean)get("loop");
  }

  /**
   * Sets the fill alpha.
   * 
   * @param fillAlpha the new fill alpha
   */
  public void setFillAlpha(Float fillAlpha) {
    set("fill-alpha", fillAlpha);
  }

  /**
   * Sets the fill colour in HTML hex format (#ffffff)
   * 
   * @param colour the new fill colour
   */
  public void setFillColour(String colour) {
    set("fill", colour);
  }

  /**
   * Sets loop
   * 
   * @param loop true or false
   */
  public void setLoop(boolean loop) {
    set("loop", loop);
  }
}

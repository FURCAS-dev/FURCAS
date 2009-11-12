/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;


/**
 * OFC horizontal stacked bar chart
 */
public class HorizontalStackedBarChart extends StackedBarChart {

  /**
   * OFC stack bar chart values
   */
  public static class StackValue extends StackedBarChart.StackValue {

    /**
     * Creates a new stack value.
     * 
     * @param left the value
     * @param right the value
     */
    public StackValue(Number left, Number right) {
      this(left, right, null);
    }

    /**
     * Creates a new stack value.
     * 
     * @param left the value
     * @param right the value
     * @param colour the colour
     */
    public StackValue(Number left, Number right, String colour) {
      this(left, right, colour, null);
    }

    /**
     * Creates a new stack value.
     * 
     * @param left the value
     * @param right the value
     * @param colour the colour
     * @param text the text
     */
    public StackValue(Number left, Number right, String colour, String text) {
      super(left);
      remove("val");
      setLeft(left);
      setRight(right);
      setColour(colour);
      setText(text);
    }

    /**
     * Gets the left value.
     * 
     * @return the value
     */
    public Number getLeft() {
      return (Number)get("left");
    }

    /**
     * Gets the right value.
     * 
     * @return the value
     */
    public Number getRight() {
      return (Number)get("right");
    }

    /**
     * Sets the left value.
     * 
     * @param left the new value
     */
    public void setLeft(Number left) {
      set("left", left);
    }

    /**
     * Sets the right value.
     * 
     * @param right the new value
     */
    public void setRight(Number right) {
      set("right", right);
    }
  }

  /**
   * Creates a new stacked bar chart.
   */
  public HorizontalStackedBarChart() {
    super("hbar_stack");
  }
  
  /**
   * Gets the barwidth.
   * 
   * @return the barwidth
   */
  public Number getBarwidth() {    
    return (Number)get("barwidth");
  }

  /**
   * Sets the barwidth.
   * 
   * @param barwidth the new barwidth
   */
  public void setBarwidth(Number barwidth) {
    set("barwidth", barwidth);
  }
}

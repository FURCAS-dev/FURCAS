/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * OFC stacked bar chart
 */
public class StackedBarChart extends ChartConfig {

  /**
   * Base class for OFC stack bar chart values
   */
  public static class StackValue extends DataConfig {

    /**
     * Creates a new stack value.
     * 
     * @param value the value
     */
    public StackValue(Number value) {
      this(value, null);
    }

    /**
     * Creates a new stack value.
     * 
     * @param value the value
     * @param colour the colour
     */
    public StackValue(Number value, String colour) {
      this(value, colour, null);
    }

    /**
     * Creates a new stack value.
     * 
     * @param value the value
     * @param colour the colour
     * @param text the text
     */
    public StackValue(Number value, String colour, String text) {
      super(value);
      set("val", value);
      if (colour != null) setColour(colour);
      if (text != null) setText(text);
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
     * Gets the text.
     * 
     * @return the text
     */
    public String getText() {
      return (String) get("text");
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
     * Sets the text
     * 
     * @param text the new text
     */
    public void setText(String text) {
      set("text", text);
    }
  }

  /**
   * Creates a new stacked bar chart.
   */
  public StackedBarChart() {
    super("bar_stack");
  }

  protected StackedBarChart(String type) {
    super(type);
  }

  /**
   * Adds the stack.
   * 
   * @param stackvalues a list of stack values
   */
  public void addStack(List<StackValue> stackvalues) {
    ArrayList<StackValue> stack = new ArrayList<StackValue>();
    stack.addAll(stackvalues);
    getStackValues().add(stack);
  }

  /**
   * Adds the stack.
   * 
   * @param stacks the stacks
   */
  public void addStack(StackValue... stacks) {
    addStack(Arrays.asList(stacks));
  }

  /**
   * Returns the values.
   * 
   * @return the values
   */
  public List<ArrayList<StackValue>> getStackValues() {
    List<ArrayList<StackValue>> values = get("values");
    if (values == null) {
      values = new ArrayList<ArrayList<StackValue>>();
      set("values", values);
    }
    return values;
  }
}

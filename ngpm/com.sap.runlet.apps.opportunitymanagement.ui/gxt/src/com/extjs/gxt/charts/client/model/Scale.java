/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

/**
 * Aggregates a  min, max, and interval values.
 */
public class Scale {

  private double min;
  private double max;
  private double interval;
  
  public Scale() {
    
  }
  
  public Scale(double min, double max, double interval) {
    this.min = min;
    this.max = max;
    this.interval = interval;
  }
  
  public double getMin() {
    return min;
  }

  public void setMin(double min) {
    this.min = min;
  }

  public double getMax() {
    return max;
  }

  public void setMax(double max) {
    this.max = max;
  }

  public double getInterval() {
    return interval;
  }

  public void setInterval(double interval) {
    this.interval = interval;
  }

}

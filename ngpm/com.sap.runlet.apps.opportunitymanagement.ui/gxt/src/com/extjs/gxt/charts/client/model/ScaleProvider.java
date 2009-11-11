/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

/**
 * Provides the chart scale given a minimum and maximum value.
 */
public interface ScaleProvider {

  public static ScaleProvider DEFAULT_SCALE_PROVIDER = new ScaleProvider() {
    public Scale calcScale(double min, double max) {
      min = Math.floor(min * (min > 0 ? .9 : 1.1));
      max = Math.round(max * (max > 0 ? 1.1 : .9));
      return new Scale(min, max, Math.max(min > 0 ? min : min * -1, max > 0 ? max : max
          * -1) / 10);
    }
  };

  public static ScaleProvider ROUNDED_NEAREST_SCALE_PROVIDER = new ScaleProvider() {
    public Scale calcScale(double min, double max) {
      Scale scale = DEFAULT_SCALE_PROVIDER.calcScale(min, max);
      scale.setInterval(Math.round(scale.getInterval()));
      return scale;
    }
  };

  /**
   * Returns the scale for the given minimum and maximum value.
   * 
   * @param min the minimum value
   * @param max the maximum value
   * @return the scale
   */
  public Scale calcScale(double min, double max);

}

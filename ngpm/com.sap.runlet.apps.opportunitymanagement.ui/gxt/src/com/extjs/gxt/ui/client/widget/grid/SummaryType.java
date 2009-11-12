/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.Map;

import com.extjs.gxt.ui.client.data.ModelData;

/**
 * Calculates the value of a summary column.
 * 
 * @param <N> the number type
 */
public abstract class SummaryType<N extends Number> {

  public static final SummaryType<Double> SUM = new SummaryType<Double>() {
    @Override
    public Double render(Object v, ModelData m, String field, Map<String, Object> data) {
      if (v == null) {
        v = 0d;
      }
      return ((Double) v) + ((Number) m.get(field)).doubleValue();
    }
  };

  public static final SummaryType<Double> AVG = new SummaryType<Double>() {
    @Override
    public Double render(Object v, ModelData m, String field, Map<String, Object> data) {
      Integer count = (Integer) data.get(field + "count");
      if (count == null) {
        count = new Integer(0);
      }
      int i = count.intValue();
      i++;
      data.put(field + "count", i);

      Double total = (Double) data.get(field + "total");
      if (total == null) total = 0d;
      total += ((Number) m.get(field)).doubleValue();
      data.put(field + "total", total);

      return total == 0 ? 0 : total / i;
    }
  };
  
  public static final SummaryType<Double> MAX = new SummaryType<Double>() {
    @Override
    public Double render(Object v, ModelData m, String field, Map<String, Object> data) {
      Double max = (Double) data.get(field + "max");
      if (max == null) {
        max = new Double(0);
      }
      
      Double current = ((Number) m.get(field)).doubleValue();
      max = Math.max(max, current);
      data.put(field + "max", max);
      return max;
    }
  };
  
  public static final SummaryType<Double> MIN = new SummaryType<Double>() {
    @Override
    public Double render(Object v, ModelData m, String field, Map<String, Object> data) {
      Double min = (Double) data.get(field + "min");
      if (min == null) {
        min = new Double(0);
      }
      Double current = ((Number) m.get(field)).doubleValue();
      min = Math.min(min, current);
      data.put(field + "min", min);
      return min;
    }
  };

  public static final SummaryType<Integer> COUNT = new SummaryType<Integer>() {
    @Override
    public Integer render(Object v, ModelData m, String field, Map<String, Object> data) {
      Integer count = (Integer) data.get(field + "count");
      if (count == null) {
        count = new Integer(0);
      }
      int i = count.intValue();
      i++;
      data.put(field + "count", i);
      return i;
    }
  };

  /**
   * Returns the value for a summary calculation. The render method will be
   * called for each model within the group. Both the v and data parameters are
   * forwarded to each render call.
   * 
   * @param v the current value which was returned from the previous render call
   * @param m the containing model
   * @param field the field name
   * @param data a single instance data object passed to each render call
   * @return the calculated value
   */
  public abstract N render(Object v, ModelData m, String field, Map<String, Object> data);

}

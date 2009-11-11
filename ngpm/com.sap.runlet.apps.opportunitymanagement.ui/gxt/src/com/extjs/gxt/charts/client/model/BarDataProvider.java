/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.charts.BarChart;
import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.charts.client.model.charts.BarChart.Bar;
import com.extjs.gxt.ui.client.data.ModelData;

/**
 * <code>DataProvider</code> implementation for bar charts.
 */
public class BarDataProvider extends PieDataProvider {

  public BarDataProvider(String valueProperty) {
    super(valueProperty);
  }

  public BarDataProvider(String valueProperty, String labelProperty, String textProperty) {
    super(valueProperty, labelProperty, textProperty);
  }

  public BarDataProvider(String valueProperty, String labelProperty) {
    super(valueProperty, labelProperty);
  }

  @Override
  public void populateData(ChartConfig config) {
    BarChart chart = (BarChart) config;
    chart.getValues().clear();

    XAxis xAxis = null;
    if (labelProperty != null) {
      xAxis = chart.getModel().getXAxis();
      if (xAxis == null) {
        xAxis = new XAxis();
        chart.getModel().setXAxis(xAxis);
      }
      xAxis.getLabels().getLabels().clear();
    }

    for (ModelData m : store.getModels()) {
      Object v = m.get(valueProperty);
      Number n = v instanceof String ? Double.parseDouble((String) v) : (Number) v;
      chart.addBars(new Bar(n));      
      minYValue = Math.min(minYValue, n.doubleValue());
      maxYValue = Math.max(maxYValue, n.doubleValue());
      if (xAxis != null) xAxis.addLabels(getLabel(m, valueProperty));
    }
  }
}

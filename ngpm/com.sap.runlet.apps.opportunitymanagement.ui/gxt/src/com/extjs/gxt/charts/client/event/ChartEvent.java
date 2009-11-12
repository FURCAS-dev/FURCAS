/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.event;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.charts.client.model.charts.DataConfig;
import com.extjs.gxt.ui.client.event.BoxComponentEvent;

/**
 * Chart and ChartModel event type.
 */
public class ChartEvent extends BoxComponentEvent {

  private Chart chart;
  private ChartConfig chartConfig;
  private ChartModel chartModel;
  private DataConfig dataType;
  private Number value;

  public ChartEvent(Chart chart) {
    super(chart);
  }

  /**
   * Returns the source chart.
   * 
   * @return the source chart
   */
  public Chart getChart() {
    return chart;
  }

  /**
   * Returns the source chart config.
   * 
   * @return the chart config
   */
  public ChartConfig getChartConfig() {
    return chartConfig;
  }

  /**
   * Returns the source chart model.
   * 
   * @return the chart model
   */
  public ChartModel getChartModel() {
    return chartModel;
  }

  /**
   * Returns the source data type.
   * 
   * @return the source data type
   */
  public DataConfig getDataType() {
    return dataType;
  }

  /**
   * Returns the data value.
   * 
   * @return the value
   */
  public Number getValue() {
    return value;
  }

  /**
   * Sets the source chart.
   * 
   * @param chart the chart
   */
  public void setChart(Chart chart) {
    this.chart = chart;
  }

  /**
   * Sets the source chart config.
   * 
   * @param chartConfig the chart config
   */
  public void setChartConfig(ChartConfig chartConfig) {
    this.chartConfig = chartConfig;
  }

  /**
   * Sets the source chart model.
   * 
   * @param chartModel the source chart model
   */
  public void setChartModel(ChartModel chartModel) {
    this.chartModel = chartModel;
  }

  /**
   * Sets the source data type.
   * 
   * @param dataType the data type
   */
  public void setDataType(DataConfig dataType) {
    this.dataType = dataType;
  }

  /**
   * Sets the source value.
   * 
   * @param value the source value
   */
  public void setValue(Number value) {
    this.value = value;
  }

}

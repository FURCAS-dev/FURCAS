/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.charts.client.model.charts.PieChart;
import com.extjs.gxt.charts.client.model.charts.PieChart.Slice;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelStringProvider;

/**
 * <code>DataProvider</code> implementation for pie charts.
 */
public class PieDataProvider extends DataProvider {

  protected String valueProperty;

  /**
   * Creates a new pie data provider.
   * 
   * @param valueProperty the property name which contains the value
   */
  public PieDataProvider(String valueProperty) {
    this.valueProperty = valueProperty;
  }

  public PieDataProvider(String valueProperty, String labelProperty) {
    this.valueProperty = valueProperty;
    this.labelProperty = labelProperty;
  }

  public PieDataProvider(String valueProperty, String labelProperty, String textProperty) {
    this.valueProperty = valueProperty;
    this.labelProperty = labelProperty;
    this.textProperty = textProperty;
  }

  /**
   * Returns the label property.
   * 
   * @return the label property
   */
  public String getLabelProperty() {
    return labelProperty;
  }

  /**
   * Returns the model label provider.
   * 
   * @return the label provider
   */
  public ModelStringProvider<ModelData> getLabelProvider() {
    return labelProvider;
  }

  /**
   * Returns the model text provider.
   * 
   * @return the model text provider
   */
  public ModelStringProvider<ModelData> getTextProvider() {
    return textProvider;
  }

  /**
   * Returns the value property.
   * 
   * @return the value property
   */
  public String getValueProperty() {
    return valueProperty;
  }

  @Override
  public void populateData(ChartConfig config) {
    PieChart chart = (PieChart) config;
    chart.getValues().clear();

    for (ModelData m : store.getModels()) {
      Object v = m.get(valueProperty);
      Number n = v instanceof String ? Double.parseDouble((String) v) : (Number) v;
      chart.addSlices(new Slice(n, getLabel(m, valueProperty), getText(m, valueProperty)));
    }
  }

  /**
   * Sets the label property. Works when models contains a property with the
   * label value, an alternative is to use a label provider (
   * {@link #setLabelProvider(ModelStringProvider)}.
   * 
   * @param labelProperty the label property
   */
  public void setLabelProperty(String labelProperty) {
    this.labelProperty = labelProperty;
  }

  /**
   * Sets the label provider.
   * 
   * @param labelProvider the label provider
   */
  public void setLabelProvider(ModelStringProvider<ModelData> labelProvider) {
    this.labelProvider = labelProvider;
  }

  public void setTextProvider(ModelStringProvider<ModelData> textProvider) {
    this.textProvider = textProvider;
  }

  public void setValueProperty(String valueProperty) {
    this.valueProperty = valueProperty;
  }

}

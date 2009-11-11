/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.ChartManager;
import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelStringProvider;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;

/**
 * Base class for objects that provide chart data form models in a store.
 */
public abstract class DataProvider {

  protected ChartConfig chartConfig;
  protected String labelProperty, textProperty;
  protected ModelStringProvider<ModelData> labelProvider, textProvider;
  protected ListStore<ModelData> store;
  protected double maxYValue, minYValue;

  private String chartId;
  private StoreListener<ModelData> storeListener;

  /**
   * Creates a new data provider.
   */
  public DataProvider() {
    storeListener = new StoreListener<ModelData>() {
      @Override
      public void handleEvent(StoreEvent<ModelData> e) {
        onStoreChange(e);
      }
    };
  }

  /**
   * Binds the data provider the the given store.
   * 
   * @param store the store
   */
  @SuppressWarnings("unchecked")
  public void bind(ListStore store) {
    if (this.store != null) {
      this.store.removeStoreListener(storeListener);
    }
    this.store = store;
    this.store.addStoreListener(storeListener);
  }

  public abstract void populateData(ChartConfig config);

  protected String getLabel(ModelData model, String valueProperty) {
    String label = null;
    if (labelProperty != null) {
      Object o = model.<Object> get(labelProperty);
      label = o != null ? o.toString() : null;
    } else if (labelProvider != null) {
      label = labelProvider.getStringValue(model, valueProperty);
    }
    return label == null ? "" : label;
  }

  protected double getMaxYValue() {
    return maxYValue;
  }

  protected double getMinYValue() {
    return minYValue;
  }

  protected String getText(ModelData model, String valueProperty) {
    String text = null;
    if (textProperty != null) {
      Object o = model.<Object> get(textProperty);
      text = o != null ? o.toString() : null;
    } else if (textProvider != null) {
      text = textProvider.getStringValue(model, valueProperty);
    }
    return text == null ? "" : text;
  }

  protected void onStoreChange(StoreEvent<ModelData> se) {
    Chart chart = ChartManager.get().getChart(chartId);
    if (chart != null) {
      chart.delayedRefresh(50);
    }
  }
}

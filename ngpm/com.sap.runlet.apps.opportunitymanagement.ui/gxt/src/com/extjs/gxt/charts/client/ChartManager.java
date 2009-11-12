/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client;

import java.util.Collection;
import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;

/**
 * Maintains a list of all attached charts.
 */
public class ChartManager {

  private static ChartManager instance;
  static {
    instance = new ChartManager();
  }

  public static ChartManager get() {
    return instance;
  }

  private Map<String, Chart> charts = new FastMap<Chart>();

  private ChartManager() {
    init();
  }

  public Chart getChart(String id) {
    return charts.get(id);
  }

  public Collection<Chart> getCharts() {
    return charts.values();
  }

  public void registerChart(Chart chart) {
    charts.put(chart.getSwfId(), chart);
  }

  public void unregisterChart(Chart chart) {
    charts.remove(chart.getSwfId());
  }

  @SuppressWarnings("unused")
  private String handleGetData(String id) {
    Chart chart = charts.get(id);
    if (chart != null) {
      return chart.onGetChartData();
    }
    return "";
  }

  @SuppressWarnings("unused")
  private void handleOnClick(String id, int chartIndex, int dataIndex) {
    Chart chart = charts.get(id);
    if (chart != null) {
      chart.onClick(chartIndex, dataIndex);
    }
  }

  @SuppressWarnings("unused")
  private void handleOnReady(String id) {
    Chart chart = charts.get(id);
    if (chart != null) {
      chart.onReady();
    }
  }

  private native void init() /*-{
    var x = this;
    $wnd.ofc_ready = function (id) {
      x.@com.extjs.gxt.charts.client.ChartManager::handleOnReady(Ljava/lang/String;)(id);
    };
    $wnd.open_flash_chart_data = function (id) {
      return x.@com.extjs.gxt.charts.client.ChartManager::handleGetData(Ljava/lang/String;)(id);
    };
    $wnd.ofc_onclick = function (id, config, data) {
      return x.@com.extjs.gxt.charts.client.ChartManager::handleOnClick(Ljava/lang/String;II)(id, config, data);
    };
  }-*/;
}

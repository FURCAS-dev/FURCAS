/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client;

import com.extjs.gxt.charts.client.event.ChartEvent;
import com.extjs.gxt.charts.client.event.ChartListener;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.DataProvider;
import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.charts.client.model.charts.DataConfig;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.flash.FlashComponent;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Element;

/**
 * Chart component that uses the Open Flash Chart flash charting library. See
 * http://teethgrinder.co.uk/open-flash-chart-2.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>Ready</b> : ChartEvent(chart)<br>
 * <div>Fires after the chart is ready.</div>
 * <ul>
 * <li>chart : this</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ChartClick</b> : ChartEvent(chart, chartModel, chartConfig,
 * dataConfig, value)<br>
 * <div>Fires after a data point is clicked.</div>
 * <ul>
 * <li>chart : this</li>
 * <li>chartModel : the chart model</li>
 * <li>dataConfig : the source data config</li>
 * <li>value : the value</li>
 * </ul>
 * </dd>
 */
public class Chart extends FlashComponent {

  /**
   * ChartClick event type.
   */
  public static final EventType ChartClick = new EventType();

  private String jsonData;
  private boolean loaded = false;
  private ChartModel model;
  private DelayedTask refreshTask;

  /**
   * Creates a new chart using the given url.
   * 
   * @param url the url
   */
  public Chart(String url) {
    super(url);
  }

  /**
   * Adds a chart listener. This listener will only receive events from the
   * chart model and / or all chart configs that have been enabled for events.
   * <p/>
   * <b>Note:</b> Only adding a listener to a chart (with no listeners enabled
   * on the chart model or chart config) will result in no chart events being
   * fired.
   * 
   * @param listener the listener
   */
  public void addChartListener(ChartListener listener) {
    addListener(ChartClick, listener);
  }

  /**
   * Returns the chart model.
   * 
   * @return the chart model
   */
  public ChartModel getChartModel() {
    return model;
  }

  /**
   * Returns the OFC API JSON data that the chart is using.
   * <p/>
   * <b>Note: </b>JSON string can be either set directly via
   * {@link #setJsonData(String)}, or constructed dynamically via
   * {@link #setChartModel(ChartModel)}.
   * 
   * @return the json data
   */
  public String getJsonData() {
    return jsonData;
  }

  /**
   * Returns the true is the chart has loaded correctly and is ready for
   * configuration/updates
   * 
   * @return true if the chart has loaded
   */
  public boolean isLoaded() {
    return loaded;
  }

  /**
   * Refreshes the chart using the current model data using a delay.
   * 
   * @param delay the delay in ms
   */
  public void delayedRefresh(int delay) {
    if (refreshTask == null) {
      refreshTask = new DelayedTask(new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
          refresh();
        }
      });
    }
    refreshTask.delay(delay);
  }

  /**
   * Refreshes the chart using the current model data.
   */
  public void refresh() {
    if (model != null) {
      setChartModel(model);
    } else if (jsonData != null) {
      setJsonData(jsonData);
    }
  }

  /**
   * Removes the chart listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeChartListener(ChartListener listener) {
    removeListener(ChartClick, listener);
  }

  /**
   * Sets the chart model.
   * 
   * @param model the model
   */
  public void setChartModel(ChartModel model) {
    this.model = model;
    for (ChartConfig config : model.getChartConfigs()) {
      DataProvider provider = config.getDataProvider();
      if (provider != null) {
        setChartId(provider, getSwfId());
      }
    }
    processModel(model);
  }

  /**
   * Sets the chart data directly without using a chart model.
   * 
   * @param jsonData the JSON OFC API data
   */
  public void setJsonData(String jsonData) {
    this.jsonData = jsonData;
    if (loaded) updateData(swfElement, jsonData);
  }

  protected void onClick(int configIndex, int dataIndex) {
    ChartConfig config = model.getChartConfigs().get(configIndex);
    DataConfig data = config.getValues().get(dataIndex);

    ChartEvent event = new ChartEvent(this);
    event.setChartModel(config.getModel());
    event.setChartConfig(config);
    event.setDataType(data);
    event.setValue(data.getValue());
    event.setType(ChartClick);

    for (ChartListener l : config.getChartListeners()) {
      l.handleEvent(event);
    }
    fireEvent(ChartClick, event);
  }

  @Override
  protected void onAttach() {
    ChartManager.get().registerChart(this);
    super.onAttach();
  }

  @Override
  protected void onDetach() {
    ChartManager.get().unregisterChart(this);
    super.onDetach();
  }

  @Override
  protected void afterRender() {
    super.afterRender();
  }

  protected String onGetChartData() {
    return jsonData;
  }

  protected void onReady() {
    loaded = true;
    if (jsonData != null) {
      setJsonData(jsonData);
    }
    fireEvent(Events.Ready, new ChartEvent(this));
  }

  protected void processModel(ChartModel model) {

    boolean global = model.isEnableEvents();
    for (int i = 0; i < model.getChartConfigs().size(); i++) {
      ChartConfig config = model.getChartConfigs().get(i);
      DataProvider provider = config.getDataProvider();
      if (provider != null) {
        provider.populateData(config);
      }
      if (global || config.isEnableEvents()) {
        for (int j = 0; j < config.getValues().size(); j++) {
          DataConfig data = config.getValues().get(j);
          data.set("on-click", "ofc_onclick('" + getSwfId() + "'," + i + "," + j + ")");
        }
      }
    }
    model.updateYScale();

    JavaScriptObject jso = Util.getJsObject(model, 8);
    JSONObject json = new JSONObject(jso);
    setJsonData(json.toString());
  }

  private native void updateData(Element e, String json) /*-{
    if ('load' in e) e.load(json);
  }-*/;

  private native void setChartId(DataProvider provider, String id) /*-{
    provider.@com.extjs.gxt.charts.client.model.DataProvider::chartId = id;
  }-*/;
}

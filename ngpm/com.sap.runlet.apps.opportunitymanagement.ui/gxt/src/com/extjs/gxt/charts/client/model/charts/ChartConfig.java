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

import com.extjs.gxt.charts.client.event.ChartListener;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.DataProvider;
import com.extjs.gxt.charts.client.model.axis.Keys;
import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * Base abstract class for OFC charts.
 */
public abstract class ChartConfig extends BaseModel {

  protected ChartModel model;
  protected DataProvider dataProvider;
  private boolean enableEvents;
  private List<ChartListener> listeners;

  /**
   * Creates a new element.
   * 
   * @param type the type
   */
  protected ChartConfig(String type) {
    set("type", type);
    setAnimateOnShow(false);
  }

  public void setAnimateOnShow(boolean animateOnShow) {
    if (animateOnShow) {
      remove("on-show");
    } else {
      BaseModel bm = new BaseModel();
      bm.set("type", "");
      set("on-show", bm);
    }
  }

  /**
   * Adds a chart listener.
   * 
   * @param listener the listener
   */
  public void addChartListener(ChartListener listener) {
    enableEvents = true;
    if (listeners == null) {
      listeners = new ArrayList<ChartListener>();
    }
    listeners.add(listener);
  }

  /**
   * Adds a null value (skip this value).
   * 
   */
  public void addNullValue() {
    getValues().add(null);
  }

  /**
   * Returns the configs chart listeners.
   * 
   * @return the chart listeners
   */
  public List<ChartListener> getChartListeners() {
    if (listeners == null) {
      listeners = new ArrayList<ChartListener>();
    }
    return listeners;
  }

  /**
   * Returns the chart's data provider.
   * 
   * @return the data provider
   */
  public DataProvider getDataProvider() {
    return dataProvider;
  }

  /**
   * Returns the font size.
   * 
   * @return the font size
   */
  public Integer getFontSize() {
    return (Integer) get("font-size");
  }

  /**
   * Returns the chart's model.
   * 
   * @return the model
   */
  public ChartModel getModel() {
    return model;
  }

  /**
   * Returns the text.
   * 
   * @return the text
   */
  public String getText() {
    return (String) get("text");
  }

  /**
   * Returns the tooltip.
   * 
   * @return the tooltip
   */
  public String getTooltip() {
    return (String) get("tip");
  }

  /**
   * Returns the type.
   * 
   * @return the type
   */
  public String getType() {
    return (String) get("type");
  }

  /**
   * Returns the values.
   * 
   * @return the values
   */
  public List<DataConfig> getValues() {
    List<DataConfig> values = get("values");
    if (values == null) {
      values = new ArrayList<DataConfig>();
      set("values", values);
    }
    return values;
  }

  /**
   * Returns whether click events are enabled.
   * 
   * @return true if click events are enabled
   */
  public boolean isEnableEvents() {
    return enableEvents;
  }

  /**
   * Removes the chart listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeChartListener(ChartListener listener) {
    if (listeners != null) {
      listeners.remove(listener);
    }
  }

  /**
   * True to enable click events for the chart config (defaults to false).
   * 
   * @param enableEvents true to enable click events
   */
  public void setEnableEvents(boolean enableEvents) {
    this.enableEvents = enableEvents;
  }

  /**
   * Sets the font size.
   * 
   * @param fontSize the font size
   */
  public void setFontSize(Integer fontSize) {
    set("font-size", fontSize);
  }

  /**
   * Sets the stack keys.
   * 
   * @param keys the keys
   */
  public void setKeys(Keys... keys) {
    setKeys(Arrays.asList(keys));
  }

  /**
   * Sets the stack keys.
   * 
   * @param keys the keys
   */
  public void setKeys(List<Keys> keys) {
    set("keys", keys);
  }

  /**
   * Sets the chart's model.
   * 
   * @param model the model
   */
  public void setModel(ChartModel model) {
    this.model = model;
  }

  /**
   * Sets the text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    set("text", text);
  }

  /**
   * Sets the tooltip text (#val# is the default)
   * 
   * @param tooltip the tooltip
   */
  public void setTooltip(String tooltip) {
    set("tip", tooltip);
  }

  /**
   * Sets the values.
   * 
   * @param values the values
   */
  public void setValues(List<DataConfig> values) {
    set("values", values);
  }

  protected void setDataProvider(DataProvider dataProvider) {
    this.dataProvider = dataProvider;
  }

}

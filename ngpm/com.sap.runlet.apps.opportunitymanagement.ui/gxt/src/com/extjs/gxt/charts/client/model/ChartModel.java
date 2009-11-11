/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.axis.RadarAxis;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * This is the OFC chart model.
 * <p/>
 * Use this model to configure chart title, axes, legends, labels, and draw-able
 * elements in your chart. You add an chart type to the chart model, for
 * example...</br>
 * 
 * <pre>
 * ChartModel cm = new ChartModel(&quot;Sales by Region&quot;);
 * PieChart pie = new PieChart();
 * pie.addValues(10, 30, 40, 20);
 * cm.addChartConfig(pie);
 * </pre>
 * 
 * @see Chart#setChartModel(ChartModel)
 */
public class ChartModel extends BaseModel {

  private boolean enableEvents;
  private ScaleProvider scaleProvider;

  /**
   * Creates a new chart model instance.
   */
  public ChartModel() {
    // nothing...
  }

  /**
   * Creates a new chart model instance with the given title.
   * 
   * @param titleText the chart title
   */
  public ChartModel(String titleText) {
    this(titleText, null);
  }

  /**
   * Creates a new chart model instance with the given title and style.
   * 
   * @param titleText the chart title
   * @param style the chart style (ex. 'font-size: 14px; text-align: center')
   */
  public ChartModel(String titleText, String style) {
    setTitle(new Text(titleText, style));
  }

  /**
   * Adds a chart config to the list of configs.
   * 
   * @param config the chart configs
   */
  public void addChartConfig(ChartConfig... config) {
    Collection<ChartConfig> elements = checkElements();
    elements.addAll(Arrays.asList(config));
    for (ChartConfig cc : config) {
      cc.setModel(this);
    }
  }

  /**
   * Adds a collection of chart configs.
   * 
   * @param collection the collection of chart configs
   */
  public void addChartConfig(Collection<ChartConfig> collection) {
    Collection<ChartConfig> configs = checkElements();
    configs.addAll(collection);
    for (ChartConfig cc : collection) {
      cc.setModel(this);
    }
  }

  /**
   * Returns the current background colour
   * 
   * @return the background colour
   */
  public String getBackgroundColour() {
    return (String) get("bg_colour");
  }

  /**
   * Returns the chart configs.
   * 
   * @return the chart configs
   */
  public List<ChartConfig> getChartConfigs() {
    return checkElements();
  }

  /**
   * Returns the chart legend.
   * 
   * @return the legend
   */
  public Legend getLegend() {
    return (Legend) get("legend");
  }

  /**
   * Returns the number of decimals.
   * 
   * @return the number of decimals
   */
  public Integer getNumDecimals() {
    return (Integer) get("num_decimals");
  }

  /**
   * Returns the current radar axis.
   * 
   * @return the radar axis
   */
  public RadarAxis getRadarAxis() {
    return (RadarAxis) get("radar_axis");
  }

  /**
   * Returns the scale provider.
   * 
   * @return the scale provider
   */
  public ScaleProvider getScaleProvider() {
    return scaleProvider;
  }

  /**
   * Returns the current title.
   * 
   * @return the title
   */
  public Text getTitle() {
    return (Text) get("title");
  }

  /**
   * Returns the tooltip style.
   * 
   * @return the tooltip
   */
  public ToolTip getTooltipStyle() {
    return (ToolTip) get("tooltip");
  }

  /**
   * Returns the x-axis.
   * 
   * @return the x-axis
   */
  public XAxis getXAxis() {
    return (XAxis) get("x_axis");
  }

  /**
   * Get the current x-legend Text
   * 
   * @return the x-legend
   */
  public Text getXLegend() {
    return get("x_legend");
  }

  /**
   * Returns the current y-axis (left side).
   * 
   * @return the y-axis
   */
  public YAxis getYAxis() {
    return get("y_axis");
  }

  /**
   * Return the current y-axis (right side).
   * 
   * @return the y-axis
   */
  public YAxis getYAxisRight() {
    return get("y_axis_right");
  }

  /**
   * Returns the y-legend.
   * 
   * @return the y-legend
   */
  public Text getYLegend() {
    return (Text) get("y_legend");
  }

  /**
   * Returns the right y-legend.
   * 
   * @return the right y-legend
   */
  public Text getYRightLegend() {
    return (Text) get("y2_legend");
  }

  /**
   * Returns true if a decimal separator comma is enabled.
   * 
   * @return the decimal separator state
   */
  public Boolean isDecimalSeparatorComma() {
    return this.<String> get("is_decimal_separator_comma").equals("1");
  }

  /**
   * Returns true if click events are enabled.
   * 
   * @return true if click events are enabled
   */
  public boolean isEnableEvents() {
    return enableEvents;
  }

  /**
   * Returns true if fixed number of decimals is enabled.
   * 
   * @return true if fixed
   */
  public Boolean isFixedNumDecimalsForced() {
    return this.<String> get("is_fixed_num_decimals_forced").equals("1");
  }

  /**
   * Returns true if the thousands separator is enabled.
   * 
   * @return the thousands separator state
   */
  public Boolean isThousandSeparatorDisabled() {
    return this.<String> get("is_thousand_separator_disabled").equals("1");
  }

  /**
   * Removes a chart config from the list of configs.
   * 
   * @param chartConfig the chart config
   * @return true if an element was removed
   */
  public boolean removeChartConfig(ChartConfig chartConfig) {
    Collection<ChartConfig> elements = checkElements();
    return elements.remove(chartConfig);
  }

  /**
   * Sets the chart background colour in HTML hex format (#ffffff). Set to "-1"
   * to set transparent.
   * 
   * @param backgroudColor the background color
   */
  public void setBackgroundColour(String backgroudColor) {
    set("bg_colour", backgroudColor);
  }

  /**
   * Clears and then sets the list of chart configs.
   * 
   * @param collection the chart configs
   */
  public void setChartConfigs(Collection<ChartConfig> collection) {
    Collection<ChartConfig> configs = checkElements();
    configs.clear();
    addChartConfig(collection);
  }

  /**
   * True to use a decimal separator comma.
   * 
   * @param useComma true to enable the separator comma
   */
  public void setDecimalSeparatorComma(boolean useComma) {
    set("is_decimal_separator_comma", useComma ? "1" : "0");
  }

  /**
   * True to globally enable click events (defaults to false). Alternatively,
   * {@link ChartConfig#setEnableEvents(boolean)} can be used to enable click
   * events at the individual chart level.
   * 
   * @param enableEvents true to enable click event
   */
  public void setEnableEvents(boolean enableEvents) {
    this.enableEvents = enableEvents;
  }

  /**
   * True to force fixed number of decimals.
   * 
   * @param fixed true to force fixed number of decimals
   */
  public void setFixedNumDecimalsForced(boolean fixed) {
    set("is_fixed_num_decimals_forced", fixed ? "1" : "0");
  }

  /**
   * Sets the chart legend
   * 
   * @param legend the legend
   */
  public void setLegend(Legend legend) {
    set("legend", legend);
  }

  /**
   * Sets the number of decimals.
   * 
   * @param numDecimals the number of decimals
   */
  public void setNumDecimals(Integer numDecimals) {
    set("num_decimals", numDecimals);
  }

  /**
   * Sets the radar axis.
   * 
   * @param radarAxis the radar axis
   */
  public void setRadarAxis(RadarAxis radarAxis) {
    set("radar_axis", radarAxis);
  }

  /**
   * Optionally, sets the scale provider used to manage the min, max, and
   * interval of the y-axis.
   * 
   * @param scaleProvider the scale provider
   */
  public void setScaleProvider(ScaleProvider scaleProvider) {
    this.scaleProvider = scaleProvider;
  }

  /**
   * Sets whether the thousand separator is disabled.
   * 
   * @param disabled true for disabled
   */
  public void setThousandSeparatorDisabled(boolean disabled) {
    set("is_thousand_separator_disabled", disabled ? "1" : "0");
  }

  /**
   * Sets the title.
   * 
   * @param title title
   */
  public void setTitle(Text title) {
    set("title", title);
  }

  /**
   * Sets the tooltip style.
   * 
   * @param tooltip the new tooltip
   */
  public void setTooltipStyle(ToolTip tooltip) {
    set("tooltip", tooltip);
  }

  /**
   * Sets the x-axis.
   * 
   * @param xAxis the x-axis
   */
  public void setXAxis(XAxis xAxis) {
    set("x_axis", xAxis);
  }

  /**
   * Sets the x-legend.
   * 
   * @param xLegend the x-legend
   */
  public void setXLegend(Text xLegend) {
    set("x_legend", xLegend);
  }

  /**
   * Sets the left y-axis.
   * 
   * @param yAxis the y-axis
   */
  public void setYAxis(YAxis yAxis) {
    set("y_axis", yAxis);
  }

  /**
   * Sets the y-axis label style.
   * 
   * @param size the size
   * @param colour the label colour
   */
  public void setYAxisLabelStyle(Integer size, String colour) {
    set("y_label__label_style", createLabelStyle(size, colour));
  }

  /**
   * Sets the right y-axis.
   * 
   * @param yAxis the right y-axis
   */
  public void setYAxisRight(YAxis yAxis) {
    set("y_axis_right", yAxis);
  }

  /**
   * Sets the right y-axis label style.
   * 
   * @param size the size
   * @param colour the label colour
   */
  public void setYAxisRightLabelStyle(Integer size, String colour) {
    set("y_label_2__label_style", createLabelStyle(size, colour));
  }

  /**
   * Sets the y-legend.
   * 
   * @param yLegend the y-legend
   */
  public void setYLegend(Text yLegend) {
    set("y_legend", yLegend);
  }

  /**
   * Sets the right y-legend.
   * 
   * @param yLegend the right yLegend
   */
  public void setYRightLegend(Text yLegend) {
    set("y2_legend", yLegend);
  }

  public void updateYScale() {
    if (scaleProvider != null) {
  
      double max = 0;
      double min = 0;
      for (ChartConfig config : getChartConfigs()) {
        DataProvider provider = config.getDataProvider();
        if (provider != null) {
          max = Math.max(max, provider.getMaxYValue());
          min = Math.min(min, provider.getMinYValue());
        }
        provider.maxYValue = 0;
        provider.minYValue = 0;
      }
  
      Scale scale = scaleProvider.calcScale(min, max);
      YAxis yAxis = getYAxis();
      if (yAxis == null) {
        yAxis = new YAxis();
        setYAxis(yAxis);
      }
      yAxis.setMin(scale.getMin());
      yAxis.setMax(scale.getMax());
      yAxis.setSteps(scale.getInterval());
    }
  }

  private List<ChartConfig> checkElements() {
    List<ChartConfig> elements = get("elements");
    if (elements == null) {
      elements = new ArrayList<ChartConfig>();
      set("elements", elements);
    }
    return elements;
  }

  private String createLabelStyle(Integer size, String colour) {
    String label_style = size.toString();
    if (colour != null && colour.length() > 0) label_style += "," + colour;
    return label_style;
  }
}

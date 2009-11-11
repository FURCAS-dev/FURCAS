/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.Widget;

/**
 * Defines the configuration information for an aggregation row. The values for
 * each column can be configured and calculated in several ways. The following
 * methods are supported in order of precedence.
 * 
 * <ol>
 * <li>A static HTML string can be specified.</li>
 * <li>A widget can be specified.</li>
 * <li>A <code>SummaryType</code> can be used to "calculate" a value based on
 * the data. When using a summary type, <b>EITHER</b> a
 * <code>NumberFormat</code> or a <code>AggregationRenderer</code> can be used
 * to "format" the value.
 * </ol>
 * 
 * <p />
 * In some cases, the values will not be calculated by the data stored in the
 * store, for example, with paging. In this situation, there are 2 ways to
 * provide values.
 * 
 * <p />
 * The first method is to specify a <code>AggregationRenderer</code> for the
 * relevant columns. This renderer can any data as needed. The second method is
 * to provide a GXT <code>Model</code> that contains the values for the
 * aggregation row. In this case, the value will be retrieved from the model
 * using the property name associated with the column. With this method, you are
 * responsible for ensuring the model is updated any time the aggregation values
 * are updated.
 * 
 * @param <M> the model type
 */
public class AggregationRowConfig<M extends ModelData> {

  private Map<String, AggregationRenderer<M>> renderers;
  private Map<String, SummaryType<?>> types;
  private Map<String, NumberFormat> formats;
  private Map<String, Widget> widgets;
  private Map<String, String> texts;
  private ModelData model;

  /**
   * Creates a new aggregation row config.s
   */
  public AggregationRowConfig() {
    renderers = new HashMap<String, AggregationRenderer<M>>();
    types = new HashMap<String, SummaryType<?>>();
    formats = new HashMap<String, NumberFormat>();
    texts = new HashMap<String, String>();
    widgets = new HashMap<String, Widget>();
  }

  /**
   * Returns the html for the given column.
   * 
   * @param id the column id
   * @return the column
   */
  public String getHtml(String id) {
    return texts.get(id);
  }

  /**
   * Returns the model.
   * 
   * @return the model
   */
  public ModelData getModel() {
    return model;
  }

  /**
   * Returns the aggregation renderer for the given column.
   * 
   * @param id the column id
   * @return the aggregation renderer
   */
  public AggregationRenderer<M> getRenderer(String id) {
    return renderers.get(id);
  }

  /**
   * Returns the summary format for the given column.
   * 
   * @param id the column id
   * @return the summary format
   */
  public NumberFormat getSummaryFormat(String id) {
    return formats.get(id);
  }

  /**
   * Returns the summary type for the given column.
   * 
   * @param id the column id
   * @return the summary type
   */
  public SummaryType<?> getSummaryType(String id) {
    return types.get(id);
  }

  /**
   * Returns the widget for the given column.
   * 
   * @param id the column id
   * @return the widget
   */
  public Widget getWidget(String id) {
    return widgets.get(id);
  }

  /**
   * Sets the static HTML for the given column.
   * 
   * @param id the column id
   * @param html the html
   */
  public void setHtml(String id, String html) {
    texts.put(id, html);
  }

  /**
   * Sets the model that contains the values for the aggregation row. It is
   * expected, the model contains a value for the properties which match the
   * column configuration data index. If the value is a Number, the number
   * format and renderer will be used if specified. toString will be called on
   * any other type.
   * 
   * @param model the model
   */
  public void setModel(ModelData model) {
    this.model = model;
  }

  /**
   * Sets the aggregation renderer for the given column.
   * 
   * @param id the column id
   * @param renderer the renderer
   */
  public void setRenderer(String id, AggregationRenderer<M> renderer) {
    renderers.put(id, renderer);
  }

  /**
   * Sets the number format for the given column. Only applies when specifying a
   * <code>SummaryType</code>.
   * 
   * @param id the column id
   * @param format the number format
   */
  public void setSummaryFormat(String id, NumberFormat format) {
    formats.put(id, format);
  }

  /**
   * Sets the summary type for the given column.
   * 
   * @param id the column id
   * @param type the summary type
   */
  public void setSummaryType(String id, SummaryType<?> type) {
    types.put(id, type);
  }

  /**
   * Sets the widget for the given column.
   * 
   * @param id the column id
   * @param widget the widget
   */
  public void setWidget(String id, Widget widget) {
    widgets.put(id, widget);
  }

}

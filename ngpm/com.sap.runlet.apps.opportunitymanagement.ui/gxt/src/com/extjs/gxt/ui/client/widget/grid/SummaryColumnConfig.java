/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import com.google.gwt.i18n.client.NumberFormat;

/**
 * A <code>ColumnConfig</code> which aggregates a <code>SummaryType</code>,
 * <code>SummaryRenderer</code>. The summary type is used to render the cells
 * value. The summary renderer is used to render the summary row.
 * 
 * @param <N> the summary type number type
 */
public class SummaryColumnConfig<N extends Number> extends ColumnConfig {

  private SummaryType<N> summaryType;
  private SummaryRenderer summaryRenderer;
  private NumberFormat summaryFormat;

  /**
   * Creates a new summary column config.
   */
  public SummaryColumnConfig() {
    super();
  }

  /**
   * Creates a new summary column config.
   * 
   * @param id the column id
   * @param name the column name
   * @param width the column width
   */
  public SummaryColumnConfig(String id, String name, int width) {
    super(id, name, width);
  }

  /**
   * Returns the summary format.
   * 
   * @return the summary format
   */
  public NumberFormat getSummaryFormat() {
    return summaryFormat;
  }

  /**
   * Returns the summary renderer used to render the summary row.
   * 
   * @return the summary renderer
   */
  public SummaryRenderer getSummaryRenderer() {
    return summaryRenderer;
  }

  /**
   * Returns the summary type used for each rows summary calculation.
   * 
   * @return the summary type
   */
  public SummaryType<N> getSummaryType() {
    return summaryType;
  }

  /**
   * Sets the summary format.
   * 
   * @param summaryFormat the summary format
   */
  public void setSummaryFormat(NumberFormat summaryFormat) {
    this.summaryFormat = summaryFormat;
  }

  /**
   * Sets the summary renderer.
   * 
   * @param summaryRenderer the summary renderer
   */
  public void setSummaryRenderer(SummaryRenderer summaryRenderer) {
    this.summaryRenderer = summaryRenderer;
  }

  /**
   * Sets the summary type.
   * 
   * @param summaryType the summary type
   */
  public void setSummaryType(SummaryType<N> summaryType) {
    this.summaryType = summaryType;
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * Base class for chart data values.
 */
public abstract class DataConfig extends BaseModel {

  private Number value;

  /**
   * Creates a new data config.
   * 
   * @param value the value
   */
  public DataConfig(Number value) {
    setValue(value);
  }

  /**
   * Returns the value.
   * 
   * @return the value
   */
  public Number getValue() {
    return value;
  }

  /**
   * Sets the value.
   * 
   * @param value the value
   */
  public void setValue(Number value) {
    this.value = value;
  }

  protected Number getFirstValue() {
    return null;
  }

  protected Number getSecondValue() {
    return null;
  }

}

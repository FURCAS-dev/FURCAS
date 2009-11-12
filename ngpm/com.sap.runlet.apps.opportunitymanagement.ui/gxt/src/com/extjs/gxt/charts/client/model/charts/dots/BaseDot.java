/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts.dots;

import com.extjs.gxt.charts.client.model.charts.DataConfig;

/**
 * OFC line dots
 */
public abstract class BaseDot extends DataConfig {

  protected BaseDot() {
    super(null);
    set("type", null);
  }
  /**
   * Creates a new dot.
   * 
   * @param type the type
   * @param value the value
   */
  public BaseDot(String type, Number value) {
    super(value);
    set("type", type);
  }

  /**
   * Gets the colour.
   * 
   * @return the colour
   */
  public String getColour() {
    return (String) get("colour");
  }

  /**
   * Gets the size.
   * 
   * @return the size
   */
  public Integer getSize() {
    return (Integer) get("dot-size");
  }

  /**
   * Gets the halo size.
   * 
   * @return the halo size
   */
  public Integer getHaloSize() {
    return (Integer) get("halo-size");
  }

  /**
   * Gets the tooltip.
   * 
   * @return the tooltip
   */
  public String getTooltip() {
    return (String) get("tip");
  }

  /**
   * Gets the value.
   * 
   * @return the value
   */
  public Number getValue() {
    return (Number) get("value");
  }

  /**
   * Gets the x.
   * 
   * @return the x
   */
  public Number getX() {
    return (Number) get("x");
  }

  /**
   * Gets the y.
   * 
   * @return the y
   */
  public Number getY() {
    return (Number) get("y");
  }

  /**
   * Sets the colour in HTML hex format (#ffffff)
   * 
   * @param colour the colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }

  /**
   * Sets the size.
   * 
   * @param size the size
   */
  public void setSize(Integer size) {
    set("dot-size", size);
  }

  /**
   * Sets the halo size.
   * 
   * @param haloSize the halo size
   */
  public void setHaloSize(Integer haloSize) {
    set("halo-size", haloSize);
  }

  /**
   * Sets the tooltip.
   * 
   * @param tooltip the new tooltip
   */
  public void setTooltip(String tooltip) {
    set("tip", tooltip);
  }

  /**
   * Sets the value.
   * 
   * @param value the value
   */
  public void setValue(Number value) {
    set("value", value);
  }

  /**
   * Sets the x.
   * 
   * @param x the new x
   * @param y the new y
   */
  public void setXY(Number x, Number y) {
    set("y", x);
    set("x", y);
  }
}
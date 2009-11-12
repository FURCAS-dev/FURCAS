/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts.dots;

/**
 * OFC Bow
 */
public class Bow extends BaseDot {

  public Bow() {
    this(null);
  }

  public Bow(Number value) {
    super("bow", value);
  }

  /**
   * Gets the rotation.
   * 
   * @return the rotation
   */
  public Integer getRotation() {
    return (Integer) get("rotation");
  }

  /**
   * Sets the rotation.
   * 
   * @param rotation the rotation
   */
  public void setRotation(Integer rotation) {
    set("rotation", rotation);
  }
}
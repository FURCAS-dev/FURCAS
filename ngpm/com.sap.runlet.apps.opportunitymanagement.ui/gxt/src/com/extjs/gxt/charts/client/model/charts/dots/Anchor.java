/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts.dots;

/**
 * OFC Anchor
 */
public class Anchor extends BaseDot {

  public Anchor() {
    this(null);
  }

  public Anchor(Number value) {
    super("anchor", value);
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

  /**
   * Gets the sides.
   * 
   * @return the sides
   */
  public Integer getSides() {
    return (Integer) get("sides");
  }

  /**
   * Sets the sides.
   * 
   * @param sides the sides
   */
  public void setSides(Integer sides) {
    set("sides", sides);
  }
}
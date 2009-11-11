/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.charts.dots;


/**
 * OFC Star
 */
public class Star extends BaseDot {

  public Star() {
    this(null);
  }

  public Star(Number value) {
    super("star", value);
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
   * @return true if hollow
   */
  public boolean isHollow() {
    return (Boolean)get("hollow");
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
   * Sets the hollow.
   * 
   * @param hollow the hollow
   */
  public void setHollow(Boolean hollow) {
    set("hollow", new Boolean(hollow));
  }
}
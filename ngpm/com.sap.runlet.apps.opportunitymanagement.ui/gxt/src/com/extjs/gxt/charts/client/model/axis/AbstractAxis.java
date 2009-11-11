/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model.axis;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * Base abstract class for an OFC axis
 */
public abstract class AbstractAxis extends BaseModel {

  /**
   * Returns the colour.
   * 
   * @return the colour
   */
  public String getColour() {
    return (String)get("colour");
  }

  /**
   * Returns the grid colour.
   * 
   * @return the grid colour
   */
  public String getGridColour() {
    return (String)get("grid-colour");
  }

  /**
   * Returns the max.
   * 
   * @return the max
   */
  public Number getMax() {
    return (Number)get("max");
  }

  /**
   * Returns the minimum.
   * 
   * @return the minimum
   */
  public Number getMin() {
    return (Number)get("min");
  }

  /**
   * Returns the offset.
   * 
   * @return the offset
   */
  public boolean getOffset() {
    return (Integer.parseInt((String) get("offset"))) == 1;
  }

  /**
   * Returns the steps.
   * 
   * @return the steps
   */
  public Number getSteps() {
    return (Number)get("steps");
  }

  /**
   * Returns the stroke.
   * 
   * @return the stroke
   */
  public Integer getStroke() {
    return (Integer)get("stroke");
  }

  /**
   * Returns the z-depth (3D).
   * 
   * @return the zdepth3d
   */
  public int getZDepth3D() {
    return (Integer)get("3d");
  }

  /**
   * Sets the colour in HTML hex format (#ffffff).
   * 
   * @param colour the new colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }

  /**
   * Sets the grid colour in HTML hex format (#ffffff).
   * 
   * @param gridColour the new grid colour
   */
  public void setGridColour(String gridColour) {
    set("grid-colour", gridColour);
  }

  /**
   * Sets the max.
   * 
   * @param max the new max
   */
  public void setMax(Number max) {
    set("max", max);
  }

  /**
   * Sets the min.
   * 
   * @param min the new min
   */
  public void setMin(Number min) {
    set("min", min);
  }

  /**
   * Sets the offset.
   * 
   * @param offset the new offset
   */
  public void setOffset(boolean offset) {
    set("offset", offset ? 1 : 0);
  }

  /**
   * Sets the range.
   * 
   * @param min the minimum value
   * @param max the maximum value
   */
  public void setRange(Number min, Number max) {
    setMin(min);
    setMax(max);
  }

  /**
   * Sets the range.
   * 
   * @param min the minimum value
   * @param max the maximum value
   * @param step the step
   */
  public void setRange(Number min, Number max, Number step) {
    setRange(min, max);
    setSteps(step);
  }

  /**
   * Sets the steps.
   * 
   * @param steps the new steps
   */
  public void setSteps(Number steps) {
    set("steps", steps);
  }

  /**
   * Sets the stroke.
   * 
   * @param stroke the new stroke
   */
  public void setStroke(Integer stroke) {
    set("stroke", stroke);
  }

  /**
   * Sets the z-depth (3D).
   * 
   * @param zdepth3d the new zdepth3d
   */
  public void setZDepth3D(Integer zdepth3d) {
    set("3d", zdepth3d);
  }
}

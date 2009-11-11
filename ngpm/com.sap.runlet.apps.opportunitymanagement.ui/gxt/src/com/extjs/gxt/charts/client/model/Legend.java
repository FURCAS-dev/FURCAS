/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.charts.client.model;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * Base class for an OFC legend element
 */
public class Legend extends BaseModel {
  /**
   * Enumeration Position - used with legend.
   */
  public static enum Position {

    TOP("top"), RIGHT("right");

    private String pos;

    Position(String pos) {
      this.pos = pos;
    }

    @Override
    public String toString() {
      return pos;
    }
  }

  /**
   * Create a new Legend instance with a border and the given position.
   * 
   * @param pos Position
   */
  public Legend(Position pos) {
    this(pos, true);
  }

  /**
   * Create a new Legend instance with the given position and border.
   * 
   * @param pos Position
   * @param border boolean
   */
  public Legend(Position pos, boolean border) {
    setVisible(true);
    setPosition(pos);
    setBorder(border);
    setShadow(true);
    setBackgroundColour("#fefefe");
  }

  /**
   * Returns the alpha value.
   * 
   * @return the alpha value
   */
  public float getAlpha() {
    return (Float)get("alpha");
  }

  /**
   * Returns the background color.
   * 
   * @return the the background color
   */
  public String getBackgroundColour() {
    return (String)get("bg_colour");
  }

  /**
   * Returns true if the border is enabled.
   * 
   * @return true if border is enabled
   */
  public boolean getBorder() {
    return (Boolean)get("border");
  }

  /**
   * Returns the border colour.
   * 
   * @return the border colour
   */
  public String getBorderColour() {
    return (String)get("border_colour");
  }

  /**
   * Returns the margin.
   * 
   * @return the margin
   */
  public Integer getMargin() {
    return (Integer)get("margin");
  }

  /**
   * Returns the padding.
   * 
   * @return the padding
   */
  public Integer getPadding() {
    return (Integer)get("padding");
  }

  /**
   * Returns the position.
   * 
   * @return the position
   */
  public Position getPosition() {
    return Position.valueOf((String) get("position"));
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
   * Returns the shadow.
   * 
   * @return the shadow
   */
  public boolean isShadow() {
    return (Boolean)get("shadow");
  }

  /**
   * Returns the visible state.
   * 
   * @return true if visible.
   */
  public boolean isVisible() {
    return (Boolean)get("visible");
  }

  /**
   * Sets the alpha value.
   * 
   * @param alpha the alpha to set
   */
  public void setAlpha(Float alpha) {
    set("alpha", alpha);
  }

  /**
   * Sets the background colour.
   * 
   * @param backgroundColour the background color to set
   */
  public void setBackgroundColour(String backgroundColour) {
    set("bg_colour", backgroundColour);
  }

  /**
   * Sets the border, whether or not to draw a line around the side legend.
   * 
   * @param border true to draw a border
   */
  public void setBorder(boolean border) {
    set("border", border);
  }

  /**
   * Sets the border colour.
   * 
   * @param borderColour the border colour
   */
  public void setBorderColour(String borderColour) {
    set("border_colour", borderColour);
  }

  /**
   * Sets the margin.
   * 
   * @param margin the margin to set
   */
  public void setMargin(Integer margin) {
    set("margin", margin);
  }

  /**
   * Sets the padding.
   * 
   * @param padding the padding
   */
  public void setPadding(Integer padding) {
    set("padding", padding);
  }

  /**
   * Sets the position.
   * 
   * @param pos the position
   */
  public void setPosition(Position pos) {
    set("position", pos.toString());
  }

  /**
   * @param shadow the shadow to set
   */
  public void setShadow(boolean shadow) {
    set("shadow", shadow);
  }

  /**
   * Sets whether the legend is visible.
   * 
   * @param visible true for visible, false to hide
   */
  public void setVisible(boolean visible) {
    set("visible", new Boolean(visible));
  }

  /**
   * Sets the stroke.
   * 
   * @param stroke the stroke to set
   */
  public void setStroke(Integer stroke) {
    set("stroke", stroke);
  }
}

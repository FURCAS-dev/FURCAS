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
 * Base class for an OFC tooltip element
 */
public class ToolTip extends BaseModel {
  /**
   * Enumeration MouseStyle - used with tooltip.
   */
  public static enum MouseStyle {

    /** CLOSEST */
    CLOSEST(0),

    /** FOLLOW */
    FOLLOW(1),

    /** NORMAL */
    NORMAL(2);

    /** The style. */
    private int style;

    /**
     * Creates a new mouse style.
     * 
     * @param style the style
     */
    MouseStyle(int style) {
      this.style = style;
    }

    /**
     * Returns the style.
     * 
     * @return the style
     */
    public String toString() {
      return "" + style;
    }
  }

  /**
   * Create a new ToolTip instance
   */
  public ToolTip() {
  }

  /**
   * Create a new ToolTip instance with the given mouse style
   * 
   * @param mouse the mouse style
   */
  public ToolTip(MouseStyle mouse) {
    setMouse(mouse);
  }

  /**
   * Returns the background colour.
   * 
   * @return the background colour
   */
  public String getBackgroundColour() {
    return (String)get("background");
  }

  /**
   * Returns the body style.
   * 
   * @return the body style
   */
  public String getBodyStyle() {
    return (String)get("body");
  }

  /**
   * Returns the colour.
   * 
   * @return the colour
   */
  public String getColour() {
    return (String)get("colour");
  }

  /**
   * Returns the mouse.
   * 
   * @return the mouse
   */
  public MouseStyle getMouse() {
    return MouseStyle.valueOf((String) get("mouse"));
  }

  /**
   * Returns the stroke.
   * 
   * @return the stroke
   */
  public int getStroke() {
    return (Integer)get("stroke");
  }

  /**
   * Gets the title style.
   * 
   * @return the title style
   */
  public String getTitleStyle() {
    return (String)get("title");
  }

  /**
   * Sets the background colour.
   * 
   * @param backgroundColour the background colour to set
   */
  public void setBackgroundColour(String backgroundColour) {
    set("background", backgroundColour);
  }

  /**
   * Sets the body style.
   * 
   * @param bodyStyle the body style to set
   */
  public void setBodyStyle(String bodyStyle) {
    set("body", bodyStyle);
  }

  /**
   * Sets the colour.
   * 
   * @param colour the colour to set
   */
  public void setColour(String colour) {
    set("colour", colour);
  }

  /**
   * Sets the mouse.
   * 
   * @param mouse the mouse to set
   */
  public void setMouse(MouseStyle mouse) {
    set("mouse", mouse.toString());
  }

  /**
   * Sets the stroke.
   * 
   * @param stroke the stroke to set
   */
  public void setStroke(int stroke) {
    set("stroke", stroke);
  }

  /**
   * Sets the title style.
   * 
   * @param titleStyle the title style to set
   */
  public void setTitleStyle(String titleStyle) {
    set("title", titleStyle);
  }
}

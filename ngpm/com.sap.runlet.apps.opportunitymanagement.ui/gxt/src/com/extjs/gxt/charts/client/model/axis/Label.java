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
 * Base class for an OFC label.
 */
public class Label extends BaseModel {

  /**
   * Creates a new label.
   */
  public Label() {
    this(null);
  }

  /**
   * Creates a new label.
   * 
   * @param text the text
   */
  public Label(String text) {
    setText(text);
  }

  /**
   * Creates a new label.
   * 
   * @param text the text
   * @param angle the rotation angle
   */
  public Label(String text, int angle) {
    setText(text);
    setRotationAngle(angle);
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
   * Returns the rotation.
   * 
   * @return the rotation
   */
  public int getRotationAngle() {
    return (Integer)get("rotate");
  }

  /**
   * Returns the size.
   * 
   * @return the size
   */
  public int getSize() {
    return (Integer)get("size");
  }

  /**
   * Returns the text.
   * 
   * @return the text
   */
  public String getText() {
    return (String)get("text");
  }

  /**
   * Returns whether the label is visible.
   * 
   * @return true if visible
   */
  public boolean isVisible() {
    return (Boolean)get("visible");
  }

  /**
   * Sets the colour in HTML hex format (#ffffff).
   * 
   * @param colour the colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }

  /**
   * Sets the rotation in degrees (ie 45 = diagonal, 90 = vertical).
   * 
   * @param angle the rotate angle
   */
  public void setRotationAngle(int angle) {
    set("rotate", angle);
  }

  /**
   * Sets the size.
   * 
   * @param size the size
   */
  public void setSize(int size) {
    set("size", size);
  }

  /**
   * Sets the text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    set("text", text);
  }

  /**
   * Sets the visible.
   * 
   * @param visible the visible
   */
  public void setVisible(boolean visible) {
    set("visible", visible);
  }
}

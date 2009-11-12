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
 * Base class for an OFC keys.
 */
public class Keys extends BaseModel {

  /**
   * Creates a new key.
   * 
   * @param text the text
   * @param colour the colour
   * @param fontSize the font size
   */
  public Keys(String text, String colour, int fontSize) {
    setText(text);
    setColour(colour);
    setFontSize(fontSize);
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
   * Returns the font size.
   * 
   * @return the font size
   */
  public int getFontSize() {
    return (Integer)get("font-size");
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
   * Sets the colour in HTML hex format (#ffffff).
   * 
   * @param colour the colour
   */
  public void setColour(String colour) {
    set("colour", colour);
  }

  /**
   * Sets the font size.
   * 
   * @param fontSize the font size
   */
  public void setFontSize(int fontSize) {
    set("font-size", fontSize);
  }

  /**
   * Sets the text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    set("text", text);
  }
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.ColorPalette;
import com.google.gwt.user.client.Event;

/**
 * ColorPalette event type.
 */
public class ColorPaletteEvent extends ComponentEvent {

  private ColorPalette colorPalette;
  private String color;

  public ColorPaletteEvent(ColorPalette colorPalette) {
    super(colorPalette);
    setColorPalette(colorPalette);
  }

  public ColorPaletteEvent(ColorPalette colorPalette, Event event) {
    super(colorPalette, event);
    setColorPalette(colorPalette);
  }

  /**
   * Returns the selected color.
   * 
   * @return the selected color
   */
  public String getColor() {
    return color;
  }

  /**
   * Sets the selected color.
   * 
   * @param color the selected color
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Sets the color palette.
   * 
   * @param colorPalette the color palette
   */
  public void setColorPalette(ColorPalette colorPalette) {
    this.colorPalette = colorPalette;
  }

  /**
   * Returns the color palette.
   * 
   * @return the color palette
   */
  public ColorPalette getColorPalette() {
    return colorPalette;
  }

}

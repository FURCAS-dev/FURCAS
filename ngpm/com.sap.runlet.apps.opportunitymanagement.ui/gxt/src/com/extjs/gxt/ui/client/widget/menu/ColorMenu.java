/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.ColorPalette;

public class ColorMenu extends Menu {

  protected ColorPalette palette;

  public ColorMenu() {
    super();
    palette = new ColorPalette();
    add(palette);
    setAutoHeight(true);
    plain = true;
    showSeparator = false;
    setEnableScrolling(false);
  }

  /**
   * Returns the selected color.
   * 
   * @return the color
   */
  
  public String getColor() {
    return palette.getValue();
  }

  /**
   * Returns the color palette.
   * 
   * @return the color palette
   */
  public ColorPalette getColorPalette() {
    return palette;
  }
  
  protected void onClick(ComponentEvent ce) {
    hide(true);
  }
}

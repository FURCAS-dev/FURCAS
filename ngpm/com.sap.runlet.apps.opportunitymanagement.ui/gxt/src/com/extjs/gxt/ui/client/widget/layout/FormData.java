/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

/**
 * Layout data form <code>FormLayout</code>.
 */
public class FormData extends AnchorData {

  private int width;
  private int height;

  /**
   * Creates a new form data instance.
   */
  public FormData() {

  }

  /**
   * Creates a new form data instance.
   * 
   * @param width the width
   * @param height the height
   */
  public FormData(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Creates a new form data instance.
   * 
   * @param anchorSpec the anchor spec
   */
  public FormData(String anchorSpec) {
    super(anchorSpec);
  }

  /**
   * Returns the height.
   * 
   * @return the height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Returns the width.
   * 
   * @return the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Sets the height.
   * 
   * @param height the height
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Setst the width.
   * 
   * @param width the width
   */
  public void setWidth(int width) {
    this.width = width;
  }
}

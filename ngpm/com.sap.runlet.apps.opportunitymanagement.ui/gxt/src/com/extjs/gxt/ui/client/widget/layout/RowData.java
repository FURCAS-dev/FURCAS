/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.util.Margins;

/**
 * Layout data for <code>RowLayout</code> that controls the width and height of
 * a widget.
 * 
 * <p/> The height and width of each component can be specified with a RowData
 * instance. There are 3 types of values:
 * 
 * <ul>
 * <li>Values less than or equal to 1 are treated as percentages, with 1 = 100%.
 * </li>
 * <li>Values greater than 1 are treated as pixels.</li>
 * <li>Values equal to Style.DEFAULT (-1) will use the component's computed
 * height.</li>
 * </ul>
 * 
 * @see RowLayout
 */
public class RowData extends MarginData {

  private double width = Style.DEFAULT;
  private double height = Style.DEFAULT;
  int calcHeight;
  int calcWidth;

  /**
   * Creates a new row data.
   */
  public RowData() {

  }

  /**
   * Creates a new row data.
   * 
   * @param width the width, values of 1 or less treated as percentages
   * @param height the height, values of 1 or less treated as percentages
   */
  public RowData(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Creates a new row data.
   * 
   * @param width the width, values of 1 or less treated as percentages
   * @param height the height, values of 1 or less treated as percentages
   * @param margins the margins
   */
  public RowData(double width, double height, Margins margins) {
    super(margins);
    this.width = width;
    this.height = height;
  }

  /**
   * Returns the height.
   * 
   * @return the height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Returns the width.
   * 
   * @return the width
   */
  public double getWidth() {
    return width;
  }

  /**
   * Sets the height in pixels (defauls to DEFAULT). The default value indicates
   * that the layout should use the widget's computed height.
   * 
   * @param height the height, values of 1 or less treated as percentages
   */
  public void setHeight(double height) {
    this.height = height;
  }

  /**
   * Sets the height in pixels (defaults to DEFAULT). The default value
   * indicates that the layout should use the widget's computed width.
   * 
   * @param width the width, values of 1 treated as percentages
   */
  public void setWidth(double width) {
    this.width = width;
  }

}

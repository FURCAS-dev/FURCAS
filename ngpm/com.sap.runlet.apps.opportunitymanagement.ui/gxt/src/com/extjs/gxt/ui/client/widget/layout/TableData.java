/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.core.El;

/**
 * Layout data for {@link TableLayout}.
 */
public class TableData extends LayoutData {

  HorizontalAlignment horizontalAlign;
  VerticalAlignment verticalAlign;
  private String width;
  private int padding;
  private int margin;
  private int colspan = 1;
  private int rowspan = 1;
  private String styleName;
  private String height;
  private String style;

  /**
   * Creates a new table data instance.
   */
  public TableData() {

  }

  /**
   * Creates a new table data instance.
   * 
   * @param horizontalAlign the horiztonal alignment
   * @param verticalAlign the vertical aligment
   */
  public TableData(HorizontalAlignment horizontalAlign, VerticalAlignment verticalAlign) {
    this.setHorizontalAlign(horizontalAlign);
    this.setVerticalAlign(verticalAlign);
  }

  /**
   * Creates a new table data instance.
   * 
   * @param width the cell width
   * @param height the cell height
   */
  public TableData(String width, String height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Returns the column span.
   * 
   * @return the column span
   */
  public int getColspan() {
    return colspan;
  }

  /**
   * Returns the cell's height.
   * 
   * @return the cell height
   */
  public String getHeight() {
    return height;
  }

  public HorizontalAlignment getHorizontalAlign() {
    return horizontalAlign;
  }

  /**
   * Returns the cell's margin.
   * 
   * @return the margin
   */
  public int getMargin() {
    return margin;
  }

  /**
   * Returns the cell's padding.
   * 
   * @return the padding
   */
  public int getPadding() {
    return padding;
  }

  /**
   * Returns the cell style.
   * 
   * @return the style
   */
  public String getStyle() {
    return style;
  }

  /**
   * Returns the cell's style.
   * 
   * @return the style
   */
  public String getStyleName() {
    return styleName;
  }

  /**
   * Returns the cell's vertical alignment (defaults to TOP).
   * 
   * @return the vertical alignment
   */
  public VerticalAlignment getVerticalAlign() {
    return verticalAlign;
  }

  /**
   * Returns the cell's width.
   * 
   * @return the cell width
   */
  public String getWidth() {
    return width;
  }

  /**
   * Sets the number of columns to span (defaults to 1).
   * 
   * @param colspan the column span
   */
  public void setColspan(int colspan) {
    this.colspan = colspan;
  }

  /**
   * Sets the cell's height.
   * 
   * @param height the cell height
   */
  public void setHeight(String height) {
    this.height = height;
  }

  /**
   * Sets the cell's horizontal alignment (defaults to LEFT).
   * 
   * @param horizontalAlign the horizontal alignment
   */
  public void setHorizontalAlign(HorizontalAlignment horizontalAlign) {
    this.horizontalAlign = horizontalAlign;
  }

  /**
   * Sets the cell's margins.
   * 
   * @param margin the margin
   */
  public void setMargin(int margin) {
    this.margin = margin;
  }

  /**
   * Sets the cell's padding (default to 0).
   * 
   * @param padding the padding
   */
  public void setPadding(int padding) {
    this.padding = padding;
  }

  /**
   * Custom CSS styles to be applied to the table cell in the format expected by
   * {@link El#applyStyles}.
   * 
   * @param style the styles
   */
  public void setStyle(String style) {
    this.style = style;
  }

  /**
   * Sets the CSS style name applied to the component's cell.
   * 
   * @param style the style name
   */
  public void setStyleName(String style) {
    this.styleName = style;
  }

  /**
   * Sets the cell's vertical alignment.
   * 
   * @param verticalAlign the vertical alignment
   */
  public void setVerticalAlign(VerticalAlignment verticalAlign) {
    this.verticalAlign = verticalAlign;
  }

  /**
   * Specifies the cell's width.
   * 
   * @param width the cell width
   */
  public void setWidth(String width) {
    this.width = width;
  }

  public void setRowspan(int rowspan) {
    this.rowspan = rowspan;
  }

  public int getRowspan() {
    return rowspan;
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.util.Margins;

/**
 * Base layout data with margin support.
 */
public class MarginData extends LayoutData {

  private Margins margins;

  /**
   * Creates a new layout data.
   */
  public MarginData() {

  }

  /**
   * Creates a new layout data.
   * 
   * @param margin the margin
   */
  public MarginData(int margin) {
    this.margins = new Margins(margin);
  }

  /**
   * Creates a new layout data.
   * 
   * @param top the top margin
   * @param right the right margin
   * @param bottom the bottom margin
   * @param left the left margin
   */
  public MarginData(int top, int right, int bottom, int left) {
    this.margins = new Margins(top, right, bottom, left);
  }

  /**
   * Creates a new layout data.
   * 
   * @param margins the margins
   */
  public MarginData(Margins margins) {
    this.margins = margins;
  }

  /**
   * Returns the data's margins.
   * 
   * @return the margins
   */
  public Margins getMargins() {
    return margins;
  }

  /**
   * Sets the data's margins.
   * 
   * @param margins the margins
   */
  public void setMargins(Margins margins) {
    this.margins = margins;
  }
}

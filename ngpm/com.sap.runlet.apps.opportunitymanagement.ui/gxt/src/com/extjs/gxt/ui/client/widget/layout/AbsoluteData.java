/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.Style;

/**
 * Layout data for {@link AbsoluteLayout}.
 */
public class AbsoluteData extends AnchorData {

  private int left = Style.DEFAULT;
  private int top = Style.DEFAULT;

  public AbsoluteData() {

  }

  public AbsoluteData(int left, int top) {
    this.left = left;
    this.top = top;
  }

  /**
   * Returns the left coordinate value.
   * 
   * @return the left value
   */
  public int getLeft() {
    return left;
  }

  /**
   * Returns the left value.
   * 
   * @return the left value
   */
  public int getTop() {
    return top;
  }

  /**
   * Sets the left property (defaults to DEFAULT).
   * 
   * @param left the left value
   */
  public void setLeft(int left) {
    this.left = left;
  }

  /**
   * Sets the top position (defaults to DEFAULT).
   * 
   * @param top the top value
   */
  public void setTop(int top) {
    this.top = top;
  }

}

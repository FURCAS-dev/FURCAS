/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.SplitBar;

/**
 * Layout data describing a "region" in a border panel.
 */
public class BorderLayoutData extends LayoutData {

  private int minSize = 50;
  private boolean floatable = true;
  private int maxSize = 500;
  private float size = 200;
  private boolean collapsible;
  private Margins margins = new Margins();
  private boolean split;
  private boolean hidden = false;
  private boolean hideCollapseTool = false;
  
  /**
   * The region the mapped content panel will be placed.
   */
  private LayoutRegion region;

  /**
   * Creates a new border layout data.
   * 
   * @param region the region
   */
  public BorderLayoutData(LayoutRegion region) {
    this.setRegion(region);
  }

  /**
   * Creates a new border layout data.
   * 
   * @param region the region
   * @param size the region's size
   */
  public BorderLayoutData(LayoutRegion region, float size) {
    this.setRegion(region);
    this.setSize(size);
  }

  public BorderLayoutData(LayoutRegion region, float size, int min, int max) {
    this(region, size);
    this.setMinSize(min);
    this.setMaxSize(max);
    setSplit(true);
  }

  /**
   * Returns the margins.
   * 
   * @return the margins
   */
  public Margins getMargins() {
    return margins;
  }

  /**
   * Returns the region's max size.
   * 
   * @return the max size
   */
  public int getMaxSize() {
    return maxSize;
  }

  /**
   * Returns the region's min size.
   * 
   * @return the min size
   */
  public int getMinSize() {
    return minSize;
  }

  /**
   * Returns the layout region.
   * 
   * @return the region
   */
  public LayoutRegion getRegion() {
    return region;
  }

  /**
   * Returns the region's size.
   * 
   * @return the region size
   */
  public float getSize() {
    return size;
  }

  /**
   * Returns true if the collapse tool is hidden.
   * 
   * @return the hide collapse tool state
   */
  public boolean getHideCollapseTool() {
    return hideCollapseTool;
  }
  
  /**
   * Returns true if collapsing is enabled.
   * 
   * @return the collapse state
   */
  public boolean isCollapsible() {
    return collapsible;
  }

  /**
   * Returns true if the region is floatable.
   * 
   * @return the float state
   */
  public boolean isFloatable() {
    return floatable;
  }

  /**
   * Returns true if the component is hidden.
   * 
   * @return the hidden state
   */
  public boolean isHidden() {
    return hidden;
  }

  /**
   * Returns true if the region is split.
   * 
   * @return the split state
   */
  public boolean isSplit() {
    return split;
  }

  /**
   * True to allow the user to collapse this region (defaults to false). If
   * true, an expand/collapse tool button will automatically be rendered into
   * the title bar of the region, otherwise the button will not be shown.
   * 
   * @param collapsible true to enable collapsing
   */
  public void setCollapsible(boolean collapsible) {
    this.collapsible = collapsible;
  }

  /**
   * True to allow clicking a collapsed region's bar to display the region's
   * panel floated above the layout, false to force the user to fully expand a
   * collapsed region by clicking the expand button to see it again (defaults to
   * true).
   * 
   * @param floatable true to enable floating
   */
  public void setFloatable(boolean floatable) {
    this.floatable = floatable;
  }

  /**
   * True to hide the component.
   * 
   * @param hidden true to hide
   */
  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  /**
   * Sets the margins to apply to the region.
   * 
   * @param margins the margins
   */
  public void setMargins(Margins margins) {
    this.margins = margins;
  }

  /**
   * Sets the maximum allowable size in pixels for this region (defaults to
   * 500).
   * 
   * @param maxSize the max size
   */
  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }

  /**
   * Sets the minimum allowable size in pixels for this region (defaults to 50).
   * 
   * @param minSize the min size
   */
  public void setMinSize(int minSize) {
    this.minSize = minSize;
  }

  /**
   * Sets the region the mapped content panel will be placed.
   * 
   * @param region the region
   */
  public void setRegion(LayoutRegion region) {
    this.region = region;
  }

  /**
   * The region's preferred size. Values of 1 or less are treated as percentages
   * (defaults to 200).
   * 
   * @param size the region size
   */
  public void setSize(float size) {
    this.size = size;
  }

  /**
   * True to display a {@link SplitBar} between this region and its neighbor,
   * allowing the user to resize the regions dynamically (defaults to false).
   * When split = true, it is common to specify a {@link #minSize} and
   * {@link #maxSize} for the region.
   * 
   * @param split true to enable a split bar
   */
  public void setSplit(boolean split) {
    this.split = split;
  }
  
  /**
   * True to hide the contained panel's collapse toggle buttons, false to
   * display it (defaults to false).
   * 
   * @param hideCollapseTool true to hide
   */
  public void setHideCollapseTool(boolean hideCollapseTool) {
    this.hideCollapseTool = hideCollapseTool;
  }

}

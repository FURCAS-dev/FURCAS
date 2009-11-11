/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Layout;

/**
 * <code>Layout</code> that simply renders each child component into its
 * container. The size and position of children are not altered by this layout.
 * 
 * <p/>
 * Margins can be applied directly to child components to control the spacing
 * between components.
 */
public class FlowLayout extends Layout {

  private Margins margins;
  private boolean removePositioning = false;

  /**
   * Creates a new layout instance.
   */
  public FlowLayout() {

  }

  /**
   * Creates a new flow layout.
   * 
   * @param removePostioning true to remove positioning on child components
   */
  public FlowLayout(boolean removePostioning) {
    this.setRemovePositioning(removePostioning);
  }

  /**
   * Creates a new layout instance with the given margin.
   * 
   * @param margin the margin
   */
  public FlowLayout(int margin) {
    setMargins(new Margins(margin));
  }

  /**
   * Returns the margins of the layout.
   * 
   * @return the margins
   */
  public Margins getMargins() {
    return margins;
  }

  /**
   * Returns true if positioning is being removed.
   * 
   * @return the remove positioning state
   */
  public boolean getRemovePositioning() {
    return removePositioning;
  }

  /**
   * Sets the margins using the give margin.
   * 
   * @param margin the margin
   */
  public void setMargin(int margin) {
    setMargins(new Margins(margin));
  }

  /**
   * Sets the margins of the layout to be applied to the container.
   * 
   * @param margins the margins in pixels
   */
  public void setMargins(Margins margins) {
    this.margins = margins;
  }

  /**
   * True to remove positioning from the container's children (defaults to
   * false).
   * 
   * @param removePositioning true to remove positioning
   */
  public void setRemovePositioning(boolean removePositioning) {
    this.removePositioning = removePositioning;
  }

  @Override
  protected void onLayout(Container<?> container, El target) {
    super.onLayout(container, target);
    if (margins != null) {
      applyMargins(target, margins);
    }
  }

  @Override
  protected void renderComponent(Component c, int index, El target) {
    super.renderComponent(c, index, target);
    if (removePositioning) {
      c.setStyleAttribute("position", "static");
    }
    if (getLayoutData(c) != null && getLayoutData(c) instanceof FlowData) {
      FlowData data = (FlowData) getLayoutData(c);
      applyMargins(c.el(), data.getMargins());
    }
  }

}

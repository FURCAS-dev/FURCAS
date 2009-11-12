/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;

/**
 * This layout contains multiple widgets, each fit to the container, where only
 * a single widget can be visible at any given time. This layout style is most
 * commonly used for wizards, tab implementations, etc.
 * 
 * <p />
 * Child Widgets are:
 * <ul>
 * <li><b>Sized</b> : Yes - expands to fill parent container.</li>
 * <li><b>Positioned</b> : No - widgets are located at 0,0.</li>
 * </ul>
 * 
 * <p />
 * The CardLayout's focal method is {@link #setActiveItem(Component)}. Since
 * only one panel is displayed at a time, the only way to move from one panel to
 * the next is by calling setActiveItem the next panel to display. The layout
 * itself does not provide a mechanism for handling this navigation, so that
 * functionality must be provided by the developer.
 * 
 * @see CardPanel
 */
public class CardLayout extends FitLayout {

  private boolean deferredRender = true;

  /**
   * Creates a new card layout instance.
   */
  public CardLayout() {
    monitorResize = true;
    renderHidden = true;
  }

  /**
   * Returns the active component.
   * 
   * @return the top widget
   */
  public Component getActiveItem() {
    return activeItem;
  }

  /**
   * Returns true if children are rendered when first accessed.
   * 
   * @return true to defer rendering
   */
  public boolean isDeferredRender() {
    return deferredRender;
  }

  /**
   * Sets the active (visible) item in the layout.
   * 
   * @param component the active component
   */
  public void setActiveItem(Component component) {
    if (activeItem != component) {
      if (activeItem != null) {
        activeItem.hide();
      }
      activeItem = component;
      if (activeItem != null) {
        activeItem.show();
        // deferred rendering
        if (!activeItem.isRendered()
            || ((activeItem instanceof Container) && isLayoutNeeded((Container<?>) activeItem))) {
          setLayoutNeeded(container, true);
        }

        layoutContainer();
      }
    }
  }

  /**
   * True to render each child when it accessed, false to render all (defaults
   * to true).
   * 
   * @param deferredRender true to defer rendering
   */
  public void setDeferredRender(boolean deferredRender) {
    this.deferredRender = deferredRender;
  }

  @Override
  protected void renderComponent(Component component, int index, El target) {
    if (activeItem == component || !deferredRender) {
      super.renderComponent(component, index, target);
    }
  }

}

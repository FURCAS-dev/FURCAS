/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Component;

/**
 * <code>FillLayout</code> places its components in a single row or column,
 * forcing them to be the same size.
 * 
 * <p/>
 * Each components margins can be specified by using a FillData instance for
 * each child. Only 1 component should specify a margin on adjacent sides.
 */
public class FillLayout extends RowLayout {

  /**
   * Creates a new vertical fill layout.
   */
  public FillLayout() {

  }

  /**
   * Creates a new fill layout with the given orientation.
   * 
   * @param orientation the orientation
   */
  public FillLayout(Orientation orientation) {
    super(orientation);
  }

  @Override
  protected void layoutHorizontal(El target) {
    for (Component c : this.container.getItems()) {
      c.addStyleName("x-column");
    }

    Size size = target.getStyleSize();

    int w = size.width;
    int h = size.height;

    int count = container.getItemCount();
    for (int i = 0; i < count; i++) {
      Component c = container.getItem(i);
      int width = (w / count) - getSideMargins(c);
      int height = h - c.el().getMargins("tb");
      setSize(c, width, height);
    }
  }

  @Override
  protected void layoutVertical(El target) {
    Size size = target.getStyleSize();

    int w = size.width;
    int h = size.height;

    int count = container.getItemCount();
    for (int i = 0; i < count; i++) {
      Component c = container.getItem(i);
      int width = w - getSideMargins(c);
      int height = (h / count) - c.el().getMargins("tb");
      setSize(c, width, height);
    }
  }

}

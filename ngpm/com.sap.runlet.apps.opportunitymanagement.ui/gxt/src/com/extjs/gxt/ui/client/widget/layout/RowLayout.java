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
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.ScrollContainer;

/**
 * This layout positions the container's children in a single horizontal or
 * vertical row. Each component may specify its height and width in pixels or as
 * percentage.
 * 
 * <p/>
 * Each components margin may also be specified using a RowData instance. Only 1
 * component should specify a margin on adjacent sides.
 * 
 * @see RowData
 */
public class RowLayout extends Layout {

  private Orientation orientation = Orientation.VERTICAL;
  private boolean adjustForScroll;

  /**
   * Creates a new vertical row layout.
   */
  public RowLayout() {
    this(Orientation.VERTICAL);
  }

  /**
   * Creates a new row layout with the given orientation.
   * 
   * @param orientation the orientation of row layout
   */
  public RowLayout(Orientation orientation) {
    this.orientation = orientation;
    monitorResize = true;
  }

  /**
   * Returns the orientation of the layout.
   * 
   * @return the orientation
   */
  public Orientation getOrientation() {
    return orientation;
  }

  /**
   * Returns true if adjust for scroll is enabled.
   * 
   * @return the adjust for scroll state
   */
  public boolean isAdjustForScroll() {
    return adjustForScroll;
  }

  /**
   * True to adjust the container width calculations to account for the scroll
   * bar (defaults to false).
   * 
   * @param adjustForScroll the adjust for scroll state
   */
  public void setAdjustForScroll(boolean adjustForScroll) {
    this.adjustForScroll = adjustForScroll;
  }

  /**
   * Sets the orientation of the layout.
   * 
   * @param orientation the orientation
   */
  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
  }

  protected void layoutHorizontal(El target) {
    Size size = target.getStyleSize();

    int w = size.width - (adjustForScroll ? 19 : 0);
    int h = size.height;
    int pw = w;

    int count = container.getItemCount();

    // some columns can be percentages while others are fixed
    // so we need to make 2 passes
    for (int i = 0; i < count; i++) {
      Component c = container.getItem(i);
      c.el().makePositionable(true);
      c.el().setStyleAttribute("margin", "0px");
      RowData data = (RowData) getLayoutData(c);
      if (data == null) {
        data = new RowData();
        setLayoutData(c, data);
      }
      if (data.getWidth() > 1) {
        pw -= data.getWidth();
      } else if (data.getWidth() == -1) {
        pw -= c.getOffsetWidth();
      }

      Margins m = data.getMargins();
      if (m != null) {
        pw -= m.left + m.right;
      }
    }

    pw = pw < 0 ? 0 : pw;

    int x = 0;

    for (int i = 0; i < count; i++) {
      Component c = container.getItem(i);
      RowData data = (RowData) getLayoutData(c);

      double height = data.getHeight();

      if (height > 0 && height <= 1) {
        height = height * h;
      } else

      if (height == -1) {
        height = c.el().getHeight(true);
      }

      double width = data.getWidth();
      double fw = width;
      if (width > 0 && width <= 1) {
        width = width * pw;
        fw = width;
      } else if (width == -1) {
        fw = c.getOffsetWidth();
      }

      int tx = x;
      int ty = 0;
      int tw = (int) width;
      int th = (int) height;

      Margins m = data.getMargins();
      if (m != null) {
        tx += m.left;
        ty += m.top;
        th -= m.top;
        th -= m.bottom;
      }

      c.el().setLeftTop(tx, ty);
      setSize(c, tw, th);
      x += fw;
      if (m != null) {
        x += m.left + m.right;
      }
    }
  }

  protected void layoutVertical(El target) {
    Size size = target.getStyleSize();

    int w = size.width - (adjustForScroll ? 19 : 0);
    int h = size.height;
    int ph = h;

    int count = container.getItemCount();

    // some columns can be percentages while others are fixed
    // so we need to make 2 passes
    for (int i = 0; i < count; i++) {
      Component c = container.getItem(i);
      RowData data = (RowData) getLayoutData(c);
      if (data == null) {
        data = new RowData();
        setLayoutData(c, data);
      }

      if (data.getHeight() > 1) {
        ph -= data.getHeight();
      } else if (data.getHeight() == -1) {
        ph -= c.getOffsetHeight();
      }

      ph -= c.el().getMargins("tb");
    }

    ph = ph < 0 ? 0 : ph;

    for (int i = 0; i < count; i++) {
      Component c = container.getItem(i);
      RowData data = (RowData) getLayoutData(c);

      double width = data.getWidth();

      if (width > 0 && width <= 1) {
        width = width * w;
      }

      width -= getSideMargins(c);

      double height = data.getHeight();
      if (height > 0 && height <= 1) {
        height = height * ph;
      }

      height -= c.el().getMargins("tb");

      setSize(c, (int) width, (int) height);
    }
  }

  @Override
  protected void onLayout(Container<?> container, El target) {
    super.onLayout(container, target);
    target.makePositionable();

    if (container instanceof ScrollContainer) {
      ScrollContainer<?> sc = (ScrollContainer<?>) container;
      sc.setScrollMode(sc.getScrollMode());
    } else {
      target.setStyleAttribute("overflow", "hidden");
    }

    if (orientation == Orientation.VERTICAL) {
      layoutVertical(target);
    } else {
      layoutHorizontal(target);
    }
  }

}
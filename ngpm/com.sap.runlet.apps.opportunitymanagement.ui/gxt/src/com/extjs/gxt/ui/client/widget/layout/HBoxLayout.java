/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Container;

/**
 * Lays out it's children in a horizontal row.
 * 
 * <p />
 * Because this layout positions it's children absolutely, the container will
 * have no height. A height must be specified directly or by a parent layout.
 * 
 * <p />
 * The vertical position and height of children can be managed by using
 * {@link #setHBoxLayoutAlign(HBoxLayoutAlign)}.
 * 
 * <p />
 * <ul>
 * <ul>
 * <li>TOP - Children are aligned horizontally at the <b>top</b> side of the
 * container.</li>
 * <li>MIDDLE - Children are aligned horizontally at the <b>mid-height</b> of
 * the container.</li>
 * <li>STRETCH - Children are stretched vertically to fill the height of the
 * container.</li>
 * <li>STRETCHMAX - Children heights are set the size of the largest child's
 * height.</li>
 * </ul>
 */
public class HBoxLayout extends BoxLayout {

  public enum HBoxLayoutAlign {
    /**
     * Children are aligned horizontally at the <b>top</b> side of the
     * container.
     */
    TOP,
    /**
     * Children are aligned horizontally at the <b>mid-height</b> of the
     * container.
     */
    MIDDLE,
    /**
     * Children are aligned horizontally at the <b>bottom</b> side of the
     * container.
     */
    BOTTOM,
    /**
     * Children are stretched vertically to fill the height of the container.
     */
    STRETCH,
    /**
     * Children heights are set the size of the largest child's height.
     */
    STRETCHMAX
  }

  private HBoxLayoutAlign hBoxLayoutAlign;

  public HBoxLayout() {
    super();
    hBoxLayoutAlign = HBoxLayoutAlign.TOP;
    setPack(BoxLayoutPack.START);
  }

  /**
   * Returns the horizontal alignment.
   * 
   * @return the horizontal alignment
   */
  public HBoxLayoutAlign getHBoxLayoutAlign() {
    return hBoxLayoutAlign;
  }

  /**
   * Sets the vertical alignment for child items (defaults to TOP).
   * 
   * @param hBoxLayoutAlign the vertical alignment
   */
  public void setHBoxLayoutAlign(HBoxLayoutAlign hBoxLayoutAlign) {
    this.hBoxLayoutAlign = hBoxLayoutAlign;
  }

  protected void onLayout(Container<?> container, El target) {
    super.onLayout(container, target);

    Size size = target.getSize(true);
    if ((GXT.isIE && !GXT.isStrict) && (size.width < 1 || size.height < 1)) {
      return;
  } else if (size.width < 1 && size.height < 1) { // display none?
      return;
    }

    int w = size.width - target.getPadding("lr") - getScrollOffset();
    int h = size.height - target.getPadding("tb");

    int l = getPadding().left;
    int t = getPadding().top;

    int strechHeight = h - t - getPadding().bottom;
    int totalFlex = 0;
    int totalWidth = 0;
    int maxHeight = 0;

    for (int i = 0; i < container.getItemCount(); i++) {
      BoxComponent c = (BoxComponent) container.getItem(i);
      c.el().setStyleAttribute("margin", "0px");
      HBoxLayoutData layoutData = (HBoxLayoutData) ComponentHelper.getLayoutData(c);
      if (layoutData == null) {
        layoutData = new HBoxLayoutData();
      }
      Margins cm = layoutData.getMargins();
      totalFlex += layoutData.getFlex();
      totalWidth += c.getWidth() + cm.left + cm.right;
      maxHeight = Math.max(maxHeight, c.getHeight() + cm.top + cm.bottom);
    }

    int innerCtHeight = maxHeight + t + getPadding().bottom;

    if (hBoxLayoutAlign.equals(HBoxLayoutAlign.STRETCH)) {
      innerCt.setSize(w, h);
    } else if (hBoxLayoutAlign.equals(HBoxLayoutAlign.MIDDLE)
        || hBoxLayoutAlign.equals(HBoxLayoutAlign.BOTTOM)) {
      innerCt.setSize(w, h = Math.max(h, innerCtHeight));
    } else {
      innerCt.setSize(w, innerCtHeight);
    }

    int extraWidth = w - totalWidth - l - getPadding().right;
    int allocated = 0;
    int cw, ch, ct;
    int availableHeight = h - t - getPadding().bottom;

    if (getPack().equals(BoxLayoutPack.CENTER)) {
      l += extraWidth / 2;
    } else if (getPack().equals(BoxLayoutPack.END)) {
      l += extraWidth;
    }

    for (int i = 0; i < container.getItemCount(); i++) {
      BoxComponent c = (BoxComponent) container.getItem(i);
      HBoxLayoutData layoutData = (HBoxLayoutData) ComponentHelper.getLayoutData(c);
      if (layoutData == null) {
        layoutData = new HBoxLayoutData();
      }
      Margins cm = layoutData.getMargins();
      cw = c.getWidth();
      ch = c.getHeight();
      l += cm.left;
      if (hBoxLayoutAlign.equals(HBoxLayoutAlign.MIDDLE)) {
        int diff = availableHeight - (ch + cm.top + cm.bottom);
        if (diff == 0) {
          ct = t + cm.top;
        } else {
          ct = t + cm.top + (diff / 2);
        }
      } else {
        if (hBoxLayoutAlign.equals(HBoxLayoutAlign.BOTTOM)) {
          ct = h - (getPadding().bottom + cm.bottom + ch);
        } else {
          ct = t + cm.top;
        }

      }

      c.setPosition(l, ct);
      if (getPack().equals(BoxLayoutPack.START) && layoutData.getFlex() > 0) {
        int add = (int) Math.floor(extraWidth * (layoutData.getFlex() / totalFlex));
        allocated += add;
        if (isAdjustForFlexRemainder() && i == container.getItemCount() - 1) {
          add += (extraWidth - allocated);
        }

        cw += add;
        c.setWidth(cw);
      }
      if (hBoxLayoutAlign.equals(HBoxLayoutAlign.STRETCH)) {
        c.setHeight(Util.constrain(strechHeight - cm.top - cm.bottom,
            layoutData.getMinHeight(), layoutData.getMaxHeight()));
      } else if (hBoxLayoutAlign.equals(HBoxLayoutAlign.STRETCHMAX)) {
        c.setHeight(Util.constrain(maxHeight - cm.top - cm.bottom,
            layoutData.getMinHeight(), layoutData.getMaxHeight()));
      }
      l += cw + cm.right;
    }

  }
}

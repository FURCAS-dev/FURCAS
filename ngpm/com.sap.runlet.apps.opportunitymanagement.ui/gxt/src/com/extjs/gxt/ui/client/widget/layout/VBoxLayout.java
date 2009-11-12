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
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Container;

/**
 * Lays out it's children in a vertical column.
 * 
 * <p />
 * Because this layout positions it's children absolutely, the container will
 * have no height. A height must be specified directly or by a parent layout.
 * 
 * <p />
 * The horizontal position and width can be managed by using
 * {@link #setVBoxLayoutAlign(VBoxLayoutAlign)}.
 * 
 * <p />
 * <ul>
 * <li>LEFT - Children are aligned vertically at the <b>left</b> side of the
 * container (default).</li>
 * <li>CENTER - Children are aligned vertically at the <b>mid-width</b> of the
 * container.</li>
 * <li>STRETCH - Children are stretched horizontally to fill the width of the
 * container.</li>
 * <li>STRETCHMAX - Children widths are set the size of the largest child's
 * width.</li>
 * </ul>
 */
public class VBoxLayout extends BoxLayout {

  /**
   * Alignment enumeration for horizontal alignment.
   */
  public enum VBoxLayoutAlign {
    /**
     * Children are aligned vertically at the <b>left</b> side of the container
     * (default).
     */
    LEFT,
    /**
     * Children are aligned vertically at the <b>mid-width</b> of the container.
     */
    CENTER,
    /**
     * Children are aligned vertically at the <b>right</b> side of the container
     * (default).
     */
    RIGHT,
    /**
     * Children are stretched horizontally to fill the width of the container.
     */
    STRETCH,
    /**
     * Children widths are set the size of the largest child's width.
     */
    STRETCHMAX
  }

  private VBoxLayoutAlign vBoxLayoutAlign;

  public VBoxLayout() {
    super();
    vBoxLayoutAlign = VBoxLayoutAlign.LEFT;
    setPack(BoxLayoutPack.START);
  }

  /**
   * Returns the horizontal alignment.
   * 
   * @return the horizontal alignment
   */
  public VBoxLayoutAlign getVBoxLayoutAlign() {
    return vBoxLayoutAlign;
  }

  /**
   * Sets the horizontal alignment for child items (defaults to LEFT).
   * 
   * @param vBoxLayoutAlign the horizontal alignment
   */
  public void setVBoxLayoutAlign(VBoxLayoutAlign vBoxLayoutAlign) {
    this.vBoxLayoutAlign = vBoxLayoutAlign;
  }

  protected void onLayout(Container<?> container, El target) {
    super.onLayout(container, target);

    Size size = target.getSize();

    if (size.width < 1 && size.height < 1) { // display none?
      return;
    }

    int w = size.width - target.getPadding("lr") - getScrollOffset();
    int h = size.height - target.getPadding("tb");

    int l = getPadding().left;
    int t = getPadding().top;

    int strechWidth = w - l - getPadding().right;
    int totalFlex = 0;
    int totalHeight = 0;
    int maxWidth = 0;
    for (int i = 0; i < container.getItemCount(); i++) {
      BoxComponent c = (BoxComponent) container.getItem(i);
      c.el().setStyleAttribute("margin", "0px");
      VBoxLayoutData layoutData = (VBoxLayoutData) ComponentHelper.getLayoutData(c);
      if (layoutData == null) {
        layoutData = new VBoxLayoutData();
      }
      Margins cm = layoutData.getMargins();
      totalFlex += layoutData.getFlex();
      totalHeight += c.getHeight() + cm.top + cm.bottom;
      maxWidth = Math.max(maxWidth, c.getWidth() + cm.left + cm.right);
    }

    int innerCtWidth = maxWidth + l + getPadding().right;

    if (vBoxLayoutAlign.equals(VBoxLayoutAlign.STRETCH)) {
      innerCt.setSize(w, h);
    } else {
      innerCt.setSize(w = Math.max(w, innerCtWidth), h);
    }

    int extraHeight = h - totalHeight - t - getPadding().bottom;
    int allocated = 0;
    int cw, ch, cl;
    int availableWidth = w - l - getPadding().right;

    if (getPack().equals(BoxLayoutPack.CENTER)) {
      t += extraHeight / 2;
    } else if (getPack().equals(BoxLayoutPack.END)) {
      t += extraHeight;
    }

    for (int i = 0; i < container.getItemCount(); i++) {
      BoxComponent c = (BoxComponent) container.getItem(i);
      VBoxLayoutData layoutData = (VBoxLayoutData) ComponentHelper.getLayoutData(c);
      if (layoutData == null) {
        layoutData = new VBoxLayoutData();
      }
      Margins cm = layoutData.getMargins();
      cw = c.getWidth();
      ch = c.getHeight();
      t += cm.top;
      if (vBoxLayoutAlign.equals(VBoxLayoutAlign.CENTER)) {
        int diff = availableWidth - (cw + cm.left + cm.right);
        if (diff == 0) {
          cl = l + cm.left;
        } else {
          cl = l + cm.left + (diff / 2);
        }
      } else {
        if (vBoxLayoutAlign.equals(VBoxLayoutAlign.RIGHT)) {
          cl = w - (getPadding().right + cm.right + cw);
        } else {
          cl = l + cm.left;
        }
      }

      c.setPosition(cl, t);
      if (getPack().equals(BoxLayoutPack.START) && layoutData.getFlex() > 0) {
        int add = (int) Math.floor(extraHeight * (layoutData.getFlex() / totalFlex));
        allocated += add;
        if (isAdjustForFlexRemainder() && i == container.getItemCount() - 1) {
          add += extraHeight - allocated;
        }
        ch += add;
        c.setHeight(ch);
      }
      if (vBoxLayoutAlign.equals(VBoxLayoutAlign.STRETCH)) {
        c.setWidth(Util.constrain(strechWidth - cm.left - cm.right,
            layoutData.getMinWidth(), layoutData.getMaxWidth()));
      } else if (vBoxLayoutAlign.equals(VBoxLayoutAlign.STRETCHMAX)) {
        c.setWidth(Util.constrain(maxWidth - cm.left - cm.right,
            layoutData.getMinWidth(), layoutData.getMaxWidth()));
      }
      t += ch + cm.bottom;
    }

  }
}

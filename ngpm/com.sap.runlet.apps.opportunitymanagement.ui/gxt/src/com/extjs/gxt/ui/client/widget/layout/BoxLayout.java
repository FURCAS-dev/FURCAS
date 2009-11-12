/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Layout;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

/**
 * Base class for box layouts.
 * 
 * <p />
 * Pack config:
 * <ul>
 * <li>START - Children are packed together at <b>top</b> side of container.</li>
 * <li>CENTER - Children are packed together at <b>mid-height</b> of container.</li>
 * <li>Children are packed together at <b>bottom</b> side of container.</li>
 * </ul>
 */
public abstract class BoxLayout extends Layout {

  protected El innerCt;
  
  private int scrollOffset = 0;
  private String ctCls = "x-box-layout-ct";
  private String innerCls = "x-box-inner";
  private BoxLayoutPack pack;
  private Padding padding = new Padding(0);
  private boolean adjustForFlexRemainder;

  /**
   * BoxLayoutPack enumeration.
   */
  public enum BoxLayoutPack {
    /**
     * Children are packed together at <b>top</b> side of container.
     */
    START,
    /**
     * Children are packed together at <b>mid-height</b> of container.
     */
    CENTER,
    /**
     * Children are packed together at <b>bottom</b> side of container.
     */
    END
  }

  public BoxLayout() {
    monitorResize = true;
    setExtraStyle("x-box-item");
  }

  /**
   * Returns the padding.
   * 
   * @return the padding
   */
  public Padding getPadding() {
    return padding;
  }

  /**
   * Returns the layouts pack value.
   * 
   * @return the pack value
   */
  public BoxLayoutPack getPack() {
    return pack;
  }

  /**
   * Returns the scroll offset.
   * 
   * @return the scroll offset
   */
  public int getScrollOffset() {
    return scrollOffset;
  }

  /**
   * Returns true if the remaining space after flex calculation is applied to the last component being flexed.
   * 
   * @return true if adjusting for flex remainder
   */
  public boolean isAdjustForFlexRemainder() {
    return adjustForFlexRemainder;
  }

  /**
   * Set to true if the remaining space after flex calculation should be applied to the last component being flexed.
   * 
   * @param adjustForFlexRemainder true to add the space
   */
  public void setAdjustForFlexRemainder(boolean adjustForFlexRemainder) {
    this.adjustForFlexRemainder = adjustForFlexRemainder;
  }

  /**
   * Sets how the child items of the container are packed together.
   * 
   * @param pack the pack value
   */
  public void setPack(BoxLayoutPack pack) {
    this.pack = pack;
  }

  /**
   * Sets the padding to be applied to all child items managed by this
   * container's layout (defaults to 0).
   * 
   * @param padding the padding
   */
  public void setPadding(Padding padding) {
    this.padding = padding;
  }

  /**
   * Sets the scroll offset (defaults to 0).
   * 
   * @param scrollOffset the scroll offset
   */
  public void setScrollOffset(int scrollOffset) {
    this.scrollOffset = scrollOffset;
  }

  @Override
  protected boolean isValidParent(Element elem, Element parent) {
    return elem.getParentElement() == innerCt.dom;
  }

  @Override
  protected void onLayout(Container<?> container, El target) {

    if (innerCt == null) {
      target.addStyleName(ctCls);

      // the innerCt prevents wrapping and shuffling while
      // the container is resizing
      Element div = DOM.createDiv();
      div.setClassName(innerCls);
      innerCt = target.appendChild(div);
    }
    renderAll(container, innerCt);
  }

}

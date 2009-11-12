/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Container;

/**
 * Inherits the anchoring of {@link AnchorLayout} and adds the ability for left
 * / top positioning using the <code>AbsoluteData</code> left and top
 * properties.
 * 
 * <p />
 * Child Widgets are:
 * <ul>
 * <li><b>Sized</b> : Yes - relative to parent container.</li>
 * <li><b>Positioned</b> : Yes - using left and top.</li>
 * </ul>
 * 
 * @see AbsoluteData
 */
public class AbsoluteLayout extends AnchorLayout {

  public AbsoluteLayout() {
    setExtraStyle("x-abs-layout-item");
  }

  /**
   * Sets the component's position.
   * 
   * @param c the component
   * @param left the left value
   * @param top the top value
   */
  public void setPosition(Component c, int left, int top) {
    AbsoluteData ad = (AbsoluteData) ComponentHelper.getLayoutData(c);
    if (ad == null) {
      ad = new AbsoluteData();
      ComponentHelper.setLayoutData(c, ad);
    }
    ad.setLeft(left);
    ad.setTop(top);

    if (container.isRendered() && c.isRendered()) {
      if (c instanceof BoxComponent) {
        BoxComponent box = (BoxComponent) c;
        box.setPosition(left, top);
      } else {
        if (left != -1) {
          c.el().setLeft(left);
        }
        if (top != -1) {
          c.el().setTop(top);
        }
      }
    }
  }

  @Override
  protected void onLayout(Container<?> container, El target) {
    super.onLayout(container, target);
    target.makePositionable();
    for (int i = 0; i < container.getItemCount(); i++) {
      Component c = container.getItem(i);
      LayoutData data = ComponentHelper.getLayoutData(c);
      if (data != null && data instanceof AbsoluteData) {
        AbsoluteData ad = (AbsoluteData) data;
        setPosition(c, ad.getLeft(), ad.getTop());
      }
    }
  }

  @Override
  protected void renderComponent(Component component, int index, El target) {
    super.renderComponent(component, index, target);
    component.el().makePositionable(true);
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.Layout;

/**
 * This is a base class for layouts that contain a single item that
 * automatically expands to fill the layout's container.
 * 
 * <p />
 * Child Widgets are:
 * <ul>
 * <li><b>Sized</b> : Yes - expands to fill parent container</li>
 * <li><b>Positioned</b> : No</li>
 * </ul>
 * 
 * <p />
 * In the following code, the child panel will be sized to 400 by 400 when the
 * parent container is sized:
 * 
 * <code><pre>
   LayoutContainer container = new LayoutContainer();
   container.setLayout(new FitLayout());
  
   ContentPanel panel = new ContentPanel();
   container.add(panel);
  
   container.setSize(400, 400);
 * </pre></code>
 * 
 * @see FitData
 */
public class FitLayout extends Layout {

  /**
   * Creates a new fit layout instance.
   */
  public FitLayout() {
    monitorResize = true;
  }

  @Override
  protected void onLayout(Container<?> container, El target) {
    if (container.getItemCount() == 0) {
      return;
    }
    activeItem = activeItem != null ? activeItem : container.getItem(0);
    super.onLayout(container, target);

    setItemSize(activeItem, target.getStyleSize());
  }

  protected void setItemSize(Component item, Size size) {
    if (item != null && item.isRendered() && size.height > 0) {
      size.width -= getSideMargins(item);
      size.height -= item.el().getMargins("tb");
      setSize(item, size.width, size.height);
    }
  }

}
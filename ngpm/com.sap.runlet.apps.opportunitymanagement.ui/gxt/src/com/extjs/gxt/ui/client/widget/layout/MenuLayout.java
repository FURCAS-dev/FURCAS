/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * Custom layout for <code>Menu</code>
 */
public class MenuLayout extends Layout {

  protected void renderComponent(Component c, int index, El target) {

    if (c != null && !c.isRendered()) {

      Element li = DOM.createElement("li");
      li.setId("x-menu-el-" + c.getId());
      li.setClassName("x-menu-list-item");
      if (GXT.isAriaEnabled()) {
        Accessibility.setRole(li, "presentation");
      }

      target.insertChild(li, index);
      c.render(li);
      boolean needsIcon = (c instanceof Field) || (c instanceof ContentPanel);
      if (needsIcon) {
        c.el().getParent().addStyleName("x-menu-list-item-indent");
      }
    } else if (c != null && !isValidParent(c.getElement(), target.dom)) {
      c.el().insertInto(target.dom, index);
    }
  }

  protected boolean isValidParent(Element elem, Element parent) {
    return fly(elem).findParent("li.x-menu-list-item", 5).getParent().dom == parent;
  }

  protected void onLayout(Container<?> container, El target) {
    renderAll(container, target);
    doAutoSize();

    cleanup(target);
  }

  protected void cleanup(El target) {
    NodeList<Node> cn = target.dom.getChildNodes();
    for (int i = cn.getLength() - 1; i >= 0; i--) {
      if (cn.getItem(i).getFirstChild() == null) {
        target.dom.removeChild(cn.getItem(i));
      }
    }
  }

  protected void doAutoSize() {
    int w = getStaticMenuWidth((Menu) container);

    if (w != Style.DEFAULT) {
      container.setWidth(w);
    } else {
      int minWidth = ((Menu) container).getMinWidth();
      int width = container.getLayoutTarget().getWidth()
          + container.el().getFrameWidth("lr");
      container.setWidth(width < minWidth ? minWidth : width);
    }
  }

  private native int getStaticMenuWidth(Menu c) /*-{
    return parseInt(c.@com.extjs.gxt.ui.client.widget.BoxComponent::width, 10)||@com.extjs.gxt.ui.client.Style::DEFAULT;
  }-*/;

}

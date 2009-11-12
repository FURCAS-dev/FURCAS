/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.google.gwt.user.client.ui.Widget;

/**
 * Provides access to package protected methods of component and widget.
 */
public class ComponentHelper {

  public static void doAttach(Widget widget) {
    if (widget != null && !widget.isAttached()) {
      if (widget instanceof Component) {
        ((Component) widget).onAttach();
      } else {
        doAttachNative(widget);
      }
    }
  }

  public static void doDetach(Widget widget) {
    if (widget != null && widget.isAttached()) {
      if (widget instanceof Component) {
        ((Component) widget).onDetach();
      } else {
        doDetachNative(widget);
      }
    }
  }

  public static LayoutData getLayoutData(Component c) {
    return c.getLayoutData();
  }

  public static void setLayoutData(Component c, LayoutData data) {
    c.setLayoutData(data);
  }

  public static void setModel(Component c, ModelData model) {
    c.setModel(model);
  }

  static native void doAttachNative(Widget widget) /*-{
    widget.@com.google.gwt.user.client.ui.Widget::onAttach()();
  }-*/;

  static native void doDetachNative(Widget widget) /*-{
    widget.@com.google.gwt.user.client.ui.Widget::onDetach()();
  }-*/;
}

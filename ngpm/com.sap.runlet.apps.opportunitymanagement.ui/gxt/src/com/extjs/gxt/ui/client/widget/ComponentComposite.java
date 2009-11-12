/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * A GWT <code>Composite</code> subclass that handles GXT lazy rendering. This
 * class is intended to only be used when working with the GWT Composite widget.
 * The GXT {@link Composite} us preferred as it is a GXT Component subclass.
 * 
 * <p />
 * The class should be used when wrapping a component in a GWT Composite class.
 * 
 * @see com.extjs.gxt.ui.client.widget.Composite
 * @see WidgetComponent
 */
public class ComponentComposite extends Composite {

  protected Component component;

  @Override
  protected void initWidget(final Widget widget) {
    if (widget instanceof Component) {
      component = (Component) widget;
      if (!component.isRendered()) {
        component.render(DOM.createDiv());
      }
    }
    super.initWidget(widget);
  }

}

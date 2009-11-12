/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * A <code>Container</code> that lays out its children using a
 * <code>Layout</code>. Layouts are responsible for connecting the child
 * components to the container. Layouts are very flexible as they can create any
 * internal element structure, inserting its child components at any location.
 * For example, a TableLayout lays out its children using HTML tables.
 * 
 * <p/>
 * Many layouts support layout data which are configurable objects that provide
 * additional information to the layout. These objects can be passed when adding
 * and inserting child components into the container. Each layout will document
 * if and what layout data it supports.
 * </p>
 * 
 * Code snippet:
 * 
 * <pre>
 * LayoutContainer container = new LayoutContainer();
 * container.add(new Button(&quot;Click Me&quot;));
 * container.setSize(300, 300);
 * container.setBorders(true);
 * RootPanel.get().add(container);
 * </pre>
 * 
 * {@link FlowLayout} is the the default layout and will be used if not a layout
 * is not specified. You must size/position containers unless they are in an
 * existing container that lays out its children.</p>
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>AfterLayout</b> : ContainerEvent(container)<br>
 * <div>Fires when the widgets in this container are arranged by the associated
 * layout.</div>
 * <ul>
 * <li>container : this</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>ScrollContainer Scroll</dd>
 * <dd>Container BeforeAdd</dd>
 * <dd>Container Add</dd>
 * <dd>Container BeforeRemove</dd>
 * <dd>Container Remove</dd>
 * <dd>BoxComponent Move</dd>
 * <dd>BoxComponent Resize</dd>
 * <dd>Component Enable</dd>
 * <dd>Component Disable</dd>
 * <dd>Component BeforeHide</dd>
 * <dd>Component Hide</dd>
 * <dd>Component BeforeShow</dd>
 * <dd>Component Show</dd>
 * <dd>Component Attach</dd>
 * <dd>Component Detach</dd>
 * <dd>Component BeforeRender</dd>
 * <dd>Component Render</dd>
 * <dd>Component BrowserEvent</dd>
 * <dd>Component BeforeStateRestore</dd>
 * <dd>Component StateRestore</dd>
 * <dd>Component BeforeStateSave</dd>
 * <dd>Component SaveState</dd>
 * </dl>
 * 
 * @see Layout
 */
public class LayoutContainer extends ScrollContainer<Component> {

  /**
   * Creates a new layout container.
   */
  public LayoutContainer() {
    enableLayout = true;
  }

  /**
   * Creates a new layout container.
   * 
   * @param layout the layout
   */
  public LayoutContainer(Layout layout) {
    this();
    setLayout(layout);
  }

  /**
   * Adds a widget to this Container. Fires the <i>BeforeAdd</i> event before
   * adding, then fires the <i>Add</i> event after the component has been added.
   * 
   * @param widget the widget to add. If the widget is not a Component instance
   *          it will be wrapped in a WidgetComponent
   */
  public boolean add(Widget widget) {
    return insert(widget, getItemCount());
  }

  /**
   * Adds a widget to this Container. Fires the <i>BeforeAdd</i> event before
   * adding, then fires the <i>Add</i> event after the component has been added.
   * 
   * @param widget the widget to add. If the widget is not a Component instance
   *          it will be wrapped in a WidgetComponent
   * @param layoutData the layout data
   */
  public boolean add(Widget widget, LayoutData layoutData) {
    return insert(widget, getItemCount(), layoutData);
  }

  /**
   * Creates a new HTML instance and adds it to the container. Fires the
   * <i>BeforeAdd</i> event before adding, then fires the <i>Add</i> event after
   * the component has been added.
   * 
   * @param text the html text
   * @return the new HTML instance
   */
  public Html addText(String text) {
    Html html = new Html(text);
    if (add(html)) {
      return html;
    } else {
      return null;
    }
  }

  /**
   * Returns the widget component that wraps the given widget.
   * 
   * @param widget the wrapped widget
   * @return the component or null
   */
  public WidgetComponent findComponent(Widget widget) {
    for (Component c : getItems()) {
      if (c instanceof WidgetComponent) {
        WidgetComponent wc = (WidgetComponent) c;
        if (widget == wc.getWidget()) {
          return wc;
        }
      }
    }
    return null;
  }

  /**
   * Returns the layout which is associated with the container, or
   * <code>null</code> if one has not been set.
   * 
   * @return the container's layout or <code>null</code>
   */
  public Layout getLayout() {
    return super.getLayout();
  }

  /**
   * Override this method to specify the element to be used by the layout as the
   * container. Allows the container to be decorated.
   * 
   * @return the element to be used as the panel's container
   */
  public El getLayoutTarget() {
    return el();
  }

  @Override
  public int getWindowResizeDelay() {
    return super.getWindowResizeDelay();
  }

  /**
   * Inserts a widget into this Container at a specified index. Fires the
   * <i>BeforeAdd</i> event before inserting, then fires the <i>Add</i> event
   * after the component has been inserted.
   * 
   * @param widget the widget to insert. If the widget is not a Component
   *          instance it will be wrapped in a WidgetComponent
   * @param index the index at which the component will be inserted in
   */
  public boolean insert(Widget widget, int index) {
    return super.insert(wrapWidget(widget), index);
  }

  /**
   * Inserts a widget into this Container at a specified index. Fires the
   * <i>BeforeAdd</i> event before inserting, then fires the <i>Add</i> event
   * after the component has been inserted.
   * 
   * @param widget the widget to insert. If the widget is not a Component
   *          instance it will be wrapped in a WidgetComponent
   * @param index the index at which the component will be inserted in
   * @param layoutData the component's layout data
   */
  public boolean insert(Widget widget, int index, LayoutData layoutData) {
    Component component = wrapWidget(widget);
    if (layoutData != null) {
      component.setLayoutData(layoutData);
    }
    boolean added = super.insert(component, index);
    return added;
  }

  /**
   * Returns <code>true</code> if the layout will be executed when widgets are
   * added or removed.
   * 
   * @return the layout on change state
   */
  public boolean isLayoutOnChange() {
    return layoutOnChange;
  }

  @Override
  public boolean isMonitorWindowResize() {
    return super.isMonitorWindowResize();
  }
  
  @Override
  public boolean layout() {
    return super.layout();
  }

  @Override
  public boolean layout(boolean force) {
    return super.layout(force);
  }

  /**
   * Removes a component from this container. Fires the 'BeforeRemove' event
   * before removing, then fires the 'Remove' event after the component has been
   * removed.
   * 
   * @param widget the widget to remove
   */
  public boolean remove(Widget widget) {
    Component c = null;
    if (!(widget instanceof Component)) {
      c = findComponent(widget);
    } else {
      c = (Component) widget;
    }
    if (c == null) {
      return false;
    }
    return super.remove(c);
  }

  /**
   * Removes all of children from this container.
   */
  public boolean removeAll() {
    return super.removeAll();
  }

  /**
   * Sets the container's layout.
   * 
   * @param layout the new layout
   */
  public void setLayout(Layout layout) {
    super.setLayout(layout);
  }

  /**
   * Sets the component's layout data.
   * 
   * @param component the component
   * @param layoutData the layout data
   */
  public void setLayoutData(Component component, LayoutData layoutData) {
    ComponentHelper.setLayoutData(component, layoutData);
  }

  /**
   * Specifies if the container's layout should be called when widgets are added
   * or removed. Default value is <code>false</code>.
   * 
   * @param layoutOnChange <code>true</code> to enable
   */
  public void setLayoutOnChange(boolean layoutOnChange) {
    this.layoutOnChange = layoutOnChange;
  }

  @Override
  public void setMonitorWindowResize(boolean monitorWindowResize) {
    super.setMonitorWindowResize(monitorWindowResize);
  }

  @Override
  public void setWindowResizeDelay(int delay) {
    super.setWindowResizeDelay(delay);
  }

  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    if (el() == null) {
      setElement(DOM.createDiv(), parent, index);
    }
  }

}

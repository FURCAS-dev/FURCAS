/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Class for any {@link BoxComponent} that can contain other components.
 * Containers handle the basic behavior of containing components, namely
 * managing, attaching, and detaching the child widgets.
 * 
 * <p/>
 * When children are added to a container they are not physically added to the
 * DOM of the container. Subclasses are responsible for connecting the child
 * components.
 * 
 * <p/>
 * Container does not define a root element. setElement must be called by any
 * subclass to ensure the container has an element.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeAdd</b> : ContainerEvent(container, item, index)<br>
 * <div>Fires before a item is added or inserted. Listeners can cancel the
 * action by calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the component being added</li>
 * <li>index : the index at which the component will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>BeforeRemove</b> : ContainerEvent(container, item)<br>
 * <div>Fires before a item is removed. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the component being removed</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Add</b> : ContainerEvent(container, item, index)<br>
 * <div>Fires after a item has been added or inserted.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item that was added</li>
 * <li>index : the index at which the item will be added</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Remove</b> : ContainerEvent(container, item)<br>
 * <div>Fires after a item has been removed.</div>
 * <ul>
 * <li>container : this</li>
 * <li>item : the item being removed</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
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
 * @param <T> the child component type
 */
public abstract class Container<T extends Component> extends BoxComponent {

  /**
   * True to attach the container's children (defaults to true).
   */
  protected boolean attachChildren = true;

  /**
   * False to disable the container's layout, stopping it from executing
   * (defaults to false).
   */
  protected boolean enableLayout;

  /**
   * True to execute the container's layout when children are inserted and
   * removed (defaults to false).
   */
  protected boolean layoutOnChange;

  protected boolean layoutExecuted;
  protected boolean layoutNeeded = true;
  protected boolean layoutOnAttach = true;

  private List<T> items;
  private Layout layout;

  /**
   * Creates a new container.
   */
  public Container() {
    items = new ArrayList<T>();
  }

  @Override
  public void disable() {
    super.disable();
    for (Component c : items) {
      c.disable();
    }
  }

  @Override
  public void enable() {
    super.enable();
    for (Component c : items) {
      c.enable();
    }
  }

  /**
   * Returns the component whose element, or child element, matches the given
   * element.
   * 
   * @param elem the element
   * @return the matching component or <code>null</code> if no match
   */
  public T findItem(Element elem) {
    for (T c : items) {
      if (DOM.isOrHasChild(c.getElement(), elem)) {
        return c;
      }
    }
    return null;
  }

  /**
   * Returns the item at the given index or null if index out of bounds.
   * 
   * @param index the index
   * @return the item
   */
  public T getItem(int index) {
    return index < items.size() ? items.get(index) : null;
  }

  /**
   * Returns the item with the specified item id.
   * 
   * @param itemId the item id
   * @return the button or <code>null</code> if no match
   */
  public T getItemByItemId(String itemId) {
    for (T item : getItems()) {
      if (item.getItemId().equals(itemId)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Returns the number of children.
   * 
   * @return the component count
   */
  public int getItemCount() {
    return items.size();
  }

  /**
   * Returns the child items.
   * 
   * @return the children
   */
  public List<T> getItems() {
    return items;
  }

  /**
   * Returns the container's layout target. Only applies to container's with
   * layouts.
   * 
   * @return the layout target
   */
  public El getLayoutTarget() {
    return el();
  }

  /**
   * Returns the widget at the given index. If the child is a WidgetComponent,
   * the wrapped widget is returned.
   * 
   * @param index the index
   * @return the widget
   */
  public Widget getWidget(int index) {
    Component c = getItem(index);
    if (c != null && c instanceof WidgetComponent) {
      return ((WidgetComponent) c).getWidget();
    }
    return c;
  }

  /**
   * Returns the index of the item.
   * 
   * @param item the item
   * @return the index
   */
  public int indexOf(T item) {
    return items.indexOf(item);
  }

  /**
   * Returns an iterator over the container's children.
   * 
   * @return an iterator
   */
  public Iterator<T> iterator() {
    return items.iterator();
  }

  /**
   * Removes all the container's items.
   * 
   * @return true if all items where removed
   */
  public boolean removeAll() {
    return removeAll(false);
  }

  /**
   * Scrolls the item into view.
   * 
   * @param item the item
   */
  public void scrollIntoView(T item) {
    if (rendered) {
      item.el().scrollIntoView(el().dom, false);
    }
  }

  /**
   * Adds a item to the container. Fires the <i>BeforeAdd</i> event before
   * inserting, then fires the <i>Add</i> event after the widget has been
   * inserted.
   * 
   * @param item the item to be added
   */
  protected boolean add(T item) {
    return insert(item, getItemCount());
  }

  protected int adjustIndex(T child, int beforeIndex) {
    if (child.getParent() == this) {
      int idx = indexOf(child);
      if (idx < beforeIndex) {
        beforeIndex--;
      }
    }
    return beforeIndex;
  }

  /**
   * Sets the child's parent to this container. In order to support lazy
   * rendering this method uses JSNI to simply set the child parent without
   * effecting the attached state of the child.
   * 
   * @param child the child widget
   */
  protected void adopt(T child) {
    setParent(this, child);
  }

  @SuppressWarnings("unchecked")
  protected ContainerEvent createContainerEvent(T item) {
    return new ContainerEvent(this, item);
  }

  @Override
  protected void doAttachChildren() {
    if (attachChildren) {
      for (T item : items) {
        if (item.isRendered() && !item.isAttached()) {
          item.onAttach();
        }
      }
    }
  }

  @Override
  protected void doDetachChildren() {
    if (attachChildren) {
      for (T item : items) {
        if (item.isRendered() && item.isAttached()) {
          item.onDetach();
        }
      }
    }
  }

  protected boolean doLayout() {
    return doLayout(false);
  }

  protected boolean doLayout(boolean force) {
    if (!enableLayout) {
      return false;
    }

    if (layout == null) {
      setLayout(new FlowLayout());
    }

    // execute the layout
    if (force || layoutNeeded) {
      layoutExecuted = true;
      layout.layout();
      if (isVisible()) {
        layoutNeeded = false;
      }
    }

    for (Component c : items) {
      if (attachChildren && c.isRendered()) {
        ComponentHelper.doAttach(c);
      }

      if (c instanceof Composite) {
        c = ((Composite) c).getComponent();
      }

      if (c instanceof LayoutContainer) {
        ((LayoutContainer) c).layout(force);
      } else if (c instanceof Container) {
        Container<?> con = (Container<?>) c;
        if (con.layout != null) {
          con.layout(force);
        }
      } else {
        c.recalculate();
      }
    }

    onAfterLayout();
    fireEvent(Events.AfterLayout, createContainerEvent(null));
    return true;
  }

  protected Layout getLayout() {
    return layout;
  }

  /**
   * Adds a item into the container. Fires the <i>BeforeAdd</i> event before
   * inserting, then fires the <i>Add</i> event after the widget has been
   * inserted.
   * 
   * @param item the item to insert
   * @param index the insert location
   */
  @SuppressWarnings("unchecked")
  protected boolean insert(T item, int index) {
    ContainerEvent containerEvent = createContainerEvent(item);
    containerEvent.setIndex(index);
    if (fireEvent(Events.BeforeAdd, containerEvent)) {
      ComponentEvent componentEvent = item.createComponentEvent(null);
      if (item.fireEvent(Events.BeforeAdopt, componentEvent)) {
        index = adjustIndex(item, index);
        item.removeFromParent();
        items.add(index, item);
        onInsert(item, index);
        adopt(item);
        item.fireEvent(Events.Adopt, componentEvent);
        fireEvent(Events.Add, containerEvent);
        layoutNeeded = true;
        if (isRendered() && layoutOnChange) {
          layout();
        }
        return true;
      }
    }
    return false;
  }

  protected boolean isLayoutNeeded() {
    return layoutNeeded;
  }

  /**
   * Executes the container's layout. If a layout has not been set a
   * <code>FlowLayout</code> will be used.
   * 
   * @return true if layout was executed.
   */
  protected boolean layout() {
    return layout(false);
  }

  /**
   * * Executes the container's layout. If a layout has not been set a
   * <code>FlowLayout</code> will be used.
   * 
   * @param force true to force the layout call, also if caching things it is
   *          not needed
   * @return true if layout was executed.
   */
  protected boolean layout(boolean force) {
    if (!rendered) {
      layoutOnAttach = true;
      return false;
    }

    return doLayout(force);
  }

  protected void onAfterLayout() {
    sync(true);
  }

  @Override
  protected void onAttach() {
    super.onAttach();
    if (!layoutExecuted && layoutOnAttach && !(getParent() instanceof Container)) {
      layout();
    }
  }

  protected void onInsert(T item, int index) {
    if (isAutoHeight() || isAutoWidth()) {
      sync(true);
    }
  }

  protected void onRemove(T item) {
    if (isAutoHeight() || isAutoWidth()) {
      sync(true);
    }
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    layoutNeeded = true;
    for (Component c : items) {
      if (c instanceof Container) {
        ((Container<?>) c).layoutNeeded = true;
      }
    }
  }

  protected final void orphan(T child) {
    assert (child.getParent() == this);
    if (child.isAttached()) {
      ComponentHelper.doDetach(child);
      assert !child.isAttached() : "Failure of " + getClass()
          + " to call super.onDetach()";
    }
    setParent(null, child);
  }

  /**
   * Removes the item from the container. Fires the <i>BeforeRemove</i> event
   * before removing, then fires the <i>Remove</i> event after the widget has
   * been removed.
   * 
   * @param item the item to remove
   * @return <code>true</code> if the item was removed
   */
  protected boolean remove(T item) {
    return remove(item, false);
  }

  @SuppressWarnings("unchecked")
  protected boolean remove(T component, boolean force) {
    ContainerEvent containerEvent = createContainerEvent(component);
    containerEvent.setItem(component);
    containerEvent.setIndex(indexOf(component));
    if (fireEvent(Events.BeforeRemove, containerEvent) || force) {
      ComponentEvent componentEvent = component.createComponentEvent(null);
      if (component.fireEvent(Events.BeforeOrphan, componentEvent) || force) {
        onRemove(component);

        if (attachChildren) {
          if (component.getParent() != this) {
            throw new RuntimeException("component is not a child of this container");
          }
          orphan(component);
        }

        if (rendered) {
          Element elem = component.getElement();
          Element parent = DOM.getParent(elem);
          if (parent != null) {
            DOM.removeChild(parent, elem);
          }
        }

        items.remove(component);

        component.fireEvent(Events.Orphan, componentEvent);
        fireEvent(Events.Remove, containerEvent);
        layoutNeeded = true;
        if (rendered && layoutOnChange) {
          layout();
        }
        return true;
      }
    }
    return false;
  }

  protected boolean removeAll(boolean force) {
    int count = getItemCount();
    for (int i = 0; i < count; i++) {
      remove(getItem(0), force);
    }
    return getItemCount() == 0;
  }

  /**
   * Sets the container's layout.
   * 
   * @param layout the new layout
   */
  protected void setLayout(Layout layout) {
    this.layout = layout;
    layoutNeeded = true;
    layout.setContainer(this);
  }

  protected void setLayoutNeeded(boolean layoutNeeded) {
    this.layoutNeeded = layoutNeeded;
  }

  protected void setLayoutOnChange(boolean change) {
    this.layoutOnChange = change;
  }

  /**
   * Helper Method for the subclasses that wish to support automatic wrapping of
   * Widget instances in WidgetComponents
   * 
   * <p/>
   * If the widget is a component, no wrapping is performed
   * 
   * @param widget the widget to be wrapped
   * @return the new component
   */
  protected Component wrapWidget(Widget widget) {
    if (widget instanceof Component) {
      return (Component) widget;
    } else {
      return new WidgetComponent(widget);
    }
  }

  private native void setParent(Widget parent, Widget child) /*-{
    child.@com.google.gwt.user.client.ui.Widget::parent = parent;
  }-*/;
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.ScrollListener;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * A <code>Container</code> that scrolls its contents. The container is created
 * with scrolling disabled.
 * 
 * <dl>
 * <dt>Events:</dt>
 * <dd><b>Scroll</b> : ComponentEvent(component)<br>
 * <div>Fires when the container is scrolled.</div>
 * <ul>
 * <li>component : this</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
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
 */
public class ScrollContainer<T extends Component> extends Container<T> {

  private Scroll scrollMode = Scroll.NONE;
  private int scrollLeft = Style.DEFAULT;
  private int scrollTop = Style.DEFAULT;

  /**
   * Adds a listener to receive scroll events.
   * 
   * @param listener the listener to be added
   */
  public void addScrollListener(ScrollListener listener) {
    addListener(Events.Scroll, listener);
  }

  /**
   * Returns the horizontal scroll position.
   * 
   * @return the horizontal scroll position
   */
  public int getHScrollPosition() {
    if (rendered) {
      return getLayoutTarget().getScrollLeft();
    } else {
      return scrollLeft != Style.DEFAULT ? scrollLeft : 0;
    }
  }

  /**
   * Returns the scroll model.
   * 
   * @return the scroll mode
   */
  public Scroll getScrollMode() {
    return scrollMode;
  }

  /**
   * Returns the vertical scroll position.
   * 
   * @return the vertical scroll position
   */
  public int getVScrollPosition() {
    if (rendered) {
      return getLayoutTarget().getScrollTop();
    } else {
      return scrollTop != Style.DEFAULT ? scrollTop : 0;
    }
  }

  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    if (ce.getEventTypeInt() == Event.ONSCROLL) {
      fireEvent(Events.Scroll, new ComponentEvent(this));
    }
  }

  /**
   * Removes a previously added listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeScrollListener(ScrollListener listener) {
    removeListener(Events.Scroll, listener);
  }

  /**
   * Scroll the child into view.
   * 
   * @param child the child widget
   */
  public void scrollIntoView(Widget child) {
    fly(child.getElement()).scrollIntoView(getLayoutTarget().dom, true);
  }

  /**
   * Sets the horizontal scroll position.
   * 
   * @param position the new horizontal scroll position
   */
  public void setHScrollPosition(int position) {
    scrollLeft = position;
    if (rendered) {
      getLayoutTarget().setScrollLeft(position);
    }
  }

  /**
   * Sets the container's scroll mode.
   * 
   * @param scroll the scroll mode
   */
  public void setScrollMode(Scroll scroll) {
    this.scrollMode = scroll;
    if (rendered) {
      switch (scroll) {
        case AUTO:
        case ALWAYS:
        case NONE:
          getLayoutTarget().setStyleAttribute("overflow", scrollMode.value().toLowerCase());
          break;
        case AUTOX:
          getLayoutTarget().setStyleAttribute("overflowX", scrollMode.value().toLowerCase());
          getLayoutTarget().setStyleAttribute("overflowY", "hidden");
          break;
        case AUTOY:
          getLayoutTarget().setStyleAttribute("overflowY", scrollMode.value().toLowerCase());
          getLayoutTarget().setStyleAttribute("overflowX", "hidden");
          break;
      }

    }
  }

  /**
   * Sets the vertical scroll position.
   * 
   * @param position the new horizontal scroll position, in pixels
   */
  public void setVScrollPosition(int position) {
    scrollTop = position;
    if (rendered) {
      getLayoutTarget().setScrollTop(position);
    }
  }

  protected void afterRender() {
    if (scrollLeft != Style.DEFAULT) {
      setHScrollPosition(scrollLeft);
    }
    if (scrollTop != Style.DEFAULT) {
      setVScrollPosition(scrollTop);
    }
    if (scrollMode != Scroll.NONE) {
      setScrollMode(scrollMode);
    }
    getLayoutTarget().addEventsSunk(Event.ONSCROLL);
    super.afterRender();
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.button;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * A simple css styled button with 3 states: normal, over, and disabled.
 * 
 * <p />
 * Note: To change the icon style after construction use
 * {@link #changeStyle(String)}.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Select</b> : IconButtonEvent(iconButton, event)<br>
 * <div>Fires after the item is selected.</div>
 * <ul>
 * <li>iconButton : this</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
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
 */
public class IconButton extends BoxComponent {

  protected String style;
  protected boolean cancelBubble = true;

  /**
   * Creates a new icon button. When using the default constructor,
   * {@link #changeStyle(String)} must be called to initialize the button.
   */
  public IconButton() {
    this("");
  }

  /**
   * Creates a new icon button. The 'over' style and 'disabled' style names
   * determined by adding '-over' and '-disabled' to the base style name.
   * 
   * @param style the base style
   */
  public IconButton(String style) {
    this.style = style;
  }

  /**
   * Creates a new icon button. The 'over' style and 'disabled' style names
   * determined by adding '-over' and '-disabled' to the base style name.
   * 
   * @param style the base style
   * @param listener the click listener
   */
  public IconButton(String style, SelectionListener<IconButtonEvent> listener) {
    this(style);
    addSelectionListener(listener);
  }

  /**
   * @param listener
   */
  public void addSelectionListener(SelectionListener<IconButtonEvent> listener) {
    addListener(Events.Select, listener);
  }

  /**
   * Changes the icon style.
   * 
   * @param style the new icon style
   */
  public void changeStyle(String style) {
    removeStyleName(this.style);
    removeStyleName(this.style + "-over");
    removeStyleName(this.style + "-disabled");
    addStyleName(style);
    this.style = style;
  }

  public void onComponentEvent(ComponentEvent ce) {
    switch (ce.getEventTypeInt()) {
      case Event.ONMOUSEOVER:
        addStyleName(style + "-over");
        break;
      case Event.ONMOUSEOUT:
        removeStyleName(style + "-over");
        break;
      case Event.ONCLICK:
        onClick(ce);
        break;
    }
  }

  /**
   * Removes a previously added listener.
   * 
   * @param listener the listener to be removed
   */
  public void removeSelectionListener(SelectionListener<ButtonEvent> listener) {
    removeListener(Events.Select, listener);
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    return new IconButtonEvent(this, event);
  }

  protected void onClick(ComponentEvent ce) {
    if (cancelBubble) {
      ce.cancelBubble();
    }
    removeStyleName(style + "-over");
    fireEvent(Events.Select, ce);
  }

  protected void onDisable() {
    addStyleName(style + "-disabled");
  }

  protected void onEnable() {
    removeStyleName(style + "-disabled");
  }

  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
    addStyleName("x-icon-btn");
    addStyleName("x-nodrag");
    addStyleName(style);
    sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS);
    super.onRender(target, index);
  }

}

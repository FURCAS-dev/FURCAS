/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.button;

import java.util.List;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ComponentManager;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * A 2-state toggle button.
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>Toggle</b> : ButtonEvent(button)<br>
 * <div>Fires when the "pressed" state of this button changes.</div>
 * <ul>
 * <li>button : this</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class ToggleButton extends Button {

  private boolean pressed;
  private String toggleGroup;
  private boolean allowDepress = true;

  /**
   * Creates a new toggle button.
   */
  public ToggleButton() {
    super();
  }

  /**
   * Creates a new toggle button.
   * 
   * @param text the button text
   */
  public ToggleButton(String text) {
    super(text);
  }

  /**
   * Creates a new toggle button.
   * 
   * @param text the button text
   * @param listener a selection listener
   */
  public ToggleButton(String text, SelectionListener<ButtonEvent> listener) {
    super(text, listener);
  }

  /**
   * Returns the toggle group name.
   * 
   * @return the toggle group name
   */
  public String getToggleGroup() {
    return toggleGroup;
  }

  public boolean isAllowDepress() {
    return allowDepress;
  }

  /**
   * Returns true if the button is pressed.
   * 
   * @return the pressed state
   */
  public boolean isPressed() {
    return pressed;
  }

  /**
   * Toggles the current state.
   */
  public void toggle() {
    toggle(!pressed);
  }

  /**
   * Sets the current pressed state.
   * 
   * @param state true to set pressed state
   */
  public void toggle(boolean state) {
    this.pressed = state;
    if (rendered) {
      ButtonEvent be = new ButtonEvent(this);
      el().setStyleName("x-btn-pressed", state);
      if (state) {
        onBlur(null);
        removeStyleName(baseStyle + "-over");
      } else {
        onFocus(null);
      }
      if (state && toggleGroup != null && toggleGroup.length() > 0) {
        List<ToggleButton> list = ComponentManager.get().get(ToggleButton.class);
        for (ToggleButton tb : list) {
          if (tb != this && tb.getToggleGroup() != null
              && tb.getToggleGroup().equals(toggleGroup)) {
            tb.toggle(false);
          }
        }
      }
      Accessibility.setState(buttonEl.dom, "aria-pressed", "" + state);
      fireEvent(Events.Toggle, be);
    }
  }

  /**
   * True to allow a toggle item to be depressed (default to true).
   * 
   * @param allowDepress true to allow depressing
   */
  public void setAllowDepress(boolean allowDepress) {
    this.allowDepress = allowDepress;
  }

  /**
   * Optionally, set the the button's toggle group name.
   * 
   * @param toggleGroup the toggle group name
   */
  public void setToggleGroup(String toggleGroup) {
    this.toggleGroup = toggleGroup;
  }

  @Override
  protected void onClick(ComponentEvent ce) {
    ce.stopEvent();
    focus();
    hideToolTip();
    if (!disabled) {
      if (allowDepress || !pressed) {
        toggle();
      }
      if (menu != null && !menu.isVisible()) {
        showMenu();
      }
      ButtonEvent be = new ButtonEvent(this);
      be.setEvent(ce.getEvent());
      fireEvent(Events.Select, be);
    }
  }

  @Override
  protected void onFocus(ComponentEvent ce) {
    if (!pressed) {
      super.onFocus(ce);
    }
  }

  @Override
  protected void onMouseDown(ComponentEvent ce) {
    // do nothing
  }

  @Override
  protected void onMouseOver(ComponentEvent ce) {
    if (!pressed) {
      super.onMouseOver(ce);
    }
  }

  @Override
  protected void onMouseUp(ComponentEvent ce) {
    // do nothing
  }

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    if (pressed) {
      toggle(pressed);
    }
  }
}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.menu.Menu;

/**
 * Button event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see Button
 */
public class ButtonEvent extends BoxComponentEvent {

  /**
   * The source button.
   */
  private Button button;

  /**
   * The button's menu.
   */
  private Menu menu;

  /**
   * Creates a new button event.
   * 
   * @param button the source button
   */
  public ButtonEvent(Button button) {
    super(button);
    this.button = button;
  }

  /**
   * Returns the source button.
   * 
   * @return the button
   */
  public Button getButton() {
    return button;
  }

  /**
   * Returns the button's menu.
   * 
   * @return the menu
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * Sets the button's menu
   * 
   * @param menu the menu
   */
  public void setMenu(Menu menu) {
    this.menu = menu;
  }

}

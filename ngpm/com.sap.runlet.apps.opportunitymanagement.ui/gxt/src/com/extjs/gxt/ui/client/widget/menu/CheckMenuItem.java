/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.Element;

/**
 * Adds a menu item that contains a checkbox by default, but can also be part of
 * a radio group.
 * 
 * A horizontal row of buttons.
 * 
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>BeforeCheckChange</b> : MenuEvent(menu, item)<br>
 * <div>Fires before the item is checked or unchecked.</div>
 * <ul>
 * <li>item : this</li>
 * <li>menu : the parent menu</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>CheckChange</b> : MenuEvent(menu, item)<br>
 * <div>Fires after the item is checked or unchecked.</div>
 * <ul>
 * <li>item : this</li>
 * <li>menu : the parent menu</li>
 * </ul>
 * </dd> </dt>
 */
public class CheckMenuItem extends MenuItem {

  private String groupStyle = "x-menu-group-item";
  private boolean checked;
  private String group;

  /**
   * Creates a new check menu item.
   */
  public CheckMenuItem() {
    hideOnClick = true;
    itemStyle = "x-menu-item x-menu-check-item";
    canActivate = true;
  }

  /**
   * Creates a new check menu item.
   * 
   * @param text the text
   */
  public CheckMenuItem(String text) {
    this();
    setText(text);
  }

  /**
   * Returns the group name.
   * 
   * @return the name
   */
  public String getGroup() {
    return group;
  }

  /**
   * Returns the group style.
   * 
   * @return the group style
   */
  public String getGroupStyle() {
    return groupStyle;
  }

  /**
   * Returns true if the item is checked.
   * 
   * @return the checked state
   */
  public boolean isChecked() {
    return checked;
  }

  /**
   * Set the checked state of this item.
   * 
   * @param checked the new checked state
   */
  public void setChecked(boolean checked) {
    setChecked(checked, false);
  }

  /**
   * Set the checked state of this item.
   * 
   * @param state the new checked state
   * @param supressEvent true to prevent the CheckChange event from firing
   */
  public void setChecked(boolean state, boolean supressEvent) {
    if (!rendered) {
      this.checked = state;
      return;
    }
    MenuEvent me = new MenuEvent(parentMenu);
    me.setItem(this);
    if (supressEvent || fireEvent(Events.BeforeCheckChange, me)) {

      if (getGroup() == null) {
        setIcon(state ? GXT.IMAGES.checked()
            : GXT.IMAGES.unchecked());
      } else {
        setIcon(state ? GXT.IMAGES.group_checked() : null);
      }
      checked = state;
      if (!supressEvent) {
        fireEvent(Events.CheckChange, me);
      }
    }
  }

  /**
   * All check items with the same group name will automatically be grouped into
   * a single-select radio button group (defaults to null).
   * 
   * @param group the group
   */
  public void setGroup(String group) {
    this.group = group;
  }

  /**
   * The default CSS class to use for radio group check items (defaults to
   * "x-menu-group-item").
   * 
   * @param groupStyle the group style
   */
  public void setGroupStyle(String groupStyle) {
    if (rendered) {
      el().removeStyleName(this.groupStyle);
      el().addStyleName(groupStyle);
    }
    this.groupStyle = groupStyle;
  }

  protected void onClick(ComponentEvent ce) {
    if (!disabled && getGroup() == null) {
      setChecked(!checked);
    }
    if (!disabled && !checked && getGroup() != null) {
      setChecked(!checked);
      onRadioClick(ce);
    }
    super.onClick(ce);
  }

  protected void onRadioClick(ComponentEvent ce) {
    if (parentMenu != null) {
      for (Component item : parentMenu.getItems()) {
        if (item instanceof CheckMenuItem) {
          CheckMenuItem check = (CheckMenuItem) item;
          if (check != this && check.isChecked()) {
            check.setChecked(false);
          }
        }
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    if (getGroup() != null) {
      setGroupStyle(groupStyle);
    }
    setChecked(checked, true);

  }

}

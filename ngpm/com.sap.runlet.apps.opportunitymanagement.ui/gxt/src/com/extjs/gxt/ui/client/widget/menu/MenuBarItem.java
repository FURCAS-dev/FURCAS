/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.menu;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * Child of MenuBar.
 */
public class MenuBarItem extends Component {

  protected Menu menu;
  protected boolean expanded;
  private String text;

  public MenuBarItem(String text, Menu menu) {
    baseStyle = "x-menubar-item";
    this.text = text;
    this.menu = menu;
    assert (menu != null);
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
    if (rendered) {
      getElement().setInnerHTML(text);
    }
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createDiv(), target, index);
    setStyleAttribute("display", "inline");
    setText(text);

    if (GXT.isAriaEnabled()) {
      // el().setTabIndex(-1);
      Accessibility.setRole(getElement(), Accessibility.ROLE_MENUITEM);
      Accessibility.setState(getElement(), "aria-haspopup", "true");
    }
  }

}

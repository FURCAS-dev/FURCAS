/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.aria;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.DOM;

public class FocusFrame extends BaseObservable {
  private FocusFrame() {

  }

  private static FocusFrame instance = new FocusFrame();

  private boolean initialized;
  private Component curComponent;
  private El focusFrameContainer;
  private List<El> sides = new ArrayList<El>();

  protected void init() {
    if (!initialized) {
      focusFrameContainer = new El(DOM.createDiv());
      focusFrameContainer.setStyleName("x-aria-focusframe");
      focusFrameContainer.makePositionable();
      focusFrameContainer.hide();

      for (int i = 0; i < 4; i++) {
        El side = new El(DOM.createDiv());
        side.setStyleName("x-aria-focusframe-side");
        focusFrameContainer.dom.appendChild(side.dom);
        side.makePositionable(true);
        sides.add(side);
      }
      initialized = true;
    }
  }

  public static FocusFrame get() {
    return instance;
  }

  public void frame(Component newComponent) {
    if (!GXT.isAriaEnabled()) {
      return;
    }
    if (!initialized) {
      init();
    }

    if (curComponent != newComponent) {
      if (newComponent.isRendered()) {
        curComponent = newComponent;
        curComponent.el().getParent().makePositionable();
        curComponent.el().getParent().dom.appendChild(focusFrameContainer.dom);
        focusFrameContainer.show();
        sync(curComponent);
      }
    }
  }

  public void unframe() {
    if (initialized) {
      focusFrameContainer.hide();
      curComponent = null;
    }
  }

  public void unframe(Component c) {
    if (c == curComponent) {
      unframe();
    }
  }

  public void hide(Component c) {
    if (initialized && c == curComponent) {
      focusFrameContainer.setVisible(false);
    }
  }

  public void show(Component c) {
    if (initialized && c == curComponent) {
      focusFrameContainer.setVisible(true);
      sync(c);
    }
  }

  public void sync(Component c) {
    if (initialized && curComponent == c && c.isRendered()) {
      El el = curComponent.el();
      int width = el.getWidth();
      int height = el.getHeight();

      sides.get(0).setSize(width, 2).alignTo(el.dom, "tl", null);
      sides.get(1).setSize(width, 2).alignTo(el.dom, "bl", new int[] {0, -2});
      sides.get(2).setSize(2, height).alignTo(el.dom, "tr", new int[] {-2, 0});
      sides.get(3).setSize(2, height).alignTo(el.dom, "tl", null);

      for (El side : sides) {
        side.setZIndex(curComponent.el().getZIndex() + 1);
      }
    }
  }
}

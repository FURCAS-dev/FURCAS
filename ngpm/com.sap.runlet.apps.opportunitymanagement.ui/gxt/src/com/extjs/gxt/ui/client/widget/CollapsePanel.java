/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * The collapse state of a content panel.
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
 * <dd>ContentPanel BeforeExpand</dd>
 * <dd>ContentPanel Expand</dd>
 * <dd>ContentPanel BeforeCollapse</dd>
 * <dd>ContentPanel Collapse</dd>
 * <dd>ContentPanel BeforeClose</dd>
 * <dd>ContentPanel Close</dd>
 * <dd>LayoutContainer AfterLayout</dd>
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
 */
public class CollapsePanel extends ContentPanel {

  private ToolButton collapseBtn;
  private BorderLayoutData parentData;
  private boolean expanded;
  private El headerEl;
  private ContentPanel panel;
  private Popup popup;
  private String align;
  private int[] adj;
  private LayoutRegion region;

  /**
   * Creates a new collapse panel.
   * 
   * @param panel the parent content panel
   * @param data the border layout data
   */
  public CollapsePanel(ContentPanel panel, BorderLayoutData data) {
    this.panel = panel;
    this.parentData = data;
    this.region = data.getRegion();
    this.collapse();
    setDeferHeight(false);
  }

  /**
   * Returns the panel's content panel.
   * 
   * @return the content panel
   */
  public ContentPanel getContentPanel() {
    return panel;
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    if (!ce.within(collapseBtn.getElement())) {
      if (ce.getType().getEventCode() == Event.ONCLICK) {
        setExpanded(!expanded);
      }
    }
    switch (ce.getType().getEventCode()) {
      case Event.ONMOUSEOVER:
        addStyleName("x-layout-collapsed-over");
        break;
      case Event.ONMOUSEOUT:
        removeStyleName("x-layout-collapsed-over");
        break;
    }
  }

  public void setExpanded(boolean expanded) {
    ContentPanel panel = (ContentPanel) getData("panel");
    if (!this.expanded && expanded) {
      onShowPanel(panel);
    } else if (this.expanded && !expanded) {
      onHidePanel(panel);
    }
  }

  protected void afterHidePanel(ContentPanel panel) {
  }

  protected void afterShowPanel(ContentPanel panel) {
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    collapseBtn.onAttach();
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(collapseBtn);
  }

  @Override
  protected void onExpand() {
    panel.getHeader().show();
  }

  protected void onExpandButton(BaseEvent be) {

  }

  protected void onHidePanel(ContentPanel panel) {
    this.expanded = false;
    if (popup != null) {
      panel.body.removeStyleName("x-panel-popup-body");
      panel.getHeader().show();
      popup.hide();
      panel.setStyleAttribute("margin", "0px");
      afterHidePanel(panel);

      SplitBar bar = (SplitBar) panel.getData("splitBar");
      if (bar != null) {
        bar.enable();
      }
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    el().removeChildren();
    String txt = "";

    LayoutRegion r = parentData.getRegion();

    if (r == LayoutRegion.NORTH || r == LayoutRegion.SOUTH) {
      txt = panel.getHeader().getText();
    }
    headerEl = el().createChild(
        "<div class=x-panel-header><span class=x-pnael-header-text>" + txt + "</span></div>");

    String icon = null;
    adj = new int[] {0, 0};
    switch (parentData.getRegion()) {
      case WEST:
        icon = "right";
        align = "tl-tr";
        adj = new int[] {0, 24};
        break;
      case EAST:
        icon = "left";
        align = "tr-tl";
        adj = new int[] {0, 24};
        break;
      case NORTH:
        icon = "down";
        align = "tl-bl";
        break;
      case SOUTH:
        icon = "up";
        align = "bl-tl";
        break;
    }

    if (r == LayoutRegion.NORTH || region == LayoutRegion.SOUTH) {
      headerEl.setStyleAttribute("background", "none");
    }

    headerEl.setStyleAttribute("cursor", "default");

    setStyleName("x-layout-collapsed");
    collapseBtn = new ToolButton("x-tool-" + icon);
    collapseBtn.render(headerEl.dom, 0);

    collapseBtn.addListener(Events.Select, new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent ce) {
        if (expanded) {
          setExpanded(false);
        }
        onExpandButton(ce);
      }
    });

    if (parentData.isFloatable()) {
      el().addEventsSunk(Event.MOUSEEVENTS | Event.ONCLICK);
    }
    el().setVisibility(true);

    sinkEvents(Event.MOUSEEVENTS);
  }

  protected void onShowPanel(ContentPanel panel) {
    this.expanded = true;
    Rectangle box = getBounds(false);

    SplitBar bar = (SplitBar) panel.getData("splitBar");
    if (bar != null) {
      bar.disable();
    }

    popup = new Popup() {
      protected boolean onAutoHide(Event event) {
        setExpanded(false);
        return false;
      }
    };

    popup.getIgnoreList().add(collapseBtn.getElement());
    popup.getIgnoreList().add(getElement());
    popup.getIgnoreList().add(panel.getElement());
    popup.setStyleName("x-layout-popup");
    popup.setLayout(new FillLayout());
    popup.setShadow(true);

    int hh = fly(el().firstChild().dom).getHeight();

    panel.el().setLeftTop(0, 0);
    panel.setBorders(false);
    panel.getHeader().hide();
    panel.body.addStyleName("x-panel-popup-body");

    popup.add(panel);

    int w = 0;
    int h = 0;

    switch (region) {
      case WEST:
      case EAST:
        w = (int) parentData.getSize();
        h = box.height - hh;
        break;
      case NORTH:
      case SOUTH:
        w = box.width;
        h = (int) parentData.getSize();
    }

    popup.setSize(w, h);
    popup.show(getElement(), align, adj);
    popup.layout();

    afterShowPanel(panel);
  }
}

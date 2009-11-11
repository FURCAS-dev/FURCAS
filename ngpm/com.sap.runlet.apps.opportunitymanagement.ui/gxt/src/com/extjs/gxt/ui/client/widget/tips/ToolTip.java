/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tips;

import java.util.Date;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.util.Region;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Component;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;

/**
 * A standard tooltip implementation for providing additional information when
 * hovering over a target element.
 */
public class ToolTip extends Tip {

  protected Component target;
  protected Point targetXY = new Point(0, 0);

  protected Timer dismissTimer;
  protected Timer showTimer;
  protected Timer hideTimer;

  protected String anchorStyle;
  protected El anchorEl;

  private Date lastActive;

  protected String title, text;

  protected Listener<ComponentEvent> listener;

  protected ToolTipConfig toolTipConfig;

  /**
   * Creates a new tool tip.
   */
  public ToolTip() {
    toolTipConfig = new ToolTipConfig();
    hidden = true;
    lastActive = new Date();
  }

  /**
   * Creates a new tool tip.
   * 
   * @param target the target widget
   */
  public ToolTip(Component target) {
    this();
    initTarget(target);
  }

  /**
   * Creates a new tool tip for the given target.
   * 
   * @param target the target widget
   */
  public ToolTip(Component target, ToolTipConfig config) {
    this();
    updateConfig(config);
    initTarget(target);
  }

  public ToolTipConfig getToolTipConfig() {
    return toolTipConfig;
  }

  @Override
  public void hide() {
    clearTimers();
    lastActive = new Date();
    super.hide();
  }

  public void initTarget(final Component target) {
    if (this.target != null) {
      this.target.addListener(Events.OnMouseOver, listener);
      this.target.addListener(Events.OnMouseOut, listener);
      this.target.addListener(Events.OnMouseMove, listener);
      this.target.addListener(Events.Hide, listener);
      this.target.addListener(Events.Detach, listener);
    }

    this.target = target;
    if (listener == null) {
      listener = new Listener<ComponentEvent>() {
        public void handleEvent(ComponentEvent be) {
          Element source = target.getElement();
          EventType type = be.getType();
          if (type == Events.OnMouseOver) {
            Element from = DOM.eventGetFromElement(be.getEvent());
            if (from != null && !DOM.isOrHasChild(source, from)) {
              onTargetOver(be);
            }
          } else if (type == Events.OnMouseOut) {
            Element to = DOM.eventGetToElement(be.getEvent());
            if (to != null && !DOM.isOrHasChild(source, to)) {
              onTargetOut(be);
            }
          } else if (type == Events.OnMouseMove) {
            onMouseMove(be);
          } else if (type == Events.Hide || type == Events.Detach) {
            hide();
          }
        }
      };
    }
    target.addListener(Events.OnMouseOver, listener);
    target.addListener(Events.Render, listener);
    target.addListener(Events.OnMouseOut, listener);
    target.addListener(Events.OnMouseMove, listener);
    target.addListener(Events.Hide, listener);
    target.addListener(Events.Detach, listener);
    target.sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT | Event.ONMOUSEMOVE);
  }

  @Override
  public void show() {
    String origAnchor = null;
    boolean origConstrainPosition = false;
    if (toolTipConfig.getAnchor() != null) {
      origAnchor = toolTipConfig.getAnchor();
      // pre-show it off screen so that the el will have dimensions
      // for positioning calcs when getting xy next
      showAt(-1000, -1000);
      origConstrainPosition = this.constrainPosition;
      constrainPosition = false;
    }
    showAt(getTargetXY(0));

    if (toolTipConfig.getAnchor() != null) {
      anchorEl.show();
      syncAnchor();

      constrainPosition = origConstrainPosition;
      toolTipConfig.setAnchor(origAnchor);
    } else {
      anchorEl.hide();
    }

  }

  @Override
  public void showAt(int x, int y) {
    lastActive = new Date();
    clearTimers();
    super.showAt(x, y);
    if (toolTipConfig.getDismissDelay() > 0 && toolTipConfig.isAutoHide()) {
      dismissTimer = new Timer() {
        public void run() {
          hide();
        }
      };
      dismissTimer.schedule(toolTipConfig.getDismissDelay());
    }
  }

  /**
   * Updates the tool tip with the given config.
   * 
   * @param config the tool tip config
   */
  public void update(ToolTipConfig config) {
    updateConfig(config);
    if (!hidden) {
      updateContent();
    }
  }

  protected void clearTimer(String timer) {
    if (timer.equals("hide")) {
      if (hideTimer != null) {
        hideTimer.cancel();
        hideTimer = null;
      }
    } else if (timer.equals("dismiss")) {
      if (dismissTimer != null) {
        dismissTimer.cancel();
        dismissTimer = null;
      }
    } else if (timer.equals("show")) {
      if (showTimer != null) {
        showTimer.cancel();
        showTimer = null;
      }
    }
  }

  protected void clearTimers() {
    clearTimer("show");
    clearTimer("dismiss");
    clearTimer("hide");
  }

  protected void delayShow() {
    if (hidden && showTimer == null) {
      if ((new Date().getTime() - lastActive.getTime()) < quickShowInterval) {
        show();
      } else {
        showTimer = new Timer() {
          public void run() {
            show();
          }
        };
        showTimer.schedule(toolTipConfig.getShowDelay());
      }

    } else if (!hidden && toolTipConfig.isAutoHide()) {
      show();
    }
  }

  protected void onMouseMove(ComponentEvent ce) {
    targetXY = ce.getXY();
    if (!hidden && toolTipConfig.isTrackMouse()) {
      setPagePosition(getTargetXY(0));
    }
  }

  protected void onTargetOut(ComponentEvent ce) {
    if (disabled) {
      return;
    }
    clearTimer("show");
    if (toolTipConfig.isAutoHide()) {
      delayHide();
    }
  }

  protected void onTargetOver(ComponentEvent ce) {
    if (disabled || !ce.within(target.getElement())) {
      return;
    }

    clearTimer("hide");
    targetXY = ce.getXY();
    delayShow();
  }

  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    anchorEl = new El(DOM.createDiv());
    anchorEl.addStyleName("x-tip-anchor");
    el().appendChild(anchorEl.dom);
  }

  protected void afterRender() {
    super.afterRender();
    anchorEl.setStyleAttribute("zIndex", el().getZIndex() + 1);
  }

  protected String getAnchorAlign() {
    if (toolTipConfig.getAnchor().equals("top")) {
      return "tl-bl";
    } else if (toolTipConfig.getAnchor().equals("left")) {
      return "tl-tr";
    } else if (toolTipConfig.getAnchor().equals("right")) {
      return "tr-tl";
    }

    return "bl-tl";
  }

  protected int[] getOffsets() {
    int[] offsets;
    char ap = toolTipConfig.getAnchor().charAt(0);
    if (toolTipConfig.isAnchorToTarget() && !toolTipConfig.isTrackMouse()) {
      switch (ap) {
        case 't':
          offsets = new int[] {0, 9};
          break;
        case 'b':
          offsets = new int[] {0, -13};
          break;
        case 'r':
          offsets = new int[] {-13, 0};
          break;
        default:
          offsets = new int[] {9, 0};
          break;
      }
    } else {
      int anchorOffset = toolTipConfig.getAnchorOffset();
      switch (ap) {
        case 't':
          offsets = new int[] {-15 - anchorOffset, 30};
          break;
        case 'b':
          offsets = new int[] {-19 - anchorOffset, -13 - el().dom.getOffsetHeight()};
          break;
        case 'r':
          offsets = new int[] {-15 - el().dom.getOffsetWidth(), -13 - anchorOffset};
          break;
        default:
          offsets = new int[] {25, -13 - anchorOffset};
          break;
      }
    }
    int[] mouseOffset = toolTipConfig.getMouseOffset();
    offsets[0] += mouseOffset[0];
    offsets[1] += mouseOffset[1];

    return offsets;
  }

  protected void syncAnchor() {
    String anchorPos, targetPos;
    int[] offset;
    int anchorOffset = toolTipConfig.getAnchorOffset();
    switch (toolTipConfig.getAnchor().charAt(0)) {
      case 't':
        anchorPos = "b";
        targetPos = "tl";
        offset = new int[] {20 + anchorOffset, 2};
        break;
      case 'r':
        anchorPos = "l";
        targetPos = "tr";
        offset = new int[] {-2, 11 + anchorOffset};
        break;
      case 'b':
        anchorPos = "t";
        targetPos = "bl";
        offset = new int[] {20 + anchorOffset, -2};
        break;
      default:
        anchorPos = "r";
        targetPos = "tl";
        offset = new int[] {2, 11 + anchorOffset};
        break;
    }
    anchorEl.alignTo(el().dom, anchorPos + "-" + targetPos, offset);
  }

  protected void updateContent() {
    String title = this.title;
    getHeader().setText(title == null ? "" : title);
    if (toolTipConfig.getTemplate() != null) {
      toolTipConfig.getTemplate().overwrite(getBody().dom, toolTipConfig.getParams());
    } else {
      String text = this.text;
      if (text != null) {
        getBody().update(text);
      }
    }
  }

  private void delayHide() {
    if (!hidden && hideTimer == null) {
      if (toolTipConfig.getHideDelay() == 0) {
        hide();
        return;
      }
      hideTimer = new Timer() {
        public void run() {
          hide();
        }
      };
      hideTimer.schedule(toolTipConfig.getHideDelay());
    }
  }

  private Point getTargetXY(int targetCounter) {
    int[] mouseOffset = toolTipConfig.getMouseOffset();
    if (toolTipConfig.getAnchor() != null) {
      targetCounter++;
      int[] offsets = getOffsets();
      Point xy = (toolTipConfig.isAnchorToTarget() && !toolTipConfig.isTrackMouse())
          ? el().getAlignToXY(target.el().dom, getAnchorAlign(), null) : targetXY;

      int dw = XDOM.getViewWidth(false) - 5;
      int dh = XDOM.getViewHeight(false) - 5;
      int scrollX = XDOM.getBodyScrollLeft() + 5;
      int scrollY = XDOM.getBodyScrollTop() + 5;

      int[] axy = new int[] {xy.x + offsets[0], xy.y + offsets[1]};
      Size sz = getSize();
      Region r = target.el().getRegion();
      anchorEl.removeStyleName(anchorStyle);

      if (targetCounter < 2) {
        if (sz.width + offsets[0] + scrollX < dw - r.right) {
          toolTipConfig.setAnchor("left");
          return getTargetXY(targetCounter);
        }
        if (sz.width + offsets[0] + scrollX < r.left) {
          toolTipConfig.setAnchor("right");
          return getTargetXY(targetCounter);
        }
        if (sz.height + offsets[1] + scrollY < dh - r.bottom) {
          toolTipConfig.setAnchor("top");
          return getTargetXY(targetCounter);
        }
        if (sz.height + offsets[1] + scrollY < r.top) {
          toolTipConfig.setAnchor("bottom");
          return getTargetXY(targetCounter);
        }
      }

      anchorStyle = "x-tip-anchor-" + toolTipConfig.getAnchor();
      anchorEl.addStyleName(anchorStyle);
      targetCounter = 0;
      return new Point(axy[0], axy[1]);
    } else {
      int x = targetXY.x + mouseOffset[0];
      int y = targetXY.y + mouseOffset[1];
      return new Point(x, y);
    }

  }

  private void updateConfig(ToolTipConfig config) {
    this.toolTipConfig = config;
    if (!config.isEnabled()) {
      clearTimers();
      hide();
    }

    text = config.getText();
    title = config.getTitle();
  }

}

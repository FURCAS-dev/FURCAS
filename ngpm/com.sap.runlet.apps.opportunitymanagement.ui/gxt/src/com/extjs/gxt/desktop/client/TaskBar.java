/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.desktop.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.WindowManager;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * Displays the start menu button followed by a list of open windows.
 */
public class TaskBar extends LayoutContainer {

  protected StartBox startBox; // west
  protected TasksButtonsPanel tbPanel; // center

  public TaskBar() {
    setId("ux-taskbar");
    setLayout(new BorderLayout());

    startBox = new StartBox();
    tbPanel = new TasksButtonsPanel();

    add(startBox, new BorderLayoutData(LayoutRegion.WEST, 90));
    add(tbPanel, new BorderLayoutData(LayoutRegion.CENTER));
  }

  /**
   * Returns the bar's buttons.
   * 
   * @return the buttons
   */
  public List<TaskButton> getButtons() {
    return tbPanel.getItems();
  }

  /**
   * Adds a button.
   * 
   * @param win the window
   * @return the new task button
   */
  public TaskButton addTaskButton(Window win) {
    return tbPanel.addButton(win);
  }

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("zIndex", "10");
  }

  /**
   * Returns the bar's start menu.
   * 
   * @return the start menu
   */
  public StartMenu getStartMenu() {
    return (StartMenu) startBox.startBtn.getMenu();
  }

  /**
   * Removes a button.
   * 
   * @param btn the button to remove
   */
  public void removeTaskButton(TaskButton btn) {
    tbPanel.removeButton(btn);
  }

  /**
   * Sets the active button.
   * 
   * @param btn the button
   */
  public void setActiveButton(TaskButton btn) {
    tbPanel.setActiveButton(btn);
  }

}

class StartBox extends BoxComponent {

  StartButton startBtn = new StartButton();

  public StartBox() {
    setId("ux-taskbar-start");
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    ComponentHelper.doAttach(startBtn);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(startBtn);
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createDiv(), target, index);

    startBtn.render(getElement());
  }

}

class StartButton extends Button {

  private StartMenu startMenu;

  public StartButton() {
    setText("Start");
    setId("ux-startbutton");
    setIcon(IconHelper.createStyle("start", 23, 23));
    setMenuAlign("bl-tl");

    startMenu = new StartMenu();
    setMenu(startMenu);

    template = new Template(getButtonTemplate());
  }

  @Override
  protected void autoWidth() {

  }

  @Override
  public void setIcon(AbstractImagePrototype icon) {
    super.setIcon(icon);
    if (rendered) {
      if (buttonEl.selectNode("img") != null) {
        buttonEl.selectNode("img").remove();
      }
      if (icon != null) {
        buttonEl.setPadding(new Padding(7, 0, 7, 28));
        Element e = (Element) icon.createElement().cast();
        buttonEl.insertFirst(e);
        El.fly(e).makePositionable(true);
        String align = "b-b";
        if (getIconAlign() == IconAlign.BOTTOM) {
          align = "b-b";
        } else if (getIconAlign() == IconAlign.TOP) {
          align = "t-t";
        } else if (getIconAlign() == IconAlign.LEFT) {
          align = "l-l";
        } else if (getIconAlign() == IconAlign.RIGHT) {
          align = "r-r";
        }
        El.fly(e).alignTo(buttonEl.dom, align, null);
      }
    }
  }

  private native String getButtonTemplate() /*-{
    return [
    '<table border="0" cellpadding="0" cellspacing="0" class="x-btn-wrap"><tbody><tr>',
    '<td class="ux-startbutton-left"><i>&#160;</i></td><td class="ux-startbutton-center"><em unselectable="on"><button class="x-btn-text" type="{1}" style="height:30px;">{0}</button></em></td><td class="ux-startbutton-right"><i>&#160;</i></td>',
    '</tr></tbody></table>'
    ].join("");
  }-*/;
}

class TaskButton extends Button {

  private Window win;

  TaskButton(Window win, Element parent) {
    this.win = win;
    setText(win.getHeading());
    setIcon(win.getIcon());
    template = new Template(getButtonTemplate());

    render(parent);
  }

  @Override
  public void setIcon(AbstractImagePrototype icon) {
    super.setIcon(icon);
    if (rendered) {
      if (buttonEl.selectNode("img") != null) {
        buttonEl.selectNode("img").remove();
      }
      if (icon != null) {
        buttonEl.setPadding(new Padding(7, 0, 7, 20));
        Element e = (Element) icon.createElement().cast();
        buttonEl.insertFirst(e);
        El.fly(e).makePositionable(true);
        String align = "b-b";
        if (getIconAlign() == IconAlign.BOTTOM) {
          align = "b-b";
        } else if (getIconAlign() == IconAlign.TOP) {
          align = "t-t";
        } else if (getIconAlign() == IconAlign.LEFT) {
          align = "l-l";
        } else if (getIconAlign() == IconAlign.RIGHT) {
          align = "r-r";
        }
        El.fly(e).alignTo(buttonEl.dom, align, null);
      }
    }
  }

  @Override
  protected void onClick(ComponentEvent ce) {
    super.onClick(ce);
    if (win.getData("minimized") != null || !win.isVisible()) {
      win.show();
    } else if (win == WindowManager.get().getActive()) {
      win.minimize();
    } else {
      win.toFront();
    }
  }

  private native String getButtonTemplate() /*-{
    return [
    '<table border="0" cellpadding="0" cellspacing="0" class="x-btn-wrap"><tbody><tr>',
    '<td class="ux-taskbutton-left"><i>&#160;</i></td><td class="ux-taskbutton-center"><em unselectable="on"><button class="x-btn-text" type="{1}" style="height:28px;">{0}</button></em></td><td class="ux-taskbutton-right"><i>&#160;</i></td>',
    '</tr></tbody></table>'
    ].join("");
  }-*/;

}

class TasksButtonsPanel extends BoxComponent {

  // private TaskButton activeButton;
  private El stripWrap, strip, edge;
  // private El scrollLeft, scrollRight;
  private List<TaskButton> items;
  private boolean buttonWidthSet = false;
  private int lastButtonWidth;
  private boolean resizeButtons = true;
  private boolean enableScroll = true;
  private int buttonWidth = 168;
  private int minButtonWidth = 118;
  private int buttonMargin = 2;
  // private boolean scrolling;
  private int scrollIncrement = -1;

  TasksButtonsPanel() {
    setId("ux-taskbuttons-panel");
    items = new ArrayList<TaskButton>();
  }

  public List<TaskButton> getItems() {
    return items;
  }

  public TaskButton addButton(Window win) {
    Element li = strip.createChild("<li></li>", edge.dom).dom;
    TaskButton btn = new TaskButton(win, li);
    items.add(btn);
    if (!buttonWidthSet) {
      lastButtonWidth = li.getOffsetWidth();
    }
    setActiveButton(btn);
    win.setData("taskButton", btn);

    ComponentHelper.doAttach(btn);
    return btn;
  }

  public void removeButton(TaskButton btn) {
    Element li = btn.getElement().getParentElement().cast();
    li.getParentElement().removeChild(li);

    items.remove(btn);

    delegateUpdates();
    ComponentHelper.doDetach(btn);
  }

  public void setActiveButton(TaskButton btn) {
    // this.activeButton = btn;
    delegateUpdates();
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createDiv(), target, index);
    setStyleName("ux-taskbuttons-panel");

    stripWrap = el().createChild("<div class='ux-taskbuttons-strip-wrap'><ul class='ux-taskbuttons-strip'></ul></div>");
    el().createChild("<div class='ux-taskbuttons-strip-spacer'></div>");
    strip = stripWrap.firstChild();
    edge = strip.createChild("<li class='ux-taskbuttons-edge'></li>");
    strip.createChild("<div class='x-clear'></div>");
  }

  @Override
  protected void onResize(int width, int height) {
    super.onResize(width, height);
    delegateUpdates();
  }

  int getScrollIncrement() {
    return scrollIncrement != -1 ? scrollIncrement : lastButtonWidth + 2;
  }

  private void autoScroll() {
    // auto scroll not functional
    if (true) {
      return;
    }
  }

  private void autoSize() {
    int count = items.size();
    int aw = el().getStyleWidth();

    if (!resizeButtons || count < 1) {
      return;
    }

    int each = (int) Math.max(Math.min(Math.floor((aw - 4) / count) - buttonMargin, buttonWidth), minButtonWidth);
    NodeList<com.google.gwt.dom.client.Element> btns = stripWrap.dom.getElementsByTagName("button");

    El b = items.get(0).el();
    lastButtonWidth = b.findParent("li", 5).getWidth();

    for (int i = 0, len = btns.getLength(); i < len; i++) {
      Element btn = btns.getItem(i).cast();

      int tw = items.get(i).el().getParent().dom.getOffsetWidth();
      int iw = btn.getOffsetWidth();
      btn.getStyle().setPropertyPx("width", (each - (tw - iw)));
    }
  }

  // private void createScrollers() {
  // int h = el().getHeight();
  //
  // El sl =
  // el().insertFirst(XDOM.create("<div class='ux-taskbuttons-scroller-left'></div>"));
  // sl.setHeight(h);
  // scrollLeft = sl;
  //
  // El sr =
  // el().insertFirst(XDOM.create("<div class='ux-taskbuttons-scroller-right'></div>"));
  // sr.setHeight(h);
  // scrollRight = sr;
  // }

  private void delegateUpdates() {
    if (resizeButtons && rendered) {
      autoSize();
    }
    if (enableScroll && rendered) {
      autoScroll();
    }
  }

  // private void onScrollRight() {
  // int sw = getScrollWidth() - getScrollArea();
  // int pos = getScrollPos();
  // int s = Math.min(sw, pos + getScrollIncrement());
  // if (s != pos) {
  // scrollTo(s, animScroll);
  // }
  // }
  //  
  // private void onScrollLeft() {
  // int pos = getScrollPos();
  // int s = Math.max(0, pos - getScrollIncrement());
  // if (s != pos) {
  // scrollTo(s, animScroll);
  // }
  // }

  // private int getScrollArea() {
  // return stripWrap.getClientWidth();
  // }

  // private int getScrollPos() {
  // return stripWrap.dom.getScrollLeft();
  // }

  // private int getScrollWidth() {
  // return edge.getOffsetsTo(stripWrap.dom).x + getScrollPos();
  // }

  // private void scrollTo(int pos, boolean animate) {
  // if (animate) {
  // stripWrap.scrollTo("left", pos, new FxConfig(new Listener<FxEvent>() {
  // public void handleEvent(FxEvent fe) {
  // updateScrollButtons();
  // }
  // }));
  // } else {
  // stripWrap.scrollTo("left", pos);
  // updateScrollButtons();
  // }
  // }

  // private void scrollToBtn(TaskButton btn, boolean animate) {
  // com.google.gwt.dom.client.Element item =
  // btn.getElement().getParentElement();
  // if (item == null) {
  // return;
  // }
  // int pos = getScrollPos();
  // int area = getScrollArea();
  // int left = fly((Element) item).getOffsetsTo(stripWrap.dom).x + pos;
  // int right = left + getWidth();
  // if (left > pos) {
  // scrollTo(left, animate);
  // } else if (right > (pos + area)) {
  // scrollTo(right - area, animate);
  // }
  // }

  // private void updateScrollButtons() {
  // int pos = getScrollPos();
  // scrollLeft.setStyleName("ux-taskbuttons-scroller-left-disabled", pos == 0);
  // scrollRight.setStyleName("ux-taskbuttons-scroller-right-disabled",
  // pos >= (getScrollWidth() - getScrollArea()));
  // }

}

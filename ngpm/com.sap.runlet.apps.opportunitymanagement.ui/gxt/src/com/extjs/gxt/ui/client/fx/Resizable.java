/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.fx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.PreviewEvent;
import com.extjs.gxt.ui.client.event.ResizeEvent;
import com.extjs.gxt.ui.client.event.ResizeListener;
import com.extjs.gxt.ui.client.util.BaseEventPreview;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Shim;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Applies drag handles to a widget to make it resizable. The drag handles are
 * inserted into the widget and positioned absolute.
 * <p>
 * Here is the list of valid resize handles:
 * </p>
 * 
 * <pre>
 * Value   Description
 * ------  -------------------
 * 'n'     north
 * 's'     south
 * 'e'     east
 * 'w'     west
 * 'nw'    northwest
 * 'sw'    southwest
 * 'se'    southeast
 * 'ne'    northeast
 * 'all'   all
 * </pre>
 * 
 * <dl>
 * <dt><b>Events:</b></dt>
 * 
 * <dd><b>ResizeStart</b> : (source, widget, event) <br>
 * Fires before a resize operation start. Listeners can cancel the action by
 * calling {@link BaseEvent#setCancelled(boolean)}.
 * <ul>
 * <li>source : this</li>
 * <li>component : resize widget</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>ResizeEnd</b> : (source, widget, event)<br>
 * Fires after a resize.
 * <ul>
 * <li>source : this</li>
 * <li>widget : resize widget</li>
 * <li>event : the dom event</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class Resizable extends BaseObservable {

  protected enum Dir {
    E, N, NE, NW, S, SE, SW, W;
  }

  private class ResizeHandle extends Component {

    public Dir dir;

    public void onBrowserEvent(Event event) {
      switch (DOM.eventGetType(event)) {
        case Event.ONMOUSEDOWN:
          DOM.eventCancelBubble(event, true);
          DOM.eventPreventDefault(event);
          handleMouseDown(event, this);
          break;
      }
    }

    @Override
    protected void onRender(Element target, int index) {
      super.onRender(target, index);
      setElement(DOM.createDiv(), target, index);
      sinkEvents(Event.MOUSEEVENTS);
    }
  }

  private Dir dir;
  private boolean dynamic;
  private boolean enabled = true;
  private List<ResizeHandle> handleList;
  private String handles;
  private Listener<ComponentEvent> listener;
  private int maxHeight = 2000;
  private int maxWidth = 2000;
  private int minHeight = 50;
  private int minWidth = 50;
  private boolean preserveRatio = false;
  private BaseEventPreview preview;
  private El proxyEl;
  private String proxyStyle = "x-resizable-proxy";
  private BoxComponent resize;
  private boolean resizing;
  private Rectangle startBox;
  private Point startPoint;

  /**
   * Creates a new resizable instance with 8-way resizing.
   * 
   * @param resize the resize widget
   */
  public Resizable(BoxComponent resize) {
    this(resize, "all");
  }

  /**
   * Creates a new resizable instance.
   * 
   * @param resize the resize widget
   * @param handles the resize handle locations separated by spaces
   */
  public Resizable(final BoxComponent resize, String handles) {
    this.resize = resize;
    this.handles = handles;

    listener = new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent e) {
        EventType type = e.getType();
        if (type == Events.Render) {
          init();
        } else if (type == Events.Attach) {
          onAttach();
        } else if (type == Events.Detach) {
          onDetach();
        }
      }
    };

    resize.addListener(Events.Render, listener);
    resize.addListener(Events.Attach, listener);
    resize.addListener(Events.Detach, listener);

    if (resize.isRendered()) {
      init();
    }

    if (resize.isAttached()) {
      onAttach();
    }
  }

  /**
   * Adds a resize listener.
   * 
   * @param listener the listener
   */
  public void addResizeListener(ResizeListener listener) {
    addListener(Events.ResizeStart, listener);
    addListener(Events.ResizeEnd, listener);
  }

  /**
   * Returns the max height
   * 
   * @return the max height
   */
  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   * Returns the max width.
   * 
   * @return the max width
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Returns the min height.
   * 
   * @return the min height
   */
  public int getMinHeight() {
    return minHeight;
  }

  /**
   * Returns the min width.
   * 
   * @return the min width
   */
  public int getMinWidth() {
    return minWidth;
  }

  /**
   * Returns the proxy style.
   * 
   * @return the proxy style
   */
  public String getProxyStyle() {
    return proxyStyle;
  }

  /**
   * Returns true if widget is being resized directly.
   * 
   * @return the dynamic state
   */
  public boolean isDynamic() {
    return dynamic;
  }

  /**
   * Returns true if the aspect ratio is being preserved.
   * 
   * @return true if the aspect ratio is being preserved
   */
  public boolean isPreserveRatio() {
    return preserveRatio;
  }

  /**
   * Returns <code>true</code> if if resizing.
   * 
   * @return the resize state
   */
  public boolean isResizing() {
    return resizing;
  }

  /**
   * Removes the drag handles.
   */
  public void release() {
    onDetach();

    resize.removeListener(Events.Attach, listener);
    resize.removeListener(Events.Detach, listener);
    resize.removeListener(Events.Render, listener);

    Iterator<ResizeHandle> iter = handleList.iterator();
    while (iter.hasNext()) {
      ResizeHandle handle = iter.next();
      iter.remove();
      DOM.removeChild(resize.getElement(), handle.getElement());
    }
  }

  /**
   * Removes a resize listener.
   * 
   * @param listener the listener
   */
  public void removeResizeListener(ResizeListener listener) {
    removeListener(Events.ResizeStart, listener);
    removeListener(Events.ResizeEnd, listener);
  }

  /**
   * True to resize the widget directly instead of using a proxy (defaults to
   * false).
   * 
   * @param dynamic true to resize directly
   */
  public void setDynamic(boolean dynamic) {
    this.dynamic = dynamic;
  }

  /**
   * Enables or disables the drag handles.
   * 
   * @param enable <code>true</code> to enable
   */
  public void setEnabled(boolean enable) {
    for (ResizeHandle handle : handleList) {
      El.fly(handle.getElement()).setVisibility(enable);
    }
  }

  /**
   * Sets the max height (defaults to 2000).
   * 
   * @param maxHeight the max height
   */
  public void setMaxHeight(int maxHeight) {
    this.maxHeight = maxHeight;
  }

  /**
   * Sets the max width (defaults to 2000).
   * 
   * @param maxWidth the max width
   */
  public void setMaxWidth(int maxWidth) {
    this.maxWidth = maxWidth;
  }

  /**
   * Sets the min height (default to 50).
   * 
   * @param minHeight the min height
   */
  public void setMinHeight(int minHeight) {
    this.minHeight = minHeight;
  }

  /**
   * Sets the min width (defaults to 50).
   * 
   * @param minWidth the min width
   */
  public void setMinWidth(int minWidth) {
    this.minWidth = minWidth;
  }

  /**
   * True to preserve the original ratio between height and width during resize
   * (defaults to false).
   * 
   * @param preserveRatio true to preserve the original aspect ratio
   */
  public void setPreserveRatio(boolean preserveRatio) {
    this.preserveRatio = preserveRatio;
  }

  /**
   * Sets the style name used for proxy drags (defaults to 'x-resizable-proxy').
   * 
   * @param proxyStyle the proxy style
   */
  public void setProxyStyle(String proxyStyle) {
    this.proxyStyle = proxyStyle;
  }

  public void syncHandleHeight() {
    int height = resize.getHeight(true);
    for (ResizeHandle r : handleList) {
      if (r.dir == Dir.E || r.dir == Dir.W) {
        r.el().setHeight(height);
      }
    }
    resize.el().repaint();

  }

  protected Element createProxy() {
    Element elem = DOM.createDiv();
    El.fly(elem).setStyleName(proxyStyle, true);
    El.fly(elem).disableTextSelection(true);
    return elem;
  }

  protected void init() {
    resize.el().makePositionable();
    if (handleList == null) {
      handleList = new ArrayList<ResizeHandle>();
      if (handles.equals("all")) {
        handles = "n s e w ne nw se sw";
      }
      String[] temp = handles.split(" ");
      for (int i = 0; i < temp.length; i++) {
        if ("n".equals(temp[i])) {
          create(Dir.N, "north");
        } else if ("nw".equals(temp[i])) {
          create(Dir.NW, "northwest");
        } else if ("e".equals(temp[i])) {
          create(Dir.E, "east");
        } else if ("w".equals(temp[i])) {
          create(Dir.W, "west");
        } else if ("se".equals(temp[i])) {
          create(Dir.SE, "southeast");
        } else if ("s".equals(temp[i])) {
          create(Dir.S, "south");
        } else if ("ne".equals(temp[i])) {
          create(Dir.NE, "northeast");
        } else if ("sw".equals(temp[i])) {
          create(Dir.SW, "southwest");
        }
      }

      preview = new BaseEventPreview() {

        @Override
        public boolean onPreview(PreviewEvent event) {
          event.preventDefault();
          switch (event.getEventTypeInt()) {
            case Event.ONMOUSEMOVE:
              int x = event.getClientX();
              int y = event.getClientY();
              handleMouseMove(x, y);
              break;
            case Event.ONMOUSEUP:
              handleMouseUp(event.getEvent());
              break;
          }
          return true;
        }

      };
      preview.setAutoHide(false);
    }

    syncHandleHeight();

  }

  protected void onAttach() {
    for (ResizeHandle handle : handleList) {
      ComponentHelper.doAttach(handle);
    }
  }

  protected void onDetach() {
    for (ResizeHandle handle : handleList) {
      ComponentHelper.doDetach(handle);
    }
  }

  private int constrain(int v, int diff, int m, int mx) {
    if (v - diff < m) {
      diff = v - m;
    } else if (v - diff > mx) {
      diff = mx - v;
    }
    return diff;
  }

  private ResizeHandle create(Dir dir, String cls) {
    ResizeHandle rh = new ResizeHandle();
    rh.setStyleName("x-resizable-handle " + "x-resizable-handle-" + cls);
    rh.dir = dir;
    rh.render(resize.getElement());
    handleList.add(rh);
    return rh;
  }

  private void handleMouseDown(Event event, ResizeHandle handle) {
    if (!enabled) {
      return;
    }

    if (!fireEvent(Events.ResizeStart, new ResizeEvent(this, resize, event))) {
      return;
    }

    dir = handle.dir;

    startBox = resize.getBounds(false);
    int x = DOM.eventGetClientX(event);
    int y = DOM.eventGetClientY(event);
    startPoint = new Point(x, y);

    resizing = true;

    if (proxyEl == null) {
      proxyEl = new El(DOM.createDiv());
      proxyEl.setStyleName(proxyStyle, true);
      proxyEl.disableTextSelection(true);
      Element body = RootPanel.getBodyElement();
      DOM.appendChild(body, proxyEl.dom);
    }

    proxyEl.makePositionable(true);
    proxyEl.setLeft(startBox.x).setTop(startBox.y);
    proxyEl.setSize(startBox.width, startBox.height);
    proxyEl.setVisible(true);
    proxyEl.updateZIndex(5);

    preview.add();

    Shim.get().cover(false);
    Shim.get().setStyleAttribute("cursor", handle.el().getStyleAttribute("cursor"));

  }

  private void handleMouseMove(int xin, int yin) {
    if (resizing) {
      int x = startBox.x;
      int y = startBox.y;
      float w = startBox.width;
      float h = startBox.height;
      float ow = w, oh = h;
      int mw = minWidth;
      int mh = minHeight;
      int mxw = maxWidth;
      int mxh = maxHeight;

      Point eventXY = new Point(xin, yin);

      int diffX = -(startPoint.x - Math.max(2, eventXY.x));
      int diffY = -(startPoint.y - Math.max(2, eventXY.y));

      switch (dir) {
        case E:
          w += diffX;
          w = Math.min(Math.max(mw, w), mxw);
          break;
        case S:
          h += diffY;
          h = Math.min(Math.max(mh, h), mxh);
          break;
        case SE:
          w += diffX;
          h += diffY;
          w = Math.min(Math.max(mw, w), mxw);
          h = Math.min(Math.max(mh, h), mxh);
          break;
        case N:
          diffY = constrain((int) h, diffY, mh, mxh);
          y += diffY;
          h -= diffY;
          break;
        case W:
          diffX = constrain((int) w, diffX, mw, mxw);
          x += diffX;
          w -= diffX;
          break;
        case NE:
          w += diffX;
          w = Math.min(Math.max(mw, w), mxw);
          diffY = constrain((int) h, diffY, mh, mxh);
          y += diffY;
          h -= diffY;
          break;
        case NW:
          diffX = constrain((int) w, diffX, mw, mxw);
          diffY = constrain((int) h, diffY, mh, mxh);
          y += diffY;
          h -= diffY;
          x += diffX;
          w -= diffX;
          break;
        case SW:
          diffX = constrain((int) w, diffX, mw, mxw);
          h += diffY;
          h = Math.min(Math.max(mh, h), mxh);
          x += diffX;
          w -= diffX;
          break;
      }
      if (preserveRatio) {
        switch (dir) {
          case SE:
          case E:
            h = oh * (w / ow);
            h = Math.min(Math.max(mh, h), mxh);
            w = ow * (h / oh);
            break;
          case S:
            w = ow * (h / oh);
            w = Math.min(Math.max(mw, w), mxw);
            h = oh * (w / ow);
            break;
          case NE:
            w = ow * (h / oh);
            w = Math.min(Math.max(mw, w), mxw);
            h = oh * (w / ow);
            break;
          case N: {
            float tw = w;
            w = ow * (h / oh);
            w = Math.min(Math.max(mw, w), mxw);
            h = oh * (w / ow);
            x += (tw - w) / 2;
          }
            break;
          case SW: {
            h = oh * (w / ow);
            h = Math.min(Math.max(mh, h), mxh);
            float tw = w;
            w = ow * (h / oh);
            x += tw - w;
            break;
          }
          case W: {
            float th = h;
            h = oh * (w / ow);
            h = Math.min(Math.max(mh, h), mxh);
            y += (th - h) / 2;
            float tw = w;
            w = ow * (h / oh);
            x += tw - w;
            break;
          }
          case NW: {
            float tw = w;
            float th = h;
            h = oh * (w / ow);
            h = Math.min(Math.max(mh, h), mxh);
            w = ow * (h / oh);
            y += th - h;
            x += tw - w;
            break;
          }
        }
      }
      proxyEl.setBounds(x, y, (int) w, (int) h);
    }
  }

  private void handleMouseUp(Event event) {
    resizing = false;
    preview.remove();
    Shim.get().uncover();

    Rectangle rect;
    if (!GXT.isBorderBox) {
      rect = proxyEl.getBounds(false, true);
    } else {
      rect = proxyEl.getBounds();
    }

    rect.width = Math.min(rect.width, maxWidth);
    rect.height = Math.min(rect.height, maxHeight);

    if (proxyEl != null) {
      proxyEl.disableTextSelection(false);
    }
    proxyEl.setVisible(false);

    resize.setBounds(rect);

    syncHandleHeight();

    ResizeEvent ce = new ResizeEvent(this);
    ce.setComponent(resize);
    ce.setEvent(event);
    fireEvent(Events.ResizeEnd, ce);
  }

}

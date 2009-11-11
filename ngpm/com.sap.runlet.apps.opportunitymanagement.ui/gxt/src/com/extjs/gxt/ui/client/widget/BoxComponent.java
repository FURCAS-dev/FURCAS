/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.aria.FocusFrame;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BoxComponentEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Layer.ShadowPosition;
import com.google.gwt.user.client.Event;

/**
 * Base class for any visual {@link Component} that uses a box container.
 * {@link BoxComponent} provides automatic box model adjustments for sizing and
 * positioning and will work correctly within the {@link Component} rendering
 * model.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>Resize</b> : BoxComponentEvent(boxComponent, width, height)<br>
 * <div>Fires after the component is resized.</div>
 * <ul>
 * <li>boxComponent : this</li>
 * <li>width : the widget width</li>
 * <li>height : the widget height</li>
 * </ul>
 * 
 * <dd><b>Move</b> : BoxComponentEvent(boxComponent, x, y)<br>
 * <div>Fires after the component is moved.</div>
 * <ul>
 * <li>boxComponent : this</li>
 * <li>x : the new x position</li>
 * <li>y : the new y position</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * <dl>
 * <dt>Inherited Events:</dt>
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
public class BoxComponent extends Component {

  /**
   * True to adjust sizes for box model issues to ensure actual size matches set
   * size.
   */
  protected boolean adjustSize = true;

  /**
   * True to enable a shim which uses a transparent iframe to stop content from
   * bleeding through.
   */
  protected boolean shim;

  /**
   * True to cache size calculation.
   */
  protected boolean cacheSizes = true;

  /**
   * A specialized El that provides support for a shadow and shim. Will be
   * created if either {@link #shadow} or {@link #shim} is set to true.
   */
  protected Layer layer;

  protected Size lastSize;
  protected String width, height;

  private boolean shadow;
  private ShadowPosition shadowPosition = ShadowPosition.SIDES;
  private int shadowOffset = 4;

  private boolean deferHeight;
  private boolean autoHeight;
  private boolean autoWidth;
  private int left = Style.DEFAULT, top = Style.DEFAULT;
  private int pageX = Style.DEFAULT, pageY = Style.DEFAULT;
  private boolean boxReady;

  /**
   * Gets the current box measurements of the component's underlying element.
   * The component must be attached to return page coordinates.
   * 
   * @param local if true the element's left and top are returned instead of
   *          page coordinates
   * @return the component's bounds
   */
  public Rectangle getBounds(boolean local) {
    return el().getBounds(local);
  }

  /**
   * Returns the component's offset height.
   * 
   * @return the height
   */
  public int getHeight() {
    return el().getHeight();
  }

  /**
   * Return the component's height.
   * 
   * @param content true to get the height minus borders and padding
   * @return the height
   */
  public int getHeight(boolean content) {
    return el().getHeight(content);
  }

  /**
   * Returns the component's current position. The component must be attached to
   * return page coordinates.
   * 
   * @param local true to return the element's left and top rather than page
   *          coordinates
   * @return the position
   */
  public Point getPosition(boolean local) {
    if (local) {
      return new Point(el().getLeft(true), el().getTop(true));
    }
    return el().getXY();
  }

  /**
   * Returns true if the shadow is enabled.
   * 
   * @return the shadow the shadow state
   */
  public boolean getShadow() {
    return shadow;
  }

  /**
   * Returns the shadow position.
   * 
   * @return the shadow position
   */
  public ShadowPosition getShadowPosition() {
    return shadowPosition;
  }

  /**
   * Returns the shadow offset.
   * 
   * @return the shadow offset
   */
  public int getShadowOffset() {
    return shadowOffset;
  }

  /**
   * Returns the component's size.
   * 
   * @return the size
   */
  public Size getSize() {
    return el().getSize();
  }

  /**
   * Returns the component's width.
   * 
   * @return the width
   */
  public int getWidth() {
    return getOffsetWidth();
  }

  /**
   * Returns the component's width.
   * 
   * @param content true to get width minus borders and padding
   * @return the width
   */
  public int getWidth(boolean content) {
    return el().getWidth(content);
  }

  /**
   * @return the autoHeight
   */
  public boolean isAutoHeight() {
    return autoHeight;
  }

  /**
   * @return the autoWidth
   */
  public boolean isAutoWidth() {
    return autoWidth;
  }

  /**
   * Returns true if the height is being deferred
   * 
   * @return the defer height state
   */
  public boolean isDeferHeight() {
    return deferHeight;
  }

  /**
   * Returns true if shimming is enabled.
   * 
   * @return the shim state
   */
  public boolean isShim() {
    return shim;
  }

  /**
   * Sets the component's auto height value (defaults to false).
   * 
   * @param autoHeight true to enable auto height
   */
  public void setAutoHeight(boolean autoHeight) {
    this.autoHeight = autoHeight;
  }

  /**
   * True to use width:'auto', false to use fixed width (defaults to false).
   * 
   * @param autoWidth the auto width state
   */
  public void setAutoWidth(boolean autoWidth) {
    this.autoWidth = autoWidth;
  }

  /**
   * Sets the component's size. This method fires the <i>Move</i> and
   * <i>Resize</i> events. element.
   * 
   * @param x the x coordinate
   * @param y the y coordinate
   * @param width the width
   * @param height the height
   */
  public void setBounds(int x, int y, int width, int height) {
    setPagePosition(x, y);
    setSize(width, height);
  }

  /**
   * Sets the component's size. This method fires the <i>Move</i> and
   * <i>Resize</i> events. element.
   * 
   * @param bounds the update box
   */
  public void setBounds(Rectangle bounds) {
    setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
  }

  /**
   * True to defer height calculations to an external component, false to allow
   * this component to set its own height (defaults to false).
   * 
   * @param deferHeight true to defer height
   */
  public void setDeferHeight(boolean deferHeight) {
    this.deferHeight = deferHeight;
  }

  /**
   * Sets the component's height. This method fires the <i>Resize</i> event.
   * element.
   * 
   * @param height the new height
   */
  public void setHeight(int height) {
    setSize(-1, height);
  }

  /**
   * Sets the height of the component. This method fires the <i>Resize</i>
   * event. element.
   * 
   * @param height the new height to set
   */
  public void setHeight(String height) {
    setSize(Style.UNDEFINED, height);
  }

  /**
   * Sets the page XY position of the component. To set the left and top
   * instead, use {@link #setPosition}. This method fires the <i>Move</i> event.
   * 
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public void setPagePosition(int x, int y) {
    if (x != Style.DEFAULT) {
      pageX = x;
    }
    if (y != Style.DEFAULT) {
      pageY = y;
    }
    if (!boxReady) {
      return;
    }
    Point p = getPositionEl().translatePoints(new Point(x, y));
    setPosition(p.x, p.y);
  }

  /**
   * Sets the page XY position of the component. To set the left and top
   * instead, use {@link #setPosition}. This method fires the <i>Move</i> event.
   * 
   * @param point the new location
   */
  public void setPagePosition(Point point) {
    setPagePosition(point.x, point.y);
  }

  /**
   * Sets the width and height of the component. This method fires the resize
   * event.
   * 
   * @param width the new width to set
   * @param height the new height to set
   */
  public void setPixelSize(int width, int height) {
    setSize(width, height);
  }

  /**
   * Sets the left and top of the component. To set the page XY position
   * instead, use {@link #setPagePosition}. This method fires the move event.
   * 
   * @param left the new left
   * @param top the new top
   */
  public void setPosition(int left, int top) {
    this.left = left;
    this.top = top;

    if (!boxReady) {
      return;
    }

    Point adj = adjustPosition(new Point(left, top));
    int ax = adj.x, ay = adj.y;

    El pel = getPositionEl();

    if (ax != Style.DEFAULT || ay != Style.DEFAULT) {
      if (ax != Style.DEFAULT && ay != Style.DEFAULT) {
        pel.setLeftTop(ax, ay);
      } else if (ax != Style.DEFAULT) {
        pel.setLeft(ax);
      } else if (ay != Style.DEFAULT) {
        pel.setTop(ay);
      }
      onPosition(ax, ay);
      FocusFrame.get().sync(this);

      BoxComponentEvent be = (BoxComponentEvent) createComponentEvent(null);
      be.setX(ax);
      be.setY(ay);
      fireEvent(Events.Move, be);
    }
  }

  /**
   * True to enable a shadow that will be displayed behind the component
   * (defaults to false).
   * 
   * @param shadow true to enable the shadow
   */
  public void setShadow(boolean shadow) {
    this.shadow = shadow;
  }

  /**
   * Sets the shadow position (defaults to SIDES).
   * 
   * @param shadowPosition the position
   */
  public void setShadowPosition(ShadowPosition shadowPosition) {
    this.shadowPosition = shadowPosition;
    if (layer != null) {
      layer.setShadowPosition(shadowPosition);
    }
  }

  /**
   * Sets the shadow offset (defaults to 4).
   * 
   * @param shadowOffset the offset
   */
  public void setShadowOffset(int shadowOffset) {
    this.shadowOffset = shadowOffset;
    setShadowPosition(shadowPosition);
  }

  /**
   * True to enable a shim which uses a transparent iframe to stop content from
   * bleeding through.
   * 
   * @param shim true to enable a shim
   */
  public void setShim(boolean shim) {
    this.shim = shim;
  }

  /**
   * Sets the width and height of the component. This method fires the
   * <i>Resize</i> event.
   * 
   * @param width the new width to set
   * @param height the new height to set
   */
  public void setSize(int width, int height) {
    if (!boxReady) {
      if (width != -1) {
        this.width = width + "px";
      }
      if (height != -1) {
        this.height = height + "px";
      }

      return;
    }

    Size size = new Size(width, height);
    if (cacheSizes && lastSize != null && lastSize.equals(size)) {
      return;
    }

    lastSize = size;

    Size ads = adjustSize(size);

    int aw = ads.width;
    int ah = ads.height;

    if (autoWidth) {
      setStyleAttribute("width", "auto");
    } else {
      el().setWidth(aw, adjustSize);
    }
    if (autoHeight) {
      setStyleAttribute("height", "auto");
    } else {
      if (!deferHeight) {
        el().setHeight(ah, adjustSize);
      }
    }

    onResize(aw, ah);

    sync(true);

    FocusFrame.get().sync(this);

    BoxComponentEvent ce = (BoxComponentEvent) createComponentEvent(null);
    ce.setWidth(aw);
    ce.setHeight(ah);
    fireEvent(Events.Resize, ce);
  }

  /**
   * Sets the width and height of the component. This method fires the
   * <i>Resize</i> event.
   * 
   * @param width the new width to set
   * @param height the new height to set
   */
  public void setSize(String width, String height) {
    if (!boxReady) {
      if (width != null && !width.equals(Style.UNDEFINED)) {
        this.width = width;
      }
      if (height != null && !height.equals(Style.UNDEFINED)) {
        this.height = height;
      }
      return;
    }

    if (width == null) {
      width = Style.UNDEFINED;
    }
    if (height == null) {
      height = Style.UNDEFINED;
    }

    if (!width.equals(Style.UNDEFINED)) {
      width = El.addUnits(width, "px");
    }

    if (!height.equals(Style.UNDEFINED)) {
      height = El.addUnits(height, "px");
    }

    if (autoWidth) {
      el().setWidth("auto");
    } else if (!width.equals(Style.UNDEFINED)) {
      el().setWidth(width);
    }
    if (autoHeight) {
      el().setHeight("auto");
    } else if (!height.equals(Style.UNDEFINED)) {
      if (!deferHeight) {
        el().setHeight(height);
      }
    }

    int w = -1;
    int h = -1;

    if (width.indexOf("px") != -1) {
      w = Integer.parseInt(width.substring(0, width.indexOf("px")));
    } else if (autoWidth || width.equals("auto")) {
      w = -1;
    } else if (!width.equals(Style.UNDEFINED)) {
      w = getOffsetWidth();
    }

    if (height.indexOf("px") != -1) {
      h = Integer.parseInt(height.substring(0, height.indexOf("px")));
    } else if (autoHeight || height.equals("auto")) {
      h = -1;
    } else if (!height.equals(Style.UNDEFINED)) {
      h = getOffsetHeight();
    }

    Size size = new Size(w, h);
    if (cacheSizes && lastSize != null && lastSize.equals(size)) {
      return;
    }

    lastSize = size;

    onResize(w, h);

    sync(true);

    FocusFrame.get().sync(this);

    BoxComponentEvent evt = (BoxComponentEvent) createComponentEvent(null);
    evt.setWidth(w);
    evt.setHeight(h);
    fireEvent(Events.Resize, evt);
  }

  /**
   * Sets the width of the component. This method fires the <i>Resize</i> event.
   * 
   * @param width the new width to set
   */
  public void setWidth(int width) {
    setSize(width, -1);
  }

  /**
   * Sets the width of the component. This method fires the <i>Resize</i> event.
   * 
   * @param width the new width to set
   */
  public void setWidth(String width) {
    setSize(width, Style.UNDEFINED);
  }

  /**
   * Syncs the layer of the component.
   */
  public void sync(boolean show) {
    if (layer != null) {
      layer.sync(show);
    }
  }

  public void syncSize() {
    lastSize = null;
    if (rendered) {
      setSize(getWidth(), getHeight());
    }
  }

  protected Point adjustPosition(Point point) {
    return point;
  }

  protected Size adjustSize(Size size) {
    return size;
  }

  protected void afterRender() {
    super.afterRender();
    boxReady = true;

    if (shadow || (shim && GXT.useShims)) {
      layer = new Layer(getElement());
      if (shadow) {
        layer.enableShadow();
        layer.setShadowPosition(shadowPosition);
        layer.setShadowOffset(shadowOffset);
      }
      if (shim && GXT.useShims) {
        layer.enableShim();
      }
      setEl(layer);
    }

    if (width != null || height != null) {
      setSize(width, height);
    }

    if (left != Style.DEFAULT || top != Style.DEFAULT) {
      setPosition(left, top);
    }
    if (pageX != Style.DEFAULT || pageY != Style.DEFAULT) {
      setPagePosition(pageX, pageY);
    }
  }

  @Override
  protected ComponentEvent createComponentEvent(Event event) {
    BoxComponentEvent e = new BoxComponentEvent(this, event);
    return e;
  }

  /**
   * Returns the element to be used when positioning the component. Subclasses
   * may override as needed. Default method returns the component's root
   * element.
   * 
   * @return the position element
   */
  protected El getPositionEl() {
    return el();
  }

  /**
   * Returns the element to be used when resizing the component. Subclasses may
   * override as needed. Default method returns the component's root element.
   * 
   * @return the resize element
   */
  protected El getResizeEl() {
    return el();
  }

  protected void hideShadow() {
    if (layer != null) {
      layer.hideShadow();
    }
  }

  protected void hideShim() {
    if (layer != null) {
      layer.hideShim();
    }
  }

  protected void hideUnders() {
    if (layer != null) {
      layer.hideUnders();
    }
  }

  @Override
  protected void onDetach() {
    super.onDetach();
    if (!hidden) {
      hideUnders();
    }
  }

  protected void onHide() {
    super.onHide();
    hideUnders();
  }

  /**
   * Called after the component is moved, this method is empty by default but
   * can be implemented by any subclass that needs to perform custom logic after
   * a move occurs.
   * 
   * @param x the new x position
   * @param y the new y position
   */
  protected void onPosition(int x, int y) {
  }

  /**
   * Called after the component is resized, this method is empty by default but
   * can be implemented by any subclass that needs to perform custom logic after
   * a resize occurs.
   * 
   * @param width the width
   * @param height the height
   */
  protected void onResize(int width, int height) {
    if (mask) {
      mask(maskMessage, maskMessageStyleName);
    }
  }

  protected void onShow() {
    super.onShow();
    sync(true);
  }
}

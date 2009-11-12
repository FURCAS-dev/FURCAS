/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import java.util.Stack;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.util.Markup;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Accessibility;

/**
 * An extended {@link El} object that supports a shadow and shim, constrain to
 * viewport and automatic maintaining of shadow/shim positions.
 */
public class Layer extends El {
  public enum ShadowPosition {
    DROP, SIDES, FRAME;
  }

  private static Stack<El> shims = new Stack<El>();

  private static Stack<El> shadows = new Stack<El>();

  private El shadow;
  private boolean shadowEnabled;
  private El shim;
  private boolean shimEnabled;

  private Rectangle shadowAdjusts;
  private ShadowPosition shadowPosition;

  private int shadowOffset = 4;

  /**
   * Creates a new layer instance.
   */
  public Layer() {
    super(DOM.createDiv());
    setShadowPosition(ShadowPosition.SIDES);
  }

  /**
   * Creates a new layer instance wrapping the specified element.
   * 
   * @param element the element
   */
  public Layer(Element element) {
    super(element);
    makePositionable();
    setShadowPosition(ShadowPosition.SIDES);
  }

  @Override
  public El alignTo(Element align, String pos, int[] offsets) {
    super.alignTo(align, pos, offsets);
    sync(true);
    return this;
  }

  private El createShadow() {
    El el;
    if (GXT.isIE) {

      el = new El(DOM.createDiv());;
      el.setStyleName("x-ie-shadow");
      if (GXT.isIE) {
        el.setStyleAttribute("filter", "progid:DXImageTransform.Microsoft.alpha("
            + "opacity=50) progid:DXImageTransform.Microsoft.Blur(pixelradius=" + shadowOffset + ")");
      }
    } else {
      el = new El(Markup.SHADOW);
    }
    return el;
  }

  /**
   * Creates an iframe shim for this element to keep selects and other windowed
   * objects from showing through.
   * 
   * @return the new shim element
   */
  private El createShim() {
    El el = new El(DOM.createIFrame());
    el.dom.setPropertyString("frameborder", "no");
    el.dom.setPropertyString("frameBorder", "no");
    el.dom.setClassName("ext-shim");
    el.setTabIndex(-1);
    el.setVisibility(true);
    el.setVisible(false);
    if (GXT.isIE && GXT.isSecure) {
      el.dom.setPropertyString("src", GXT.SSL_SECURE_URL);
    }

    Accessibility.setRole(el.dom, "presentation");

    return el;
  }

  /**
   * Disables the shadow.
   */
  public void disableShadow() {
    shadowEnabled = false;
    hideShadow();
  }

  /**
   * Disables the shim.
   */
  public void disableShim() {
    shimEnabled = false;
    hideShim();
  }

  /**
   * Disables the shim and the shadow.
   */
  public void disableUnders() {
    disableShadow();
    disableShim();
  }

  /**
   * Enables the shadow.
   */
  public void enableShadow() {
    shadowEnabled = true;
  }

  /**
   * Enables the shim.
   */
  public void enableShim() {
    shimEnabled = true;
  }

  /**
   * Returns the layer's shadow.
   * 
   * @return the shadow or null
   */
  public El getShadow() {
    if (shadow != null) {
      return shadow;
    }
    shadow = shadows.size() > 0 ? shadows.pop() : null;
    if (shadow == null) {
      shadow = createShadow();
      shadow.setVisible(false);
    }
    El pn = getParent();
    if (pn == null) return null;
    El p = shadow.getParent();
    if (p != null && p.dom == XDOM.getBody()) {
      pn.insertChild(shadow.dom, 0);
    } else if (p == null || pn.dom != p.dom) {
      try {
        pn.insertBefore(shadow.dom, dom);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }
    shadow.setZIndex(getZIndex() - 1);
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
   * Returns the layer's shim.
   * 
   * @return the shim
   */
  public El getShim() {
    if (shim != null) {
      return shim;
    }
    shim = shims.size() > 0 ? shims.pop() : null;
    if (shim == null) {
      shim = createShim();
      shim.setVisible(false);
    }
    El pn = getParent();
    El p = shim.getParent();
    if (p != null && p.dom == XDOM.getBody()) {
      pn.insertChild(shim.dom, 0);
    } else if (p == null || pn.dom != p.dom) {
      pn.insertBefore(shim.dom, dom);
    }
    shim.setZIndex(getZIndex() - 2);
    return shim;
  }

  /**
   * Hides the layer's shadow.
   */
  public void hideShadow() {
    if (shadow != null) {
      shadow.hide();
      shadow.removeFromParent();
      shadows.push(shadow);
      shadow = null;
    }
  }

  /**
   * Hides the shim.
   */
  public void hideShim() {
    if (shim != null) {
      shim.hide();
      shim.removeFromParent();
      shims.push(shim);
      shim = null;
    }
  }

  /**
   * Hides the shim and the shadow.
   */
  public void hideUnders() {
    hideShadow();
    hideShim();
  }

  @Override
  public El remove() {
    super.remove();
    hideUnders();
    return this;
  }

  @Override
  public El setHeight(int height, boolean adjust) {
    super.setHeight(height, adjust);
    sync(true);
    return this;
  }

  @Override
  public El setHeight(String height) {
    super.setHeight(height);
    sync(true);
    return this;
  }

  @Override
  public El setLeft(int left) {
    super.setLeft(left);
    sync(true);
    return this;
  }

  /**
   * Sets the shadow position (defaults to SIDES).
   * 
   * @param shadowPosition the position
   */
  public void setShadowPosition(ShadowPosition shadowPosition) {
    this.shadowPosition = shadowPosition;
    int radius = shadowOffset / 2;
    shadowAdjusts = new Rectangle();
    switch (shadowPosition) {
      case SIDES:
        shadowAdjusts.width = shadowOffset * 2;
        shadowAdjusts.x = -shadowOffset;
        shadowAdjusts.y = shadowOffset - 1;
        if (GXT.isIE) {
          shadowAdjusts.x -= (shadowOffset - radius);
          shadowAdjusts.y -= (shadowOffset + radius);
          shadowAdjusts.x += 1;
          shadowAdjusts.width -= (shadowOffset - radius) * 2;
          shadowAdjusts.width -= radius + 1;
          shadowAdjusts.height -= 1;
        }
        break;
      case FRAME:
        shadowAdjusts.width = shadowAdjusts.height = (shadowOffset * 2);
        shadowAdjusts.x = shadowAdjusts.y = -shadowOffset;
        shadowAdjusts.y += 1;
        shadowAdjusts.height -= 2;
        if (GXT.isIE) {
          shadowAdjusts.x -= (shadowOffset - radius);
          shadowAdjusts.y -= (shadowOffset - radius);
          shadowAdjusts.width -= (shadowOffset + radius);
          shadowAdjusts.width += 1;
          shadowAdjusts.height -= (shadowOffset + radius);
          shadowAdjusts.height += 3;
        }
        break;
      default:
        shadowAdjusts.width = 0;
        shadowAdjusts.x = shadowAdjusts.y = shadowOffset;
        shadowAdjusts.y -= 1;
        if (GXT.isIE) {
          shadowAdjusts.x -= shadowOffset + radius;
          shadowAdjusts.y -= shadowOffset + radius;
          shadowAdjusts.width -= radius;
          shadowAdjusts.height -= radius;
          shadowAdjusts.y += 1;
        }
        break;
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

  @Override
  public El setTop(int top) {
    super.setTop(top);
    sync(true);
    return this;
  }

  @Override
  public El setVisibility(boolean visible) {
    super.setVisibility(visible);
    if (!visible) {
      hideUnders();
    } else {
      sync(true);
    }
    return this;
  }

  @Override
  public El setVisible(boolean visible) {
    super.setVisible(visible);
    if (!visible) {
      hideUnders();
    } else {
      sync(true);
    }
    return this;
  }

  @Override
  public El setWidth(int width, boolean adjust) {
    super.setWidth(width, adjust);
    sync(true);
    return this;
  }

  @Override
  public El setWidth(String width) {
    super.setWidth(width);
    sync(true);
    return this;
  }

  @Override
  public El setXY(int x, int y) {
    super.setXY(x, y);
    sync(true);
    return this;
  }

  @Override
  public El setZIndex(int zIndex) {
    super.setZIndex(zIndex);
    if (shadow != null) {
      shadow.setZIndex(zIndex - 1);
    }
    if (shim != null) {
      shim.setZIndex(zIndex - 2);
    }
    return this;
  }

  /**
   * Syncs the shadow and shim.
   * 
   * @param show true to show
   */
  @Override
  public El sync(boolean show) {
    super.sync(show);
    if (isVisible() && (shadowEnabled || shimEnabled)) {
      int w = getWidth();
      int h = getHeight();
      int l = getLeft();
      int t = getTop();

      if (shadowEnabled && getParent() != null) {
        if (shadow == null) {
          shadow = getShadow();
        }
        if (shadow != null && show) {
          shadow.show();
        }
        shadow.setLeft(l + shadowAdjusts.x);
        shadow.setTop(t + shadowAdjusts.y);

        int sw = w + shadowAdjusts.width;
        int sh = h + shadowAdjusts.height;
        if (shadow.getWidth() != sw || shadow.getHeight() != sh) {
          shadow.setSize(sw, sh);
          if (!GXT.isIE) {
            int width = Math.max(0, sw - 12);
            fly((Element) shadow.dom.getChildNodes().getItem(0).getChildNodes().getItem(1)).setWidth(width);
            fly((Element) shadow.dom.getChildNodes().getItem(1).getChildNodes().getItem(1)).setWidth(width);
            fly((Element) shadow.dom.getChildNodes().getItem(2).getChildNodes().getItem(1)).setWidth(width);
            int height = Math.max(0, sh - 12);
            fly((Element) shadow.dom.getChildNodes().getItem(1)).setHeight(height);
          }
        }
      }
      if (shimEnabled) {
        if (shim == null) {
          shim = getShim();
        }
        if (show) {
          shim.setVisible(true);
        }
        Rectangle a = shadow == null ? new Rectangle(0, 0, 0, 0) : shadowAdjusts;

        if (GXT.isIE && shadow != null && shadow.isVisible()) {
          w += 8;
          h += 8;
        }

        try {
          shim.setLeft(Math.min(l, l + a.x));
          shim.setTop(Math.min(t, t + a.y));
          shim.setWidth(Math.max(1, w + a.width));
          shim.setHeight(Math.max(1, h + a.height));
        } catch (Exception e) {
          GWT.log("shim error", e);
        }

      }
    }
    return this;
  }

}

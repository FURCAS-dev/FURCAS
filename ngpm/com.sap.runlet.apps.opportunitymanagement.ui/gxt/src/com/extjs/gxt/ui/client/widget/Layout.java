/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.ContainerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.LayoutEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.extjs.gxt.ui.client.widget.layout.MarginData;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Layout provides the basic foundation for all other layout classes in GXT. It
 * is a non-visual class that simply provides the base logic required to
 * function as a layout. This class is intended to be extended.
 * 
 * <p/>
 * Layout instances should not be shared with multiple containers.
 * 
 * @see LayoutContainer
 */
public abstract class Layout extends BaseObservable {

  protected Container<Component> container;
  protected El target;
  protected Component activeItem;
  protected boolean renderHidden;
  protected boolean monitorResize;

  private String extraStyle;
  @SuppressWarnings("unchecked")
  private Listener<ContainerEvent> listener;
  private int resizeDelay = 0;

  private Listener<ComponentEvent> resizeListener = new Listener<ComponentEvent>() {
    public void handleEvent(ComponentEvent ce) {
      onResize(ce);
    }
  };

  private DelayedTask task = new DelayedTask(new Listener<BaseEvent>() {
    public void handleEvent(BaseEvent be) {
      if (container != null) {
        layout();
      }
    }
  });

  /**
   * Returns the extra style name.
   * 
   * @return the extra style
   */
  public String getExtraStyle() {
    return extraStyle;
  }

  /**
   * Returns the window resize delay.
   * 
   * @return the delay
   */
  public int getResizeDelay() {
    return resizeDelay;
  }

  /**
   * Returns true if the container will be render child components hidden.
   * 
   * @return the render hidden state
   */
  public boolean isRenderHidden() {
    return renderHidden;
  }

  /**
   * Layouts the container, by executing it's layout.
   */
  public void layout() {
    El target = container.getLayoutTarget();
    onLayout(container, target);
    fireEvent(Events.AfterLayout, new LayoutEvent(container, this));
  }

  /**
   * Sets the layout's container.
   * 
   * @param ct the container
   */
  @SuppressWarnings("unchecked")
  public void setContainer(Container ct) {
    if (listener == null) {
      listener = new Listener<ContainerEvent>() {
        public void handleEvent(ContainerEvent be) {
          onRemove(be.getItem());
        }
      };
    }

    if (this.container != null) {
      this.container.removeListener(Events.BeforeRemove, listener);
    }

    if (monitorResize && container != ct) {
      if (container != null) {
        container.removeListener(Events.Resize, resizeListener);
      }
      if (ct != null) {
        ct.addListener(Events.Resize, resizeListener);
      }
    }
    this.container = ct;
    this.container.addListener(Events.BeforeRemove, listener);
  }

  /**
   * Sets an optional extra CSS style name that will be added to the container.
   * This can be useful for adding customized styles to the container or any of
   * its children using standard CSS rules.
   * 
   * @param extraStyle the extra style name
   */
  public void setExtraStyle(String extraStyle) {
    this.extraStyle = extraStyle;
  }

  /**
   * True to hide each contained component on render (defaults to false).
   * 
   * @param renderHidden true to render hidden
   */
  public void setRenderHidden(boolean renderHidden) {
    this.renderHidden = renderHidden;
  }

  /**
   * Sets the number of milliseconds to buffer resize events (defaults to 0).
   * Only applies when {@link #monitorResize} = true.
   * 
   * @param resizeDelay the delay in milliseconds
   */
  public void setResizeDelay(int resizeDelay) {
    this.resizeDelay = resizeDelay;
  }

  protected void applyMargins(El target, Margins margins) {
    if (margins == null) return;
    target.setStyleAttribute("marginLeft", margins.left + "px");
    target.setStyleAttribute("marginTop", margins.top + "px");
    target.setStyleAttribute("marginRight", margins.right + "px");
    target.setStyleAttribute("marginBottom", margins.bottom + "px");
  }

  protected void applyPadding(El target, Padding paddings) {
    if (paddings == null) return;
    target.setStyleAttribute("paddingLeft", paddings.left + "px");
    target.setStyleAttribute("paddingTop", paddings.top + "px");
    target.setStyleAttribute("paddingRight", paddings.right + "px");
    target.setStyleAttribute("paddingBottom", paddings.bottom + "px");
  }

  protected El fly(com.google.gwt.dom.client.Element elem) {
    return El.fly(elem);
  }

  protected El fly(Element elem) {
    return El.fly(elem);
  }

  protected LayoutData getLayoutData(Component c) {
    return ComponentHelper.getLayoutData(c);
  }

  protected int getSideMargins(Component c) {
    if (GXT.isWebKit) {
      try {
        Object data = getLayoutData(c);
        if (data != null && data instanceof MarginData) {
          MarginData m = (MarginData) data;
          Margins margins = m.getMargins();
          if (margins == null) {
            return 0;
          }
          int tot = 0;
          if (margins.left != -1) {
            tot += margins.left;
          }
          if (margins.right != -1) {
            tot += margins.right;
          }
          return tot;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

    } else {
      return c.el().getMargins("lr");
    }
    return 0;
  }

  protected boolean isValidParent(Element elem, Element parent) {
    return elem.getParentElement() != null && elem.getParentElement() == parent;
  }

  protected void layoutContainer() {
    container.layout();
  }

  protected void onLayout(Container<?> container, El target) {
    this.target = target;
    renderAll(container, target);
  }

  protected void onRemove(Component component) {
    if (activeItem == component) {
      activeItem = null;
    }
  }

  protected void onResize(ComponentEvent ce) {
    task.delay(resizeDelay);
  }

  @SuppressWarnings("unchecked")
  protected void renderAll(Container container, El target) {
    int count = container.getItemCount();
    for (int i = 0; i < count; i++) {
      Component c = container.getItem(i);
      if (!c.isRendered() || !isValidParent(c.el().dom, target.dom)) {
        renderComponent(c, i, target);
      }
    }
  }

  protected void renderComponent(Component component, int index, El target) {
    if (component.isRendered()) {
      target.insertChild(component.el().dom, index);
    } else {
      component.render(target.dom, index);
    }
    if (extraStyle != null) {
      component.addStyleName(extraStyle);
    }
    if (renderHidden && component != activeItem) {
      component.setVisible(false);
    }
    LayoutData data = component.getLayoutData();
    if (data != null && data instanceof MarginData) {
      MarginData ld = (MarginData) data;
      applyMargins(component.el(), ld.getMargins());
    }
  }

  protected void setBounds(Widget w, int x, int y, int width, int height) {
    if (w instanceof BoxComponent) {
      ((BoxComponent) w).setBounds(x, y, width, height);
    } else {
      fly(w.getElement()).setBounds(x, y, width, height, true);
    }
  }

  protected void setLayoutData(Component c, LayoutData data) {
    ComponentHelper.setLayoutData(c, data);
  }

  protected void setSize(Component c, int width, int height) {
    if (c instanceof BoxComponent) {
      ((BoxComponent) c).setSize(width, height);
    } else if (c.isRendered()) {
      fly(c.getElement()).setSize(width, height, true);
    }
  }

  protected native void setLayoutOnChange(Container<?> c, boolean change) /*-{
     c.@com.extjs.gxt.ui.client.widget.Container::layoutOnChange = change;
   }-*/;

  protected native void setLayoutNeeded(Container<?> c, boolean needed) /*-{
     c.@com.extjs.gxt.ui.client.widget.Container::layoutNeeded = needed;
   }-*/;

  protected native boolean isLayoutNeeded(Container<?> c) /*-{
     return c.@com.extjs.gxt.ui.client.widget.Container::layoutNeeded;
   }-*/;

}

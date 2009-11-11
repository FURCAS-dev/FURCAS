/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SplitBarEvent;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.CollapsePanel;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Layout;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.SplitBar;
import com.extjs.gxt.ui.client.widget.button.ToolButton;

/**
 * This is a multi-pane, application-oriented UI layout style that supports
 * multiple regions, automatic split bars between regions and built-in expanding
 * and collapsing of regions.
 * 
 * <p />
 * The children of the container using a border layout positions it's children
 * absolutely. Because of this, a specific height and width must be set on any
 * container using a border layout. The size can be set directly, or by a parent
 * layout.
 * 
 * <p />
 * Rather then act on the child components directly, expanding, collapsing,
 * hiding, and showing use the methods provided by border layout (
 * {@link #expand}, {@link #collapse}, {@link #hide}, and {@link #collapse}.
 * 
 * <p />
 * Be default, this layout adds a CSS style to the parent container (defaults to
 * 'x-border-layout-ct') which gives the container a background color.
 * 
 * <p />
 * Code snippet:
 * 
 * <pre>
 * public class BorderLayoutExample extends LayoutContainer {
 * 
 *   public BorderLayoutExample() {
 *     setLayout(new BorderLayout());
 * 
 *     ContentPanel west = new ContentPanel();
 *     ContentPanel center = new ContentPanel();
 * 
 *     BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 200);
 *     westData.setSplit(true);
 *     westData.setCollapsible(true);
 *     westData.setMargins(new Margins(5));
 * 
 *     BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
 *     centerData.setMargins(new Margins(5, 0, 5, 0));
 * 
 *     add(west, westData);
 *     add(center, centerData);
 *   }
 * }
 * </pre>
 * 
 * </p>
 */
public class BorderLayout extends Layout {

  protected Map<LayoutRegion, SplitBar> splitBars;

  private boolean enableState = true;
  private Listener<ComponentEvent> collapseListener;
  private BoxComponent north, south;
  private BoxComponent west, east, center;
  private boolean rendered;
  private LayoutContainer layoutContainer;
  private String containerStyle = "x-border-layout-ct";
  private Rectangle lastCenter;

  public BorderLayout() {
    monitorResize = true;
    splitBars = new HashMap<LayoutRegion, SplitBar>();
    collapseListener = new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent e) {
        EventType type = e.getType();
        if (type == Events.BeforeCollapse) {
          e.setCancelled(true);
          onCollapse(e.<ContentPanel> getComponent());
        } else if (type == Events.BeforeExpand) {
          e.setCancelled(true);
          onExpand(e.<ContentPanel> getComponent());
        }
      }
    };
  }

  /**
   * Collapses the panel in the given region.
   * 
   * @param region the region to be collapsed
   */
  public void collapse(LayoutRegion region) {
    Component c = getRegionWidget(region);
    if (c != null && c instanceof ContentPanel && !(c instanceof CollapsePanel)) {
      onCollapse((ContentPanel) c);
    }
  }

  /**
   * Expands the panel in the given region.
   * 
   * @param region the region to expand
   */
  public void expand(LayoutRegion region) {
    Component c = getRegionWidget(region);
    if (c != null && c instanceof CollapsePanel) {
      ContentPanel cp = (ContentPanel) c.getData("panel");
      onExpand(cp);
    }
  }

  /**
   * Returns true if state is enabled.
   * 
   * @return the enabled state flag
   */
  public boolean getEnableState() {
    return enableState;
  }

  public void hide(LayoutRegion region) {
    Component c = getRegionWidget(region);
    if (c != null) {
      BorderLayoutData data = (BorderLayoutData) getLayoutData(c);
      data.setHidden(true);
      layout();
    }
  }

  /**
   * Sets the CSS style name to be added to the layout's container (defaults to
   * 'x-border-layout-ct').
   * 
   * @param style the style name
   */
  public void setContainerStyle(String style) {
    this.containerStyle = style;
  }

  /**
   * True to enabled state (defaults to true). When true, expand / collapse and
   * size state is persisted across user sessions.
   * 
   * @param enableState true to enable state
   */
  public void setEnableState(boolean enableState) {
    this.enableState = enableState;
  }

  public void show(LayoutRegion region) {
    Component c = getRegionWidget(region);
    if (c != null) {
      BorderLayoutData data = (BorderLayoutData) getLayoutData(c);
      data.setHidden(false);
      layout();
    }
  }

  protected SplitBar createSplitBar(LayoutRegion region, BoxComponent component) {
    return new SplitBar(region, component);
  }

  @Override
  protected void onLayout(Container<?> container, El target) {
    super.onLayout(container, target);
    layoutContainer = (LayoutContainer) container;
    if (!rendered) {
      target.makePositionable();
      target.addStyleName(containerStyle);
      List<Component> list = new ArrayList<Component>(container.getItems());
      for (int i = 0; i < list.size(); i++) {
        Component c = list.get(i);
        if (!c.isRendered()) {
          c.addStyleName("x-border-panel");
          c.render(target.dom, i);
        }
        if (enableState) {
          BorderLayoutData data = (BorderLayoutData) getLayoutData(c);
          Map<String, Object> st = c.getState();
          if (st.containsKey("collapsed") && (c instanceof ContentPanel)) {
            switchPanels((ContentPanel) c);
          } else if (st.containsKey("size") && (c instanceof BoxComponent)
              && (!(c instanceof CollapsePanel))) {
            data.setSize((Float) st.get("size"));
          }
        }
      }
      rendered = true;
    }

    Rectangle rect = target.getBounds();
    int w = rect.width - target.getBorderWidth("lr");
    int h = rect.height - target.getBorderWidth("tb");
    int centerW = w, centerH = h, centerY = 0, centerX = 0;

    north = getRegionWidget(LayoutRegion.NORTH);
    south = getRegionWidget(LayoutRegion.SOUTH);
    west = getRegionWidget(LayoutRegion.WEST);
    east = getRegionWidget(LayoutRegion.EAST);
    center = getRegionWidget(LayoutRegion.CENTER);

    if (north != null) {
      BorderLayoutData data = (BorderLayoutData) getLayoutData(north);
      north.setVisible(!data.isHidden());
      if (!data.isHidden()) {
        if (north.getData("init") == null) {
          initPanel(north);
        }
        if (data.isSplit()) {
          initSplitBar(LayoutRegion.SOUTH, north, data);
        } else {
          removeSplitBar(LayoutRegion.SOUTH);
        }
        Rectangle b = new Rectangle();
        Margins m = data.getMargins();
        float s = data.getSize() < 1 ? data.getSize() * rect.height : data.getSize();
        b.height = (int) s;
        b.width = w - (m.left + m.right);
        b.x = m.left;
        b.y = m.top;
        centerY = b.height + b.y + m.bottom;
        centerH -= centerY;
        applyLayout(north, b);
      }

    }
    if (south != null) {
      BorderLayoutData data = (BorderLayoutData) getLayoutData(south);
      south.setVisible(!data.isHidden());
      if (!data.isHidden()) {
        if (south.getData("init") == null) {
          initPanel(south);
        }
        if (data.isSplit()) {
          initSplitBar(LayoutRegion.NORTH, south, data);
        } else {
          removeSplitBar(LayoutRegion.NORTH);
        }
        Rectangle b = south.getBounds(false);
        Margins m = data.getMargins();
        float s = data.getSize() < 1 ? data.getSize() * rect.height : data.getSize();
        b.height = (int) s;
        b.width = w - (m.left + m.right);
        b.x = m.left;
        int totalHeight = (b.height + m.top + m.bottom);
        b.y = h - totalHeight + m.top;
        centerH -= totalHeight;
        applyLayout(south, b);
      }
    }

    if (west != null) {
      BorderLayoutData data = (BorderLayoutData) getLayoutData(west);
      west.setVisible(!data.isHidden());
      if (!data.isHidden()) {
        if (west.getData("init") == null) {
          initPanel(west);
        }

        if (data.isSplit()) {
          initSplitBar(LayoutRegion.EAST, west, data);
        } else {
          removeSplitBar(LayoutRegion.EAST);
        }

        Rectangle box = new Rectangle();
        Margins m = data.getMargins();
        float s = data.getSize() < 1 ? data.getSize() * rect.width : data.getSize();
        box.width = (int) s;
        box.height = centerH - (m.top + m.bottom);
        box.x = m.left;
        box.y = centerY + m.top;
        int totalWidth = (box.width + m.left + m.right);
        centerX += totalWidth;
        centerW -= totalWidth;
        applyLayout(west, box);

      }

    }
    if (east != null) {
      BorderLayoutData data = (BorderLayoutData) getLayoutData(east);
      east.setVisible(!data.isHidden());
      if (!data.isHidden()) {
        if (east.getData("init") == null) {
          initPanel(east);
        }

        if (data.isSplit()) {
          initSplitBar(LayoutRegion.WEST, east, data);
        } else {
          removeSplitBar(LayoutRegion.WEST);
        }
        Rectangle b = east.getBounds(false);
        Margins m = data.getMargins();
        float s = data.getSize() < 1 ? data.getSize() * rect.width : data.getSize();
        b.width = (int) s;
        b.height = centerH - (m.top + m.bottom);
        int totalWidth = (b.width + m.left + m.right);
        b.x = w - totalWidth + m.left;
        b.y = centerY + m.top;
        centerW -= totalWidth;
        applyLayout(east, b);
      }
    }

    lastCenter = new Rectangle(centerX, centerY, centerW, centerH);

    if (center != null) {
      BorderLayoutData data = (BorderLayoutData) getLayoutData(center);
      Margins m = data.getMargins();
      lastCenter.x = centerX + m.left;
      lastCenter.y = centerY + m.top;
      lastCenter.width = centerW - (m.left + m.right);
      lastCenter.height = centerH - (m.top + m.bottom);
      applyLayout(center, lastCenter);
    }
  }

  @Override
  protected void onRemove(Component component) {
    super.onRemove(component);
    if (component instanceof ContentPanel) {
      ContentPanel panel = (ContentPanel) component;
      if (panel.getData("collapseBtn") != null) {
        Component tool = (Component) panel.getData("collapseBtn");
        tool.removeAllListeners();
        panel.getHeader().removeTool(tool);
      }
      panel.removeListener(Events.BeforeCollapse, collapseListener);
      panel.removeListener(Events.BeforeExpand, collapseListener);
    }
    component.setData("init", null);
    component.setData("collapseBtn", null);
    component.setData("collapse", null);

    SplitBar splitBar = component.getData("splitBar");
    if (splitBar != null) {
      splitBar.release();
      component.setData("splitBar", null);
    }
  }

  private void applyLayout(BoxComponent component, Rectangle box) {
    component.el().makePositionable(true);
    component.el().setLeftTop(box.x, box.y);
    component.setSize(box.width, box.height);
  }

  private CollapsePanel createCollapsePanel(ContentPanel panel, BorderLayoutData data) {
    CollapsePanel cp = new CollapsePanel(panel, data) {
      protected void onExpandButton(BaseEvent be) {
        if (isExpanded()) {
          setExpanded(false);
        }
        onExpandClick(this);
      }
    };
    BorderLayoutData collapseData = new BorderLayoutData(data.getRegion());
    collapseData.setSize(24);
    collapseData.setMargins(data.getMargins());
    ComponentHelper.setLayoutData(cp, collapseData);
    cp.setData("panel", panel);
    panel.setData("collapse", cp);
    return cp;
  }

  private BoxComponent getRegionWidget(LayoutRegion region) {
    for (int i = 0; i < container.getItemCount(); i++) {
      BoxComponent w = (BoxComponent) container.getItem(i);
      if (getLayoutData(w) != null && getLayoutData(w) instanceof BorderLayoutData) {
        BorderLayoutData data = (BorderLayoutData) getLayoutData(w);
        if (data.getRegion() == region) {
          w.el().makePositionable(true);
          return w;
        }
      }
    }
    return null;
  }

  private void initPanel(BoxComponent component) {
    BorderLayoutData data = (BorderLayoutData) getLayoutData(component);
    String icon = null;
    switch (data.getRegion()) {
      case WEST:
        icon = "left";
        break;
      case EAST:
        icon = "right";
        break;
      case NORTH:
        icon = "up";
        break;
      case SOUTH:
        icon = "down";
        break;
    }
    if (data.isCollapsible() && component instanceof ContentPanel) {
      final ContentPanel panel = (ContentPanel) component;
      ToolButton collapse = (ToolButton) panel.getData("collapseBtn");
      if (!data.getHideCollapseTool() && collapse == null) {
        collapse = new ToolButton("x-tool-" + icon);
        collapse.addListener(Events.Select, new Listener<ComponentEvent>() {
          public void handleEvent(ComponentEvent be) {
            panel.collapse();
          }
        });
        panel.setData("collapseBtn", collapse);
        panel.getHeader().addTool(collapse);
        collapse.setData("panel", panel);
      }
      panel.removeListener(Events.BeforeCollapse, collapseListener);
      panel.removeListener(Events.BeforeExpand, collapseListener);
      panel.addListener(Events.BeforeCollapse, collapseListener);
      panel.addListener(Events.BeforeExpand, collapseListener);
      panel.setData("init", "true");
    }

  }

  private void initSplitBar(final LayoutRegion region, final BoxComponent component,
      final BorderLayoutData data) {
    SplitBar bar = (SplitBar) component.getData("splitBar");
    if (bar == null || bar.getResizeWidget() != component) {
      bar = createSplitBar(region, component);
      final SplitBar fBar = bar;
      Listener<ComponentEvent> splitBarListener = new Listener<ComponentEvent>() {
        public void handleEvent(ComponentEvent ce) {
          boolean side = region == LayoutRegion.WEST || region == LayoutRegion.EAST;
          int size = side ? component.getOffsetWidth() : component.getOffsetHeight();
          int centerSize = side ? lastCenter.width : lastCenter.height;

          fBar.setMinSize(data.getMinSize());
          fBar.setMaxSize(Math.min(size + centerSize, data.getMaxSize()));
        }
      };
      component.setData("splitBar", bar);

      bar.addListener(Events.DragStart, splitBarListener);
      bar.setMinSize(data.getMinSize());
      bar.setMaxSize(data.getMaxSize() == 0 ? bar.getMaxSize() : data.getMaxSize());
      bar.setAutoSize(false);
      bar.addListener(Events.Resize, new Listener<SplitBarEvent>() {
        public void handleEvent(SplitBarEvent sbe) {
          if (sbe.getSize() < 1) {
            return;
          }
          data.setSize(sbe.getSize());
          Component c = sbe.getSplitBar().getResizeWidget();
          Map<String, Object> state = c.getState();
          state.put("size", data.getSize());
          c.saveState();
          layout();
        }
      });
      component.setData("splitBar", bar);
    }
  }

  private void onCollapse(ContentPanel panel) {
    if (!layoutContainer.getItems().contains(panel)) {
      return;
    }

    BorderLayoutData data = (BorderLayoutData) getLayoutData(panel);
    layoutContainer.remove(panel);
    Map<String, Object> st = panel.getState();
    st.put("collapsed", true);
    panel.saveState();
    setCollapsed(panel, true);

    CollapsePanel cp = (CollapsePanel) panel.getData("collapse");
    if (cp == null) {
      cp = createCollapsePanel(panel, data);
    }
    layoutContainer.add(cp);
    layoutContainer.layout();
  }

  private void onExpand(ContentPanel panel) {
    setCollapsed(panel, false);
    CollapsePanel cp = panel.getData("collapse");
    Map<String, Object> st = panel.getState();
    st.remove("collapsed");
    panel.saveState();
    layoutContainer.remove(cp);
    layoutContainer.add(panel);
    layoutContainer.layout();
  }

  private void onExpandClick(CollapsePanel cp) {
    ContentPanel panel = cp.getContentPanel();
    onExpand(panel);
  }

  private void removeSplitBar(LayoutRegion region) {
    splitBars.put(region, null);
  }

  private native void setCollapsed(ContentPanel panel, boolean collapse) /*-{
    panel.@com.extjs.gxt.ui.client.widget.ContentPanel::collapsed = collapse;
  }-*/;

  private void switchPanels(ContentPanel panel) {
    BorderLayoutData data = (BorderLayoutData) getLayoutData(panel);
    layoutContainer.remove(panel);
    CollapsePanel cp = (CollapsePanel) panel.getData("collapse");
    if (cp == null) {
      cp = createCollapsePanel(panel, data);
    }
    initPanel(panel);
    setCollapsed(panel, true);
    layoutContainer.add(cp);
    renderComponent(cp, 0, layoutContainer.getLayoutTarget());
  }

}

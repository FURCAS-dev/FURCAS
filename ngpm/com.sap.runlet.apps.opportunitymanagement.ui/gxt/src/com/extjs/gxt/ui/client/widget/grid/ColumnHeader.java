/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DragEvent;
import com.extjs.gxt.ui.client.event.DragListener;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.util.Region;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTMLTable.RowFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;

class ColumnHeader extends BoxComponent {

  class GridSplitBar extends BoxComponent {

    private int colIndex;
    private Draggable d;
    private boolean dragging;
    private DragListener listener = new DragListener() {

      @Override
      public void dragEnd(DragEvent de) {
        onDragEnd(de);
      }

      @Override
      public void dragStart(DragEvent de) {
        onDragStart(de);
      }

    };
    private int startX;

    protected void onDragEnd(DragEvent e) {
      dragging = false;
      headerDisabled = false;
      setStyleAttribute("borderLeft", "none");
      el().setStyleAttribute("opacity", "0");
      el().setWidth(splitterWidth);
      bar.el().setVisibility(false);

      int endX = e.getEvent().getClientX();
      int diff = endX - startX;
      onColumnSplitterMoved(colIndex, cm.getColumnWidth(colIndex) + diff);
    }

    protected void onDragStart(DragEvent e) {
      headerDisabled = true;
      dragging = true;
      setStyleAttribute("borderLeft", "1px solid black");
      setStyleAttribute("cursor", "default");
      el().setStyleAttribute("opacity", "1");
      el().setWidth(1);

      startX = e.getX();

      int cols = cm.getColumnCount();
      for (int i = 0, len = cols; i < len; i++) {
        if (cm.isHidden(i)) continue;
        Element hd = getHead(i).getElement();
        if (hd != null) {
          Region rr = El.fly(hd).getRegion();
          if (startX > rr.right - 5 && startX < rr.right + 5) {
            colIndex = heads.indexOf(getHead(i));
            if (colIndex != -1) break;
          }
        }
      }
      if (colIndex > -1) {
        Element c = getHead(colIndex).getElement();
        int x = startX;
        int minx = x - fly((com.google.gwt.user.client.Element) c).getX() - minColumnWidth;
        int maxx = (container.el().getX() + container.el().getWidth()) - e.getEvent().getClientX();
        d.setXConstraint(minx, maxx);
      }
    }

    protected void onMouseMove(Head header, ComponentEvent ce) {
      int activeHdIndex = heads.indexOf(header);

      if (dragging) {
        return;
      }
      Event event = ce.getEvent();
      int x = event.getClientX();
      Region r = header.el().getRegion();
      int hw = splitterWidth;
      
      el().setY(container.el().getY());
      el().setHeight(container.getHeight());

      Style ss = getElement().getStyle();

      if (x - r.left <= hw && cm.isResizable(activeHdIndex - 1)) {
        bar.el().setVisibility(true);
        el().setX(r.left);
        ss.setProperty("cursor", GXT.isSafari ? "e-resize" : "col-resize");
      } else if (r.right - x <= hw && cm.isResizable(activeHdIndex)) {
        el().setX(r.right - (hw / 2));
        bar.el().setVisibility(true);
        ss.setProperty("cursor", GXT.isSafari ? "w-resize" : "col-resize");
      } else {
        bar.el().setVisibility(false);
        ss.setProperty("cursor", "");
      }
    }

    @Override
    protected void onRender(com.google.gwt.user.client.Element target, int index) {
      super.onRender(target, index);
      setElement(DOM.createDiv(), target, index);

      el().setStyleAttribute("cursor", "col-resize");
      setStyleAttribute("position", "absolute");
      setWidth(5);

      el().setVisibility(false);
      el().setStyleAttribute("backgroundColor", "white");
      el().setStyleAttribute("opacity", "0");

      d = new Draggable(this);
      d.setUseProxy(false);
      d.setConstrainVertical(true);
      d.addDragListener(listener);
    }
  }

  class Group extends BoxComponent {

    private HeaderGroupConfig config;

    public Group(HeaderGroupConfig config) {
      this.config = config;
      config.group = this;
      groups.add(this);
    }

    public void setText(String text) {
      el().setInnerHtml(text);
    }

    @Override
    protected void onRender(Element target, int index) {
      setElement(DOM.createDiv(), target, index);
      setStyleName("x-grid3-hd-inner");

      if (config.getWidget() != null) {
        el().appendChild(config.getWidget().getElement());
        ComponentHelper.doAttach(config.getWidget());
      } else {
        el().setInnerHtml(config.getHtml());
      }
    }

    @Override
    protected void doDetachChildren() {
      ComponentHelper.doDetach(config.getWidget());
    }

    @Override
    protected void doAttachChildren() {
      ComponentHelper.doAttach(config.getWidget());
    }
  }

  class Head extends BoxComponent {

    private ColumnConfig config;
    private AnchorElement btn;
    private ImageElement img;
    private Widget c;
    private Html text;
    private int column;

    public Head(ColumnConfig column) {
      this.config = column;
      this.column = cm.indexOf(column);
      baseStyle = "x-grid3-hd-inner x-grid3-hd-" + column.getId();
      heads.add(this);
    }

    public void activateTrigger(boolean activate) {
      El e = el().findParent("td", 3);
      if (e != null) {
        e.setStyleName("x-grid3-hd-menu-open", activate);
      }
    }

    public Element getTrigger() {
      return (Element) btn.cast();
    }

    @Override
    public void onComponentEvent(ComponentEvent ce) {
      super.onComponentEvent(ce);
      int type = ce.getEventTypeInt();
      switch (type) {
        case Event.ONMOUSEOVER:
          onMouseOver(ce);
          break;
        case Event.ONMOUSEOUT:
          onMouseOut(ce);
          break;
        case Event.ONMOUSEMOVE:
          onMouseMove(ce);
          break;
        case Event.ONMOUSEDOWN:
          onHeaderMouseDown(ce, cm.indexOf(config));
          break;
        case Event.ONCLICK:
          onClick(ce);
          break;
        case Event.ONDBLCLICK:
          onDoubleClick(ce);
          break;
      }
    }

    public void setHeader(String header) {
      text.setHtml(header);
    }

    public void updateWidth(int width) {
      if (!cm.isHidden(cm.indexOf(config))) {
        El td = el().findParent("td", 3);
        if (indexOf(this) == (heads.size() - 1)) {
          width++;
        }
        td.dom.getStyle().setProperty("width", width + "px");
        if (rows > 1) {
          if (GXT.isBorderBox) width -= 2;
          el().setWidth(width, true);
        }
      }
    }

    @Override
    protected void doAttachChildren() {
      super.doAttachChildren();
      ComponentHelper.doAttach(c);
    }

    @Override
    protected void doDetachChildren() {
      super.doDetachChildren();
      ComponentHelper.doDetach(c);
    }

    @Override
    protected void onRender(Element target, int index) {
      setElement(DOM.createDiv(), target, index);

      btn = Document.get().createAnchorElement();
      btn.setHref("#");
      btn.setClassName("x-grid3-hd-btn");
      btn.setAttribute("onclick", "return false");

      img = Document.get().createImageElement();
      img.setSrc(GXT.BLANK_IMAGE_URL);
      img.setClassName("x-grid3-sort-icon");

      text = new Html(config.getHeader());
      text.setTagName("span");

      el().dom.appendChild(btn);
      text.render(el().dom);

      el().dom.appendChild(img);

      String tip = config.getToolTip();
      if (tip != null) {
        getElement().setAttribute("qtip", tip);
      }

      sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS);
    }

    private void onClick(ComponentEvent ce) {
      ce.preventDefault();
      if (ce.getTarget() == (Element) btn.cast()) {
        onDropDownClick(ce, column);
      } else {
        onHeaderClick(ce, column);
      }
    }

    private void onDoubleClick(ComponentEvent ce) {
      onHeaderDoubleClick(ce, column);
    }

    private void onMouseMove(ComponentEvent ce) {
      if (bar != null) bar.onMouseMove(this, ce);
    }

    private void onMouseOut(ComponentEvent ce) {
      if (!ce.within(getElement(), true)) {
        el().findParent("td", 3).removeStyleName("x-grid3-hd-over");
      }
    }

    private void onMouseOver(ComponentEvent ce) {
      if (headerDisabled) {
        return;
      }
      if (!cm.isMenuDisabled(indexOf(this))) {
        El td = el().findParent("td", 3);
        td.addStyleName("x-grid3-hd-over");
        el().setHeight(td.getHeight(true), true);
        if (btn != null) {
          El.fly(btn).setHeight(td.getHeight(), true);
        }
      }
    }
  }

  protected BoxComponent container;
  protected ColumnModel cm;
  protected FlexTable table;

  private int minColumnWidth = 10;
  private boolean headerDisabled;
  private GridSplitBar bar;
  private int splitterWidth = 5;
  private List<Head> heads = new ArrayList<Head>();
  private List<Group> groups = new ArrayList<Group>();
  private Menu menu;
  private int rows;

  public ColumnHeader(BoxComponent container, ColumnModel cm) {
    this.container = container;
    this.cm = cm;
  }

  public void enableColumnResizing() {
    if (bar != null) {
      ComponentHelper.doDetach(bar);
    }
    bar = new GridSplitBar();
    bar.render(container.getElement());
    ComponentHelper.doAttach(bar);
  }

  public int getMinColumnWidth() {
    return minColumnWidth;
  }

  public int getSplitterWidth() {
    return splitterWidth;
  }

  public int indexOf(Head head) {
    return heads.indexOf(head);
  }

  public void refresh() {
    groups.clear();
    heads.clear();

    int cnt = table.getRowCount();
    for (int i = 0; i < cnt; i++) {
      table.removeRow(0);
    }

    table.setWidth(cm.getTotalWidth() + "");

    List<HeaderGroupConfig> configs = cm.getHeaderGroups();

    FlexCellFormatter cf = table.getFlexCellFormatter();
    RowFormatter rf = table.getRowFormatter();

    rows = 0;
    for (HeaderGroupConfig config : configs) {
      rows = Math.max(rows, config.getRow() + 1);
    }
    rows += 1;

    for (int i = 0; i < rows; i++) {
      rf.setStyleName(i, "x-grid3-hd-row");
    }

    int cols = cm.getColumnCount();

    for (HeaderGroupConfig config : cm.getHeaderGroups()) {
      int col = config.getColumn();
      int row = config.getRow();
      int rs = config.getRowspan();
      int cs = config.getColspan();

      Group group = new Group(config);

      boolean hide = true;
      if (cs > 1 && rows > 1) {
        for (int i = col; i < (col + cs); i++) {
          if (!cm.isHidden(i)) {
            hide = false;
          }
        }
      }
      if (hide) {
        continue;
      }

      table.setWidget(row, col, group);
      cf.setStyleName(row, col, "x-grid3-header x-grid3-hd x-grid3-cell");

      HorizontalAlignmentConstant halign = HasHorizontalAlignment.ALIGN_CENTER;
      cf.setHorizontalAlignment(row, col, halign);

      int ncs = cs;
      if (cs > 1) {
        for (int i = col; i < (col + cs); i++) {
          if (cm.isHidden(i)) {
            ncs -= 1;
          }
        }
      }

      cf.setRowSpan(row, col, rs);
      cf.setColSpan(row, col, ncs);
    }

    for (int i = 0; i < cols; i++) {
      Head h = new Head(cm.getColumn(i));
      if (cm.isHidden(i)) {
        continue;
      }
      int rowspan = 1;
      if (rows > 1) {
        for (int j = rows - 2; j >= 0; j--) {
          if (!cm.hasGroup(j, i)) {
            rowspan += 1;
          }
        }
      }

      int tw = cm.getColumnWidth(i);
      if (i == (cols - 1)) tw++;
      if (!GXT.isBorderBox) tw -= 2;

      if (rowspan > 1) {
        int r = (rows - 1) - (rowspan - 1);
        table.setWidget(r, i, h);
        table.getFlexCellFormatter().setRowSpan(r, i, rowspan);
        cf.setStyleName(r, i, "x-grid3-header x-grid3-hd x-grid3-cell");
        cf.getElement(r, i).getStyle().setPropertyPx("width", tw);
      } else {
        table.setWidget(rows - 1, i, h);
        cf.setStyleName(rows - 1, i, "x-grid3-header x-grid3-hd x-grid3-cell");
        cf.getElement(rows - 1, i).getStyle().setPropertyPx("width", tw);
      }
    }
    cleanCells();
  }

  public void setHeader(int column, String header) {
    getHead(column).setHeader(header);
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public void setMinColumnWidth(int minColumnWidth) {
    this.minColumnWidth = minColumnWidth;
  }

  public void setSplitterWidth(int splitterWidth) {
    this.splitterWidth = splitterWidth;
  }

  public void updateColumnHidden(int index, boolean hidden) {
    refresh();
    updateGroupWidths();
    cleanCells();
  }

  public void updateColumnWidth(int column, int width) {
    Head h = getHead(column);
    if (h != null) {
      h.updateWidth(width);
    }
    updateGroupWidths();
  }

  protected void updateGroupWidths() {
    for (Group group : groups) {
      if (!group.isRendered()) {
        continue;
      }
      // the group must be sized as table layout is auto and we need
      // content to clip if needed
      int col = group.config.getColumn();
      int w = getColumnWidths(col, col + group.config.getColspan());
      w -= (2 * group.config.getColspan());
      group.el().setWidth(w, true);
    }
  }

  protected int getColumnWidths(int start, int end) {
    int w = 0;
    for (int i = start; i < end; i++) {
      if (!cm.isHidden(i)) {
        w += cm.getColumnWidth(i);
      }
    }
    return w;
  }

  public void updateSortIcon(int colIndex, SortDir dir) {
    for (Head h : heads) {
      if (h.isRendered()) {
        h.el().findParent("td", 3).removeStyleName("sort-asc", "sort-desc");
      }
    }
    String s = dir == SortDir.DESC ? "sort-desc" : "sort-asc";
    Head h = heads.get(colIndex);
    h.el().findParent("td", 3).addStyleName(s);
  }

  protected ComponentEvent createColumnEvent(ColumnHeader header, int column, Menu menu) {
    return new ComponentEvent(header);
  }

  @Override
  protected void doAttachChildren() {
    super.doAttachChildren();
    ComponentHelper.doAttach(table);
  }

  @Override
  protected void doDetachChildren() {
    super.doDetachChildren();
    ComponentHelper.doDetach(table);
  }

  protected Menu getContextMenu(int column) {
    return menu;
  }

  protected Head getHead(int column) {
    return column < heads.size() ? heads.get(column) : null;
  }

  @Override
  protected void onAttach() {
    super.onAttach();
    cleanCells();
    adjustHeights();
  }

  private void cleanCells() {
    NodeList<Element> tds = table.getElement().getElementsByTagName("td").cast();
    for (int i = 0; i < tds.getLength(); i++) {
      Element td = tds.getItem(i);
      if (td.getInnerHTML().equals("")) {
        El.fly(td).removeFromParent();
      }
    }
    for (int i = 0; i < tds.getLength(); i++) {
      Element td = tds.getItem(i);
      if (td.getInnerHTML().equals("")) {
        El.fly(td).removeFromParent();
      }

    }
  }

  protected void onColumnSplitterMoved(int colIndex, int width) {

  }

  protected void onDropDownClick(ComponentEvent ce, int column) {
    ce.cancelBubble();
    ce.preventDefault();

    menu = getContextMenu(column);

    ComponentEvent ge = createColumnEvent(this, column, menu);
    if (!container.fireEvent(Events.HeaderContextMenu, ge)) {
      return;
    }

    final Head h = ce.getComponent();

    if (menu != null) {
      h.activateTrigger(true);
      menu.addListener(Events.Hide, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
          h.activateTrigger(false);
        }
      });
      menu.show(h.getTrigger(), "tl-bl?");
    }
  }

  protected void adjustHeights() {
    for (Head head : heads) {
      if (head.isRendered()) {
        int h = head.el().getParent().getHeight();
        head.el().setHeight(h, true);
        // head.el().setWidth(cm.getColumnWidth(head.column) - 1, true);
      }
    }
  }

  public void updateTotalWidth(int offset, int width) {
    table.getElement().getParentElement().getStyle().setPropertyPx("width", offset);
    table.getElement().getStyle().setProperty("width", width + "px");
  }

  protected void onHeaderClick(ComponentEvent ce, int column) {
    ComponentEvent evt = createColumnEvent(this, column, menu);
    evt.setEvent(ce.getEvent());
    container.fireEvent(Events.HeaderClick, evt);
  }

  protected void onHeaderDoubleClick(ComponentEvent ce, int column) {
    ComponentEvent evt = createColumnEvent(this, column, menu);
    evt.setEvent(ce.getEvent());
    container.fireEvent(Events.HeaderDoubleClick, evt);
  }

  protected void onHeaderMouseDown(ComponentEvent ce, int column) {
    ComponentEvent evt = createColumnEvent(this, column, menu);
    evt.setEvent(ce.getEvent());
    container.fireEvent(Events.HeaderMouseDown, evt);
  }

  @Override
  protected void onRender(Element target, int index) {
    table = new FlexTable();
    table.setCellPadding(0);
    table.setCellSpacing(0);

    table.getElement().getStyle().setProperty("tableLayout", "fixed");

    setElement(table.getElement(), target, index);
    refresh();

    // cannot use fixed layout with rows with colspan as widths
    // of child cells are evenly distributed, ignoring actual widths
    if (rows > 1) {
      table.getElement().getStyle().setProperty("tableLayout", "auto");
    }

    sinkEvents(Event.ONMOUSEMOVE);
  }

}

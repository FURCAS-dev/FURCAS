/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.table;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SplitBarEvent;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.SplitBar;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;

/**
 * @deprecated see {@link Grid}
 */
public class TableColumnUI extends BoxComponent {

  protected static String html;

  static {
    StringBuffer sb = new StringBuffer();
    sb.append("<div class=my-tbl-col-overflow style='text-align: {0}'>");
    sb.append("<div class=my-tbl-col-text>{1}</div>");
    sb.append("</div>");
    html = sb.toString();
  }

  protected int lastWidth;
  protected boolean end;
  protected int index;
  protected BaseTable table;
  protected TableColumn column;
  protected TableHeader header;
  protected SplitBar splitBar;
  protected Listener<ComponentEvent> splitBarListener = new Listener<ComponentEvent>() {
    public void handleEvent(ComponentEvent e) {
      EventType type = e.getType();
      if (type == Events.DragStart) {
        header.enableEvents(false);
      } else if (type == Events.DragEnd) {
        header.enableEvents(true);
      }
    }
  };

  protected TableColumnUI(BaseTable table, int index) {
    this.table = table;
    this.index = index;
    column = table.getColumn(index);
    header = table.getTableHeader();
  }

  public String getAlignment() {
    String align = "left";
    if (column != null) {
      if (column.getAlignment() == HorizontalAlignment.CENTER) {
        align = "center";
      } else if (column.getAlignment() == HorizontalAlignment.RIGHT) {
        align = "right";
      }
    }
    return align;
  }

  @Override
  protected void onRightClick(ComponentEvent ce) {
    super.onRightClick(ce);
    header.onRightClick(column, ce);
  }

  public void onBrowserEvent(Event event) {
    if (!header.isEnabled()) {
      return;
    }
    super.onBrowserEvent(event);
  }

  public void onColumnResize(SplitBarEvent sbe) {
    if (sbe.getSize() < 1) {
      return;
    }
    if (column.getWidth() < 1.1) {
      int pixWidth = sbe.getSize() - 6;
      float percent = (float) pixWidth / table.getColumnModel().getVariableWidth();
      table.getColumnModel().setWidthAsPercent(column.index, percent);
      header.resizeColumns(true, true);
    } else {
      column.setWidth(sbe.getSize());
      header.resizeColumn(index, true);
    }
  }

  public void onComponentEvent(ComponentEvent ce) {
    switch (ce.getEventTypeInt()) {
      case Event.ONMOUSEOVER:
        onMouseOver(ce);
        break;
      case Event.ONMOUSEOUT:
        onMouseOut(ce);
        break;
      case Event.ONCLICK:
        header.onColumnClick(this, ce);
        break;
    }
  }

  public void onMouseMove(BaseEvent be) {
    header.onColumnMouseMove(this, be);
  }

  public void onMouseOut(BaseEvent be) {
    removeStyleName("my-tbl-col-over");
  }

  public void onMouseOver(BaseEvent be) {
    addStyleName("my-tbl-col-over");
  }

  public void onSortChange(SortDir sortDir) {
    Element td = DOM.getParent(getElement());
    switch (sortDir) {
      case ASC:
        fly(td).addStyleName("my-tbl-col-sort");
        addStyleName("my-tbl-col-asc");
        break;
      case DESC:
        fly(td).addStyleName("my-tbl-col-sort");
        addStyleName("my-tbl-col-desc");
        break;
      case NONE:
        fly(td).removeStyleName("my-tbl-col-sort");
        removeStyleName("my-tbl-col-asc");
        removeStyleName("my-tbl-col-desc");
    }
  }

  public void onTextChange(String text) {
    El textEl = el().selectNode(".my-tbl-col-text");
    textEl.dom.setInnerHTML(text);
  }

  @Override
  protected void onRender(Element target, int index) {
    String[] params = null;
    if (end) {
      params = new String[] {"", ""};
    } else {
      params = new String[] {getAlignment(), column.getText()};
    }
    String s = Format.substitute(html, (Object[]) params);
    setElement(XDOM.create(s), target, index);

    if (column != null) {
      addStyleName("my-tbl-col-" + column.getId());
    }

    // TODO: remove hardcoded height
    el().setHeight(24);

    if (!end && column.isResizable()) {
      splitBar = header.createSplitBar(LayoutRegion.EAST, this);
      splitBar.setHandleWidth(5);
      splitBar.setXOffset(-2);
      splitBar.setAutoSize(false);
      splitBar.addListener(Events.Resize, new Listener<SplitBarEvent>() {
        public void handleEvent(SplitBarEvent ce) {
          onColumnResize(ce);
        }
      });
      splitBar.addListener(Events.DragStart, splitBarListener);
      splitBar.addListener(Events.DragEnd, splitBarListener);
    }

    sinkEvents(Event.ONCLICK | Event.MOUSEEVENTS);
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Column footer widget for Grid, which renders one to many aggregation rows.
 */
class ColumnFooter extends BoxComponent {

  class Foot extends SimplePanel {

    public Foot(AggregationRowConfig<?> config, String id) {
      setStyleName("x-grid3-cell-inner");
    }

    public void setHtml(String html) {
      setWidget(new HTML(html));
    }

    public void setWidget(Widget widget) {
      super.setWidget(widget);
    }
  }

  class FooterRow extends BoxComponent {

    private FlexTable table;
    private AggregationRowConfig<?> config;

    public FooterRow(AggregationRowConfig<?> config) {
      this.config = config;
      rows.add(this);
    }

    public void setHtml(int column, String html) {
      Foot f = (Foot) table.getWidget(0, column);
      f.setHtml(html);
    }

    public void setWidget(int column, Widget widget) {
      Foot f = (Foot) table.getWidget(0, column);
      f.setWidget(f);
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

    @Override
    protected void onRender(Element target, int index) {
      super.onRender(target, index);

      setElement(DOM.createDiv(), target, index);
      setStyleName("x-grid3-footer-row");

      table = new FlexTable();
      table.setCellPadding(0);
      table.setCellSpacing(0);

      int cols = cm.getColumnCount();
      for (int i = 0; i < cols; i++) {
        Foot f = new Foot(config, cm.getDataIndex(i));
        table.setWidget(0, i, f);
        table.getCellFormatter().setWidth(0, i, cm.getColumnWidth(i) + "");

        if (cm.getColumnAlignment(i) == HorizontalAlignment.RIGHT) {
          table.getCellFormatter().setHorizontalAlignment(0, i, HasHorizontalAlignment.ALIGN_RIGHT);
        }
      }
      el().appendChild(table.getElement());
    }
  }

  protected Grid<ModelData> grid;
  protected ColumnModel cm;
  protected List<FooterRow> rows = new ArrayList<FooterRow>();

  @SuppressWarnings("unchecked")
  public ColumnFooter(Grid grid, ColumnModel cm) {
    this.grid = grid;
    this.cm = cm;
  }

  public void add(FooterRow row) {
    rows.add(row);
  }

  @Override
  public void onComponentEvent(ComponentEvent ce) {
    super.onComponentEvent(ce);
    ce.stopEvent();
  }

  public void remove(FooterRow row) {
    rows.remove(row);
  }

  public void updateColumnHidden(int column, boolean hidden) {
    for (int i = 0; i < rows.size(); i++) {
      FooterRow footerRow = rows.get(i);
      Element td = footerRow.table.getFlexCellFormatter().getElement(0, column);
      td.getStyle().setProperty("display", hidden ? "none" : "");
    }
  }

  public void updateColumnWidth(int column, int width) {
    if (!cm.isHidden(column)) {
      for (int i = 0; i < rows.size(); i++) {
        FooterRow row = rows.get(i);
        row.table.getCellFormatter().setWidth(0, column, width + "");
        Widget w = row.table.getWidget(0, column);
        El.fly(w.getElement()).setWidth(width, true);
      }
    }
  }

  public void updateTotalWidth(int offset, int width) {
    for (int i = 0; i < rows.size(); i++) {
      FooterRow row = rows.get(i);
      row.setWidth(offset);
      row.table.getElement().getStyle().setProperty("width", width + "px");
    }
  }

  @Override
  protected void onRender(Element target, int index) {
    super.onRender(target, index);
    setElement(DOM.createDiv(), target, index);
    setStyleName("x-grid3-footer");
    setStyleAttribute("overflow", "hidden");

    int rows = cm.getAggregationRows().size();
    for (int i = 0; i < rows; i++) {
      FooterRow row = new FooterRow(cm.getAggregationRow(i));
      row.render(getElement());
    }

    refresh();
    sinkEvents(Event.MOUSEEVENTS);
  }

  @SuppressWarnings("unchecked")
  protected void refresh() {
    ListStore<ModelData> store = grid.getStore();
    int cols = cm.getColumnCount();
    int models = grid.getStore().getCount();
    int rowcount = rows.size();

    for (int i = 0; i < rowcount; i++) {
      AggregationRowConfig<?> config = cm.getAggregationRow(i);
      FooterRow footer = rows.get(i);

      for (int j = 0; j < cols; j++) {
        String name = cm.getDataIndex(j);
        
        if (config.getHtml(name) != null) {
          footer.setHtml(j, config.getHtml(name));
          continue;
        } else if (config.getWidget(name) != null) {
          footer.setWidget(j, config.getWidget(name));
          continue;
        }

        Number value = null;
        
        SummaryType<?> type = config.getSummaryType(name);
        if (type != null) {
          Map<String, Object> data = new HashMap<String, Object>();
          for (int k = 0; k < models; k++) {
            value = type.render(value, store.getAt(k), name, data);
          }
        }
        
        if (config.getModel() != null) {
          Object obj = config.getModel().get(cm.getDataIndex(i));
          if (obj != null && obj instanceof Number) {
            value = (Number)obj;
          } else if (obj != null) {
            footer.setHtml(j, obj.toString());
            continue;
          }
        }

        NumberFormat format = config.getSummaryFormat(name);
        if (format != null) {
          String svalue = format.format(value.doubleValue());
          footer.setHtml(j, svalue);
          continue;
        }

        AggregationRenderer<?> renderer = config.getRenderer(name);
        if (renderer != null) {
          Object obj = renderer.render(value, j, (Grid) grid, (ListStore) store);
          if (obj instanceof Widget) {
            footer.setWidget(j, (Widget) obj);
          } else {
            footer.setHtml(j, obj.toString());
          }
        }
      }
    }
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import com.extjs.gxt.ui.client.core.DomQuery;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Util;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentPlugin;
import com.google.gwt.user.client.Element;

/**
 * A column config and component plugin that adds the ability for each row to be
 * expanded, showing custom content that spans all the rows columns.
 */
public class RowExpander extends ColumnConfig implements ComponentPlugin {

  protected Grid<?> grid;
  private XTemplate template;

  /**
   * Creates a new row expander.
   */
  public RowExpander() {
    setHeader("");
    setWidth(20);
    setSortable(false);
    setResizable(false);
    setFixed(true);
    setMenuDisabled(true);
    setDataIndex("");
    setId("expander");

    setRenderer(new GridCellRenderer<ModelData>() {
      public String render(ModelData model, String property, ColumnData d, int rowIndex,
          int colIndex, ListStore<ModelData> store, Grid<ModelData> grid) {
        d.cellAttr = "rowspan='2'";
        return "<div class='x-grid3-row-expander'>&#160;</div>";
      }
    });

  }

  /**
   * Creates a new row expander with the given template.
   * 
   * @param template the template
   */
  public RowExpander(XTemplate template) {
    this();
    setTemplate(template);
  }

  @SuppressWarnings("unchecked")
  public void init(Component component) {
    this.grid = (Grid) component;

    GridView view = grid.getView();

    final GridViewConfig config = view.getViewConfig();
    view.viewConfig = new GridViewConfig() {
      @Override
      public String getRowStyle(ModelData model, int rowIndex, ListStore ds) {
        String s = "x-grid3-row-collapsed";
        if (config != null) {
          return s + " " + config.getRowStyle(model, rowIndex, ds);
        } else {
          return s;
        }
      }
    };

    view.enableRowBody = true;

    grid.addListener(Events.RowClick, new Listener<GridEvent>() {
      public void handleEvent(GridEvent be) {
        onMouseDown(be);
      }

    });

  }

  /**
   * Sets the template.
   * 
   * @param template the template
   */
  public void setTemplate(XTemplate template) {
    this.template = template;
  }

  protected boolean beforeExpand(ModelData model, Element body, El row, int rowIndex) {
    if (fireEvent(Events.BeforeExpand)) {
      body.setInnerHTML(getBodyContent(model, rowIndex));
      return true;
    }
    return false;
  }

  protected void collapseRow(El row) {
    if (fireEvent(Events.BeforeCollapse)) {
      row.replaceStyleName("x-grid3-row-expanded", "x-grid3-row-collapsed");
      fireEvent(Events.Collapse);
    }
  }

  protected void expandRow(El row) {
    int idx = row.dom.getPropertyInt("rowIndex");
    ModelData model = grid.getStore().getAt(idx);
    Element body = DomQuery.selectNode("tr:nth(2) div.x-grid3-row-body", row.dom);
    if (beforeExpand(model, body, row, idx)) {
      row.replaceStyleName("x-grid3-row-collapsed", "x-grid3-row-expanded");
      fireEvent(Events.Expand);
    }
  }

  protected String getBodyContent(ModelData model, int rowIndex) {
    return template.applyTemplate(Util.getJsObject(model, template.getMaxDepth()));
  }

  protected void onMouseDown(GridEvent<?> e) {
    if (e.getTarget().getClassName().equals("x-grid3-row-expander")) {
      e.stopEvent();
      El row = e.getTarget(".x-grid3-row", 15);
      toggleRow(row);
    }
  }

  protected void toggleRow(El row) {
    if (row.hasStyleName("x-grid3-row-collapsed")) {
      expandRow(row);
    } else {
      collapseRow(row);
    }
    grid.getView().calculateVBar(false);
  }

}

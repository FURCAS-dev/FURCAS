/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.table;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TableEvent;
import com.extjs.gxt.ui.client.event.TreeTableEvent;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.SplitBar;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.menu.CheckMenuItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.treetable.TreeTable;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;

/**
 * @deprecated see {@link Grid}
 */
public class TableHeader extends BoxComponent {

  protected static String html;

  static {
    StringBuffer sb = new StringBuffer();
    sb.append("<div class=my-tbl-header style='position: relative'>");
    sb.append("<table border=0 cellpadding=0 cellspacing=0 style='position:relative'><tbody><tr class=my-tbl-header-row>");
    sb.append("</tr></table></div>");
    html = sb.toString();
  }

  protected List<TableColumnUI> columns;
  protected BaseTable table;
  protected TableColumnModel columnModel;
  protected TableColumnUI sortColumn, endColumn, hoverColumn;
  protected Element headerRow;

  private DelayedTask task = new DelayedTask(new Listener<ComponentEvent>() {
    public void handleEvent(ComponentEvent ce) {
      updateSplitBars();
    }
  });

  public TableHeader() {

  }

  public TableHeader(BaseTable table) {
    this.table = table;
    this.columnModel = this.table.getColumnModel();
  }

  public void clearSort() {
    if (sortColumn != null) {
      sortColumn.onSortChange(SortDir.NONE);
      sortColumn = null;
    }
  }

  public void sort(int index, SortDir dir) {
    TableColumn column = table.getColumn(index);
    column.sortDir = dir;
    if (rendered) {
      onSortChange(column, dir);
    }
  }

  public void addColumn(TableColumnUI ui) {
    Element td = DOM.createTD();
    td.setClassName("my-tbl-col");

    ui.render(td);
    headerRow.appendChild(td);
    columns.add(ui);
  }

  public SplitBar createSplitBar(LayoutRegion direction, TableColumnUI column) {
    return new SplitBar(direction, column, (BoxComponent) table);
  }

  public TableColumnUI createTableColumnUI(int index) {
    return new TableColumnUI(table, index);
  }

  protected void doAttachChildren() {
    int count = columns.size() - 1;
    for (int i = 0; i < count; i++) {
      ComponentHelper.doAttach(getColumnUI(i));
    }
  }

  protected void doDetachChildren() {
    int count = columns.size() - 1;
    for (int i = 0; i < count; i++) {
      ComponentHelper.doDetach(getColumnUI(i));
    }
  }

  public TableColumnUI getColumnUI(int index) {
    return columns.get(index);
  }

  public void init(BaseTable table) {
    this.table = table;
    this.columnModel = this.table.getColumnModel();

    columns = new ArrayList<TableColumnUI>();
    int cols = columnModel.getColumnCount();
    for (int i = 0; i < cols; i++) {
      TableColumnUI columnUI = createTableColumnUI(i);
      addColumn(columnUI);
    }
    endColumn = createTableColumnUI(cols);
    endColumn.end = true;
    addColumn(endColumn);
  }

  public void onColumnClick(TableColumnUI columnUI, ComponentEvent e) {
    BaseEvent be = null;

    if (table instanceof TreeTable) {
      TreeTableEvent tte = new TreeTableEvent((TreeTable) table);
      tte.setColumnIndex(columnUI.index);
      tte.setEvent(e.getEvent());
      be = tte;
    } else {
      TableEvent ce = new TableEvent((Table) table);
      ce.setColumnIndex(columnUI.index);
      ce.setEvent(e.getEvent());
      be = ce;
    }

    if (!((Component) table).fireEvent(Events.ColumnClick, be)) {
      return;
    }

    if (columnUI.column.isSortable()) {

      SortDir sortDir = SortDir.toggle(columnUI.column.sortDir);
      table.sort(columnUI.index, sortDir);
    }
  }

  protected void onColumnMouseMove(TableColumnUI column, BaseEvent be) {

  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(XDOM.create(html), target, index);
    headerRow = el().selectNode(".my-tbl-header-row").dom;
    disableContextMenu(true);
  }

  protected void onRightClick(final TableColumn column, ComponentEvent ce) {
    ce.stopEvent();

    if (!table.getColumnContextMenu()) {
      return;
    }

    final int x = ce.getClientX();
    final int y = ce.getClientY();
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        onShowContextMenu(column).showAt(x, y);
      }
    });
  }

  protected Menu onShowContextMenu(final TableColumn column) {
    final Menu menu = new Menu();

    if (column.isSortable()) {
      MenuItem item = new MenuItem();
      item.setText(GXT.MESSAGES.gridView_sortAscText());
      item.setIcon(IconHelper.createStyle("my-icon-asc"));
      item.addSelectionListener(new SelectionListener<MenuEvent>() {
        public void componentSelected(MenuEvent ce) {
          table.sort(column.index, SortDir.ASC);
        }

      });
      menu.add(item);

      item = new MenuItem();
      item.setText(GXT.MESSAGES.gridView_sortDescText());
      item.setIcon(IconHelper.createStyle("my-icon-desc"));
      item.addSelectionListener(new SelectionListener<MenuEvent>() {
        public void componentSelected(MenuEvent ce) {
          table.sort(column.index, SortDir.DESC);
        }
      });
      menu.add(item);
    }

    MenuItem columns = new MenuItem();
    columns.setText(GXT.MESSAGES.gridView_columnsText());
    columns.setIcon(IconHelper.createStyle("icon-columns"));

    final Menu columnMenu = new Menu();

    int cols = columnModel.getColumnCount();
    for (int i = 0; i < cols; i++) {
      final TableColumn def = columnModel.getColumn(i);
      final CheckMenuItem check = new CheckMenuItem();
      check.setHideOnClick(false);
      check.setText(def.getText());
      check.setChecked(!def.isHidden());
      check.addSelectionListener(new SelectionListener<MenuEvent>() {

        public void componentSelected(MenuEvent ce) {
          def.setHidden(!check.isChecked());
          showColumn(def.index, !def.isHidden());

          if (columnModel.getVariableColumnCount() > 0) {
            resizeColumns(false, true);
          }

          if (columnModel.getVisibleColumnCount() == 1) {
            for (Component item : columnMenu.getItems()) {
              CheckMenuItem check = (CheckMenuItem) item;
              if (check.isChecked()) {
                item.disable();
              }
            }
          } else if (columnModel.getVisibleColumnCount() == 2) {
            for (Component item : columnMenu.getItems()) {
              item.enable();
            }
          }
        }

      });
      columnMenu.add(check);

      if (columnModel.getVisibleColumnCount() == 1) {
        for (Component item : columnMenu.getItems()) {
          CheckMenuItem ci = (CheckMenuItem) item;
          if (ci.isChecked()) {
            ci.disable();
          }
        }
      }
    }

    columns.setSubMenu(columnMenu);
    menu.add(columns);

    if (table instanceof Table) {
      TableEvent e = new TableEvent((Table) table);
      e.setColumnIndex(column.getIndex());
      e.setMenu(menu);
      ((Table) table).fireEvent(Events.HeaderContextMenu, e);
    }

    return menu;
  }

  public int getSortColumn() {
    if (sortColumn != null) {
      return sortColumn.index;
    }
    return Style.DEFAULT;
  }

  public void onSortChange(TableColumn column, SortDir sortDir) {
    column.sortDir = sortDir;
    if (sortColumn != null) {
      getColumnUI(sortColumn.index).onSortChange(SortDir.NONE);
    }
    sortColumn = getColumnUI(column.index);
    sortColumn.onSortChange(sortDir);
  }

  protected void resizeColumn(int index, boolean resizeBody) {
    TableColumn column = columnModel.getColumn(index);
    TableColumnUI ui = getColumnUI(index);
    if (column.isHidden()) {
      ui.setVisible(false);
      showColumn(index, false);
      return;
    } else {
      ui.setVisible(true);
    }
    int w = columnModel.getWidthInPixels(column.index);
    if (w < 1) {
      return;
    }

    if (w != ui.lastWidth) {
      Element td = DOM.getParent(ui.getElement());
      w -= fly(td).getBorderWidth("lr");

      fly(td).setWidth(w);
      if (td.getChildNodes().getLength() > 1) {
        fly(td).getChild(1).setWidth(w);
      }

      SplitBar splitBar = ui.splitBar;
      if (splitBar != null) {
        if (column.isResizable()) {
          splitBar.setVisible(true);
        }
        splitBar.setMinSize(column.getMinWidth());
        splitBar.setMaxSize(column.getMaxWidth());
      }
      task.delay(400);
      if (resizeBody) {
        doTableComponentResizeCells(index);
      }

    }

    ui.lastWidth = w;

    if (resizeBody) {
      doTableComponentResize();
    }
  }

  protected void resizeColumns(boolean fireEvent, boolean resizeBody) {
    int tw = Math.max(columnModel.getTotalWidth(), ((Component) table).getOffsetWidth()) + 100;
    setWidth(tw);
    el().firstChild().setWidth(tw);
    endColumn.el().setWidth("100%");

    int cols = columnModel.getColumnCount();
    for (int i = 0; i < cols; i++) {
      resizeColumn(i, resizeBody);
    }

    task.delay(100);

    if (resizeBody) {
      doTableComponentResize();
    }

  }

  protected void showColumn(int index, boolean show) {
    TableColumnUI ui = getColumnUI(index);

    ui.el().getParent().setStyleAttribute("display", show ? "" : "none");
    ui.setVisible(show);
    doTableComponentShowColumn(index, show);

    updateSplitBars();
    doTableComponentResize();

    if (show) {
      resizeColumn(index, true);
    }
  }

  protected void updateSplitBars() {
    int count = columns.size() - 1;
    for (int i = 0; i < count; i++) {
      TableColumnUI ui = getColumnUI(i);
      if (ui.splitBar != null) {
        ui.splitBar.sync();
      }
    }
  }

  protected void doTableComponentResize() {
    if (table instanceof Table) {
      ((Table) table).getView().resize();
    }
  }

  protected void doTableComponentResizeCells(int columnIndex) {
    if (table instanceof Table) {
      ((Table) table).getView().resizeCells(columnIndex);
    }
  }

  protected void doTableComponentShowColumn(int index, boolean show) {
    if (table instanceof Table) {
      ((Table) table).getView().showColumn(index, show);
    }
  }

}

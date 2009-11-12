/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.grid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.core.DomHelper;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.SortInfo;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ColumnModelEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsArray;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.menu.CheckMenuItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Widget;

/**
 * <p>
 * This class encapsulates the user interface of an {@link Grid}. Methods of
 * this class may be used to access user interface elements to enable special
 * display effects. Do not change the DOM structure of the user interface.
 * </p>
 * <p>
 * This class does not provide ways to manipulate the underlying data. The data
 * model of a Grid is held in an {@link ListStore}.
 * </p>
 * 
 */
public class GridView extends BaseObservable {

  /**
   * Icons used by Grid which can be overridden as needed. s
   */
  public class GridViewImages {
    private AbstractImagePrototype sortAsc = GXT.IMAGES.grid_sortAsc();
    private AbstractImagePrototype sortDesc = GXT.IMAGES.grid_sortDesc();
    private AbstractImagePrototype columns = GXT.IMAGES.grid_columns();

    public AbstractImagePrototype getColumns() {
      return columns;
    }

    public AbstractImagePrototype getSortAsc() {
      return sortAsc;
    }

    public AbstractImagePrototype getSortDesc() {
      return sortDesc;
    }

    public void setColumns(AbstractImagePrototype columnsIcon) {
      this.columns = columnsIcon;
    }

    public void setSortAsc(AbstractImagePrototype sortAscIcon) {
      this.sortAsc = sortAscIcon;
    }

    public void setSortDesc(AbstractImagePrototype sortDescIcon) {
      this.sortDesc = sortDescIcon;
    }
  }

  protected GridViewImages images;
  protected int activeHdIndex;
  protected boolean autoFill;
  protected int borderWidth = 2;

  protected ColumnModel cm;
  protected boolean deferEmptyText;

  protected ListStore<ModelData> ds;
  // elements
  protected El el, mainWrap, mainHd, innerHd, scroller, mainBody, focusEl;
  protected String emptyText = "&nbsp;";
  protected boolean enableHdMenu = true;
  // config
  protected boolean enableRowBody;
  protected boolean forceFit;
  protected Grid<ModelData> grid;
  protected int scrollOffset = 19;
  protected int splitterWidth = 5;

  protected GridTemplates templates;
  protected boolean userResized;
  protected GridViewConfig viewConfig;

  private String cellSelector = "td.x-grid3-cell";
  private int cellSelectorDepth = 4;
  private Listener<ColumnModelEvent> columnListener;
  private boolean focusEnabled = true;
  private boolean headerDisabled;
  private int lastViewWidth;
  private StoreListener<ModelData> listener;
  private Element overRow;
  private String rowSelector = "div.x-grid3-row";
  private int rowSelectorDepth = 10;
  private boolean showDirtyCells = true;
  private SortInfo sortState;

  private boolean vbar;
  private ColumnHeader header;
  private ColumnFooter footer;
  private boolean layoutRun = false;
  private List<Map<String, Widget>> widgetMap = new ArrayList<Map<String, Widget>>();

  /**
   * Ensured the current row and column is visible.
   * 
   * @param row the row index
   * @param col the column index
   * @param hscroll true to scroll horizontally if needed
   * @return the calculated point
   */
  public Point ensureVisible(int row, int col, boolean hscroll) {
    if (row < 0 || row > ds.getCount()) {
      return null;
    }

    if (col == -1) {
      col = 0;
    }

    Element rowEl = getRow(row);
    Element cellEl = null;
    if (!(!hscroll && col == 0)) {
      while (cm.isHidden(col)) {
        col++;
      }
      cellEl = getCell(row, col);

    }

    if (rowEl == null) {
      return null;
    }

    Element c = scroller.dom;

    int ctop = 0;
    Element p = rowEl, stope = el.dom;
    while (p != null && p != stope) {
      ctop += p.getOffsetTop();
      p = p.getOffsetParent().cast();
    }
    ctop -= mainHd.dom.getOffsetHeight();

    int cbot = ctop + rowEl.getOffsetHeight();

    int ch = c.getOffsetHeight();
    int stop = c.getScrollTop();
    int sbot = stop + ch;

    if (ctop < stop) {
      c.setScrollTop(ctop);
    } else if (cbot > sbot) {
      if (hscroll && (cm.getTotalWidth() > scroller.getWidth() - scrollOffset)) {
        cbot += scrollOffset;
      }
      c.setScrollTop(cbot -= ch);
    }

    if (hscroll) {
      int cleft = cellEl.getOffsetLeft();
      int cright = cleft + cellEl.getOffsetWidth();
      int sleft = c.getScrollLeft();
      int sright = sleft + c.getOffsetWidth();
      if (cleft < sleft) {
        c.setScrollLeft(cleft);
      } else if (cright > sright) {
        c.setScrollLeft(cright - scroller.getStyleWidth());
      }
    }

    return cellEl != null ? fly(cellEl).getXY() : new Point(c.getScrollLeft(), fly(rowEl).getY());
  }

  /**
   * Returns the cell.
   * 
   * @param elem the cell element or a child element
   * @return the cell element
   */
  public Element findCell(Element elem) {
    if (elem == null) {
      return null;
    }
    return fly(elem).findParentElement(cellSelector, cellSelectorDepth);
  }

  /**
   * Returns the cell index.
   * 
   * @param elem the cell or child element
   * @param requiredStyle an optional required style name
   * @return the cell index or -1 if not found
   */
  public int findCellIndex(Element elem, String requiredStyle) {
    Element cell = findCell(elem);
    if (cell != null && (requiredStyle == null || fly(cell).hasStyleName(requiredStyle))) {
      return getCellIndex(cell);
    }
    return -1;
  }

  /**
   * Returns the row element.
   * 
   * @param el the row element or any child element
   * @return the matching row element
   */
  public Element findRow(Element el) {
    if (el == null) {
      return null;
    }
    return fly(el).findParentElement(rowSelector, rowSelectorDepth);
  }

  /**
   * Returns the row index.
   * 
   * @param elem the row or child of the row element
   * @return the index
   */
  public int findRowIndex(Element elem) {
    Element r = findRow(elem);
    return r != null ? r.getPropertyInt("rowIndex") : -1;
  }

  /**
   * Focus the cell and scrolls into view.
   * 
   * @param rowIndex the row index
   * @param colIndex the column index
   * @param hscroll true to scroll horizontally
   */
  public void focusCell(int rowIndex, int colIndex, boolean hscroll) {
    Point xy = ensureVisible(rowIndex, colIndex, hscroll);
    if (xy != null) {
      focusEl.setXY(xy);
      if (focusEnabled) {
        focusGrid();
      }
    }
  }

  /**
   * Focus the row and scrolls into view.
   * 
   * @param rowIndex the row index
   */
  public void focusRow(int rowIndex) {
    focusCell(rowIndex, 0, true);
  }

  /**
   * Returns the grid's body element.
   * 
   * @return the body element
   */
  public El getBody() {
    return scroller;
  }

  /**
   * Returns the grid's &lt;TD> HtmlElement at the specified coordinates.
   * 
   * @param row the row index in which to find the cell
   * @param col the column index of the cell
   * @return the &lt;TD> at the specified coordinates
   */
  public Element getCell(int row, int col) {
    // ROW DIV TABLE TR TD
    return getRow(row).getFirstChild().getFirstChild().getFirstChild().getChildNodes().getItem(col).cast();
  }

  /**
   * Returns the cell selector depth.
   * 
   * @return the cell selector depth
   */
  public int getCellSelectorDepth() {
    return cellSelectorDepth;
  }

  /**
   * Returns the editor parent element.
   * 
   * @return the editor element
   */
  public Element getEditorParent() {
    return scroller.dom;
  }

  /**
   * Returns the empty text.
   * 
   * @return the empty text
   */
  public String getEmptyText() {
    return emptyText;
  }

  /**
   * Returns the grid's column header.
   * 
   * @return the header
   */
  public ColumnHeader getHeader() {
    return header;
  }

  /**
   * Returns the &lt;TD> HtmlElement which represents the Grid's header cell for
   * the specified column index.
   * 
   * @param index the column index
   * @return the &lt;TD> element.
   */
  public Element getHeaderCell(int index) {
    return mainHd.dom.getElementsByTagName("td").getItem(index);
  }

  /**
   * Returns the images used by grid.
   * 
   * @return the images
   */
  public GridViewImages getImages() {
    if (images == null) {
      images = new GridViewImages();
    }
    return images;
  }

  /**
   * Return the &lt;TR> HtmlElement which represents a Grid row for the
   * specified index.
   * 
   * @param row the row index
   * @return the &lt;TR> element
   */
  public Element getRow(int row) {
    if (row < 0) {
      return null;
    }
    return getRows().getItem(row);
  }

  /**
   * Returns the row selector depth.
   * 
   * @return the row selector depth
   */
  public int getRowSelectorDepth() {
    return rowSelectorDepth;
  }

  /**
   * Returns the current scroll state.
   * 
   * @return the scroll state
   */
  public Point getScrollState() {
    return new Point(scroller.getScrollLeft(), scroller.getScrollTop());
  }

  /**
   * Returns the view config.
   * 
   * @return the view config
   */
  public GridViewConfig getViewConfig() {
    return viewConfig;
  }

  /**
   * Returns the widget at the current location.
   * 
   * @param rowIndex the row index
   * @param colIndex the column index
   * @return the widget or null
   */
  public Widget getWidget(int rowIndex, int colIndex) {
    Map<String, Widget> map = widgetMap.get(rowIndex);
    return map != null ? map.get(String.valueOf(colIndex)) : null;
  }

  /**
   * Returns true if auto fill is enabled.
   * 
   * @return true for auto fill
   */
  public boolean isAutoFill() {
    return autoFill;
  }

  /**
   * Returns true if force fit is enabled.
   * 
   * @return true for force fit
   */
  public boolean isForceFit() {
    return forceFit;
  }

  /**
   * Returns true if dirty cell markers are enabled.
   * 
   * @return true of dirty cell markers
   */
  public boolean isShowDirtyCells() {
    return showDirtyCells;
  }

  public void layout() {
    if (mainBody == null) {
      return;
    }

    El c = grid.el();
    Size csize = c.getStyleSize();

    int vw = csize.width;
    int vh = 0;
    if (vw < 10 || csize.height < 20) {
      return;
    }
    resize();

    if (forceFit || (!layoutRun && autoFill)) {
      if (lastViewWidth != vw) {
        fitColumns(false, false, -1);
        lastViewWidth = vw;
      }
    } else {
      autoExpand(false);
      syncHeaderScroll();
    }

    templateOnLayout(vw, vh);
    layoutRun = true;
  }

  /**
   * Rebuilds the grid using its current configuration and data.
   * 
   * @param headerToo true to refresh the header
   */
  public void refresh(boolean headerToo) {
    stopEditing();

    detachWidgets(0, -1, true);

    String result = renderBody();
    mainBody.setInnerHtml(result);
    if (headerToo) {
      sortState = null;
      
      ComponentHelper.doDetach(header);
     
      newColumnHeader();
      renderHeader();
      
      if (grid.isEnableColumnResize()) {
        header.enableColumnResizing();
      }

    }
    processRows(0, true);
    renderWidgets(0, -1);
    layout();

    updateHeaderSortState();

    applyEmptyText();

    fireEvent(Events.Refresh);
  }

  /**
   * Scrolls the grid to the top.
   */
  public void scrollToTop() {
    scroller.setScrollTop(0);
    scroller.setScrollLeft(0);
  }

  /**
   * True to auto expand the columns to fit the grid <b>when the grid is
   * created</b>.
   * 
   * @param autoFill true to expand
   */
  public void setAutoFill(boolean autoFill) {
    this.autoFill = autoFill;
  }

  /**
   * The number of levels to search for cells in event delegation (defaults to
   * 4).
   * 
   * @param cellSelectorDepth the cell selector depth
   */
  public void setCellSelectorDepth(int cellSelectorDepth) {
    this.cellSelectorDepth = cellSelectorDepth;
  }

  /**
   * Default text to display in the grid body when no rows are available
   * (defaults to '').
   * 
   * @param emptyText the empty text
   */
  public void setEmptyText(String emptyText) {
    this.emptyText = emptyText;
  }

  /**
   * True to auto expand/contract the size of the columns to fit the grid width
   * and prevent horizontal scrolling.
   * 
   * @param forceFit true to force fit
   */
  public void setForceFit(boolean forceFit) {
    this.forceFit = forceFit;
  }

  /**
   * The number of levels to search for rows in event delegation (defaults to
   * 10).
   * 
   * @param rowSelectorDepth the row selector depth
   */
  public void setRowSelectorDepth(int rowSelectorDepth) {
    this.rowSelectorDepth = rowSelectorDepth;
  }

  /**
   * True to display a red triangle in the upper left corner of any cells which
   * are "dirty" as defined by any existing records in the data store (defaults
   * to true).
   * 
   * @param showDirtyCells true to display the dirty flag
   */
  public void setShowDirtyCells(boolean showDirtyCells) {
    this.showDirtyCells = showDirtyCells;
  }

  /**
   * Sets the view config.
   * 
   * @param viewConfig the view config
   */
  public void setViewConfig(GridViewConfig viewConfig) {
    this.viewConfig = viewConfig;
  }

  protected void addRowStyle(Element elem, String style) {
    if (elem != null) {
      fly(elem).addStyleName(style);
    }
  }

  protected void afterRender() {
    applyEmptyText();

    int sh = scroller.getHeight();
    int dh = mainBody.getHeight();
    boolean vbar = dh < sh;
    if (vbar) {
      this.vbar = vbar;
      lastViewWidth = -1;
      layout();
    }
  }

  protected void autoExpand(boolean preventUpdate) {
    if (!userResized && grid.getAutoExpandColumn() != null) {
      int tw = cm.getTotalWidth(false);
      int aw = grid.getWidth(true) - getScrollAdjust();
      if (tw != aw) {
        int ci = cm.getIndexById(grid.getAutoExpandColumn());
        if (cm.isHidden(ci)) {
          return;
        }
        int currentWidth = cm.getColumnWidth(ci);
        int cw = Math.min(Math.max(((aw - tw) + currentWidth), grid.getAutoExpandMin()), grid.getAutoExpandMax());
        if (cw != currentWidth) {
          cm.setColumnWidth(ci, cw, true);

          if (!preventUpdate) {
            updateColumnWidth(ci, cw);
          }
        }
      }
    }
  }

  protected void calculateVBar(boolean force) {
    int sh = scroller.getHeight();
    int dh = mainBody.getHeight();
    boolean vbar = dh > sh;
    if (force || this.vbar != vbar) {
      this.vbar = vbar;
      lastViewWidth = -1;
      layout();
    }
  }

  protected Menu createContextMenu(final int colIndex) {
    final Menu menu = new Menu();

    if (cm.isSortable(colIndex)) {
      MenuItem item = new MenuItem();
      item.setText(GXT.MESSAGES.gridView_sortAscText());
      item.setIcon(getImages().getSortAsc());
      item.addSelectionListener(new SelectionListener<MenuEvent>() {
        public void componentSelected(MenuEvent ce) {
          ds.sort(cm.getDataIndex(colIndex), SortDir.ASC);
        }

      });
      menu.add(item);

      item = new MenuItem();
      item.setText(GXT.MESSAGES.gridView_sortDescText());
      item.setIcon(getImages().getSortDesc());
      item.addSelectionListener(new SelectionListener<MenuEvent>() {
        public void componentSelected(MenuEvent ce) {
          ds.sort(cm.getDataIndex(colIndex), SortDir.DESC);
        }
      });
      menu.add(item);
    }

    MenuItem columns = new MenuItem();
    columns.setText(GXT.MESSAGES.gridView_columnsText());
    columns.setIcon(getImages().getColumns());

    final Menu columnMenu = new Menu();

    int cols = cm.getColumnCount();
    for (int i = 0; i < cols; i++) {
      if (cm.getColumnHeader(i) == null || cm.getColumnHeader(i).equals("") || cm.isFixed(i)) {
        continue;
      }
      final int fcol = i;
      final CheckMenuItem check = new CheckMenuItem();
      check.setHideOnClick(false);
      check.setText(cm.getColumnHeader(i));
      check.setChecked(!cm.isHidden(i));
      check.addSelectionListener(new SelectionListener<MenuEvent>() {
        public void componentSelected(MenuEvent ce) {
          cm.setHidden(fcol, !cm.isHidden(fcol));
          restrictMenu(columnMenu);
        }
      });
      columnMenu.add(check);
    }

    restrictMenu(columnMenu);

    columns.setSubMenu(columnMenu);
    menu.add(columns);
    return menu;
  }

  protected void deleteRows(ListStore<ModelData> store, int firstRow, int lastRow) {
    if (store.getCount() < 1) {
      refresh(false);
      return;
    }
    removeRows(firstRow, lastRow);
  }

  protected void detachWidget(int rowIndex, boolean remove) {
    Map<String, Widget> m = rowIndex < widgetMap.size() ? widgetMap.get(rowIndex) : null;
    if (m != null) {
      for (Widget w : m.values()) {
        ComponentHelper.doDetach(w);
      }
      if (remove) {
        widgetMap.remove(rowIndex);
      }
    }
  }

  protected void detachWidgets(int startRow, int endRow, boolean remove) {
    if (endRow == -1) {
      endRow = ds.getCount() - 1;
    }
    for (int i = endRow; i >= startRow; i--) {
      detachWidget(i, remove);
    }

  }

  protected void doAttach() {
    ComponentHelper.doAttach(header);
    header.updateTotalWidth(getOffsetWidth(), getTotalWidth());
    renderWidgets(0, -1);
  }

  protected void doDetach() {
    ComponentHelper.doDetach(header);
    detachWidgets(0, -1, false);
  }

  protected String doRender(List<ColumnData> cs, List<ModelData> rows, int startRow, int colCount, boolean stripe) {
    int last = colCount - 1;
    String tstyle = "width:" + getTotalWidth() + "px;";

    StringBuilder buf = new StringBuilder();
    StringBuilder cb = new StringBuilder();

    for (int j = 0; j < rows.size(); j++) {
      ModelData model = (ModelData) rows.get(j);
      Record r = ds.hasRecord(model) ? ds.getRecord(model) : null;

      int rowIndex = (j + startRow);
      Map<String, Widget> rowMap = new FastMap<Widget>();
      widgetMap.add(rowIndex, rowMap);
      for (int i = 0; i < colCount; i++) {
        ColumnData c = cs.get(i);
        c.css = c.css == null ? "" : c.css;
        String rv = getRenderedValue(c, rowIndex, i, model, c.name);

        String css = (i == 0 ? "x-grid-cell-first " : (i == last ? "x-grid3-cell-last " : " ")) + " "
            + (c.css == null ? "" : c.css);
        String attr = c.cellAttr != null ? c.cellAttr : "";
        String cellAttr = c.cellAttr != null ? c.cellAttr : "";

        if (showDirtyCells && r != null && r.getChanges().containsKey(c.id)) {
          css += " x-grid3-dirty-cell";
        }

        cb.append("<td class=\"x-grid3-col x-grid3-cell x-grid3-td-");
        cb.append(c.id);
        cb.append(" ");
        cb.append(css);
        cb.append("\" style=\"");
        cb.append(c.style);
        cb.append("\" tabIndex=0 ");
        cb.append(cellAttr);
        cb.append("><div class=\"x-grid3-cell-inner x-grid3-col-");
        cb.append(c.id);
        cb.append("\" ");
        cb.append(attr);
        cb.append(">");
        cb.append(rv);
        cb.append("</div></td>");
      }

      String alt = "";
      if (stripe && ((rowIndex + 1) % 2 == 0)) {
        alt += " x-grid3-row-alt";
      }

      if (showDirtyCells && r != null && r.isDirty()) {
        alt += " x-grid3-dirty-row";
      }

      if (viewConfig != null) {
        alt += " " + viewConfig.getRowStyle(model, rowIndex, ds);
      }

      buf.append("<div class=\"x-grid3-row ");
      buf.append(alt);
      buf.append("\" style=\"");
      buf.append(tstyle);
      buf.append("\"><table class=x-grid3-row-table border=0 cellspacing=0 cellpadding=0 style=\"");
      buf.append(tstyle);
      buf.append("\"><tbody><tr>");
      buf.append(cb.toString());
      buf.append("</tr>");
      buf.append((enableRowBody
          ? ("<tr class=x-grid3-row-body-tr style=\"\"><td colspan=" + colCount + " class=x-grid3-body-cell tabIndex=0><div class=x-grid3-row-body>${body}</div></td></tr>")
          : ""));
      buf.append("</tbody></table></div>");
      cb = new StringBuilder();
    }

    return buf.toString();
  }

  protected void fitColumns(boolean preventRefresh, boolean onlyExpand, int omitColumn) {
    int tw = cm.getTotalWidth(false);
    double aw = grid.el().getWidth(true) - getScrollAdjust();
    if (aw < 0) {
      aw = grid.el().getStyleWidth();
    }

    if (aw < 20 || aw > 2000) { // not initialized, so don't screw up the
      // default widths
      return;
    }

    int extra = (int) aw - tw;

    if (extra == 0) {
      return;
    }

    int vc = cm.getColumnCount(true);
    int ac = vc - (omitColumn != -1 ? 1 : 0);

    if (ac == 0) {
      ac = 1;
      omitColumn = -1;
    }

    int colCount = cm.getColumnCount();
    Stack<Integer> cols = new Stack<Integer>();
    int extraCol = 0;
    int width = 0;
    int w;

    for (int i = 0; i < colCount; i++) {
      if (!cm.isHidden(i) && !cm.isFixed(i) && i != omitColumn) {
        w = cm.getColumnWidth(i);
        cols.push(i);
        extraCol = i;
        cols.push(w);
        width += w;
      }
    }

    double frac = (aw - cm.getTotalWidth()) / width;

    while (cols.size() > 0) {
      w = cols.pop();
      int i = cols.pop();
      int ww = Math.max(grid.getMinColumnWidth(), (int) Math.floor(w + w * frac));
      cm.setColumnWidth(i, ww, true);
    }

    if ((tw = cm.getTotalWidth(false)) > aw) {
      int adjustCol = ac != vc ? omitColumn : extraCol;
      cm.setColumnWidth(adjustCol, (int) Math.max(1, cm.getColumnWidth(adjustCol) - (tw - aw)), true);
    }

    if (!preventRefresh) {
      updateAllColumnWidths();
    }
  }

  protected El fly(Element elem) {
    return El.fly(elem, "grid");
  }

  protected void focusGrid() {
    if (GXT.isGecko) {
      focusEl.setFocus(true);
    } else {
      DeferredCommand.addCommand(new Command() {
        public void execute() {
          focusEl.setFocus(true);
        }
      });
    }
  }

  protected int getCellIndex(Element elem) {
    if (elem != null) {
      String id = getCellIndexId(elem);
      if (id != null) {
        return cm.getIndexById(id);
      }
    }
    return -1;
  }

  protected List<ColumnData> getColumnData() {
    int colCount = cm.getColumnCount();
    List<ColumnData> cs = new ArrayList<ColumnData>();
    for (int i = 0; i < colCount; i++) {
      String name = cm.getDataIndex(i);
      ColumnData data = new ColumnData();
      data.name = name == null ? cm.getColumnId(i) : name;
      data.renderer = cm.getRenderer(i);
      data.id = cm.getColumnId(i);
      data.style = getColumnStyle(i, false);
      cs.add(data);
    }
    return cs;
  }

  protected int getOffsetWidth() {
    return (getTotalWidth() + getScrollAdjust());
  }

  protected String getRenderedValue(ColumnData data, int rowIndex, int colIndex, ModelData m, String property) {
    GridCellRenderer<ModelData> r = cm.getRenderer(colIndex);
    if (r != null) {
      Object o = r.render(ds.getAt(rowIndex), property, data, rowIndex, colIndex, ds, grid);
      if (o instanceof Component) {
        Component c = (Component) o;
        Map<String, Widget> rowMap = widgetMap.get(rowIndex);
        rowMap.put(String.valueOf(colIndex), c);
        return "";
      } else {
        return o.toString();
      }
    }
    Object val = m.get(property);

    ColumnConfig c = cm.getColumn(colIndex);

    if (val != null && c.getNumberFormat() != null) {
      Number n = (Number) val;
      NumberFormat nf = cm.getColumn(colIndex).getNumberFormat();
      val = nf.format(n.doubleValue());
    } else if (val != null && c.getDateTimeFormat() != null) {
      DateTimeFormat dtf = c.getDateTimeFormat();
      val = dtf.format((Date) val);
    }

    if (val != null) {
      return val.toString();
    }
    return "";
  }

  protected NodeList<Element> getRows() {
    if (!hasRows()) {
      return new JsArray().getJsObject().cast();
    }
    return mainBody.dom.getChildNodes().cast();
  }

  protected int getScrollAdjust() {
    if (scroller != null) {
      int sh = scroller.getHeight();
      int dh = mainBody.getHeight();
      vbar = dh > sh;
      return vbar ? scrollOffset : 2;
    }
    return scrollOffset;
  }

  protected int getTotalWidth() {
    return cm.getTotalWidth();
  }

  @SuppressWarnings("unchecked")
  protected void handleComponentEvent(GridEvent ge) {
    switch (ge.getEventTypeInt()) {
      case Event.ONMOUSEOVER:
        Element row = getRow(ge.getRowIndex());
        if (row != null) {
          onRowOver(row);
        }
        break;
      case Event.ONMOUSEOUT:
        if (overRow != null) {
          onRowOut(overRow);
        }
        break;
      case Event.ONMOUSEDOWN:
        onMouseDown(ge);
        break;
      case Event.ONSCROLL:
        if (scroller.isOrHasChild(ge.getTarget())) {
          syncScroll();
        }
        break;
    }
  }
  
  /**
   * Initializes the view.
   * 
   * @param grid the grid
   */
  @SuppressWarnings("unchecked")
  protected void init(final Grid grid) {
    this.grid = grid;
    this.cm = grid.getColumnModel();

    initListeners();

    initTemplates();
    initData(grid.getStore(), cm);
    initUI(grid);

    newColumnHeader();

    if (cm.getAggregationRows().size() > 0) {
      footer = new ColumnFooter(grid, cm);
    }
  }

  /**
   * Initializes the data.
   * 
   * @param ds the data store
   * @param cm the column model
   */
  @SuppressWarnings("unchecked")
  protected void initData(ListStore ds, ColumnModel cm) {
    if (this.ds != null) {
      this.ds.removeStoreListener(listener);
    }
    if (ds != null) {
      ds.addStoreListener(listener);
    }
    this.ds = ds;

    if (this.cm != null) {
      this.cm.removeListener(Events.HiddenChange, columnListener);
      this.cm.removeListener(Events.HeaderChange, columnListener);
      this.cm.removeListener(Events.WidthChange, columnListener);
    }
    if (cm != null) {
      cm.addListener(Events.HiddenChange, columnListener);
      cm.addListener(Events.HeaderChange, columnListener);
      cm.addListener(Events.WidthChange, columnListener);
    }
    this.cm = cm;
  }

  protected void initElements() {
    NodeList<Node> cs = grid.getElement().getFirstChild().getChildNodes();

    el = grid.el().firstChild();

    mainWrap = new El((com.google.gwt.user.client.Element) cs.getItem(0));
    mainHd = mainWrap.firstChild();

    if (grid.isHideHeaders()) {
      mainHd.setVisible(false);
    }

    innerHd = mainHd.firstChild();

    scroller = mainWrap.getChild(1);
    scroller.addEventsSunk(Event.ONSCROLL);

    if (forceFit) {
      scroller.setStyleAttribute("overflowX", "hidden");
    }

    mainBody = scroller.firstChild();
    focusEl = scroller.getChild(1);
    grid.swallowEvent(Events.OnClick, focusEl.dom, true);
  }

  protected void initListeners() {
    listener = new StoreListener<ModelData>() {

      @Override
      public void storeAdd(StoreEvent<ModelData> se) {
        onAdd(ds, se.getModels(), se.getIndex());
      }

      @Override
      public void storeBeforeDataChanged(StoreEvent<ModelData> se) {
        onBeforeDataChanged(se);
      }

      @Override
      public void storeClear(StoreEvent<ModelData> se) {
        onClear(se);
      }

      @Override
      public void storeDataChanged(StoreEvent<ModelData> se) {
        onDataChanged(se);
      }

      @Override
      public void storeFilter(StoreEvent<ModelData> se) {
        onDataChanged(se);
      }

      @Override
      public void storeRemove(StoreEvent<ModelData> se) {
        onRemove(ds, se.getModel(), se.getIndex(), false);
      }

      @Override
      public void storeUpdate(StoreEvent<ModelData> se) {
        onUpdate(ds, se.getModel());
      }

    };

    columnListener = new Listener<ColumnModelEvent>() {
      public void handleEvent(ColumnModelEvent e) {
        EventType type = e.getType();
        if (type == Events.HiddenChange) {
          onHiddenChange(cm, e.getColIndex(), e.isHidden());
        } else if (type == Events.HeaderChange) {
          onHeaderChange(e.getColIndex(), e.getHeader());
        } else if (type == Events.WidthChange) {
          onColumnWidthChange(e.getColIndex(), e.getWidth());
        }
      }
    };
  }

  protected void initTemplates() {
    templates = GWT.create(GridTemplates.class);
  }

  protected void initUI(final Grid<ModelData> grid) {

  }

  protected void insertRows(ListStore<ModelData> store, int firstRow, int lastRow, boolean isUpdate) {
    if (isUpdate && firstRow == 0 && lastRow == store.getCount() - 1) {
      refresh(false);
      return;
    }
    Element e = mainBody.dom.getFirstChildElement();
    if (e != null && !hasRows()) {
      mainBody.dom.setInnerHTML("");
    }

    String html = renderRows(firstRow, lastRow);
    Element before = getRow(firstRow);

    if (before != null) {
      DomHelper.insertBefore((com.google.gwt.user.client.Element) before, html);
    } else {
      DomHelper.insertHtml("beforeEnd", mainBody.dom, html);
    }

    if (!isUpdate) {
      processRows(firstRow, false);
    }

    focusRow(firstRow);
  }

  protected ColumnHeader newColumnHeader() {
    header = new ColumnHeader(grid, cm) {
      @Override
      protected ComponentEvent createColumnEvent(ColumnHeader header, int column, Menu menu) {
        GridEvent<ModelData> event = new GridEvent<ModelData>(grid);
        event.setColIndex(column);
        event.setMenu(menu);
        return event;
      }

      @Override
      protected Menu getContextMenu(int column) {
        return createContextMenu(column);
      }

      @Override
      protected void onColumnSplitterMoved(int colIndex, int width) {
        super.onColumnSplitterMoved(colIndex, width);
        GridView.this.onColumnSplitterMoved(colIndex, width);
      }

      @Override
      protected void onHeaderClick(ComponentEvent ce, int column) {
        super.onHeaderClick(ce, column);
        GridView.this.onHeaderClick(grid, column);
      }

    };
    header.setSplitterWidth(splitterWidth);
    header.setMinColumnWidth(grid.getMinColumnWidth());
    
    return header;
  }

  protected void onAdd(ListStore<ModelData> store, List<ModelData> models, int index) {
    insertRows(store, index, index + (models.size() - 1), false);
    renderWidgets(index, index + (models.size() - 1));
    calculateVBar(false);
    refreshFooterData();
  }

  protected void onBeforeDataChanged(StoreEvent<ModelData> se) {
    if (grid.isLoadMask()) {
      grid.mask(GXT.MESSAGES.loadMask_msg());
    }
  }

  protected void onCellDeselect(int row, int col) {
    Element cell = getCell(row, col);
    if (cell != null) {
      fly(cell).removeStyleName("x-grid3-cell-selected");
    }
  }

  protected void onCellSelect(int row, int col) {
    Element cell = getCell(row, col);
    if (cell != null) {
      fly(cell).addStyleName("x-grid3-cell-selected");
    }
  }

  protected void onClear(StoreEvent<ModelData> se) {
    refresh(false);
  }

  protected void onClick(GridEvent<ModelData> ce) {
    Element row = findRow(ce.getTarget());
    if (row != null) {
      ce.setRowIndex(findRowIndex(row));
      grid.fireEvent(Events.RowClick, ce);
    }
  }

  protected void onColumnMove(ColumnModel cm, int oldIndex, int newIndex) {
    // indexMap = null;
    Point s = getScrollState();
    refresh(true);
    restoreScroll(s);
    templateAfterMove(newIndex);
  }

  protected void onColumnSplitterMoved(int colIndex, int width) {
    stopEditing();
    userResized = true;
    width = Math.max(grid.getMinColumnWidth(), width);
    cm.setColumnWidth(colIndex, width);

    if (forceFit) {
      fitColumns(true, false, colIndex);
      updateAllColumnWidths();
    } else {
      updateColumnWidth(colIndex, width);
      if (GXT.isIE) {
        syncHeaderScroll();
      }
    }

    GridEvent<ModelData> e = new GridEvent<ModelData>(grid);
    e.setColIndex(colIndex);
    e.setWidth(width);
    grid.fireEvent(Events.ColumnResize, e);
  }

  protected void onColumnWidthChange(int column, int width) {
    updateColumnWidth(column, width);
    syncHScroll();
  }

  protected void onDataChanged(StoreEvent<ModelData> se) {
    refresh(false);
    if (grid.isLoadMask()) {
      grid.unmask();
    }
    refreshFooterData();
  }

  protected void onHeaderChange(int column, String text) {
    header.setHeader(column, text);
  }

  protected void onHeaderClick(Grid<ModelData> grid, int column) {
    if (headerDisabled || !cm.isSortable(column)) {
      return;
    }
    grid.store.sort(cm.getDataIndex(column), null);
  }

  protected void onHiddenChange(ColumnModel cm, int col, boolean hidden) {
    updateColumnHidden(col, hidden);
  }

  protected void onMouseDown(GridEvent<ModelData> ge) {

  }

  protected void onRemove(ListStore<ModelData> ds, ModelData m, int index, boolean isUpdate) {
    detachWidget(index, true);
    removeRow(index);
    if (!isUpdate) {
      processRows(0, false);
    }
    calculateVBar(false);
    applyEmptyText();
    refreshFooterData();
  }

  protected void onRowDeselect(int rowIndex) {
    Element row = getRow(rowIndex);
    if (row != null) {
      removeRowStyle(row, "x-grid3-row-selected");
    }
  }

  protected void onRowOut(Element row) {
    if (grid.isTrackMouseOver() && overRow != null) {
      removeRowStyle(overRow, "x-grid3-row-over");
      overRow = null;
    }
  }

  protected void onRowOver(Element row) {
    if (grid.isTrackMouseOver() && overRow != row) {
      addRowStyle(row, "x-grid3-row-over");
      overRow = row;
    }
  }

  protected void onRowSelect(int rowIndex) {
    Element row = getRow(rowIndex);
    if (row != null) {
      onRowOut(row);
      addRowStyle(row, "x-grid3-row-selected");
    }
  }

  protected void onUpdate(ListStore<ModelData> store, ModelData model) {
    refreshRow(store.indexOf(model));
  }

  protected void processRows(int startRow, boolean skipStripe) {
    if (ds.getCount() < 1) {
      return;
    }
    skipStripe = !skipStripe || !grid.isStripeRows();
    NodeList<Element> rows = getRows();
    String cls = " x-grid3-row-alt ";
    for (int i = 0, len = rows.getLength(); i < len; i++) {
      Element row = rows.getItem(i);
      row.setPropertyInt("rowIndex", i);
      if (!skipStripe) {
        boolean isAlt = ((i + 1) % 2 == 0);
        boolean hasAlt = (" " + row.getClassName() + " ").indexOf(cls) != -1;
        if (isAlt == hasAlt) {
          continue;
        }
        if (isAlt) {
          row.setClassName(row.getClassName() + " " + cls);
        } else {
          row.setClassName(row.getClassName().replaceFirst(cls, ""));
        }
      }
    }
  }

  protected void refreshRow(int row) {
    ModelData m = ds.getAt(row);
    if (m != null) {
      // do not change focus on refresh
      // handles situation with changing cell value with field binding
      focusEnabled = false;

      insertRows(ds, row, row, true);
      getRow(row).setPropertyInt("rowIndex", row);
      onRemove(ds, m, row + 1, true);

      renderWidgets(row, row);

      GridEvent<ModelData> e = new GridEvent<ModelData>(grid);
      e.setRowIndex(row);
      e.setModel(ds.getAt(row));
      fireEvent(Events.RowUpdated, e);
      focusEnabled = true;
    }
  }

  protected void removeRow(int row) {
    Element r = getRow(row);
    if (r != null) {
      fly(r).removeFromParent();
    }
  }

  protected void removeRows(int firstRow, int lastRow) {
    for (int rowIndex = firstRow; rowIndex <= lastRow; rowIndex++) {
      mainBody.getChild(firstRow).removeFromParent();
    }
  }

  protected void removeRowStyle(Element row, String style) {
    fly(row).removeStyleName(style);
  }

  protected void render() {
    cm = grid.getColumnModel();
    renderUI();
    if (autoFill) {
      fitColumns(true, true, -1);
    } else if (forceFit) {
      fitColumns(true, false, -1);
    } else if (grid.getAutoExpandColumn() != null) {
      autoExpand(false);
    }

    grid.sinkEvents(Event.ONCLICK | Event.ONDBLCLICK | Event.MOUSEEVENTS);
  }

  protected String renderBody() {
    String markup = renderRows(0, -1);
    return templates.body(markup);
  }

  protected void renderFooter() {
    mainWrap.appendChild(footer.getElement());
    ComponentHelper.doAttach(footer);
  }

  protected void renderHeader() {
    El head = grid.el().selectNode(".x-grid3-hh");
    head.removeChildren();
    head.appendChild(header.getElement());

    ComponentHelper.doAttach(header);
  }

  protected String renderRows(int startRow, int endRow) {
    int colCount = cm.getColumnCount();

    if (ds.getCount() < 1) {
      return "";
    }

    List<ColumnData> cs = getColumnData();

    if (endRow == -1) {
      endRow = ds.getCount() - 1;
    }

    List<ModelData> rs = ds.getRange(startRow, endRow);
    return doRender(cs, rs, startRow, colCount, grid.isStripeRows());
  }

  protected void renderUI() {
    String h = "<div class='x-grid3-hh'></div>";
    String body = templates.body("");

    String html = templates.master(body, h);

    grid.getElement().setInnerHTML(html);

    renderHeader();

    initElements();

    mainBody.setInnerHtml(renderRows(0, -1));
    renderWidgets(0, -1);
    processRows(0, true);
    
    if (grid.isEnableColumnResize()) {
      header.enableColumnResizing();
    }

    if (footer != null) {
      renderFooter();
    }

    mainHd.addEventsSunk(Event.MOUSEEVENTS | Event.ONCLICK);
    updateHeaderSortState();

    if (!GXT.isGecko && !GXT.isWebKit) {
      grid.disableTextSelection(true);
    }
  }

  protected void renderWidgets(int startRow, int endRow) {
    if (endRow == -1) {
      endRow = ds.getCount() - 1;
    }
    for (int i = startRow; i <= endRow; i++) {
      Map<String, Widget> m = i < widgetMap.size() ? widgetMap.get(i) : null;
      if (m != null) {
        for (int j = 0; j < grid.getColumnModel().getColumnCount(); j++) {
          Widget w = m.get(String.valueOf(j));
          if (w != null) {
            com.google.gwt.user.client.Element cell = (com.google.gwt.user.client.Element) getCell(i, j).getFirstChild();
            if (w instanceof Component) {
              Component c = (Component) w;

              if (c.isRendered()
                  && (c.el().getParent() == null || (c.el().getParent() != null && c.el().getParent().dom != cell))) {
                c.el().insertInto(cell);
              } else {
                c.render(cell);
              }

            } else {
              cell.appendChild(w.getElement());
            }
            ComponentHelper.doAttach(w);
          }
        }
      }
    }

  }

  protected void resize() {
    if (mainBody == null) {
      return;
    }

    El c = grid.el();
    Size csize = c.getStyleSize();

    int vw = csize.width;
    int vh = 0;
    if (vw < 10 || csize.height < 20) {
      return;
    }

    if (grid.isAutoHeight()) {
      el.setWidth(csize.width);
      scroller.setStyleAttribute("overflow", "visible");
    } else {
      el.setSize(csize.width, csize.height);
      int hdHeight = mainHd.getHeight();
      vh = csize.height - hdHeight;

      if (footer != null) {
        vh -= footer.getHeight();
      }

      scroller.setSize(vw + 1, vh);

      if (innerHd != null) {
        innerHd.setWidth(vw + 1);
      }
      if (footer != null) {
        footer.setWidth(vw + 1);
      }
    }
  }

  protected void restoreScroll(Point state) {
    scroller.setScrollLeft(state.x);
    scroller.setScrollTop(state.y);
  }

  protected void stopEditing() {
    if (grid instanceof EditorGrid) {
      ((EditorGrid<ModelData>) grid).stopEditing(true);
    }
  }

  protected void syncScroll() {
    syncHeaderScroll();
    GridEvent<ModelData> ge = new GridEvent<ModelData>(grid);
    ge.setScrollLeft(scroller.getScrollLeft());
    ge.setScrollTop(scroller.getScrollTop());
    grid.fireEvent(Events.BodyScroll, ge);
  }

  protected void templateAfterMove(int index) {
    // template method
  }

  protected void templateOnAllColumnWidthsUpdated(List<Integer> ws, int tw) {
    // template method
  }

  protected void templateOnColumnHiddenUpdated(int col, boolean hidden, int tw) {
    // template method
  }

  protected void templateOnColumnWidthUpdated(int col, int w, int tw) {
    // template method
  }

  protected void templateOnLayout(int vw, int vh) {
    // template method
  }

  protected void templateUpdateColumnText(int col, String text) {
    // template method
  }

  protected void updateAllColumnWidths() {
    int tw = getTotalWidth();
    int clen = cm.getColumnCount();
    Stack<Integer> ws = new Stack<Integer>();
    JsArray jsws = new JsArray();

    for (int i = 0; i < clen; i++) {
      ws.push(getColumnWidth(i));
      jsws.add(getColumnWidth(i));
    }

    innerHd.firstChild().firstChild().setWidth(tw);

    for (int i = 0; i < clen; i++) {
      header.updateColumnWidth(i, ws.get(i));
    }

    NodeList<Element> ns = getRows();
    for (int i = 0, len = ns.getLength(); i < len; i++) {
      Element row = ns.getItem(i);
      row.getStyle().setPropertyPx("width", tw);
      if (row.getFirstChild() != null) {
        row.getFirstChildElement().getStyle().setPropertyPx("width", tw);
        TableSectionElement e = row.getFirstChild().cast();
        TableRowElement nodeList = e.getRows().getItem(0);
        for (int j = 0; j < clen; j++) {
          ((Element) nodeList.getChildNodes().getItem(j)).getStyle().setPropertyPx("width", ws.get(j));
        }
      }
    }

    templateOnAllColumnWidthsUpdated(ws, tw);
  }

  protected void updateColumnHidden(int index, boolean hidden) {
    int tw = getTotalWidth();
    String display = hidden ? "none" : "";

    El.fly(innerHd.dom.getFirstChildElement()).setWidth(getOffsetWidth());
    El.fly(innerHd.dom.getFirstChildElement().getFirstChildElement()).setWidth(tw);

    header.updateColumnHidden(index, hidden);
    if (footer != null) {
      footer.updateTotalWidth(getOffsetWidth(), tw);
      footer.updateColumnHidden(index, hidden);
    }

    NodeList<Element> ns = getRows();
    for (int i = 0, len = ns.getLength(); i < len; i++) {
      Element elem = ns.getItem(i);
      El.fly(elem).setWidth(tw);
      El.fly(elem).firstChild().setWidth(tw);
      TableSectionElement e = elem.getFirstChild().cast();
      Element cell = e.getRows().getItem(0).getChildNodes().getItem(index).cast();
      cell.getStyle().setProperty("display", display);
    }

    templateOnColumnHiddenUpdated(index, hidden, tw);

    lastViewWidth = -1;
    layout();
  }

  protected void updateColumnWidth(int col, int width) {
    int tw = getTotalWidth();
    int w = getColumnWidth(col);

    // innerHd.firstChild().setWidth(getOffsetWidth());
    // innerHd.firstChild().firstChild().setWidth(tw);

    header.updateTotalWidth(getOffsetWidth(), tw);
    header.updateColumnWidth(col, w);

    if (footer != null) {
      footer.updateTotalWidth(getOffsetWidth(), tw);
      footer.updateColumnWidth(col, w);
    }

    NodeList<Element> ns = getRows();
    for (int i = 0, len = ns.getLength(); i < len; i++) {
      Element row = ns.getItem(i);
      row.getStyle().setPropertyPx("width", tw);
      if (row.getFirstChild() != null) {
        row.getFirstChildElement().getStyle().setPropertyPx("width", tw);
        TableSectionElement e = row.getFirstChild().cast();
        ((Element) e.getRows().getItem(0).getChildNodes().getItem(col)).getStyle().setPropertyPx("width", w);
      }
    }

    templateOnColumnWidthUpdated(col, w, tw);
    syncHScroll();
  }

  protected void updateHeaderSortState() {
    SortInfo state = ds.getSortState();
    if (state == null || state.getSortField() == null) {
      return;
    }
    if (sortState == null || (!sortState.getSortField().equals(state.getSortField()))
        || sortState.getSortDir() != state.getSortDir()) {
      GridEvent<ModelData> e = new GridEvent<ModelData>(grid);
      e.setSortInfo(state);

      sortState = new SortInfo(state.getSortField(), state.getSortDir());
      int sortColumn = cm.findColumnIndex(state.getSortField());
      if (sortColumn != -1) {
        updateSortIcon(sortColumn, sortState.getSortDir());
      }

      // focusGrid(); // if focus got lost, we set it back
      grid.fireEvent(Events.SortChange, e);
    }
  }

  protected void updateSortIcon(int colIndex, SortDir dir) {
    header.updateSortIcon(colIndex, dir);
  }

  private void applyEmptyText() {
    if (emptyText == null) {
      emptyText = "&nbsp;";
    }
    if (!hasRows()) {
      mainBody.setInnerHtml("<div class='x-grid-empty'>" + emptyText + "</div>");
    }
    syncHScroll();
  }

  private native String getCellIndexId(Element elem) /*-{
    if (!$wnd.GXT.___colRe) {
      $wnd.GXT.___colRe = new RegExp("x-grid3-td-([^\\s]+)");
    }
    if (elem) {
      var m = elem.className.match($wnd.GXT.___colRe);
      if(m && m[1]){
        return m[1];
      }
    }
    return null;
  }-*/;

  private String getColumnStyle(int colIndex, boolean isHeader) {
    String style = !isHeader ? cm.getColumnStyle(colIndex) : "";
    if (style == null) style = "";
    style += "width:" + getColumnWidth(colIndex) + "px;";
    if (cm.isHidden(colIndex)) {
      style += "display:none;";
    }
    HorizontalAlignment align = cm.getColumnAlignment(colIndex);
    if (align != null) {
      style += "text-align:" + align.name() + ";";
    }
    return style;
  }

  private int getColumnWidth(int col) {
    int w = cm.getColumnWidth(col);
    return (GXT.isBorderBox ? w : (w - borderWidth > 0 ? w - borderWidth : 0));
  }

  private boolean hasRows() {
    Element e = mainBody.dom.getFirstChildElement();
    return e != null && !e.getClassName().equals("x-grid-empty");
  }

  private void refreshFooterData() {
    if (footer != null) {
      footer.refresh();
    }
  }

  private void restrictMenu(Menu columns) {
    int count = 0;
    for (int i = 0, len = cm.getColumnCount(); i < len; i++) {
      if (!cm.isHidden(i) && !cm.isFixed(i)) {
        count++;
      }
    }

    if (count == 1) {
      for (Component item : columns.getItems()) {
        CheckMenuItem ci = (CheckMenuItem) item;
        if (ci.isChecked()) {
          ci.disable();
        }
      }
    } else {
      for (Component item : columns.getItems()) {
        item.enable();
      }
    }
  }

  private void syncHeaderScroll() {
    int sl = scroller.getScrollLeft();
    innerHd.setScrollLeft(sl);
    // second time for IE (1/2 time first fails, other browsers ignore)
    innerHd.setScrollLeft(sl);

    if (footer != null) {
      footer.el().setScrollLeft(sl);
      footer.el().setScrollLeft(sl);
    }
  }

  private void syncHScroll() {
    if (!hasRows()) {
      El child = mainBody.firstChild();

      if (child != null) {
        child.setWidth(innerHd.firstChild().getWidth(), true);
      }
    }
  }

}

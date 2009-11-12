/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.treetable;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableItem;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

/**
 * This class encapsulates the user interface of a {@link TreeTable}.
 * 
 * @deprecated see @link {@link TreeGrid}
 */
public class TreeTableView {

  private static String bodyHTML;

  static {
    StringBuffer sb = new StringBuffer();
    sb.append("<div style='overflow: hidden;'>");
    sb.append("<div style='overflow: scroll;'>");
    sb.append("<div class='my-treetbl-data'>");
    sb.append("<div class='my-treetbl-tree'></div>");
    sb.append("</div></div></div>");
    bodyHTML = sb.toString();
  }

  // styles
  protected String baseStyle = "my-tbl-item";
  protected String overStyle = baseStyle + "-over";
  protected String selStyle = baseStyle + "-sel";
  protected String cellStyle = baseStyle + "-" + "cell";
  protected String cellOverflowStyle = baseStyle + "-" + "overflow";
  protected String textStyle = cellStyle + "-text";
  protected String widgetStyle = cellStyle + "-widget";
  protected String cellSelector = ".my-treetbl-cell";

  protected TableColumnModel cm;
  protected Element treeDiv;
  protected El scrollEl, dataEl;
  protected TreeTable treeTable;
  protected int scrollBarWidth;

  private int cellSelectorDepth = 10;

  /**
   * Returns the cell.
   * 
   * @param elem the cell element or any child element
   * @return the cell or null if not match
   */
  public Element findCell(Element elem) {
    if (elem == null) {
      return null;
    }
    return El.fly(elem).findParentElement(cellSelector, cellSelectorDepth);
  }

  /**
   * Returns the elements cell index.
   * 
   * @param elem the row element
   * @return the cell index or -1 if not match
   */
  public int findCellIndex(Element elem) {
    Element cell = findCell(elem);
    if (cell != null) {
      return getCellIndex(cell);
    }
    return -1;
  }

  /**
   * Returns the data element.
   * 
   * @return the data elemnt
   */
  public El getDataEl() {
    return dataEl;
  }

  /**
   * Returns the scroll element.
   * 
   * @return the scroll element
   */
  public El getScrollEl() {
    return scrollEl;
  }

  public void resize() {
    int width = treeTable.getOffsetWidth();
    int headerHeight = treeTable.getTableHeader().getOffsetHeight();
    int bodyHeight = treeTable.getOffsetHeight() - headerHeight;
    int bodyWidth = width;

    if (treeTable.isAutoHeight()) {
      scrollEl.setHeight("auto");
      dataEl.setHeight("auto");
      bodyHeight = dataEl.getHeight();
      bodyHeight += treeTable.el().getBorderWidth("tb");
    }

    int columnModelWidth = cm.getTotalWidth();
    dataEl.setWidth(columnModelWidth);
    treeTable.getTableHeader().setWidth(columnModelWidth);

    bodyHeight -= treeTable.el().getBorderWidth("tb");
    bodyWidth -= treeTable.el().getBorderWidth("lr");

    scrollEl.setStyleAttribute("overflowY", "auto");

    if (treeTable.getHorizontalScroll()) {
      scrollEl.setStyleAttribute("overflowX", "auto");
      if (columnModelWidth < width) {
        scrollEl.setStyleAttribute("overflowX", "hidden");
        treeTable.getTableHeader().el().setLeft(0);
      }
    }

    if (treeTable.isAutoHeight()) {
      bodyHeight = -1;
    }
    scrollEl.setSize(bodyWidth, bodyHeight);
  }

  /**
   * The number of levels to search for cells in event delegation (defaults to
   * 10).
   * 
   * @param cellSelectorDepth the cell selector depth
   */
  public void setCellSelectorDepth(int cellSelectorDepth) {
    this.cellSelectorDepth = cellSelectorDepth;
  }

  /**
   * Returns the cell selector depth.
   * 
   * @return the cell selector depth
   */
  public int getCellSelectorDepth() {
    return cellSelectorDepth;
  }

  protected void applyCellStyles(TreeTableItem item) {
    if (item.cellStyles != null) {
      for (int i = 0; i < item.cellStyles.length; i++) {
        setCellStyle(item, i, item.cellStyles[i]);
      }
    }
  }

  protected Element getCell(TableItem item, int cell) {
    return item.el().select("td.my-treetbl-cell").getItem(cell);
  }

  protected int getCellIndex(Element elem) {
    if (elem != null) {
      String index = elem.getAttribute("index");
      if (index != null && index.length() != 0) {
        return Integer.parseInt(index);
      }
    }
    return -1;
  }

  protected Element getTextCellElement(TreeTableItem item, int cell) {
    return ((TreeTableItemUI) item.getUI()).getTextCellElement(cell);
  }

  protected void init(TreeTable treeTable) {
    this.treeTable = treeTable;
    this.cm = treeTable.getColumnModel();
  }

  protected void processRows() {
    for (int i = 0; i < treeTable.getItems().size(); i++) {
      treeTable.getItem(i).getElement().setPropertyInt("rowIndex", i);
    }
  }

  protected void render() {
    scrollBarWidth = XDOM.getScrollBarWidth();

    Element div = DOM.createDiv();
    DOM.setInnerHTML(div, bodyHTML.toString());
    scrollEl = new El(El.fly(div).getSubChild(2));
    dataEl = new El(DOM.getFirstChild(scrollEl.dom));
    treeDiv = dataEl.firstChild().dom;
    DOM.appendChild(treeDiv, treeTable.getRootItem().getElement());
    DOM.appendChild(treeTable.getElement(), DOM.getFirstChild(div));

    treeTable.disableTextSelection(true);

    DOM.sinkEvents(scrollEl.dom, Event.ONSCROLL);
  }

  protected void renderItemValue(TreeTableItem item, int index, Object value) {
    Element textElem = getTextCellElement(item, index);
    if (textElem != null) {
      DOM.setInnerHTML(textElem, "");
      if (value instanceof Widget) {
        Widget widget = (Widget) value;
        textElem.setClassName(widgetStyle);
        DOM.appendChild(textElem, widget.getElement());
        if (treeTable.isAttached()) {
          ComponentHelper.doAttach(widget);
        }
      } else {
        String s = treeTable.getRenderedValue(item, index, value);
        textElem.setInnerHTML(s);
      }
    }
    applyCellStyles(item);
  }

  protected void resizeCells(int columnIndex) {
    TreeTableColumn c = (TreeTableColumn) cm.getColumn(columnIndex);
    int w = ((TreeTableColumnModel) cm).getWidthInPixels(c.getIndex());
    String sel = "." + treeTable.getId() + "-col-" + columnIndex;
    String rule = "width:" + w + "px;" + (!c.isHidden() ? "" : "display: none;");
    treeTable.styleTemplate.set(sel, rule);
    treeTable.styleTemplate.apply();
  }

  protected void setCellStyle(TreeTableItem item, int index, String style) {
    if (item.cellsRendered) {
      Element cell = getTextCellElement(item, index);
      El.fly(cell).addStyleName(textStyle, style);
    }
  }

  protected void showColumn(int columnIndex, boolean show) {
    TreeTableColumn c = (TreeTableColumn) cm.getColumn(columnIndex);
    int w = ((TreeTableColumnModel) cm).getWidthInPixels(c.getIndex());
    String sel = "." + treeTable.getId() + "-col-" + columnIndex;
    String rule = "width:" + w + "px;" + (!c.isHidden() ? "" : "display: none;");
    treeTable.styleTemplate.set(sel, rule);
    treeTable.styleTemplate.apply();
  }

}
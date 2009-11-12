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
import java.util.Map;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsArray;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.widget.menu.CheckMenuItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * <code>GridView</code> that groups data based on a <code>GroupingStore</code>.
 */
public class GroupingView extends GridView {

  public class GroupingViewImages extends GridViewImages {
    private AbstractImagePrototype groupBy = GXT.IMAGES.grid_groupBy();

    public AbstractImagePrototype getGroupBy() {
      return groupBy;
    }

    public void setGroupBy(AbstractImagePrototype groupBy) {
      this.groupBy = groupBy;
    }
  }

  protected boolean enableGrouping;

  private GroupingStore<ModelData> groupingStore;
  private boolean showGroupedColumn = true;
  private boolean enableGroupingMenu = true;
  private boolean isUpdating;
  private boolean showGroupName;
  private String lastGroupField;
  private boolean startCollapsed;
  private GridGroupRenderer groupRenderer;
  private boolean enableNoGroups = true;
  private Map<String, Boolean> state = new FastMap<Boolean>();

  /**
   * Collapses all groups.
   */
  public void collapseAllGroups() {
    toggleAllGroups(false);
  }

  /**
   * Expands all groups.
   */
  public void expandAllGroups() {
    toggleAllGroups(true);
  }

  /**
   * Returns the group renderer.
   * 
   * @return the group renderer
   */
  public GridGroupRenderer getGroupRenderer() {
    return groupRenderer;
  }

  @Override
  public GroupingViewImages getImages() {
    if (images == null) {
      images = new GroupingViewImages();
    }
    return (GroupingViewImages) images;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void initData(ListStore ds, ColumnModel cm) {
    super.initData(ds, cm);
    groupingStore = (GroupingStore) ds;
  }

  /**
   * Returns true if the grouping menu is enabled.
   * 
   * @return the enable grouping state
   */
  public boolean isEnableGroupingMenu() {
    return enableGroupingMenu;
  }

  /**
   * Returns true if the user can turn off grouping.
   * 
   * @return the enable no groups state
   */
  public boolean isEnableNoGroups() {
    return enableNoGroups;
  }

  /**
   * Returns true if the grouped column is visible.
   * 
   * @return the show grouped column
   */
  public boolean isShowGroupedColumn() {
    return showGroupedColumn;
  }

  /**
   * Returns true if start collapsed is enabled.
   * 
   * @return the start collapsed state
   */
  public boolean isStartCollapsed() {
    return startCollapsed;
  }

  /**
   * True to enable the grouping entry in the header context menu (defaults to
   * true).
   * 
   * @param enableGroupingMenu true to enable
   */
  public void setEnableGroupingMenu(boolean enableGroupingMenu) {
    this.enableGroupingMenu = enableGroupingMenu;
  }

  /**
   * True to allow the user to turn off grouping by adding a check item to the
   * header context menu (defaults to true).
   * 
   * @param enableNoGroups true to enable turning off grouping
   */
  public void setEnableNoGroups(boolean enableNoGroups) {
    this.enableNoGroups = enableNoGroups;
  }

  /**
   * Sets the group renderer.
   * 
   * @param groupRenderer the group renderer
   */
  public void setGroupRenderer(GridGroupRenderer groupRenderer) {
    this.groupRenderer = groupRenderer;
  }

  /**
   * Sets whether the grouped column is visible (defaults to true).
   * 
   * @param showGroupedColumn true to show the grouped column
   */
  public void setShowGroupedColumn(boolean showGroupedColumn) {
    this.showGroupedColumn = showGroupedColumn;
  }

  /**
   * Sets whether the groups should start collapsed (defaults to false).
   * 
   * @param startCollapsed true to start collapsed
   */
  public void setStartCollapsed(boolean startCollapsed) {
    this.startCollapsed = startCollapsed;
  }

  /**
   * Toggles all groups.
   * 
   * @param expanded true to expand
   */
  public void toggleAllGroups(boolean expanded) {
    NodeList<Element> groups = getGroups();
    for (int i = 0, len = groups.getLength(); i < len; i++) {
      toggleGroup(groups.getItem(i), expanded);
    }
  }

  @Override
  protected Menu createContextMenu(final int colIndex) {
    Menu menu = super.createContextMenu(colIndex);

    if (menu != null && enableGroupingMenu && cm.isGroupable(colIndex)) {
      MenuItem groupBy = new MenuItem(GXT.MESSAGES.groupingView_groupByText());
      groupBy.setIcon(getImages().getGroupBy());
      groupBy.addSelectionListener(new SelectionListener<MenuEvent>() {

        @Override
        public void componentSelected(MenuEvent ce) {
          onGroupByClick(ce, colIndex);
        }

      });
      menu.add(new SeparatorMenuItem());
      menu.add(groupBy);
    }

    if (menu != null && enableGroupingMenu && enableGrouping && enableNoGroups) {
      final CheckMenuItem showInGroups = new CheckMenuItem(GXT.MESSAGES.groupingView_showGroupsText());
      showInGroups.setChecked(true);
      showInGroups.addSelectionListener(new SelectionListener<MenuEvent>() {

        @Override
        public void componentSelected(MenuEvent ce) {
          onShowGroupsClick(ce, showInGroups.isChecked());
        }
      });
      menu.add(showInGroups);
    }
    return menu;
  }

  protected void doGroupEnd(StringBuilder buf, GroupColumnData g, List<ColumnData> cs, int colCount) {
    buf.append(templates.endGroup());
  }

  protected void doGroupStart(StringBuilder buf, GroupColumnData g, List<ColumnData> cs, int colCount) {
    buf.append(templates.startGroup(g.groupId, g.css, g.style, g.group.toString()));
  }

  @Override
  protected String doRender(List<ColumnData> cs, List<ModelData> rows, int startRow, int colCount, boolean stripe) {
    if (rows.size() < 1) {
      return "";
    }

    String groupField = getGroupField();
    int colIndex = cm.findColumnIndex(groupField);

    enableGrouping = groupField != null;

    if (!enableGrouping || isUpdating) {
      return super.doRender(cs, rows, startRow, colCount, stripe);
    }

    String gstyle = "width:" + getTotalWidth() + ";";
    String gidPrefix = grid.getId();

    ColumnConfig cfg = cm.getColumn(colIndex);

    String prefix = showGroupName ? cfg.getHeader() + ": " : "";

    GroupColumnData curGroup = null;
    String gid = null;

    List<GroupColumnData> groups = new ArrayList<GroupColumnData>();

    for (int j = 0; j < rows.size(); j++) {
      ModelData model = (ModelData) rows.get(j);

      int rowIndex = (j + startRow);

      // the value for the group field
      Object gvalue = model.get(groupField);

      // the rendered group value
      String g = getGroup(gvalue, model, rowIndex, colIndex, ds);

      if (curGroup == null || !curGroup.group.equals(g)) {
        gid = gidPrefix + "-gp-" + groupField + "-" + g;

        boolean isCollapsed = state.get(gid) != null ? !state.get(gid) : startCollapsed;
        String gcls = isCollapsed ? "x-grid-group-collapsed" : "";

        curGroup = new GroupColumnData();
        curGroup.group = g;
        curGroup.field = groupField;
        curGroup.gvalue = gvalue;
        curGroup.text = prefix + g;
        curGroup.groupId = gid;
        curGroup.startRow = rowIndex;
        curGroup.style = gstyle;
        curGroup.css = gcls;
        curGroup.models.add(model);
        groups.add(curGroup);

      } else {
        curGroup.models.add(model);
      }
      model.set("_groupId", gid);

    }

    for (GroupColumnData group : groups) {
      if (groupRenderer != null) {
        String g = groupRenderer.render(group);
        if (g == null || g.equals("")) {
          g = "&nbsp;";
        }
        group.group = g;
      }
    }

    StringBuilder buf = new StringBuilder();

    for (int i = 0, len = groups.size(); i < len; i++) {
      GroupColumnData g = groups.get(i);
      doGroupStart(buf, g, cs, colCount);
      buf.append(super.doRender(cs, g.models, g.startRow, colCount, stripe));
      doGroupEnd(buf, g, cs, colCount);
    }

    return buf.toString();
  }

  protected String getGroup(Object value, ModelData m, int rowIndex, int colIndex, ListStore<ModelData> ds) {
    return value == null ? "" : value.toString();
  }

  @SuppressWarnings("unchecked")
  protected NodeList<Element> getGroups() {
    return (NodeList) mainBody.dom.getChildNodes();
  }

  @Override
  protected NodeList<Element> getRows() {
    if (!enableGrouping) {
      return super.getRows();
    }

    NodeList<Element> gs = getGroups();
    JsArray rows = new JsArray();
    for (int i = 0, len = gs.getLength(); i < len; i++) {
      NodeList<Element> g = gs.getItem(i).getChildNodes().getItem(1).getChildNodes().cast();
      for (int j = 0, len2 = g.getLength(); j < len2; j++) {
        rows.add(g.getItem(j));
      }
    }
    return rows.getJsObject().cast();
  }

  @Override
  protected void initTemplates() {
    super.initTemplates();

    GridSelectionModel<ModelData> sm = grid.getSelectionModel();
    if (sm instanceof CellSelectionModel) {
      sm.addListener(Events.BeforeSelect, new Listener<SelectionEvent<ModelData>>() {
        public void handleEvent(SelectionEvent<ModelData> be) {
          onBeforeRowSelect(be);
        }
      });
    } else {
      sm.addListener(Events.BeforeSelect, new Listener<SelectionEvent<ModelData>>() {
        public void handleEvent(SelectionEvent<ModelData> be) {
          onBeforeRowSelect(be);
        }
      });
    }
  }

  @Override
  protected void onAdd(ListStore<ModelData> store, List<ModelData> models, int index) {
    if (enableGrouping) {
      Point ss = getScrollState();
      refresh(false);
      restoreScroll(ss);
    } else {
      super.onAdd(store, models, index);
    }
  }

  @Override
  protected void onMouseDown(GridEvent<ModelData> ge) {
    El hd = ge.getTarget(".x-grid-group-hd", 10);
    if (hd != null) {
      ge.stopEvent();
      toggleGroup(hd.dom.getParentElement(), isGroupExpanded(hd.dom.getParentElement()));
    }
  }

  @Override
  protected void onRemove(ListStore<ModelData> ds, ModelData m, int index, boolean isUpdate) {
    super.onRemove(ds, m, index, isUpdate);
    Element g = XDOM.getElementById(m.<String> get("_groupId"));
    if (g != null && g.getChildNodes().getItem(1).getChildNodes().getLength() < 1) {
      fly(g).removeFromParent();
    }
    // appply empty text
  }

  protected void onShowGroupsClick(MenuEvent be, boolean checked) {
    if (checked) {
      onGroupByClick(be, activeHdIndex);
    } else {
      groupingStore.clearGrouping();
    }
  }

  @Override
  protected void refreshRow(int row) {
    if (ds.getCount() == 1) {
      refresh(false);
    } else {
      isUpdating = true;
      super.refreshRow(row);
      isUpdating = false;
    }
  }

  @Override
  protected String renderRows(int startRow, int endRow) {
    String groupField = getGroupField();
    boolean eg = groupField != null;
    if (!showGroupedColumn) {
      int colIndex = cm.findColumnIndex(groupField);
      if (!eg && lastGroupField != null) {
        mainBody.update("");
        cm.setHidden(cm.findColumnIndex(lastGroupField), false);
        lastGroupField = null;
      } else if (eg && lastGroupField == null) {
        lastGroupField = groupField;
        cm.setHidden(colIndex, true);
      } else if (eg && lastGroupField != null && !groupField.equals(lastGroupField)) {
        mainBody.update("");
        int oldIndex = cm.findColumnIndex(lastGroupField);
        cm.setHidden(oldIndex, false);
        lastGroupField = groupField;
        cm.setHidden(colIndex, true);
      }
    }
    return super.renderRows(startRow, endRow);
  }

  @Override
  protected void templateOnAllColumnWidthsUpdated(List<Integer> ws, int tw) {
    updateGroupWidths();
  }

  @Override
  protected void templateOnColumnWidthUpdated(int col, int w, int tw) {
    updateGroupWidths();
  }

  @Override
  protected void templateOnLayout(int vw, int vh) {
    updateGroupWidths();
  }

  private Element findGroup(Element el) {
    return new El((com.google.gwt.user.client.Element) el).findParentElement(".x-grid-group", 10);
  }

  private String getGroupField() {
    return groupingStore.getGroupState();
  }

  private boolean isGroupExpanded(Element g) {
    return fly(g).hasStyleName("x-grid-group-collapsed");
  }

  private void onBeforeRowSelect(SelectionEvent<ModelData> se) {
    if (!enableGrouping) {
      return;
    }
    Element row = getRow(se.getIndex());
    if (row != null && row.getOffsetParent() != null) {
      Element g = findGroup(row);
      toggleGroup(g, true);
    }
  }

  private void onGroupByClick(MenuEvent me, int colIndex) {
    groupingStore.groupBy(cm.getDataIndex(colIndex));
  }

  private void toggleGroup(Element g, boolean expanded) {
    if (grid instanceof EditorGrid) {
      ((EditorGrid<ModelData>) grid).stopEditing();
    }
    El gel = fly(g);
    state.put(gel.getId(), expanded);
    if (expanded) {
      gel.removeStyleName("x-grid-group-collapsed");
    } else {
      gel.addStyleName("x-grid-group-collapsed");
    }
    calculateVBar(false);
  }

  private void updateGroupWidths() {
    if (!enableGrouping || ds.getCount() < 1) {
      return;
    }
    String tw = Math.max(cm.getTotalWidth(), el.dom.getOffsetWidth() - getScrollAdjust()) + "px";
    NodeList<Element> gs = getGroups();
    for (int i = 0, len = gs.getLength(); i < len; i++) {
      Element e = gs.getItem(i).getFirstChild().cast();
      e.getStyle().setProperty("width", tw);
    }
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseGroupingLoadConfig;
import com.extjs.gxt.ui.client.data.GroupingLoadConfig;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.SortInfo;

/**
 * A specialized store implementation that provides for grouping models by one
 * of the available fields.
 * 
 * @param <M> the model type
 */
public class GroupingStore<M extends ModelData> extends ListStore<M> {

  private boolean remoteGroup;
  private boolean groupOnSort;
  private String groupField;

  /**
   * Creates a new grouping store.
   */
  public GroupingStore() {
    super();
  }

  /**
   * Creates a new grouping store.
   * 
   * @param loader the list loader
   */
  @SuppressWarnings("unchecked")
  public GroupingStore(ListLoader loader) {
    super(loader);
  }

  /**
   * Clears any existing grouping and refreshes the data using the default sort.
   */
  public void clearGrouping() {
    groupField = null;
    if (remoteGroup) {
      if (config != null && config instanceof GroupingLoadConfig) {
        ((GroupingLoadConfig) config).setGroupBy("");
      }
      loader.load(config);
    } else {
      applySort(false);
      fireEvent(DataChanged, createStoreEvent());
    }
  }

  /**
   * Returns the group state.
   * 
   * @return the state
   */
  public String getGroupState() {
    return groupOnSort && groupField != null ? sortInfo != null ? sortInfo.getSortField() : null
        : groupField;
  }

  /**
   * Groups the data by the specified field.
   * 
   * @param field the field name by which to group by
   */
  public void groupBy(String field) {
    groupBy(field, false);
  }

  /**
   * Groups the data by the specified field.
   * 
   * @param field the field name by which to group by
   * @param forceRegroup true to force the group to be refreshed even if the
   *          field passed in is the same as the current grouping field, false
   *          to skip grouping on the same field
   */
  public void groupBy(String field, boolean forceRegroup) {
    if (groupField != null && groupField.equals(field) && !forceRegroup) {
      return;
    }
    groupField = field;
    if (remoteGroup) {
      if (config != null && config instanceof GroupingLoadConfig) {
        ((GroupingLoadConfig) config).setGroupBy("");
      } else {
        BaseGroupingLoadConfig c = new BaseGroupingLoadConfig();
        c.setGroupBy(field);
        config = c;
      }
    }

    if (groupOnSort) {
      sort(field, null);
      return;
    }

    if (remoteGroup) {
      loader.load(config);
    } else {
      SortInfo se = sortInfo != null ? sortInfo : new SortInfo();
      if (se.getSortField() != null && !se.getSortField().equals(field)) {
        applySort(false);
      } else {
        sortData(field, null);
      }
      fireEvent(DataChanged, createStoreEvent());
    }
  }

  /**
   * Returns true if group on sort is enabled.
   * 
   * @return true for group on sort
   */
  public boolean isGroupOnSort() {
    return groupOnSort;
  }

  /**
   * Returns true if remote grouping is enabled.
   * 
   * @return true for remote grouping
   */
  public boolean isRemoteGroup() {
    return remoteGroup;
  }

  /**
   * True to sort the data on the grouping field when a grouping operation
   * occurs, false to sort based on the existing sort info (defaults to false).
   * 
   * @param groupOnSort true to group on sort
   */
  public void setGroupOnSort(boolean groupOnSort) {
    this.groupOnSort = groupOnSort;
  }

  /**
   * True if the grouping should apply on the server side, false if it is local
   * only (defaults to false). If the grouping is local, it can be applied
   * immediately to the data. For remote grouping, the store requires a list
   * loader.
   * 
   * @param remoteGroup true to enable remote grouping
   */
  public void setRemoteGroup(boolean remoteGroup) {
    this.remoteGroup = remoteGroup;
  }

  protected boolean applyGrouping(boolean alwaysFireChange) {
    if (groupField != null) {
      groupBy(groupField);
      return true;
    } else {
      if (alwaysFireChange) {
        fireEvent(DataChanged, createStoreEvent());
      }
      return false;
    }
  }

  @Override
  protected void applySort(boolean supressEvent) {
    super.applySort(supressEvent);
    // sort by group after sorting
    if (!groupOnSort && !remoteGroup) {
      String gs = getGroupState();
      if (gs != null && !gs.equals(sortInfo.getSortField())) {
        sortData(groupField, SortDir.ASC);
      }
    }
  }

}

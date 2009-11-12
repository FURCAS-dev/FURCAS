/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.io.Serializable;

import com.extjs.gxt.ui.client.Style.SortDir;

/**
 * Default <code>ListLoadConfig</code> implementation.
 * 
 * @see ListLoadConfig
 */
public class BaseListLoadConfig extends BaseModelData implements ListLoadConfig,
    Serializable {

  // needed for serialization
  @SuppressWarnings("unused")
  private SortDir sortDir;

  public BaseListLoadConfig() {
    this("", SortDir.NONE);
  }

  public BaseListLoadConfig(SortInfo info) {
    setSortInfo(info);
  }

  public BaseListLoadConfig(String field, SortDir dir) {
    setSortField(field);
    setSortDir(dir);
  }

  public SortDir getSortDir() {
    return this.<SortDir> get("sortDir");
  }

  public String getSortField() {
    return this.<String> get("sortField");
  }

  public SortInfo getSortInfo() {
    return new SortInfo(getSortField(), getSortDir());
  }

  public void setSortInfo(SortInfo sortInfo) {
    setSortField(sortInfo.getSortField());
    setSortDir(sortInfo.getSortDir());
  }

  public void setSortField(String sortField) {
    set("sortField", sortField);
  }

  public void setSortDir(SortDir sortDir) {
    set("sortDir", sortDir);
  }

}

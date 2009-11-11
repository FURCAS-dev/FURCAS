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

import com.extjs.gxt.ui.client.data.ModelData;

public class GroupColumnData extends ColumnData {

  public String group;

  public String field;

  public Object gvalue;

  public String text;

  public String groupId;

  public int startRow;

  public List<ModelData> models = new ArrayList<ModelData>();

}

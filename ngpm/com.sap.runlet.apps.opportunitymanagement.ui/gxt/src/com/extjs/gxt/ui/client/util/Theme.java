/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

import java.util.Map;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.data.BaseModelData;

/**
 * A UI theme. Themes are identified by there an id. The CSS stylesheet(s)
 * should be included in the host HTML file and given a class = the id. See
 * below for an example of the "gray" theme. Note the class name for each link
 * matches the id "gray":
 * 
 * <code><pre>
 * <link class="gray" rel="stylesheet" type="text/css" href="css/xtheme-gray.css" />
 * <link class="gray" rel="stylesheet" type="text/css" href="css/gxt-all-gray.css" />
 * </code></pre>
 * 
 * @see Theme#BLUE
 * @see Theme#GRAY
 * 
 */
public class Theme extends BaseModelData {

  /**
   * Default GXT blue theme.
   */
  public static Theme BLUE;

  /**
   * GXT gray theme (default path is 'gxt/css/gxt-gray.css').
   */
  public static Theme GRAY;

  static {
    BLUE = new Theme("blue", GXT.MESSAGES.themeSelector_blueTheme(), "gxt-all.css");
    GRAY = new Theme("gray", GXT.MESSAGES.themeSelector_grayTheme(), "gxt/css/gxt-gray.css");
  }

  protected Theme() {

  }

  public Theme(String id, String name, String file) {
    set("id", id);
    set("name", name);
    set("file", file);
  }

  public String getId() {
    return this.<String> get("id");
  }

  public String getName() {
    return this.<String> get("name");
  }

  public String getFile() {
    return this.<String> get("file");
  }

  public Map<String, Object> asMap() {
    Map<String, Object> map = new FastMap<Object>();
    map.put("id", getId());
    map.put("file", getFile());
    return map;
  }

}

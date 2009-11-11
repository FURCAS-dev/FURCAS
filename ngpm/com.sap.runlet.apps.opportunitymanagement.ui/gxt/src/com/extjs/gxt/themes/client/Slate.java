/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.themes.client;

import com.extjs.gxt.ui.client.util.Theme;

/**
 * Slate theme (default path is 'gxt/themes/slate/css/xtheme-slate.css').
 */
public class Slate extends Theme {

  public static Theme SLATE = new Slate();

  public Slate() {
    super("slate", "Slate", "gxt/themes/slate/css/xtheme-slate.css");
  }

  public Slate(String name) {
    super("slate", name, "gxt/themes/slate/css/xtheme-slate.css");
  }

}
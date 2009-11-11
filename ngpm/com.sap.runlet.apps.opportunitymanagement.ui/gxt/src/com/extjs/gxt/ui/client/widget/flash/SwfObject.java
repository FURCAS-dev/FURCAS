/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.flash;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.util.Util;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * <code>JavaScriptObject</code> object that wraps the SwfObject JS Object.
 * 
 * <p />
 * <b>See http://code.google.com/p/swfobject/</b>
 * 
 */
public class SwfObject {
  
  public static class SwfConfig {
    ModelData attrs = new BaseModelData();
    ModelData params = new BaseModelData();
    ModelData flashVars = new BaseModelData();

    String expressInstallUrl;
    String version = "";
    String width = "100%";
    String height = "100%";

    public void addAttribute(String attr, String value) {
      attrs.set(attr, value);
    }

    public void addFlashVar(String var, String value) {
      flashVars.set(var, value);
    }

    public void addParameter(String param, String value) {
      params.set(param, value);
    }

    public String getExpressInstallUrl() {
      return expressInstallUrl;
    }

    /**
     * Returns the flash object height.
     * 
     * @return the height
     */
    public String getHeight() {
      return height;
    }

    /**
     * Returns the flash version.
     * 
     * @return the flash version
     */
    public String getVersion() {
      return version;
    }

    /**
     * Returns the flash object width.
     * 
     * @return the width
     */
    public String getWidth() {
      return width;
    }

    public void setExpressInstallUrl(String expressInstallUrl) {
      this.expressInstallUrl = expressInstallUrl;
    }

    /**
     * Sets the flash object height (defaults to '100%').
     * 
     * @param height the height
     */
    public void setHeight(String height) {
      this.height = height;
    }

    /**
     * Sets the flash version.
     * 
     * @param version the flash object version
     */
    public void setVersion(String version) {
      this.version = version;
    }

    /**
     * Sets the flash object width.
     * 
     * @param width the flash object width
     */
    public void setWidth(String width) {
      this.width = width;
    }
  }
  
  public static void embedSWF(String url, String replaceId, SwfConfig cfg) {
    JavaScriptObject vars = Util.getJsObject(cfg.flashVars, 4);
    JavaScriptObject params = Util.getJsObject(cfg.params, 4);
    JavaScriptObject attrs = Util.getJsObject(cfg.attrs, 4);
    embedSWT(url, replaceId, cfg.width, cfg.height, cfg.version, cfg.expressInstallUrl, vars, params, attrs);
  }

  private native static void embedSWT(String url, String replaceId, String width, String height,
      String version, String expressUrl, JavaScriptObject flashvars,
      JavaScriptObject params, JavaScriptObject attrs) /*-{
      $wnd.swfobject.embedSWF(url, replaceId, width, height, version, expressUrl, flashvars, params, attrs);
    }-*/;


  private SwfObject() {

  }

}

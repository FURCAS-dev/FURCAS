/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.flash;

import java.util.Date;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.flash.SwfObject.SwfConfig;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;

/**
 * Base class for components that embed a flash object.
 */
public class FlashComponent extends BoxComponent {

  public enum WMode {
    TRANSPARENT, OPAQUE, WINDOW
  };

  protected Element swfElement;
  protected SwfObject swfObject;

  private String expressInstallUrl;
  private String flashVersion = "9.0.45";
  private String swfHeight = "100%";
  private String swfId;
  private String swfWidth = "100%";
  private String url;
  private WMode wmode = WMode.TRANSPARENT;
  private boolean ieFixEnabled = GXT.isIE;

  /**
   * Creates a new flash component.
   * 
   * @param url the url of the flash file
   */
  public FlashComponent(String url) {
    this.url = url;
  }

  /**
   * Gets the express install url.
   * 
   * @return the express install url.
   */
  public String getExpressInstall() {
    return expressInstallUrl;
  }

  /**
   * Returns the flash version.
   * 
   * @return the flash version
   */
  public String getFlashVersion() {
    return flashVersion;
  }

  /**
   * Returns the width of the flash object.
   * 
   * @return the width of the flash object
   */
  public String getSwfHeight() {
    return swfHeight;
  }

  /**
   * Returns the flash id.
   * 
   * @return the flash id
   */
  public String getSwfId() {
    swfId = swfId != null ? swfId : (swfId = "extswf"
        + XDOM.getUniqueId().replace("-", ""));
    return swfId;
  }

  /**
   * Returns the flash object width.
   * 
   * @return the flash object width
   */
  public String getSwfWidth() {
    return swfWidth;
  }

  /**
   * Returns the wmode.
   * 
   * @return the wmode
   */
  public WMode getWmode() {
    return wmode;
  }

  /**
   * Returns true if the IE fix is enabled.
   * 
   * @return the IE fix enabled state
   */
  public boolean isIeFixEnabled() {
    return ieFixEnabled;
  }

  /**
   * Add support for express install.
   * 
   * @param url the url of the express install file
   */
  public void setExpressInstall(String url) {
    this.expressInstallUrl = url;
  }

  /**
   * Sets the flash version.
   * 
   * @param flashVersion the flash version
   */
  public void setFlashVersion(String flashVersion) {
    this.flashVersion = flashVersion;
  }

  /**
   * Sets if an IE fix should be used to ensure flash-to-JS interaction works.
   * Enabled by default.
   * 
   * @param enabled true to enable the IE fix
   */
  public void setIeFixEnabled(boolean enabled) {
    this.ieFixEnabled = enabled;
  }

  /**
   * Sets the flash object height (defaults to '100%').
   * 
   * @param swfHeight the height
   */
  public void setSwfHeight(String swfHeight) {
    this.swfHeight = swfHeight;
  }

  /**
   * Sets the flash id (- will be removed and are not allowed).
   * 
   * @param swfId the flash id
   */
  public void setSwfId(String swfId) {
    this.swfId = swfId;
  }

  /**
   * Sets the flash object width (defaults to '100%').
   * 
   * @param swfWidth the width
   */
  public void setSwfWidth(String swfWidth) {
    this.swfWidth = swfWidth;
  }

  /**
   * Sets the wmode (defaults to WMode.TRANSPARENT).
   * 
   * @param wmode the wmode
   */
  public void setWmode(WMode wmode) {
    this.wmode = wmode;
  }

  @Override
  protected void onAttach() {
    super.onAttach();
    el().setInnerHtml("<div id=\"" + getSwfId() + "\"></div>");
    SwfConfig config = new SwfConfig();
    injectFlash(config);
  }

  @Override
  protected void onDetach() {
    El.fly(swfElement).removeFromParent();
    swfElement = null;
    super.onDetach();
  }

  @Override
  protected void onRender(Element target, int index) {
    setElement(DOM.createDiv(), target, index);
  }

  protected void injectFlash(SwfConfig config) {
    String flashUrl = url;
    if (ieFixEnabled) {
      flashUrl += "?" + new Date().getTime();
    }

    if (expressInstallUrl != null) {
      config.setExpressInstallUrl(expressInstallUrl);
    }

    config.addParameter("id", swfId);
    config.addParameter("allowScriptAccess", "always");

    config.addParameter("wmode", wmode.toString().toLowerCase());

    config.addFlashVar("id", swfId);
    config.addFlashVar("allowedDomain", Window.Location.getHostName());
    config.addFlashVar("elementID", getId());

    config.setVersion(flashVersion);

    SwfObject.embedSWF(flashUrl, swfId, config);

    swfElement = el().firstChild().dom;
  }

}

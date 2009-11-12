/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.tips;

import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.util.Params;
import com.google.gwt.user.client.Element;

/**
 * Configuration information for a tool tip.
 */
public class ToolTipConfig {

  private String text;
  private int showDelay = 500;
  private int hideDelay = 200;
  private int dismissDelay = 5000;
  private int[] mouseOffset = new int[] {15, 18};
  private boolean trackMouse;
  private Template template;
  private Params params;
  private String title;
  private String anchor;
  private boolean autoHide = true;
  private Element target;
  private boolean enabled = true;
  
  private boolean anchorToTarget = true;
  private int anchorOffset = 0;


  /**
   * Creates a new tool tip config.
   */
  public ToolTipConfig() {

  }

  /**
   * Creates a new tool tip config with the given text.
   * 
   * @param text the tool tip text
   */
  public ToolTipConfig(String text) {
    this.setText(text);
  }

  /**
   * Creates a new tool tip config with the given title and text.
   * 
   * @param title the tool tip title
   * @param text the tool tip text
   */
  public ToolTipConfig(String title, String text) {
    this.setTitle(title);
    this.setText(text);
  }

  /**
   * Returns the dismiss delay.
   * 
   * @return the dismiss delay
   */
  public int getDismissDelay() {
    return dismissDelay;
  }

  /**
   * Returns the hide delay in milliseconds.
   * 
   * @return the delay
   */
  public int getHideDelay() {
    return hideDelay;
  }

  /**
   * Returns the mouse offset.
   * 
   * @return the offset
   */
  public int[] getMouseOffset() {
    return mouseOffset;
  }

  /**
   * Returns the params.
   * 
   * @return the params
   */
  public Params getParams() {
    return params;
  }

  /**
   * Returns the show delay in milliseconds.
   * 
   * @return the delay
   */
  public int getShowDelay() {
    return showDelay;
  }

  /**
   * Returns the element the configuration will be applied to.
   * 
   * @return the target element
   */
  public Element getTarget() {
    return target;
  }

  /**
   * Returns the template.
   * 
   * @return the template
   */
  public Template getTemplate() {
    return template;
  }

  /**
   * Returns the tool tip text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Returns the tool tip title.
   * 
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Returns true if auto hide is enabled.
   * 
   * @return the auto hide state
   */
  public boolean isAutoHide() {
    return autoHide;
  }

  /**
   * Returns true if the tool tip is enabled.
   * 
   * @return true for enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * Returns true if mouse tracking is enabled.
   * 
   * @return the mouse track state
   */
  public boolean isTrackMouse() {
    return trackMouse;
  }

  /**
   * True to automatically hide the tooltip after the mouse exits the target
   * element or after the {@link #dismissDelay} has expired if set (defaults to
   * true).
   * 
   * @param autoHide the auto hide state
   */
  public void setAutoHide(boolean autoHide) {
    this.autoHide = autoHide;
  }

  /**
   * Delay in milliseconds before the tooltip automatically hides (defaults to
   * 5000). To disable automatic hiding, set dismissDelay = 0.
   * 
   * @param dismissDelay the dismiss delay
   */
  public void setDismissDelay(int dismissDelay) {
    this.dismissDelay = dismissDelay;
  }

  /**
   * Sets whether the tool tip is enabled (defaults to true).
   * 
   * @param enabled true to enable
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Delay in milliseconds after the mouse exits the target element but before
   * the tooltip actually hides (defaults to 200). Set to 0 for the tooltip to
   * hide immediately.
   * 
   * @param hideDelay the hide delay
   */
  public void setHideDelay(int hideDelay) {
    this.hideDelay = hideDelay;
  }

  /**
   * An XY offset from the mouse position where the tooltip should be shown
   * (defaults to [15,18]).
   * 
   * @param mouseOffset the offset
   */
  public void setMouseOffset(int[] mouseOffset) {
    this.mouseOffset = mouseOffset;
  }

  /**
   * The paramters to be used when a custom a {@link #template} is specified.
   * 
   * @param params the params
   */
  public void setParams(Params params) {
    this.params = params;
  }

  /**
   * Delay in milliseconds before the tooltip displays after the mouse enters
   * the target element (defaults to 500).
   * 
   * @param showDelay the show delay
   */
  public void setShowDelay(int showDelay) {
    this.showDelay = showDelay;
  }

  /**
   * Sets an optional sub-element of the target component that the configuration
   * should be applied to.
   * 
   * @param target the target element
   */
  // public void setTarget(Element target) {
  // this.target = target;
  // }
  /**
   * A optional template to be used to render the tool tip. The {@link #params}
   * will be applied to the template. If specified, {@link #title} and
   * {@link #text} will be added to the params before being applied to the
   * template.
   * 
   * @param template the template
   */
  public void setTemplate(Template template) {
    this.template = template;
  }

  /**
   * The tool tip text.
   * 
   * @param text the text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Sets the tool tip title.
   * 
   * @param title the title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * True to have the tooltip follow the mouse as it moves over the target
   * element (defaults to false).
   * 
   * @param trackMouse the track mouse state
   */
  public void setTrackMouse(boolean trackMouse) {
    this.trackMouse = trackMouse;
  }

  public void setAnchor(String anchor) {
    this.anchor = anchor;
  }

  public String getAnchor() {
    return anchor;
  }

  public void setAnchorToTarget(boolean anchorToTarget) {
    this.anchorToTarget = anchorToTarget;
  }

  public boolean isAnchorToTarget() {
    return anchorToTarget;
  }

  public void setAnchorOffset(int anchorOffset) {
    this.anchorOffset = anchorOffset;
  }

  public int getAnchorOffset() {
    return anchorOffset;
  }

}
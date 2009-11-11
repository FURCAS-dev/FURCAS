/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.layout;

import com.extjs.gxt.ui.client.util.Margins;

/**
 * Layout data for {@link AnchorLayout}.
 */
public class AnchorData extends MarginData {

  private String anchorSpec;

  public AnchorData() {

  }

  /**
   * Creates a new anchor data.
   * 
   * @param anchorSpec the anchor spec
   */
  public AnchorData(String anchorSpec) {
    this.setAnchorSpec(anchorSpec);
  }

  /**
   * Creates a new anchor data.
   * 
   * @param anchorSpec the anchor spec
   * @param margins the margins
   */
  public AnchorData(String anchorSpec, Margins margins) {
    super(margins);
    this.anchorSpec = anchorSpec;
  }

  /**
   * Sets the anchor spec.
   * 
   * @param anchorSpec the anchor spec
   */
  public void setAnchorSpec(String anchorSpec) {
    this.anchorSpec = anchorSpec;
  }

  /**
   * Returns the anchor spec.
   * 
   * @return the anchor spec
   */
  public String getAnchorSpec() {
    return anchorSpec;
  }

}

/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;

/**
 * TabPanel event type.
 * 
 * <p/>
 * Note: For a given event, only the fields which are appropriate will be filled
 * in. The appropriate fields for each event are documented by the event source.
 * 
 * @see TabPanel
 */
public class TabPanelEvent extends ContainerEvent<TabPanel, TabItem> {

  public TabPanelEvent(TabPanel container) {
    super(container);
  }

  public TabPanelEvent(TabPanel container, TabItem item) {
    super(container, item);
  }

}

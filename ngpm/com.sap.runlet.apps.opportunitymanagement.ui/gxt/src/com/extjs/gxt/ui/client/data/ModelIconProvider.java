/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import com.google.gwt.user.client.ui.AbstractImagePrototype;

public interface ModelIconProvider<M extends ModelData> {

  public AbstractImagePrototype getIcon(M model);

}

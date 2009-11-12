/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.event;

import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * A <code>SelectionChangedListener</code> that ignores its own selection
 * events. Useful when registering the provider with the
 * <code>SelectionService</code>.
 */
public class SourceSelectionChangedListener extends SelectionChangedListener<ModelData> {
  private SelectionProvider<ModelData> provider;

  public SourceSelectionChangedListener(SelectionProvider<ModelData> provider) {
    this.provider = provider;
  }

  public void selectionChanged(final SelectionChangedEvent<ModelData> event) {
    SelectionProvider<ModelData> eventProvider = event.getSelectionProvider();
    if (eventProvider != provider) {
      if (provider.getSelection().get(0) != eventProvider.getSelection().get(0)) {
        DeferredCommand.addCommand(new Command() {
          public void execute() {
            provider.setSelection(event.getSelection());
          }
        });

      }
    }
  }
}

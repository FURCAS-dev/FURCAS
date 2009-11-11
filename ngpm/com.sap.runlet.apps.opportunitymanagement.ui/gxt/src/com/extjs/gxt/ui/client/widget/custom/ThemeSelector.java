/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.widget.custom;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Theme;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.user.client.Element;

/**
 * A combo box for selecting the GXT themes. Changing themes will cause the
 * application to be reloaded.
 */
public class ThemeSelector extends ComboBox<Theme> {

  private Theme last;

  /**
   * Creates a new theme selector.
   */
  public ThemeSelector() {
    setEditable(false);
    setDisplayField("name");
    setWidth(100);
    setTriggerAction(TriggerAction.ALL);
  }

  @Override
  protected void beforeRender() {
    super.beforeRender();
    ListStore<Theme> store = new ListStore<Theme>();
    store.add(ThemeManager.getThemes());
    setStore(store);

    String theme = GXT.getThemeId();
    if (theme == null) {
      setValue(Theme.BLUE);
    } else {
      for (Theme t : store.getModels()) {
        if (theme.equals(t.getId().toLowerCase())) {
          setValue(t);
          break;
        }
      }
    }
    last = getValue();
  }

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    Listener<FieldEvent> l = new Listener<FieldEvent>() {
      public void handleEvent(FieldEvent be) {
        Theme c = getValue();
        if (c != last) {
          last = c;
          GXT.switchTheme(c);
        }
      }
    };
    addListener(Events.Change, l);
    addListener(Events.Collapse, l);
  }
}

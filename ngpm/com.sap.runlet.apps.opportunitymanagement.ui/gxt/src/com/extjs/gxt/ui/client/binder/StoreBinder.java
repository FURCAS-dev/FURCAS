/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binder;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelStringProvider;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionProvider;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreFilter;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentHelper;

/**
 * Abstract base class for all Store Binders. Binders provide model support to
 * data widgets by binding a <code>Store</code> to a component.
 * 
 * @param <S> the store type
 * @param <C> the component being bound
 * @param <M> the model type
 */
public abstract class StoreBinder<S extends Store<M>, C extends Component, M extends ModelData>
    extends BaseObservable implements SelectionProvider<M> {

  protected S store;
  protected C component;
  protected StoreListener<M> listener = new StoreListener<M>() {

    @Override
    public void storeAdd(StoreEvent<M> se) {
      onAdd(se);
    }

    public void storeBeforeDataChanged(StoreEvent<M> se) {
      onBeforeDataChanged(se);
    }

    public void storeClear(StoreEvent<M> se) {
      onClear(se);
    }

    public void storeDataChanged(StoreEvent<M> se) {
      onDataChanged(se);
    }

    public void storeFilter(StoreEvent<M> se) {
      onFilter(se);
    }

    public void storeRemove(StoreEvent<M> se) {
      onRemove(se);
    }

    public void storeSort(StoreEvent<M> se) {
      onSort(se);
    }

    public void storeUpdate(StoreEvent<M> se) {
      onUpdate(se);
    }

  };
  protected ModelStringProvider<M> stringProvider;
  protected ModelStringProvider<M> iconProvider;
  protected ModelStringProvider<M> styleProvider;
  protected ModelStringProvider<M> defaultStringProvider = new ModelStringProvider<M>() {
    public String getStringValue(M model, String property) {
      Object o = model.get(property);
      if (o == null) {
        return "";
      } else {
        return String.valueOf(o);
      }
    }
  };

  private boolean mask;
  private boolean autoSelect;

  /**
   * Creates a new binder instance.
   * 
   * @param store the store
   * @param container the container
   */
  public StoreBinder(S store, C container) {
    this.component = container;
    this.store = store;
    hook();
    bind(store);
  }

  public void addSelectionChangedListener(SelectionChangedListener<M> listener) {
    addListener(Events.SelectionChange, listener);
  }

  /**
   * Returns the matching component for the given model.
   * 
   * @param model the model
   * @return the component
   */
  public abstract Component findItem(M model);

  public List<M> getSelection() {
    return getSelectionFromComponent();
  }

  /**
   * Returns the binder's store.
   * 
   * @return the store
   */
  public Store<M> getStore() {
    return store;
  }

  /**
   * Must be called after the binder had been configured.
   */
  public void init() {
    createAll();
  }

  /**
   * Returns true if select on load is enabled.
   * 
   * @return the auto select state
   */
  public boolean isAutoSelect() {
    return autoSelect;
  }

  /**
   * Returns whether the given model is filtered.
   * 
   * @param parent the model parent
   * @param child the child model
   * @return true if the child is filtered
   */
  public boolean isFiltered(M parent, M child) {
    if (store.isFiltered() && store.getFilters().size() > 0) {
      for (StoreFilter<M> filter : store.getFilters()) {
        boolean result = filter.select(store, parent, child, null);
        if (!result) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Returns true if masking is enabled.
   * 
   * @return the mask state
   */
  public boolean isMask() {
    return mask;
  }

  public void removeSelectionListener(SelectionChangedListener<M> listener) {
    removeListener(Events.SelectionChange, listener);
  }

  /**
   * True to select the first model after the store's data changes.
   * 
   * @param autoSelect true to auto select
   */
  public void setAutoSelect(boolean autoSelect) {
    this.autoSelect = autoSelect;
  }

  /**
   * Sets the binder's icon provider.
   * 
   * @param iconProvider the icon provider
   */
  public void setIconProvider(ModelStringProvider<M> iconProvider) {
    this.iconProvider = iconProvider;
  }

  /**
   * Sets whether a mask should be displayed during a load operation.
   * 
   * @param mask true for mask
   */
  public void setMask(boolean mask) {
    this.mask = mask;
  }

  public void setSelection(List<M> selection) {
    if (selection == null) {
      selection = new ArrayList<M>();
    }
    setSelectionFromProvider(selection);
  }

  /**
   * Sets the current selection for this selection provider.
   * 
   * @param selection the selection
   */
  public void setSelection(M selection) {
    List<M> sel = new ArrayList<M>();
    if (selection != null) {
      sel.add(selection);
    }
    setSelection(sel);
  }

  /**
   * Sets the binder's string provider.
   * 
   * @param stringProvider the string provider
   */
  public void setStringProvider(ModelStringProvider<M> stringProvider) {
    this.stringProvider = stringProvider;
  }

  /**
   * Sets the binder's style provider.
   * 
   * @param styleProvider the style provider
   */
  public void setStyleProvider(ModelStringProvider<M> styleProvider) {
    this.styleProvider = styleProvider;
  }

  protected void bind(S store) {
    if (this.store != null) {
      this.store.removeStoreListener(listener);
    }
    this.store = store;
    if (store != null) {
      store.addStoreListener(listener);
      if (component.isRendered()) {
        createAll();
      }
    }
  }

  protected abstract void createAll();

  protected void fireSelectionChanged(SelectionChangedEvent<M> se) {
    fireEvent(Events.SelectionChange, se);
  }

  protected String getIconValue(M model, String property) {
    if (iconProvider != null) {
      return iconProvider.getStringValue(model, property);
    }
    return null;
  }

  protected abstract List<M> getSelectionFromComponent();

  protected String getTextValue(M model, String property) {
    if (stringProvider != null) {
      return stringProvider.getStringValue(model, property);
    }
    return null;
  }

  protected String getTextValue(M model, String property, boolean useDefault) {
    if (stringProvider != null) {
      return stringProvider.getStringValue(model, property);
    }
    if (useDefault) {
      return defaultStringProvider.getStringValue(model, property);
    }
    return null;
  }

  protected void hook() {
    component.addListener(Events.SelectionChange, new Listener<ComponentEvent>() {
      public void handleEvent(ComponentEvent ce) {
        SelectionChangedEvent<M> se = new SelectionChangedEvent<M>(StoreBinder.this, getSelection());
        fireSelectionChanged(se);
      }
    });
  }

  protected abstract void onAdd(StoreEvent<M> se);

  protected void onBeforeDataChanged(StoreEvent<M> se) {
    if (mask && component != null) {
      component.mask(GXT.MESSAGES.loadMask_msg());
    }
  }

  protected void onClear(StoreEvent<M> se) {
    removeAll();
  }

  protected void onDataChanged(StoreEvent<M> se) {
    if (mask && component != null) {
      component.unmask();
    }
  }

  protected void onFilter(StoreEvent<M> se) {

  }

  protected abstract void onRemove(StoreEvent<M> se);

  protected void onSort(StoreEvent<M> se) {

  }

  protected abstract void onUpdate(StoreEvent<M> se);

  protected abstract void removeAll();

  protected void setModel(Component c, ModelData model) {
    ComponentHelper.setModel(c, model);
  }

  protected abstract void setSelectionFromProvider(List<M> selection);

  protected abstract void update(M model);
}

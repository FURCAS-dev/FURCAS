/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * BeanModelFactores are responsible for creating new <code>BeanModel</code>
 * instances from Java POJOs. <code>BeanModels</code> are GXT models and can be
 * used with the GXT data API. BeanModelFactories are obtained from @link
 * {@link BeanModelLookup}.
 * 
 * @see BeanModelLookup
 */
public abstract class BeanModelFactory {

  protected abstract BeanModel newInstance();

  /**
   * Creates a new bean model instance.
   * 
   * @param bean creates a new model
   * @return the new model
   */
  public BeanModel createModel(Object bean) {
    BeanModel model = newInstance();
    model.setBean(bean);
    return model;
  }

  /**
   * Creates a list new bean model instances.
   * 
   * @param beans the list of beans
   * @return the list of models
   */
  public List<BeanModel> createModel(Collection<?> beans) {
    List<BeanModel> models = new ArrayList<BeanModel>();
    for (Object obj : beans) {
      models.add(createModel(obj));
    }
    return models;
  }

}

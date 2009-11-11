/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;


/**
 * Provides a convenient method to provide "formatted" data when using
 * templates. Rather than formatting a model value directly, new properties can
 * be set with the formatted values directly on the model. The template then can
 * refer to these new properties.
 * 
 * @param <M> the model type
 */
public abstract class ModelProcessor<M extends ModelData> {

  /**
   * Returns the model to be rendered.
   * 
   * @param model the model
   * @return the updated or new model
   */
  public abstract M prepareData(M model);

}

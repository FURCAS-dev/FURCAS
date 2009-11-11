/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.data;

import java.util.List;

/**
 * A <code>JsonReader</code> implementation that reads JSON data using a
 * <code>ModelType</code> definition and returns a list load result.
 * 
 * @param <D> the <code>ListLoadResult</code> type being returned by the
 *            reader
 */
public class JsonLoadResultReader<D> extends JsonReader<D> {

  /**
   * Creates a new reader.
   * 
   * @param modelType the model type definition
   */
  public JsonLoadResultReader(ModelType modelType) {
    super(modelType);
  }

  /**
   * Responsible for the object being returned by the reader.
   * 
   * @param loadConfig the load config
   * @param records the list of models
   * @param totalCount the total count
   * @return the data to be returned by the reader
   */
  @SuppressWarnings("unchecked")
  protected Object createReturnData(Object loadConfig, List<ModelData> records,
      int totalCount) {
    ListLoadResult<ModelData> result = newLoadResult(loadConfig, records);
    if (result instanceof PagingLoadResult) {
      PagingLoadResult<ModelData> r = (PagingLoadResult) result;

      if (totalCount != -1) {
        r.setTotalLength(totalCount);
      }
    }
    return (D) result;
  }

  /**
   * Template method that provides load result.
   * 
   * @param models the models
   * @return the load result
   */
  protected ListLoadResult<ModelData> newLoadResult(Object loadConfig,
      List<ModelData> models) {
    return new BaseListLoadResult<ModelData>(models);
  }

}

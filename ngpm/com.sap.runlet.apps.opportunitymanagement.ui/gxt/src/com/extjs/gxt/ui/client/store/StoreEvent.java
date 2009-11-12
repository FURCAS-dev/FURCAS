/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.store;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.store.Record.RecordUpdate;

/**
 * A store event.
 * 
 * @param <M> the model type
 */
public class StoreEvent<M extends ModelData> extends BaseEvent {

  private int index;
  private M model;
  private List<M> models;
  private RecordUpdate operation;
  private Record record;
  private Store<? extends M> store;

  /**
   * Creates a new store event.
   * 
   * @param store the store event
   */
  public StoreEvent(Store<? extends M> store) {
    super(store);
    this.store = store;
  }

  /**
   * Returns the index.
   * 
   * @return the index
   */
  public int getIndex() {
    return index;
  }

  /**
   * Returns the model.
   * 
   * @return the model
   */
  public M getModel() {
    return model;
  }

  /**
   * Returns the models.
   * 
   * @return the models
   */
  public List<M> getModels() {
    return models;
  }

  /**
   * Returns the operation.
   * 
   * @return the operation
   */
  public RecordUpdate getOperation() {
    return operation;
  }

  /**
   * Returns the record.
   * 
   * @return the record
   */
  public Record getRecord() {
    return record;
  }

  /**
   * Returns the store.
   * 
   * @return the store
   */
  public Store<? extends M> getStore() {
    return store;
  }

  /**
   * Sets the index.
   * 
   * @param index the index
   */
  public void setIndex(int index) {
    this.index = index;
  }

  /**
   * Sets the model.
   * 
   * @param model the model
   */
  public void setModel(M model) {
    this.model = model;
  }

  /**
   * Sets the models.
   * 
   * @param models the models
   */
  public void setModels(List<M> models) {
    this.models = models;
  }

  /**
   * Sets the operation.
   * 
   * @param operation the operation
   */
  public void setOperation(RecordUpdate operation) {
    this.operation = operation;
  }

  /**
   * Sets the record.
   * 
   * @param record the record
   */
  public void setRecord(Record record) {
    this.record = record;
  }

  /**
   * Sets the store.
   * 
   * @param store the store.
   */
  public void setStore(Store<? extends M> store) {
    this.store = store;
  }

}

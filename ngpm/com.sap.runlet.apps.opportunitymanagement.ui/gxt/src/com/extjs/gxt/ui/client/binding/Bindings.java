/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.binding;

import java.util.Collection;
import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseObservable;
import com.extjs.gxt.ui.client.event.BindingEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * Aggregates one to many field bindings.
 * 
 * <dl>
 * <dt>Events:</dt>
 * 
 * <dd><b>BeforeBind</b> : BindingEvent(source, model)<br>
 * <div>Fires before binding.</div>
 * <ul>
 * <li>source : this</li>
 * <li>model : the model to bind</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>Bind</b> : BindingEvent(source, model)<br>
 * <div>Fires after successful binding.</div>
 * <ul>
 * <li>source : this</li>
 * <li>model : the binded model</li>
 * </ul>
 * </dd>
 * 
 * <dd><b>UnBind</b> : BindingEvent(source, model)<br>
 * <div>Fires after successful unbinding.</div>
 * <ul>
 * <li>source : this</li>
 * <li>model : the unbound model</li>
 * </ul>
 * </dd>
 * </dl>
 * 
 * @see FieldBinding
 */
public class Bindings extends BaseObservable {

  protected ModelData model;
  protected Map<String, FieldBinding> bindings;

  /**
   * Creates a new bindings instance.
   */
  public Bindings() {
    bindings = new FastMap<FieldBinding>();
  }

  /**
   * Adds a field binding.
   * 
   * @param binding the binding instance to add
   */
  public void addFieldBinding(FieldBinding binding) {
    bindings.put(binding.getField().getId(), binding);
  }

  /**
   * Binds the model instance.
   * 
   * @param model the model
   */
  public void bind(final ModelData model) {
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        BindingEvent e = new BindingEvent(Bindings.this, model);
        if (fireEvent(Events.BeforeBind, e)) {
          if (Bindings.this.model != null) {
            unbind();
          }
          Bindings.this.model = model;
          for (FieldBinding binding : bindings.values()) {
            binding.bind(model);
          }
          fireEvent(Events.Bind, e);
        }
      }
    });
  }

  /**
   * Clears all fields by setting the value for each field to <code>null</code>.
   */
  public void clear() {
    for (FieldBinding fieldBinding : getBindings()) {
      fieldBinding.getField().setValue(null);
    }
  }

  /**
   * Returns the field binding for the given field.
   * 
   * @param field the field
   * @return the field binding or null of no match
   */
  public FieldBinding getBinding(Field<?> field) {
    return bindings.get(field.getId());
  }

  /**
   * Returns all bindings.
   * 
   * @return the collection of bindings
   */
  public Collection<FieldBinding> getBindings() {
    return bindings.values();
  }

  /**
   * Returns the currently bound model;
   * 
   * @return the currently bound model;
   */
  public ModelData getModel() {
    return model;
  }

  /**
   * Removes a field binding.
   * 
   * @param binding the binding instance to add
   */
  public void removeFieldBinding(FieldBinding binding) {
    bindings.remove(binding.getField().getId());
  }

  /**
   * Unbinds the current model.
   */
  public void unbind() {
    if (model != null) {
      for (FieldBinding binding : bindings.values()) {
        binding.unbind();
      }
      fireEvent(Events.UnBind, new BindingEvent(this, model));
      model = null;
    }
  }

}

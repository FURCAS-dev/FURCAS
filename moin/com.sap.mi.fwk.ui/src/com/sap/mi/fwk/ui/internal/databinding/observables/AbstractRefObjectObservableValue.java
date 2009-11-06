package com.sap.mi.fwk.ui.internal.databinding.observables;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * An observable implementation that listens to changes of an {@link Attribute}
 * or {@link Reference}. In case of any change a {@link ValueChangeEvent} is
 * fired in order to update all registered target observables.
 * 
 * @author d022960, d027044
 * 
 */
public abstract class AbstractRefObjectObservableValue extends AbstractObservableValue implements IObserving {
	protected RefObject refObject;
	protected StructuralFeature structuralFeature;
	protected UpdateListener listener;
	protected Object oldValue;

	public AbstractRefObjectObservableValue(Realm realm, RefObject refObject, StructuralFeature feature) {
		super(realm);
		Assert.isLegal(refObject != null, "RefObject must not be null"); //$NON-NLS-1$
		Assert.isLegal(feature != null, "StructuralFeature must not be null"); //$NON-NLS-1$
		this.refObject = refObject;
		this.structuralFeature = feature;
		this.oldValue = doGetValue();
	}

	@Override
	public synchronized void dispose() {
		if (listener != null && refObject != null) {
			Connection connection = ModelAdapter.getInstance().getConnection(refObject);
			connection.getSession().getEventRegistry().deregister(listener);
			listener = null;
		}
		refObject = null;
		structuralFeature = null;
		super.dispose();
	}

	public Object getObserved() {
		return refObject;
	}

	/**
	 * Registers a {@link UpdateListener} for the given {@link Attribute} or
	 * {@link Reference}.<br>
	 * This method is called at the point in time the first listener is added to
	 * this observable, e.g.
	 * {@link MoinDataBindingContext#bindValue(IObservableValue, IObservableValue, UpdateValueStrategy, UpdateValueStrategy)}
	 * operation.
	 */
	@Override
	protected void firstListenerAdded() {
		if (refObject == null || !((Partitionable) this.refObject).is___Alive()) {
			return;
		}

		Connection connection = ModelAdapter.getInstance().getConnection(refObject);
		EventRegistry eventRegistry = connection.getSession().getEventRegistry();

		class ValueUpdateListener implements UpdateListener {
			public void notifyUpdate(EventChain event) {
				final Object tmpOldValue = oldValue;
				if (((Partitionable) refObject).is___Alive()) {
					final Object tmpNewValue = refObject.refGetValue(structuralFeature);

					// Check if value has changed
					boolean changed = false;
					if (tmpNewValue == null) {
						changed = (tmpOldValue != null);
					} else if (tmpNewValue != tmpOldValue && !tmpNewValue.equals(tmpOldValue)) {
						changed = true;
					}

					// Do not fire event if there is no change
					if (changed) {
						oldValue = tmpNewValue;
						getRealm().exec(new Runnable() {
							public void run() {
								fireValueChange(Diffs.createValueDiff(tmpOldValue, tmpNewValue));
							}
						});
					}
				}
			}
		}

		if (structuralFeature instanceof Attribute) {
			Attribute attribute = (Attribute) structuralFeature;
			EventFilter etFilter = new AndFilter(new InstanceFilter(refObject), new AttributeFilter(attribute));

			listener = new ValueUpdateListener();
			eventRegistry.registerUpdateListener(listener, etFilter);
		} else if (structuralFeature instanceof Reference) {
			Reference reference = (Reference) structuralFeature;
			Association association = (Association) reference.getReferencedEnd().refImmediateComposite();
			EventFilter etFilter = new AndFilter(new InstanceFilter(refObject), new AssociationFilter(association));

			listener = new ValueUpdateListener();
			eventRegistry.registerUpdateListener(listener, etFilter);
		}
	}

	@Override
	protected void lastListenerRemoved() {
		if (listener != null && refObject != null && refObject.get___Connection().isAlive()) {
			refObject.get___Connection().getSession().getEventRegistry().deregister(listener);
		}
		listener = null;
	}

	@Override
	protected Object doGetValue() {
		return refObject.refGetValue(structuralFeature);
	}

	@Override
	protected void doSetValue(Object value) {
		refObject.refSetValue(structuralFeature, value);
	}

	public Object getValueType() {
		return structuralFeature;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getClass().getName());
		result.append('@');
		result.append(Integer.toHexString(hashCode()));

		result.append(" (refObject:"); //$NON-NLS-1$
		result.append(refObject);
		result.append(")"); //$NON-NLS-1$

		result.append(" (structuralFeature: "); //$NON-NLS-1$
		result.append(structuralFeature);
		result.append(")"); //$NON-NLS-1$

		try {
			Object value = refObject.refGetValue(structuralFeature);
			result.append(" (value: "); //$NON-NLS-1$
			result.append(value);
			result.append(")"); //$NON-NLS-1$
		} catch (Exception exception) {
			// $JL-EXC$ Ignore.
		}

		return result.toString();
	}
}

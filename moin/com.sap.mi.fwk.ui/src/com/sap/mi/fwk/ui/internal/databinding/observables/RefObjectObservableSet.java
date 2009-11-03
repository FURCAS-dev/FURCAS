package com.sap.mi.fwk.ui.internal.databinding.observables;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.UpdateSetStrategy;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ObservableSet;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.internal.databinding.TracingSupport;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.type.AttributeMultiValueEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * An observable implementation that listens to changes on a
 * <code>JMIList</code> implementation. References or multi-valued attributes
 * with cardinality > 1 that are <em>unordered</em> AND <em>unique</em> are
 * represented as a <code>Set</code> (which is backed by <code>JMIList</code>
 * implementation). <br>
 * This implementation listens to {@link LinkChangeEvent} or
 * {@link AttributeMultiValueEvent} and fires corresponding
 * {@link SetChangeEvent}s.
 * 
 * @author d027044, d022960
 * 
 */
public class RefObjectObservableSet extends ObservableSet implements IObserving {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DATABINDING);

	private RefObjectObservableCollectionDelegate delegate = null;

	public RefObjectObservableSet(Realm realm, RefObject refObject, StructuralFeature feature) {
		this(realm, refObject, refObject.refGetValue(feature), feature);
	}

	private RefObjectObservableSet(Realm realm, RefObject refObject, Object value, StructuralFeature feature) {
		super(realm, (value instanceof Set ? (Set<?>) value : new UnorderedUniqueJmiListWrapper((Collection) value, feature)), feature);

		Assert.isLegal(refObject != null, "RefObject must not be null"); //$NON-NLS-1$
		Assert.isLegal(feature != null, "StructuralFeature must not be null"); //$NON-NLS-1$
		delegate = new RefObjectObservableCollectionDelegate(refObject, feature);
	}

	public Object getObserved() {
		return delegate.getRefObject();
	}

	@Override
	public synchronized void dispose() {
		delegate.dispose();
		super.dispose();
	}

	/**
	 * Registers a {@link UpdateListener} for the given <em>unordered</em> AND
	 * <em>unique</em> {@link Attribute} or {@link Reference} with cardinality >
	 * 1.<br>
	 * This method is called at the point in time the first listener is added to
	 * this observable, e.g.
	 * {@link MoinDataBindingContext#bindSet(IObservableSet, IObservableSet, UpdateSetStrategy, UpdateSetStrategy)}
	 * operation.
	 */
	@Override
	protected void firstListenerAdded() {
		if (sTracer.debug()) {
			sTracer
					.debug("RefObjectObservableSet.firstListenerAdded() called for <" + TracingSupport.getName(delegate.getRefObject()) + ">, feature <" + delegate.getFeature().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		UpdateListener listener = new UpdateListener() {
			public void notifyUpdate(EventChain eventChain) {

				if (sTracer.debug()) {
					sTracer
							.debug("RefObjectObservableSet.notifyUpdate() called for <" + TracingSupport.getName(delegate.getRefObject()) + ">, feature <" + delegate.getFeature().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}

				List<ChangeEvent> events = eventChain.getEvents();

				// handle LinkChangeEvents
				HashSet<Object> additions = new HashSet<Object>();
				HashSet<Object> removals = new HashSet<Object>();
				for (Iterator<ChangeEvent> it = events.iterator(); it.hasNext();) {
					ChangeEvent changeEvent = it.next();
					if (changeEvent instanceof LinkChangeEvent) {
						LinkChangeEvent event = (LinkChangeEvent) changeEvent;
						RefBaseObject object = delegate.getForeignRefObject(event);
						if (object != null) {
							if (changeEvent instanceof LinkAddEvent) {
								additions.add(object);
								if (sTracer.debug()) {
									sTracer.debug("Element added"); //$NON-NLS-1$
								}
							} else if (changeEvent instanceof LinkRemoveEvent) {
								removals.add(object);
								if (sTracer.debug()) {
									sTracer.debug("Element removed"); //$NON-NLS-1$
								}
							} else {
								String msg = "Unknown subtype of LinkChangeEvent - supported subtypes: LinkAddEvent, LinkRemoveEvent"; //$NON-NLS-1$
								sTracer.error("notifyUpdate()", msg);//$NON-NLS-1$
								Assert.isTrue(false, msg);
							}
						}
					} else if (changeEvent instanceof AttributeMultiValueEvent) {
						AttributeMultiValueEvent event = (AttributeMultiValueEvent) changeEvent;
						Object object = event.getValue();
						// For primitive types object is now an instance of the
						// corresponding Java type, for RefObject typed
						// attributes object is only a LRI --> resolve the LRI
						// to get the object
						if (object instanceof LRI) {
							object = delegate.getForeignRefObject(event);
						}
						if (object != null) {
							if (event instanceof AttributeValueAddEvent) {
								additions.add(object);
							} else if (event instanceof AttributeValueRemoveEvent) {
								removals.add(object);
							} else {
								String msg = "Unknown subtype of AttributeChangeEvent - supported subtypes: AttributeValueAddEvent, AttributeValueRemoveEvent"; //$NON-NLS-1$
								sTracer.error("notifyUpdate()", msg);//$NON-NLS-1$
								Assert.isTrue(false, msg);
							}
						}
					}
				}
				final SetDiff setDiff = Diffs.createSetDiff(additions, removals);
				getRealm().exec(new Runnable() {
					public void run() {
						fireSetChange(setDiff);
					}
				});
			}
		};
		delegate.addListener(listener);
	}

	@Override
	protected void lastListenerRemoved() {
		if (sTracer.debug()) {
			sTracer
					.debug("RefObjectObservableSet.lastListenerRemoved() called for <" + TracingSupport.getName(delegate.getRefObject()) + ">, feature <" + delegate.getFeature().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		delegate.removeListener();
	}

	/**
	 * This implementation returns the {@link StructuralFeature} from the MOF
	 * metamodel that describes the corresponding multi-valued, unique {@link Attribute}
	 * or {@link Reference} which is observed by this {@link IObservableSet}
	 * <code> instance.
	 */
	@Override
	public Object getElementType() {
		return super.getElementType();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getClass().getName());
		result.append('@');
		result.append(Integer.toHexString(hashCode()));

		result.append(" (RefObject:"); //$NON-NLS-1$
		result.append(delegate.getRefObject());
		result.append(")"); //$NON-NLS-1$

		result.append(" (structuralFeature: "); //$NON-NLS-1$
		result.append(delegate.getFeature());
		result.append(")"); //$NON-NLS-1$

		result.append(" (wrappedSet: "); //$NON-NLS-1$
		result.append(wrappedSet);
		result.append(")"); //$NON-NLS-1$

		return result.toString();
	}

	/**
	 * This class wraps a <code>Collection</code> into a <code>Set</code>. All
	 * methods delegate to the underlying collection which holds the actual
	 * model data. <br>
	 * This wrapper does not have a identity on its own - meaning two wrappers
	 * are equals in case the underlying Moin collections are equal.<br>
	 * Moin exposes multi-valued attributes or references for which the
	 * <code>ordered</code> flag has been defined <code>false</code> as
	 * <code>Collection</code>(s). In order to ensure that the <code>Set</code>
	 * specific constraints are met, the value of the <code>unique</code> flag
	 * has to be <code>true</code>, otherwise an exception has to be thrown.
	 * 
	 * @author d022960
	 * 
	 */
	@SuppressWarnings("unchecked")
	private static class UnorderedUniqueJmiListWrapper implements Set {

		private Collection mCollection = null;

		public UnorderedUniqueJmiListWrapper(Collection collection, StructuralFeature feature) {
			if (!feature.getMultiplicity().isUnique()) {
				throw new IllegalArgumentException(
						"The feature '" + feature.getName() //$NON-NLS-1$
								+ "' is not unique and cannot be used as a base for an observable set - check the corresponding metamodel definition.");//$NON-NLS-1$
			}
			mCollection = collection;
		}

		public boolean contains(Object o) {
			return mCollection.contains(o);
		}

		public boolean containsAll(Collection c) {
			return mCollection.containsAll(c);
		}

		public boolean isEmpty() {
			return mCollection.isEmpty();
		}

		public Iterator iterator() {
			return mCollection.iterator();
		}

		public int size() {
			return mCollection.size();
		}

		public Object[] toArray() {
			return mCollection.toArray();
		}

		public Object[] toArray(Object[] a) {
			return mCollection.toArray(a);
		}

		public boolean add(Object o) {
			return mCollection.add(o);
		}

		public boolean addAll(Collection c) {
			return mCollection.addAll(c);
		}

		public void clear() {
			mCollection.clear();
		}

		public boolean remove(Object o) {
			return mCollection.remove(o);
		}

		public boolean removeAll(Collection c) {
			return mCollection.removeAll(c);
		}

		public boolean retainAll(Collection c) {
			return mCollection.retainAll(c);
		}

		@Override
		public boolean equals(Object obj) {
			return mCollection.equals(obj);
		}

		@Override
		public int hashCode() {
			return mCollection.hashCode();
		}

		@Override
		public String toString() {
			return mCollection.toString();
		}
	}
}

package com.sap.mi.fwk.ui.internal.databinding.observables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.list.ObservableList;
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
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * An observable implementation that listens to changes on a
 * <code>JMIList</code> implementation. References or multi-valued attributes
 * with cardinality > 1 that are <em>ordered</em> are represented as a
 * <code>List</code>. <br>
 * This implementation listens to {@link LinkChangeEvent} or
 * {@link AttributeMultiValueEvent} and fires corresponding
 * {@link ListChangeEvent}s.
 * 
 * <p>
 * Overwriting {@link #updateWrappedList(List)} is not necessary since this list
 * is a live list and always reflects the current state
 * 
 * @author d027044, d022960
 * 
 */
public class RefObjectObservableList extends ObservableList {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_DATABINDING);

	private RefObjectObservableCollectionDelegate delegate = null;

	public RefObjectObservableList(Realm realm, RefObject refObject, StructuralFeature feature) {
		this(realm, refObject, refObject.refGetValue(feature), feature);
	}

	private RefObjectObservableList(Realm realm, RefObject refObject, Object value, StructuralFeature feature) {
		super(realm, (List<?>) value, feature);

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
	 * Registers a {@link UpdateListener} for the given <em>ordered</em>
	 * {@link Attribute} or {@link Reference} with cardinality > 1.<br>
	 * This method is called at the point in time the first listener is added to
	 * this observable, e.g.
	 * {@link MoinDataBindingContext#bindList(IObservableList, IObservableList, UpdateListStrategy, UpdateListStrategy)}
	 * operation.
	 */
	@Override
	protected void firstListenerAdded() {
		if (sTracer.isLoggable(Level.FINE)) {
			sTracer
					.fine("RefObjectObservableList.firstListenerAdded() called for <" + TracingSupport.getName(delegate.getRefObject()) + ">, feature <" + delegate.getFeature().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		UpdateListener listener = new UpdateListener() {
			public void notifyUpdate(EventChain eventChain) {
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer
							.fine("RefObjectObservableList.notifyUpdate() called for <" + TracingSupport.getName(delegate.getRefObject()) + ">, feature <" + delegate.getFeature().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}

				List<ChangeEvent> events = eventChain.getEvents();

				// handle LinkChangeEvents
				List<MoinListDiffEntry> diffEntries = new ArrayList<MoinListDiffEntry>();

				for (Iterator<ChangeEvent> it = events.iterator(); it.hasNext();) {
					ChangeEvent changeEvent = it.next();
					if (changeEvent instanceof LinkChangeEvent) {
						LinkChangeEvent event = (LinkChangeEvent) changeEvent;
						Object object = delegate.getForeignRefObject(event);
						if (object != null) {
							int position = event.getPosition();
							if (event instanceof LinkAddEvent || event instanceof LinkRemoveEvent) {
								diffEntries.add(new MoinListDiffEntry(position, event instanceof LinkAddEvent, object));
							} else {
								String msg = "Unknown subtype of LinkChangeEvent - supported subtypes: LinkAddEvent, LinkRemoveEvent"; //$NON-NLS-1$
								sTracer.logp(Level.SEVERE, RefObject.class.getName(),"notifyUpdate()", msg);//$NON-NLS-1$
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
							int position = event.getPosition();
							if (event instanceof AttributeValueAddEvent || event instanceof AttributeValueRemoveEvent) {
								diffEntries.add(new MoinListDiffEntry(position, event instanceof AttributeValueAddEvent, object));
							} else {
								String msg = "Unknown subtype of AttributeMultiValueEvent - supported subtypes: AttributeValueAddEvent, AttributeValueRemoveEvent"; //$NON-NLS-1$
								sTracer.logp(Level.SEVERE, RefObject.class.getName(), "notifyUpdate()", msg);//$NON-NLS-1$
								Assert.isTrue(false, msg);
							}
						}
					}
				}
				final ListDiff listDiff = Diffs.createListDiff(diffEntries.toArray(new ListDiffEntry[diffEntries.size()]));
				getRealm().exec(new Runnable() {
					public void run() {
						fireListChange(listDiff);
					}
				});
			}
		};
		delegate.addListener(listener);
	}

	/**
	 * This implementation returns the {@link StructuralFeature} from the MOF
	 * metamodel that describes the corresponding multi-valued {@link Attribute}
	 * or {@link Reference} which is observed by this {@link IObservableList}
	 * <code> instance.
	 */
	@Override
	public Object getElementType() {
		return super.getElementType();
	}

	@Override
	protected void lastListenerRemoved() {
		if (sTracer.isLoggable(Level.FINE)) {
			sTracer
					.fine("RefObjectObservableList.lastListenerRemoved() called for <" + TracingSupport.getName(delegate.getRefObject()) + ">, feature <" + delegate.getFeature().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		delegate.removeListener();
	}

	private class MoinListDiffEntry extends ListDiffEntry {

		private int position;
		private boolean isAddition;
		private Object object;

		public MoinListDiffEntry(int position, boolean isAddition, Object object) {
			super();
			this.position = position;
			this.isAddition = isAddition;
			this.object = object;
		}

		@Override
		public Object getElement() {
			return object;
		}

		@Override
		public int getPosition() {
			return position;
		}

		@Override
		public boolean isAddition() {
			return isAddition;
		}
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

		result.append(" (wrappedList: "); //$NON-NLS-1$
		result.append(wrappedList);
		result.append(")"); //$NON-NLS-1$

		return result.toString();
	}
}

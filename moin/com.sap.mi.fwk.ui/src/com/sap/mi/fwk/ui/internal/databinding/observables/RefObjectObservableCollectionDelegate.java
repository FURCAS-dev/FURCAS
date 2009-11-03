package com.sap.mi.fwk.ui.internal.databinding.observables;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.core.databinding.observable.set.ObservableSet;
import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.internal.databinding.TracingSupport;
import com.sap.tc.moin.friends.RefBaseObjectDummyForCollectionAccess;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.events.type.AttributeMultiValueEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * This class contains common functionality for both MOIN
 * {@link RefObjectObservableList} and {@link RefObjectObservableSet}. Since
 * these two classes need to extend different Data Binding base classes (
 * {@link ObservableList} and {@link ObservableSet}) delegation is used.
 * <p>
 * The task of this class is the handling of the MOIN listener attached to the
 * {@link RefObject} this collection belongs to.
 * 
 * @author d027044
 */
public class RefObjectObservableCollectionDelegate {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DATABINDING);

	private RefObject refObject = null;
	private UpdateListener listener = null;
	private StructuralFeature feature = null;

	/**
	 * Creates a new delegate
	 * 
	 * @param refObject
	 *            The {@link RefObject} the collection belongs to
	 */
	public RefObjectObservableCollectionDelegate(RefObject refObject, StructuralFeature feature) {
		super();
		this.refObject = refObject;
		this.feature = feature;
	}

	public RefObject getRefObject() {
		return refObject;
	}

	public StructuralFeature getFeature() {
		return feature;
	}

	/**
	 * Extracts from the given {@link LinkChangeEvent} the object at the other
	 * end of the link. All links provided here should go from the
	 * {@link RefObject} provided in the constructor to another object; this is
	 * the return value of this method.
	 * <p>
	 * Can be used to determine the object added or removed to the collection
	 * 
	 * @param event
	 *            The event to retrieve the foreign object from.
	 * @return The foreign object
	 */
	public RefBaseObject getForeignRefObject(LinkChangeEvent event) {
		Connection connection = event.getEventTriggerConnection();
		// Find the object at the other end of the link
		// (starting point here is the RefObject this list is
		// created for. Here we search the target link end which
		// is the change the link change event was created for
		RefBaseObject object = connection.getElement(event.getStoredLinkEndMri());
		if (object == null || object.equals(refObject)) {
			LRI lri = event.getNonStoredLinkEndLri();
			if (lri != null) {
				object = connection.getElement(lri);
				if (object == null) {
					// Handle deleted elements, use RefObject dummy
					object = new RefBaseObjectDummyForCollectionAccess(lri);
				}
			}
		}
		return object;
	}

	/**
	 * Used to determine the undelying <code>RefBaseObject</code> that has been
	 * added to or removed from the collection. This method MUST NOT be called
	 * if the underlying collection holds instances of some primitive type.
	 * <p/>
	 * The implementation extracts the {@link LRI} from the given
	 * {@link AttributeMultiValueEvent} and tries to resolve it using the
	 * triggering connection. <br>
	 * In case the object has been deleted an instance of type
	 * {@link RefBaseObjectDummyForCollectionAccess} is created. This class
	 * provides a <code>equals(Object)</code> implementation that returns
	 * <code>true</code> if called with an existing RefObject zombie. This
	 * ensures that an existing RefObject instance could still be removed from
	 * any observing <code>IObservableSet</code>s.
	 * <p/>
	 * Note: The precondition is that the caller has checked the return type of
	 * <code>event.getValue()</code> - it has to be of type {@link LRI}.
	 * 
	 * @param event
	 *            The event to retrieve the foreign object from.
	 * @exception ClassCastException
	 *                in case <code>event.getValue()</code> does not return a
	 *                {@link LRI}
	 * 
	 * @return The foreign object
	 */
	public RefBaseObject getForeignRefObject(AttributeMultiValueEvent event) {
		RefBaseObject retValue = null;
		LRI lri = (LRI) event.getValue();

		// For primitive types object is now an instance of the
		// corresponding Java type, for RefObject typed
		// attributes object is only a LRI --> resolve the LRI
		// to get the object
		if (sTracer.debug()) {
			sTracer.debug("Value of the event is a LRI: " + lri.toString()); //$NON-NLS-1$
		}
		retValue = event.getEventTriggerConnection().getElement(lri);
		if (sTracer.debug()) {
			sTracer.debug("LRI was resolved to: " //$NON-NLS-1$
					+ (retValue instanceof RefObject ? TracingSupport.getName((RefObject) lri) : "<null>")); //$NON-NLS-1$
		}
		if (retValue == null) {
			// Handle deleted elements, use RefObject dummy
			retValue = new RefBaseObjectDummyForCollectionAccess(lri);
			if (sTracer.debug()) {
				sTracer.debug("Created dummby RefObject: " //$NON-NLS-1$
						+ retValue.toString());
			}
		}
		return retValue;
	}

	/**
	 * Disposes this delegate and frees the used listener
	 */
	void dispose() {
		listener = null;
		refObject = null;
		feature = null;
	}

	/**
	 * Adds an {@link UpdateListener} to the {@link RefObject} the collection
	 * belongs to. Should be called when the first listener needs to be
	 * registered; it can only be called once since only one listener should be
	 * registered.
	 * 
	 * @param listener
	 *            The listener to register
	 */
	void addListener(UpdateListener listener) {
		Assert.isTrue(listener != null, "Update listener was already registered"); //$NON-NLS-1$
		this.listener = listener;

		if (refObject == null || !((Partitionable) refObject).is___Alive()) {
			return;
		}

		Connection connection = ModelAdapter.getInstance().getConnection(refObject);
		EventRegistry eventRegistry = connection.getSession().getEventRegistry();
		if (feature instanceof Attribute) {
			Attribute attribute = (Attribute) feature;
			EventFilter etFilter = new AndFilter(new InstanceFilter(refObject), new AttributeFilter(attribute));
			eventRegistry.registerUpdateListener(this.listener, etFilter);
		} else if (feature instanceof Reference) {
			Reference reference = (Reference) feature;
			Association association = (Association) reference.getReferencedEnd().refImmediateComposite();
			EventFilter etFilter = new AndFilter(new InstanceFilter(refObject), new AssociationFilter(association));
			eventRegistry.registerUpdateListener(this.listener, etFilter);
		}
	}

	/**
	 * Removes the {@link UpdateListener} set by calling
	 * {@link #addListener(UpdateListener)}.
	 */
	void removeListener() {
		// skip if not alive, moin is using weak references
		if (listener != null && refObject != null && refObject.get___Connection().isAlive()) {
			refObject.get___Connection().getSession().getEventRegistry().deregister(listener);
		}
		listener = null;
	}
}

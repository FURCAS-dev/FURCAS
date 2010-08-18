package com.sap.runlet.interpreter;

import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;



import org.osgi.framework.BundleContext;

import behavioral.events.EventFilter;



public class MethodCallResolverCacheInvalidationListener implements GlobalEventListener, UpdateListener {

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(ResourceSet connection, BundleContext context) {
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	EventFilter ownedMethodSignaturesFilter = new AssociationFilter(connection.getAssociation(
		OwnedSignatures.ASSOCIATION_DESCRIPTOR).refMetaObject());
	EventFilter adaptedToFilter = new AssociationFilter(connection.getAssociation(
		AdaptedTo.ASSOCIATION_DESCRIPTOR).refMetaObject());
	EventFilter adaptersFilter = new AssociationFilter(connection.getAssociation(
		AAdaptedAdapters.ASSOCIATION_DESCRIPTOR).refMetaObject());
	EventFilter allFilter = new AndFilter(ownedMethodSignaturesFilter, adaptedToFilter, adaptersFilter);

	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(allFilter, listenerForType);

	return result;
    }
    
    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    if (event instanceof LinkAddEvent || event instanceof LinkRemoveEvent) {
		Activator.getDefault().getMethodCallResolver().invalidateCache();
		/* TODO do more fine-grained invalidation
		LinkChangeEvent lce = (LinkChangeEvent) event;
		ResourceSet conn = lce.getEventTriggerConnection();
		Association a = (Association) lce.getAffectedMetaObject(conn);
		if (a.equals(conn.getAssociation(OwnedSignatures.ASSOCIATION_DESCRIPTOR).refMetaObject())) {
		    SignatureOwner owner = (SignatureOwner) conn.getElement(lce.getFirstLinkEndMri().getLri());
		    MethodSignature sig = (MethodSignature) conn.getElement(lce.getSecondLinkEndMri().getLri());
		    // TODO invalidate cache for owner; if owner is adapter, invalidate all adapted transitively
		} else if (a.equals(conn.getAssociation(AdaptedTo.ASSOCIATION_DESCRIPTOR).refMetaObject())) {
		    SapClass c = (SapClass) conn.getElement(lce.getFirstLinkEndMri().getLri());
		    TypeAdapter adapter = (TypeAdapter) conn.getElement(lce.getSecondLinkEndMri().getLri());
		    // TODO invalidate cache for owner; if owner is adapter, invalidate all adapted transitively
		} else if (a.equals(conn.getAssociation(AdaptedTo.ASSOCIATION_DESCRIPTOR).refMetaObject())) {
		    SapClass c = (SapClass) conn.getElement(lce.getFirstLinkEndMri().getLri());
		    TypeAdapter adapter = (TypeAdapter) conn.getElement(lce.getSecondLinkEndMri().getLri());
		    // TODO invalidate cache for owner; if owner is adapter, invalidate all adapted transitively
		}
		*/
	    }
	}
    }

}

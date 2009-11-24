package com.sap.runlet.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;

import data.classes.AAdaptedAdapters;
import data.classes.AdaptedTo;
import data.classes.OwnedSignatures;

public class MethodCallResolverCacheInvalidationListener implements GlobalEventListener, UpdateListener {

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
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
		Connection conn = lce.getEventTriggerConnection();
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

package com.sap.coghead.metamodel.eventhandlers;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;

import coghead.ASchemaCollection;
import coghead.Collection;
import coghead.Schema;
import coghead.Variable;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.mmi.model.Association;

public class SchemaConnectionLinkAddEventHandler implements GlobalEventListener, UpdateListener {

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	EventFilter collectionSchemaAssocFilter = new AssociationFilter(
		(Association) connection.getAssociation(ASchemaCollection.ASSOCIATION_DESCRIPTOR).refMetaObject());
	EventFilter collectionCreationFilter = new AndFilter(collectionSchemaAssocFilter, new EventTypeFilter(LinkAddEvent.class));

	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(collectionCreationFilter, listenerForType);

	return result;
    }

    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    if (event instanceof LinkAddEvent) {
		LinkAddEvent ece = (LinkAddEvent) event;
		Connection conn = ece.getEventTriggerConnection();
		Schema schema = (Schema) ece.getFirstLinkEnd(conn);
		Collection collection = (Collection) ece.getSecondLinkEnd(conn);
		if (collection != null && collection.getVariables() != null) {
		    for (Variable v : collection.getVariables()) {
			if (v.getName().equals("FORM")) {
			    v.setSchemaType(schema);
			}
		    }
		}
	    }
	}
    }

}

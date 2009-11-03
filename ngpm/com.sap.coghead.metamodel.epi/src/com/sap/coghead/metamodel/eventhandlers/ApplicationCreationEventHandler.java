package com.sap.coghead.metamodel.eventhandlers;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;

import coghead.Application;
import coghead.ApplicationLevelPermission;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public class ApplicationCreationEventHandler implements GlobalEventListener, UpdateListener {

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	EventFilter applicationFilter = new ClassFilter((MofClass) connection.getClass(Application.CLASS_DESCRIPTOR).refMetaObject(), true);
	EventFilter applicationCreationFilter = new AndFilter(applicationFilter, new EventTypeFilter(ElementCreateEvent.class));

	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(applicationCreationFilter, listenerForType);

	return result;
    }

    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    if (event instanceof ElementCreateEvent) {
		ElementCreateEvent ece = (ElementCreateEvent) event;
		Connection conn = ece.getEventTriggerConnection();
		Application application = (Application) ece.getAffectedElement(conn);
		constructPermissions(application, conn);
	    }
	}
    }

    private void constructPermissions(Application application, Connection conn) {
	ApplicationLevelPermission applicationLevelPermissions = conn.createElement(ApplicationLevelPermission.CLASS_DESCRIPTOR);
	application.setPermissions(applicationLevelPermissions);
    }
    
}

package com.sap.coghead.metamodel.eventhandlers;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;

import coghead.Collection;
import coghead.Form;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * If a collection changes its name, a form that is owned by the collection and has the
 * same name as the collection used to have will be renamed to the new collection's name.
 * 
 * @author Axel Uhl D043530
 *
 */
public class CollectionNameChangeEventHandler implements GlobalEventListener, UpdateListener {

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	JmiHelper jmiHelper = connection.getJmiHelper();
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	EventFilter collectionFilter = new ClassFilter((MofClass) connection.getClass(Collection.CLASS_DESCRIPTOR).refMetaObject(), true);
	EventFilter nameChangeFilter = new AttributeFilter(
		jmiHelper.getAttributeByName((MofClass) connection.getClass(Collection.CLASS_DESCRIPTOR).refMetaObject(),
			"name", /*includeSupertypes*/ true));
	EventFilter collectionNameChangedFilter = new AndFilter(collectionFilter, nameChangeFilter,
		new EventTypeFilter(AttributeValueChangeEvent.class));

	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(collectionNameChangedFilter, listenerForType);

	return result;
    }

    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    if (event instanceof AttributeValueChangeEvent) {
		AttributeValueChangeEvent avce = (AttributeValueChangeEvent) event;
		Connection conn = avce.getEventTriggerConnection();
		Collection collection = (Collection) avce.getAffectedElement(conn);
		String oldValue = (String) avce.getOldValue();
		String newValue = (String) avce.getNewValue();
		for (Form f : collection.getForms()) {
		    if ((f.getName() == null && oldValue == null) ||
			    (f.getName() != null && f.getName().equals(oldValue))) {
			f.setName(newValue);
		    }
		}
	    }
	}
    }
}

package com.sap.coghead.metamodel.eventhandlers;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;

import coghead.Collection;
import coghead.CollectionLevelPermission;
import coghead.Form;
import coghead.Variable;
import coghead.action.MultiplicityEnum;

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
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

public class CollectionCreationEventHandler implements GlobalEventListener, UpdateListener {

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	EventFilter collectionFilter = new ClassFilter((MofClass) connection.getClass(Collection.CLASS_DESCRIPTOR).refMetaObject(), true);
	EventFilter collectionCreationFilter = new AndFilter(collectionFilter, new EventTypeFilter(ElementCreateEvent.class));

	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(collectionCreationFilter, listenerForType);

	return result;
    }

    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    if (event instanceof ElementCreateEvent) {
		ElementCreateEvent ece = (ElementCreateEvent) event;
		Connection conn = ece.getEventTriggerConnection();
		Collection collection = (Collection) ece.getAffectedElement(conn);

		constructImplicitVariables(collection, conn);
		constructCollectionLevelPermissions(collection, conn);
		constructDefaultForm(collection, conn);
	    }
	}
    }

    private void constructDefaultForm(Collection collection, Connection conn) {
	Form defaultForm = conn.createElement(Form.CLASS_DESCRIPTOR);
	defaultForm.setName(collection.getName());
	collection.getForms().add(defaultForm);
    }

    private void constructCollectionLevelPermissions(Collection collection, Connection conn) {
	CollectionLevelPermission permissions = conn.createElement(CollectionLevelPermission.CLASS_DESCRIPTOR);
	collection.setPermissions(permissions);
    }

    private void constructImplicitVariables(Collection collection, Connection conn) {
	RefClass variableClazz = conn.getClass(Variable.CLASS_DESCRIPTOR);
	Variable variable = (Variable) variableClazz.refCreateInstance();
	variable.setName("FORM");
	variable.setMultiplicity(MultiplicityEnum.SINGLE);
	if (collection.getSchema() != null) {
	    variable.setSchemaType(collection.getSchema());
	}
	collection.getVariables().add(variable);
    }

}

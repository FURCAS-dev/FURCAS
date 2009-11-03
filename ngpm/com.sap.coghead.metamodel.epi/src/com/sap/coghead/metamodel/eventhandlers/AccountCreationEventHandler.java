package com.sap.coghead.metamodel.eventhandlers;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;

import coghead.Account;
import coghead.AccountLevelPermission;
import coghead.Role;

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

public class AccountCreationEventHandler implements GlobalEventListener, UpdateListener {

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	EventFilter collectionFilter = new ClassFilter((MofClass) connection.getClass(Account.CLASS_DESCRIPTOR).refMetaObject(), true);
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
		Account account= (Account) ece.getAffectedElement(conn);
		constructImplicitRolesAndPermissions(account, conn);
	    }
	}
    }

    private void constructImplicitRolesAndPermissions(Account account, Connection conn) {
	Role admins = createRole("Admins", conn);
	Role support = createRole("Support", conn);
	Role users = createRole("Users", conn);
	account.getRoles().add(admins);
	account.getRoles().add(support);
	account.getRoles().add(users);
	AccountLevelPermission accountLevelPermissions = conn.createElement(AccountLevelPermission.CLASS_DESCRIPTOR);
	account.setPermissions(accountLevelPermissions);
	accountLevelPermissions.getDesignTimeCreate().add(admins);
	accountLevelPermissions.getDesignTimeUpdate().add(admins);
	accountLevelPermissions.getDesignTimeRetrieve().add(admins);
	accountLevelPermissions.getDesignTimeDelete().add(admins);
	accountLevelPermissions.getRuntimeCreate().add(admins);
	accountLevelPermissions.getRuntimeUpdate().add(admins);
	accountLevelPermissions.getRuntimeRetrieve().add(admins);
	accountLevelPermissions.getRuntimeDelete().add(admins);
	accountLevelPermissions.getRuntimeCreate().add(users);
	accountLevelPermissions.getRuntimeUpdate().add(users);
	accountLevelPermissions.getRuntimeRetrieve().add(users);
	accountLevelPermissions.getRuntimeDelete().add(users);
    }
    
    private Role createRole(String name, Connection conn) {
	Role role = conn.createElement(Role.CLASS_DESCRIPTOR);
	role.setName(name);
	role.setDescription(name);
	return role;
    }

}

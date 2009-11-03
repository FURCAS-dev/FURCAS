package com.sap.ap.metamodel.eventhandlers;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sap.tc.moin.globalmodellistener.GlobalEventListener;
import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import data.classes.AElementsOfTypeClazz;
import data.classes.AOwnedTypeDefinitionOwnerTypedElement;
import data.classes.ActualObjectParameter;
import data.classes.ClassTypeDefinition;
import data.classes.Parameter;
import data.classes.SapClass;
import dataaccess.expressions.This;
import dataaccess.expressions.VariableExpression;

/**
 * Due to the current limitations of the Furcas/TCS approach we cannot create the actual object
 * parameters for the {@link ClassTypeDefinition} that is attached to a {@link This} expression,
 * mostly because creating a number of elements determined dynamically from the cardinality of some
 * other feature is not supported at this time. As a workaround, we install this global event
 * listener which will get notified whenever a {@link This} expressions has its owned type
 * definition set. This handler will determine the formal object parameters of the class and create
 * {@link VariableExpression}s, one for each formal object parameter, and set them as the actual
 * object parameters for the class type definition used by the {@link This} expression. It does so
 * in the scope of the connection that caused the change event.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class ThisTypeDefinitionSetter implements GlobalEventListener, UpdateListener {
    Logger log = Logger.getLogger(ThisTypeDefinitionSetter.class.getName());
    
    /**
     * The OSGi bundle context; will be initialized when {@link #getFilters} is called.
     */
    private BundleContext context;
    
    private ServiceReference globalEventListenerRegistryRef;

    @Override
    public void notifyUpdate(EventChain events) {
	for (ChangeEvent event : events.getEvents()) {
	    if (event instanceof LinkAddEvent) {
		LinkAddEvent lre = (LinkAddEvent) event;
		MRI thisMri = lre.getSecondLinkEndMri();
		Connection conn = event.getEventTriggerConnection();
		This thiz = (This) conn.getElement(thisMri.getLri());
		ClassTypeDefinition ctd = (ClassTypeDefinition) conn.getElement(lre
			.getFirstLinkEndMri().getLri());
		constructActualObjectParams(thiz, ctd, conn);
	    }
	}
    }

    private void constructActualObjectParams(This thiz, ClassTypeDefinition ctd, Connection conn) {
	if (ctd == null) {
	    log.severe("This expression's class type definition doesn't exist yet."+
	    " Unable to establish actual object parameters");
	} else {
	    if (ctd.getClazz() == null) {
		registerForClassToBeSetOnClassTypeDefinition(ctd, conn);
	    } else {
		setActualObjectParameters(ctd, ctd.getClazz(), conn);
	    }
	}
    }

    private void setActualObjectParameters(ClassTypeDefinition ctd, SapClass clazz, Connection conn) {
	RefClass vec = conn
		.getClass(VariableExpression.CLASS_DESCRIPTOR);
	RefClass aopc = conn
		.getClass(ActualObjectParameter.CLASS_DESCRIPTOR);
	for (Parameter param : clazz.getFormalObjectParameters()) {
	    VariableExpression ve = (VariableExpression) vec.refCreateInstance();
	    ve.setVariable(param);
	    ActualObjectParameter aop = (ActualObjectParameter) aopc.refCreateInstance();
	    aop.setFormalObjectParameter(param);
	    aop.setValue(ve);
	    ctd.getObjectParameters().add(aop);
	}
    }

    /**
     * When the class type definition of the {@link This} expression doesn't yet have a
     * {@link SapClass} set, we have to wait for this connection to be made or the class type
     * definition being deleted. In both events, those registrations will be canceled again.
     * If a valid link shows up, the setting of the actual object parameters on the
     * class type definition will be triggered.
     * @param ctd
     */
    private void registerForClassToBeSetOnClassTypeDefinition(ClassTypeDefinition ctd, Connection conn) {
	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(globalEventListenerRegistryRef);
	HashMap<EventFilter, Map<ListenerType, EventListener>> listenerFilters = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	Map<ListenerType, EventListener> ctdDeletedListeners = new HashMap<ListenerType, EventListener>();
	ctdDeletedListeners.put(ListenerType.UPDATE, new UpdateListener() {
	    @Override
	    public void notifyUpdate(EventChain events) {
		// TODO remove listener with yet to be defined API on GlobalEventListenerRegistry
	    }
	});
	listenerFilters.put(new AndFilter(new InstanceFilter(ctd), new EventTypeFilter(ElementDeleteEvent.class)),
		ctdDeletedListeners);
	Map<ListenerType, EventListener> ctdReceivedClassListeners = new HashMap<ListenerType, EventListener>();
	ctdReceivedClassListeners.put(ListenerType.UPDATE, new UpdateListener() {
	    @Override
	    public void notifyUpdate(EventChain events) {
		for (ChangeEvent event : events.getEvents()) {
		    if (event instanceof LinkAddEvent) {
			LinkAddEvent linkAddEvent = (LinkAddEvent) event;
			Connection conn = event.getEventTriggerConnection();
			ClassTypeDefinition ctd = (ClassTypeDefinition) conn
				.getElement(linkAddEvent.getFirstLinkEndMri());
			SapClass clazz = (SapClass) conn.getElement(linkAddEvent
				.getSecondLinkEndMri());
			setActualObjectParameters(ctd, clazz, event.getEventTriggerConnection());
			// TODO remove listener with yet to be defined API on
			// GlobalEventListenerRegistry

		    }
		}
	    }
	});
	listenerFilters.put(new AndFilter(new InstanceFilter(ctd), new AssociationFilter(
		conn.getAssociation(AElementsOfTypeClazz.ASSOCIATION_DESCRIPTOR).refMetaObject()),
		new EventTypeFilter(LinkAddEvent.class)),
		ctdReceivedClassListeners);
	registry.addFilters(listenerFilters);
    }

    @Override
    public Map<EventFilter, Map<ListenerType, EventListener>> getFilters(Connection connection, BundleContext context) {
	this.context = context;
	globalEventListenerRegistryRef = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
	HashMap<EventFilter, Map<ListenerType, EventListener>> result = new HashMap<EventFilter, Map<ListenerType, EventListener>>();
	Association ownedTDAssoc = connection.getAssociation(
		AOwnedTypeDefinitionOwnerTypedElement.ASSOCIATION_DESCRIPTOR).refMetaObject();
	EventFilter assocFilter = new AssociationFilter(ownedTDAssoc);
	EventFilter thisTypeFilter = new ClassFilter(connection.getClass(
		This.CLASS_DESCRIPTOR).refMetaObject(),
		/* includeSubclasses */ true);
	EventFilter andFilter = new AndFilter(assocFilter, thisTypeFilter, new EventTypeFilter(LinkAddEvent.class));
	Map<ListenerType, EventListener> listenerForType = new HashMap<ListenerType, EventListener>();
	listenerForType.put(ListenerType.UPDATE, this);
	result.put(andFilter, listenerForType);
	return result;
    }

}

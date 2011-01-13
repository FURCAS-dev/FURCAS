/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager.framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.NotificationHelper;
import org.eclipse.ocl.examples.eventmanager.Statistics;
import org.eclipse.ocl.examples.eventmanager.filters.AndFilter;
import org.eclipse.ocl.examples.eventmanager.filters.AssociationFilter;
import org.eclipse.ocl.examples.eventmanager.filters.AttributeFilter;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.ClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.ContainmentFilter;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.EventTypeFilter;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.NewValueClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.NotFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OldValueClassFilterIncludingSubclasses;
import org.eclipse.ocl.examples.eventmanager.filters.OrFilter;
import org.eclipse.ocl.examples.eventmanager.filters.StructuralFeatureFilter;


/**
 * The default implementation for the {@link EventManagerFactory} interface
 * Provides a {@link ResourceSet} based cache for {@link EventManager} instances and uses as implementation the {@link EventManagerTableBased}
 * @author Philipp Berger, Axel Uhl
 *
 */
public class EventManagerFactoryImpl implements EventManagerFactory {
    /**
     * When a {@link ResourceSet} key becomes only weakly referenced, the corresponding {@link EventManager} no longer
     * needs to be held here. However, as long as the {@link ResourceSet} exists, an {@link EventManager} obtained
     * for that resource set remains strongly referenced as long as the {@link ResourceSet} is strongly referenced.
     * Imagine a usual client interacting: the event manager is used only to perform a subscription. Afterwards it
     * may happen that the event manager is no longer referenced by the client. Yet, the client would expect the
     * subscriptions to get notified by the event manager.
     */
    WeakHashMap<ResourceSet,EventManager> setToManager= new WeakHashMap<ResourceSet, EventManager>();

    /**
     * @return a new {@link EventManagerFactoryImpl}
     */
    public static EventManagerFactory init() {
        return new EventManagerFactoryImpl();
    }

    public EventManager getEventManagerFor(ResourceSet set) {
        EventManager cached = setToManager.get(set)==null?null:setToManager.get(set);
        if(cached!=null){
            return cached;
        }
        EventManager eventManager = new org.eclipse.ocl.examples.eventmanager.framework.EventManagerTableBased(set);
        setToManager.put(set, eventManager);
        return eventManager;
    }

    public EventManager createEventManager() {
        EventManager eventManager = new org.eclipse.ocl.examples.eventmanager.framework.EventManagerTableBased();
        return eventManager;
    }

    public EventManager createEventManagerFor(ResourceSet set) {
        EventManager eventManager = new org.eclipse.ocl.examples.eventmanager.framework.EventManagerTableBased(set);
        return eventManager;
    }

    public EventTypeFilter createEventTypeFilter(int eventType) {
        EventTypeFilter eventTypeFilter = new EventTypeFilter(eventType);
        return eventTypeFilter;
    }

    public NotFilter createNotFilter(EventFilter filter) {
        NotFilter notFilter = new NotFilter(filter);
        return notFilter;
    }

    public ClassFilter createClassFilter(EClass clazz) {
        ClassFilter classFilter = new ClassFilter(clazz, /* negated */ false);
        return classFilter;
    }

    public ClassFilterIncludingSubclasses createClassFilterIncludingSubclasses(EClass clazz) {
        ClassFilterIncludingSubclasses classFilter = new ClassFilterIncludingSubclasses(clazz, /* negated */ false);
        return classFilter;
    }

    public AttributeFilter createAttributeFilter(EAttribute attribute) {
        AttributeFilter attributeFilter = new AttributeFilter(attribute);
        return attributeFilter;
    }

    public AssociationFilter createAssociationFilter(EReference reference) {
        AssociationFilter associationFilter = new AssociationFilter(reference);
        return associationFilter;
    }

    public OldValueClassFilterIncludingSubclasses createOldValueClassFilterIncludingSubclasses(EClass cls) {
        OldValueClassFilterIncludingSubclasses oldValueClassFilter = new OldValueClassFilterIncludingSubclasses(cls, /* negated */ false);
        return oldValueClassFilter;
    }
    
    public OldValueClassFilter createOldValueClassFilter(EClass cls) {
        OldValueClassFilter oldValueClassFilter = new OldValueClassFilter(cls, /* negated */ false);
        return oldValueClassFilter;
    }

    public NewValueClassFilterIncludingSubclasses createNewValueClassFilterIncludingSubclasses(EClass cls) {
        NewValueClassFilterIncludingSubclasses newValueClassFilter = new NewValueClassFilterIncludingSubclasses(cls, /* negated */ false);
        return newValueClassFilter;
    }

    public NewValueClassFilter createNewValueClassFilter(EClass cls) {
        NewValueClassFilter newValueClassFilter = new NewValueClassFilter(cls, /* negated */ false);
        return newValueClassFilter;
    }

    public ContainmentFilter createContainmentFilter() {
        ContainmentFilter containmentFilter = ContainmentFilter.INSTANCE;
        return containmentFilter;
    }
   
    public AndFilter createAndFilterFor(EventFilter... eventFilters) {
        AndFilter and = new AndFilter(eventFilters);
        return and;
    }

    public OrFilter createOrFilterFor(EventFilter... eventFilters) {
        OrFilter or = new OrFilter(eventFilters);
        return or;
    }

    public EventFilter createFilterForElementInsertionOrDeletion(EClass cls) {
        NewValueClassFilterIncludingSubclasses nv = createNewValueClassFilterIncludingSubclasses(cls);
        OldValueClassFilterIncludingSubclasses ov = createOldValueClassFilterIncludingSubclasses(cls);
        return createAndFilterFor(createOrFilterFor(nv, ov), createContainmentFilter());
    }

    public EventFilter createFilterForElementInsertion(EClass cls) {
        NewValueClassFilterIncludingSubclasses nv = createNewValueClassFilterIncludingSubclasses(cls);
        // Figure out what the containing Reference is
        return createAndFilterFor(createOrFilterForEventTypes(Notification.ADD, Notification.SET, Notification.ADD_MANY), nv,
                createContainmentFilter());
    }

    private LogicalOperationFilterImpl createOrFilterForEventTypes(int... types) {
        LogicalOperationFilterImpl or = new OrFilter();
        for (int t : types) {
            EventTypeFilter e1 = createEventTypeFilter(t);
            or.addOperand(e1);
        }
        return or;

    }

    public EventFilter createFilterForEAttribute(EClass eClass, EAttribute referredProperty) {
        StructuralFeatureFilter sf = null;
        sf = createAttributeFilter(referredProperty);

        ClassFilter cf = createClassFilterIncludingSubclasses(eClass);
        return createAndFilterFor(sf, cf);
    }

    public EventFilter createFilterForEReference(EClass eClass, EReference referredProperty) {
        StructuralFeatureFilter sf = null;
        sf = createAssociationFilter(referredProperty);
        ClassFilter cf = createClassFilterIncludingSubclasses(eClass);
        return createAndFilterFor(sf, cf);
    }

    public Collection<Notification> createNotificationForComposites(Notification event) {
        Statistics.getInstance().begin("createNotificationForComposites", event);
        Set<Notification> result = new HashSet<Notification>();
        Object f = event.getFeature();
        if (f != null && f instanceof EReference && ((EReference) f).isContainment()) {
            handleValues(event, result);
        } else if (f == null && (event.getNotifier() instanceof Resource)) {
            handleValues(event, result);
        }
        result.add(event);
        Statistics.getInstance().end("createNotificationForComposites", event);
        return result;
    }

    /**
     * Calls for each value of the given {@link Notification} {@link #addNotification(EObject, boolean, Notification, Set)}
     * @param event the {@link Notification} to handle
     * @param result the output {@link Set} of {@link Notification}s
     */
    private void handleValues(Notification event, Set<Notification> result) {
        Object value = NotificationHelper.isAddEvent(event) ? event.getNewValue() : event.getOldValue();
        if (NotificationHelper.isManyEvent(event)) {
            assert (value instanceof Collection<?>);
            Collection<?> valueCol = (Collection<?>) value;
            for (Object o : valueCol) {
                if (o instanceof EObject) {
                    addNotification((EObject) o, NotificationHelper.isAddEvent(event), event, result);
                }
            }
        } else {
            if (value instanceof EObject) {
                addNotification((EObject) value, NotificationHelper.isAddEvent(event), event, result);
            }
        }
    }

    /**
     * Creates a new {@link Notification} for the given parameters and adds it to the result set
     * @param value the {@link Notifier} for the new {@link Notification}
     * @param add is it a add or remove {@link Notification}
     * @param event the parent {@link Notification}
     * @param result the ouput set
     */
    private void addNotification(EObject value, boolean add, Notification event, Set<Notification> result) {
        for (EStructuralFeature ref : value.eClass().getEAllStructuralFeatures()) {
            //init new Notification
            Notification notification=null;
            Object valueOfRef = value.eGet(ref);
            if(valueOfRef==null){
                //no value so nothing to do here
                continue;
            }
            if (ref.isMany()) {
                //can cast value to list
                EList<?> values = (EList<?>) valueOfRef;
                switch (values.size()) {
                case 0:
                    // no content
                    break;
                case 1:
                    //create single add notification
                    notification= new EventManagerGeneratedNotification(add ? Notification.ADD : Notification.REMOVE, add ? null : values
                            .get(0), !add ? null : values.get(0), value, ref);
                    break;
                default:
                    //create many add notification
                    notification= new EventManagerGeneratedNotification(add ? Notification.ADD_MANY : Notification.REMOVE_MANY, add ? null : values
                            , !add ? null : values,  value, ref);
                    break;
                }
            }else{
                //simple set notification
                    notification= new EventManagerGeneratedNotification(Notification.SET, add ? null : valueOfRef
                            , !add ? null : valueOfRef, value, ref);
                
            }
            if(notification!=null ){
                //recursive call for new notification
                if(ref instanceof EReference && ((EReference)ref).isContainment()){
                    handleValues(notification, result);
                }
                result.add(notification);
            }
            
        }
    }
    
    /**
     * This class is used to generate new {@link Notification} in case of subtree movements
     * @author Philipp
     *
     */
    static private class EventManagerGeneratedNotification extends NotificationImpl {

        private Object feature;
        private Notifier notifier;

        /**
         * @return the feature
         */
        public Object getFeature() {
            return feature;
        }

        /**
         * @return the notifier
         */
        public Notifier getNotifier() {
            return notifier;
        }
        public EventManagerGeneratedNotification(int eventType, Object oldValue, Object newValue, Notifier noti, Object feature) {
            super(eventType, oldValue, newValue);
            this.feature = feature;
            this.notifier = noti;
        }

    }

} // EventManagerFactoryImpl

package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationHelper;
import de.hpi.sam.bp2009.solution.eventManager.Statistics;
import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.StructuralFeatureFilter;

/**
 * The default implementation for the {@link EventManagerFactory} interface
 * Provides a {@link ResourceSet} based cache for {@link EventManager} instances and uses as implementation the {@link EventManagerTableBased}
 * @author Philipp Berger
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
    @Override
    public EventManager getEventManagerFor(ResourceSet set) {
        EventManager cached = setToManager.get(set)==null?null:setToManager.get(set);
        if(cached!=null){
            return cached;
        }
        EventManager eventManager = new de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased(set);
        setToManager.put(set, eventManager);
        return eventManager;
    }

    @Override
    public EventTypeFilter createEventTypeFilter() {
        EventTypeFilter eventTypeFilter = new EventTypeFilter();
        return eventTypeFilter;
    }

    @Override
    public NotFilter createNotFilter() {
        NotFilter notFilter = new NotFilter();
        return notFilter;
    }

    @Override
    public ClassFilter createClassFilter(EClass clazz) {
        ClassFilter classFilter = new ClassFilter(clazz, /* negated */ false);
        return classFilter;
    }

    @Override
    public ClassFilterIncludingSubclasses createClassFilterIncludingSubclasses(EClass clazz) {
        ClassFilterIncludingSubclasses classFilter = new ClassFilterIncludingSubclasses(clazz, /* negated */ false);
        return classFilter;
    }

    @Override
    public AttributeFilter createAttributeFilter() {
        AttributeFilter attributeFilter = new AttributeFilter();
        return attributeFilter;
    }

    @Override
    public AssociationFilter createAssociationFilter() {
        AssociationFilter associationFilter = new AssociationFilter();
        return associationFilter;
    }

    @Override
    public OldValueClassFilterIncludingSubclasses createOldValueClassFilterIncludingSubclasses(EClass cls) {
        OldValueClassFilterIncludingSubclasses oldValueClassFilter = new OldValueClassFilterIncludingSubclasses(cls, /* negated */ false);
        return oldValueClassFilter;
    }
    @Override
    public OldValueClassFilter createOldValueClassFilter(EClass cls) {
        OldValueClassFilter oldValueClassFilter = new OldValueClassFilter(cls, /* negated */ false);
        return oldValueClassFilter;
    }

    @Override
    public NewValueClassFilterIncludingSubclasses createNewValueClassFilterIncludingSubclasses(EClass cls) {
        NewValueClassFilterIncludingSubclasses newValueClassFilter = new NewValueClassFilterIncludingSubclasses(cls, /* negated */ false);
        return newValueClassFilter;
    }
    @Override
    public NewValueClassFilter createNewValueClassFilter(EClass cls) {
        NewValueClassFilter newValueClassFilter = new NewValueClassFilter(cls, /* negated */ false);
        return newValueClassFilter;
    }

    @Override
    public ContainmentFilter createContainmentFilter() {
        ContainmentFilter containmentFilter = ContainmentFilter.INSTANCE;
        return containmentFilter;
    }
   
    @Override
    public AndFilter createAndFilterFor(EventFilter... eventFilters) {
        AndFilter and = new AndFilter(eventFilters);
        return and;
    }

    @Override
    public OrFilter createOrFilterFor(EventFilter... eventFilters) {
        OrFilter or = new OrFilter(eventFilters);
        return or;
    }

    @Override
    public EventFilter createFilterForElementInsertionOrDeletion(EClass cls) {
        NewValueClassFilterIncludingSubclasses nv = createNewValueClassFilterIncludingSubclasses(cls);
        OldValueClassFilterIncludingSubclasses ov = createOldValueClassFilterIncludingSubclasses(cls);
        return createAndFilterFor(createOrFilterFor(nv, ov), createContainmentFilter());
    }

    @Override
    public EventFilter createFilterForElementInsertion(EClass cls) {
        NewValueClassFilterIncludingSubclasses nv = createNewValueClassFilterIncludingSubclasses(cls);
        // Figure out what the containing Reference is
        return createAndFilterFor(createOrFilterForEventTypes(Notification.ADD, Notification.SET, Notification.ADD_MANY), nv,
                createContainmentFilter());
    }

    private LogicalOperationFilterImpl createOrFilterForEventTypes(int... types) {
        LogicalOperationFilterImpl or = new OrFilter();
        for (int t : types) {
            EventTypeFilter e1 = createEventTypeFilter();
            e1.setEventType(t);
            or.addOperand(e1);
        }
        return or;

    }

    @Override
    public EventFilter createFilterForEAttribute(EClass eClass, EStructuralFeature referredProperty) {
        StructuralFeatureFilter sf = null;
        sf = createAttributeFilter();
        sf.setFeature(referredProperty);

        ClassFilter cf = createClassFilterIncludingSubclasses(eClass);
        return createAndFilterFor(sf, cf);
    }

    @Override
    public EventFilter createFilterForEReference(EClass eClass, EStructuralFeature referredProperty) {
        StructuralFeatureFilter sf = null;
        sf = createAssociationFilter();
        sf.setFeature(referredProperty);
        ClassFilter cf = createClassFilterIncludingSubclasses(eClass);
        return createAndFilterFor(sf, cf);
    }

    @Override
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
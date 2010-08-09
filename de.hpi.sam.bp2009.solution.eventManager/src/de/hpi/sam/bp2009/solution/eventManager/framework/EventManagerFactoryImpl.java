package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;
import java.util.Arrays;
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
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilterIncludingSubclasses;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.StructuralFeatureFilter;

public class EventManagerFactoryImpl implements EventManagerFactory {
    WeakHashMap<ResourceSet,WeakReference<EventManager>> setToManager= new WeakHashMap<ResourceSet, WeakReference<EventManager>>();

    public static EventManagerFactory init() {
        return new EventManagerFactoryImpl();
    }

    public EventManagerFactoryImpl() {
        super();
    }

    @Override
    public EventManager getEventManagerFor(ResourceSet set) {
        EventManager cached = setToManager.get(set)==null?null:setToManager.get(set).get();
        if(cached!=null){
            return cached;
        }
        EventManager eventManager = new de.hpi.sam.bp2009.solution.eventManager.framework.EventManagerTableBased(set);
        setToManager.put(set, new WeakReference<EventManager>(eventManager));
        return eventManager;
    }

    @Override
    public EventTypeFilter createEventTypeFilter() {
        EventTypeFilter eventTypeFilter = new EventTypeFilter();
        return eventTypeFilter;
    }

    @Override
    public LogicalOperationFilter createAndFilter() {
        LogicalOperationFilter andFilter = new AndFilter();
        return andFilter;
    }

    @Override
    public OrFilter createOrFilter() {
        OrFilter orFilter = new OrFilter();
        return orFilter;
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
    public OldValueClassFilter createOldValueClassFilter(EClass cls, boolean includeSubclasses) {
        OldValueClassFilter oldValueClassFilter = new OldValueClassFilter(cls, includeSubclasses, /* negated */ false);
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
   
    /**
     * Handle creation of an And-filter for multiple given filters
     * 
     * @param eventFilters
     * @return
     */
    @Override
    public EventFilter getAndFilterFor(EventFilter... eventFilters) {
        LogicalOperationFilter and = createAndFilter();
        and.getOperands().addAll(Arrays.asList(eventFilters));
        return and;
    }

    /**
     * Creates an And-Filter for all given filters
     * 
     * @param eventFilters
     * @return
     */
    @Override
    public EventFilter getOrFilterFor(EventFilter... eventFilters) {
        LogicalOperationFilter or = createOrFilter();
        or.getOperands().addAll(Arrays.asList(eventFilters));
        return or;
    }

    @Override
    public EventFilter createFilterForElementInsertionOrDeletion(EClass cls) {
        NewValueClassFilterIncludingSubclasses nv = createNewValueClassFilterIncludingSubclasses(cls);
        OldValueClassFilterIncludingSubclasses ov = createOldValueClassFilterIncludingSubclasses(cls);
        return getAndFilterFor(getOrFilterFor(nv, ov), createContainmentFilter());
    }

    @Override
    public EventFilter createFilterForElementInsertion(EClass cls) {
        NewValueClassFilterIncludingSubclasses nv = createNewValueClassFilterIncludingSubclasses(cls);
        // Figure out what the containing Reference is
        return getAndFilterFor(createOrFilterForEventTypes(Notification.ADD, Notification.SET, Notification.ADD_MANY), nv,
                createContainmentFilter());
    }

    private LogicalOperationFilter createOrFilterForEventTypes(int... types) {
        LogicalOperationFilter or = createOrFilter();
        for (int t : types) {
            EventTypeFilter e1 = createEventTypeFilter();
            e1.setEventType(t);
            or.getOperands().add(e1);
        }
        return or;

    }

    @Override
    public EventFilter createFilterForEAttribute(EClass eClass, EStructuralFeature referredProperty) {
        StructuralFeatureFilter sf = null;
        sf = createAttributeFilter();
        sf.setFeature(referredProperty);

        ClassFilter cf = createClassFilterIncludingSubclasses(eClass);
        return getAndFilterFor(sf, cf);
    }

    @Override
    public EventFilter createFilterForEReference(EClass eClass, EStructuralFeature referredProperty) {
        StructuralFeatureFilter sf = null;
        sf = createAssociationFilter();
        sf.setFeature(referredProperty);
        ClassFilter cf = createClassFilterIncludingSubclasses(eClass);
        return getAndFilterFor(sf, cf);
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

    private void addNotification(EObject o, boolean add, Notification event, Set<Notification> result) {
        for (EStructuralFeature ref : o.eClass().getEAllStructuralFeatures()) {
            //init new Notification
            Notification notification=null;
            Object valueOfRef = o.eGet(ref);
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
                    notification= new MyNotification(add ? Notification.ADD : Notification.REMOVE, add ? null : values
                            .get(0), !add ? null : values.get(0), o, ref);
                    break;
                default:
                    //create many add notification
                    notification= new MyNotification(add ? Notification.ADD_MANY : Notification.REMOVE_MANY, add ? null : values
                            , !add ? null : values,  o, ref);
                    break;
                }
            }else{
                //simple set notification
                    notification= new MyNotification(Notification.SET, add ? null : valueOfRef
                            , !add ? null : valueOfRef, o, ref);
                
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
    
    static private class MyNotification extends NotificationImpl {

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

        public MyNotification(int eventType, Object oldValue, Object newValue, Notifier noti, Object feature) {
            super(eventType, oldValue, newValue);
            this.feature = feature;
            this.notifier = noti;
        }

    }

} // EventManagerFactoryImpl
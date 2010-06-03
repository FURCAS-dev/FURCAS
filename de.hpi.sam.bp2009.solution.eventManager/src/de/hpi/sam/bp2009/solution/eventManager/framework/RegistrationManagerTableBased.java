package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;


/**
 * The SessionRegistrationManager encapsulates the configuration that is needed for the SessionEventManager.
 * 
 * @see RegistrationManager
 * @author Daniel Vocke (D044825)
 */
class RegistrationManagerTableBased extends RegistrationManager {

    private Collection<TableForEventFilter> affectedTablesOnElementRepartitioning;

    public RegistrationManagerTableBased() {
        super();
    }

    /**
     * this method adds caching functionality and the filtering by the listener type to the super class' functionality
     * 
     * @see com.sap.tc.moin.repository.events.framework.RegistrationManager#getRegistrationsFor(com.sap.tc.moin.repository.events.type.ChangeEvent)
     */
    public Collection<Registration> getRegistrationsFor(Notification event) {

        Collection<Registration> result = getCachedRegistrationsFromEvent(event);

        if (result == null) {
            result = super.getRegistrationsFor(event);
            cacheRegistrationsForEvent(result, event);
        } else {
            // this is the post change phase - the entry in the HashMap will not
            // be needed any more
            // ((ChangeEventImpl) event).registrations = null;
            setRegistrationsForEvent(event,null);
            // it might happen, that a listener deregistered between the pre and
            // the post event
            result.retainAll(allRegistrations);
        }

        // return reduceCollectionToMatchingListenerType(result, ((ChangeEventImpl)event).getDedicatedListenerType());
        return reduceCollectionToMatchingListenerType(result, ListenerTypeEnum.postChange);
    }

    /**
     * puts the registrations into WeakReferences which will be cached in the event itself
     * 
     * @param registrations
     * @param event
     */
    private void cacheRegistrationsForEvent(Collection<Registration> registrations, Notification event) {
        Collection<WeakReference<Registration>> result = new LinkedList<WeakReference<Registration>>();
        for (Registration reg : registrations) {
            result.add(new WeakReference<Registration>(reg));
        }
        setRegistrationsForEvent(event, result);
        // ((ChangeEventImpl) event).registrations = result;
    }

    /**
     * converts the cached WeakReferences(which are stored in the event instance) to Java References
     * 
     * @param event
     * @return
     */
    private Collection<Registration> getCachedRegistrationsFromEvent(Notification event) {
        // Collection<WeakReference> cachedWeakReferences = ((ChangeEventImpl) event).registrations;
        Collection<WeakReference<Registration>> cachedWeakReferences = getRegistrationsFromEvent(event);
        if (cachedWeakReferences == null)
            return null;

        Collection<Registration> result = new ArrayList<Registration>(cachedWeakReferences.size());

        for (WeakReference<Registration> wref : cachedWeakReferences) {
            Registration registration = wref.get();
            if (registration != null)
                result.add(registration);
        }
        return result;
    }

    HashMap<Notification, Collection<WeakReference<Registration>>> regCache = new HashMap<Notification, Collection<WeakReference<Registration>>>();

    private Collection<WeakReference<Registration>> getRegistrationsFromEvent(Notification event) {
        return regCache.get(event);

    }

    private void setRegistrationsForEvent(Notification event, Collection<WeakReference<Registration>> result) {
        regCache.put(event, result);

    }

    /**
     * All registrations for a certain type of event have been computed an cached so far. For the current event delivery, only
     * PreChangeListeners are needed in case of a preChangeEvent and only ChangeListeners are needed in case of a postChangeEvent
     * 
     * @param registrations
     *            all registrations that matched for the current event
     * @param reduceToPostListener
     *            flag which determines whether (Post-)ChangeListeners or PreChangeListeners are returned
     * @return all registrations that were registered either by a Post- or a PreChangeListener
     */
    private Collection<Registration> reduceCollectionToMatchingListenerType(Collection<Registration> registrations,
            ListenerTypeEnum listenerType) {

        Collection<Registration> result = new ArrayList<Registration>(registrations.size());

        for (Registration registration : registrations)
            if (listenerType.matches(registration.getListenerType()))
                result.add(registration);

        return result;
    }

    /**
     * this method encapsulates the "configuration" of the RegistrationManager.
     */
    protected void init() {
        TableForEventFilter table = null;
        allTables = new HashSet<TableForEventFilter>();
        affectedTablesOnElementRepartitioning = new ArrayList<TableForEventFilter>(4);

        table = new TableForAssociationFilter();
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);

        table = new TableForAttributeFilter();
        // addTableForEventType(table, AttributeValueAddEventImpl.class);
        // addTableForEventType(table, AttributeValueRemoveEventImpl.class);
        // addTableForEventType(table, AttributeValueChangeEventImpl.class);
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);

        table = new TableForClassFilter();
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);

//        TODO check if instance filter used
//        table = new TableInstanceFilter(false);
//        setUsualEvents(table);
//        allTables.add(table);
//        tableByFilterType.put(table.getIdentifier(), table);
//        affectedTablesOnElementRepartitioning.add(table);
//
//        table = new TableInstanceFilter(true);
//        setUsualEvents(table);
//        allTables.add(table);
//        tableByFilterType.put(table.getIdentifier(), table);
//        affectedTablesOnElementRepartitioning.add(table);

        table = new TableForEventTypeFilter();
        // addTableForEventType(table, ElementCreateEventImpl.class);
        // addTableForEventType(table, PreElementCreateEventImpl.class);
        // addTableForEventType(table, ElementDeleteEventImpl.class);
        // addTableForEventType(table, AttributeValueAddEventImpl.class);
        // addTableForEventType(table, AttributeValueRemoveEventImpl.class);
        // addTableForEventType(table, AttributeValueChangeEventImpl.class);
        // addTableForEventType(table, LinkAddEventImpl.class);
        // addTableForEventType(table, LinkRemoveEventImpl.class);
        // addTableForEventType(table, SaveEventImpl.class);
        // addTableForEventType(table, PartitionContentChangeEventImpl.class);
        // addTableForEventType(table, PartitionCreateEventImpl.class);
        // addTableForEventType(table, PartitionRemoveEventImpl.class);
        // addTableForEventType(table, PartitionPropertyChangeEventImpl.class);
        // addTableForEventType(table, PartitionMembershipChangeEventImpl.class);
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);
        eventTypeFilterTable = table;

        /*
         * ================================================================================================ For Testing Purposes
         * only(will be removed as soon as custom event types are supported):
         */
        // Set<EventFilterTable> tables = new HashSet<EventFilterTable>();
        // tables.add(table);
        // tablesByEventType.put("class com.sap.tc.moin.repository.test.core.EventFrameworkTest$DummyEventImpl", tables);
        // ================================================================================================

        table = new TableForPackageFilter();
        // addTableForEventType(table, ElementCreateEventImpl.class);
        // addTableForEventType(table, PreElementCreateEventImpl.class);
        // addTableForEventType(table, ElementDeleteEventImpl.class);
        // addTableForEventType(table, AttributeValueAddEventImpl.class);
        // addTableForEventType(table, AttributeValueRemoveEventImpl.class);
        // addTableForEventType(table, AttributeValueChangeEventImpl.class);
        // addTableForEventType(table, LinkAddEventImpl.class);
        // addTableForEventType(table, LinkRemoveEventImpl.class);
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);
        
        table = new TableForContainmentFilter();
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);
        
        table = new TableForNewValueClassFilter();
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);
        
        table = new TableForOldValueClassFilter();
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);

    }

    private void setUsualEvents(TableForEventFilter table) {
        addTableForEventType(table, Notification.SET);
        addTableForEventType(table, Notification.UNSET);
        addTableForEventType(table, Notification.ADD);
        addTableForEventType(table, Notification.REMOVE);
        addTableForEventType(table, Notification.ADD_MANY);
        addTableForEventType(table, Notification.REMOVE_MANY);
    }

}

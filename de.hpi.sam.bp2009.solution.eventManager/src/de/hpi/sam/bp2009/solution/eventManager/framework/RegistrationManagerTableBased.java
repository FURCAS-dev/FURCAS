package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;


/**
 * The SessionRegistrationManager encapsulates the configuration that is needed for the SessionEventManager.
 * 
 * @see RegistrationManager
 * @author Daniel Vocke (D044825)
 */
class RegistrationManagerTableBased extends RegistrationManager {

    public RegistrationManagerTableBased() {
        super();
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
    @SuppressWarnings("unused")
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
        table = new TableForAssociationFilter();
        setUsualEvents(table);
        allTables.add(table);
        tableByFilterType.put(table.getIdentifier(), table);

        table = new TableForAttributeFilter();
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
        addTableForEventType(table, Notification.MOVE);
    }

}

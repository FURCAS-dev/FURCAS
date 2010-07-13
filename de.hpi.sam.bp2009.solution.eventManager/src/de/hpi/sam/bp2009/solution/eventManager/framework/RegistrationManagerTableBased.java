package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;

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
        super.init();
        @SuppressWarnings("unchecked")
        Class<? extends TableForEventFilter>[] tableTypes = (Class<? extends TableForEventFilter>[]) new Class<?>[] {
                TableForAssociationFilter.class, TableForAttributeFilter.class, TableForClassFilter.class,
                TableForEventTypeFilter.class, TableForPackageFilter.class, TableForContainmentFilter.class,
                TableForNewValueClassFilter.class, TableForOldValueClassFilter.class };
        for (Class<? extends TableForEventFilter> tableType : tableTypes) {
            TableForEventFilter table;
            try {
                Constructor<? extends TableForEventFilter> constructor = tableType.getConstructor(Integer.TYPE);
                table = constructor.newInstance(tableTypes.length);
            } catch (Exception e) {
                throw new RuntimeException("Didn't find constructor(int) on table type "+tableType.getSimpleName(), e);
            }
            setUsualEvents(table);
            registerTable(table);
        }
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

package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.swing.event.ChangeEvent;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;


/**
 * EventFilterTables are used to connect {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.EventFilter EventFilters} and
 * {@link com.sap.tc.moin.repository.events.framework.Registration Registrations}. For each filter type exists a special subtype
 * of EventFilterTable which handles exactly all instances of this filter type. It is responsible for computing all
 * possible registration candidates that match an event in the context of the filter type it handles. Additionally it
 * encapsulates the knowledge how to get the necessary information from the passed event (
 * {@link #getAffectedObject(ChangeEvent)}).<br>
 * 
 * @author Daniel Vocke (D044825)
 */

public abstract class TableForEventFilter {

    /**
     * list of all (normal) registrations that are stored in this instance.
     */
    protected List<Registration> completeYesSet = new ArrayList<Registration>();

    /**
     * list of all (negated) registration that are stored in this instance.
     */
    protected List<Registration> completeNoSet = new ArrayList<Registration>();

    /**
     * index which is needed for deregistration purposes
     */
    protected HashMap<AbstractRegistration, Object> filterCriterionsByRegistration = new HashMap<AbstractRegistration, Object>();

    /**
     * registrations are contained in a FilterTableEntry. This structure is needed to find the registrations for a
     * filter criterion which is being retrieved by an event.
     */
    protected HashMap<Object, FilterTableEntry<Registration>> tableEntryByFilterCriterion = new HashMap<Object, FilterTableEntry<Registration>>();

    protected TableForEventFilter() {
    }

    /**
     * This method encapsulates the knowlegde which information that is contained by the passed event is of interest in
     * the context of the current EventFilterTable.
     */
    public abstract Object getAffectedObject(Notification event);

    /**
     * stores the passed {@link com.sap.tc.moin.repository.events.framework.Registration}. The Registration will stored as
     * "interested in events meeting the filterCriterion of the passed event in the context of the appropriate
     * EventFitlerTable subclass"
     * 
     * @param filter
     * @param registration
     */

    @SuppressWarnings("unchecked") 
    void register(EventFilter filter, Registration registration) {

        FilterTableEntry<Registration> entry = tableEntryByFilterCriterion.get(filter.getFilterCriterion());

        if (entry == null) {
            entry = new FilterTableEntry<Registration>();
            tableEntryByFilterCriterion.put(filter.getFilterCriterion(), entry);
        }

        if (filter.isNegated()) {
            entry.getNegatedRegistrations().add(registration);
            completeNoSet.add(registration);
        } else {
            entry.getRegistrations().add(registration);
            completeYesSet.add(registration);
        }

        // Maintain inverse Map for better performance when deregistering
        Object criterion = filterCriterionsByRegistration.get(registration);
        if (criterion == null) {
            filterCriterionsByRegistration.put(registration, filter.getFilterCriterion());
        }else{
            /*
             * Registration used for other criterion yet, store in a list (happens rarely)
             */
            if (criterion instanceof List<?>){
                ((List<Object>)criterion).add(filter.getFilterCriterion());
            }else{
                List<Object> criterions = new ArrayList<Object>(2);
                criterions.add(criterion);
                criterions.add(filter.getFilterCriterion());
                filterCriterionsByRegistration.put(registration, criterions);
            }

        }
    }

    /**
     * removes all entries affecting the passed registration.
     * 
     * @param registration
     */
    @SuppressWarnings("unchecked") 
    void deregister(Registration registration) {

        Object criterion = filterCriterionsByRegistration.get(registration);
        if (criterion == null)
            return; // registration not stored in this table

        if (criterion instanceof List<?>){
            for (Object filterCriterion : (List<Object>)criterion) {
                _deregister(registration,filterCriterion);
            }

        }else{
            _deregister(registration,criterion);
        }
        filterCriterionsByRegistration.remove(registration);
    }

    /**
     * this method does the main work for {@link #deregister(Registration)}
     * @param registration
     * @param criterion
     */
    private void _deregister(Registration registration, Object criterion){
        FilterTableEntry<Registration> entry = tableEntryByFilterCriterion.get(criterion);

        entry.getRegistrations().remove(registration);
        entry.getNegatedRegistrations().remove(registration);

        completeYesSet.remove(registration);
        completeNoSet.remove(registration);

        if (entry.getRegistrations().size() == 0 && entry.getNegatedRegistrations().size() == 0) {
            tableEntryByFilterCriterion.remove(criterion);
        }        
    }

    /**
     * returns a {@link com.sap.tc.moin.repository.events.framework.RegistrationIterator} that iterates over all Registrations that
     * are either directly registered for the passed event or Registrations that are registrated for "NOT anotherEvent".
     * These Registrations form the base for all possible affected Registrations in the context of an event.
     * 
     * @param event
     * @return an object of type RegistrationIterator
     */
    @SuppressWarnings("unchecked")  //unchecked conversion needed because of Object-return value which can be of type Collection
    RegistrationIterator<Registration> getRegistrationsFor(Notification event, boolean negated) {

        /*
         * returns the fitler criterion which is of interest in context of the current EventFilterTable
         */
        Object affectedFilterTableEntryKeys = getAffectedObject(event);

        // will contain all affected FilterTableEntries that have a registration
        Collection<FilterTableEntry> filterTableEntries = new ArrayList<FilterTableEntry>();

        if (affectedFilterTableEntryKeys instanceof Collection<?>) {
            /*
             * Some EventFilterTables return multiple matching criterions. For example the ClassFilterTable (including
             * Subclasses) returns more than one matching row if there were registrations for a class and its superclass
             * when the subclass was changed.
             */
            // TODO: Possible not necessary / possible performance optimization
            Collection affectedFilterTableEntryKeySet = new ArrayList<Object>((Collection) affectedFilterTableEntryKeys);
            /*
             * if the table is empty, don't do the following expensive poerations..
             */
            if (!tableEntryByFilterCriterion.isEmpty()) {
                // remove contained items that have no registrations
                affectedFilterTableEntryKeySet.retainAll(tableEntryByFilterCriterion.keySet());

                for (Object criterion : affectedFilterTableEntryKeySet) {
                    filterTableEntries.add(tableEntryByFilterCriterion.get(criterion));
                }
            }

        } else if (affectedFilterTableEntryKeys != null && tableEntryByFilterCriterion.keySet().contains(
                /*
                 * Perhaps there is no registration for the affected object?
                 */
                affectedFilterTableEntryKeys)) {

            filterTableEntries.add(tableEntryByFilterCriterion.get(affectedFilterTableEntryKeys));

        } else if (negated && !completeNoSet.isEmpty()) {
            /*
             * there is no registration for the affected object, BUT there is a registration for "NOT something else"
             * which implies the a registration for affected object
             */
            filterTableEntries.add(tableEntryByFilterCriterion.get(affectedFilterTableEntryKeys));
        }

        RegistrationIterator<Registration> result = null;
        if (filterTableEntries.size() > 0 || negated){
            result = new RegistrationIterator(this, filterTableEntries, negated);
        }
        return result;
    }

    /*
     * getters for the members completeYesSet and completeNoSet they are needed by the implementation of
     * RegistrationIterator (Docu: RegistrationSet)
     */
    List<Registration> getCompleteYesSet() {
        return completeYesSet;
    }
    // (Docu: NegatedRegistrationSet)
    List<Registration> getCompleteNoSet() {
        return completeNoSet;
    }

    protected boolean isEmpty() {
        return completeNoSet.isEmpty() && completeYesSet.isEmpty();
    }


    boolean isRegistered(Registration reg){
        return filterCriterionsByRegistration.containsKey(reg);
    }

    /**
     * Each type of <code>EventFilterTable</code> is directly associated to a filter type, but some <code>MoinEventFilters</code> support
     * additional modifiers that affect the filtering ( for example the <code>includeCompositions</code> flag on <code>InstanceFilterTable</code>
     * or the <code>includeSubclasses</code> flag on <code>ClassFilter</code>). In those cases, there will be more than one instance of the
     * EventFilterTable and in order to be able to determine the right instance for a given <code>MoinEventFilter</code>, both, the <code>MoinEventFilter</code>
     * and the <code>EventFilterTable</code> must implement a <code>getIdentifier()</code> method. The default implementation simply returns its {@link Class}, but
     * filters and their tables which support modifying flags return a {@link List} containing the {@link Class} and all modifiers.
     *  
     * @return an Identifier that allows associating the instance to a filter type.
     */
    public abstract Object getIdentifier();

}
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.event.ChangeEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.CompositeSet;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;



/**
 * EventFilterTables are used to connect {@link de.hpi.sam.bp2009.solution.eventManager.filters.sap.tc.moin.repository.events.filter.EventFilter EventFilters} and
 * {@link Registration Registrations}. For each filter type exists a special subtype
 * of EventFilterTable which handles exactly all instances of this filter type. It is responsible for computing all
 * possible registration candidates that match an event in the context of the filter type it handles. Additionally it
 * encapsulates the knowledge how to get the necessary information from the passed event (
 * {@link #getAffectedObject(ChangeEvent)}).<br>
 * 
 * @author Daniel Vocke (D044825), Axel Uhl (D043530)
 */
public abstract class TableForEventFilter {

    /**
     * list of all (negated) registration that are stored in this table, keyed by the bit set identifying the
     * tables in which the registrations in the value set are stored. This means in particular that the array only
     * contains values at bit set indexes that have the bit for this table set.
     */
    private final Set<Registration>[] completeNoSet;

    private final int numberOfFilterTables;
    
    private final Set<Registration>[] emptyRegistrationArray;
    
    private enum SetSelection { YES, NO  };

    /**
     * index which is needed for deregistration purposes
     */
    protected final HashMap<Registration, Object> filterCriteriaByRegistration = new HashMap<Registration, Object>();

    /**
     * registrations are contained in a FilterTableEntry. This structure is needed to find the registrations for a
     * filter criterion which is being retrieved by an event.
     */
    protected final Map<Object, FilterTableEntry> tableEntryByFilterCriterion = new HashMap<Object, FilterTableEntry>();

    @SuppressWarnings("unchecked")
    protected TableForEventFilter(int numberOfFilterTables) {
        this.numberOfFilterTables = numberOfFilterTables;
        completeNoSet = (Set<Registration>[]) new Set<?>[1<<numberOfFilterTables];
        emptyRegistrationArray = (Set<Registration>[]) new Set<?>[1<<numberOfFilterTables];
    }

    /**
     * This method encapsulates the knowlegde which information that is contained by the passed event is of interest in
     * the context of the current EventFilterTable.
     */
    public abstract Object getAffectedObject(Notification event);
    
    protected String criterionToString(Object criterion) {
        return criterion.toString();
    }

    /**
     * stores the passed {@link Registration}. The Registration will stored as
     * "interested in events meeting the filterCriterion of the passed event in the context of the appropriate
     * EventFitlerTable subclass"
     */
    @SuppressWarnings("unchecked") 
    void register(EventFilter filter, Registration registration) {
        FilterTableEntry entry = tableEntryByFilterCriterion.get(filter.getFilterCriterion());
        if (entry == null) {
            entry = new FilterTableEntry(numberOfFilterTables);
            tableEntryByFilterCriterion.put(filter.getFilterCriterion(), entry);
        }

        if (filter.isNegated()) {
            entry.addNegatedRegistrations(registration);
            int tableBitSet = registration.getBitSetForTablesRegisteredWith();
            Set<Registration> registrationSetForTableCombination = completeNoSet[tableBitSet];
            if (registrationSetForTableCombination == null) {
                registrationSetForTableCombination = new HashSet<Registration>();
                completeNoSet[tableBitSet] = registrationSetForTableCombination;
            }
            registrationSetForTableCombination.add(registration);
        } else {
            entry.addRegistrations(registration);
        }

        // Maintain inverse Map for better performance when deregistering
        Object criterion = filterCriteriaByRegistration.get(registration);
        if (criterion == null) {
            filterCriteriaByRegistration.put(registration, filter.getFilterCriterion());
        } else {
            // Registration used for other criterion already, store in a list (happens rarely)
            if (criterion instanceof List<?>) {
                ((List<Object>)criterion).add(filter.getFilterCriterion());
            } else {
                List<Object> criterions = new ArrayList<Object>(2);
                criterions.add(criterion);
                criterions.add(filter.getFilterCriterion());
                filterCriteriaByRegistration.put(registration, criterions);
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
        Object criterion = filterCriteriaByRegistration.get(registration);
        if (criterion != null) {
            // registration is stored in this table
            if (criterion instanceof List<?>) {
                for (Object filterCriterion : (List<Object>) criterion) {
                    _deregister(registration, filterCriterion);
                }
            } else {
                _deregister(registration, criterion);
            }
            filterCriteriaByRegistration.remove(registration);
        }
    }

    /**
     * this method does the main work for {@link #deregister(Registration)}
     * @param registration
     * @param criterion
     */
    private void _deregister(Registration registration, Object criterion){
        FilterTableEntry entry = tableEntryByFilterCriterion.get(criterion);
        if (entry != null) {
            entry.remove(registration);
            if (entry.isEmpty()) {
                tableEntryByFilterCriterion.remove(criterion);
            }
        }
        Set<Registration> completeNoSetEntry = completeNoSet[registration.getBitSetForTablesRegisteredWith()];
        if (completeNoSetEntry != null) { // could be that there were no negated registrations in this table combination
            if (completeNoSetEntry.remove(registration)) {
                if (completeNoSetEntry.isEmpty()) {
                    completeNoSet[registration.getBitSetForTablesRegisteredWith()] = null;
                }
            }
        }
    }

    /**
     * Fetches the "Yes" entries for the criterion specific to this table, extracted from <code>event</code>.
     * See also {@link FilterTableEntry#getYesSets()} and {@link #getAffectedObject(Notification)}. The result is
     * an array with <code>1&lt;&lt;numberOfBitSetsWithAtLeastOneRegistration</code> elements where each element
     * represents the bit set corresponding to the element's index in the array. The caller must not modify the
     * array returned.
     */
    Set<Registration>[] getYesSetsFor(Notification event, int numberOfBitSetsWithAtLeastOneRegistration, int[] bitSetsWithAtLeastOneRegistration) {
        return getSetsFor(event, SetSelection.YES, numberOfBitSetsWithAtLeastOneRegistration, bitSetsWithAtLeastOneRegistration);
    }
    
    /**
     * Fetches the "No" entries for the criterion specific to this table, extracted from <code>event</code>.
     * See also {@link FilterTableEntry#getNoSets()} and {@link #getAffectedObject(Notification)}. The result is
     * an array with <code>1&lt;&lt;numberOfBitSetsWithAtLeastOneRegistration</code> elements where each element
     * represents the bit set corresponding to the element's index in the array. The caller must not modify the
     * array returned.
     */
    Set<Registration>[] getNoSetsFor(Notification event, int numberOfBitSetsWithAtLeastOneRegistration, int[] bitSetsWithAtLeastOneRegistration) {
        return getSetsFor(event, SetSelection.NO, numberOfBitSetsWithAtLeastOneRegistration, bitSetsWithAtLeastOneRegistration);
    }
    
    @SuppressWarnings("unchecked")
    private Set<Registration>[] getSetsFor(Notification event, SetSelection yesNoSelection, int numberOfBitSetsWithAtLeastOneRegistration, int[] bitSetsWithAtLeastOneRegistration) {
        // returns the filter criterion which is of interest in context of the current EventFilterTable
        Object affectedFilterTableEntryKeys = getAffectedObject(event);
        Set<Registration>[] resultSetArray;
        // will contain all affected FilterTableEntries that have a registration
        List<FilterTableEntry> filterTableEntries = getFilterTableEntries(affectedFilterTableEntryKeys);
        switch (filterTableEntries.size()) {
        case 0:
            resultSetArray = emptyRegistrationArray;
            break;
        case 1:
            if (yesNoSelection == SetSelection.YES) {
                resultSetArray = filterTableEntries.get(0).getYesSets();
            } else {
                resultSetArray = filterTableEntries.get(0).getNoSets();
            }
            break;
        default:
            resultSetArray = (Set<Registration>[]) new Set<?>[1<<numberOfFilterTables];
            for (int i = 0; i < numberOfBitSetsWithAtLeastOneRegistration; i++) {
                List<Set<Registration>> setList = new ArrayList<Set<Registration>>();
                for (FilterTableEntry filterTableEntry : filterTableEntries) {
                    Set<Registration> yesSetForTableEntryAtBitSet;
                    if (yesNoSelection == SetSelection.YES) {
                        yesSetForTableEntryAtBitSet = filterTableEntry.getYesSet(bitSetsWithAtLeastOneRegistration[i]);
                    } else {
                        yesSetForTableEntryAtBitSet = filterTableEntry.getNoSet(bitSetsWithAtLeastOneRegistration[i]);
                    }
                    if (yesSetForTableEntryAtBitSet != null) {
                        setList.add(yesSetForTableEntryAtBitSet);
                    }
                }
                CompositeSet<Registration> compositeSetAtBitSet = null;
                if (!setList.isEmpty()) {
                    compositeSetAtBitSet = new CompositeSet<Registration>(
                        (Set<Registration>[]) setList.toArray(new Set<?>[0]));
                }
                resultSetArray[bitSetsWithAtLeastOneRegistration[i]] = compositeSetAtBitSet;
            }
        }
        return resultSetArray;
    }

    private List<FilterTableEntry> getFilterTableEntries(Object affectedFilterTableEntryKeys) {
        List<FilterTableEntry> filterTableEntries = Collections.emptyList();
        if (affectedFilterTableEntryKeys instanceof Collection<?>) {
            // Some EventFilterTables return multiple matching criteria. For example the ClassFilterTable (including
            // Subclasses) returns more than one matching row if there were registrations for a class and its superclass
            // when the subclass was changed.
            if (!tableEntryByFilterCriterion.isEmpty()) {
                filterTableEntries = new ArrayList<FilterTableEntry>();
                for (Object criterion : (Collection<?>) affectedFilterTableEntryKeys) {
                    FilterTableEntry fte = tableEntryByFilterCriterion.get(criterion);
                    if (fte != null) {
                        filterTableEntries.add(fte);
                    }
                }
            }
        } else if (affectedFilterTableEntryKeys != null) {
            FilterTableEntry tableEntry = tableEntryByFilterCriterion.get(affectedFilterTableEntryKeys);
            if (tableEntry != null) {     // Perhaps there is no registration for the affected object?
                filterTableEntries = Collections.singletonList(tableEntry);
            }
        }
        return filterTableEntries;
    }

    protected boolean isEmpty() {
        if (!tableEntryByFilterCriterion.isEmpty()) {
            return false;
        }
        for (Set<Registration> completeNoSetEntry : completeNoSet) {
            if (completeNoSetEntry != null) {
                return false;
            }
        }
        return true;
    }


    boolean isRegistered(Registration reg){
        return filterCriteriaByRegistration.containsKey(reg);
    }

    /**
     * Each type of {@link TableForEventFilter} is directly associated to a filter type, but some <code>MoinEventFilters</code> support
     * additional modifiers that affect the filtering ( for example the <code>includeCompositions</code> flag on <code>InstanceFilterTable</code>
     * or the <code>includeSubclasses</code> flag on <code>ClassFilter</code>). In those cases, there will be more than one instance of the
     * EventFilterTable and in order to be able to determine the right instance for a given <code>MoinEventFilter</code>, both, the <code>MoinEventFilter</code>
     * and the <code>EventFilterTable</code> must implement a <code>getIdentifier()</code> method. The default implementation simply returns its {@link Class}, but
     * filters and their tables which support modifying flags return a {@link List} containing the {@link Class} and all modifiers.
     *  
     * @return an Identifier that allows associating the instance to a filter type.
     */
    public abstract Class<? extends EventFilter> getIdentifier();

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getClass().getSimpleName());
        result.append(": ");
        boolean appendedSomeNoSetStuff = false;
        for (int i = 0; i < completeNoSet.length; i++) {
            if (completeNoSet[i] != null) {
                appendedSomeNoSetStuff = true;
                result.append(", completeNoSet[" + i + "].size()=");
                result.append(completeNoSet[i].size());
            }
        }
        if (appendedSomeNoSetStuff) {
            result.append(", ");
        }
        result.append("FilterTableByCriterion=(\n");
        boolean first = true;
        for (Object criterion : tableEntryByFilterCriterion.keySet()) {
            if (!first) {
                result.append(",\n");
            } else {
                first = false;
            }
            result.append(" ");
            result.append(criterionToString(criterion));
            result.append(":\n");
            result.append(tableEntryByFilterCriterion.get(criterion));
        }
        result.append(")");
        return result.toString();
    }

    /**
     * The registrations registered negatedly, grouped by the bit sets representing the set of tables
     * in which the registrations from the set are registered
     */
    public Set<Registration>[] getCompleteNoSet() {
        return completeNoSet;
    }
}

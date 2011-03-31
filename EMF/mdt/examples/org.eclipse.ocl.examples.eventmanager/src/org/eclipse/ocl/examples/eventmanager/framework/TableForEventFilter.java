/*******************************************************************************
 * Copyright (c) 2009-2011 SAP AG and others.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.AndFilter;
import org.eclipse.ocl.examples.eventmanager.util.Bag;
import org.eclipse.ocl.examples.eventmanager.util.BagImpl;
import org.eclipse.ocl.examples.eventmanager.util.CompositeBag;

/**
 * EventFilterTables are used to connect {@link EventFilter event filters} and
 * {@link Registration Registrations}. For each filter type, a special
 * subtype of this class exists which handles exactly all instances of this
 * filter type. It is responsible for computing all possible registration
 * candidates that match an event in the context of the filter type it handles.
 * Additionally it encapsulates the knowledge how to get the necessary
 * information from the passed event (see {@link #getAffectedObject}).
 * 
 * @author Daniel Vocke, Axel Uhl
 */
public abstract class TableForEventFilter {

	/**
	 * list of all (negated) registration that are stored in this table, keyed
	 * by the bit set identifying the tables in which the registrations in the
	 * value set are stored. This means in particular that the array only
	 * contains values at bit set indexes that have the bit for this table set.
	 */
    private final Bag<Registration>[] completeNoBag;

	/**
	 * The total number of filter tables managed by the enclosing
	 * {@link RegistrationManagerTableBased} instance
	 */
    private final int numberOfFilterTables;
    
    private final Bag<Registration>[] emptyRegistrationArray;
    
    private enum SetSelection { YES, NO  };

    /**
     * index which is needed for deregistration purposes
     */
    protected final HashMap<Registration, Object> filterCriteriaByRegistration = new HashMap<Registration, Object>();

	/**
	 * registrations are contained in a FilterTableEntry. This structure is
	 * needed to find the registrations for a filter criterion which is being
	 * retrieved by an event.
	 */
    protected final Map<Object, FilterTableEntry> tableEntryByFilterCriterion = new HashMap<Object, FilterTableEntry>();

    @SuppressWarnings("unchecked")
    protected TableForEventFilter(int numberOfFilterTables) {
        this.numberOfFilterTables = numberOfFilterTables;
        completeNoBag = (Bag<Registration>[]) new Bag<?>[1<<numberOfFilterTables];
        emptyRegistrationArray = (Bag<Registration>[]) new Bag<?>[1<<numberOfFilterTables];
    }

	/**
	 * This method encapsulates the knowledge which information that is
	 * contained by the passed event is of interest in the context of the
	 * current EventFilterTable.
	 */
    public abstract Object getAffectedObject(Notification event);
    
    protected String criterionToString(Object criterion) {
        return criterion.toString();
    }

	/**
	 * stores the passed {@link Registration}. The Registration will be stored
	 * as "interested in events meeting the filterCriterion of the passed event
	 * in the context of the appropriate EventFilterTable subclass"
	 * 
	 * @param filter
	 *            expected to be an elementary leaf predicate in an {@link AndFilter}
	 *            in a filter tree in DNF
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
            Bag<Registration> completeNoBagForTableCombination = completeNoBag[tableBitSet];
            if (completeNoBagForTableCombination == null) {
                completeNoBagForTableCombination = new BagImpl<Registration>();
                completeNoBag[tableBitSet] = completeNoBagForTableCombination;
            }
            completeNoBagForTableCombination.add(registration);
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
                List<Object> criteria = new ArrayList<Object>(2);
                criteria.add(criterion);
                criteria.add(filter.getFilterCriterion());
                filterCriteriaByRegistration.put(registration, criteria);
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
        Bag<Registration> completeNoBagEntry = completeNoBag[registration.getBitSetForTablesRegisteredWith()];
        if (completeNoBagEntry != null) { // could be that there were no negated registrations in this table combination
            if (completeNoBagEntry.remove(registration)) {
                if (completeNoBagEntry.isEmpty()) {
                    completeNoBag[registration.getBitSetForTablesRegisteredWith()] = null;
                }
            }
        }
    }

	/**
	 * Fetches the "Yes" entries for the criterion specific to this table,
	 * extracted from <code>event</code>. See also
	 * {@link FilterTableEntry#getYesSets()} and
	 * {@link #getAffectedObject(Notification)}. The result is an array with
	 * <code>1&lt;&lt;numberOfBitSetsWithAtLeastOneRegistration</code> elements
	 * where each element represents the bit set corresponding to the element's
	 * index in the array. The caller must not modify the array returned.
	 */
	Bag<Registration>[] getYesSetsFor(Notification event,
			int numberOfBitSetsWithAtLeastOneRegistration,
			int[] bitSetsWithAtLeastOneRegistration) {
		return getSetsFor(event, SetSelection.YES,
				numberOfBitSetsWithAtLeastOneRegistration,
				bitSetsWithAtLeastOneRegistration);
	}

	/**
	 * Fetches the "No" entries for the criterion specific to this table,
	 * extracted from <code>event</code>. See also
	 * {@link FilterTableEntry#getNoSets()} and
	 * {@link #getAffectedObject(Notification)}. The result is an array with
	 * <code>1&lt;&lt;numberOfBitSetsWithAtLeastOneRegistration</code> elements
	 * where each element represents the bit set corresponding to the element's
	 * index in the array. The caller must not modify the array returned.
	 */
	Bag<Registration>[] getNoSetsFor(Notification event,
			int numberOfBitSetsWithAtLeastOneRegistration,
			int[] bitSetsWithAtLeastOneRegistration) {
		return getSetsFor(event, SetSelection.NO,
				numberOfBitSetsWithAtLeastOneRegistration,
				bitSetsWithAtLeastOneRegistration);
	}
    
    @SuppressWarnings("unchecked")
	private Bag<Registration>[] getSetsFor(Notification event,
			SetSelection yesNoSelection,
			int numberOfBitSetsWithAtLeastOneRegistration,
			int[] bitSetsWithAtLeastOneRegistration) {
		// returns the filter criterion which is of interest in context of the current EventFilterTable
        Object affectedFilterTableEntryKeys = getAffectedObject(event);
        Bag<Registration>[] resultBagArray;
        // will contain all affected FilterTableEntries that have a registration
        Set<FilterTableEntry> filterTableEntries = getFilterTableEntries(affectedFilterTableEntryKeys);
        switch (filterTableEntries.size()) {
        case 0:
            resultBagArray = emptyRegistrationArray;
            break;
        case 1:
            if (yesNoSelection == SetSelection.YES) {
                resultBagArray = filterTableEntries.iterator().next().getYesSets();
            } else {
                resultBagArray = filterTableEntries.iterator().next().getNoSets();
            }
            break;
        default:
            resultBagArray = (Bag<Registration>[]) new Bag<?>[1<<numberOfFilterTables];
            for (int i = 0; i < numberOfBitSetsWithAtLeastOneRegistration; i++) {
                List<Bag<Registration>> bagList = new ArrayList<Bag<Registration>>();
                for (FilterTableEntry filterTableEntry : filterTableEntries) {
                    Bag<Registration> yesSetForTableEntryAtBitSet;
                    if (yesNoSelection == SetSelection.YES) {
                        yesSetForTableEntryAtBitSet = filterTableEntry.getYesSet(bitSetsWithAtLeastOneRegistration[i]);
                    } else {
                        yesSetForTableEntryAtBitSet = filterTableEntry.getNoSet(bitSetsWithAtLeastOneRegistration[i]);
                    }
                    if (yesSetForTableEntryAtBitSet != null) {
                        bagList.add(yesSetForTableEntryAtBitSet);
                    }
                }
                CompositeBag<Registration> compositeBagAtBitSet = null;
                if (!bagList.isEmpty()) {
                    compositeBagAtBitSet = new CompositeBag<Registration>(
                        (Bag<Registration>[]) bagList.toArray(new Bag<?>[0]));
                }
                resultBagArray[bitSetsWithAtLeastOneRegistration[i]] = compositeBagAtBitSet;
            }
        }
        return resultBagArray;
    }

	/**
	 * @return a list with unique entries; this is guaranteed even in case
	 *         <code>affectedFilterTableEntryKeys</code> is a non-{@link Set}
	 *         collection by projecting it into a {@link Set} in this case.
	 */
    private Set<FilterTableEntry> getFilterTableEntries(Object affectedFilterTableEntryKeys) {
        Set<FilterTableEntry> filterTableEntries = Collections.emptySet();
        if (affectedFilterTableEntryKeys instanceof Collection<?>) {
        	if (!(affectedFilterTableEntryKeys instanceof Set<?>)) {
        		// only consider distinct elements, therefore project into a set
        		affectedFilterTableEntryKeys = new HashSet<Object>((Collection<?>) affectedFilterTableEntryKeys);
        	}
            // Some EventFilterTables return multiple matching criteria. For example the ClassFilterTable (including
            // Subclasses) returns more than one matching row if there were registrations for a class and its superclass
            // when the subclass was changed.
            if (!tableEntryByFilterCriterion.isEmpty()) {
                filterTableEntries = new HashSet<FilterTableEntry>();
                for (Object criterion : (Set<?>) affectedFilterTableEntryKeys) {
                    FilterTableEntry fte = tableEntryByFilterCriterion.get(criterion);
                    if (fte != null) {
                        filterTableEntries.add(fte);
                    }
                }
            }
        } else if (affectedFilterTableEntryKeys != null) {
            FilterTableEntry tableEntry = tableEntryByFilterCriterion.get(affectedFilterTableEntryKeys);
            if (tableEntry != null) {     // Perhaps there is no registration for the affected object?
                filterTableEntries = Collections.singleton(tableEntry);
            }
        }
        return filterTableEntries;
    }

    protected boolean isEmpty() {
        if (!tableEntryByFilterCriterion.isEmpty()) {
            return false;
        }
        for (Bag<Registration> completeNoBagEntry : completeNoBag) {
            if (completeNoBagEntry != null) {
                return false;
            }
        }
        return true;
    }


    boolean isRegistered(Registration reg){
        return filterCriteriaByRegistration.containsKey(reg);
    }

	/**
	 * Each type of {@link TableForEventFilter} is directly associated to a
	 * filter type, but some <code>MoinEventFilters</code> support additional
	 * modifiers that affect the filtering ( for example the
	 * <code>includeCompositions</code> flag on <code>InstanceFilterTable</code>
	 * or the <code>includeSubclasses</code> flag on <code>ClassFilter</code>).
	 * In those cases, there will be more than one instance of the
	 * EventFilterTable and in order to be able to determine the right instance
	 * for a given <code>MoinEventFilter</code>, both, the
	 * <code>MoinEventFilter</code> and the <code>EventFilterTable</code> must
	 * implement a <code>getIdentifier()</code> method. The default
	 * implementation simply returns its {@link Class}, but filters and their
	 * tables which support modifying flags return a {@link List} containing the
	 * {@link Class} and all modifiers.
	 * 
	 * @return an Identifier that allows associating the instance to a filter
	 *         type.
	 */
    public abstract Class<? extends EventFilter> getIdentifier();

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getClass().getSimpleName());
        result.append(": ");
        boolean appendedSomeNoSetStuff = false;
        for (int i = 0; i < completeNoBag.length; i++) {
            if (completeNoBag[i] != null) {
                appendedSomeNoSetStuff = true;
                result.append(", completeNoSet[" + i + "].size()=");
                result.append(completeNoBag[i].size());
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
	 * The registrations registered negatedly, grouped by the bit sets
	 * representing the set of tables in which the registrations from the set
	 * are registered
	 */
    public Bag<Registration>[] getCompleteNoBag() {
        return completeNoBag;
    }
}

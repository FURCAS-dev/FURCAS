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

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.AbstractEventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.AndFilter;
import org.eclipse.ocl.examples.eventmanager.filters.LogicalOperationFilter;
import org.eclipse.ocl.examples.eventmanager.filters.NotFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OrFilter;
import org.eclipse.ocl.examples.eventmanager.util.Bag;
import org.eclipse.ocl.examples.eventmanager.util.Statistics;


/**
 * The <code>RegistrationManager</code> is responsible for storing the listeners and their registrations and for computing the set
 * of affected listeners for a certain event. <br>
 * The <code>RegistrationManager</code> has knowledge about several things: <br>
 * <ul>
 * <li>it knows the event types that have to be forwarded to certain <code>EventFilterTables</code></li>
 * <li>It knows the filter type that belongs to a table.</li>
 * <li>It knows the registrations that belong to a listener.</li>
 * </ul>
 * <br>
 * The first two points are defined in the {@link #init()} method which is implemented in the subclass
 * {@link com.RegistrationManagerTableBased.tc.moin.repository.events.framework.SessionRegistrationManager} because originally there also were other
 * subtypes of <code>RegistrationManager</code> (e.g. the GlobalRegistrationManager). <br>
 * This knowledge enables the <code>RegistrationManager</code> to fill the <code>EventFilterTables</code> with new registrations
 * and to compute all listeners that are registered to a certain event. The knowledge of the registrations that belong to a
 * listener is primary for performance improvement at deregistration time. The
 * {@link org.eclipse.ocl.examples.eventmanager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable EventFilterTables} provide registrations for an event in
 * one context. When an event is being fired, the <code>RegistrationManager</code> will know which <code>EventFilterTables</code>
 * to ask and can collect all registrations from all affected <code>EventFilterTables</code>. The <code>RegistrationManager</code>
 * has the overview and can merge these candidates into a consolidated set of registrations. Afterwards these Registrations are
 * converted into listeners that will have to be notified.
 * 
 * @author Daniel Vocke (D044825), Axel Uhl (D043530)
 */
public class RegistrationManagerTableBased {
    private Logger logger = Logger.getLogger(RegistrationManagerTableBased.class.getName());
    
    // uncomment the following lines in case you want to record statistics about the minimum table size;
    // but pay attention: this method runs in the innermost loop of the event manager, and even a method
    // call to an empty method may consume some time
    // /**
    //  * group ID for {@link Statistics} capturing the minimum table sizes during event handling
    //  */
    // public static final String GROUP_ID_MINIMUM_TABLE_SIZE = "minimumTableSize*1000000";

    // needed to compute the affected registrations for an event
    private final HashMap<Integer, Set<TableForEventFilter>> tablesByEventType = new HashMap<Integer, Set<TableForEventFilter>>();

    /*
     * needed for registering purposes. The key may consist of either java.lang.Class or a list containing the class and
     * additional identifying information
     */
    private final HashMap<Object, TableForEventFilter> tableByFilterType = new HashMap<Object, TableForEventFilter>();

    /**
     * During {@link #register(AbstractEventFilter, WeakReference, ListenerTypeEnum) registration}, weak references
     * to adapters are passed in. To enable {@link #deregister(Adapter) deregistration} by direct references
     * to the adapter, this field keeps the mapping between the adapters and their weak references. It does
     * so in a {@link WeakHashMap} such that again no strong references to the adapter are introduced by
     * the event manager framework.
     */
	private final WeakHashMap<Adapter, Set<Reference<? extends Adapter>>> adaptersToWeakRefs = new WeakHashMap<Adapter, Set<Reference<? extends Adapter>>>();

	/**
	 * maps the weak references to the adapters passed to
	 * {@link #register(AbstractEventFilter, WeakReference, ListenerTypeEnum)} to the
	 * registration sets constructed for their event filter; when implicit
	 * de-registration occurs due to the adapter getting garbage collected, this
	 * structure is used to clean up the registrations.
	 */
	private final Map<Reference<? extends Adapter>, List<RegistrationSet>> registrationSetByListenerReference = new HashMap<Reference<? extends Adapter>, List<RegistrationSet>>();

    /**
     * Maintains the registrations keyed by their {@link AndFilter}. It is used to find existing registrations
     * matching an {@link AndFilter} occurring in a filter tree for which a new {@link RegistrationSet} is to
     * be assembled and added to the event manager's tables. This enables efficient re-use of registrations.
     */
    private Map<AndFilter, Registration> allRegistrations = new HashMap<AndFilter, Registration>();

    /**
     * The elements 0..{@link #numberOfBitSetsWithAtLeastOneRegistration-1} store those bit set values for which
     * {@link #allRegistrations} has at least one registration with that {@link Registration#getBitSetForTablesRegisteredWith()
     * bit set}. The array may need to be reorganized when registrations come and go. Registrations for so far unused
     * bit sets are added at index {@link #numberOfBitSetsWithAtLeastOneRegistration} and the attribute
     * {@link #numberOfBitSetsWithAtLeastOneRegistration} is incremented by one. When deregistering, the array is
     * reconstructed from {@link #allRegistrations}.
     */
    private int[] bitSetsWithAtLeastOneRegistration;
    private int numberOfBitSetsWithAtLeastOneRegistration;
    
    /**
     * Invariants:
     * <p>
     * <code>filterTypeToBitMask.get(allTables[i].getIdentifier()) = 2&lt;&lt;i</code>
     * <p>
     * <code>filterTypeToBitMask.keySet().equals(allTables.getIdentifier())</code>
     * 
     * In other words: the identifying classes of all tables stored in this list occur as keys in {@link #filterTypeToBitMask},
     * and the order in which the tables occur in this list matches with the bit number of the bit mask returned by
     * {@link #filterTypeToBitMask} as value for the key being the respective table's {@link TableForEventFilter#getIdentifier()
     * identifier}
     */
    private TableForEventFilter[] allTables;

    // The EventTypeFilterTable will also be used with custom events
    protected TableForEventFilter eventTypeFilterTable = null;

    // a table with negated registrations always has a contribution to an event
    // (except the negated registration covers exactly the current event)
    protected Set<TableForEventFilter> tablesWithNegatedRegistrations = new HashSet<TableForEventFilter>();

    /**
     * Maps the class of a filter to the bit mask it has in finding the correct array position
     * in an array of registration sets
     */
    private Map<Class<? extends EventFilter>, Integer> filterTypeToBitMask;
    
    /**
     * Maps the filter tables from {@link #allTables} to the integer positions they have in {@link #allTables}
     * for fast look-up.
     */
    private final Map<TableForEventFilter, Integer> tableToIndexInAllTables = new HashMap<TableForEventFilter, Integer>();

    public RegistrationManagerTableBased() {
        init();
    }

    /**
     * The implementation of the <code>init()</code> method initialises the members above.
     * Performs the "configuration" of the RegistrationManager.
     */
    protected void init() {
        filterTypeToBitMask = new HashMap<Class<? extends EventFilter>, Integer>();
        @SuppressWarnings("unchecked")
        Class<? extends TableForEventFilter>[] tableTypes = (Class<? extends TableForEventFilter>[]) new Class<?>[] {
                TableForStructuralFeatureFilter.class, TableForClassFilter.class,
                TableForClassFilterIncludingSubClasses.class,
                TableForEventTypeFilter.class, TableForContainmentFilter.class,
                TableForNewValueClassFilter.class, TableForOldValueClassFilter.class,
                TableForNewValueClassFilterIncludingSubclasses.class, TableForOldValueClassFilterIncludingSubclasses.class};
        createAllTables(tableTypes.length);
        int i=0;
        for (Class<? extends TableForEventFilter> tableType : tableTypes) {
            TableForEventFilter table;
            try {
                Constructor<? extends TableForEventFilter> constructor = tableType.getConstructor(Integer.TYPE);
                table = constructor.newInstance(tableTypes.length);
            } catch (Exception e) {
                throw new RuntimeException("Didn't find constructor(int) on table type "+tableType.getSimpleName(), e);
            }
            setUsualEvents(table);
            registerTable(table, i++);
        }
    }
    
    protected void createAllTables(int size) {
        allTables = new TableForEventFilter[size];
        bitSetsWithAtLeastOneRegistration = new int[1<<size];
        numberOfBitSetsWithAtLeastOneRegistration = 0;
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

    /**
     * registers a listener with the passed filter expression. The returned object of type <code>RegistrationHandle</code> is
     * intended to be used as handle for deregistration puposes.
     * 
     * @param filter
     *            the filter expression (may also be a tree)
     * @param listener
     *            the listener to register
     * @return an object of type RegistrationHandle (needed for deregistering purposes only)
     */
    public synchronized void register(EventFilter filterTree, WeakReference<? extends Adapter> listener,
            ListenerTypeEnum listenerType) {
        // adjustFilter() has to be called before the dnf is formed, but there has to be at least one logicaloperationfilter at
        // the top
        if (!(filterTree instanceof OrFilter || filterTree instanceof AndFilter)) {
            EventFilter topOfTree = EventManagerFactory.eINSTANCE.createAndFilterFor(filterTree);
            filterTree = topOfTree;
        }
        OrFilter filterInNormalForm = getDisjunctiveNormalForm((LogicalOperationFilterImpl) filterTree);
        // visit the whole filter tree and add each atomic filter to its corresponding filterTable.
        List<Registration> registrations = new LinkedList<Registration>();
        for (EventFilter filter : filterInNormalForm.getOperands()) {
            AndFilter andFilter = (AndFilter) filter;
            Registration reg = allRegistrations.get(andFilter);
            if (reg == null) {
                reg = createRegistration(andFilter);
            }
            registrations.add(reg);
        }
        RegistrationSet result = new RegistrationSet(listener, listenerType, registrations);
        addRegistrationForListener(result, listener);
    }

    /**
     * Creates the registration and adds it to {@link #allRegistrations}
     */
    private Registration createRegistration(AndFilter andFilter) {
    	int[] requiredMatchesPerTable = new int[allTables.length];
		Map<EventFilter, TableForEventFilter> filterTablesToRegisterWith = getFilterTablesToRegisterWith(
				andFilter, requiredMatchesPerTable);
		Registration result = new Registration(
				getBitSet(filterTablesToRegisterWith.values()), andFilter,
				requiredMatchesPerTable);
		allRegistrations.put(andFilter, result);
		updateBitSetsWithAtLeastOneRegistration(result);
		for (Entry<EventFilter, TableForEventFilter> filterTableEntry : filterTablesToRegisterWith
				.entrySet()) {
			filterTableEntry.getValue().register(filterTableEntry.getKey(),
					result);
		}
		return result;
	}

    /**
     * Ensures that {@link #bitSetsWithAtLeastOneRegistration} contains <code>registration</code>.
     * {@link Registration#getBitSetForTablesRegisteredWith()} in elements 0..{@link #numberOfBitSetsWithAtLeastOneRegistration}
     * -1. It may have to append the bit set value to the end. In this case, {@link #numberOfBitSetsWithAtLeastOneRegistration}
     * will be incremented by one.
     */
    private void updateBitSetsWithAtLeastOneRegistration(Registration registration) {
        int bitset = registration.getBitSetForTablesRegisteredWith();
        for (int i=0; i<numberOfBitSetsWithAtLeastOneRegistration; i++) {
            if (bitSetsWithAtLeastOneRegistration[i] == bitset) {
                return;
            }
        }
        bitSetsWithAtLeastOneRegistration[numberOfBitSetsWithAtLeastOneRegistration++] = bitset;
    }

	/**
	 * @param requiredMatchesPerTable
	 *            Expected to contain only 0 values upon invocation. Updated by
	 *            this method with the number of matches that the
	 *            {@link Registration} to be created from the results of this
	 *            method expects to find in the respective table. Indices in
	 *            this array correspond to the indices in {@link #allTables}.
	 *            When this method completes normally, this array will contain 0
	 *            for all tables (see also {@link #tableToIndexInAllTables})
	 *            that don't occur in the results {@link Map#values() values}
	 *            and at least 1 for all tables that do occur.
	 */
	private Map<EventFilter, TableForEventFilter> getFilterTablesToRegisterWith(
			AndFilter andFilter, int[] requiredMatchesPerTable) {
		// determine tables to register with; needed already for construction of
		// Registration
		Map<EventFilter, TableForEventFilter> filterTablesToRegisterWith = new HashMap<EventFilter, TableForEventFilter>();
		// The following table is used only for the possibility of error reporting
        LogicalOperationFilterImpl level1OfTree = andFilter;
        for (EventFilter leafOfTree : level1OfTree.getOperands()) {
            TableForEventFilter filterTable = getFilterTable(leafOfTree);
            if (filterTable == null) {
                throw new IllegalArgumentException("no table for type " + leafOfTree.getClass()
                        + " in RegistryManager defined");
            }
            requiredMatchesPerTable[tableToIndexInAllTables.get(filterTable)]++;
            filterTablesToRegisterWith.put(leafOfTree, filterTable);
        }
        return filterTablesToRegisterWith;
    }

    private void addRegistrationForListener(RegistrationSet registrationSet, Reference<? extends Adapter> listenerRef) {
        // registrationsByListener is a WeakHashMap, so direct references to listeners can be stored
        Adapter adapter = listenerRef.get();
        if (adapter == null) {
            logger.warning("Registered adapter got GCed: "+listenerRef);
        } else {
            Set<Reference<? extends Adapter>> listenerSet = adaptersToWeakRefs.get(adapter);
            if (listenerSet == null) {
            	listenerSet = new HashSet<Reference<? extends Adapter>>();
            	adaptersToWeakRefs.put(adapter, listenerSet);
            }
            listenerSet.add(listenerRef);
            List<RegistrationSet> registrationSetList = registrationSetByListenerReference.get(listenerRef);
			if (registrationSetList == null) {
				registrationSetList = new ArrayList<RegistrationSet>();
            	registrationSetByListenerReference.put(listenerRef, registrationSetList);
            }
			registrationSetList.add(registrationSet);
        }
    }

    /**
     * From a collection of filter tables, computes the bit set representing this table combination.
     * 
     * @see RegistrationManagerTableBased#filterTypeToBitMask
     */
    private int getBitSet(Collection<TableForEventFilter> tables) {
        int result = 0;
        for (TableForEventFilter table : tables) {
            result |= filterTypeToBitMask.get(table.getIdentifier());
        }
        return result;
    }

    private void deregister(RegistrationSet rs) {
        for (Registration reg : ((RegistrationSet) rs).getRegistrations()) {
            if (reg.removeRegistrationSet(rs)) {
                // the registration lost its last registration set; remove from all tables
                deregister(reg);
            }
        }
    }

    /**
     * Removes all registrations that belong to the passed listener from all <code>EventFilterTables</code>. The listener will not
     * receive any events any more. This method is synchronized because there must be no changes to the FilterTables while they
     * are working.
     * 
     * @param listener
     *            the listener to deregister
     */

    public synchronized void deregister(Adapter listener) {
    	Set<Reference<? extends Adapter>> set = adaptersToWeakRefs.get(listener);
		if (set != null) {
			for (Reference<? extends Adapter> listenerRef : set) {
				deregister(listenerRef);
			}
		}
    }
    
    public synchronized void deregister(Reference<? extends Adapter> listenerRef) {
    	Adapter adapter = listenerRef.get();
    	if (adapter != null) {
    		// not yet collected
    		adaptersToWeakRefs.remove(adapter);
    	}
        List<RegistrationSet> registrationSets = registrationSetByListenerReference.get(listenerRef);
        if (registrationSets != null) {
            for (RegistrationSet registrationSet : registrationSets) {
                deregister(registrationSet);
            }
            registrationSetByListenerReference.remove(listenerRef);
        }
    }
    
    /**
     * This method returns a {@link java.util.Collection} of {@link Adapter}s that were registered for the passed event.
     * 
     * @param event
     * @return a Collection of listeners that are registered for the passed event
     */
    public Collection<WeakReference<? extends Adapter>> getListenersFor(Notification event) {
        // this method does the main work, it computes the registrations from all EventFilterTables
        Collection<Registration> registrations = getRegistrationsFor(event);
        Collection<WeakReference<? extends Adapter>> result = new LinkedList<WeakReference<? extends Adapter>>();
        // this collection is needed in order to remove duplicates. (it is possible, that two OR connected filter criteria matched.
        // In this case, two different registrations will be returned (which both point to the same RegistrationSet), but
        // the listener will expect to get notified only once.
        Set<RegistrationSet> registrationSetsAddedSoFar = new HashSet<RegistrationSet>();
        for (Registration reg : registrations) {
            for (RegistrationSet registrationSet : reg.getRegistrationSets()) {
                if (!registrationSetsAddedSoFar.contains(registrationSet)) {
                    registrationSetsAddedSoFar.add(registrationSet);
                    result.add(registrationSet.getListener());
                }
            }
        }
        return result;
    }

    /**
     * Finds matching {@link Registration}s for <code>event</code>. 
     */
    private Set<Registration> getRegistrationsFor(Notification event) {
        Statistics.getInstance().begin("getRegistrationsFor", event);
        // insert is O(1) for linked list; no cloning / copying required as it grows
        Set<Registration> result = new HashSet<Registration>();
        // for the following two lists, the index corresponds to the table index in allTables
        @SuppressWarnings("unchecked")
        Bag<Registration>[][] yesSetsForTables = (Bag<Registration>[][]) new Bag<?>[allTables.length][];
        @SuppressWarnings("unchecked")
        Bag<Registration>[][] noSetsForTables = (Bag<Registration>[][]) new Bag<?>[allTables.length][];
        int i=0;
        for (TableForEventFilter table : allTables) {
            Bag<Registration>[] yesSetsForTable = table.getYesSetsFor(event, numberOfBitSetsWithAtLeastOneRegistration, bitSetsWithAtLeastOneRegistration);
            yesSetsForTables[i] = yesSetsForTable;
            Bag<Registration>[] noSetsForTable = table.getNoSetsFor(event, numberOfBitSetsWithAtLeastOneRegistration, bitSetsWithAtLeastOneRegistration);
            noSetsForTables[i] = noSetsForTable;
            i++;
        }
        // loop over all table combinations (as bit set counter) for which registrations exist
        HashSet<Registration> startSetToReuseToAvoidHashSetCreation = new HashSet<Registration>();
        for (int bitSetIndex=0; bitSetIndex<numberOfBitSetsWithAtLeastOneRegistration; bitSetIndex++) {
            addIntersectionOverTablesInBitset_Of_YesSetUnitedWithAllNoSetMinusNoSet(bitSetsWithAtLeastOneRegistration[bitSetIndex],
                    yesSetsForTables, noSetsForTables, result, startSetToReuseToAvoidHashSetCreation);
        }
        Statistics.getInstance().end("getRegistrationsFor", event);
        return result;  
    }

	private void addIntersectionOverTablesInBitset_Of_YesSetUnitedWithAllNoSetMinusNoSet(
			int bitSetForTableCombination,
			Bag<Registration>[][] yesSetsForTables,
			Bag<Registration>[][] noSetsForTables, Set<Registration> result,
			HashSet<Registration> startSetToReuseToAvoidHashSetCreation) {
		// first, determine maximum size of (yesSet "union" allNo \ no) for each
		// table in the bit set;
        // if the maximum size of one of them is 0, we're done; otherwise, start with the table promising the
        // smallest size
        int tableWithMinSize = getTableWithMinSizeForIntersection(bitSetForTableCombination, yesSetsForTables);
        // construct the set to start with:
        Collection<Registration> resultForTablesInBitSet = getStartCollectionFromMinSizeTable(bitSetForTableCombination,
                yesSetsForTables, noSetsForTables, tableWithMinSize, startSetToReuseToAvoidHashSetCreation);
        
        if (!resultForTablesInBitSet.isEmpty()) {
            // now retain only those that are also in the (yesSet "union" allNo \ no) for all other tables in the bit set
            for (int i = allTables.length - 1; i >= 0; i--) {
                if (i != tableWithMinSize // don't intersect with start set again; wouldn't hurt except for performance
                        && (bitSetForTableCombination & (1 << i)) != 0) { // loop over tables in bit set only
                    Iterator<Registration> resultIter = resultForTablesInBitSet.iterator();
                    while (resultIter.hasNext()) {
                        Registration next = resultIter.next();
                        if (!is_InYesOrCompleteNo_And_NotInNo_OfTable(next, i, bitSetForTableCombination, yesSetsForTables,
                                noSetsForTables)) {
                            resultIter.remove();
                        }
                    }
                }
            }
        }
        result.addAll(resultForTablesInBitSet);
    }

	private Collection<Registration> getStartCollectionFromMinSizeTable(
			int bitSetForTableCombination,
			Bag<Registration>[][] yesSetsForTables,
			Bag<Registration>[][] noSetsForTables, int tableWithMinSize,
			HashSet<Registration> resultForTablesInBitSet) {
		resultForTablesInBitSet.clear();
        Bag<Registration> yesSetForMinSizeTable = yesSetsForTables[tableWithMinSize][bitSetForTableCombination];
        Bag<Registration> allNoForMinSizeTable = allTables[tableWithMinSize].getCompleteNoBag()[bitSetForTableCombination];
        Bag<Registration> noSetForMinSizeTable = noSetsForTables[tableWithMinSize][bitSetForTableCombination];
        // add those registrations that got exactly as many matches in the table as they require
		if (yesSetForMinSizeTable != null) {
			for (Registration r : yesSetForMinSizeTable) {
				if ((noSetForMinSizeTable == null || !noSetForMinSizeTable.contains(r))
						&& r.getMatchesRequiredForTable(tableWithMinSize) ==
							yesSetForMinSizeTable.count(r) + (allNoForMinSizeTable == null ? 0 : allNoForMinSizeTable.count(r))) {
					resultForTablesInBitSet.add(r);
				}
			}
		}
        if (allNoForMinSizeTable != null) {
			for (Registration r : allNoForMinSizeTable) {
				if ((noSetForMinSizeTable == null || !noSetForMinSizeTable.contains(r))
						&& r.getMatchesRequiredForTable(tableWithMinSize) == (yesSetForMinSizeTable == null ? 0
								: yesSetForMinSizeTable.count(r))
								+ allNoForMinSizeTable.count(r)) {
					resultForTablesInBitSet.add(r);
				}
			}
        }
        return resultForTablesInBitSet;
    }

    private int getTableWithMinSizeForIntersection(int bitSetForTableCombination, Bag<Registration>[][] yesSetsForTables) {
        int[] maxSizes = new int[allTables.length]; // only those elements from the bit set will be populated
        int minSize = Integer.MAX_VALUE; // minimum value that got explicitly set in sizes[]
        int tableWithMinSize = -1;       // position of minimum value in sizes[]; that's the table to start with for intersection
        int tableBit = 1<<(allTables.length-1);
        for (int i=allTables.length-1; i>=0; i--) {
            if ((bitSetForTableCombination & tableBit) != 0) {
                // table identified by tableBit occurs in the combination represented by bitSetForTableCombination
            	Bag<Registration> yesSet = yesSetsForTables[i][bitSetForTableCombination];
            	Bag<Registration> allNo = allTables[i].getCompleteNoBag()[bitSetForTableCombination];
                maxSizes[i] = (yesSet == null ? 0 : yesSet.size()) + (allNo == null ? 0 : allNo.size());
                if (maxSizes[i] < minSize) {
                    // will be executed at least once because we start with minSize=Integer.MAX_VALUE and
                    // there has to be at least one non-zero bit in the bit set
                    minSize = maxSizes[i];
                    tableWithMinSize = i;
                }
            }
            tableBit >>= 1;
        }
        // uncomment the following line in case you want to record statistics about the minimum table size;
        // but pay attention: this method runs in the innermost loop of the event manager, and even a method
        // call to an empty method may consume some time
        // Statistics.getInstance().record(GROUP_ID_MINIMUM_TABLE_SIZE, bitSetForTableCombination, 1000000*minSize);
        return tableWithMinSize;
    }

	private boolean is_InYesOrCompleteNo_And_NotInNo_OfTable(
			Registration registration, int table,
			int bitSetForTableCombination,
			Bag<Registration>[][] yesSetsForTable,
			Bag<Registration>[][] noSetsForTables) {
		Bag<Registration> yesSet = yesSetsForTable[table][bitSetForTableCombination];
    	Bag<Registration> allNo = allTables[table].getCompleteNoBag()[bitSetForTableCombination];
        Bag<Registration> noSet = noSetsForTables[table][bitSetForTableCombination];

        // add those registrations that got exactly as many matches in the table as they require
        return 
			((yesSet != null) &&
			((noSet == null || !noSet.contains(registration)) &&
			 registration.getMatchesRequiredForTable(table) ==
				yesSet.count(registration) + (allNo == null ? 0 : allNo.count(registration))))
			||
	        ((allNo != null) &&
			((noSet == null || !noSet.contains(registration)) &&
			 registration.getMatchesRequiredForTable(table) ==
				(yesSet == null ? 0 : yesSet.count(registration)) + allNo.count(registration)));
    }

    /**
     * @param listener
     * @return whether the listener is registered
     */
    public boolean isListenerRegistered(Adapter listener) {
        return adaptersToWeakRefs.containsKey(listener);
    }

    /**
     * Removes the passed registration from all affected FilterTables.
     * 
     * @param registration
     *            the registration to remove
     */
    private void deregister(Registration registration) {
        for (TableForEventFilter table : allTables) {
            table.deregister(registration);
            if (table.isEmpty()) {
                tablesWithNegatedRegistrations.remove(table);
            }
        }
        allRegistrations.remove(registration.getAndFilter());
        rebuildBitSetsWithAtLeastOneRegistration();
    }

    private void rebuildBitSetsWithAtLeastOneRegistration() {
        Set<Integer> bitSetsInUse = new HashSet<Integer>();
        for (Registration r : allRegistrations.values()) {
            bitSetsInUse.add(r.getBitSetForTablesRegisteredWith());
        }
        numberOfBitSetsWithAtLeastOneRegistration = bitSetsInUse.size();
        int i=0;
        for (int bitSetInUse : bitSetsInUse) {
            bitSetsWithAtLeastOneRegistration[i++] = bitSetInUse;
        }
    }

    /**
     * this is a private helper method. unfortunately there is no 1 to 1 mapping of event filter instances and EventFilterTable
     * instances because some of the filters have modifiers like <code>
     * includeSubclasses</code>. In this case, there is a seperate EventFilterTable instance for each value of the modifier. this
     * method encapsulates this knowledge and always returns the right <code>FilterTable</code>
     * 
     * @param filter
     *            the filter instance to find the correnponding FilterTable for
     * @return the FilterTable which is reponsible for the passed filter instance
     */
    private TableForEventFilter getFilterTable(EventFilter filter) {
        return tableByFilterType.get(filter.getClass());
    }

    /**
     * This method fills the <code>tablesByEventType</code> member with the passed parameters. It is only used in the
     * <code>init()</code> method of subclasses.
     * 
     * @param table
     * @param eventType
     */
    protected void addTableForEventType(TableForEventFilter table, Integer eventType) {
        Set<TableForEventFilter> tables = tablesByEventType.get(eventType);
        if (tables == null) {
            tables = new HashSet<TableForEventFilter>();
            tablesByEventType.put(eventType, tables);
        }
        tables.add(table);
    }

    /**
     * Transforms the (sub-)tree into disjunctive normal form. This special form is needed internally for the following
     * processing. The tree is not cloned before processing, so the clients that plan to reuse their FilterTrees will have to
     * clone them using {@link #clone()} before registering to the EventFramework or invoking this method.
     * 
     * @return a filter tree in disjunctive normal form which has exactly the same semantics like the original tree
     */
    public static OrFilter getDisjunctiveNormalForm(LogicalOperationFilterImpl filter) {

        // perhaps the tree is in DNF yet?
        if (isInDisjunctiveNormalForm(filter))
            return (OrFilter) filter;

        LogicalOperationFilterImpl result = filter;

        // eliminate negations and then expand the tree until the disjunctive
        // normalform is reached
        result = (LogicalOperationFilterImpl) eliminateNegations(result);
        result = (LogicalOperationFilterImpl) getExpandedSubTree(null, result);

        // expandSubTree might also produce a conjunctive normal form =>
        // transform again
        if (!isInDisjunctiveNormalForm(result))
            result = (LogicalOperationFilterImpl) getExpandedSubTree(null, result);
        else
            return (OrFilter) result;

        if (getDepth(result) < 2) {

            // bring simple filters to disjunctive normalform
            if (result instanceof OrFilter) {
                /*
                 * This is currently an OrFilter which connects the leaves of the tree => between the OrFilter and each leaf, an
                 * AndFilter is inserted.
                 */
                LogicalOperationFilterImpl orfilter = new OrFilter();
                for (EventFilter operand : result.getOperands()) {
                    LogicalOperationFilterImpl tmp = new AndFilter(operand);
                    orfilter.addOperand(tmp);
                }
                result = orfilter;

            } else if (result instanceof AndFilter) {
                /*
                 * This is an AndFilter which connects the leafs => put an OrFilter on the top of the tree
                 */
                LogicalOperationFilterImpl tmp = new OrFilter(result);
                result = tmp;

            } else if (result instanceof NotFilter) {
               throw new IllegalStateException("Elimination of NotFilters failed");
            }
        }

        if (!isInDisjunctiveNormalForm(result)) {
        	if(result instanceof OrFilter){
        		/*
        		 * there might be primitives left as direct children --> encapsulate them into AndFilters
        		 *  a | b | (c & d) -- > (a &) | (b &) | (c & d)
        		 */
        		Set<EventFilter> oldO = result.getOperands();
                LogicalOperationFilterImpl orfilter = new OrFilter();
        		for(EventFilter f: oldO){
        			if(!(f instanceof LogicalOperationFilter)){
        				orfilter.addOperand(EventManagerFactory.eINSTANCE.createAndFilterFor(f));
        			}else{
        				orfilter.addOperand(f);
        			}
        		}
        		result = orfilter;
            	if (!isInDisjunctiveNormalForm(result)) {
            		throw new IllegalStateException("Could not create disjunctiv normal form");
            	}
        	}else{
        		throw new IllegalStateException("Could not create disjunctiv normal form");
        	}

        }

        return (OrFilter) result;
    }

    /**
     * Tests whether the tree is in disjunctive normal form yet.
     * 
     * @return true if the tree is in disjunctive normal form.
     */
    private static boolean isInDisjunctiveNormalForm(EventFilter filter) {
        /*
         * "this" has to be an OrFilter which connects AndFilters which connect Non-LogicaloperationFilters
         */
        if (!(filter instanceof OrFilter))
            return false;
        for (EventFilter operand : ((LogicalOperationFilterImpl) filter).getOperands()) {
            if (!(operand instanceof AndFilter))
                return false;
            for (EventFilter operandsOperand : ((LogicalOperationFilterImpl) operand).getOperands()) {
                if (operandsOperand instanceof OrFilter || operandsOperand instanceof AndFilter)
                    return false;
            }
        }
        return true;
    }

    /**
     * This method traverses the tree recursively and pushes negation to the leafs of the tree using "De Morgan". When the first
     * <code>NotFilter</code> is reached, the traversing is being continued using {@link #getNegatedSubTree()}.
     * 
     * @return a filter tree without <code>NotFilter</code>s, which has exactly the same semantics as the original tree.
     */
    private static EventFilter eliminateNegations(EventFilter filter) {

        // Check if a NotFilter was shall be negated
        if (filter instanceof NotFilter) {
            // DeMorgan: negate the Terminals (Filter) and replace the connecting OR
            // by AND and vice versa (is done in getNegatedSubTree())
            EventFilter operand = ((LogicalOperationFilterImpl) filter).getOperands().iterator().next();
            // substitue this by the negated subtree
            return getNegatedSubTree(operand);
        }

        // Check if a LogicalOperationFilter shall be negated
        if (filter instanceof LogicalOperationFilterImpl) {
            // clone list
            List<EventFilter> oldOperands = new ArrayList<EventFilter>(((LogicalOperationFilterImpl) filter).getOperands());

            // clear original list
            ((LogicalOperationFilterImpl) filter).clearOperands();

            // refill original list
            for (EventFilter operand : oldOperands)
                addOperand(((LogicalOperationFilterImpl) filter), eliminateNegations(operand));

            // no substitution of the filter needed
            return filter;
        }

        // Normal filter are unchanged
        return filter;
    }

    /**
     * this method multiplies the boolean expression which the tree represents out in order to get the expanded version. This
     * processing is needed in order to achieve a disjunctive normal form. This method is responsible for the recursive
     * dispatching an the simplifying of the expanded tree. The real expansion is done in the {@link #multiplyOut(List, int)}
     * method.
     * 
     * @return the expanded subtree which did not change any semantics.
     */
    static EventFilter getExpandedSubTree(LogicalOperationFilterImpl parent, EventFilter filter) {
        if (!(filter instanceof LogicalOperationFilterImpl)) {
            return filter;
        }

        LogicalOperationFilterImpl lof = (LogicalOperationFilterImpl) filter;

        // recursively expand subtree
        // clone operands
        Set<EventFilter> oldOperands = new HashSet<EventFilter>(lof.getOperands().size());
        oldOperands.addAll(lof.getOperands());

        // clear "new" operands
        lof.clearOperands();

        /*
         * shrink degenerated trees, e.g. an AndFilter that contains only one OrFilter which contains filters is shrinked to the
         * AndFilter which then contains the OrFilter's operands
         */
        if (oldOperands.size() == 1 && oldOperands.iterator().next() instanceof LogicalOperationFilterImpl) {
            if(oldOperands.iterator().next() instanceof AndFilter){
                lof = new AndFilter();
            }else{
                lof = new OrFilter();
            }
            oldOperands = ((LogicalOperationFilterImpl) oldOperands.iterator().next()).getOperands();
        }

        for (EventFilter operand : oldOperands) {
            EventFilter expandedSubtree = getExpandedSubTree(lof, operand);
            if (lof.getClass().equals(expandedSubtree.getClass())) {
                /*
                 * simplify: due to commutativity of logical ORs and ANDs, the operands of the subtree can be added to this's
                 * operands if the composite LogicalOperationFilter is of the same type
                 */
                lof.addOperands(((LogicalOperationFilterImpl) expandedSubtree).getOperands());
            } else {
                addOperand(lof, expandedSubtree);
            }

        }
        boolean isDNFyet = (parent == null && lof.getClass().equals(OrFilter.class));
        boolean willBeShrinkedIfNotMultipliedOut = (parent != null && parent.getClass().equals(lof.getClass()));
        if (isDNFyet || willBeShrinkedIfNotMultipliedOut)
            return lof;
        else
            return multiplyOut(lof, new LinkedList<LogicalOperationFilterImpl>(), 0);
    }
    static long getLeafCount(EventFilter f){
        if(f instanceof LogicalOperationFilterImpl){
            long count =0l;
            for(EventFilter o: ((LogicalOperationFilterImpl) f).getOperands()){
                count +=getLeafCount(o);
            }
            return count;
        }
        return 1l;
    }
    /**
     * transforms a subtree from e.g. (a | b) & (c | d) to (a & c) | (a & d) | (b & c) | (b & d) where a,b,c,d represent instances
     * of <code>MoinEventFilter</code>s.
     * 
     * @param intermediateResult
     *            an empty list - this param is only needed internally
     * @param index
     *            start with 0, this param is only needed internally
     * @return the expanded tree.
     */
    private static LogicalOperationFilterImpl multiplyOut(LogicalOperationFilterImpl filter,
            List<LogicalOperationFilterImpl> intermediateResult, int index) {
//        System.out.println("Depth: "+ getDepth(filter) + " Leaves: "+getLeafCount(filter));
        List<EventFilter> operands = new ArrayList<EventFilter>(filter.getOperands());
        if (operands.size() < 2)
            return filter;
        /*
         * asuming a simple expression (a | b) & (c | d) & (e | f)
         */
        if (index == 0) {
            // first check, if multiplying out the subtree is possible
            boolean moPossible = false;
            for (EventFilter operand : operands) {
                if (operand instanceof LogicalOperationFilterImpl) {
                    moPossible = true;
                    break; // one contained LogicalOperationFilter is enough
                }
            }
            if (!moPossible)
                return filter;

            Set<EventFilter> tmp1 = null;
            if (operands.get(0) instanceof LogicalOperationFilterImpl)
                tmp1 = ((LogicalOperationFilterImpl) operands.get(0)).getOperands();
            else {
                tmp1 = new HashSet<EventFilter>(1);
                tmp1.add(operands.get(0));
            }

            Set<EventFilter> tmp2 = null;
            if (operands.get(1) instanceof LogicalOperationFilterImpl)
                tmp2 = ((LogicalOperationFilterImpl) operands.get(1)).getOperands();
            else {
                tmp2 = new HashSet<EventFilter>(1);
                tmp2.add(operands.get(1));
            }

            /*
             * take the first 2 expressions ( (a | b) & (c | d) ) and transform them to (a & c) | (a & d) | (b & c) | (b & d)
             */
            LogicalOperationFilterImpl lof = null;
            for (EventFilter filter1 : tmp1) {
                for (EventFilter filter2 : tmp2) {
                    if (filter instanceof AndFilter) {
                        lof = new AndFilter(filter1, filter2);
                    } else {
                        lof = new OrFilter(filter1, filter2);
                    }
                    intermediateResult.add(lof);
                }
            }

            return multiplyOut(filter, intermediateResult, 2);
        }

        // exit condition
        if (index >= operands.size()) {
            /*
             * the intermediate result is just a list of small trees they have to be connected using a LogicalOperationFilter.
             */
            LogicalOperationFilterImpl result;
            try {
                result = (LogicalOperationFilterImpl) getSubstitutionForLogicalOperation(filter);
            } catch (Exception e) {
                result = null;
            }

            for (LogicalOperationFilterImpl lof : intermediateResult)
                addOperand(result, lof);

            return result;
        }

        Set<EventFilter> currentOperands = null;
        if (operands.get(index) instanceof LogicalOperationFilterImpl) {
            currentOperands = ((LogicalOperationFilterImpl) operands.get(index)).getOperands();
        } else {
            currentOperands = new HashSet<EventFilter>(1);
            currentOperands.add(operands.get(index));
        }

        /*
         * for each operand in (e | f) clone the intermediate result ((a & c) | (a & d) | (b & c) | (b & d)) and append e and f
         * respectively to each clone. => (a & c & e) | (a & d & e) | (b & c & e) | (b & d & e) | (a & c & f) | (a & d & f) | (b &
         * c & f) | (b & d & f)
         */
        List<LogicalOperationFilterImpl> irClone = new ArrayList<LogicalOperationFilterImpl>(intermediateResult.size());
        irClone.addAll(intermediateResult);
        intermediateResult.clear();

        for (EventFilter currentOperand : currentOperands) {
            for (LogicalOperationFilterImpl currentIntermediateResult : irClone) {
                LogicalOperationFilterImpl clone = (LogicalOperationFilterImpl) currentIntermediateResult.clone();
                addOperand(clone, currentOperand);
                intermediateResult.add(clone);
            }
        }

        return multiplyOut(filter, intermediateResult, index + 1);
    }

    private static LogicalOperationFilterImpl getSubstitutionForLogicalOperation(LogicalOperationFilterImpl filter) {
        if (filter instanceof AndFilter) {
            return new OrFilter();
        }
        if (filter instanceof OrFilter) {
            return new AndFilter();
        }
        throw new IllegalStateException("Unknown logical substitution for " + filter.getClass());
    }

    /**
     * Computes the depth of the subtree. NotFilters are ignored while computing the depth.
     * 
     * @return the maximal depth of the tree.
     */
    public static int getDepth(LogicalOperationFilterImpl filter) {
        return getDepth(filter, 1);
    }

    private static int getDepth(LogicalOperationFilterImpl filter, int level) {
        int result = 0;
        for (EventFilter currentFilter : filter.getOperands()) {
            if (currentFilter instanceof LogicalOperationFilterImpl) {
                int nextLevel = level + 1;
                // Do not count NotFilter
                if (currentFilter instanceof NotFilter)
                    nextLevel = level;

                result = Math.max(result, getDepth((LogicalOperationFilterImpl) currentFilter, nextLevel));
            }
        }
        return result + level;
    }

    /**
     * This operation applies the rules of De Morgan in order to return a filter tree which represents the negation of the
     * subtree.
     */
    private static EventFilter getNegatedSubTree(EventFilter filter) {
        if (filter instanceof NotFilter) {
            EventFilter result = new ArrayList<EventFilter>(((LogicalOperationFilterImpl) filter).getOperands()).get(0);
            // trick in oder to continue the recursion without negating the operand
            return getNegatedSubTree(getNegatedSubTree(result));
        }

        if (filter instanceof LogicalOperationFilterImpl) {
            // replace the OrFilter(this) by an AndFilter and negate its operands
            LogicalOperationFilterImpl result = getSubstitutionForLogicalOperation((LogicalOperationFilterImpl) filter);

            for (EventFilter operand : ((LogicalOperationFilterImpl) filter).getOperands()) {
                EventFilter negatedOperand = getNegatedSubTree(operand);
                // simplify due to commutativity of AND/OR conjunction
                if (negatedOperand.getClass().equals(result.getClass())) {
                    result.addOperands(((LogicalOperationFilterImpl) negatedOperand).getOperands());
                } else {
                    addOperand(result, negatedOperand);
                }
            }
            return result;
        }

        // By default simply change the "negated" flag if the EventFilter
        ((AbstractEventFilter) filter).setNegated(!filter.isNegated());
        return filter;
    }

    /**
     * adds the operand to the list if it is not contained yet. Equality of operands is computet by the equality of their
     * contained members or operands, not by their reference! This means, that adding two empty AndFilters will result in only one
     * AndFilter added for example. Clients that want to evade that functionality can use <code>getOperands().add(..)</code>
     * instead.
     * 
     * @param operand
     *            the operand to add
     * @return true if the operand was added
     */
    private static boolean addOperand(LogicalOperationFilterImpl filter, EventFilter operand) {
        // prevent doubles
        filter.addOperand(operand);
        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("RegistrationManager: (\n");
        boolean first = true;
        int i=0;
        for (TableForEventFilter table : allTables) {
            if (!first) {
                result.append(",\n");
            } else {
                first = false;
            }
            result.append("(");
            result.append(i++);
            result.append(") ");
            result.append(table);
        }
        result.append(')');
        return result.toString();
    }

    /**
     * Creates an array that has length <code>2^{@link #filterTypeToBitMask}.size()</code> so that any combination of
     * bit mask used as value in {@link #filterTypeToBitMask} can be used as index into such an array.
     */
    @SuppressWarnings("unchecked")
    protected Set<Registration>[] createRegistrationSetArray() {
        return (Set<Registration>[]) new Set<?>[1<<filterTypeToBitMask.size()];
    }

    protected void registerTable(TableForEventFilter table, int posInAllTables) {
        allTables[posInAllTables] = table;
        tableByFilterType.put(table.getIdentifier(), table);
        filterTypeToBitMask.put(table.getIdentifier(), 1<<filterTypeToBitMask.size());
        tableToIndexInAllTables.put(table, posInAllTables);
    }
    
    /**
     * When passing a bit set as returned by {@link #getBitSet(Collection)}, returns the collection
     * of filter tables identified by this bit set.
     */
    protected Collection<TableForEventFilter> getTablesForBitSet(int bitSet) {
        Collection<TableForEventFilter> result = new ArrayList<TableForEventFilter>(allTables.length);
        int i=1;
        for (TableForEventFilter table : allTables) {
            if ((bitSet & i) != 0) {
                result.add(table);
            }
            i <<= 1;
        }
        return result;
    }
    
    /**
     * Mostly for debugging and analysis. Expects the {@link AndFilter}s to be stored in the {@link Registration}s.
     * Scans through all {@link Registration} objects known by this event manager and determines how many overlapping
     * distinct registrations with equal {@link AndFilter} there are. This is a prerequisite to judging how much
     * of a performance improvement we may gain if we try to collate registrations with equal filters.
     */
    public int redundantFilters() {
        Map<AndFilter, Registration> distinctAndFilters = new HashMap<AndFilter, Registration>();
        int result = 0;
        for (Registration ar : allRegistrations.values()) {
            if (checkForRedundantFilterAndUpdateMapCorrespondingly((Registration) ar, distinctAndFilters)) {
                result++;
            }
        }
        return result;
    }

    private boolean checkForRedundantFilterAndUpdateMapCorrespondingly(Registration r,
            Map<AndFilter, Registration> distinctAndFilters) {
        AndFilter andFilter = r.getAndFilter();
        boolean result;
        Registration knownRegistrationWithEqualAndFilter = distinctAndFilters.get(andFilter);
        if (knownRegistrationWithEqualAndFilter == null) {
            distinctAndFilters.put(andFilter, r);
            result = false;
        } else {
            result = knownRegistrationWithEqualAndFilter != r;
            if (result && knownRegistrationWithEqualAndFilter.getBitSetForTablesRegisteredWith() != r.getBitSetForTablesRegisteredWith()) {
                throw new RuntimeException("Error: registrations with equal AndFilter have different bit set, saying they would end up in different tables");
            }
        }
        return result;
    }
}

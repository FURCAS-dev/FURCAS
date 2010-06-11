package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.query2.EcoreHelper;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.PackageFilter;

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
 * {@link de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable EventFilterTables} provide registrations for an event in
 * one context. When an event is being fired, the <code>RegistrationManager</code> will know which <code>EventFilterTables</code>
 * to ask and can collect all registrations from all affected <code>EventFilterTables</code>. The <code>RegistrationManager</code>
 * has the overview and can merge these candidates into a consolidated set of registrations. Afterwards these Registrations are
 * converted into listeners that will have to be notified.
 * 
 * @author Daniel Vocke (D044825)
 */
public abstract class RegistrationManager {

    // needed to compute the affected registrations for an event
    protected HashMap<Integer, Set<TableForEventFilter>> tablesByEventType = new HashMap<Integer, Set<TableForEventFilter>>();

    /*
     * needed for registering purposes. The key may consist of either java.lang.Class or a list containing the class and
     * additional identifying information
     */
    protected HashMap<Object, TableForEventFilter> tableByFilterType = new HashMap<Object, TableForEventFilter>();

    // This hashmap is for deregistration purposes only
    protected WeakHashMap<Adapter, List<AbstractRegistration>> registrationsByListener = new WeakHashMap<Adapter, List<AbstractRegistration>>();

    // TODO are the sets really needed? wouldn't a list be better (better performance)
    // This set is needed to maintain caches
    protected Set<AbstractRegistration> allRegistrations = new HashSet<AbstractRegistration>();

    protected Set<TableForEventFilter> allTables = null;

    // The EventTypeFilterTable will also be used with custom events
    protected TableForEventFilter eventTypeFilterTable = null;

    // a table with negated registrations always has a contribution to an event
    // (except the negated registration covers exactly the current event)
    protected Set<TableForEventFilter> tablesWithNegatedRegistrations = new HashSet<TableForEventFilter>();

    protected RegistrationManager() {
        init();
    }

    /**
     * The implementation of the <code>init()</code> method initialises the members above.
     */
    protected abstract void init();

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
    public synchronized RegistrationHandle register(EventFilter filterTree, WeakReference<? extends Adapter> listener,
            ListenerTypeEnum listenerType) {

        /*
         * adjustFilter() has to be called before the dnf is formed, but there has to be at least one logicaloperationfilter at
         * the top
         */
        if (!(filterTree instanceof OrFilter || filterTree instanceof AndFilter)) {
            AndFilter topOfTree = EventManagerFactory.eINSTANCE.createAndFilter();
            topOfTree.getOperands().add(filterTree);
            filterTree = topOfTree;
        }

        /*
         * the order of the following 2 calls is important! adjustFilter might change the structure of the filter tree
         */
        filterTree = adjustFilter(filterTree);

        LogicalOperationFilter filterInNormalForm = (LogicalOperationFilter) getDisjunctiveNormalForm((LogicalOperationFilter) filterTree);

        /*
         * visit the whole filter tree and add each atomic filter to its corresponding filterTable.
         */
        RegistrationSet result = new RegistrationSet(listener, listenerType);

        for (EventFilter andFilter : filterInNormalForm.getOperands()) {
            // create registration
            Registration reg = new Registration(listener, listenerType);
            reg.setContainer(result);
            result.getRegistrations().add(reg);

            /*
             * registrationsByListener is a WeakHashMap, so direct references to listeners can be stored
             */
            if (registrationsByListener.get(listener.get()) == null)
                registrationsByListener.put(listener.get(), new ArrayList<AbstractRegistration>());

            registrationsByListener.get(listener.get()).add(reg);

            AndFilter level1OfTree = (AndFilter) andFilter;
            for (EventFilter leafOfTree : level1OfTree.getOperands()) {

                TableForEventFilter filterTable = getFilterTable(leafOfTree);
                if(filterTable == null){
                    throw new IllegalArgumentException("no table for type "+ leafOfTree.getClass() +" in RegistryManager defined");
                }
                filterTable.register(leafOfTree, reg);

                if (leafOfTree.isNegated())
                    tablesWithNegatedRegistrations.add(filterTable);
            }
        }
        /*
         * if only 1 registration was needed, the RegistrationSet (=the registration's container) can be removed
         */
        if (result.getRegistrations().size() == 1) {
            Registration reg = (Registration) result.getRegistrations().iterator().next();
            reg.setContainer(null);
            allRegistrations.add(reg);
            return reg;
        } else {
            allRegistrations.addAll(result.getRegistrations());
            return result;
        }

    }

    /**
     * Removes the passed <code>registration</code> from all <code>EventFilterTables</code>. This method is synchronized because
     * there must be no changes to the FilterTables while they are working.
     * 
     * @param the
     *            registration to remove
     */
    public synchronized void deregister(RegistrationHandle registration) {
        if (registration instanceof RegistrationSet) {
            for (Registration reg : ((RegistrationSet) registration).getRegistrations())
                deregister(reg);
        } else
            deregister((Registration) registration);

        // AbstractRegistration is the only implementing class of RegistrationHandle
        // TODO uncomment if the deregister(RegistrationHandle) method is reintroduced on the EventRegistry-interface
        /*
         * MoinChangeListener listener = ((AbstractRegistration) registration).getListener().get(); if
         * ((registrationsByListener.get(listener)).isEmpty()) registrationsByListener.remove(listener);
         */
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

        if (!registrationsByListener.containsKey(listener))
            return; // listener is not registered

        for (RegistrationHandle regHandle : registrationsByListener.get(listener)) {
            deregister(regHandle);
        }

        // should already be done by deregister(RegistrationHandle)
        registrationsByListener.remove(listener);
    }

    /**
     * Removes all registrations that belong to the passed listener from all <code>EventFilterTables</code>. The listener will not
     * receive any events any more. This method is synchronized because there must be no changes to the FilterTables while they
     * are working.
     * 
     * @param listener
     *            the listener to deregister
     */

    public synchronized void deregister(WeakReference<? extends Adapter> listener) {

        if (!registrationsByListener.containsKey(listener))
            return; // listener is not registered

        for (RegistrationHandle regHandle : registrationsByListener.get(listener)) {
            deregister(regHandle);
        }

        // should already be done by deregister(RegistrationHandle)
        registrationsByListener.remove(listener);
    }

    /**
     * This method returns a {@link java.util.Collection} of {@link Adapter}s that were registered for the passed event.
     * 
     * @param event
     * @return a Collection of listeners that are registered for the passed event
     */
    public Collection<WeakReference<? extends Adapter>> getListenersFor(Notification event) {

        /*
         * this method does the main work, it computes the registrations from all EventFilterTables
         */
        Collection<Registration> registrations = getRegistrationsFor(event);

        Collection<WeakReference<? extends Adapter>> result = new LinkedList<WeakReference<? extends Adapter>>();

        /*
         * this collection is needed in order to remove doubles. (it is possible, that 2 OR connected filter criterions matched.
         * In this case, 2 different registrations will be returned (which are both contained in the same RegistrationSet), but
         * the listener will expect to get notified only once.
         */
        Collection<RegistrationSet> registrationSetsAddedSoFar = new LinkedList<RegistrationSet>();

        for (Registration reg : registrations) {
            /*
             * several registrations that are contained in the same registrationSet mean that more than one criterion of
             * OR-connected filters matched. in this case, the client shall be notified only once.
             */
            if (reg.getContainer() != null) {
                RegistrationSet rs = reg.getContainer();
                if (!registrationSetsAddedSoFar.contains(rs)) {
                    // the client(listener) is added the first time
                    registrationSetsAddedSoFar.add(rs);
                    result.add(rs.getListener());
                }
            } else
                result.add(reg.getListener());
        }
        return result;
    }

    // private long time=0;
    @SuppressWarnings("unchecked")
    protected Collection<Registration> getRegistrationsFor(Notification event) {
        // TODO Performance optimizations can probably be done here - VERY CENTRAL METHOD
        // caching is done in the subclass SessionRegistrationManager
   
        // long mtime=System.currentTimeMillis();

        // In Docu: Green cells
        Iterator<Registration>[] yesSetIterators = new Iterator[allTables.size()];
        // In Docu: Red cells
        Iterator<Registration>[] noSetIterators = new Iterator[allTables.size()];
        int ysi_count = 0, nsi_count = 0;

        int estimatedYesSetSize = 0;
        RegistrationIterator<Registration> regIt;

        /*
         * for each type of event, there is a specific set of EventFilterTables which might contribute registrations to the event.
         * These tables are stored in "tablesByEventType".
         */
        Set<TableForEventFilter> tableSet = tablesByEventType.get(event.getEventType());

        if (tableSet != null) {
            for (TableForEventFilter table : tableSet) {
                /*
                 * collect registrations for that event from each EventFilterTable
                 */
                regIt = table.getRegistrationsFor(event, false);
                if (regIt != null) {
                    yesSetIterators[ysi_count++] = regIt;
                    estimatedYesSetSize += regIt.getSize();
                }

                /*
                 * collect registrations that do NOT want to get notified about the current event
                 */
                regIt = table.getRegistrationsFor(event, true);
                if (regIt != null) {
                    noSetIterators[nsi_count++] = regIt;
                    // estimatedNoSetSize += regIt.getSize();
                }
            }
        } else {
            // TODO Log warning! (throw exception?)
        }

        /*
         * tables that normally would not be affected could contribute if they have negated registrations. (a registration to
         * "Not X" implies a registration to "Y")
         */
        for (TableForEventFilter table : tablesWithNegatedRegistrations) {

            regIt = table.getRegistrationsFor(event, false);
            if (regIt != null) {
                yesSetIterators[ysi_count++] = regIt;
                estimatedYesSetSize += regIt.getSize();
            }
        }

        /*
         * collect all registrations for the event. The collected registrations are stored in a set, because a multiple appearance
         * means that someone registered for (X and Y) and both conditions were fulfilled. In this case, a cient would probably
         * expect to be notified only once. ( if Y did not match, it will be contained in the NoSet)
         */

        // First contains positive registrations that are only in one table (no AND used)... at the end, contains ALL positive
        // registrations
        Set<Registration> yesSet = new HashSet<Registration>(estimatedYesSetSize);
        // Contains all positive registrations that were registered in more than one table
        Set<Registration> possibleYesSetEntries = new HashSet<Registration>();

        // Collection<Registration> yesSet = new ArrayList<Registration>(estimatedYesSetSize);
        short tableCountWithCurrentRegistration = 0;
        for (int i = 0; i < ysi_count; i++)
            for (Iterator<Registration> yesSetRegistrationIterator = yesSetIterators[i]; yesSetRegistrationIterator.hasNext();) {
                Registration nextReg = yesSetRegistrationIterator.next();

                tableCountWithCurrentRegistration = 0;
                for (TableForEventFilter table : allTables)
                    if (table.isRegistered(nextReg))
                        tableCountWithCurrentRegistration++;

                if (tableCountWithCurrentRegistration < 2)
                    yesSet.add(nextReg);
                else
                    possibleYesSetEntries.add(nextReg);

            }

        /*
         * remove all registrations from the yesSet that were collected in the so called noSet
         */
        if (!possibleYesSetEntries.isEmpty()) {
            for (int i = 0; i < nsi_count; i++) {
                for (Iterator<Registration> noSetRegistrationIterator = noSetIterators[i]; noSetRegistrationIterator.hasNext();) {
                    possibleYesSetEntries.remove(noSetRegistrationIterator.next());
                }
            }

            // Take also into account registrations that are not in the tableSet, but combined with an AND
            Set<TableForEventFilter> tablesNotAffectedByEvent = new HashSet<TableForEventFilter>(allTables);
            tablesNotAffectedByEvent.removeAll(tableSet);

            // Remove from yesSet registrations in tablesNotAffectedByEvent
            for (TableForEventFilter table : tablesNotAffectedByEvent) {
                possibleYesSetEntries.removeAll(table.completeYesSet);
            }

            if (!possibleYesSetEntries.isEmpty()) {
                yesSet.addAll(possibleYesSetEntries);
            }
        }

        // for (int i = 0; i < nsi_count; i++)
        // for (Iterator noSetRegistrationIterator = noSetIterators[i]; noSetRegistrationIterator.hasNext();) {
        //
        // yesSet.remove((Registration) noSetRegistrationIterator.next());
        // }
        // time+=(System.currentTimeMillis()-mtime);
        return yesSet;
    }

    /**
     * @param listener
     * @return whether the listener is registered
     */
    public boolean isListenerRegistered(Adapter listener) {
        return registrationsByListener.containsKey(listener);
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
            if (table.getCompleteNoSet().isEmpty() && tablesWithNegatedRegistrations.contains(table))
                tablesWithNegatedRegistrations.remove(table);
        }
        allRegistrations.remove(registration);
    }

    /**
     * this method expands filters like "ClassFilter including subclasses" to an equivalent subtree
     * 
     * @param source
     * @param parent
     */
    private static EventFilter adjustFilter(EventFilter source) {

        // traverse tree recursively
        if (source instanceof LogicalOperationFilter) {
            Set<EventFilter> sourceOperands = ((LogicalOperationFilter) source).getOperands();
            EventFilter[] targetOperands = new EventFilter[sourceOperands.size()];
            int index = 0;
            for (EventFilter operand : sourceOperands) {
                targetOperands[index++] = adjustFilter(operand);
            }

            if (source instanceof AndFilter) {
                return new AndFilter(targetOperands);
            }
            if (source instanceof OrFilter) {
                return new OrFilter(targetOperands);
            }
            // if (source instanceof NotFilter) {
            // return new NotFilter(targetOperands[0]);
            // }
        }

        if (source instanceof ClassFilter && ((ClassFilter) source).getIncludeSubClasses()) {
            /**
             * This method replaces ClassFilters that have a true <code>
             * includeSubClasses</code> flag with a collection of OR-Connected ClassFilters that represent all subclasses.
             */
            ClassFilter classFilter = (ClassFilter) source;

            return getSubTypeFilterTree(classFilter);
             }else if (source instanceof PackageFilter) {
             /**
             * This method replaces ExtentFilters that have a filterCriterion of type <code>
             * EPackage</code> with a
             * collection of OR-Connected ExtentFilterFilters that represent all transitively contained
             * <code>RefClasses</code>
             */
             PackageFilter extentFilter = (PackageFilter) source;
            
             return getExpandedExtentFilterTree(extentFilter);
        } else
            return source;
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

    public void registerCustomEventType(List<Integer> eventTypes, TableForEventFilter eventFilterTableInstance) {
        if (eventFilterTableInstance != null) {
            for (Integer eventType : eventTypes) {
                addTableForEventType(eventFilterTableInstance, eventType);
                // EventTypeFilterTable also provides filtering for (unknown) custom events
                addTableForEventType(eventTypeFilterTable, eventType);
            }
            allTables.add(eventFilterTableInstance);
            tableByFilterType.put(eventFilterTableInstance.getIdentifier(), eventFilterTableInstance);
        } else {
            for (Integer eventType : eventTypes)
                addTableForEventType(eventTypeFilterTable, eventType);

        }

    }

    /**
     * creates a filter tree which consists of an OR-Filter that connects several PackageFilters which represent all packages that
     * are composite children of the original package
     * 
     * @see #getExpandedExtentFilterTree()
     * @param extent
     */
    private static EventFilter getExpandedExtentFilterTree(PackageFilter filter) {

        EPackage extent = filter.getEPackage();
        EventFilter extentFilterTree = null;
        Collection<EPackage> containedPackages = getContainedPackageExtents(extent);
        if (containedPackages.size() == 0) {
            return filter;
        }

        EventFilter[] orFilterOperands = new EventFilter[containedPackages.size() + 1];
        int index = 0;
        orFilterOperands[index++] = filter; // ad the top level package filter also
        for (EPackage _package : containedPackages) {
            orFilterOperands[index++] = new PackageFilter(_package);
        }
        LogicalOperationFilter orFilter = new OrFilter(orFilterOperands);

        if (filter.isNegated()) {
            NotFilter notFilter = new NotFilter(orFilter);
            extentFilterTree = notFilter;
        } else
            extentFilterTree = orFilter;

        return extentFilterTree;
    }

    /**
     * @see #computeExpandedExtentFilterTree(RefPackage)
     * @param refPackage
     * @return
     */
    private static Collection<EPackage> getContainedPackageExtents(EPackage refPackage) {

        Collection<EPackage> result = new ArrayList<EPackage>();

        for (Iterator<EPackage> it = refPackage.getESubpackages().iterator(); it.hasNext();) {
            EPackage containedPackage = it.next();
            result.add(containedPackage);
            result.addAll(getContainedPackageExtents(containedPackage));
        }
        return result;
    }

    /**
     * computes an OR-connected filter tree which represents an explicit registration to all subtypes of the parameter
     * 
     * @param filter {@link ClassFilter} which should {@link ClassFilter#getIncludeSubClasses()}
     * @return or filter, which contains the filter itself and new filter for all subtypes
     */
    static EventFilter getSubTypeFilterTree(ClassFilter filter) {
        EventFilter subTypeFilterTree = null;
        EClass clazz = filter.getWantedClass();
        Collection<EClass> subClasses = getSubTypes(clazz);

        if (subClasses.size() == 0) {
            return filter;
        }

        EventFilter[] orFilterOperands = new EventFilter[subClasses.size() + 1];
        int index = 0;
        orFilterOperands[index++] = filter;
        for (EClass subClass : subClasses) {
                ClassFilter copy = filter.clone();
                copy.setWantedClass(subClass);
                copy.setNegated(false);
                copy.setIncludeSubClasses(false);
                orFilterOperands[index++] =copy;
        }
        subTypeFilterTree = new OrFilter(orFilterOperands);

        if (filter.isNegated()) {
            NotFilter notFilter = new NotFilter(subTypeFilterTree);
            subTypeFilterTree = notFilter;
        }

        return subTypeFilterTree;
    }

    /**
     * @param generalizableElement
     * @return a collection which contains all known subtypes of the passed parameter
     */
    static Collection<EClass> getSubTypes(EClass generalizableElement) {
        return EcoreHelper.getInstance().getAllSubclasses(generalizableElement);
    }

    /**
     * Transforms the (sub-)tree into disjunctive normal form. This special form is needed internally for the following
     * processing. The tree is not cloned before processing, so the clients that plan to reuse their FilterTrees will have to
     * clone them using {@link #clone()} before registering to the EventFramework or invoking this method.
     * 
     * @return a filter tree in disjunctive normal form which has exactly the same semantics like the original tree
     */
    public static LogicalOperationFilter getDisjunctiveNormalForm(LogicalOperationFilter filter) {

        // perhaps the tree is in DNF yet?
        if (isInDisjunctiveNormalForm(filter))
            return (LogicalOperationFilter) filter;

        LogicalOperationFilter result = filter;

        // eliminate negations and then expand the tree until the disjunctive
        // normalform is reached
        result = (LogicalOperationFilter) eliminateNegations(result);
        result = (LogicalOperationFilter) getExpandedSubTree(null, result);

        // expandSubTree might also produce a conjunctive normal form =>
        // transform again
        if (!isInDisjunctiveNormalForm(result))
            result = (LogicalOperationFilter) getExpandedSubTree(null, result);
        else
            return (LogicalOperationFilter) result;

        if (getDepth(result) < 2) {

            // bring simple filters to disjunctive normalform
            if (result instanceof OrFilter) {
                /*
                 * This is currently an OrFilter which connects the leafs of the tree => between the OrFilter and each leaf, an
                 * AndFilter is inserted.
                 */
                LogicalOperationFilter orfilter = new OrFilter();
                for (EventFilter operand : result.getOperands()) {
                    AndFilter tmp = new AndFilter(operand);
                    orfilter.getOperands().add(tmp);
                }
                result = orfilter;

            } else if (result instanceof AndFilter) {
                /*
                 * This is an AndFilter which connects the leafs => put an OrFilter on the top of the tree
                 */
                LogicalOperationFilter tmp = new OrFilter(result);
                result = tmp;

            } else if (result instanceof NotFilter) {
                // TODO log an error, this may not happen (or does it? => test it!!)
                AndFilter afilter = new AndFilter(result);
                LogicalOperationFilter tmp = new OrFilter(afilter);
                result = tmp;

            }
        }

        if (!isInDisjunctiveNormalForm(result)) {
            throw new IllegalStateException();
        }

        return (LogicalOperationFilter) result;
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
        for (EventFilter operand : ((LogicalOperationFilter) filter).getOperands()) {
            if (!(operand instanceof AndFilter))
                return false;
            for (EventFilter operandsOperand : ((AndFilter) operand).getOperands()) {
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
     * @return a filter tree without <code>NotFilter</code>s, wich has exactly the same semantic like the original tree.
     */
    private static EventFilter eliminateNegations(EventFilter filter) {

        // Check if a NotFilter was shall be negated
        if (filter instanceof NotFilter) {
            // DeMorgan: negate the Terminals (Filter) and replace the connecting OR
            // by AND and vice versa (is done in getNegatedSubTree())
            EventFilter operand = ((LogicalOperationFilter) filter).getOperands().iterator().next();
            // substitue this by the negated subtree
            return getNegatedSubTree(operand);
        }

        // Check if a LogicalOperationFilter was shall be negated
        if (filter instanceof LogicalOperationFilter) {
            // clone list
            List<EventFilter> oldOperands = new ArrayList<EventFilter>(((LogicalOperationFilter) filter).getOperands().size());
            oldOperands.addAll(((LogicalOperationFilter) filter).getOperands());

            // clear original list
            ((LogicalOperationFilter) filter).getOperands().clear();

            // refill original list
            for (EventFilter operand : oldOperands)
                addOperand(((LogicalOperationFilter) filter), eliminateNegations(operand));

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
    static EventFilter getExpandedSubTree(LogicalOperationFilter parent, EventFilter filter) {
        if (!(filter instanceof LogicalOperationFilter)) {
            return filter;
        }

        LogicalOperationFilter lof = (LogicalOperationFilter) filter;

        // recursively expand subtree
        // clone operands
        Set<EventFilter> oldOperands = new HashSet<EventFilter>(lof.getOperands().size());
        oldOperands.addAll(lof.getOperands());

        // clear "new" operands
        lof.getOperands().clear();

        /*
         * shrink degenerated trees, e.g. an AndFilter that contains only one OrFilter which contains filters is shrinked to the
         * AndFilter which then contains the OrFilter's operands
         */
        if (oldOperands.size() == 1 && oldOperands.iterator().next() instanceof LogicalOperationFilter) {
            if(oldOperands.iterator().next() instanceof AndFilter){
                lof = new AndFilter();
            }else{
                lof = new OrFilter();
            }
            oldOperands = ((LogicalOperationFilter) oldOperands.iterator().next()).getOperands();
            
        }

        for (EventFilter operand : oldOperands) {
            EventFilter expandedSubtree = getExpandedSubTree(lof, operand);
            if (lof.getClass().equals(expandedSubtree.getClass())) {
                /*
                 * simplyfy: due to commutativity of logical ORs and ANDs, the operands of the subtree can be added to this's
                 * operands if the composite LogicalOperationFilter is of the same type
                 */
                lof.getOperands().addAll(((LogicalOperationFilter) expandedSubtree).getOperands());
            } else {
                addOperand(lof, expandedSubtree);
            }

        }
        boolean isDNFyet = (parent == null && lof.getClass().equals(OrFilter.class));
        boolean willBeShrinkedIfNotMultipliedOut = (parent != null && parent.getClass().equals(lof.getClass()));
        if (isDNFyet || willBeShrinkedIfNotMultipliedOut)
            return lof;
        else
            return multiplyOut(lof, new LinkedList<LogicalOperationFilter>(), 0);
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
    private static LogicalOperationFilter multiplyOut(LogicalOperationFilter filter,
            List<LogicalOperationFilter> intermediateResult, int index) {

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
                if (operand instanceof LogicalOperationFilter) {
                    moPossible = true;
                    break; // one contained LogicalOperationFilter is enough
                }
            }
            if (!moPossible)
                return filter;

            Set<EventFilter> tmp1 = null;
            if (operands.get(0) instanceof LogicalOperationFilter)
                tmp1 = ((LogicalOperationFilter) operands.get(0)).getOperands();
            else {
                tmp1 = new HashSet<EventFilter>(1);
                tmp1.add(operands.get(0));
            }

            Set<EventFilter> tmp2 = null;
            if (operands.get(1) instanceof LogicalOperationFilter)
                tmp2 = ((LogicalOperationFilter) operands.get(1)).getOperands();
            else {
                tmp2 = new HashSet<EventFilter>(1);
                tmp2.add(operands.get(1));
            }

            /*
             * take the first 2 expressions ( (a | b) & (c | d) ) and tramsform them to (a & c) | (a & d) | (b & c) | (b & d)
             */
            LogicalOperationFilter lof = null;
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
            LogicalOperationFilter result;
            try {
                result = (LogicalOperationFilter) getSubstitutionForLogicalOperation(filter);
            } catch (Exception e) {
                result = null;
            }

            for (LogicalOperationFilter lof : intermediateResult)
                addOperand(result, lof);

            return result;
        }

        Set<EventFilter> currentOperands = null;
        if (operands.get(index) instanceof LogicalOperationFilter) {
            currentOperands = ((LogicalOperationFilter) operands.get(index)).getOperands();
        } else {
            currentOperands = new HashSet<EventFilter>(1);
            currentOperands.add(operands.get(index));
        }

        /*
         * for each operand in (e | f) clone the intermediate result ((a & c) | (a & d) | (b & c) | (b & d)) and append e and f
         * respectively to each clone. => (a & c & e) | (a & d & e) | (b & c & e) | (b & d & e) | (a & c & f) | (a & d & f) | (b &
         * c & f) | (b & d & f)
         */
        List<LogicalOperationFilter> irClone = new ArrayList<LogicalOperationFilter>(intermediateResult.size());
        irClone.addAll(intermediateResult);
        intermediateResult.clear();

        for (EventFilter currentOperand : currentOperands) {
            for (LogicalOperationFilter currentIntermediateResult : irClone) {
                LogicalOperationFilter clone = (LogicalOperationFilter) currentIntermediateResult.clone();
                addOperand(clone, currentOperand);
                intermediateResult.add(clone);
            }
        }

        return multiplyOut(filter, intermediateResult, index + 1);
    }

    private static LogicalOperationFilter getSubstitutionForLogicalOperation(LogicalOperationFilter filter) {
        if (filter instanceof AndFilter) {
            return new OrFilter();
        }
        if (filter instanceof OrFilter) {
            return new AndFilter();
        }
        throw new IllegalStateException();
    }

    /**
     * Computes the depth of the subtree. NotFilters are ignored while computing the depth.
     * 
     * @return the maximal depth of the tree.
     */
    public static int getDepth(LogicalOperationFilter filter) {
        return getDepth(filter, 1);
    }

    private static int getDepth(LogicalOperationFilter filter, int level) {
        int result = 0;
        for (EventFilter currentFilter : filter.getOperands()) {
            if (currentFilter instanceof LogicalOperationFilter) {
                int nextLevel = level + 1;
                // Do not count NotFilter
                if (currentFilter instanceof NotFilter)
                    nextLevel = level;

                result = Math.max(result, getDepth((LogicalOperationFilter) currentFilter, nextLevel));
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
            EventFilter result = new ArrayList<EventFilter>(((LogicalOperationFilter) filter).getOperands()).get(0);
            // trick in oder to continue the recursion without negating the operand
            return getNegatedSubTree(getNegatedSubTree(result));
        }

        if (filter instanceof LogicalOperationFilter) {
            // replace the OrFilter(this) by an AndFilter and negate its operands
            LogicalOperationFilter result = getSubstitutionForLogicalOperation((LogicalOperationFilter) filter);

            for (EventFilter operand : ((LogicalOperationFilter) filter).getOperands()) {
                EventFilter negatedOperand = getNegatedSubTree(operand);
                // simplify due to commutativity of AND/OR conjunction
                if (operand.getClass().equals(result.getClass())) {
                    result.getOperands().addAll(((LogicalOperationFilter) negatedOperand).getOperands());
                } else {
                    addOperand(result, negatedOperand);
                }
            }
            return result;
        }

        // By defaluts simple change the "negated" flag if the EventFilter
        filter.setNegated(!filter.isNegated());
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
    private static boolean addOperand(LogicalOperationFilter filter, EventFilter operand) {

        // prevent doubles
        if (filter.getOperands().contains(operand))
            return false;
        else
            filter.getOperands().add(operand);
        return true;
    }

}
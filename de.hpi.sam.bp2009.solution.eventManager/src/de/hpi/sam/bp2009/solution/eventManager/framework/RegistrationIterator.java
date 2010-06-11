package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;



/**
 * The RegistrationIterator encapsulates the knowledge how to compute all Registrations that are of interest in the
 * context that the filterTableEntries member defines.<br>
 * Example: In order to make it easier to understand, I'm going to talk about YesSets (= set of Registrations that are
 * registered directly to a certain criterion) and NoSets (=set of Registrations that are registered in a negated way to
 * a certain criterion, meaning "NOT criterion"). The RegistrationIterator has a set of filterTableEntries. A
 * FilterTableEntry encapsulates 2 sets, the registrations and a the negatedRegistrations which both belong to one
 * filter criterion. The set of filterTableEntries represents the matching criterions for an event (there can be
 * multiple of them due to the existence of EventFilters like ClassFilter with its includeCompositions flag).<br>
 * The YesSet consists of all YesSets of the matching criterions. Additionally all NoSets of the EventFilterTable except
 * the NoSets that are associated with the matching criterions are also added to the result. This is due to the fact
 * that an expression <code>NOT Y</code> will probably expect to get notified when <code>X</code> occurs. The NoSet
 * will be computed the same way, just by using NoSets instead of YesSets and vice versa. The RegistrationIterator
 * iterates over all Registrations that match the requirements above.<br>
 * The main reason to introduce this class was to avoid the creation of new {@link java.util.Set}s each time a
 * {@link de.hpi.sam.bp2009.solution.eventManager.framework.TableForEventFilter.tc.moin.repository.events.framework.EventFilterTable} is asked for its registrations for an event. (This happens
 * about 15-20 times for each event). The RegistrationIterator uses the sets of the EventFilterTable and just adds the
 * knowledge which entries to ignore.
 * 
 * @author Daniel Vocke (D044825)
 */

public class RegistrationIterator<Type> implements Iterator<Type> {

    /**
     * Set of the matching rows of the current <code>EventFilterTable</code>
     */
    private Collection<FilterTableEntry<Type>> filterTableEntries = null;

    /**
     * flag whether the Registrations of the negated registrations shall be iterated
     */
    private boolean negated = false;

    /**
     * The current FilterTableEntry of which the matching Registrations have to be iterated.
     */
    private TableForEventFilter _eventFilterTable = null;

    /**
     * The estimated (!!) number of the Registrations that will be iterated.
     */
    private int _size = -1;

    /**
     * The next value that will be returned.
     */
    private Type _next = null;
  
    /**
     * excludeLists is a array of lists. Each list represents registrations that may not be returned by a call to this
     * object's {@link #next()} method.
     */
    private List<List<Type>>[] excludeLists;

    /**
     * needed in order to determine how many lists really are contained in the excludeLists array
     */
    int es_count = 0;
    
    private HashMap<Type,Object> registrationsToExclude = null;
    /**
     * an array of Lists. it consists of lists that will be iterated one by one.
     */
    private List<Type>[] includeLists;

    /**
     * needed in order to determine how many lists really are contained in the includeLists array
     */
    private int is_count = 0;

    /**
     * counter in order to determine the next includeList to be iterated.
     */
    private int nextIncludeListNr = 0;

    /**
     * content of the current "includeList". The content of matchingResults will be returned in the {@link #next()}
     * method if the current object is not contained in any excludeList.
     */
    private List<Type> currentIncludeList = null;

    /**
     * counter in order to iterate over the "matchingRegistrations"-array.
     */
    private int currentRegistration = 0;

    /**
     * Creates a RegistrationIterator which iterates over some Registrations that are stored in the associated
     * EventFilterTable.
     * 
     * @param eventFilterTable the associated EventFilterTable
     */
    public RegistrationIterator(TableForEventFilter eventFilterTable, Collection<FilterTableEntry<Type>> filterTableEntries,
        boolean negated) {
        _eventFilterTable = eventFilterTable;
        this.filterTableEntries = filterTableEntries;
        this.negated = negated;
    }
    
    //needed for subclassing (for testing purposes only)
    protected RegistrationIterator(){}

    /**
     * @return the filterTableEntries.
     */
    public Collection<FilterTableEntry<Type>> getFilterTableEntries() {
        return filterTableEntries;
    }

    /**
     * returns the <b>estimated size</b> of the registrations that will be iterated. Due to performance reasons, an
     * exact computation of the size is not possible.
     * 
     * @return Returns the <b>estimated</b> number of Registrations that will be iterated.
     */
    public int getSize() {
        if (_size == -1)
            init();
        return _size;
    }

    /**
     * @return Returns whether the so called YesSet of NoSet will be iterated
     */
    public boolean isNegated() {
        return negated;
    }

    /* methods from Iterator interface */

    /*
     * see {@link Iterator#remove()} for details
     */

    public void remove() {
        throw new UnsupportedOperationException("RegistrationIterator has only reading access to EventFilterTables");
    }

    /*
     * see {@link Iterator#hasNext()} for details
     */
    public boolean hasNext() {
        if (_size == -1)
            init();
        return _next != null;
    }

    /*
     * see {@link Iterator#next()} for details
     */
    public Type next() {
        if (_size == -1)
            init();
        // TODO request for new wrapped exception type and adapt Exception to localized message
        if (_next == null)
            throw new NoSuchElementException("No more Registrations to iterate over!");
        Type result = _next;
        _next = internalNext();

        return result;
    }

    /**
     * @return the object that will be returned at the next call to the {@link #next()} method.
     */
    private Type internalNext() {
        Type result = null;

        while (result == null) {
            /*
             * There normally are multiple lists to iterate over. the following block changes to the next list if the
             * end of the current list is reached.
             */
            if (currentRegistration >= currentIncludeList.size()) {
                if (nextIncludeListNr >= is_count) {
                    // the last list to iterate over was reached yet.
                    return null;
                }
                currentIncludeList = includeLists[nextIncludeListNr];
                nextIncludeListNr++;
                currentRegistration = 0;
            }

            // Simply take the next entry as result
            result = currentIncludeList.get(currentRegistration);
            currentRegistration++;

            if (registrationsToExclude.containsKey(result))
                result=null;
//            if (es_count > 0) { // There are excludeSets => result might be
//                // invalid
//                /*
//                 * If any of the excludeSets contain the current result => take the next one
//                 */
//                    
//                for (int i = 0; i < es_count; i++) {
//                    if (excludeLists[i].contains(result)) {
//                        result = null;
//                        break;
//                    }
//                }
//            }
//
        }
        return result;
    }

    /**
     * initialises all members.
     */
    @SuppressWarnings("unchecked")
    private void init() {

        _size = 0;
        
        includeLists = new List[filterTableEntries.size() + 1];
        excludeLists = new List[filterTableEntries.size()];
        registrationsToExclude = new HashMap<Type,Object>();
        
        if (negated) {
            /*
             * includeSets consists of: all YesSets of the current EventFilterTable + the NoSets of the matching rows;
             * excludeSets consists of: the YesSets of the matching rows
             */
            is_count = addListToArray(_eventFilterTable.getCompleteYesSet(), includeLists, is_count, true);

            // TODO PERFORMANCE! replace Lists and Iterators with arrays?
            for (FilterTableEntry<Type> filterTableEntry : filterTableEntries) {
                
                is_count = addListToArray(filterTableEntry.getNegatedRegistrations(), includeLists, is_count, true);
                
                es_count = addListToArray(filterTableEntry.getRegistrations(), excludeLists, es_count, false);
                addListToHashTable(filterTableEntry.getRegistrations(),registrationsToExclude);
            }

        } else {
            /*
             * includeSets consists of: all NoSets of the current EventFilterTable + the YesSets of the matching rows;
             * excludeSets consists of: the NoSets of the matching rows
             */
            is_count = addListToArray(_eventFilterTable.getCompleteNoSet(), includeLists, is_count, true);

            for (FilterTableEntry<Type> filterTableEntry : filterTableEntries){
                is_count = addListToArray(filterTableEntry.getRegistrations(), includeLists, is_count, true);
                es_count = addListToArray(filterTableEntry.getNegatedRegistrations(), excludeLists, es_count, false);
                addListToHashTable(filterTableEntry.getNegatedRegistrations(),registrationsToExclude);
            }
        }
        
        if (is_count == 0) {
            // should never happen since the RegistrationManager does not
            // trigger a creation of a RegistrationSet if no registrations are
            // found
            _size = -1;
            _next = null;
            return;
        }

        currentIncludeList = includeLists[0];
        nextIncludeListNr = 1;

        _next = internalNext();
    }

    /**
     * adds the reference of the passed list to the passed array if the list was not empty. Additionally, the _size
     * member is increased or decreased.
     * 
     * @param listToAdd the list which's reference will be added to the array if the listhas not been empty
     * @param arrayToAddTo the array in which the reference will be stored
     * @param position the position on which the reference is added in the array
     * @param increaseSize a flag which indicates whether the _size member is being increased or decreased
     * @return the position of the next free entry in the array.
     */
    private int addListToArray(List<?> listToAdd, List<?>[] arrayToAddTo, int position, boolean increaseSize) {
        if (!listToAdd.isEmpty()) {
            arrayToAddTo[position] = listToAdd;

            if (increaseSize)
                _size += listToAdd.size();
            else
                _size -= listToAdd.size();

            return position + 1;
        }
        return position;
    }
    
    private void addListToHashTable(List<Type> list,HashMap<Type,Object> map){
        if (list.isEmpty())
            return;
        for (Type reg : list){
            map.put(reg,null);
        }
    }

}
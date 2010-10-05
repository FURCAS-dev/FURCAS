package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.ocl.ecore.OperationCallExp;

import de.hpi.sam.bp2009.solution.eventManager.CompositeIterable;

/**
 * Immutable implementation of a data structure keyed by {@link OperationCallExp} expressions where the values
 * are sets of <code>E</code> objects.
 * 
 * @author Axel Uhl (D043530)
 */
public class OperationCallExpKeyedSetImpl implements OperationCallExpKeyedSet {
    private final Map<OperationCallExp, Iterable<AnnotatedEObject>> map;
    private static final OperationCallExpKeyedSetImpl EMPTY_SET = new OperationCallExpKeyedSetImpl();
    
    private OperationCallExpKeyedSetImpl() {
        map = Collections.emptyMap();
    }
    
    public OperationCallExpKeyedSetImpl(OperationCallExp oce, Iterable<AnnotatedEObject> c) {
        if (c == null) {
            throw new IllegalArgumentException("Must pass a valid, non-null iterable");
        }
        Map<OperationCallExp, Iterable<AnnotatedEObject>> myMap = new HashMap<OperationCallExp, Iterable<AnnotatedEObject>>();
        myMap.put(oce, c);
        map = myMap;
    }

    public OperationCallExpKeyedSetImpl(Iterable<AnnotatedEObject> c) {
        if (c == null) {
            throw new IllegalArgumentException("Must pass a valid, non-null iterable");
        }
        Map<OperationCallExp, Iterable<AnnotatedEObject>> myMap = new HashMap<OperationCallExp, Iterable<AnnotatedEObject>>();
        myMap.put(null, c);
        map = myMap;
    }
    
    public OperationCallExpKeyedSetImpl(AnnotatedEObject aeo) {
        Map<OperationCallExp, Iterable<AnnotatedEObject>> myMap = new HashMap<OperationCallExp, Iterable<AnnotatedEObject>>();
        myMap.put(null, Collections.singleton(aeo));
        map = myMap;
    }
    
    public OperationCallExpKeyedSetImpl(Collection<OperationCallExpKeyedSet> sets) {
        Map<OperationCallExp, Iterable<AnnotatedEObject>> myMap = new HashMap<OperationCallExp, Iterable<AnnotatedEObject>>();
        for (OperationCallExpKeyedSet set : sets) {
            for (Entry<OperationCallExp, ? extends Iterable<AnnotatedEObject>> entry : set.entrySet()) {
                Iterable<AnnotatedEObject> entryValue = entry.getValue();
                if (entryValue.iterator().hasNext()) {
                    Set<AnnotatedEObject> mapSet = (Set<AnnotatedEObject>) myMap.get(entry.getKey());
                    if (mapSet == null) {
                        mapSet = new HashSet<AnnotatedEObject>();
                        myMap.put(entry.getKey(), mapSet);
                    }
                    for (AnnotatedEObject e : entryValue) {
                        mapSet.add(e);
                    }
                }
            }
        }
        map = myMap;
    }

    public static OperationCallExpKeyedSetImpl emptySet() {
        return EMPTY_SET;
    }
    
    public boolean isEmpty() {
        return map.isEmpty();
    }

    
    public Iterator<AnnotatedEObject> iterator() {
        Iterator<AnnotatedEObject> result;
        if (map.size() == 0) {
            Set<AnnotatedEObject> emptySet = Collections.emptySet();
            result = emptySet.iterator();
        } else if (map.size() == 1) {
            result = map.values().iterator().next().iterator();
        } else {
            result = new CompositeIterable<AnnotatedEObject>(map.values()).iterator();
        }
        return result;
    }

    private Iterable<AnnotatedEObject> get(Object key) {
        return map.get(key);
    }

    public Iterable<AnnotatedEObject> getCombinedResultsFor(OperationCallExp oce) {
        Iterable<AnnotatedEObject> result;
        Iterable<AnnotatedEObject> resultForOce = get(oce);
        Iterable<AnnotatedEObject> resultForNull = get(null);
        if (resultForOce == null || !resultForOce.iterator().hasNext()) {
            result = resultForNull;
        } else if (resultForNull == null || !resultForNull.iterator().hasNext()) {
            result = resultForOce;
        } else {
            Set<AnnotatedEObject> resultSet = new HashSet<AnnotatedEObject>();
            for (AnnotatedEObject e : resultForOce) {
                resultSet.add(e);
            }
            for (AnnotatedEObject e : resultForNull) {
                resultSet.add(e);
            }
            result = resultSet;
        }
        if (result == null) {
            result = Collections.emptySet();
        }
        return result;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        boolean first = true;
        for (AnnotatedEObject e : this) {
            if (!first) {
                result.append(", ");
            } else {
                first = false;
            }
            result.append(e);
        }
        result.append(']');
        return result.toString();
    }

    public Iterable<Entry<OperationCallExp, Iterable<AnnotatedEObject>>> entrySet() {
        return map.entrySet();
    }

}

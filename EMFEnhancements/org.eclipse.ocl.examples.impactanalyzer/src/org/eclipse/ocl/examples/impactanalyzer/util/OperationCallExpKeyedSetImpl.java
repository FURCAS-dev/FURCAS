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
package org.eclipse.ocl.examples.impactanalyzer.util;

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
 * are sets of <code>E</code> objects.<p>
 * 
 * Implementation invariant: only non-empty iterators are inserted into the map. Therefore, the map contains
 * no entries whose iterators would not produce any results.
 * 
 * @author Axel Uhl (D043530)
 */
public class OperationCallExpKeyedSetImpl implements OperationCallExpKeyedSet {
    private final Map<OperationCallExp, Iterable<AnnotatedEObject>> map;
    private static final OperationCallExpKeyedSetImpl EMPTY_SET = new OperationCallExpKeyedSetImpl();
    
    private OperationCallExpKeyedSetImpl() {
        map = Collections.emptyMap();
    }
    
    OperationCallExpKeyedSetImpl(OperationCallExp oce, Iterable<AnnotatedEObject> c) {
        if (c == null) {
            throw new IllegalArgumentException("Must pass a valid, non-null iterable");
        }
        if (c.iterator().hasNext()) {
            map = Collections.singletonMap(oce, c);
        } else {
            map = Collections.emptyMap();
        }
    }

    OperationCallExpKeyedSetImpl(Iterable<AnnotatedEObject> c) {
        if (c == null) {
            throw new IllegalArgumentException("Must pass a valid, non-null iterable");
        }
        if (!c.iterator().hasNext()) {
            map = Collections.emptyMap();
        } else {
            map = Collections.singletonMap(null, c);
        }
    }
    
    OperationCallExpKeyedSetImpl(AnnotatedEObject aeo) {
        Iterable<AnnotatedEObject> aeoAsIterable = Collections.singleton(aeo);
        map = Collections.singletonMap(null, aeoAsIterable);
    }
    
    OperationCallExpKeyedSetImpl(Collection<OperationCallExpKeyedSet> sets) {
        if (sets.isEmpty()) {
            map = Collections.emptyMap();
        } else {
            Map<OperationCallExp, Iterable<AnnotatedEObject>> myMap = new HashMap<OperationCallExp, Iterable<AnnotatedEObject>>();
            for (OperationCallExpKeyedSet set : sets) {
                for (Entry<OperationCallExp, ? extends Iterable<AnnotatedEObject>> entry : set.entrySet()) {
                    Iterable<AnnotatedEObject> entryValue = entry.getValue();
                    // enter only non-empty result iterators
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
    }

    static OperationCallExpKeyedSetImpl emptySet() {
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

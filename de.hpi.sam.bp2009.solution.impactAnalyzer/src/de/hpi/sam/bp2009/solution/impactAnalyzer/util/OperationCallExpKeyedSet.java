package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * Recursively keys sets of elements by {@link OperationCallExp} elements and implements the {@link Set} interface. The
 * {@link Set} view on this collection is the projection of transitively combining unique elements from the tree of keyed element.
 * The same element which from a "set semantics" perspective is contained in this collection only once may be keyed with several
 * {@link OperationCallExp} objects along different paths. Removal of objects is not supported. The regular {@link #add(Object)}
 * operations are defined such that they key the element(s) added with the <code>null</code> key.
 * <p>
 * 
 * The <code>null</code> key is special and means that a result was computed without tracing back through an operation's
 * <code>self</code> or parameter variable. For example, this is the case for an <code>allInstances()</code> call found inside an
 * operation body. Such results always apply for the immediately-calling {@link OperationCallExp} and need to be added to their
 * results. The special getter {@link #getCombinedResultsFor(OperationCallExp)} adds the values for key <code>null</code> to the
 * values for the key specified.<p>
 * 
 * Keyed access is granted by means of the {@link #get(Object)} operation which again returns an object of this class.
 * 
 * @author Axel Uhl (D043530)
 */
public class OperationCallExpKeyedSet<E> implements Set<E> {
    private final Map<OperationCallExp, OperationCallExpKeyedSet<E>> map;
    
    /**
     * Used to avoid structural endless recursion. The {@link #map} doesn't contain an entry for the <code>null</code>
     * key as that would again have to be an instance of this class. Instead, we keep the values for the <code>null</code>
     * key separate in this regular, non-hierarchical set.
     */
    private final Set<E> nullSet;
    
    private final Set<E> set;
    
    private final boolean keyByOperation;
    
    @SuppressWarnings("rawtypes")
    private final static OperationCallExpKeyedSet<?> EMPTY_SET_KEYED_BY_OPERATION = new OperationCallExpKeyedSet(true, true);
    @SuppressWarnings("rawtypes")
    private final static OperationCallExpKeyedSet<?> EMPTY_SET_NOT_KEYED_BY_OPERATION = new OperationCallExpKeyedSet(true, false);
    
    public OperationCallExpKeyedSet(boolean keyByOperation) {
        this.keyByOperation = keyByOperation;
        if (keyByOperation) {
            map = new HashMap<OperationCallExp, OperationCallExpKeyedSet<E>>();
            nullSet = new HashSet<E>();
        } else {
            map = null;
            nullSet = null;
        }
        set = new HashSet<E>();
    }

    public OperationCallExpKeyedSet(Collection<? extends E> c, boolean keyByOperation) {
        this.keyByOperation = keyByOperation;
        if (keyByOperation) {
            map = new HashMap<OperationCallExp, OperationCallExpKeyedSet<E>>(Math.max((int) (c.size() / .75f) + 1, 16));
            nullSet = new HashSet<E>(c);
        } else {
            map = null;
            nullSet = null;
        }
        set = new HashSet<E>(c);
        addAll(c);
    }

    public OperationCallExpKeyedSet(int initialCapacity, float loadFactor, boolean keyByOperation) {
        this.keyByOperation = keyByOperation;
        if (keyByOperation) {
            map = new HashMap<OperationCallExp, OperationCallExpKeyedSet<E>>(initialCapacity, loadFactor);
            nullSet = new HashSet<E>(initialCapacity, loadFactor);
        } else {
            map = null;
            nullSet = null;
        }
        set = new HashSet<E>(initialCapacity, loadFactor);
    }

    public OperationCallExpKeyedSet(int initialCapacity, boolean keyByOperation) {
        this.keyByOperation = keyByOperation;
        if (keyByOperation) {
            map = new HashMap<OperationCallExp, OperationCallExpKeyedSet<E>>(initialCapacity);
            nullSet = new HashSet<E>(initialCapacity);
        } else {
            map = null;
            nullSet = null;
        }
        set = new HashSet<E>(initialCapacity);
    }
    
    /**
     * Used only for creating the empty set
     */
    private OperationCallExpKeyedSet(boolean b, boolean keyByOperation) {
        this.keyByOperation = keyByOperation;
        if (keyByOperation) {
            map = Collections.emptyMap();
            nullSet = Collections.emptySet();
        } else {
            map = null;
            nullSet = null;
        }
        set = Collections.emptySet();
    }

    public int size() {
        return set.size();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(Object o) {
        return set.contains(o);
    }

    public Iterator<E> iterator() {
        return set.iterator();
    }

    public Object[] toArray() {
        return set.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    /**
     * Adds <code>e</code> with <code>null</code> as key. This is short for {@link #put(OperationCallExp, Object) put(null, e)}.
     */
    public boolean add(E e) {
        return put(null, e);
    }
    
    public boolean put(OperationCallExp oce, E e) {
        if (keyByOperation) {
            Set<E> s;
            if (oce == null) {
                s = nullSet;
            } else {
                s = map.get(oce);
                if (s == null) {
                    OperationCallExpKeyedSet<E> s2 = new OperationCallExpKeyedSet<E>(keyByOperation);
                    map.put(oce, s2);
                    s = s2;
                }
            }
            s.add(e);
        }
        return set.add(e);
    }

    public boolean putAll(OperationCallExp oce, Collection<? extends E> e) {
        if (keyByOperation) {
            Set<E> s;
            if (oce == null) {
                s = nullSet;
            } else {
                s = map.get(oce);
                if (s == null) {
                    OperationCallExpKeyedSet<E> s2 = new OperationCallExpKeyedSet<E>(keyByOperation);
                    map.put(oce, s2);
                    s = s2;
                }
            }
            s.addAll(e);
        }
        return set.addAll(e);
    }
    
    public boolean addAll(OperationCallExpKeyedSet<E> other) {
        if (keyByOperation) {
            for (OperationCallExp key : other.map.keySet()) {
                OperationCallExpKeyedSet<E> s = map.get(key);
                if (s == null) {
                    s = new OperationCallExpKeyedSet<E>(keyByOperation);
                    map.put(key, s);
                }
                s.addAll(other.get(key));
            }
            nullSet.addAll(other.nullSet);
        }
        return set.addAll(other);
    }

    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    /**
     * Adds all elements from <code>c</code> with <code>null</code> as key. This is short for
     * {@link #putAll(OperationCallExp, Object) putAll(null, e)}.
     */
    public boolean addAll(Collection<? extends E> c) {
        return putAll(null, c);
    }

    private OperationCallExpKeyedSet<E> get(Object key) {
        if (!keyByOperation) {
            throw new RuntimeException("get(key) not supported on OperatoinCallExpKeyedSet if operation call selection is not activated. "+
                    "See ActivationOption.isOperationCallSelectionActive().");
        }
        if (key == null) {
            return new OperationCallExpKeyedSet<E>(nullSet, keyByOperation);
        } else {
            return map.get(key);
        }
    }

    public OperationCallExpKeyedSet<E> getCombinedResultsFor(OperationCallExp oce) {
        OperationCallExpKeyedSet<E> result;
        if (keyByOperation) {
            result = new OperationCallExpKeyedSet<E>(keyByOperation);
            Set<E> resultForOce = get(oce);
            if (resultForOce != null) {
                result.addAll(resultForOce);
            }
            result.addAll(nullSet);
        } else {
            result = this;
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public static OperationCallExpKeyedSet<AnnotatedEObject> emptySet(boolean keyByOperation) {
        if (keyByOperation) {
            return (OperationCallExpKeyedSet<AnnotatedEObject>) EMPTY_SET_KEYED_BY_OPERATION;
        } else {
            return (OperationCallExpKeyedSet<AnnotatedEObject>) EMPTY_SET_NOT_KEYED_BY_OPERATION;
        }
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("remove(...) not supported on objects of type "+getClass().getName());
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll(...) not supported on objects of type "+getClass().getName());
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("removeAll(...) not supported on objects of type "+getClass().getName());
    }

    public void clear() {
        throw new UnsupportedOperationException("clear(...) not supported on objects of type "+getClass().getName());
    }

    public String toString() {
        StringBuilder result = new StringBuilder('[');
        boolean first = true;
        for (E e : this) {
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
}

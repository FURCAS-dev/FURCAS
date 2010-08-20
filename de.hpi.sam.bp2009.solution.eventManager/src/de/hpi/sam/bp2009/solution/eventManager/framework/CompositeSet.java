package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Forwards {@link #contains(Object)} to the individual sets. Iterates by pulling the iterators of the
 * individual sets. Just creating the composite set happens in O(1) by assigning the passed array of
 * sets. The contains-check performs in O(n) is n is the number of sets held by this composite set and
 * assuming that the individual sets can perform their contains-check in O(1). The composite set is
 * unmodifiable. All modifying operations throw an exception.
 * 
 * @author Axel Uhl
 */
public class CompositeSet<E> extends AbstractSet<E> {
    final Set<E>[] sets;
    private int size = -1; // not set yet
    
    public CompositeSet(Set<E>... sets) {
        this.sets = sets;
    }
    
    @Override
    public boolean contains(Object o) {
        for (Set<E> set : sets) {
            if (set.contains(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("Unmodifiable collection");
    }

    @Override
    public boolean add(E e) {
        throw new RuntimeException("Unmodifiable collection");
    }

    @Override
    public boolean remove(Object o) {
        throw new RuntimeException("Unmodifiable collection");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new RuntimeException("Unmodifiable collection");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException("Unmodifiable collection");
    }

    @Override
    public void clear() {
        throw new RuntimeException("Unmodifiable collection");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int nextSet = 0;
            private Iterator<E> iter = nextIter();
            
            public boolean hasNext() {
                return iter != null && iter.hasNext();
            }
            
            private Iterator<E> nextIter() {
                Iterator<E> result = null;
                while (nextSet < sets.length && (result == null || !result.hasNext())) {
                    result = sets[nextSet++].iterator();
                }
                return result;
            }
            
            public E next() {
                E result = iter.next();
                if (!iter.hasNext()) {
                    iter = nextIter();
                }
                return result;
            }
            
            public void remove() {
                throw new UnsupportedOperationException("Read-only iterator on composite set");
            }
        };
    }

    @Override
    public int size() {
        if (size == -1) {
            size = 0;
            for (Set<E> s : sets) {
                size += s.size();
            }
        }
        return size;
    }
}

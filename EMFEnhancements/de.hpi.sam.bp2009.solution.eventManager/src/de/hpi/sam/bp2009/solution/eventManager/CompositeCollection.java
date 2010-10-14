package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Collection;
import java.util.Iterator;

/**
 * Forwards {@link #contains(Object)} to the individual sets. Iterates by pulling the iterators of the
 * individual sets. Just creating the composite set happens in O(1) by assigning the passed array of
 * sets. The contains-check performs in O(n) is n is the number of sets held by this composite set and
 * assuming that the individual sets can perform their contains-check in O(1). The composite set is
 * unmodifiable. All modifying operations throw an exception.
 * 
 * @author Axel Uhl
 */
public class CompositeCollection<E> extends CompositeIterable<E> implements Collection<E> {
    private int size = -1; // not set yet
    
    public CompositeCollection(Collection<? extends E>... collections) {
        super(collections);
    }
    
    public CompositeCollection(Collection<Iterable<? extends E>> collections) {
       super(collections);
    }
    
    private Collection<? extends E>[] getCollections() {
        return (Collection<? extends E>[]) getIterables();
    }
    
    public boolean contains(Object o) {
        for (Collection<? extends E> collection : getCollections()) {
            if (collection.contains(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("Unmodifiable collection");
    }

    public boolean add(E e) {
        throw new RuntimeException("Unmodifiable collection");
    }

    public boolean remove(Object o) {
        throw new RuntimeException("Unmodifiable collection");
    }

    public boolean addAll(Collection<? extends E> c) {
        throw new RuntimeException("Unmodifiable collection");
    }

    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException("Unmodifiable collection");
    }

    public void clear() {
        throw new RuntimeException("Unmodifiable collection");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int nextSet = 0;
            private Iterator<? extends E> iter = nextIter();
            
            public boolean hasNext() {
                return iter != null && iter.hasNext();
            }
            
            private Iterator<? extends E> nextIter() {
                Iterator<? extends E> result = null;
                while (nextSet < getCollections().length && (result == null || !result.hasNext())) {
                    result = getCollections()[nextSet++].iterator();
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

    public int size() {
        if (size == -1) {
            size = 0;
            for (Collection<? extends E> s : getCollections()) {
                size += s.size();
            }
        }
        return size;
    }

    public boolean isEmpty() {
        for (Collection<? extends E> s : getCollections()) {
            if (!s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Object[] toArray() {
        Object[] result = new Object[size()];
        int i=0;
        for (Object o : this) {
            result[i++] = o;
        }
        return result;
    }

    public <T> T[] toArray(T[] a) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[size()];
        int i=0;
        for (E o : this) {
            @SuppressWarnings("unchecked")
            T to = (T) o;
            result[i++] = to;
        }
        return result;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }
}

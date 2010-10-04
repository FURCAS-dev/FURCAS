package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Collection;
import java.util.Iterator;

public class CompositeIterable<E> implements Iterable<E> {
    final Iterable<? extends E>[] iterables;
    
    public CompositeIterable(Iterable<? extends E>... iterables) {
        this.iterables = iterables;
    }
    
    @SuppressWarnings("unchecked")
    public CompositeIterable(Collection<? extends Iterable<? extends E>> iterables) {
        this.iterables = (Iterable<? extends E>[]) iterables.toArray(new Iterable<?>[0]);
    }
    
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int nextSet = 0;
            private Iterator<? extends E> iter = nextIter();
            
            public boolean hasNext() {
                return iter != null && iter.hasNext();
            }
            
            private Iterator<? extends E> nextIter() {
                Iterator<? extends E> result = null;
                while (nextSet < iterables.length && (result == null || !result.hasNext())) {
                    result = iterables[nextSet++].iterator();
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

    protected Iterable<? extends E>[] getIterables() {
        return iterables;
    }

}

package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Set;


/**
 * A composite collection that has unique entries only. Clients need to assert this property by themselves
 * because only this way can we save the effort of actually iterating all elements of all sets which is the
 * whole purpose of this class.
 * 
 * @author Axel Uhl (D043530)
 */
public class CompositeSet<E> extends CompositeCollection<E> implements Set<E> {
    private Integer hashCode = null;
    
    public CompositeSet(Set<? extends E>... sets) {
        super(sets);
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Set<?>)) {
            return false;
        }
        Set<?> otherSet = (Set<?>) o;
        for (E e : this) {
            if (!otherSet.contains(e)) {
                return false;
            }
        }
        return true;
    }
    
    public int hashCode() {
        if (hashCode != null) {
            return hashCode;
        } else {
            int hc = 92748;
            for (E e : this) {
                hc ^= e.hashCode();
            }
            hashCode = hc;
            return hc;
        }
    }
}

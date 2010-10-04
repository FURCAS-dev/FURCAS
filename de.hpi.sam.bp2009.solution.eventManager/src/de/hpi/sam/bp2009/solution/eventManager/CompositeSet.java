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
    public CompositeSet(Set<? extends E>... sets) {
        super(sets);
    }
}

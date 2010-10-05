package de.hpi.sam.bp2009.solution.impactAnalyzer.util;

import java.util.Collection;

import org.eclipse.ocl.ecore.OperationCallExp;

/**
 * Produces {@link OperationCallExpKeyedSet} objects, either of type {@link OperationCallExpKeyedSetImpl} in case
 * the <code>isOperationCallSelectionActive</code> argument passed to the constructor was <code>true</code>,
 * or {@link FlatSet} objects otherwise.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class OperationCallExpKeyedSetFactory {
    private final boolean isOperationCallSelectionActive;

    public OperationCallExpKeyedSetFactory(boolean isOperationCallSelectionActive) {
        this.isOperationCallSelectionActive = isOperationCallSelectionActive;
    }
    
    public OperationCallExpKeyedSet createOperationCallExpKeyedSet(OperationCallExp oce, Iterable<AnnotatedEObject> c) {
        if (isOperationCallSelectionActive) {
            return new OperationCallExpKeyedSetImpl(oce, c);
        } else {
            return new FlatSet(c);
        }
    }

    public OperationCallExpKeyedSet createOperationCallExpKeyedSet(Iterable<AnnotatedEObject> c) {
        if (isOperationCallSelectionActive) {
            return new OperationCallExpKeyedSetImpl(c);
        } else {
            return new FlatSet(c);
        }
    }
    
    public OperationCallExpKeyedSet createOperationCallExpKeyedSet(AnnotatedEObject aeo) {
        if (isOperationCallSelectionActive) {
            return new OperationCallExpKeyedSetImpl(aeo);
        } else {
            return new FlatSet(aeo);
        }
    }
    
    public OperationCallExpKeyedSet createOperationCallExpKeyedSet(Collection<OperationCallExpKeyedSet> sets) {
        if (isOperationCallSelectionActive) {
            return new OperationCallExpKeyedSetImpl(sets);
        } else {
            return new FlatSet(sets);
        }
    }

    public OperationCallExpKeyedSet emptySet() {
        if (isOperationCallSelectionActive) {
            return OperationCallExpKeyedSetImpl.emptySet();
        } else {
            return FlatSet.emptySet();
        }
    }
    
}

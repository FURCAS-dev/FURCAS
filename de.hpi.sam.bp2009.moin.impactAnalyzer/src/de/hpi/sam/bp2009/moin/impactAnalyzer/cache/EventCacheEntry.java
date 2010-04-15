package de.hpi.sam.bp2009.moin.impactAnalyzer.cache;

import java.util.Set;

import org.eclipse.ocl.ecore.Constraint;

/**
 * Represents a tuple of an <code>OclStatement</code> (the affected statement)
 * and a <code>Set&ltOclStatement&gt</code> (the reverse navigation paths)
 */
public class EventCacheEntry {

    /**
     * A <code>Set</code> of OclStatements which evaluate to the set of
     * instances for which the affected statement has to be reevaluated
     */
    private final Set<Constraint> myNavigationStatements;

    /**
     * The affected OclStatement
     */
    private final Constraint myAffectedStatement;

    /**
     * Creates a new EventCacheEntry
     * 
     * @param affectedStatement the affect OclStatement
     * @param navigationStatements a list of reverse path expressions
     */
    EventCacheEntry( Constraint affectedStatement, Set<Constraint> navigationStatements ) {

        this.myAffectedStatement = affectedStatement;
        this.myNavigationStatements = navigationStatements;
    }

    /**
     * @return the (potentially) affected OclStatement
     */
    public Constraint getStatement( ) {

        return this.myAffectedStatement;
    }

    /**
     * @return a Set of <code>OclStatement</code>s evaluating to the set of
     * instances for which the affected statement (see {@link #getStatement()})
     * has to be reevaluated
     */
    public Set<Constraint> getInstances( ) {

        return this.myNavigationStatements;
    }
}
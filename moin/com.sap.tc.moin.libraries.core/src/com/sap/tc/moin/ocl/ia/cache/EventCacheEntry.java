package com.sap.tc.moin.ocl.ia.cache;

import java.util.Set;

import com.sap.tc.moin.ocl.utils.OclStatement;

/**
 * Represents a tuple of an <code>OclStatement</code> (the affected statement)
 * and a <code>Set&ltOclStatement&gt</code> (the reverse navigation paths)
 */
public class EventCacheEntry {

    /**
     * A <code>Set</code> of OclStatements which evaluate to the set of
     * instances for which the affected statement has to be reevaluated
     */
    private final Set<OclStatement> myNavigationStatements;

    /**
     * The affected OclStatement
     */
    private final OclStatement myAffectedStatement;

    /**
     * Creates a new EventCacheEntry
     * 
     * @param affectedStatement the affect OclStatement
     * @param navigationStatements a list of reverse path expressions
     */
    EventCacheEntry( OclStatement affectedStatement, Set<OclStatement> navigationStatements ) {

        this.myAffectedStatement = affectedStatement;
        this.myNavigationStatements = navigationStatements;
    }

    /**
     * @return the (potentially) affected OclStatement
     */
    public OclStatement getStatement( ) {

        return this.myAffectedStatement;
    }

    /**
     * @return a Set of <code>OclStatement</code>s evaluating to the set of
     * instances for which the affected statement (see {@link #getStatement()})
     * has to be reevaluated
     */
    public Set<OclStatement> getInstances( ) {

        return this.myNavigationStatements;
    }
}
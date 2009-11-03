package com.sap.tc.moin.ocl.ia.result.impl;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.ia.result.InstanceSet;
import com.sap.tc.moin.ocl.utils.OclStatement;

/**
 * Implementation of InstanceSet
 * 
 * @author Thomas Hettel (D039141)
 */
public class InstanceSetImpl implements InstanceSet {

    private final OclStatement navigationStatement;

    private final Set<RefObject> startingPoints;

    /**
     * @param theNavigationStatement {@link OclStatement}
     * @param theStartingPoints the starting points
     */
    public InstanceSetImpl( OclStatement theNavigationStatement, Set<RefObject> theStartingPoints ) {

        this.navigationStatement = theNavigationStatement;
        this.startingPoints = theStartingPoints;
    }

    /**
     * @return Returns the navigationStatement.
     */
    public OclStatement getNavigationStatement( ) {

        return this.navigationStatement;
    }

    /**
     * @return Returns the startingPoint.
     */
    public Set<RefObject> getStartingPoints( ) {

        return this.startingPoints;
    }

}
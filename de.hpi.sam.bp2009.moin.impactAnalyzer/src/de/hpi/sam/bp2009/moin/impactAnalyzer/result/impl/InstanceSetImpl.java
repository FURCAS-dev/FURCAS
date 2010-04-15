package de.hpi.sam.bp2009.moin.impactAnalyzer.result.impl;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;

/**
 * Implementation of InstanceSet
 * 
 * @author Thomas Hettel (D039141)
 */
public class InstanceSetImpl implements de.hpi.sam.bp2009.moin.impactAnalyzer.result.InstanceSet {

    private final Constraint navigationStatement;

    private final Set<EObject> startingPoints;

    /**
     * @param theNavigationStatement {@link OclStatement}
     * @param theStartingPoints the starting points
     */
    public InstanceSetImpl( Constraint theNavigationStatement, Set<EObject> theStartingPoints ) {

        this.navigationStatement = theNavigationStatement;
        this.startingPoints = theStartingPoints;
    }

    /**
     * @return Returns the navigationStatement.
     */
    public Constraint getNavigationStatement( ) {

        return this.navigationStatement;
    }

    /**
     * @return Returns the startingPoint.
     */
    public Set<EObject> getStartingPoints( ) {

        return this.startingPoints;
    }

}
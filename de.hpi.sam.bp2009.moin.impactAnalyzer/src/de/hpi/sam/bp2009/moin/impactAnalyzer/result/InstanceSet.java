package de.hpi.sam.bp2009.moin.impactAnalyzer.result;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Constraint;

/**
 * This class describes how to get the set of instances for which an
 * OclStatement has to be reevaluated.
 */
public interface InstanceSet {

    /**
     * The OclStatement describing how to compute the affected instances which
     * have to be reevaluated.
     * 
     * @return the navigation statement
     */
    public Constraint getNavigationStatement( );

    /**
     * The instance form which to start the computation of the affected
     * instances.
     * 
     * @return the starting points
     */
    public Set<EObject> getStartingPoints( );

}
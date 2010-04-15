package de.hpi.sam.bp2009.moin.impactAnalyzer.result;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.utils.OclStatement;

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
    public OclStatement getNavigationStatement( );

    /**
     * The instance form which to start the computation of the affected
     * instances.
     * 
     * @return the starting points
     */
    public Set<RefObject> getStartingPoints( );

}
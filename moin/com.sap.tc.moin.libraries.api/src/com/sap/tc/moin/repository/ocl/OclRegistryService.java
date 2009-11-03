package com.sap.tc.moin.repository.ocl;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.mof.OclMofConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

/**
 * The main entrypoint for the application to the OCL infrastructure
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients
 */
public interface OclRegistryService {

    /**
     * @return the "freestyle" registry
     */
    public OclFreestyleRegistry getFreestyleRegistry( );

    /**
     * @return the metamodel constraint registry
     */
    public OclMetamodelConstraintRegistry getMetamodelConstraintRegistry( );

    /**
     * @return the {@link OclMofConstraintRegistry}
     * @throws OclManagerException indicates internal problems
     */
    public OclMofConstraintRegistry getMofConstraintRegistry( ) throws OclManagerException;

    /**
     * Triggers partition-based analysis for a given category. Note that this
     * does not just involve invariant registration, but <em>all</em>
     * registrations for this category.
     * <p>
     * Does nothing if the category does not exist or if no registrations for
     * this category exist or if no listeners are registered for this category
     * and returns <code>false</code> in any of these cases.
     * 
     * @param category the category for which to re-evaluate
     * @param partitions the partitions for which to trigger evaluation
     * @return true if evaluation was actually performed
     * @throws OclManagerException indicates internal problems
     */
    public boolean analyzeModelPartitions( String category, Set<PRI> partitions ) throws OclManagerException;

    /**
     * Trigger analysis for the collected events.
     * <p>
     * Does nothing if the category does not exist or if no registrations for
     * this category exist or if no event-based, deferred listeners are
     * registered and returns <code>false</code> in any of these cases.
     * 
     * @param category the category for which to re-evaluate
     * @return true if evaluation was actually performed
     * @throws OclManagerException indicates internal problems
     */
    public boolean analyzeCollectedEvents( String category ) throws OclManagerException;

    /**
     * This is mainly for event-based, deferred checks: events are accumulated
     * in a buffer and subsequent evaluations will take all these events into
     * account until the event cache is cleared with this method.
     * <p>
     * Does nothing if the category does not exist or if no event-based,
     * deferred listeners exist for the category
     * 
     * @param category the category
     * @throws OclManagerException indicates internal problems
     */
    public void resetEvents( String category ) throws OclManagerException;

    /**
     * Verify constraints for a single object
     * <p>
     * The result is similar to the result of a call to
     * {@link RefBaseObject#refVerifyConstraints(boolean)} with the parameter
     * set to <code>false</code>, i.e. a shallow verify. Instead of a List of
     * Exceptions, this returns the violations as a
     * {@link DeferredConstraintViolationStatus}.
     * 
     * @param object the object to check
     * @return violation status information (may be empty)
     * @throws OclManagerException indicates internal problems
     */
    public DeferredConstraintViolationStatus verifyConstraints( RefObject object ) throws OclManagerException;

}

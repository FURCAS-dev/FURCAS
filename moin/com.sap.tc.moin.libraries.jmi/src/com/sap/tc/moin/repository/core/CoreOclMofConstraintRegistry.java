package com.sap.tc.moin.repository.core;

import java.util.Set;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;

/**
 * The MOF Constraint registry (Core Interface)
 */
public interface CoreOclMofConstraintRegistry {

    /**
     * @param connection connection
     * @return the available constraints
     * @throws OclConstraintManagerException internal
     */
    public Set<OclMetaModelConstraintRegistration> getAvailableMofConstraints( CoreConnection connection ) throws OclConstraintManagerException;

    /**
     * @param connection connection
     * @param partitionPris PRIs
     * @param category category
     * @return the status (may be empty, but not null)
     * @throws OclManagerException internal
     */
    public DeferredConstraintViolationStatus analyzeMetamodelPartitions( CoreConnection connection, Set<PRI> partitionPris, OclRegistrationCategory... category ) throws OclManagerException;

    /**
     * @param connection connection
     * @param pris PRIs
     * @param categories categories
     * @return the status (may be empty, but not null)
     * @throws OclManagerException internal
     */
    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, Set<PRI> pris, Set<OclRegistrationCategory> categories ) throws OclManagerException;

    /**
     * @param connection connection
     * @param listener listener
     * @param category category
     * @return see {@link Set#add(Object)}
     * @throws OclManagerException internal
     */
    public boolean registerDeferredConstraintViolationListenerForEvents( CoreConnection connection, DeferredConstraintViolationListener listener, OclRegistrationCategory... category ) throws OclManagerException;

    /**
     * @param connection connection
     * @param listener listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterDeferredConstraintViolationListener( CoreConnection connection, DeferredConstraintViolationListener listener );

    /**
     * @param connection connection
     * @param listener listener
     * @return see {@link Set#add(Object)}
     * @throws OclManagerException internal
     */
    public boolean registerImmediateConstraintViolationListener( CoreConnection connection, ImmediateConstraintViolationListener listener ) throws OclManagerException;

    /**
     * @param connection connection
     * @param listener listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterImmediateConstraintViolationListener( CoreConnection connection, ImmediateConstraintViolationListener listener );

    /**
     * @param connection connection
     * @param category category
     * @throws OclManagerException internal
     */
    public void analyzeCollectedEvents( CoreConnection connection, OclRegistrationCategory... category ) throws OclManagerException;

    /**
     * @param connection connection
     * @param category category
     * @throws OclManagerException internal
     */
    public void resetEvents( CoreConnection connection, OclRegistrationCategory... category ) throws OclManagerException;

}

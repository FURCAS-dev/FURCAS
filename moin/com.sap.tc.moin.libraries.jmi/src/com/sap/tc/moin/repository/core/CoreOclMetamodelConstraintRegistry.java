package com.sap.tc.moin.repository.core;

import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

/**
 * The {@link CoreOclMofConstraintRegistry}
 */
public interface CoreOclMetamodelConstraintRegistry {

    /**
     * @param connection connection
     * @param category category
     * @param listener listener
     * @return see {@link Set#add(Object)}
     * @throws IllegalArgumentException internal
     */
    public boolean registerImmediateConstraintViolationListener( CoreConnection connection, String category, ImmediateConstraintViolationListener listener ) throws IllegalArgumentException;

    /**
     * @param connection connection
     * @param category category
     * @param listener listener
     * @return see {@link Set#add(Object)}
     */
    public boolean registerPartitionBasedConstraintViolationListener( CoreConnection connection, String category, DeferredConstraintViolationListener listener );

    /**
     * @param connection connection
     * @param listener listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterDeferredListener( CoreConnection connection, DeferredConstraintViolationListener listener );

    /**
     * @param connection connection
     * @param listener listener
     * @return see {@link Set#remove(Object)}
     */
    public boolean unregisterImmediateListener( CoreConnection connection, ImmediateConstraintViolationListener listener );

    /**
     * @param connection connection
     * @return the constraints
     * @throws OclConstraintManagerException internal
     */
    public Set<OclMetaModelConstraintRegistration> getAvailableMetamodelConstraints( CoreConnection connection ) throws OclConstraintManagerException;

    /**
     * @param connection connection
     * @param category category
     * @param listener listener
     * @return see {@link Set#add(Object)}
     */
    public boolean registerDeferredConstraintViolationListenerForEvents( CoreConnection connection, String category, DeferredConstraintViolationListener listener );

    /**
     * @param connection connection
     * @return the registered content
     * @throws OclManagerException internal
     */
    public Map<String, Set<OclMetaModelConstraintRegistration>> getRegistry( CoreConnection connection ) throws OclManagerException;

    /**
     * @param connection connection
     * @param pris partitions
     * @param categories categories
     * @return status
     * @throws OclManagerException internal
     */
    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, Set<PRI> pris, Set<String> categories ) throws OclManagerException;

}

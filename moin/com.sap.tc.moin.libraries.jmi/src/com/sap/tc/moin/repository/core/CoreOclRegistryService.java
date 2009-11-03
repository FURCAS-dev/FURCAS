package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.management.ObjectName;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

/**
 * The {@link OclRegistryService} (Core API)
 */
public interface CoreOclRegistryService {

    /**
     * @param connection connection
     * @return the {@link OclFreestyleRegistry}
     */
    public OclFreestyleRegistry getFreestyleRegistry( CoreConnection connection );

    /**
     * @param connection connection
     * @return the {@link CoreOclMetamodelConstraintRegistry}
     */
    public CoreOclMetamodelConstraintRegistry getMetamodelConstraintRegistry( CoreConnection connection );

    /**
     * @param connection connection
     * @return the {@link CoreOclMofConstraintRegistry}
     * @throws OclManagerException internal
     */
    public CoreOclMofConstraintRegistry getMofConstraintRegistry( CoreConnection connection ) throws OclManagerException;

    /**
     * @param connection connection
     * @param category category
     * @param partitions partitions
     * @return <code>true</code> if anything was checked</true>
     * @throws OclManagerException internal
     */
    public boolean analyzeModelPartitions( CoreConnection connection, String category, Set<PRI> partitions ) throws OclManagerException;

    /**
     * @param connection connection
     * @param category category
     * @return <code>true</code> if anything was checked
     * @throws OclManagerException internal
     */
    public boolean analyzeCollectedEvents( CoreConnection connection, String category ) throws OclManagerException;

    /**
     * @param connection connection
     * @param category category
     * @throws OclManagerException internal
     */
    public void resetEvents( CoreConnection connection, String category ) throws OclManagerException;

    /**
     * @param connection connection
     * @param object the object
     * @return the status, never null
     * @throws OclManagerException internal
     */
    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, RefObject object ) throws OclManagerException;

    /**
     * @param connection connection
     * @param partitions partitions
     * @return the status, never null
     * @throws OclManagerException internal
     */
    public Map<ProcessReport, MRI> parseOclConstraints( CoreConnection connection, Set<CoreModelPartition> partitions ) throws OclManagerException;

    /**
     * @param conn connection
     * @param targetObject object
     * @param deepVerify deepVerify
     * @return the exceptions, never null
     */
    public Collection<JmiException> refVerifyConstraints( CoreConnection conn, RefObject targetObject, boolean deepVerify );

    /**
     * @param connection connection
     * @return the {@link CoreOclMofConstraintRegistry}
     * @throws OclManagerException internal
     */
    public CoreOclMofConstraintRegistry getCoreOclMofConstraintRegistry( CoreConnection connection ) throws OclManagerException;

    /**
     * @return the {@link ObjectName} identifying this OclRegistryService in
     * JMX.
     */
    public ObjectName getObjectName( );

    /**
     * Creates and registers the OclRegistryService MBean for the given session.
     * 
     * @param session session
     */
    public void registerMBean( CoreSession session );

    /**
     * @param connection connection
     * @return the CoreOclEditorService
     */
    public CoreOclEditorService getOclEditorService( Connection connection );

}

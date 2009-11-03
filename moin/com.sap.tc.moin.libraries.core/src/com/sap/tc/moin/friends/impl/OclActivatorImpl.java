package com.sap.tc.moin.friends.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.friends.ocl.OclActivator;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.AbstractConnectionAwareWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The OCL Activator implementation
 */
public class OclActivatorImpl implements OclActivator {


    private final CoreConnection myConnection;

    /**
     * @param connection the connection
     */
    public OclActivatorImpl( CoreConnection connection ) {

        this.myConnection = connection;
    }

    public Map<ProcessReport, MRI> parseOclConstraintsInPartitions( Set<ModelPartition> partitions ) {

        Set<SynchronizationManager> mgrs = new HashSet<SynchronizationManager>( );
        AbstractConnectionAwareWrapper<ModelPartition> wrapper = null;
        for ( ModelPartition p : partitions ) {
            wrapper = (AbstractConnectionAwareWrapper<ModelPartition>) p;
            mgrs.add( wrapper.getSynchronizationManager( ) );
        }

        SynchronizationManager mgr = mgrs.iterator( ).next( );
        synchronized ( mgr.getProhibitWriteSyncObject( ) ) {
            wrapper.assertConnectionAlive( );
            mgr.acquireMicroWriteLock( );
            try {
                Set<CoreModelPartition> corePartitions = new HashSet<CoreModelPartition>( );
                for ( ModelPartition p : partitions ) {
                    corePartitions.add( (CoreModelPartition) ( (Wrapper<ModelPartition>) p ).unwrap( ) );
                }

                try {
                    return this.myConnection.getCoreOclRegistryService( ).parseOclConstraints( this.myConnection, corePartitions );
                } catch ( OclManagerException e ) {
                    throw new MoinLocalizedBaseRuntimeException( e );
                }
            } finally {
                mgr.releaseMicroWriteLock( );
            }
        }

    }
}

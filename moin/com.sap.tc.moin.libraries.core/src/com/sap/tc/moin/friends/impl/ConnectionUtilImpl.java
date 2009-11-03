package com.sap.tc.moin.friends.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import com.sap.tc.moin.friends.CommandStackObserver;
import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.ProgressMonitor;
import com.sap.tc.moin.friends.impl.merge.OperationInvokerImpl;
import com.sap.tc.moin.friends.merge.OperationInvoker;
import com.sap.tc.moin.friends.merge.OperationInvokerConfiguration;
import com.sap.tc.moin.friends.ocl.OclActivator;
import com.sap.tc.moin.friends.ocl.editor.OclEditorService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CoreOclEditorService;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.OclEditorServiceWrapper;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;


/**
 * The implementation of the ConnectionUtil interface
 */
public class ConnectionUtilImpl implements ConnectionUtil {

    @SuppressWarnings( "unchecked" )
    public void setCommandStackObserver( Connection connection, CommandStackObserver observer ) {

        CoreConnection coreConnection = ( (Wrapper<CoreConnection>) connection ).unwrap( );
        coreConnection.getCommandStack( ).setCommandStackObserver( observer );
    }

    @SuppressWarnings( "unchecked" )
    public void setProgressMonitor( Connection connection, ProgressMonitor progressMonitor ) {

        CoreConnection coreConnection = ( (Wrapper<CoreConnection>) connection ).unwrap( );
        coreConnection.getCommandStack( ).setProgressMonitor( progressMonitor );
    }

    @SuppressWarnings( "unchecked" )
    public OclEditorService getOclEditorService( Connection connection ) {

        CoreConnection coreConnection = ( (Wrapper<CoreConnection>) connection ).unwrap( );
        CoreOclEditorService srv = coreConnection.getCoreOclRegistryService( ).getOclEditorService( connection );
        return new OclEditorServiceWrapper( srv, coreConnection );
    }

    @SuppressWarnings( "unchecked" )
    public OclActivator getOclActivator( Connection connection ) {

        CoreConnection coreConnection = ( (Wrapper<CoreConnection>) connection ).unwrap( );
        return new OclActivatorImpl( coreConnection );
    }

    @SuppressWarnings( "unchecked" )
    public ModelPartition loadPartition( Connection connection, PRI pri, InputStream stream ) {

        CoreConnection coreConnection = ( (Wrapper<CoreConnection>) connection ).unwrap( );
        CoreSession session = coreConnection.getSession( );
        WorkspaceSet workspaceSet = session.getWorkspaceSet( );
        CoreModelPartition partition = null;

        workspaceSet.getSynchronizationManager( ).acquireReadLock( );
        try {
            CoreMoin moin = session.getMoin( );
            SpiPartitionSerializationManager serializationManager = moin.getPartitionSerializationManager( );
            Workspace ws = session.getWorkspace( );
            SpiStage stage = ws.getStage( pri.getDataAreaDescriptor( ) );
            partition = ws.getPartitionFactory( ).createModelPartition( pri, stage, ws );
            SpiParserCallback callback = moin.getCore( ).getPartitionService( ).getCoreParserCallback( serializationManager, session, partition );

            // Before the partition is loaded, an old version must be evicted
            ws.getPartitionManager( ).evictPartitions( Collections.singletonList( pri ) );
            try {
                serializationManager.parse( pri, stream, callback, -1 );
            } catch ( IOException e ) {
                return null;
            }

            coreConnection.setSaveAllowed( false );

            ws.getPartitionManager( ).addPartition( coreConnection, partition );
            // dirty to force the index to read from memory
            partition.markDirty( coreConnection );

            return coreConnection.getWrapperForModelPartition( partition );
        } finally {
            workspaceSet.getSynchronizationManager( ).releaseReadLock( );
        }
    }

    public OperationInvoker getMergeOperationInvoker( ModelPartition sourcePartition, ModelPartition targetPartition, OperationInvokerConfiguration config ) {

        return new OperationInvokerImpl( sourcePartition, targetPartition, config );
    }
}

package com.sap.tc.moin.facility.versioning.eclipse;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

import com.sap.tc.moin.facility.filesystem.componentmodel.services.FsPersistenceExtImpl;
import com.sap.tc.moin.facility.versioning.IpiVersioningSupport;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;


public class FsPersistenceVersionedImpl extends FsPersistenceExtImpl {

    public FsPersistenceVersionedImpl( String moinId, ReferenceQueue<?> refQueue ) {

        super( moinId, refQueue );
    }

    private IpiVersioningSupport versioning;

    public void bind( IpiVersioningSupport versioning ) {

        this.versioning = versioning;
    }

    protected void processPartitions( Collection<SpiPartitionSaveContext> partitions, SpiSaveOperation operation ) {

        if ( partitions != null && partitions.size( ) > 0 ) {
            for ( SpiPartitionSaveContext partitionContext : partitions ) {
                try {
                    switch ( operation ) {
                        case ADD:
                        case EDIT:
                            this.storePartition( partitionContext );
                            this.storePartitionTexts( partitionContext );
                            break;
                        case DELETE:
                            this.deletePartition( partitionContext.getPri( ) /* deletePartition only accepts PRI in this version
                            						     , partitionContext.getStage( ) */);
                            deletePartitionTexts( partitionContext.getPri( ) );
                    }
                } catch ( Throwable t ) {
                    partitionContext.signalFail( t );
                }
            }
        }
    }

    @Override
    public void savePartitions( final Collection<SpiPartitionSaveContext> partitionsToBeCreated, final Collection<SpiPartitionSaveContext> partitionsToBeEdited, final Collection<SpiPartitionSaveContext> partitionsToBeDeleted, Object lockHandle ) {

        IWorkspaceRunnable runnable = new IWorkspaceRunnable( ) {

            public void run( IProgressMonitor monitor ) {

                versioning.processPartitions( partitionsToBeDeleted, SpiSaveOperation.DELETE );
                processPartitions( partitionsToBeCreated, SpiSaveOperation.ADD );
                processPartitions( partitionsToBeEdited, SpiSaveOperation.EDIT );
                versioning.processPartitions( partitionsToBeEdited, SpiSaveOperation.EDIT );
                processPartitions( partitionsToBeDeleted, SpiSaveOperation.DELETE );
                versioning.processPartitions( partitionsToBeCreated, SpiSaveOperation.ADD );
            }
        };

        try {
            if ( lockHandle instanceof ISchedulingRule ) {
                ResourcesPlugin.getWorkspace( ).run( runnable, (ISchedulingRule) lockHandle, IWorkspace.AVOID_UPDATE, null );
            } else {
                throw new MoinLocalizedBaseRuntimeException( (MoinLocalizedBaseRuntimeException) null );
            }
        } catch ( CoreException e ) {
            throw new RuntimeException( e );
        }
    }
}

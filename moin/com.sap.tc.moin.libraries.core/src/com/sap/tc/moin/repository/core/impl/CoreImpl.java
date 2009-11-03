package com.sap.tc.moin.repository.core.impl;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.Core;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl;
import com.sap.tc.moin.repository.core.cps.parser.CoreParserCallbackImpl;
import com.sap.tc.moin.repository.core.cps.parser.PartitionParserImpl;
import com.sap.tc.moin.repository.core.cps.serializer.PartitionSerializerImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionReaderImpl;
import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiOperationService;
import com.sap.tc.moin.repository.spi.core.SpiPartitionService;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.core.SpiStageService;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionWriter;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * Implementation of SpiMoin.
 * 
 * @author d026715
 */
public class CoreImpl implements Core, SpiPartitionService, SpiOperationService, SpiStageService {

    private final CoreMoin moin;

    private SpiMetamodelService metamodelService;

    public CoreImpl( CoreMoin moin ) {

        this.moin = moin;
        initMetamodelService( );
    }

    public void shutDown( ) {

        initMetamodelService( );
    }

    private void initMetamodelService( ) {

        this.metamodelService = new MetamodelServiceImpl( moin );
    }

    public String getMoinId( ) {

        return this.moin.getId( );
    }

    /*
     * Expose MOIN Core functionality via service interfaces (implementation
     * follows below)
     */

    public SpiPartitionService getPartitionService( ) {

        return this;
    }

    public SpiMetamodelService getMetamodelService( ) {

        return this.metamodelService;
    }

    public SpiOperationService getOperationService( ) {

        return this;

    }

    public SpiStageService getStageFactory( ) {

        return this;

    }

    public SpiJmiHelper getJmiHelper( ) {

        return moin.getJmiHelper( );
    }

    /*
     * Implementation of the provided service interfaces
     */

    public SpiStage createSharedStage( DataAreaDescriptor dataAreaDescriptor, String name ) {

        return new SharedStageImpl( dataAreaDescriptor, name );
    }

    public SpiStage createClientSpecificStage( DataAreaDescriptor dataAreaDescriptor, String name, String clientspecId ) {

        return new ClientSpecificStageImpl( dataAreaDescriptor, name, clientspecId );
    }

    public SpiResourceInfo createResourceInfo( PRI pri, SpiStage stage ) {

        return new ResourceInfoImpl( pri, stage );
    }

    public SpiPartitionReader createPartitionReader( ) {

        return new PartitionReaderImpl( );
    }

    public SpiPartitionWriter createPartitionWriter( ) {

        return new PartitionWriterImpl( );
    }

    public void evictPartitions( Map<SpiStage, List<PRI>> partitionsToEvictPerStage ) {

        if ( partitionsToEvictPerStage == null ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.PARTITIONSTOEVICTGROUPEDBYSTAGEMUSTNOTBENULL );
        }
        Collection<WorkspaceSet> workspaceSets = this.moin.getWorkspaceSets( );
        Set<Entry<SpiStage, List<PRI>>> stageToPris = partitionsToEvictPerStage.entrySet( );
        for ( WorkspaceSet workspaceSet : workspaceSets ) {
            SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                synchronizationManager.acquireMicroWriteLock( );
                try {
                    for ( Entry<SpiStage, List<PRI>> entry : stageToPris ) {
                        SpiStage stage = entry.getKey( );
                        List<PRI> pris = entry.getValue( );
                        if ( stage.isClientSpecific( ) ) {
                            String clientId = stage.getName( );
                            CompoundClientSpecWorkspace compoundClientSpecWorkspace = workspaceSet.getCompoundClientSpecWorkspace( clientId );
                            if ( compoundClientSpecWorkspace != null ) {
                                compoundClientSpecWorkspace.getPartitionManager( ).evictPartitions( pris );
                                // Empty the PRI cache of all sessions.
                                for ( CoreSession session : workspaceSet.getSessionsForClientId( clientId ) ) {
                                    Map<CRI, Collection<PRI>> cachePartitionsInContainer = session.getCachePartitionsInContainer( );
                                    if ( cachePartitionsInContainer != null ) {
                                        for ( PRI pri : pris ) {
                                            cachePartitionsInContainer.remove( pri.getCri( ) );
                                        }
                                    }
                                }
                            }
                        } else {
                            Workspace sharedWorkspace = workspaceSet.getWorkspace( stage, null );
                            if ( sharedWorkspace != null ) {
                                sharedWorkspace.getPartitionManager( ).evictPartitions( pris );
                            }
                        }
                    }
                } finally {
                    synchronizationManager.releaseMicroWriteLock( );
                }
            }
        }
    }

    @Deprecated
    public boolean hasTranslatableTexts( Connection connection, PRI pri ) {

        // check the partition for texts
        ModelPartition partition = connection.getPartition( pri );
        SpiSession session = (SpiSession) connection.getSession( );
        // search for at least one class with an attribute of type TranslatableText
        Collection<Partitionable> elements = partition.getElements( );
        for ( Partitionable element : elements ) {
            if ( element instanceof RefObject && ( (RefObject) element ).refMetaObject( ) instanceof MofClass ) {
                MofClass clazz = (MofClass) ( (RefObject) element ).refMetaObject( );
                for ( Attribute attribute : getJmiHelper( ).getAttributes( session, clazz, true ) ) {
                    if ( attribute.getType( ) instanceof StructureType && getJmiHelper( ).isTranslatableText( session, (StructureType) attribute.getType( ) ) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCommandRunningInCurrentThread( ) {

        return CommandStackImpl.isCommandRunningInCurrentThread( );
    }

    public ReferenceQueue getReferenceQueue( ) {

        return moin.getReferenceQueue( );
    }

    public final boolean isLinkAllowed( SpiLifecycleManagement lifecycleManagement, PRI priOfStoredEnd, PRI priOfOtherEnd, SpiClientSpec clientSpecOfStoredEnd, SpiClientSpec clientSpecOfOtherEnd ) {

        if ( !isSavablePartition( priOfStoredEnd ) ) {
            return true; //link to a non-savable partition is allowed
        }

        if ( !isSavablePartition( priOfOtherEnd ) ) {
            return true; //link to a non-savable partition is allowed
        }

        if ( priOfStoredEnd.getCri( ).equals( priOfOtherEnd.getCri( ) ) ) {
            return true; //link within the same container is allowed
        }

        if ( priOfOtherEnd.isMetaModelPartition( ) ) {
            return true;//links to a MM partition are always allowed
        }

        return lifecycleManagement.isLinkBackedByContainerUsage( priOfStoredEnd, priOfOtherEnd, clientSpecOfStoredEnd, clientSpecOfOtherEnd );

    }

    public final boolean isSavablePartition( PRI pri ) {

        return ( !pri.isVolatilePartition( ) );
    }

    public SpiCustomParser getParser( ) {

        return new PartitionParserImpl( );
    }

    public SpiCustomSerializer getSerializer( ) {

        return new PartitionSerializerImpl( );
    }

    public SpiParserCallback getCoreParserCallback( SpiPartitionSerializationManager serializationManager, SpiSession session, ModelPartition partition ) {

        return new CoreParserCallbackImpl( serializationManager, (CoreSession) session, (CoreModelPartition) partition );
    }

    public void executeCoreRunnable( SpiCoreRunnable coreRunnable, DataAreaDescriptor... dataAreaScope ) {

        List<SynchronizationManager> syncManagers = new ArrayList<SynchronizationManager>( );

        List<DataAreaDescriptor> daDescs = Arrays.asList( dataAreaScope );
        for ( WorkspaceSet wks : this.moin.getWorkspaceSets( ) ) {
            for ( DataArea da : wks.getCompoundDataArea( ).getDataAreas( ) ) {
                if ( daDescs.contains( da.getDescriptor( ) ) ) {
                    syncManagers.add( wks.getSynchronizationManager( ) );
                    break;
                }
            }
        }

        if ( !syncManagers.isEmpty( ) ) {
            this.executeCoreRunnableLocked( coreRunnable, syncManagers.iterator( ) );
        } else {
            // no active worksets for the given data areas - but we have to execute the runnable 
            // FIXME: dataarea sync in core - what happens if a ws is just created now?
            coreRunnable.run( );
        }
    }

    private void executeCoreRunnableLocked( SpiCoreRunnable coreRunnable, Iterator<SynchronizationManager> itSyncManager ) {

        SynchronizationManager next = itSyncManager.next( );

        synchronized ( next ) {
            next.acquireMicroWriteLock( );
            try {
                if ( itSyncManager.hasNext( ) ) {
                    this.executeCoreRunnableLocked( coreRunnable, itSyncManager );
                } else {
                    coreRunnable.run( );
                }
            } finally {
                next.releaseMicroWriteLock( );
            }
        }
    }

    public void requestMofRomInjection( ) {

        this.moin.injectMofRomIntoFacility( );
    }
}

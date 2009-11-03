package com.sap.tc.moin.repository.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyMap;
import com.sap.tc.moin.repository.DeepCopyPolicy;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.MetamodelElementDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.repository.xmi.XmiReader;
import com.sap.tc.moin.repository.xmi.XmiWriter;

public final class ConnectionWrapper extends AbstractConnectionAwareWrapper<CoreConnection> implements Connection {

    private WrapperManager wrapperManager;

    private JmiHelper jmiHelper;

    private Session session;

    private XmiReaderWrapper xmiReader;

    private XmiWriter xmiWriter;

    private CommandStack commandStack;

    private EventRegistry eventRegistry;

    private MQLProcessor mqlProcessor;

    private OclRegistryService oclRegistryService;

    private DeepCopyPolicyHandler defaultDeepCopyPolicyHandler;

    public ConnectionWrapper( WorkspaceSet workspaceSet, CoreConnection connection ) {

        super( connection, workspaceSet.getSynchronizationManager( ) );
        this.wrapperManager = workspaceSet.getWrapperManager( );
        this.jmiHelper = new JmiHelperWrapper( connection, workspaceSet.getSynchronizationManager( ) );
        this.session = connection.getSession( ).getWrapper( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof ConnectionWrapper ) {
            return connection.equals( ( (ConnectionWrapper) obj ).connection );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return connection.hashCode( );
    }

    @Override
    public String toString( ) {

        return connection.toString( );
    }

    public String getLabel( ) {

        return connection.getLabel( );
    }

    public void setLabel( String label ) {

        assertConnectionAlive( );
        connection.setLabel( label );
    }

    public String getId( ) {

        return connection.getId( );
    }

    public Session getSession( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return session;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void save( ) throws PartitionsNotSavedException, NullPartitionNotEmptyException {

        // avoid synchronization locks here since the complex handling of locks 
        // in conjunction with the Facility locking is handled in the implementation of "save"
        assertConnectionAlive( );
        attachConnectionIfRequired( );
        connection.save( );

    }

    public void revert( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            connection.revert( );
        }
    }

    public boolean isAlive( ) {

        // Don't use assertAlive() here, because isAlive() must not throw an
        // exception.
        return connection.isAlive( );
    }

    public void close( ) {

        // both the "big" and the micro write lock have to be acquired because
        // the actual close might have to do a
        // "revert()". The micro write lock is needed in order to prevent a race
        // condition between connection.close()
        // and assertConnectionAlive()

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            synchronizationManager.acquireMicroWriteLock( );
            try {
                // Closing an already closed connection has to be a no-op (just
                // like in ConnectionImpl).
                if ( this.isAlive( ) ) {
                    attachConnectionIfRequired( );
                    connection.closeInternal( );
                }
                if ( this.commandStack != null ) {
                    ( (Wrapper<CoreCommandStack>) this.commandStack ).unwrap( ).destroy( );
                    this.commandStack = null;
                }
                this.jmiHelper = null;
                this.mqlProcessor = null;
                this.oclRegistryService = null;
                this.session = null;
                this.wrapperManager = null;
                this.xmiReader = null;
                this.xmiWriter = null;
            } finally {
                synchronizationManager.releaseMicroWriteLock( );
            }
        }
    }


    public RefPackage getPackage( String modelContainerName, String... qualifiedName ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefPackage result = connection.getPackage( modelContainerName, qualifiedName );
            if ( result != null ) {
                result = connection.getWrapperForJmiObject( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public RefPackage getPackage( PackageDescriptor packageDescriptor ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefPackage result = connection.getPackage( packageDescriptor );
            if ( result != null ) {
                result = connection.getWrapperForJmiObject( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public RefClass getClass( ClassDescriptor classDescriptor ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefClass result = connection.getClass( classDescriptor );
            if ( result != null ) {
                result = connection.getWrapperForJmiObject( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public RefAssociation getAssociation( AssociationDescriptor associationDescriptor ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefAssociation result = connection.getAssociation( associationDescriptor );
            if ( result != null ) {
                result = connection.getWrapperForJmiObject( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public <T extends RefBaseObject> T getMetamodelElement( MetamodelElementDescriptor<T> metamodelElementDescriptor ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            T result = connection.getMetamodelElement( metamodelElementDescriptor );
            if ( result != null ) {
                result = connection.getWrapperForJmiObject( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public RefBaseObject getElement( MRI mri ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefBaseObject result = connection.getElement( mri );
            if ( result != null ) {
                result = connection.getWrapperForJmiObject( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public RefBaseObject getElement( LRI lri ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefBaseObject result = connection.getElement( lri );
            if ( result != null ) {
                result = connection.getWrapperForJmiObject( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean elementExists( LRI lri ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.elementExists( lri );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean elementExists( MRI mri ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.elementExists( mri );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public <T extends RefObject> T createElement( ClassDescriptor<? extends RefClass, T> classDescriptor ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );

            return connection.getWrapperForJmiObject( connection.createElement( classDescriptor ) );
        }
    }

    public <T extends RefObject> T createElement( Class<T> clazz ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );

            return connection.getWrapperForJmiObject( connection.createElement( clazz ) );
        }
    }

    public <T extends RefObject> T createElementInPartition( ClassDescriptor<? extends RefClass, T> classDescriptor, ModelPartition partition ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );

            // Unwrap arg
            if ( partition != null ) {
                partition = ( (Wrapper<ModelPartition>) partition ).unwrap( );
            }

            return connection.getWrapperForJmiObject( connection.createElementInPartition( classDescriptor, partition ) );
        }
    }

    public <T extends RefObject> T createElementInPartition( Class<T> clazz, ModelPartition partition ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );

            // Unwrap arg
            if ( partition != null ) {
                partition = ( (Wrapper<ModelPartition>) partition ).unwrap( );
            }

            return connection.getWrapperForJmiObject( connection.createElementInPartition( clazz, partition ) );
        }
    }

    public ModelPartition createPartition( PRI pri ) throws InvalidResourceIdentifierException, PartitionCreatingNotPossibleException {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.getWrapperForModelPartition( connection.createPartition( pri ) );
        }
    }

    public ModelPartition getPartition( PRI pri ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.getWrapperForModelPartition( connection.getPartition( pri ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean partitionExists( PRI pri ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.partitionExists( pri );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public XmiWriter getXmiWriter( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            if ( xmiWriter == null ) {
                xmiWriter = new XmiWriterWrapper( connection );
            }
            return xmiWriter;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public XmiReader getXmiReader( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            if ( xmiReader == null ) {
                xmiReader = new XmiReaderWrapper( connection );
            }
            return xmiReader;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public ModelImporter createModelImporter( XmParserConfiguration configuration ) {

        return connection.getImportExportFactory( ).getModelImporter( configuration, this );
    }


    public ModelExporter createModelExporter( XmSerializerConfiguration configuration ) {

        return connection.getImportExportFactory( ).getModelExporter( configuration, this );
    }


    public synchronized MQLProcessor getMQLProcessor( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            if ( mqlProcessor == null ) {
                mqlProcessor = new MQLProcessorWrapper( connection );
            }
            return mqlProcessor;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public synchronized CommandStack getCommandStack( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            if ( commandStack == null ) {
                commandStack = new CommandStackWrapper( connection );
            }
            return commandStack;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public JmiHelper getJmiHelper( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return jmiHelper;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public DeepCopyResultSet deepCopy( Collection<RefObject> elementsToBeCopied, DeepCopyPolicyHandler policyHandler, boolean includeExternalCompositeParents ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Map<MRI, CoreConnection> connectionsOfElements = new HashMap<MRI, CoreConnection>( Utilities.calcInitialCapacity( elementsToBeCopied.size( ) ) );
            for ( RefObject elem : elementsToBeCopied ) {
                //DO NOT unwrap the element before getting the connection!!!
                connectionsOfElements.put( elem.get___Mri( ), ( (Wrapper<CoreConnection>) elem.get___Connection( ) ).unwrap( ) );
            }

            // copy elements

            if ( policyHandler == null ) {
                policyHandler = getDefaultDeepCopyPolicyHandler( );
            }

            DeepCopyTransactionable dcTx = new DeepCopyTransactionable( connection, connectionsOfElements, new DeepCopyPolicyHandlerWrapper( policyHandler, connection ), includeExternalCompositeParents );

            connection.getSession( ).getTransactionManager( ).runInTransaction( dcTx );

            DeepCopyResultSet resultSet = dcTx.resultSet;
            Collection<RefObject> copiedElements = resultSet.getCopiedElements( );

            // wrap returned elements

            Collection<RefObject> wrappedObjects = new ArrayList<RefObject>( );

            for ( RefObject copy : copiedElements ) {
                wrappedObjects.add( (RefObject) wrapperManager.wrapObject( connection, copy ) );
            }

            return new DeepCopyResultSetImpl( wrappedObjects, new DeepCopyMapWrapper( resultSet.getMappingTable( ), connection ), resultSet.getMriMappingTable( ), resultSet.getInverseMriMappingTable( ), resultSet.getCopyErrors( ) );

        }

    }

    private static final class DeepCopyTransactionable implements Transactionable {

        private final CoreConnection coreConnection;

        private Map<MRI, CoreConnection> elementsToBeCopied;

        private DeepCopyPolicyHandlerWrapper policyHandler;

        private boolean includeExternalCompositeParents;

        private DeepCopyResultSet resultSet;

        public DeepCopyTransactionable( CoreConnection con, Map<MRI, CoreConnection> elementsToBeCopied, DeepCopyPolicyHandlerWrapper policyHandler, boolean includeExternalCompositeParents ) {

            this.coreConnection = con;
            this.elementsToBeCopied = elementsToBeCopied;
            this.policyHandler = policyHandler;
            this.includeExternalCompositeParents = includeExternalCompositeParents;
        }

        public void runInTransaction( ) {

            resultSet = coreConnection.deepCopy( elementsToBeCopied, policyHandler, includeExternalCompositeParents );
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    /**
     * Standard Deep Copy Policy Handler that applies the default policy to all
     * operations.
     * 
     * @return
     */
    private DeepCopyPolicyHandler getDefaultDeepCopyPolicyHandler( ) {

        if ( defaultDeepCopyPolicyHandler == null ) {
            defaultDeepCopyPolicyHandler = new DeepCopyPolicyHandler( ) {

                public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap ) {

                    return defaultPolicy;
                }
            };
        }
        return defaultDeepCopyPolicyHandler;
    }

    public synchronized OclRegistryService getOclRegistryService( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            if ( oclRegistryService == null ) {
                oclRegistryService = OclRegistryServiceWrapper.create( connection );
            }
            return oclRegistryService;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public ConsistencyViolationListenerRegistry getConsistencyViolationListenerRegistry( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return new ConsistencyViolationRegistryWrapperImpl( this.connection );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public CoreConnection unwrap( ) {

        return connection;
    }

    public boolean isDirty( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.isDirty( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public ModelPartition getNullPartition( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            ModelPartition result = connection.getNullPartition( );
            if ( result != null ) {
                result = connection.getWrapperForModelPartition( result );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public EventRegistry getEventRegistry( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            if ( eventRegistry == null ) {
                eventRegistry = new EventRegistryWrapperForConnection( connection );
            }
            return eventRegistry;

        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public ModelPartition getOrCreateTransientPartition( String partitionName ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.getWrapperForModelPartition( connection.getOrCreateTransientPartition( partitionName ) );
        }
    }

    public Collection<ModelPartition> getPartitionsToBeSaved( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Collection<ModelPartition> unwrapped = connection.getPartitionsToBeSaved( );
            return wrapCollectionContent( unwrapped );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public Collection<ModelPartition> getTransientPartitions( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Collection<ModelPartition> unwrapped = connection.getTransientPartitions( );
            return wrapCollectionContent( unwrapped );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public Collection<MRI> getReferencedTransientElements( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.getReferencedTransientElements( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean hasReferencedTransientElements( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.hasReferencedTransientElements( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean hasCrossPartitionLinks( PRI priOne, PRI... otherPris ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.hasCrossPartitionLinks( priOne, otherPris );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean isLegalNameForTransientPartition( String partitionName ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.isLegalNameForTransientPartition( partitionName );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }


    public void enableMemoryChangeOnly( ) {

        //this is actually not guarded by the usual locks, therefore the connection could be concurrently closed,
        //but as "connection.enableMemoryChangeOnly( )" is a simple setter which doesn't need anything from the
        //state of an "alive" connection, that's no problem
        assertConnectionAlive( );
        connection.enableMemoryChangeOnly( );

    }


    public boolean isMemoryChangeOnlyEnabled( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            //we don't synchronize on "enableMemoryChangeLock" here in order to avoid deadlocks, but the 
            //correct visibility of the value is still guaranteed for different threads as the field is volatile
            return connection.isMemoryChangeOnlyEnabled( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    private Collection<ModelPartition> wrapCollectionContent( Collection<ModelPartition> unwrapped ) {

        Set<ModelPartition> result = new LinkedHashSet<ModelPartition>( unwrapped.size( ) );
        for ( ModelPartition partition : unwrapped ) {
            result.add( connection.getWrapperForModelPartition( partition ) );
        }
        return result;
    }



}
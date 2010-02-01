/*
 * Created on 13.12.2005
 */
package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.InvalidSessionException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.consistency.LinkPermissionConsistencyViolation;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionFactory;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EvictionThread;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.core.PartitionsSaveRecord;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.SharedWorkspace;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.cps.parser.CoreParserCallbackImpl;
import com.sap.tc.moin.repository.core.cps.serializer.CoreSerializerCallbackImpl;
import com.sap.tc.moin.repository.core.events.PartitionContentChangeEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionCreateEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionDeleteEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionSaveEventImpl;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiLifecycleManagement;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;
import com.sap.tc.moin.repository.spi.facility.SpiResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiPartitionLoadContext;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiPartitionSaveContext;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiSaveOperation;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;

/**
 * @author d044711
 */
public final class PartitionManagerImpl implements CorePartitionManager {

    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, PartitionManagerImpl.class );

    private static final String INTERNAL_TRANSIENT_PARTITION_PREFIX = "internal-"; //$NON-NLS-1$

    private static final Object[] NULL_OBJECT_ARRAY = new Object[0];

    private final Map<PRI, CoreModelPartition> loadedPartitions = Collections.synchronizedMap( new HashMap<PRI, CoreModelPartition>( ) );

    private final Map<String, Map<PRI, CoreModelPartition>> transientPartitions;

    private final Map<String, Map<PRI, CoreModelPartition>> nullPartitions;

    private final Object loadAndEvictLock = new Object( );

    private ExtentPartition extentPartition;

    private Workspace workspace;

    public PartitionManagerImpl( WorkspaceImpl workspace ) {

        this.workspace = workspace;
        this.transientPartitions = Collections.synchronizedMap( new HashMap<String, Map<PRI, CoreModelPartition>>( ) );
        this.nullPartitions = Collections.synchronizedMap( new HashMap<String, Map<PRI, CoreModelPartition>>( ) );
    }

    public CoreModelPartition getPartitionConsideringDeleted( final CoreSession session, final PRI pri, boolean loadMissing ) {

        CoreModelPartition partition = this.loadedPartitions.get( pri );
        if ( partition == null ) {
            CoreMoin moin = workspace.getWorkspaceSet( ).getMoin( );
            if ( !moin.isSecondStageInjected( ) ) {
                if ( pri.isMetaModelPartition( ) && MoinMofRomServicesImpl.OCL_PARTITION_NAME.equals( pri.getPartitionName( ) ) ) {
                    moin.injectSecondMofRomStage( );
                    return this.loadedPartitions.get( pri );
                }
            }
            if ( loadMissing && !pri.isVolatilePartition( ) ) {
                // The following "synchronized" is necessary because two threads getting the same unresolved partition would 
                // load the partition twice. This results in injecting the same elements twice into the InstanceManager which
                // will then throw an exception that an instance is already hosted. By synchronizing the potential load code,
                // the first thread will trigger the loading of the partition. The second thread will enter the same block 
                // afterwards (once the first thread fully completed the load) but will NOT trigger the load as it is already loaded 
                // by now and the partition will be available in memory in the "loadedPartitions" collection.
                // The "loadedPartitions" collection is a synchronized map, therefore the following code 
                // is NOT the double-checked lock pattern despite looking a little bit like it
		synchronized (this) { // synchronization on this is necessary because a call to
				      // ExtentManagerImpl.selectExtentForPartitionReader
		    // may follow which grabs the lock on this, too. However,
		    synchronized (loadAndEvictLock) {
			partition = this.loadedPartitions.get(pri);
			if (partition != null) {
			    // partition was loaded by another thread in the meantime
			    return partition;
			}
			SpiFacility facility = (SpiFacility) this.workspace.getWorkspaceSet().getMoin()
				.getFacilityById(pri.getDataAreaDescriptor().getFacilityId());
			// enable bulk notification of consistency violations
			this.enableConsistencyViolationBulkNotification();
			// Load the partition from persistence.
			try {
			    if (logger.isTraced(MoinSeverity.DEBUG)) {
				logger
					.traceWithStack(
						MoinSeverity.DEBUG,
						"Starting to load partition \"{0}\" from persistence. Session is \"{1}\".", pri, session); //$NON-NLS-1$
			    }
			    SpiStage stage = this.workspace.getStage(pri.getDataAreaDescriptor());
			    if (stage == null) {
				throw new MoinIllegalStateException(
					CoreImplMessages.COULDNOTGETSTAGEFORDATAAREAFROMWORKSPACE, pri
						.getDataAreaDescriptor(), this.workspace);
			    }
			    partition = this.workspace.getPartitionFactory()
				    .createModelPartition(pri, stage, workspace);
			    final CoreParserCallbackImpl parserCallback = new CoreParserCallbackImpl(moin
				    .getPartitionSerializationManager(), session, partition);
			    SpiPartitionLoadContext loadContext = new SpiPartitionLoadContext() {

				public SpiSession getSession() {

				    return session;
				}

				public SpiParserCallback getParserCallback() {

				    return parserCallback;
				}

				public PRI getPri() {

				    return parserCallback.getPri();
				}

				public void setPersistedTimestamp(long timestamp) {

				    parserCallback.getPartitionToLoad().setPersistedTimestamp(timestamp);
				}

				public SpiStage getStage() {

				    return parserCallback.getPartitionToLoad().getResourceInformation().getStage();
				}

				@Override
				public String toString() {

				    // the PRI which is loaded; stage is ignored
				    PRI pri = parserCallback.getPri();
				    return String.valueOf(pri);
				}

			    };
			    assert holdsLockForLoadOrEvict() : "Thread tries to load partition without having acquired one of the necessary locks"; //$NON-NLS-1$
			    boolean successfullyLoaded = facility.getModelPersistence().loadPartition(loadContext);
			    if (successfullyLoaded) {
				this.addPartition(null, partition);
				partition.markPersisted();
				if (pri.isMetaModelPartition()) {
				    partition.trimToSize();
				}
			    } else {
				// All instances from the InstanceManager that have been injected up to now must be
				// evicted!
				for (Partitionable element : partition.getElements()) {
				    this.workspace.getInstanceManager().evictInstance((CorePartitionable) element);
				}
				if (logger.isTraced(MoinSeverity.DEBUG)) {
				    logger.trace(MoinSeverity.DEBUG, "Couldn't load partition" + partition.getPri()); //$NON-NLS-1$
				}
				return null;
			    }
			    if (logger.isTraced(MoinSeverity.DEBUG)) {
				logger.trace(MoinSeverity.DEBUG,
					"Successfully finished loading of partition, result is: " + partition); //$NON-NLS-1$
			    }
			} finally {
			    // disable bulk notification of consistency violations
			    this.finishConsistencyViolationBulkNotification();
			}
		    }
		}
            }
        }
        return partition;
    }

    private void finishConsistencyViolationBulkNotification( ) {

        if ( this.workspace instanceof SessionWorkspace ) {
            ConsistencyViolationRegistry consistencyViolationRegistry = ( (SessionWorkspace) this.workspace ).getSession( ).getConsistencyViolationRegistry( );
            consistencyViolationRegistry.finishBulkNotification( );
        } else if ( this.workspace instanceof CompoundClientSpecWorkspace ) {
            String clientId = ( (CompoundClientSpecWorkspace) this.workspace ).getCompoundClientSpec( ).getId( );
            for ( CoreSession session : workspace.getWorkspaceSet( ).getSessionsForClientId( clientId ) ) {
                if ( session.isAlive( ) ) {
                    ConsistencyViolationRegistry registry = session.getConsistencyViolationRegistry( );
                    if ( registry != null ) {
                        registry.finishBulkNotification( );
                    }
                }
            }
        }
    }

    private void enableConsistencyViolationBulkNotification( ) {

        if ( this.workspace instanceof SessionWorkspace ) {
            ConsistencyViolationRegistry consistencyViolationRegistry = ( (SessionWorkspace) this.workspace ).getSession( ).getConsistencyViolationRegistry( );
            consistencyViolationRegistry.enableBulkNotification( );
        } else if ( this.workspace instanceof CompoundClientSpecWorkspace ) {
            String clientId = ( (CompoundClientSpecWorkspace) this.workspace ).getCompoundClientSpec( ).getId( );
            for ( CoreSession session : workspace.getWorkspaceSet( ).getSessionsForClientId( clientId ) ) {
                if ( session.isAlive( ) ) {
                    ConsistencyViolationRegistry registry = session.getConsistencyViolationRegistry( );
                    if ( registry != null ) {
                        registry.enableBulkNotification( );
                    }
                }
            }
        }
    }

    public CoreModelPartition getPartition( CoreSession session, final PRI pri, boolean loadMissing ) {

        return this.getPartitionConsideringDeleted( session, pri, loadMissing );
    }

    /**
     * Removes the <tt>partition</tt> from the set of {@link #loadedPartitions}.
     * Note, that this does <em>not</em> unload any instances or links. It just
     * removes the partition from the set of loaded partitions. If the partition
     * is not found in the {@link #loadedPartitions} set, this operation takes
     * no effect.
     */
    public void removePartition( PRI pri ) {

        // cleanup loaded partitions map
        if ( pri != null && this.loadedPartitions.containsKey( pri ) ) {
            CoreModelPartition mp = this.loadedPartitions.get( pri );
            this.loadedPartitions.remove( pri );

            this.workspace.getWorkspaceSet( ).getReferenceManager( ).notifyBeforePartitionEviction( mp );

            // Make sure partition is also removed from the list of dirty partitions.
            clearDirtyFlag( mp );

            mp.setWorkspace( null );

            if ( pri.isVolatilePartition( ) ) {
                if ( pri.isNullPartition( ) ) {
                    this.removeNullPartition( pri );
                } else {
                    this.removeTransientPartition( pri );
                }
            }
        }
    }

    public Collection<CoreModelPartition> getLoadedPartitionsLive( ) {

        return Collections.unmodifiableCollection( this.loadedPartitions.values( ) );
    }

    public Collection<? extends SpiModelPartition> getLoadedPartitions( ) {

        return Utilities.getSnapshotOfCollectionAsList( this.loadedPartitions.values( ) );
    }

    /**
     * Adds a partition to the set of {@link #loadedPartitions}. Note, that this
     * does not add any instances or links to this workspace. It just records
     * that this workspace has "loaded" the <tt>partition</tt>.
     * <p>
     * 
     * @param partition The partition to add to the set of loaded partitions. If
     * {@link #loadedPartitions} already contains a partition with equal
     * {@link #metadata}, that partition is replaced.
     */
    public void addPartition( CoreConnection connection, CoreModelPartition partition ) {

        if ( partition != null && !this.loadedPartitions.containsKey( partition.getPri( ) ) ) {
            this.loadedPartitions.put( partition.getPri( ), partition );
            if ( ( partition.getPri( ).isVolatilePartition( ) ) && !partition.isExtentPartition( ) ) {

                if ( partition.getPri( ).isNullPartition( ) ) {
                    addNullPartition( connection, partition );
                } else {
                    addTransientPartition( connection, partition );
                }
            }
        }
    }

    public CoreModelPartition getNullPartition( CoreConnection connection ) {

        return this.getOrCreateTransientPartition( "", connection, true, false ); //$NON-NLS-1$
    }

    public CoreModelPartition getOrCreateTransientPartition( String partitionName, CoreConnection connection ) {

        return this.getOrCreateTransientPartition( partitionName, connection, false, false );
    }

    public CoreModelPartition getOrCreateTransientPartitionNonTransactional( String partitionName, CoreConnection connection ) {

        return this.getOrCreateTransientPartition( partitionName, connection, false, true );

    }

    public boolean isLegalPartitionNameForTransientPartition( String partitionName ) {

        if ( partitionName == null || partitionName.equals( "" ) ) { //$NON-NLS-1$
            return false;
        }
        for ( int i = 0; i < partitionName.length( ); i++ ) {
            char c = partitionName.charAt( i );
            if ( !( ( c >= 'A' && c <= 'Z' ) || ( c >= 'a' && c <= 'z' ) || ( Character.isDigit( c ) ) || ( c == '_' ) ) ) {
                return false;
            }
        }

        return true;
    }

    public void assertLegalPartitionNameForTransientPartition( String partitionName ) {

        if ( !isLegalPartitionNameForTransientPartition( partitionName ) ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.PARTITIONNAMEISILLEGAL, partitionName );
        }
    }

    private CoreModelPartition getOrCreateTransientPartition( String partitionName, CoreConnection connection, boolean nullPartition, boolean nonTransactional ) {

        boolean legalPartitionName = true;
        if ( nonTransactional ) {
            assertLegalPartitionNameForTransientPartition( partitionName );
        } else if ( nullPartition ) {
            legalPartitionName = true;
        } else {
            legalPartitionName = isLegalPartitionNameForTransientPartition( partitionName );
        }

        PRI transientPartitionPri = null;
        CoreModelPartition transientPartition = null;
        DataAreaDescriptor dataAreaDescriptor = connection.getTargetDataArea( ).getDescriptor( );

        if ( legalPartitionName ) {

            Facility facility = this.workspace.getWorkspaceSet( ).getCompoundDataArea( ).getDataArea( dataAreaDescriptor ).getFacility( );
            SpiResourceIdentifierFactory riFactory = (SpiResourceIdentifierFactory) facility.getRIFactory( );

            String partitionNameForRiFactory;
            if ( nullPartition ) {
                partitionNameForRiFactory = connection.getId( ) + partitionName;
                transientPartitionPri = riFactory.createNullPri( dataAreaDescriptor, partitionNameForRiFactory );
                transientPartition = this.getNullPartition( connection, transientPartitionPri );
            } else {

                if ( nonTransactional ) {
                    partitionNameForRiFactory = connection.getId( ) + INTERNAL_TRANSIENT_PARTITION_PREFIX + partitionName;
                } else {
                    partitionNameForRiFactory = connection.getId( ) + partitionName;
                }
                transientPartitionPri = riFactory.createVolatilePri( dataAreaDescriptor, partitionNameForRiFactory );
                transientPartition = this.getTransientPartition( connection, transientPartitionPri );

            }
        }

        // cleanup deleted partitions
        if ( transientPartition != null && !transientPartition.isAlive( ) ) {
            this.removePartition( transientPartition.getPri( ) );
            transientPartition = null;
        }

        // create partition if not already there
        if ( transientPartition == null ) {
            SpiStage stage = this.workspace.getStage( dataAreaDescriptor );
            if ( stage == null && nonTransactional ) {
                throw new MoinIllegalStateException( CoreImplMessages.COULDNOTGETSTAGEFORDATAAREAFROMWORKSPACE, dataAreaDescriptor, this.workspace );
            }

            if ( nullPartition || nonTransactional ) {
                transientPartition = this.workspace.getPartitionFactory( ).createTransientPartitionNonTransactional( connection, transientPartitionPri, stage );
            } else {
                transientPartition = this.workspace.getPartitionFactory( ).createTransientPartition( connection, transientPartitionPri, stage, partitionName );
            }

        }

        return transientPartition;

    }

    private void addTransientPartition( CoreConnection connection, CoreModelPartition transientPartition ) {

        Map<PRI, CoreModelPartition> transientPartitionsForConnection = this.transientPartitions.get( connection.getId( ) );
        if ( transientPartitionsForConnection == null ) {
            transientPartitionsForConnection = Collections.synchronizedMap( new HashMap<PRI, CoreModelPartition>( ) );
            this.transientPartitions.put( connection.getId( ), transientPartitionsForConnection );
        }
        transientPartitionsForConnection.put( transientPartition.getPri( ), transientPartition );
    }

    private void addNullPartition( CoreConnection connection, CoreModelPartition transientPartition ) {

        Map<PRI, CoreModelPartition> transientPartitionsForConnection = this.nullPartitions.get( connection.getId( ) );
        if ( transientPartitionsForConnection == null ) {
            transientPartitionsForConnection = Collections.synchronizedMap( new HashMap<PRI, CoreModelPartition>( ) );
            this.nullPartitions.put( connection.getId( ), transientPartitionsForConnection );
        }
        transientPartitionsForConnection.put( transientPartition.getPri( ), transientPartition );
    }

    private CoreModelPartition getTransientPartition( Connection connection, PRI pri ) {

        Map<PRI, CoreModelPartition> transientPartitionsForConnection = this.transientPartitions.get( connection.getId( ) );
        if ( transientPartitionsForConnection != null ) {
            return transientPartitionsForConnection.get( pri );
        }
        return null;
    }

    private CoreModelPartition getNullPartition( Connection connection, PRI pri ) {

        Map<PRI, CoreModelPartition> transientPartitionsForConnection = this.nullPartitions.get( connection.getId( ) );
        if ( transientPartitionsForConnection != null ) {
            return transientPartitionsForConnection.get( pri );
        }
        return null;
    }

    private void removeTransientPartition( PRI pri ) {

        Set<Entry<String, Map<PRI, CoreModelPartition>>> entrySet = this.transientPartitions.entrySet( );
        for ( Entry<String, Map<PRI, CoreModelPartition>> entry : entrySet ) {
            Map<PRI, CoreModelPartition> transientPartitionsForConnection = entry.getValue( );
            transientPartitionsForConnection.remove( pri );
            if ( transientPartitionsForConnection.isEmpty( ) ) {
                this.transientPartitions.remove( entry.getKey( ) );
            }
        }
    }

    private void removeNullPartition( PRI pri ) {

        Set<Entry<String, Map<PRI, CoreModelPartition>>> entrySet = this.nullPartitions.entrySet( );
        for ( Entry<String, Map<PRI, CoreModelPartition>> entry : entrySet ) {
            Map<PRI, CoreModelPartition> transientPartitionsForConnection = entry.getValue( );
            transientPartitionsForConnection.remove( pri );
            if ( transientPartitionsForConnection.isEmpty( ) ) {
                this.nullPartitions.remove( entry.getKey( ) );
            }
        }
    }

    public Collection<CoreModelPartition> getTransientPartitions( CoreConnection connection ) {

        Collection<CoreModelPartition> result = null;
        Map<PRI, CoreModelPartition> transientPartitionsForConnection = this.transientPartitions.get( connection.getId( ) );
        if ( transientPartitionsForConnection != null ) {
            result = transientPartitionsForConnection.values( );
        }

        if ( result == null ) {
            result = Collections.emptyList( );
        }

        return result;
    }

    public Collection<CoreModelPartition> getAllTransientPartitions( ) {

        Collection<CoreModelPartition> result = new ArrayList<CoreModelPartition>( );
        Collection<Map<PRI, CoreModelPartition>> values = transientPartitions.values( );
        for ( Map<PRI, CoreModelPartition> map : values ) {
            Collection<CoreModelPartition> partitions = map.values( );
            result.addAll( partitions );
        }

        return result;
    }

    public ExtentPartition getExtentPartition( ) {

        if ( this.extentPartition == null ) {
            // Extent partition can only be created for a CorePartitionManager in a Metamodel Workspace
            if ( this.workspace.getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ) == this.workspace ) {
                SpiStage metaModelStage = ( (SharedWorkspace) this.workspace ).getStage( );
                DataAreaDescriptor metaModelDataAreaDescriptor = metaModelStage.getDataAreaDescriptor( );
                Facility facility = this.workspace.getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ).getMetamodelDataArea( ).getFacility( );
                SpiResourceIdentifierFactory riFactory = (SpiResourceIdentifierFactory) facility.getRIFactory( );
                PRI pri = riFactory.createVolatilePri( metaModelDataAreaDescriptor, CorePartitionFactory.EXTENT_PARTITION_NAME );
                this.extentPartition = (ExtentPartition) this.workspace.getPartitionFactory( ).createExtentPartition( pri, metaModelStage );
            } else {
                throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.EXTENTPARTITIONONLYAVAILABLEATMMWORKSPACE );
            }

            this.loadedPartitions.put( this.extentPartition.getPri( ), this.extentPartition );
        }
        return this.extentPartition;
    }

    /**
     * Is called when a connection is closed/garbage collected. The context
     * object is the getId() of the Connection.
     */
    public void notifyOnObjectRemoved( boolean garbageCollected, Object context ) {

        // context is Connection.getId()
        this.transientPartitions.remove( context );
        this.nullPartitions.remove( context );
    }



    public void evictPartition( CoreModelPartition mp ) {

        if ( canEvict( mp ) ) {
            this.evictPartitionInternal( mp );
        }
    }



    public void evictPartitionForced( CoreModelPartition partition ) {

        SynchronizationManager syncManager = this.workspace.getWorkspaceSet( ).getSynchronizationManager( );
        synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {
            syncManager.acquireMicroWriteLock( );
            try {
                if ( partition.isDirty( ) && !partition.getPri( ).isVolatilePartition( ) ) {
                    PartitionLockManager lockManager = partition.getWorkspace( ).getWorkspaceSet( ).getLockManager( );
                    CoreConnection lockingConnection = (CoreConnection) lockManager.getLockOwner( partition.getPri( ) );
                    if ( lockingConnection != null ) {
                        if ( partition.isPersisted( ) ) {
                            // Release the partition lock.
                            lockManager.releaseLock( partition.getPri( ), lockingConnection );
                            // Notify the PartitionChangeRecorder of the locking connection to make sure that a potential delta
                            // for this partition gets dropped.
                            lockingConnection.getPartitionChangeRecorder( ).dirtyPartitionEvicted( partition );
                        }
                    }
                }

                this.evictPartitionInternal( partition );
                clearDirtyFlag( partition );

            } finally {
                syncManager.releaseMicroWriteLock( );
            }
        }
    }

    private void clearDirtyFlag( CoreModelPartition partition ) {

        if ( workspace instanceof SessionWorkspace && !partition.getPri( ).isVolatilePartition( ) && partition.isDirty( ) ) {
            // Important: the isVolatilePartition() call above must precede the isDirty() call! Otherwise the evictPartitionForced()
            // called by ConnectionImpl.revert() to evict the null partition will fail.
            CoreSession session = ( (SessionWorkspace) workspace ).getSession( );
            for ( CoreConnection connection : session.getConnections( ) ) {
                partition.clearDirty( connection );
            }
        }
    }

    private void evictPartitionInternal( CoreModelPartition mp ) {

        if ( mp != null ) {
            assert holdsLockForLoadOrEvict( ) : "Thread tries to evict partition without having acquired one of the necessary locks"; //$NON-NLS-1$
            synchronized ( loadAndEvictLock ) {
                //the synchronization is needed in order to avoid inconsistent structures in the core
                //it must be avoided that two threads concurrently "load" respectively "evict" a partition
                //otherwise it could be that the PartitionManager no longer knows about the evicted partition
                //whereas there could be instances in the InstanceManager injected  by the "loading" thread
                if ( isPartitionLoaded( mp.getPri( ) ) ) {
                    PRI pri = mp.getPri( );
                    // Need to compute partition elements before evicting links because compositions implicitly define partition pertinence.
                    Collection<Partitionable> elementsFromPartition = mp.getElements( );
                    int elements = 0;
                    int links = 0;
                    long t = 0;
                    String sessionId = null;
                    final EvictionThread evictionThread = this.workspace.getWorkspaceSet( ).getMoin( ).getEvictionThread( );
                    boolean jmxInfoWanted = JMX_ENABLED && evictionThread != null && evictionThread.isJmxTraceEnabled( );
                    boolean debugInfoWanted = logger.isTraced( MoinSeverity.DEBUG );
                    if ( debugInfoWanted || jmxInfoWanted ) {
                        t = System.nanoTime( );
                        elements = elementsFromPartition.size( );
                        links = mp.getLinks( ).size( );
                        Workspace ws = mp.getWorkspace( );
                        if ( ws instanceof SessionWorkspace ) {
                            sessionId = ( (SessionWorkspace) ws ).getSession( ).toString( );
                        }
                        if ( jmxInfoWanted ) {
                            //evictionThread cannot be null -> that's implicit if jmxInfoWanted == true
                            evictionThread.traceEvictPartitionStart( pri, sessionId, Thread.currentThread( ).getStackTrace( ) );
                        }
                        if ( debugInfoWanted ) {
                            logger.traceWithStack( MoinSeverity.DEBUG, "Start evict partition: " + pri + " ; Session Id: " + sessionId ); //$NON-NLS-1$ //$NON-NLS-2$
                        }
                    }
                    // Remove all links solely owned by mp. Doing this before evicting the instances is necessary to keep MRIs computable.
                    this.workspace.getMemoryLinkManager( ).evictLinksAndInvalidateJmiLists( mp );
                    // remove all instances of mp from the set of instances:
                    for ( Iterator<Partitionable> i = elementsFromPartition.iterator( ); i.hasNext( ); ) {
                        CorePartitionable me = (CorePartitionable) i.next( );
                        this.workspace.getInstanceManager( ).evictInstance( me );
                    }
                    removePartition( pri );
                    if ( workspace instanceof SessionWorkspace ) {
                        // If we have a client specific workspace, we empty the PRI cache of its session.
                        CoreSession session = ( (SessionWorkspace) workspace ).getSession( );
                        Map<CRI, Collection<PRI>> cachePartitionsInContainer = session.getCachePartitionsInContainer( );
                        if ( cachePartitionsInContainer != null ) {
                            cachePartitionsInContainer.remove( pri.getCri( ) );
                        }
                        CompoundClientSpecWorkspace compoundClientSpecWorkspace = session.getCompoundClientSpecWorkspace( );
                        if ( compoundClientSpecWorkspace != null ) {
                            compoundClientSpecWorkspace.privateCopyRemoved( pri );
                        }
                    }
                    long duration = 0l;
                    if ( jmxInfoWanted || debugInfoWanted ) {
                        duration = ( System.nanoTime( ) - t ) / 1000000;
                    }
                    if ( jmxInfoWanted ) {
                        //evictionThread cannot be null -> that's implicit if jmxInfoWanted == true
                        evictionThread.traceEvictPartitionEnd( pri, sessionId, elements, links, duration );
                    }
                    if ( debugInfoWanted ) {
                        logger.trace( MoinSeverity.DEBUG, "End evict partition: " + pri + " ; Session Id: " + sessionId + " ; Elements: " + elements + "; Links: " + links + " ; Duration: " + duration ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                    }
                }
            }
        }
    }

    /**
     * Checks if the <tt>partition</tt> specified can be evicted from this
     * workspace. Criteria may include whether a transaction is currently
     * running that has accessed model elements from the partition, or whether
     * the partition is currently modified.
     * <p>
     * This dummy implementation currently only considers if the given partition
     * is dirty.
     */
    public boolean canEvict( ModelPartition mp ) {

        if ( mp == null ) {
            throw new MoinIllegalArgumentException( RepositoryCoreMessages.MOIN_1009 );
        }

        if ( mp.isDirty( ) ) {
            return false;
        }

        // TODO implement based on reasonable criteria; see JavaDocs
        return true;
    }

    /**
     * Tells if a model partition is currently loaded. The model partition is
     * identified by {@link Object}, because
     * 
     * @param modelPartition
     * @return
     */
    public boolean isPartitionLoaded( PRI modelPartition ) {

        return this.loadedPartitions.containsKey( modelPartition );
    }

    public Workspace getWorkspace( ) {

        return this.workspace;
    }

    public void destroy( ) {

        final EvictionThread evictionThread = this.workspace.getWorkspaceSet( ).getMoin( ).getEvictionThread( );

        if ( evictionThread != null ) {
            Collection<? extends SpiModelPartition> tempLoadedPartitions = getLoadedPartitions( );
            for ( SpiModelPartition loadedPartition : tempLoadedPartitions ) {
                evictPartitionInternal( (CoreModelPartition) loadedPartition );
            }
        }
    }

    public void evictPartitionsForced( List<PRI> pris ) {

        evictPartitionsInternal( pris, true );
    }

    public void evictPartitions( List<PRI> pris ) {

        evictPartitionsInternal( pris, false );
    }

    private void evictPartitionsInternal( List<PRI> pris, boolean forced ) {

        for ( int i = 0, size = pris.size( ); i < size; i++ ) {
            PRI pri = pris.get( i );
            evictPartitionInternal( pri, forced );
        }
    }

    private void evictPartitionInternal( PRI pri, boolean forced ) {

        if ( isPartitionLoaded( pri ) ) {
            CoreModelPartition partition = this.loadedPartitions.get( pri );
            if ( forced ) {
                this.evictPartitionForced( partition );
            } else {
                this.evictPartition( partition );
            }
        }
    }

    public void evictPartition( PRI pri ) {

        evictPartitionInternal( pri, false /* forced */);
    }

    /*
     * #####################################################################
     * #####################################################################
     * ########################## Partition save ###########################
     * #####################################################################
     * #####################################################################
     */
    public void savePartitionsOfConnection( CoreConnection connection ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        assert this.workspace == connection.getSession( ).getWorkspace( ) : "Saving not allowed on non-client-specific workspaces"; //$NON-NLS-1$

        CoreSession session = connection.getSession( );
        // Check if session has been closed in the meantime
        if ( session == null ) {
            throw new InvalidSessionException( JmiCoreMessages.SESSIONISINVALID );
        }

        // see comment at the break statement below.
        while ( true ) {

            Map<SpiFacility, PartitionsSaveRecord> affectedPartitions = this.computePartitionSaveRecords( connection.getDirtyPartitionsWithoutNullPartition( ) );

            Map<SpiFacility, Object> lockHandle = null;

            try {

                lockHandle = this.workspace.getWorkspaceSet( ).getSynchronizationManager( ).acquireFacilityLocks( affectedPartitions );

                synchronized ( this.workspace.getWorkspaceSet( ).getSynchronizationManager( ).getProhibitWriteSyncObject( ) ) {

                    // check if the state has been manipulated while locks have been acquired.
                    // see comment at the break statement below.
                    Map<SpiFacility, PartitionsSaveRecord> partitionOperations = this.computePartitionSaveRecords( connection.getDirtyPartitionsWithoutNullPartition( ) );

                    if ( partitionOperations != null ) {
                        if ( partitionOperations.equals( affectedPartitions ) ) {
                            // there must be no command running
                            this.ensureNoCommandRunningInConnection( connection );

                            // the NullPartition of this connection must be empty, otherwise
                            // saving is not allowed
                            this.ensureNullPartitionIsEmpty( connection );

                            // Check if the "ensure" state that was determined during commands is still valid 
                            this.ensurePartitionChangesStillAllowed( partitionOperations, session );

                            // there must be no links from persistent to transient partitions
                            this.ensureNoLinksToTransientPartition( connection );

                            // save all modified partitions and release their locks
                            Map<PRI, Throwable> failedSaves = this.saveDirtyPartitionsAndReleaseLocks( partitionOperations, lockHandle, connection );

                            // inform client by throwing exception which partitions couldn't be
                            // saved.
                            this.handleNotSavedPartitions( failedSaves );

                            // This construct is needed to avoid deadlocks between facility locking mechanisms and core locking.
                            // We know this code smells, but we don't know a better solution.
                            break;
                        }
                    }
                }
            } finally {
                this.workspace.getWorkspaceSet( ).getSynchronizationManager( ).releaseFacilityLocks( lockHandle );
            }
        }
    }

    private Map<SpiFacility, PartitionsSaveRecord> computePartitionSaveRecords( Collection<CoreModelPartition> partitions ) {

        Map<SpiFacility, PartitionsSaveRecord> ret = new HashMap<SpiFacility, PartitionsSaveRecord>( );

        WorkspaceSet workspaceSet = this.workspace.getWorkspaceSet( );

        for ( CoreModelPartition partition : partitions ) {
            PRI pri = partition.getPri( );
            SpiFacility facility = (SpiFacility) workspaceSet.getCompoundDataArea( ).getDataArea( pri.getDataAreaDescriptor( ) ).getFacility( );
            PartitionsSaveRecord partitionsSaveRecord = this.getPartitionSaveRecordForFacility( facility, ret );

            if ( partition.isAlive( ) ) {
                if ( partition.isPersisted( ) ) {
                    // edit
                    partitionsSaveRecord.editedPartitions.add( partition );
                } else {
                    // create
                    partitionsSaveRecord.addedPartitions.add( partition );
                }
            } else {
                // delete
                partitionsSaveRecord.deletedPartitions.add( partition );
            }
        }

        return ret;
    }

    private PartitionsSaveRecord getPartitionSaveRecordForFacility( SpiFacility facility, Map<SpiFacility, PartitionsSaveRecord> facilityToPartitionsSaveRecord ) {

        PartitionsSaveRecord partitionsSaveRecord = facilityToPartitionsSaveRecord.get( facility );
        if ( partitionsSaveRecord == null ) {
            partitionsSaveRecord = new PartitionsSaveRecord( );
            facilityToPartitionsSaveRecord.put( facility, partitionsSaveRecord );
        }
        return partitionsSaveRecord;
    }

    private void ensureNoCommandRunningInConnection( CoreConnection connection ) {

        // there must be no command running
        if ( connection.getCommandStack( ).getState( ).isRunning( ) ) {
            throw new MoinIllegalStateException( CoreImplMessages.ILLEGALCALLTOCONNECTIONWHILECOMMANDISRUNNING );
        }
    }

    /**
     * Checks if the null partition attached to this connection is empty. It can
     * only be saved if it is empty because otherwise the saved model could be
     * inconsistent as the elements in the null partition are not saved as the
     * null partition is never saved.
     * 
     * @throws NullPartitionNotEmptyException if the transient partition is not
     * empty
     */
    private void ensureNullPartitionIsEmpty( CoreConnection connection ) throws NullPartitionNotEmptyException {

        CoreModelPartition transientPartition;
        transientPartition = this.getNullPartition( connection );
        if ( !transientPartition.isEmpty( ) ) {
            // if the transient partition still contains elements, saving is not
            // possible
            throw new NullPartitionNotEmptyException( connection.getWrapperForModelPartition( transientPartition ) );
        }
    }

    private void ensurePartitionChangesStillAllowed( Map<SpiFacility, PartitionsSaveRecord> partitionSaveRecords, CoreSession session ) {

        // The intention of the "ensure" calls is to make the operation (create, edit, delete) possible (e.g. check out a file).
        // The "ensure" calls return "false" in case the operation couldn't be made possible.
        // If the return value is "false", an error handling would be required here, however we assume
        // that the real "save" will then fail, and the powerful error handling there will provide useful traces.

        for ( Entry<SpiFacility, PartitionsSaveRecord> e : partitionSaveRecords.entrySet( ) ) {
            PartitionsSaveRecord saveRecord = e.getValue( );

            SpiLifecycleManagement lifecycleManagement = e.getKey( ).getLifecycleManagement( );
            PRI pri;

            for ( CoreModelPartition partition : saveRecord.addedPartitions ) {
                pri = partition.getPri( );
                DataAreaDescriptor dataAreaDescriptor = pri.getDataAreaDescriptor( );
                SpiClientSpec clientSpec = (SpiClientSpec) session.getCompoundClientSpec( ).getClientSpec( dataAreaDescriptor );
                try {
                    lifecycleManagement.ensureCreatingAllowed( pri, clientSpec );
                } catch ( RuntimeException ex ) {
                    // Save shall always proceed even if some partitions have problems, e.g. concerning life cycle management.
                    if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                        logger.trace( ex, MoinSeverity.DEBUG, "Connection save for partition creation will continue despite of problems in life cycle management: " + pri, NULL_OBJECT_ARRAY ); //$NON-NLS-1$
                    }
                    continue;
                }
            }

            for ( CoreModelPartition partition : saveRecord.deletedPartitions ) {
                pri = partition.getPri( );
                DataAreaDescriptor dataAreaDescriptor = pri.getDataAreaDescriptor( );
                SpiClientSpec clientSpec = (SpiClientSpec) session.getCompoundClientSpec( ).getClientSpec( dataAreaDescriptor );
                try {
                    lifecycleManagement.ensureDeletingAllowed( pri, clientSpec );
                } catch ( RuntimeException ex ) {
                    // Save shall always proceed even if some partitions have problems, e.g. concerning life cycle management.
                    if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                        logger.trace( ex, MoinSeverity.DEBUG, "Connection save for partition deletion will continue despite of problems in life cycle management: " + pri, NULL_OBJECT_ARRAY ); //$NON-NLS-1$
                    }
                    continue;
                }
            }

            for ( CoreModelPartition partition : saveRecord.editedPartitions ) {
                pri = partition.getPri( );
                DataAreaDescriptor dataAreaDescriptor = pri.getDataAreaDescriptor( );
                SpiClientSpec clientSpec = (SpiClientSpec) session.getCompoundClientSpec( ).getClientSpec( dataAreaDescriptor );
                try {
                    lifecycleManagement.ensureEditingAllowed( pri, clientSpec );
                } catch ( RuntimeException ex ) {
                    // Save shall always proceed even if some partitions have problems, e.g. concerning life cycle management.
                    if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                        logger.trace( ex, MoinSeverity.DEBUG, "Connection save for partition modification will continue despite of problems in life cycle management: " + pri, NULL_OBJECT_ARRAY ); //$NON-NLS-1$
                    }
                    continue;
                }
            }
        }
    }

    private void ensureNoLinksToTransientPartition( CoreConnection connection ) {

        if ( connection.hasReferencedTransientElements( ) ) {
            throw new ReferencedTransientElementsException( RepositoryCoreMessages.TRANSIENTELEMENTREFERENCED );
        }
    }

    private void createEventsAndFilterVetoedPartition( Collection<CoreModelPartition> partitions, SpiSaveOperation operation, CoreConnection connection, Map<PRI, PartitionSaveEvent> partitionSaveEvents, Map<PRI, PartitionChangeEvent> crossSessionPartitionEvents ) {

        SpiEventManager eventManager = connection.getSession( ).getEventManager( );
        PartitionSaveEvent saveEvent;
        PartitionChangeEvent changeEvent;

        for ( Iterator<CoreModelPartition> it = partitions.iterator( ); it.hasNext( ); ) {
            CoreModelPartition partition = it.next( );

            try {
                // create save event and check if someone vetoes the save of the partition
                saveEvent = new PartitionSaveEventImpl( connection, partition );
                eventManager.firePreChangeEvent( saveEvent ); // may rise VetoException

                // proceed if there is no veto
                partitionSaveEvents.put( partition.getPri( ), saveEvent );
                switch ( operation ) {
                    case ADD:
                        changeEvent = new PartitionCreateEventImpl( connection, partition.getPri( ) );
                        break;
                    case EDIT:
                        changeEvent = new PartitionContentChangeEventImpl( connection, partition.getPri( ) );
                        break;
                    case DELETE:
                        changeEvent = new PartitionDeleteEventImpl( connection, partition.getPri( ) );
                        break;
                    default:
                        throw new MoinIllegalArgumentException( CoreImplMessages.UNEXPECTEDSAVEOPERATIONTYPE, operation );
                }
                crossSessionPartitionEvents.put( partition.getPri( ), changeEvent );
            } catch ( VetoException e ) {
                // if we get a veto remove the partition from the partition list
                it.remove( );
            }
        }
    }

    private Map<PRI, Throwable> saveDirtyPartitionsAndReleaseLocks( Map<SpiFacility, PartitionsSaveRecord> partitionsPerFacility, Map<SpiFacility, Object> lockHandle, CoreConnection connection ) {

        Map<PRI, PartitionSaveEvent> partitionSaveEvents = new HashMap<PRI, PartitionSaveEvent>( );
        Map<PRI, PartitionChangeEvent> crossSessionPartitionEvents = new HashMap<PRI, PartitionChangeEvent>( );

        SpiEventManager eventManager = connection.getSession( ).getEventManager( );
        eventManager.beginUpdate( connection );//deliverUpdate is done within executeFinalSaveActions()

        // create and prefire events 
        for ( PartitionsSaveRecord saveRecord : partitionsPerFacility.values( ) ) {
            this.createEventsAndFilterVetoedPartition( saveRecord.addedPartitions, SpiSaveOperation.ADD, connection, partitionSaveEvents, crossSessionPartitionEvents );
            this.createEventsAndFilterVetoedPartition( saveRecord.editedPartitions, SpiSaveOperation.EDIT, connection, partitionSaveEvents, crossSessionPartitionEvents );
            this.createEventsAndFilterVetoedPartition( saveRecord.deletedPartitions, SpiSaveOperation.DELETE, connection, partitionSaveEvents, crossSessionPartitionEvents );
        }

        Map<PRI, Throwable> failedSaves = this.doSave( partitionsPerFacility, lockHandle, connection );

        // nothing left to be saved, do the final actions
        // handle events, partition locks, Copy-On-Write ...
        this.executeFinalSaveActions( partitionSaveEvents.values( ), crossSessionPartitionEvents.values( ), connection, failedSaves );

        return failedSaves;
    }

    private Map<PRI, Throwable> doSave( Map<SpiFacility, PartitionsSaveRecord> partitionsPerFacility, Map<SpiFacility, Object> lockHandle, CoreConnection connection ) {

        Map<PRI, Throwable> failed = new LinkedHashMap<PRI, Throwable>( 0 );

        for ( Entry<SpiFacility, PartitionsSaveRecord> entry : partitionsPerFacility.entrySet( ) ) {

            SpiFacility facility = entry.getKey( );

            PartitionsSaveRecord facilitySaveRecord = entry.getValue( );

            Collection<SpiPartitionSaveContext> toSave = this.createSaveContexts( facilitySaveRecord.addedPartitions, SpiSaveOperation.ADD, connection );
            Collection<SpiPartitionSaveContext> toEdit = this.createSaveContexts( facilitySaveRecord.editedPartitions, SpiSaveOperation.EDIT, connection );
            Collection<SpiPartitionSaveContext> toDelete = this.createSaveContexts( facilitySaveRecord.deletedPartitions, SpiSaveOperation.DELETE, connection );

            // DO THE REAL SAVE
            try {
                facility.getModelPersistence( ).savePartitions( toSave, toEdit, toDelete, lockHandle.get( facility ) );

                this.postProcessPartitions( toSave, failed );
                this.postProcessPartitions( toEdit, failed );
                this.postProcessPartitions( toDelete, failed );
            } catch ( RuntimeException e ) {
                logger.trace( e, MoinSeverity.ERROR, "Model partition save failed due to exception in facility {0}", facility ); //$NON-NLS-1$

                // The facility throws an exception we omit the events.
                for ( CoreModelPartition partition : facilitySaveRecord.addedPartitions ) {
                    failed.put( partition.getPri( ), e );
                }
                for ( CoreModelPartition partition : facilitySaveRecord.editedPartitions ) {
                    failed.put( partition.getPri( ), e );
                }
                for ( CoreModelPartition partition : facilitySaveRecord.deletedPartitions ) {
                    failed.put( partition.getPri( ), e );
                }
            }
        }
        partitionsPerFacility.clear( );

        return failed;
    }

    private void postProcessPartitions( Collection<SpiPartitionSaveContext> partitionContexts, Map<PRI, Throwable> failedSaves ) {

        if ( partitionContexts != null ) {
            for ( SpiPartitionSaveContext saveContext : partitionContexts ) {
                if ( saveContext.hasFailed( ) ) {
                    PRI pri = saveContext.getPri( );
                    Throwable reason = saveContext.getFailedReason( );
                    logger.trace( reason, MoinSeverity.ERROR, "The partition {0} could not be saved", new Object[] { pri } ); //$NON-NLS-1$
                    failedSaves.put( pri, reason );
                } else {
                    PartitionSaveContextImpl sc = (PartitionSaveContextImpl) saveContext;
                    switch ( saveContext.getOperation( ) ) {
                        case ADD:
                        case EDIT:
                            this.partitionStored( sc.partition, sc.connection, sc.delta );
                            break;
                        case DELETE:
                            this.partitionDeleted( sc.partition, sc.connection );
                            break;
                        default:
                            throw new MoinIllegalArgumentException( CoreImplMessages.UNEXPECTEDOPERATIONTYPE, saveContext.getOperation( ) );
                    }
                }
            }
        }
    }

    private Collection<SpiPartitionSaveContext> createSaveContexts( Collection<CoreModelPartition> partitions, SpiSaveOperation operation, CoreConnection connection ) {

        if ( partitions == null || partitions.isEmpty( ) ) {
            return null;
        }
        Collection<SpiPartitionSaveContext> result = new ArrayList<SpiPartitionSaveContext>( partitions.size( ) );
        for ( CoreModelPartition partition : partitions ) {
            // (Axel Uhl, d043530) trying without delta calculation for partition deletions; so far, tests still seem to run
            SpiPartitionDelta delta;
            if (operation == SpiSaveOperation.DELETE) {
        	delta = null;
            } else {
        	delta = connection.getPartitionChangeRecorder( ).getDeltaForPartition( partition );
            }
            SpiSerializerCallback callback = new CoreSerializerCallbackImpl( connection.getSession( ), partition );
            result.add( new PartitionSaveContextImpl( connection, partition, callback, delta, operation ) );
        }
        return result;
    }

    private static final class PartitionSaveContextImpl implements SpiPartitionSaveContext {

        private CoreConnection connection;

        private CoreModelPartition partition;

        private SpiSerializerCallback serializerCallback;

        private SpiPartitionDelta delta;

        private SpiSaveOperation operation;

        private Throwable failInfo;

        public PartitionSaveContextImpl( CoreConnection _connection, CoreModelPartition _partition, SpiSerializerCallback callback, SpiPartitionDelta _delta, SpiSaveOperation _operation ) {

            this.connection = _connection;
            this.partition = _partition;
            this.serializerCallback = callback;
            this.delta = _delta;
            this.operation = _operation;
        }

        public SpiSaveOperation getOperation( ) {

            return this.operation;
        }

        public SpiPartitionDelta getPartitionDelta( ) {

            return this.delta;
        }

        public long getPersistedTimestamp( ) {

            return this.partition.getPersistedTimestamp( );
        }

        public PRI getPri( ) {

            return partition.getPri( );
        }

        public SpiSerializerCallback getSerializerCallback( ) {

            return this.serializerCallback;
        }

        public SpiStage getStage( ) {

            return this.partition.getResourceInformation( ).getStage( );
        }

        public boolean hasTranslatableTexts( ) {

            // check the partition for texts
            CoreSession session = connection.getSession( );
            // search for at least one class with an attribute of type TranslatableText with valid content
            Collection<Partitionable> elements = partition.getElements( );
            SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
            for ( Partitionable element : elements ) {
                if ( element instanceof RefObject && ( (RefObject) element ).refMetaObject( ) instanceof MofClass ) {
                    MofClass clazz = (MofClass) ( (RefObject) element ).refMetaObject( );
                    List<Attribute> translatableTextFragmentAttributes = jmiHelper.getTranslatableTextFragmentAttributes( session, clazz );
                    for ( Attribute attribute : translatableTextFragmentAttributes ) {
                        int attributeUpperBound = attribute.getMultiplicity( ).getUpper( );
                        if ( attributeUpperBound == MULTIPLICITY_BOUND_INFINITE || attributeUpperBound > 1 ) {
                            // multi-valued attribute
                            Collection<RefStructImpl> attributeValues = (Collection<RefStructImpl>) ( (RefObjectImpl) element ).refGetValue( connection, attribute.getName( ) );
                            if ( attributeValues != null ) {
                                for ( RefStructImpl attributeValue : attributeValues ) {
                                    String originalText = null;
                                    if ( attributeValue != null && ( originalText = (String) attributeValue.refGetValue( "originalText" ) ) != null && originalText.length( ) != 0 ) { //$NON-NLS-1$
                                        return true;
                                    }
                                }
                            }
                        } else {
                            // single-valued attribute
                            RefStructImpl attributeValue = (RefStructImpl) ( (RefObjectImpl) element ).refGetValue( connection, attribute.getName( ) );
                            String originalText = null;
                            if ( attributeValue != null && ( originalText = (String) attributeValue.refGetValue( "originalText" ) ) != null && originalText.length( ) != 0 ) { //$NON-NLS-1$
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        public boolean isPartitionPersisted( ) {

            return partition.isPersisted( );
        }

        public void setPersistedTimestamp( long timestamp ) {

            this.partition.setPersistedTimestamp( timestamp );
        }

        public void signalFail( Throwable t ) {

            this.failInfo = t;
        }

        public boolean hasFailed( ) {

            return this.failInfo != null;
        }

        public Throwable getFailedReason( ) {

            return this.failInfo;
        }

        public int getNumberOfElements( ) {

            return this.partition.getElements( ).size( );
        }

        public int getNumberOfLinks( ) {

            return this.partition.getLinks( ).size( );
        }
    }

    private void partitionStored( CoreModelPartition storedPartition, CoreConnection connection, SpiPartitionDelta delta ) {

        try {
            storedPartition.clearDirty( connection );
            storedPartition.markPersisted( );
            storedPartition.clearHadErrorsDuringLoad( );
            storedPartition.clearHadUnhandledErrorsDuringLoad( );
            storedPartition.clearUsedMetamodels( );
            connection.getPartitionLockManager( ).releaseLock( storedPartition.getPri( ), connection );
            // inform the client specific workspace about the change
            // so that caches can be updated
            connection.getSession( ).getWorkspace( ).partitionChanged( storedPartition.getPri( ), delta );
        } catch ( RuntimeException e ) {
            logger.trace( e, MoinSeverity.ERROR, "Final cleanup operations for stored partition {0} couldn't be executed", new Object[] { storedPartition } ); //$NON-NLS-1$
        }
    }

    private void partitionDeleted( CoreModelPartition deletedPartition, CoreConnection connection ) {

        try {
            deletedPartition.clearDirty( connection );
            deletedPartition.clearPersisted( );
            deletedPartition.clearHadErrorsDuringLoad( );
            deletedPartition.clearHadUnhandledErrorsDuringLoad( );
            deletedPartition.clearUsedMetamodels( );
            connection.getSession( ).getWorkspace( ).getPartitionManager( ).removePartition( deletedPartition.getPri( ) );
            // inform the client specific workspace about the change
            // so that caches can be updated
            connection.getSession( ).getWorkspace( ).partitionChanged( deletedPartition.getPri( ), null /* delta */);
        } catch ( RuntimeException e ) {
            logger.trace( e, MoinSeverity.ERROR, "Final cleanup operations for deleted partition {0} couldn't be executed", new Object[] { deletedPartition } ); //$NON-NLS-1$
        }
    }

    private void clearConnectionStateAfterSave( CoreConnection connection, Map<PRI, Throwable> failedSaves ) {

        // after save has been completed, there can't be any new elements,
        // therefore clear them all
        connection.clearNewElements( );
        if ( failedSaves.isEmpty( ) ) {
            // If exceptions occured during save, do not throw away delta information and do not toggle the hasPrivateCopies flag. 
            connection.getPartitionChangeRecorder( ).clear( );
            connection.getSession( ).getWorkspace( ).setHasPrivateCopies( false );
        }
        connection.getCommandStack( ).clear( );
    }

    private void cleanupPartitionStructuresAfterSave( CoreConnection connection ) {

        CorePartitionManager partitionManager = this;
        Collection<? extends SpiModelPartition> loadedPartitions = partitionManager.getLoadedPartitions( );
        for ( SpiModelPartition partition : loadedPartitions ) {
            PRI pri = partition.getPri( );
            if ( !pri.isVolatilePartition( ) ) {
                if ( !partition.isAlive( ) && !partition.isPersisted( ) ) {
                    // dirty-deleted partition
                    partitionManager.removePartition( pri );
                } else {
                    // Either the partition is a private copy unnecessarily created by cow (not-dirty), or
                    // it is a partition which could not be saved by the facility (must be dirty then). 
                    CoreModelPartition corePartition = (CoreModelPartition) partition;
                    if ( !corePartition.isDirty( ) ) {
                        connection.getSession( ).updateWrapperCaches( corePartition.getPri( ), connection.getSession( ).getCompoundClientSpecWorkspace( ) );
                        partitionManager.evictPartition( corePartition );
                    }
                }
            }
        }
    }

    /**
     * If the modified partitions collection is not empty, that means that those
     * partitions are not saved yet. This can e.g. happen due to technical
     * difficulties during save so that a partition was not saved. The unsaved
     * partitions are collected and put into an exception which is thrown to the
     * client.
     * 
     * @throws PartitionsNotSavedException if at least one partition could not
     * be saved.
     */
    private void handleNotSavedPartitions( Map<PRI, Throwable> failedSaves ) throws PartitionsNotSavedException {

        // if there are still modified partitions left that means that those
        // partitions could not be stored or it was not tried (maybe forgotten)
        // by the client to store them
        if ( !failedSaves.isEmpty( ) ) {
            List<PRI> pris = new ArrayList<PRI>( failedSaves.keySet( ) );
            Throwable firstExceptionDuringSave = failedSaves.entrySet( ).iterator( ).next( ).getValue( );
            throw new PartitionsNotSavedException( firstExceptionDuringSave, pris, RepositoryCoreMessages.SOME_PARTITIONS_NOT_SAVED );
        }
    }

    private void executeFinalSaveActions( Collection<PartitionSaveEvent> saveEvents, Collection<PartitionChangeEvent> crossSessionPartitionEvents, CoreConnection connection, Map<PRI, Throwable> failedSaves ) {

        CoreSession savingSession = connection.getSession( );
        Collection<CoreSession> sessions = (Collection) savingSession.getMoin( ).getSessions( );
        SynchronizationManager synchronizationManager = getWorkspace( ).getWorkspaceSet( ).getSynchronizationManager( );
        List<SpiEventManager> eventManagersOfOtherSessions = new ArrayList<SpiEventManager>( sessions.size( ) );

        synchronizationManager.acquireMicroWriteLock( );
        try {
            CompoundClientSpecWorkspace compoundClientSpecWorkspace = savingSession.getCompoundClientSpecWorkspace( );
            CorePartitionManager partitionManagerOfCompoundClientSpecWorkspace = compoundClientSpecWorkspace.getPartitionManager( );
            Map<PRI, Collection<SpiLink>> linksPerPartitionInCompoundClientSpecWorkspace = new HashMap<PRI, Collection<SpiLink>>( Utilities.calcInitialCapacity( crossSessionPartitionEvents.size( ) ) );
            Map<PRI, Boolean /* hasDcDependencyViolation */> inconsistentPartitions = new HashMap<PRI, Boolean>( );

            for ( PartitionChangeEvent partitionChangeEvent : crossSessionPartitionEvents ) {
                PRI pri = partitionChangeEvent.getAffectedPartitionPri( );
                if ( partitionManagerOfCompoundClientSpecWorkspace.isPartitionLoaded( pri ) ) {
                    // Fetch the links from the CompoundClientSpecWorkspace before evicting the partition. We need them later on to 
                    // invalidate potentially existing JmiListForDistributedEndStorage instances.
                    Collection<SpiLink> links = partitionManagerOfCompoundClientSpecWorkspace.getPartition( null, pri, false /* loadMissing */).getLinks( );
                    linksPerPartitionInCompoundClientSpecWorkspace.put( pri, links );

                    // collect inconsistencies from all sessions
                    for ( CoreSession session : sessions ) {
                        // check if inconsistency was already found in another session
                        Boolean dcInconsistency = inconsistentPartitions.get( pri );
                        if ( dcInconsistency == null ) {
                            dcInconsistency = Boolean.FALSE;
                        }
                        ConsistencyViolationRegistry consistencyViolationRegistry = session.getConsistencyViolationRegistry( );
                        if ( consistencyViolationRegistry.isPartitionInconsistent( pri ) ) {

                            if ( consistencyViolationRegistry.isPartitionInconsistent( pri, LinkPermissionConsistencyViolation.class ) ) {
                                dcInconsistency = true;
                            }
                            inconsistentPartitions.put( pri, dcInconsistency );
                        }
                    }
                }
            }

            for ( CoreSession session : sessions ) {
                boolean isOtherSession = savingSession != session;
                // Events shall only be sent to "other" Sessions
                if ( isOtherSession ) {
                    SpiEventManager eventManager = session.getEventManager( );
                    // The EventManager might be null if the Session was closed in the meantime
                    if ( eventManager != null ) {
                        eventManagersOfOtherSessions.add( eventManager );
                        eventManager.beginUpdate( connection );
                    }
                }

                if ( session.isAlive( ) ) {
                    Map<CRI, Collection<PRI>> cachePartitionsInContainer = session.getCachePartitionsInContainer( );
                    for ( PartitionChangeEvent partitionEvent : crossSessionPartitionEvents ) {
                        PRI pri = partitionEvent.getAffectedPartitionPri( );
                        if ( cachePartitionsInContainer != null ) {
                            // update cache for "PartitionsInContainer", even in saving session
                            cachePartitionsInContainer.remove( pri.getCri( ) );
                        }

                        if ( isOtherSession ) {
                            CoreModelPartition corePartitionInSavingSession = savingSession.getWorkspace( ).getPartitionManager( ).getPartition( savingSession, pri, false );
                            SpiPartitionDelta delta = null;
                            if ( !( partitionEvent instanceof PartitionDeleteEvent ) ) {
                                // Do not compute a delta in case of partition deletion as partition is null
                                if ( corePartitionInSavingSession != null ) {
                                    delta = connection.getPartitionChangeRecorder( ).getDeltaForPartition( corePartitionInSavingSession );
                                }
                            }
                            CoreSession otherSession = session;
                            Collection<SpiLink> links = linksPerPartitionInCompoundClientSpecWorkspace.get( pri );
                            if ( links != null && !links.isEmpty( ) ) {
                                QueryLinkManager queryLinkManager = otherSession.getWorkspace( ).getQueryLinkManager( );
                                ConsistencyViolationRegistry registry = otherSession.getConsistencyViolationRegistry( );
                                for ( SpiLink link : links ) {
                                    registry.linkDeleted( (EndStorageLink) link );
                                    queryLinkManager.updateCaches( link.getOtherEndLri( ), session.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( link.getEndNumberOfStorageEnd( ), link.getMetaObjectMri( ).getMofId( ) ), null /* iterator */);
                                }
                            }
                            // A "save" can only affect other sessions that have this partition in the client-specific workspace. 
                            // Sessions that use this partition from shared workspaces will notice the deletion only after it is checked in.
                            // They have to be evicted anyway because they could have a private copy after undo of a change (as private copies are not removed on undo)
                            otherSession.getWorkspace( ).partitionChanged( pri, delta );
                            otherSession.updateWrapperCaches( pri, compoundClientSpecWorkspace );
                            otherSession.getWorkspace( ).getPartitionManager( ).evictPartitionsForced( Collections.singletonList( pri ) );
                        }

                    }//endfor partitionsEvents loop

                }//endif of session.isAlive()

            }//endfor of sessions loop

            //update the CompoundClientSpecWorkspace and the saving session 
            for ( PartitionChangeEvent partitionEvent : crossSessionPartitionEvents ) {
                PRI pri = partitionEvent.getAffectedPartitionPri( );
                partitionManagerOfCompoundClientSpecWorkspace.evictPartition( pri );
                // evict the partition from the saving session
                CorePartitionManager partitionManagerOfSessionWorkspace = savingSession.getWorkspace( ).getPartitionManager( );
                CoreModelPartition corePartitionInSavingSession = partitionManagerOfSessionWorkspace.getPartition( savingSession, pri, false );
                if ( corePartitionInSavingSession != null ) { // could have been deleted
                    partitionManagerOfSessionWorkspace.evictPartition( corePartitionInSavingSession );
                    if ( !partitionManagerOfSessionWorkspace.isPartitionLoaded( pri ) ) {
                        // eviction was successful
                        savingSession.updateWrapperCaches( pri, compoundClientSpecWorkspace );
                    }
                }
                if ( !partitionManagerOfSessionWorkspace.isPartitionLoaded( pri ) ) {
                    compoundClientSpecWorkspace.privateCopyRemoved( pri );
                }
                Boolean dcDependencyViolation = inconsistentPartitions.get( pri );
                if ( dcDependencyViolation != null ) {
                    // If a partition with inconsistencies has just been evicted, we need to immediately reload it into the
                    // CompoundClientSpecWorkspace and perform all consistency checks. Otherwise, inconsistencies will
                    // simply disappear after save, a behavior that is not really wanted. Furthermore, certain kinds of
                    // inconsistencies will not reappear *automatically* after the next load, so triggering an explicit
                    // consistency check is a must.
                    ConsistencyViolationRegistry consistencyViolationRegistry = connection.getSession( ).getConsistencyViolationRegistry( );
                    consistencyViolationRegistry.performConsistencyCheck( pri, connection );
                    // Only perform the more expensive DC dependency check if we definitely know that there has been a
                    // LinkPermissionConsistencyViolation before eviction.
                    if ( dcDependencyViolation == Boolean.TRUE ) {
                        consistencyViolationRegistry.performDcDependencyCheck( pri, connection );
                    }
                }
            }

            //remove dirty deleted partitions from the core structures
            this.cleanupPartitionStructuresAfterSave( connection );

            // Cleanup CommandStack and newElements
            this.clearConnectionStateAfterSave( connection, failedSaves );

            // it is possible that transients locks were obtained, but the
            // locked partitions were not made dirty.
            // Such partitions must have the locks released as well.
            PartitionLockManager partitionLockManager = connection.getPartitionLockManager( );
            Collection<PRI> lockedResources = partitionLockManager.getLockedResources( connection );
            for ( PRI pri : lockedResources ) {
                try {
                    partitionLockManager.releaseLock( pri, connection );
                } catch ( RuntimeException e ) {
                    logger.trace( e, MoinSeverity.ERROR, "Problem on releasing lock for non-dirty resource {0}", new Object[] { pri } ); //$NON-NLS-1$
                }
            }

        } finally {
            synchronizationManager.releaseMicroWriteLock( );
        }

        //fire post events and end the "update" cycle for the saving session
        SpiEventManager savingSessionEventManager = savingSession.getEventManager( );
        for ( PartitionSaveEvent saveEvent : saveEvents ) {
            savingSessionEventManager.fireChangeEvent( saveEvent );
        }
        savingSessionEventManager.deliverUpdate( connection );

        // Fire cross-session events and notify event manager of other sessions that event bucket ends
        for ( SpiEventManager eventManager : eventManagersOfOtherSessions ) {
            for ( PartitionChangeEvent partitionChangeEvent : crossSessionPartitionEvents ) {
                eventManager.fireChangeEvent( partitionChangeEvent );
            }
            eventManager.deliverUpdate( connection );
        }
    }

    private boolean holdsLockForLoadOrEvict( ) {

        if ( !workspace.isMetamodelWorkspace( ) ) {
            SynchronizationManager synchronizationManager = workspace.getWorkspaceSet( ).getSynchronizationManager( );
            if ( synchronizationManager.checkLockHolding( ) ) {
                return synchronizationManager.isLockHeldByCurrentThread( );
            }
        }
        return true;

    }
}

package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreInstanceManager;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.SharedWorkspace;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.extension.RefObjectExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefBaseObjectWrapperImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public final class MoinCoreConsistencyChecker {

    private final CoreMoin moin;

    private final boolean withoutLocks;

    public static enum CheckId {

        DIRTY_PARTITION_MUST_BE_CONTAINED_IN_EXACTLY_ONE_MODIFIED_PARTITIONS( "Each dirty partition which is not a null-partition or a transient partition must be contained in the 'modifiedPartitions' collection of exactly one connection of the hosting session." ), //$NON-NLS-1$

        PARTITIONS_OF_NON_SW_EXCEPT_FOR_EXTENTPARTITION_MUST_NOT_BE_DIRTY_OR_TRANSIENT_OR_NULLPARTITION( "Each partition which is not from a SessionWorkspace and which is not the extent partition must not be dirty, transient or a null-partition (and must be marked as persisted)." ), //$NON-NLS-1$

        ELEMENTS_IN_INSTANCEMANAGER_MUST_HAVE_PARTITION_IN_PARTITIONMANAGER( "For each element in a workspace's InstanceManager, the element's partition must be contained in the 'loadedPartitions' collections of the responsible PartitionManager." ), //$NON-NLS-1$

        STORAGE_END_OF_LINKS_MUST_BE_EQUAL_TO_HOSTING_ELEMENT(
            "For each link, the following must hold for the MriReference of the storage end: if the reference is cached, the cached element must be == the element hosting the link; else, the reference's MRI must be equal to the hosting element's MRI." ), //$NON-NLS-1$

        RESOLVED_ELEMENT_OF_CACHED_MRI_REFERENCES_MUST_BE_IN_CERTAIN_WORKSPACE(
            "For all cached MriReferences hosted in a workspace W the following must hold for the resolved element E: E must not be from the MetamodelWorkspace; if W is a SessionWorkspace, E must be from W; if W is a CompoundClientSpecWorkspace, E must be either from W or from some SharedWorkspace" ), //$NON-NLS-1$

        CACHED_COMPOSITE_PARENT_LINK_MUST_NOT_HAVE_ELEMENT_FROM_CERTAIN_WORKSPACE_AT_COMPOSITE_END( "For the cached link to the composite parent ('__compositeParentLink') of elements, certain workspaces for the resolved element at the storage end are not allowed." ), //$NON-NLS-1$

        RESOLVED_MRIREFERENCE_AT_JMIWRAPPER_MUST_HAVE_WORKSPACE( "If the MriReference held by a JMI wrapper is in the resolved state, the resolved element must have a workspace != 'null'." ), //$NON-NLS-1$

        DUPLICATE_ELEMENTS_IN_INSTANCEMANAGERS_MUST_HAVE_DISTINCT_MRIS( "If a DuplicateElement inconsistency is hosted by an InstanceManager, the duplicate elements with identical LRI must have distinct MRIs." ), //$NON-NLS-1$

        PRIVATE_COPY_COLLECTION_MUST_BE_CONSISTENT( "The CompoundClientSpecWorkspace tracks all PRIs for which currently a private copy exists in a collection. This collection must always reflect the current situation." );//$NON-NLS-1$

        private final String checkDescription;

        private CheckId( String checkDescription ) {

            this.checkDescription = checkDescription;
        }

        public String getCheckDescription( ) {

            return this.checkDescription;
        }
    }

    public MoinCoreConsistencyChecker( CoreMoin moin, boolean withoutLocks ) {

        this.moin = moin;
        this.withoutLocks = withoutLocks;
    }

    public CheckResult performAllChecks( ) {

        CheckResult result = new CheckResult( );
        result = checkDirtyPartitions( result );
        result = checkStatesOfPartitionsInNonSessionWorkspaces( result );
        result = checkInstanceManagersForOrphanedElements( result );
        result = checkStorageEndOfAllLinks( result );
        result = checkCachedCompositeParentLinks( result );
        result = checkMriReferencesOfJmiWrappersForNulledWorkspace( result );
        result = checkMriReferencesOfAllNonMetamodelWorkspaces( result );
        result = checkDuplicateElementInconsistencies( result );
        result = checkPrivateCopyCollection( result );
        return result;
    }

    public CheckResult checkPrivateCopyCollection( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkPrivateCopyCollectionInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkPrivateCopyCollectionInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkPrivateCopyCollectionInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        CheckId checkId = CheckId.PRIVATE_COPY_COLLECTION_MUST_BE_CONSISTENT;
        for ( CompoundClientSpecWorkspace ccsWorkspace : workspaceSet.getCompoundClientSpecWorkspaces( ) ) {
            // First, collect all PRIs of non-transient, non-null-partitions in all sessions of the CompoundClientSpec.
            Set<PRI> prisInSessionWorkspaces = new HashSet<PRI>( );
            for ( CoreSession session : workspaceSet.getSessionsForClientId( ccsWorkspace.getCompoundClientSpec( ).getId( ) ) ) {
                for ( SpiModelPartition partition : session.getWorkspace( ).getPartitionManager( ).getLoadedPartitions( ) ) {
                    PRI pri = partition.getPri( );
                    if ( !pri.isVolatilePartition( ) && partition.isPersisted( ) ) {
                        prisInSessionWorkspaces.add( pri );
                        if ( !session.getWorkspace( ).hasPrivateCopies( ) ) {
                            result.addIncident( checkId, "Found private copy of " + pri + " in session " + session + ", but session states it has no private copies!" );//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        }
                    }
                }
            }
            // Now, compare the collected info with the PRI collection of the CompoundClientSpecWorkspace.
            Set<PRI> privateCopies = ccsWorkspace.getPrivateCopies( );
            if ( !privateCopies.equals( prisInSessionWorkspaces ) ) {
                StringBuilder message = new StringBuilder( "Mismatch between existing private copies and the PRI collection in CCSW " ).append( ccsWorkspace ); //$NON-NLS-1$
                message.append( ". Existing private copies: " ).append( Arrays.asList( prisInSessionWorkspaces.toArray( ) ) ); //$NON-NLS-1$
                message.append( ", PRI collection: " ).append( Arrays.asList( privateCopies.toArray( ) ) ); //$NON-NLS-1$
                result.addIncident( checkId, message.toString( ) );
            }
        }
    }

    public CheckResult checkDuplicateElementInconsistencies( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkDuplicateElementInconsistenciesInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkDuplicateElementInconsistenciesInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkDuplicateElementInconsistenciesInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        List<Workspace> allWorkspaces = getAllWorkspaces( workspaceSet );
        for ( Workspace workspace : allWorkspaces ) {
            checkDuplicateElementsInInstanceManagerForSameMri( workspace, result );
        }
    }

    @SuppressWarnings( "unchecked" )
    private void checkDuplicateElementsInInstanceManagerForSameMri( Workspace workspace, CheckResult result ) {

        try {
            CheckId checkId = CheckId.DUPLICATE_ELEMENTS_IN_INSTANCEMANAGERS_MUST_HAVE_DISTINCT_MRIS;
            CoreInstanceManager instanceManager = workspace.getInstanceManager( );
            List<Object> instances = Utilities.getSnapshotOfCollectionAsList( instanceManager.getInstancesLive( ) );
            for ( int i = 0, n = instances.size( ); i < n; i++ ) {
                Object object = instances.get( i );
                if ( object instanceof List ) {
                    List list = (List) object;
                    Set<MRI> mris = new HashSet<MRI>( );
                    for ( int j = 0, k = list.size( ); j < k; j++ ) {
                        MRI mri = ( (CorePartitionable) list.get( j ) ).get___Mri( );
                        if ( !mris.add( mri ) ) { // already contained => illegal duplicate MRI contained in list
                            result.addIncident( checkId, "Found duplicate element for LRI " + mri.getLri( ) + " where at least two duplicate elements have the same MRI " + mri + "." ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        }
                    }
                }
            }
        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    public CheckResult checkMriReferencesOfJmiWrappersForNulledWorkspace( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkMriReferencesOfJmiWrappersForNulledWorkspaceInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkMriReferencesOfJmiWrappersForNulledWorkspaceInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    @SuppressWarnings( "unchecked" )
    private void checkMriReferencesOfJmiWrappersForNulledWorkspaceInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        try {
            CheckId checkId = CheckId.RESOLVED_MRIREFERENCE_AT_JMIWRAPPER_MUST_HAVE_WORKSPACE;
            for ( CoreSession session : workspaceSet.getSessions( ) ) {
                if ( session != null ) {
                    for ( CoreConnection connection : session.getConnections( ) ) {
                        if ( connection != null ) {
                            for ( Wrapper jmiWrapper : connection.getCachedJmiWrappers( ) ) {
                                MriReference mriReference = ( (RefBaseObjectWrapperImpl) jmiWrapper ).getMriReference( );
                                if ( mriReference.isCached( ) ) {
                                    CorePartitionable element = mriReference.getIfResolved( );
                                    if ( element.get___Workspace( ) == null ) {
                                        result.addIncident( checkId, "Found cached MriReference held by JMI wrapper " + jmiWrapper + " whose resolved element " + element + " has workspace == 'null'." ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    public CheckResult checkDirtyPartitions( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkDirtyPartitionsInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkDirtyPartitionsInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkDirtyPartitionsInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        try {
            CheckId checkId = CheckId.DIRTY_PARTITION_MUST_BE_CONTAINED_IN_EXACTLY_ONE_MODIFIED_PARTITIONS;
            for ( CoreSession session : workspaceSet.getSessions( ) ) {
                if ( session != null && session.isAlive( ) ) {
                    for ( CoreModelPartition partition : session.getWorkspace( ).getPartitionManager( ).getLoadedPartitionsLive( ) ) {
                        PRI pri = partition.getPri( );
                        if ( partition.isDirty( ) && !pri.isVolatilePartition( ) ) {
                            // Check that the dirty partition is in the modifiedPartitions collection of a connection of this session.
                            Set<CoreConnection> connections = session.getConnections( );
                            if ( !connections.isEmpty( ) ) {
                                int matchesInModifiedPartitions = 0;
                                for ( CoreConnection connection : connections ) {
                                    Collection<CoreModelPartition> modifiedPartitions = connection.getDirtyPartitionsWithoutNullPartition( );
                                    if ( modifiedPartitions.contains( partition ) ) {
                                        matchesInModifiedPartitions++;
                                    }
                                }
                                if ( matchesInModifiedPartitions == 0 ) {
                                    result.addIncident( checkId, "Found dirty partition " + pri + " which is not contained in the 'modifiedPartitions' collection of any connection!" ); //$NON-NLS-1$ //$NON-NLS-2$
                                } else if ( matchesInModifiedPartitions > 1 ) {
                                    result.addIncident( checkId, "Found dirty partition " + pri + " which is contained in more than one 'modifiedPartitions' collection!" ); //$NON-NLS-1$ //$NON-NLS-2$
                                }
                            }
                        }
                    }
                }
            }
        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    public CheckResult checkStatesOfPartitionsInNonSessionWorkspaces( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkStatesOfPartitionsInNonSessionWorkspacesInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkStatesOfPartitionsInNonSessionWorkspacesInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkStatesOfPartitionsInNonSessionWorkspacesInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        try {
            CheckId checkId = CheckId.PARTITIONS_OF_NON_SW_EXCEPT_FOR_EXTENTPARTITION_MUST_NOT_BE_DIRTY_OR_TRANSIENT_OR_NULLPARTITION;
            for ( Workspace workspace : getAllWorkspaces( workspaceSet ) ) {
                if ( !( workspace instanceof SessionWorkspace ) ) {
                    for ( CoreModelPartition partition : workspace.getPartitionManager( ).getLoadedPartitionsLive( ) ) {
                        if ( !partition.isExtentPartition( ) ) {
                            PRI pri = partition.getPri( );
                            if ( pri.isVolatilePartition( ) ) {
                                result.addIncident( checkId, "Found volatile partition " + pri + " in workspace " + workspace ); //$NON-NLS-1$ //$NON-NLS-2$
                            } else if ( partition.isDirty( ) ) {
                                result.addIncident( checkId, "Found dirty partition " + pri + " in workspace " + workspace ); //$NON-NLS-1$ //$NON-NLS-2$
                            } else if ( !partition.isPersisted( ) ) {
                                result.addIncident( checkId, "Found non-dirty, non-transient but non-persisted partition " + pri + " in workspace " + workspace ); //$NON-NLS-1$ //$NON-NLS-2$
                            }
                        }
                    }
                }
            }
        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    public CheckResult checkInstanceManagersForOrphanedElements( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkInstanceManagersForOrphanedElementsInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkInstanceManagersForOrphanedElementsInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkInstanceManagersForOrphanedElementsInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        List<Workspace> allWorkspaces = getAllWorkspaces( workspaceSet );
        for ( Workspace workspace : allWorkspaces ) {
            checkInstanceManager( workspace, result );
        }
    }

    public CheckResult checkStorageEndOfAllLinks( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkStorageEndOfAllLinksInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkStorageEndOfAllLinksInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkStorageEndOfAllLinksInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        try {
            CheckId checkId = CheckId.STORAGE_END_OF_LINKS_MUST_BE_EQUAL_TO_HOSTING_ELEMENT;
            for ( Workspace workspace : getAllWorkspaces( workspaceSet ) ) {
                for ( CoreModelPartition partition : workspace.getPartitionManager( ).getLoadedPartitionsLive( ) ) {
                    if ( !partition.isExtentPartition( ) ) {
                        for ( Partitionable element : partition.getElements( ) ) {
                            List<EndStorageLink> allStoredLinks = ( (RefFeaturedExtension) element ).get___AllStoredLinks( );
                            if ( allStoredLinks != null ) {
                                for ( EndStorageLink link : allStoredLinks ) {
                                    MriReference storageEnd = link.getStorageEnd( );
                                    if ( storageEnd.isCached( ) ) {
                                        if ( storageEnd.getIfResolved( ) != element ) {
                                            result.addIncident( checkId, "Found stored link in element " + element + " whose resolved storageEnd differs from the hosting element." ); //$NON-NLS-1$ //$NON-NLS-2$
                                        }
                                    } else {
                                        if ( !storageEnd.getMri( ).equals( element.get___Mri( ) ) ) {
                                            result.addIncident( checkId, "Found stored link in element " + element + " whose unresolved storageEnd differs from the hosting element." ); //$NON-NLS-1$ //$NON-NLS-2$
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    public CheckResult checkMriReferencesOfAllNonMetamodelWorkspaces( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkMriReferencesOfAllNonMetamodelWorkspacesInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkMriReferencesOfAllNonMetamodelWorkspacesInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkMriReferencesOfAllNonMetamodelWorkspacesInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        try {
            CheckId checkId = CheckId.RESOLVED_ELEMENT_OF_CACHED_MRI_REFERENCES_MUST_BE_IN_CERTAIN_WORKSPACE;
            for ( Workspace workspace : getAllWorkspaces( workspaceSet ) ) {
                if ( !workspace.isMetamodelWorkspace( ) ) {
                    for ( MriReference mriReference : workspace.getHostedMriReferences( ) ) {
                        if ( mriReference.isCached( ) ) {
                            CorePartitionable element = mriReference.getIfResolved( );
                            Workspace workspaceOfElement = element.get___Workspace( );
                            if ( workspaceOfElement != null ) {
                                if ( ( workspaceOfElement instanceof MetamodelWorkspace ) || ( workspace instanceof SessionWorkspace && workspaceOfElement != workspace )
                                     || ( workspace instanceof CompoundClientSpecWorkspace && !( workspaceOfElement == workspace || workspaceOfElement instanceof SharedWorkspace ) ) ) {
                                    result.addIncident( checkId, "Found cached reference hosted in workspace " + workspace + " with resolved element " + element + " from workspace " + workspaceOfElement ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                }
                            }
                        }
                    }
                }
            }
        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    public CheckResult checkCachedCompositeParentLinks( CheckResult checkResult ) {

        CheckResult result = ( checkResult != null ? checkResult : new CheckResult( ) );
        for ( WorkspaceSet workspaceSet : moin.getWorkspaceSets( ) ) {
            if ( withoutLocks ) {
                checkCachedCompositeParentLinksInternal( result, workspaceSet );
            } else {
                SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
                synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                    synchronizationManager.acquireMicroWriteLock( );
                    try {
                        checkCachedCompositeParentLinksInternal( result, workspaceSet );
                    } finally {
                        synchronizationManager.releaseMicroWriteLock( );
                    }
                }
            }
        }
        return result;
    }

    private void checkCachedCompositeParentLinksInternal( CheckResult result, WorkspaceSet workspaceSet ) {

        try {
            CheckId checkId = CheckId.CACHED_COMPOSITE_PARENT_LINK_MUST_NOT_HAVE_ELEMENT_FROM_CERTAIN_WORKSPACE_AT_COMPOSITE_END;
            for ( Workspace workspace : getAllWorkspaces( workspaceSet ) ) {
                if ( !workspace.isMetamodelWorkspace( ) ) {
                    for ( CorePartitionable componentElement : workspace.getInstanceManager( ).getInstances( ) ) {
                        EndStorageLink compositeParentLink = ( (RefObjectExtension) componentElement ).get___CompositeParentLink( );
                        if ( compositeParentLink != null && compositeParentLink != RefObjectImpl.NOT_YET_RETRIEVED ) {
                            MoinReference compositeEnd = compositeParentLink.getEnd( compositeParentLink.getCompositeEnd( ) );
                            if ( compositeEnd.isCached( ) ) {
                                CorePartitionable compositeElement = compositeEnd.get( null /* session */);
                                if ( !RefObjectImpl.isCachingOfCompositeParentLinkAllowed( compositeElement, componentElement ) ) {
                                    result.addIncident( checkId, "Found cached composite parent link in element " + componentElement + " from workspace " + workspace + " where the composite end " + compositeEnd + " is resolved and lives in workspace " + compositeElement.get___Workspace( ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                                }
                            }
                        }
                    }
                }
            }
        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    private List<Workspace> getAllWorkspaces( WorkspaceSet workspaceSet ) {

        List<Workspace> allWorkspaces = new ArrayList<Workspace>( workspaceSet.getClientSpecificWorkspaces( ) );
        allWorkspaces.addAll( workspaceSet.getSharedWorkspaces( ) );
        allWorkspaces.addAll( workspaceSet.getCompoundClientSpecWorkspaces( ) );
        return allWorkspaces;
    }

    @SuppressWarnings( "unchecked" )
    private void checkInstanceManager( Workspace workspace, CheckResult checkResult ) {

        try {
            CorePartitionManager partitionManager = workspace.getPartitionManager( );
            CoreInstanceManager instanceManager = workspace.getInstanceManager( );

            List<Object> instances = Utilities.getSnapshotOfCollectionAsList( instanceManager.getInstancesLive( ) );
            for ( int i = 0, n = instances.size( ); i < n; i++ ) {
                Object object = instances.get( i );
                if ( object instanceof List ) {
                    List<CorePartitionable> elements = (List) object;
                    for ( CorePartitionable instance : elements ) {
                        checkInstanceForOrphanage( instance, checkResult, partitionManager );
                    }
                } else {
                    checkInstanceForOrphanage( (CorePartitionable) object, checkResult, partitionManager );
                }
            }

        } catch ( Exception ex ) {
        } // $JL-EXCL$
    }

    private void checkInstanceForOrphanage( CorePartitionable instance, CheckResult checkResult, CorePartitionManager partitionManager ) {

        if ( !partitionManager.isPartitionLoaded( instance.get___Partition( ).getPri( ) ) ) {
            checkResult.addIncident( CheckId.ELEMENTS_IN_INSTANCEMANAGER_MUST_HAVE_PARTITION_IN_PARTITIONMANAGER, "Found orphaned element " + instance + " in InstanceManager of workspace " + partitionManager.getWorkspace( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }
}
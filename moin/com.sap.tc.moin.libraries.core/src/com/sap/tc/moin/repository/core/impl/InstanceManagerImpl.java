package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.InconsistentModelException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreInstanceManager;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;
import com.sap.tc.moin.repository.core.jmi.extension.RefBaseObjectExtension;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

/**
 * Manages the model element instances for a
 * {@link com.sap.tc.moin.repository.core.Workspace}. The following actions make
 * use of the {@link InstanceManagerImpl} operations:
 * <ul>
 * <li>{@link CorePartitionManager#evictPartition}</li>
 * <li>{@link CorePartitionManager#loadPartition}</li>
 * <li>logical creation of a model element</li>
 * <li>logical deletion of a model element</li>
 * </ul>
 * 
 * @author d046074
 */
public class InstanceManagerImpl implements CoreInstanceManager {

    /**
     * The owning {@link com.sap.tc.moin.repository.core.Workspace workspace} of
     * this instance manager
     */
    private final Workspace workspace;

    /**
     * The set of model elements hosted by this workspace that belong to
     * {@link ModelPartition}s which are part of this workspace's
     * {@link com.sap.tc.moin.repository.DataArea}. Keys are {@link LRI}s, the
     * values are either a {@link CorePartitionable} or a {@link java.util.List}
     * of {@link CorePartitionable}. The reason for this is that the instance
     * manager needs to be able to host inconsistencies, i.e. that a model
     * element which is visible more then once, e.g. because of wrong partition
     * sync state, needs to be hosted multiple times in the instance manager.
     * The respective operations working with this structure needs to implement
     * the behavior in case of inconsistencies, e.g. throw an exception if a
     * model element is found more than once when getting a instance.
     */
    private final Map<LRI, Object> modelElementInstances;

    /**
     * Constructor taking the owning {@link Workspace workspace} as parameter
     * and initializing the internal structure for holding the model element
     * instances.
     * 
     * @param workspace
     */
    public InstanceManagerImpl( Workspace workspace ) {

        this.workspace = workspace;
        this.modelElementInstances = new HashMap<LRI, Object>( );
    }

    public void injectInstance( CoreConnection connection, CorePartitionable element ) {

        if ( element.get___Partition( ) == null ) {
            if ( connection == null ) {
                throw new MoinIllegalStateException( CoreImplMessages.NOTPOSSIBLETODETERMINEWHICHNULLPARTITIONTOUSE );
            }
            CoreModelPartition partition = getResponsibleTransientPartition( connection, element );
            element.set___PartitionAssignment( partition );
        }

        LRI lri = element.get___Mri( ).getLri( );
        Object instanceOrList = modelElementInstances.get( lri );
        if ( instanceOrList == null ) {
            modelElementInstances.put( lri, element );
        } else {
            List<CorePartitionable> modelElementList = null;
            if ( instanceOrList instanceof CorePartitionable ) {
                // check if the element was already loaded into the same partition
                if ( ( (CorePartitionable) instanceOrList ).get___Mri( ).equals( element.get___Mri( ) ) ) {
                    throw new InconsistentModelException( RepositoryCoreMessages.INSTANCE_ALREADY_HOSTED, element.get___Mri( ).toString( ) );
                }
                modelElementList = new ArrayList<CorePartitionable>( 2 );
                modelElementList.add( (CorePartitionable) instanceOrList );
                modelElementList.add( element );
                modelElementInstances.put( lri, modelElementList );
                notifyDuplicateElementInconsistency( element.get___Mri( ), ( (CorePartitionable) instanceOrList ).get___Mri( ) );
            } else if ( instanceOrList instanceof List ) {
                modelElementList = (List<CorePartitionable>) instanceOrList;
                // check if the element was already loaded into the same partition
                MRI existingMri = null;
                for ( Object object : modelElementList ) {
                    MRI mri = ( (CorePartitionable) object ).get___Mri( );
                    if ( mri.equals( element.get___Mri( ) ) ) {
                        throw new InconsistentModelException( RepositoryCoreMessages.INSTANCE_ALREADY_HOSTED, element.get___Mri( ).toString( ) );
                    }
                    // last MRI wins but that's no problem because the existingMri is only considered within the 
                    // "notifyDuplicateElementInconsistency()" if it is the first duplicate element (no duplicates 
                    // of this element so far) 
                    existingMri = mri;
                }
                modelElementList.add( element );
                notifyDuplicateElementInconsistency( ( element ).get___Mri( ), existingMri );
            } else {
                // Unsupported container type, throw exception
                throw new MoinIllegalStateException( RepositoryCoreMessages.WRONG_CONTAINER_TYPE_FOR_INSTANCES, instanceOrList.getClass( ).toString( ) );
            }
        }
        if ( this.workspace instanceof SessionWorkspace ) {
            SessionWorkspace sessionWorkspace = (SessionWorkspace) this.workspace;
            CompoundClientSpecWorkspace compoundClientSpecWorkspace = sessionWorkspace.getSession( ).getCompoundClientSpecWorkspace( );
            Object instancesInCCSW = compoundClientSpecWorkspace.getInstanceManager( ).getInstancesRaw( lri );
            if ( instancesInCCSW instanceof List ) {
                List<CorePartitionable> instances = (List<CorePartitionable>) instancesInCCSW;
                for ( int i = 0, n = instances.size( ); i < n; i++ ) {
                    CorePartitionable instanceInCCSW = instances.get( i );
                    if ( !instanceInCCSW.get___Mri( ).equals( element.get___Mri( ) ) ) {
                        if ( !sessionWorkspace.getPartitionManager( ).isPartitionLoaded( instanceInCCSW.get___Mri( ).getPri( ) ) ) {
                            notifyDuplicateElementInconsistency( element.get___Mri( ), instanceInCCSW.get___Mri( ) );
                        }
                    }
                }
            }
        }
        notifyElementCreated( element.get___Mri( ) );
    }

    private void notifyDuplicateElementInconsistency( MRI newMri, MRI existingMri ) {

        assert newMri != null;
        assert existingMri != null;
        if ( this.workspace instanceof SessionWorkspace ) {
            // Must be a load triggered by COW.
            getConsistencyViolationRegistry( (SessionWorkspace) this.workspace ).notifyDuplicateElementInconsistency( newMri, existingMri );
        } else if ( this.workspace instanceof CompoundClientSpecWorkspace ) {
            // Must be a "regular" load from the persistence.
            CompoundClientSpecWorkspace ccsWorkspace = (CompoundClientSpecWorkspace) this.workspace;
            String clientId = ccsWorkspace.getCompoundClientSpec( ).getId( );
            PRI newPri = newMri.getPri( );
            PRI existingPri = existingMri.getPri( );
            for ( CoreSession session : workspace.getWorkspaceSet( ).getSessionsForClientId( clientId ) ) {
                if ( session.isAlive( ) ) {
                    boolean notifySession = false;
                    boolean privateCopyNew = privateCopyExists( session, newPri );
                    boolean privateCopyExisting = privateCopyExists( session, existingPri );
                    if ( !privateCopyNew && !privateCopyExisting ) {
                        notifySession = true;
                    } else if ( !privateCopyNew && privateCopyExisting ) {
                        if ( session.getWorkspace( ).getInstanceManager( ).getInstance( session, existingMri.getLri( ) ) != null ) {
                            notifySession = true;
                        }
                    }
                    if ( notifySession ) {
                        ConsistencyViolationRegistry registry = session.getConsistencyViolationRegistry( );
                        if ( registry != null ) {
                            registry.notifyDuplicateElementInconsistency( newMri, existingMri );
                        }
                    }
                }
            }
        }
        // TODO inconsistency handling for shared workspaces
    }

    private boolean privateCopyExists( CoreSession session, PRI pri ) {

        return session.getWorkspace( ).getPartitionManager( ).isPartitionLoaded( pri );
    }

    private void notifyElementDeleted( MRI mri ) {

        if ( this.workspace instanceof SessionWorkspace ) {
            ConsistencyViolationRegistry consistencyViolationRegistry = getConsistencyViolationRegistry( (SessionWorkspace) this.workspace );
            if ( consistencyViolationRegistry != null ) {
                consistencyViolationRegistry.elementDeleted( mri );
            }
        } else if ( this.workspace instanceof CompoundClientSpecWorkspace ) {
            String clientId = ( (CompoundClientSpecWorkspace) this.workspace ).getCompoundClientSpec( ).getId( );
            for ( CoreSession session : workspace.getWorkspaceSet( ).getSessionsForClientId( clientId ) ) {
                if ( session.isAlive( ) ) {
                    ConsistencyViolationRegistry registry = session.getConsistencyViolationRegistry( );
                    if ( registry != null ) {
                        registry.elementDeleted( mri );
                    }
                }
            }
        }
        // TODO inconsistency handling for shared workspaces
    }

    private void notifyElementCreated( MRI mri ) {

        if ( this.workspace instanceof SessionWorkspace ) {
            getConsistencyViolationRegistry( (SessionWorkspace) this.workspace ).elementCreated( mri.getLri( ) );
        } else if ( this.workspace instanceof CompoundClientSpecWorkspace ) {
            String clientId = ( (CompoundClientSpecWorkspace) this.workspace ).getCompoundClientSpec( ).getId( );
            for ( CoreSession session : workspace.getWorkspaceSet( ).getSessionsForClientId( clientId ) ) {
                if ( session.isAlive( ) ) {
                    ConsistencyViolationRegistry registry = session.getConsistencyViolationRegistry( );
                    if ( registry != null ) {
                        registry.elementCreated( mri.getLri( ) );
                    }
                }
            }
        }
        // TODO inconsistency handling for shared workspaces
    }

    private CorePartitionable getInstanceOnInconsistency( CoreSession session, LRI lri, List<CorePartitionable> instanceList ) {

        // check consistency registry    
        if ( this.workspace instanceof SessionWorkspace ) {
            CorePartitionable result = null;
            MRI usedMri = getConsistencyViolationRegistry( (SessionWorkspace) this.workspace ).checkRegisteredDuplicateElement( lri ).get( 0 ).getUsedElementsMri( );
            if ( usedMri != null ) {
                for ( CorePartitionable instance : instanceList ) {
                    if ( instance.get___Mri( ).equals( usedMri ) ) {
                        result = instance;
                    }
                }
            }
            if ( result == null ) {
                return instanceList.get( instanceList.size( ) - 1 );
            }
            return result;
        } else if ( this.workspace instanceof CompoundClientSpecWorkspace ) {
            if ( session != null ) {
                // First check if the session still has DuplicateElement inconsistencies. If yes, we ask the DuplicateElementConsistencyViolation
                // which instance has to be used.
                List<DuplicateElementConsistencyViolation> violations = session.getConsistencyViolationRegistry( ).checkRegisteredDuplicateElement( lri );
                if ( violations != null ) {
                    CorePartitionable result = null;
                    MRI usedMri = violations.get( 0 ).getUsedElementsMri( );
                    if ( usedMri != null ) {
                        for ( CorePartitionable instance : instanceList ) {
                            if ( instance.get___Mri( ).equals( usedMri ) ) {
                                result = instance;
                                break;
                            }
                        }
                    }

                    return result;
                }
                // The session has no registered DuplicateElement inconsistency. This can only mean that the session has fixed it locally.
                // In order to fix it, either all partitions or all partitions except for one must have been modified (either the whole
                // partition or the element only has been deleted). If we find an instance whose partition has not been modified by the
                // session, it must be the instance to use. Otherwise, the instance must have been deleted from ALL partitions, i.e.
                // we must return 'null'.
                CorePartitionManager partitionManagerOfSession = session.getWorkspace( ).getPartitionManager( );
                for ( CorePartitionable instance : instanceList ) {
                    PRI pri = instance.get___Partition( ).getPri( );
                    CoreModelPartition partition = partitionManagerOfSession.getPartitionConsideringDeleted( session, pri, false /* loadMissing */);
                    if ( partition == null ) {
                        // We found a partition that was NOT modified by the session. Therefore it must be the one containing the instance to use.
                        return instance;
                    }
                }
            }
            // ALL occurrences of the instance with the given LRI have been deleted locally. Therefore we have to return 'null'.
            return null;
        } else {
            // TODO no proper inconsistency support of shared workspaces so far
            return instanceList.get( 0 );
        }
    }

    private ConsistencyViolationRegistry getConsistencyViolationRegistry( SessionWorkspace clientSpecificWorkspace ) {

        return clientSpecificWorkspace.getSession( ).getConsistencyViolationRegistry( );
    }

    private CoreModelPartition getResponsibleTransientPartition( CoreConnection connection, SpiPartitionable element ) {

        // TODO determine the correct transient partition because there can be one per facility
        return connection.getNullPartition( );
    }

    public void evictInstance( CorePartitionable element ) {

        workspace.getWorkspaceSet( ).getReferenceManager( ).notifyBeforeInstanceEviction( element );

        LRI lri = element.get___Mri( ).getLri( );
        Object instanceOrList = modelElementInstances.get( lri );
        if ( instanceOrList == null ) {
            // no-op
        } else if ( instanceOrList instanceof CorePartitionable ) {
            if ( ( (CorePartitionable) instanceOrList ).equals( element ) ) {
                modelElementInstances.remove( lri );
            } else {
                throw new MoinIllegalStateException( RepositoryCoreMessages.INSTANCE_DOES_NOT_MATCH_KEY, element.get___Mri( ).toString( ), lri );
            }
        } else if ( instanceOrList instanceof List ) {
            List<CorePartitionable> modelElementList = (List) instanceOrList;
            // pick the right one to remove - MRI must be the same
            for ( Iterator<CorePartitionable> elements = modelElementList.iterator( ); elements.hasNext( ); ) {
                if ( elements.next( ).get___Mri( ).equals( element.get___Mri( ) ) ) {
                    elements.remove( );
                }
            }
            // Change container type from List to CorePartitionable
            if ( modelElementList.size( ) == 1 ) {
                CorePartitionable cp = modelElementList.iterator( ).next( );
                // modelElementList.remove(cp);
                // modelElementInstances.remove(lri);
                modelElementInstances.put( lri, cp );
            }
        } else {
            // Unsupported container type, throw exception
            throw new MoinIllegalStateException( RepositoryCoreMessages.WRONG_CONTAINER_TYPE_FOR_INSTANCES, instanceOrList.getClass( ).toString( ) );
        }
        notifyElementDeleted( element.get___Mri( ) );
        ( (RefBaseObjectExtension) element ).set___Workspace( null );
    }

    public CorePartitionable getInstance( CoreSession session, LRI lri ) {

        Object instanceOrList = modelElementInstances.get( lri );
        // check if there is more than one instance for this LRI and if yes,
        // throw exception
        if ( instanceOrList instanceof List ) {
            List<CorePartitionable> instanceList = (List<CorePartitionable>) instanceOrList;
            return getInstanceOnInconsistency( session, lri, instanceList );
        }
        // return null or CorePartitionable
        return (CorePartitionable) instanceOrList;
    }

    public CorePartitionable getInstance( MRI mri ) {

        Object instanceOrList = modelElementInstances.get( mri.getLri( ) );
        // check if there is more than one instance for this LRI and if yes, throw exception
        if ( instanceOrList instanceof List ) {
            // search for suitable mri
            List<CorePartitionable> instanceList = (List<CorePartitionable>) instanceOrList;
            for ( CorePartitionable partitionable : instanceList ) {
                if ( partitionable.get___Mri( ).equals( mri ) ) {
                    return partitionable;
                }
            }
        } else if ( instanceOrList != null ) {
            if ( ( (CorePartitionable) instanceOrList ).get___Mri( ).equals( mri ) ) {
                return (CorePartitionable) instanceOrList;
            }
            // found instance has wrong MRI
        }
        // instance was not found
        return null;
    }

    public Collection<CorePartitionable> getInstances( LRI lri ) {

        Collection<CorePartitionable> result = null;
        Object instanceOrList = modelElementInstances.get( lri );
        if ( instanceOrList == null ) {
            result = Collections.emptyList( );
        } else if ( instanceOrList instanceof Collection ) {
            result = (Collection<CorePartitionable>) instanceOrList;
        } else {
            result = Collections.singletonList( (CorePartitionable) instanceOrList );
        }
        return result;
    }

    public Set<CorePartitionable> getInstances( ) {

        HashSet<CorePartitionable> result = new HashSet<CorePartitionable>( );
        Collection<Object> elements = modelElementInstances.values( );
        for ( Object object : elements ) {
            if ( object instanceof Collection ) {
                result.addAll( (Collection<? extends CorePartitionable>) object );
            } else {
                result.add( (CorePartitionable) object );
            }
        }
        return result;
    }

    public Collection<Object> getInstancesLive( ) {

        return this.modelElementInstances.values( );
    }

    public Object getInstancesRaw( LRI lri ) {

        return modelElementInstances.get( lri );
    }

    public Workspace getWorkspace( ) {

        return this.workspace;
    }
}

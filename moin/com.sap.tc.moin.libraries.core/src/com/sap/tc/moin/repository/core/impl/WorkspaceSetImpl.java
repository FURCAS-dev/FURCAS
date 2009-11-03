package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObjectPool;
import com.sap.tc.moin.repository.core.EndStorageLinkFactory;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.SharedWorkspace;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.WrapperManager;
import com.sap.tc.moin.repository.core.locking.CompoundPartitionLockManagerImpl;
import com.sap.tc.moin.repository.core.locking.LockManagerRegistry;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclMetaModelConstraintWorkspaceSetRegistry;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclMofConstraintWorkspaceSetRegistry;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.spi.util.SpiMutableInteger;

public class WorkspaceSetImpl extends AbstractWorkspaceSet {

    private Set<SpiFacility> allFacilities;

    private Object nonSharedWorkspacesLock = new Object( );

    private Map<CompoundClientSpec, CompoundClientSpecWorkspace> compoundClientSpecWorkspaces;

    private Map<CoreSession, SessionWorkspace> sessionWorkspaces;

    private Map<CompoundClientSpec, SpiMutableInteger> compoundClientSpecSessionCounters;

    private Map<SpiStage, SharedWorkspace> sharedWorkspaces;

    //for convenience and garbage avoidance we keep the one and only metamodel clientspec also as array (with one element)
    private SpiClientSpec[] metamodelClientSpecAsArray;

    private CompoundDataArea compoundDataArea;

    private WrapperManager wrapperManager;

    private SynchronizationManager synchronizationManager;

    private LockManagerRegistry lockManagerRegistry;

    private OclMofConstraintWorkspaceSetRegistry mofConstraintRegistry;

    private OclMetaModelConstraintWorkspaceSetRegistry mmConstraintRegistry;

    public WorkspaceSetImpl( CoreMoin moin, CompoundDataArea compoundDataArea ) {

        super( moin );

        this.lockManagerRegistry = new LockManagerRegistry( this );
        this.compoundDataArea = compoundDataArea;
        this.wrapperManager = new WrapperManagerImpl( this );
        this.synchronizationManager = new SynchronizationManagerImpl( this );
        this.compoundClientSpecWorkspaces = new HashMap<CompoundClientSpec, CompoundClientSpecWorkspace>( );
        this.compoundClientSpecSessionCounters = new HashMap<CompoundClientSpec, SpiMutableInteger>( );
        this.sessionWorkspaces = new HashMap<CoreSession, SessionWorkspace>( );
        this.sharedWorkspaces = new HashMap<SpiStage, SharedWorkspace>( );
        this.allFacilities = new HashSet<SpiFacility>( );

        for ( Iterator<DataArea> iterator = this.compoundDataArea.getDataAreas( ).iterator( ); iterator.hasNext( ); ) {
            SpiDataArea dataArea = (SpiDataArea) iterator.next( );
            SpiFacility facilityForDataArea = (SpiFacility) dataArea.getFacility( );
            allFacilities.add( facilityForDataArea );
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, "Facility: " + facilityForDataArea + " is responsible for data area " + dataArea ); //$NON-NLS-1$ //$NON-NLS-2$
            }

            if ( dataArea.getDescriptor( ).isMetamodelDataArea( ) ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Data area " + dataArea + " is metamodel data area" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                this.sharedWorkspaces.put( moin.getMetamodelWorkspace( ).getStage( ), moin.getMetamodelWorkspace( ) );
                this.metamodelClientSpecAsArray = new SpiClientSpec[] { this.getMoin( ).getMetamodelClientSpec( ) };

            } else if ( dataArea.hasSingleStageOnly( ) && dataArea.getSingleStage( ).isClientSpecific( ) ) {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Data area " + dataArea + " has single stage which is clientspecific" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
            } else {
                for ( SpiStage stage : ( dataArea ).getAllSharedStages( ) ) {
                    SharedWorkspace sharedWorkspace = new SharedWorkspaceImpl( this, stage );
                    this.sharedWorkspaces.put( stage, sharedWorkspace );
                }
            }
        }
    }

    public Workspace getWorkspace( SpiStage stage, Session session ) {

        if ( stage.isClientSpecific( ) ) {
            synchronized ( nonSharedWorkspacesLock ) {
                return compoundClientSpecWorkspaces.get( session.getCompoundClientSpec( ) );
            }
        }
        return sharedWorkspaces.get( stage );
    }

    @Override
    public Collection<CompoundClientSpecWorkspace> getCompoundClientSpecWorkspaces( ) {

        synchronized ( nonSharedWorkspacesLock ) {
            return compoundClientSpecWorkspaces.values( );
        }
    }

    @Override
    public Collection<SharedWorkspace> getSharedWorkspaces( ) {

        return sharedWorkspaces.values( );
    }

    @Override
    public Collection<SessionWorkspace> getClientSpecificWorkspaces( ) {

        synchronized ( nonSharedWorkspacesLock ) {
            return new ArrayList<SessionWorkspace>( sessionWorkspaces.values( ) );
        }
    }

    public ReferenceManager getReferenceManager( ) {

        return getMoin( ).getMetamodelWorkspace( ).getWorkspaceSet( ).getReferenceManager( );
    }

    @Override
    public WrapperManager getWrapperManager( ) {

        return this.wrapperManager;
    }

    @Override
    public SynchronizationManager getSynchronizationManager( ) {

        return synchronizationManager;
    }

    @Override
    public RefPackage[] getPackages( String modelContainerName, String... qualifiedName ) {

        if ( !getMoin( ).isSecondStageInjected( ) && WorkspaceSet.OCL_PACKAGE_NAME.equals( qualifiedName[0] ) ) {
            this.getMoin( ).injectSecondMofRomStage( );
        }
        if ( modelContainerName == null ) {
            return getMoin( ).getExtentManager( ).selectRefPackages( qualifiedName );
        }
        return getMoin( ).getExtentManager( ).selectRefPackages( qualifiedName, new String[] { modelContainerName } );
    }

    public EndAndMetaObjectPool getEndAndMetaObjectPool( ) {

        return this.getMoin( ).getMetamodelWorkspace( ).getWorkspaceSet( ).getEndAndMetaObjectPool( );
    }


    @Override
    public boolean priExists( CoreSession session, PRI pri ) {

        boolean isInMetamodelDataArea = pri.getDataAreaDescriptor( ).isMetamodelDataArea( );
        Workspace workspace = null;
        // Check whether PRI is located in the MetaModelDataArea
        if ( isInMetamodelDataArea ) {
            workspace = this.getMoin( ).getMetamodelWorkspace( );
        } else {
            if ( session != null ) {
                workspace = session.getWorkspace( );
            } else {
                //no session and not in metamodel data area -> cannot be resolved
                if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                    logger.traceWithStack( MoinSeverity.WARNING, "PRI " + pri + " should be resolved, but session was null and PRI is not from metamodel data area, therefore returning false" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                return false;
            }
        }

        // try to get it from memory first
        CoreModelPartition partition = workspace.getPartitionManager( ).getPartition( session, pri, false );
        if ( partition != null ) {
            if ( partition.isAlive( ) ) {
                return true;
            } else {
                return false;
            }
        }

        ClientSpec clientSpec;
        if ( isInMetamodelDataArea ) {
            clientSpec = getMoin( ).getMetamodelClientSpec( );
        } else {
            clientSpec = session.getCompoundClientSpec( ).getClientSpec( pri.getDataAreaDescriptor( ) );
        }
        SpiFacility facility = (SpiFacility) getMoin( ).getFacilityById( pri.getDataAreaDescriptor( ).getFacilityId( ) );
        return facility.getCoreQueryService( ).isPartitionExistent( clientSpec, pri );
    }

    @Override
    public boolean mriExists( CoreSession session, MRI mri ) {

        if ( !priExists( session, mri.getPri( ) ) ) {
            return false;
        }

        Workspace workspace = null;
        // Check whether MRI is located in the MetaModel DataArea
        boolean isMriInMetaModelDataArea = mri.getDataAreaDescriptor( ).isMetamodelDataArea( );
        if ( isMriInMetaModelDataArea ) {
            workspace = this.getMoin( ).getMetamodelWorkspace( );
        } else {
            if ( session != null ) {
                workspace = session.getWorkspace( );
            } else {
                //no session and not in metamodel data area -> cannot be resolved
                if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                    logger.traceWithStack( MoinSeverity.WARNING, "MRI " + mri + " should be resolved, but session was null and MRI is not from metamodel data area, therefore returning false" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                return false;
            }
        }

        if ( workspace.getInstanceManager( ).getInstance( mri ) != null ) {
            return true;
        }

        ClientSpec[] clientSpecs;
        if ( isMriInMetaModelDataArea ) {
            clientSpecs = this.metamodelClientSpecAsArray;
        } else {
            Collection<ClientSpec> clientSpecsCollection = session.getCompoundClientSpec( ).getClientSpecs( );
            clientSpecs = clientSpecsCollection.toArray( new ClientSpec[clientSpecsCollection.size( )] );
        }

        SpiFacility facility = (SpiFacility) getMoin( ).getFacilityById( mri.getDataAreaDescriptor( ).getFacilityId( ) );
        PRI priForLri = null;
        if ( clientSpecs != null && clientSpecs.length > 0 ) {
            priForLri = facility.getCoreQueryService( ).getPriForLri( clientSpecs, mri.getLri( ) );
        }
        if ( priForLri == null ) {
            return false;
        }
        if ( !priForLri.equals( mri.getPri( ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public boolean lriExists( CoreSession session, LRI lri ) {

        DataAreaDescriptor dataAreaDescriptor = lri.getDataAreaDescriptor( );
        Workspace workspace = null;
        // Check whether LRI is located in the MetaModel DataArea
        boolean isMriInMetaModelDataArea = dataAreaDescriptor.isMetamodelDataArea( );
        if ( isMriInMetaModelDataArea ) {
            workspace = this.getMoin( ).getMetamodelWorkspace( );
        } else {
            if ( session != null ) {
                workspace = session.getWorkspace( );
            } else {
                //no session and not in metamodel data area -> cannot be resolved
                if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                    logger.traceWithStack( MoinSeverity.WARNING, "LRI " + lri + " should be resolved, but session was null and LRI is not from metamodel data area, therefore returning false" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                return false;
            }
        }

        if ( workspace.getInstanceManager( ).getInstance( session, lri ) != null ) {
            return true;
        }

        ClientSpec[] clientSpecs;

        if ( isMriInMetaModelDataArea ) {
            clientSpecs = this.metamodelClientSpecAsArray;
        } else {
            Collection<ClientSpec> clientSpecsCollection = session.getCompoundClientSpec( ).getClientSpecs( );
            clientSpecs = clientSpecsCollection.toArray( new ClientSpec[clientSpecsCollection.size( )] );
        }


        SpiFacility facility = (SpiFacility) getMoin( ).getFacilityById( dataAreaDescriptor.getFacilityId( ) );
        PRI pri = null;
        if ( clientSpecs != null && clientSpecs.length > 0 ) {
            pri = facility.getCoreQueryService( ).getPriForLri( clientSpecs, lri );
        }
        if ( pri == null ) {
            return false;
        }
        return priExists( session, pri );
    }


    @Override
    public CompoundDataArea getCompoundDataArea( ) {

        return this.compoundDataArea;
    }


    @Override
    public SpiSession createSession( SpiCompoundClientSpec compoundClientSpec ) {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Creating session for compound client specification: " + compoundClientSpec ); //$NON-NLS-1$
        }
        Set<SpiStage> allClientSpecificStages = new HashSet<SpiStage>( );
        for ( ClientSpec clientSpec : compoundClientSpec.getClientSpecs( ) ) {
            SpiClientSpec spiClientSpec = (SpiClientSpec) clientSpec;
            SpiStage clientSpecificStage = spiClientSpec.getClientSpecificStage( );
            if ( clientSpecificStage != null ) {
                allClientSpecificStages.add( spiClientSpec.getClientSpecificStage( ) );
            } else {
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Client spec " + spiClientSpec + " has no client specific stage" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
        }
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "All client specific stages: " + allClientSpecificStages ); //$NON-NLS-1$
        }
        SessionWorkspaceImpl sessionWorkspace = new SessionWorkspaceImpl( this, allClientSpecificStages );
        CoreSession result = new SessionImpl( sessionWorkspace, this, compoundClientSpec );
        sessionWorkspace.setSession( result );
        synchronized ( nonSharedWorkspacesLock ) {
            this.sessionWorkspaces.put( result, sessionWorkspace );
            //increment counter for compound client spec sessions
            SpiMutableInteger counter = this.compoundClientSpecSessionCounters.get( compoundClientSpec );
            if ( counter == null ) {
                counter = new SpiMutableInteger( 0 );
                this.compoundClientSpecSessionCounters.put( compoundClientSpec, counter );
                compoundClientSpecWorkspaces.put( compoundClientSpec, new CompoundClientSpecWorkspaceImpl( this, compoundClientSpec, allClientSpecificStages ) );
                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                    logger.trace( MoinSeverity.DEBUG, "Created CompoundClientSpecWorkspace for compound client specification: " + compoundClientSpec ); //$NON-NLS-1$
                }
            }
            counter.increment( );
        }
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Created session: " + result ); //$NON-NLS-1$
        }
        return result;
    }

    /**
     * Removes a ClientSpec Session entry from the map, which keeps the mapping
     * of ClientSpecs to existing Sessions
     * 
     * @param clientSpec the ClientSpec of the Session to be removed
     */
    @Override
    public void removeSession( Session session ) {

        synchronized ( nonSharedWorkspacesLock ) {
            CompoundClientSpec compoundClientSpec = session.getCompoundClientSpec( );
            sessionWorkspaces.remove( session );
            //decrement counter for compound client spec sessions and remove compound client spec workspace if dropping to 0
            SpiMutableInteger counter = this.compoundClientSpecSessionCounters.get( compoundClientSpec );
            counter.decrement( );
            if ( counter.getValue( ) == 0 ) {
                CompoundClientSpecWorkspace compoundClientSpecWorkspace = this.compoundClientSpecWorkspaces.remove( compoundClientSpec );
                this.compoundClientSpecSessionCounters.remove( compoundClientSpec );
                compoundClientSpecWorkspace.destroy( );

            }
        }
    }

    /**
     * For internal use (testing).
     * 
     * @return the number of session
     */
    @Override
    public int getNumberOfSessions( ) {

        synchronized ( nonSharedWorkspacesLock ) {
            return this.sessionWorkspaces.size( );
        }
    }

    /**
     * Returns all Sessions for the WorkspaceSet
     */
    @Override
    public Collection<CoreSession> getSessions( ) {

        synchronized ( nonSharedWorkspacesLock ) {
            return new ArrayList<CoreSession>( this.sessionWorkspaces.keySet( ) );
        }
    }

    @Override
    public Collection<CoreSession> getSessionsForClientId( String clientId ) {

        //TODO this method is quite expensive if there are a lot of sessions -> consider own mapping from clientId to session
        synchronized ( nonSharedWorkspacesLock ) {
            Set<CoreSession> sessions = this.sessionWorkspaces.keySet( );
            ArrayList<CoreSession> result = new ArrayList<CoreSession>( );
            for ( CoreSession coreSession : sessions ) {
                SpiCompoundClientSpec compoundClientSpec = coreSession.getCompoundClientSpec( );
                if ( compoundClientSpec.getId( ).equals( clientId ) ) {
                    result.add( coreSession );
                }
            }
            return result;
        }
    }

    @Override
    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( String clientId ) {

        synchronized ( nonSharedWorkspacesLock ) {
            Set<Entry<CompoundClientSpec, CompoundClientSpecWorkspace>> entrySet = this.compoundClientSpecWorkspaces.entrySet( );
            for ( Entry<CompoundClientSpec, CompoundClientSpecWorkspace> entry : entrySet ) {
                SpiCompoundClientSpec compoundClientSpec = (SpiCompoundClientSpec) entry.getKey( );
                if ( clientId.equals( compoundClientSpec.getId( ) ) ) {
                    return entry.getValue( );
                }
            }

            return null;
        }
    }

    @Override
    public PartitionLockManager getLockManager( ) {

        return new CompoundPartitionLockManagerImpl( this.lockManagerRegistry, this.compoundDataArea );
    }


    /**
     * Called by {@link MoinImpl#shutDown()}. If JMX is enabled, unregisters
     * this WorkspaceSet's MBeans. Initializes the JmiHelper's caches.
     */
    void shutDown( ) {

        if ( JMX_ENABLED ) {
            SpiJmxHelper.unregisterMBean( ( (SynchronizationManagerImpl) synchronizationManager ).getObjectName( ) );
        }

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Shutting down workspace set [" + this + "]" ); //$NON-NLS-1$//$NON-NLS-2$
        }

        Collection<CoreSession> sessions = getSessions( );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Sessions: " + sessions ); //$NON-NLS-1$
        }

        for ( CoreSession session : sessions ) {
            for ( CoreConnection conn : session.getConnections( ) ) {
                conn.shutdown( );
            }
            session.close( );
        }

        this.compoundDataArea = null;
        this.wrapperManager = null;
        this.synchronizationManager = null;
        this.sessionWorkspaces = null;
        this.sharedWorkspaces = null;
        this.allFacilities = null;
        this.lockManagerRegistry = null;


        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Finished shutdown of workspace set" ); //$NON-NLS-1$
        }
    }

    public boolean lockingTraceEnabled( ) {

        return ( (SynchronizationManagerImpl) synchronizationManager ).jmxNotificationsEnabled;
    }

    /**
     * Helper method only called if JMX is enabled. We need to pass the
     * partition lock event to the synchronization manager.
     */
    public void obtainedPartitionLock( PRI pri, ConnectionImpl connection, boolean coreLock, StackTraceElement[] stackTrace, long duration ) {

        ( (SynchronizationManagerImpl) synchronizationManager ).partitionLockObtain( pri, connection, coreLock, stackTrace, duration );
    }

    /**
     * Helper method only called if JMX is enabled. We need to pass the
     * partition lock release event to the synchronization manager.
     * 
     * @param stackTrace
     * @param duration
     */
    public void releasedPartitionLock( PRI resInfo, ConnectionImpl connection, boolean coreLock, StackTraceElement[] stackTrace, long duration ) {

        ( (SynchronizationManagerImpl) synchronizationManager ).partitionLockRelease( resInfo, connection, coreLock, stackTrace, duration );
    }

    public EndStorageLinkFactory getLinkFactory( ) {

        return getMoin( ).getMetamodelWorkspace( ).getWorkspaceSet( ).getLinkFactory( );
    }

    /**
     * @param connection
     * @return the connection-independent part of the OclMofConstraintRegistry
     * @throws OclManagerException
     */
    public OclMofConstraintWorkspaceSetRegistry getOrCreateOclConstraintRegistry( CoreConnection connection ) throws OclManagerException {

        if ( this.mofConstraintRegistry == null ) {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.traceWithStack( MoinSeverity.DEBUG, "Creating MofConstraintRegistry at workspace set " + this + ", responsible connection: " + connection ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            this.mofConstraintRegistry = new OclMofConstraintWorkspaceSetRegistry( connection );
        }
        return this.mofConstraintRegistry;
    }

    /**
     * @param connection
     * @return the connection-independent part of the OclMofConstraintRegistry
     */
    public OclMetaModelConstraintWorkspaceSetRegistry getOrCreateOclMMConstraintRegistry( CoreConnection connection ) {

        if ( this.mmConstraintRegistry == null ) {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.traceWithStack( MoinSeverity.DEBUG, "Creating MetamodelConstraintRegistry at workspace set " + this + ", responsible connection: " + connection ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            this.mmConstraintRegistry = new OclMetaModelConstraintWorkspaceSetRegistry( connection );
        }
        return this.mmConstraintRegistry;
    }

    @Override
    public String toString( ) {

        return "Workspace set: MOIN id = " + getMoin( ).getId( ) + ", compound data area = " + this.compoundDataArea; //$NON-NLS-1$//$NON-NLS-2$
    }

    @Override
    public CompoundClientSpecWorkspace getCompoundClientSpecWorkspace( CompoundClientSpec compoundClientSpec ) {

        synchronized ( nonSharedWorkspacesLock ) {
            return compoundClientSpecWorkspaces.get( compoundClientSpec );
        }
    }
}
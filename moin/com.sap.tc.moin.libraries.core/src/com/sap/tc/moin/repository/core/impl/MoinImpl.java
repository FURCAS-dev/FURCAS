package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerStandardMBean;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.MoinVersion;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.SessionCreationListener;
import com.sap.tc.moin.repository.Version;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.core.ConsistencyThread;
import com.sap.tc.moin.repository.core.Core;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreEventFactory;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EvictionThread;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.JmiClassResolver;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.MetamodelWorkspace;
import com.sap.tc.moin.repository.core.MoinWrapper;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.consistency.impl.ConsistencyViolationNotifThread;
import com.sap.tc.moin.repository.core.events.EventFactoryImpl;
import com.sap.tc.moin.repository.core.eviction.EvictionThreadImpl;
import com.sap.tc.moin.repository.core.jmi.util.JmiHelperImpl;
import com.sap.tc.moin.repository.core.links.LogicalLinkManagerImpl;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRom0;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRom1;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.core.transactions.microtransactionables.MicroTransactionableFactoryImpl;
import com.sap.tc.moin.repository.core.transactions.transactionables.TransactionableFactoryImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmx.MoinMBean;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.mmi.descriptors.ExtentDescriptor;
import com.sap.tc.moin.repository.runtimehost.MmInfoConst;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.HousekeepingThread;
import com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundClientSpec;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.core.SpiSession;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiMofRomInjectionService.SpiMofRomPartitionContent;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetaModelInfo;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.transactionables.TransactionableFactory;

/**
 * The Moin implementation representing a Moin instance.
 */
public final class MoinImpl implements CoreMoin {

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, MoinImpl.class );

    private Map<String, Facility> myFacilities;

    public static final boolean MOIN_CORE_CONSISTENCY_CHECKS = Boolean.getBoolean( MoinSystemPropertyKeys.MOIN_CORE_CONSISTENCY_CHECKS );

    private static final int MOIN_CORE_RUNTIME_MAJOR_VERSION = 9;

    private static final int MOIN_CORE_RUNTIME_MINOR_VERSION = 0;

    private final Version coreRuntimeVersion;
    
    private WeakHashMap<SessionCreationListener, Object> sessionCreationListeners = new WeakHashMap<SessionCreationListener, Object>();

    private boolean initialized = false;

    // MOIN THREADS
    private ConsistencyThread consistencyThread;

    private EvictionThread evictionThread;

    private HousekeepingThread housekeepingThread;

    // JMI class resolver
    private JmiClassResolver classResolver = null;

    // Metamodel catalog - exposed in API, could be deprecated
    private MetaModelCatalog mmCatalog = null;

    // meta-model registry - only in SPI, contract between core and runtimehost
    private SpiMetamodelRegistry metaModelRegistry;

    private SpiCompoundDataAreaManager compoundDataAreaManager = null;

    private MetamodelWorkspace metamodelWorkspace;

    private ExtentManager extentManager;

    private SpiClientSpec metamodelClientSpec;

    /**
     * Maps CompoundDataArea on WorkspaceSet
     */
    private Map<CompoundDataArea, WorkspaceSet> compoundDataAreaToWorkspaceSet = null;

    /**
     * This Moin instance's wrapper.
     */
    private MoinWrapper wrapper;

    /**
     * The name identifying this MOIN instance in JMX.
     */
    private ObjectName objectName;

    private final Comparator<Partitionable> mofIdComparator;

    private Core core;

    private SpiMetaModelInfo mofRomMetamodelInfo;

    private CRI mofRomCri = null;

    private boolean isSecondStageInjected = false;

    private MoinMofRomServicesImpl mofRomServices;

    private TransactionableFactory transactionableFactory;

    private MicroTransactionableFactory microTransactionableFactory;

    private CoreEventFactory eventFactory;

    private LogicalLinkManager logicalLinkManager;

    private SpiDataArea metamodelDataArea;

    private JmiHelperImpl jmiHelper;

    private SpiPartitionSerializationManager partitionSerializationManager;

    public MoinImpl( ) {

        this.coreRuntimeVersion = new VersionImpl( MOIN_CORE_RUNTIME_MAJOR_VERSION, MOIN_CORE_RUNTIME_MINOR_VERSION );
        this.mofIdComparator = new MofIdComparator( );

        this.resetInstance( );
    }

    public void resetInstance( ) {

        assert this.initialized == false : "MOIN instance not properly shut down"; //$NON-NLS-1$

        this.myFacilities = new HashMap<String, Facility>( );
        this.compoundDataAreaToWorkspaceSet = new HashMap<CompoundDataArea, WorkspaceSet>( );
        this.core = new CoreImpl( this );
        this.transactionableFactory = new TransactionableFactoryImpl( );
        this.microTransactionableFactory = new MicroTransactionableFactoryImpl( );
        this.eventFactory = new EventFactoryImpl( );
        this.housekeepingThread = new HousekeepingThread( this.getId( ) );

        this.logicalLinkManager = new LogicalLinkManagerImpl( this );
        this.jmiHelper = new JmiHelperImpl( this );
    }

    public synchronized void finalizeShutdown( ) {

        if ( housekeepingThread != null ) {
            this.housekeepingThread.requestShutdown( );
            try {
                this.housekeepingThread.join( );
            } catch ( InterruptedException ie ) {
                logger.trace( MoinSeverity.WARNING, "Housekeeping thread was interrupted during shutdown." ); //$NON-NLS-1$
            }
        }
    }

    public String getId( ) {

        return String.valueOf( System.identityHashCode( this ) );
    }

    public Comparator<Partitionable> getByMofIdComparator( ) {

        return this.mofIdComparator;
    }

    /**
     * Initializes the MOIN instance with the specified facilities.
     * <p>
     * This will fail once the instance has already been initialized unless it
     * was shut down in the meantime.
     * <p>
     * This method should <em>only</em> be called by the Moin initializer!
     * 
     * @param facilities a collection of {@link Facility} objects for the MOIN
     * @param compoundDataAreaManager compound data area manager
     * @param metamodelCatalog the catalog (API view on deployed meta-models)
     * @param metamodelRegistry the meta-model registry (core internal view on
     * deployed meta-models)
     * @param partitionSerializationManager the serialization manager (customer
     * parser/serialized registry)
     * @see #shutDown()
     */
    public synchronized void init( Collection<Facility> facilities, SpiCompoundDataAreaManager compoundDataAreaManager, MetaModelCatalog metamodelCatalog, SpiMetamodelRegistry metamodelRegistry, SpiPartitionSerializationManager partitionSerializationManager ) {

        if ( this.initialized ) {
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.traceWithStack( MoinSeverity.ERROR, "Moin (id = " + getId( ) + ") is already initialized - shutdown has to be called before reinitialization." ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            throw new MoinIllegalStateException( CoreImplMessages.MOINISALREADYINITIALIZED );
        }

        this.partitionSerializationManager = partitionSerializationManager;

        this.metaModelRegistry = metamodelRegistry;

        this.classResolver = new JmiClassResolverImpl( metamodelRegistry );

        this.compoundDataAreaManager = compoundDataAreaManager;

        for ( Facility facility : facilities ) {
            this.myFacilities.put( facility.getId( ), facility );
        }

        this.mmCatalog = metamodelCatalog;

        this.evictionThread = new EvictionThreadImpl( this.getId( ), this.getReferenceQueue( ) );
        this.consistencyThread = new ConsistencyViolationNotifThread( this.getId( ) );

        if ( JMX_ENABLED ) {
            objectName = getObjectName( );
            new JmxAdapter( this, objectName, this.getReferenceQueue( ) );
        }

        metamodelDataArea = null;
        SpiFacility metamodelFacility = null;

        for ( Facility facility : facilities ) {
            metamodelFacility = (SpiFacility) facility;

            metamodelDataArea = (SpiDataArea) metamodelFacility.getMetamodelDataArea( );

            if ( metamodelDataArea != null ) {
                break;
            }
        }

        if ( metamodelFacility == null || metamodelDataArea == null ) {
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.traceWithStack( MoinSeverity.ERROR, "Metamodel data area or facility could not be found." ); //$NON-NLS-1$
            }
            throw new MoinIllegalStateException( CoreImplMessages.METAMODELDATAAREAORFACILITYNOTFOUND );
        }

        checkMetamodelDataAreaSanity( metamodelDataArea );

        this.metamodelWorkspace = new MetamodelWorkspaceImpl( new MetamodelWorkspaceSetImpl( this ), metamodelDataArea.getSingleStage( ), metamodelFacility.getMetamodelClientSpec( ), metamodelFacility.getRIFactory( ) );
        this.extentManager = new ExtentManagerImpl( metamodelWorkspace, Collections.singletonList( metamodelFacility.getCoreQueryService( ) ) );

        this.metamodelClientSpec = metamodelFacility.getMetamodelClientSpec( );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "MOIN initialized, id = " + getId( ) ); //$NON-NLS-1$
        }

        injectMofRom( );

        this.initialized = true;
    }

    public TransactionableFactory getTransactionableFactory( ) {

        return transactionableFactory;
    }

    public MicroTransactionableFactory getMicroTransactionableFactory( ) {

        return this.microTransactionableFactory;
    }

    public CoreEventFactory getEventFactory( ) {

        return this.eventFactory;
    }

    public SpiClientSpec getMetamodelClientSpec( ) {

        return metamodelClientSpec;
    }

    public Extent getExtent( ExtentDescriptor extentDescriptor ) {

        if ( !isSecondStageInjected( ) && WorkspaceSet.OCL_PACKAGE_NAME.equals( extentDescriptor.getQualifiedName( )[0] ) ) {
            this.injectSecondMofRomStage( );
        }
        Extent extent = getExtentManager( ).selectExtent( extentDescriptor.getMofIdOfMetaObject( ), extentDescriptor.getQualifiedName( ), extentDescriptor.getModelContainerName( ) );
        return extent;
    }

    public LogicalLinkManager getLogicalLinkManager( ) {

        return logicalLinkManager;
    }

    public SpiJmiHelper getJmiHelper( ) {

        return jmiHelper;
    }

    public CorePartitionable resolveMri( CoreSession session, MRI mri ) {

        return getWorkspaceSetForDataArea( mri.getDataAreaDescriptor( ), session ).resolveMri( session, mri );
    }

    public CoreModelPartition resolvePri( CoreSession session, PRI pri ) {

        return getWorkspaceSetForDataArea( pri.getDataAreaDescriptor( ), session ).resolvePri( session, pri );
    }

    private WorkspaceSet getWorkspaceSetForDataArea( DataAreaDescriptor descriptor, CoreSession session ) {

        WorkspaceSet ret = null;

        if ( descriptor.isMetamodelDataArea( ) ) {
            ret = getMetamodelWorkspace( ).getWorkspaceSet( );
        } else {
            if ( session == null ) {
                throw new MoinIllegalStateException( CoreImplMessages.SESSIONHASTOBEPROVIDED, descriptor );
            }

            ret = session.getWorkspaceSet( );
        }

        return ret;

    }

    private void injectMofRom( ) {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Injecting MOF ROM Phase 0 for workspace set: " + this ); //$NON-NLS-1$
        }

        SpiDataArea metamodelDataArea = getMetamodelWorkspace( ).getMetamodelDataArea( );

        // inject the MOF ROM
        Workspace modelElementWorkspace = getMetamodelWorkspace( );
        Workspace extentWorkspace = getMetamodelWorkspace( );
        DataAreaDescriptor dataAreaDescriptor = metamodelDataArea.getDescriptor( );
        ResourceIdentifierFactory riFactory = metamodelDataArea.getFacility( ).getRIFactory( );
        mofRomServices = new MoinMofRomServicesImpl( modelElementWorkspace, extentWorkspace, riFactory, dataAreaDescriptor );
        mofRomServices.injectMofRomPhase( new MoinMofRom0( ) );
    }

    public boolean isSecondStageInjected( ) {

        return isSecondStageInjected;
    }

    public synchronized void injectSecondMofRomStage( ) {

        if ( isSecondStageInjected ) {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.traceWithStack( MoinSeverity.DEBUG, "Attempt to inject second MOF ROM phase again for Moin: " + this ); //$NON-NLS-1$
            }
            return;
        }
        List<SpiMofRomPartitionContent> mofRomPartitions;
        synchronized ( getExtentManager( ) ) {
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, "Injecting MOF ROM Phase 1 for workspace set: " + this ); //$NON-NLS-1$
            }
            mofRomServices.injectMofRomPhase( new MoinMofRom1( ) );
//            ( (ExtentManagerImpl) getExtentManager( ) ).resetTopLevelExtents( );

            // index additional content
            mofRomPartitions = new ArrayList<SpiMofRomPartitionContent>( );
            for ( SpiModelPartition partition : getMetamodelWorkspace( ).getPartitionManager( ).getLoadedPartitionsLive( ) ) {
                if ( partition.isAlive( ) ) {
                    PRI pri = partition.getPri( );
                    if ( pri.getContainerName( ).equals( MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME ) ) {
                        SpiMofRomPartitionContent content = new MofRomPartitionContent( partition );
                        mofRomPartitions.add( content );
                    }
                }
            }
        }

        //JIRA MOIN-3595
        //the injection has to take place outside the synchronized block. Problem is that the facility index is holding a lock
        //while indexing partitions and additionaly requires the extent manager lock. The mof rom injection into the index requires the index lock, too.
        //So if we do the injection within the extent manager synchronized block we have a deadlock as soon as an other thread is concurrently indexing
        //and requires the extent manager lock
        ( (SpiFacility) getMetamodelWorkspace( ).getMetamodelDataArea( ).getFacility( ) ).getMofRomInjectionService( ).injectMofRomPartitions( mofRomPartitions );
        this.isSecondStageInjected = true;
    }


    private void checkMetamodelDataAreaSanity( SpiDataArea metamodelDataArea ) {

        List<SpiStage> allSharedStages = metamodelDataArea.getAllSharedStages( );
        if ( allSharedStages.size( ) != 1 ) {
            String message = "The MetamodelDataArea " + metamodelDataArea.getName( ) + " has got " + allSharedStages.size( ) + " shared stages, instead of a single shared Stage"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, message );
            }
            throw new IllegalStateException( message );
        }
    }


    public void shutdownThreads( ) {

        // TODO let runtimehost create threads via "MoinRunnable"
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Requesting shutdown of consistency thread." ); //$NON-NLS-1$
        }
        this.consistencyThread.requestShutdown( );
        try {
            ( (Thread) this.consistencyThread ).join( );
        } catch ( InterruptedException e ) {
            logger.trace( MoinSeverity.WARNING, "Consistency thread interrupted during shut down." ); //$NON-NLS-1$
        }
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Requesting shutdown of eviction thread." ); //$NON-NLS-1$
        }
        this.evictionThread.requestShutdown( );
        try {
            ( (Thread) this.evictionThread ).join( );
        } catch ( InterruptedException e ) {
            logger.trace( MoinSeverity.WARNING, "Eviction thread interrupted during shut down." ); //$NON-NLS-1$
        }

        this.consistencyThread = null;
        this.evictionThread = null;

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Shutdown of consistency and eviction thread finished." ); //$NON-NLS-1$
        }
    }

    /**
     * Shuts down the MOIN instance.
     * <p>
     * This method should <em>only</em> be called by the Moin initializer!
     * 
     * @see #init
     */
    public synchronized void shutDown( ) {

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.traceWithStack( MoinSeverity.DEBUG, "MOIN shutdown starting, id = " + getId( ) ); //$NON-NLS-1$
        }

        this.initialized = false;
        this.isSecondStageInjected = false;

        myFacilities.clear( );

        if ( JMX_ENABLED ) {
            SpiJmxHelper.unregisterMBean( objectName );
        }

        for ( WorkspaceSet workspaceSet : compoundDataAreaToWorkspaceSet.values( ) ) {
            SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                //Micro write lock is needed because that's also the lock for closing of session
                //and during shutdown of workspace set the session is also closed
                synchronizationManager.acquireMicroWriteLock( );
                try {
                    ( (WorkspaceSetImpl) workspaceSet ).shutDown( );
                } finally {
                    synchronizationManager.releaseMicroWriteLock( );
                }
            }
        }

        getJmiHelper( ).initializeCaches( );

        this.metamodelWorkspace = null;
        this.extentManager = null;


        this.compoundDataAreaToWorkspaceSet.clear( );

        this.mofRomCri = null;
        this.mofRomMetamodelInfo = null;
        this.mmCatalog = null;
        this.compoundDataAreaManager = null;
        this.classResolver = null;
        this.core.shutDown( );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "MOIN shutdown finished, id = " + getId( ) ); //$NON-NLS-1$
        }
    }

    public Core getCore( ) {

        return this.core;
    }

    public Facility getFacilityById( String facilityId ) {

        return this.myFacilities.get( facilityId );
    }

    public Collection<Facility> getFacilities( ) {

        return this.myFacilities.values( );
    }

    public synchronized SpiSession createSession( CompoundClientSpec compoundClientSpec ) {

        // Get or Create WorkspaceSet for given CompoundClientSpec
        WorkspaceSet workspaceSet = getOrCreateWorkspaceSet( compoundClientSpec.getCompoundDataArea( ) );
        SpiSession result = workspaceSet.createSession( (SpiCompoundClientSpec) compoundClientSpec );
        fireSessionCreated(result);
        return result;
    }
    
    private void fireSessionCreated(SpiSession session) {
	for (SessionCreationListener listener : sessionCreationListeners.keySet()) {
	    listener.sessionCreated(((CoreSession) session).getWrapper());
	}
    }

    /**
     * For internal use (testing). Iterates over WorkspaceSets and asks for
     * number of sessions in each WorkspaceSet
     * 
     * @return the number of sessions of all WorkspaceSets
     */
    public synchronized int getNumberOfSessions( ) {

        int size = 0;
        for ( WorkspaceSet workspaceSet : compoundDataAreaToWorkspaceSet.values( ) ) {
            size += workspaceSet.getNumberOfSessions( );
        }
        return size;
    }

    /**
     * Iterates over WorkspaceSets and Collects all sessions
     * 
     * @return the running sessions
     */
    public synchronized Collection<SpiSession> getSessions( ) {

        Collection<SpiSession> sessions = new HashSet<SpiSession>( );
        for ( WorkspaceSet workspaceSet : compoundDataAreaToWorkspaceSet.values( ) ) {
            sessions.addAll( workspaceSet.getSessions( ) );
        }
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Moin.getSessions(): Session list " + sessions ); //$NON-NLS-1$
        }
        return Collections.unmodifiableCollection( sessions );
    }

    private String getFacilityId( String mriString ) throws InvalidResourceIdentifierException {

        String scheme = null;
        int colonPos = mriString.indexOf( ':' );
        if ( colonPos > -1 ) {
            int dotPos = mriString.indexOf( '.' );
            if ( ( dotPos > -1 ) && ( dotPos < colonPos ) ) {
                scheme = mriString.substring( 0, dotPos );
            } else {
                scheme = mriString.substring( 0, colonPos );
            }
        }
        if ( scheme != null ) {
            return scheme;
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.NO_FACILITY_DEFINED );
        }
    }

    private ResourceIdentifierFactory getResourceIdentifierFactory( String scheme ) {

        Facility mriFacility = null;
        if ( scheme != null ) {
            mriFacility = this.getFacilityById( scheme );
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.NO_FACILITY_DEFINED );
        }

        ResourceIdentifierFactory mriFactory = null;
        if ( mriFacility != null ) {
            mriFactory = mriFacility.getRIFactory( );
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.FACILITY_NOT_FOUND, scheme );
        }
        return mriFactory;
    }

    /**
     * Gets the catalog of already deployed meta-models. The
     * {@link MetaModelCatalog} is exposed to the consumer API.
     * 
     * @see Moin#getMetamodelCatalog()
     * @return catalog of already deployed meta-models.
     */
    public MetaModelCatalog getMetamodelCatalog( ) {

        return this.mmCatalog;
    }


    /**
     * Gets the meta-model registry. The MetaModelRegistry represents the
     * internal contract between Core and Runtimehost.
     * 
     * @see com.sap.tc.moin.repository.core.CoreMoin#getMetaModelRegistry()
     */
    public SpiMetamodelRegistry getMetaModelRegistry( ) {

        return this.metaModelRegistry;
    }

    public PRI createPri( String priString ) throws InvalidResourceIdentifierException {

        String scheme = getFacilityId( priString );
        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( scheme );
        if ( riFactory != null ) {
            return riFactory.createPri( priString );
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.NO_FACILITY_DEFINED );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.ResourceIdentifierFactory#createLri(java.lang
     * .String)
     */
    public LRI createLri( String lri ) throws InvalidResourceIdentifierException {

        String scheme = getFacilityId( lri );
        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( scheme );
        if ( riFactory != null ) {
            return riFactory.createLri( lri );
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.NO_FACILITY_DEFINED );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.repository.ResourceIdentifierFactory#createMri(java.lang
     * .String)
     */
    public MRI createMri( String mri ) throws InvalidResourceIdentifierException {

        String scheme = getFacilityId( mri );
        // check internal facility first
        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( scheme );
        if ( riFactory != null ) {
            return riFactory.createMri( mri );
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.NO_FACILITY_DEFINED );
        }
    }

    public CRI createCri( String cri ) {

        String scheme = getFacilityId( cri );
        // check internal facility first
        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( scheme );
        if ( riFactory != null ) {
            return riFactory.createCri( cri );
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.NO_FACILITY_DEFINED );
        }
    }

    public MRI createMri( String facilityId, String dataAreaName, String containerName, String partitionName, String mofId ) {

        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( facilityId );
        return riFactory.createMri( dataAreaName, containerName, partitionName, mofId );
    }

    public PRI createPri( String facilityId, String dataAreaName, String containerName, String partitionName ) {

        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( facilityId );
        return riFactory.createPri( dataAreaName, containerName, partitionName );
    }

    public LRI createLri( String facilityId, String dataAreaName, String mofId ) {

        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( facilityId );
        return riFactory.createLri( dataAreaName, mofId );
    }

    public CRI createCri( String facilityId, String dataAreaName, String containerName ) {

        ResourceIdentifierFactory riFactory = getResourceIdentifierFactory( facilityId );
        return riFactory.createCri( dataAreaName, containerName );
    }

    public SpiCompoundDataAreaManager getCompoundDataAreaManager( ) {

        return this.compoundDataAreaManager;
    }

    /**
     * Returns the {@link WorkspaceSet} for the given {@link CompoundDataArea}.
     * 
     * @param compoundDataArea
     * @return
     */
    private WorkspaceSet getOrCreateWorkspaceSet( CompoundDataArea compoundDataArea ) {

        WorkspaceSet workspaceSet = this.compoundDataAreaToWorkspaceSet.get( compoundDataArea );
        if ( workspaceSet == null ) {
            workspaceSet = new WorkspaceSetImpl( this, compoundDataArea );
            this.compoundDataAreaToWorkspaceSet.put( compoundDataArea, workspaceSet );
            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, "Created new workspace set [" + workspaceSet + "]" ); //$NON-NLS-1$//$NON-NLS-2$
            }
        }
        return workspaceSet;
    }

    public WorkspaceSet getWorkspaceSet( CompoundDataArea compoundDataArea ) {

        return this.compoundDataAreaToWorkspaceSet.get( compoundDataArea );
    }

    public Collection<WorkspaceSet> getWorkspaceSets( ) {

        return this.compoundDataAreaToWorkspaceSet.values( );
    }

    public final CoreConnection getCurrentConnection( ) {

        throw new UnsupportedOperationException( "getCurrentConnection() is no longer supported, must be a bug if this method is still called. Please report to the MOIN team." ); //$NON-NLS-1$
    }

    public JmiClassResolver getJmiClassResolver( ) {

        return this.classResolver;
    }

    public MoinWrapper getWrapper( ) {

        if ( wrapper == null ) {
            wrapper = new MoinWrapper( this );
        }
        return wrapper;
    }


    public ObjectName getObjectName( ) {

        try {
            return new ObjectName( MOIN_DOMAIN + "type=Moin,id=" + getId( ) ); //$NON-NLS-1$
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
    }

    static final class MofIdComparator implements Comparator<Partitionable> {

        MofIdComparator( ) {

        }

        public int compare( Partitionable partitionable1, Partitionable partitionable2 ) {

            String mofId1 = partitionable1.refMofId( );
            String mofId2 = partitionable2.refMofId( );
            if ( mofId1 == mofId2 ) {
                return 0;
            }
            return mofId1.compareTo( mofId2 );
        }
    }

    private static final class JmxAdapter implements MoinMBean {

        private final WeakReferenceWithObjectName<MoinImpl> moinRef;

        private final long startTime;

        private JmxAdapter( MoinImpl moin, ObjectName objectName, ReferenceQueue refQueue ) {

            moinRef = new WeakReferenceWithObjectName<MoinImpl>( moin, objectName, refQueue );
            registerStandardMBean( this, MoinMBean.class, objectName );
            startTime = System.currentTimeMillis( );
        }

        public String getMoinVersionNumber( ) {

            MoinVersion moinVersion = Moin.class.getAnnotation( MoinVersion.class );
            return moinVersion.versionNumber( );
        }

        public String getMoinVersionDate( ) {

            MoinVersion moinVersion = Moin.class.getAnnotation( MoinVersion.class );
            return moinVersion.versionDate( );
        }

        public String getMoinVersionComment( ) {

            MoinVersion moinVersion = Moin.class.getAnnotation( MoinVersion.class );
            return moinVersion.versionComment( );
        }

        public String getUptime( ) {

            long uptime = System.currentTimeMillis( ) - startTime;
            long days, hours, minutes, seconds;
            days = uptime / 86400000;
            uptime = uptime - ( days * 86400000 );
            hours = uptime / 3600000;
            uptime = uptime - ( hours * 3600000 );
            minutes = uptime / 60000;
            uptime = uptime - ( minutes * 60000 );
            seconds = uptime / 1000;
            return days + "d " + hours + "h " + minutes + "m " + seconds + "s"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
        }

        public String getStartedAt( ) {

            DateFormat formatter = DateFormat.getDateTimeInstance( DateFormat.FULL, DateFormat.FULL );
            return formatter.format( new Date( startTime ) );
        }

        public String getMoinCoreRuntimeVersionMajor( ) {

            MoinImpl moin = moinRef.get( );
            if ( moin != null ) {
                return String.valueOf( MOIN_CORE_RUNTIME_MAJOR_VERSION );
            }
            return null;
        }

        public String getMoinCoreRuntimeVersionMinor( ) {

            MoinImpl moin = moinRef.get( );
            if ( moin != null ) {
                return String.valueOf( MOIN_CORE_RUNTIME_MINOR_VERSION );
            }
            return null;
        }

        public String checkConsistencyOfMoinCore( ) throws IOException {

            return checkCoreConsistency( false /* withoutLocks */);
        }

        public String checkConsistencyOfMoinCoreWithoutLocks( ) throws IOException {

            return checkCoreConsistency( true /* withoutLocks */);
        }

        private String checkCoreConsistency( boolean withoutLocks ) {

            MoinImpl moin = moinRef.get( );
            if ( moin != null ) {
                MoinCoreConsistencyChecker checker = new MoinCoreConsistencyChecker( moin, withoutLocks );
                CheckResult result = checker.performAllChecks( );
                if ( result.isEmpty( ) ) {
                    return "No incidents found"; //$NON-NLS-1$
                }
                return result.toString( );
            }
            return null;
        }
    }

    public Version getCoreRuntimeVersion( ) {

        return this.coreRuntimeVersion;
    }

    public void finalizeStartup( ) {

        //MOFROM INJECTION
        this.injectMofRomIntoFacility( );
    }

    public CRI getMofRomCri( ) {

        return this.mofRomCri;
    }

    public SpiMetaModelInfo getMofRomInfo( ) {

        if ( mofRomMetamodelInfo == null ) {
            mofRomMetamodelInfo = new MofRomMetamodelInfo( getMofRomCri( ) );
        }
        return mofRomMetamodelInfo;
    }

    public void injectMofRomIntoFacility( ) {

        // obtain the MOFROM partitions
        List<SpiMofRomPartitionContent> mofRomPartitions = new ArrayList<SpiMofRomPartitionContent>( );
        for ( SpiModelPartition partition : getMetamodelWorkspace( ).getPartitionManager( ).getLoadedPartitionsLive( ) ) {
            if ( partition.isAlive( ) ) {
                PRI pri = partition.getPri( );
                if ( pri.getContainerName( ).equals( MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME ) ) {
                    SpiMofRomPartitionContent content = new MofRomPartitionContent( partition );
                    mofRomPartitions.add( content );
                    if ( this.mofRomCri == null ) {
                        String mofRomFacilityId = pri.getDataAreaDescriptor( ).getFacilityId( );
                        String mofRomDataAreaName = pri.getDataAreaDescriptor( ).getDataAreaName( );
                        this.mofRomCri = this.createCri( mofRomFacilityId, mofRomDataAreaName, MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME );
                    }
                }
            }
        }

        // only do something if they exist
        if ( mofRomPartitions.isEmpty( ) ) {
            throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.MOFROMNOTLOADEDATTHISTIME );
        }

        SpiFacility facility = (SpiFacility) this.getFacilityById( this.mofRomCri.getDataAreaDescriptor( ).getFacilityId( ) );
        // perform the injection
        facility.getMofRomInjectionService( ).injectMofRomPartitions( mofRomPartitions );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "Moin - inject MOF ROM into facility " + facility + " ; MOF ROM partitions " + mofRomPartitions ); //$NON-NLS-1$ //$NON-NLS-2$
        }

    }

    private static final class MofRomPartitionContent implements SpiMofRomPartitionContent {

        private PRI pri;

        private List<Partitionable> elements;

        private List<SpiLink> links;

        public MofRomPartitionContent( SpiModelPartition partition ) {

            this.pri = partition.getPri( );
            this.elements = new ArrayList( partition.getElements( ) );
            this.links = new ArrayList( partition.getLinks( ) );
        }

        public List<Partitionable> getElements( ) {

            return this.elements;
        }

        public List<SpiLink> getLinks( ) {

            return this.links;
        }

        public PRI getPri( ) {

            return pri;
        }

    }

    public ConsistencyThread getConsistencyThread( ) {

        return this.consistencyThread;
    }

    public EvictionThread getEvictionThread( ) {

        return this.evictionThread;
    }

    public ReferenceQueue getReferenceQueue( ) {

        return this.housekeepingThread.getReferenceQueue( );
    }

    public ExtentManager getExtentManager( ) {

        return extentManager;
    }

    public MetamodelWorkspace getMetamodelWorkspace( ) {

        return metamodelWorkspace;
    }

    public SpiDataArea getMetamodelDataArea( ) {

        return metamodelDataArea;
    }


    private static final class MofRomMetamodelInfo implements SpiMetaModelInfo {

        private DeploymentExtension extension;

        private CRI cri;

        private MetaModelVersion version;

        public MofRomMetamodelInfo( CRI cri ) {

            this.cri = cri;
        }

        public CRI getContainer( ) {

            return cri;
        }

        public DeploymentExtension getMmExtensionInstance( ) {

            if ( extension == null ) {
                extension = MoinMofRomServicesImpl.createMofDeploymentExtension( );
            }
            return extension;
        }

        public String getContainerName( ) {

            return getContainer( ).getContainerName( );
        }

        public String getDeployedMetaModelFacilityName( ) {

            return getContainer( ).getDataAreaDescriptor( ).getFacilityId( );
        }


        public MetaModelVersion getDeployedMetaModelVersion( ) {

            if ( version == null ) {
                version = new MetaModelVersion( ) {

                    public String getVersionString( ) {

                        // TODO where to get it really from ???
                        return "1.0"; //$NON-NLS-1$
                    }
                };
            }
            return version;
        }

        public String getName( ) {

            return getContainerName( );
        }

        public String getVendor( ) {

            return "sap.com"; //$NON-NLS-1$
        }

        public String getMetaModelResourceBundleName( ) {

            // use default bundle name
            return MmInfoConst.MM_RESOURCEBUNDLE_NAME;
        }

    }

    public SpiPartitionSerializationManager getPartitionSerializationManager( ) {

        return partitionSerializationManager;
    }

    @Override
    public void addSessionCreationListener(SessionCreationListener listener) {
	sessionCreationListeners.put(listener, null);
    }

    @Override
    public void fireInitialized() {
	for (SessionCreationListener listener : sessionCreationListeners.keySet()) {
	    listener.moinInitialized(this.getWrapper());
	}
    }

}

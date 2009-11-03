package com.sap.tc.moin.repository.runtimehost.ide;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerStandardMBean;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.unregisterMBean;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.SessionCreationListener;
import com.sap.tc.moin.repository.admin.ide.IdeRuntimeHost;
import com.sap.tc.moin.repository.cdam.ide.impl.IdeCompoundDataAreaManagerImpl;
import com.sap.tc.moin.repository.core.MoinWrapper;
import com.sap.tc.moin.repository.core.impl.ExtentManagerImpl;
import com.sap.tc.moin.repository.core.impl.MoinImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.ide.IdeMoin;
import com.sap.tc.moin.repository.ide.impl.IdeMoinWrapperImpl;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentManager;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;
import com.sap.tc.moin.repository.jmx.RuntimeHostIdeMBean;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.MoinInstanceManager;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.ide.IdeMetaModelReceiverImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.ide.MmGeneratorImpl;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityFactory;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * The main-class of the plugin. It is mostly used to access the 'environment'
 * of this plugin.
 */
public class IdeRuntimeHostImpl extends AbstractUIPlugin implements IdeRuntimeHost {

    public final String ROOT_FOLDER_FOR_RESOURCES = "resources/"; //$NON-NLS-1$

    protected final String FACILITY_EX_POINT_NAME = "com.sap.tc.moin.runtime.MoinFacility"; //$NON-NLS-1$

    protected final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

    protected final String FACILITY_PARTICIPANT = "facilityParticipant"; //$NON-NLS-1$

    // MOIN logger
    private static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, IdeRuntimeHostImpl.class );

    // the instance of the RuntimeHost plug-in
    private static IdeRuntimeHostImpl _plugin;

    // Deployment - MetaModel Receiver
    protected IdeMetaModelReceiverImpl mmReceiver = null;

    // Initialization
    private MoinInstanceManager moinInstanceManager = null;

    private PartitionSerializationManagerImpl partitionSerializationManager = null;

    private MmGenerator mmGenerator = null;

    /**
     * The name identifying the runtime host in JMX.
     */
    private ObjectName objectName;

    // MOIN status - running / not running
    private boolean moinRunning = false;

    // the js-specific moin wrapper instance
    private IdeMoin ideMoinWrapper;

    /**
     * Creates the Plugin and caches its default instance.
     */
    public IdeRuntimeHostImpl( ) {

    }

    // ============ overwritten methods of AbstractUIPlugin ====================

    /**
     * This method is called upon plug-in activation
     */
    @Override
    public void start( BundleContext context ) throws Exception {

        super.start( context );

        // meta-model receiver and moin is started lazily upon first client request
        _plugin = this;
    }

    /**
     * This method is called when the plug-in is stopped
     */
    @Override
    public void stop( BundleContext context ) throws Exception {

        super.stop( context );

        if ( this.moinInstanceManager != null ) {
            this.stopMoin( );
        }

        _plugin = null;
    }

    // ======================== static access methods ==========================

    /**
     * Gets the default-instance of this plugin. Actually the default-instance
     * should always be the only instance -> Singleton.
     */
    public static IdeRuntimeHostImpl getDefault( ) {

        return _plugin;
    }

    // =========================== MOIN methods ===========================
    public synchronized IdeMoin getMoinInstance( ) {

        if ( this.moinInstanceManager == null ) {
            com.tssap.util.ui.UIPlugin.getDefault( );
        }

        if ( _log.isTraced( MoinSeverity.INFO ) ) {
            _log.trace( MoinSeverity.INFO, "Client calls for MOIN instance." ); //$NON-NLS-1$
        }
        if ( this.moinRunning == false ) {
            // Start MOIN - instantiate and configure MOIN and facilities
            this.startMoin( null );
        }

        if ( ideMoinWrapper == null ) {
            // must not happen
            throw new MoinIllegalStateException( IdeRuntimeHostMessages.MOIN_WRAPPER_NOT_INITIALIZED );
        }

        return ideMoinWrapper;
    }

    public Moin resetMoin( ) {

        if ( this.isMoinRunning( ) ) {
            SpiMoin existingMoin = this.moinInstanceManager.moin;
            existingMoin.shutdownThreads( );
            synchronized ( existingMoin ) {
                synchronized ( this ) {
                    this.stopMoinInternal( );
                    ( (MoinImpl) existingMoin ).resetInstance( );

                    Moin startedMoinWrapper;
                    startedMoinWrapper = this.startMoin( existingMoin );

                    if ( existingMoin.getWrapper( ) != startedMoinWrapper || existingMoin != ( (MoinWrapper) startedMoinWrapper ).unwrap( ) ) {
                        throw new MoinIllegalStateException( IdeRuntimeHostMessages.RESETTED_MOIN_INSTANCE_CHANGED );
                    }

                    return startedMoinWrapper;
                }
            }
        } else {
            return this.startMoin( null );
        }
    }

    private Moin startMoin( SpiMoin existingMoinObject ) {

        this.moinRunning = false;

        if ( _log.isTraced( MoinSeverity.INFO ) ) {
            _log.trace( MoinSeverity.INFO, "Initialize MOIN startup." ); //$NON-NLS-1$
        }

        // First step - initialize MOIN
        SpiMoin spiMoin = this.initializeMoin( existingMoinObject );

        if ( spiMoin == null ) {
            _log.trace( MoinSeverity.FATAL, "MOIN not initialized. Please check the trace for more information." ); //$NON-NLS-1$
            return spiMoin;
        }

        try {
            if ( JMX_ENABLED ) {
                objectName = getObjectName( );
                new JmxAdapter( this, objectName );
            }
        } catch ( RuntimeException e ) {
            // no exception during Runtime Host plug-in initialization
            _log.trace( e, MoinSeverity.FATAL, "IdeRuntimeHost.initializeMoin(): JMX runtime exception during MOIN startup - exception: " ); //$NON-NLS-1$
        }

        // Second step - Initialize meta-models
        // Check the meta-model status and deploy not-deployed meta-models
        _log.trace( MoinSeverity.INFO, "Initialize MOIN meta-models." ); //$NON-NLS-1$
        this.initializeMetaModels( spiMoin );

        // Third step - Finalize MOIN and facility startup
        _log.trace( MoinSeverity.INFO, "Start finalizing MOIN instance and facilities." ); //$NON-NLS-1$
        this.finalizeStartup( spiMoin );

        this.moinRunning = true;
        _log.trace( MoinSeverity.INFO, "MOIN started." ); //$NON-NLS-1$
        spiMoin.fireInitialized();
        return spiMoin.getWrapper( );
    }

    private SpiMoin initializeMoin( SpiMoin existingMoinObject ) {

        if ( this.moinInstanceManager == null ) {
            // create a new MOIN instance if we do not restart an existing one
            SpiMoin moin = existingMoinObject == null ? new MoinImpl( ) : existingMoinObject;
            registerSessionCreationListeners(moin);

            // create the instance of Moin and Moin instance manager.
            this.moinInstanceManager = this.createMoinInstanceManager( moin );
            _log.trace( MoinSeverity.INFO, "MOIN instance manager created." ); //$NON-NLS-1$
        }

        if ( this.partitionSerializationManager == null ) {
            // create serialization manager for custom parsers/serializers
            SpiCustomParserSerializerFactory parserFactory = this.moinInstanceManager.moin.getCore( ).getPartitionService( );
            this.partitionSerializationManager = new PartitionSerializationManagerImpl( this.moinInstanceManager.moin );

            // registration of core partition reader
            this.partitionSerializationManager.registerParserSerializer( SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION, SpiPartitionSerializationManager.DEFAULT_SUFFIXES, parserFactory );
            _log.trace( MoinSeverity.INFO, "Serialization manager created." ); //$NON-NLS-1$
        }

        Collection<Facility> facilities = this.getFacilities( this.moinInstanceManager.moin.getCore( ), this.partitionSerializationManager );
        _log.trace( MoinSeverity.INFO, "Facilities created." ); //$NON-NLS-1$

        if ( this.mmReceiver == null ) {
            this.mmReceiver = this.createMetaModelReceiver( this.moinInstanceManager.moin );
            _log.trace( MoinSeverity.INFO, "Metamodel receiver created." ); //$NON-NLS-1$
        }

        SpiCompoundDataAreaManager compoundDataAreaManager = new IdeCompoundDataAreaManagerImpl( this.moinInstanceManager.moin );
        _log.trace( MoinSeverity.INFO, "Compound data area manager initialized." ); //$NON-NLS-1$

        // Initialize the MoinInstanceManager and starts MOIN
        SpiMoin moin = this.moinInstanceManager.startMoin( facilities, compoundDataAreaManager, this.mmReceiver.getMetamodelCatalog( ), this.mmReceiver.getMetamodelCatalog( ), partitionSerializationManager );

        moin.injectSecondMofRomStage();
        
        return moin;
    }

    private void registerSessionCreationListeners(SpiMoin moin) {
	IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint(
		"com.sap.tc.moin.runtime.sessionCreationListener");
	for (IConfigurationElement element : eventListenerPoint.getConfigurationElements()) {
	    if (element.getName().equals("sessionCreationListener")) {
		try {
		    SessionCreationListener listener = (SessionCreationListener) element.createExecutableExtension("classname");
		    moin.addSessionCreationListener(listener);
		} catch (CoreException e) {
		    throw new RuntimeException(e);
		}
	    }
	}
    }

    protected MoinInstanceManager createMoinInstanceManager( SpiMoin spiMoin ) {

        return new MoinInstanceManager( spiMoin );
    }

    /**
     * Instantiates the meta-model receiver. Subclasses can override this method
     * to provide own implementations (test use-case).
     * 
     * @param spiMoin
     * @return
     */
    protected IdeMetaModelReceiverImpl createMetaModelReceiver( SpiMoin spiMoin ) {

        return new IdeMetaModelReceiverImpl( spiMoin );
    }

    public void stopMoin( ) {

        if ( isMoinRunning( ) ) {
            this.moinInstanceManager.moin.shutdownThreads( );
            synchronized ( this.moinInstanceManager.moin ) {
                // Ideally, both MoinImpl and IdeRuntimeHostImpl should be one monitor for these kind of operations
                synchronized ( this ) {
                    this.stopMoinInternal( );
                }
            }
        }

        // TODO: destroy the wrapper
        // drop the wrapper
        this.ideMoinWrapper = null;

    }

    private void stopMoinInternal( ) {

        if ( _log.isTraced( MoinSeverity.INFO ) ) {
            _log.trace( MoinSeverity.INFO, "Client stops the Moin instance." ); //$NON-NLS-1$
        }

        this.moinRunning = false;

        if ( JMX_ENABLED ) {
            unregisterMBean( this.getObjectName( ) );
        }

        if ( this.moinInstanceManager != null && this.moinInstanceManager.moin != null ) {
            this.moinInstanceManager.stopMoin( );
            this.moinInstanceManager = null;

            this.partitionSerializationManager.shutDown( );
            this.partitionSerializationManager = null;
        } else {
            _log.trace( MoinSeverity.ERROR, "MOIN not running - can not perfom MOIN stop." ); //$NON-NLS-1$
        }

        if ( this.mmReceiver != null ) {
            this.mmReceiver.shutdown( );
            this.mmReceiver = null;
        }

        this.mmGenerator = null;

        if ( _log.isTraced( MoinSeverity.INFO ) ) {
            _log.trace( MoinSeverity.INFO, "MOIN stopped." ); //$NON-NLS-1$
        }

    }

    public MmDeploymentManager getMmDeploymentManager( ) {

        if ( _log.isTraced( MoinSeverity.INFO ) ) {
            _log.trace( MoinSeverity.INFO, "Client calls the Moin deployment manager." ); //$NON-NLS-1$
        }
        if ( this.mmReceiver != null ) {
            return this.mmReceiver.getMetamodelRegistry( );
        }
        _log.trace( MoinSeverity.ERROR, "The meta-model information is not available. The meta-model receiver not initialized." ); //$NON-NLS-1$
        return null;

    }

    public MetaModelCatalog getMetaModelCatalog( ) {

        if ( _log.isTraced( MoinSeverity.INFO ) ) {
            _log.trace( MoinSeverity.INFO, "Client calls the Moin deployment manager." ); //$NON-NLS-1$
        }
        if ( this.mmReceiver != null ) {
            return this.mmReceiver.getMetamodelCatalog( );
        }
        _log.trace( MoinSeverity.ERROR, "The meta-model information is not available. The meta-model receiver not initialized." ); //$NON-NLS-1$
        return null;

    }

    public synchronized boolean isMoinRunning( ) {

        return this.moinRunning;
    }

    public MmGenerator getMmGenerator( ) {

        if ( this.mmGenerator == null ) {
            this.mmGenerator = new MmGeneratorImpl( );
        }

        return this.mmGenerator;
    }

    // ======================= MOIN private methods ============================

    private void initializeMetaModels( SpiMoin spiMoin ) {

        // Initialize the MetaModelReceiver with MOIN
        this.mmReceiver.startup( spiMoin, this.partitionSerializationManager );
        _log.trace( MoinSeverity.INFO, "Metamodel jars registered." ); //$NON-NLS-1$

        // FIXME do this over an interface
        ( (ExtentManagerImpl) ( (MoinImpl) spiMoin ).getExtentManager( ) ).signalMetamodelsDeployed( );
    }

    private void finalizeStartup( SpiMoin spiMoin ) {

        _log.trace( MoinSeverity.INFO, "Finalize MOIN startup." ); //$NON-NLS-1$

        // Finalize MOIN startup
        if ( spiMoin == null ) {
            _log.trace( MoinSeverity.ERROR, "MOIN finalize startup - the MOIN not initialized." ); //$NON-NLS-1$
            return;
        }
        spiMoin.finalizeStartup( );

        //the receiver can only finalize its startup after moin finalized
        this.mmReceiver.finalizeStartup( spiMoin );

        // Finalize facilities startup
        Collection<Facility> facilities = spiMoin.getFacilities( );
        if ( !facilities.isEmpty( ) ) {
            Iterator<Facility> iterFacilities = facilities.iterator( );
            while ( iterFacilities.hasNext( ) ) {
                SpiFacilityLifecycle facility = (SpiFacilityLifecycle) iterFacilities.next( );
                facility.finalizeStartup( );
            }
        }

        // finally set the IDES-MOIN instance wrapper which is exposed to the clients
        ideMoinWrapper = new IdeMoinWrapperImpl( spiMoin );
        _log.trace( MoinSeverity.INFO, "Finalized MOIN startup - Moin is now available for client applications via MoinFactory" ); //$NON-NLS-1$
    }

    protected Collection<Facility> getFacilities( SpiCore core, SpiPartitionSerializationManager serializationManager ) {

        SpiFacilityFactory facilityFactory = null;
        SpiFacility facilitySpi = null;
        Collection<Facility> facilities = new LinkedList<Facility>( );

        IExtensionPoint mmExtPoint = Platform.getExtensionRegistry( ).getExtensionPoint( FACILITY_EX_POINT_NAME );

        if ( mmExtPoint != null ) {
            _log.trace( MoinSeverity.INFO, "    ------: " + mmExtPoint.getUniqueIdentifier( ) ); //$NON-NLS-1$

            IConfigurationElement[] configElements = mmExtPoint.getConfigurationElements( );

            for ( int i = 0; i < configElements.length; i++ ) {
                IConfigurationElement configElement = configElements[i];

                try {
                    if ( configElement.getName( ).equalsIgnoreCase( FACILITY_PARTICIPANT ) ) {
                        Object facilityEI = configElement.createExecutableExtension( CLASS_ATTRIBUTE );
                        if ( facilityEI instanceof SpiFacilityFactory ) {
                            facilityFactory = (SpiFacilityFactory) facilityEI;
                            facilitySpi = facilityFactory.getFacility( core, serializationManager, null );

                            if ( facilitySpi instanceof SpiFacilityLifecycle ) {
                                facilities.add( facilitySpi );
                                _log.trace( MoinSeverity.INFO, "          : " + facilitySpi.toString( ) ); //$NON-NLS-1$
                            } else {
                                _log.trace( MoinSeverity.WARNING, "The executable extension does not implement Pluggable interface " + configElement.getName( ) ); //$NON-NLS-1$
                            }

                        } else {
                            _log.trace( MoinSeverity.FATAL, "The extension class does not implements the FacilityExtension interface. The Moin facility plug-in is " + configElement.getName( ) ); //$NON-NLS-1$
                        }
                    }
                } catch ( CoreException e ) {
                    _log.trace( MoinSeverity.FATAL, "Can not create the executable extension for Moin facility plug-in " + configElement.getName( ) ); //$NON-NLS-1$
                }
            }

            return facilities;
        }
        _log.trace( MoinSeverity.FATAL, "No Eclipse plug-in extends the Facility-specific extension-point." ); //$NON-NLS-1$
        return null;

    }

    // =========================== MOIN JMX methods ======================

    private ObjectName getObjectName( ) {

        try {
            return new ObjectName( MOIN_DOMAIN + "type=RuntimeHost,moin=" + this.moinInstanceManager.moin.getId( ) ); //$NON-NLS-1$
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
    }

    private static final class JmxAdapter implements RuntimeHostIdeMBean {

        // Caution: its not referenced weak, since housekeeping thread is not existent at this time.
        private final IdeRuntimeHostImpl frameRef;

        private final CompositeType compositeTypeForMetamodels;

        private final TabularType tabularTypeForMetamodels;

        private JmxAdapter( IdeRuntimeHostImpl runtimeHost, ObjectName objectName ) {

            frameRef = runtimeHost;
            registerStandardMBean( this, RuntimeHostIdeMBean.class, objectName );
            try {
                compositeTypeForMetamodels = new CompositeType( "MetamodelInfo", "MetamodelInfo", new String[] { "1: Name", "2: Description", "3: Vendor", "4: Facility", "5: Status", "6: Available Version", "7: Deployed Version" }, new String[] { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
                                                                "1: Name", "2: Description", "3: Vendor", "4: Facility", "5: Status", "6: Available Version", "7: Deployed Version" }, new OpenType[] { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
                                                                SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING } );
                tabularTypeForMetamodels = new TabularType( "AvailableMetamodels", "Available Metamodels", compositeTypeForMetamodels, new String[] { "1: Name", "3: Vendor" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e );
            }
        }

        @SuppressWarnings( "unchecked" )
        public TabularData showAllMetamodels( ) throws IOException {

            IdeRuntimeHost frame = frameRef;
            if ( frame != null ) {
                Collection<MmDeploymentInfo> metamodelInfos = frame.getMmDeploymentManager( ).getMetaModelPluginList( );
                TabularData tabData = new TabularDataSupport( tabularTypeForMetamodels );
                for ( MmDeploymentInfo mmInfo : metamodelInfos ) {
                    Map map = new LinkedHashMap( );
                    map.put( "1: Name", mmInfo.getContainerName( ) ); //$NON-NLS-1$
                    map.put( "2: Description", mmInfo.getLabel( ) ); //$NON-NLS-1$
                    map.put( "3: Vendor", mmInfo.getVendor( ) ); //$NON-NLS-1$
                    map.put( "4: Facility", mmInfo.getFacilityName( ) ); //$NON-NLS-1$
                    map.put( "5: Status", mmInfo.getStatus( ).toString( ) ); //$NON-NLS-1$
                    MetaModelVersion pluginVersion = mmInfo.getMetaModelPluginVersion( );
                    map.put( "6: Available Version", pluginVersion != null ? pluginVersion.getVersionString( ) : "" ); //$NON-NLS-1$ //$NON-NLS-2$
                    MetaModelVersion deployedVersion = mmInfo.getDeployedMetaModelVersion( );
                    map.put( "7: Deployed Version", deployedVersion != null ? deployedVersion.getVersionString( ) : "" ); //$NON-NLS-1$ //$NON-NLS-2$
                    try {
                        tabData.put( new CompositeDataSupport( compositeTypeForMetamodels, map ) );
                    } catch ( OpenDataException e ) {
                        throw new RuntimeException( e );
                    }
                }
                return tabData;
            }
            return null;
        }
    }
}

package com.sap.tc.moin.repository.runtimehost.filesystem;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.core.impl.ExtentManagerImpl;
import com.sap.tc.moin.repository.core.impl.MoinImpl;
import com.sap.tc.moin.repository.filesystem.FileSystemRuntimeHost;
import com.sap.tc.moin.repository.runtimehost.MoinInstanceManager;
import com.sap.tc.moin.repository.runtimehost.deployment.PartitionSerializationManagerImpl;
import com.sap.tc.moin.repository.runtimehost.filesystem.exception.FileSystemRuntimeHostException;
import com.sap.tc.moin.repository.runtimehost.filesystem.mmhandling.FileSystemMetaModelReceiver;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManagerFactory;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityFactory;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;

/**
 * MOIN runtime host frame implementation class for the file system scenario.
 */
public class FileSystemRuntimeHostImpl implements FileSystemRuntimeHost {

    private static final MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, FileSystemRuntimeHostImpl.class );

    // Initialization
    private MoinInstanceManager manager = null;

    private PartitionSerializationManagerImpl partitionSerializationManager = null;

    private FileSystemMetaModelReceiver mmReceiver = null;

    private SpiFacility facility = null;

    // MOIN status - running / not running
    private boolean moinRunning = false;


    public FileSystemRuntimeHostImpl( ) {

    }

    public void stopMoin( ) {

        if ( this.manager != null && this.manager.moin != null ) {
            this.manager.moin.shutdownThreads( );
        }

        synchronized ( this ) {
            this.moinRunning = false;

            if ( this.manager != null ) {
                this.manager.stopMoin( );
            } else {
                _log.trace( MoinSeverity.ERROR, FileSystemRuntimeHostTraces.MOIN_NOT_RUNNING );
            }

            this.facility = null;

            this.mmReceiver = null;

            this.partitionSerializationManager.shutDown( );
            this.partitionSerializationManager = null;
        }
    }

    public void shutDown( ) {

        if ( isRunning( ) ) {
            this.stopMoin( );
        }
    }

    /**
     * Returns the configured Moin instance.
     * 
     * @return configured Moin instance.
     */
    public Moin getMoinInstance( ) {

        if ( this.moinRunning == false ) {
            throw new FileSystemRuntimeHostException( FileSystemRuntimeHostMessages.NOT_INITIALIZED );
        }
        return this.manager.moin.getWrapper( );

    }

    public Moin startMoin( String[] metamodelJars, SpiFacilityFactory facilityFactory, SpiCompoundDataAreaManagerFactory cdamFactory ) {

        if ( this.moinRunning ) {
            throw new FileSystemRuntimeHostException( FileSystemRuntimeHostMessages.ALREADYSTARTED );
        }

        Moin result = null;
        this.moinRunning = false;

        // Start MOIN - instantiate and configure MOIN and facilities
        SpiMoin spiMoin = this.initializeMoin( facilityFactory, cdamFactory );

        if ( spiMoin == null ) {
            _log.trace( MoinSeverity.FATAL, FileSystemRuntimeHostTraces.MOIN_NOT_INITIALIZED );
        } else {
            // Initialize meta-models - check the meta-model status and deploy
            // not-deployed meta-models
            this.initializeMetaModels( metamodelJars );

            // Finalize MOIN and facility startup
            this.finalizeStartup( spiMoin );

            this.moinRunning = true;

            result = spiMoin.getWrapper( );
        }
        return result;

    }

    // ======================= MOIN private methods =========================
    private SpiMoin initializeMoin( SpiFacilityFactory facilityFactory, SpiCompoundDataAreaManagerFactory cdamFactory ) {

        SpiMoin spiMoin = null;

        if ( this.moinRunning == false ) {

            _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.CONFIGURATION_READ );

            if ( this.manager == null ) {
                // create the instance of Moin and Moin instance manager. 
                this.manager = new MoinInstanceManager( new MoinImpl( ) );
                _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.MOIN_INSTANCE_MANAGER_CREATED );

            }

            if ( this.partitionSerializationManager == null ) {
                // create serialization manager for custom parsers/serializers
                SpiCustomParserSerializerFactory parserFactory = this.manager.moin.getCore( ).getPartitionService( );
                this.partitionSerializationManager = new PartitionSerializationManagerImpl( this.manager.moin );

                // registration of core partition reader
                @SuppressWarnings( "deprecation" )
                String DEFAULT_SUFFIXES[] = SpiPartitionSerializationManager.DEFAULT_SUFFIXES;

                this.partitionSerializationManager.registerParserSerializer( SpiCustomParserSerializerFactory.DEFAULT_SERIALIZATION, DEFAULT_SUFFIXES, parserFactory );
                _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.SERIALIZATION_MANAGER_CREATED );
            }

            this.facility = facilityFactory.getFacility( this.manager.moin.getCore( ), this.partitionSerializationManager, null );

            Collection<Facility> facilities = Collections.<Facility> singleton( this.facility );
            _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.FACILITIES_CREATED );

            _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.CORE_CONFIGURATION_CREATED );

            this.mmReceiver = new FileSystemMetaModelReceiver( this.manager.moin );
            _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.METAMODEL_RECEIVER_CREATED );

            // CompoundDataAreaManager
            SpiCompoundDataAreaManager compoundDataAreaManager = cdamFactory.getCompoundDataAreaManager( this.manager.moin.getCore( ) );
            _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.COMPOUND_DATA_AREA_MANAGER_INITIALIZED );

            // starts MOIN
            spiMoin = this.manager.startMoin( facilities, compoundDataAreaManager, this.mmReceiver.getMetaModelRegistry( ), this.mmReceiver.getMetaModelRegistry( ), partitionSerializationManager );

            compoundDataAreaManager.initializeMetamodelDataAreas( facilities );
            _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.METAMODEL_DATA_AREAS_INITIALIZED );

            return spiMoin;
        }
        return this.manager.moin;

    }

    private void initializeMetaModels( String[] metamodelJars ) {

        this.mmReceiver.startup( metamodelJars, this.partitionSerializationManager );
        _log.trace( MoinSeverity.INFO, FileSystemRuntimeHostTraces.METAMODEL_JARS_REGISTERED );

        // FIXME do this over an interface
        ( (ExtentManagerImpl) ( (MoinImpl) this.manager.moin ).getExtentManager( ) ).signalMetamodelsDeployed( );
    }

    private void finalizeStartup( SpiMoin spiMoin ) {

        // Finalize MOIN startup
        if ( spiMoin != null ) {
            spiMoin.finalizeStartup( );
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
        } else {
            _log.trace( MoinSeverity.ERROR, FileSystemRuntimeHostTraces.MOIN_FINALIZE_STARTUP_MOIN_NOT_INITIALIZED );
        }
    }

    public SpiFacility getFacility( ) {

        return this.facility;
    }

    /**
     * Returns true if the MOIN is running; otherwise returns false.
     * 
     * @return true if the MOIN is running; otherwise returns false.
     */
    public boolean isRunning( ) {

        return this.moinRunning;
    }

}

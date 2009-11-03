package com.sap.tc.moin.repository.runtimehost;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityLifecycle;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;

/**
 * The MOIN instance manager implements the (basic) functionality which is used
 * to start (see {@link #startMoin()}), stop (see {@link #stopMoin()}) and
 * restart (see {@link #restartMoin()}) MOIN.
 * <p>
 * During start the runtime host initializes first the MOIN facilities and then
 * the MOIN instance. During stop the runtime host stops first the MOIN instance
 * and then the MOIN facilities.
 */
public class MoinInstanceManager {

    public static final MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_RUNTIMHOST, MoinInstanceManager.class );

    /**
     * The MOIN instance. There is only one instance of MOIN!
     */
    public SpiMoin moin = null;

    protected boolean moinStarted = false;

    // this is a list of core plugs that we need to be able to shut down
    // if something goes wrong
    public Set<SpiFacility> registeredFacilities = new HashSet<SpiFacility>( );

    public MoinInstanceManager( SpiMoin spiMoin ) {

        this.moin = spiMoin;
    }

    /**
     * Starts the MOIN and returns the MOIN instance.
     * 
     * @param facilities a collection of {@link Facility} objects for the MOIN
     * @param compoundDataAreaManager compound data area manager
     * @param metamodelCatalog the catalog (API view on deployed meta-models)
     * @param metamodelRegistry the meta-model registry (core internal view on
     * deployed meta-models)
     * @param partitionSerializationManager the serialization manager (customer
     * parser/serialized registry)
     * @see SpiMoin#init(Collection, SpiCompoundDataAreaManager,
     * MetaModelCatalog, SpiMetamodelRegistry, SpiPartitionSerializationManager)
     * @return the MOIN instance
     */
    public SpiMoin startMoin( Collection<Facility> facilities, SpiCompoundDataAreaManager compoundDataAreaManager, MetaModelCatalog metamodelCatalog, SpiMetamodelRegistry metamodelRegistry, SpiPartitionSerializationManager partitionSerializationManager ) {

        if ( this.moinStarted == false ) {

            // Initialize MOIN facilities
            Collection<Facility> facilityCollection = this.initializeMoinFacilities( facilities );

            this.initializeMoin( facilityCollection, compoundDataAreaManager, metamodelCatalog, metamodelRegistry, partitionSerializationManager );

            this.moinStarted = true;

            return this.moin;
        } else {
            _log.trace( MoinSeverity.ERROR, "ERROR in startMoin(). Moin already running. Please first stop Moin (use the stopMoin() method)" ); //$NON-NLS-1$
            throw new MoinIllegalStateException( RuntimehostMessages.MOINALREADYRUNNING );
        }
    }

    /**
     * Stops the MOIN.
     * 
     * @return returns true if the MOIN was successfully stopped. Otherwise
     * returns false.
     */
    public boolean stopMoin( ) {

        _log.trace( MoinSeverity.INFO, "Begin MOIN stop." ); //$NON-NLS-1$

        this.moinStarted = false;

        boolean shutdownNormal = true;

        // shutdown the Moin instance and load plug-ins
        try {
            this.shutdownMoinInstance( );
        } catch ( Exception e ) {
            _log.trace( e, MoinSeverity.ERROR, "MOIN stop - core did not shutdown properly. " ); //$NON-NLS-1$
            shutdownNormal = false;
        }

        try {
            this.shutdownMoinFacilities( );
        } catch ( Exception e ) {
            _log.trace( e, MoinSeverity.ERROR, "MOIN stop - facilities did not shutdown properly. " ); //$NON-NLS-1$
            shutdownNormal = false;
        }

        try {
            this.moin.finalizeShutdown( );
        } catch ( Exception e ) {
            _log.trace( e, MoinSeverity.ERROR, "MOIN stop - core did not finalize shutdown properly. " ); //$NON-NLS-1$
            shutdownNormal = false;
        }

        this.moin = null;

        _log.trace( MoinSeverity.INFO, "MOIN stopped." ); //$NON-NLS-1$

        return shutdownNormal;
    }

    /**
     * Shutdown MOIN instance.
     */
    protected void shutdownMoinInstance( ) {

        if ( this.moin != null ) {
            this.shutdownMoinInstance( this.moin );
        } else {
            // Moin not running
            _log.trace( MoinSeverity.ERROR, "MOIN not running. Can not perform MOIN shutdown." ); //$NON-NLS-1$
        }
    }

    /**
     * Stops currently running MOIN facilities.
     */
    protected void shutdownMoinFacilities( ) {

        if ( this.registeredFacilities != null ) {

            for ( Iterator<SpiFacility> it = this.registeredFacilities.iterator( ); it.hasNext( ); ) {
                SpiFacility facility = null;

                try {
                    facility = it.next( );
                    ( (SpiFacilityLifecycle) facility ).tearDown( );
                } catch ( ClassCastException e ) {
                    _log.trace( e, MoinSeverity.WARNING, "The facility " + facility.getId( ) + " does not implement Pluggable - shutdown not implemented." ); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
            this.registeredFacilities.clear( );
        }
    }

    /**
     * Initialize the known (in current MOIN environment) MOIN facilities.
     */
    private synchronized Collection<Facility> initializeMoinFacilities( Collection<Facility> facilities ) throws IllegalStateException {

        Collection<Facility> facilityCollection = new ArrayList<Facility>( );
        SpiFacilityLifecycle facilityLifecycle = null;

        if ( !this.moinStarted ) {
            // loop over known facilities
            for ( Facility facility : facilities ) {

                // check facility type
                if ( facility != null ) {
                    if ( facility instanceof SpiFacility ) {
                        if ( facility instanceof SpiFacilityLifecycle ) {
                            // everything is all right, facility can be casted as needed
                            facilityLifecycle = (SpiFacilityLifecycle) facility;

                            try {

                                facilityLifecycle.initialize( );
                                this.registeredFacilities.add( (SpiFacility) facilityLifecycle );

                                // this will throw an IllegalStateException if MoinImpl has
                                // been initialized already
                                facilityCollection.add( (SpiFacility) facilityLifecycle );

                            } catch ( RuntimeException e ) {
                                _log.trace( e, MoinSeverity.FATAL, "ERROR: Initializing Facility: " + facility.getId( ) ); //$NON-NLS-1$
                                this.shutdownMoinFacilities( );
                                throw e;
                            }

                        } else {
                            _log.trace( MoinSeverity.WARNING, "The facility " + facility.getId( ) + " does not implement FacilityLifecycle." ); //$NON-NLS-1$ //$NON-NLS-2$
                        }
                    } else {
                        _log.trace( MoinSeverity.WARNING, "The facility " + facility.getId( ) + " does not implement SpiFacility." ); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                }

            }
            return facilityCollection;
        }
        return null;
    }

    /**
     * Initializes the MOIN instance.
     */
    private void initializeMoin( Collection<Facility> facilities, SpiCompoundDataAreaManager compoundDataAreaManager, MetaModelCatalog metamodelCatalog, SpiMetamodelRegistry metamodelRegistry, SpiPartitionSerializationManager partitionSerializationManager ) {

        compoundDataAreaManager.initializeMetamodelDataAreas( facilities );

        // initialize Moin instance
        this.moin.init( facilities, compoundDataAreaManager, metamodelCatalog, metamodelRegistry, partitionSerializationManager );
    }

    /**
     * Stops the current MOIN instance.
     * 
     * @param moinInstance the currently running MOIN instance.
     */
    private void shutdownMoinInstance( SpiMoin moinInstance ) {

        moinInstance.shutDown( );
    }

}

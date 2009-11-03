package com.sap.tc.moin.facility.primary.riservice;

import java.lang.ref.ReferenceQueue;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiDataAreaDescriptorFactory;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.facility.primary.riservice.DiPriImpl.PartitionNature;
import com.sap.tc.moin.facility.primary.riservice.ResourceIdentifierScanner.ResourceIdentifierTokens;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.shared.util.WeakObjectCache;
import com.sap.tc.moin.repository.shared.util.WeakObjectCache2;
import com.sap.tc.moin.repository.spi.facility.SpiResourceIdentifierFactory;

/**
 * @author d047015
 * @author D048997
 */
public class DiResourceIdentifierFactoryImpl implements SpiResourceIdentifierFactory, IpiDataAreaDescriptorFactory, IpiFacilityComponent {

    // Weak object caches for MRIs, LRIs, and PRIs

    private WeakObjectCache2<PRI, String /* mofId */, DiMriImpl> mriCache;

    private WeakObjectCache2<CRI, String /* partName */, DiPriImpl> priCache;

    private WeakObjectCache2<DataAreaDescriptor, String /* mofId */, DiLriImpl> lriCache;

    private WeakObjectCache2<DataAreaDescriptor, String /* container */, DiCriImpl> criCache;

    private ResourceIdentifierScanner resourceIdentifierScanner;

    private WeakObjectCache<String /* dataAreaName */, DiDataAreaDescriptorImpl> dataAreaDescriptorCache;

    // wrapper for created resource identifiers
    private DiResourceIdentifierFactoryImplWrapper wrapper;


    /*
     * Lifecycle related methods
     */

    public DiResourceIdentifierFactoryImpl( ReferenceQueue refQueue ) {

        this.dataAreaDescriptorCache = new WeakObjectCache<String, DiDataAreaDescriptorImpl>( refQueue );

        this.mriCache = new WeakObjectCache2<PRI, String, DiMriImpl>( refQueue, 2048 );
        this.priCache = new WeakObjectCache2<CRI, String, DiPriImpl>( refQueue, 2048 );
        this.criCache = new WeakObjectCache2<DataAreaDescriptor, String, DiCriImpl>( refQueue, 32 );
        this.lriCache = new WeakObjectCache2<DataAreaDescriptor, String, DiLriImpl>( refQueue, 2048 );
    }

    public void initialize( ) {

        this.resourceIdentifierScanner = new DiResourceIdentifierScannerImpl( );
        this.wrapper = new DiResourceIdentifierFactoryImplWrapper( this );
    }

    public void tearDown( ) {

        this.dataAreaDescriptorCache = null;
        this.criCache = null;
        this.priCache = null;
        this.mriCache = null;
        this.lriCache = null;
        // invalidate the wrapper
        this.wrapper.shutdown( );
        this.wrapper = null;
    }

    public void finalizeStartup( ) {

    }


    /*
     * Creation methods which actually create objects and update the cache
     */

    public DataAreaDescriptor createDataAreaDescriptor( String dataAreaName ) {

        String _dataAreaName = dataAreaName.intern( );
        DiDataAreaDescriptorImpl result;

        synchronized ( dataAreaDescriptorCache ) {
            result = dataAreaDescriptorCache.get( _dataAreaName );
            if ( result == null ) {
                result = new DiDataAreaDescriptorImpl( _dataAreaName, IpiPrimaryFacility.META_MODEL_DATA_AREA_ID == _dataAreaName );
                dataAreaDescriptorCache.put( _dataAreaName, result );
            }
        }

        return result;
    }

    /**
     * Not in any interface! It's protected since used in {@link DiPriImpl} to
     * create MRI.
     * 
     * @param pri
     * @param mofId
     * @return
     */
    protected MRI createMri( PRI pri, String mofId ) {

        String _mofId = mofId.intern( );
        DiMriImpl result;
        synchronized ( mriCache ) {
            result = this.mriCache.get( pri, _mofId );
            if ( result == null ) {
                result = new DiMriImpl( this.wrapper, pri, _mofId );
                this.mriCache.put( pri, _mofId, result );
            }
        }
        return result;
    }

    private PRI createPri( CRI cri, String partition, PartitionNature nature ) {

        String _partition = partition.intern( );
        DiPriImpl result;
        synchronized ( priCache ) {
            result = this.priCache.get( cri, _partition );
            if ( result == null ) {
                result = new DiPriImpl( this.wrapper, cri, _partition, nature );
                this.priCache.put( cri, _partition, result );
            }
        }
        return result;
    }

    private CRI createCri( DataAreaDescriptor dataArea, String containerName ) {

        String _containerName = containerName.intern( );
        DiCriImpl result;

        synchronized ( criCache ) {
            result = this.criCache.get( dataArea, _containerName );
            if ( result == null ) {
                result = new DiCriImpl( dataArea, _containerName );
                this.criCache.put( dataArea, _containerName, result );
            }
        }
        return result;
    }

    /**
     * Not in any interface! It's protected since used in {@link DiMriImpl} to
     * create LRI
     * 
     * @param dataArea
     * @param mofId
     * @return
     */
    protected LRI createLri( DataAreaDescriptor dataArea, String mofId ) {

        String _mofId = mofId.intern( );
        DiLriImpl result;
        synchronized ( lriCache ) {
            result = this.lriCache.get( dataArea, _mofId );
            if ( result == null ) {
                result = new DiLriImpl( dataArea, _mofId );
                this.lriCache.put( dataArea, _mofId, result );
            }
        }
        return result;
    }


    /*
     * Token based creation methods which delegate the actual creation
     */

    public MRI createMri( String dataAreaName, String containerName, String partitionName, String mofId ) {

        CRI cri = this.createCri( dataAreaName, containerName );
        PartitionNature nature = this.determinePartitionNature( dataAreaName, partitionName );
        PRI pri = this.createPri( cri, partitionName, nature );

        return this.createMri( pri, mofId );
    }

    public PRI createPri( String dataAreaName, String containerName, String partitionName ) {

        CRI cri = this.createCri( dataAreaName, containerName );
        PartitionNature nature = this.determinePartitionNature( dataAreaName, partitionName );

        return this.createPri( cri, partitionName, nature );
    }

    public PRI createNullPri( DataAreaDescriptor descriptor, String partitionName ) {

        // check whether the provided DataArea descriptor was created by this facility
        if ( !descriptor.getFacilityId( ).equals( PrimaryFacility.FACILITY_ID ) ) {
            throw new MoinIllegalArgumentException( RiServiceMessages.ILLEGAL_DESCRIPTOR_WRONG_FACILITY, descriptor, PrimaryFacility.FACILITY_ID );
        }

        // we can reuse the descriptor because it was created by the facility hosting this factory
        CRI cri = this.createCri( descriptor, DiResourceIdentifierConstants.DC_INTERNAL );
        return this.createPri( cri, DiResourceIdentifierConstants.NULL_PARTITION_PREFIX + partitionName + DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_SUFFIX, PartitionNature.NULL_PARTITION );
    }

    public PRI createVolatilePri( DataAreaDescriptor descriptor, String partitionName ) {

        // check whether the provided DataArea descriptor was created by this facility
        if ( !descriptor.getFacilityId( ).equals( PrimaryFacility.FACILITY_ID ) ) {
            throw new MoinIllegalArgumentException( RiServiceMessages.ILLEGAL_DESCRIPTOR_WRONG_FACILITY, descriptor, PrimaryFacility.FACILITY_ID );
        }

        // we can reuse the descriptor because it was created by the facility hosting this factory
        CRI cri = this.createCri( descriptor, DiResourceIdentifierConstants.DC_INTERNAL );
        String volatilePartitionName = DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_FOLDER + partitionName + DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_SUFFIX;

        return this.createPri( cri, volatilePartitionName, PartitionNature.VOLATILE_PARTITION );
    }

    public CRI createCri( String dataAreaName, String containerName ) {

        DataAreaDescriptor dataAreaDescriptor = this.createDataAreaDescriptor( dataAreaName );
        return this.createCri( dataAreaDescriptor, containerName );
    }

    public LRI createLri( String dataAreaName, String mofId ) {

        DataAreaDescriptor dataArea = this.createDataAreaDescriptor( dataAreaName );
        return createLri( dataArea, mofId );
    }


    /*
     * String based creation methods which scan the input and delegate the
     * actual creation
     */

    public MRI createMri( String mriString ) throws InvalidResourceIdentifierException {

        // scan MRI string
        ResourceIdentifierTokens parseResult = this.resourceIdentifierScanner.scanMriString( mriString );

        // delegate MRI creation
        return createMri( parseResult.dataAreaName, parseResult.containerName, parseResult.partitionName, parseResult.mofId );
    }


    public PRI createPri( String priString ) throws InvalidResourceIdentifierException {

        // scan PRI string
        ResourceIdentifierTokens scannedTokens = this.resourceIdentifierScanner.scanPriString( priString );

        return this.createPri( scannedTokens.dataAreaName, scannedTokens.containerName, scannedTokens.partitionName );
    }

    public CRI createCri( String criString ) {

        // scan CRI string
        ResourceIdentifierTokens scannedTokens = this.resourceIdentifierScanner.scanCriString( criString );

        // delegate CRI creation
        return this.createCri( scannedTokens.dataAreaName, scannedTokens.containerName );
    }

    public LRI createLri( String lriString ) throws InvalidResourceIdentifierException {

        // scan LRI string
        ResourceIdentifierTokens scannedTokens = this.resourceIdentifierScanner.scanLriString( lriString );

        // delegate LRI creation
        return createLri( scannedTokens.dataAreaName, scannedTokens.mofId );
    }


    /*
     * Methods that determine partition nature and perform on-the-fly static
     * checks
     */

    /**
     * Determines the nature of a partition based on previously scanned resource
     * identifier tokens of a {@link MRI} or {@link PRI}.
     * <p>
     * Throws an exception if invalid input tokens are detected. Invalid means
     * that a syntax or semantical rule is violated.
     * 
     * @param dataAreaName The data area name
     * @param partitionName The partition name
     * @return The detected partition nature
     * @throws InvalidResourceIdentifierException if the parameters are not
     * valid resource identifier tokens.
     */
    private DiPriImpl.PartitionNature determinePartitionNature( String dataAreaName, String partitionName ) {

        boolean isVolatilePartition = detectVolatilePartition( partitionName ); // throws exception on invalid syntax 
        boolean isMetamodelPartition = detectMetamodelPartition( dataAreaName, partitionName, isVolatilePartition );
        boolean isNullPartition = this.detectNullPartition( partitionName );

        this.performNatureIndependentStaticChecks( partitionName );

        // note: the order in which the following checks are done is not arbitrary
        PartitionNature nature = null;
        if ( isMetamodelPartition ) {
            nature = PartitionNature.METAMODEL_PARTITION;
        } else if ( isNullPartition ) {
            nature = PartitionNature.NULL_PARTITION;
        } else if ( isVolatilePartition ) {
            nature = PartitionNature.VOLATILE_PARTITION;
        } else {
            nature = PartitionNature.NORMAL_PARTITION;
        }

        return nature;
    }

    /**
     * Detects and validates static constraints for volatile partitions.
     * 
     * @param partitionName The partition name to check for prefix and suffix
     * @return true if the partition name indicated a volatile partition
     * @throws InvalidResourceIdentifierException If an illegal partition name
     * syntax was detected
     */
    private boolean detectVolatilePartition( String partitionName ) {

        boolean isVolatile = false;

        boolean hasVolatilePrefix = partitionName.startsWith( DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_FOLDER );
        boolean hasVolatileSuffix = partitionName.endsWith( DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_SUFFIX );

        // check partition name for volatile prefix and suffix:
        // only prefix and suffix are allowed (detached volatile suffixes and prefixes cause exceptions)
        if ( hasVolatilePrefix ) {
            if ( hasVolatileSuffix ) {
                isVolatile = true;
            } else {
                // detected volatile prefix: no volatile suffix found
                // FIXME: use correct message
                throw new InvalidResourceIdentifierException( RiServiceMessages.INVALIDVOLATILEPARTITION, DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_SUFFIX, partitionName );
            }
        } else if ( hasVolatileSuffix ) {
            // detected volatile suffix: no volatile prefix found
            // FIXME: use correct message
            throw new InvalidResourceIdentifierException( RiServiceMessages.INVALIDVOLATILEPARTITION, DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_SUFFIX, partitionName );
        }

        return isVolatile;
    }

    /**
     * Detects and validates static constraints for metamodel partitions.
     * 
     * @param dataAreaName The name of the DataArea of the partition
     * @param partitionName The partition name to check
     * @param isVolatilePartition A flag indicating if we inspect a volatile
     * partition
     * @return true if the partition name indicated a volatile partition
     * @throws InvalidResourceIdentifierException If an illegal partition name
     * syntax was detected
     */
    private boolean detectMetamodelPartition( String dataAreaName, String partitionName, boolean isVolatilePartition ) {

        boolean isMetaModel = false;
        boolean isLocatedInMetaModelDataArea = dataAreaName.equals( IpiPrimaryFacility.META_MODEL_DATA_AREA_ID );

        // assert for all partitions in the metamodel DataArea:
        if ( isLocatedInMetaModelDataArea ) {
            // only volatile partitions are allowed not to have the metamodel suffix
            if ( !partitionName.endsWith( MetaModelCatalog.META_MODEL_EXTENSION ) && !isVolatilePartition ) {
                throw new InvalidResourceIdentifierException( RiServiceMessages.ILLEGALPARTITIONSUFFIXFORMETAMODELDATAAREA, partitionName, IpiPrimaryFacility.META_MODEL_DATA_AREA_ID, MetaModelCatalog.META_MODEL_EXTENSION );
            }
            isMetaModel = true;
        }

        return isMetaModel;
    }

    /**
     * Detects and validates static constraints for null partitions.
     * 
     * @param partitionName The partition name to check
     * @return true if the partition name indicated a null partition
     */
    private boolean detectNullPartition( String partitionName ) {

        boolean hasNullPartitionPrefix = partitionName.startsWith( DiResourceIdentifierConstants.NULL_PARTITION_PREFIX );
        boolean hasFixedVolatilePartitionSuffix = partitionName.endsWith( DiResourceIdentifierConstants.FIXED_VOLATILE_PARTITION_SUFFIX );

        return hasNullPartitionPrefix && hasFixedVolatilePartitionSuffix;
    }

    /**
     * Validates static syntax constraints which are not related to the
     * partition nature determination.<br>
     * <p>
     * The following checks are performed:<br>
     * - The partition name must not be a suffix only
     * 
     * @param partitionName The partition name to check
     */
    private void performNatureIndependentStaticChecks( String partitionName ) {

        if ( !isLastSegmentNotSuffixOnly( partitionName ) ) {
            throw new InvalidResourceIdentifierException( RiServiceMessages.INVALIDPATHLASTSEGMENTNOTSUFFIXONLY, partitionName );
        }
    }

    /**
     * Tests whether the last segment (i.e. the filename) is not a suffix only.
     * For example "[...]/.mointest" is not possible. Must be called after
     * hasModelPartitionSuffixForNonMOFModel().
     */
    private boolean isLastSegmentNotSuffixOnly( String partitionName ) {

        int pos = partitionName.lastIndexOf( DiResourceIdentifierConstants.SUFFIX_START_CHAR );
        if ( pos > 0 ) {
            char c = partitionName.charAt( pos - 1 );
            if ( c == '/' || c == '\\' ) {
                return false;
            }
            return true;
        }
        if ( pos == 0 ) {
            return false;
        } else {
            // partition name has no suffix
            return true;
        }
    }


    /*
     * Factory wrapper used to decouple factory instances from created products
     * at shutdown
     */

    /**
     * Wrapper for {@link DiResourceIdentifierFactoryImpl}.<br>
     * Used in created resource identifiers to invalidate back-references on
     * shutdown.
     */
    public static class DiResourceIdentifierFactoryImplWrapper {

        private DiResourceIdentifierFactoryImpl riFactory;

        DiResourceIdentifierFactoryImplWrapper( DiResourceIdentifierFactoryImpl riFactory ) {

            this.riFactory = riFactory;
        }

        /**
         * @return The wrapped factory instance or <code>null</code> if the
         * factory was already shut down.
         */
        protected DiResourceIdentifierFactoryImpl getRiFactory( ) {

            return riFactory;
        }

        /** Invalidates the reference on the wrapped factory. */
        void shutdown( ) {

            this.riFactory = null;
        }
    }
}

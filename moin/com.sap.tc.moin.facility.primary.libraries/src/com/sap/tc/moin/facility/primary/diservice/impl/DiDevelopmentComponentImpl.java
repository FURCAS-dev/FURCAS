package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcToPpDependencyProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiServiceException;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider.Scenario;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * @author d021091
 */

public abstract class DiDevelopmentComponentImpl {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, DiDevelopmentComponentImpl.class );

    private final static ArrayList<DiPublicPartImpl> EMPTY_PUBLIC_PART_LIST = new ArrayList<DiPublicPartImpl>( 0 );

    protected boolean _isInvalid = false;

    private final IpiDiDcDefinitionProvider _moinDiDcDefinitionProvider;

    private final CRI _cri;

    private final String _fullDcTypeName;

    private final DiConfigurationImpl _diConfiguration;

    // The relevant folders of MOIN native DCs:
    private List<String> _moinRelevantFolders;

    // The relevant folders of MOIN custom DCs:
    // are retrieved from DiContentSelectionRegistryImpl, see getMoinRelevantCustomFolders(...)

    // references for fast access ...

    // MOIN-property as it is defined in _moinRelevantProperties:
    private IpiDiDcDefinitionProvider.PropertyProvider _moinPropertyProvider;

    // Lazy computed and cached information:

    // The computation of the _moinResourceFolderPaths + _moinFolderPaths is lazy.
    // This lazy handling is based on an explicit handling via the flags _is...Initialized 
    // and not on an implicit handling via value null,
    // because MOIN custom DCs do not have such folders and the values should nevertheless be computed only once.

    // - MoinResourceFolders defined in MOIN-property:
    private ArrayList<String> _moinResourceFolderPaths = new ArrayList<String>( );

    private boolean _isMoinResourceFolderPathsInitialized = false;

    // - MoinFolders defined in MOIN-property:
    private ArrayList<String> _moinFolderPaths = new ArrayList<String>( );

    private boolean _isMoinFolderPathsInitialized = false;

    // - DC-folder-property (containing the definition of package and source
    // folders) as it is defined in _moinRelevantProperties:
    private List<String> _dcFolderPaths;

    // MOIN-folders from the map:
    private List<String> _moinGenerationFolderPaths;

    // todo: first solution implemented as hard coded list --> design and impl for final solution    
    private String GENERATION_ROOT = "gensrc"; //$NON-NLS-1$ // or "gsrc", is shorter and does only overlap with "gen" in 1 character ???

    private String EXTENSIBILITY_FRAMEWORK_GENFOLDER = "/extcfg"; //$NON-NLS-1$

    // Structured MOIN-resource-folders and MOIN-folders properties:
    // - MOIN-resource-folders MUST be also defined as DC resource folders
    // - MOIN-folders MUST NOT be defined as DC resource folders
    static final String MOIN_RESOURCE_FOLDERS_PROPERTY = "moin_resource_folders"; //$NON-NLS-1$

    private static final String MOIN_FOLDERS_PROPERTY = "moin_folders"; //$NON-NLS-1$

    private static final boolean MUST_BE_DC_RESOURCE_FOLDER = true;

    private static final boolean MUST_NOT_BE_DC_RESOURCE_FOLDER = false;

    // Folder-properties in MOIN-resource-folders and MOIN-folders properties
    static final String MOIN_FOLDER_PATH_PROPERTY = "folder"; //$NON-NLS-1$

    // Attributes of folder-properties:
    static final String MOIN_FOLDER_PATH_ATTRIBUTE = "path"; //$NON-NLS-1$

    private static final String MOIN_IDE_EXCLUSION_ATTRIBUTE = "exclude_in_ide"; //$NON-NLS-1$

    private static final String MOIN_BUILD_EXCLUSION_ATTRIBUTE = "exclude_in_build"; //$NON-NLS-1$

    private static final String MOIN_UNKNOWN_EXCLUSION_ATTRIBUTE = "unknown_exclude"; //$NON-NLS-1$

    private static final String EXCLUDE_IN_SCENARIO = "true"; //$NON-NLS-1$

    /** ******************** Construction *********************************** */

    protected DiDevelopmentComponentImpl( IpiDiDcDefinitionProvider moinDiDcDefinition, CRI cri, DiConfigurationImpl diConfiguration ) {

        _moinDiDcDefinitionProvider = moinDiDcDefinition;
        _cri = cri;
        _diConfiguration = diConfiguration;
        _fullDcTypeName = DiComponentModelUtilImpl.getFullDcTypeName( _moinDiDcDefinitionProvider.getDcTypeVendor( ), _moinDiDcDefinitionProvider.getDcTypeName( ) );

    }

    /** ************************* API ************************************** */

    public IpiDiDcDefinitionProvider getDiDcDefinitionProvider( ) {

        return _moinDiDcDefinitionProvider;
    }

    /**
     * Reset the internally computed and cached state (not the input for the
     * construction).
     * <p>
     * A reset is needed when the state of DCs (meta data) and their
     * dependencies have changed (e.g. after a sync from repository).
     * <p>
     * Changes for which a resetInternalCaches has to be done:
     * <p>
     * - the meta data of this DC have changed
     * <p>
     * - the usage references of this DC to other DCs have changed
     * <p>
     * - the meta data of a DC which up-to-now was referenced have changed, e.g.
     * a public part was removed
     * <p>
     * The reset data are garbage collected (therefore they do not need an own
     * reset-method). Those data can be computed again based on the provider.
     * The caching and refresh of the provider is in the responsibility of the
     * provider or layer where it is provided.
     */
    public void resetInternalCaches( ) {

        // Caches for infos from DC definition:
        _moinPropertyProvider = null;
        _moinResourceFolderPaths.clear( );
        _isMoinResourceFolderPathsInitialized = false;
        _moinFolderPaths.clear( );
        _isMoinFolderPathsInitialized = false;

        _moinRelevantFolders = null;
        _dcFolderPaths = null;
        _moinGenerationFolderPaths = null;

        // DC dependencies are not cached, because they are cached by DiClient-Library (e.g.Dii05)
        // --> newly retrieval should not be expensive and always up-to-date
    }

    public void invalidate( ) {

        _isInvalid = true;
        resetInternalCaches( );
    }

    public boolean isInvalid( ) {

        return _isInvalid;
    }

    public void checkInvalid( ) { // invalid

        if ( isInvalid( ) ) {
            // Message: "MOIN DC-object [development component: {1}] is no longer valid "
            IpiDiServiceException e = new IpiDiServiceException( DiServiceMessages.DC_NO_LONGER_VALID, getModelContainerName( ) );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            }
            throw e;
        }
    }


    public String getDcName( ) {

        // The method must return a valid result although the DC-object is out-dated, because it might be used during cache-clean-up on lower layers
        return _moinDiDcDefinitionProvider.getDcName( );
    }

    public String getDcVendor( ) {

        // The method must return a valid result although the DC-object is out-dated, because it might be used during cache-clean-up on lower layers
        return _moinDiDcDefinitionProvider.getDcVendor( );
    }

    public String getModelContainerName( ) {

        // The method must return a valid result although the DC-object is out-dated, because it might be used during cache-clean-up on lower layers
        return _moinDiDcDefinitionProvider.getFullDcName( );
    }

    public CRI getCri( ) {

        // The method must return a valid result although the DC-object is out-dated, because it might be used during cache-clean-up on lower layers
        return _cri;
    }

    public List<String> getMoinRelevantFolders( ) {

        if ( _moinRelevantFolders == null ) {
            // lazy initialization:
            // - Native MOIN-relevant folders:
            int size = getMoinResourceFolders( ).size( ) + getMoinFolders( ).size( );
            _moinRelevantFolders = new ArrayList<String>( size );
            _moinRelevantFolders.addAll( getMoinResourceFolders( ) );
            _moinRelevantFolders.addAll( getMoinFolders( ) );
            // - Generation folders:
            _moinRelevantFolders.addAll( getMoinGenerationFolders( ) );
        }
        return _moinRelevantFolders;
    }

    public List<String> getMoinRelevantCustomFolders( DiContentSelectionRegistryImpl customContentSelectionRegistry ) {

        // The registry contains the Mapping: MOIN-relevant custom DC type --> MOIN-relevant custom folders
        return customContentSelectionRegistry.getMoinRelevantCustomFolders( _fullDcTypeName );
    }

    public IpiDiDcDefinitionProvider.DcSourceState getDcSourceState( ) {

        return getDiDcDefinitionProvider( ).getDcSourceState( );
    }

    public boolean isVisibleAsSources( ) {

        return _moinDiDcDefinitionProvider.isVisibleAsSources( );
    }

    public boolean isVisibleAsArchives( ) {

        return _moinDiDcDefinitionProvider.isVisibleAsArchives( );
    }

    public boolean isMoinMetaModelDc( ) {

        checkInvalid( );
        return IpiDiDcDefinitionProvider.MOIN_META_MODEL_DCTYPE_VENDOR.equals( _moinDiDcDefinitionProvider.getDcTypeVendor( ) ) && IpiDiDcDefinitionProvider.MOIN_META_MODEL_DCTYPE_ID.equals( _moinDiDcDefinitionProvider.getDcTypeName( ) );
    }

    /**
     * Remark: The parameter <code>connection</code> is needed, because we
     * recognize the dirty state of the partitions in the destination DCs.
     * <p>
     * Example:
     * <p>
     * A dirty created partition in a destination DC is also visible (when it is
     * covered by the referenced public part of the destination DC).
     * <p>
     * Whereas a dirty deleted partition in a destination DC is not visible
     * (although it is still available in persistence).
     * </p>
     */
    public List<PRI> getVisiblePartitions( DiServiceImpl diService, List<PartitionOperation> dirtyPartitions ) {

        checkInvalid( );

        // (0) Algorithm:
        // --------------
        // A DC is principally visible for a source DC if both conditions are true:
        // - the source DC has a usage relation to the destination DC or one of its PPs
        // - the destination DC has a PP
        // There is an additional condition which is only checked during Build (DC Build):
        // - the destination DC has an ACL which does not cover the srcDC --> the destination DC is actually not visible for the destination DC

        // A DC is visible for a source DC for a given purpose (e.g. for compilation) if all three conditions are true:
        // - the destination DC is visible for the source DC
        // - at least one visible public part of the destination DC has the required purpose, e.g. purpose compilation
        // - the content of the visible public part/s is usable (not empty, domain-specific conditions, ...)

        // A part of the files of a DC is visible for a source DC for a given purpose:
        // - if the respective files are part of the public part which is visible for source DC for this purpose.

        // (1) Determine the PPs which are visible for the current DC for compilation,
        // ---------------------------------------------------------------------------
        // i.e. the model elements in partitions of those PPs can be referenced from model element in the current DC.
        ArrayList<DiPublicPartImpl> ppsVisibleForCompilation = getReferencedPpsVisibleForCompilation( );

        // (2) Determine the partitions in those PPs
        // -----------------------------------------
        // First implementation:
        // - We do not need to evaluate the content of the different PPs, because a MOIN-relevant PP always contains all model partitions of the DC
        // - --> We just take all model partitions of the respective DCs
        // todo: final implementation: consider that a DC can have several PPs where each of them can contain entities like 'Model File', 'Model Folder', ...

        // (2.1) Determine the corresponding DCs
        // -------------------------------------
        // Map: DC name --> DC
        HashSet<DiDevelopmentComponentImpl> dcsVisibleForCompilation = getDcs( ppsVisibleForCompilation );

        // (2.2) Determine the partitions in those DCs
        // -------------------------------------------
        // hot_todo: Real future implementation must filter the partitions of the destination DCs with the ppsVisibleForCompilation and their entity types.
        // First simplified implementation:
        // The visible partitions cannot be cached because they are matter of editing and dirty handling:
        ArrayList<PRI> visiblePartitions = new ArrayList<PRI>( );
        for ( DiDevelopmentComponentImpl dc : dcsVisibleForCompilation ) {
            List<PartitionOperation> dirtyPartitionsInDc = filterPartitionsOfDc( dc, dirtyPartitions );
            Collection<PRI> persistedPartitions = diService.getPersistedPartitions( dc.getCri( ) );
            visiblePartitions.addAll( dc.mergePartitions( persistedPartitions, dirtyPartitionsInDc ) );
            if ( dirtyPartitionsInDc.size( ) == 0 && persistedPartitions.size( ) == 0 ) {
                LOGGER.trace( MoinSeverity.INFO, "{0}: The referenced DC does not contain MOIN partitions: [source DC: {1}, destination DC: {2}].", "getVisiblePartitions", toString( ), dc.toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        if ( visiblePartitions.size( ) == 0 ) {
            LOGGER.trace( MoinSeverity.INFO, "{0}: There are no referenced DCs containing MOIN partitions visible for DC: {1}.", "getVisiblePartitions", toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        return visiblePartitions;
    }


    /**
     * Caution:
     * <p>
     * The interface is dangerous because it can easily lead to the mistake that
     * the visible DCs can be determined in 1 step and then the partitions in
     * the DCs can be handled as visible partitions.
     * <p>
     * This is true only in the first implementation, because:
     * <p>
     * - we return only those referenced DCs to which a usage relation to a
     * public part purpose compilation exists
     * <p>
     * - such a public part can only cover all partitions of the DC (fixed
     * simplified first implementation).
     * <p>
     * But in the final implementation, the dependencies and the related visible
     * partitions are more difficult to determine:
     * <p>
     * - there can be several public parts purpose compilation
     * <p>
     * - usage relations can be to all or only some of those public parts
     * <p>
     * - the single public parts can contain all partitions or only a part of
     * the partitions (entity types: Model File, Model Folder, Model Folder
     * Tree).
     */
    public List<CRI> getVisibleDcs( ) {

        checkInvalid( );

        // (0) Algorithm:
        // --------------
        // see under getVisiblePartitions

        // (1) Determine the PPs which are visible for the current DC for compilation,
        // ---------------------------------------------------------------------------
        // i.e. the model elements in partitions of those PPs can be referenced from model element in the current DC.
        ArrayList<DiPublicPartImpl> ppsVisibleForCompilation = getReferencedPpsVisibleForCompilation( );

        // (2) Determine the corresponding DCs
        // -----------------------------------
        // Map: DC name --> DC
        HashSet<DiDevelopmentComponentImpl> dcsVisibleForCompilation = getDcs( ppsVisibleForCompilation );
        ArrayList<CRI> visibleDcCRIs = getCris( dcsVisibleForCompilation );

        if ( visibleDcCRIs.size( ) == 0 ) {
            LOGGER.trace( MoinSeverity.INFO, "{0}: The DC does not refrencene any DCs: {1}.", "getVisibleDcs", toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return visibleDcCRIs;
    }

    public ArrayList<DiPublicPartImpl> getReferencedPpsVisibleForCompilation( ) {

        checkInvalid( );

        // Determine the dependencies to PPs of the destination DCs to which the srcDC has usage relations:
        List<DiDcToPpDependencyImpl> dependencies = getReferencesToPublicParts( );
        if ( dependencies == null || dependencies.size( ) == 0 ) {
            LOGGER.trace( MoinSeverity.INFO, "{0}: The DC does not reference any public parts: {1}.", "getReferencedPpsVisibleForCompilation", toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            return EMPTY_PUBLIC_PART_LIST;
        }

        // Remove those public parts from the list which are not visible:
        ArrayList<DiPublicPartImpl> ppsVisibleForCompilation = new ArrayList<DiPublicPartImpl>( dependencies.size( ) );
        for ( DiDcToPpDependencyImpl dependency : dependencies ) {
            DiPublicPartImpl publicPart = dependency.getPublicPart( );

            if ( dependency.isVisibleForBuildTime( ) && publicPart.hasPurposeCompilation( ) ) {
                ppsVisibleForCompilation.add( dependency.getPublicPart( ) );
            }
        }

        ppsVisibleForCompilation.trimToSize( );
        if ( ppsVisibleForCompilation == null || ppsVisibleForCompilation.size( ) == 0 ) {
            LOGGER.trace( MoinSeverity.INFO, "{0}: The DC does not reference public parts which are visible for compilation: {1}.", "getReferencedPpsVisibleForCompilation", toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return ppsVisibleForCompilation;
    }

    public boolean isModifiable( ) {

        checkInvalid( );

        // Archives are not modifiable:
        if ( isVisibleAsArchives( ) ) {
            LOGGER.trace( MoinSeverity.INFO, "{0}: The DC is not modifiable because it is visible as archives: {1}.", "isModifiable", toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
            return false;
        }

        // Only sources in certain states are modifiable:
        IpiDiDcDefinitionProvider.DcSyncMode dcSyncMode = _moinDiDcDefinitionProvider.getDcSyncMode( );
        if ( dcSyncMode == IpiDiDcDefinitionProvider.DcSyncMode.LOCAL_ONLY || dcSyncMode == IpiDiDcDefinitionProvider.DcSyncMode.SYNCED_AS_INACTIVE_SOURCE ) {
            return true;
        }
        LOGGER.trace( MoinSeverity.INFO, "{0}: The DC is not modifiable because it is visible as sources from active DTR workspace: {1}.", "isModifiable", toString( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        return false;
    }

    @Override
    public String toString( ) {

        return getModelContainerName( );
    }

    /** ******************** API for sub-classes **************************** */

    // Remark: FsPersistence can survive although the folders does not exist
    // Caution:
    // The method has to deliver the resource-folders with a trailing '/'.
    // This is expected by the callers (performance: avoid subsequent repeated
    // concatenations with '/')
    protected List<String> getMoinResourceFolders( ) {

        // Compute on demand and only once:
        if ( !_isMoinResourceFolderPathsInitialized ) {
            if ( getMoinPropertyProvider( ) != null ) {
                // The property MOIN_PROPERTY contains the definition of the
                // MOIN-resource-folders.
                // Restrictions for resource folders:
                // - The resource folders must be defined as DC-resource folders.
                // - They must not be excluded for the current scenario.
                computeAndCheckMoinRelevantFolders( getMoinPropertyProvider( ), getScenario( ) );
            } // else: Custom MOIN DC
        }
        return Collections.unmodifiableList( _moinResourceFolderPaths );
    }

    // Remark: FsPersistence can survive although the folders does not exist
    // Caution:
    // The method has to deliver the resource-folders with a trailing '/'.
    // This is expected by the callers (performance: avoid subsequent repeated
    // concatenations with '/')
    protected List<String> getMoinFolders( ) {

        // Compute on demand and only once:
        if ( !_isMoinFolderPathsInitialized ) {
            if ( getMoinPropertyProvider( ) != null ) {
                // The property MOIN_PROPERTY contains the definition of the MOIN-folders.
                // Restrictions for resource folders:
                // - The resource folders must not be defined as DC-resource folders.
                // - They must not be excluded for the current scenario.
                computeAndCheckMoinRelevantFolders( getMoinPropertyProvider( ), getScenario( ) );
            }
        }
        return Collections.unmodifiableList( _moinFolderPaths );
    }

    protected String getGenerationRoot( ) {

        // todo: first solution implemented as hard coded list --> design and impl for final solution    
        return GENERATION_ROOT;
    }

    public List<String> getMoinGenerationFolders( ) {

        if ( _moinGenerationFolderPaths == null ) {
            // Lazy computation:
            _moinGenerationFolderPaths = new ArrayList<String>( 1 );
            // todo: first solution implemented as hard coded list --> design and impl for final solution
            _moinGenerationFolderPaths.add( getGenerationRoot( ) + EXTENSIBILITY_FRAMEWORK_GENFOLDER );
        }
        return Collections.unmodifiableList( _moinGenerationFolderPaths );
    }

    public DiConfigurationImpl getDiConfiguration( ) {

        return _diConfiguration;
    }

    protected IpiDiConfigurationProvider.Scenario getScenario( ) {

        return getDiConfiguration( ).getScenario( );
    }

    protected DataAreaDescriptor getDataAreaDescriptor( ) {

        return getDiConfiguration( ).getDataAreaDescriptor( );
    }

    /** ******************** Internal *************************************** */

    // Internal:Caching & Eviction:
    // (1) Caching of DiDevelopmentComponentImpl-objects is done in the respective DiConfiguration
    // (2) Caching of DC dependencies:
    // - Currently we do NOT cache DC dependencies (and referenced DCs and respective CRIs),
    //   because:
    // -- because the DC dependencies are cached by DiClient-Library (e.g.Dii05)
    // --> newly retrieval should not be expensive and always up-to-date
    // --> In case we face performance problems:
    // - first trial: clarify with Dii05 if they can improve performance
    // - second trial: realize a DcReferenceHandler, which:
    // -- is responsible for creation of the related MOIN objects (DiPpDependency, DiPublicPartImpl)
    // -- and caches those objects and the dependencies:
    //    --- Map: source DC --> Set ( PP-Dependency ) 			with: this source DC ---PP-Dependency---> to a PP of the respective destination DC
    //							additionally Set( destination DC ) and Set( destination CRIs ) could be cached, because some methods require this format
    //	  --- Map: destination DC --> Set( PP - Dependency ) 	with: a PP of this destination DC <---PP-Dependency--- from the respective source DC
    // -- and takes care for consistent eviction in all cases where the meta data
    //    of a source-DC or a destination-DC have changed or a DC got invalid.
    private IpiDiDcDefinitionProvider.PropertyProvider getMoinPropertyProvider( ) {

        // Lazy initialization:
        if ( _moinPropertyProvider == null ) {
            _moinPropertyProvider = _moinDiDcDefinitionProvider.getMoinProperty( );
        }
        return _moinPropertyProvider;
    }

    private List<String> getDcFolderPaths( ) {

        // Lazy initialization:
        if ( _dcFolderPaths == null ) {
            _dcFolderPaths = _moinDiDcDefinitionProvider.getDiDcFolderDefinitions( );
        }
        return _dcFolderPaths;
    }

    // New computation of moinResourceFolderPaths and moinFolderPaths
    // Caution:
    // The method has to deliver the resource-folders with a trailing '/'.
    // This is expected by the callers (performance: avoid subsequent repeated
    // concatenations with '/')
    private void computeAndCheckMoinRelevantFolders( IpiDiDcDefinitionProvider.PropertyProvider moinPropertyProvider, Scenario scenario ) {

        // Reset MOIN folder paths:
        if ( !_moinResourceFolderPaths.isEmpty( ) ) {
            _moinResourceFolderPaths.clear( );
        }
        if ( !_moinFolderPaths.isEmpty( ) ) {
            _moinFolderPaths.clear( );
        }
        _moinRelevantFolders = null;
        _isMoinResourceFolderPathsInitialized = false;
        _isMoinFolderPathsInitialized = false;

        // Compute the scenario attribute for the current scenario:
        final String scenarioAttribute = ( Scenario.IDE_SCENARIO.equals( scenario ) ? MOIN_IDE_EXCLUSION_ATTRIBUTE : ( Scenario.BUILD_SCENARIO.equals( scenario ) ? MOIN_BUILD_EXCLUSION_ATTRIBUTE : MOIN_UNKNOWN_EXCLUSION_ATTRIBUTE ) );

        // Compute the MOIN folder paths based on the given MOIN-Property:
        List<IpiDiDcDefinitionProvider.PropertyProvider> moinChildPropertyProviders = moinPropertyProvider.getChildProperties( );
        for ( int i = 0; i < moinChildPropertyProviders.size( ); i++ ) {
            IpiDiDcDefinitionProvider.PropertyProvider moinChildPropertyProvider = moinChildPropertyProviders.get( i );
            if ( MOIN_RESOURCE_FOLDERS_PROPERTY.equals( moinChildPropertyProvider.getName( ) ) ) {
                if ( _moinResourceFolderPaths != null && !_moinResourceFolderPaths.isEmpty( ) ) {
                    final String msg = "{0}: Double moin-resource-folder property for moin-property is ignored: {1}."; //$NON-NLS-1$
                    LOGGER.trace( MoinSeverity.INFO, msg, "computeAndCheckMoinRelevantFolders", MOIN_RESOURCE_FOLDERS_PROPERTY ); //$NON-NLS-1$
                } else {
                    // Get MOIN-resource-folders which are DC-resource-folders:
                    getAndCheckMoinFolders( _moinResourceFolderPaths, moinChildPropertyProvider, MUST_BE_DC_RESOURCE_FOLDER, scenarioAttribute );
                }

            } else if ( MOIN_FOLDERS_PROPERTY.equals( moinChildPropertyProvider.getName( ) ) ) {
                if ( MOIN_BUILD_EXCLUSION_ATTRIBUTE.equals( scenarioAttribute ) ) {
                    // MOIN-folders must not be DC-resource-folders, i.e. they are not synced by CBS and not available for DC-build in CBS,
                    // i.e. the MOIN-folders are automatically invisible for DC-build in CBS.
                    // The DC-build in IDE should behave the same way as in CBS, therefore the MOIN-folders must also be invisible for DC-build in IDE.
                    // --> The MOIN-folders are ignored in DC-build in IDE, even when they are available on local disc (synced by the user).
                    continue;
                }
                if ( _moinFolderPaths != null && !_moinFolderPaths.isEmpty( ) ) {
                    final String msg = "{0}: Double moin-folder property for moin-property is ignored: {1}."; //$NON-NLS-1$
                    LOGGER.trace( MoinSeverity.INFO, msg, "computeAndCheckMoinRelevantFolders", MOIN_FOLDERS_PROPERTY ); //$NON-NLS-1$
                } else {
                    // Get MOIN-resource-folders which are not DC-resource-folders:
                    getAndCheckMoinFolders( _moinFolderPaths, moinChildPropertyProvider, MUST_NOT_BE_DC_RESOURCE_FOLDER, scenarioAttribute );
                }
            } else { // Support bug tracking: trace all unknown properties
                final String msg = "{0}: Unknown child property [{1}] for moin-property [{2}]."; //$NON-NLS-1$
                LOGGER.trace( MoinSeverity.INFO, msg, "computeAndCheckMoinRelevantFolders", moinChildPropertyProvider.getName( ), IpiDiDcDefinitionProvider.MOIN_PROPERTY ); //$NON-NLS-1$
            }
        }
        // Remark:
        // MOIN-resource-folder and MOIN-folder cannot overlap, because a folder cannot be a DC-resource-folder and a DC-folder at the same time.

        // Complete initialization of paths:
        _isMoinResourceFolderPathsInitialized = true;
        _isMoinFolderPathsInitialized = true;
    }

    // The method returns the MOIN-resource-folders defined via DC-definition.
    // Caution:
    // The method has to deliver the resource-folders with a trailing '/'.
    // This is expected by the callers (performance: avoid subsequent repeated concatenations with '/')
    private void getAndCheckMoinFolders( ArrayList<String> moinResourceFolderPaths, IpiDiDcDefinitionProvider.PropertyProvider moinRelevantFoldersPropertyProvider, boolean mustBeDcResourceFolder, String scenarioAttribute ) {

        // Get the properties defining the MOIN-folders:
        List<IpiDiDcDefinitionProvider.PropertyProvider> folderPropertyProviders = moinRelevantFoldersPropertyProvider.getChildProperties( );
        moinResourceFolderPaths.ensureCapacity( folderPropertyProviders.size( ) );
        String folderPath = null;

        // Check all properties and collect the valid MOIN-relevant folder-properties:
        for ( int i = 0; i < folderPropertyProviders.size( ); i++ ) {
            IpiDiDcDefinitionProvider.PropertyProvider folderPropertyProvider = folderPropertyProviders.get( i );
            if ( MOIN_FOLDER_PATH_PROPERTY.equals( folderPropertyProvider.getName( ) ) ) {
                folderPath = null;
                List<IpiDiDcDefinitionProvider.AttributeProvider> folderAttributeProviders = folderPropertyProvider.getAttributes( );

                // Check attributes of folder property (unknown attributes ...) and determine scenarioAttributes:
                boolean ignoreDueToScenarioAttribute = false;
                for ( int j = 0; j < folderAttributeProviders.size( ); j++ ) {
                    IpiDiDcDefinitionProvider.AttributeProvider folderAttributeProvider = folderAttributeProviders.get( j );
                    if ( MOIN_FOLDER_PATH_ATTRIBUTE.equals( folderAttributeProvider.getName( ) ) ) {
                        folderPath = PathUtilImpl.ensureTrailingFileSeparator( folderAttributeProvider.getValue( ) );

                    } else if ( scenarioAttribute.equals( folderAttributeProvider.getName( ) ) ) {
                        if ( EXCLUDE_IN_SCENARIO.equals( folderAttributeProvider.getValue( ) ) ) {
                            ignoreDueToScenarioAttribute = true;
                        }
                    } else { // Support bug tracking: trace all unknown attributes
                        final String msg = "{0}: Attribute [{1}] for moin-property [{2}] is ignored."; //$NON-NLS-1$
                        LOGGER.trace( MoinSeverity.INFO, msg, "getAndCheckMoinFolders", folderAttributeProvider.getName( ), MOIN_FOLDER_PATH_PROPERTY ); //$NON-NLS-1$
                    }
                }
                // Check if the folder has to be ignored due to the scenarioAttribute:
                if ( ignoreDueToScenarioAttribute ) {
                    final String msg = "{0}: Moin-folder-property is ignored due to attribute [{1}]: {2}."; //$NON-NLS-1$
                    LOGGER.trace( MoinSeverity.INFO, msg, "getAndCheckMoinFolders", scenarioAttribute, folderPath ); //$NON-NLS-1$
                    folderPath = null;
                }

                if ( folderPath != null ) {

                    // Check if folder is located under generation root:
                    if ( folderPath.startsWith( getGenerationRoot( ) ) ) {
                        final String msg = "{0}: Moin-folder-property is ignored because it overlaps with generation folder: {1}."; //$NON-NLS-1$
                        LOGGER.trace( MoinSeverity.INFO, msg, "getAndCheckMoinFolders", folderPath ); //$NON-NLS-1$
                    } else {
                        // Check if folder is DcResource-folder:
                        if ( isDcResourceFolder( folderPath ) == mustBeDcResourceFolder ) {

                            // Check if folder overlaps with already found folder:
                            if ( PathUtilImpl.doesResourceFoldersOverlap( folderPath, moinResourceFolderPaths, PathUtilImpl.OVERLAP_INCLUDES_EQUAL ) ) {
                                final String msg = "{0}: Moin-folder-property is ignored because it overlaps with other Moin-folder-property: {1}."; //$NON-NLS-1$
                                LOGGER.trace( MoinSeverity.INFO, msg, "getAndCheckMoinFolders", folderPath ); //$NON-NLS-1$
                            } else {
                                // Proper definition of MOIN-resource-folder found
                                moinResourceFolderPaths.add( folderPath );
                            }
                        } else {
                            final String warning = ( mustBeDcResourceFolder ? "{0}: Moin-folder-property (registered as resource-folder) is ignored because it is no Dc-resource-folder: {1}" //$NON-NLS-1$
                                                                           : "{0}: Moin-folder-property (registered as non-resource-folder) is ignored because it is a Dc-resource-folder: {1}" ); //$NON-NLS-1$
                            LOGGER.trace( MoinSeverity.WARNING, warning, "getAndCheckMoinFolders", folderPath ); //$NON-NLS-1$
                        }
                    }

                }
            } else {
                final String msg = "{0}: Unknown child property [{1}] for moin-property [{2}]."; //$NON-NLS-1$
                LOGGER.trace( MoinSeverity.INFO, msg, "getAndCheckMoinFolders", folderPropertyProvider.getName( ), IpiDiDcDefinitionProvider.MOIN_PROPERTY ); //$NON-NLS-1$
            }
        }
        // there could be additional child properties (illegally)
        moinResourceFolderPaths.trimToSize( );
    }

    private boolean isDcResourceFolder( String folderPath ) {

        List<String> dcFolderPaths = getDcFolderPaths( );
        if ( folderPath == null || ( dcFolderPaths == null || dcFolderPaths.size( ) == 0 ) ) {
            return false;
        }
        // Check if the given folderPath is a DC-resource-folder (i.e. DC-source- or DC-package-folder) or a sub-folder of such a DC-resource folder
        int len = folderPath.length( );
        for ( int i = 0; i < dcFolderPaths.size( ); i++ ) {
            String dcFolderPath = dcFolderPaths.get( i );
            if ( len > dcFolderPath.length( ) ) {
                if ( folderPath.startsWith( dcFolderPath ) ) {
                    return true;
                }
            } else if ( dcFolderPath.startsWith( folderPath ) ) {
                return true;
            }
        }
        return false;
    }

    private Collection<PRI> mergePartitions( Collection<PRI> persistedPartitions, Collection<PartitionOperation> dirtyPartitions ) {

        // Get the persisted partitions:        
        List<PRI> partitionsInContainer = new ArrayList<PRI>( );
        partitionsInContainer.addAll( persistedPartitions );

        // Consider dirty partitions:
        // - add dirty created partitions
        // - remove dirty deleted partitions
        for ( PartitionOperation dirtyPartition : dirtyPartitions ) {
            switch ( dirtyPartition.getOperation( ) ) {
                case CREATE:
                    partitionsInContainer.add( dirtyPartition.getPartitionPri( ) );
                    break;
                case DELETE:
                    partitionsInContainer.remove( dirtyPartition.getPartitionPri( ) );
                    break;
            } // EDIT does not influence the set of partitions
        }

        return partitionsInContainer;
    }

    private List<DiDcToPpDependencyImpl> getReferencesToPublicParts( ) {

        List<IpiDiDcToPpDependencyProvider> ppDependencyProviders = _moinDiDcDefinitionProvider.getReferencesToPublicParts( );
        ArrayList<DiDcToPpDependencyImpl> ppDependencies = new ArrayList<DiDcToPpDependencyImpl>( ppDependencyProviders.size( ) );
        for ( IpiDiDcToPpDependencyProvider ppDependencyProvider : ppDependencyProviders ) {
            ppDependencies.add( new DiDcToPpDependencyImpl( ppDependencyProvider, _diConfiguration ) );
        }
        return ppDependencies;
    }

    private HashSet<DiDevelopmentComponentImpl> getDcs( ArrayList<DiPublicPartImpl> publicParts ) {

        HashSet<DiDevelopmentComponentImpl> dcs = new HashSet<DiDevelopmentComponentImpl>( );
        for ( int i = 0; i < publicParts.size( ); i++ ) {
            DiPublicPartImpl publicPart = publicParts.get( i );
            DiDevelopmentComponentImpl dc = publicPart.getDevelopmentComponent( );
            dcs.add( dc );
        }

        return dcs;
    }

    private ArrayList<CRI> getCris( HashSet<DiDevelopmentComponentImpl> dcs ) {

        ArrayList<CRI> cris = new ArrayList<CRI>( dcs.size( ) );

        for ( DiDevelopmentComponentImpl dc : dcs ) {
            cris.add( dc.getCri( ) );
        }

        return cris;
    }

    private List<PartitionOperation> filterPartitionsOfDc( DiDevelopmentComponentImpl dc, List<PartitionOperation> dirtyPartitions ) {

        ArrayList<PartitionOperation> dirtyPartitionsForDc = new ArrayList<PartitionOperation>( dirtyPartitions.size( ) );
        for ( PartitionOperation dirtyPartition : dirtyPartitions ) {
            if ( dirtyPartition.getPartitionPri( ).getCri( ).equals( dc.getCri( ) ) ) {
                dirtyPartitionsForDc.add( dirtyPartition );
            }
        }
        dirtyPartitionsForDc.trimToSize( );
        return dirtyPartitionsForDc;
    }

}

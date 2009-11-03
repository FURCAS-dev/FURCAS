package com.sap.tc.moin.facility.primary.diservice.fs.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.facility.primary.diservice.impl.DiDevelopmentComponentImpl;
import com.sap.tc.moin.facility.primary.diservice.impl.DiServiceImpl;
import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiQuery;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiConfigurationProvider;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiServiceException;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ContainerResourceRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.PartitionIsCreatableResultRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceArchiveFoldersRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceArchivesRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceFoldersRecord;
import com.sap.tc.moin.facility.primary.ipi.fs.IpiFsResourceManagement.ResourceRecord;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

/**
 * @author d021091
 */
public abstract class DiFsServiceImpl extends DiServiceImpl {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, DiFsServiceImpl.class );

    private static final List<ContainerResourceRecord> EMPTY_CONTAINER_RESOURCE_RECORDS = null;

    private IpiFsResourceManagement _fsPersistenceResourceHandler;

    private IpiQuery _fsPersistenceQuery;

    // Convenience:
    protected static final boolean DO_CREATE_CLIENT_SPEC = true;

    protected static final boolean DONT_CREATE_CLIENT_SPEC = false;

    protected static final boolean FORCED_REFRESH = true;

    protected static final boolean DONT_FORCED_REFRESH = false;


    /** ******************** Construction *********************************** */

    protected DiFsServiceImpl( ) {

        super( );
    }


    public void bind( IpiFsResourceManagement fsPersistenceResourceHandler ) {

        _fsPersistenceResourceHandler = fsPersistenceResourceHandler;
    }

    public void bind( IpiQuery query ) {

        _fsPersistenceQuery = query;
    }


    /** ******************** API for sub classes **************************** */

    /**
     * Scenario-specific sub-classes might overwrite this method to provide
     * consistency check concerning the diConfigurationProvider. This provider
     * could e.g. be invalid, because the respective DevConfigImport was removed
     * in the meanwhile.
     * <p>
     * In case the provider is invalid then the method has to return NULL.
     */
    protected DiFsConfigurationImpl createAndCheckDiConfiguration( IpiDiConfigurationProvider diConfigurationProvider, DataAreaDescriptor dataAreaDescriptor ) {

        return new DiFsConfigurationImpl( diConfigurationProvider, dataAreaDescriptor, _riFactory );
    }

    /**
     * The method retrieves or creates a client-spec.
     * <p>
     * Caution:
     * <p>
     * The initialization of FsPersistence is not done here, but the concrete
     * sub-classes in the respective scenarios have to implement this handling
     * in a scenario-specific way. E.g. the handling in IDE is different to the
     * handling in Build.
     */
    protected synchronized SpiClientSpec getOrCreateClientSpec( String clientSpecId, String dataAreaName, boolean doCreate ) throws IpiDiServiceException {

        // Check preconditions:
        checkStringParameter( "getOrCreateClientSpec", "clientSpecId", clientSpecId ); //$NON-NLS-1$ //$NON-NLS-2$
        checkStringParameter( "getOrCreateClientSpec", "dataAreaName", dataAreaName ); //$NON-NLS-1$ //$NON-NLS-2$

        // Get or create data area and client spec (lazy initialization):
        // In file-system-based scenarios:
        // - For each Data Area there is exactly one ClientSpec and there is exactly 1 compound data area and 1 compound Client spec.
        // (In JEE-scenario: 
        // - Different instances of the same data area can be combined in different compound data areas and compound client specs
        // --> handling is done by CompoundDataAreaManager)
        // - The data area and the client spec are initialized together and lazy, e.g. in IDE:
        // -- triggered by the first access to the client spec for a given project
        // -- lazy initialization for all MOIN projects covered by the development configuration for the given project
        // -- see above for the mapping
        // - Later accesses to the client spec for the same project or a different project of the same development configuration 
        //   just return the already initialized client spec.
        SpiClientSpec nwdiClientSpec = null;
        IpiDataArea diDataArea = _dataAreaManager.getDataAreaByName( dataAreaName );
        if ( diDataArea == null ) {
            // If the data area does not exist then there cannot exist any client-specs for that data area
            if ( !doCreate ) {
                return null; // pure getter-functionality !!!
            }
            // --> Create the data area and the client spec
            try {
                diDataArea = _dataAreaManager.createRegularDataArea( dataAreaName );
            } catch ( Exception e ) {
                // Message: "Creating regular data area [{0}] failed"
                IpiDiServiceException e1 = new IpiDiServiceException( e, DiFsServiceMessages.CREATING_REGULAR_DATA_AREA_FAILED, dataAreaName );
                LOGGER.trace( e1, MoinSeverity.ERROR, e1.getMessage( ) );
                throw e1;
            }
            nwdiClientSpec = diDataArea.getSingleClientSpec( );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, "getOrCreateClientSpec: created data area [name: {0}] and client spec [{1}].", diDataArea.getDescriptor( ).getDataAreaName( ), nwdiClientSpec.getClientId( ) ); //$NON-NLS-1$
            }

        } else {
            try {
                // Retrieve the client spec for the existing data area:
                nwdiClientSpec = (SpiClientSpec) diDataArea.getClientSpec( clientSpecId );
            } catch ( Exception e1 ) {
                // Message: "Retrieval of client spec [name: {0}] for data area [{1}] failed"
                IpiDiServiceException e2 = new IpiDiServiceException( e1, DiFsServiceMessages.RETRIEVAL_OF_CLIENT_SPEC_FAILED, clientSpecId, dataAreaName );
                LOGGER.trace( e2, MoinSeverity.ERROR, e2.getMessage( ) );
                throw e2;
            }
            if ( nwdiClientSpec == null ) {
                // Message: "Internal error: The client spec [name:{0}] for data area [{0}] does not exist"
                IpiDiServiceException e1 = new IpiDiServiceException( DiFsServiceMessages.INTERNAL_ERROR_CLIENT_SPEC_DOES_NOT_EXIST, clientSpecId, dataAreaName );
                LOGGER.trace( e1, MoinSeverity.ERROR, e1.getMessage( ) );
                throw e1;
            }
        }

        // Caution:
        // The initialization of FsPersistence is not done here, but the concrete
        // sub-classes in the respective scenarios have to implement this handling
        // in a scenario-specific way. E.g. the handling in IDE is different to the
        // handling in Build.

        return nwdiClientSpec;
    }

    /**
     * The methods removes the given data area and the respective client spec
     * (in case of file system there is only one client spec per data area).
     * <p>
     * Caution:
     * <p>
     * This method must only be called during failed initializations because it
     * does not consider other references data area or client spec (e.g. by
     * compound data area or compound client spec).
     */
    protected void removeDataAreaAndClientSpec( DataAreaDescriptor dataAreaDescriptor ) {

        _dataAreaManager.deleteDataArea( dataAreaDescriptor.getDataAreaName( ) );
    }

    /**
     * The method triggers that the container identified by <code>cri</code> is
     * removed from FsPersistence and all persistence-internal clean-ups
     * involved are done.
     */
    protected void removeFromFsPersistence( CRI cri ) {

        _fsPersistenceResourceHandler.removeContainer( cri );
    }

    /**
     * The method removes all registrations for the the data area described by
     * the given <code>dataAreaDescriptor</code> from FsPersistence and all
     * persistence-internal clean-ups involved are done.
     */
    protected void removeFromFsPersistence( DataAreaDescriptor dataAreaDescriptor ) throws IpiDiServiceException {

        _fsPersistenceResourceHandler.updateDataArea( dataAreaDescriptor, EMPTY_CONTAINER_RESOURCE_RECORDS );
    }

    /**
     * The method triggers that the FsPersistence is initialized concerning the
     * given container <code>moinDc</code>. If this container is already known
     * in FsPersistence then it is updated accordingly. The given flag
     * <code>forced</code> determines if this update is done in forced-mode or
     * not.
     * <p>
     * Remark:
     * <p>
     * FsPersistence can survive although the MOIN-relevant folders does not
     * exist.
     * <p>
     * Caution:
     * <p>
     * Source-Registrations and Archive-Registrations are exclusive
     * <p>
     * --> It purely depends on the dcSourcState of moinDc which registrations
     * are considered and which are ignored:
     * <p>
     * -- DcSourceState.SOURCE --> sources considered, archives ignored
     * <p>
     * -- DcSourceState.ARCHIVE --> archives considered, sources ignored
     * <p>
     * Caution:
     * <p>
     * Synchronization & Locking has to be done on the concrete
     * scenario-specific layer if needed.
     * <p>
     * Caution in IDE-Scenario:
     * <p>
     * This method MUST be enclosed in a synchronized-block which is enclosed in
     * a Eclipse-workspace-runnable or an Eclipse-job-lock. This is a
     * requirement coming from the handling in FsPersistence for Eclipse. See
     * IdeDiServiceImpl for details.
     */
    public boolean initOrUpdateFsPersistence( DiFsDevelopmentComponentImpl moinFsDc, boolean forced ) {

        LOGGER.trace( MoinSeverity.INFO, "initOrUpdateFsPersistence: Registering DC definition at MOIN: {0}.", moinFsDc.toString( ) ); //$NON-NLS-1$

        ResourceRecord resourceRecord = null;
        if ( moinFsDc.isVisibleAsSources( ) ) {
            // (1) Handle DCs which are available as sources:
            resourceRecord = computeResourceRecordForDcWithSources( moinFsDc );

        } else if ( moinFsDc.isVisibleAsArchives( ) ) {
            // (2) Handle DCs which are available as archives (which might be somewhere distributed on several locations):
            resourceRecord = computeResourceRecordForDcWithArchives( moinFsDc );

        } else {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                Object[] args = { moinFsDc, moinFsDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ), moinFsDc.getDcSourceState( ) };
                LOGGER.traceWithStack( MoinSeverity.WARNING, "initOrUpdateFsPersistence: ignoring definition for MOIN DC [name: {0}, data area: {1}] due to internal error: DC has unknown source state: {2}", args ); //$NON-NLS-1$
            }
            return false; // This MUST NOT stop the flow which started the initialization concerning this DC ...
        }

        // (3) Initialize the FsPersistence for the container
        if ( resourceRecord == null ) {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                Object[] args = { moinFsDc, moinFsDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ) };
                LOGGER.traceWithStack( MoinSeverity.WARNING, "initOrUpdateFsPersistence: ignoring definition for MOIN DC [name: {0}, data area: {1}] because it does not define MOIN-relevant folders.", args ); //$NON-NLS-1$
            }
            return false; // something is wrong with the DC definition or state on local disc --> we ignore the DC
        }
        CRI cri = moinFsDc.getCri( );
        _fsPersistenceResourceHandler.updateContainer( cri, resourceRecord, forced );
        // and check if the registration succeeded:
        if ( !_fsPersistenceResourceHandler.resourcesAvailableForContainer( cri ) ) {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                Object[] args = { moinFsDc, moinFsDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ) };
                LOGGER.traceWithStack( MoinSeverity.WARNING, "initOrUpdateFsPersistence: ignoring definition for MOIN DC [name: {0}, data area: {1}] because it could not be registered at MOIN persistence.", args ); //$NON-NLS-1$
            }
            return false;
        }
        return true;
    }

    /**
     * The method initializes the FsPeristence for the data area described by
     * the given <code>dataAreaDescriptor</code> and the given containers
     * <code>moinDcs</code> completely. It returns the list of containers which
     * could not be registered because e.g. the respective archives were not
     * found.
     */
    public Collection<DiDevelopmentComponentImpl> initializeFsPersistence( Collection<DiDevelopmentComponentImpl> moinDcs, DataAreaDescriptor dataAreaDescriptor ) throws IpiDiServiceException {

        // Synchronization & Locking has to be done on the concrete scenario-specific layer if needed.

        // Caution in IDE-Scenario: 
        // This method MUST be enclosed in a synchronized-block which is enclosed in a Eclipse-workspace-runnable or an Eclipse-job-lock.
        // This is a requirement coming from the handling in FsPersistence for Eclipse.
        // See IdeDii05ServiceImpl for details.

        // collect file system data for each container based on the current state
        List<ContainerResourceRecord> containerResourceRecords = new ArrayList<ContainerResourceRecord>( moinDcs.size( ) );

        for ( DiDevelopmentComponentImpl moinDc : moinDcs ) {
            DiFsDevelopmentComponentImpl moinFsDc = (DiFsDevelopmentComponentImpl) moinDc;

            // create resource record for this container 
            ContainerResourceRecord containerResourceRecord = new ContainerResourceRecord( );
            containerResourceRecord.cri = moinDc.getCri( );
            ResourceRecord resourceRecord = null;

            if ( moinFsDc.isVisibleAsSources( ) ) {
                // (1) Handle DCs which are available as sources:
                resourceRecord = computeResourceRecordForDcWithSources( moinFsDc );

            } else if ( moinFsDc.isVisibleAsArchives( ) ) {
                // (2) Handle DCs which are available as archives (which might be somewhere distributed on several locations):
                resourceRecord = computeResourceRecordForDcWithArchives( moinFsDc );

            } else {
                if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                    Object[] args = { moinFsDc, moinFsDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ), moinFsDc.getDcSourceState( ) };
                    LOGGER.traceWithStack( MoinSeverity.WARNING, "initializeFsPersistence: ignoring definition for MOIN DC [name: {0}, data area: {1}] due to internal error: DC has unknown source state: {2}", args ); //$NON-NLS-1$
                }
                continue; // This MUST NOT stop the flow which started the initialization concerning this DC ...
            }

            if ( resourceRecord == null ) {
                if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                    Object[] args = { moinFsDc, moinFsDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ) };
                    LOGGER.traceWithStack( MoinSeverity.WARNING, "initializeFsPersistence: ignoring definition for MOIN DC [name: {0}, data area: {1}] because it does not define MOIN-relevant folders.", args ); //$NON-NLS-1$
                }
                continue; // something is wrong with the DC definition or state on local disc --> we ignore the DC
            }
            containerResourceRecord.resourceRecord = resourceRecord;

            // add records of current container
            containerResourceRecords.add( containerResourceRecord );
        }

        // Update the FsPersistence with current state
        _fsPersistenceResourceHandler.updateDataArea( dataAreaDescriptor, containerResourceRecords );
        // and check which of the container were registered:
        ArrayList<DiDevelopmentComponentImpl> notRegisteredMoinDcs = new ArrayList<DiDevelopmentComponentImpl>( moinDcs.size( ) );
        for ( DiDevelopmentComponentImpl moinDc : moinDcs ) {
            if ( !_fsPersistenceResourceHandler.resourcesAvailableForContainer( moinDc.getCri( ) ) ) {
                notRegisteredMoinDcs.add( moinDc );
                if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                    Object[] args = { moinDc, moinDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ) };
                    LOGGER.traceWithStack( MoinSeverity.WARNING, "initializeFsPersistence: ignoring definition for MOIN DC [name: {0}, data area: {1}] due to missing data for the registration (definition of MOIN-relevant folders or archive locations).", args ); //$NON-NLS-1$
                }
            }
        }
        return notRegisteredMoinDcs;
    }

    /** ******************** Internals ************************************** */

    protected ResourceFoldersRecord computeResourceRecordForDcWithSources( DiFsDevelopmentComponentImpl moinDc ) {

        // (1.1) Determine all native MOIN-relevant folders (MOIN resource folders) including their mapping to local disc:
        Map<String, String> moinRelevantFolderPaths = moinDc.getMoinRelevantNativeFolderPaths( );
        // (1.2) Determine all custom MOIN-relevant folders (not checked against DI resource folders) including their mapping to local disc:
        moinRelevantFolderPaths.putAll( moinDc.getMoinRelevantCustomFolderPaths( _customContentSelectionRegistry ) );

        // (1.3) Check if DC is valid: >= 1 folders are registered for the DC
        if ( moinRelevantFolderPaths.isEmpty( ) ) {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                Object[] args = { moinDc, moinDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ) };
                LOGGER.traceWithStack( MoinSeverity.WARNING, "computeResourceRecordForDcWithSources: ignoring definition for MOIN DC [name: {0}, data area: {1}] because it does not define MOIN-relevant folders.", args ); //$NON-NLS-1$
            }
            return null;
        }

        // (2) Determine the corresponding resourceRecord 
        ResourceFoldersRecord resourceFoldersRecord = new ResourceFoldersRecord( );
        resourceFoldersRecord.resourceFolderPathsToRootPaths = moinRelevantFolderPaths;
        return resourceFoldersRecord;
    }

    protected ResourceRecord computeResourceRecordForDcWithArchives( DiFsDevelopmentComponentImpl moinDc ) {

        ResourceRecord resourceRecord;
        // (1.1) Determine all native MOIN-relevant folders (MOIN resource folders, generation folder) 
        List<String> moinRelevantFolders = moinDc.getMoinRelevantFolders( );

        // (1.2) Determine all custom MOIN-relevant folders (not checked against DI resource folders)
        moinRelevantFolders.addAll( moinDc.getMoinRelevantCustomFolders( _customContentSelectionRegistry ) );

        // (1.3) Check if DC is valid: >= 1 folders are registered for the DC
        if ( moinRelevantFolders.isEmpty( ) ) {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                Object[] args = { moinDc, moinDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ) };
                LOGGER.traceWithStack( MoinSeverity.WARNING, "computeResourceRecordForDcWithArchives: ignoring definition for MOIN DC [name: {0}, data area: {1}] because it does not define MOIN-relevant folders.", args ); //$NON-NLS-1$
            }
            return null;
        }

        // (2) Determine the corresponding resourceRecord

// hot_todo: handling of custom PPs

        // (2.1) ... for case where only a DC-archive-folder-paths can be retrieved:
        // Remark: 1 archive-folder-path for each PP of the DC
        List<String> moinDcArchivePaths = null;
        List<String> moinDcArchiveFolderPaths = moinDc.getDcArchiveFolderPaths( );
        if ( moinDcArchiveFolderPaths != null && moinDcArchiveFolderPaths.size( ) > 0 ) {
            ResourceArchiveFoldersRecord resourceArchiveFoldersRecord = new ResourceArchiveFoldersRecord( );
            resourceArchiveFoldersRecord.archiveFoldersPaths = moinDcArchiveFolderPaths;
            resourceArchiveFoldersRecord.resourceFoldersPaths = moinRelevantFolders;
            resourceRecord = resourceArchiveFoldersRecord;

        } else {
            // (2.2) ... for case where the single DC-archive-paths can be retrieved:
            // Remark: 1 or several archive-paths for each PP of the DC
            moinDcArchivePaths = moinDc.getDcArchivePaths( );
            if ( moinDcArchivePaths != null && moinDcArchivePaths.size( ) > 0 ) {
                ResourceArchivesRecord resourceArchivesRecord = new ResourceArchivesRecord( );
                resourceArchivesRecord.archivePaths = moinDcArchivePaths;
                resourceArchivesRecord.resourceFoldersPaths = moinRelevantFolders;
                resourceRecord = resourceArchivesRecord;
            } else {
                if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                    Object[] args = { moinDc, moinDc.getDiConfiguration( ).getDataAreaDescriptor( ).getDataAreaName( ) };
                    LOGGER.traceWithStack( MoinSeverity.WARNING, "computeResourceRecordForDcWithArchives: ignoring definition for MOIN DC [name: {0}, data area: {1}] because DC archive paths and DC archive folder path could not be retrieved.", args ); //$NON-NLS-1$
                }
                return null;
            }
        }

        return resourceRecord;
    }

    @Override
    protected void checkPartitionIsCreatable( PRI pri ) throws IpiDiServiceException {

        //(0) Use Persistence to check if partition is creatable:

        // Only Persistence can determine: 
        // - Does partition exist in index and/or on local disc?
        // more detailed:
        // - Does partition exist in same upper/lower case in index ?
        // - Does partition exists with path in same or different upper/lower case on local disc ?

        // Remark:
        // _fsPersistenceResourceHandler.partitionExists( pri ) cannot be used, because it is purely based on index.

        PartitionIsCreatableResultRecord resultRecord;
        try {
            resultRecord = _fsPersistenceResourceHandler.partitionIsCreatable( pri );
        } catch ( Exception e ) {
            // ACCESS_TO_LOCAL_DISC_FAILED=Partition [name\: {0}, development component\: {1}] cannot be created because the access to the partition file on local disc failed\: {2}.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ), e.getMessage( ) };
            IpiDiServiceException e1 = new IpiDiServiceException( e, DiFsServiceMessages.ACCESS_TO_LOCAL_DISC_FAILED, args );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e1, MoinSeverity.DEBUG );
            }
            throw e1;
        }

        // (1) First check the (hopefully) normal state: partition is creatable
        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.CREATABLE ) {
            return;
        }

        // (2) Then check all possible problem reasons (why partition is not creatable) and produce expressive exceptions
        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.NOT_CREATABLE_CASE_CONFLICT ) {
            // NAME_CLASH_TO_FILE_WITH_DIFFERENT_UPPER_LOWER_CASE=Partition [name\: {0}, development component\: {1}] cannot be created because a file with different upper \/ lower case already exists on local disc\: {2}.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ), resultRecord.existingPath };
            IpiDiServiceException e = new IpiDiServiceException( DiFsServiceMessages.NAME_CLASH_TO_FILE_WITH_DIFFERENT_UPPER_LOWER_CASE, args );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG );
            }
            throw e;
        }
        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.NOT_CREATABLE_ALREADY_EXISTS ) {
            // PARTITION_ALREADY_EXISTS: Partition [name\: {0}, development component\: {1}] cannot be created because the partition file already exists on local disc.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ) };
            IpiDiServiceException e = new IpiDiServiceException( DiFsServiceMessages.PARTITION_ALREADY_EXISTS, args );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG );
            }
            throw e;
        }
        if ( resultRecord.result == PartitionIsCreatableResultRecord.CreatableCheckResult.NOT_CREATABLE_RESOURCE_ARCHIVE_NOT_WRITEABLE ) {
            // PARTITION_CREATION_NOT_POSSIBLE_IN_ARCHIVE: Partition [name\: {0}, development component\: {1}] cannot be created because it is not possible to create new partitions inside an archive.
            Object[] args = { pri.getPartitionName( ), pri.getContainerName( ) };
            IpiDiServiceException e = new IpiDiServiceException( DiFsServiceMessages.PARTITION_CREATION_NOT_POSSIBLE_IN_ARCHIVE, args );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG );
            }
            throw e;
        }
        // Should never happen:
        // UNKNOWN_RESULT_FROM_PERSISTENCE_CREATABLE_CHECK=Internal Error\: Partition [name\: {0}, development component\: {1}] cannot be created because the respective persistence test has returned an unknown result\: {2}. 
        Object[] args = { pri.getPartitionName( ), pri.getContainerName( ), resultRecord.result };
        MoinIllegalStateException e = new MoinIllegalStateException( DiFsServiceMessages.UNKNOWN_RESULT_FROM_PERSISTENCE_CREATABLE_CHECK, args );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
        }
        throw e;
    }

    @Override
    protected boolean doesPartitionExist( PRI pri ) {

        // The index is the primary source for FsPersistence.
        // --> This method only relies on the (case sensitive) information coming from index 
        //     and it does not access the local disc to see the truth due to the performance impact.
        return _fsPersistenceResourceHandler.partitionExists( pri );
    }

    @Override
    protected boolean isPartitionReadOnly( PRI pri ) {

        // Only Persistence can determine: Is partition read-only on local disc?
        // Precondition: doesPartitionExist --> else: Persistence throws exception
        return _fsPersistenceResourceHandler.partitionIsReadOnly( pri );
    }

    @Override
    protected Collection<PRI> getPersistedPartitions( CRI cri ) {

        return _fsPersistenceQuery.getPartitionsInContainer( cri );
    }

    /** ******************** Internals ************************************** */

    protected void checkStringParameter( String methodName, String paramName, String paramValue ) {

        if ( paramValue == null ) {
            // Message: "Method "{0}"\: Argument with name "{1}" has an illegal value
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( methodName, paramName, "null" ); //$NON-NLS-1$
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
    }

}

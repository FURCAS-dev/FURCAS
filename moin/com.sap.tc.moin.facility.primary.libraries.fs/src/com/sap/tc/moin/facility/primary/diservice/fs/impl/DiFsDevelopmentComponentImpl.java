package com.sap.tc.moin.facility.primary.diservice.fs.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.facility.primary.diservice.impl.DiConfigurationImpl;
import com.sap.tc.moin.facility.primary.diservice.impl.DiContentSelectionRegistryImpl;
import com.sap.tc.moin.facility.primary.diservice.impl.DiDevelopmentComponentImpl;
import com.sap.tc.moin.facility.primary.diservice.impl.PathUtilImpl;
import com.sap.tc.moin.facility.primary.ipi.diservice.IpiDiDcDefinitionProvider;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * @author d021091
 */

// hot_todo: move in separate sub project and separate package
public class DiFsDevelopmentComponentImpl extends DiDevelopmentComponentImpl {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, DiFsDevelopmentComponentImpl.class );

    // Additional MOIN-folders: MOIN-folder --> folder path
    // (only use case known so far: MOIN-folders in the output-folder of DcBuild)
    private Map<String, String> _additionalMoinFolders;

    // MOIN-folders from the map:
    private List<String> _additionalMoinFolderPaths;

    // For DCs available as archives:
    private List<String> _dcArchivePaths;

    private List<String> _dcArchiveFolderPaths;

    /** ******************** Construction *********************************** */

    protected DiFsDevelopmentComponentImpl( IpiDiDcDefinitionProvider moinDiDcDefinition, CRI cri, DiConfigurationImpl diConfiguration ) {

        super( moinDiDcDefinition, cri, diConfiguration );
    }

    /** ************************* API ************************************** */

    @Override
    public List<String> getMoinRelevantFolders( ) {

        List<String> moinRelevantFolders = super.getMoinRelevantFolders( );

        // Handle additional MOIN folders (only relevant in FS based scenarios, currently only used in DC Build)
        if ( IpiDiDcDefinitionProvider.DcSourceState.SOURCE.equals( getDcSourceState( ) ) ) {
            moinRelevantFolders.addAll( getAdditionalMoinFolders( ) );
        }
        return moinRelevantFolders;
    }

    // API in superclass:
    // - ...
    // - getMoinResourceFolders
    // - getMoinFolders
    //
    // Additional MOIN-relevant folders are only relevant in scenarios with
    // file-system. The only use-case know so far is MOIN-folders in the
    // output-folder of DcBuild.
    public List<String> getAdditionalMoinFolders( ) {

        checkInvalid( );

        if ( _additionalMoinFolderPaths == null ) {
            // Lazy computation:
            _additionalMoinFolderPaths = new ArrayList<String>( getAdditionalMoinFoldersMapping( ).size( ) );
            int i = 0;
            for ( String folder : getAdditionalMoinFoldersMapping( ).keySet( ) ) {
                _additionalMoinFolderPaths.set( i, folder );
            }
        }
        return Collections.unmodifiableList( _additionalMoinFolderPaths );
    }

    public List<String> getDcArchivePaths( ) {

        checkInvalid( );

        if ( _dcArchivePaths == null ) {
            _dcArchivePaths = getDiDcDefinitionProvider( ).getDcArchivePaths( );
        }
        return _dcArchivePaths;
    }

    public List<String> getDcArchiveFolderPaths( ) {

        checkInvalid( );

        if ( _dcArchivePaths != null && _dcArchivePaths.size( ) > 0 ) {
            return null;
        }
        if ( _dcArchiveFolderPaths == null ) {
            _dcArchiveFolderPaths = getDiDcDefinitionProvider( ).getDcArchiveFolderPaths( );
        }
        return _dcArchiveFolderPaths;
    }

    @Override
    public void resetInternalCaches( ) {

        super.resetInternalCaches( );

        _additionalMoinFolderPaths = null;
        _additionalMoinFolders = null;
        _dcArchivePaths = null;
        String methodName = "resetInternalCaches"; //$NON-NLS-1$
        LOGGER.trace( MoinSeverity.INFO, "{0}: Reset internal caches concerning MOIN DC: {1}.", methodName, toString( ) ); //$NON-NLS-1$
    }

    /** ******************** Internals ************************************** */

    private Map<String, String> getAdditionalMoinFoldersMapping( ) {

        if ( _additionalMoinFolders == null ) {
            // Lazy computation:
            _additionalMoinFolders = getDiDcDefinitionProvider( ).getAdditionalMoinFolders( );
            if ( _additionalMoinFolders == null ) {
                // No additional MOIN-folders defined
                _additionalMoinFolders = Collections.emptyMap( );
            }
            // Check if those MOIN-relevant folders overlap with the MOIN-
            // resource-folders and MOIN-folders from DC-definition:
            List<String> moinResourceFolder = getMoinResourceFolders( );
            List<String> moinFolder = getMoinFolders( );
            Iterator<String> iter = _additionalMoinFolders.keySet( ).iterator( );
            while ( iter.hasNext( ) ) {
                String additionalMoinFolder = iter.next( );
                if ( PathUtilImpl.doesResourceFolderOverlap( additionalMoinFolder, moinResourceFolder, PathUtilImpl.OVERLAP_INCLUDES_EQUAL ) ) {
                    // overlapping additional MOIN-folders are ignored
                    iter.remove( );
                    continue;
                }
                if ( PathUtilImpl.doesResourceFolderOverlap( additionalMoinFolder, moinFolder, PathUtilImpl.OVERLAP_INCLUDES_EQUAL ) ) {
                    // overlapping additional MOIN-folders are ignored
                    iter.remove( );
                    continue;
                }
            }
        }
        return _additionalMoinFolders;
    }

    // map:
    // moin-resource-folder --> absolute root path for folder
    // (relative folder path for moin-resource-folder)
    protected Map<String, String> getMoinRelevantNativeFolderPaths( ) {

        Map<String, String> moinRelevantFolderPaths = Collections.emptyMap( );

        // Check preconditions:
        if ( !( IpiDiDcDefinitionProvider.DcSourceState.SOURCE.equals( getDcSourceState( ) ) ) ) {
            // If the DC is not available as source then there is no path
            // mapping, but we react in an error-tolerant way.
            return moinRelevantFolderPaths;
        }
        // Handle DCs which are available as sources:

        // - MOIN-resource-folders and MOIN-folders from DC-definition:
        String dcRootPath = getDiDcDefinitionProvider( ).getDcRootPath( );
        if ( dcRootPath == null || dcRootPath.length( ) == 0 ) {
            // Message: "Internal error: null project root path in DC-definition-provider [development component: {0}]"
            MoinIllegalStateException e = new MoinIllegalStateException( DiFsServiceMessages.INTERNAL_ERROR_NULL_PROJECT_ROOT, getModelContainerName( ) );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        List<String> moinResourceFolders = getMoinResourceFolders( );
        List<String> moinSourceFolders = getMoinFolders( );

        // - MOIN generation folders:
        String generationRootLocation = getDiDcDefinitionProvider( ).getGenerationRootLocation( );
        if ( generationRootLocation == null || generationRootLocation.length( ) == 0 ) {
            // Message: "Internal error: null generation root location in DC-definition-provider [development component: {0}]"
            MoinIllegalStateException e = new MoinIllegalStateException( DiFsServiceMessages.INTERNAL_ERROR_NULL_GENERATION_ROOT, getModelContainerName( ) );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }
        List<String> moinGenerationFolders = getMoinGenerationFolders( );

        moinRelevantFolderPaths = new HashMap<String, String>( 2 * ( moinResourceFolders.size( ) + moinSourceFolders.size( ) + moinGenerationFolders.size( ) ) );

        for ( int i = 0; i < moinResourceFolders.size( ); i++ ) {
            moinRelevantFolderPaths.put( moinResourceFolders.get( i ), dcRootPath );
        }
        for ( int i = 0; i < moinSourceFolders.size( ); i++ ) {
            moinRelevantFolderPaths.put( moinSourceFolders.get( i ), dcRootPath );
        }
        for ( int i = 0; i < moinGenerationFolders.size( ); i++ ) {
            moinRelevantFolderPaths.put( moinGenerationFolders.get( i ), generationRootLocation );
        }

        // - Additional MOIN folders:
        // (Remark: The additional MOIN-folders are provided by the
        // DcDefinitionProvider only in scenarios where they are needed, e.g. during build.)
        moinRelevantFolderPaths.putAll( getAdditionalMoinFoldersMapping( ) );

        return moinRelevantFolderPaths;
    }

    // map:
    // MOIN relevant custom folder --> absolute root path for folder
    // (relative folder path for MOIN relevant folder)
    protected Map<String, String> getMoinRelevantCustomFolderPaths( DiContentSelectionRegistryImpl customContentSelectionRegistry ) {

        Map<String, String> moinRelevantCustomFolderPaths = Collections.emptyMap( );

        // Check preconditions:
        if ( !( IpiDiDcDefinitionProvider.DcSourceState.SOURCE.equals( getDcSourceState( ) ) ) ) {
            // If the DC is not available as source then there is no path
            // mapping, but we react in an error-tolerant way.
            return moinRelevantCustomFolderPaths;
        }
        // Handle DCs which are available as sources:

        // - MOIN-resource-folders and MOIN-folders from DC-definition:
        String dcRootPath = getDiDcDefinitionProvider( ).getDcRootPath( );
        if ( dcRootPath == null || dcRootPath.length( ) == 0 ) {
            // Message: "Internal error: null project root path in DC-definition-provider [development component: {0}]"
            MoinIllegalStateException e = new MoinIllegalStateException( DiFsServiceMessages.INTERNAL_ERROR_NULL_PROJECT_ROOT, getModelContainerName( ) );
            LOGGER.trace( e, MoinSeverity.DEBUG, e.getMessage( ) );
            throw e;
        }

        List<String> moinCustomFolders = getMoinRelevantCustomFolders( customContentSelectionRegistry );

        moinRelevantCustomFolderPaths = new HashMap<String, String>( 2 * moinCustomFolders.size( ) );

        for ( int i = 0; i < moinCustomFolders.size( ); i++ ) {
            moinRelevantCustomFolderPaths.put( moinCustomFolders.get( i ), dcRootPath );
        }

        return moinRelevantCustomFolderPaths;
    }

}

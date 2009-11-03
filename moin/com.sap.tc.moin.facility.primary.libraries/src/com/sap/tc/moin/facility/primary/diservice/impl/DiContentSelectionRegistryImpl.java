package com.sap.tc.moin.facility.primary.diservice.impl;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiCustomContentSelectionManagement;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;


/**
 * This class implements the handling of the DI-specific custom parser
 * serializer registry parts which are relevant for the DI integration (via
 * DiService): the content selection registry.
 * <p>
 * The MOIN custom parser serializer registry (part of MOIN runtime host)
 * provides a collection of properties which describe the content selection for
 * MOIN .
 * <p>
 * Those properties are technology-specific (i.e. specific for the respective
 * environment integration component, e.g. specific for DiService or ABAP
 * integration ...), in DI: the selection of MOIN-relevant DCs and their
 * MOIN-relevant folders. Therefore the custom parser serializer registry cannot
 * interpret those properties.
 * <p>
 * The specific properties are retrieved from the respective environment
 * integration component (e.g. DiService) on demand and specifically
 * interpreted. In the DiService the respective handling is encapsulated in the
 * DI-specific content selection registry.
 * 
 * @author d021091
 */
public class DiContentSelectionRegistryImpl implements SpiCustomContentSelectionManagement {

    /** ******************** Internals ************************************** */

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_DI_SERVICE, DiContentSelectionRegistryImpl.class );

    // Properties Format:
    // ------------------
    // Collection<Properties>, each element of the collection contains
    // the properties of the xml-element "Supported selection" of a CPS registration.
    // Example:
    //          <Property name=dcTypeName value="com.sap.tc.silver.bullet.nwdi.dctype.sb" />
    //          <Property name=dcTypeVendor value="sap.com" />
    //          <Property name=folder_0 value="moin/models" />
    //          <Property name=folder_1 value="diagrams" />
    //          ...

    public static final String DC_TYPE_NAME_PROPERTY = "dcTypeName"; //$NON-NLS-1$

    public static final String DC_TYPE_VENDOR_PROPERTY = "dcTypeVendor"; //$NON-NLS-1$

    public static final String MOIN_RELEVANT_FOLDER_PROPERTY = "folder"; //$NON-NLS-1$

    public static final String DI_CPS_CONTENT_SELECTION_TYPE = "DI"; //$NON-NLS-1$

    private static final boolean REFRESH = true;

    private static final boolean DONT_REFRESH = false;

    // CPS registrations are handled by RuntimeHost via PartitionSerializationManager.
    // They contain DI-specific parts which only can be interpreted by a DiContentSelectionRegistry.
    // Dummy ContentSelectionRegistry:
    // In some cases/scenarios will still do not handle custom DCs, but we
    // instantiate a Dummy ContentSelectionRegistry with _customParserSerializerRegistry == null.
    // The Dummy ContentSelectionRegistry reflects a state without any registration for CPS.
    private SpiPartitionSerializationManager _customParserSerializerRegistry;

    private CustomDcTypeRegistryImpl _customDcTypesRegistry;

    /** **************************** Construction *************************** */

    /**
     * Caution:
     * <p>
     * The constructor is NOT intended to be used by other components than the
     * DiService and the component test for the registry.
     */
    public DiContentSelectionRegistryImpl( SpiPartitionSerializationManager customParserSerializerRegistry ) {

        _customParserSerializerRegistry = customParserSerializerRegistry;
    }

    /** ************ SpiCustomContentSelectionManagement ******************** */

    /**
     * See JavaDoc in interface.
     * <p>
     * The method is a pure check-method and does not need to be synchronized.
     */
    public SpiCustomContentSelectionManagement.CheckResult checkContentSelectionProperties( ) {

        return checkOrRefreshRegistry( DONT_REFRESH );
    }

    /** ******************* Registry API inside DiService ******************* */

    /**
     * Caution:
     * <p>
     * (1) The method is synchronized via the calling DiService-methods
     * <p>
     * Therefore the method cannot be called outside the DiService, it does not
     * have an own synchronization concerning parallel DiService-operations.
     * <p>
     * (2) Refresh overwrites the registration always:
     * <p>
     * If the previous registrations were correct, but the new ones are empty or
     * incorrect, then nevertheless the registry is overwritten. This behavior
     * can also be used to reset the registry.
     */
    public SpiCustomContentSelectionManagement.CheckResult refreshRegistry( ) {

        return checkOrRefreshRegistry( REFRESH );
    }

    public boolean isMoinRelevantCustomDcType( String fullDcTypeName ) {

        if ( _customDcTypesRegistry == null || _customDcTypesRegistry.isEmpty( ) ) {
            // no lazy refresh, because this could cause concurrency problems in IDE
            // todo: check if we can keep this handling in all scenarios or if we need an IDE-specific sub-class
            return false;
        }
        return _customDcTypesRegistry.isRegistered( fullDcTypeName );
    }

    public List<String> getMoinRelevantCustomFolders( String fullDcTypeName ) {

        if ( _customDcTypesRegistry == null || _customDcTypesRegistry.isEmpty( ) ) {
            // no lazy refresh, because this could cause concurrency problems in IDE
            // todo: check if we can keep this handling in all scenarios or if we need an IDE-specific sub-class
            return Collections.emptyList( );
        }

        return _customDcTypesRegistry.getMoinRelevantCustomFolders( fullDcTypeName );
    }

    /** **************************** Internals ****************************** */

    private CheckResultImpl checkOrRefreshRegistry( boolean refresh ) {

        CheckResultImpl completeCheckResult = new CheckResultImpl( );

        // Check preconditions
        if ( _customParserSerializerRegistry == null ) {
            return completeCheckResult; // Dummy Registry is empty
        }

        String methodName = "checkOrRefreshRegistry"; //$NON-NLS-1$

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            if ( !refresh ) {
                LOGGER.traceWithStack( MoinSeverity.INFO, "{0}: Checking custom DC types registry.", methodName ); //$NON-NLS-1$
            } else if ( _customDcTypesRegistry == null ) {
                LOGGER.traceWithStack( MoinSeverity.INFO, "{0}: Creating custom DC types registry.", methodName ); //$NON-NLS-1$
            } else {
                LOGGER.traceWithStack( MoinSeverity.INFO, "{0}: Refreshing custom DC types registry.", methodName ); //$NON-NLS-1$
            }
        }

        // Retrieve the currently deployed setting concerning custom parser serializer:
        Collection<Properties> contentSelectionPropertiesCollection = _customParserSerializerRegistry.getCustomContentSelections( DI_CPS_CONTENT_SELECTION_TYPE );
        if ( contentSelectionPropertiesCollection == null || contentSelectionPropertiesCollection.isEmpty( ) ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.traceWithStack( MoinSeverity.INFO, "{0}: There are no custom DC type registrations.", methodName ); //$NON-NLS-1$
            }
            return completeCheckResult;
        }

        // Create a new custom dc types registry:
        CustomDcTypeRegistryImpl newCustomDcTypeRegistry = new CustomDcTypeRegistryImpl( );

        // Analyze, check and register the respective registration entries for custom DC types with their MOIN-relevant folders:
        // Caution: There can be several registration entries for the same DC type and they MUST NOT overlap !!!
        Map<CustomDcTypeRegistryImpl, CheckResultImpl> contentSelectionResult = null;
        for ( Properties contentSelectionPropertiesForDcType : contentSelectionPropertiesCollection ) {
            // Check 1: Compute and check the registration entries for the current DC type:
            contentSelectionResult = getAndCheckCustomDcTypeSelection( contentSelectionPropertiesForDcType, newCustomDcTypeRegistry );
            CheckResultImpl checkResultForDcType = contentSelectionResult.values( ).iterator( ).next( );
            CustomDcTypeRegistryImpl registryEntryForDcType = contentSelectionResult.keySet( ).iterator( ).next( );

            // Add check results for current DC type to complete set of check results
            completeCheckResult.addCheckResult( checkResultForDcType );

            // Refresh --> If valid then add the registration entries for the current DC type to the new registry
            if ( refresh ) {
                if ( MoinSeverity.ERROR == checkResultForDcType.getMoinSeverity( ) ) {
                    // Message: ""{0}": Invalid registration is ignored: {1}.""                
                    MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.INVALID_REGISTRATION_IS_IGNORED, methodName, getString( contentSelectionPropertiesForDcType ) );
                    if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                        LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
                    }
                    completeCheckResult.addError( e );
                    continue;
                }
                if ( registryEntryForDcType.isEmpty( ) ) {
                    // Message: ""{0}": Invalid registration is ignored: {1}.""                
                    MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.INVALID_REGISTRATION_IS_IGNORED, methodName, getString( contentSelectionPropertiesForDcType ) );
                    if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                        LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
                    }
                    completeCheckResult.addError( e );
                    continue;
                }
                newCustomDcTypeRegistry.addRegistryEntries( registryEntryForDcType );
                if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                    String fullDcTypeName = registryEntryForDcType.getRegisteredDcTypes( ).iterator( ).next( );
                    List<String> moinRelevantFolders = registryEntryForDcType.getMoinRelevantCustomFolders( fullDcTypeName );
                    LOGGER.traceWithStack( MoinSeverity.INFO, "{0}: Took over the custom DC type with its MOIN-relevant folders into the new registrations: DC type: {1}, folders: {2}.", methodName, fullDcTypeName, moinRelevantFolders ); //$NON-NLS-1$
                }
            } // else: Pure Check 
        }

        if ( refresh ) {
            // Keep the time period for the switch to the refreshed registry as small as possible.
            // Caution:
            // If the previous registrations were correct, but the new ones are empty or incorrect,
            // then nevertheless the registry is overwritten. 
            // This behavior can also be used to reset the registry.
            _customDcTypesRegistry = newCustomDcTypeRegistry;
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.traceWithStack( MoinSeverity.INFO, "{0}: The custom DC types registry is updated with the new registrations, check severity: " + completeCheckResult.getMoinSeverity( ) + ", registry entries: " + newCustomDcTypeRegistry.getRegistry( ), methodName ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        } else {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.traceWithStack( MoinSeverity.INFO, "{0}: The new content selection properties are checked, check severity: " + completeCheckResult.getMoinSeverity( ) + ", computed registry entries: " + newCustomDcTypeRegistry.getRegistry( ), methodName ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return completeCheckResult;
    }

    private Map<CustomDcTypeRegistryImpl, CheckResultImpl> getAndCheckCustomDcTypeSelection( Properties contentSelectionPropertiesForDcType, CustomDcTypeRegistryImpl currentRegistry ) {

        String methodName = "getAndCheckCustomDcTypeSelection"; //$NON-NLS-1$

        // Construct the result collection:
        Map<CustomDcTypeRegistryImpl, CheckResultImpl> contentSelectionResult = new HashMap<CustomDcTypeRegistryImpl, CheckResultImpl>( );
        CustomDcTypeRegistryImpl registryForDcType = new CustomDcTypeRegistryImpl( );
        CheckResultImpl checkResultForDcType = new CheckResultImpl( );
        contentSelectionResult.put( registryForDcType, checkResultForDcType );

        // Check and get the registered DC type:
        String dcTypeName = contentSelectionPropertiesForDcType.getProperty( DC_TYPE_NAME_PROPERTY );
        String dcTypeVendor = contentSelectionPropertiesForDcType.getProperty( DC_TYPE_VENDOR_PROPERTY );
        if ( dcTypeName == null || dcTypeName.length( ) == 0 ) {
            // Message: ""{0}": Content selection registration is invalid (DC type name is missing or it is empty): {1}"                
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.INVALID_REGISTRATION_WITH_DC_TYPE_NAME_MISSING, methodName, getString( contentSelectionPropertiesForDcType ) );
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                LOGGER.trace( e, MoinSeverity.WARNING, e.getMessage( ) );
            }
            checkResultForDcType.addError( e );
        }
        if ( dcTypeVendor == null || dcTypeVendor.length( ) == 0 ) {
            // Message: ""{0}": Content selection registration is invalid (DC type vendor is missing or it is empty): {1}"                
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.INVALID_REGISTRATION_WITH_DC_TYPE_VENDOR_MISSING, methodName, getString( contentSelectionPropertiesForDcType ) );
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                LOGGER.trace( e, MoinSeverity.WARNING, e.getMessage( ) );
            }
            checkResultForDcType.addError( e );
        }
        String fullDcTypeName = null;
        if ( MoinSeverity.ERROR != checkResultForDcType.getMoinSeverity( ) ) {
            fullDcTypeName = DiComponentModelUtilImpl.getFullDcTypeName( dcTypeVendor, dcTypeName );
        }

        // Check and get the registered MOIN-relevant folders for the DC type:
        Map<List<String>, CheckResultImpl> folderSelectionResult = getAndCheckCustomFolderSelection( contentSelectionPropertiesForDcType, currentRegistry.getMoinRelevantCustomFolders( fullDcTypeName ) );
        List<String> moinRelevantFolders = folderSelectionResult.keySet( ).iterator( ).next( );
        CheckResultImpl checkResultForFolders = folderSelectionResult.values( ).iterator( ).next( );

        if ( moinRelevantFolders.isEmpty( ) ) {
            // Message: ""{0}": Content selection registration for DC type [{1}] is invalid (it does not contain valid folder definitions): {2}."                
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.INVALID_REGISTRATION_WITH_EMPTY_VALID_FOLDER_LIST, methodName, fullDcTypeName, contentSelectionPropertiesForDcType );
            if ( LOGGER.isTraced( MoinSeverity.ERROR ) ) {
                LOGGER.trace( e, MoinSeverity.ERROR, e.getMessage( ) );
            }
            checkResultForFolders.addError( e );
        }

        if ( MoinSeverity.INFO != checkResultForFolders.getMoinSeverity( ) ) {
            checkResultForDcType.addCheckResult( checkResultForFolders );
        }

        // Create register entries:
        if ( fullDcTypeName != null && !moinRelevantFolders.isEmpty( ) ) {
            // We are error-tolerant: we take over as many registration entries as possible even in case there are errors in the other properties
            registryForDcType.registerDcType( fullDcTypeName, moinRelevantFolders );
        }

        return contentSelectionResult;
    }

    /**
     * The method analyzes the <code>supportedSelection</code> properties
     * concerning: - DC type: full DC type name - format failures (e.g. empty
     * paths) - overlapping folder paths - folder paths overlapping with folder
     * paths in <code>customDcTypeRegistry</code>
     */
    private Map<List<String>, CheckResultImpl> getAndCheckCustomFolderSelection( Properties supportedSelectionForDcType, List<String> alreadyRegisteredFoldersForDcType ) {

        String methodName = "getAndCheckCustomFolderSelection"; //$NON-NLS-1$

        // Construct the result collection:
        List<String> moinRelevantFolders = new ArrayList<String>( );
        CheckResultImpl checkResult = new CheckResultImpl( );
        Map<List<String>, CheckResultImpl> result = new HashMap<List<String>, CheckResultImpl>( );
        result.put( moinRelevantFolders, checkResult );

        for ( Map.Entry propertiesElement : supportedSelectionForDcType.entrySet( ) ) {
            // Check properties format and - if any format failures - then find as many as possible:
            boolean errorForCurrentProperty = false;
            if ( !( propertiesElement.getKey( ) instanceof String ) ) {
                // Message: "Method "{0}": Argument with name "{1}" has an illegal format in the properties element "{2}""                
                MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.ILLEGAL_PROPERTIES_FORMAT, methodName, "supportedSelection", propertiesElement ); //$NON-NLS-1$
                if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                    LOGGER.trace( e, MoinSeverity.WARNING, e.getMessage( ) );
                }
                checkResult.addError( e );
                errorForCurrentProperty = true;
            }
            if ( !( propertiesElement.getValue( ) instanceof String ) ) {
                // Message: "Method "{0}": Argument with name "{1}" has an illegal format in the properties element "{2}""                
                MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.ILLEGAL_PROPERTIES_FORMAT, methodName, "supportedSelection", propertiesElement ); //$NON-NLS-1$
                if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                    LOGGER.trace( e, MoinSeverity.WARNING, e.getMessage( ) );
                }
                checkResult.addError( e );
                errorForCurrentProperty = true;
            }
            if ( errorForCurrentProperty ) {
                continue;
            }

            // Check and get the registered folders for the DC type:
            if ( ( (String) propertiesElement.getKey( ) ).startsWith( MOIN_RELEVANT_FOLDER_PROPERTY ) ) {
                if ( ( (String) propertiesElement.getValue( ) ).length( ) == 0 ) {
                    // Message: ""{0}": Invalid folder definition [key: {1}, path: {2}] is ignored: folder path is empty"
                    MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.ILLEGAL_FOLDER_WITH_EMPTY_PATH, methodName, propertiesElement.getKey( ), propertiesElement.getValue( ) );
                    if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                        LOGGER.trace( e, MoinSeverity.INFO, e.getMessage( ) );
                    }
                    checkResult.addWarning( e );
                    continue;
                }

                // todo: check path syntax, is also missing for the .dcdef, see DiDevelopmentComponentImpl

                // Remark: 
                // - The current folder properties set should contain the folder only once and it must not contain overlapping folders.
                // - Already registered folders for the same DC type (registered by another meta model) can contain the same folder (legal situation),
                //   but it must not contain overlapping folders.
                String moinRelevantFolder = PathUtilImpl.ensureTrailingFileSeparator( (String) propertiesElement.getValue( ) );
                PathUtilImpl.FolderOverlap folderOverlap = PathUtilImpl.getFolderOverlap( moinRelevantFolder, moinRelevantFolders );
                if ( !PathUtilImpl.FolderOverlap.NO_OVERLAP.equals( folderOverlap ) ) {
                    // Message: ""{0}": Invalid folder definition [key: {1}, path: {2}] is ignored: folder path overlaps with another folder path"
                    MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.ILLEGAL_FOLDER_WITH_OVERLAPPING_PATH, methodName, propertiesElement.getKey( ), propertiesElement.getValue( ) );
                    if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                        LOGGER.trace( e, MoinSeverity.INFO, e.getMessage( ) );
                    }
                    checkResult.addWarning( e );
                    continue;
                }
                folderOverlap = PathUtilImpl.getFolderOverlap( moinRelevantFolder, alreadyRegisteredFoldersForDcType );
                if ( PathUtilImpl.FolderOverlap.OVERLAP.equals( folderOverlap ) ) {
                    // Message: ""{0}": Invalid folder definition [key: {1}, path: {2}] is ignored: folder path overlaps with another folder path"
                    MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.ILLEGAL_FOLDER_WITH_OVERLAPPING_PATH, methodName, propertiesElement.getKey( ), propertiesElement.getValue( ) );
                    if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                        LOGGER.trace( e, MoinSeverity.INFO, e.getMessage( ) );
                    }
                    checkResult.addWarning( e );
                    continue;
                }
                if ( PathUtilImpl.FolderOverlap.EQUAL.equals( folderOverlap ) ) {
                    continue; // folder is already registered for this DC type, but in the registration from another MOIN MetaModel --> legal situation
                }

                moinRelevantFolders.add( moinRelevantFolder );
                continue;
            }

            // Ignore the DC type property (handled outside this method):
            if ( DC_TYPE_NAME_PROPERTY.equals( propertiesElement.getKey( ) ) || DC_TYPE_VENDOR_PROPERTY.equals( propertiesElement.getKey( ) ) ) {
                continue;
            }

            // Handle unknown properties:
            // Message: ""{0}: Unknown property [key: {1}, value: {2}] is ignored"
            MoinIllegalArgumentException e = new MoinIllegalArgumentException( DiServiceMessages.UNKNOWN_PROPERTY, methodName, propertiesElement.getKey( ), propertiesElement.getValue( ) );
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( e, MoinSeverity.INFO, e.getMessage( ) );
            }
            checkResult.addWarning( e );
        }

        return result;
    }

    /** **************** Internal Classes *********************************** */

    private static class CustomDcTypeRegistryImpl {

        /** **************** Internals ************************************** */

        // Map: fullDcTypeName --> List of respective MOIN-relevant folders
        private HashMap<String, List<String>> _registry;

        /** ************************ Construction *************************** */

        CustomDcTypeRegistryImpl( ) {

            _registry = new HashMap<String, List<String>>( );
        }

        /** *************************** API ********************************** */

        boolean isEmpty( ) {

            return _registry.isEmpty( );
        }

        boolean isRegistered( String fullDcTypeName ) {

            return _registry.containsKey( fullDcTypeName );
        }

        List<String> getMoinRelevantCustomFolders( String fullDcTypeName ) {

            List<String> customFolders = _registry.get( fullDcTypeName );
            if ( customFolders == null ) {
                return Collections.emptyList( );
            }
            return customFolders;
        }

        Collection<String> getRegisteredDcTypes( ) {

            return Collections.unmodifiableSet( _registry.keySet( ) );
        }

        void registerDcType( String fullDcTypeName, List<String> moinRelevantFolders ) {

            _registry.put( fullDcTypeName, moinRelevantFolders );
        }

        // Prerequisite:
        // The registryEntries do not contain folder registrations
        // which are already registered for the same DC type in _registry.
        void addRegistryEntries( CustomDcTypeRegistryImpl registryEntries ) {

            Map<String, List<String>> regEntries = registryEntries.getRegistry( );
            for ( Map.Entry<String, List<String>> regEntry : regEntries.entrySet( ) ) {
                // Get the new registration entry:
                String fullDcTypeName = regEntry.getKey( );
                List<String> moinRelevantFolders = regEntry.getValue( );

                // and consider that the registry could already contain a registration 
                // for the respective DC type (e.g. from a different CPS)
                // --> Register the DC type with the unification of the folder lists. 
                List<String> alreadyRegisteredFolders = _registry.get( fullDcTypeName );
                if ( alreadyRegisteredFolders != null ) {
                    moinRelevantFolders.addAll( alreadyRegisteredFolders );
                }
                registerDcType( fullDcTypeName, moinRelevantFolders );
            }
        }

        /** **************** Internals ************************************** */

        private Map<String, List<String>> getRegistry( ) {

            return Collections.unmodifiableMap( _registry );
        }
    }


    // Remark: 
    // Inside this class CheckResultImpl is used, so that this class
    // is as far as possible decoupled from SPI interface
    // SpiCustomContentSelectionManagement.CheckResult.
    private static class CheckResultImpl implements SpiCustomContentSelectionManagement.CheckResult {

        /** **************** Internals ************************************** */

        private MoinSeverity _severity;

        private Collection<MoinIllegalArgumentException> _errors;

        private Collection<MoinIllegalArgumentException> _warnings;


        /** ************************ Construction *************************** */

        public CheckResultImpl( ) {

            _severity = MoinSeverity.INFO;
            _errors = new ArrayList<MoinIllegalArgumentException>( );
            _warnings = new ArrayList<MoinIllegalArgumentException>( );
        }


        /** ************************** API ********************************** */

        MoinSeverity getMoinSeverity( ) {

            return _severity;
        }

        /** ****** SpiCustomContentSelectionManagement.CheckResult ********** */

        public int getSeverity( ) {

            return _severity.severity( );
        }

        public Collection<MoinIllegalArgumentException> getErrors( ) {

            return Collections.unmodifiableCollection( _errors );
        }

        public Collection<MoinIllegalArgumentException> getWarnings( ) {

            return Collections.unmodifiableCollection( _warnings );
        }

        /** **************** Internals ************************************** */

        private void addError( MoinIllegalArgumentException e ) {

            _errors.add( e );
            addSeverity( MoinSeverity.ERROR );
        }

        private void addWarning( MoinIllegalArgumentException e ) {

            _warnings.add( e );
            addSeverity( MoinSeverity.WARNING );
        }

        private void addCheckResult( SpiCustomContentSelectionManagement.CheckResult checkResult ) {

            Collection<MoinIllegalArgumentException> errors = checkResult.getErrors( );
            if ( !errors.isEmpty( ) ) {
                _errors.addAll( errors );
                addSeverity( MoinSeverity.ERROR );
            }

            Collection<MoinIllegalArgumentException> warnings = checkResult.getWarnings( );
            if ( !warnings.isEmpty( ) ) {
                _warnings.addAll( warnings );
                addSeverity( MoinSeverity.WARNING );
            }

        }

        private void addSeverity( MoinSeverity severity ) {

            // We currently only need and handle 3 severities: INFO, WARNING, ERROR
            switch ( severity ) {
                case ERROR:
                    if ( MoinSeverity.ERROR != _severity ) {
                        _severity = MoinSeverity.ERROR;
                    }
                    break;

                case WARNING:
                    if ( MoinSeverity.INFO == _severity ) {
                        _severity = MoinSeverity.WARNING;
                    }
                    break;

                default:
                    throw new MoinIllegalArgumentException( "addSeverity", "severity", severity ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

    }

    /**
     * Caution:
     * <p>
     * Properties.toString() results in: '{ prop1=val1, ... }' and '{' and '}'
     * confuse the SAP logger in case a stacktrace should be traced --> stack
     * trace is missing
     * <p>
     * --> We need a specific String representation for Properties which does
     * not contain '{' and '}'.
     */
    private String getString( Properties properties ) {

        StringBuffer sb = new StringBuffer( );
        // Begin of properties set:
        sb.append( "[ " ); //$NON-NLS-1$
        Set<Entry<Object, Object>> propertySet = properties.entrySet( );
        Iterator<Entry<Object, Object>> iter = propertySet.iterator( );
        // First element:
        if ( iter.hasNext( ) ) {
            Entry<Object, Object> property = iter.next( );
            sb.append( property.getKey( ) );
            sb.append( "=" ); //$NON-NLS-1$
            sb.append( property.getValue( ) );
        }
        // Next elements, separated with leading ', ':
        while ( iter.hasNext( ) ) {
            Entry<Object, Object> property = iter.next( );
            sb.append( ", " ); //$NON-NLS-1$
            sb.append( property.getKey( ) );
            sb.append( "=" ); //$NON-NLS-1$
            sb.append( property.getValue( ) );
        }
        // End of properties set:
        sb.append( " ]" ); //$NON-NLS-1$

        return sb.toString( );
    }

}

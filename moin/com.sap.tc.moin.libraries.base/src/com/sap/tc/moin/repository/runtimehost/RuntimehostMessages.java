package com.sap.tc.moin.repository.runtimehost;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>MOIN_ARCHIVE_HEADER_NOT_SET_XMSG: Archive header not set in {0}</li>
 * <li>S2X_COLLISION_XMSG: Cannot register custom S2X callback for metamodel container {0}. There is already a callback registered ({1})</li>
 * <li>ERROR_HANDLER_VERSION_COLLISION_XMSG: Cannot register custom error handler for metamodel container {0} and version [{1},{2}]. There is already an error handler registered</li>
 * <li>EXTENSION_CLASS_NOT_FOUND_XMSG: Class {0} could not be found. The Moin metamodel is {1}</li>
 * <li>CONTENT_SELECTION_COLLISION_XMSG: Custom model content selection criteria for {0} and deployment id {1} already registered</li>
 * <li>NO_PARSER_XMSG: Custom parser/serializer factory {0} did not return a parser</li>
 * <li>NO_SERIALIZER_XMSG: Custom parser/serializer factory {0} did not return a serializer</li>
 * <li>ARCHIVE_VERSION_UNKNOWN_XMSG: Determination of archive version of  {0} failed</li>
 * <li>PARTITION_HASH_DETERMINATION_FAILED_XMSG: Determination of the hash failed - partition {0}</li>
 * <li>MoinAlreadyRunning_XMSG: ERROR in startMoin(). Moin already running. Please first stop Moin (use the stopMoin() method)</li>
 * <li>REGISTRATION_SCHEMA_ERROR_XMSG: Error setting the xml schema {0}</li>
 * <li>FACILITY_DOES_NOT_EXIST_XMSG: Facility {0} used in registration file {1} does not exist</li>
 * <li>FILE_NOT_FOUND_XMSG: File {0} not found in {1}</li>
 * <li>EXTENSION_CLASS_ILLEGAL_ACCESS_XMSG: Instance of class {0} could not be created. The Moin metamodel is {1}</li>
 * <li>METAMODEL_NOT_FOUND_XMSG: Meta-model not found for container {0}</li>
 * <li>NO_CUSTOM_CONTENT_SELECTION_XMSG: No custom model content selectionf file {0}</li>
 * <li>NO_CUSTOM_PARSER_XMSG: No custom parser/serializer registration file {0}</li>
 * <li>NO_SERIALIZATION_FACTORY_FOUND_XMSG: No custom serialization factory for partition pattern {0} found</li>
 * <li>NO_SERIALIZATION_FACTORY_FOUND_FOR_ID_XMSG: No custom serialization factory for serialization id {0} found</li>
 * <li>UNDEPLOYED_NOT_FOUND_XMSG: No deployed registrations found to unregister for deployment id {0}</li>
 * <li>NO_ERRORHANDLER_XMSG: No error handler registration file {0}</li>
 * <li>NO_S2X_CALLBACK_XMSG: No s2x registration file {0}</li>
 * <li>PATTERN_ALREADY_REGISTERED_XMSG: Pattern {0} already registered for other parser/serializer {1}</li>
 * <li>FILE_PROBLEMS_XMSG: Problems accessing file {0} in {1}</li>
 * <li>METAMODEL_PROPERTY_LOADING_XMSG: Problems loading metamodel properties for metamodel {0}</li>
 * <li>PARSE_PROBLEMS_XMSG: Problems parsing file {0} in {1}: {2}</li>
 * <li>REGISTRATION_FILE_CONTENT_ERROR_XMSG: Problems parsing registration file</li>
 * <li>CLASS_NOT_FOUND_XMSG: Registered class {0} could not be instantiated</li>
 * <li>FACTORY_WRONG_INTERFACE_XMSG: Registered class {0} does not implement required interface {1}</li>
 * <li>PATTERN_REGISTRATION_SUCCESSFUL_XMSG: Registered custom parser with id {0} for suffixes {1}</li>
 * <li>REGISTRATION_FAILED_XMSG: Registration failed for registration file {0} of {1}</li>
 * <li>S2X_REGISTRATION_FAILED_XMSG: Registration of S2X callback failed for {0}</li>
 * <li>CPS_REGISTRATION_FAILED_XMSG: Registration of custom parser/serializer failed for {0}</li>
 * <li>EH_REGISTRATION_FAILED_XMSG: Registration of error handler failed for {0}</li>
 * <li>SERIALIZATION_ID_COLLISION_XMSG: SerializationId {0} already registered for class {1}. Registration of {2} skipped</li>
 * <li>SERIALIZATION_ID_REGISTRATION_FAILED_XMSG: Serializationid {0} was not correctly registered</li>
 * <li>SUFFIX_COLLISION_XMSG: Suffix {0} is already registered for serialization id {1}. Registration of {2} skipped</li>
 * <li>EXTENSION_CLASS_WRONG_INTERFACE_XMSG: The extension class {0} does not implements the SpiDeploymentExtension interface. The Moin metamodel is {1}</li>
 * <li>EXTENSION_CLASS_INSTANTIATION_ERROR_XMSG: The meta-model deployment descriptor is binary incompatible with this MOIN version:  {0}</li>
 * <li>METAMODEL_VERSION_CONFLICT_XMSG: The metamodel  {0} was generated with core runtime version {1}, but the current version is {2}. The metamodel will not be deployed</li>
 * <li>METAMODEL_EXTENSION_CLASS_NOT_SET_XMSG: The metamodel configuration does not define the metamodel extension package name (see {0} in {1}). The Moin metamodel plugin: {2}</li>
 * <li>METAMODEL_FACILTIY_NOT_SET_XMSG: The metamodel configuration does not define the metamodel facility name (see {0} in {1}). The Moin metamodel plugin:{2}</li>
 * <li>METAMODEL_LABEL_NOT_SET_XMSG: The metamodel configuration does not define the metamodel label (see {0} in {1}). The Moin metamodel plugin: {2}</li>
 * <li>METAMODEL_NAME_NOT_SET_XMSG: The metamodel configuration does not define the metamodel name (see {0} in {1})</li>
 * <li>METAMODEL_CONTAINER_NOT_SET_XMSG: The metamodel configuration does not define the metamodel name (see {0} in {1}). The Moin metamodel plugin:  {2}</li>
 * <li>METAMODEL_PARTITIONS_NOT_SET_XMSG: The metamodel configuration does not define the metamodel partition list (see {0} in {1}). The Moin metamodel plugin:  {2}</li>
 * <li>METAMODEL_VENDOR_NOT_SET_XMSG: The metamodel configuration does not define the metamodel vendor (see {0} in {1}). The Moin metamodel plugin: {2}</li>
 * <li>METAMODEL_VERSION_NOT_SET_XMSG: The metamodel configuration does not define the metamodel version (see {0} in {1}). The Moin metamodel plugin: {2}</li>
 * <li>UNRESOLVED_TEXT_LOCALIZATION_XMSG: Unresolved text localization: resource-bundle {0} not found for meta-model {1}</li>
 * <li>UNRESOLVED_TEXT_LOCALIZATION2_XMSG: Unresolved text localization: resource-key {0} not found for meta-model {1}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from RuntimehostMessages.properties
 */
 
public enum RuntimehostMessages implements MoinLocalizedString {


    /**
     * Message: "Determination of archive version of  {0} failed"
     */
    ARCHIVE_VERSION_UNKNOWN("ARCHIVE_VERSION_UNKNOWN_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registered class {0} could not be instantiated"
     */
    CLASS_NOT_FOUND("CLASS_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Custom model content selection criteria for {0} and deployment id {1} already registered"
     */
    CONTENT_SELECTION_COLLISION("CONTENT_SELECTION_COLLISION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registration of custom parser/serializer failed for {0}"
     */
    CPS_REGISTRATION_FAILED("CPS_REGISTRATION_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registration of error handler failed for {0}"
     */
    EH_REGISTRATION_FAILED("EH_REGISTRATION_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot register custom error handler for metamodel container {0} and version [{1},{2}]. There is already an error handler registered"
     */
    ERROR_HANDLER_VERSION_COLLISION("ERROR_HANDLER_VERSION_COLLISION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Instance of class {0} could not be created. The Moin metamodel is {1}"
     */
    EXTENSION_CLASS_ILLEGAL_ACCESS("EXTENSION_CLASS_ILLEGAL_ACCESS_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The meta-model deployment descriptor is binary incompatible with this MOIN version:  {0}"
     */
    EXTENSION_CLASS_INSTANTIATION_ERROR("EXTENSION_CLASS_INSTANTIATION_ERROR_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Instance of class {0} could not be created. The Moin metamodel is {1}"
     */
    EXTENSION_CLASS_INSTANTIATION_EXCEPTION("EXTENSION_CLASS_INSTANTIATION_EXCEPTION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Class {0} could not be found. The Moin metamodel is {1}"
     */
    EXTENSION_CLASS_NOT_FOUND("EXTENSION_CLASS_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The extension class {0} does not implements the SpiDeploymentExtension interface. The Moin metamodel is {1}"
     */
    EXTENSION_CLASS_WRONG_INTERFACE("EXTENSION_CLASS_WRONG_INTERFACE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Facility {0} used in registration file {1} does not exist"
     */
    FACILITY_DOES_NOT_EXIST("FACILITY_DOES_NOT_EXIST_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registered class {0} does not implement required interface {1}"
     */
    FACTORY_WRONG_INTERFACE("FACTORY_WRONG_INTERFACE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "File {0} not found in {1}"
     */
    FILE_NOT_FOUND("FILE_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Problems accessing file {0} in {1}"
     */
    FILE_PROBLEMS("FILE_PROBLEMS_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel name (see {0} in {1}). The Moin metamodel plugin:  {2}"
     */
    METAMODEL_CONTAINER_NOT_SET("METAMODEL_CONTAINER_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel extension package name (see {0} in {1}). The Moin metamodel plugin: {2}"
     */
    METAMODEL_EXTENSION_CLASS_NOT_SET("METAMODEL_EXTENSION_CLASS_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel facility name (see {0} in {1}). The Moin metamodel plugin:{2}"
     */
    METAMODEL_FACILTIY_NOT_SET("METAMODEL_FACILTIY_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel label (see {0} in {1}). The Moin metamodel plugin: {2}"
     */
    METAMODEL_LABEL_NOT_SET("METAMODEL_LABEL_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel name (see {0} in {1})"
     */
    METAMODEL_NAME_NOT_SET("METAMODEL_NAME_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Meta-model not found for container {0}"
     */
    METAMODEL_NOT_FOUND("METAMODEL_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel partition list (see {0} in {1}). The Moin metamodel plugin:  {2}"
     */
    METAMODEL_PARTITIONS_NOT_SET("METAMODEL_PARTITIONS_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Problems loading metamodel properties for metamodel {0}"
     */
    METAMODEL_PROPERTY_LOADING("METAMODEL_PROPERTY_LOADING_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel vendor (see {0} in {1}). The Moin metamodel plugin: {2}"
     */
    METAMODEL_VENDOR_NOT_SET("METAMODEL_VENDOR_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel  {0} was generated with core runtime version {1}, but the current version is {2}. The metamodel will not be deployed"
     */
    METAMODEL_VERSION_CONFLICT("METAMODEL_VERSION_CONFLICT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel configuration does not define the metamodel version (see {0} in {1}). The Moin metamodel plugin: {2}"
     */
    METAMODEL_VERSION_NOT_SET("METAMODEL_VERSION_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Archive header not set in {0}"
     */
    MOIN_ARCHIVE_HEADER_NOT_SET("MOIN_ARCHIVE_HEADER_NOT_SET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ERROR in startMoin(). Moin already running. Please first stop Moin (use the stopMoin() method)"
     */
    MOINALREADYRUNNING("MoinAlreadyRunning_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No custom model content selectionf file {0}"
     */
    NO_CUSTOM_CONTENT_SELECTION("NO_CUSTOM_CONTENT_SELECTION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No custom parser/serializer registration file {0}"
     */
    NO_CUSTOM_PARSER("NO_CUSTOM_PARSER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No error handler registration file {0}"
     */
    NO_ERRORHANDLER("NO_ERRORHANDLER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Custom parser/serializer factory {0} did not return a parser"
     */
    NO_PARSER("NO_PARSER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No s2x registration file {0}"
     */
    NO_S2X_CALLBACK("NO_S2X_CALLBACK_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No custom serialization factory for serialization id {0} found"
     */
    NO_SERIALIZATION_FACTORY_FOUND_FOR_ID("NO_SERIALIZATION_FACTORY_FOUND_FOR_ID_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No custom serialization factory for partition pattern {0} found"
     */
    NO_SERIALIZATION_FACTORY_FOUND("NO_SERIALIZATION_FACTORY_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Custom parser/serializer factory {0} did not return a serializer"
     */
    NO_SERIALIZER("NO_SERIALIZER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Problems parsing file {0} in {1}: {2}"
     */
    PARSE_PROBLEMS("PARSE_PROBLEMS_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Determination of the hash failed - partition {0}"
     */
    PARTITION_HASH_DETERMINATION_FAILED("PARTITION_HASH_DETERMINATION_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Pattern {0} already registered for other parser/serializer {1}"
     */
    PATTERN_ALREADY_REGISTERED("PATTERN_ALREADY_REGISTERED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registered custom parser with id {0} for suffixes {1}"
     */
    PATTERN_REGISTRATION_SUCCESSFUL("PATTERN_REGISTRATION_SUCCESSFUL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registration failed for registration file {0} of {1}"
     */
    REGISTRATION_FAILED("REGISTRATION_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Problems parsing registration file"
     */
    REGISTRATION_FILE_CONTENT_ERROR("REGISTRATION_FILE_CONTENT_ERROR_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Error setting the xml schema {0}"
     */
    REGISTRATION_SCHEMA_ERROR("REGISTRATION_SCHEMA_ERROR_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot register custom S2X callback for metamodel container {0}. There is already a callback registered ({1})"
     */
    S2X_COLLISION("S2X_COLLISION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registration of S2X callback failed for {0}"
     */
    S2X_REGISTRATION_FAILED("S2X_REGISTRATION_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "SerializationId {0} already registered for class {1}. Registration of {2} skipped"
     */
    SERIALIZATION_ID_COLLISION("SERIALIZATION_ID_COLLISION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Serializationid {0} was not correctly registered"
     */
    SERIALIZATION_ID_REGISTRATION_FAILED("SERIALIZATION_ID_REGISTRATION_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Suffix {0} is already registered for serialization id {1}. Registration of {2} skipped"
     */
    SUFFIX_COLLISION("SUFFIX_COLLISION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No deployed registrations found to unregister for deployment id {0}"
     */
    UNDEPLOYED_NOT_FOUND("UNDEPLOYED_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unresolved text localization: resource-key {0} not found for meta-model {1}"
     */
    UNRESOLVED_TEXT_LOCALIZATION2("UNRESOLVED_TEXT_LOCALIZATION2_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unresolved text localization: resource-bundle {0} not found for meta-model {1}"
     */
    UNRESOLVED_TEXT_LOCALIZATION("UNRESOLVED_TEXT_LOCALIZATION_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( RuntimehostMessages.class );

    private final String myKey;

    private RuntimehostMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + RuntimehostMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
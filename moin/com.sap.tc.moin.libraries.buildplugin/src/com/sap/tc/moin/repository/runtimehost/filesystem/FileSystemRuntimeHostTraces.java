package com.sap.tc.moin.repository.runtimehost.filesystem;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.localization.ExternalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Externalized Messages in alphabetical order:
 * <ol>
 * <li>Compound_data_area_manager_initialized_XMSG: Compound data area manager initialized.</li>
 * <li>Configuration_read_XMSG: Configuration read.</li>
 * <li>Core_configuration_created_XMSG: Core configuration created.</li>
 * <li>Facilities_created_XMSG: Facilities created.</li>
 * <li>Invalid_metamodel_specification_XMSG: Invalid metamodel specification. Check the declaration in \"{0}\".</li>
 * <li>MOIN_finalize_startup_MOIN_not_initialized_XMSG: MOIN finalize startup - the MOIN not initialized.</li>
 * <li>MOIN_instance_manager_created_XMSG: MOIN instance manager created.</li>
 * <li>MOIN_not_initialized_XMSG: MOIN not initialized. Please check the trace for more information.</li>
 * <li>MOIN_not_running_XMSG: MOIN not running - can not perform MOIN stop.</li>
 * <li>Metamodel_data_areas_initialized_XMSG: Metamodel data areas initialized.</li>
 * <li>Metamodel_jars_registered_XMSG: Metamodel jars registered.</li>
 * <li>Metamodel_receiver_created_XMSG: Metamodel receiver created.</li>
 * <li>No_meta_model_jars_specified_XMSG: No meta model jars specified. Running only with MOF meta-model.</li>
 * <li>Problems_opening_metamodel_archive_XMSG: Problems opening metamodel archive \"{0}\".</li>
 * <li>Serialization_manager_created_XMSG: Serialization manager created.</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from FileSystemRuntimeHostTraces.properties
 */
 
public enum FileSystemRuntimeHostTraces implements MoinExternalizedString {


    /**
     * Message: "Compound data area manager initialized."
     */
    COMPOUND_DATA_AREA_MANAGER_INITIALIZED("Compound_data_area_manager_initialized_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Configuration read."
     */
    CONFIGURATION_READ("Configuration_read_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Core configuration created."
     */
    CORE_CONFIGURATION_CREATED("Core_configuration_created_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Facilities created."
     */
    FACILITIES_CREATED("Facilities_created_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid metamodel specification. Check the declaration in \"{0}\"."
     */
    INVALID_METAMODEL_SPECIFICATION("Invalid_metamodel_specification_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN finalize startup - the MOIN not initialized."
     */
    MOIN_FINALIZE_STARTUP_MOIN_NOT_INITIALIZED("MOIN_finalize_startup_MOIN_not_initialized_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN instance manager created."
     */
    MOIN_INSTANCE_MANAGER_CREATED("MOIN_instance_manager_created_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN not initialized. Please check the trace for more information."
     */
    MOIN_NOT_INITIALIZED("MOIN_not_initialized_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN not running - can not perform MOIN stop."
     */
    MOIN_NOT_RUNNING("MOIN_not_running_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel data areas initialized."
     */
    METAMODEL_DATA_AREAS_INITIALIZED("Metamodel_data_areas_initialized_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel jars registered."
     */
    METAMODEL_JARS_REGISTERED("Metamodel_jars_registered_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel receiver created."
     */
    METAMODEL_RECEIVER_CREATED("Metamodel_receiver_created_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No meta model jars specified. Running only with MOF meta-model."
     */
    NO_META_MODEL_JARS_SPECIFIED("No_meta_model_jars_specified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Problems opening metamodel archive \"{0}\"."
     */
    PROBLEMS_OPENING_METAMODEL_ARCHIVE("Problems_opening_metamodel_archive_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Serialization manager created."
     */
    SERIALIZATION_MANAGER_CREATED("Serialization_manager_created_XMSG"); //$NON-NLS-1$

    private final static ExternalizedResourceBundleAccessor ACCESSOR = new ExternalizedResourceBundleAccessor( FileSystemRuntimeHostTraces.class );

    private final String myKey;

    private FileSystemRuntimeHostTraces( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );

    }

}  
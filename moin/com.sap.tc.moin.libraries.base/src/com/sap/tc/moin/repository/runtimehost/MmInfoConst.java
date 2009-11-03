package com.sap.tc.moin.repository.runtimehost;

import java.util.Arrays;
import java.util.List;

/**
 * String constants for metamodels
 */
public class MmInfoConst {

    /**
     * Folder for metamodel partitions.
     */
    public static final String MM_PARTITIONS_FOLDER = "moin/meta/"; //$NON-NLS-1$

    /**
     * The name of the metamodel properties file.
     */
    public static final String MM_PROPERTIES_FILE_NAME = "metamodel.properties"; //$NON-NLS-1$

    /**
     * Property name of the metamodel identifier (metamodel ID).
     */
    public static final String MM_ID = "metamodelId"; //$NON-NLS-1$

    /**
     * The property name of the metamodel description.
     */
    public static final String MM_LABEL = "label"; //$NON-NLS-1$

    /**
     * Property name of the metamodel vendor.
     */
    public static final String MM_VENDOR = "vendor"; //$NON-NLS-1$

    /**
     * Property name of the metamodel version number.
     */
    public static final String MM_VERSION = "version"; //$NON-NLS-1$

    /**
     * Property name of the metamodel partition list.
     */
    public static final String MM_PARTITION_LIST = "partitionList"; //$NON-NLS-1$

    /**
     * Property name of the metamodel facility name.
     */
    public static final String MM_FACILITY_NAME = "facilityName"; //$NON-NLS-1$

    /**
     * Property name of the package name of the class that implements the
     * metamodel extension.
     */
    public static final String MM_EXTENSION_PACKAGE = "metaModelExtensionPackage"; //$NON-NLS-1$

    /**
     * Name of the extension class (without package).
     */
    public static final String MM_EXTENSION_CLASS_NAME = "MetamodelExtension"; //$NON-NLS-1$


    // constants for archive 2.0

    /**
     * Parent folder name of the registration folder.
     */
    public static final String REGISTRATION_PARENT = "moin"; //$NON-NLS-1$   

    /**
     * Registration folder name.
     */
    public static final String REGISTRATION = "reginfo"; //$NON-NLS-1$  

    /**
     * Folder for registration files.
     */
    public static final String REGISTRATION_FOLDER = REGISTRATION_PARENT + "/" + REGISTRATION + "/"; //$NON-NLS-1$  //$NON-NLS-2$    

    /**
     * The name of the version 2 meta model properties file.
     */
    public static final String MM2_PROPERTIES_FILE_NAME = REGISTRATION_FOLDER + "moinarch.properties"; //$NON-NLS-1$

    /**
     * The archive version 2.
     */
    public static final String MM2_ARCHIVE_VERSION = "2.0"; //$NON-NLS-1$

    /**
     * The id of the metamodel xml file.
     */
    public static final String MM2_METAMODEL_XML_FILE_ID = "metamodel.xml"; //$NON-NLS-1$

    /**
     * The name of the metamodel xml file.
     */
    public static final String MM2_METAMODEL_XML_FILE_NAME = REGISTRATION_FOLDER + MM2_METAMODEL_XML_FILE_ID;

    /**
     * Property name of the metamodel identifier (metamodel ID).
     */
    public static final String MM2_ID = "containerId"; //$NON-NLS-1$

    /**
     * The property name of the metamodel description.
     */
    public static final String MM2_LABEL = "label"; //$NON-NLS-1$

    /**
     * Property name of the metamodel vendor.
     */
    public static final String MM2_VENDOR = "vendor"; //$NON-NLS-1$

    /**
     * Property name of the metamodel version number.
     */
    public static final String MM2_VERSION = "semantic_version"; //$NON-NLS-1$

    // these properties are used to read from the metamodel.xml

    /**
     * Property name of the metamodel partition list.
     */
    public static final String MM2_PARTITION_LIST = "partitions"; //$NON-NLS-1$

    /**
     * Property name of the metamodel partition list.
     */
    public static final String MM2_PARTITION = "partition"; //$NON-NLS-1$

    /**
     * Property name of the metamodel facility name.
     */
    public static final String MM2_FACILITY_NAME = "facilityName"; //$NON-NLS-1$

    /**
     * Property name of the package name of the class that implements the
     * metamodel extension.
     */
    public static final String MM2_EXTENSION_CLASS = "deploymentExtension"; //$NON-NLS-1$

    /**
     * The name of the custom parser registration file
     */
    public static final String MM_STORAGE_INF_FILE_NAME = REGISTRATION_FOLDER + "modelstorage.xml"; //$NON-NLS-1$

    /**
     * Error handler
     */
    public static final String ERROR_HANDLER_INF_FILE_NAME = REGISTRATION_FOLDER + "errorhandler.xml"; //$NON-NLS-1$

    /**
     * S2X call back handler
     */
    public static final String S2X_CALLBACK_INF_FILE_NAME = REGISTRATION_FOLDER + "textverticalization.xml"; //$NON-NLS-1$

    /**
     * Content selection
     */
    public static final String CUSTOM_CONTENT_SELECTION_INF_FILE_NAME = REGISTRATION_FOLDER + "modelcontentselection.xml"; //$NON-NLS-1$

    /**
     * MetaModelLocalization
     */
    public static final String MM_RESOURCEBUNDLE_ID = "MetaModelLocalization"; //$NON-NLS-1$

    /**
     * .properties
     */
    public static final String MM_PROPS_SUFFIX = ".properties"; //$NON-NLS-1$

    /**
     * MetaModelLocalization.properties
     */
    public static final String MM_RESOURCEBUNDLE_ID_PROPS = MM_RESOURCEBUNDLE_ID + MM_PROPS_SUFFIX;

    /**
     * com.sap.tc.moin.MetaModelLocalization
     */
    public static final String MM_RESOURCEBUNDLE_NAME = "com.sap.tc.moin." + MM_RESOURCEBUNDLE_ID; //$NON-NLS-1$

    /**
     * metaModelResourceBundleName
     */
    public static final String MM_RESOURCEBUNDLE_NAMEKEY = "metaModelResourceBundleName"; //$NON-NLS-1$

    /**
     * The list of metamodel resources
     */
    public static final List<String> resourceList = Arrays.asList( new String[] {
        MmInfoConst.MM2_PROPERTIES_FILE_NAME,
        MmInfoConst.MM2_METAMODEL_XML_FILE_NAME,
        MmInfoConst.MM_STORAGE_INF_FILE_NAME,
        MmInfoConst.S2X_CALLBACK_INF_FILE_NAME,
        MmInfoConst.ERROR_HANDLER_INF_FILE_NAME,
        MmInfoConst.CUSTOM_CONTENT_SELECTION_INF_FILE_NAME,
        MmInfoConst.MM_PROPERTIES_FILE_NAME } ); // added for server backward compatibility
}

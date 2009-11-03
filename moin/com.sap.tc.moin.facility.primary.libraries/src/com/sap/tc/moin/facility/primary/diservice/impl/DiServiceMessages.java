package com.sap.tc.moin.facility.primary.diservice.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>INVALID_REGISTRATION_WITH_EMPTY_VALID_FOLDER_LIST_XMSG: "{0}": Content selection registration for DC type [{1}] is invalid (it does not contain valid folder definitions): {2}.</li>
 * <li>INVALID_REGISTRATION_WITH_DC_TYPE_NAME_MISSING_XMSG: "{0}": Content selection registration is invalid (DC type name is missing or it is empty): {1}</li>
 * <li>INVALID_REGISTRATION_WITH_DC_TYPE_VENDOR_MISSING_XMSG: "{0}": Content selection registration is invalid (DC type vendor is missing or it is empty): {1}</li>
 * <li>ILLEGAL_FOLDER_WITH_EMPTY_PATH_XMSG: "{0}": Invalid folder definition [key: {1}, path: {2}] is ignored: folder path is empty</li>
 * <li>ILLEGAL_FOLDER_WITH_OVERLAPPING_PATH_XMSG: "{0}": Invalid folder definition [key: {1}, path: {2}] is ignored: folder path overlaps with another folder path</li>
 * <li>INVALID_REGISTRATION_IS_IGNORED_XMSG: "{0}": Invalid registration is ignored: {1}."</li>
 * <li>UNKNOWN_PROPERTY_XMSG: "{0}": Unknown property [key: {1}, value: {2}] is ignored</li>
 * <li>DC_NO_LONGER_VALID_XMSG: MOIN DC-object [development component: {1}] is no longer valid </li>
 * <li>ILLEGAL_PROPERTIES_FORMAT_XMSG: Method "{0}": Argument with name "{1}" has an illegal format in the properties element "{2}"</li>
 * <li>DEVELOPMENT_COMPONENT_IS_UNMODIFIABLE_XMSG: Partition [name: {0}, development component: {1}] cannot be created because it belongs to an unmodifiable development component.</li>
 * <li>DATA_AREA_IS_UNMODIFIABLE_XMSG: Partition [name: {0}, development component: {1}] cannot be created/edited/deleted because it belongs to an unmodifiable data area [name: {2}].</li>
 * <li>PARTITION_DOES_NOT_EXIST_XMSG: Partition [name: {0}, development component: {1}] cannot be edited/deleted because it does not exist.</li>
 * <li>ACCESS_TO_LOCAL_DISC_FAILED_XMSG: Partition [name: {0}, development component: {1}] cannot be edited/deleted because the access to the partition file on local disc failed: {2}.</li>
 * <li>PARTITION_IS_READ_ONLY_XMSG: Partition [name: {0}, development component: {1}] cannot be edited/deleted because the partition file is read-only.</li>
 * <li>PARTITION_NO_SERIALIZER_XMSG: Partition {0} cannot be modified. No serializer defined</li>
 * <li>WRONG_DC_PROVIDER_CLASS_XMSG: The DC-provider-object must be an instance of class "{0}", but it is an instance of class "{1}"</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from DiServiceMessages.properties
 */
 
public enum DiServiceMessages implements MoinLocalizedString {


    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be edited/deleted because the access to the partition file on local disc failed: {2}."
     */
    ACCESS_TO_LOCAL_DISC_FAILED("ACCESS_TO_LOCAL_DISC_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be created/edited/deleted because it belongs to an unmodifiable data area [name: {2}]."
     */
    DATA_AREA_IS_UNMODIFIABLE("DATA_AREA_IS_UNMODIFIABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN DC-object [development component: {1}] is no longer valid "
     */
    DC_NO_LONGER_VALID("DC_NO_LONGER_VALID_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be created because it belongs to an unmodifiable development component."
     */
    DEVELOPMENT_COMPONENT_IS_UNMODIFIABLE("DEVELOPMENT_COMPONENT_IS_UNMODIFIABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}": Invalid folder definition [key: {1}, path: {2}] is ignored: folder path is empty"
     */
    ILLEGAL_FOLDER_WITH_EMPTY_PATH("ILLEGAL_FOLDER_WITH_EMPTY_PATH_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}": Invalid folder definition [key: {1}, path: {2}] is ignored: folder path overlaps with another folder path"
     */
    ILLEGAL_FOLDER_WITH_OVERLAPPING_PATH("ILLEGAL_FOLDER_WITH_OVERLAPPING_PATH_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method "{0}": Argument with name "{1}" has an illegal format in the properties element "{2}""
     */
    ILLEGAL_PROPERTIES_FORMAT("ILLEGAL_PROPERTIES_FORMAT_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}": Invalid registration is ignored: {1}.""
     */
    INVALID_REGISTRATION_IS_IGNORED("INVALID_REGISTRATION_IS_IGNORED_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}": Content selection registration is invalid (DC type name is missing or it is empty): {1}"
     */
    INVALID_REGISTRATION_WITH_DC_TYPE_NAME_MISSING("INVALID_REGISTRATION_WITH_DC_TYPE_NAME_MISSING_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}": Content selection registration is invalid (DC type vendor is missing or it is empty): {1}"
     */
    INVALID_REGISTRATION_WITH_DC_TYPE_VENDOR_MISSING("INVALID_REGISTRATION_WITH_DC_TYPE_VENDOR_MISSING_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}": Content selection registration for DC type [{1}] is invalid (it does not contain valid folder definitions): {2}."
     */
    INVALID_REGISTRATION_WITH_EMPTY_VALID_FOLDER_LIST("INVALID_REGISTRATION_WITH_EMPTY_VALID_FOLDER_LIST_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be edited/deleted because it does not exist."
     */
    PARTITION_DOES_NOT_EXIST("PARTITION_DOES_NOT_EXIST_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be edited/deleted because the partition file is read-only."
     */
    PARTITION_IS_READ_ONLY("PARTITION_IS_READ_ONLY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition {0} cannot be modified. No serializer defined"
     */
    PARTITION_NO_SERIALIZER("PARTITION_NO_SERIALIZER_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}": Unknown property [key: {1}, value: {2}] is ignored"
     */
    UNKNOWN_PROPERTY("UNKNOWN_PROPERTY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The DC-provider-object must be an instance of class "{0}", but it is an instance of class "{1}""
     */
    WRONG_DC_PROVIDER_CLASS("WRONG_DC_PROVIDER_CLASS_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( DiServiceMessages.class );

    private final String myKey;

    private DiServiceMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + DiServiceMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
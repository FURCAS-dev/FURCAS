package com.sap.tc.moin.facility.primary.diservice.fs.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CREATING_REGULAR_DATA_AREA_FAILED_XMSG: Creating regular data area [{0}] failed</li>
 * <li>UNKNOWN_RESULT_FROM_PERSISTENCE_CREATABLE_CHECK_XMSG: Internal Error: Partition [name: {0}, development component: {1}] cannot be created because the respective persistence test has returned an unknown result: {2}</li>
 * <li>INTERNAL_ERROR_CLIENT_SPEC_DOES_NOT_EXIST_XMSG: Internal error: The client spec [name:{0}] for data area [{0}] does not exist</li>
 * <li>INTERNAL_ERROR_NULL_GENERATION_ROOT_XMSG: Internal error: null generation root location in DC-definition-provider [development component: {0}]</li>
 * <li>INTERNAL_ERROR_NULL_PROJECT_ROOT_XMSG: Internal error: null project root path in DC-definition-provider [development component: {0}]</li>
 * <li>NAME_CLASH_TO_FILE_WITH_DIFFERENT_UPPER_LOWER_CASE_XMSG: Partition [name: {0}, development component: {1}] cannot be created because a file with different upper / lower case already exists on local disc: {2}</li>
 * <li>PARTITION_CREATION_NOT_POSSIBLE_IN_ARCHIVE_XMSG: Partition [name: {0}, development component: {1}] cannot be created because it is not possible to create new partitions inside an archive</li>
 * <li>ACCESS_TO_LOCAL_DISC_FAILED_XMSG: Partition [name: {0}, development component: {1}] cannot be created because the access to the partition file on local disc failed: {2}</li>
 * <li>PARTITION_ALREADY_EXISTS_XMSG: Partition [name: {0}, development component: {1}] cannot be created because the partition file already exists on local disc</li>
 * <li>RETRIEVAL_OF_CLIENT_SPEC_FAILED_XMSG: Retrieval of client spec [name: {0}] for data area [{1}] failed</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from DiFsServiceMessages.properties
 */
 
public enum DiFsServiceMessages implements MoinLocalizedString {


    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be created because the access to the partition file on local disc failed: {2}"
     */
    ACCESS_TO_LOCAL_DISC_FAILED("ACCESS_TO_LOCAL_DISC_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Creating regular data area [{0}] failed"
     */
    CREATING_REGULAR_DATA_AREA_FAILED("CREATING_REGULAR_DATA_AREA_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Internal error: The client spec [name:{0}] for data area [{0}] does not exist"
     */
    INTERNAL_ERROR_CLIENT_SPEC_DOES_NOT_EXIST("INTERNAL_ERROR_CLIENT_SPEC_DOES_NOT_EXIST_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Internal error: null generation root location in DC-definition-provider [development component: {0}]"
     */
    INTERNAL_ERROR_NULL_GENERATION_ROOT("INTERNAL_ERROR_NULL_GENERATION_ROOT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Internal error: null project root path in DC-definition-provider [development component: {0}]"
     */
    INTERNAL_ERROR_NULL_PROJECT_ROOT("INTERNAL_ERROR_NULL_PROJECT_ROOT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be created because a file with different upper / lower case already exists on local disc: {2}"
     */
    NAME_CLASH_TO_FILE_WITH_DIFFERENT_UPPER_LOWER_CASE("NAME_CLASH_TO_FILE_WITH_DIFFERENT_UPPER_LOWER_CASE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be created because the partition file already exists on local disc"
     */
    PARTITION_ALREADY_EXISTS("PARTITION_ALREADY_EXISTS_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition [name: {0}, development component: {1}] cannot be created because it is not possible to create new partitions inside an archive"
     */
    PARTITION_CREATION_NOT_POSSIBLE_IN_ARCHIVE("PARTITION_CREATION_NOT_POSSIBLE_IN_ARCHIVE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Retrieval of client spec [name: {0}] for data area [{1}] failed"
     */
    RETRIEVAL_OF_CLIENT_SPEC_FAILED("RETRIEVAL_OF_CLIENT_SPEC_FAILED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Internal Error: Partition [name: {0}, development component: {1}] cannot be created because the respective persistence test has returned an unknown result: {2}"
     */
    UNKNOWN_RESULT_FROM_PERSISTENCE_CREATABLE_CHECK("UNKNOWN_RESULT_FROM_PERSISTENCE_CREATABLE_CHECK_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( DiFsServiceMessages.class );

    private final String myKey;

    private DiFsServiceMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + DiFsServiceMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
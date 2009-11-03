package com.sap.tc.moin.repository.runtimehost.filesystem;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>Failed_to_read_content_for_partition_XMSG: Failed to read content for partition \"{0}\" from meta-model archive \"{1}\".</li>
 * <li>AlreadyStarted_XMSG: FileSystemRuntimeHost already started.</li>
 * <li>Not_initialized_XMSG: FileSystemRuntimeHost not initialized.</li>
 * <li>Metamodel_jar_registered: Metamodel jar \"{0}\" registered.</li>
 * <li>Modification_date_can_not_be_determined_XMSG: Modification date of metamodel archive {0} can not be determined.</li>
 * <li>Partition_not_in_archive_XMSG: Partition \"{0}\" not found in meta-model archive \"{1}\".</li>
 * <li>Registering_meta_model_jar_XMSG: Registering meta model jar \"{0}\".</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from FileSystemRuntimeHostMessages.properties
 */
 
public enum FileSystemRuntimeHostMessages implements MoinLocalizedString {


    /**
     * Message: "FileSystemRuntimeHost already started."
     */
    ALREADYSTARTED("AlreadyStarted_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to read content for partition \"{0}\" from meta-model archive \"{1}\"."
     */
    FAILED_TO_READ_CONTENT_FOR_PARTITION("Failed_to_read_content_for_partition_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel jar \"{0}\" registered."
     */
    METAMODEL_JAR_REGISTERED("Metamodel_jar_registered"), //$NON-NLS-1$

    /**
     * Message: "Modification date of metamodel archive {0} can not be determined."
     */
    MODIFICATION_DATE_CAN_NOT_BE_DETERMINED("Modification_date_can_not_be_determined_XMSG"), //$NON-NLS-1$

    /**
     * Message: "FileSystemRuntimeHost not initialized."
     */
    NOT_INITIALIZED("Not_initialized_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition \"{0}\" not found in meta-model archive \"{1}\"."
     */
    PARTITION_NOT_IN_ARCHIVE("Partition_not_in_archive_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registering meta model jar \"{0}\"."
     */
    REGISTERING_META_MODEL_JAR("Registering_meta_model_jar_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( FileSystemRuntimeHostMessages.class );

    private final String myKey;

    private FileSystemRuntimeHostMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + FileSystemRuntimeHostMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
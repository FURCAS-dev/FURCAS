package com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ARGUMENT_MUST_NOT_BE_EMPTY_XMSG: Argument {0} must not be empty</li>
 * <li>ARGUMENT_MUST_NOT_BE_NULL_XMSG: Argument {0} must not be null</li>
 * <li>UNABLE_TO_CREATE_FILE_XMSG: Could not create file {0}</li>
 * <li>UNABLE_TO_CREATE_FILE_ALREADY_EXISTS_XMSG: Could not create file: File already exists {0}</li>
 * <li>UNABLE_TO_CREATE_FILE_CAUSE_UNKNOWN_XMSG: Could not create file: Unknown error on creation of file {0}</li>
 * <li>UNABLE_TO_CREATE_FOLDER_ALREADY_EXISTS_XMSG: Could not create folder: File already exists {0}</li>
 * <li>UNABLE_TO_CREATE_FOLDER_CAUSE_UNKNOWN_XMSG: Could not create folder: Unknown error on creation of folder {0}</li>
 * <li>UNABLE_TO_DETERMINE_CANONICAL_PATH_XMSG: Could not determine canonical path for resource {0}</li>
 * <li>UNABLE_TO_OPEN_STREAM_FOR_ENTRY_XMSG: Could not get input stream for entry {0} in archive {1}</li>
 * <li>UNABLE_TO_OPEN_INPUTSTREAM_FILE_NOT_FOUND_XMSG: Could not open input stream: file does not exist {0}</li>
 * <li>UNABLE_TO_OPEN_OUTPUTSTREAM_FILE_NOT_FOUND_XMSG: Could not open output stream: file does not exist {0}</li>
 * <li>UNABLE_TO_READ_ENTRY_XMSG: Could not read entry {0} in archive {1}</li>
 * <li>UNABLE_TO_DETERMINE_ARCHIVE_ENTRY_SIZE_XMSG: Determination of file size in archive failed: Could not access entry {0} in archive {1}</li>
 * <li>UNABLE_TO_CHECK_EXISTENCE_OF_ARCHIVE_ENTRY_SIZE_XMSG: Failed to check existence of relative path in archive: Could not access entry {0} in archive {1}</li>
 * <li>UNABLE_TO_CLOSE_ARCHIVE_XMSG: Failed to close archive {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from PersistenceLfsJavaioimplMessages.properties
 */
 
public enum PersistenceLfsJavaioimplMessages implements MoinLocalizedString {


    /**
     * Message: "Argument {0} must not be empty"
     */
    ARGUMENT_MUST_NOT_BE_EMPTY("ARGUMENT_MUST_NOT_BE_EMPTY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Argument {0} must not be null"
     */
    ARGUMENT_MUST_NOT_BE_NULL("ARGUMENT_MUST_NOT_BE_NULL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to check existence of relative path in archive: Could not access entry {0} in archive {1}"
     */
    UNABLE_TO_CHECK_EXISTENCE_OF_ARCHIVE_ENTRY_SIZE("UNABLE_TO_CHECK_EXISTENCE_OF_ARCHIVE_ENTRY_SIZE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to close archive {0}"
     */
    UNABLE_TO_CLOSE_ARCHIVE("UNABLE_TO_CLOSE_ARCHIVE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not create file: File already exists {0}"
     */
    UNABLE_TO_CREATE_FILE_ALREADY_EXISTS("UNABLE_TO_CREATE_FILE_ALREADY_EXISTS_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not create file: Unknown error on creation of file {0}"
     */
    UNABLE_TO_CREATE_FILE_CAUSE_UNKNOWN("UNABLE_TO_CREATE_FILE_CAUSE_UNKNOWN_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not create file {0}"
     */
    UNABLE_TO_CREATE_FILE("UNABLE_TO_CREATE_FILE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not create folder: File already exists {0}"
     */
    UNABLE_TO_CREATE_FOLDER_ALREADY_EXISTS("UNABLE_TO_CREATE_FOLDER_ALREADY_EXISTS_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not create folder: Unknown error on creation of folder {0}"
     */
    UNABLE_TO_CREATE_FOLDER_CAUSE_UNKNOWN("UNABLE_TO_CREATE_FOLDER_CAUSE_UNKNOWN_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Determination of file size in archive failed: Could not access entry {0} in archive {1}"
     */
    UNABLE_TO_DETERMINE_ARCHIVE_ENTRY_SIZE("UNABLE_TO_DETERMINE_ARCHIVE_ENTRY_SIZE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not determine canonical path for resource {0}"
     */
    UNABLE_TO_DETERMINE_CANONICAL_PATH("UNABLE_TO_DETERMINE_CANONICAL_PATH_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not open input stream: file does not exist {0}"
     */
    UNABLE_TO_OPEN_INPUTSTREAM_FILE_NOT_FOUND("UNABLE_TO_OPEN_INPUTSTREAM_FILE_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not open output stream: file does not exist {0}"
     */
    UNABLE_TO_OPEN_OUTPUTSTREAM_FILE_NOT_FOUND("UNABLE_TO_OPEN_OUTPUTSTREAM_FILE_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not get input stream for entry {0} in archive {1}"
     */
    UNABLE_TO_OPEN_STREAM_FOR_ENTRY("UNABLE_TO_OPEN_STREAM_FOR_ENTRY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not read entry {0} in archive {1}"
     */
    UNABLE_TO_READ_ENTRY("UNABLE_TO_READ_ENTRY_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( PersistenceLfsJavaioimplMessages.class );

    private final String myKey;

    private PersistenceLfsJavaioimplMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + PersistenceLfsJavaioimplMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
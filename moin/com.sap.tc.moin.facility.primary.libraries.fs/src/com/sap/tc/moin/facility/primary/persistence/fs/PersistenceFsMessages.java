package com.sap.tc.moin.facility.primary.persistence.fs;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>FOLDER_DOES_NOT_EXIST_XMSG: "Folder {0} does not exist</li>
 * <li>ARGUMENT_MUST_NOT_BE_NULL_XMSG: Argument {0} must not be null</li>
 * <li>UNKNOWN_SUBTYPE_DETECTED_XMSG: Bug exception: Unable to handle unknown subtype of type {0}: {1}</li>
 * <li>UNABLE_TO_DETERMINE_CANONICAL_PATH_XMSG: Could not determine canonical path for resource {0}</li>
 * <li>UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE_XMSG: Could not get output stream for partition texts: No storage found for {0}</li>
 * <li>UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE_XMSG: Could not get output stream for partition: No storage found for {0}</li>
 * <li>UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_WRITING_XMSG: Could not get output stream for writing partition texts: {0}</li>
 * <li>UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_WRITING_XMSG: Could not get output stream for writing: {0}</li>
 * <li>UNABLE_TO_OPEN_ARCHIVE_FOR_READING_XMSG: Could not open archive for reading: {0}</li>
 * <li>IllegalSourcePathInDir_XMSG: Detected illegal source path in directory storage. The path is expected to reference a folder but references a file. {0}</li>
 * <li>UNABLE_TO_CLOSE_ARCHIVE_XMSG: Failed to close archive {0}</li>
 * <li>ILLEGAL_SOURCE_PATH_DETECTED_ARCHIVE_XMSG: Illegal source path in archive storage detected: The path is expected to reference an archive file but references a folder {0}</li>
 * <li>ILLEGAL_SOURCE_PATH_DETECTED_FOLDER_XMSG: Illegal source path in directory storage detected: The path is expected to reference a folder but references a file {0}</li>
 * <li>NO_FILE_AVAILABLE_XMSG: No file available for source path {0} and partition {1}</li>
 * <li>NO_TEXT_FILE_AVAILABLE_XMSG: No text file available for source path {0} and partition {1}</li>
 * <li>UNABLE_TO_DELETE_PARTITION_NO_STORAGE_XMSG: Partition could not be deleted: No storage found for {0} </li>
 * <li>UNABLE_TO_DELETE_PARTITION_CAUSE_UNKNOWN_XMSG: Partition could not be deleted: Unknown error on deletion of {0}</li>
 * <li>UNABLE_TO_READ_PARTITION_XMSG: Partition could not be read: {0}</li>
 * <li>PartitionCouldNotBeWritten_XMSG: Partition could not be written: {0}</li>
 * <li>PARTITION_DOES_NOT_EXIST_IN_FS_XMSG: Partition does not exist in the file system: {0}</li>
 * <li>PARTITION_DOES_NOT_EXIST_IN_FS_STORAGE_XMSG: Partition does not exist in the file system: {0} does not reference a resource in storage {1}</li>
 * <li>UNABLE_TO_DELETE_PARTITION_TEXT_NO_STORAGE_XMSG: Partition texts could not be deleted: No storage found for {0} </li>
 * <li>UNABLE_TO_DELETE_PARTITION_TEXT_CAUSE_UNKNOWN_XMSG: Partition texts could not be deleted: Unknown error on deletion of {0}</li>
 * <li>PartitionTextsCouldNotBeWritten_XMSG: Partition texts could not be written: {0}</li>
 * <li>RESOURCE_FOLDER_NO_DIRECTORY_XMSG: Path to resource folder does not reference a directory {0}</li>
 * <li>UNABLE_TO_DETERMINE_READ_ONLY_STATE_NOT_A_FILE_XMSG: Read-only state could not be determined in the file system: Resource referenced by {0} is a folder {1} in storage {2}</li>
 * <li>RESOURCE_FOLDER_NOT_ALLOWED_XMSG: Resource folder &#039;null&#039; is not allowed for storage area path &#039;{0}&#039; assigned to data area &#039;{1}&#039; and container &#039;{2}&#039;</li>
 * <li>UNEXPECTED_PRI_STREAM_REQUESTED_XMSG: Stream for unexpected pri requested from stream provider: Provider is responsible for {0} but {1} was requested</li>
 * <li>TEXT_RESOURCE_EXISTS_BUT_IS_FOLDER_XMSG: Text resource exists for partition {0} but is a folder: {1}</li>
 * <li>UnexpectedAmbiguousRegistration_XMSG: Unexpected ambiguous registration of identical root paths for different containers: rootPath={0}, registered CRI={1}, CRI to register={2}</li>
 * <li>UnexpectedEnumValue_XMSG: Unexpected enum value</li>
 * <li>UnexpectedPriFromIndex_XMSG: Unexpected pri {0} from index. Expected pri {1}</li>
 * <li>UnexpectedStorageType_XMSG: Unexpected storage type</li>
 * <li>MethodNotSupportedForThisImplementation_XMSG: method not supported for this implementation</li>
 * <li>StorePartitionFailed_XMSG: storePartition failed</li>
 * <li>StorePartitionInternalFailed_XMSG: storePartitionInternal failed</li>
 * <li>StorePartitionTextsFailed_XMSG: storePartitionTexts failed</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from PersistenceFsMessages.properties
 */
 
public enum PersistenceFsMessages implements MoinLocalizedString {


    /**
     * Message: "Argument {0} must not be null"
     */
    ARGUMENT_MUST_NOT_BE_NULL("ARGUMENT_MUST_NOT_BE_NULL_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""Folder {0} does not exist"
     */
    FOLDER_DOES_NOT_EXIST("FOLDER_DOES_NOT_EXIST_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal source path in archive storage detected: The path is expected to reference an archive file but references a folder {0}"
     */
    ILLEGAL_SOURCE_PATH_DETECTED_ARCHIVE("ILLEGAL_SOURCE_PATH_DETECTED_ARCHIVE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal source path in directory storage detected: The path is expected to reference a folder but references a file {0}"
     */
    ILLEGAL_SOURCE_PATH_DETECTED_FOLDER("ILLEGAL_SOURCE_PATH_DETECTED_FOLDER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Detected illegal source path in directory storage. The path is expected to reference a folder but references a file. {0}"
     */
    ILLEGALSOURCEPATHINDIR("IllegalSourcePathInDir_XMSG"), //$NON-NLS-1$

    /**
     * Message: "method not supported for this implementation"
     */
    METHODNOTSUPPORTEDFORTHISIMPLEMENTATION("MethodNotSupportedForThisImplementation_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No file available for source path {0} and partition {1}"
     */
    NO_FILE_AVAILABLE("NO_FILE_AVAILABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No text file available for source path {0} and partition {1}"
     */
    NO_TEXT_FILE_AVAILABLE("NO_TEXT_FILE_AVAILABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition does not exist in the file system: {0} does not reference a resource in storage {1}"
     */
    PARTITION_DOES_NOT_EXIST_IN_FS_STORAGE("PARTITION_DOES_NOT_EXIST_IN_FS_STORAGE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition does not exist in the file system: {0}"
     */
    PARTITION_DOES_NOT_EXIST_IN_FS("PARTITION_DOES_NOT_EXIST_IN_FS_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition could not be written: {0}"
     */
    PARTITIONCOULDNOTBEWRITTEN("PartitionCouldNotBeWritten_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition texts could not be written: {0}"
     */
    PARTITIONTEXTSCOULDNOTBEWRITTEN("PartitionTextsCouldNotBeWritten_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Resource folder &#039;null&#039; is not allowed for storage area path &#039;{0}&#039; assigned to data area &#039;{1}&#039; and container &#039;{2}&#039;"
     */
    RESOURCE_FOLDER_NOT_ALLOWED("RESOURCE_FOLDER_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Path to resource folder does not reference a directory {0}"
     */
    RESOURCE_FOLDER_NO_DIRECTORY("RESOURCE_FOLDER_NO_DIRECTORY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "storePartition failed"
     */
    STOREPARTITIONFAILED("StorePartitionFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "storePartitionInternal failed"
     */
    STOREPARTITIONINTERNALFAILED("StorePartitionInternalFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "storePartitionTexts failed"
     */
    STOREPARTITIONTEXTSFAILED("StorePartitionTextsFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Text resource exists for partition {0} but is a folder: {1}"
     */
    TEXT_RESOURCE_EXISTS_BUT_IS_FOLDER("TEXT_RESOURCE_EXISTS_BUT_IS_FOLDER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to close archive {0}"
     */
    UNABLE_TO_CLOSE_ARCHIVE("UNABLE_TO_CLOSE_ARCHIVE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition could not be deleted: Unknown error on deletion of {0}"
     */
    UNABLE_TO_DELETE_PARTITION_CAUSE_UNKNOWN("UNABLE_TO_DELETE_PARTITION_CAUSE_UNKNOWN_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition could not be deleted: No storage found for {0} "
     */
    UNABLE_TO_DELETE_PARTITION_NO_STORAGE("UNABLE_TO_DELETE_PARTITION_NO_STORAGE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition texts could not be deleted: Unknown error on deletion of {0}"
     */
    UNABLE_TO_DELETE_PARTITION_TEXT_CAUSE_UNKNOWN("UNABLE_TO_DELETE_PARTITION_TEXT_CAUSE_UNKNOWN_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition texts could not be deleted: No storage found for {0} "
     */
    UNABLE_TO_DELETE_PARTITION_TEXT_NO_STORAGE("UNABLE_TO_DELETE_PARTITION_TEXT_NO_STORAGE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not determine canonical path for resource {0}"
     */
    UNABLE_TO_DETERMINE_CANONICAL_PATH("UNABLE_TO_DETERMINE_CANONICAL_PATH_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Read-only state could not be determined in the file system: Resource referenced by {0} is a folder {1} in storage {2}"
     */
    UNABLE_TO_DETERMINE_READ_ONLY_STATE_NOT_A_FILE("UNABLE_TO_DETERMINE_READ_ONLY_STATE_NOT_A_FILE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not open archive for reading: {0}"
     */
    UNABLE_TO_OPEN_ARCHIVE_FOR_READING("UNABLE_TO_OPEN_ARCHIVE_FOR_READING_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not get output stream for partition: No storage found for {0}"
     */
    UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE("UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not get output stream for writing: {0}"
     */
    UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_WRITING("UNABLE_TO_OPEN_OUTPUT_STREAM_FOR_WRITING_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not get output stream for partition texts: No storage found for {0}"
     */
    UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE("UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_PARTITION_NO_STORAGE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not get output stream for writing partition texts: {0}"
     */
    UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_WRITING("UNABLE_TO_OPEN_TEXT_OUTPUT_STREAM_FOR_WRITING_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition could not be read: {0}"
     */
    UNABLE_TO_READ_PARTITION("UNABLE_TO_READ_PARTITION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Stream for unexpected pri requested from stream provider: Provider is responsible for {0} but {1} was requested"
     */
    UNEXPECTED_PRI_STREAM_REQUESTED("UNEXPECTED_PRI_STREAM_REQUESTED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Bug exception: Unable to handle unknown subtype of type {0}: {1}"
     */
    UNKNOWN_SUBTYPE_DETECTED("UNKNOWN_SUBTYPE_DETECTED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected ambiguous registration of identical root paths for different containers: rootPath={0}, registered CRI={1}, CRI to register={2}"
     */
    UNEXPECTEDAMBIGUOUSREGISTRATION("UnexpectedAmbiguousRegistration_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected enum value"
     */
    UNEXPECTEDENUMVALUE("UnexpectedEnumValue_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected pri {0} from index. Expected pri {1}"
     */
    UNEXPECTEDPRIFROMINDEX("UnexpectedPriFromIndex_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected storage type"
     */
    UNEXPECTEDSTORAGETYPE("UnexpectedStorageType_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( PersistenceFsMessages.class );

    private final String myKey;

    private PersistenceFsMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            // $JL-EXC$        
            return "Localization failed for ResourceBundle " + PersistenceFsMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
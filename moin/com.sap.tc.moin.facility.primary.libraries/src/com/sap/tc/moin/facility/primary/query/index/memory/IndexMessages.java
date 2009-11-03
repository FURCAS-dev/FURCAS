package com.sap.tc.moin.facility.primary.query.index.memory;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>UNABLE_TO_RESET_MODEL_ELEMENT_XMSG: Cannot reset index model element</li>
 * <li>TABLE_POSITION_IS_NULL_XMSG: Entry at position {0} is null</li>
 * <li>EXCLUSIVE_SCOPE_NOT_ALLOWED_XMSG: Exclusive partition scope is not allowed without type scope</li>
 * <li>HASH_SIZE_TABLES_INCONSISTENT_XMSG: Hash table and size table inconsistent at position {0}</li>
 * <li>HASH_CODE_NOT_DESIGNED_XMSG: Hashcode not designed</li>
 * <li>KEY_ELEMENT_NOT_FOUND_XMSG: Key element {0} not found while looking for object {1}</li>
 * <li>NESTED_INDEXING_NOT_ALLOWED_XMSG: Nested indexing not allowed! current PRI={0}, new PRI={1}</li>
 * <li>NO_ELEMENT_FOUND_TO_REMOVE_XMSG: No element found to remove on position {0}</li>
 * <li>NULL_VALUE_IN_EXT_TABLE_XMSG: Null value in extEnd link list</li>
 * <li>NULL_VALUE_IN_LOC_TABLE_XMSG: Null value in localEnd link list</li>
 * <li>NUM_OF_INDEXED_LINKS_DIFFER_XMSG: Number of indexed links in tables localMofIdToLinkRecords({0}) and priToLinkRecords({1}) differ</li>
 * <li>PARTITION_EXISTS_ALREADY_ACTIVE_XMSG: Partition already exists active in index {0}</li>
 * <li>SIZE_COUNTER_DIFFERENT_XMSG: Size counter({0}) and actual size of array({1}) different</li>
 * <li>NO_INDEX_TICKET_XMSG: The given ticket is not created by the index</li>
 * <li>PARAMETER_IS_NOT_OF_TYPE_XMSG: The parameter {0} is not a {1}</li>
 * <li>PARAMETER_MUST_NOT_BE_STRING_OF_LENGTH_XMSG: The parameter {0} must be a String of length {1}</li>
 * <li>PARAMETER_MUST_NOT_BE_NULL_XMSG: The parameter {0} must not be 'null'</li>
 * <li>TYPE_DOES_NOT_EXIST_XMSG: The type {0} does not exist</li>
 * <li>TICKET_INVALID_XMSG: Ticket is invalid</li>
 * <li>UNEXPECTED_INDEXING_ACTION_XMSG: Unexpected action {0} for partition indexing</li>
 * <li>UNEXPECTED_INDEXING_RESULT_XMSG: Unexpected result from partition indexing operation {0}</li>
 * <li>UNEXPECTED_REMOVE_RESULT_XMSG: Unexpected result from partition removal operation {0}</li>
 * <li>UNKNOWN_MOFID_IN_LINKRECORD_XMSG: Unknown MOF-Id {0} found in LinkRecord {1}</li>
 * <li>UNKNOWN_KEY_ELEMENT_NUMBER_XMSG: Unknown key element number {0}</li>
 * <li>WEAK_REF_EXPECTED_AT_POS_XMSG: WeakReference expected at position {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IndexMessages.properties
 */
 
public enum IndexMessages implements MoinLocalizedString {


    /**
     * Message: "Exclusive partition scope is not allowed without type scope"
     */
    EXCLUSIVE_SCOPE_NOT_ALLOWED("EXCLUSIVE_SCOPE_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Hashcode not designed"
     */
    HASH_CODE_NOT_DESIGNED("HASH_CODE_NOT_DESIGNED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Hash table and size table inconsistent at position {0}"
     */
    HASH_SIZE_TABLES_INCONSISTENT("HASH_SIZE_TABLES_INCONSISTENT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Key element {0} not found while looking for object {1}"
     */
    KEY_ELEMENT_NOT_FOUND("KEY_ELEMENT_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Nested indexing not allowed! current PRI={0}, new PRI={1}"
     */
    NESTED_INDEXING_NOT_ALLOWED("NESTED_INDEXING_NOT_ALLOWED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No element found to remove on position {0}"
     */
    NO_ELEMENT_FOUND_TO_REMOVE("NO_ELEMENT_FOUND_TO_REMOVE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The given ticket is not created by the index"
     */
    NO_INDEX_TICKET("NO_INDEX_TICKET_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Null value in extEnd link list"
     */
    NULL_VALUE_IN_EXT_TABLE("NULL_VALUE_IN_EXT_TABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Null value in localEnd link list"
     */
    NULL_VALUE_IN_LOC_TABLE("NULL_VALUE_IN_LOC_TABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Number of indexed links in tables localMofIdToLinkRecords({0}) and priToLinkRecords({1}) differ"
     */
    NUM_OF_INDEXED_LINKS_DIFFER("NUM_OF_INDEXED_LINKS_DIFFER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The parameter {0} is not a {1}"
     */
    PARAMETER_IS_NOT_OF_TYPE("PARAMETER_IS_NOT_OF_TYPE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The parameter {0} must not be 'null'"
     */
    PARAMETER_MUST_NOT_BE_NULL("PARAMETER_MUST_NOT_BE_NULL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The parameter {0} must be a String of length {1}"
     */
    PARAMETER_MUST_NOT_BE_STRING_OF_LENGTH("PARAMETER_MUST_NOT_BE_STRING_OF_LENGTH_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition already exists active in index {0}"
     */
    PARTITION_EXISTS_ALREADY_ACTIVE("PARTITION_EXISTS_ALREADY_ACTIVE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Size counter({0}) and actual size of array({1}) different"
     */
    SIZE_COUNTER_DIFFERENT("SIZE_COUNTER_DIFFERENT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Entry at position {0} is null"
     */
    TABLE_POSITION_IS_NULL("TABLE_POSITION_IS_NULL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Ticket is invalid"
     */
    TICKET_INVALID("TICKET_INVALID_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The type {0} does not exist"
     */
    TYPE_DOES_NOT_EXIST("TYPE_DOES_NOT_EXIST_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot reset index model element"
     */
    UNABLE_TO_RESET_MODEL_ELEMENT("UNABLE_TO_RESET_MODEL_ELEMENT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected action {0} for partition indexing"
     */
    UNEXPECTED_INDEXING_ACTION("UNEXPECTED_INDEXING_ACTION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected result from partition indexing operation {0}"
     */
    UNEXPECTED_INDEXING_RESULT("UNEXPECTED_INDEXING_RESULT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected result from partition removal operation {0}"
     */
    UNEXPECTED_REMOVE_RESULT("UNEXPECTED_REMOVE_RESULT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unknown key element number {0}"
     */
    UNKNOWN_KEY_ELEMENT_NUMBER("UNKNOWN_KEY_ELEMENT_NUMBER_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unknown MOF-Id {0} found in LinkRecord {1}"
     */
    UNKNOWN_MOFID_IN_LINKRECORD("UNKNOWN_MOFID_IN_LINKRECORD_XMSG"), //$NON-NLS-1$

    /**
     * Message: "WeakReference expected at position {0}"
     */
    WEAK_REF_EXPECTED_AT_POS("WEAK_REF_EXPECTED_AT_POS_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IndexMessages.class );

    private final String myKey;

    private IndexMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + IndexMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
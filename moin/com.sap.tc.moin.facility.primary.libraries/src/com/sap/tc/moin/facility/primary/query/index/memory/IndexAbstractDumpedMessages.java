package com.sap.tc.moin.facility.primary.query.index.memory;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ARRAY_SIZE_END_ERROR_XMSG: Array size end sign incorrect, expected {0}, was {1}</li>
 * <li>ARRAY_SIZE_START_ERROR_XMSG: Array size start sign incorrect, expected {0}, was {1}</li>
 * <li>POSITION_NOT_FOUND_XMSG: Could not determine position of record {0}</li>
 * <li>ENTRY_NUMBERS_INCORRECT_XMSG: DUMP Error: {0} number of entrys incorrect, expected: {1}, was: {2}</li>
 * <li>DUMP_VERSION_INCOMPATIBLE_XMSG: Dump version incompatible, expected: {1}, was: {2}</li>
 * <li>UNKNOWN_ELEMENT_TYPE_XMSG: Unknown element type {0} in index dump</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IndexAbstractDumpedMessages.properties
 */
 
public enum IndexAbstractDumpedMessages implements MoinLocalizedString {


    /**
     * Message: "Array size end sign incorrect, expected {0}, was {1}"
     */
    ARRAY_SIZE_END_ERROR("ARRAY_SIZE_END_ERROR_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Array size start sign incorrect, expected {0}, was {1}"
     */
    ARRAY_SIZE_START_ERROR("ARRAY_SIZE_START_ERROR_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Dump version incompatible, expected: {1}, was: {2}"
     */
    DUMP_VERSION_INCOMPATIBLE("DUMP_VERSION_INCOMPATIBLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "DUMP Error: {0} number of entrys incorrect, expected: {1}, was: {2}"
     */
    ENTRY_NUMBERS_INCORRECT("ENTRY_NUMBERS_INCORRECT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not determine position of record {0}"
     */
    POSITION_NOT_FOUND("POSITION_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unknown element type {0} in index dump"
     */
    UNKNOWN_ELEMENT_TYPE("UNKNOWN_ELEMENT_TYPE_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IndexAbstractDumpedMessages.class );

    private final String myKey;

    private IndexAbstractDumpedMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + IndexAbstractDumpedMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
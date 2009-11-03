package com.sap.tc.moin.repository.shared.util;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>IllegalArgument_XMSG: Illegal argument: sortInputArray must have length 2</li>
 * <li>HousekeepingThreadException_XMSG: The Housekeeping Thread has encountered an Exception</li>
 * <li>UnexpectedGUIDLength_XMSG: Unexpected GUID length, guid_XMSG={0}</li>
 * <li>UnexpectedMofIdLength_XMSG: Unexpected MOF id length, MOF id_XMSG={0}</li>
 * <li>UnexpectedArrayLength_XMSG: Unexpected array length of hash value</li>
 * <li>UnexpectedByteValue_XMSG: Unexpected byte value: {0}</li>
 * <li>UnexpectedCharValue_XMSG: Unexpected char value: {0}</li>
 * <li>UnexpectedPrefixLength_XMSG: Unexpected prefix length for segmented MOF id, Prefix length={0}</li>
 * <li>UnsupportedEncoding_XMSG: Unsupported encoding</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from UtilitiesMessages.properties
 */
 
public enum UtilitiesMessages implements MoinLocalizedString {


    /**
     * Message: "The Housekeeping Thread has encountered an Exception"
     */
    HOUSEKEEPINGTHREADEXCEPTION("HousekeepingThreadException_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal argument: sortInputArray must have length 2"
     */
    ILLEGALARGUMENT("IllegalArgument_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected array length of hash value"
     */
    UNEXPECTEDARRAYLENGTH("UnexpectedArrayLength_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected byte value: {0}"
     */
    UNEXPECTEDBYTEVALUE("UnexpectedByteValue_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected char value: {0}"
     */
    UNEXPECTEDCHARVALUE("UnexpectedCharValue_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected GUID length, guid_XMSG={0}"
     */
    UNEXPECTEDGUIDLENGTH("UnexpectedGUIDLength_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected MOF id length, MOF id_XMSG={0}"
     */
    UNEXPECTEDMOFIDLENGTH("UnexpectedMofIdLength_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected prefix length for segmented MOF id, Prefix length={0}"
     */
    UNEXPECTEDPREFIXLENGTH("UnexpectedPrefixLength_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unsupported encoding"
     */
    UNSUPPORTEDENCODING("UnsupportedEncoding_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( UtilitiesMessages.class );

    private final String myKey;

    private UtilitiesMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + UtilitiesMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
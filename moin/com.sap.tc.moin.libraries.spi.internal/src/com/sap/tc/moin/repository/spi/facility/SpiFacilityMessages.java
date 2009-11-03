package com.sap.tc.moin.repository.spi.facility;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>RemoveFromExceptionIteratorNotSupported_XMSG: Remove from exception iterator not supported</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from SpiFacilityMessages.properties
 */
 
public enum SpiFacilityMessages implements MoinLocalizedString {


    /**
     * Message: "Remove from exception iterator not supported"
     */
    REMOVEFROMEXCEPTIONITERATORNOTSUPPORTED("RemoveFromExceptionIteratorNotSupported_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( SpiFacilityMessages.class );

    private final String myKey;

    private SpiFacilityMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + SpiFacilityMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
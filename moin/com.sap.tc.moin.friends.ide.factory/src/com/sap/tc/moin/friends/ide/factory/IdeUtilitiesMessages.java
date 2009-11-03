package com.sap.tc.moin.friends.ide.factory;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>GetUtilFailed_XMSG: getUtil failed</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from IdeUtilitiesMessages.properties
 */

public enum IdeUtilitiesMessages implements MoinLocalizedString {


    /**
     * Message: "getUtil failed"
     */
    GETUTILFAILED( "GetUtilFailed_XMSG" ); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IdeUtilitiesMessages.class );

    private final String myKey;

    private IdeUtilitiesMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + IdeUtilitiesMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}
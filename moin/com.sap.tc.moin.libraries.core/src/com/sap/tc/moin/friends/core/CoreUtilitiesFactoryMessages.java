package com.sap.tc.moin.friends.core;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>FailedGetImplementation_XMSG: Failed to get the implementation via reflection</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreUtilitiesFactoryMessages.properties
 */
 
public enum CoreUtilitiesFactoryMessages implements MoinLocalizedString {


    /**
     * Message: "Failed to get the implementation via reflection"
     */
    FAILEDGETIMPLEMENTATION("FailedGetImplementation_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreUtilitiesFactoryMessages.class );

    private final String myKey;

    private CoreUtilitiesFactoryMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreUtilitiesFactoryMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
package com.sap.tc.moin.repository.ide.localization;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>MoinDeploymentExceptionMessage_XMSG: Deployment could not be completed, technical information: {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from RuntimeEpiMessages.properties
 */
 
public enum RuntimeEpiMessages implements MoinLocalizedString {


    /**
     * Message: "Deployment could not be completed, technical information: {0}"
     */
    MOINDEPLOYMENTEXCEPTIONMESSAGE("MoinDeploymentExceptionMessage_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( RuntimeEpiMessages.class );

    private final String myKey;

    private RuntimeEpiMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + RuntimeEpiMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
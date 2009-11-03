package com.sap.tc.moin.repository.cdam.ide.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ARGUMENT_MUST_NOT_BE_NULL_XMSG: Argument {0} must not be null</li>
 * <li>NO_CRI_FOR_PROJECT_XMSG: Container resource identifier could not be retrieved for {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IdeCompoundDataAreaManagerMessages.properties
 */
 
public enum IdeCompoundDataAreaManagerMessages implements MoinLocalizedString {


    /**
     * Message: "Argument {0} must not be null"
     */
    ARGUMENT_MUST_NOT_BE_NULL("ARGUMENT_MUST_NOT_BE_NULL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Container resource identifier could not be retrieved for {0}"
     */
    NO_CRI_FOR_PROJECT("NO_CRI_FOR_PROJECT_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IdeCompoundDataAreaManagerMessages.class );

    private final String myKey;

    private IdeCompoundDataAreaManagerMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + IdeCompoundDataAreaManagerMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
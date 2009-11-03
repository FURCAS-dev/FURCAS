package com.sap.tc.moin.repository.runtimehost.ide;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>RESETTED_MOIN_INSTANCE_CHANGED_XMSG: Error during reset: MOIN instance changed</li>
 * <li>MOIN_WRAPPER_NOT_INITIALIZED_XMSG: MOIN wrapper not initialized</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IdeRuntimeHostMessages.properties
 */
 
public enum IdeRuntimeHostMessages implements MoinLocalizedString {


    /**
     * Message: "MOIN wrapper not initialized"
     */
    MOIN_WRAPPER_NOT_INITIALIZED("MOIN_WRAPPER_NOT_INITIALIZED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Error during reset: MOIN instance changed"
     */
    RESETTED_MOIN_INSTANCE_CHANGED("RESETTED_MOIN_INSTANCE_CHANGED_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IdeRuntimeHostMessages.class );

    private final String myKey;

    private IdeRuntimeHostMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + IdeRuntimeHostMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
package com.sap.tc.moin.repository.shared.util.cmdline;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>Parameter_is_missing_XMSG: Parameter %1$s is missing.</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CommandLineParserMessages.properties
 */
 
public enum CommandLineParserMessages implements MoinLocalizedString {


    /**
     * Message: "Parameter %1$s is missing."
     */
    PARAMETER_IS_MISSING("Parameter_is_missing_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CommandLineParserMessages.class );

    private final String myKey;

    private CommandLineParserMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CommandLineParserMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
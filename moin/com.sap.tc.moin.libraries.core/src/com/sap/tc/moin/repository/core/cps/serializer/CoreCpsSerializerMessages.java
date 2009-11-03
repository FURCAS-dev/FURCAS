package com.sap.tc.moin.repository.core.cps.serializer;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>EndNumberMustEitherBe0Or1_XMSG: The value of the endNumber parameter must either be 0 or 1</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreCpsSerializerMessages.properties
 */
 
public enum CoreCpsSerializerMessages implements MoinLocalizedString {


    /**
     * Message: "The value of the endNumber parameter must either be 0 or 1"
     */
    ENDNUMBERMUSTEITHERBE0OR1("EndNumberMustEitherBe0Or1_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreCpsSerializerMessages.class );

    private final String myKey;

    private CoreCpsSerializerMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreCpsSerializerMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
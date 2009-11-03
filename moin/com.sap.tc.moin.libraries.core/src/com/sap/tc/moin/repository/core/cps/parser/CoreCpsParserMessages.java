package com.sap.tc.moin.repository.core.cps.parser;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ElementAtFirstEndIsNotCompatible_XMSG: The elementAtFirstEnd is not compatible with the type of the association's first end</li>
 * <li>ElementAtSecondEndIsNotCompatible_XMSG: The elementAtSecondEnd is not compatible with the type of the association's second end</li>
 * <li>MofIdParameterMustBeAStringOfLength_XMSG: The mofId parameter must be a String of length {0}</li>
 * <li>UnexpectedNullValue_XMSG: Unexpected 'null' value of currentElement</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreCpsParserMessages.properties
 */
 
public enum CoreCpsParserMessages implements MoinLocalizedString {


    /**
     * Message: "The elementAtFirstEnd is not compatible with the type of the association's first end"
     */
    ELEMENTATFIRSTENDISNOTCOMPATIBLE("ElementAtFirstEndIsNotCompatible_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The elementAtSecondEnd is not compatible with the type of the association's second end"
     */
    ELEMENTATSECONDENDISNOTCOMPATIBLE("ElementAtSecondEndIsNotCompatible_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The mofId parameter must be a String of length {0}"
     */
    MOFIDPARAMETERMUSTBEASTRINGOFLENGTH("MofIdParameterMustBeAStringOfLength_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected 'null' value of currentElement"
     */
    UNEXPECTEDNULLVALUE("UnexpectedNullValue_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreCpsParserMessages.class );

    private final String myKey;

    private CoreCpsParserMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreCpsParserMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
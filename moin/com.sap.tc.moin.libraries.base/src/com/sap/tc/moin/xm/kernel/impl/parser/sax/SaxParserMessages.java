package com.sap.tc.moin.xm.kernel.impl.parser.sax;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>LevelSmallerThanOne_XMSG: Level is smaller than 1</li>
 * <li>NODENOTEXISTINGINLEVEL_XMSG: The given XML element/attribute with local name {0} and prefix {1} does not exist in the level {2}</li>
 * <li>NotWithinAllowedRange_XMSG: The specified depth {0} is not within the allowed range [1,{1}]</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from SaxParserMessages.properties
 */
 
public enum SaxParserMessages implements MoinLocalizedString {


    /**
     * Message: "Level is smaller than 1"
     */
    LEVELSMALLERTHANONE("LevelSmallerThanOne_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The given XML element/attribute with local name {0} and prefix {1} does not exist in the level {2}"
     */
    NODENOTEXISTINGINLEVEL("NODENOTEXISTINGINLEVEL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The specified depth {0} is not within the allowed range [1,{1}]"
     */
    NOTWITHINALLOWEDRANGE("NotWithinAllowedRange_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( SaxParserMessages.class );

    private final String myKey;

    private SaxParserMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + SaxParserMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
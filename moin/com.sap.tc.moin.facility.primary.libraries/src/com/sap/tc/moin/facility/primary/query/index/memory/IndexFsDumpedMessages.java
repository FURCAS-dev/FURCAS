package com.sap.tc.moin.facility.primary.query.index.memory;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>DATA_AREA_SCOPE_MISSING_XMSG: Illegal combination of arguments: dataAreaName == null && syncedOnly = true</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IndexFsDumpedMessages.properties
 */
 
public enum IndexFsDumpedMessages implements MoinLocalizedString {


    /**
     * Message: "Illegal combination of arguments: dataAreaName == null && syncedOnly = true"
     */
    DATA_AREA_SCOPE_MISSING("DATA_AREA_SCOPE_MISSING_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IndexFsDumpedMessages.class );

    private final String myKey;

    private IndexFsDumpedMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + IndexFsDumpedMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
package com.sap.tc.moin.facility.primary.metamodelmanager;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ParameterPriMustNotBeNull_XMSG: The parameter pri must not be null</li>
 * <li>NO_STREAM_AVAILABLE_FOR_PARTITION_XMSG: Unable to provide partition stream for the given PRI: meta-model partition {0} not registered</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MetaModelManagerMessages.properties
 */
 
public enum MetaModelManagerMessages implements MoinLocalizedString {


    /**
     * Message: "Unable to provide partition stream for the given PRI: meta-model partition {0} not registered"
     */
    NO_STREAM_AVAILABLE_FOR_PARTITION("NO_STREAM_AVAILABLE_FOR_PARTITION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The parameter pri must not be null"
     */
    PARAMETERPRIMUSTNOTBENULL("ParameterPriMustNotBeNull_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MetaModelManagerMessages.class );

    private final String myKey;

    private MetaModelManagerMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + MetaModelManagerMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
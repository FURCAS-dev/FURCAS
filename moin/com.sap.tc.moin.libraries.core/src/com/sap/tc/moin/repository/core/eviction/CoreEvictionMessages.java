package com.sap.tc.moin.repository.core.eviction;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>EvictionIntervalMustNotBeNegative_XMSG: Eviction interval must not be negative: {0}</li>
 * <li>MaximumAgeCannotBeNegativeOrZero_XMSG: maximumAge cannot be negative or zero</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreEvictionMessages.properties
 */
 
public enum CoreEvictionMessages implements MoinLocalizedString {


    /**
     * Message: "Eviction interval must not be negative: {0}"
     */
    EVICTIONINTERVALMUSTNOTBENEGATIVE("EvictionIntervalMustNotBeNegative_XMSG"), //$NON-NLS-1$

    /**
     * Message: "maximumAge cannot be negative or zero"
     */
    MAXIMUMAGECANNOTBENEGATIVEORZERO("MaximumAgeCannotBeNegativeOrZero_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreEvictionMessages.class );

    private final String myKey;

    private CoreEvictionMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreEvictionMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
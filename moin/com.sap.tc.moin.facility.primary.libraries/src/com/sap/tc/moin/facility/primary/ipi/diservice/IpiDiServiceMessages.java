package com.sap.tc.moin.facility.primary.ipi.diservice;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED_XMSG: Internal error: development component adaptor could not be instantiated</li>
 * <li>INTERNAL_ERROR_CONFIGURATION_ADAPTER_NOT_INSTANTIATED_XMSG: Internal error: development configuration adaptor could not be instantiated</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from IpiDiServiceMessages.properties
 */
 
public enum IpiDiServiceMessages implements MoinLocalizedString {


    /**
     * Message: "Internal error: development configuration adaptor could not be instantiated"
     */
    INTERNAL_ERROR_CONFIGURATION_ADAPTER_NOT_INSTANTIATED("INTERNAL_ERROR_CONFIGURATION_ADAPTER_NOT_INSTANTIATED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Internal error: development component adaptor could not be instantiated"
     */
    INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED("INTERNAL_ERROR_DC_ADAPTER_NOT_INSTANTIATED_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( IpiDiServiceMessages.class );

    private final String myKey;

    private IpiDiServiceMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            // $JL-EXC$        
            return "Localization failed for ResourceBundle " + IpiDiServiceMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
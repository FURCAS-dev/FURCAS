package com.sap.tc.moin.repository.cdam;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ClientSpecMustNotBelongToMetamodelDataArea_XMSG: Client spec must not belong to the meta model data area</li>
 * <li>MoreThanOneMetamodelFacilityFound_XMSG: More than one metamodel facility found</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from RepositoryCdamMessages.properties
 */
 
public enum RepositoryCdamMessages implements MoinLocalizedString {


    /**
     * Message: "Client spec must not belong to the meta model data area"
     */
    CLIENTSPECMUSTNOTBELONGTOMETAMODELDATAAREA("ClientSpecMustNotBelongToMetamodelDataArea_XMSG"), //$NON-NLS-1$

    /**
     * Message: "More than one metamodel facility found"
     */
    MORETHANONEMETAMODELFACILITYFOUND("MoreThanOneMetamodelFacilityFound_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( RepositoryCdamMessages.class );

    private final String myKey;

    private RepositoryCdamMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + RepositoryCdamMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
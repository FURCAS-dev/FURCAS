package com.sap.tc.moin.facility.primary.dataareamgmt.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>Unexpected_Stage_XMSG: Data area "{0}" does not belong to client spec
 * "{1}", but it belongs to client spec "{2}"</li>
 * <li>Data_Area_Management_Not_Properly_Initialized_XMSG: Data area management
 * is not properly initialized</li>
 * <li>INTERNAL_ERROR_DATA_AREA_EXISTS_XMSG: Internal Error: Data area "{0}"
 * already exists</li>
 * <li>INTERNAL_ERROR_MULTIPLE_STAGES_NOT_SUPPORTED_XMSG: Internal error: Data
 * areas with multiple stages are not supported</li>
 * <li>PRI_DOES_NOT_BELONG_TO_DATAAREA_XMSG: The partition "{0}" does not belong
 * to the data area "{1}"</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from DataAreaMgmtMessages.properties
 */

public enum DataAreaMgmtMessages implements MoinLocalizedString {


    /**
     * Message: "Data area management is not properly initialized"
     */
    DATA_AREA_MANAGEMENT_NOT_PROPERLY_INITIALIZED( "Data_Area_Management_Not_Properly_Initialized_XMSG" ), //$NON-NLS-1$

    /**
     * Message: "Internal Error: Data area "{0}" already exists"
     */
    INTERNAL_ERROR_DATA_AREA_EXISTS( "INTERNAL_ERROR_DATA_AREA_EXISTS_XMSG" ), //$NON-NLS-1$

    /**
     * Message:
     * "Internal error: Data areas with multiple stages are not supported"
     */
    INTERNAL_ERROR_MULTIPLE_STAGES_NOT_SUPPORTED( "INTERNAL_ERROR_MULTIPLE_STAGES_NOT_SUPPORTED_XMSG" ), //$NON-NLS-1$

    /**
     * Message: "Internal error\: The data area of partition [{0}] is not
     * supported because it has multiple stages"
     */
    PRI_DOES_NOT_BELONG_TO_DATAAREA( "PRI_DOES_NOT_BELONG_TO_DATAAREA_XMSG" ), //$NON-NLS-1$

    /**
     * Message: "Data area "{0}" does not belong to client spec "{1}
     * ", but it belongs to client spec "{2}""
     */
    UNEXPECTED_STAGE( "Unexpected_Stage_XMSG" ); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( DataAreaMgmtMessages.class );

    private final String myKey;

    private DataAreaMgmtMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + DataAreaMgmtMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}
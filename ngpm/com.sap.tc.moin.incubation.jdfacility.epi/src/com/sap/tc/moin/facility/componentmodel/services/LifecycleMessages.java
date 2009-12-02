package com.sap.tc.moin.facility.componentmodel.services;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>PARTITION_CREATION_NOT_POSSIBLE_XMSG: Creation of partition '{0}' not possible. Modification of container or data area is not possible.</li>
 * <li>PARTITION_DELETION_NOT_POSSIBLE_XMSG: Deletion of partition '{0}' not possible. Modification of container or data area is not possible.</li>
 * <li>PDEL_NOT_POSSIBLE_P_NOT_EXISTING_XMSG: Deletion of partition '{0}' not possible. Partition does not exist.</li>
 * <li>PARTITION_EDITING_NOT_POSSIBLE_XMSG: Edition of partition '{0}' not possible. Modification of container or data area is not possible.</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from LifeCycleMessages.properties
 */
 
public enum LifecycleMessages implements MoinLocalizedString {


    /**
     * Message: "Creation of partition '{0}' not possible. Modification of container or data area is not possible."
     */
    PARTITION_CREATION_NOT_POSSIBLE("PARTITION_CREATION_NOT_POSSIBLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Deletion of partition '{0}' not possible. Modification of container or data area is not possible."
     */
    PARTITION_DELETION_NOT_POSSIBLE("PARTITION_DELETION_NOT_POSSIBLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Edition of partition '{0}' not possible. Modification of container or data area is not possible."
     */
    PARTITION_EDITING_NOT_POSSIBLE("PARTITION_EDITING_NOT_POSSIBLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Deletion of partition '{0}' not possible. Partition does not exist."
     */
    PDEL_NOT_POSSIBLE_P_NOT_EXISTING("PDEL_NOT_POSSIBLE_P_NOT_EXISTING_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( LifecycleMessages.class );

    private final String myKey;

    private LifecycleMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + LifecycleMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
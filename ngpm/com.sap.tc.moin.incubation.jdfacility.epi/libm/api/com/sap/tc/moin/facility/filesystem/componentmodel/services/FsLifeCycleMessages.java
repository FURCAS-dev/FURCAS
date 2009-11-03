package com.sap.tc.moin.facility.filesystem.componentmodel.services;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ERR_PCREATE_NAME_CONFLICT_XMSG: Creation of partition ''{0}'' not possible. A file with different upper / lower case already exists on local disc: ''{1}''.</li>
 * <li>ERR_PCREATE_DUPLICATE_XMSG: Creation of partition ''{0}'' not possible. Partition already exists.</li>
 * <li>ERR_PCREATE_FSERROR_XMSG: Creation of partition ''{0}'' not possible. Problems with filesystem.</li>
 * <li>ERR_PCREATE_ARCHIVE_NOT_WRITEABLE_XMSG: Creation of partition ''{0}'' not possible. Target is inside an archive.</li>
 * <li>ERR_PDEL_MISSING_XMSG: Deletion of partition ''{0}'' not possible. Partition does not exist.</li>
 * <li>ERR_PDEL_READONLY_XMSG: Deletion of partition ''{0}'' not possible. Partition is read-only.</li>
 * <li>ERR_PEDIT_MISSING_XMSG: Editing of partition ''{0}'' not possible. Partition does not exist.</li>
 * <li>ERR_PEDIT_READONLY_XMSG: Editing of partition ''{0}'' not possible. Partition is read-only.</li>
 * <li>PARTITION_NO_SERIALIZER_XMSG: Partition {0} cannot be modified. No serializer defined</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from FsLifeCycleMessages.properties
 */
 
public enum FsLifeCycleMessages implements MoinLocalizedString {


    /**
     * Message: "Creation of partition ''{0}'' not possible. Target is inside an archive."
     */
    ERR_PCREATE_ARCHIVE_NOT_WRITEABLE("ERR_PCREATE_ARCHIVE_NOT_WRITEABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Creation of partition ''{0}'' not possible. Partition already exists."
     */
    ERR_PCREATE_DUPLICATE("ERR_PCREATE_DUPLICATE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Creation of partition ''{0}'' not possible. Problems with filesystem."
     */
    ERR_PCREATE_FSERROR("ERR_PCREATE_FSERROR_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Creation of partition ''{0}'' not possible. A file with different upper / lower case already exists on local disc: ''{1}''."
     */
    ERR_PCREATE_NAME_CONFLICT("ERR_PCREATE_NAME_CONFLICT_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Deletion of partition ''{0}'' not possible. Partition does not exist."
     */
    ERR_PDEL_MISSING("ERR_PDEL_MISSING_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Deletion of partition ''{0}'' not possible. Partition is read-only."
     */
    ERR_PDEL_READONLY("ERR_PDEL_READONLY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Editing of partition ''{0}'' not possible. Partition does not exist."
     */
    ERR_PEDIT_MISSING("ERR_PEDIT_MISSING_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Editing of partition ''{0}'' not possible. Partition is read-only."
     */
    ERR_PEDIT_READONLY("ERR_PEDIT_READONLY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition {0} cannot be modified. No serializer defined"
     */
    PARTITION_NO_SERIALIZER("PARTITION_NO_SERIALIZER_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( FsLifeCycleMessages.class );

    private final String myKey;

    private FsLifeCycleMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + FsLifeCycleMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
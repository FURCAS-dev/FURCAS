package com.sap.tc.moin.repository.core.jmi.util;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>NoValidEndNumber_XMSG: "{0}" is not a valid end number</li>
 * <li>DependencyCycle_XMSG: A dependency cycle was detected</li>
 * <li>CouldNotReadBytes_XMSG: Could not read the expected number of bytes</li>
 * <li>EndNotFoundInAssoc_XMSG: Internal error: couldn't find AssociationEnd "{0}" in its owning Association "{1}"</li>
 * <li>StorageOnBothEnds_XMSG: Storage is defined on both end 0 and end 1 for Association/Attribute "{0}". The metamodel may be faulty.</li>
 * <li>StorageOnNoEnd_XMSG: Storage is defined on neither end 0 nor end 1 for Association/Attribute "{0}". The metamodel may be faulty.</li>
 * <li>ContainerOfEnumWrongType_XMSG: The Container of the EnumerationType "{0}" is neither a MofClass nor a MofPackage</li>
 * <li>RefObjectMustBeAttOrAssoc_XMSG: The given RefObject must be either an Attribute or an Association</li>
 * <li>MetaObjectMustBeAttOrAssoc_XMSG: The meta object must be instance of either Attribute or Association</li>
 * <li>ObjectNoAttOrAssoc_XMSG: The object "{0}" is neither an Attribute nor an Association</li>
 * <li>WrongIndexVersion_XMSG: Wrong index version. Expected: {0}, read: {1}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from JmiUtilMessages.properties
 */
 
public enum JmiUtilMessages implements MoinLocalizedString {


    /**
     * Message: "The Container of the EnumerationType "{0}" is neither a MofClass nor a MofPackage"
     */
    CONTAINEROFENUMWRONGTYPE("ContainerOfEnumWrongType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not read the expected number of bytes"
     */
    COULDNOTREADBYTES("CouldNotReadBytes_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A dependency cycle was detected"
     */
    DEPENDENCYCYCLE("DependencyCycle_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Internal error: couldn't find AssociationEnd "{0}" in its owning Association "{1}""
     */
    ENDNOTFOUNDINASSOC("EndNotFoundInAssoc_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The meta object must be instance of either Attribute or Association"
     */
    METAOBJECTMUSTBEATTORASSOC("MetaObjectMustBeAttOrAssoc_XMSG"), //$NON-NLS-1$

    /**
     * Message: ""{0}" is not a valid end number"
     */
    NOVALIDENDNUMBER("NoValidEndNumber_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The object "{0}" is neither an Attribute nor an Association"
     */
    OBJECTNOATTORASSOC("ObjectNoAttOrAssoc_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The given RefObject must be either an Attribute or an Association"
     */
    REFOBJECTMUSTBEATTORASSOC("RefObjectMustBeAttOrAssoc_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Storage is defined on both end 0 and end 1 for Association/Attribute "{0}". The metamodel may be faulty."
     */
    STORAGEONBOTHENDS("StorageOnBothEnds_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Storage is defined on neither end 0 nor end 1 for Association/Attribute "{0}". The metamodel may be faulty."
     */
    STORAGEONNOEND("StorageOnNoEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Wrong index version. Expected: {0}, read: {1}"
     */
    WRONGINDEXVERSION("WrongIndexVersion_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( JmiUtilMessages.class );

    private final String myKey;

    private JmiUtilMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + JmiUtilMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
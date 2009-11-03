package com.sap.tc.moin.friends.impl.merge;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CopyObjectNotResolved_XMSG: Can not resolve the object to copy</li>
 * <li>CouldNotResolveEitherLink_XMSG: Could not resolve either link end during link copy operation</li>
 * <li>DifferentObjectDuringReorder_XMSG: Different objects found during reordering</li>
 * <li>NoHandlerForOperationType_XMSG: No handler for operation type {0}</li>
 * <li>EndsCouldNotBeResolved_XMSG: One or both ends could not be resolved</li>
 * <li>NoChangeDetected_XMSG: Operation did not result in any changes</li>
 * <li>ReorderingAttValuesNotImplemented_XMSG: Reordering of attribute values not implemented</li>
 * <li>WrongParameterType_XMSG: The parameter type does not match the operation type</li>
 * <li>ParentNotFound_XMSG: The parent for a dependent operation was not found</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from FriendsImplMergeMessages.properties
 */
 
public enum FriendsImplMergeMessages implements MoinLocalizedString {


    /**
     * Message: "Can not resolve the object to copy"
     */
    COPYOBJECTNOTRESOLVED("CopyObjectNotResolved_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not resolve either link end during link copy operation"
     */
    COULDNOTRESOLVEEITHERLINK("CouldNotResolveEitherLink_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Different objects found during reordering"
     */
    DIFFERENTOBJECTDURINGREORDER("DifferentObjectDuringReorder_XMSG"), //$NON-NLS-1$

    /**
     * Message: "One or both ends could not be resolved"
     */
    ENDSCOULDNOTBERESOLVED("EndsCouldNotBeResolved_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation did not result in any changes"
     */
    NOCHANGEDETECTED("NoChangeDetected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No handler for operation type {0}"
     */
    NOHANDLERFOROPERATIONTYPE("NoHandlerForOperationType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The parent for a dependent operation was not found"
     */
    PARENTNOTFOUND("ParentNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Reordering of attribute values not implemented"
     */
    REORDERINGATTVALUESNOTIMPLEMENTED("ReorderingAttValuesNotImplemented_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The parameter type does not match the operation type"
     */
    WRONGPARAMETERTYPE("WrongParameterType_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( FriendsImplMergeMessages.class );

    private final String myKey;

    private FriendsImplMergeMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + FriendsImplMergeMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
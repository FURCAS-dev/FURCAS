package com.sap.tc.moin.xm.adapter.cps;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>AssociationHasNoEndName_XMSG: Association "{0}" does not have an end with name "{1}"</li>
 * <li>AssociationEndNumberIllegal_XMSG: Association end number {0} is illegal</li>
 * <li>TypeNotFittingToAssociationEnd_XMSG: Type "{0}" of the model element does not fit to the end "{1}" of the association "{2}"</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from XmCpsMessages.properties
 */
 
public enum XmCpsMessages implements MoinLocalizedString {


    /**
     * Message: "Association end number {0} is illegal"
     */
    ASSOCIATIONENDNUMBERILLEGAL("AssociationEndNumberIllegal_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Association "{0}" does not have an end with name "{1}""
     */
    ASSOCIATIONHASNOENDNAME("AssociationHasNoEndName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type "{0}" of the model element does not fit to the end "{1}" of the association "{2}""
     */
    TYPENOTFITTINGTOASSOCIATIONEND("TypeNotFittingToAssociationEnd_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( XmCpsMessages.class );

    private final String myKey;

    private XmCpsMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + XmCpsMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
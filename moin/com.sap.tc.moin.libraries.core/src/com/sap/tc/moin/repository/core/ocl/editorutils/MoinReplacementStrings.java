package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>AddEnumLabel_XMSG: Add Enumeration label</li>
 * <li>AddCollectionType_XMSG: Add a CollectionType</li>
 * <li>AddCollectionDecl_XMSG: Add a CollectionType declaration</li>
 * <li>DeleteToken_XMSG: Delete token "{0}"</li>
 * <li>InsertToken_XMSG: Insert {0}</li>
 * <li>InsertTokenBefore_XMSG: Insert {0} before this position</li>
 * <li>ReplaceToken_XMSG: Replace "{0}" with "{1}"</li>
 * <li>ReplaceTokenAssocEnd_XMSG: Replace with AssociationEnd "{0}"</li>
 * <li>ReplaceTokenAttribute_XMSG: Replace with Attribute "{0}"</li>
 * <li>ReplaceTokenReference_XMSG: Replace with Reference "{0}"</li>
 * <li>ElementProposalSimple_XMSG: {0}</li>
 * <li>VarNameAndType_XMSG: {0} : {1}</li>
 * <li>ElementProposal_XMSG: {0} : {1} - {2}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MoinReplacementStrings.properties
 */
 
public enum MoinReplacementStrings implements MoinLocalizedString {


    /**
     * Message: "Add a CollectionType declaration"
     */
    ADDCOLLECTIONDECL("AddCollectionDecl_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Add a CollectionType"
     */
    ADDCOLLECTIONTYPE("AddCollectionType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Add Enumeration label"
     */
    ADDENUMLABEL("AddEnumLabel_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Delete token "{0}""
     */
    DELETETOKEN("DeleteToken_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0}"
     */
    ELEMENTPROPOSALSIMPLE("ElementProposalSimple_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0} : {1} - {2}"
     */
    ELEMENTPROPOSAL("ElementProposal_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Insert {0} before this position"
     */
    INSERTTOKENBEFORE("InsertTokenBefore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Insert {0}"
     */
    INSERTTOKEN("InsertToken_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Replace with AssociationEnd "{0}""
     */
    REPLACETOKENASSOCEND("ReplaceTokenAssocEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Replace with Attribute "{0}""
     */
    REPLACETOKENATTRIBUTE("ReplaceTokenAttribute_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Replace with Reference "{0}""
     */
    REPLACETOKENREFERENCE("ReplaceTokenReference_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Replace "{0}" with "{1}""
     */
    REPLACETOKEN("ReplaceToken_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0} : {1}"
     */
    VARNAMEANDTYPE("VarNameAndType_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MoinReplacementStrings.class );

    private final String myKey;

    private MoinReplacementStrings( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + MoinReplacementStrings.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
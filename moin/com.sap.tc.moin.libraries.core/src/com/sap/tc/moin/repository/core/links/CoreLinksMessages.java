package com.sap.tc.moin.repository.core.links;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CallIsAssocLinkExistingOnNonAssocLink_XMSG: Attempt to call isAssociationLinkExisting() for a non-association link</li>
 * <li>ReplaceLogicalLinkMultOneWithMultAssocEnd_XMSG: Attempt to call replaceLogicalLinkMultiplicityOne() with a multiplicity-many association end</li>
 * <li>LoadSecondLinkForSingleAssoc_XMSG: Attempt to load a second link for a multiplicity-one association</li>
 * <li>LoadSecondLinkForSingleAttr_XMSG: Attempt to load a second link for a multiplicity-one object-valued attribute</li>
 * <li>ChangingNotAllowedWithThisIterator_XMSG: Changing not allowed with this iterator</li>
 * <li>StandardPRINull_XMSG: Internal error: StandardPri is null, but overflow structure is existing</li>
 * <li>IteratorRemoveCalledBeforeNext_XMSG: Iterator.remove() has been called without calling Iterator.next() before</li>
 * <li>LriOfMriNull_XMSG: Method getLri() of MRI "{0}" returned a null value</li>
 * <li>StorageEndNumberWrong_XMSG: Number of storage end must be 0 or 1, but was {0}</li>
 * <li>SpecifiedArrayIsNull_XMSG: The specified array is null</li>
 * <li>ThisMethodShouldNeverBeCalled_XMSG: This method should never be called. If so, it is a bug.</li>
 * <li>FromIndex_XMSG: fromIndex = {0}</li>
 * <li>FromIndex_GT_ToIndex_XMSG: fromIndex({0}) > toIndex({1})</li>
 * <li>ToIndex_XMSG: toIndex = {0}</li>
 * <li>NoLegalArgument_XMSG: {0} is no legal argument, only {1} and {2} are allowed</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreLinksMessages.properties
 */
 
public enum CoreLinksMessages implements MoinLocalizedString {


    /**
     * Message: "Attempt to call isAssociationLinkExisting() for a non-association link"
     */
    CALLISASSOCLINKEXISTINGONNONASSOCLINK("CallIsAssocLinkExistingOnNonAssocLink_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Changing not allowed with this iterator"
     */
    CHANGINGNOTALLOWEDWITHTHISITERATOR("ChangingNotAllowedWithThisIterator_XMSG"), //$NON-NLS-1$

    /**
     * Message: "fromIndex({0}) > toIndex({1})"
     */
    FROMINDEX_GT_TOINDEX("FromIndex_GT_ToIndex_XMSG"), //$NON-NLS-1$

    /**
     * Message: "fromIndex = {0}"
     */
    FROMINDEX("FromIndex_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator.remove() has been called without calling Iterator.next() before"
     */
    ITERATORREMOVECALLEDBEFORENEXT("IteratorRemoveCalledBeforeNext_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attempt to load a second link for a multiplicity-one association"
     */
    LOADSECONDLINKFORSINGLEASSOC("LoadSecondLinkForSingleAssoc_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attempt to load a second link for a multiplicity-one object-valued attribute"
     */
    LOADSECONDLINKFORSINGLEATTR("LoadSecondLinkForSingleAttr_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method getLri() of MRI "{0}" returned a null value"
     */
    LRIOFMRINULL("LriOfMriNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0} is no legal argument, only {1} and {2} are allowed"
     */
    NOLEGALARGUMENT("NoLegalArgument_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attempt to call replaceLogicalLinkMultiplicityOne() with a multiplicity-many association end"
     */
    REPLACELOGICALLINKMULTONEWITHMULTASSOCEND("ReplaceLogicalLinkMultOneWithMultAssocEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The specified array is null"
     */
    SPECIFIEDARRAYISNULL("SpecifiedArrayIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Internal error: StandardPri is null, but overflow structure is existing"
     */
    STANDARDPRINULL("StandardPRINull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Number of storage end must be 0 or 1, but was {0}"
     */
    STORAGEENDNUMBERWRONG("StorageEndNumberWrong_XMSG"), //$NON-NLS-1$

    /**
     * Message: "This method should never be called. If so, it is a bug."
     */
    THISMETHODSHOULDNEVERBECALLED("ThisMethodShouldNeverBeCalled_XMSG"), //$NON-NLS-1$

    /**
     * Message: "toIndex = {0}"
     */
    TOINDEX("ToIndex_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreLinksMessages.class );

    private final String myKey;

    private CoreLinksMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreLinksMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
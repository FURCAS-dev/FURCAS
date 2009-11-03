package com.sap.tc.moin.repository.messages.jmi.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CanNotAccessValueOfFeatureWithNameNull_XMSG: Can not access the value of the feature with name "null"</li>
 * <li>CanNotAccessValueOfNonexistingFeature_XMSG: Can not access the value of the feature with the given name. The object {0} does not have a feature with the name "{1}".</li>
 * <li>CanNotInvokeOperationNull_XMSG: Can not invoke operation with name null</li>
 * <li>ElementDeletedButFoundCached_XMSG: Element with the MRI "{0}" has been deleted / evicted, but was still found (and still cached at MRI Reference), Connection: {1}</li>
 * <li>ElementDeletedButFoundNotCached_XMSG: Element with the MRI "{0}" has been deleted / evicted, but was still found (but no longer cached at MRI Reference), Connection: {1}</li>
 * <li>ElementDeleted_XMSG: Element with the MRI "{0}" has been deleted, connection: "{1}"</li>
 * <li>LabelNotInEnum_XMSG: Enumeration {0} has no label with name {1}</li>
 * <li>jmi_base_0003_XMSG: MOF id {0} has already been set and cannot be reassigned to new MOF id {1}</li>
 * <li>jmi_base_0002_XMSG: Meta object is null</li>
 * <li>jmi_base_0006_XMSG: Method {0} to create enumeration types is not supported on a RefBaseObject and has to be overwritten by a derived class</li>
 * <li>ObjectNotEnum_XMSG: Object with name {0} is not an Enumeration</li>
 * <li>AssocNotFound_XMSG: The Association with name {0} was not found</li>
 * <li>ClassNotFound_XMSG: The Class with name {0} was not found</li>
 * <li>PackageNotFound_XMSG: The Package with name {0} was not found</li>
 * <li>jmi_base_0004_XMSG: The element is not yet initialized, the Workspace is null</li>
 * <li>jmi_base_0008_XMSG: The metaObject specified  by name {0} is neither of type AssociationEnd nor Attribute</li>
 * <li>jmi_base_0007_XMSG: The multiplicity's upper bound of this AssociationEnd is 1, but there have been {0} model elements returned</li>
 * <li>UnknownOperation_XMSG: The requested operation is unknown</li>
 * <li>jmi_base_0005_XMSG: Unexpected number of parameters to initialize Structure Type {0}, {1} instead of {2} parameters were passed</li>
 * <li>jmi_base_0001_XMSG: Variable {0} is null</li>
 * <li>RefAllOfClassContainedNull_XMSG: refAllOfClass contained null element for MRI {0}</li>
 * <li>RefAllOfTypeContainedNull_XMSG: refAllOfType contained null element for MRI {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from JmiBase.properties
 */
 
public enum JmiBase implements MoinLocalizedString {


    /**
     * Message: "The Association with name {0} was not found"
     */
    ASSOCNOTFOUND("AssocNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not access the value of the feature with name "null""
     */
    CANNOTACCESSVALUEOFFEATUREWITHNAMENULL("CanNotAccessValueOfFeatureWithNameNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not access the value of the feature with the given name. The object {0} does not have a feature with the name "{1}"."
     */
    CANNOTACCESSVALUEOFNONEXISTINGFEATURE("CanNotAccessValueOfNonexistingFeature_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not invoke operation with name null"
     */
    CANNOTINVOKEOPERATIONNULL("CanNotInvokeOperationNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Class with name {0} was not found"
     */
    CLASSNOTFOUND("ClassNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element with the MRI "{0}" has been deleted / evicted, but was still found (and still cached at MRI Reference), Connection: {1}"
     */
    ELEMENTDELETEDBUTFOUNDCACHED("ElementDeletedButFoundCached_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element with the MRI "{0}" has been deleted / evicted, but was still found (but no longer cached at MRI Reference), Connection: {1}"
     */
    ELEMENTDELETEDBUTFOUNDNOTCACHED("ElementDeletedButFoundNotCached_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element with the MRI "{0}" has been deleted, connection: "{1}""
     */
    ELEMENTDELETED("ElementDeleted_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Enumeration {0} has no label with name {1}"
     */
    LABELNOTINENUM("LabelNotInEnum_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Object with name {0} is not an Enumeration"
     */
    OBJECTNOTENUM("ObjectNotEnum_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Package with name {0} was not found"
     */
    PACKAGENOTFOUND("PackageNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "refAllOfClass contained null element for MRI {0}"
     */
    REFALLOFCLASSCONTAINEDNULL("RefAllOfClassContainedNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "refAllOfType contained null element for MRI {0}"
     */
    REFALLOFTYPECONTAINEDNULL("RefAllOfTypeContainedNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The requested operation is unknown"
     */
    UNKNOWNOPERATION("UnknownOperation_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Variable {0} is null"
     */
    JMI_BASE_0001("jmi_base_0001_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Meta object is null"
     */
    JMI_BASE_0002("jmi_base_0002_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOF id {0} has already been set and cannot be reassigned to new MOF id {1}"
     */
    JMI_BASE_0003("jmi_base_0003_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The element is not yet initialized, the Workspace is null"
     */
    JMI_BASE_0004("jmi_base_0004_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected number of parameters to initialize Structure Type {0}, {1} instead of {2} parameters were passed"
     */
    JMI_BASE_0005("jmi_base_0005_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method {0} to create enumeration types is not supported on a RefBaseObject and has to be overwritten by a derived class"
     */
    JMI_BASE_0006("jmi_base_0006_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The multiplicity's upper bound of this AssociationEnd is 1, but there have been {0} model elements returned"
     */
    JMI_BASE_0007("jmi_base_0007_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metaObject specified  by name {0} is neither of type AssociationEnd nor Attribute"
     */
    JMI_BASE_0008("jmi_base_0008_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( JmiBase.class );

    private final String myKey;

    private JmiBase( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + JmiBase.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
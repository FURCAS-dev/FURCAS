package com.sap.tc.moin.xm.adapter.ie;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>AssociationIncorrectEndName_XMSG: Association "{0}" does not have an end with name "{1}"</li>
 * <li>FieldMissing_XMSG: Field {0} in class {1} missing</li>
 * <li>AttributeNotOnType_XMSG: Model elements of type "{0}" do not have an attribute with name "{1}"</li>
 * <li>NoPackageFor_YMSG: No package found for the path "{0}" in the meta-model container "{1}". Check whether the metamodel is deployed and whether the meta-model container name and the package names are correct.</li>
 * <li>PRINotSet_XMSG: PRI is not set</li>
 * <li>PartitionNotExisting_XMSG: Partition for PRI {0} does not exist</li>
 * <li>QualifiedNameWithoutPackage_XMSG: Qualified name {0} does not have a package part</li>
 * <li>UnsupportedPrimitiveType_XMSG: The attribute {0} has the unsupported primitive type {1}</li>
 * <li>TypeNotFittingToAssocEnd_XMSG: Type "{0}" does not fit to the end "{1}" of the association "{2}"</li>
 * <li>InCorrectAssociationEndName_XMSG: Value "{0}" of the parameter "{1}" is not a valid end name of the association "{2}"</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from XmIeMessages.properties
 */
 
public enum XmIeMessages implements MoinLocalizedString {


    /**
     * Message: "Association "{0}" does not have an end with name "{1}""
     */
    ASSOCIATIONINCORRECTENDNAME("AssociationIncorrectEndName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Model elements of type "{0}" do not have an attribute with name "{1}""
     */
    ATTRIBUTENOTONTYPE("AttributeNotOnType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Field {0} in class {1} missing"
     */
    FIELDMISSING("FieldMissing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Value "{0}" of the parameter "{1}" is not a valid end name of the association "{2}""
     */
    INCORRECTASSOCIATIONENDNAME("InCorrectAssociationEndName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No package found for the path "{0}" in the meta-model container "{1}". Check whether the metamodel is deployed and whether the meta-model container name and the package names are correct."
     */
    NOPACKAGEFOR("NoPackageFor_YMSG"), //$NON-NLS-1$

    /**
     * Message: "PRI is not set"
     */
    PRINOTSET("PRINotSet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition for PRI {0} does not exist"
     */
    PARTITIONNOTEXISTING("PartitionNotExisting_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Qualified name {0} does not have a package part"
     */
    QUALIFIEDNAMEWITHOUTPACKAGE("QualifiedNameWithoutPackage_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type "{0}" does not fit to the end "{1}" of the association "{2}""
     */
    TYPENOTFITTINGTOASSOCEND("TypeNotFittingToAssocEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The attribute {0} has the unsupported primitive type {1}"
     */
    UNSUPPORTEDPRIMITIVETYPE("UnsupportedPrimitiveType_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( XmIeMessages.class );

    private final String myKey;

    private XmIeMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            // $JL-EXC$        
            return "Localization failed for ResourceBundle " + XmIeMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
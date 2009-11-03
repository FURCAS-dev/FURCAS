package com.sap.tc.moin.repository.messages.core;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>UnexpectedExceptionInSaxReader_XMSG: An unexpected Exception encountered in the SAX Reader</li>
 * <li>moin_xmi_1049_XMSG: Bad number format: {0}</li>
 * <li>moin_xmi_1036_XMSG: Cannot set a multi-value to a non-multivalued attribute: {0}</li>
 * <li>moin_xmi_1040_XMSG: Cannot set a multi-value to a non-multivalued reference: {0}</li>
 * <li>moin_xmi_1035_XMSG: Classifier-level attribute value could not be resolved for attribute: {0}</li>
 * <li>moin_xmi_1054_XMSG: Could not add link for association {0} between model elements {1} and {2}</li>
 * <li>CouldNotGetTargetPartitionForOcl_XMSG: Could not determine target partition for the OCL Constraint parser</li>
 * <li>PartitionEvicitonFailed_XMSG: Could not evict partition due to an unexpected Exception</li>
 * <li>moin_xmi_1018_XMSG: Could not obtain InputStream for URI: {0}</li>
 * <li>moin_xmi_1010_XMSG: Could not read the meta object of object {0}</li>
 * <li>CouldNotRetrieveEnumValue_XMSG: Could not retrieve enum value</li>
 * <li>ResolveCrossParitionLinkFailed_XMSG: Cross-partition link could not be resolved due to an unexpected Exception</li>
 * <li>moin_xmi_1013_XMSG: Encountered unsupported type: {0}</li>
 * <li>moin_xmi_1012_XMSG: Exception during feature.refGetValue(name), feature: {0},  name: {1}</li>
 * <li>EvenNumberOfLinkEndsExpected_XMSG: Expected an even number of link ends, but found {0}</li>
 * <li>ExtentWritingNotSupported_XMSG: Extent writing is currently not supported</li>
 * <li>moin_xmi_1060_XMSG: Failed to create model element</li>
 * <li>moin_xmi_1055_XMSG: Failed to create model partition {0}</li>
 * <li>moin_xmi_1059_XMSG: Failed to load mapping table for model partition {0}</li>
 * <li>Failed_To_Load_Metamodel_Package_XMSG: Failed to load metamodel package {0} (container: {1})</li>
 * <li>moin_xmi_1057_XMSG: Failed to load model partition {0}</li>
 * <li>moin_xmi_1056_XMSG: Failed to make partition {0} writable</li>
 * <li>moin_xmi_1069_XMSG: Failed to resolve the model element with the XMI representation {0}</li>
 * <li>moin_xmi_1058_XMSG: Failed to store mapping table for model partition {0}</li>
 * <li>moin_xmi_1044_XMSG: Field {0} in structure {1} is multi-valued</li>
 * <li>moin_xmi_1041_XMSG: Found XML attribute {0} with illegal type: {1}</li>
 * <li>moin_xmi_1053_XMSG: Found duplicate XMI-ID: {0}</li>
 * <li>moin_xmi_1043_XMSG: Found duplicate field in structure: {0}</li>
 * <li>HrefWriteFailed_XMSG: HRef could not be written due to an unexpected Exception</li>
 * <li>moin_xmi_1046_XMSG: Illegal type of structure field: {0}</li>
 * <li>InstanceLoadFailed_XMSG: Instance could not be loaded due to an unexpected Exception</li>
 * <li>InvalidHref_XMSG: Invalid href attribute: {0}</li>
 * <li>InvalidHrefMissingDelim_XMSG: Invalid href attribute: {0} (missing delimiter)</li>
 * <li>moin_xmi_1039_XMSG: Invalid sub-element: {0}</li>
 * <li>LRIResolveFailed_XMSG: LRI could not be resolved due to an unexpected Exception</li>
 * <li>MRIFailure_XMSG: MRI of an object could not be retrieved due to an unexpected Exception</li>
 * <li>moin_xmi_1050_XMSG: Negative values of xmi.position parameters are not supported</li>
 * <li>moin_xmi_1048_XMSG: Nested XMI differences are not supported</li>
 * <li>moin_xmi_1032_XMSG: Not a valid URI: {0}</li>
 * <li>NotAssocEnd_XMSG: Not an AssociationEnd: {0}</li>
 * <li>moin_xmi_1045_XMSG: Structure {0} does not contain a field with name {1}</li>
 * <li>moin_xmi_1005_XMSG: The Collection must not be "null"</li>
 * <li>moin_xmi_1002_XMSG: The ModelPartition must not be "null"</li>
 * <li>moin_xmi_1003_XMSG: The ModelPartition {0} is not assigned to a Workspace</li>
 * <li>moin_xmi_1001_XMSG: The OutputStream must not be "null"</li>
 * <li>moin_xmi_1020_XMSG: The URI must not be "null"</li>
 * <li>moin_xmi_1025_XMSG: The URI of the ModelPartition must not be "null"</li>
 * <li>moin_xmi_1019_XMSG: The Workspace must not be "null"</li>
 * <li>moin_xmi_1006_XMSG: The XMI version must not be "null" or empty</li>
 * <li>moin_xmi_1009_XMSG: The collection entry {0} is not an instance of com.sap.tc.moin.repository.mmi.reflect.RefObject</li>
 * <li>EncodingNotNullOrEmpty_XMSG: The encoding must not be "null" or the empty String</li>
 * <li>moin_xmi_1021_XMSG: The extent must not be "null"</li>
 * <li>moin_xmi_1063_XMSG: The partition {0} does not contain a model element with mapping ID {1} (hint: the XMI document {2} might be outdated)</li>
 * <li>moin_xmi_1015_XMSG: The referenced model element {0} is assigned to its workspace''s no-partition</li>
 * <li>UnresolvedReferencesParam_XMSG: There are still unresolved XMI references: {0}</li>
 * <li>UnresolvedReferences_XMSG: There are still unresolved references</li>
 * <li>moin_xmi_1034_XMSG: Unexpected call of receiveValue()</li>
 * <li>moin_xmi_1037_XMSG: Unexpected element: {0}</li>
 * <li>UnexpectedHrefAttribute_XMSG: Unexpected href attribute</li>
 * <li>moin_xmi_1071_XMSG: Unexpected type of link end: {0}</li>
 * <li>moin_xmi_1033_XMSG: Unrecognized type name: {0}</li>
 * <li>moin_xmi_1065_XMSG: Unsupported Corba type: {0}</li>
 * <li>moin_xmi_1004_XMSG: Unsupported XMI version: {0}</li>
 * <li>moin_xmi_1042_XMSG: Wrong number of fields in structure: {0}</li>
 * <li>XmiIdNotFound_XMSG: XMI Id could not be determined due to an unexpected Exception</li>
 * <li>moin_xmi_1047_XMSG: XMI differences referring to the document they are placed in are not supported</li>
 * <li>moin_xmi_1066_XMSG: XMI.CorbaTcAlias with type {0} is not supported</li>
 * <li>moin_xmi_1067_XMSG: XMI.CorbaTcField with type {0} is not supported</li>
 * <li>moin_xmi_1038_XMSG: XMI.CorbaTypeCode element expected for XML tag: {0}</li>
 * <li>moin_xmi_1073_XMSG: {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from XMI.properties
 */
 
public enum XMI implements MoinLocalizedString {


    /**
     * Message: "Could not determine target partition for the OCL Constraint parser"
     */
    COULDNOTGETTARGETPARTITIONFOROCL("CouldNotGetTargetPartitionForOcl_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not retrieve enum value"
     */
    COULDNOTRETRIEVEENUMVALUE("CouldNotRetrieveEnumValue_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The encoding must not be "null" or the empty String"
     */
    ENCODINGNOTNULLOREMPTY("EncodingNotNullOrEmpty_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Expected an even number of link ends, but found {0}"
     */
    EVENNUMBEROFLINKENDSEXPECTED("EvenNumberOfLinkEndsExpected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Extent writing is currently not supported"
     */
    EXTENTWRITINGNOTSUPPORTED("ExtentWritingNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to load metamodel package {0} (container: {1})"
     */
    FAILED_TO_LOAD_METAMODEL_PACKAGE("Failed_To_Load_Metamodel_Package_XMSG"), //$NON-NLS-1$

    /**
     * Message: "HRef could not be written due to an unexpected Exception"
     */
    HREFWRITEFAILED("HrefWriteFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Instance could not be loaded due to an unexpected Exception"
     */
    INSTANCELOADFAILED("InstanceLoadFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid href attribute: {0} (missing delimiter)"
     */
    INVALIDHREFMISSINGDELIM("InvalidHrefMissingDelim_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid href attribute: {0}"
     */
    INVALIDHREF("InvalidHref_XMSG"), //$NON-NLS-1$

    /**
     * Message: "LRI could not be resolved due to an unexpected Exception"
     */
    LRIRESOLVEFAILED("LRIResolveFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MRI of an object could not be retrieved due to an unexpected Exception"
     */
    MRIFAILURE("MRIFailure_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Not an AssociationEnd: {0}"
     */
    NOTASSOCEND("NotAssocEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not evict partition due to an unexpected Exception"
     */
    PARTITIONEVICITONFAILED("PartitionEvicitonFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cross-partition link could not be resolved due to an unexpected Exception"
     */
    RESOLVECROSSPARITIONLINKFAILED("ResolveCrossParitionLinkFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An unexpected Exception encountered in the SAX Reader"
     */
    UNEXPECTEDEXCEPTIONINSAXREADER("UnexpectedExceptionInSaxReader_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected href attribute"
     */
    UNEXPECTEDHREFATTRIBUTE("UnexpectedHrefAttribute_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There are still unresolved XMI references: {0}"
     */
    UNRESOLVEDREFERENCESPARAM("UnresolvedReferencesParam_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There are still unresolved references"
     */
    UNRESOLVEDREFERENCES("UnresolvedReferences_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XMI Id could not be determined due to an unexpected Exception"
     */
    XMIIDNOTFOUND("XmiIdNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OutputStream must not be "null""
     */
    MOIN_XMI_1001("moin_xmi_1001_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The ModelPartition must not be "null""
     */
    MOIN_XMI_1002("moin_xmi_1002_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The ModelPartition {0} is not assigned to a Workspace"
     */
    MOIN_XMI_1003("moin_xmi_1003_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unsupported XMI version: {0}"
     */
    MOIN_XMI_1004("moin_xmi_1004_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Collection must not be "null""
     */
    MOIN_XMI_1005("moin_xmi_1005_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The XMI version must not be "null" or empty"
     */
    MOIN_XMI_1006("moin_xmi_1006_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The extent must not be "null""
     */
    MOIN_XMI_1008("moin_xmi_1008_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The collection entry {0} is not an instance of com.sap.tc.moin.repository.mmi.reflect.RefObject"
     */
    MOIN_XMI_1009("moin_xmi_1009_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not read the meta object of object {0}"
     */
    MOIN_XMI_1010("moin_xmi_1010_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception during feature.refGetValue(name), feature: {0},  name: {1}"
     */
    MOIN_XMI_1012("moin_xmi_1012_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Encountered unsupported type: {0}"
     */
    MOIN_XMI_1013("moin_xmi_1013_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The referenced model element {0} is assigned to its workspace''s no-partition"
     */
    MOIN_XMI_1015("moin_xmi_1015_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not obtain InputStream for URI: {0}"
     */
    MOIN_XMI_1018("moin_xmi_1018_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Workspace must not be "null""
     */
    MOIN_XMI_1019("moin_xmi_1019_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The URI must not be "null""
     */
    MOIN_XMI_1020("moin_xmi_1020_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The extent must not be "null""
     */
    MOIN_XMI_1021("moin_xmi_1021_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The URI of the ModelPartition must not be "null""
     */
    MOIN_XMI_1025("moin_xmi_1025_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Not a valid URI: {0}"
     */
    MOIN_XMI_1032("moin_xmi_1032_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unrecognized type name: {0}"
     */
    MOIN_XMI_1033("moin_xmi_1033_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected call of receiveValue()"
     */
    MOIN_XMI_1034("moin_xmi_1034_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Classifier-level attribute value could not be resolved for attribute: {0}"
     */
    MOIN_XMI_1035("moin_xmi_1035_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot set a multi-value to a non-multivalued attribute: {0}"
     */
    MOIN_XMI_1036("moin_xmi_1036_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected element: {0}"
     */
    MOIN_XMI_1037("moin_xmi_1037_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XMI.CorbaTypeCode element expected for XML tag: {0}"
     */
    MOIN_XMI_1038("moin_xmi_1038_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid sub-element: {0}"
     */
    MOIN_XMI_1039("moin_xmi_1039_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot set a multi-value to a non-multivalued reference: {0}"
     */
    MOIN_XMI_1040("moin_xmi_1040_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Found XML attribute {0} with illegal type: {1}"
     */
    MOIN_XMI_1041("moin_xmi_1041_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Wrong number of fields in structure: {0}"
     */
    MOIN_XMI_1042("moin_xmi_1042_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Found duplicate field in structure: {0}"
     */
    MOIN_XMI_1043("moin_xmi_1043_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Field {0} in structure {1} is multi-valued"
     */
    MOIN_XMI_1044("moin_xmi_1044_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Structure {0} does not contain a field with name {1}"
     */
    MOIN_XMI_1045("moin_xmi_1045_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal type of structure field: {0}"
     */
    MOIN_XMI_1046("moin_xmi_1046_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XMI differences referring to the document they are placed in are not supported"
     */
    MOIN_XMI_1047("moin_xmi_1047_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Nested XMI differences are not supported"
     */
    MOIN_XMI_1048("moin_xmi_1048_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Bad number format: {0}"
     */
    MOIN_XMI_1049("moin_xmi_1049_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Negative values of xmi.position parameters are not supported"
     */
    MOIN_XMI_1050("moin_xmi_1050_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Found duplicate XMI-ID: {0}"
     */
    MOIN_XMI_1053("moin_xmi_1053_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not add link for association {0} between model elements {1} and {2}"
     */
    MOIN_XMI_1054("moin_xmi_1054_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to create model partition {0}"
     */
    MOIN_XMI_1055("moin_xmi_1055_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to make partition {0} writable"
     */
    MOIN_XMI_1056("moin_xmi_1056_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to load model partition {0}"
     */
    MOIN_XMI_1057("moin_xmi_1057_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to store mapping table for model partition {0}"
     */
    MOIN_XMI_1058("moin_xmi_1058_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to load mapping table for model partition {0}"
     */
    MOIN_XMI_1059("moin_xmi_1059_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to create model element"
     */
    MOIN_XMI_1060("moin_xmi_1060_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The partition {0} does not contain a model element with mapping ID {1} (hint: the XMI document {2} might be outdated)"
     */
    MOIN_XMI_1063("moin_xmi_1063_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unsupported Corba type: {0}"
     */
    MOIN_XMI_1065("moin_xmi_1065_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XMI.CorbaTcAlias with type {0} is not supported"
     */
    MOIN_XMI_1066("moin_xmi_1066_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XMI.CorbaTcField with type {0} is not supported"
     */
    MOIN_XMI_1067("moin_xmi_1067_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to resolve the model element with the XMI representation {0}"
     */
    MOIN_XMI_1069("moin_xmi_1069_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected type of link end: {0}"
     */
    MOIN_XMI_1071("moin_xmi_1071_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0}"
     */
    MOIN_XMI_1073("moin_xmi_1073_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( XMI.class );

    private final String myKey;

    private XMI( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + XMI.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
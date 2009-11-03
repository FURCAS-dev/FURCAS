package com.sap.tc.moin.repository.jmigenerator;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>MofConstraintRegistryNotFound_XMSG: Can not check OCL constraints. The MOF constraints registry can not be found.</li>
 * <li>OclRegistryServiceNotFound_XMSG: Can not check OCL constraints. The OCL registry service can not be found.</li>
 * <li>CannotCreateWrapper_XMSG: Can not create Generator wrapper for model element {0}</li>
 * <li>ConsistencyCheckTimer_XMSG: Consistency checks</li>
 * <li>ConsistencyChecksFinished_XMSG: Consistency checks finished</li>
 * <li>CouldNotParseOcl_XMSG: Could not parse the OCL Expression: "{0}"</li>
 * <li>DcNameNotSpecified_XMSG: DC Name is not specified</li>
 * <li>DCVendorNotSpecified_XMSG: DC Vendor is not specified</li>
 * <li>NullEndInAssocationFound_XMSG: Either end0 or end1 of association {0} is null</li>
 * <li>ExceptionGettingClassNameResolver_XMSG: Exception when trying to get the Class Name Resolver</li>
 * <li>ExceptionGettingDeploymentExtension_XMSG: Exception when trying to get the Deployment Extensions</li>
 * <li>ExceptionGettingGeneratorWrapper_XMSG: Exception when trying to get the generator wrapper instance</li>
 * <li>ExceptionGettingGeneratorImpl_XMSG: Exception when trying to obtain the generator implementation</li>
 * <li>GenerateJmiTimer_XMSG: Generating JMI</li>
 * <li>JmiOutput_XMSG: JMI output destination: {0}</li>
 * <li>UnsupportedMofType_XMSG: MOF Type not supported: {0}</li>
 * <li>MMLoadedTimer_XMSG: Meta-Model loaded</li>
 * <li>MMConstainterNotSpecified_XMSG: MetaModelContainer attribute is not specified</li>
 * <li>MoreThanOneAssocEndInAssoc_XMSG: More than one association end found contained in association</li>
 * <li>MultipleExtentsFound_XMSG: More than one extent found for qualified name {0}</li>
 * <li>MultipleMetaModelLocalizationPropFiles_xmsg: Multiple MetaModelLocalization.properties files found: {0}</li>
 * <li>NameCheckTimer_XMSG: Name checks</li>
 * <li>NameChecksFinished_XMSG: Name checks finished</li>
 * <li>NameOfV2PropertiesFileNotSpecified_XMSG: Name of the moin archive properties file is not specified</li>
 * <li>NameOfPropertiesFileNotSpecified_XMSG: Name of the properties file is not specified</li>
 * <li>NoJavaClassName_XMSG: No Java Class name could be generated for object {0}</li>
 * <li>NoConsistencyViolationsFound_XMSG: No consistency violations found</li>
 * <li>NoConstraintViolationsFound_XMSG: No constraint violations found</li>
 * <li>OclConstraintCheckTimer_XMSG: OCL constraint checks</li>
 * <li>OclConstraintChecksFinished_XMSG: OCL constraint checks finished</li>
 * <li>GetEndNumberOfToEndNotSupported_XMSG: Operation "getEndNumberOfToEnd" not supported for derived features</li>
 * <li>PartitionNotFound_XMSG: Partition "{0}" not found</li>
 * <li>PropertyNotDefinedInFile_XMSG: Property "{0}" is not defined in file "{0}"</li>
 * <li>PropertyDiffersInFileAndBuild_XMSG: Property "{0}" value "{1}" in file "{2}" differs to DC definition key "{3}" value "{4}"</li>
 * <li>RefStructureNotHandledYet_XMSG: RefStructure {0} not handled yet</li>
 * <li>StartingOclConstraintChecks_XMSG: Starting OCL constraint checks</li>
 * <li>StartingConsistencyChecks_XMSG: Starting consistency checks</li>
 * <li>StartingNameChecks_XMSG: Starting name checks</li>
 * <li>OclParserNotAvailable_XMSG: The OCL Parser could not be obtained</li>
 * <li>NullForMandatoryAttribute_XMSG: The mandatory attribute {0} of RefObject {1} was null</li>
 * <li>UnhandledValueType_XMSG: Unhandled value type: {0}</li>
 * <li>UnknownType_XMSG: Unknown type</li>
 * <li>UnsupportedPropertyValueInFile_XMSG: Unsupported value "{0}" for property "{1}" in file "{2}"</li>
 * <li>VisibilityDefaulted_XMSG: Visibility of the feature "{0}" was defaulted to "public"</li>
 * <li>XmiDirNotSpecified_XMSG: XMI Directory is not specified</li>
 * <li>XmiListNotSpecified_XMSG: XMI list is not specified</li>
 * <li>MEViolationMessagePattern_XMSG: {0}, offending Model Element: "{1}" (MofID: "{2}")</li>
 * <li>ViolationMessagePattern_XMSG: {0}, offending MofID: {1}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from JmiGeneratorTraces.properties
 */
 
public enum JmiGeneratorTraces implements MoinLocalizedString {


    /**
     * Message: "Can not create Generator wrapper for model element {0}"
     */
    CANNOTCREATEWRAPPER("CannotCreateWrapper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Consistency checks"
     */
    CONSISTENCYCHECKTIMER("ConsistencyCheckTimer_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Consistency checks finished"
     */
    CONSISTENCYCHECKSFINISHED("ConsistencyChecksFinished_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not parse the OCL Expression: "{0}""
     */
    COULDNOTPARSEOCL("CouldNotParseOcl_XMSG"), //$NON-NLS-1$

    /**
     * Message: "DC Vendor is not specified"
     */
    DCVENDORNOTSPECIFIED("DCVendorNotSpecified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "DC Name is not specified"
     */
    DCNAMENOTSPECIFIED("DcNameNotSpecified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception when trying to get the Class Name Resolver"
     */
    EXCEPTIONGETTINGCLASSNAMERESOLVER("ExceptionGettingClassNameResolver_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception when trying to get the Deployment Extensions"
     */
    EXCEPTIONGETTINGDEPLOYMENTEXTENSION("ExceptionGettingDeploymentExtension_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception when trying to obtain the generator implementation"
     */
    EXCEPTIONGETTINGGENERATORIMPL("ExceptionGettingGeneratorImpl_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception when trying to get the generator wrapper instance"
     */
    EXCEPTIONGETTINGGENERATORWRAPPER("ExceptionGettingGeneratorWrapper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Generating JMI"
     */
    GENERATEJMITIMER("GenerateJmiTimer_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "getEndNumberOfToEnd" not supported for derived features"
     */
    GETENDNUMBEROFTOENDNOTSUPPORTED("GetEndNumberOfToEndNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "JMI output destination: {0}"
     */
    JMIOUTPUT("JmiOutput_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0}, offending Model Element: "{1}" (MofID: "{2}")"
     */
    MEVIOLATIONMESSAGEPATTERN("MEViolationMessagePattern_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MetaModelContainer attribute is not specified"
     */
    MMCONSTAINTERNOTSPECIFIED("MMConstainterNotSpecified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Meta-Model loaded"
     */
    MMLOADEDTIMER("MMLoadedTimer_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not check OCL constraints. The MOF constraints registry can not be found."
     */
    MOFCONSTRAINTREGISTRYNOTFOUND("MofConstraintRegistryNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "More than one association end found contained in association"
     */
    MORETHANONEASSOCENDINASSOC("MoreThanOneAssocEndInAssoc_XMSG"), //$NON-NLS-1$

    /**
     * Message: "More than one extent found for qualified name {0}"
     */
    MULTIPLEEXTENTSFOUND("MultipleExtentsFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Multiple MetaModelLocalization.properties files found: {0}"
     */
    MULTIPLEMETAMODELLOCALIZATIONPROPFILES("MultipleMetaModelLocalizationPropFiles_xmsg"), //$NON-NLS-1$

    /**
     * Message: "Name checks"
     */
    NAMECHECKTIMER("NameCheckTimer_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Name checks finished"
     */
    NAMECHECKSFINISHED("NameChecksFinished_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Name of the properties file is not specified"
     */
    NAMEOFPROPERTIESFILENOTSPECIFIED("NameOfPropertiesFileNotSpecified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Name of the moin archive properties file is not specified"
     */
    NAMEOFV2PROPERTIESFILENOTSPECIFIED("NameOfV2PropertiesFileNotSpecified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No consistency violations found"
     */
    NOCONSISTENCYVIOLATIONSFOUND("NoConsistencyViolationsFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No constraint violations found"
     */
    NOCONSTRAINTVIOLATIONSFOUND("NoConstraintViolationsFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No Java Class name could be generated for object {0}"
     */
    NOJAVACLASSNAME("NoJavaClassName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Either end0 or end1 of association {0} is null"
     */
    NULLENDINASSOCATIONFOUND("NullEndInAssocationFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The mandatory attribute {0} of RefObject {1} was null"
     */
    NULLFORMANDATORYATTRIBUTE("NullForMandatoryAttribute_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OCL constraint checks"
     */
    OCLCONSTRAINTCHECKTIMER("OclConstraintCheckTimer_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OCL constraint checks finished"
     */
    OCLCONSTRAINTCHECKSFINISHED("OclConstraintChecksFinished_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL Parser could not be obtained"
     */
    OCLPARSERNOTAVAILABLE("OclParserNotAvailable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not check OCL constraints. The OCL registry service can not be found."
     */
    OCLREGISTRYSERVICENOTFOUND("OclRegistryServiceNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition "{0}" not found"
     */
    PARTITIONNOTFOUND("PartitionNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Property "{0}" value "{1}" in file "{2}" differs to DC definition key "{3}" value "{4}""
     */
    PROPERTYDIFFERSINFILEANDBUILD("PropertyDiffersInFileAndBuild_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Property "{0}" is not defined in file "{0}""
     */
    PROPERTYNOTDEFINEDINFILE("PropertyNotDefinedInFile_XMSG"), //$NON-NLS-1$

    /**
     * Message: "RefStructure {0} not handled yet"
     */
    REFSTRUCTURENOTHANDLEDYET("RefStructureNotHandledYet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Starting consistency checks"
     */
    STARTINGCONSISTENCYCHECKS("StartingConsistencyChecks_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Starting name checks"
     */
    STARTINGNAMECHECKS("StartingNameChecks_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Starting OCL constraint checks"
     */
    STARTINGOCLCONSTRAINTCHECKS("StartingOclConstraintChecks_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unhandled value type: {0}"
     */
    UNHANDLEDVALUETYPE("UnhandledValueType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unknown type"
     */
    UNKNOWNTYPE("UnknownType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOF Type not supported: {0}"
     */
    UNSUPPORTEDMOFTYPE("UnsupportedMofType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unsupported value "{0}" for property "{1}" in file "{2}""
     */
    UNSUPPORTEDPROPERTYVALUEINFILE("UnsupportedPropertyValueInFile_XMSG"), //$NON-NLS-1$

    /**
     * Message: "{0}, offending MofID: {1}"
     */
    VIOLATIONMESSAGEPATTERN("ViolationMessagePattern_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Visibility of the feature "{0}" was defaulted to "public""
     */
    VISIBILITYDEFAULTED("VisibilityDefaulted_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XMI Directory is not specified"
     */
    XMIDIRNOTSPECIFIED("XmiDirNotSpecified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XMI list is not specified"
     */
    XMILISTNOTSPECIFIED("XmiListNotSpecified_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( JmiGeneratorTraces.class );

    private final String myKey;

    private JmiGeneratorTraces( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + JmiGeneratorTraces.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
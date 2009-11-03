package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>NotYetRetrievedLinkMethod_XMSG: Attempt to call a method on the NOT_YET_RETRIEVED link</li>
 * <li>CompareWrapperWithCore_XMSG: Attempt to compare a JMI wrapper and an unwrapped JMI object via equals()</li>
 * <li>AttributeOrRefNotFoundInExtent_XMSG: Attribute or Reference "{0}" could not be found at extent "{1}"</li>
 * <li>UNABLE_TO_INVOKE_OPERATION_WITH_ID_XMSG: Can not invoke the operation with the given ID: The class '{0}' does not have an operation with the ID '{1}'</li>
 * <li>UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_ID_XMSG: Can not set the value of the feature with the given ID: The class '{0}' does not have a feature with the ID '{1}'</li>
 * <li>UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_NAME_XMSG: Can not set the value of the feature with the given name: The class '{0}' does not have a feature with the name '{1}'</li>
 * <li>OperationWithIdNotInClass_XMSG: Class "{0}" does not have an operation with ID {1}</li>
 * <li>ClassNotSuperclass_XMSG: Class "{0}" is not a superclass of "{1}"</li>
 * <li>AttributeOrAssocEndNotFoundForName_XMSG: Couldn't get Attribute or AssociationEnd for name "{0}"</li>
 * <li>EndNumberMustBeZeroOrOne_XMSG: End number must be 0 or 1</li>
 * <li>RefQueryWithoutConnectionIsNotSupported_XMSG: Execution of "refQuery" without connection is not supported</li>
 * <li>FeatureNotFound_XMSG: Feature "{0}" does not exist</li>
 * <li>FeatureOfClassNotChangeable_XMSG: Feature "{0}" of class "{1]" is not changeable</li>
 * <li>ScopeKindNotChangeable_XMSG: Feature "{0}" of class "{1}" has scope kind "{2}". MOIN does not allow the change of attributes with a scope kind other than "instance_level".</li>
 * <li>MultiValuedAttributeNotSettable_XMSG: Feature "{0}" of class "{1}" is a multi-valued Attribute, multi-valued Attributes can not be set as a whole.</li>
 * <li>MultiValuedReferenceNotSettable_XMSG: Feature "{0}" of class "{1}" is a multi-valued Reference, multi-valued References can not be set as a whole.</li>
 * <li>FeatureTypeExpected_XMSG: Feature "{0}" of class "{1}" must be of type "{2}"</li>
 * <li>FeatureTypeMismatch_XMSG: Feature "{0}" of class "{1}" must be of type "{2}" but is of type "{3}"</li>
 * <li>ImplementationClassDoesNotOverrideThisMethod_XMSG: Implementation class does not override this method, should be the case for derived association</li>
 * <li>Index_XMSG: Index: {0}</li>
 * <li>NotPossibleToCreateInstancesOfThisClass_XMSG: It is not possible to create instances of this class as it is abstract -- at least it will be abstract in the future</li>
 * <li>MethodNotSupportedForDerivedAssocation_XMSG: Method not supported for derived assocation {0}</li>
 * <li>NotPossibleToCallThisMethod_XMSG: Not possible to call this method on {0}</li>
 * <li>NotSupported_ThereIsNoOperation_XMSG: Not supported, there is no operation which could be called</li>
 * <li>OnlyDeletionOfRefObjectIsPossible_XMSG: Only deletion of RefObject is possible. This instance is of type {0}</li>
 * <li>OperationNotFound_XMSG: Operation "{0}" not found</li>
 * <li>SessionIsNullButElementIsNotInMetamodelPartition_XMSG: Session is null, but element {0} is not in a metamodel partition</li>
 * <li>DeletionOfPackagesNotSupported_XMSG: The deletion of packages is currently not supported</li>
 * <li>ThereIsNoExtentToBeCreatedAlreadyDoneByMOFROM_XMSG: There is no extent to be created, because that it is already done by the MOF ROM</li>
 * <li>WorksapceAlreadySet_XMSG: Workspace has already been set</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from JmiReflectMessages.properties
 */
 
public enum JmiReflectMessages implements MoinLocalizedString {


    /**
     * Message: "Couldn't get Attribute or AssociationEnd for name "{0}""
     */
    ATTRIBUTEORASSOCENDNOTFOUNDFORNAME("AttributeOrAssocEndNotFoundForName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attribute or Reference "{0}" could not be found at extent "{1}""
     */
    ATTRIBUTEORREFNOTFOUNDINEXTENT("AttributeOrRefNotFoundInExtent_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Class "{0}" is not a superclass of "{1}""
     */
    CLASSNOTSUPERCLASS("ClassNotSuperclass_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attempt to compare a JMI wrapper and an unwrapped JMI object via equals()"
     */
    COMPAREWRAPPERWITHCORE("CompareWrapperWithCore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The deletion of packages is currently not supported"
     */
    DELETIONOFPACKAGESNOTSUPPORTED("DeletionOfPackagesNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "End number must be 0 or 1"
     */
    ENDNUMBERMUSTBEZEROORONE("EndNumberMustBeZeroOrOne_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" does not exist"
     */
    FEATURENOTFOUND("FeatureNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" of class "{1]" is not changeable"
     */
    FEATUREOFCLASSNOTCHANGEABLE("FeatureOfClassNotChangeable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" of class "{1}" must be of type "{2}""
     */
    FEATURETYPEEXPECTED("FeatureTypeExpected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" of class "{1}" must be of type "{2}" but is of type "{3}""
     */
    FEATURETYPEMISMATCH("FeatureTypeMismatch_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Implementation class does not override this method, should be the case for derived association"
     */
    IMPLEMENTATIONCLASSDOESNOTOVERRIDETHISMETHOD("ImplementationClassDoesNotOverrideThisMethod_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Index: {0}"
     */
    INDEX("Index_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method not supported for derived assocation {0}"
     */
    METHODNOTSUPPORTEDFORDERIVEDASSOCATION("MethodNotSupportedForDerivedAssocation_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" of class "{1}" is a multi-valued Attribute, multi-valued Attributes can not be set as a whole."
     */
    MULTIVALUEDATTRIBUTENOTSETTABLE("MultiValuedAttributeNotSettable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" of class "{1}" is a multi-valued Reference, multi-valued References can not be set as a whole."
     */
    MULTIVALUEDREFERENCENOTSETTABLE("MultiValuedReferenceNotSettable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Not possible to call this method on {0}"
     */
    NOTPOSSIBLETOCALLTHISMETHOD("NotPossibleToCallThisMethod_XMSG"), //$NON-NLS-1$

    /**
     * Message: "It is not possible to create instances of this class as it is abstract -- at least it will be abstract in the future"
     */
    NOTPOSSIBLETOCREATEINSTANCESOFTHISCLASS("NotPossibleToCreateInstancesOfThisClass_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Not supported, there is no operation which could be called"
     */
    NOTSUPPORTED_THEREISNOOPERATION("NotSupported_ThereIsNoOperation_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attempt to call a method on the NOT_YET_RETRIEVED link"
     */
    NOTYETRETRIEVEDLINKMETHOD("NotYetRetrievedLinkMethod_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only deletion of RefObject is possible. This instance is of type {0}"
     */
    ONLYDELETIONOFREFOBJECTISPOSSIBLE("OnlyDeletionOfRefObjectIsPossible_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "{0}" not found"
     */
    OPERATIONNOTFOUND("OperationNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Class "{0}" does not have an operation with ID {1}"
     */
    OPERATIONWITHIDNOTINCLASS("OperationWithIdNotInClass_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Execution of "refQuery" without connection is not supported"
     */
    REFQUERYWITHOUTCONNECTIONISNOTSUPPORTED("RefQueryWithoutConnectionIsNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Feature "{0}" of class "{1}" has scope kind "{2}". MOIN does not allow the change of attributes with a scope kind other than "instance_level"."
     */
    SCOPEKINDNOTCHANGEABLE("ScopeKindNotChangeable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Session is null, but element {0} is not in a metamodel partition"
     */
    SESSIONISNULLBUTELEMENTISNOTINMETAMODELPARTITION("SessionIsNullButElementIsNotInMetamodelPartition_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There is no extent to be created, because that it is already done by the MOF ROM"
     */
    THEREISNOEXTENTTOBECREATEDALREADYDONEBYMOFROM("ThereIsNoExtentToBeCreatedAlreadyDoneByMOFROM_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not invoke the operation with the given ID: The class '{0}' does not have an operation with the ID '{1}'"
     */
    UNABLE_TO_INVOKE_OPERATION_WITH_ID("UNABLE_TO_INVOKE_OPERATION_WITH_ID_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not set the value of the feature with the given ID: The class '{0}' does not have a feature with the ID '{1}'"
     */
    UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_ID("UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_ID_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not set the value of the feature with the given name: The class '{0}' does not have a feature with the name '{1}'"
     */
    UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_NAME("UNABLE_TO_SET_VALUE_OF_FEATURE_WITH_NAME_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Workspace has already been set"
     */
    WORKSAPCEALREADYSET("WorksapceAlreadySet_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( JmiReflectMessages.class );

    private final String myKey;

    private JmiReflectMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + JmiReflectMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
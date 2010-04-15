package com.sap.tc.moin.ocl.utils.localization;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>OclEvalRtEx_XMSG: A RuntimeExeption was thrown in the OCL evaluator, exception message: {0}</li>
 * <li>ContextAttachReport_XMSG: A context couldn&#039;&#039;t be attached, root cause:&#092;n {0}</li>
 * <li>RegistrationExists_XMSG: A registration with name "{0}" exists already</li>
 * <li>InvalidValueException_XMSG: An OCL Runtime Error occured because an invalid value was encountered</li>
 * <li>ArrowExpected_XMSG: Arrow expected</li>
 * <li>MustProvideCategory_XMSG: At least one category must provided</li>
 * <li>BodyExprTagsMustBeAttached_XMSG: Body expression tags must be attached to at least one operation</li>
 * <li>CanNotRegisterDeferredListenerOnImmediateCategory_XMSG: Can not register a deferred listener on the immediate category</li>
 * <li>CanNotRegisterListenersForImmediateCategory_XMSG: Can not register listeners for the immediate category here explicitly</li>
 * <li>ConstraintNotFoundInRegistry_XMSG: Constraint "{0}" was not found in the registry</li>
 * <li>OnlyOCLAndOCLInitAsLangu_XMSG: Constraint "{0}": Language "{1}" not supported, only "OCL" and "OCLInit" are allowed</li>
 * <li>OnlyAttribInitForLangOclInit_XMSG: Constraint "{0}": Only attribute initializers are supported for Language "OCLInit"</li>
 * <li>OnlyInvForOCL_XMSG: Constraint "{0}": only invariants are supported for Language "OCL"</li>
 * <li>EmptyExpressionNotParsable_XMSG: Constraint "{0}": the expression is null or empty and can not be parsed </li>
 * <li>CouldNotDetermineTargetPartition_XMSG: Could not determine target partition</li>
 * <li>ExceptionParsingExpr_XMSG: Exception while parsing Expression "{0}"</li>
 * <li>OrphanSubExpression_XMSG: Found an orphan sub expression; this is a bug in the Impact Analyzer</li>
 * <li>IteratorExpExpected_XMSG: Iterator Expression expected</li>
 * <li>JmiCreatinHelpers_XMSG: JMI Exception while creating OCL helper operations</li>
 * <li>NoRegistrationsFound_XMSG: No registrations could be found</li>
 * <li>NoRegistrationsForCat_XMSG: No registrations found for category "{0}"</li>
 * <li>NoStmtsForCategory_XMSG: No statements found for category "{0}" (constrainedElements may be empty)</li>
 * <li>NoValidCategory_XMSG: No valid category was provided, please specify at least one of "immediate" or "deferred"</li>
 * <li>NoVisitorForClass_XMSG: No visitor method defined for class "{0}"</li>
 * <li>InvMustEvalToBoolean_XMSG: OCL Invariants must evaluate to Boolean</li>
 * <li>OnlyAttAndStructInit_XMSG: Only Attributes and Structure Fields can be initialized</li>
 * <li>PrimitiveInitOnly_XMSG: Only Primitive-typed Structure Fields can be initialized</li>
 * <li>BodyExprOnly_XMSG: Only body expressions are allowed here</li>
 * <li>OpNotFound_XMSG: Operation {0} could not be found for class {1}</li>
 * <li>RevNavNotSupported_XMSG: Reverse navigation is not supported for class "{0}"</li>
 * <li>ExpressionNotParsable_XMSG: The Expression "{0}" could not be parsed</li>
 * <li>ExpEvaluatesToUndefined_XMSG: The Expression evaluates to OclUdnefined</li>
 * <li>MofConstraintsNotFound_XMSG: The MOF constraints could not be found</li>
 * <li>OclBodyNotFound_XMSG: The OCL Body expression for operation "{0}" of class "{1}" could not be found</li>
 * <li>OclEvalStackOverflow_XMSG: The OCL Evaluator stack has reached a size of {0} probably due to some recursion</li>
 * <li>OclExprDoesNotEvaluateToExpr_XMSG: The OCL Expression does not evaluate to a statement of type "expression"</li>
 * <li>OclExprDoesNotEvaluateToInv_XMSG: The OCL Expression does not evaluate to a statement of type "invariant"</li>
 * <li>MustParseToOne_XMSG: The OCL Expression for registration "{0}" must parse to exactly one statement, but evaluates to {1} statements; Expression: {2}</li>
 * <li>OclRegistryNotAvailable_XMSG: The OCL Registry is not available</li>
 * <li>OpMarkedHelperNoBody_XMSG: The Operation "{0}" is marked as Ocl Helper operation but has no body attached; Impact Analysis can not continue</li>
 * <li>ConstrainedTypeIncompatible_XMSG: The constrained element type "{0}" is not compatible with the context declaration type "{1}"</li>
 * <li>NotAMofClass_XMSG: The object is not a MofClass</li>
 * <li>ExceptionCreatingHelper_XMSG: Unexpected Exception while creating helper operations</li>
 * <li>ExceptionWhileVerifyConstraints_XMSG: Unexpected Exception while verifying constraints</li>
 * <li>UseRegisterEventBasedMethod_XMSG: Use an event based listener registration method</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from OclServiceExceptions.properties
 */
 
public enum OclServiceExceptions implements MoinLocalizedString {


    /**
     * Message: "Arrow expected"
     */
    ARROWEXPECTED("ArrowExpected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only body expressions are allowed here"
     */
    BODYEXPRONLY("BodyExprOnly_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Body expression tags must be attached to at least one operation"
     */
    BODYEXPRTAGSMUSTBEATTACHED("BodyExprTagsMustBeAttached_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not register a deferred listener on the immediate category"
     */
    CANNOTREGISTERDEFERREDLISTENERONIMMEDIATECATEGORY("CanNotRegisterDeferredListenerOnImmediateCategory_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not register listeners for the immediate category here explicitly"
     */
    CANNOTREGISTERLISTENERSFORIMMEDIATECATEGORY("CanNotRegisterListenersForImmediateCategory_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The constrained element type "{0}" is not compatible with the context declaration type "{1}""
     */
    CONSTRAINEDTYPEINCOMPATIBLE("ConstrainedTypeIncompatible_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraint "{0}" was not found in the registry"
     */
    CONSTRAINTNOTFOUNDINREGISTRY("ConstraintNotFoundInRegistry_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A context couldn&#039;&#039;t be attached, root cause:&#092;n {0}"
     */
    CONTEXTATTACHREPORT("ContextAttachReport_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not determine target partition"
     */
    COULDNOTDETERMINETARGETPARTITION("CouldNotDetermineTargetPartition_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraint "{0}": the expression is null or empty and can not be parsed "
     */
    EMPTYEXPRESSIONNOTPARSABLE("EmptyExpressionNotParsable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected Exception while creating helper operations"
     */
    EXCEPTIONCREATINGHELPER("ExceptionCreatingHelper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception while parsing Expression "{0}""
     */
    EXCEPTIONPARSINGEXPR("ExceptionParsingExpr_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected Exception while verifying constraints"
     */
    EXCEPTIONWHILEVERIFYCONSTRAINTS("ExceptionWhileVerifyConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Expression evaluates to OclUdnefined"
     */
    EXPEVALUATESTOUNDEFINED("ExpEvaluatesToUndefined_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Expression "{0}" could not be parsed"
     */
    EXPRESSIONNOTPARSABLE("ExpressionNotParsable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OCL Invariants must evaluate to Boolean"
     */
    INVMUSTEVALTOBOOLEAN("InvMustEvalToBoolean_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An OCL Runtime Error occured because an invalid value was encountered"
     */
    INVALIDVALUEEXCEPTION("InvalidValueException_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator Expression expected"
     */
    ITERATOREXPEXPECTED("IteratorExpExpected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "JMI Exception while creating OCL helper operations"
     */
    JMICREATINHELPERS("JmiCreatinHelpers_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The MOF constraints could not be found"
     */
    MOFCONSTRAINTSNOTFOUND("MofConstraintsNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL Expression for registration "{0}" must parse to exactly one statement, but evaluates to {1} statements; Expression: {2}"
     */
    MUSTPARSETOONE("MustParseToOne_XMSG"), //$NON-NLS-1$

    /**
     * Message: "At least one category must provided"
     */
    MUSTPROVIDECATEGORY("MustProvideCategory_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No registrations found for category "{0}""
     */
    NOREGISTRATIONSFORCAT("NoRegistrationsForCat_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No registrations could be found"
     */
    NOREGISTRATIONSFOUND("NoRegistrationsFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No statements found for category "{0}" (constrainedElements may be empty)"
     */
    NOSTMTSFORCATEGORY("NoStmtsForCategory_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No valid category was provided, please specify at least one of "immediate" or "deferred""
     */
    NOVALIDCATEGORY("NoValidCategory_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No visitor method defined for class "{0}""
     */
    NOVISITORFORCLASS("NoVisitorForClass_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The object is not a MofClass"
     */
    NOTAMOFCLASS("NotAMofClass_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL Body expression for operation "{0}" of class "{1}" could not be found"
     */
    OCLBODYNOTFOUND("OclBodyNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A RuntimeExeption was thrown in the OCL evaluator, exception message: {0}"
     */
    OCLEVALRTEX("OclEvalRtEx_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL Evaluator stack has reached a size of {0} probably due to some recursion"
     */
    OCLEVALSTACKOVERFLOW("OclEvalStackOverflow_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL Expression does not evaluate to a statement of type "expression""
     */
    OCLEXPRDOESNOTEVALUATETOEXPR("OclExprDoesNotEvaluateToExpr_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL Expression does not evaluate to a statement of type "invariant""
     */
    OCLEXPRDOESNOTEVALUATETOINV("OclExprDoesNotEvaluateToInv_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL Registry is not available"
     */
    OCLREGISTRYNOTAVAILABLE("OclRegistryNotAvailable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only Attributes and Structure Fields can be initialized"
     */
    ONLYATTANDSTRUCTINIT("OnlyAttAndStructInit_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraint "{0}": Only attribute initializers are supported for Language "OCLInit""
     */
    ONLYATTRIBINITFORLANGOCLINIT("OnlyAttribInitForLangOclInit_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraint "{0}": only invariants are supported for Language "OCL""
     */
    ONLYINVFOROCL("OnlyInvForOCL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraint "{0}": Language "{1}" not supported, only "OCL" and "OCLInit" are allowed"
     */
    ONLYOCLANDOCLINITASLANGU("OnlyOCLAndOCLInitAsLangu_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Operation "{0}" is marked as Ocl Helper operation but has no body attached; Impact Analysis can not continue"
     */
    OPMARKEDHELPERNOBODY("OpMarkedHelperNoBody_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation {0} could not be found for class {1}"
     */
    OPNOTFOUND("OpNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Found an orphan sub expression; this is a bug in the Impact Analyzer"
     */
    ORPHANSUBEXPRESSION("OrphanSubExpression_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only Primitive-typed Structure Fields can be initialized"
     */
    PRIMITIVEINITONLY("PrimitiveInitOnly_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A registration with name "{0}" exists already"
     */
    REGISTRATIONEXISTS("RegistrationExists_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Reverse navigation is not supported for class "{0}""
     */
    REVNAVNOTSUPPORTED("RevNavNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Use an event based listener registration method"
     */
    USEREGISTEREVENTBASEDMETHOD("UseRegisterEventBasedMethod_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( OclServiceExceptions.class );

    private final String myKey;

    private OclServiceExceptions( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + OclServiceExceptions.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
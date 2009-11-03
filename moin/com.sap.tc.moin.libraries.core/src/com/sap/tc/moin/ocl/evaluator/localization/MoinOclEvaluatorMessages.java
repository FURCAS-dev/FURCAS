package com.sap.tc.moin.ocl.evaluator.localization;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>MOIN_OCL_EVALUATOR_004_XMSG: Association end has upper cardinality of one, but has multiple values</li>
 * <li>CanNotCompareWrappersAndBase_XMSG: Can not compare Wrappers and Base objects - This is a bug in the Evaluator</li>
 * <li>OclAnyCreateNotSupported_XMSG: Can not create OclAny wrapper for an object of type "{}"</li>
 * <li>CanNotCreateEmptyTuple_XMSG: Can not create an empty OclTuple</li>
 * <li>CannotPop_XMSG: Cannot pop the root EvaluationContext</li>
 * <li>MOIN_OCL_EVALUATOR_014_XMSG: Cannot sum() a collection that contains elements that do not support the plus operation</li>
 * <li>MOIN_OCL_EVALUATOR_007_XMSG: Condition in IfExp is not an OclBoolean</li>
 * <li>ExtractRefAssocFailed_XMSG: Could not extract the RefAssociation for Association "{0}"</li>
 * <li>MOIN_OCL_EVALUATOR_008_XMSG: Could not find variable with name {0} in EvaluationContext</li>
 * <li>AssocValueQueryFailed_XMSG: End {0} of Association {1}: the query for object with MofId {2} returned a JMIList with "null" values; please check partition {3} for dangling links</li>
 * <li>EvaluationOfExpression_XMSG: Evaluating expression "{0}" for role "{1}"</li>
 * <li>MOIN_OCL_EVALUATOR_001_XMSG: Evaluation of OclConstraint resulted in a non-Boolean value: {0}</li>
 * <li>EvalContextAlreadySet_XMSG: EvaluationContext already exists in the current thread</li>
 * <li>MOIN_OCL_EVALUATOR_010_XMSG: Iterator operation called with no iterator names</li>
 * <li>MOIN_OCL_EVALUATOR_017_XMSG: Iterator operation with name {0} not found in type {1}</li>
 * <li>MOIN_OCL_EVALUATOR_011_XMSG: Iterator operation {0} does not support multiple iterators</li>
 * <li>ListOrderedSetIndexOutOfBounds_XMSG: ListOrderedSet can not  add at index {0}, since size is {1}</li>
 * <li>NoNullInListOrderedSet_XMSG: ListOrderedSet does not support null values</li>
 * <li>MOIN_OCL_EVALUATOR_012_XMSG: No tupleParts found in TupleLiteralExp</li>
 * <li>MOIN_OCL_EVALUATOR_016_XMSG: Operation with name {0} and {1} arguments not found in type {2}</li>
 * <li>MOIN_OCL_EVALUATOR_015_XMSG: Operation {0} not found in type {1}</li>
 * <li>PoppingEvaContext_XMSG: Popping the Evaluation context</li>
 * <li>PushingEvalContext_XMSG: Pushing the Evaluation context</li>
 * <li>RangeNotSupportedForNonInt_XMSG: Range not implemented for non-integer values</li>
 * <li>MOIN_OCL_EVALUATOR_003_XMSG: Source in AssociationEndCallExp is not a RefObject</li>
 * <li>MOIN_OCL_EVALUATOR_002_XMSG: Source in AttributeCallExp is not a RefObject or a Tuple</li>
 * <li>SelfMustNotBeNull_XMSG: The "self" variable must not be null</li>
 * <li>UnknownKind_XMSG: The Collection kind "{0}" is unknown</li>
 * <li>EvalContextNotSet_XMSG: The Evaluator context has not been set for the current thread</li>
 * <li>ExprTypeNotSupported_XMSG: The ExpressionEvaluator does not currently support expressions of type "{0}"</li>
 * <li>VarNameMustNotBeNull_XMSG: The name for variable must not be null</li>
 * <li>VarValueMustNotBeNull_XMSG: The value for a variable must not be null</li>
 * <li>UnderlyingValueNotNull_XMSG: The value hosted in an OclAny object must not be null</li>
 * <li>MOIN_OCL_EVALUATOR_009_XMSG: Type of body expression in sortedBy iterator must support &#039;&lt;&#039; operation</li>
 * <li>CouldNotGetSourceForJavaOp_XMSG: Unable to determine source object for Java implemented operation</li>
 * <li>MOIN_OCL_EVALUATOR_013_XMSG: Unknown Tuple part with name: {0}</li>
 * <li>MOIN_OCL_EVALUATOR_005_XMSG: Unrecognized Collection kind</li>
 * <li>MOIN_OCL_EVALUATOR_006_XMSG: Unrecognized CollectionLiteralPart</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MoinOclEvaluatorMessages.properties
 */
 
public enum MoinOclEvaluatorMessages implements MoinLocalizedString {


    /**
     * Message: "End {0} of Association {1}: the query for object with MofId {2} returned a JMIList with "null" values; please check partition {3} for dangling links"
     */
    ASSOCVALUEQUERYFAILED("AssocValueQueryFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not compare Wrappers and Base objects - This is a bug in the Evaluator"
     */
    CANNOTCOMPAREWRAPPERSANDBASE("CanNotCompareWrappersAndBase_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not create an empty OclTuple"
     */
    CANNOTCREATEEMPTYTUPLE("CanNotCreateEmptyTuple_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot pop the root EvaluationContext"
     */
    CANNOTPOP("CannotPop_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unable to determine source object for Java implemented operation"
     */
    COULDNOTGETSOURCEFORJAVAOP("CouldNotGetSourceForJavaOp_XMSG"), //$NON-NLS-1$

    /**
     * Message: "EvaluationContext already exists in the current thread"
     */
    EVALCONTEXTALREADYSET("EvalContextAlreadySet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Evaluator context has not been set for the current thread"
     */
    EVALCONTEXTNOTSET("EvalContextNotSet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Evaluating expression "{0}" for role "{1}""
     */
    EVALUATIONOFEXPRESSION("EvaluationOfExpression_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The ExpressionEvaluator does not currently support expressions of type "{0}""
     */
    EXPRTYPENOTSUPPORTED("ExprTypeNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not extract the RefAssociation for Association "{0}""
     */
    EXTRACTREFASSOCFAILED("ExtractRefAssocFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ListOrderedSet can not  add at index {0}, since size is {1}"
     */
    LISTORDEREDSETINDEXOUTOFBOUNDS("ListOrderedSetIndexOutOfBounds_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Evaluation of OclConstraint resulted in a non-Boolean value: {0}"
     */
    MOIN_OCL_EVALUATOR_001("MOIN_OCL_EVALUATOR_001_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Source in AttributeCallExp is not a RefObject or a Tuple"
     */
    MOIN_OCL_EVALUATOR_002("MOIN_OCL_EVALUATOR_002_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Source in AssociationEndCallExp is not a RefObject"
     */
    MOIN_OCL_EVALUATOR_003("MOIN_OCL_EVALUATOR_003_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Association end has upper cardinality of one, but has multiple values"
     */
    MOIN_OCL_EVALUATOR_004("MOIN_OCL_EVALUATOR_004_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unrecognized Collection kind"
     */
    MOIN_OCL_EVALUATOR_005("MOIN_OCL_EVALUATOR_005_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unrecognized CollectionLiteralPart"
     */
    MOIN_OCL_EVALUATOR_006("MOIN_OCL_EVALUATOR_006_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Condition in IfExp is not an OclBoolean"
     */
    MOIN_OCL_EVALUATOR_007("MOIN_OCL_EVALUATOR_007_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not find variable with name {0} in EvaluationContext"
     */
    MOIN_OCL_EVALUATOR_008("MOIN_OCL_EVALUATOR_008_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of body expression in sortedBy iterator must support &#039;&lt;&#039; operation"
     */
    MOIN_OCL_EVALUATOR_009("MOIN_OCL_EVALUATOR_009_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator operation called with no iterator names"
     */
    MOIN_OCL_EVALUATOR_010("MOIN_OCL_EVALUATOR_010_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator operation {0} does not support multiple iterators"
     */
    MOIN_OCL_EVALUATOR_011("MOIN_OCL_EVALUATOR_011_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No tupleParts found in TupleLiteralExp"
     */
    MOIN_OCL_EVALUATOR_012("MOIN_OCL_EVALUATOR_012_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unknown Tuple part with name: {0}"
     */
    MOIN_OCL_EVALUATOR_013("MOIN_OCL_EVALUATOR_013_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot sum() a collection that contains elements that do not support the plus operation"
     */
    MOIN_OCL_EVALUATOR_014("MOIN_OCL_EVALUATOR_014_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation {0} not found in type {1}"
     */
    MOIN_OCL_EVALUATOR_015("MOIN_OCL_EVALUATOR_015_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation with name {0} and {1} arguments not found in type {2}"
     */
    MOIN_OCL_EVALUATOR_016("MOIN_OCL_EVALUATOR_016_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator operation with name {0} not found in type {1}"
     */
    MOIN_OCL_EVALUATOR_017("MOIN_OCL_EVALUATOR_017_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ListOrderedSet does not support null values"
     */
    NONULLINLISTORDEREDSET("NoNullInListOrderedSet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not create OclAny wrapper for an object of type "{}""
     */
    OCLANYCREATENOTSUPPORTED("OclAnyCreateNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Popping the Evaluation context"
     */
    POPPINGEVACONTEXT("PoppingEvaContext_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Pushing the Evaluation context"
     */
    PUSHINGEVALCONTEXT("PushingEvalContext_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Range not implemented for non-integer values"
     */
    RANGENOTSUPPORTEDFORNONINT("RangeNotSupportedForNonInt_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The "self" variable must not be null"
     */
    SELFMUSTNOTBENULL("SelfMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The value hosted in an OclAny object must not be null"
     */
    UNDERLYINGVALUENOTNULL("UnderlyingValueNotNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Collection kind "{0}" is unknown"
     */
    UNKNOWNKIND("UnknownKind_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name for variable must not be null"
     */
    VARNAMEMUSTNOTBENULL("VarNameMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The value for a variable must not be null"
     */
    VARVALUEMUSTNOTBENULL("VarValueMustNotBeNull_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MoinOclEvaluatorMessages.class );

    private final String myKey;

    private MoinOclEvaluatorMessages( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + MoinOclEvaluatorMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
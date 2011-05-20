/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bugs 176110, 191689 
 *   Zeligsoft - Bug 253512
 *   Borland - Bug 242880
 *
 * </copyright>
 *
 * $Id: OCLMessages.java,v 1.9 2011/05/20 15:27:20 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.messages;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 */
public class OCLMessages
{
	static {
		NLS.initializeMessages(OCLMessages.class.getName(), OCLMessages.class);
	}

	public static String no_message;
    public static String Input_ERROR_;
    
    public static String EnvRegistry_missingClass_ERROR_;
    public static String EnvRegistry_missingNsURI_ERROR_;
    public static String EnvRegistry_unknownElement_ERROR_;

    
	public static String BindingExist_ERROR_;
	public static String UnknownOperation_ERROR_;
	public static String IteratorNotImpl_ERROR_;
	public static String IndexOutOfRange_ERROR_;
	public static String TupleFieldDoesntExist_ERROR_;
	public static String NullProperty_ERROR_;
	public static String NullNavigationSource_ERROR_;
	public static String NullNavigationType_ERROR_;
	public static String NullOperation_ERROR_;
	public static String NullSourceOperation_ERROR_;
	public static String IllegalOperation_ERROR_;
	public static String NonQueryOperation_ERROR_;
	public static String IllegalOpcode_ERROR_;
	public static String TypeConformanceOperation_ERROR_;
	public static String IllegalEnumLiteral_ERROR_;
	public static String VariableTypeMismatch_ERROR_;
	public static String MissingNameInVariableDeclaration_ERROR_;
	public static String TypeConformanceInit_ERROR_;
	public static String NonBooleanIfExp_ERROR_;
	public static String TypeConformanceIfExp_ERROR_;
	public static String TypeConformanceIntegerLiteral_ERROR_;
    public static String TypeConformanceUnlimitedNaturalLiteral_ERROR_;
	public static String TypeConformanceRealLiteral_ERROR_;
	public static String TypeConformanceStringLiteral_ERROR_;
	public static String TypeConformanceBooleanLiteral_ERROR_;
	public static String TypeConformanceNullLiteral_ERROR_;
	public static String TypeConformanceInvalidLiteral_ERROR_;
	public static String TypeConformanceLetExp_ERROR_;
	public static String TypeConformanceIterateExp_ERROR_;
	public static String TypeConformanceIterateExpBody_ERROR_;
	public static String TypeConformanceIterateExpLoopVar_ERROR_;
	public static String TypeConformanceIteratorResult_ERROR_;
	public static String TypeConformanceIteratorExpLoopVar_ERROR_;
	public static String TypeConformanceCollectSequence_ERROR_;
	public static String TypeConformanceCollectBag_ERROR_;
	public static String TypeConformanceClosure_ERROR_;
	public static String ElementTypeConformanceClosure_ERROR_;
	public static String TypeConformanceSelectReject_ERROR_;
	public static String TypeConformanceIteratorBodyBoolean_ERROR_;
	public static String TypeConformanceCollectionLiteralExp_ERROR_;
	public static String TypeConformanceSetLiteral_ERROR_;
	public static String TypeConformanceOrderedSetLiteral_ERROR_;
	public static String TypeConformanceBagLiteral_ERROR_;
	public static String TypeConformanceSequenceLiteral_ERROR_;
	public static String TypeConformanceEmptyCollection_ERROR_;
	public static String TypeConformanceCollectionElementType_ERROR_;
	public static String TypeConformanceTupleLiteralExp_ERROR_;
	public static String TypeConformanceTupleLiteralExpParts_ERROR_;
	public static String TupleLiteralExpressionPart_ERROR_;
	public static String TupleDuplicateName_ERROR_;
	public static String MissingPropertyInTupleLiteralPart_ERROR_;
	public static String MissingTypeInTupleLiteralPart_ERROR_;
	public static String TuplePartType_ERROR_;
	public static String TypeConformanceTuplePartValue_ERROR_;
	
	public static String TypeConformanceTypeExp_ERROR_;
	public static String TypeExpMissingType_ERROR_;
	
	public static String IllegalSignature_ERROR_;
	public static String IteratorSource_ERROR_;
	public static String IterateExpLoopVarInit_ERROR_;
	public static String TooManyIteratorVariables_ERROR_;
    
	public static String IncompleteVariableExp_ERROR_;
	public static String IncompleteLetExp_ERROR_;
	public static String IncompleteIterateExp_ERROR_;
	public static String IncompleteIfExp_ERROR_;
	public static String IncompleteIteratorExp_ERROR_;
	public static String MissingInitIterateExp_ERROR_;
	
	public static String ErrorMessage_ERROR_;
	public static String ProblemMessage_ERROR_;
    public static String Severity_Cancel;
	public static String Severity_Fatal_Error;
	public static String Severity_Error;
	public static String Severity_Warning;
	public static String Severity_Info;
	public static String Severity_OK;

	public static String Phase_Parser;
	public static String Phase_Unparser;
	public static String Phase_Lexer;
	public static String Phase_Analyzer;
	public static String Phase_Validator;
	public static String Phase_Utility;
	
	
	public static String VariableUsed_ERROR_;
	public static String VariableDeclaration_ERROR_;
	public static String BadArg_ERROR_;
	public static String PackageNotFound_ERROR_;
	public static String UnrecognizedContext_ERROR_;
	public static String PropertyConstraints_ERROR_;
	
	public static String BooleanForIf_ERROR_;
	public static String VarInNavExp_ERROR_;
	public static String UnrecognizedVar_ERROR_;
	public static String DeclarationType_ERROR_;
	public static String DeclarationNoInitExp_ERROR_;
	public static String DeclarationInitExp_ERROR_;
	public static String UnrecognizedType_ERROR_;
	
	public static String DuplicateNameInTuple_ERROR_;
	public static String InitExpNotAllowed_ERROR_;
	public static String UnrecognizedEnum_ERROR_;
	public static String FirstLastTypeMismatch_ERROR_;
	
	public static String NullArgExpectEObj_ERROR_;
	public static String NullArgExpectlist_ERROR_;
	public static String BooleanQuery_ERROR_;
	
	public static String EvaluationFailed_ERROR_;
	
	public static String Noncomforming_ERROR_;
	public static String SourceEClass_ERROR_;
	public static String SourceOperationCompareTo_ERROR_;
	public static String ResultCompareToInt_ERROR_;
	public static String TypeMismatch_ERROR_;
	public static String CastTypeMismatch_ERROR_;
	public static String CollectionType_ERROR_;
	public static String MaxOperator_ERROR_;
	public static String MinOperator_ERROR_;
	public static String SumOperator_ERROR_;
	public static String TupleTypeMismatch_ERROR_;
	public static String TupleFieldNotFound_ERROR_;
	public static String TupleFieldNumMismatch_ERROR_;
	public static String RemoveUnsupported_ERROR_;
	public static String OCLCollectionKindNotImpl_ERROR_;
	
	public static String IsInStateSignature_ERROR_;
	public static String NoSuchState_ERROR_;
	public static String AmbiguousState_ERROR_;
	public static String MissingStateInStateExp_ERROR_;
	public static String UnrecognizedMessageType_ERROR_;
	public static String AmbiguousMessageType_ERROR_;
	public static String IllegalUnspecifiedValueExp_ERROR_;
	public static String MissingMessageTarget_ERROR_;
	public static String MissingOperationInCallAction_ERROR_;
	public static String MissingSignalInCallAction_ERROR_;
	public static String MessageArgumentCount_ERROR_;
	public static String MessageArgConformance_ERROR_;
	
	public static String DefinitionConstraintFeature_ERROR_;
	public static String DefinitionConstraintConformance_ERROR_;
	public static String DuplicateProperty_ERROR_;
	public static String UnsupportedStatic_ERROR_;
	public static String UnimplementedStatic_ERROR_;
	public static String DuplicateOperation_ERROR_;
	public static String InitOrDerConstraintConformance_ERROR_;
	
	public static String IllegalAtPre_ERROR_;
	public static String AtPreInPostcondition_ERROR_;
	public static String BodyConditionNotAllowed_ERROR_;
	public static String BodyConditionConformance_ERROR_;
	public static String OCLIsNewInPostcondition_ERROR_;
	public static String IllegalQualifiers_ERROR_;
	public static String MismatchedQualifiers_ERROR_;
	public static String MissingAssociationClass_ERROR_;
	public static String AssociationClassQualifierCount_ERROR_;
	public static String AssociationClassQualifierType_ERROR_;
	public static String AssociationClassAmbiguous_ERROR_;
	
	public static String WrongContextClassifier_ERROR_;
	public static String BodyConditionForm_ERROR_;
	public static String OperationConstraintBoolean_ERROR_;
//	public static String InvariantConstraintBoolean_ERROR_;
	public static String MissingContextVariable_ERROR_;
    public static String ExtraneousParameterVariables_ERROR_;
    public static String ExtraneousResultVariable_ERROR_;
    public static String MismatchedArgumentCount_ERROR_;
    public static String MismatchedArgumentType_ERROR_;
    public static String MismatchedParameterVariables_ERROR_;
    public static String MismatchedResultVariable_ERROR_;
    public static String MissingResultVariable_ERROR_;
    public static String MissingBodyExpression_ERROR_;
    
    public static String NonStaticAttribute_ERROR_;
    public static String NonStaticOperation_ERROR_;
    
	public static String InvalidOCL_ERROR_;
	
	public static String NonStd_DQuote_Escape_;
	public static String NonStd_SQuote_Escape_;
    public static String NonStd_Operation_;
    public static String NonStd_Iterator_;
    public static String NonStd_InheritedFeatureContext_;
    public static String NonStd_CompareTo_;
    
    public static String Ambig_AssocEnd_;
    
    public static String StringNotProperlyClosed_ERROR;
    public static String InvalidEscapeSequence_ERROR;
    
    public static String XorOrAndPrecedence_WARNING;
	
	public static String EvaluationResultIsInvalid_ERROR_;	
	public static String MissingBodyForInvocationDelegate_ERROR_;	
	public static String MissingDerivationForSettingDelegate_ERROR_;
	
	public static String ValidationConstraintException_ERROR_;
	public static String ValidationConstraintIsNotBoolean_ERROR_;
	public static String ValidationConstraintIsNotSatisfied_ERROR_;
	public static String ValidationMessageException_ERROR_;
	public static String ValidationMessageIsNotString_ERROR_;
	public static String ValidationResultIsInvalid_ERROR_;	
	public static String ValidationResultIsNull_ERROR_;	
	public static String ValidationResultIsNotBoolean_ERROR_;
	
	public static String HiddenOppositeOf;

	public static String NoOperationReflection_WARNING_;
	public static String ExtraArg_ERROR_;
	
	// above this line messages migrated from non-Pivot
	//-----------------------------------------------------------
	// below this line alphabetical messages known to be used for Pivot
	public static String IncompatibleBodyType_WARNING_;
	public static String RedundantIterator_WARNING_;
	public static String UnresolvedImport_ERROR_;
	public static String UnresolvedInclude_ERROR_;
	public static String UnresolvedLibrary_ERROR_;
	public static String UnresolvedOperation_ERROR_;
	public static String UnresolvedOperationCall_ERROR_;
	public static String UnresolvedProperty_ERROR_;
	public static String UnresolvedType_ERROR_;
	public static String Unresolved_ERROR_;
	
	public static String Validation;
}

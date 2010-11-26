/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
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
 * $Id: OCLMessages.java,v 1.14 2010/08/24 16:17:06 ewillink Exp $
 */

package org.eclipse.ocl.internal.l10n;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * An accessor class for externalized strings.
 * 
 * @author Christian Vogt (cvogt)
 */
public class OCLMessages {

	static final String BUNDLE_NAME = "org.eclipse.ocl.internal.l10n.OCLMessages"; //$NON-NLS-1$

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
	public static String OperationNotFound_ERROR_;
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
	public static String InvariantConstraintBoolean_ERROR_;
	public static String MissingContextVariable_ERROR_;
    public static String ExtraneousParameterVariables_ERROR_;
    public static String ExtraneousResultVariable_ERROR_;
    public static String MismatchedParameterVariables_ERROR_;
    public static String MismatchedResultVariable_ERROR_;
    public static String MissingResultVariable_ERROR_;
    public static String MissingBodyExpression_ERROR_;
    
    public static String NonStaticAttribute_ERROR_;
    public static String NonStaticOperation_ERROR_;
    
	public static String InvalidOCL_ERROR_;
	public static String ParseCSTNodeType_ERROR_;

	public static String OCLParseErrorCodes_LEX_ERROR;
	public static String OCLParseErrorCodes_ERROR;
	public static String OCLParseErrorCodes_BEFORE;
	public static String OCLParseErrorCodes_INSERTION;
	public static String OCLParseErrorCodes_INVALID;
	public static String OCLParseErrorCodes_SUBSTITUTION_SECONDARY;
	public static String OCLParseErrorCodes_DELETION;
	public static String OCLParseErrorCodes_MERGE;
	public static String OCLParseErrorCodes_MISPLACED;
	public static String OCLParseErrorCodes_SCOPE;
	public static String OCLParseErrorCodes_EOF;
	public static String OCLParseErrorCodes_INVALID_TOKEN;
	
	public static String ErrorReport_RowColumn;
	
	public static String Conceptual_Operation_Name_;
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
	public static String ValidationConstraintIsNotBoolean_ERROR_;	
	public static String ValidationResultIsInvalid_ERROR_;	
	public static String ValidationResultIsNull_ERROR_;	
	public static String ValidationResultIsNotBoolean_ERROR_;
	
	public static String HiddenOppositeOf;
	public static String CantFindOppositeWithUMLReflection_ERROR_;

	public static String NoOperationReflection_WARNING_;
	
	private static IMessages messagesImpl;
	
	public static String bind(String message, Object arg) {
		return messagesImpl.bind(message, arg);
	}
	
	public static String bind(String message, Object arg1, Object arg2) {
		return messagesImpl.bind(message, arg1, arg2);
	}
	
	public static String bind(String message, Object[] args) {
		return messagesImpl.bind(message, args);
	}

	static {
		try {
			@SuppressWarnings("unchecked")
			Class<IMessages> nlsClass = (Class<IMessages>) Class
				.forName("org.eclipse.ocl.internal.l10n.IMessages$NLS"); //$NON-NLS-1$
			messagesImpl = nlsClass.newInstance();
		} catch (NoClassDefFoundError e) {
			// expected in non-Eclipse environment
		} catch (Exception e) {
			// expected in non-Eclipse environment
		}
		
		if (messagesImpl == null) {
			// could not find the NLS class.  Try initializing the messages,
			//    ourselves
			initializeMessages();
			messagesImpl = new IMessages.Default();
		}
	}
	
	private static void initializeMessages() {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
		int publicStatic = Modifier.PUBLIC | Modifier.STATIC;
		
		Class<OCLMessages> clazz = OCLMessages.class;
		
		if (bundle != null) {
			Field[] fields = clazz.getDeclaredFields();
			
			for (int i = 0; i < fields.length; i++) {
				Field next = fields[i];
				
				if (((next.getModifiers() & publicStatic) == publicStatic)
						&& (next.getType() == String.class)) {
					String name = next.getName();
					
					try {
						try {
							next.set(null, bundle.getString(name));
						} catch (MissingResourceException e) {
							// just use its own name, then
							next.set(null, "Missing message for key: " + name); //$NON-NLS-1$
						}
					} catch (Exception e) {
						// oh, well.  Can't set a value for this one
					}
				}
			}
		}
	}
}

/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLMessages.java,v 1.3 2006/03/01 17:15:48 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.l10n;

import org.eclipse.osgi.util.NLS;

/**
 * An accessor class for externalized strings.
 * 
 * @author Christian Vogt (cvogt)
 */
public class OCLMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.emf.ocl.internal.l10n.OCLMessages"; //$NON-NLS-1$

	public static String no_message;
	public static String BindingExist_ERROR_;
	public static String UnknownOperation_ERROR_;
	public static String IteratorNotImpl_ERROR_;
	public static String IndexOutOfRange_ERROR_;
	public static String TupleFieldDoesntExist_ERROR_;
	public static String InvalidClass_ERROR_;
	public static String InvalidDatatype_ERROR_;
	public static String NullAttribute_ERROR_;
	public static String NullSourceAttribute_ERROR_;
	public static String NullTypeAttribute_ERROR_;
	public static String NullAssociation_ERROR_;
	public static String NullSourceAssociation_ERROR_;
	public static String NullTypeAssociation_ERROR_;
	public static String NullOperation_ERROR_;
	public static String NullSourceOperation_ERROR_;
	public static String IllegalOperation_ERROR_;
	public static String IllegalOpcode_ERROR_;
	public static String TypeConformanceOperation_ERROR_;
	public static String IllegalEnumLiteral_ERROR_;
	public static String VariableTypeMismatch_ERROR_;
	public static String MissingNameInVariableDeclaration_ERROR_;
	public static String TypeConformanceInit_ERROR_;
	public static String NonBooleanIfExp_ERROR_;
	public static String TypeConformanceIfExp_ERROR_;
	public static String TypeConformanceIntegerLiteral_ERROR_;
	public static String TypeConformanceRealLiteral_ERROR_;
	public static String TypeConformanceStringLiteral_ERROR_;
	public static String TypeConformanceBooleanLiteral_ERROR_;
	public static String TypeConformanceLetExp_ERROR_;
	public static String TypeConformanceIterateExp_ERROR_;
	public static String TypeConformanceIterateExpBody_ERROR_;
	public static String TypeConformanceIterateExpLoopVar_ERROR_;
	public static String TypeConformanceIteratorResult_ERROR_;
	public static String TypeConformanceCollectSequence_ERROR_;
	public static String TypeConformanceCollectBag_ERROR_;
	public static String TypeConformanceSelectReject_ERROR_;
	public static String TypeConformanceIterateExpBodyBoolean_ERROR_;
	public static String TypeConformanceCollectionLiteralExp_ERROR_;
	public static String TypeConformanceSetLiteral_ERROR_;
	public static String TypeConformanceOrderedSetLiteral_ERROR_;
	public static String TypeConformanceBagLiteral_ERROR_;
	public static String TypeConformanceSequenceLiteral_ERROR_;
	public static String TypeConformanceEmptyCollection_ERROR_;
	public static String TypeConformanceCollectionElementType_ERROR_;
	public static String TypeConformanceTupleLiteralExp_ERROR_;
	public static String TypeConformanceTupleLiteralExpParts_ERROR_;
	public static String TupleLiteralExpressionAttribName_ERROR_;
	public static String TupleLiteralExpressionRefName_ERROR_;
	public static String TupleDuplicateName_ERROR_;
	public static String RecursiveContainment_ERROR_;
	public static String EMFOCLConversion_ERROR_;
	public static String UnknownOperationOwnerType_ERROR_;
	public static String IllegalSignature_ERROR_;
	public static String IteratorSource_ERROR_;
	public static String MissingInitIterateExpLoopVar_ERROR_;
	public static String IncompleteVariableDeclaration_ERROR_;
	public static String IncompleteLetExp_ERROR_;
	public static String IncompleteIterateExp_ERROR_;
	public static String IncompleteIfExp_ERROR_;
	public static String IncompleteIteratorExp_ERROR_;
	public static String MissingInitIterateExp_ERROR_;
	public static String StringParse_ERROR_;
	public static String ErrorMessage_ERROR_;
	public static String VariableUsed_ERROR_;
	public static String VariableDeclaration_ERROR_;
	public static String OperationNotFound_ERROR_;
	public static String BadArg_ERROR_;
	public static String PackageNotFound_ERROR_;
	public static String UnrecognizedContext_ERROR_;
	public static String BooleanForIf_ERROR_;
	public static String MissingTypeForVar_ERROR_;
	public static String MissingInitForVar_ERROR_;
	public static String VarInNavExp_ERROR_;
	public static String UnrecognizedVar_ERROR_;
	public static String DeclarationType_ERROR_;
	public static String DeclarationNoInitExp_ERROR_;
	public static String DeclarationInitExp_ERROR_;
	public static String UnrecognizedType_ERROR_;
	public static String UnrecognizedVarType_ERROR_;
	public static String NoType_ERROR_;
	public static String NoInitExp_ERROR_;
	public static String MissingTypeDecl_ERROR_;
	public static String DuplicateNameInTuple_ERROR_;
	public static String InitExpNotAllowed_ERROR_;
	public static String MissingInit_ERROR_;
	public static String UnrecognizedPackageOrEnum_ERROR_;
	public static String UnrecognizedEnum_ERROR_;
	public static String FirstLastTypeMismatch_ERROR_;
	public static String NullArgExpectEObj_ERROR_;
	public static String NullArgExpectlist_ERROR_;
	public static String BooleanQuery_ERROR_;
	public static String InputListExpectEObjs_ERROR_;
	public static String CheckBool_ERROR_;
	public static String Noncomforming_ERROR_;
	public static String EqualityTupleUnsupported_ERROR_;
	public static String SourceEClass_ERROR_;
	public static String SourceOperationCompareTo_ERROR_;
	public static String ResultCompareToInt_ERROR_;
	public static String TypeMismatch_ERROR_;
	public static String CompareTypeMismatch_ERROR_;
	public static String UnrecognizedCollectionOperation_ERROR_;
	public static String CollectionType_ERROR_;
	public static String CollectionSuperType_ERROR_;
	public static String SumOperator_ERROR_;
	public static String TupleTypeMismatch_ERROR_;
	public static String TupleFieldNotFound_ERROR_;
	public static String TupleFieldNumMismatch_ERROR_;
	public static String RemoveUnsupported_ERROR_;
	public static String OCLCollectionKindNotImpl_ERROR_;
	public static String IllegalAtPre_ERROR_;
	public static String AtPreInPostcondition_ERROR_;
	public static String BodyConditionNotAllowed_ERROR_;
	public static String BodyConditionConformance_ERROR_;
	public static String BodyConditionConformance2_ERROR_;
	public static String OCLIsNewInPostcondition_ERROR_;
	public static String IllegalQualifiers_ERROR_;
	public static String MismatchedQualifiers_ERROR_;
	public static String MissingAssociationClass_ERROR_;
	public static String AssociationClassQualifierCount_ERROR_;
	public static String AssociationClassQualifierType_ERROR_;
	public static String AssociationClassAmbiguous_ERROR_;
	public static String BodyConditionForm_ERROR_;
	public static String OperationConstraintBoolean_ERROR_;
	public static String InvariantConstraintBoolean_ERROR_;

	static {
		NLS.initializeMessages(BUNDLE_NAME, OCLMessages.class);
	}
}

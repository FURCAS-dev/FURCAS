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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.AttributeCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.ModelPropertyCallExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.util.AbstractVisitor;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.VoidType;
import org.eclipse.emf.ocl.types.internal.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.PrimitiveTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.osgi.util.NLS;

/**
 * @author Edith Schonberg (edith)
 * 
 * Checks the well-formedness rules for the expressions package
 */
public class ValidationVisitorImpl
	implements Visitor {

	private static final String NullAttribute_ERROR_ =
		OclMessages.NullAttribute_ERROR_;

	private static final String NullSourceAttribute_ERROR_ =
		OclMessages.NullSourceAttribute_ERROR_;

	private static final String NullTypeAttribute_ERROR_ =
		OclMessages.NullTypeAttribute_ERROR_;

	private static final String NullOperation_ERROR_ =
		OclMessages.NullOperation_ERROR_;

	private static final String NullSourceOperation_ERROR_ =
		OclMessages.NullSourceOperation_ERROR_;

	private static final String IllegalOperation_ERROR_ =
		OclMessages.IllegalOperation_ERROR_;

	private static final String IllegalOpcode_ERROR_ =
		OclMessages.IllegalOpcode_ERROR_;

	private static final String TypeConformanceOperation_ERROR_ =
		OclMessages.TypeConformanceOperation_ERROR_;

	private static final String IllegalEnumLiteral_ERROR_ =
		OclMessages.IllegalEnumLiteral_ERROR_;

	private static final String IncompleteVariableDeclaration_ERROR_ =
		OclMessages.IncompleteVariableDeclaration_ERROR_;

	private static final String VariableTypeMismatch_ERROR_ =
		OclMessages.VariableTypeMismatch_ERROR_;

	private static final String NullAssociation_ERROR_ =
		OclMessages.NullAssociation_ERROR_;

	private static final String NullSourceAssociation_ERROR_ =
		OclMessages.NullSourceAssociation_ERROR_;

	private static final String NullTypeAssociation_ERROR_ =
		OclMessages.NullTypeAssociation_ERROR_;

	private static final String MissingNameInVariableDeclaration_ERROR_ =
		OclMessages.MissingNameInVariableDeclaration_ERROR_;

	private static final String TypeConformanceInit_ERROR_ =
		OclMessages.TypeConformanceInit_ERROR_;

	private static final String IncompleteIfExp_ERROR_ =
		OclMessages.IncompleteIfExp_ERROR_;

	private static final String NonBooleanIfExp_ERROR_ =
		OclMessages.NonBooleanIfExp_ERROR_;

	private static final String TypeConformanceIfExp_ERROR_ =
		OclMessages.TypeConformanceIfExp_ERROR_;

	private static final String TypeConformanceIntegerLiteral_ERROR_ =
		OclMessages.TypeConformanceIntegerLiteral_ERROR_;

	private static final String TypeConformanceRealLiteral_ERROR_ =
		OclMessages.TypeConformanceRealLiteral_ERROR_;

	private static final String TypeConformanceStringLiteral_ERROR_ =
		OclMessages.TypeConformanceStringLiteral_ERROR_;

	private static final String TypeConformanceBooleanLiteral_ERROR_ =
		OclMessages.TypeConformanceBooleanLiteral_ERROR_;

	private static final String TypeConformanceLetExp_ERROR_ =
		OclMessages.TypeConformanceLetExp_ERROR_;

	private static final String IncompleteLetExp_ERROR_ =
		OclMessages.IncompleteLetExp_ERROR_;

	private static final String IncompleteIterateExp_ERROR_ =
		OclMessages.IncompleteIterateExp_ERROR_;

	private static final String MissingInitIterateExp_ERROR_ =
		OclMessages.MissingInitIterateExp_ERROR_;

	private static final String TypeConformanceIterateExp_ERROR_ =
		OclMessages.TypeConformanceIterateExp_ERROR_;

	private static final String TypeConformanceIterateExpBody_ERROR_ =
		OclMessages.TypeConformanceIterateExpBody_ERROR_;

	private static final String IteratorSource_ERROR_ =
		OclMessages.IteratorSource_ERROR_;

	private static final String MissingInitIterateExpLoopVar_ERROR_ =
		OclMessages.MissingInitIterateExpLoopVar_ERROR_;

	private static final String TypeConformanceIterateExpLoopVar_ERROR_ =
		OclMessages.TypeConformanceIterateExpLoopVar_ERROR_;

	private static final String IncompleteIteratorExp_ERROR_ =
		OclMessages.IncompleteIteratorExp_ERROR_;

	private static final String TypeConformanceIteratorResult_ERROR_ =
		OclMessages.TypeConformanceIteratorResult_ERROR_;

	private static final String TypeConformanceCollectSequence_ERROR_ =
		OclMessages.TypeConformanceCollectSequence_ERROR_;

	private static final String TypeConformanceCollectBag_ERROR_ =
		OclMessages.TypeConformanceCollectBag_ERROR_;

	private static final String TypeConformanceSelectReject_ERROR_ =
		OclMessages.TypeConformanceSelectReject_ERROR_;

	private static final String TypeConformanceIterateExpBodyBoolean_ERROR_ =
		OclMessages.TypeConformanceIterateExpBodyBoolean_ERROR_;

	private static final String TypeConformanceCollectionLiteralExp_ERROR_ =
		OclMessages.TypeConformanceCollectionLiteralExp_ERROR_;

	private static final String TypeConformanceSetLiteral_ERROR_ =
		OclMessages.TypeConformanceSetLiteral_ERROR_;

	private static final String TypeConformanceOrderedSetLiteral_ERROR_ =
		OclMessages.TypeConformanceOrderedSetLiteral_ERROR_;

	private static final String TypeConformanceBagLiteral_ERROR_ =
		OclMessages.TypeConformanceBagLiteral_ERROR_;

	private static final String TypeConformanceSequenceLiteral_ERROR_ =
		OclMessages.TypeConformanceSequenceLiteral_ERROR_;

	private static final String TypeConformanceEmptyCollection_ERROR_ =
		OclMessages.TypeConformanceEmptyCollection_ERROR_;

	private static final String TypeConformanceCollectionElementType_ERROR_ =
		OclMessages.TypeConformanceCollectionElementType_ERROR_;

	private static final String TypeConformanceTupleLiteralExp_ERROR_ =
		OclMessages.TypeConformanceTupleLiteralExp_ERROR_;

	private static final String TypeConformanceTupleLiteralExpParts_ERROR_ =
		OclMessages.TypeConformanceTupleLiteralExpParts_ERROR_;

	private static final String TupleLiteralExpressionAttribName_ERROR_ =
		OclMessages.TupleLiteralExpressionAttribName_ERROR_;

	private static final String TupleLiteralExpressionRefName_ERROR_ =
		OclMessages.TupleLiteralExpressionRefName_ERROR_;

	private static final String TupleDuplicateName_ERROR_ =
		OclMessages.TupleDuplicateName_ERROR_;

	private static Visitor instance = null;

	private static final String AtPreInPostcondition_ERROR_ =
		OclMessages.AtPreInPostcondition_ERROR_;

	private static final String BodyConditionNotAllowed_ERROR_ =
		OclMessages.BodyConditionNotAllowed_ERROR_;

	private static final String BodyConditionConformance_ERROR_ =
		OclMessages.BodyConditionConformance_ERROR_;

	private static final String BodyConditionConformance2_ERROR_ =
		OclMessages.BodyConditionConformance2_ERROR_;

	private static final String OclIsNewInPostcondition_ERROR_ =
		OclMessages.OclIsNewInPostcondition_ERROR_;

	private static final String MissingAssociationClass_ERROR_ =
		OclMessages.MissingAssociationClass_ERROR_;
	
	private static final String BodyConditionForm_ERROR_ =
		OclMessages.BodyConditionForm_ERROR_;
	
	private static final String OperationConstraintBoolean_ERROR_ =
		OclMessages.OperationConstraintBoolean_ERROR_;

	// singleton
	public static Visitor getInstance() {
		if (instance == null)
			instance = new ValidationVisitorImpl();
		return instance;
	}

	/**
	 * Default constructor.
	 */
	private ValidationVisitorImpl() {
		super();
	}

	/**
	 * Callback for a AttributeCallExp visit. "source.attribute" Well-formedness
	 * rule: The type of the Attribute call expression is the type of the
	 * referred attribute.
	 * 
	 * @param ac
	 *            the attribute call expression
	 * @return Boolean -- true if validated
	 */
	public Object visitAttributeCallExp(AttributeCallExp ac) {
		EAttribute attr = ac.getReferredAttribute();
		OclExpression source = ac.getSource();
		EClassifier type = ac.getType();

		if (attr == null) {
			String message = NLS.bind(NullAttribute_ERROR_,
				new Object[] {ac.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin
				.throwing(getClass(), "visitAttributeCallExp", error);//$NON-NLS-1$
			throw error;
		}

		if (source == null) {
			String message = NLS.bind(NullSourceAttribute_ERROR_,
				new Object[] {ac.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin
				.throwing(getClass(), "visitAttributeCallExp", error);//$NON-NLS-1$
			throw error;
		}

		if (type == null) {
			String message = NLS.bind(NullTypeAttribute_ERROR_,
				new Object[] {ac.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin
				.throwing(getClass(), "visitAttributeCallExp", error);//$NON-NLS-1$
			throw error;
		}

		visitModelPropertyCallExp(ac);
		
		source.accept(this);

		EClassifier attrType = EcoreEnvironment.getOclType(attr);
		//        EClassifier sourceType = source.getType();
		/*
		 * typeCompare - returns 0 if types are equal. -1 if attrType subType of
		 * sourceType (attrType conforms to sourceType) 1 if attrType superType
		 * of sourceType (sourceType conforms to attrType)
		 */

		if (AnyTypeImpl.typeCompare(attrType, type) == 0)
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}

	/**
	 * Callback for an OperationCallExp visit.
	 * 
	 * Well-formedness rule: All of the arguments must conform to the parameters
	 * of the referred operation. There must be exactly as many arguments as the
	 * referred operation has parameters.
	 * 
	 * @param oc
	 *            the operation call expression
	 * @return Boolean -- true if validated
	 */
	public Object visitOperationCallExp(OperationCallExp oc) {

		OclExpression source = oc.getSource();
		EOperation oper = oc.getReferredOperation();
		int opcode = oc.getOperationCode();
		EList args = oc.getArguments();

		if (oper == null) {
			String message = NLS.bind(NullOperation_ERROR_,
				new Object[] {oc.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin
				.throwing(getClass(), "visitOperationCallExp", error);//$NON-NLS-1$
			throw error;
		}

		if (source == null) {
			String message = NLS.bind(NullSourceOperation_ERROR_,
				new Object[] {oc.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin
				.throwing(getClass(), "visitOperationCallExp", error);//$NON-NLS-1$
			throw error;
		}

		EClassifier sourceType = source.getType();
		int numArgs = args.size();
		String operName = oper.getName();

		for (int i = 0; i < numArgs; i++) {
			((OclExpression) args.get(i)).accept(this);
		}
		
		visitModelPropertyCallExp(oc);
		
		if (opcode == AnyTypeImpl.OCL_IS_NEW) {
			// oclIsNew() may only be used in postcondition constraints
			if (!ExpressionsUtil.isInPostcondition(oc)) {
				
				IllegalArgumentException error = new IllegalArgumentException(
					OclIsNewInPostcondition_ERROR_);
				OclEnginePlugin.throwing(getClass(),
					"visitOperationCallExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		source.accept(this);

		// Check argument conformance.
		try {
			EOperation oper1 = EcoreEnvironment.lookupOperation(sourceType,
				operName, args);
			if (oper1 != oper) {
				String message = NLS.bind(IllegalOperation_ERROR_,
					new Object[] {oc.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitOperationCallExp", error);//$NON-NLS-1$
				throw error;
			}
			EClassifier resultType = null;

			if (sourceType instanceof CollectionType) {
				if (opcode != ((CollectionTypeImpl) sourceType)
					.getOperationCode(operName)) {
					String message = NLS.bind(IllegalOpcode_ERROR_,
						new Object[] {operName });
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OclEnginePlugin.throwing(getClass(),
						"visitOperationCallExp", error);//$NON-NLS-1$
					throw error;
				}
				CollectionTypeImpl ct = (CollectionTypeImpl) sourceType;
				resultType = ct.getResultType(opcode, args);
			} else if (sourceType instanceof PrimitiveType) {
				if (opcode != ((PrimitiveTypeImpl) sourceType)
					.getOperationCode(operName)) {
					String message = NLS.bind(IllegalOpcode_ERROR_,
						new Object[] {operName });
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OclEnginePlugin.throwing(getClass(),
						"visitOperationCallExp", error);//$NON-NLS-1$
					throw error;
				}
				PrimitiveTypeImpl pt = (PrimitiveTypeImpl) sourceType;
				resultType = pt.getResultType(opcode, args);
			} else {
				// source is a tuple, an EClass, or an enumeration
				if (opcode != AnyTypeImpl.OCL_ANY_TYPE
					.getOperationCode(operName)) {
					String message = NLS.bind(IllegalOpcode_ERROR_,
						new Object[] {operName });
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OclEnginePlugin.throwing(getClass(),
						"visitOperationCallExp", error);//$NON-NLS-1$
					throw error;
				}
				resultType = AnyTypeImpl
					.getResultType(sourceType, opcode, args);
				if (resultType == null) {
					resultType = EcoreEnvironment.getOclType(oper);
				}
			}
			if (AnyTypeImpl.typeCompare(resultType, oc.getType()) != 0) {
				String message = NLS.bind(
					TypeConformanceOperation_ERROR_, new Object[] {oc.getType()
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitOperationCallExp", error);//$NON-NLS-1$
				throw error;
			}
		} catch (Exception e) {
			IllegalArgumentException error = new IllegalArgumentException(e
				.getMessage());
			OclEnginePlugin
				.throwing(getClass(), "visitOperationCallExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for an EnumLiteralExp visit. Well-formedness rule: The type of
	 * an enum Literal expression is the type of the referred literal.
	 * 
	 * @param el
	 *            the enumeration literal expresion
	 * @return Boolean -- true if validated
	 */
	public Object visitEnumLiteralExp(EnumLiteralExp el) {
		EEnumLiteral l = el.getReferredEnumLiteral();
		EClassifier type = el.getType();
		if (!(type instanceof EEnum) || l.getEEnum() != type) {
			String message = NLS.bind(IllegalEnumLiteral_ERROR_,
				new Object[] {el.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitEnumLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for a VariableExp visit. Well-formedness rule: The type of a
	 * VariableExp is the type of the Variable to which it refers.
	 * 
	 * @param v
	 *            the variable expression
	 * @return Boolean -- true if validated
	 */
	public Object visitVariableExp(VariableExp v) {
		// get the referred variable name
		VariableDeclaration vd = v.getReferredVariable();

		if (vd == null || v.getType() == null || vd.getVarName() == null
			|| vd.getType() == null) {
			String message = NLS.bind(
				IncompleteVariableDeclaration_ERROR_, new Object[] {v
					.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitVariableExp", error);//$NON-NLS-1$
			throw error;
		}
		vd.accept(this);
		if (AnyTypeImpl.typeCompare(vd.getType(), v.getType()) != 0) {
			IllegalArgumentException error = new IllegalArgumentException(
				VariableTypeMismatch_ERROR_);
			OclEnginePlugin.throwing(getClass(), "visitVariableExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for an AssociationEndCallExp visit. Well-formedness rule: The
	 * type of the AssociationEndCallExp is the type of the referred EReference.
	 * 
	 * @param ae
	 *            the association end expression
	 * @return Boolean -- true if validated
	 */
	public Object visitAssociationEndCallExp(AssociationEndCallExp ae) {
		EReference ref = ae.getReferredAssociationEnd();
		OclExpression source = ae.getSource();
		EClassifier type = ae.getType();

		if (ref == null) {
			String message = NLS.bind(NullAssociation_ERROR_,
				new Object[] {ae.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitAssociationEndCallExp", error);//$NON-NLS-1$
			throw error;
		}
		if (source == null) {
			String message = NLS.bind(NullSourceAssociation_ERROR_,
				new Object[] {ae.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitAssociationEndCallExp", error);//$NON-NLS-1$
			throw error;
		}
		if (type == null) {
			String message = NLS.bind(NullTypeAssociation_ERROR_,
				new Object[] {ae.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitAssociationEndCallExp", error);//$NON-NLS-1$
			throw error;
		}
		
		visitModelPropertyCallExp(ae);
		
		source.accept(this);

		EClassifier refType = EcoreEnvironment.getOclType(ref);
		//        EClassifier sourceType = source.getType();
		/*
		 * typeCompare - returns 0 if types are equal. -1 if attrType subType of
		 * sourceType (attrType conforms to sourceType) 1 if attrType superType
		 * of sourceType (sourceType conforms to attrType)
		 */

		if (AnyTypeImpl.typeCompare(refType, type) == 0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Callback for an AssociationClassCallExp visit. Well-formedness rules:
	 * <ul>
	 *   <li>the type of the AssociationClassCallExp is the type of the
	 *       referenced EReference</li>
	 *   <li>the referenced EReference is an AssociationClassEnd, and its
	 *       associationClass reference is not null</li>
	 * </ul>
	 * 
	 * @param ae
	 *            the association end expression
	 * @return Boolean -- true if validated
	 */
	public Object visitAssociationClassCallExp(AssociationClassCallExp ae) {
		EClass ref = ae.getReferredAssociationClass();
		OclExpression source = ae.getSource();
		EClassifier type = ae.getType();

		if (ref == null) {
			String message = NLS.bind(MissingAssociationClass_ERROR_,
				new Object[] {ae.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitAssociationClassCallExp", error);//$NON-NLS-1$
			throw error;
		}
		if (source == null) {
			String message = NLS.bind(NullSourceAssociation_ERROR_,
				new Object[] {ae.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitAssociationClassCallExp", error);//$NON-NLS-1$
			throw error;
		}
		if (type == null) {
			String message = NLS.bind(NullTypeAssociation_ERROR_,
				new Object[] {ae.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitAssociationClassCallExp", error);//$NON-NLS-1$
			throw error;
		}
		
		visitModelPropertyCallExp(ae);
		
		source.accept(this);

		EClassifier refType = EcoreEnvironment.getOclType(ref);

		if (AnyTypeImpl.typeCompare(refType, type) == 0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	/**
	 * Callback for a VariableDeclaration visit. Well-formedness rule: The type
	 * of the initExpression must conform to the type of the declared variable.
	 * 
	 * @param vd --
	 *            variable declaration
	 * @return Boolean -- true if validated
	 */
	public Object visitVariableDeclaration(VariableDeclaration vd) {
		String varName = vd.getVarName();
		if (varName == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				MissingNameInVariableDeclaration_ERROR_);
			OclEnginePlugin.throwing(getClass(),
				"visitVariableDeclaration", error);//$NON-NLS-1$
			throw error;
		}
		EClassifier type = vd.getType();
		OclExpression init = vd.getInitExpression();

		if (init != null) {
			init.accept(this);
			if (AnyTypeImpl.typeCompare(init.getType(), type) > 0) {
				IllegalArgumentException error = new IllegalArgumentException(
					TypeConformanceInit_ERROR_);
				OclEnginePlugin.throwing(getClass(),
					"visitVariableDeclaration", error);//$NON-NLS-1$
				throw error;
			}
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for an IfExp visit. Well-formedness Rule: The type of the
	 * condition must be Boolean. The type of the if expression is the common
	 * supertype of the then and else
	 * 
	 * @param i -
	 *            if expression
	 * @return Boolean -- true if validated
	 */
	public Object visitIfExp(IfExp i) {
		OclExpression cond = i.getCondition();
		OclExpression thenexp = i.getThenExpression();
		OclExpression elseexp = i.getElseExpression();

		if (cond == null || thenexp == null | elseexp == null) {
			String message = NLS.bind(IncompleteIfExp_ERROR_,
				new Object[] {i.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIfExp", error);//$NON-NLS-1$
			throw error;
		}
		cond.accept(this);
		thenexp.accept(this);
		elseexp.accept(this);
		if (cond.getType() != PrimitiveTypeImpl.OCL_BOOLEAN) {
			String message = NLS.bind(NonBooleanIfExp_ERROR_,
				new Object[] {i.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIfExp", error);//$NON-NLS-1$
			throw error;
		}
		EClassifier thenelsetype = null;
		try {
			thenelsetype = AnyTypeImpl.commonSuperType(thenexp.getType(),
				elseexp.getType());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		if (AnyTypeImpl.typeCompare(i.getType(), thenelsetype) != 0) {
			String message = NLS.bind(TypeConformanceIfExp_ERROR_,
				new Object[] {i.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIfExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for an UnspecifiedValueExp visit.
	 * 
	 * @param uv --
	 *            unspecified value expression
	 * @return Boolean -- true if validated
	 */
	public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		return Boolean.TRUE;
	}

	/**
	 * Callback for an IntegerLiteralExp visit. Well-formedness rule: The type
	 * of an integer Literal expression is the type Integer
	 * 
	 * @param il -
	 *            integer literal expression
	 * @return Boolean -- true if validated
	 */
	public Object visitIntegerLiteralExp(IntegerLiteralExp il) {
		if (il.getType() != PrimitiveTypeImpl.OCL_INTEGER) {
			IllegalArgumentException error = new IllegalArgumentException(
				TypeConformanceIntegerLiteral_ERROR_);
			OclEnginePlugin.throwing(getClass(),
				"visitIntegerLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for a RealLiteralExp visit. Well-formedness rule: The type of a
	 * real literal expression is the type Real.
	 * 
	 * @param rl --
	 *            real literal expression
	 * @return Boolean -- true if validated
	 */
	public Object visitRealLiteralExp(RealLiteralExp rl) {
		if (rl.getType() != PrimitiveTypeImpl.OCL_REAL) {
			IllegalArgumentException error = new IllegalArgumentException(
				TypeConformanceRealLiteral_ERROR_);
			OclEnginePlugin.throwing(getClass(), "visitRealLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for a StringLiteralExp visit. Well-formedness rule: The type of
	 * a string literal expression is the type of the string.
	 * 
	 * @param sl --
	 *            string literal expression
	 * @return Boolean -- true if validated
	 */
	public Object visitStringLiteralExp(StringLiteralExp sl) {
		if (sl.getType() != PrimitiveTypeImpl.OCL_STRING) {
			IllegalArgumentException error = new IllegalArgumentException(
				TypeConformanceStringLiteral_ERROR_);
			OclEnginePlugin
				.throwing(getClass(), "visitStringLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for a BooleanLiteralExp visit. Well-formedness rule: The type of
	 * a Boolean Literal expression is the type of the boolean.
	 * 
	 * @param bl -
	 *            boolean literal expression
	 * @return Boolean - true if validated
	 */
	public Object visitBooleanLiteralExp(BooleanLiteralExp bl) {
		if (bl.getType() != PrimitiveTypeImpl.OCL_BOOLEAN) {
			IllegalArgumentException error = new IllegalArgumentException(
				TypeConformanceBooleanLiteral_ERROR_);
			OclEnginePlugin.throwing(getClass(),
				"visitBooleanLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for LetExp visit. Well-formedness rule: The type of the Let
	 * expression is the type of the in expression.
	 * 
	 * @param l --
	 *            let expression
	 * @return Boolean -- true if validated
	 */
	public Object visitLetExp(LetExp l) {
		VariableDeclaration vd = l.getVariable();
		OclExpression in = l.getIn();
		EClassifier type = l.getType();

		if (vd == null || in == null || type == null) {
			String message = NLS.bind(IncompleteLetExp_ERROR_,
				new Object[] {l.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitLetExp", error);//$NON-NLS-1$
			throw error;
		}

		vd.accept(this);
		in.accept(this);

		if (AnyTypeImpl.typeCompare(type, in.getType()) != 0) {
			String message = NLS.bind(TypeConformanceLetExp_ERROR_,
				new Object[] {type, in.getType() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitLetExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * 
	 * Callback for an IterateExp visit. *Well-formedness rule: The type of the
	 * iterate is the type of the result variable. The type of the body
	 * expression must conform to the declared type of the result variable. *A
	 * result variable must have an init expression. *The type of a source
	 * expression must be a collection. *The loop variable has no init
	 * expression. *The type of the iterator variable must be the type of the
	 * elements of the *source collection.
	 * 
	 * @param ie -
	 *            iterate expression
	 * @return Boolean -- true if validated
	 */
	public Object visitIterateExp(IterateExp ie) {
		// get the variable declaration for the result
		VariableDeclaration vd = ie.getResult();
		EClassifier type = ie.getType();
		OclExpression body = ie.getBody();
		OclExpression source = ie.getSource();
		EList iterators = ie.getIterators();

		if (vd == null || type == null || source == null || body == null
			|| iterators.isEmpty()) {
			String message = NLS.bind(IncompleteIterateExp_ERROR_,
				new Object[] {ie.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		int numIters = iterators.size();

		// Validate all of the iterate parts
		source.accept(this);
		vd.accept(this);
		body.accept(this);

		if (vd.getInitExpression() == null) {
			String message = NLS.bind(MissingInitIterateExp_ERROR_,
				new Object[] {ie.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		if (AnyTypeImpl.typeCompare(type, vd.getType()) != 0) {
			String message = NLS.bind(TypeConformanceIterateExp_ERROR_,
				new Object[] { ie.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}
		if (AnyTypeImpl.typeCompare(body.getType(), vd.getType()) > 0) {
			String message = NLS.bind(
				TypeConformanceIterateExpBody_ERROR_, new Object[] {ie
					.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		EClassifier sourceType = source.getType();
		if (!(sourceType instanceof CollectionType)) {
			String message = NLS.bind(IteratorSource_ERROR_,
				new Object[] {ie.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		for (int i = 0; i < numIters; i++) {
			VariableDeclaration loopiter = (VariableDeclaration) iterators
				.get(i);
			// Validate the iterator expressions
			loopiter.accept(this);
			if (loopiter.getInitExpression() != null) {
				String message = NLS.bind(
					MissingInitIterateExpLoopVar_ERROR_, new Object[] {ie
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
				throw error;
			}
			if (AnyTypeImpl.typeCompare(loopiter.getType(),
				((CollectionType) sourceType).getElementType()) != 0) {
				String message = NLS.bind(
					TypeConformanceIterateExpLoopVar_ERROR_, new Object[] {ie
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for an IteratorExp visit. Well-formedness rule: If the iterator
	 * is "forall", "isUnique", "any", "one", or "exists", the type of the
	 * iterator must be Boolean. The result type of the collect operation on a
	 * sequence type is a sequence; the result type of collect on any other type
	 * is a bag. The select and reject iterators have the same type as its
	 * source. They type of the body of the select, reject, forall, exists must
	 * be boolean. The type of a source expression must be a collection. The
	 * loop variable has no init expression. The type of the iterator variable
	 * must be the type of the elements of the source collection.
	 * 
	 * @param ie --
	 *            iterator expression
	 * @return Boolean -- true if validated
	 */
	public Object visitIteratorExp(IteratorExp ie) {
		EClassifier type = ie.getType();
		OclExpression body = ie.getBody();
		OclExpression source = ie.getSource();
		EList iterators = ie.getIterators();
		String name = ie.getName();

		if (type == null || name == null || source == null || body == null
			|| iterators.isEmpty()) {
			String message = NLS.bind(IncompleteIteratorExp_ERROR_,
				new Object[] {ie.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
			throw error;
		}

		int numIters = iterators.size();

		// Validate all of the iterate parts
		source.accept(this);
		body.accept(this);

		if (name.equals("forAll") || name.equals("exists") || name.equals("isUnique")) {//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			if (type != PrimitiveTypeImpl.OCL_BOOLEAN) {
				String message = NLS.bind(
					TypeConformanceIteratorResult_ERROR_, new Object[] {ie
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		if (name.equals("collect")) { //$NON-NLS-1$
			if (source.getType() instanceof SequenceType
				|| source.getType() instanceof OrderedSetType) {
				if (!(type instanceof SequenceType)) {
					String message = NLS.bind(
						TypeConformanceCollectSequence_ERROR_, new Object[] {ie
							.toString() });
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OclEnginePlugin.throwing(getClass(),
						"visitIteratorExp", error);//$NON-NLS-1$
					throw error;
				}
			} else if (!(type instanceof BagType)) {
				String message = NLS.bind(
					TypeConformanceCollectBag_ERROR_, new Object[] {ie
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		if (name.equals("select") || name.equals("reject")) {//$NON-NLS-2$//$NON-NLS-1$
			if (AnyTypeImpl.typeCompare(type, source.getType()) != 0) {
				String message = NLS.bind(
					TypeConformanceSelectReject_ERROR_, new Object[] {ie
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		if (name.equals("select") || name.equals("reject") || name.equals("forAll") //$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			|| name.equals("any") || name.equals("exists") || name.equals("one")) {//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			if (body.getType() != PrimitiveTypeImpl.OCL_BOOLEAN) {
				String message = NLS.bind(
					TypeConformanceIterateExpBodyBoolean_ERROR_,
					new Object[] {ie.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		EClassifier sourceType = source.getType();
		if (!(sourceType instanceof CollectionType)) {
			String message = NLS.bind(IteratorSource_ERROR_,
				new Object[] {ie.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
			throw error;
		}

		for (int i = 0; i < numIters; i++) {
			VariableDeclaration loopiter = (VariableDeclaration) iterators
				.get(i);
			// Validate the iterator expressions
			loopiter.accept(this);
			if (loopiter.getInitExpression() != null) {
				String message = NLS.bind(
					MissingInitIterateExpLoopVar_ERROR_, new Object[] {ie
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
			if (AnyTypeImpl.typeCompare(loopiter.getType(),
				((CollectionType) sourceType).getElementType()) != 0) {
				String message = NLS.bind(
					TypeConformanceIterateExpLoopVar_ERROR_, new Object[] {ie
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		return Boolean.TRUE;
	}

	/**
	 * Callback for a CollectionLiteralExp visit. Well-formedness rule: The type
	 * of a collection literal expression is determined by the collection kind
	 * selection, and the common supertype of all elements. The empty collection
	 * has an OclVoid as element type.
	 * 
	 * @param cl --
	 *            collection literal expression
	 * @return Boolean -- true if validated
	 */
	public Object visitCollectionLiteralExp(CollectionLiteralExp cl) {

		CollectionKind kind = cl.getKind();
		EClassifier collectionType = cl.getType();
		if (collectionType == null
			|| !(collectionType instanceof CollectionType)) {
			String message = NLS.bind(
				TypeConformanceCollectionLiteralExp_ERROR_, new Object[] {cl
					.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitCollectionLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		if (kind == CollectionKind.SET_LITERAL) {
			if (!(collectionType instanceof SetType)) {
				String message = NLS.bind(
					TypeConformanceSetLiteral_ERROR_, new Object[] {cl
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitCollectionLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		} else if (kind == CollectionKind.ORDERED_SET_LITERAL) {
			if (!(collectionType instanceof OrderedSetType)) {
				String message = NLS.bind(
					TypeConformanceOrderedSetLiteral_ERROR_, new Object[] {cl
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitCollectionLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		} else if (kind == CollectionKind.BAG_LITERAL) {
			if (!(collectionType instanceof BagType)) {
				String message = NLS.bind(
					TypeConformanceBagLiteral_ERROR_, new Object[] {cl
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitCollectionLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		} else if (kind != CollectionKind.SEQUENCE_LITERAL
			|| !(collectionType instanceof SequenceType)) {
			String message = NLS.bind(
				TypeConformanceSequenceLiteral_ERROR_, new Object[] {cl
					.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitCollectionLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		List parts = cl.getParts();
		if (parts.isEmpty()) {
			if (((CollectionType) collectionType).getElementType() != Types.OCL_VOID) {
				String message = NLS.bind(
					TypeConformanceEmptyCollection_ERROR_, new Object[] {cl
						.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitCollectionLiteralExp", error);//$NON-NLS-1$
				throw error;
			} else
				return Boolean.TRUE;
		}

		EClassifier partsType = ((CollectionLiteralPart) parts.get(0))
			.getType();

		for (Iterator it = parts.iterator(); it.hasNext();) {
			CollectionLiteralPart part = (CollectionLiteralPart) it.next();

			if (part instanceof CollectionItem) {
				((CollectionItem) part).getItem().accept(this);
			} else {
				((CollectionRange) part).getFirst().accept(this);
				((CollectionRange) part).getLast().accept(this);
			}
			try {
				partsType = AnyTypeImpl.commonSuperType(partsType, part
					.getType());
			} catch (Exception e) {
				throw new IllegalArgumentException(e.getMessage());
			}

		}
		if (AnyTypeImpl.typeCompare(partsType,
			((CollectionType) collectionType).getElementType()) != 0) {
			String message = NLS.bind(
				TypeConformanceCollectionElementType_ERROR_, new Object[] {cl
					.toString() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(getClass(),
				"visitCollectionLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 * 
	 * Well-formedness rule: The type of a tuple literal is a TupleType the
	 * specified parts All tuple literal expression parts must have unique
	 * names. The type of each attribute in a tuple literal part must match the
	 * type of the initialization expression.
	 * 
	 * @param tl
	 *            tuple literal expression
	 * @return Boolean
	 */
	public Object visitTupleLiteralExp(TupleLiteralExp tl) {

		EClassifier type = tl.getType();
		if (!(type instanceof TupleType)) {
			IllegalArgumentException error = new IllegalArgumentException(
				TypeConformanceTupleLiteralExp_ERROR_);
			OclEnginePlugin.throwing(getClass(), "visitTupleLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		//EClass eclazz = type.eClass();
		EClass eclazz = (EClass) type;
		// The fields of the tuple are the attributes and references of the
		// EClass.
		EList attribs = eclazz.getEAttributes();
		EList refs = eclazz.getEReferences();

		EList tp = tl.getTuplePart();
		if (tp.size() != attribs.size() + refs.size()) {
			IllegalArgumentException error = new IllegalArgumentException(
				TypeConformanceTupleLiteralExpParts_ERROR_);
			OclEnginePlugin.throwing(getClass(), "visitTupleLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		// Match each attribute with a tuple part entry
		// Tuple parts are Variable declarations
		Iterator piter = attribs.iterator();
		while (piter.hasNext()) {
			EAttribute attr = (EAttribute) piter.next();
			Iterator iter = tp.iterator();
			boolean found = false;
			while (iter.hasNext()) {
				VariableDeclaration vdcl = (VariableDeclaration) iter.next();
				if (vdcl.getVarName().equals(attr.getName())) {
					found = true;
					break;
				}
			}
			if (!found) {
				String message = NLS.bind(
					TupleLiteralExpressionAttribName_ERROR_, new Object[] {
						attr.getName(), tl.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitTupleLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		// Match each reference with a tuple part entry.
		piter = refs.iterator();
		while (piter.hasNext()) {
			EReference ref = (EReference) piter.next();
			Iterator iter = tp.iterator();
			boolean found = false;
			while (iter.hasNext()) {
				VariableDeclaration vdcl = (VariableDeclaration) iter.next();
				if (vdcl.getVarName().equals(ref.getName())) {
					found = true;
					break;
				}
			}
			if (!found) {
				String message = NLS.bind(
					TupleLiteralExpressionRefName_ERROR_, new Object[] {
						ref.getName(), tl.toString() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitTupleLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		// Validate each VariableDeclaration in the tuple part
		// At the same time, check for unique names
		Iterator iter = tp.iterator();
		Set names = new HashSet();
		while (iter.hasNext()) {
			VariableDeclaration vdcl = (VariableDeclaration) iter.next();
			String name = vdcl.getVarName();
			if (names.contains(name)) {
				String message = NLS.bind(
					TupleDuplicateName_ERROR_, new Object[] {name });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitTupleLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
			names.add(name);
			vdcl.accept(this);
		}
		return Boolean.TRUE;
	}
	
	/**
	 * Applies well-formedness rules to constraints.
	 * 
	 * @param constraint the constraint to validate
	 */
	public Object visitConstraint(Constraint constraint) {
		String stereo = constraint.getStereotype();


		EClassifier bodyType = constraint.getBody().getType();
		EClassifier operationType = null;
		String operationName = null;
		
		if (!constraint.getConstrainedElement().isEmpty()) {
			Object constrained = constraint.getConstrainedElement().get(0);
			
			if (constrained instanceof EOperation) {
				EOperation operation = (EOperation) constrained;
				operationName = operation.getName();
				
				if (operation.getEType() != null) {
					operationType = EcoreEnvironment.getOclType(operation);
				}
			}
		}
		
		if (operationType == null) {
			operationType = Types.OCL_VOID;
		}
		
		if (Constraint.BODY.equals(stereo)
				|| Constraint.POSTCONDITION.equals(stereo)
				|| Constraint.PRECONDITION.equals(stereo)) {
			// operation constraints must be boolean-valued
			if (!(bodyType instanceof PrimitiveBoolean)) {
				String message = NLS.bind(
					OperationConstraintBoolean_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		if (Constraint.BODY.equals(constraint.getStereotype())) {
			if (operationType instanceof VoidType) {
				String message = NLS.bind(
					BodyConditionNotAllowed_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			// the expression must be of the form result = <expr> or
			//    <expr> = result, where <expr> is some expression whose type
			//    conforms to the operation type.  However, this expression is
			//    allowed to be nested inside any number of lets for the user's
			//    convenience
			OclExpression exp = constraint.getBody();
			while (exp instanceof LetExp) {
				exp = ((LetExp) exp).getIn();
			}
			OperationCallExp body = null;
			if (exp instanceof OperationCallExp) {
				body = (OperationCallExp) exp;
			}
			
			// two definitions of the "equals" operation
			if ((body == null)
					|| ((body.getOperationCode() != AnyTypeImpl.EQUAL)
							&& (body.getOperationCode() != CollectionTypeImpl.EQUALS))
					|| (body.getArguments().size() != 1)) {
				String message = NLS.bind(
					BodyConditionForm_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			OclExpression bodyExpr;
			
			if (isResultVariable(body.getSource(), operationType)) {
				bodyExpr = (OclExpression) body.getArguments().get(0);
			} else if (isResultVariable(
					(OclExpression) body.getArguments().get(0),
					operationType)) {
				bodyExpr = body.getSource();
			} else {
				String message = NLS.bind(
					BodyConditionForm_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			bodyType = bodyExpr.getType();
			
			try {
				if (AnyTypeImpl.typeCompare(bodyType, operationType) > 0) {
					String message = NLS.bind(
						BodyConditionConformance_ERROR_,
						new Object[] {
							operationName,
							bodyType.getName(),
							operationType.getName()});
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OclEnginePlugin.throwing(getClass(),
						"visitConstraint", error);//$NON-NLS-1$
					throw error;
				}
			} catch (IllegalArgumentException e) {
				// types are not even comparable
				String message = NLS.bind(
					BodyConditionConformance2_ERROR_,
					operationName, e.getLocalizedMessage());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			// one last check:  does the "body" part of the condition include
			//    the result variable?  It must not
			if (findResultVariable(bodyExpr, operationType)) {
				String message = NLS.bind(
					BodyConditionForm_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		// check the body condition, itself, for well-formedness
		return constraint.getBody().accept(this);
	}
	
	/**
	 * Determines whether the specified expression is a reference to the
	 * special <code>result</code> variable of an operation body constraint.
	 * 
	 * @param expr an OCL expression
	 * @param expectedType the expected type of the result variable (i.e.,
	 *     the operation type
	 * 
	 * @return <code>true</code> if it is the result variable;
	 *     <code>false</code>, otherwise
	 */
	private static boolean isResultVariable(OclExpression expr, EClassifier expectedType) {
		// the implicitly defined "result" variable always has the same type
		//    as the operation
		boolean result = (expr instanceof VariableExp);
		
		if (result) {
			try {
				result = AnyTypeImpl.typeCompare(expr.getType(), expectedType) == 0;
			} catch (Exception e) {
				// get an exception on incompatible types.  This is expected
				result = false;
			}
		}
		
		if (result) {
			VariableDeclaration var = ((VariableExp) expr).getReferredVariable();
			
			result = (var != null) && "result".equals(var.getVarName()); //$NON-NLS-1$
		}
		
		return result;
	}
	
	/**
	 * Queries whether the special <code>result</code> variable can be found
	 * anywhere in the specified OCL expression.
	 * 
	 * @param expr the expression to search
	 * @param expectedType the expected type of the result variable
	 * 
	 * @return <code>true</code> if it includes some reference to the result
	 *    variable; <code>false</code>, otherwise
	 */
	private static boolean findResultVariable(OclExpression expr, final EClassifier expectedType) {
		class ResultFinder extends AbstractVisitor {
			boolean found = false;
			
			public Object visitVariableExp(VariableExp v) {
				if (isResultVariable(v, expectedType)) {
					found = true;
				}
				
				// no need to call super because this is a leaf expression
				return null;
			}
		}
		
		ResultFinder finder = new ResultFinder();
		expr.accept(finder);
		
		return finder.found;
	}
	
	/**
	 * Applies well-formedness rules for model property calls in general.
	 * This includes checking that "@pre" notation is only used in a
	 * postcondition constraint.
	 * 
	 * @param exp the model property call expression to validate
	 */
	private void visitModelPropertyCallExp(ModelPropertyCallExp exp) {
		if (exp.isMarkedPre()) {
			// check for a postcondition constraint
			if (!ExpressionsUtil.isInPostcondition(exp)) {
				
				IllegalArgumentException error = new IllegalArgumentException(
					AtPreInPostcondition_ERROR_);
				OclEnginePlugin.throwing(getClass(),
					"visitModelPropertyCallExp", error);//$NON-NLS-1$
				throw error;
			}
		}
	}
} // ValidationVisitorImpl


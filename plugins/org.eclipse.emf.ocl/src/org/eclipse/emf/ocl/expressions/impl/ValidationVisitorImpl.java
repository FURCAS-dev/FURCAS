/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: ValidationVisitorImpl.java,v 1.8 2006/04/28 14:46:28 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.FeatureCallExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.InvalidLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.MessageExp;
import org.eclipse.emf.ocl.expressions.NullLiteralExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StateExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.util.AbstractVisitor;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypeType;
import org.eclipse.emf.ocl.types.VoidType;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.UMLPackage;
import org.eclipse.emf.ocl.utilities.ASTNode;
import org.eclipse.emf.ocl.utilities.PredefinedType;

/**
 * @author Edith Schonberg (edith)
 * 
 * Checks the well-formedness rules for the expressions package
 */
public class ValidationVisitorImpl
	implements Visitor {

	private static Environment NULL_ENVIRONMENT = new NullEnvironment();
	
	private Environment environment = null;
	
	/**
	 * Obtains an instance of the validation visitor that assumes an Ecore
	 * environment, inferred from the context of the constraint being validated.
	 * 
	 * @return a validation visitor instance
	 */
	public static Visitor getInstance() {
		return new ValidationVisitorImpl(null);
	}
	
	/**
	 * Obtains an instance of the validation visitor that validates against the
	 * specified environment, which presumably was used in parsing the OCL in
	 * the first place.
	 * 
	 * @param environment an OCL environment
	 * 
	 * @return a validation visitor instance for the specified environment
	 */
	public static Visitor getInstance(Environment environment) {
		return new ValidationVisitorImpl(environment);
	}

	/**
	 * Default constructor.
	 * 
	 * @param environment the environment
	 */
	private ValidationVisitorImpl(Environment environment) {
		super();
		
		this.environment = environment;
	}
	
	/**
	 * Obtains the current environment, which may be inferred from the context
	 * of the constraint that we are validating.
	 * 
	 * @param node an AST node from which possibly to infer the environment.
	 *     If <code>null</code>, it will be assumed that we were initialized
	 *     with an environment
	 *     
	 * @return a suitable environment, or a default if no node was
	 *     provide for inference and we were not initialized with an explicit
	 *     environment
	 */
	protected Environment getEnvironment(ASTNode node) {
		Environment result = environment;
		
		if (result == null) {
			if (node != null) {
				result = createEcoreEnvironment(node);
			}
			
			if (result == null) {
				result = NULL_ENVIRONMENT;
			}
			
			environment = result;  // cache the result
		}
		
		return result;
	}
	
	/**
	 * Creates an Ecore environment from the context of an AST node.
	 * 
	 * @param node an AST node in the OCL constraint being validated
	 * 
	 * @return the appropriate environment
	 */
	private Environment createEcoreEnvironment(ASTNode node) {
		Environment result = null;
		
		Object context = null;
		Constraint constraint = (Constraint) ExpressionsUtil.containerOfType(
				UMLPackage.Literals.CONSTRAINT, node);
		
		if ((constraint != null) && !constraint.getConstrainedElement().isEmpty()) {
			context = constraint.getConstrainedElement().get(0);
			
			if (context instanceof EClassifier) {
				result = ExpressionsUtil.createClassifierContext(
						(EClassifier) context);
			} else if (context instanceof EOperation) {
				result = ExpressionsUtil.createOperationContext(
						(EOperation) context);
			} else if (context instanceof EStructuralFeature) {
				result = ExpressionsUtil.createPropertyContext(
						(EStructuralFeature) context);
			}
		}
		
		return result;
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

		OCLExpression source = oc.getSource();
		EOperation oper = oc.getReferredOperation();
		int opcode = oc.getOperationCode();
		EList args = oc.getArgument();

		if (oper == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullOperation_ERROR_,
					oc.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin
				.throwing(getClass(), "visitOperationCallExp", error);//$NON-NLS-1$
			throw error;
		}

		if (source == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullSourceOperation_ERROR_,
					oc.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin
				.throwing(getClass(), "visitOperationCallExp", error);//$NON-NLS-1$
			throw error;
		}

		EClassifier sourceType = source.getType();
		int numArgs = args.size();
		String operName = oper.getName();

		for (int i = 0; i < numArgs; i++) {
			((OCLExpression) args.get(i)).accept(this);
		}
		
		visitFeatureCallExp(oc);
		
		if (opcode == PredefinedType.OCL_IS_NEW) {
			// oclIsNew() may only be used in postcondition constraints
			if (!ExpressionsUtil.isInPostcondition(oc)) {
				
				IllegalArgumentException error = new IllegalArgumentException(
						OCLMessages.OCLIsNewInPostcondition_ERROR_);
				OCLPlugin.throwing(getClass(),
					"visitOperationCallExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		source.accept(this);

		// Check argument conformance.
		try {
			EOperation oper1 = getEnvironment(oc).lookupOperation(sourceType,
				operName, args);
			if (oper1 != oper) {
				String message = OCLMessages.bind(
						OCLMessages.IllegalOperation_ERROR_,
						oc.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitOperationCallExp", error);//$NON-NLS-1$
				throw error;
			}
			
			if (!getEnvironment(oc).isQuery(oper)) {
				String message = OCLMessages.bind(
						OCLMessages.NonQueryOperation_ERROR_,
						oper.getName());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitOperationCallExp", error);//$NON-NLS-1$
				throw error;
			}
			
			EClassifier resultType = null;

			if (sourceType instanceof PredefinedType) {
				PredefinedType pt = (PredefinedType) sourceType;
				
				if (opcode != pt.getOperationCodeFor(operName)) {
					String message = OCLMessages.bind(
							OCLMessages.IllegalOpcode_ERROR_,
							operName);
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OCLPlugin.throwing(getClass(),
						"visitOperationCallExp", error);//$NON-NLS-1$
					throw error;
				}
				
				resultType = pt.getResultTypeFor(sourceType, opcode, args);
			} else {
				// source is an EClass, an enumeration, or a user data type
				if (opcode != AnyTypeImpl.getOperationCode(operName)) {
					String message = OCLMessages.bind(
							OCLMessages.IllegalOpcode_ERROR_,
							operName);
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OCLPlugin.throwing(getClass(),
						"visitOperationCallExp", error);//$NON-NLS-1$
					throw error;
				}
				resultType = AnyTypeImpl
					.getResultType(sourceType, opcode, args);
				if (resultType == null) {
					resultType = TypeUtil.getOCLType(oper);
				}
			}
			if (TypeUtil.typeCompare(resultType, oc.getType()) != 0) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceOperation_ERROR_,
						oc.getType().toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitOperationCallExp", error);//$NON-NLS-1$
				throw error;
			}
		} catch (Exception e) {
			IllegalArgumentException error = new IllegalArgumentException(e
				.getMessage());
			OCLPlugin
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
			String message = OCLMessages.bind(
					OCLMessages.IllegalEnumLiteral_ERROR_,
					el.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitEnumLiteralExp", error);//$NON-NLS-1$
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
		Variable vd = v.getReferredVariable();

		if (vd == null || v.getType() == null || vd.getName() == null
			|| vd.getType() == null) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteVariableExp_ERROR_,
					v.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitVariableExp", error);//$NON-NLS-1$
			throw error;
		}
		vd.accept(this);
		if (TypeUtil.typeCompare(vd.getType(), v.getType()) != 0) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(OCLMessages.VariableTypeMismatch_ERROR_, vd.getName()));
			OCLPlugin.throwing(getClass(), "visitVariableExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	/**
	 * Callback for an PropertyCallExp visit. Well-formedness rule: The
	 * type of the PropertyCallExp is the type of the referred
	 * EStructuralFeature.
	 * 
	 * @param pc the property call expression
	 * @return Boolean -- true if validated
	 */
	public Object visitPropertyCallExp(PropertyCallExp pc) {
		EStructuralFeature property = pc.getReferredProperty();
		OCLExpression source = pc.getSource();
		EClassifier type = pc.getType();

		if (property == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullProperty_ERROR_,
					pc.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitPropertyCallExp", error);//$NON-NLS-1$
			throw error;
		}
		
		if (source == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationSource_ERROR_,
					pc.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitPropertyCallExp", error);//$NON-NLS-1$
			throw error;
		}
		if (type == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationType_ERROR_,
					pc.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitPropertyCallExp", error);//$NON-NLS-1$
			throw error;
		}
		
		EList qualifiers = pc.getQualifier();
		if (!qualifiers.isEmpty()) {
			// navigation qualifiers must conform to expected qualifier types
			EList expectedQualifierTypes = getEnvironment(pc).getQualifiers(property);
			
			if (expectedQualifierTypes.size() != qualifiers.size()) {
				String message = OCLMessages.bind(
						OCLMessages.MismatchedQualifiers_ERROR_,
						pc.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitPropertyCallExp", error);//$NON-NLS-1$
				throw error;
			} else {
				Iterator eiter = expectedQualifierTypes.iterator();
				Iterator qiter = qualifiers.iterator();
				
				while (eiter.hasNext()) {
					EClassifier expectedType = TypeUtil.getOCLType(
							(ETypedElement) eiter.next());
					OCLExpression qualifier = (OCLExpression) qiter.next();
					
					EClassifier qualifierType = qualifier.getType();
					if ((TypeUtil.getRelationship(qualifierType, expectedType)
							& PredefinedType.SUBTYPE) == 0) {
						
						String message = OCLMessages.bind(
								OCLMessages.MismatchedQualifiers_ERROR_,
								pc.toString());
						IllegalArgumentException error = new IllegalArgumentException(
							message);
						OCLPlugin.throwing(getClass(),
							"visitPropertyCallExp", error);//$NON-NLS-1$
						throw error;
					}
				}
			}
		}
		
		visitFeatureCallExp(pc);
		
		source.accept(this);

		EClassifier refType = TypeUtil.getOCLType(property);
		
		if (!pc.getQualifier().isEmpty() && (refType instanceof CollectionType)) {
			// qualifying the navigation results in a non-collection
			//    type
			refType = ((CollectionType) refType).getElementType();
		}
		
		return Boolean.valueOf(TypeUtil.typeCompare(refType, type) == 0);
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
		OCLExpression source = ae.getSource();
		EClassifier type = ae.getType();

		if (ref == null) {
			String message = OCLMessages.bind(
					OCLMessages.MissingAssociationClass_ERROR_,
					ae.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitAssociationClassCallExp", error);//$NON-NLS-1$
			throw error;
		}
		
		if (source == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationSource_ERROR_,
					ae.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitAssociationClassCallExp", error);//$NON-NLS-1$
			throw error;
		}
		EClassifier sourceType = source.getType();
		
		if (type == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationType_ERROR_,
					ae.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitAssociationClassCallExp", error);//$NON-NLS-1$
			throw error;
		}
		
		if (ae.getNavigationSource() != null) {
			// navigation source must be an end of the association class
			EStructuralFeature end = ae.getNavigationSource();
			
			if (!(end instanceof EReference)
					|| (ref != getEnvironment(ae).getAssociationClass((EReference) end))
					|| (end != getEnvironment(ae).lookupProperty(sourceType, end.getName()))) {
				String message = OCLMessages.bind(
						OCLMessages.AssociationClassQualifierType_ERROR_,
						ae.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitAssociationClassCallExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		visitFeatureCallExp(ae);
		
		source.accept(this);

		EClassifier refType = TypeUtil.getOCLType(ref);

		if (TypeUtil.typeCompare(refType, type) == 0)
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
	public Object visitVariable(Variable vd) {
		String varName = vd.getName();
		if (varName == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.MissingNameInVariableDeclaration_ERROR_);
			OCLPlugin.throwing(getClass(),
				"visitVariableDeclaration", error);//$NON-NLS-1$
			throw error;
		}
		EClassifier type = vd.getType();
		OCLExpression init = vd.getInitExpression();

		if (init != null) {
			init.accept(this);
			if (TypeUtil.typeCompare(init.getType(), type) > 0) {
				IllegalArgumentException error = new IllegalArgumentException(
						OCLMessages.bind(
								OCLMessages.TypeConformanceInit_ERROR_,
								varName));
				OCLPlugin.throwing(getClass(),
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
		OCLExpression cond = i.getCondition();
		OCLExpression thenexp = i.getThenExpression();
		OCLExpression elseexp = i.getElseExpression();

		if (cond == null || thenexp == null | elseexp == null) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteIfExp_ERROR_,
					i.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIfExp", error);//$NON-NLS-1$
			throw error;
		}
		cond.accept(this);
		thenexp.accept(this);
		elseexp.accept(this);
		if (cond.getType() != Types.OCL_BOOLEAN) {
			String message = OCLMessages.bind(
					OCLMessages.NonBooleanIfExp_ERROR_,
					cond.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIfExp", error);//$NON-NLS-1$
			throw error;
		}
		EClassifier thenelsetype = null;
		try {
			thenelsetype = TypeUtil.commonSuperType(thenexp.getType(),
				elseexp.getType());
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		if (TypeUtil.typeCompare(i.getType(), thenelsetype) != 0) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceIfExp_ERROR_,
					i.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIfExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	public Object visitMessageExp(MessageExp m) {
		if (m.getTarget() == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.MissingMessageTarget_ERROR_,
							m.toString()));
			OCLPlugin.throwing(getClass(), "visitMessageExp", error);//$NON-NLS-1$
			throw error;
		}
		
		m.getTarget().accept(this);
		
		if (m.getCalledOperation() == null && m.getSentSignal() == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.UnrecognizedMessageType_ERROR_);
			OCLPlugin.throwing(getClass(), "visitMessageExp", error);//$NON-NLS-1$
			throw error;
		}
		if (m.getCalledOperation() != null && m.getSentSignal() != null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.AmbiguousMessageType_ERROR_);
			OCLPlugin.throwing(getClass(), "visitMessageExp", error);//$NON-NLS-1$
			throw error;
		}
		
		EList parameters;
		
		if (m.getCalledOperation() != null) {
			EOperation operation = m.getCalledOperation().getOperation();
			
			if (operation == null) {
				IllegalArgumentException error = new IllegalArgumentException(
						OCLMessages.bind(
								OCLMessages.MissingOperationInCallAction_ERROR_,
								m.toString()));
				OCLPlugin.throwing(getClass(), "visitMessageExp", error);//$NON-NLS-1$
				throw error;
			}
			
			parameters = operation.getEParameters();
		} else {
			EClass signal = m.getSentSignal().getSignal();
			
			if (signal == null) {
				IllegalArgumentException error = new IllegalArgumentException(
						OCLMessages.bind(
								OCLMessages.MissingSignalInCallAction_ERROR_,
								m.toString()));
				OCLPlugin.throwing(getClass(), "visitMessageExp", error);//$NON-NLS-1$
				throw error;
			}
			
			parameters = TypeUtil.getProperties(signal);
		}
		
		EList arguments = m.getArgument();
		
		if (arguments.size() != parameters.size()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(OCLMessages.MessageArgumentCount_ERROR_,
							getName(m.getType())));
			OCLPlugin.throwing(getClass(), "visitMessageExp", error);//$NON-NLS-1$
			throw error;
		}
		
		// check type conformance against operation/signal parameters
		Iterator paramsIter = parameters.iterator();
		Iterator argsIter = arguments.iterator();
		while (paramsIter.hasNext()) {
			ETypedElement param = (ETypedElement) paramsIter.next();
			OCLExpression arg = (OCLExpression) argsIter.next();
			
			if (TypeUtil.typeCompare(arg.getType(), TypeUtil.getOCLType(param)) > 0) {
				IllegalArgumentException error = new IllegalArgumentException(
						OCLMessages.bind(OCLMessages.MessageArgConformance_ERROR_,
							param.getName(), arg.toString()));
				OCLPlugin.throwing(getClass(), "visitMessageExp", error);//$NON-NLS-1$
				throw error;
			}
			
			// validate the argument
			arg.accept(this);
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
		// unspecified values need not declare a type (it can be OclVoid).
		//   The only restriction is that they can only be used in message expressions
		if (!(uv.eContainer() instanceof MessageExp)) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.IllegalUnspecifiedValueExp_ERROR_,
							uv.toString()));
			OCLPlugin.throwing(getClass(), "visitUnspecifiedValueExp", error);//$NON-NLS-1$
			throw error;
		}
		
		return Boolean.TRUE;
	}
	
	/**
	 * Callback for a TypeExp visit.
	 */
	public Object visitTypeExp(TypeExp t) {
		if (!(t.getType() instanceof TypeType)) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(OCLMessages.TypeConformanceTypeExp_ERROR_,
							getName(t.getType())));
			OCLPlugin.throwing(getClass(),
				"visitTypeExp", error);//$NON-NLS-1$
			throw error;
		}
		
		if (t.getReferredType() == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.TypeExpMissingType_ERROR_,
							t.toString()));
			OCLPlugin.throwing(getClass(),
				"visitTypeExp", error);//$NON-NLS-1$
			throw error;
		}
		
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
		if (il.getType() != Types.OCL_INTEGER) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.TypeConformanceIntegerLiteral_ERROR_);
			OCLPlugin.throwing(getClass(),
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
		if (rl.getType() != Types.OCL_REAL) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.TypeConformanceRealLiteral_ERROR_);
			OCLPlugin.throwing(getClass(), "visitRealLiteralExp", error);//$NON-NLS-1$
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
		if (sl.getType() != Types.OCL_STRING) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.TypeConformanceStringLiteral_ERROR_);
			OCLPlugin
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
		if (bl.getType() != Types.OCL_BOOLEAN) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.TypeConformanceBooleanLiteral_ERROR_);
			OCLPlugin.throwing(getClass(),
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
		Variable vd = l.getVariable();
		OCLExpression in = l.getIn();
		EClassifier type = l.getType();

		if (vd == null || in == null || type == null) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteLetExp_ERROR_,
					l.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitLetExp", error);//$NON-NLS-1$
			throw error;
		}

		vd.accept(this);
		in.accept(this);

		if (TypeUtil.typeCompare(type, in.getType()) != 0) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceLetExp_ERROR_,
					type, in.getType());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitLetExp", error);//$NON-NLS-1$
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
		Variable vd = ie.getResult();
		EClassifier type = ie.getType();
		OCLExpression body = ie.getBody();
		OCLExpression source = ie.getSource();
		EList iterators = ie.getIterator();

		if (vd == null || type == null || source == null || body == null
			|| iterators.isEmpty()) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteIterateExp_ERROR_,
					ie.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		int numIters = iterators.size();

		// Validate all of the iterate parts
		source.accept(this);
		vd.accept(this);
		body.accept(this);

		if (vd.getInitExpression() == null) {
			String message = OCLMessages.bind(
					OCLMessages.MissingInitIterateExp_ERROR_,
					ie.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		if (TypeUtil.typeCompare(type, vd.getType()) != 0) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceIterateExp_ERROR_,
					ie.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}
		if (TypeUtil.typeCompare(body.getType(), vd.getType()) > 0) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceIterateExpBody_ERROR_,
					ie.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		EClassifier sourceType = source.getType();
		if (!(sourceType instanceof CollectionType)) {
			String message = OCLMessages.bind(
					OCLMessages.IteratorSource_ERROR_,
					ie.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
			throw error;
		}

		for (int i = 0; i < numIters; i++) {
			Variable loopiter = (Variable) iterators
				.get(i);
			// Validate the iterator expressions
			loopiter.accept(this);
			if (loopiter.getInitExpression() != null) {
				String message = OCLMessages.bind(
						OCLMessages.IterateExpLoopVarInit_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
				throw error;
			}
			if (TypeUtil.typeCompare(loopiter.getType(),
				((CollectionType) sourceType).getElementType()) != 0) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIterateExpLoopVar_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIterateExp", error);//$NON-NLS-1$
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
		OCLExpression body = ie.getBody();
		OCLExpression source = ie.getSource();
		EList iterators = ie.getIterator();
		String name = ie.getName();

		if (type == null || name == null || source == null || body == null
			|| iterators.isEmpty()) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteIteratorExp_ERROR_,
					ie.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
			throw error;
		}

		int opcode = 0;
		if (source.getType() instanceof PredefinedType) {
			opcode = ((PredefinedType) source.getType()).getOperationCodeFor(name);
		}
		
		int numIters = iterators.size();

		// Validate all of the iterate parts
		source.accept(this);
		body.accept(this);

		switch (opcode) {
		case PredefinedType.FOR_ALL:
		case PredefinedType.EXISTS:
		case PredefinedType.IS_UNIQUE:
			if (type != Types.OCL_BOOLEAN) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIteratorResult_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		if (opcode == PredefinedType.COLLECT) {
			if (source.getType() instanceof SequenceType
				|| source.getType() instanceof OrderedSetType) {
				if (!(type instanceof SequenceType)) {
					String message = OCLMessages.bind(
							OCLMessages.TypeConformanceCollectSequence_ERROR_,
							ie.toString());
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OCLPlugin.throwing(getClass(),
						"visitIteratorExp", error);//$NON-NLS-1$
					throw error;
				}
			} else if (!(type instanceof BagType)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceCollectBag_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		switch (opcode) {
		case PredefinedType.SELECT:
		case PredefinedType.REJECT:
			if (TypeUtil.typeCompare(type, source.getType()) != 0) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceSelectReject_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		switch (opcode) {
		case PredefinedType.SELECT:
		case PredefinedType.REJECT:
		case PredefinedType.FOR_ALL:
		case PredefinedType.ANY:
		case PredefinedType.EXISTS:
		case PredefinedType.ONE:
			if (body.getType() != Types.OCL_BOOLEAN) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIteratorBodyBoolean_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		EClassifier sourceType = source.getType();
		if (!(sourceType instanceof CollectionType)) {
			String message = OCLMessages.bind(
					OCLMessages.IteratorSource_ERROR_,
					ie.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
			throw error;
		}
		
		if (opcode == PredefinedType.CLOSURE) {
			if (!(type instanceof SetType)) {
				String message = OCLMessages.bind(
					OCLMessages.TypeConformanceClosure_ERROR_,
					ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
			
			// recursive reference must be to a type conforming
			//   to the source, otherwise it isn't recursive
			
			// checked above that the source is a collection type
			EClassifier sourceElementType =
				((CollectionType) source.getType()).getElementType();
			EClassifier iteratorElementType =
				((CollectionType) type).getElementType();
			
			if (TypeUtil.typeCompare(sourceElementType, iteratorElementType) < 0) {
				String message = OCLMessages.bind(
						OCLMessages.ElementTypeConformanceClosure_ERROR_,
						getName(iteratorElementType),
						getName(sourceElementType));
					IllegalArgumentException error = new IllegalArgumentException(
						message);
					OCLPlugin.throwing(getClass(),
						"visitIteratorExp", error);//$NON-NLS-1$
					throw error;
			}
		}

		for (int i = 0; i < numIters; i++) {
			Variable loopiter = (Variable) iterators
				.get(i);
			// Validate the iterator expressions
			loopiter.accept(this);
			if (loopiter.getInitExpression() != null) {
				String message = OCLMessages.bind(
						OCLMessages.IterateExpLoopVarInit_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
			if (TypeUtil.typeCompare(loopiter.getType(),
				((CollectionType) sourceType).getElementType()) != 0) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIteratorExpLoopVar_ERROR_,
						ie.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "visitIteratorExp", error);//$NON-NLS-1$
				throw error;
			}
		}

		return Boolean.TRUE;
	}

	/**
	 * Callback for a CollectionLiteralExp visit. Well-formedness rule: The type
	 * of a collection literal expression is determined by the collection kind
	 * selection, and the common supertype of all elements. The empty collection
	 * has a Classifier as element type.
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
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceCollectionLiteralExp_ERROR_,
					cl.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitCollectionLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		if (kind == CollectionKind.SET_LITERAL) {
			if (!(collectionType instanceof SetType)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceSetLiteral_ERROR_,
						cl.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitCollectionLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		} else if (kind == CollectionKind.ORDERED_SET_LITERAL) {
			if (!(collectionType instanceof OrderedSetType)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceOrderedSetLiteral_ERROR_,
						cl.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitCollectionLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		} else if (kind == CollectionKind.BAG_LITERAL) {
			if (!(collectionType instanceof BagType)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceBagLiteral_ERROR_,
						cl.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitCollectionLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
		} else if (kind != CollectionKind.SEQUENCE_LITERAL
			|| !(collectionType instanceof SequenceType)) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceSequenceLiteral_ERROR_,
					cl.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
				"visitCollectionLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		List parts = cl.getPart();
		if (parts.isEmpty()) {
			if (((CollectionType) collectionType).getElementType() != AnyTypeImpl.UML_CLASSIFIER) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceEmptyCollection_ERROR_,
						cl.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
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
				partsType = TypeUtil.commonSuperType(partsType, part
					.getType());
			} catch (Exception e) {
				throw new IllegalArgumentException(e.getMessage());
			}

		}
		if (TypeUtil.typeCompare(partsType,
			((CollectionType) collectionType).getElementType()) != 0) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceCollectionElementType_ERROR_,
					cl.toString());
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(),
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
					OCLMessages.bind(
							OCLMessages.TypeConformanceTupleLiteralExp_ERROR_,
							tl.toString()));
			OCLPlugin.throwing(getClass(), "visitTupleLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		EClass eclazz = (EClass) type;
		
		// The fields of the tuple are the properties of the EClass.

		EList tp = tl.getPart();
		if (tp.size() != eclazz.getEStructuralFeatures().size()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.TypeConformanceTupleLiteralExpParts_ERROR_,
							tl.toString()));
			OCLPlugin.throwing(getClass(), "visitTupleLiteralExp", error);//$NON-NLS-1$
			throw error;
		}

		Set names = new java.util.HashSet();
		
		// Match each property with a tuple part
		Iterator iter = tl.getPart().iterator();
		while (iter.hasNext()) {
			TupleLiteralPart part = (TupleLiteralPart) iter.next();
			String name = part.getName();
			EStructuralFeature property = eclazz.getEStructuralFeature(name);
			
			if (property == null) {
				String message = OCLMessages.bind(
						OCLMessages.TupleLiteralExpressionPart_ERROR_,
						name,
						tl.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitTupleLiteralExp", error);//$NON-NLS-1$
				throw error;
			}

			// Validate each TupleLiteralPart in the tuple literal
			// At the same time, check for unique names
			if (!names.add(name)) {
				String message = OCLMessages.bind(
						OCLMessages.TupleDuplicateName_ERROR_,
						name, tl.toString());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitTupleLiteralExp", error);//$NON-NLS-1$
				throw error;
			}
			
			part.accept(this);
		}
		
		return Boolean.TRUE;
	}
	
	public Object visitTupleLiteralPart(TupleLiteralPart tp) {
		EStructuralFeature property = tp.getAttribute();
		
		if (property == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.MissingPropertyInTupleLiteralPart_ERROR_,
							tp.getName(),
							tp.eContainer().toString()));
			OCLPlugin.throwing(getClass(),
				"visitTupleLiteralPart", error);//$NON-NLS-1$
			throw error;
		}
		
		EClassifier type = tp.getType();
		
		if (type == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.MissingTypeInTupleLiteralPart_ERROR_,
							tp.getName(),
							tp.eContainer().toString()));
			OCLPlugin.throwing(getClass(),
				"visitTupleLiteralPart", error);//$NON-NLS-1$
			throw error;
		}
		
		// convert property type to OCL type because it may be an Ecore primitive
		//    such as EIntegerObject
		if (TypeUtil.typeCompare(TypeUtil.getOCLType(property), type) != 0) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.TuplePartType_ERROR_,
							tp.getName(),
							tp.eContainer().toString()));
			OCLPlugin.throwing(getClass(),
				"visitTupleLiteralPart", error);//$NON-NLS-1$
			throw error;
		}
		
		OCLExpression init = tp.getValue();
		
		if (init != null) {
			init.accept(this);
			
			if (TypeUtil.typeCompare(init.getType(), type) > 0) {
				IllegalArgumentException error = new IllegalArgumentException(
						OCLMessages.TypeConformanceTuplePartValue_ERROR_);
				OCLPlugin.throwing(getClass(),
					"visitTupleLiteralPart", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		return Boolean.TRUE;
	}
	
	public Object visitStateExp(StateExp s) {
		EObject state = s.getReferredState();
		
		if (state == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.bind(
							OCLMessages.MissingStateInStateExp_ERROR_,
							s.toString()));
			OCLPlugin.throwing(getClass(),
				"visitStateExp", error);//$NON-NLS-1$
			throw error;
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
		EClassifier propertyType = null;
		String operationName = null;
		String propertyName = null;
		String classifierName = null;
		
		if (!constraint.getConstrainedElement().isEmpty()) {
			Object constrained = constraint.getConstrainedElement().get(0);
			
			if (constrained instanceof EOperation) {
				EOperation operation = (EOperation) constrained;
				operationName = operation.getName();
				
				if (operation.getEContainingClass() != null) {
					classifierName = operation.getEContainingClass().getName();
				}
				
				if (operation.getEType() != null) {
					operationType = TypeUtil.getOCLType(operation);
				}
			} else if (constrained instanceof EStructuralFeature) {
				EStructuralFeature property = (EStructuralFeature) constrained;
				propertyName = property.getName();
				
				if (property.getEContainingClass() != null) {
					classifierName = property.getEContainingClass().getName();
				}
				
				if (property.getEType() != null) {
					propertyType = TypeUtil.getOCLType(property);
				}
			} else if (constrained instanceof EClassifier) {
				classifierName = ((EClassifier) constrained).getName();
			}
		}
		
		if (operationType == null) {
			operationType = Types.OCL_VOID;
		}
		
		if (propertyType == null) {
			propertyType = Types.OCL_VOID;
		}
		
		if (Constraint.BODY.equals(stereo)
				|| Constraint.POSTCONDITION.equals(stereo)
				|| Constraint.PRECONDITION.equals(stereo)) {
			// operation constraints must be boolean-valued
			if (!(bodyType instanceof PrimitiveBoolean)) {
				String message = OCLMessages.bind(
						OCLMessages.OperationConstraintBoolean_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
		} else if (Constraint.INVARIANT.equals(stereo)) {
			if (!(bodyType instanceof PrimitiveBoolean)) {
				// so must invariants, but they have a different kind of context
				String message = OCLMessages.bind(
						OCLMessages.InvariantConstraintBoolean_ERROR_,
						classifierName);
				IllegalArgumentException error = new IllegalArgumentException(
						message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
		} else if (Constraint.DEFINITION.equals(stereo)) {
			// expression type must conform to feature type
			ETypedElement feature = null;
			if (constraint.getConstrainedElement().size() >= 2) {
				Object constrained = constraint.getConstrainedElement().get(1);
				if (constrained instanceof ETypedElement) {
					feature = (ETypedElement) constrained;
				}
			}
			
			if (feature == null) {
				String message = OCLMessages.bind(
						OCLMessages.DefinitionConstraintFeature_ERROR_,
						classifierName);
				IllegalArgumentException error = new IllegalArgumentException(
						message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			EClassifier featureType = feature.getEType();
			
			if ((featureType == null)
					|| TypeUtil.typeCompare(bodyType, featureType) > 0) {
				
				String message = OCLMessages.bind(
						OCLMessages.DefinitionConstraintConformance_ERROR_,
						getName(bodyType),
						getName(featureType));
				IllegalArgumentException error = new IllegalArgumentException(
						message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
		} else if (Constraint.INITIAL.equals(stereo) || Constraint.DERIVATION.equals(stereo)) {
			// expression type must conform to property type
			if (TypeUtil.typeCompare(bodyType, propertyType) > 0) {
				
				String message = OCLMessages.bind(
						OCLMessages.InitOrDerConstraintConformance_ERROR_,
						new Object[] {
								getName(bodyType),
								propertyName,
								getName(propertyType)});
				IllegalArgumentException error = new IllegalArgumentException(
						message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		if (Constraint.BODY.equals(constraint.getStereotype())) {
			if (operationType instanceof VoidType) {
				String message = OCLMessages.bind(
						OCLMessages.BodyConditionNotAllowed_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			// the expression must be of the form result = <expr> or
			//    <expr> = result, where <expr> is some expression whose type
			//    conforms to the operation type.  However, this expression is
			//    allowed to be nested inside any number of lets for the user's
			//    convenience
			OCLExpression exp = constraint.getBody();
			while (exp instanceof LetExp) {
				exp = ((LetExp) exp).getIn();
			}
			OperationCallExp body = null;
			if (exp instanceof OperationCallExp) {
				body = (OperationCallExp) exp;
			}
			
			if ((body == null)
					|| (body.getOperationCode() != PredefinedType.EQUAL)
					|| (body.getArgument().size() != 1)) {
				String message = OCLMessages.bind(
						OCLMessages.BodyConditionForm_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			OCLExpression bodyExpr;
			
			if (isResultVariable(body.getSource(), operationType)) {
				bodyExpr = (OCLExpression) body.getArgument().get(0);
			} else if (isResultVariable(
					(OCLExpression) body.getArgument().get(0),
					operationType)) {
				bodyExpr = body.getSource();
			} else {
				String message = OCLMessages.bind(
						OCLMessages.BodyConditionForm_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			bodyType = bodyExpr.getType();
			
			if ((TypeUtil.getRelationship(bodyType, operationType) & PredefinedType.SUBTYPE) == 0) {
				String message = OCLMessages.bind(
						OCLMessages.BodyConditionConformance_ERROR_,
					new Object[] {
						operationName,
						getName(bodyType),
						getName(operationType)});
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
			
			// one last check:  does the "body" part of the condition include
			//    the result variable?  It must not
			if (findResultVariable(bodyExpr, operationType)) {
				String message = OCLMessages.bind(
						OCLMessages.BodyConditionForm_ERROR_,
					operationName);
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitConstraint", error);//$NON-NLS-1$
				throw error;
			}
		}
		
		// check the body condition, itself, for well-formedness
		return constraint.getBody().accept(this);
	}
	
	/**
	 * Null-safe alternative to {@link ENamedElement#getName()}.
	 * 
	 * @param element a named element that may be <code>null</code>
	 * @return the element's name, or <code>null</code> if the element is <code>null</code>
	 */
	static String getName(ENamedElement element) {
		return (element == null)? null : element.getName();
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
	private static boolean isResultVariable(OCLExpression expr, EClassifier expectedType) {
		// the implicitly defined "result" variable always has the same type
		//    as the operation
		boolean result = (expr instanceof VariableExp);
		
		if (result) {
			try {
				result = TypeUtil.typeCompare(expr.getType(), expectedType) == 0;
			} catch (Exception e) {
				// get an exception on incompatible types.  This is expected
				result = false;
			}
		}
		
		if (result) {
			Variable var = ((VariableExp) expr).getReferredVariable();
			
			result = (var != null) && "result".equals(var.getName()); //$NON-NLS-1$
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
	private static boolean findResultVariable(OCLExpression expr, final EClassifier expectedType) {
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
	private void visitFeatureCallExp(FeatureCallExp exp) {
		if (exp.isMarkedPre()) {
			// check for a postcondition constraint
			if (!ExpressionsUtil.isInPostcondition(exp)) {
				
				IllegalArgumentException error = new IllegalArgumentException(
						OCLMessages.AtPreInPostcondition_ERROR_);
				OCLPlugin.throwing(getClass(),
					"visitModelPropertyCallExp", error);//$NON-NLS-1$
				throw error;
			}
		}
	}

	public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
		if (il.getType() != Types.INVALID) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.TypeConformanceInvalidLiteral_ERROR_);
			OCLPlugin.throwing(getClass(),
				"visitInvalidLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}

	public Object visitNullLiteralExp(NullLiteralExp il) {
		if (il.getType() != Types.OCL_VOID) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.TypeConformanceNullLiteral_ERROR_);
			OCLPlugin.throwing(getClass(),
				"visitNullLiteralExp", error);//$NON-NLS-1$
			throw error;
		}
		return Boolean.TRUE;
	}
	
	/**
	 * A default environment in the context of the OclAny type, which simply
	 * provides the default EcoreEnvironment algorithms for looking up features
	 * of classifiers, which usually just delegates to <code>TypeUtil</code>
	 * or <code>UMLTypeUtil</code>.  This environment is only used when no
	 * other environment is specified by the client or inferable from the
	 * expression's constraint.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static class NullEnvironment extends EcoreEnvironment {

		public NullEnvironment() {
			super(EcorePackage.eINSTANCE);
			
			Variable selfVar = ExpressionsFactory.eINSTANCE.createVariable();
			selfVar.setName("self"); //$NON-NLS-1$
			selfVar.setType(Types.OCL_ANY_TYPE);
			
			setSelfVariable(selfVar);
		}
	}
} // ValidationVisitorImpl


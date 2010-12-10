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
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling, 297541
 *   Zeligsoft - Bugs 243079, 179990
 *   Borland - Bug 179990
 *
 * </copyright>
 *
 * $Id: ValidationVisitor.java,v 1.13 2010/02/08 20:57:24 ewillink Exp $
 */

package org.eclipse.ocl.parser;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitor;

/**
 * Checks the well-formedness rules for the expressions package
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
public class ValidationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	implements Visitor<Boolean, C, O, P, EL, PM, S, COA, SSA, CT> {
	
	/**
	 * @since 3.1
	 */
	protected final Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env;
	
    /**
	 * @since 3.1
	 */
    protected final UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml;
	
	/**
	 * Obtains an instance of the validation visitor that validates against the
	 * specified environment, which presumably was used in parsing the OCL in
	 * the first place.
	 * 
	 * @param environment an OCL environment (must no be <code>null</code>)
	 * 
	 * @return a validation visitor instance for the specified environment
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	Visitor<Boolean, C, O, P, EL, PM, S, COA, SSA, CT> getInstance(
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment) {
		return environment.getFactory().createValidationVisitor(environment);
	}

	/**
	 * Initializes me to validate expressions in the specified environment.
	 * 
	 * @param environment the environment
	 * 
	 * @since 3.1
	 */
	public ValidationVisitor(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment) {
		
		super();
		
		this.env = environment;
        this.uml = environment.getUMLReflection();
	}

	/**
	 * Pass a problemMessage generated for a problemObject at some validationContext to
	 * env.getErrorHandler().
	 * 
	 * @param problemObject The object being validated, may be null if unknown
	 * @param problemMessage The problem with problemObject
	 * @param validationContext Optional context of the validator, may be null
	 * 
	 * @return TRUE always, since a validation error has been reported.
	 */
	protected Boolean validatorError(Object problemObject, String problemMessage, String problemContext) {
		OCLUtil.getAdapter(env, BasicEnvironment.class).validatorError(problemMessage,
			problemContext, problemObject);
		return Boolean.TRUE;
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
	public Boolean visitOperationCallExp(OperationCallExp<C, O> oc) {

		OCLExpression<C> source = oc.getSource();
		O oper = oc.getReferredOperation();
		int opcode = oc.getOperationCode();
		List<OCLExpression<C>> args = oc.getArgument();

		if (oper == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullOperation_ERROR_,
					oc.toString());
			return validatorError(oc, message, "visitOperationCallExp");//$NON-NLS-1$
		}

		if (source == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullSourceOperation_ERROR_,
					oc.toString());
			return validatorError(oc, message, "visitOperationCallExp");//$NON-NLS-1$
		}

		C sourceType = source.getType();
		String operName = getName(oper);

		for (OCLExpression<C> expr : args) {
			expr.accept(this);
		}
		
		if (visitFeatureCallExp(oc)) {
            return Boolean.TRUE;
        }
		
		if (opcode == PredefinedType.OCL_IS_NEW) {
			// oclIsNew() may only be used in postcondition constraints
			if (!env.isInPostcondition(oc)) {
				return validatorError(oc, OCLMessages.OCLIsNewInPostcondition_ERROR_, "visitOperationCallExp");//$NON-NLS-1$
			}
		}
		
		source.accept(this);

		// Check argument conformance.
		O oper1 = env.lookupOperation(sourceType,
			operName, args);
		if (oper1 != oper) {
			String message = OCLMessages.bind(
					OCLMessages.IllegalOperation_ERROR_,
					oc.toString());
			return validatorError(oc, message, "visitOperationCallExp");//$NON-NLS-1$
		}
		
		if (!uml.isQuery(oper)) {
			String message = OCLMessages.bind(
					OCLMessages.NonQueryOperation_ERROR_,
					getName(oper));
			return validatorError(oc, message, "visitOperationCallExp");//$NON-NLS-1$
		}
		
		C resultType;

		if (TypeUtil.isStandardLibraryFeature(env, sourceType, oper)) {
			if (opcode != OCLStandardLibraryUtil.getOperationCode(operName)) {
				String message = OCLMessages.bind(
						OCLMessages.IllegalOpcode_ERROR_,
						operName);
				return validatorError(oc, message, "visitOperationCallExp");//$NON-NLS-1$
			}
			
			resultType = TypeUtil
				.getResultType(oc, env, sourceType, oper, args);
			
			if (resultType == null) {
				// maybe this operation was an "extra" contribution by a
				//    custom environment implementation
				resultType = getOCLType(oper);
			}
		} else if (TypeUtil.isOclAnyOperation(env, oper)) {
			// source is an EClass, an enumeration, or a user data type and
			//   operation is defined by OclAny (not the source, itself)
			if (opcode != OCLStandardLibraryUtil.getOclAnyOperationCode(operName)) {
				String message = OCLMessages.bind(
						OCLMessages.IllegalOpcode_ERROR_,
						operName);
				return validatorError(oc, message, "visitOperationCallExp");//$NON-NLS-1$
			}
			
			resultType = TypeUtil
				.getResultType(oc, env, sourceType, oper, args);
			
			if (resultType == null) {
				resultType = getOCLType(oper);
			}
		} else {
			// user-defined operation
			resultType = TypeUtil
				.getResultType(oc, env, sourceType, oper, args);
		}
		
		if (!TypeUtil.exactTypeMatch(env, resultType, oc.getType())) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceOperation_ERROR_,
					oc.getType().toString());
			return validatorError(oc, message, "visitOperationCallExp");//$NON-NLS-1$
		}
		
		if ((opcode == PredefinedType.TO_LOWER) || (opcode == PredefinedType.TO_UPPER)) {
			// check settings for using non-standard closure iterator
			ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
			BasicEnvironment benv = OCLUtil.getAdapter(env, BasicEnvironment.class);
			
			if (benv != null) {
				sev = benv.getValue(ProblemOption.STRING_CASE_CONVERSION);
				if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
	                benv.problem(
	                        sev,
	                        ProblemHandler.Phase.VALIDATOR,
	                        OCLMessages.bind(
	                                OCLMessages.NonStd_Operation_,
	                                (opcode == PredefinedType.TO_LOWER) ? "String::toLower()" //$NON-NLS-1$
	                                    : "String::toUpper()"), "operationCallExp", //$NON-NLS-1$ //$NON-NLS-2$
	                        oc);
	            }
			}
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
	public Boolean visitEnumLiteralExp(EnumLiteralExp<C, EL> el) {
		EL l = el.getReferredEnumLiteral();
		C type = el.getType();
		if (!uml.isEnumeration(type) || uml.getEnumeration(l) != type) {
			String message = OCLMessages.bind(
					OCLMessages.IllegalEnumLiteral_ERROR_,
					el.toString());
			return validatorError(el, message, "visitEnumLiteralExp");//$NON-NLS-1$
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
	public Boolean visitVariableExp(VariableExp<C, PM> v) {
		// get the referred variable name
		Variable<C, PM> vd = v.getReferredVariable();

		if (vd == null || v.getType() == null || vd.getName() == null
			|| vd.getType() == null) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteVariableExp_ERROR_,
					v.toString());
			return validatorError(v, message, "visitVariableExp");//$NON-NLS-1$
		}
		vd.accept(this);
		if (!TypeUtil.exactTypeMatch(env, vd.getType(), v.getType())) {
			String message = OCLMessages.bind(
					OCLMessages.VariableTypeMismatch_ERROR_,
					vd.getName());
			return validatorError(v, message, "visitVariableExp");//$NON-NLS-1$
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
	public Boolean visitPropertyCallExp(PropertyCallExp<C, P> pc) {
		P property = pc.getReferredProperty();
		OCLExpression<C> source = pc.getSource();
		C type = pc.getType();

		if (property == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullProperty_ERROR_,
					pc.toString());
			return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
		}
		
		if (source == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationSource_ERROR_,
					pc.toString());
			return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
		}
		if (type == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationType_ERROR_,
					pc.toString());
			return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
		}
		
		List<OCLExpression<C>> qualifiers = pc.getQualifier();
		if (!qualifiers.isEmpty()) {
			// navigation qualifiers must conform to expected qualifier types
			List<P> expectedQualifierTypes = uml.getQualifiers(property);
			
			if (expectedQualifierTypes.size() != qualifiers.size()) {
				String message = OCLMessages.bind(
						OCLMessages.MismatchedQualifiers_ERROR_,
						pc.toString());
				return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
			} else {
				Iterator<P> eiter = expectedQualifierTypes.iterator();
				Iterator<OCLExpression<C>> qiter = qualifiers.iterator();
				
				while (eiter.hasNext()) {
					C expectedType = getOCLType(eiter.next());
					OCLExpression<C> qualifier = qiter.next();
					
					C qualifierType = qualifier.getType();
					
					if ((TypeUtil.getRelationship(env, qualifierType, expectedType)
							& UMLReflection.SUBTYPE) == 0) {
						
						String message = OCLMessages.bind(
								OCLMessages.MismatchedQualifiers_ERROR_,
								pc.toString());
						return validatorError(pc, message, "visitPropertyCallExp");//$NON-NLS-1$
					}
				}
			}
		}
		
		if (visitFeatureCallExp(pc)) {
            return Boolean.TRUE;
        }
		
		source.accept(this);

		C refType = TypeUtil.getPropertyType(env, source.getType(), property);
		
		if (!pc.getQualifier().isEmpty() && (refType instanceof CollectionType<?, ?>)) {
			// qualifying the navigation results in a non-collection
			//    type
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) refType;
			
			refType = ct.getElementType();
		}
		
		return Boolean.valueOf(TypeUtil.exactTypeMatch(env, refType, type));
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
	public Boolean visitAssociationClassCallExp(AssociationClassCallExp<C, P> ae) {
		C ref = ae.getReferredAssociationClass();
		OCLExpression<C> source = ae.getSource();
		C type = ae.getType();

		if (ref == null) {
			String message = OCLMessages.bind(
					OCLMessages.MissingAssociationClass_ERROR_,
					ae.toString());
			return validatorError(ae, message, "visitAssociationClassCallExp");//$NON-NLS-1$
		}
		
		if (source == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationSource_ERROR_,
					ae.toString());
			return validatorError(ae, message, "visitAssociationClassCallExp");//$NON-NLS-1$
		}
		
		C sourceType = source.getType();
		
		if (type == null) {
			String message = OCLMessages.bind(
					OCLMessages.NullNavigationType_ERROR_,
					ae.toString());
			return validatorError(ae, message, "visitAssociationClassCallExp");//$NON-NLS-1$
		}
		
		if (type instanceof CollectionType<?, ?>) {
			@SuppressWarnings("unchecked")
			C elementType = ((CollectionType<C, O>) type).getElementType();
			type = elementType;
		}
		
		if (ae.getNavigationSource() != null) {
			// navigation source must be an end of the association class
			P end = ae.getNavigationSource();
			
			if (ref != uml.getAssociationClass(end)
					|| (end != env.lookupProperty(sourceType, getName(end)))) {
				String message = OCLMessages.bind(
						OCLMessages.AssociationClassQualifierType_ERROR_,
						ae.toString());
				return validatorError(ae, message, "visitAssociationClassCallExp");//$NON-NLS-1$
			}
		}
		
		if (visitFeatureCallExp(ae)) {
            return Boolean.TRUE;
        }
		
		source.accept(this);

		return Boolean.valueOf(TypeUtil.exactTypeMatch(env, ref, type));
	}

	/**
	 * Callback for a VariableDeclaration visit. Well-formedness rule: The type
	 * of the initExpression must conform to the type of the declared variable.
	 * 
	 * @param vd --
	 *            variable declaration
	 * @return Boolean -- true if validated
	 */
	public Boolean visitVariable(Variable<C, PM> vd) {
		String varName = vd.getName();
		if (varName == null) {
			return validatorError(vd, OCLMessages.MissingNameInVariableDeclaration_ERROR_,
				"visitVariableDeclaration");//$NON-NLS-1$
		}
		
		C type = vd.getType();
		OCLExpression<C> init = vd.getInitExpression();

		if (init != null) {
			init.accept(this);
			if (!TypeUtil.compatibleTypeMatch(env, init.getType(), type)) {
				String message = OCLMessages.bind(
								OCLMessages.TypeConformanceInit_ERROR_,
								varName);
				return validatorError(vd, message, "visitVariableDeclaration");//$NON-NLS-1$
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
	public Boolean visitIfExp(IfExp<C> i) {
		OCLExpression<C> cond = i.getCondition();
		OCLExpression<C> thenexp = i.getThenExpression();
		OCLExpression<C> elseexp = i.getElseExpression();

		if (cond == null || thenexp == null || elseexp == null) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteIfExp_ERROR_,
					i.toString());
			return validatorError(i, message, "visitIfExp");//$NON-NLS-1$
		}
		cond.accept(this);
		thenexp.accept(this);
		elseexp.accept(this);
		if (cond.getType() != getStandardLibrary().getBoolean()) {
			String message = OCLMessages.bind(
					OCLMessages.NonBooleanIfExp_ERROR_,
					cond.toString());
			return validatorError(i, message, "visitIfExp");//$NON-NLS-1$
		}
		
		C thenelsetype = TypeUtil.commonSuperType(
					null,
					env,
					thenexp.getType(),
					elseexp.getType());
		
		if (thenelsetype == null) {
            return Boolean.TRUE;
        }
		if (!TypeUtil.exactTypeMatch(env, i.getType(), thenelsetype)) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceIfExp_ERROR_,
					i.toString());
			return validatorError(i, message, "visitIfExp");//$NON-NLS-1$
		}
		return Boolean.TRUE;
	}

	public Boolean visitMessageExp(MessageExp<C, COA, SSA> m) {
		if (m.getTarget() == null) {
			String message = OCLMessages.bind(
							OCLMessages.MissingMessageTarget_ERROR_,
							m.toString());
			return validatorError(m, message, "visitMessageExp");//$NON-NLS-1$
		}
		
		m.getTarget().accept(this);
		
		if (m.getCalledOperation() == null && m.getSentSignal() == null) {
			String message = OCLMessages.UnrecognizedMessageType_ERROR_;
			return validatorError(m, message, "visitMessageExp");//$NON-NLS-1$
		}
		if (m.getCalledOperation() != null && m.getSentSignal() != null) {
			String message = OCLMessages.AmbiguousMessageType_ERROR_;
			return validatorError(m, message, "visitMessageExp");//$NON-NLS-1$
		}
		
		List<?> parameters;
		
		if (m.getCalledOperation() != null) {
			O operation = uml.getOperation(m.getCalledOperation());
			
			if (operation == null) {
				String message = OCLMessages.bind(
								OCLMessages.MissingOperationInCallAction_ERROR_,
								m.toString());
				return validatorError(m, message, "visitMessageExp");//$NON-NLS-1$
			}
			
			parameters = uml.getParameters(operation);
		} else {
			C signal = uml.getSignal(m.getSentSignal());
			
			if (signal == null) {
				String message = OCLMessages.bind(
								OCLMessages.MissingSignalInCallAction_ERROR_,
								m.toString());
				return validatorError(m, message, "visitMessageExp");//$NON-NLS-1$
			}
			
			parameters = uml.getAttributes(signal);
		}
		
		List<OCLExpression<C>> arguments = m.getArgument();
		
		if (arguments.size() != parameters.size()) {
			String message = OCLMessages.bind(OCLMessages.MessageArgumentCount_ERROR_,
							getName(m.getType()));
			return validatorError(m, message, "visitMessageExp");//$NON-NLS-1$
		}
		
		// check type conformance against operators
		Iterator<?> paramsIter = parameters.iterator();
		Iterator<OCLExpression<C>> argsIter =
			arguments.iterator();
		while (paramsIter.hasNext()) {
			Object param = paramsIter.next();
			OCLExpression<C> arg = argsIter.next();
			
			if (!TypeUtil.compatibleTypeMatch(env, arg.getType(), getOCLType(param))) {
				String message = OCLMessages.bind(OCLMessages.MessageArgConformance_ERROR_,
							getName(param), arg.toString());
				return validatorError(m, message, "visitMessageExp");//$NON-NLS-1$
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
	public Boolean visitUnspecifiedValueExp(UnspecifiedValueExp<C> uv) {
		// unspecified values need not declare a type (it can be OclVoid).
		//   The only restriction is that they can only be used in message expressions
		if (!(uv.eContainer() instanceof MessageExp<?, ?, ?>)) {
			String message = OCLMessages.bind(
							OCLMessages.IllegalUnspecifiedValueExp_ERROR_,
							uv.toString());
			return validatorError(uv, message, "visitUnspecifiedValueExp");//$NON-NLS-1$
		}
		
		return Boolean.TRUE;
	}
	
	/**
	 * Callback for a TypeExp visit.
	 */
	public Boolean visitTypeExp(TypeExp<C> t) {
		if (!(t.getType() instanceof TypeType<?, ?>)) {
			String message = OCLMessages.bind(OCLMessages.TypeConformanceTypeExp_ERROR_,
							getName(t.getType()));
			return validatorError(t, message, "visitTypeExp");//$NON-NLS-1$
		}
		
		if (t.getReferredType() == null) {
			String message = OCLMessages.bind(
							OCLMessages.TypeExpMissingType_ERROR_,
							t.toString());
			return validatorError(t, message, "visitTypeExp");//$NON-NLS-1$
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
	public Boolean visitIntegerLiteralExp(IntegerLiteralExp<C> il) {
		if (il.getType()  != getStandardLibrary().getInteger()) {
			String message = OCLMessages.TypeConformanceIntegerLiteral_ERROR_;
			return validatorError(il, message, "visitIntegerLiteralExp");//$NON-NLS-1$
		}
		return Boolean.TRUE;
	}

    /**
     * Callback for an UnlimitedNaturalLiteralExp visit. Well-formedness rule: The type
     * of an unlimited natural Literal expression is the type UnlimitedNatural
     * 
     * @param unl -
     *            unlimited literal expression
     * @return Boolean -- true if validated
     */
    public Boolean visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp<C> unl) {
        if (unl.getType() != getStandardLibrary().getUnlimitedNatural()) {
        	String message = OCLMessages.TypeConformanceUnlimitedNaturalLiteral_ERROR_;
            return validatorError(unl, message, "visitUnlimitedNaturalLiteralExp");//$NON-NLS-1$
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
	public Boolean visitRealLiteralExp(RealLiteralExp<C> rl) {
		if (rl.getType() != getStandardLibrary().getReal()) {
			String message = OCLMessages.TypeConformanceRealLiteral_ERROR_;
			return validatorError(rl, message, "visitRealLiteralExp");//$NON-NLS-1$
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
	public Boolean visitStringLiteralExp(StringLiteralExp<C> sl) {
		if (sl.getType() != getStandardLibrary().getString()) {
			String message = OCLMessages.TypeConformanceStringLiteral_ERROR_;
			return validatorError(sl, message, "visitStringLiteralExp");//$NON-NLS-1$
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
	public Boolean visitBooleanLiteralExp(BooleanLiteralExp<C> bl) {
		if (bl.getType() != getStandardLibrary().getBoolean()) {
			String message = OCLMessages.TypeConformanceBooleanLiteral_ERROR_;
			return validatorError(bl, message, "visitBooleanLiteralExp");//$NON-NLS-1$
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
	public Boolean visitLetExp(LetExp<C, PM> l) {
		Variable<C, PM> vd = l.getVariable();
		OCLExpression<C> in = l.getIn();
		C type = l.getType();

		if (vd == null || in == null || type == null) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteLetExp_ERROR_,
					l.toString());
			return validatorError(l, message, "visitLetExp");//$NON-NLS-1$
		}

		vd.accept(this);
		in.accept(this);

		if (!TypeUtil.exactTypeMatch(env, type, in.getType())) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceLetExp_ERROR_,
					type, in.getType());
			return validatorError(l, message, "visitLetExp");//$NON-NLS-1$
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
	public Boolean visitIterateExp(IterateExp<C, PM> ie) {
		// get the variable declaration for the result
		Variable<C, PM> vd = ie.getResult();
		C type = ie.getType();
		OCLExpression<C> body = ie.getBody();
		OCLExpression<C> source = ie.getSource();
		List<Variable<C, PM>> iterators = ie.getIterator();

		if (vd == null || type == null || source == null || body == null
			|| iterators.isEmpty()) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteIterateExp_ERROR_,
					ie.toString());
			return validatorError(ie, message, "visitIterateExp");//$NON-NLS-1$
		}

		// Validate all of the iterate parts
		source.accept(this);
		vd.accept(this);
		body.accept(this);

		if (vd.getInitExpression() == null) {
			String message = OCLMessages.bind(
					OCLMessages.MissingInitIterateExp_ERROR_,
					ie.toString());
			return validatorError(ie, message, "visitIterateExp");//$NON-NLS-1$
		}

		if (!TypeUtil.exactTypeMatch(env, type, vd.getType())) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceIterateExp_ERROR_,
					ie.toString());
			return validatorError(ie, message, "visitIterateExp");//$NON-NLS-1$
		}
		if (!TypeUtil.compatibleTypeMatch(env, body.getType(), vd.getType())) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceIterateExpBody_ERROR_,
					ie.toString());
			return validatorError(ie, message, "visitIterateExp");//$NON-NLS-1$
		}

		C sourceType = source.getType();
		if (!(sourceType instanceof CollectionType<?, ?>)) {
			String message = OCLMessages.bind(
					OCLMessages.IteratorSource_ERROR_,
					ie.toString());
			return validatorError(ie, message, "visitIterateExp");//$NON-NLS-1$
		}

        // validate the number of iterator variables
        if (iterators.size() > 1) {
            String message = OCLMessages.bind(
                OCLMessages.TooManyIteratorVariables_ERROR_,
                ie.getName());
            return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
        }

		for (Variable<C, PM> loopiter : iterators) {
			// Validate the iterator expressions
			loopiter.accept(this);
			if (loopiter.getInitExpression() != null) {
				String message = OCLMessages.bind(
						OCLMessages.IterateExpLoopVarInit_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIterateExp");//$NON-NLS-1$
			}
			
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) sourceType;
			
			if (!TypeUtil.exactTypeMatch(env, loopiter.getType(), ct.getElementType())) {
				
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIterateExpLoopVar_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIterateExp");//$NON-NLS-1$
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
	public Boolean visitIteratorExp(IteratorExp<C, PM> ie) {
		C type = ie.getType();
		OCLExpression<C> body = ie.getBody();
		OCLExpression<C> source = ie.getSource();
		List<Variable<C, PM>> iterators = ie.getIterator();
		String name = ie.getName();

		if (type == null || name == null || source == null || body == null
			|| iterators.isEmpty()) {
			String message = OCLMessages.bind(
					OCLMessages.IncompleteIteratorExp_ERROR_,
					ie.toString());
			return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
		}

		int opcode = 0;
		if (source.getType() instanceof PredefinedType<?>) {
			opcode = OCLStandardLibraryUtil.getOperationCode(name);
		}
		
		// Validate all of the iterate parts
		source.accept(this);
		body.accept(this);

		switch (opcode) {
		case PredefinedType.FOR_ALL:
		case PredefinedType.EXISTS:
		case PredefinedType.IS_UNIQUE:
			if (type != getStandardLibrary().getBoolean()) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIteratorResult_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
			}
		}
		
		if (opcode == PredefinedType.COLLECT) {
			if (source.getType() instanceof SequenceType<?, ?>
				|| source.getType() instanceof OrderedSetType<?, ?>) {
				if (!(type instanceof SequenceType<?, ?>)) {
					String message = OCLMessages.bind(
							OCLMessages.TypeConformanceCollectSequence_ERROR_,
							ie.toString());
					return validatorError(ie, message,
						"visitIteratorExp");//$NON-NLS-1$
				}
			} else if (!(type instanceof BagType<?, ?>)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceCollectBag_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
			}
		}
		
		switch (opcode) {
		case PredefinedType.SELECT:
		case PredefinedType.REJECT:
			if (!TypeUtil.exactTypeMatch(env, type, source.getType())) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceSelectReject_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
			}
		}

		switch (opcode) {
		case PredefinedType.SELECT:
		case PredefinedType.REJECT:
		case PredefinedType.FOR_ALL:
		case PredefinedType.ANY:
		case PredefinedType.EXISTS:
		case PredefinedType.ONE:
			if (body.getType() != getStandardLibrary().getBoolean()) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIteratorBodyBoolean_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
			}
		}

		C sourceType = source.getType();
		if (!(sourceType instanceof CollectionType<?, ?>)) {
			String message = OCLMessages.bind(
					OCLMessages.IteratorSource_ERROR_,
					ie.toString());
			return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
		}
		
		if (opcode == PredefinedType.CLOSURE) {
			// check settings for using non-standard closure iterator
			ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
			BasicEnvironment benv = OCLUtil.getAdapter(env, BasicEnvironment.class);
			
			if (benv != null) {
				sev = benv.getValue(ProblemOption.CLOSURE_ITERATOR);
				if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
	                benv.problem(sev, ProblemHandler.Phase.VALIDATOR, OCLMessages
	                    .bind(OCLMessages.NonStd_Iterator_,
	                        PredefinedType.CLOSURE_NAME), "iteratorExp", ie); //$NON-NLS-1$
	            }
			}
			
			if (!(type instanceof SetType<?, ?>) && !(type instanceof OrderedSetType<?, ?>)) {
				String message = OCLMessages.bind(
					OCLMessages.TypeConformanceClosure_ERROR_,
					ie.toString());
				return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
			}
			
			// recursive reference must be to a type conforming
			//   to the source, otherwise it isn't recursive
			
			// checked above that the source is a collection type
			@SuppressWarnings("unchecked")
			CollectionType<C, O> sourceCT = (CollectionType<C, O>) source.getType();
			@SuppressWarnings("unchecked")
			CollectionType<C, O> bodyCT = (CollectionType<C, O>) type;
			
			C sourceElementType = sourceCT.getElementType();
			C bodyType = bodyCT.getElementType();
			
			if (!TypeUtil.compatibleTypeMatch(env, bodyType, sourceElementType)) {
				String message = OCLMessages.bind(
						OCLMessages.ElementTypeConformanceClosure_ERROR_,
						getName(bodyType),
						getName(sourceElementType));
					return validatorError(ie, message,  "visitIteratorExp");//$NON-NLS-1$
			}
		}
        
        if (opcode == PredefinedType.SORTED_BY) {
            // the body type must be comparable (in OCL terms, it must
            //   define the '<' operation)
            
            if (!uml.isComparable(body.getType())) {
                // FIXME: Should be more specifically about the sortedBy iterator
                String message = OCLMessages.bind(
                    OCLMessages.OperationNotFound_ERROR_,
                    PredefinedType.LESS_THAN_NAME,
                    getName(body.getType()));
                return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
            }
        }

        // validate the number of iterators
        switch (opcode) {
        case PredefinedType.FOR_ALL:
        case PredefinedType.EXISTS:
            if (iterators.size() > 2) {
                String message = OCLMessages.bind(
                    OCLMessages.TooManyIteratorVariables_ERROR_,
                    ie.getName());
                return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
            }
            break;
        default:
            if (iterators.size() > 1) {
                String message = OCLMessages.bind(
                    OCLMessages.TooManyIteratorVariables_ERROR_,
                    ie.getName());
                return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
            }
        }
        
		for (Variable<C, PM> loopiter : iterators) {
			// Validate the iterator expressions
			loopiter.accept(this);
			if (loopiter.getInitExpression() != null) {
				String message = OCLMessages.bind(
						OCLMessages.IterateExpLoopVarInit_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
			}
			
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) sourceType;
			
			if (!TypeUtil.exactTypeMatch(env, loopiter.getType(), ct.getElementType())) {
				
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceIteratorExpLoopVar_ERROR_,
						ie.toString());
				return validatorError(ie, message, "visitIteratorExp");//$NON-NLS-1$
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
	public Boolean visitCollectionLiteralExp(CollectionLiteralExp<C> cl) {
		CollectionKind kind = cl.getKind();
		C type = cl.getType();
		
		if (!(type instanceof CollectionType<?, ?>)) {
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceCollectionLiteralExp_ERROR_,
					cl.toString());
			return validatorError(cl, message, "visitCollectionLiteralExp");//$NON-NLS-1$
		}

		switch (kind) {
		case SET_LITERAL:
			if (!(type instanceof SetType<?, ?>)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceSetLiteral_ERROR_,
						cl.toString());
				return validatorError(cl, message, "visitCollectionLiteralExp");//$NON-NLS-1$
			}
			break;
		case ORDERED_SET_LITERAL:
			if (!(type instanceof OrderedSetType<?, ?>)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceOrderedSetLiteral_ERROR_,
						cl.toString());
				return validatorError(cl, message, "visitCollectionLiteralExp");//$NON-NLS-1$
			}
			break;
		case BAG_LITERAL:
			if (!(type instanceof BagType<?, ?>)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceBagLiteral_ERROR_,
						cl.toString());
				return validatorError(cl, message, "visitCollectionLiteralExp");//$NON-NLS-1$
			}
			break;
		default:
			if ((kind != CollectionKind.SEQUENCE_LITERAL)
					|| !(type instanceof SequenceType<?, ?>)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceSequenceLiteral_ERROR_,
						cl.toString());
				return validatorError(cl, message, "visitCollectionLiteralExp");//$NON-NLS-1$
			}
		break;
		}

		List<CollectionLiteralPart<C>> parts = cl.getPart();
		
		@SuppressWarnings("unchecked")
		CollectionType<C, O> collectionType = (CollectionType<C, O>) type;
		
		if (parts.isEmpty()) {
			if (!(collectionType.getElementType() instanceof VoidType<?>)) {
				String message = OCLMessages.bind(
						OCLMessages.TypeConformanceEmptyCollection_ERROR_,
						cl.toString());
				return validatorError(cl, message, "visitCollectionLiteralExp");//$NON-NLS-1$
			} else {
                return Boolean.TRUE;
            }
		}

		C partsType = parts.get(0).getType();

		for (CollectionLiteralPart<C> part : parts) {
			part.accept(this);
            partsType = TypeUtil.commonSuperType(null, env, partsType, part.getType());
			if (partsType == null) {
                return Boolean.TRUE;
            }
		}
        
		if (!TypeUtil.exactTypeMatch(env, partsType, collectionType.getElementType())) {
			
			String message = OCLMessages.bind(
					OCLMessages.TypeConformanceCollectionElementType_ERROR_,
					cl.toString());
			return validatorError(cl, message, "visitCollectionLiteralExp");//$NON-NLS-1$
		}
		return Boolean.TRUE;
	}
    
    public Boolean visitCollectionItem(CollectionItem<C> item) {
        return item.getItem().accept(this);
    }
    
    public Boolean visitCollectionRange(CollectionRange<C> range) {
        return range.getFirst().accept(this) && range.getLast().accept(this);
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
	public Boolean visitTupleLiteralExp(TupleLiteralExp<C, P> tl) {

		C type = tl.getType();
		if (!(type instanceof TupleType<?, ?>)) {
			String message = OCLMessages.bind(
							OCLMessages.TypeConformanceTupleLiteralExp_ERROR_,
							tl.toString());
			return validatorError(tl, message, "visitTupleLiteralExp");//$NON-NLS-1$
		}

		// The fields of the tuple are the properties of the EClass.

		List<TupleLiteralPart<C, P>> tp = tl.getPart();
		
		if (tp.size() != uml.getAttributes(type).size()) {
			String message = OCLMessages.bind(
							OCLMessages.TypeConformanceTupleLiteralExpParts_ERROR_,
							tl.toString());
			return validatorError(tl, message, "visitTupleLiteralExp");//$NON-NLS-1$
		}

		Set<String> names = new java.util.HashSet<String>();
		
		// Match each property with a tuple part
		for (TupleLiteralPart<C, P> part : tl.getPart()) {
			String name = part.getName();
			P property = env.lookupProperty(type, name);
			
			if (property == null) {
				String message = OCLMessages.bind(
						OCLMessages.TupleLiteralExpressionPart_ERROR_,
						name,
						tl.toString());
				return validatorError(tl, message, "visitTupleLiteralExp");//$NON-NLS-1$
			}

			// Validate each TupleLiteralPart in the tuple literal
			// At the same time, check for unique names
			if (!names.add(name)) {
				String message = OCLMessages.bind(
						OCLMessages.TupleDuplicateName_ERROR_,
						name, tl.toString());
				return validatorError(tl, message, "visitTupleLiteralExp");//$NON-NLS-1$
			}
			
			part.accept(this);
		}
		
		return Boolean.TRUE;
	}
	
	public Boolean visitTupleLiteralPart(TupleLiteralPart<C, P> tp) {
		P property = tp.getAttribute();
		
		if (property == null) {
			String message = OCLMessages.bind(
							OCLMessages.MissingPropertyInTupleLiteralPart_ERROR_,
							tp.getName(),
							tp.eContainer().toString());
			return validatorError(tp, message, "visitTupleLiteralPart");//$NON-NLS-1$
		}
		
		C type = tp.getType();
		
		if (type == null) {
			String message = OCLMessages.bind(
							OCLMessages.MissingTypeInTupleLiteralPart_ERROR_,
							tp.getName(),
							tp.eContainer().toString());
			return validatorError(tp, message, "visitTupleLiteralPart");//$NON-NLS-1$
		}
		
		// convert property type to OCL type because it may be an Ecore primitive
		//    such as EIntegerObject
		if (!TypeUtil.exactTypeMatch(env, getOCLType(property), type)) {
			String message = OCLMessages.bind(
							OCLMessages.TuplePartType_ERROR_,
							tp.getName(),
							tp.eContainer().toString());
			return validatorError(tp, message, "visitTupleLiteralPart");//$NON-NLS-1$
		}
		
		OCLExpression<C> value = tp.getValue();
		
		if (value != null) {
			value.accept(this);
			
			if (!TypeUtil.compatibleTypeMatch(env, value.getType(), type)) {
				String message = OCLMessages.TypeConformanceTuplePartValue_ERROR_;
				return validatorError(tp, message, "visitTupleLiteralPart");//$NON-NLS-1$
			}
		}
		
		return Boolean.TRUE;
	}
	
	public Boolean visitStateExp(StateExp<C, S> s) {
		Object state = s.getReferredState();
		
		if (state == null) {
			String message = OCLMessages.bind(
							OCLMessages.MissingStateInStateExp_ERROR_,
							s.toString());
			return validatorError(s, message, "visitStateExp");//$NON-NLS-1$
		}
		
		return Boolean.TRUE;
	}
	
	/**
	 * Applies well-formedness rules for model property calls in general.
	 * This includes checking that "@pre" notation is only used in a
	 * postcondition constraint.
	 * 
	 * @param exp the model property call expression to validate
     * 
     * @Return true if validation must terminate due to an error
	 * @since 3.1
	 */
	public Boolean visitFeatureCallExp(FeatureCallExp<C> exp) {
		if (exp.isMarkedPre()) {
			// check for a postcondition constraint
			if (!env.isInPostcondition(exp)) {
				String message = OCLMessages.AtPreInPostcondition_ERROR_;
				return validatorError(exp, message, "visitFeatureCallExp");//$NON-NLS-1$
			}
		}
        
        // check for static access to non-static features
        if (exp.getSource() != null) {
            OCLExpression<C> source = exp.getSource();
            
            if (source.getType() instanceof TypeType<?, ?>) {
                @SuppressWarnings("unchecked")
                TypeType<C, ?>  typeType = (TypeType<C, ?>) source.getType();
                
                Object feature = null;
                
                if (exp instanceof OperationCallExp<?, ?>) {
                    feature = ((OperationCallExp<?, ?>) exp).getReferredOperation();
                    
                    // operation must either be defined by the TypeType
                    //    (e.g., allInstances()) or be a static operation of
                    //    the referred classifier
                    if (!(typeType.oclOperations().contains(feature)
                            || isStatic(feature))) {
                        String message = OCLMessages.bind(
                            OCLMessages.NonStaticOperation_ERROR_,
                            getName(feature));
                        return validatorError(exp, message, "visitFeatureCallExp");//$NON-NLS-1$
                    }
                } else if (exp instanceof PropertyCallExp<?, ?>) {
                    feature = ((PropertyCallExp<?, ?>) exp).getReferredProperty();
                    
                    // property must be a static attribute of
                    //    the referred classifier
                    if (!isStatic(feature)) {
                        String message = OCLMessages.bind(
                            OCLMessages.NonStaticAttribute_ERROR_,
                            getName(feature));
                        return validatorError(exp, message, "visitFeatureCallExp");//$NON-NLS-1$
                    }
                }
            }
        }
        return Boolean.FALSE;
	}
    
    private boolean isStatic(Object feature) {
        return (uml != null) && uml.isStatic(feature);
    }

	public Boolean visitInvalidLiteralExp(InvalidLiteralExp<C> il) {
		if (!(il.getType() instanceof InvalidType<?>)) {
			String message = OCLMessages.TypeConformanceInvalidLiteral_ERROR_;
			return validatorError(il, message, "visitInvalidLiteralExp");//$NON-NLS-1$
		}
		return Boolean.TRUE;
	}

	public Boolean visitNullLiteralExp(NullLiteralExp<C> il) {
		if (!(il.getType() instanceof VoidType<?>)) {
			String message = OCLMessages.TypeConformanceNullLiteral_ERROR_;
			return validatorError(il, message, "visitNullLiteralExp");//$NON-NLS-1$
		}
		return Boolean.TRUE;
	}
	
    public Boolean visitExpressionInOCL(ExpressionInOCL<C, PM> expression) {
        if (expression.getContextVariable() == null) {
        	String message = OCLMessages.MissingContextVariable_ERROR_;
            return validatorError(expression, message, "visitExpressionInOCL");//$NON-NLS-1$
        }
        
        OCLExpression<C> body = expression.getBodyExpression();
        if (body == null) {
        	// won't be able to do anything else useful with this expression
        	String message = OCLMessages.MissingBodyExpression_ERROR_;
            return validatorError(expression, message, "visitExpressionInOCL");//$NON-NLS-1$        
        }
        
        CT constraint = uml.getConstraint(expression);
        if (constraint != null) {
            O operation = getConstrainedOperation(uml.getConstrainedElements(constraint));
             
            if (operation == null) {
            	if (!UMLReflection.DEFINITION.equals(uml.getStereotype(constraint))) {
	                if (!expression.getParameterVariable().isEmpty()) {
	                	String message = OCLMessages.ExtraneousParameterVariables_ERROR_;
	                    return validatorError(constraint, message, "visitExpressionInOCL");//$NON-NLS-1$
	                }
	                
	                if (expression.getResultVariable() != null) {
	                	String message = OCLMessages.ExtraneousResultVariable_ERROR_;
	                    return validatorError(constraint, message, "visitExpressionInOCL");//$NON-NLS-1$
	                }
            	}
            } else {
                List<PM> parameters = uml.getParameters(operation);
                List<Variable<C, PM>> variables = expression.getParameterVariable();
                
                if (parameters.size() != variables.size()) {
                	String message = OCLMessages.MismatchedParameterVariables_ERROR_;
                    return validatorError(constraint, message, "visitExpressionInOCL");//$NON-NLS-1$
                }
                
                Iterator<PM> iter = parameters.iterator();
                for (Variable<C, PM> var : expression.getParameterVariable()) {
                    PM param = iter.next();
                    var.accept(this);
                    
                    C paramType = getOCLType(param);
                    if (paramType != null) {
                        if (!TypeUtil.exactTypeMatch(env, paramType, var.getType())) {
                        	String message = OCLMessages.MismatchedParameterVariables_ERROR_;
                            return validatorError(constraint, message, "visitExpressionInOCL");//$NON-NLS-1$
                        }
                    }
                }
                
                // we need to validate the result variable against the operation
                //   result type in postconditions.  In other constraints, the
                //   result variable does not exist (in body expressions, we
                //   allow it for now for compatibility)
                Variable<C, PM> resultVar = expression.getResultVariable();
                C operType = null;
                String stereotype = uml.getStereotype(constraint);
                if (UMLReflection.BODY.equals(stereotype)
                        || UMLReflection.POSTCONDITION.equals(stereotype)) {
                    operType = getOCLType(operation);
                    
                    if (operType instanceof VoidType<?>) {
                        operType = null;
                    }
                }
                
                if (((operType == null) != (resultVar == null)) &&
                        !UMLReflection.BODY.equals(stereotype)) {
                	String message;
                    if (resultVar == null) {
                        message = OCLMessages.MissingResultVariable_ERROR_;
                    } else {
                        message = OCLMessages.ExtraneousResultVariable_ERROR_;
                    }                  
                    return validatorError(constraint, message, "visitExpressionInOCL");//$NON-NLS-1$
                } else if (resultVar != null) {
                    if (!TypeUtil.exactTypeMatch(env, operType, resultVar.getType())) {
                    	String message = OCLMessages.MissingResultVariable_ERROR_;
                        return validatorError(constraint, message, "visitExpressionInOCL");//$NON-NLS-1$
                    }
                    
                    expression.getResultVariable().accept(this);
                }
            }
        }
        
        Boolean wellFormed = checkExpressionInOCL(expression, constraint, body);
        
        return Boolean.TRUE.equals(body.accept(this)) && Boolean.TRUE.equals(wellFormed);
    }
    
    /**
     * Checks the well-formedness of an ExpressionInOCL, according to the
     * constraints defined in Chapter 12 of the OCL Specification.
     * 
     * @param expression an expression
     * @param constraint the constraint that owns it (not <code>null</code>)
     * @param body its body expression (not <code>null</code>)
     * 
     * @return whether it is well-formed
     */
    Boolean checkExpressionInOCL(ExpressionInOCL<C, PM> expression, CT constraint,
    		OCLExpression<C> body) {
    	String stereotype = uml.getStereotype(constraint);
    	List<? extends EObject> constrainedElement = uml.getConstrainedElements(constraint);
    	
    	C bodyType = body.getType();
    	C oclBoolean = getStandardLibrary().getBoolean();
    	
    	if (UMLReflection.INVARIANT.equals(stereotype)) {
    		// if expression has one constrained element that is a classifier
    		// then the constrained classifier is the context classifier and
    		// the body expression is boolean-valued
			C constrainedClassifier = getConstrainedClassifier(constrainedElement);
    		if (!Boolean.TRUE.equals(checkContextClassifier(expression, 
    				constrainedClassifier, constrainedElement))) {
				return Boolean.FALSE;
			}
    		
			// we should always check this type conformance
			if (bodyType != oclBoolean) {
				// so must invariants, but they have a different kind of context
				String message = OCLMessages.bind(
						OCLMessages.InvariantConstraintBoolean_ERROR_,
						getName(constrainedClassifier));
				return validatorError(constraint, message, "checkExpressionInOCL"); //$NON-NLS-1$
			}
    	} else if (UMLReflection.POSTCONDITION.equals(stereotype) || UMLReflection.PRECONDITION.equals(stereotype)) {
    		// if the expression has one constrained element that is an operation
    		// then the constrained element's owner is the contextual classifier
    		// and the body expression is boolean-valued.
    		// Note that this specifically allows an inheriting classifier to
    		// redefine a pre- or post-condition by listing the classifier
    		// that inherits the operation as well as the operation in the
    		// constrainedElement reference
			O constrainedOperation = getConstrainedOperation(constrainedElement);
    		if (!Boolean.TRUE.equals(checkContextFeatureClassifier(expression,
    				constrainedOperation, constrainedElement))) {
    			return Boolean.FALSE;
    		}
    		
			// we should always check this type conformance
			if (bodyType != oclBoolean) {
				String message = OCLMessages.bind(
						OCLMessages.OperationConstraintBoolean_ERROR_,
					getName(constrainedOperation));
				return validatorError(constraint, message, "checkExpressionInOCL"); //$NON-NLS-1$
			}
    		
    	} else if (UMLReflection.DEFINITION.equals(stereotype)) {
    		// if expression has one constrained element that is a classifier
    		// then the constrained element is the context classifier
			C constrainedClassifier = getConstrainedClassifier(constrainedElement);
    		if (!Boolean.TRUE.equals(checkContextClassifier(expression, 
					constrainedClassifier, constrainedElement))) {
				return Boolean.FALSE;
			}
    	} else if (UMLReflection.INITIAL.equals(stereotype) || UMLReflection.DERIVATION.equals(stereotype)) {
    		// if the expression has one constrained element that is a property
    		// then the constrained element's owner is the contextual classifier
    		// and the body expression type conforms to the property type.
    		// Note that this specifically allows an inheriting classifier to
    		// redefine an initial or derived value by listing the classifier
    		// that inherits the attribute as well as the attribute in the
    		// constrainedElement reference
			P constrainedProperty = getConstrainedProperty(constrainedElement);
    		if (!Boolean.TRUE.equals(checkContextFeatureClassifier(expression,
					constrainedProperty, constrainedElement))) {
				return Boolean.FALSE;
			}

    		C propertyType = (constrainedProperty != null) ? getOCLType(constrainedProperty)
				: getStandardLibrary().getOclVoid();
    		
    		// we should always check this type conformance
			if (!TypeUtil.compatibleTypeMatch(env, bodyType, propertyType)) {
				
				String message = OCLMessages.bind(
						OCLMessages.InitOrDerConstraintConformance_ERROR_,
						new Object[] {
								getName(bodyType),
								getName(constrainedProperty),
								getName(propertyType)});
				return validatorError(constraint, message, "checkExpressionInOCL"); //$NON-NLS-1$
			}
    	} else if (UMLReflection.BODY.equals(stereotype)) {
    		// if the expression has one constrained element that is an operation
    		// then the constrained element's owner is the contextual classifier
    		// and the body expression type conforms to the operation type.
    		// Note that this specifically allows an inheriting classifier to
    		// redefine an operation body by listing the classifier
    		// that inherits the operation as well as the operation in the
    		// constrainedElement reference
			O constrainedOperation = getConstrainedOperation(constrainedElement);
    		if (!Boolean.TRUE.equals(checkContextFeatureClassifier(expression,
					constrainedOperation, constrainedElement))) {
				return Boolean.FALSE;
			}

    		C operationType = (constrainedOperation != null) ? getOCLType(constrainedOperation)
				: getStandardLibrary().getOclVoid();
    		String operationName = getName(constrainedOperation);
    		
    		// void operations may not have body constraints
			if (operationType instanceof VoidType<?>) {
				String message = OCLMessages.bind(
						OCLMessages.BodyConditionNotAllowed_ERROR_,
					operationName);
				return validatorError(constraint, message, "checkExpressionInOCL"); //$NON-NLS-1$
			}
			
    		// we should always check this type conformance
			if ((bodyType == oclBoolean) && (operationType != oclBoolean)) {
				
			    // this is a UML-style body condition constraint (the UML and
				// OCL specifications are contradictory)
			    if (visitBodyConditionConstraint(constraint, operationType,
                    operationName)) {
                    return Boolean.TRUE;
                }
			} else {
			    // the body expression type must conform to the operation type
	            if (!TypeUtil.compatibleTypeMatch(env, bodyType, operationType)) {
	                
	                String message = OCLMessages.bind(
    	                    OCLMessages.BodyConditionConformance_ERROR_,
    	                new Object[] {
    	                    operationName,
    	                    getName(bodyType),
    	                    getName(operationType)});
	                return validatorError(constraint, message, "checkExpressionInOCL"); //$NON-NLS-1$
	            }
                
                // check that the body doesn't reference the result variable
                if (findResultVariable(expression.getBodyExpression(), operationType)) {
                    String message = OCLMessages.bind(
                            OCLMessages.BodyConditionForm_ERROR_,
                        operationName);
                    return validatorError(constraint, message, "checkExpressionInOCL"); //$NON-NLS-1$
                }
			}
    	}
    	
    	return Boolean.TRUE;
    }

    /**
     * Checks that the contextual classifier of the specified <tt>expression</tt>
     * is correct for a classifier-context constraint.
     * 
     * @param expression an expression being validated
     * @param constrainedClassifier the feature context of the constraint
     * @param constrainedElement the constrained elements
     * 
     * @return whether the context classifier is correct
     */
    private Boolean checkContextClassifier(ExpressionInOCL<C, PM> expression,
    		C constrainedClassifier, List<? extends EObject> constrainedElement) {
    	
    	C contextualClassifier = getContextualClassifier(expression);
    	
		if (constrainedElement.size() == 1) {
			if (constrainedClassifier != contextualClassifier) {
				String message = OCLMessages.bind(
					OCLMessages.WrongContextClassifier_ERROR_,
					getName(contextualClassifier),
					getName(constrainedClassifier));
				return validatorError(expression, message, "checkExpressionInOCL"); //$NON-NLS-1$
			}
		}
		
		return Boolean.TRUE;
    }

    /**
     * Checks that the contextual classifier of the specified <tt>expression</tt>
     * is correct for a constraint in a feature context.
     * MDT OCL provides an extension in which a constraint in a
     * feature context may be specified in the context of a classifier that
     * inherits (thus does not own) the feature.  In this case, the
     * <tt>constrainedElement</tt> list additionally includes the specializing
     * classifier.
     * 
     * @param expression an expression being validated
     * @param constrainedFeature the feature context of the constraint
     * @param constrainedElement the constrained elements
     * 
     * @return whether the context classifier is correct
     */
    private Boolean checkContextFeatureClassifier(ExpressionInOCL<C, PM> expression,
    		Object constrainedFeature, List<? extends EObject> constrainedElement) {
    	
    	C contextualClassifier = getContextualClassifier(expression);
    	
		if ((constrainedElement.size() == 1) && (constrainedFeature != null)) {
			C owner = uml.getOwningClassifier(constrainedFeature);
			if (owner != contextualClassifier) {
				String message = OCLMessages.bind(
					OCLMessages.WrongContextClassifier_ERROR_,
					getName(contextualClassifier),
					getName(owner));
				return validatorError(expression, message, "checkExpressionInOCL"); //$NON-NLS-1$
			}
		} else if (constrainedElement.size() > 1) {
			// MDT OCL extension for applying constraints in the context of
			// a classifier that inherits the operation
			C constrainedClassifier = getConstrainedClassifier(constrainedElement);
			if ((constrainedClassifier != null) && (constrainedFeature != null)) {
				C owner = uml.getOwningClassifier(constrainedFeature);
				if (!TypeUtil.compatibleTypeMatch(env, constrainedClassifier, owner)) {
					String message = OCLMessages.bind(
						OCLMessages.WrongContextClassifier_ERROR_,
						getName(contextualClassifier),
						getName(owner));
					return validatorError(expression, message, "checkExpressionInOCL"); //$NON-NLS-1$
				}
			}
		}
		
		return Boolean.TRUE;
    }
    
	/**
	 * Applies well-formedness rules to constraints.
	 * 
	 * @param constraint the constraint to validate
	 */
	public Boolean visitConstraint(CT constraint) {
        ExpressionInOCL<C, PM> specification = uml.getSpecification(constraint);
        Boolean specificationResult = specification.accept(this);
        if (!Boolean.TRUE.equals(specificationResult)) {
        	return specificationResult;
        }
//        
//		String stereo = uml.getStereotype(constraint);
//
//		C bodyType = specification.getBodyExpression().getType();
//		C oclBoolean = getStandardLibrary().getBoolean();
//		
//		String classifierName = null;
//		
//		if (!uml.getConstrainedElements(constraint).isEmpty()) {
//			EObject constrained = uml.getConstrainedElements(constraint).get(0);
//			
//			if (uml.isOperation(constrained)) {
//				classifierName = getName(uml.getOwningClassifier(constrained));
//			} else if (uml.isProperty(constrained)) {
//				classifierName = getName(uml.getOwningClassifier(constrained));
//			} else if (uml.isClassifier(constrained)) {
//				classifierName = getName(constrained);
//			}
//		}
//		
//		if (UMLReflection.DEFINITION.equals(stereo)) {
//			// expression type must conform to feature type
//			EObject feature = null;
//			if (uml.getConstrainedElements(constraint).size() >= 2) {
//				EObject constrained = uml.getConstrainedElements(constraint).get(1);
//				if (uml.isOperation(constrained) || uml.isProperty(constrained)) {
//					feature = constrained;
//				}
//			}
//			
//			if (feature == null) {
//				String message = OCLMessages.bind(
//						OCLMessages.DefinitionConstraintFeature_ERROR_,
//						classifierName);
//				return validatorError(constraint, message, "visitConstraint"); //$NON-NLS-1$
//			}
//			
//			C featureType = getOCLType(feature);
//			
//			if ((featureType == null)
//					|| !TypeUtil.compatibleTypeMatch(env, bodyType, featureType)) {
//				
//				String message = OCLMessages.bind(
//						OCLMessages.DefinitionConstraintConformance_ERROR_,
//						getName(bodyType),
//						getName(featureType));
//				return validatorError(constraint, message, "visitConstraint"); //$NON-NLS-1$
//			}
//		}
		
		return Boolean.TRUE;
	}

    /**
     * @param constraint
     * @param operationType
     * @param operationName
     * 
     * @Return true if validation must terminate due to an error
     */
    private Boolean visitBodyConditionConstraint(CT constraint,
            C operationType, String operationName) {
        C bodyType;
        // the expression must be of the form result = <expr> or
        //    <expr> = result, where <expr> is some expression whose type
        //    conforms to the operation type.  However, this expression is
        //    allowed to be nested inside any number of lets for the user's
        //    convenience
        OCLExpression<C> exp = uml.getSpecification(constraint).getBodyExpression();
        while (exp instanceof LetExp<?, ?>) {
            @SuppressWarnings("unchecked")
            LetExp<C, ?> letExp = (LetExp<C, ?>) exp;
        	exp = letExp.getIn();
        }
        OperationCallExp<C, O> body = null;
        if (exp instanceof OperationCallExp<?, ?>) {
            @SuppressWarnings("unchecked")
            OperationCallExp<C, O> callExp = (OperationCallExp<C, O>) exp;
        	body = callExp;
        }
        
        if ((body == null)
        		|| (body.getOperationCode() != PredefinedType.EQUAL)
        		|| (body.getArgument().size() != 1)) {
        	String message = OCLMessages.bind(
        			OCLMessages.BodyConditionForm_ERROR_,
        		operationName);
			return validatorError(constraint, message, "visitBodyConditionConstraint"); //$NON-NLS-1$
        }
        
        OCLExpression<C> bodyExpr;
        
        if (isResultVariable(body.getSource(), operationType)) {
        	bodyExpr = body.getArgument().get(0);
        } else if (isResultVariable(body.getArgument().get(0), operationType)) {
        	bodyExpr = body.getSource();
        } else {
        	String message = OCLMessages.bind(
        			OCLMessages.BodyConditionForm_ERROR_,
        		operationName);
        	return validatorError(constraint, message, "visitBodyConditionConstraint");//$NON-NLS-1$
        }
        
        bodyType = bodyExpr.getType();
        
        if ((TypeUtil.getRelationship(env, bodyType, operationType) & UMLReflection.SUBTYPE) == 0) {
        	String message = OCLMessages.bind(
        			OCLMessages.BodyConditionConformance_ERROR_,
        		new Object[] {
        			operationName,
        			getName(bodyType),
        			getName(operationType)});
        	return validatorError(constraint, message, "visitBodyConditionConstraint");//$NON-NLS-1$
        }
        
        // one last check:  does the "body" part of the condition include
        //    the result variable?  It must not
        if (findResultVariable(bodyExpr, operationType)) {
        	String message = OCLMessages.bind(
        			OCLMessages.BodyConditionForm_ERROR_,
        		operationName);
        	return validatorError(constraint, message, "visitBodyConditionConstraint");//$NON-NLS-1$
       }
       return Boolean.FALSE;
    }
    
    /**
     * Obtains the constrained element that is a classifier.
     * 
     * @param constrainedElement a list of constrained elements
     * @return the constrained operation, if any
     */
    @SuppressWarnings("unchecked")
    private O getConstrainedOperation(List<?> constrainedElement) {
        for (Object constrained : constrainedElement) {
            if (uml.isOperation(constrained)) {
                return (O) constrained;
            }
        }
        
        return null;
    }
    
    /**
     * Obtains the constrained element that is a classifier.
     * 
     * @param constrainedElement a list of constrained elements
     * @return the constrained property, if any
     */
    @SuppressWarnings("unchecked")
    private P getConstrainedProperty(List<?> constrainedElement) {
        for (Object constrained : constrainedElement) {
            if (uml.isProperty(constrained)) {
                return (P) constrained;
            }
        }
        
        return null;
    }
    
    /**
     * Obtains the constrained element that is a classifier.
     * 
     * @param constrainedElement a list of constrained elements
     * @return the constrained classifier, if any
     */
    @SuppressWarnings("unchecked")
    private C getConstrainedClassifier(List<?> constrainedElement) {
        for (Object constrained : constrainedElement) {
            if (uml.isClassifier(constrained)) {
                return (C) constrained;
            }
        }
        
        return null;
    }
    
    /**
     * Obtains the contextual classifier of an expression.
     * 
     * @param expression the expression
     * @return its contextual classifier, or <code>null</code> if none
     */
    private C getContextualClassifier(ExpressionInOCL<C, PM> expression) {
    	Variable<C, PM> selfVar = expression.getContextVariable();
    	return (selfVar == null)? null : selfVar.getType();
    }
	
	/**
	 * Null-safe alternative to {@link ENamedElement#getName()}.
	 * 
	 * @param element a named element that may be <code>null</code>
	 * @return the element's name, or <code>null</code> if the element is <code>null</code>
	 */
	String getName(Object element) {
		return (element == null)? null : uml.getName(element);
	}
	
	/**
	 * Obtains the type of a meta-element, ensuring that the result is
	 * canonicalized with respect to the current environment (via its type
	 * resolver).
	 * 
	 * @param metaElement a typed meta-element
	 * 
	 * @return the OCL type corresponding to the element's type
	 * 
	 * @see UMLReflection#getOCLType(Object)
	 * 
	 * @since 1.2
	 */
	protected C getOCLType(Object metaElement) {
	    return TypeUtil.resolveType(env, uml.getOCLType(metaElement));
	}
	
    private OCLStandardLibrary<C> getStandardLibrary() {
        return env.getOCLStandardLibrary();
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
	private boolean isResultVariable(OCLExpression<C> expr, C expectedType) {
		
		// the implicitly defined "result" variable always has the same type
		//    as the operation
		boolean result = (expr instanceof VariableExp<?, ?>);
		
		if (result) {
            result = TypeUtil.exactTypeMatch(env, expr.getType(), expectedType);
        }
		
		if (result) {
		    @SuppressWarnings("unchecked")
			Variable<C, PM> var = ((VariableExp<C, PM>) expr).getReferredVariable();
			
			// the result variable is a context variable, contained in the
			//    ExpressionInOcl::resultVariable property
			result = (var != null) && Environment.RESULT_VARIABLE_NAME.equals(var.getName())
			        && (var.eContainmentFeature() ==
			            UtilitiesPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE);
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
	private boolean findResultVariable(
			OCLExpression<C> expr,
			final C expectedType) {
		
		class ResultFinder extends AbstractVisitor<
				Variable<C, PM>, C, O, P, EL, PM, S, COA, SSA, CT> {
			boolean found = false;
			
			@Override
            public Variable<C, PM>
			visitVariableExp(VariableExp<C, PM> v) {
				if (isResultVariable(v, expectedType)) {
					found = true;
					return v.getReferredVariable();
				}
				
				// no need to call super because this is a leaf expression
				return null;
			}
		}
		
		ResultFinder finder = new ResultFinder();
		expr.accept(finder);
		
		return finder.found;
	}
} // ValidationVisitorImpl


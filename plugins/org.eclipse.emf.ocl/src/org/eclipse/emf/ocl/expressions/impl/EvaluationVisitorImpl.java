/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: EvaluationVisitorImpl.java,v 1.13 2007/01/29 20:31:18 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
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
import org.eclipse.emf.ocl.expressions.util.AbstractVisitor;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.OCLStatusCodes;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.impl.PrimitiveTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.emf.ocl.utilities.impl.CollectionFactory;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.UnicodeSupport;

/**
 * An evaluation visitor implementation for OCL expressions.
 * <p>
 * <b>Note</b> that this class is not intended to be used or extended by
 * clients.  Use the {@link EvaluationVisitor} interface, instead.
 * </p>
 * 
 * @author Tim Klinger (tklinger)
 */
public class EvaluationVisitorImpl
	extends AbstractVisitor
	implements EvaluationVisitor {

	private EvaluationEnvironment env;

	private Map extentMap;

	public static EvaluationVisitor getInstance(EvaluationEnvironment env,
		Map extentMap) {
		return new EvaluationVisitorImpl(env, extentMap);
	}

	/**
	 * Default constructor.
	 */
	private EvaluationVisitorImpl() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param env
	 *            an evaluation environment (map of variable names to values)
	 * @param extentMap
	 *            a map of classes to their instance lists
	 */
	private EvaluationVisitorImpl(EvaluationEnvironment env, Map extentMap) {
		this.env = env;
		this.extentMap = extentMap;
	}

	/**
	 * @return the environment
	 */
	public EvaluationEnvironment getEvalEnvironment() {
		return env;
	}

	/**
	 * @return the extent map
	 */
	public Map getExtentMap() {
		return extentMap;
	}

	/**
	 * Sets the environment to the supplied value.
	 * 
	 * @param newEnv
	 *            the new environment for this visitor.
	 */
	public void setEvalEnvironment(EvaluationEnvironment newEnv) {
		env = newEnv;
	}

	/**
	 * Sets the extent map to the supplied value.
	 * 
	 * @param extentMap
	 *            the new extent map
	 */
	public void setExtentMap(Map extentMap) {
		this.extentMap = extentMap;
	}

	/**
	 * Returns a string representation of this visitor
	 */
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (evaluation environment: ");//$NON-NLS-1$
		result.append(env);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * Queries whether the specified value is the null or OclInvalid.
	 * 
	 * @param value a value
	 * 
	 * @return whether it is undefined
	 */
	static boolean isUndefined(Object value) {
		return (value == null) || (value == Types.OCL_INVALID);
	}

	/**
	 * 
	 * Callback for an OperationCallExp visit.
	 *  
	 */
	public Object visitOperationCallExp(OperationCallExp oc) {
		// check if source type is primitive and handle the
		// primitive ops "inline". Otherwise use java reflection
		// to invoke the operation (there is currently no means
		// to do this directly in EMF).

		// Note: Generally the result of an operation invocation on the
		// undefined
		// object or with an undefined argument is undefined except in the
		// following
		// cases prescribed by the spec (p. 2-10, sec. 2.4.11)
		// 1. true || <anything> is true
		// 2. false && <anything> is false
		// 3. false implies <anything> is true
		// 4. if <condition> <something1> else <something2> has the value
		// dictated
		// by the condition regardless of the other value.
		// all irrespective of the order of the arguments.

		OCLExpression source = oc.getSource();
		EClassifier sourceType = source.getType();
		EOperation oper = oc.getReferredOperation();
		int opCode = oc.getOperationCode();
		EList args = oc.getArgument();
		int numArgs = args.size();

		OCLExpression body = getBody(oper);
		if ((body != null) || getEvalEnvironment().canEvaluate(oper, opCode)) {
			// delegate evaluation to the evaluation environment
			
			// evaluate source
			Object sourceVal = source.accept(this);
			
			// evaluate args
			Object[] evalArgs = new Object[numArgs];
			int i = 0;
			for (Iterator it = args.iterator(); it.hasNext(); i++) {
				OCLExpression arg = (OCLExpression) it.next();
				evalArgs[i] = arg.accept(this);
			}
	
			// ask the environment to evaluate
			try {
				Object result;
				
				if (body != null) {
					result = invoke(oper, body, sourceVal, evalArgs);
				} else {
					result = getEvalEnvironment().evaluate(
							oper, opCode, sourceVal, evalArgs);
				}
				return result;
			} catch (UnsupportedOperationException ignore) {
				// let the EvaluationVisitor do its thing
			} catch (Exception e) {
				OCLPlugin
					.catching(getClass(), "visitOperationCallExp", e);//$NON-NLS-1$
				OCLPlugin.log(
					IStatus.ERROR,
					OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
					OCLMessages.bind(
						OCLMessages.ErrorMessage_ERROR_,
						"visitOperationCallExp", //$NON-NLS-1$
						e.getLocalizedMessage()),
					e);
				return Types.OCL_INVALID;
			}
		}
		
		// inline primitive and collection operation evaluation for increased
		// efficiency

		// We handle equals and notEquals separately since they require type
		// checking

		// The semantics for equality are as follows:
		//
		// Define primtive(type) := type in {Boolean, String, Integer, Double,
		// Void}
		//
		// For the expression x = y, let t1 = runtimeType(x1), t2 =
		// runtimeType(x2)
		//
		// if primitive(t1) or primitive(t2) then
		// 		we use the java semantics for the corresponding built-in primitive
		// types EXCEPT for
		//		the following cases:
		//		(1) when one or the type is Void, the result is true just when both x
		// and y are undefined.
		//		(2) when the t1 and t2 are non-conformant (for example t1 = String,
		// t2 = Integer) then
		//			the result is false.
		//
		//		For example,
		// 			"1 = 1.0" evaluates to true (unlike "(new Integer(1)).equals(new
		// Double(1.0))" which evalutes to false).
		//			"1 = 'x'" evalutes to false
		//			"(1/0) = 1" evaluates to false
		//			"(1/0) = (1/0)" evaluates to true
		//
		// otherwise, for non-primitive types, we use the "equals" method to
		// determine equality, which is, by default,
		// object identity.
		//
		// The semantics for inequality are dual.
		// 
		if (opCode == PredefinedType.EQUAL) {
			// evaluate source
			Object sourceVal = source.accept(this);

			// evaluate argument
			OCLExpression arg = (OCLExpression) args.get(0);
			Object argVal = arg.accept(this);

			return Boolean.valueOf(AnyTypeImpl.equal(sourceVal, argVal));
		}

		else if (opCode == PredefinedType.NOT_EQUAL) {
			// notEquals

			// evaluate source
			Object sourceVal = source.accept(this);

			// evaluate argument
			OCLExpression arg = (OCLExpression) args.get(0);
			Object argVal = arg.accept(this);

			return Boolean.valueOf(!AnyTypeImpl.equal(sourceVal, argVal));
		}

		if (sourceType instanceof PrimitiveType
			|| sourceType instanceof CollectionType
			|| sourceType instanceof EEnum || sourceType instanceof EDataType
			|| sourceType == Types.OCL_VOID || sourceType == Types.INVALID) {

			// TODO: Really VoidType should be a subtype of all the primitive
			// types

			if (numArgs == 0) {
				//
				// unary operations:
				//

				// evaluate source
				Object sourceVal = source.accept(this);

				// if source is undefined and the operation is not
				// undefined, then this expression is invalid
				if (isUndefined(sourceVal)
						&& opCode != PredefinedType.OCL_IS_UNDEFINED
						&& opCode != PredefinedType.OCL_IS_INVALID)
					return Types.OCL_INVALID;
				
				// evaluate this operation
				switch (opCode) {
						
					case PredefinedType.MINUS:
						// Integer::minus()
						if (sourceVal instanceof Integer)
							return new Integer(-((Integer) sourceVal)
								.intValue());

						// Double::minus()
						return new Double(-((Double) sourceVal).doubleValue());

					case PredefinedType.ABS:
						if (sourceVal instanceof Integer)
							// Integer::abs()
							return new Integer(Math.abs(((Integer) sourceVal)
								.intValue()));

						// Real::abs()
						return new Double(Math.abs(((Double) sourceVal)
							.doubleValue()));

					case PredefinedType.FLOOR:
						if (sourceVal instanceof Double) {
							// Real::floor()
							Double sourceDoubleVal = (Double) sourceVal;
							return new Integer((int) Math.floor(sourceDoubleVal
								.doubleValue()));
						}

						// Integer::floor()
						return sourceVal;

					case PredefinedType.ROUND:
						if (sourceVal instanceof Double) {
							// Real::round()
							Double sourceDoubleVal = (Double) sourceVal;
							return new Integer((int) Math.round(sourceDoubleVal
								.doubleValue()));
						}

						// Integer::round()
						return sourceVal;

					case PredefinedType.NOT:
						return (((Boolean) sourceVal).booleanValue()) ? Boolean.FALSE
							: Boolean.TRUE;

					case PredefinedType.OCL_IS_UNDEFINED:
						// OclAny::oclIsUndefined()
						return isUndefined(sourceVal)?
								Boolean.TRUE : Boolean.FALSE;

					case PredefinedType.OCL_IS_INVALID:
						// OclAny::oclIsInvalid()
						return (sourceVal == Types.OCL_INVALID)?
								Boolean.TRUE : Boolean.FALSE;

					case PredefinedType.SIZE:
						if (sourceType == Types.OCL_STRING) {
							// String::size()
							return new Integer(((String) sourceVal).length());
						} else if (sourceType instanceof CollectionType) {
							return new Integer(((Collection) sourceVal).size());
						}
					case PredefinedType.TO_INTEGER:
						// String::toInteger()
						return Integer.valueOf((String) sourceVal);

					case PredefinedType.TO_REAL:
						// String::toReal()
						return Double.valueOf((String) sourceVal);

					case PredefinedType.TO_LOWER:
						// String::toLower()
						return UnicodeSupport.toLowerCase((String) sourceVal);

					case PredefinedType.TO_UPPER:
						// String::toUpper()
						return UnicodeSupport.toUpperCase((String) sourceVal);

					case PredefinedType.IS_EMPTY:
						// Collection::isEmpty()
						return Boolean.valueOf(((Collection) sourceVal)
							.isEmpty());

					case PredefinedType.NOT_EMPTY:
						// Collection::notEmpty()
						return Boolean.valueOf(!((Collection) sourceVal)
							.isEmpty());

					case PredefinedType.SUM:
						// Collection::sum()
						return CollectionTypeImpl.sum((Collection) sourceVal);

					case PredefinedType.FLATTEN:
						// Set, Bag, Sequence, OrderedSet::flatten()
						return CollectionTypeImpl
							.flatten((Collection) sourceVal);

					case PredefinedType.AS_SET:
						// Set, Bag, Sequence, OrderedSet::asSet()
						return CollectionTypeImpl.asSet((Collection) sourceVal);

					case PredefinedType.AS_BAG:
						// Set, Bag, Sequence, OrderedSet::asBag()
						return CollectionTypeImpl.asBag((Collection) sourceVal);

					case PredefinedType.AS_ORDERED_SET:
						// Set, Bag, Sequence, OrderedSet::asOrderedSet()
						return CollectionTypeImpl
							.asOrderedSet((Collection) sourceVal);

					case PredefinedType.AS_SEQUENCE:
						// Set, Bag, Sequence, OrderedSet::asSequence)
						return CollectionTypeImpl
							.asSequence((Collection) sourceVal);

					case PredefinedType.FIRST:
						// OrderedSet::first()
						return CollectionTypeImpl.first((Collection) sourceVal);

					case PredefinedType.LAST:
						// OrderedSet::last()
						return CollectionTypeImpl.last((Collection) sourceVal);

				} // end of unary operation switch

			} else if (numArgs == 1) {
				//
				// binary operations:
				//

				// evaluate argument
				OCLExpression arg = (OCLExpression) args.get(0);

				// get argument type
				EClassifier argType = arg.getType();

				// evaluate source;
				Object sourceVal = source.accept(this);

				// AnyType::oclIsTypeOf(OclType)
				if (opCode == PredefinedType.OCL_IS_TYPE_OF)
					return oclIsTypeOf(sourceVal, arg.accept(this));

				// AnyType::oclIsKindOf(OclType)
				else if (opCode == PredefinedType.OCL_IS_KIND_OF)
					return oclIsKindOf(sourceVal, arg.accept(this));

				// AnyType::oclAsType(OclType)
				else if (opCode == PredefinedType.OCL_AS_TYPE) {
					// Type conversions for the built-in, non-collection
					// types are completely checked in the parser. The only
					// actual work that
					// needs to be done here is to convert from Any/Real to
					// Integer
					// and back (necessary since in OCL Integers extend
					// Reals but this is not true of the java primtives).

					// if the source is undefined or the conversion to
					// OclVoid so is the result
					if (sourceVal == null || argType == Types.OCL_VOID)
						return null;
					if (sourceVal == Types.OCL_INVALID || argType == Types.INVALID)
						return Types.OCL_INVALID;

					if (sourceVal instanceof Double
						&& argType == Types.OCL_INTEGER)
						return new Integer(((Double) sourceVal).intValue());
					else if (sourceVal instanceof Integer
						&& argType == Types.OCL_REAL)
						return new Double(((Integer) sourceVal).doubleValue());
					return sourceVal;
				}

				if (isUndefined(sourceVal)) {
					return Types.OCL_INVALID;
				}
				
				// evaluate arg, unless we have a boolean operation
				Object argVal = null;
				if (!(sourceVal instanceof Boolean)) {
					argVal = arg.accept(this);
				}

				if (sourceVal instanceof Integer && argVal instanceof Integer) {
					//
					// source and single arg are both integers
					//

					switch (opCode) {

						// Integer::plus(Integer)
						case PredefinedType.PLUS:
							return new Integer(((Integer) sourceVal).intValue()
								+ ((Integer) argVal).intValue());

						// Integer::minus(Integer)
						case PredefinedType.MINUS:
							return new Integer(((Integer) sourceVal).intValue()
								- ((Integer) argVal).intValue());

						// Integer::times(Integer)
						case PredefinedType.TIMES:
							return new Integer(((Integer) sourceVal).intValue()
								* ((Integer) argVal).intValue());

						// Integer::divide(Integer)
						case PredefinedType.DIVIDE: {
							// denominator of 0 means undefined
							double num = ((Integer) sourceVal).doubleValue();
							double denom = ((Integer) argVal).doubleValue();
							return (denom == 0.0) ? null : new Double(num
								/ denom);
						}

						// Integer::div(Integer)
						case PredefinedType.DIV: {
							int num = ((Integer) sourceVal).intValue();
							int denom = ((Integer) argVal).intValue();
							// denominator of 0 means undefined
							return (denom == 0) ? null : new Integer(num
								/ denom);
						}

						// Integer::mod(Integer)
						case PredefinedType.MOD:
							return new Integer(((Integer) sourceVal).intValue()
								% ((Integer) argVal).intValue());

						// Integer::max(Integer)
						case PredefinedType.MAX:
							return new Integer(Math.max(((Integer) sourceVal)
								.intValue(), ((Integer) argVal).intValue()));

						// Integer::min(Integer)
						case PredefinedType.MIN:
							return new Integer(Math.min(((Integer) sourceVal)
								.intValue(), ((Integer) argVal).intValue()));

						// Integer::lessThan(Integer)
						case PredefinedType.LESS_THAN:
							return ((Integer) sourceVal).intValue() < ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThan(Integer)
						case PredefinedType.GREATER_THAN:
							return ((Integer) sourceVal).intValue() > ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::lessThanEqual(Integer)
						case PredefinedType.LESS_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() <= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThanEqual(Integer)
						case PredefinedType.GREATER_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() >= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
									oper.getName());
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Integer
					&& argVal instanceof Double) {
					//
					// source is an integer and single arg is a real
					//

					switch (opCode) {

						// Integer::plus(Real)
						case PredefinedType.PLUS:
							return new Double(((Integer) sourceVal).intValue()
								+ ((Double) argVal).doubleValue());

						// Integer::minus(Real)
						case PredefinedType.MINUS:
							return new Double(((Integer) sourceVal).intValue()
								- ((Double) argVal).doubleValue());

						// Integer::times(Real)
						case PredefinedType.TIMES:
							return new Double(((Integer) sourceVal).intValue()
								* ((Double) argVal).doubleValue());

						// Integer::divide(Real)
						case PredefinedType.DIVIDE:
							return new Double(((Integer) sourceVal).intValue()
								/ ((Double) argVal).doubleValue());

						// Integer::max(Real)
						case PredefinedType.MAX:
							return new Double(Math.max(((Integer) sourceVal)
								.intValue(), ((Double) argVal).doubleValue()));

						// Integer::min(Real)
						case PredefinedType.MIN:
							return new Double(Math.min(((Integer) sourceVal)
								.intValue(), ((Double) argVal).doubleValue()));

						// Integer::lessThan(Real)
						case PredefinedType.LESS_THAN:
							return ((Integer) sourceVal).intValue() < ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThan(Real)
						case PredefinedType.GREATER_THAN:
							return ((Integer) sourceVal).intValue() > ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::lessThanEqual(Real)
						case PredefinedType.LESS_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() <= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThanEqual(Real)
						case PredefinedType.GREATER_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() >= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
									oper.getName());
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				}

				else if (sourceVal instanceof Double
					&& argVal instanceof Integer) {
					//
					// source is a real and single arg is an integer
					//	

					switch (opCode) {

						// Real::plus(Integer)
						case PredefinedType.PLUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								+ ((Integer) argVal).intValue());

						// Real::minus(Integer)
						case PredefinedType.MINUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								- ((Integer) argVal).intValue());

						// Real::times(Integer)
						case PredefinedType.TIMES:
							return new Double(((Double) sourceVal)
								.doubleValue()
								* ((Integer) argVal).intValue());

						// Real::divide(Integer)
						case PredefinedType.DIVIDE:
							return new Double(((Double) sourceVal)
								.doubleValue()
								/ ((Integer) argVal).intValue());

						// Real::max(Integer)
						case PredefinedType.MAX:
							return new Double(Math.max(((Double) sourceVal)
								.doubleValue(), ((Integer) argVal).intValue()));

						// Real::min(Integer)
						case PredefinedType.MIN:
							return new Double(Math.min(((Double) sourceVal)
								.doubleValue(), ((Integer) argVal).intValue()));

						// Real::lessThan(Integer)
						case PredefinedType.LESS_THAN:
							return ((Double) sourceVal).doubleValue() < ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThan(Integer)
						case PredefinedType.GREATER_THAN:
							return ((Double) sourceVal).doubleValue() > ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::lessThanEqual(Integer)
						case PredefinedType.LESS_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() <= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThanEqual(Integer)
						case PredefinedType.GREATER_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() >= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
								oper.getName());
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Double
					&& argVal instanceof Double) {
					//
					// source is a real and single arg is a real
					//	

					switch (opCode) {

						// Real::plus(Real)
						case PredefinedType.PLUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								+ ((Double) argVal).doubleValue());

						// Real::minus(Real)
						case PredefinedType.MINUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								- ((Double) argVal).doubleValue());

						// Real::times(Real)
						case PredefinedType.TIMES:
							return new Double(((Double) sourceVal)
								.doubleValue()
								* ((Double) argVal).doubleValue());

						// Real::divide(Real)
						case PredefinedType.DIVIDE:
							return new Double(((Double) sourceVal)
								.doubleValue()
								/ ((Double) argVal).doubleValue());

						// Real::max(Real)
						case PredefinedType.MAX:
							return new Double(Math
								.max(((Double) sourceVal).doubleValue(),
									((Double) argVal).doubleValue()));

						// Real::min(Real)
						case PredefinedType.MIN:
							return new Double(Math
								.min(((Double) sourceVal).doubleValue(),
									((Double) argVal).doubleValue()));

						// Real::lessThan(Real)
						case PredefinedType.LESS_THAN:
							return ((Double) sourceVal).doubleValue() < ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThan(Real)
						case PredefinedType.GREATER_THAN:
							return ((Double) sourceVal).doubleValue() > ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::lessThanEqual(Real)
						case PredefinedType.LESS_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() <= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThanEqual(Real)
						case PredefinedType.GREATER_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() >= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
								oper.getName());
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Boolean) {
					// the logic with an undefined value is basic 3-valued
					// logic:
					// null represents the undefined value

					// boolean source and single boolean arg
					switch (opCode) {
						// Boolean::or(Boolean)
						case PredefinedType.OR:
							if (Boolean.TRUE.equals(sourceVal))
								return Boolean.TRUE;
							
							// must evaluate the argument now
							argVal = arg.accept(this);
							return argVal;

						// Boolean::xor(Boolean)
						case PredefinedType.XOR:
							// XOR does not have a short-circuit
							argVal = arg.accept(this);
							
							if (sourceVal == null)
								return argVal;
							return (argVal == null) ? sourceVal
								: (((Boolean) sourceVal).booleanValue()
									^ ((Boolean) argVal).booleanValue() ? Boolean.TRUE
									: Boolean.FALSE);

						// Boolean::and(Boolean)
						case PredefinedType.AND:
							if (!Boolean.TRUE.equals(sourceVal))
								return Boolean.FALSE;
							
							// must evaluate the argument now
							argVal = arg.accept(this);
							return argVal;

						// Boolean::implies
						case PredefinedType.IMPLIES:
							if (Boolean.FALSE.equals(sourceVal))
								return Boolean.TRUE;
							
							// must evaluate the argument now
							argVal = arg.accept(this);
							return argVal;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
									oper.getName());
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}

				}

				else if (sourceVal instanceof String
					&& argVal instanceof String) {

					switch (opCode) {
						// String::concat(String)
						case PredefinedType.CONCAT:
							return ((String) sourceVal).concat((String) argVal);

						// Handle < (lessThan)
						case PredefinedType.LESS_THAN:
							return Boolean.valueOf(((String) sourceVal).compareTo((String) argVal) < 0);

						//	Handle <= (lessThanEqual)
						case PredefinedType.LESS_THAN_EQUAL:
							return Boolean.valueOf(((String) sourceVal).compareTo((String) argVal) <= 0);

						// Handle > (greaterThan)
						case PredefinedType.GREATER_THAN:
							return Boolean.valueOf(((String) sourceVal).compareTo((String) argVal) > 0);

						// Handle > (greaterThanEqual)
						case PredefinedType.GREATER_THAN_EQUAL:
							return Boolean.valueOf(((String) sourceVal).compareTo((String) argVal) >= 0);

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
									oper.getName());
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Collection) {
					Collection sourceColl = (Collection) sourceVal;

					switch (opCode) {
						case PredefinedType.INCLUDES:
							// Collection::includes(T)
							return CollectionTypeImpl.includes(sourceColl,
								argVal) ? Boolean.TRUE : Boolean.FALSE;

						case PredefinedType.EXCLUDES:
							// Collection::excludes(T)
							return CollectionTypeImpl.excludes(sourceColl,
								argVal) ? Boolean.TRUE : Boolean.FALSE;

						case PredefinedType.COUNT:
							// Collection::count(T)
							return new Integer(CollectionTypeImpl.count(
								sourceColl, argVal));

						case PredefinedType.INCLUDES_ALL:
							// Collection::includesAll(T)
							return CollectionTypeImpl.includesAll(sourceColl,
								(Collection) argVal) ? Boolean.TRUE
								: Boolean.FALSE;

						case PredefinedType.EXCLUDES_ALL:
							// Collection::excludesAll(T)
							return CollectionTypeImpl.excludesAll(sourceColl,
								(Collection) argVal) ? Boolean.TRUE
								: Boolean.FALSE;

						case PredefinedType.PRODUCT:
							// Collection::product(Collection(T2))
							return CollectionTypeImpl.product(
									sourceColl,
									(Collection) argVal,
									(EClass) ((CollectionType) oc.getType()).getElementType());

						case PredefinedType.UNION: {
							// Set, Bag::union(Set, Bag)
							Collection argColl = (Collection) argVal;
							return CollectionTypeImpl
								.union(sourceColl, argColl);
						}

						case PredefinedType.INTERSECTION: {
							// Set, Bag::intersection(Set, Bag)
							Collection argColl = (Collection) argVal;
							return CollectionTypeImpl.intersection(sourceColl,
								argColl);
						}

						case PredefinedType.MINUS:
							// Set::minus(Set)
							return CollectionTypeImpl.minus((Set) sourceColl,
								(Set) argVal);

						case PredefinedType.INCLUDING:
							// Set, Bag, Sequence::including(T)
							return CollectionTypeImpl.including(sourceColl,
								argVal);

						case PredefinedType.EXCLUDING:
							// Set, Bag, Sequence::excluding(T)
							return CollectionTypeImpl.excluding(sourceColl,
								argVal);

						case PredefinedType.SYMMETRIC_DIFFERENCE:
							// Set::symmetricDifference(Set)
							return CollectionTypeImpl.symmetricDifference(
								(Set) sourceColl, (Set) argVal);

						case PredefinedType.APPEND:
							// OrderedSet, Sequence::append(T)
							return CollectionTypeImpl
								.append(sourceColl, argVal);

						case PredefinedType.PREPEND:
							// OrderedSet, Sequence::prepend(T)
							return CollectionTypeImpl.prepend(sourceColl,
								argVal);

						case PredefinedType.AT: {
							// OrderedSet, Sequence::at(Integer)
							int indexVal = ((Integer) argVal).intValue();
							return CollectionTypeImpl.at(sourceColl, indexVal);
						}

						case PredefinedType.INDEX_OF:
							// OrderedSet, Sequence::indexOf(T)
							return CollectionTypeImpl.indexOf(sourceColl,
								argVal);
					} // end of collection type switch
				} else if (sourceVal instanceof Comparable) {

					// Handle < (lessThan)
					if (opCode == PredefinedType.LESS_THAN) {
						Comparable comp = (Comparable) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) < 0);
					}

					//	Handle <= (lessThanEqual)
					else if (opCode == PredefinedType.LESS_THAN_EQUAL) {
						Comparable comp = (Comparable) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) <= 0);
					}

					// Handle > (greaterThan)
					else if (opCode == PredefinedType.GREATER_THAN) {
						Comparable comp = (Comparable) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) > 0);
					}

					// Handle > (greaterThanEqual)
					else if (opCode == PredefinedType.GREATER_THAN_EQUAL) {
						Comparable comp = (Comparable) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) >= 0);
					}
				}
			} else {
				//
				// ternary operations
				//

				// evaluate source
				Object sourceVal = source.accept(this);

				// check if undefined
				if (isUndefined(sourceVal))
					return Types.OCL_INVALID;

				// evaluate arg1
				Object arg1 = ((OCLExpression) args.get(0)).accept(this);

				// check if undefined
				if (isUndefined(arg1))
					return Types.OCL_INVALID;

				// evaluate arg2
				Object arg2 = ((OCLExpression) args.get(1)).accept(this);

				// check if undefined
				if (isUndefined(arg2))
					return Types.OCL_INVALID;

				if (sourceVal instanceof String) {
					// just one ternary string operation
					// String::substring(Integer, Integer)
					// index orgin 1 for OCL
					int lower = ((Integer) arg1).intValue() - 1;
					int upper = ((Integer) arg2).intValue();
					return ((String) sourceVal).substring(lower, upper);
				} else if (sourceVal instanceof Collection) {
					Collection sourceColl = (Collection) sourceVal;
					if (opCode == PredefinedType.INSERT_AT) {
						// OrderedSet, Sequence::insertAt(Integer, T)
						int index = ((Integer) arg1).intValue();
						return CollectionTypeImpl.insertAt(sourceColl, index,
							arg2);
					} else if (opCode == PredefinedType.SUB_ORDERED_SET) {
						// OrderedSet, Sequence::subOrderedSet(Integer, Integer)
						int lower = ((Integer) arg1).intValue();
						int upper = ((Integer) arg2).intValue();
						return CollectionTypeImpl.subOrderedSet(sourceColl,
							lower, upper);
					} else if (opCode == PredefinedType.SUB_SEQUENCE) {
						// Sequence::subSequence(Integer, Integer)
						int lower = ((Integer) arg1).intValue();
						int upper = ((Integer) arg2).intValue();
						return CollectionTypeImpl.subSequence(sourceColl,
							lower, upper);
					}
				}
			}
		} else {

			// evaluate source expression
			Object context = source.accept(this);
			
			// Handle allInstances
			if (opCode == PredefinedType.ALL_INSTANCES) {
				if (context instanceof EEnum) {
					// the instances are the literals
					return new java.util.HashSet(
						((EEnum) context).getELiterals());
				} else if (context == Types.OCL_VOID) {
					// OclVoid has a single instance: null
					Set result = new java.util.HashSet();
					result.add(null);
					return result;
				} else if (context instanceof EClass) {
					return extentMap.get(context);
				} else {
					// other types do not have numerable instances
					return new java.util.HashSet();
				}
			}

			if (opCode == PredefinedType.OCL_IS_UNDEFINED) {
				return isUndefined(context)?
						Boolean.TRUE : Boolean.FALSE;
			}

			if (opCode == PredefinedType.OCL_IS_INVALID) {
				return (context == Types.OCL_INVALID)?
						Boolean.TRUE : Boolean.FALSE;
			}

			// result is invalid if source is undefined
			if (isUndefined(context)) {
				return Types.OCL_INVALID;
			}

			// Handle type check and conversion:

			// AnyType::oclIsTypeOf(OclType)
			if (opCode == PredefinedType.OCL_IS_TYPE_OF) {
				OCLExpression arg = (OCLExpression) args.get(0);
				return oclIsTypeOf(context, arg.accept(this));
			}

			// AnyType::oclIsKindOf(OclType)
			else if (opCode == PredefinedType.OCL_IS_KIND_OF) {
				OCLExpression arg = (OCLExpression) args.get(0);
				return oclIsKindOf(context, arg.accept(this));
			}

			// AnyType::oclAsType(OclType)
			else if (opCode == PredefinedType.OCL_AS_TYPE) {
				// Check if the source object type is really
				// conformant to the arg type. Note that
				// it is not possible to do this check 100%
				// at parse time because we only have the
				// declared type of the source to check
				// against the arg type and it may happen
				// that the declared type is not conformant
				// but a subtype of it is. For example,
				// if there are four types A, B, C, and D;
				// B is subtype of both A and C; D is a subtype of A;
				// and x is a variable of type A; then it is impossible
				// to know at parse time whether x.oclAsType(C)
				// is a valid conversion. If x is an object of
				// type B then it is; if x is an object of type D
				// then it isn't; and this cannot be determined
				// until runtime.				
				OCLExpression arg = (OCLExpression) args.get(0);
				EClassifier type = (EClassifier) arg.accept(this);
				if (oclIsKindOf(context, type) == Boolean.TRUE) {
					return context;
				} else {
					return Types.OCL_INVALID;
				}
			}

			// Handle < (lessThan)
			else if ((opCode == PredefinedType.LESS_THAN) && (context instanceof Comparable)) {
				Comparable compContext = (Comparable) context;
				OCLExpression arg = (OCLExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) < 0);
			}

			//	Handle <= (lessThanEqual)
			else if ((opCode == PredefinedType.LESS_THAN_EQUAL) && (context instanceof Comparable)) {
				Comparable compContext = (Comparable) context;
				OCLExpression arg = (OCLExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) <= 0);
			}

			// Handle > (greaterThan)
			else if ((opCode == PredefinedType.GREATER_THAN) && (context instanceof Comparable)) {
				Comparable compContext = (Comparable) context;
				OCLExpression arg = (OCLExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) > 0);
			}

			// Handle > (greaterThanEqual)
			else if ((opCode == PredefinedType.GREATER_THAN_EQUAL) && (context instanceof Comparable)) {
				Comparable compContext = (Comparable) context;
				OCLExpression arg = (OCLExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) >= 0);
			}

			//
			// regular operation invocation
			//

			// evaluate args
			List evalArgs = new LinkedList();
			for (Iterator it = args.iterator(); it.hasNext();) {
				OCLExpression arg = (OCLExpression) it.next();
				Object evalArg = arg.accept(this);

				// result is invalid if any arg is
				if (evalArg == Types.OCL_INVALID)
					return Types.OCL_INVALID;

				evalArgs.add(evalArg);
			}

			// get types of the arguments
			Class[] argTypes = new Class[args.size()];
			for (int i = 0, n = args.size(); i < n; i++) {
				OCLExpression e = (OCLExpression) args.get(i);
				argTypes[i] = e.getType().getInstanceClass();
			}

			// get java method for operation
			Method method = getJavaMethodFor(oper);

			if (method == null) {
				return Types.OCL_INVALID;
			}
			
			// invoke method on evaluated args
			try {
				Object result = method.invoke(context, evalArgs.toArray());
				return result;
			} catch (Exception e) {
				OCLPlugin
					.catching(getClass(), "visitOperationCallExp", e);//$NON-NLS-1$
				OCLPlugin.log(
					IStatus.ERROR,
					OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
					OCLMessages.bind(
						OCLMessages.ErrorMessage_ERROR_,
						"visitOperationCallExp", //$NON-NLS-1$
						e.getLocalizedMessage()),
					e);
				return Types.OCL_INVALID;
			}
		}

		return null;
	}
    
    /**
     * Invokes the specified additional operation.
     */
    private Object invoke(EOperation operation, OCLExpression body, Object target, Object[] args) {
    	// create a nested evaluation environment for this operation call
    	EvaluationEnvironment evalEnv = new EvalEnvironment(getEvalEnvironment());
    	
    	// bind "self"
    	evalEnv.add("self", target); //$NON-NLS-1$
    	
    	// add the parameter bindings to the local variables
    	if (args.length > 0) {
    		int i = 0;
    		for (Iterator iter = operation.getEParameters().iterator(); iter.hasNext(); i++) {
    			EParameter next = (EParameter) iter.next();
    			
    			evalEnv.add(next.getName(), args[i]);
    		}
    	}
    	
    	return body.accept(getInstance(evalEnv, getExtentMap()));
    }
    
    /**
     * Obtains the body of the specified operation or property from a def, der,
     * or body expression annotation, if any.
     * 
     * @param feature an operation or property
     * 
     * @return its value expression, if any
     */
    private OCLExpression getBody(ETypedElement feature) {
    	OCLExpression result = null;
    	
    	EAnnotation ann = feature.getEAnnotation(Environment.ANNOTATION_URI_DEFINE);
    	if (ann == null) {
    		if (feature instanceof EOperation) {
    			// try a body annotation
    			ann = feature.getEAnnotation(Environment.ANNOTATION_URI_BODY);
    		} else if (feature instanceof EStructuralFeature) {
    			// try a derivation annotation
    			ann = feature.getEAnnotation(Environment.ANNOTATION_URI_DERIVE);
    		}
    	}
    	
    	if ((ann != null) && !ann.getContents().isEmpty()) {
    		Constraint constraint = (Constraint) ann.getContents().get(0);
    		result = constraint.getBody();
    	}
    	
    	return result;
    }

	/**
	 * Returns the java method that corresponds to the supplied
	 * <code>EOperation</code>
	 * 
	 * @param oper
	 *            the operation
	 * @return a java method
	 */
	public static Method getJavaMethodFor(EOperation oper) {
		Method result = null;

		// in the case of infix operators, we need to replace the name with
		//    a valid Java name.  We will choose the legacy OCL parser names
		//    which some clients already depend on
		String operName = oper.getName();
		int opcode = PrimitiveTypeImpl.getOperationCode(operName);
		switch (opcode) {
		case PredefinedType.PLUS:
			operName = "plus"; //$NON-NLS-1$
			break;
		case PredefinedType.MINUS:
			operName = "minus"; //$NON-NLS-1$
			break;
		case PredefinedType.TIMES:
			operName = "times"; //$NON-NLS-1$
			break;
		case PredefinedType.DIVIDE:
			operName = "divide"; //$NON-NLS-1$
			break;
		case PredefinedType.LESS_THAN:
			operName = "lessThan"; //$NON-NLS-1$
			break;
		case PredefinedType.LESS_THAN_EQUAL:
			operName = "lessThanEqual"; //$NON-NLS-1$
			break;
		case PredefinedType.GREATER_THAN:
			operName = "greaterThan"; //$NON-NLS-1$
			break;
		case PredefinedType.GREATER_THAN_EQUAL:
			operName = "greaterThanEqual"; //$NON-NLS-1$
			break;
		}
		
		// get containing class for the operation
		EClass container = oper.getEContainingClass();

		// get the corresponding java instance class
		Class containerClass = container.getInstanceClass();

		// get the parameter types as java classes
		EList parms = oper.getEParameters();
		Class[] javaParms = new Class[parms.size()];
		for (int i = 0, n = parms.size(); i < n; i++) {
			EParameter parm = (EParameter) parms.get(i);
			
			if (parm.isMany()) {
				javaParms[i] = EList.class; // TODO: EList could be suppressed
			} else {
				javaParms[i] = parm.getEType().getInstanceClass();
			}
		}

		// lookup the method on the java class
		try {
			result = containerClass.getMethod(operName, javaParms);
		} catch (NoSuchMethodException e) {
			//do nothing
		}

		return result;
	}

	/**
	 * Callback for an IterateExp visit.
	 */
	public Object visitIterateExp(IterateExp ie) {

		// get the variable declaration for the result
		Variable vd = ie.getResult();
		String resultName = (String) vd.accept(this);

		try {
			// get the list of ocl iterators
			EList iterators = ie.getIterator();
	
			// evaluate the source collection
			Object sourceValue = ie.getSource().accept(this);
	
			// value of iteration expression is undefined if the source is
			//   null or OclInvalid
			if (isUndefined(sourceValue)) {
				return Types.OCL_INVALID;
			}
			
			Collection coll = (Collection) sourceValue;
			
			// get the body expression
			OCLExpression body = ie.getBody();
	
			// construct an iteration template to evaluate the iterator
			IterationTemplate is = IterationTemplate.getInstance(this);
	
			// evaluate
			return is.evaluate(coll, iterators, body, resultName);
		} finally {
			// remove result variable from environment
			env.remove(resultName);
		}
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	public Object visitIteratorExp(IteratorExp ie) {
		EClassifier sourceType = ie.getSource().getType();
		
		if (sourceType instanceof PredefinedType) {
			Object sourceValue = ie.getSource().accept(this);
			
			// value of iteration expression is undefined if the source is
			//   null or OclInvalid
			if (isUndefined(sourceValue)) {
				return Types.OCL_INVALID;
			}
			
			Collection sourceCollection = (Collection) sourceValue;
			
			switch (((PredefinedType) sourceType).getOperationCodeFor(ie.getName())) {
			case PredefinedType.EXISTS:
				return evaluateExistsIterator(ie, sourceCollection);
			case PredefinedType.FOR_ALL:
				return evaluateForAllIterator(ie, sourceCollection);
			case PredefinedType.SELECT:
				return evaluateSelectIterator(ie, sourceCollection);
			case PredefinedType.REJECT:
				return evaluateRejectIterator(ie, sourceCollection);
			case PredefinedType.COLLECT:
				return evaluateCollectIterator(ie, sourceCollection);
			case PredefinedType.COLLECT_NESTED:
				return evaluateCollectNestedIterator(ie, sourceCollection);
			case PredefinedType.ONE:
				return evaluateOneIterator(ie, sourceCollection);
			case PredefinedType.ANY:
				return evaluateAnyIterator(ie, sourceCollection);
			case PredefinedType.SORTED_BY:
				return evaluateSortedByIterator(ie, sourceCollection);
			case PredefinedType.IS_UNIQUE:
				return evaluateIsUnique(ie, sourceCollection);
			case PredefinedType.CLOSURE:
				return evaluateClosure(ie, sourceCollection);
			}
		}
		
		String message = OCLMessages.bind(
				OCLMessages.IteratorNotImpl_ERROR_, ie.getName());
		UnsupportedOperationException ex = new UnsupportedOperationException(
			message);
		OCLPlugin.throwing(getClass(), "visitIteratorExp", ex);//$NON-NLS-1$
		throw ex;
	}

	public Object evaluateExistsIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//        int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTempateExists.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, Boolean.FALSE);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove the result variable from the environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateForAllIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateForAll.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, Boolean.TRUE);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from the environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateCollectNestedIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get initial result value based on the source type
		CollectionType collType = (CollectionType) ie.getSource().getType();
		Object initResultVal = null;
		if (collType instanceof SetType || collType instanceof BagType)
			// collection on a Bag or a Set yields a Bag
			initResultVal = CollectionTypeImpl.createNewBag();
		else
			// Sequence or Ordered Set yields a Sequence
			initResultVal = CollectionTypeImpl.createNewSequence();
		
		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateCollectNested.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateCollectIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get initial result value based on the source type
		CollectionType collType = (CollectionType) ie.getSource().getType();
		Object initResultVal = null;
		if (collType instanceof SetType || collType instanceof BagType)
			// collection on a Bag or a Set yields a Bag
			initResultVal = CollectionTypeImpl.createNewBag();
		else
			// Sequence or Ordered Set yields a Sequence
			initResultVal = CollectionTypeImpl.createNewSequence();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateCollect.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateSelectIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get initial result value based on the source type
		CollectionType collType = (CollectionType) ie.getSource().getType();
		Object initResultVal = null;
		if (collType instanceof SetType)
			// Set
			initResultVal = CollectionTypeImpl.createNewSet();
		else if (collType instanceof BagType)
			// Bag
			initResultVal = CollectionTypeImpl.createNewBag();
		else if (collType instanceof SequenceType)
			// Sequence
			initResultVal = CollectionTypeImpl.createNewSequence();
		else
			// OrderedSet
			initResultVal = CollectionTypeImpl.createNewOrderedSet();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateSelect.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateRejectIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get initial result value based on the source type
		CollectionType collType = (CollectionType) ie.getSource().getType();
		Object initResultVal = null;
		if (collType instanceof SetType)
			// Set
			initResultVal = CollectionTypeImpl.createNewSet();
		else if (collType instanceof BagType)
			// Bag
			initResultVal = CollectionTypeImpl.createNewBag();
		else if (collType instanceof SequenceType)
			// Sequence
			initResultVal = CollectionTypeImpl.createNewSequence();
		else
			// OrderedSet
			initResultVal = CollectionTypeImpl.createNewOrderedSet();

		//	get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateReject.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateOneIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateOne.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, Boolean.FALSE);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		return result;
	}

	public Object evaluateAnyIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateAny.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, null);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateSortedByIterator(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateSortedBy.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, new HashMap());

		// evaluate
		// TODO: find an efficient way to do this.
		Object evaluationResult = is.evaluate(coll, iterators, body, resultName);
		
		if (evaluationResult == Types.OCL_INVALID) {
			// handle the OclInvalid result
			return evaluationResult;
		}
		
		final Map bodyEvals = (Map) is.evaluate(coll, iterators, body,
			resultName);

		// remove result name from environment
		env.remove(resultName);

		// sort the source collection based on the natural ordering of the
		// body expression evaluations
		List result = new ArrayList(coll);

		Collections.sort(result, new Comparator() {

			public int compare(Object o1, Object o2) {
				Comparable b1 = (Comparable) bodyEvals.get(o1);
				Comparable b2 = (Comparable) bodyEvals.get(o2);
				return (b1.compareTo(b2));
			}
		});

		// create result
		// type is Sequence if source is a sequence or a Bag,
		// SortedSet if source is a SortedSet or a Set
		CollectionType collType = (CollectionType) ie.getSource().getType();
		if (collType instanceof SetType || collType instanceof OrderedSetType)
			return CollectionTypeImpl.createNewOrderedSet(result);
		else
			return CollectionTypeImpl.createNewSequence(result);
	}

	public Object evaluateIsUnique(IteratorExp ie, Collection coll) {
		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		
		// get the body expression
		OCLExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateIsUnique.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, new HashSet());

		// evaluate
		is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return is.isDone() ? Boolean.FALSE : Boolean.TRUE;
	}

	public Object evaluateClosure(IteratorExp ie, Collection coll) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();

		// get the body expression
		OCLExpression body = ie.getBody();

		// create initial result value
		Object initResultVal = CollectionTypeImpl.createNewSet();

		// get an iteration template to evaluate the iterator
		IterationTemplate template = IterationTemplateClosure.getInstance(this, body);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, initResultVal);

		// evaluate
		Object result = template.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return result;
	}

	private static int tempCounter = 0;

	private static synchronized String generateName() {
		return "__result__" + tempCounter++;//$NON-NLS-1$
	}

	/**
	 * Callback for an EnumLiteralExp visit. Get the referred enum literal and
	 * return it as an Integer.
	 * 
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal as an Integer
	 */
	public Object visitEnumLiteralExp(EnumLiteralExp el) {
		return el.getReferredEnumLiteral();
	}

	/**
	 * Callback for a VariableExp visit.
	 * 
	 * @param v
	 *            the variable expression
	 * @return the value of the variable
	 */
	public Object visitVariableExp(VariableExp v) {

		// get the referred variable name
		Variable vd = v.getReferredVariable();
		String varName = vd.getName();

		// evaluate the variable in the current environment
		EvaluationEnvironment ee = getEvalEnvironment();
		Object result = ee.getValueOf(varName);
		return result;
	}

	/**
	 * Callback for a PropertyCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the property on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the property "foo" would be accessed
	 * on that object.
	 */
	public Object visitPropertyCallExp(PropertyCallExp pc) {
		EStructuralFeature property = pc.getReferredProperty();
		OCLExpression source = pc.getSource();

		// evaluate source
		EObject context = (EObject) source.accept(this);

		// if source is undefined, result is OclInvalid
		if (isUndefined(context))
			return Types.OCL_INVALID;

		OCLExpression derivation = getBody(property);
		if (derivation != null) {
			// this is an additional property
			
			return get(property, derivation, context);
		}
		
		// evaluate attribute on source value
		Object result = context.eGet(property);
		
		if ((pc.getType() instanceof CollectionType) && !(result instanceof Collection)) {
			// this was an XSD "unspecified multiplicity".  Now that we know what
			//    the multiplicity is, we can coerce it to a collection value
			
			CollectionKind kind = ((CollectionType) pc.getType()).getKind();
			Collection collection = CollectionFactory.getInstance().createCollection(
					kind.getValue());
			
			collection.add(result);
			result = collection;
		}
		
		return result;
	}
    
    /**
     * Navigates the specified additional property.
     */
    private Object get(EStructuralFeature property, OCLExpression derivation, Object target) {
    	// create a nested evaluation environment for this operation call
    	EvaluationEnvironment evalEnv = new EvalEnvironment(getEvalEnvironment());
    	
    	// bind "self"
    	evalEnv.add("self", target); //$NON-NLS-1$
    	
    	return derivation.accept(getInstance(evalEnv, getExtentMap()));
    }

	/**
	 * Callback for an AssociationClassCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the reference on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the reference "foo" would be derived
	 * on that object.
	 */
	public Object visitAssociationClassCallExp(AssociationClassCallExp ae) {
		EObject context = (EObject) ae.getSource().accept(this);
		if (isUndefined(context)) {
			return Types.OCL_INVALID;
		}
		EReference ref = getAssociationClassReference(
			context, ae.getReferredAssociationClass());

		return context.eGet(ref);
	}

	/**
	 * Retrieves the reference feature in the specified context object that
	 * references the specified association class.
	 * 
	 * @param context the context object
	 * @param associationClass the association class that it references
	 * @return the reference in question
	 */
	private EReference getAssociationClassReference(
			EObject context, EClass associationClass) {
		EReference result = null;
		
		StringBuffer nameBuf = new StringBuffer(associationClass.getName());
		UnicodeSupport.setCodePointAt(
				nameBuf,
				0,
				UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(nameBuf, 0)));
		String name = nameBuf.toString();
		
		for (Iterator iter = context.eClass().getEAllReferences().iterator();
				(result == null) && iter.hasNext();) {
			
			EReference next = (EReference) iter.next();
			if (name.equals(next.getName()) && (associationClass == next.getEReferenceType())) {
				result = next;
			}
		}
		
		return result;
	}

	/**
	 * Callback for a VariableDeclaration visit.
	 */
	public Object visitVariable(Variable vd) {
		// add the variable to the environment, initialized to
		// its initial expression (if it has one). return the name
		// of the variable.
		String varName = vd.getName();
		OCLExpression initExp = vd.getInitExpression();
		Object initVal = null;
		if (initExp != null)
			initVal = initExp.accept(this);
		env.add(varName, initVal);
		return varName;
	}

	/**
	 * Callback for an IfExp visit.
	 */
	public Object visitIfExp(IfExp ie) {
		// get condition
		OCLExpression condition = ie.getCondition();

		// evaluate condition
		Boolean condVal = (Boolean) condition.accept(this);
		if (condVal == null)
			return null;

		if (condVal.booleanValue())
			return ie.getThenExpression().accept(this);
		return ie.getElseExpression().accept(this);
	}

	/**
	 * Callback for a TypeExp visiy.
	 */
	public Object visitTypeExp(TypeExp t) {
		return t.getReferredType();
	}
	
	public Object visitStateExp(StateExp s) {
		return s.getReferredState();
	}
	
	public Object visitMessageExp(MessageExp m) {
		throw new UnsupportedOperationException("evaluation of MessageExp"); //$NON-NLS-1$
	}
	
	/**
	 * Callback for an UnspecifiedValueExp visit.
	 */
	public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		// TODO: return a "random instance of the type of the expression"
		throw new UnsupportedOperationException("evaluation of UnspecifiedValueExp"); //$NON-NLS-1$
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 * 
	 * @return the value of the integer literal as a java.lang.Integer.
	 */
	public Object visitIntegerLiteralExp(IntegerLiteralExp il) {
		return il.getIntegerSymbol();
	}

	/**
	 * Callback for a RealLiteralExp visit.
	 * 
	 * @return the value of the real literal as a java.lang.Double.
	 */
	public Object visitRealLiteralExp(RealLiteralExp rl) {
		return rl.getRealSymbol();
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * 
	 * @return the value of the string literal as a java.lang.String.
	 */
	public Object visitStringLiteralExp(StringLiteralExp sl) {
		return sl.getStringSymbol();
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * 
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	public Object visitBooleanLiteralExp(BooleanLiteralExp bl) {
		return bl.getBooleanSymbol();
	}

	public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
		// just make up some object to take the place of the OclInvalid literal
		return Types.OCL_INVALID;
	}

	public Object visitNullLiteralExp(NullLiteralExp il) {
		// the single OclVoid instance is equivalent to Java null
		return null;
	}

	/**
	 * Callback for LetExp visit.
	 */
	public Object visitLetExp(LetExp l) {
		// get variable decl for let variable
		Variable vd = l.getVariable();
		String name = (String) vd.accept(this);

		// evaluate the "in" part of the let
		OCLExpression inExp = l.getIn();
		Object val = inExp.accept(this);

		// remove the variable-init expression binding from the environment
		env.remove(name);

		// return the value of the "in"
		return val;
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 */
	public Object visitCollectionLiteralExp(CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		CollectionKind kind = cl.getKind();
		List parts = cl.getPart();
		Collection result;
		if (kind == CollectionKind.SET_LITERAL)
			// Set
			result = CollectionTypeImpl.createNewSet();
		else if (kind == CollectionKind.ORDERED_SET_LITERAL)
			// OrderedSet
			result = CollectionTypeImpl.createNewOrderedSet();
		else if (kind == CollectionKind.SEQUENCE_LITERAL)
			// Sequence
			result = CollectionTypeImpl.createNewSequence();
		else
			// Bag
			result = CollectionTypeImpl.createNewBag();

		if (kind == CollectionKind.SEQUENCE_LITERAL && cl.isSimpleRange()) {
			// literal is of the form: Sequence{first..last}.
			// construct a list with a lazy iterator for it.
			CollectionRange collRange = (CollectionRange) parts.get(0);
			OCLExpression first = collRange.getFirst();
			OCLExpression last = collRange.getLast();

			// evaluate first value
			Integer firstVal = (Integer) first.accept(this);
			if (firstVal == null) {
				result.add(null);
				return result;
			}
			// evaluate last value
			Integer lastVal = (Integer) last.accept(this);
			if (lastVal == null) {
				result.add(null);
				return result;
			}

			int firstInt = firstVal.intValue();
			int lastInt = lastVal.intValue();
			if (firstInt > lastInt)
				return result;

			// construct a lazy integer list for the range
			return new IntegerRangeList(firstInt, lastInt);
		} else {
			// not a sequence or not a simple range
			for (Iterator it = parts.iterator(); it.hasNext();) {
				CollectionLiteralPart part = (CollectionLiteralPart) it.next();
				if (part instanceof CollectionItem) {
					// CollectionItem part
					CollectionItem item = (CollectionItem) part;
					OCLExpression itemExp = item.getItem();
					Object itemVal = itemExp.accept(this);
					if (itemVal != null) {
						// add it to the result set
						result.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange range = (CollectionRange) part;
					OCLExpression first = range.getFirst();
					OCLExpression last = range.getLast();

					// evaluate first value
					Integer firstVal = (Integer) first.accept(this);
					Integer lastVal = (Integer) last.accept(this);
					if (!((firstVal == null) || (lastVal == null))) {
						// add values between first and last inclusive
						int firstInt = firstVal.intValue();
						int lastInt = lastVal.intValue();
						for (int i = firstInt; i <= lastInt; i++)
							result.add(new Integer(i));
					}
					///////////////////////////////////
					//					if (firstVal == null)
					//						result.add(null);
					//					else {
					//						// evaluate last value
					//						Integer lastVal = (Integer) last.accept(this);
					//						if (lastVal == null)
					//							result.add(null);
					//						else {
					//							// add values between first and last inclusive
					//							int firstInt = firstVal.intValue();
					//							int lastInt = lastVal.intValue();
					//							for (int i = firstInt; i <= lastInt; i++)
					//								result.add(new Integer(i));
					//						}
					//					}
					/////////////////////////////////
				} // end of collection range

			} // end of parts iterator

		} // end of not-simple range case

		return result;
	} // end of Set, OrderedSet, Bag Literals

	// private static inner class for lazy lists over an integer range
	private static final class IntegerRangeList
		extends AbstractList {

		public IntegerRangeList() {
			super();
		}

		public IntegerRangeList(int first, int last) {
			super();
			this.first = first;
			this.last = last;
		}

		public int getFirst() {
			return first;
		}

		public int getLast() {
			return last;
		}

		public int size() {
			return last - first + 1;
		}

		public Object get(int index) {
			if (index < 0 || index >= size()) {
				String message = OCLMessages.bind(
						OCLMessages.IndexOutOfRange_ERROR_,
						new Object[] {
								Integer.toString(index),
								Integer.toString(first),
								Integer.toString(last)});
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(), "get", error);//$NON-NLS-1$
				throw error;
			}
			return new Integer(first + index);
		}

		public Iterator iterator() {
			// local iterator class that provides
			// hasNext() and next() methods appropriate
			// for this range set
			class IntegerRangeIterator
				implements Iterator {

				public IntegerRangeIterator() {
					curr = first;
					initialized = false;
				}

				public Object next() {
					if (!initialized) {
						curr = first - 1;
						initialized = true;
					}
					if (hasNext())
						return new Integer(++curr);
					throw new NoSuchElementException();
				}

				public boolean hasNext() {
					return curr < last;
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}

				private int curr;

				private boolean initialized;
			}

			return new IntegerRangeIterator();
		}

		private int first;

		private int last;
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 * 
	 * @param tl
	 *            tuple literal expression
	 * @return String
	 */
	public Object visitTupleLiteralExp(TupleLiteralExp tl) {
		//EClass eclazz = tl.getType().eClass();
		EClass eclazz = (EClass) tl.getType();
		List tp = tl.getPart();
		EFactory factory = eclazz.getEPackage().getEFactoryInstance();
		EObject result = factory.create(eclazz);
		Iterator iter = tp.iterator();
		EStructuralFeature sf = null;

		while (iter.hasNext()) {
			TupleLiteralPart part = (TupleLiteralPart) iter.next();
			// Find the EStructuralFeature in the EClass for
			// the tuple part
			sf = eclazz.getEStructuralFeature(part.getName());

			if (sf == null) {
				String message = OCLMessages.bind(
						OCLMessages.TupleFieldDoesntExist_ERROR_,
						part.getName());
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(getClass(),
					"visitTupleLiteralExp", error);//$NON-NLS-1$
				throw error;
			}

			// Set the tuple field with the value of the init expression
			// from the variable declaration.
			Object value = part.accept(this);
			result.eSet(sf, value);
		}

		return result;

	}
	
	public Object visitTupleLiteralPart(TupleLiteralPart tp) {
		return tp.getValue().accept(this);
	}

	/**
	 * Checks whether the supplied object is an instance of the supplied type
	 * 
	 * @param value
	 *            the value to check
	 * @param typeArg
	 *            the type to check
	 * @return true if the object is an instance of the type, false otherwise.
	 */
	protected Boolean oclIsTypeOf(Object value, Object typeArg) {
		EClassifier type = (EClassifier) typeArg;
		
		// regardless of the source value, if the type is undefined, then so
		//    is oclIsTypeOf
		if (type == null) {
			return null;
		}
		
		// the type of null is OclVoid
		if (value == null) {
			return Boolean.valueOf(type == Types.OCL_VOID);
		}
		
		// the type of OclInvalid is Invalid
		if (value == Types.OCL_INVALID) {
			return Boolean.valueOf(type == Types.INVALID);
		}
		
		boolean isObject = value instanceof EObject;
		// non-EObject source
		if (!isObject) {
			// get the actual (runtime) java type of the source object
			Class valueType = value.getClass();

			// the actual source type must exactly match the argument type
			return Boolean.valueOf(valueType == type.getInstanceClass());
		}

		// EObject source
		else if (isObject && type instanceof EClass) {
			EObject valueEObject = (EObject) value;
			EClass valueEClass = valueEObject.eClass();
			EClass argClass = (EClass) type;
			return Boolean.valueOf(valueEClass.equals(argClass));
		}

		return Boolean.FALSE;
	}

	//	protected Boolean oclAsType(Object value, EClassifier type) {
	//		// regardless of the supplied type,
	//		// if the source is undefined the result is undefined.
	//		if (value == null)
	//			return Boolean.FALSE;
	//		if (type == PredefinedType.OCL_ANY_TYPE) {
	//			return Boolean.TRUE;
	//		}
	//
	//		boolean isEObject = value instanceof EObject;
	//		// non-EObject source
	//		if (!isEObject) {
	//			Class valueClass = value.getClass();
	//			Class typeClass = type.getInstanceClass();
	//
	//			// special case for Integer and Real which are not related types
	//			// in java but are in OCL
	//			if (valueClass == Integer.class && typeClass == Double.class)
	//				return Boolean.TRUE;
	//
	//			// otherwise we can just use the java rules
	//			return (typeClass.isAssignableFrom(valueClass)) ? Boolean.TRUE
	//				: Boolean.FALSE;
	//		}
	//
	//		// User class source
	//		else if (isEObject && type instanceof EClass) {
	//			EObject valueEObject = (EObject) value;
	//			EClass valueEClass = valueEObject.eClass();
	//			EClass argClass = (EClass) type;
	//			return Boolean.valueOf(argClass.isSuperTypeOf(valueEClass));
	//		}
	//
	//		return Boolean.FALSE;
	//	}

	/**
	 * Checks whether the supplied value is an instance of the supplied type or
	 * one of its super types.
	 * 
	 * @param value
	 *            the value to check
	 * @param typeArg
	 *            the type to check
	 * @return true iff the value is of the type or one of its super types.
	 */
	protected Boolean oclIsKindOf(Object value, Object typeArg) {
		EClassifier type = (EClassifier) typeArg;
		
		// regardless of the source value, if the type is undefined, then so
		//    is oclIsTypeOf
		if (type == null) {
			return null;
		}
		
		// OclVoid and Invalid conform to all classifiers
		if (isUndefined(value)) {
			return Boolean.TRUE;
		}

		boolean isEObject = value instanceof EObject;
		// non-EObject source
		if (!isEObject) {
			Class valueClass = value.getClass();
			Class typeClass = type.getInstanceClass();

			// special case for Integer and Real which are not related types
			// in java but are in OCL
			if (valueClass == Integer.class && typeClass == Double.class)
				return Boolean.TRUE;

			// otherwise we can just use the java rules
			return (typeClass.isAssignableFrom(valueClass)) ? Boolean.TRUE
				: Boolean.FALSE;
		}

		// User class source
		else if (isEObject && type instanceof EClass) {
			EObject valueEObject = (EObject) value;
			EClass valueEClass = valueEObject.eClass();
			EClass argClass = (EClass) type;
			return Boolean.valueOf(argClass.isSuperTypeOf(valueEClass));
		}

		return Boolean.FALSE;
	}
} //EvaluationVisitorImpl

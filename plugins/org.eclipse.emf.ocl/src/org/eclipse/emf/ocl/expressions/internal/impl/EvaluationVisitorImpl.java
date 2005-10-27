/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions.internal.impl;

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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.util.AbstractVisitor;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.OclEngineStatusCodes;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.internal.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.PrimitiveTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.osgi.util.NLS;

/**
 * An evaluation visitor implementation for OCL expressions.
 * 
 * @author tklinger
 */
public class EvaluationVisitorImpl
	extends AbstractVisitor
	implements EvaluationVisitor {

	private static final String UnknownOperation_ERROR_ = OclMessages.UnknownOperation_ERROR_;

	private static final String IteratorNotImpl_ERROR_ = OclMessages.IteratorNotImpl_ERROR_;

	private static final String IndexOutOfRange_ERROR_ = OclMessages.IndexOutOfRange_ERROR_;

	private static final String TupleFieldDoesntExist_ERROR_ = OclMessages.TupleFieldDoesntExist_ERROR_;

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
	 * Callback for a AttributeCallExp visit. Evaluates the source expression
	 * and gets the attribute value on the resulting object.
	 * 
	 * @param ac
	 *            the attribute call expression
	 * @return the value of the attribute
	 */
	public Object visitAttributeCallExp(AttributeCallExp ac) {
		EAttribute attr = ac.getReferredAttribute();
		OclExpression source = ac.getSource();
		//		EClassifier sourceType = source.getType();

		// evaluate source
		EObject context = (EObject) source.accept(this);

		// if source is null, result is undefined
		if (context == null)
			return null;

		// evaluate attribute on source value
		Object result = context.eGet(attr);

		return result;
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

		OclExpression source = oc.getSource();
		EClassifier sourceType = source.getType();
		EOperation oper = oc.getReferredOperation();
		int opCode = oc.getOperationCode();
		EList args = oc.getArguments();
		int numArgs = args.size();

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
		if (opCode == AnyTypeImpl.EQUAL) {
			// evaluate source
			Object sourceVal = source.accept(this);

			// evaluate argument
			OclExpression arg = (OclExpression) args.get(0);
			Object argVal = arg.accept(this);

			// if either value is undefined, the result is true just if both are
			// undefined and
			// false otherwise.
			if (sourceVal == null || argVal == null)
				return Boolean.valueOf(sourceVal == argVal);

			// primitive types
			if (isPrimitive(sourceVal) || isPrimitive(argVal)) {
				if (sourceVal instanceof Integer && argVal instanceof Integer)
					return Boolean
						.valueOf(((Integer) sourceVal).intValue() == ((Integer) argVal)
							.intValue());
				else if (sourceVal instanceof Integer
					&& argVal instanceof Double)
					return Boolean
						.valueOf(((Integer) sourceVal).intValue() == ((Double) argVal)
							.doubleValue());
				else if (sourceVal instanceof Double
					&& argVal instanceof Integer)
					return Boolean
						.valueOf(((Double) sourceVal).doubleValue() == ((Integer) argVal)
							.intValue());
				else if (sourceVal instanceof Double
					&& argVal instanceof Double)
					return Boolean
						.valueOf(((Double) sourceVal).doubleValue() == ((Double) argVal)
							.doubleValue());
				else if (sourceVal instanceof String
					&& argVal instanceof String)
					return Boolean.valueOf(((String) sourceVal)
						.equals(argVal));
				else if (sourceVal instanceof Boolean
					&& argVal instanceof Boolean)
					return Boolean.valueOf(sourceVal == argVal);

				// if the types are incompatible the result is false
				return Boolean.FALSE;
			}

			if (argVal instanceof EEnumLiteral) {
				EEnumLiteral argEnumVal = (EEnumLiteral) argVal;
				return Boolean
					.valueOf((argEnumVal.equals(sourceVal) || argEnumVal
						.getInstance().equals(sourceVal)));
			}

			return Boolean.valueOf(sourceVal.equals(argVal));
		}

		else if (opCode == AnyTypeImpl.NOT_EQUAL) {
			// notEquals

			// evaluate source
			Object sourceVal = source.accept(this);

			// evaluate argument
			OclExpression arg = (OclExpression) args.get(0);
			Object argVal = arg.accept(this);

			// if either value is undefined, the result is true just when one or
			// the other value
			// is undefined but not both; false otherwise.
			if (sourceVal == null || argVal == null)
				return Boolean.valueOf(sourceVal != argVal);

			if (isPrimitive(sourceVal) || isPrimitive(argVal)) {
				if (sourceVal instanceof Integer && argVal instanceof Integer)
					return Boolean
						.valueOf(((Integer) sourceVal).intValue() != ((Integer) argVal)
							.intValue());
				else if (sourceVal instanceof Integer
					&& argVal instanceof Double)
					return Boolean
						.valueOf(((Integer) sourceVal).intValue() != ((Double) argVal)
							.doubleValue());
				else if (sourceVal instanceof Double
					&& argVal instanceof Integer)
					return Boolean
						.valueOf(((Double) sourceVal).doubleValue() != ((Integer) argVal)
							.intValue());
				else if (sourceVal instanceof Double
					&& argVal instanceof Double)
					return Boolean
						.valueOf(((Double) sourceVal).doubleValue() != ((Double) argVal)
							.doubleValue());
				else if (sourceVal instanceof String
					&& argVal instanceof String)
					return Boolean.valueOf(!((String) sourceVal)
						.equals(argVal));
				else if (sourceVal instanceof Boolean
					&& argVal instanceof Boolean)
					return Boolean.valueOf(sourceVal != argVal);

				// if the types are incompatible the result is true
				return Boolean.TRUE;
			}

			if (argVal instanceof EEnumLiteral) {
				EEnumLiteral argEnumVal = (EEnumLiteral) argVal;
				return Boolean
					.valueOf(!(argEnumVal.equals(sourceVal) || argEnumVal
						.getInstance().equals(sourceVal)));
			}

			return Boolean.valueOf(!sourceVal.equals(argVal));
		}

		else if (opCode == CollectionTypeImpl.EQUALS) {
			// equals on collection types
			Object sourceVal = source.accept(this);

			// evaluate argument
			OclExpression arg = (OclExpression) args.get(0);
			Object argVal = arg.accept(this);

			// if either value is undefined, the result is undefined
			if (sourceVal == null || argVal == null)
				return null;

			if (sourceVal instanceof Collection && argVal instanceof Collection)
				return Boolean.valueOf(((Collection) sourceVal)
					.equals(argVal));

			// if the types are incompatible the result is false
			return Boolean.FALSE;
		}

		else if (opCode == CollectionTypeImpl.NOT_EQUAL) {
			// notEquals on collection types
			Object sourceVal = source.accept(this);

			// evaluate argument
			OclExpression arg = (OclExpression) args.get(0);
			Object argVal = arg.accept(this);

			// if either value is undefined, the result is undefined
			if (sourceVal == null || argVal == null)
				return null;

			if (sourceVal instanceof Collection && argVal instanceof Collection)
				return Boolean.valueOf(!((Collection) sourceVal)
					.equals(argVal));

			// if the types are incompatible the result is true
			return Boolean.TRUE;
		}

		if (sourceType instanceof PrimitiveType
			|| sourceType instanceof CollectionType
			|| sourceType instanceof EEnum || sourceType instanceof EDataType
			|| sourceType == Types.OCL_VOID) {

			// TODO: Really VoidType should be a subtype of all the primitive
			// types

			if (numArgs == 0) {
				//
				// unary operations:
				//

				// evaluate source
				Object sourceVal = source.accept(this);

				// if source is undefined and the operation is not
				// undefined, then this expression is undefined
				if (sourceVal == null && opCode != AnyTypeImpl.OCL_IS_UNDEFINED)
					return null;

				// evaluate this operation
				switch (opCode) {

					case AnyTypeImpl.ALL_INSTANCES:
						if (sourceVal instanceof EEnum) {
							// the instances are the literals
							return new java.util.HashSet(
								((EEnum) sourceVal).getELiterals());
						} else if (sourceType == Types.OCL_VOID) {
							// OclVoid has a single instance: OclUndefined
							Set result = new java.util.HashSet();
							result.add(null);
							return result;
						} else {
							// other types do not have numerable instances
							return new java.util.HashSet();
						}
						
					case PrimitiveTypeImpl.MINUS:
						// Integer::minus()
						if (sourceVal instanceof Integer)
							return new Integer(-((Integer) sourceVal)
								.intValue());

						// Double::minus()
						return new Double(-((Double) sourceVal).doubleValue());

					case PrimitiveTypeImpl.ABS:
						if (sourceVal instanceof Integer)
							// Integer::abs()
							return new Integer(Math.abs(((Integer) sourceVal)
								.intValue()));

						// Real::abs()
						return new Double(Math.abs(((Double) sourceVal)
							.doubleValue()));

					case PrimitiveTypeImpl.FLOOR:
						if (sourceVal instanceof Double) {
							// Real::floor()
							Double sourceDoubleVal = (Double) sourceVal;
							return new Integer((int) Math.floor(sourceDoubleVal
								.doubleValue()));
						}

						// Integer::floor()
						return sourceVal;

					case PrimitiveTypeImpl.ROUND:
						if (sourceVal instanceof Double) {
							// Real::round()
							Double sourceDoubleVal = (Double) sourceVal;
							return new Integer((int) Math.round(sourceDoubleVal
								.doubleValue()));
						}

						// Integer::round()
						return sourceVal;

					case PrimitiveTypeImpl.NOT:
						return (((Boolean) sourceVal).booleanValue()) ? Boolean.FALSE
							: Boolean.TRUE;

					case AnyTypeImpl.OCL_IS_UNDEFINED:
						// Any::oclIsUndefined()
						return sourceVal == null ? Boolean.TRUE : Boolean.FALSE;

					case PrimitiveTypeImpl.SIZE:
						// String::size()
						return new Integer(((String) sourceVal).length());

					case PrimitiveTypeImpl.TO_INTEGER:
						// String::toInteger()
						return Integer.valueOf((String) sourceVal);

					case PrimitiveTypeImpl.TO_REAL:
						// String::toReal()
						return Double.valueOf((String) sourceVal);

					case PrimitiveTypeImpl.TO_LOWER:
						// String::toLower()
						return ((String) sourceVal).toLowerCase();

					case PrimitiveTypeImpl.TO_UPPER:
						// String::toUpper()
						return ((String) sourceVal).toUpperCase();

					case CollectionTypeImpl.SIZE:
						// Collection::size()
						return new Integer(((Collection) sourceVal).size());

					case CollectionTypeImpl.IS_EMPTY:
						// Collection::isEmpty()
						return Boolean.valueOf(((Collection) sourceVal)
							.isEmpty());

					case CollectionTypeImpl.NOT_EMPTY:
						// Collection::notEmpty()
						return Boolean.valueOf(!((Collection) sourceVal)
							.isEmpty());

					case CollectionTypeImpl.SUM:
						// Collection::sum()
						return CollectionTypeImpl.sum((Collection) sourceVal);

					case CollectionTypeImpl.FLATTEN:
						// Set, Bag, Sequence, OrderedSet::flatten()
						return CollectionTypeImpl
							.flatten((Collection) sourceVal);

					case CollectionTypeImpl.AS_SET:
						// Set, Bag, Sequence, OrderedSet::asSet()
						return CollectionTypeImpl.asSet((Collection) sourceVal);

					case CollectionTypeImpl.AS_BAG:
						// Set, Bag, Sequence, OrderedSet::asBag()
						return CollectionTypeImpl.asBag((Collection) sourceVal);

					case CollectionTypeImpl.AS_ORDERED_SET:
						// Set, Bag, Sequence, OrderedSet::asOrderedSet()
						return CollectionTypeImpl
							.asOrderedSet((Collection) sourceVal);

					case CollectionTypeImpl.AS_SEQUENCE:
						// Set, Bag, Sequence, OrderedSet::asSequence)
						return CollectionTypeImpl
							.asSequence((Collection) sourceVal);

					case CollectionTypeImpl.FIRST:
						// OrderedSet::first()
						return CollectionTypeImpl.first((Collection) sourceVal);

					case CollectionTypeImpl.LAST:
						// OrderedSet::last()
						return CollectionTypeImpl.last((Collection) sourceVal);

				} // end of unary operation switch

			} else if (numArgs == 1) {
				//
				// binary operations:
				//

				// evaluate argument
				OclExpression arg = (OclExpression) args.get(0);

				// get argument type
				EClassifier argType = arg.getType();

				// evaluate source;
				Object sourceVal = source.accept(this);

				// AnyType::oclIsTypeOf(OclType)
				if (opCode == AnyTypeImpl.OCL_IS_TYPE_OF)
					return oclIsTypeOf(sourceVal, argType);

				// AnyType::oclIsKindOf(OclType)
				else if (opCode == AnyTypeImpl.OCL_IS_KIND_OF)
					return oclIsKindOf(sourceVal, argType);

				// AnyType::oclAsType(OclType)
				else if (opCode == AnyTypeImpl.OCL_AS_TYPE) {
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

					if (sourceVal instanceof Double
						&& argType == PrimitiveTypeImpl.OCL_INTEGER)
						return new Integer(((Double) sourceVal).intValue());
					else if (sourceVal instanceof Integer
						&& argType == PrimitiveTypeImpl.OCL_REAL)
						return new Double(((Integer) sourceVal).doubleValue());
					return sourceVal;
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
						case PrimitiveTypeImpl.PLUS:
							return new Integer(((Integer) sourceVal).intValue()
								+ ((Integer) argVal).intValue());

						// Integer::minus(Integer)
						case PrimitiveTypeImpl.MINUS:
							return new Integer(((Integer) sourceVal).intValue()
								- ((Integer) argVal).intValue());

						// Integer::times(Integer)
						case PrimitiveTypeImpl.TIMES:
							return new Integer(((Integer) sourceVal).intValue()
								* ((Integer) argVal).intValue());

						// Integer::divide(Integer)
						case PrimitiveTypeImpl.DIVIDE: {
							// denominator of 0 means undefined
							double num = ((Integer) sourceVal).doubleValue();
							double denom = ((Integer) argVal).doubleValue();
							return (denom == 0.0) ? null : new Double(num
								/ denom);
						}

						// Integer::div(Integer)
						case PrimitiveTypeImpl.DIV: {
							int num = ((Integer) sourceVal).intValue();
							int denom = ((Integer) argVal).intValue();
							// denominator of 0 means undefined
							return (denom == 0) ? null : new Integer(num
								/ denom);
						}

						// Integer::mod(Integer)
						case PrimitiveTypeImpl.MOD:
							return new Integer(((Integer) sourceVal).intValue()
								% ((Integer) argVal).intValue());

						// Integer::max(Integer)
						case PrimitiveTypeImpl.MAX:
							return new Integer(Math.max(((Integer) sourceVal)
								.intValue(), ((Integer) argVal).intValue()));

						// Integer::min(Integer)
						case PrimitiveTypeImpl.MIN:
							return new Integer(Math.min(((Integer) sourceVal)
								.intValue(), ((Integer) argVal).intValue()));

						// Integer::lessThan(Integer)
						case PrimitiveTypeImpl.LESS_THAN:
							return ((Integer) sourceVal).intValue() < ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThan(Integer)
						case PrimitiveTypeImpl.GREATER_THAN:
							return ((Integer) sourceVal).intValue() > ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::lessThanEqual(Integer)
						case PrimitiveTypeImpl.LESS_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() <= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThanEqual(Integer)
						case PrimitiveTypeImpl.GREATER_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() >= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = NLS.bind(
								UnknownOperation_ERROR_, new Object[] {oper
									.getName() });
							RuntimeException error = new RuntimeException(message);
							OclEnginePlugin.throwing(getClass(),
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
						case PrimitiveTypeImpl.PLUS:
							return new Double(((Integer) sourceVal).intValue()
								+ ((Double) argVal).doubleValue());

						// Integer::minus(Real)
						case PrimitiveTypeImpl.MINUS:
							return new Double(((Integer) sourceVal).intValue()
								- ((Double) argVal).doubleValue());

						// Integer::times(Real)
						case PrimitiveTypeImpl.TIMES:
							return new Double(((Integer) sourceVal).intValue()
								* ((Double) argVal).doubleValue());

						// Integer::divide(Real)
						case PrimitiveTypeImpl.DIVIDE:
							return new Double(((Integer) sourceVal).intValue()
								/ ((Double) argVal).doubleValue());

						// Integer::max(Real)
						case PrimitiveTypeImpl.MAX:
							return new Double(Math.max(((Integer) sourceVal)
								.intValue(), ((Double) argVal).doubleValue()));

						// Integer::min(Real)
						case PrimitiveTypeImpl.MIN:
							return new Double(Math.min(((Integer) sourceVal)
								.intValue(), ((Double) argVal).doubleValue()));

						// Integer::lessThan(Real)
						case PrimitiveTypeImpl.LESS_THAN:
							return ((Integer) sourceVal).intValue() < ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThan(Real)
						case PrimitiveTypeImpl.GREATER_THAN:
							return ((Integer) sourceVal).intValue() > ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::lessThanEqual(Real)
						case PrimitiveTypeImpl.LESS_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() <= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Integer::greaterThanEqual(Real)
						case PrimitiveTypeImpl.GREATER_THAN_EQUAL:
							return ((Integer) sourceVal).intValue() >= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = NLS.bind(
								UnknownOperation_ERROR_, new Object[] {oper
									.getName() });
							RuntimeException error = new RuntimeException(message);
							OclEnginePlugin.throwing(getClass(),
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
						case PrimitiveTypeImpl.PLUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								+ ((Integer) argVal).intValue());

						// Real::minus(Integer)
						case PrimitiveTypeImpl.MINUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								- ((Integer) argVal).intValue());

						// Real::times(Integer)
						case PrimitiveTypeImpl.TIMES:
							return new Double(((Double) sourceVal)
								.doubleValue()
								* ((Integer) argVal).intValue());

						// Real::divide(Integer)
						case PrimitiveTypeImpl.DIVIDE:
							return new Double(((Double) sourceVal)
								.doubleValue()
								/ ((Integer) argVal).intValue());

						// Real::max(Integer)
						case PrimitiveTypeImpl.MAX:
							return new Double(Math.max(((Double) sourceVal)
								.doubleValue(), ((Integer) argVal).intValue()));

						// Real::min(Integer)
						case PrimitiveTypeImpl.MIN:
							return new Double(Math.min(((Double) sourceVal)
								.doubleValue(), ((Integer) argVal).intValue()));

						// Real::lessThan(Integer)
						case PrimitiveTypeImpl.LESS_THAN:
							return ((Double) sourceVal).doubleValue() < ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThan(Integer)
						case PrimitiveTypeImpl.GREATER_THAN:
							return ((Double) sourceVal).doubleValue() > ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::lessThanEqual(Integer)
						case PrimitiveTypeImpl.LESS_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() <= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThanEqual(Integer)
						case PrimitiveTypeImpl.GREATER_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() >= ((Integer) argVal)
								.intValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = NLS.bind(
								UnknownOperation_ERROR_, new Object[] {oper
									.getName() });
							RuntimeException error = new RuntimeException(message);
							OclEnginePlugin.throwing(getClass(),
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
						case PrimitiveTypeImpl.PLUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								+ ((Double) argVal).doubleValue());

						// Real::minus(Real)
						case PrimitiveTypeImpl.MINUS:
							return new Double(((Double) sourceVal)
								.doubleValue()
								- ((Double) argVal).doubleValue());

						// Real::times(Real)
						case PrimitiveTypeImpl.TIMES:
							return new Double(((Double) sourceVal)
								.doubleValue()
								* ((Double) argVal).doubleValue());

						// Real::divide(Real)
						case PrimitiveTypeImpl.DIVIDE:
							return new Double(((Double) sourceVal)
								.doubleValue()
								/ ((Double) argVal).doubleValue());

						// Real::max(Real)
						case PrimitiveTypeImpl.MAX:
							return new Double(Math
								.max(((Double) sourceVal).doubleValue(),
									((Double) argVal).doubleValue()));

						// Real::min(Real)
						case PrimitiveTypeImpl.MIN:
							return new Double(Math
								.min(((Double) sourceVal).doubleValue(),
									((Double) argVal).doubleValue()));

						// Real::lessThan(Real)
						case PrimitiveTypeImpl.LESS_THAN:
							return ((Double) sourceVal).doubleValue() < ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThan(Real)
						case PrimitiveTypeImpl.GREATER_THAN:
							return ((Double) sourceVal).doubleValue() > ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::lessThanEqual(Real)
						case PrimitiveTypeImpl.LESS_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() <= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						// Real::greaterThanEqual(Real)
						case PrimitiveTypeImpl.GREATER_THAN_EQUAL:
							return ((Double) sourceVal).doubleValue() >= ((Double) argVal)
								.doubleValue() ? Boolean.TRUE : Boolean.FALSE;

						default: {
							String message = NLS.bind(
								UnknownOperation_ERROR_, new Object[] {oper
									.getName() });
							RuntimeException error = new RuntimeException(message);
							OclEnginePlugin.throwing(getClass(),
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
						case PrimitiveTypeImpl.OR:
							if (sourceVal == Boolean.TRUE)
								return Boolean.TRUE;
							
							// must evaluate the argument now
							argVal = arg.accept(this);
							return argVal;

						// Boolean::xor(Boolean)
						case PrimitiveTypeImpl.XOR:
							// XOR does not have a short-circuit
							argVal = arg.accept(this);
							
							if (sourceVal == null)
								return argVal;
							return (argVal == null) ? sourceVal
								: (((Boolean) sourceVal).booleanValue()
									^ ((Boolean) argVal).booleanValue() ? Boolean.TRUE
									: Boolean.FALSE);

						// Boolean::and(Boolean)
						case PrimitiveTypeImpl.AND:
							if (sourceVal != Boolean.TRUE)
								return Boolean.FALSE;
							
							// must evaluate the argument now
							argVal = arg.accept(this);
							return argVal;

						// Boolean::implies
						case PrimitiveTypeImpl.IMPLIES:
							if (sourceVal == Boolean.FALSE)
								return Boolean.TRUE;
							
							// must evaluate the argument now
							argVal = arg.accept(this);
							return argVal;

						default: {
							String message = NLS.bind(
								UnknownOperation_ERROR_, new Object[] {oper
									.getName() });
							RuntimeException error = new RuntimeException(message);
							OclEnginePlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}

				}

				else if (sourceVal instanceof String
					&& argVal instanceof String) {
					// ops are undefined if either arg is
					if (sourceVal == null || argVal == null)
						return null;

					switch (opCode) {
						// String::concat(String)
						case PrimitiveTypeImpl.CONCAT:
							return ((String) sourceVal).concat((String) argVal);

						default: {
							String message = NLS.bind(
								UnknownOperation_ERROR_, new Object[] {oper
									.getName() });
							RuntimeException error = new RuntimeException(message);
							OclEnginePlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Collection) {
					Collection sourceColl = (Collection) sourceVal;

					if (sourceVal == null)
						return null;

					switch (opCode) {
						case CollectionTypeImpl.INCLUDES:
							// Collection::includes(T)
							return CollectionTypeImpl.includes(sourceColl,
								argVal) ? Boolean.TRUE : Boolean.FALSE;

						case CollectionTypeImpl.EXCLUDES:
							// Collection::excludes(T)
							return CollectionTypeImpl.excludes(sourceColl,
								argVal) ? Boolean.TRUE : Boolean.FALSE;

						case CollectionTypeImpl.COUNT:
							// Collection::count(T)
							return new Integer(CollectionTypeImpl.count(
								sourceColl, argVal));

						case CollectionTypeImpl.INCLUDES_ALL:
							// Collection::includesAll(T)
							return CollectionTypeImpl.includesAll(sourceColl,
								(Collection) argVal) ? Boolean.TRUE
								: Boolean.FALSE;

						case CollectionTypeImpl.EXCLUDES_ALL:
							// Collection::excludesAll(T)
							return CollectionTypeImpl.excludesAll(sourceColl,
								(Collection) argVal) ? Boolean.TRUE
								: Boolean.FALSE;

						case CollectionTypeImpl.UNION: {
							// Set, Bag::union(Set, Bag)
							Collection argColl = (Collection) argVal;
							return CollectionTypeImpl
								.union(sourceColl, argColl);
						}

						case CollectionTypeImpl.INTERSECTION: {
							// Set, Bag::intersection(Set, Bag)
							Collection argColl = (Collection) argVal;
							return CollectionTypeImpl.intersection(sourceColl,
								argColl);
						}

						case CollectionTypeImpl.MINUS:
							// Set::minus(Set)
							return CollectionTypeImpl.minus((Set) sourceColl,
								(Set) argVal);

						case CollectionTypeImpl.INCLUDING:
							// Set, Bag, Sequence::including(T)
							return CollectionTypeImpl.including(sourceColl,
								argVal);

						case CollectionTypeImpl.EXCLUDING:
							// Set, Bag, Sequence::excluding(T)
							return CollectionTypeImpl.excluding(sourceColl,
								argVal);

						case CollectionTypeImpl.SYMMETRIC_DIFFERENCE:
							// Set::symmetricDifference(Set)
							return CollectionTypeImpl.symmetricDifference(
								(Set) sourceColl, (Set) argVal);

						case CollectionTypeImpl.APPEND:
							// OrderedSet, Sequence::append(T)
							return CollectionTypeImpl
								.append(sourceColl, argVal);

						case CollectionTypeImpl.PREPEND:
							// OrderedSet, Sequence::prepend(T)
							return CollectionTypeImpl.prepend(sourceColl,
								argVal);

						case CollectionTypeImpl.AT: {
							// OrderedSet, Sequence::at(Integer)
							int indexVal = ((Integer) argVal).intValue();
							return CollectionTypeImpl.at(sourceColl, indexVal);
						}

						case CollectionTypeImpl.INDEX_OF:
							// OrderedSet, Sequence::indexOf(T)
							return CollectionTypeImpl.indexOf(sourceColl,
								argVal);
					} // end of collection type switch
				}
			} else {
				//
				// ternary operations
				//

				// evaluate source
				Object sourceVal = source.accept(this);

				// check if undefined
				if (sourceVal == null)
					return null;

				// evaluate arg1
				Object arg1 = ((OclExpression) args.get(0)).accept(this);

				// check if undefined
				if (arg1 == null)
					return null;

				// evaluate arg2
				Object arg2 = ((OclExpression) args.get(1)).accept(this);

				// check if undefined
				if (arg2 == null)
					return null;

				if (sourceVal instanceof String) {
					// just one ternary string operation
					// String::substring(Integer, Integer)
					// index orgin 1 for OCL
					int lower = ((Integer) arg1).intValue() - 1;
					int upper = ((Integer) arg2).intValue();
					return ((String) sourceVal).substring(lower, upper);
				} else if (sourceVal instanceof Collection) {
					Collection sourceColl = (Collection) sourceVal;
					if (opCode == CollectionTypeImpl.INSERT_AT) {
						// OrderedSet, Sequence::insertAt(Integer, T)
						int index = ((Integer) arg1).intValue();
						return CollectionTypeImpl.insertAt(sourceColl, index,
							arg2);
					} else if (opCode == CollectionTypeImpl.SUB_ORDERED_SET) {
						// OrderedSet, Sequence::subOrderedSet(Integer, Integer)
						int lower = ((Integer) arg1).intValue();
						int upper = ((Integer) arg2).intValue();
						return CollectionTypeImpl.subOrderedSet(sourceColl,
							lower, upper);
					} else if (opCode == CollectionTypeImpl.SUB_SEQUENCE) {
						// Sequence::subSequence(Integer, Integer)
						int lower = ((Integer) arg1).intValue();
						int upper = ((Integer) arg2).intValue();
						return CollectionTypeImpl.subSequence(sourceColl,
							lower, upper);
					}
				}
			}
		} else {
			// Handle allInstances
			if (opCode == AnyTypeImpl.ALL_INSTANCES) {
				EClass eclazz = (EClass) sourceType;
				return extentMap.get(eclazz);
			}

			// evaluate source expression
			Object context = source.accept(this);

			if (opCode == AnyTypeImpl.OCL_IS_UNDEFINED) {
				return (context == null) ? Boolean.TRUE : Boolean.FALSE;
			}

			// result is undefined if source is
			if (context == null) {
				return null;
			}

			// Handle type check and conversion:

			// AnyType::oclIsTypeOf(OclType)
			if (opCode == AnyTypeImpl.OCL_IS_TYPE_OF) {
				OclExpression arg = (OclExpression) args.get(0);
				EClassifier argType = arg.getType();
				return oclIsTypeOf(context, argType);
			}

			// AnyType::oclIsKindOf(OclType)
			else if (opCode == AnyTypeImpl.OCL_IS_KIND_OF) {
				OclExpression arg = (OclExpression) args.get(0);
				EClassifier argType = arg.getType();
				return oclIsKindOf(context, argType);
			}

			// AnyType::oclAsType(OclType)
			else if (opCode == AnyTypeImpl.OCL_AS_TYPE) {
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
				OclExpression arg = (OclExpression) args.get(0);
				EClassifier argType = arg.getType();
				if (oclIsKindOf(context, argType) == Boolean.TRUE) {
					return context;
				} else {
					return null;
				}
				//				Class argClass = argType.getClass();
				//				// every type is implicitly a subtype of AnyType
				//				if (argType == AnyTypeImpl.OCL_ANY_TYPE
				//					|| argClass.isAssignableFrom(contextClass))
				//					return context;
				//				return null;
			}

			// Handle < (lessThan)
			else if (opCode == AnyTypeImpl.ANYTYPE_LESS_THAN) {
				Comparable compContext = (Comparable) context;
				OclExpression arg = (OclExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) == -1);
			}

			//	Handle <= (lessThanEqual)
			else if (opCode == AnyTypeImpl.ANYTYPE_LESS_THAN_EQUAL) {
				Comparable compContext = (Comparable) context;
				OclExpression arg = (OclExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) <= 0);
			}

			// Handle > (greaterThan)
			else if (opCode == AnyTypeImpl.ANYTYPE_GREATER_THAN) {
				Comparable compContext = (Comparable) context;
				OclExpression arg = (OclExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) == 1);
			}

			// Handle > (greaterThanEqual)
			else if (opCode == AnyTypeImpl.ANYTYPE_GREATER_THAN_EQUAL) {
				Comparable compContext = (Comparable) context;
				OclExpression arg = (OclExpression) args.get(0);
				Comparable evalArg = (Comparable) arg.accept(this);
				return Boolean.valueOf(compContext.compareTo(evalArg) >= 0);
			}

			//
			// regular operation invocation
			//

			// evaluate args
			List evalArgs = new LinkedList();
			for (Iterator it = args.iterator(); it.hasNext();) {
				OclExpression arg = (OclExpression) it.next();
				Object evalArg = arg.accept(this);

				// result is undefined if any arg is
				if (evalArg == null)
					return null;

				evalArgs.add(evalArg);
			}

			// get types of the arguments
			Class[] argTypes = new Class[args.size()];
			for (int i = 0, n = args.size(); i < n; i++) {
				OclExpression e = (OclExpression) args.get(i);
				argTypes[i] = e.getType().getInstanceClass();
			}

			// get java method for operation
			Method method = getJavaMethodFor(oper);

			// invoke method on evaluated args
			try {
				Object result = method.invoke(context, evalArgs.toArray());
				return result;
			} catch (Exception e) {
				OclEnginePlugin
					.catching(getClass(), "visitOperationCallExp", e);//$NON-NLS-1$
				OclEnginePlugin.log(
					IStatus.ERROR,
					OclEngineStatusCodes.IGNORED_EXCEPTION_WARNING,
					NLS.bind(
						OclMessages.ErrorMessage_ERROR_,
						new Object[] {
							"visitOperationCallExp", //$NON-NLS-1$
							e.getLocalizedMessage()}),
					e);
				return null;
			}
		}

		return null;
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
				javaParms[i] = EList.class;
			} else {
				javaParms[i] = parm.getEType().getInstanceClass();
			}
		}

		// lookup the method on the java class
		try {
			result = containerClass.getMethod(oper.getName(), javaParms);
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
		VariableDeclaration vd = ie.getResult();
		String resultName = (String) vd.accept(this);

		// get the list of ocl iterators
		EList iterators = ie.getIterators();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

		// construct an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplate.getInstance(this);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result variable from environment
		env.remove(resultName);

		return result;
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	public Object visitIteratorExp(IteratorExp ie) {
		if (ie.getName().equals("exists"))//$NON-NLS-1$
			return evaluateExistsIterator(ie);
		else if (ie.getName().equals("forAll"))//$NON-NLS-1$
			return evaluateForAllIterator(ie);
		else if (ie.getName().equals("select"))//$NON-NLS-1$
			return evaluateSelectIterator(ie);
		else if (ie.getName().equals("reject"))//$NON-NLS-1$
			return evaluateRejectIterator(ie);
		else if (ie.getName().equals("collect"))//$NON-NLS-1$
			return evaluateCollectIterator(ie);
		else if (ie.getName().equals("collectNested"))//$NON-NLS-1$
			return evaluateCollectNestedIterator(ie);
		else if (ie.getName().equals("one"))//$NON-NLS-1$
			return evaluateOneIterator(ie);
		else if (ie.getName().equals("any"))//$NON-NLS-1$
			return evaluateAnyIterator(ie);
		else if (ie.getName().equals("sortedBy"))//$NON-NLS-1$
			return evaluateSortedByIterator(ie);
		else if (ie.getName().equals("isUnique"))//$NON-NLS-1$
			return evaluateIsUnique(ie);
		String message = NLS.bind(IteratorNotImpl_ERROR_,
			new Object[] {ie.getName() });
		UnsupportedOperationException ex = new UnsupportedOperationException(
			message);
		OclEnginePlugin.throwing(getClass(), "visitIteratorExp", ex);//$NON-NLS-1$
		throw ex;
	}

	public Object evaluateExistsIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//        int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

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

	public Object evaluateForAllIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

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

	public Object evaluateCollectNestedIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateCollectNested.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, CollectionTypeImpl.createNewBag());

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return result;
	}

	public Object evaluateCollectIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

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

	public Object evaluateSelectIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

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

	public Object evaluateRejectIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

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

	public Object evaluateOneIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateOne.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, Boolean.FALSE);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		return result;
	}

	public Object evaluateAnyIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

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

	public Object evaluateSortedByIterator(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		OclExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateSortedBy.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, new HashMap());

		// evaluate
		// TODO: find an efficient way to do this.
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

	public Object evaluateIsUnique(IteratorExp ie) {
		// get the list of ocl iterators
		//		EList iterators = ie.getIterators();
		//		int numIters = iterators.size();

		// evaluate the source collection
		//		Collection coll = (Collection) ie.getSource().accept(this);

		// get the body expression
		//		OclExpression body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate is = IterationTemplateIsUnique.getInstance(this);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		env.add(resultName, new HashSet());

		// evaluate
		//		Set result = (Set) is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		env.remove(resultName);

		return is.isDone() ? Boolean.FALSE : Boolean.TRUE;
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
		VariableDeclaration vd = v.getReferredVariable();
		String varName = vd.getVarName();

		// evaluate the variable in the current environment
		EvaluationEnvironment ee = getEvalEnvironment();
		Object result = ee.getValueOf(varName);
		return result;
	}

	/**
	 * Callback for an AssociationEndCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the reference on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the reference "foo" would be derived
	 * on that object.
	 */
	public Object visitAssociationEndCallExp(AssociationEndCallExp ae) {
		EReference ref = ae.getReferredAssociationEnd();
		EObject context = (EObject) ae.getSource().accept(this);

		return context.eGet(ref);
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
		nameBuf.setCharAt(0, Character.toLowerCase(nameBuf.charAt(0)));
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
	public Object visitVariableDeclaration(VariableDeclaration vd) {
		// add the variable to the environment, initialized to
		// its initial expression (if it has one). return the name
		// of the variable.
		String varName = vd.getVarName();
		OclExpression initExp = vd.getInitExpression();
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
		OclExpression condition = ie.getCondition();

		// evaluate condition
		Boolean condVal = (Boolean) condition.accept(this);
		if (condVal == null)
			return null;

		if (condVal.booleanValue())
			return ie.getThenExpression().accept(this);
		return ie.getElseExpression().accept(this);
	}

	/**
	 * Callback for an UnspecifiedValueExp visit.
	 */
	public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		return uv.getType();
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

	/**
	 * Callback for LetExp visit.
	 */
	public Object visitLetExp(LetExp l) {
		// get variable decl for let variable
		VariableDeclaration vd = l.getVariable();
		String name = (String) vd.accept(this);

		// evaluate the "in" part of the let
		OclExpression inExp = l.getIn();
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
		List parts = cl.getParts();
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
			OclExpression first = collRange.getFirst();
			OclExpression last = collRange.getLast();

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
					OclExpression itemExp = item.getItem();
					Object itemVal = itemExp.accept(this);
					if (itemVal != null) {
						// add it to the result set
						result.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange range = (CollectionRange) part;
					OclExpression first = range.getFirst();
					OclExpression last = range.getLast();

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
				String message = NLS.bind(IndexOutOfRange_ERROR_,
					new Object[] {Integer.toString(index),
						Integer.toString(first), Integer.toString(last) });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(), "get", error);//$NON-NLS-1$
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
		List tp = tl.getTuplePart();
		EFactory factory = eclazz.getEPackage().getEFactoryInstance();
		EObject result = factory.create(eclazz);
		Iterator iter = tp.iterator();
		EStructuralFeature sf = null;

		while (iter.hasNext()) {
			sf = null;
			VariableDeclaration vd = (VariableDeclaration) iter.next();
			// Find the EAttribute or EReference in the EClass for
			// the variable
			List attribs = eclazz.getEAttributes();
			Iterator fiter = attribs.iterator();
			while (fiter.hasNext()) {
				EAttribute attr = (EAttribute) fiter.next();
				if (attr.getName().equals(vd.getVarName())) {
					sf = attr;
					break;
				}
			}
			if (sf == null) {
				List refs = eclazz.getEReferences();
				fiter = refs.iterator();
				while (fiter.hasNext()) {
					EReference ref = (EReference) fiter.next();
					if (ref.getName().equals(vd.getVarName())) {
						sf = ref;
						break;
					}
				}
			}

			if (sf == null) {
				String message = NLS.bind(
					TupleFieldDoesntExist_ERROR_,
					new Object[] {vd.getVarName() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OclEnginePlugin.throwing(getClass(),
					"visitTupleLiteralExp", error);//$NON-NLS-1$
				throw error;
			}

			// Set the tuple field with the value of the init expression
			// from the variable declaration.
			Object value = vd.getInitExpression().accept(this);
			result.eSet(sf, value);
		}

		return result;

	}

	/**
	 * Checks whether the supplied object is an instance of the supplied type
	 * 
	 * @param value
	 *            the value to check
	 * @param type
	 *            the type to check
	 * @return true if the object is an instance of the type, false otherwise.
	 */
	protected Boolean oclIsTypeOf(Object value, EClassifier type) {
		// regardless of the supplied type,
		// if the value is undefined the result is undefined.
		if (value == null)
			return null;

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
	//		if (type == AnyTypeImpl.OCL_ANY_TYPE) {
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
	 * @param type
	 *            the type to check
	 * @return true iff the value is of the type or one of its super types.
	 */
	protected Boolean oclIsKindOf(Object value, EClassifier type) {
		// regardless of the supplied type,
		// if the source is undefined the result is undefined.
		if (value == null)
			return null;

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

	protected boolean isPrimitive(Object o) {
		return o instanceof Integer || o instanceof String
			|| o instanceof Boolean || o instanceof Double;
	}
} //EvaluationVisitorImpl

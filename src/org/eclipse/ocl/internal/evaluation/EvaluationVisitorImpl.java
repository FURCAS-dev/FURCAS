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
 * $Id: EvaluationVisitorImpl.java,v 1.8 2007/12/12 22:08:04 cdamus Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.AbstractEvaluationVisitor;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
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
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.OCLStatusCodes;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.options.EvaluationOptions;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.UnicodeSupport;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * An evaluation visitor implementation for OCL expressions.
 * <p>
 * <b>Note</b> that this class is not intended to be used or extended by
 * clients.  Use the {@link EvaluationVisitorImpl} interface, instead.
 * </p>
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public class EvaluationVisitorImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	extends AbstractEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

	private static int tempCounter = 0;

	private EvaluationEnvironment.Enumerations<EL> enumerations;
	
	/**
	 * Constructor
	 * 
	 * @param env
	 *            an evaluation environment (map of variable names to values)
	 * @param extentMap
	 *            a map of classes to their instance lists
	 */
	@SuppressWarnings("unchecked")
	public EvaluationVisitorImpl(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			EvaluationEnvironment<C, O, P, CLS, E> evalEnv,
			Map<? extends CLS, ? extends Set<? extends E>> extentMap) {
		super(env, evalEnv, extentMap);
		
		enumerations = OCLUtil.getAdapter(evalEnv, EvaluationEnvironment.Enumerations.class);
	}

	/**
	 * 
	 * Callback for an OperationCallExp visit.
	 *  
	 */
	@Override
    public Object visitOperationCallExp(OperationCallExp<C, O> oc) {
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

		OCLExpression<C> source = oc.getSource();
		C sourceType = source.getType();
		O oper = oc.getReferredOperation();
		int opCode = oc.getOperationCode();
		List<OCLExpression<C>> args = oc.getArgument();
		int numArgs = args.size();

		// evaluate source
		Object sourceVal = source.accept(getVisitor());
		
		OCLExpression<C> body = getOperationBody(oper);
		if ((body != null) || opCode <= 0 /* not a pre-defined operation */
				|| getEvaluationEnvironment().overrides(oper, opCode)) {
			// delegate evaluation to the evaluation environment
			
			// evaluate args
			Object[] evalArgs = new Object[numArgs];
			int i = 0;
			for (Iterator<OCLExpression<C>> it = args.iterator(); it.hasNext(); i++) {
				OCLExpression<C> arg = it.next();
				evalArgs[i] = arg.accept(getVisitor());
			}
	
			// ask the environment to evaluate
			try {
				Object result;
				
				if (body != null) {
					// if source is undefined, result is OclInvalid
					if (isUndefined(sourceVal)) {
						return getOclInvalid();
					}
					
					result = call(oper, body, sourceVal, evalArgs);
				} else {
				    // handle <, <=, >, and >= operators
				    if (opCode <= 0) {
				        opCode = inferOperationCode(oper, opCode);
				    }
					result = getEvaluationEnvironment().callOperation(
							oper, opCode, sourceVal, evalArgs);
				}
				
				return result;
			} catch (UnsupportedOperationException ignore) {
				// let the EvaluationVisitor do its thing
			} catch (Exception e) {
				OCLPlugin
					.catching(getClass(), "visitOperationCallExp", e);//$NON-NLS-1$
				OCLPlugin.log(
					Diagnostic.ERROR,
					OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
					OCLMessages.bind(
						OCLMessages.ErrorMessage_ERROR_,
						"visitOperationCallExp", //$NON-NLS-1$
						e.getLocalizedMessage()),
					e);
				return getOclInvalid();
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
			// evaluate argument
			OCLExpression<C> arg = args.get(0);
			Object argVal = arg.accept(getVisitor());
	        
	        if (sourceVal instanceof Number) {
	            // coerce to Long or Double, if possible, for comparison
	            sourceVal = higherPrecisionNumber((Number) sourceVal);
	        }
	        
	        if (argVal instanceof Number) {
	            // coerce to Long or Double, if possible, for comparison
	            argVal = higherPrecisionNumber((Number) argVal);
	        }

			return Boolean.valueOf(ObjectUtil.equal(sourceVal, argVal));
		}

		else if (opCode == PredefinedType.NOT_EQUAL) {
			// notEquals

			// evaluate argument
			OCLExpression<C> arg = args.get(0);
			Object argVal = arg.accept(getVisitor());
		       
	        if (sourceVal instanceof Number) {
	            // coerce to Long or Double, if possible, for comparison
	            sourceVal = higherPrecisionNumber((Number) sourceVal);
	        }
           
            if (argVal instanceof Number) {
                // coerce to Long or Double, if possible, for comparison
                argVal = higherPrecisionNumber((Number) argVal);
            }

			return Boolean.valueOf(!ObjectUtil.equal(sourceVal, argVal));
		}

		if (sourceType instanceof PrimitiveType
			|| sourceType instanceof CollectionType
			|| getUMLReflection().isEnumeration(sourceType)
			|| getUMLReflection().isDataType(sourceType)
			|| (sourceType instanceof VoidType) || (sourceType instanceof InvalidType)) {

			if (numArgs == 0) {
				//
				// unary operations:
				//

				// if source is undefined and the operation is not
				// undefined, then this expression is invalid
				if (isUndefined(sourceVal)
						&& opCode != PredefinedType.OCL_IS_UNDEFINED
						&& opCode != PredefinedType.OCL_IS_INVALID) {
                    return getOclInvalid();
                }
				
				// evaluate this operation
				switch (opCode) {
						
					case PredefinedType.MINUS:
						// Integer::minus()
						if (sourceVal instanceof Integer) {
                            return - (Integer) sourceVal;
                        } else if (sourceVal instanceof Long) {
                            return - (Long) sourceVal;
                        }

						// Double::minus()
						return - (Double) sourceVal;

					case PredefinedType.ABS:
						if (sourceVal instanceof Integer) {
						    int sourceInt = (Integer) sourceVal;
                            
                            if (sourceType == getUnlimitedNatural()) {
                                // the unlimited value has no absolute
                                if (sourceInt == UnlimitedNaturalLiteralExp.UNLIMITED) {
                                    return getOclInvalid();
                                }
                            }
                            
							// Integer::abs()
							return Math.abs(sourceInt);
                        } else if (sourceVal instanceof Long) {
                            long sourceInt = (Long) sourceVal;
                            
                            if (sourceType == getUnlimitedNatural()) {
                                // the unlimited value has no absolute
                                if (sourceInt == UnlimitedNaturalLiteralExp.UNLIMITED) {
                                    return getOclInvalid();
                                }
                            }
                            
                            // Integer::abs()
                            return Math.abs(sourceInt);
                        }
                        
						// Real::abs()
						return Math.abs((Double) sourceVal);

					case PredefinedType.FLOOR:
						if (sourceVal instanceof Double) {
							// Real::floor()
							return (int) Math.floor((Double) sourceVal);
						}

                        if (sourceType == getUnlimitedNatural()) {
                            long sourceInt = (Long) higherPrecisionNumber((Number) sourceVal);
                            
                            // the unlimited value has no floor
                            if (sourceInt == UnlimitedNaturalLiteralExp.UNLIMITED) {
                                return getOclInvalid();
                            }
                        }
                        
						// Integer::floor()
						return sourceVal;

					case PredefinedType.ROUND:
						if (sourceVal instanceof Double) {
							// Real::round()
							return (int) Math.round((Double) sourceVal);
						}

                        if (sourceType == getUnlimitedNatural()) {
                            long sourceInt = (Long) higherPrecisionNumber((Number) sourceVal);
                            
                            // the unlimited value can't be rounded
                            if (sourceInt == UnlimitedNaturalLiteralExp.UNLIMITED) {
                                return getOclInvalid();
                            }
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
						return (sourceVal == getOclInvalid())?
								Boolean.TRUE : Boolean.FALSE;

					case PredefinedType.SIZE:
						if (sourceType == getString()) {
							// String::size()
							return new Integer(((String) sourceVal).length());
						} else if (sourceType instanceof CollectionType) {
							return new Integer(((Collection<?>) sourceVal).size());
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
						return Boolean.valueOf(((Collection<?>) sourceVal)
							.isEmpty());

					case PredefinedType.NOT_EMPTY:
						// Collection::notEmpty()
						return Boolean.valueOf(!((Collection<?>) sourceVal)
							.isEmpty());

					case PredefinedType.SUM:
						// Collection::sum()
						Number num = (Number) CollectionUtil.sum((Collection<?>) sourceVal);
						
						if (num == null) {
							// empty collection
							@SuppressWarnings("unchecked")
							CollectionType<C, O> numCollType = (CollectionType<C, O>) sourceType;
							C numType = numCollType.getElementType();
							
							if (numType == getReal()) {
								num = new Double(0.0);
							} else if (numType == getInteger()) {
								num = new Integer(0);
							}
						}
						
						return num;

					case PredefinedType.FLATTEN:
						// Set, Bag, Sequence, OrderedSet::flatten()
						return CollectionUtil.flatten((Collection<?>) sourceVal);

					case PredefinedType.AS_SET:
						// Set, Bag, Sequence, OrderedSet::asSet()
						return CollectionUtil.asSet((Collection<?>) sourceVal);

					case PredefinedType.AS_BAG:
						// Set, Bag, Sequence, OrderedSet::asBag()
						return CollectionUtil.asBag((Collection<?>) sourceVal);

					case PredefinedType.AS_ORDERED_SET:
						// Set, Bag, Sequence, OrderedSet::asOrderedSet()
						return CollectionUtil.asOrderedSet((Collection<?>) sourceVal);

					case PredefinedType.AS_SEQUENCE:
						// Set, Bag, Sequence, OrderedSet::asSequence)
						return CollectionUtil.asSequence((Collection<?>) sourceVal);

					case PredefinedType.FIRST:
						// OrderedSet::first()
						return CollectionUtil.first((Collection<?>) sourceVal);

					case PredefinedType.LAST:
						// OrderedSet::last()
						return CollectionUtil.last((Collection<?>) sourceVal);

				} // end of unary operation switch

			} else if (numArgs == 1) {
				//
				// binary operations:
				//

				// evaluate argument
				OCLExpression<C> arg = args.get(0);

				// get argument type
				C argType = arg.getType();
				
	            if (isUndefined(sourceVal)) {
	                switch (opCode) {
	                case PredefinedType.OCL_IS_TYPE_OF:
	                case PredefinedType.OCL_IS_KIND_OF:
	                case PredefinedType.OCL_AS_TYPE:
	                    if (isLaxNullHandling()) {
	                        break;
	                    } else {
	                        return getOclInvalid();
	                    }
	                default:
	                    return getOclInvalid();
	                }
	            }

				// AnyType::oclIsTypeOf(OclType)
				if (opCode == PredefinedType.OCL_IS_TYPE_OF) {
                    return oclIsTypeOf(sourceVal, arg.accept(getVisitor()));
                } else if (opCode == PredefinedType.OCL_IS_KIND_OF) {
                    return oclIsKindOf(sourceVal, arg.accept(getVisitor()));
                } else if (opCode == PredefinedType.OCL_AS_TYPE) {
					// Type conversions for the built-in, non-collection
					// types are completely checked in the parser. The only
					// actual work that
					// needs to be done here is to convert from Any/Real to
					// Integer
					// and back (necessary since in OCL Integers extend
					// Reals but this is not true of the java primtives).

					// if the source is undefined or the conversion to
					// OclVoid so is the result
					if (sourceVal == null || (argType instanceof VoidType)) {
                        return null;
                    }
					if (sourceVal == getOclInvalid() || (argType instanceof InvalidType)) {
                        return getOclInvalid();
                    }

					if (sourceVal instanceof Double
						&& (argType == getInteger())) {
                        return new Integer(((Double) sourceVal).intValue());
                    } else if (sourceVal instanceof Integer
						&& (argType == getReal())) {
                        
                        if (sourceType == getUnlimitedNatural()) {
                            int sourceInt = (Integer) sourceVal;
                            
                            // the unlimited value is positive infinity
                            if (sourceInt == UnlimitedNaturalLiteralExp.UNLIMITED) {
                                return Double.POSITIVE_INFINITY;
                            }
                        }
                        
						return new Double(((Integer) sourceVal).doubleValue());
                    }
                    
					return sourceVal;
				}
				
				// evaluate arg, unless we have a boolean operation
				Object argVal = null;
				if (!(sourceVal instanceof Boolean)) {
					argVal = arg.accept(getVisitor());
				}

				if (sourceVal instanceof Number) {
                    // we have a numeric operation.  Promote to high precision
                    sourceVal = higherPrecisionNumber((Number) sourceVal);
                    
                    if (argVal instanceof Number) {
                        argVal = higherPrecisionNumber((Number) argVal);
                    }
				}
				
				if (sourceVal instanceof Long && argVal instanceof Long) {
					//
					// source and single arg are both integers
					//

                    long sourceInt = (Long) sourceVal;
                    long argInt = (Long) argVal;
                    
                    boolean sourceUnlimited =
                        sourceType == getUnlimitedNatural()
                            && sourceInt == UnlimitedNaturalLiteralExp.UNLIMITED;
                    boolean argUnlimited =
                        argType == getUnlimitedNatural()
                            && argInt == UnlimitedNaturalLiteralExp.UNLIMITED;
                    
                    if (sourceUnlimited && argUnlimited) {
                        switch (opCode) {
                            case PredefinedType.LESS_THAN:
                            case PredefinedType.LESS_THAN_EQUAL:
                            case PredefinedType.GREATER_THAN:
                            case PredefinedType.GREATER_THAN_EQUAL:
                                // two inifinte values cannot be compared.  We
                                //   allow = and <> only to test for unbounded
                                //   multiplicities
                                return Boolean.FALSE;
                            default:
                                // cannot do arithmetic on the unlimited value
                                return getOclInvalid();
                            }
                    } else if (sourceUnlimited || argUnlimited) {
                        switch (opCode) {
                        case PredefinedType.LESS_THAN:
                        case PredefinedType.LESS_THAN_EQUAL:
                            return argUnlimited;
                        case PredefinedType.GREATER_THAN:
                        case PredefinedType.GREATER_THAN_EQUAL:
                            return sourceUnlimited;
                        default:
                            // cannot do arithmetic on the unlimited value
                            return getOclInvalid();
                        }
                    }
                    
					switch (opCode) {

						// Integer::plus(Integer)
						case PredefinedType.PLUS:
							return coerceNumber(sourceInt + argInt);

						// Integer::minus(Integer)
						case PredefinedType.MINUS:
							return coerceNumber(sourceInt - argInt);

						// Integer::times(Integer)
						case PredefinedType.TIMES:
							return coerceNumber(sourceInt * argInt);

						// Integer::divide(Integer)
						case PredefinedType.DIVIDE: {
							// denominator of 0 means undefined
							double num = sourceInt;
							double denom = argInt;
							return (denom == 0.0) ? getOclInvalid() : num / denom;
						}

						// Integer::div(Integer)
						case PredefinedType.DIV:
							// denominator of 0 means undefined
							return (argInt == 0) ? getOclInvalid() :
							    coerceNumber(sourceInt / argInt);

						// Integer::mod(Integer)
						case PredefinedType.MOD:
							return coerceNumber(sourceInt % argInt);

						// Integer::max(Integer)
						case PredefinedType.MAX:
							return coerceNumber(Math.max(sourceInt, argInt));

						// Integer::min(Integer)
						case PredefinedType.MIN:
							return coerceNumber(Math.min(sourceInt, argInt));

						// Integer::lessThan(Integer)
						case PredefinedType.LESS_THAN:
							return sourceInt < argInt;

						// Integer::greaterThan(Integer)
						case PredefinedType.GREATER_THAN:
							return sourceInt > argInt;

						// Integer::lessThanEqual(Integer)
						case PredefinedType.LESS_THAN_EQUAL:
							return sourceInt <= argInt;

						// Integer::greaterThanEqual(Integer)
						case PredefinedType.GREATER_THAN_EQUAL:
							return sourceInt >= argInt;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
									getName(oper));
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Long
					&& argVal instanceof Double) {
				    
					//
					// source is an integer and single arg is a real
					//

                    long sourceInt = (Long) sourceVal;
                    double argReal = (Double) argVal;
                    
                    if (sourceType == getUnlimitedNatural()) {
                        if (sourceInt == UnlimitedNaturalLiteralExp.UNLIMITED) {
                            switch (opCode) {
                            case PredefinedType.LESS_THAN:
                                // unlimited is not less than or equal to
                                //   any Real value
                                return Boolean.FALSE;
                            case PredefinedType.GREATER_THAN:
                            case PredefinedType.GREATER_THAN_EQUAL:
                                // unlimited is greater than 
                                //   every Real value
                                return Boolean.TRUE;
                            default:
                                // cannot do arithmetic on the unlimited value
                                return getOclInvalid();
                            }
                        }
                    }
                    
					switch (opCode) {

						// Integer::plus(Real)
						case PredefinedType.PLUS:
							return coerceNumber(sourceInt + argReal);

						// Integer::minus(Real)
						case PredefinedType.MINUS:
							return coerceNumber(sourceInt - argReal);

						// Integer::times(Real)
						case PredefinedType.TIMES:
							return coerceNumber(sourceInt * argReal);

						// Integer::divide(Real)
                        case PredefinedType.DIVIDE:
                            // denominator of 0 results in undefined
                            return (argReal == 0.0) ? getOclInvalid() : sourceInt / argReal;

						// Integer::max(Real)
						case PredefinedType.MAX:
							return coerceNumber(Math.max(sourceInt, argReal));

						// Integer::min(Real)
						case PredefinedType.MIN:
							return coerceNumber(Math.min(sourceInt, argReal));

						// Integer::lessThan(Real)
						case PredefinedType.LESS_THAN:
							return sourceInt < argReal;

						// Integer::greaterThan(Real)
						case PredefinedType.GREATER_THAN:
							return sourceInt > argReal;

						// Integer::lessThanEqual(Real)
						case PredefinedType.LESS_THAN_EQUAL:
							return sourceInt <= argReal;

						// Integer::greaterThanEqual(Real)
						case PredefinedType.GREATER_THAN_EQUAL:
							return sourceInt >= argReal;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
									getName(oper));
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				}

				else if (sourceVal instanceof Double
					&& argVal instanceof Long) {
				    
				    double sourceReal = (Double) sourceVal;
				    long argInt = (Long) argVal;
				    
					//
					// source is a real and single arg is an integer
					//	

                    if (argType == getUnlimitedNatural()) {
                        if (argInt == UnlimitedNaturalLiteralExp.UNLIMITED) {
                            switch (opCode) {
                            case PredefinedType.LESS_THAN:
                                // unlimited is greater than 
                                //   every Real value
                                return Boolean.TRUE;
                            case PredefinedType.GREATER_THAN:
                            case PredefinedType.GREATER_THAN_EQUAL:
                                // unlimited is not less than or equal to
                                //   any Real value
                                return Boolean.FALSE;
                            default:
                                // cannot do arithmetic on the unlimited value
                                return getOclInvalid();
                            }
                        }
                    }

                    // for these arithmetic operations, don't need to coerce
                    // the result to any other precision because OCL Reals are
                    // represented as Doubles, anyway
					switch (opCode) {

						// Real::plus(Integer)
						case PredefinedType.PLUS:
							return sourceReal + argInt;

						// Real::minus(Integer)
						case PredefinedType.MINUS:
							return sourceReal - argInt;

						// Real::times(Integer)
						case PredefinedType.TIMES:
							return sourceReal * argInt;

						// Real::divide(Integer)
                        case PredefinedType.DIVIDE:
                            // denominator of 0 results in undefined
                            return (argInt == 0) ? getOclInvalid() : sourceReal / argInt;

						// Real::max(Integer)
						case PredefinedType.MAX:
							return Math.max(sourceReal, argInt);

						// Real::min(Integer)
						case PredefinedType.MIN:
							return Math.min(sourceReal, argInt);

						// Real::lessThan(Integer)
						case PredefinedType.LESS_THAN:
							return sourceReal < argInt;

						// Real::greaterThan(Integer)
						case PredefinedType.GREATER_THAN:
							return sourceReal > argInt;

						// Real::lessThanEqual(Integer)
						case PredefinedType.LESS_THAN_EQUAL:
							return sourceReal <= argInt;

						// Real::greaterThanEqual(Integer)
						case PredefinedType.GREATER_THAN_EQUAL:
							return sourceReal >= argInt;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
								getName(oper));
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Double
					&& argVal instanceof Double) {
				    
                    double sourceReal = (Double) sourceVal;
                    double argReal = (Double) argVal;
				    
					//
					// source is a real and single arg is a real
					//	

					switch (opCode) {

						// Real::plus(Real)
						case PredefinedType.PLUS:
							return sourceReal + argReal;

						// Real::minus(Real)
						case PredefinedType.MINUS:
							return sourceReal - argReal;

						// Real::times(Real)
						case PredefinedType.TIMES:
							return sourceReal * argReal;

						// Real::divide(Real)
						case PredefinedType.DIVIDE:
                            // denominator of 0 results in undefined
                            return (argReal == 0.0) ? getOclInvalid() : sourceReal / argReal;

						// Real::max(Real)
						case PredefinedType.MAX:
							return Math.max(sourceReal, argReal);

						// Real::min(Real)
						case PredefinedType.MIN:
							return Math.min(sourceReal, argReal);

						// Real::lessThan(Real)
						case PredefinedType.LESS_THAN:
							return sourceReal < argReal;

						// Real::greaterThan(Real)
						case PredefinedType.GREATER_THAN:
							return sourceReal > argReal;

						// Real::lessThanEqual(Real)
						case PredefinedType.LESS_THAN_EQUAL:
							return sourceReal <= argReal;

						// Real::greaterThanEqual(Real)
						case PredefinedType.GREATER_THAN_EQUAL:
							return sourceReal >= argReal;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
								getName(oper));
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
							if (Boolean.TRUE.equals(sourceVal)) {
                                return Boolean.TRUE;
                            }
							
							// must evaluate the argument now
							argVal = arg.accept(getVisitor());
							return argVal;

						// Boolean::xor(Boolean)
						case PredefinedType.XOR:
							// XOR does not have a short-circuit
							argVal = arg.accept(getVisitor());
							
							if (sourceVal == null) {
                                return argVal;
                            }
							return (argVal == null) ? sourceVal
								: (((Boolean) sourceVal).booleanValue()
									^ ((Boolean) argVal).booleanValue() ? Boolean.TRUE
									: Boolean.FALSE);

						// Boolean::and(Boolean)
						case PredefinedType.AND:
							if (!Boolean.TRUE.equals(sourceVal)) {
                                return Boolean.FALSE;
                            }
							
							// must evaluate the argument now
							argVal = arg.accept(getVisitor());
							return argVal;

						// Boolean::implies
						case PredefinedType.IMPLIES:
							if (Boolean.FALSE.equals(sourceVal)) {
                                return Boolean.TRUE;
                            }
							
							// must evaluate the argument now
							argVal = arg.accept(getVisitor());
							return argVal;

						default: {
							String message = OCLMessages.bind(
									OCLMessages.UnknownOperation_ERROR_,
									getName(oper));
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
									getName(oper));
							RuntimeException error = new RuntimeException(message);
							OCLPlugin.throwing(getClass(),
								"visitOperationCallExp", error);//$NON-NLS-1$
							throw error;
						}
					}
				} else if (sourceVal instanceof Collection) {
					@SuppressWarnings("unchecked")
					Collection<Object> sourceColl = (Collection<Object>) sourceVal;

                    // bug 183144:  inputting OclInvalid should result in OclInvalid
                    if (argVal == getOclInvalid()) {
                        return argVal;
                    }
                    
					switch (opCode) {
						case PredefinedType.INCLUDES:
							// Collection::includes(T)
							return CollectionUtil.includes(sourceColl,
								argVal) ? Boolean.TRUE : Boolean.FALSE;

						case PredefinedType.EXCLUDES:
							// Collection::excludes(T)
							return CollectionUtil.excludes(sourceColl,
								argVal) ? Boolean.TRUE : Boolean.FALSE;

						case PredefinedType.COUNT:
							// Collection::count(T)
							return new Integer(CollectionUtil.count(
								sourceColl, argVal));

						case PredefinedType.INCLUDES_ALL:
							// Collection::includesAll(T)
							return CollectionUtil.includesAll(sourceColl,
								(Collection<?>) argVal) ? Boolean.TRUE
								: Boolean.FALSE;

						case PredefinedType.EXCLUDES_ALL:
							// Collection::excludesAll(T)
							return CollectionUtil.excludesAll(sourceColl,
								(Collection<?>) argVal) ? Boolean.TRUE
								: Boolean.FALSE;

						case PredefinedType.PRODUCT: {
							// Collection::product(Collection(T2))
							@SuppressWarnings("unchecked")
							CollectionType<C, O> collType = (CollectionType<C, O>) oc.getType();
							
							return CollectionUtil.product(
									getEvaluationEnvironment(),
									getEnvironment(),
									sourceColl,
									(Collection<?>) argVal,
									collType.getElementType());
						}
						case PredefinedType.UNION: {
							// Set, Bag::union(Set, Bag)
							Collection<?> argColl = (Collection<?>) argVal;
							return CollectionUtil.union(sourceColl, argColl);
						}

						case PredefinedType.INTERSECTION: {
							// Set, Bag::intersection(Set, Bag)
							Collection<?> argColl = (Collection<?>) argVal;
							return CollectionUtil.intersection(sourceColl,
								argColl);
						}

						case PredefinedType.MINUS:
							// Set::minus(Set)
							return CollectionUtil.minus((Set<?>) sourceColl,
								(Set<?>) argVal);

						case PredefinedType.INCLUDING:
							// Set, Bag, Sequence::including(T)
							return CollectionUtil.including(sourceColl,
								argVal);

						case PredefinedType.EXCLUDING:
							// Set, Bag, Sequence::excluding(T)
							return CollectionUtil.excluding(sourceColl,
								argVal);

						case PredefinedType.SYMMETRIC_DIFFERENCE:
							// Set::symmetricDifference(Set)
							return CollectionUtil.symmetricDifference(
								(Set<?>) sourceColl, (Set<?>) argVal);

						case PredefinedType.APPEND:
							// OrderedSet, Sequence::append(T)
							return CollectionUtil.append(sourceColl, argVal);

						case PredefinedType.PREPEND:
							// OrderedSet, Sequence::prepend(T)
							return CollectionUtil.prepend(sourceColl,
								argVal);

						case PredefinedType.AT: {
							// OrderedSet, Sequence::at(Integer)
							int indexVal = ((Integer) argVal).intValue();
							return CollectionUtil.at(sourceColl, indexVal);
						}

						case PredefinedType.INDEX_OF:
							// OrderedSet, Sequence::indexOf(T)
							return CollectionUtil.indexOf(sourceColl,
								argVal);
					} // end of collection type switch
				} else if (sourceVal instanceof Comparable) {

					// Handle < (lessThan)
					if (opCode == PredefinedType.LESS_THAN) {
						@SuppressWarnings("unchecked")
						Comparable<Object> comp = (Comparable<Object>) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) < 0);
					}

					//	Handle <= (lessThanEqual)
					else if (opCode == PredefinedType.LESS_THAN_EQUAL) {
						@SuppressWarnings("unchecked")
						Comparable<Object> comp = (Comparable<Object>) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) <= 0);
					}

					// Handle > (greaterThan)
					else if (opCode == PredefinedType.GREATER_THAN) {
						@SuppressWarnings("unchecked")
						Comparable<Object> comp = (Comparable<Object>) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) > 0);
					}

					// Handle > (greaterThanEqual)
					else if (opCode == PredefinedType.GREATER_THAN_EQUAL) {
						@SuppressWarnings("unchecked")
						Comparable<Object> comp = (Comparable<Object>) sourceVal;
						return Boolean.valueOf(comp.compareTo(argVal) >= 0);
					}
				}
			} else {
				//
				// ternary operations
				//

				// check if undefined
				if (isUndefined(sourceVal)) {
                    return getOclInvalid();
                }

				// evaluate arg1
				Object arg1 = args.get(0).accept(getVisitor());

				// check if undefined
				if (isUndefined(arg1)) {
                    return getOclInvalid();
                }

				// evaluate arg2
				Object arg2 = args.get(1).accept(getVisitor());

				// check if undefined
				if (isUndefined(arg2)) {
                    return getOclInvalid();
                }

				if (sourceVal instanceof String) {
					// just one ternary string operation
					// String::substring(Integer, Integer)
					// index orgin 1 for OCL
					int lower = ((Integer) arg1).intValue() - 1;
					int upper = ((Integer) arg2).intValue();
					return ((String) sourceVal).substring(lower, upper);
				} else if (sourceVal instanceof Collection) {
					@SuppressWarnings("unchecked")
					Collection<Object> sourceColl = (Collection<Object>) sourceVal;
					if (opCode == PredefinedType.INSERT_AT) {
						// OrderedSet, Sequence::insertAt(Integer, T)
						int index = ((Integer) arg1).intValue();
						return CollectionUtil.insertAt(sourceColl, index,
							arg2);
					} else if (opCode == PredefinedType.SUB_ORDERED_SET) {
						// OrderedSet, Sequence::subOrderedSet(Integer, Integer)
						int lower = ((Integer) arg1).intValue();
						int upper = ((Integer) arg2).intValue();
						return CollectionUtil.subOrderedSet(sourceColl,
							lower, upper);
					} else if (opCode == PredefinedType.SUB_SEQUENCE) {
						// Sequence::subSequence(Integer, Integer)
						int lower = ((Integer) arg1).intValue();
						int upper = ((Integer) arg2).intValue();
						return CollectionUtil.subSequence(sourceColl,
							lower, upper);
					}
				}
			}
		} else {
			
			// Handle allInstances
			if (opCode == PredefinedType.ALL_INSTANCES) {
				// can assume classifier type, otherwise the expression would
				//    not have parsed (or validated)
				@SuppressWarnings("unchecked")
				C classifier = (C) sourceVal; 
				
				if (getUMLReflection().isEnumeration(classifier)) {
					// the instances are the literals
					return new java.util.HashSet<EL>(
                            getUMLReflection().getEnumerationLiterals(classifier));
				} else if (sourceVal instanceof VoidType) {
					// OclVoid has a single instance: null
					Set<Object> result = new java.util.HashSet<Object>();
					result.add(null);
					return result;
				} else if (getUMLReflection().isClass(classifier)) {
					return getExtentMap().get(sourceVal);
				} else {
					// other types do not have numerable instances
					return Collections.EMPTY_SET;
				}
			}

			if (opCode == PredefinedType.OCL_IS_UNDEFINED) {
				return isUndefined(sourceVal)?
						Boolean.TRUE : Boolean.FALSE;
			}

			if (opCode == PredefinedType.OCL_IS_INVALID) {
				return (sourceVal == getOclInvalid())?
						Boolean.TRUE : Boolean.FALSE;
			}

			// result is invalid if source is undefined
			if (isUndefined(sourceVal)) {
			    switch (opCode) {
                case PredefinedType.OCL_IS_TYPE_OF:
                case PredefinedType.OCL_IS_KIND_OF:
                case PredefinedType.OCL_AS_TYPE:
                    if (isLaxNullHandling()) {
                        break;
                    } else {
                        return getOclInvalid();
                    }
                default:
                    return getOclInvalid();
			    }
			}

			// Handle type check and conversion:

			// AnyType::oclIsTypeOf(OclType)
			if (opCode == PredefinedType.OCL_IS_TYPE_OF) {
				OCLExpression<C> arg = args.get(0);
				return oclIsTypeOf(sourceVal, arg.accept(getVisitor()));
			}

			// AnyType::oclIsKindOf(OclType)
			else if (opCode == PredefinedType.OCL_IS_KIND_OF) {
				OCLExpression<C> arg = args.get(0);
				return oclIsKindOf(sourceVal, arg.accept(getVisitor()));
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
				OCLExpression<C> arg = args.get(0);
				
				@SuppressWarnings("unchecked")
				C type = (C) arg.accept(getVisitor());
				if (oclIsKindOf(sourceVal, type) == Boolean.TRUE) {
					return sourceVal;
				} else {
					return getOclInvalid();
				}
			}

			// Handle < (lessThan)
			else if ((opCode == PredefinedType.LESS_THAN) && (sourceVal instanceof Comparable)) {
				@SuppressWarnings("unchecked")
				Comparable<Object> compContext = (Comparable<Object>) sourceVal;
				OCLExpression<C> arg = args.get(0);
				
				@SuppressWarnings("unchecked")
				Comparable<Object> evalArg = (Comparable<Object>) arg.accept(getVisitor());
				return Boolean.valueOf(compContext.compareTo(evalArg) < 0);
			}

			//	Handle <= (lessThanEqual)
			else if ((opCode == PredefinedType.LESS_THAN_EQUAL) && (sourceVal instanceof Comparable)) {
				@SuppressWarnings("unchecked")
				Comparable<Object> compContext = (Comparable<Object>) sourceVal;
				OCLExpression<C> arg = args.get(0);
				
				@SuppressWarnings("unchecked")
				Comparable<Object> evalArg = (Comparable<Object>) arg.accept(getVisitor());
				return Boolean.valueOf(compContext.compareTo(evalArg) <= 0);
			}

			// Handle > (greaterThan)
			else if ((opCode == PredefinedType.GREATER_THAN) && (sourceVal instanceof Comparable)) {
				@SuppressWarnings("unchecked")
				Comparable<Object> compContext = (Comparable<Object>) sourceVal;
				OCLExpression<C> arg = args.get(0);
				
				@SuppressWarnings("unchecked")
				Comparable evalArg = (Comparable) arg.accept(getVisitor());
				return Boolean.valueOf(compContext.compareTo(evalArg) > 0);
			}

			// Handle > (greaterThanEqual)
			else if ((opCode == PredefinedType.GREATER_THAN_EQUAL) && (sourceVal instanceof Comparable)) {
				@SuppressWarnings("unchecked")
				Comparable<Object> compContext = (Comparable<Object>) sourceVal;
				OCLExpression<C> arg = args.get(0);
				
				@SuppressWarnings("unchecked")
				Comparable<Object> evalArg = (Comparable<Object>) arg.accept(getVisitor());
				return Boolean.valueOf(compContext.compareTo(evalArg) >= 0);
			}
			
			//
			// unknown operation (shouldn't have gotten this far if we
			//   successfully parsed and/or validated the expression
			//

			return getOclInvalid();
		}

		return null;
	}
	
	/**
	 * Infers a standard operation code from the name of a user-defined
	 * operation.  This applies for cases where a standard operation is not
	 * defined by the OCL Standard Library, but is implemented nonetheless by
	 * the interpreter.
	 * 
	 * @param operation the operation
     * @param opcode the original operation code from the AST
	 * @return the appropriate operation code, or the original <tt>opcode</tt>
     *     if there is no matching standard operation
	 */
	private int inferOperationCode(O operation, int opcode) {
	    int result = opcode;
	    String opName = getName(operation);
	    
        if (PredefinedType.LESS_THAN_NAME.equals(opName)) {
            result = PredefinedType.LESS_THAN;
        } else if (PredefinedType.GREATER_THAN_NAME.equals(opName)) {
            result = PredefinedType.GREATER_THAN;
        } else if (PredefinedType.LESS_THAN_EQUAL_NAME.equals(opName)) {
            result = PredefinedType.LESS_THAN_EQUAL;
        } else if (PredefinedType.GREATER_THAN_EQUAL_NAME.equals(opName)) {
            result = PredefinedType.GREATER_THAN_EQUAL;
        }
        
        return result;
    }

	/**
	 * Callback for an IterateExp visit.
	 */
	@Override
    public Object visitIterateExp(IterateExp<C, PM> ie) {
		// get the variable declaration for the result
		Variable<C, PM> vd = ie.getResult();
		String resultName = (String) vd.accept(getVisitor());

		try {
			// get the list of ocl iterators
			List<Variable<C, PM>> iterators = ie.getIterator();
	
			// evaluate the source collection
			Object sourceValue = ie.getSource().accept(getVisitor());
	
			// value of iteration expression is undefined if the source is
			//   null or OclInvalid
			if (isUndefined(sourceValue)) {
				return getOclInvalid();
			}
			
			Collection<?> coll = (Collection<?>) sourceValue;
			
			// get the body expression
			OCLExpression<C> body = ie.getBody();
	
			// construct an iteration template to evaluate the iterator
			IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
				IterationTemplate.getInstance(getVisitor());
	
			// evaluate
			return is.evaluate(coll, iterators, body, resultName);
		} finally {
			// remove result variable from environment
			getEvaluationEnvironment().remove(resultName);
		}
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	@Override
    public Object visitIteratorExp(IteratorExp<C, PM> ie) {
		C sourceType = ie.getSource().getType();
		
		if (sourceType instanceof PredefinedType) {
			Object sourceValue = ie.getSource().accept(getVisitor());
			
			// value of iteration expression is undefined if the source is
			//   null or OclInvalid
			if (isUndefined(sourceValue)) {
				return getOclInvalid();
			}
			
			Collection<?> sourceCollection = (Collection<?>) sourceValue;
			
			switch (OCLStandardLibraryUtil.getOperationCode(ie.getName())) {
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

	private static synchronized String generateName() {
		return "__result__" + tempCounter++;//$NON-NLS-1$
	}

	private Object evaluateExistsIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateExists.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, Boolean.FALSE);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove the result variable from the environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateForAllIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateForAll.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, Boolean.TRUE);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from the environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateCollectNestedIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get initial result value based on the source type
		@SuppressWarnings("unchecked")
		CollectionType<C, O> collType = (CollectionType<C, O>) ie.getSource().getType();
		
		Object initResultVal = null;
		if (collType instanceof SetType || collType instanceof BagType) {
            // collection on a Bag or a Set yields a Bag
			initResultVal = CollectionUtil.createNewBag();
        } else {
            // Sequence or Ordered Set yields a Sequence
			initResultVal = CollectionUtil.createNewSequence();
        }
		
		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateCollectNested.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateCollectIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get initial result value based on the source type
		@SuppressWarnings("unchecked")
		CollectionType<C, O> collType = (CollectionType<C, O>) ie.getSource().getType();
		
		Object initResultVal = null;
		if (collType instanceof SetType || collType instanceof BagType) {
            // collection on a Bag or a Set yields a Bag
			initResultVal = CollectionUtil.createNewBag();
        } else {
            // Sequence or Ordered Set yields a Sequence
			initResultVal = CollectionUtil.createNewSequence();
        }

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateCollect.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateSelectIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get initial result value based on the source type
		@SuppressWarnings("unchecked")
		CollectionType<C, O> collType = (CollectionType<C, O>) ie.getSource().getType();
		
		Object initResultVal = null;
		if (collType instanceof SetType) {
            // Set
			initResultVal = CollectionUtil.createNewSet();
        } else if (collType instanceof BagType) {
            // Bag
			initResultVal = CollectionUtil.createNewBag();
        } else if (collType instanceof SequenceType) {
            // Sequence
			initResultVal = CollectionUtil.createNewSequence();
        } else {
            // OrderedSet
			initResultVal = CollectionUtil.createNewOrderedSet();
        }

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateSelect.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateRejectIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get initial result value based on the source type
		@SuppressWarnings("unchecked")
		CollectionType<C, O> collType = (CollectionType<C, O>) ie.getSource().getType();
		
		Object initResultVal = null;
		if (collType instanceof SetType) {
            // Set
			initResultVal = CollectionUtil.createNewSet();
        } else if (collType instanceof BagType) {
            // Bag
			initResultVal = CollectionUtil.createNewBag();
        } else if (collType instanceof SequenceType) {
            // Sequence
			initResultVal = CollectionUtil.createNewSequence();
        } else {
            // OrderedSet
			initResultVal = CollectionUtil.createNewOrderedSet();
        }

		//	get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateReject.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, initResultVal);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateOneIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateOne.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, Boolean.FALSE);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateAnyIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateAny.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, null);

		// evaluate
		Object result = is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	private Object evaluateSortedByIterator(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		//		int numIters = iterators.size();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateSortedBy.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		
		final Map<Object, Comparable<Object>> map =
			new HashMap<Object, Comparable<Object>>();
		getEvaluationEnvironment().add(resultName, map);

		// evaluate
		// TODO: find an efficient way to do this.
		Object evaluationResult = is.evaluate(coll, iterators, body, resultName);
		
		if (evaluationResult == getOclInvalid()) {
			// handle the OclInvalid result
			return evaluationResult;
		}
		
		is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		// sort the source collection based on the natural ordering of the
		// body expression evaluations
		List<Object> result = new ArrayList<Object>(coll);

		Collections.sort(result, new Comparator<Object>() {

			public int compare(Object o1, Object o2) {
				Comparable<Object> b1 = map.get(o1);
				Comparable<Object> b2 = map.get(o2);
				return (b1.compareTo(b2));
			}
		});

		// create result
		// type is Sequence if source is a sequence or a Bag,
		// SortedSet if source is a SortedSet or a Set
		C collType = ie.getSource().getType();
		if (collType instanceof SetType || collType instanceof OrderedSetType) {
            return CollectionUtil.createNewOrderedSet(result);
        } else {
            return CollectionUtil.createNewSequence(result);
        }
	}

	private Object evaluateIsUnique(IteratorExp<C, PM> ie, Collection<?> coll) {
		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();
		
		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> is =
			IterationTemplateIsUnique.getInstance(getVisitor());

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, new HashSet<Object>());

		// evaluate
		is.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return is.isDone() ? Boolean.FALSE : Boolean.TRUE;
	}

	private Object evaluateClosure(IteratorExp<C, PM> ie, Collection<?> coll) {

		// get the list of ocl iterators
		List<Variable<C, PM>> iterators = ie.getIterator();

		// get the body expression
		OCLExpression<C> body = ie.getBody();

		// create initial result value
		Object initResultVal = CollectionUtil.createNewSet();

		// get an iteration template to evaluate the iterator
		IterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> template =
			IterationTemplateClosure.getInstance(getVisitor(), body);

		// generate a name for the result variable and add it to the environment
		String resultName = generateName();
		getEvaluationEnvironment().add(resultName, initResultVal);

		// evaluate
		Object result = template.evaluate(coll, iterators, body, resultName);

		// remove result name from environment
		getEvaluationEnvironment().remove(resultName);

		return result;
	}

	/**
	 * Callback for an EnumLiteralExp visit. Get the referred enum literal and
	 * return it as an Integer.
	 * 
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal as an Integer
	 */
	@Override
    public Object visitEnumLiteralExp(EnumLiteralExp<C, EL> el) {
		return (enumerations == null) ? el.getReferredEnumLiteral()
			: enumerations.getValue(el.getReferredEnumLiteral());
	}

	/**
	 * Callback for a VariableExp visit.
	 * 
	 * @param v
	 *            the variable expression
	 * @return the value of the variable
	 */
	@Override
    public Object visitVariableExp(VariableExp<C, PM> v) {

		// get the referred variable name
		Variable<C, PM> vd = v.getReferredVariable();
		String varName = vd.getName();

		// evaluate the variable in the current environment
		return getEvaluationEnvironment().getValueOf(varName);
	}

	/**
	 * Callback for a PropertyCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the property on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the property "foo" would be accessed
	 * on that object.
	 */
	@Override
    public Object visitPropertyCallExp(PropertyCallExp<C, P> pc) {
		P property = pc.getReferredProperty();
		OCLExpression<C> source = pc.getSource();

		// evaluate source
		Object context = source.accept(getVisitor());

		// if source is undefined, result is OclInvalid
		if (isUndefined(context)) {
            return getOclInvalid();
        }

		OCLExpression<C> derivation = getPropertyBody(property);
		if (derivation != null) {
			// this is an additional property
			
			return navigate(property, derivation, context);
		}
		
		List<Object> qualifiers;
		
		if (pc.getQualifier().isEmpty()) {
			qualifiers = Collections.emptyList();
		} else {
			// handle qualified association navigation
			qualifiers = new java.util.ArrayList<Object>();
			
			for (OCLExpression<C> q : pc.getQualifier()) {
				qualifiers.add(q.accept(getVisitor()));
			}
		}
		
		Object result = getEvaluationEnvironment().navigateProperty(property, qualifiers, context);
		
		if ((pc.getType() instanceof CollectionType) && !(result instanceof Collection)) {
			// this was an XSD "unspecified multiplicity".  Now that we know what
			//    the multiplicity is, we can coerce it to a collection value
			@SuppressWarnings("unchecked")
			CollectionKind kind = ((CollectionType<C, O>) pc.getType()).getKind();
			
			Collection<Object> collection = CollectionUtil.createNewCollection(kind);
			
			collection.add(result);
			result = collection;
		}
		
		return result;
	}

	/**
	 * Callback for an AssociationClassCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the reference on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the reference "foo" would be derived
	 * on that object.
	 */
	@Override
    public Object visitAssociationClassCallExp(AssociationClassCallExp<C, P> ae) {
		Object context = ae.getSource().accept(getVisitor());
		
		if (isUndefined(context)) {
			return getOclInvalid();
		}
		
		// evaluate attribute on source value
		return getEvaluationEnvironment().navigateAssociationClass(
			ae.getReferredAssociationClass(),
			ae.getNavigationSource(),
			context);
	}

	/**
	 * Callback for a VariableDeclaration visit.
	 */
	@Override
    public Object visitVariable(Variable<C, PM> vd) {
		// add the variable to the environment, initialized to
		// its initial expression (if it has one). return the name
		// of the variable.
		String varName = vd.getName();
		OCLExpression<C> initExp = vd.getInitExpression();
		Object initVal = null;
		if (initExp != null) {
            initVal = initExp.accept(getVisitor());
        }
		getEvaluationEnvironment().add(varName, initVal);
		return varName;
	}

	/**
	 * Callback for an IfExp visit.
	 */
	@Override
    public Object visitIfExp(IfExp<C> ie) {
		// get condition
		OCLExpression<C> condition = ie.getCondition();

		// evaluate condition
		Boolean condVal = (Boolean) condition.accept(getVisitor());
		if (condVal == null) {
            return null;
        }

		if (condVal.booleanValue()) {
            return ie.getThenExpression().accept(getVisitor());
        }
		return ie.getElseExpression().accept(getVisitor());
	}

	/**
	 * Callback for a TypeExp visiy.
	 */
	@Override
    public Object visitTypeExp(TypeExp<C> t) {
		return t.getReferredType();
	}
	
	@Override
    public Object visitStateExp(StateExp<C, S> s) {
		return s.getReferredState();
	}
	
	@Override
    public Object visitMessageExp(MessageExp<C, COA, SSA> m) {
		throw new UnsupportedOperationException("evaluation of MessageExp"); //$NON-NLS-1$
	}
	
	/**
	 * Callback for an UnspecifiedValueExp visit.
	 */
	@Override
    public Object visitUnspecifiedValueExp(UnspecifiedValueExp<C> uv) {
		// TODO: return a "random instance of the type of the expression"
		throw new UnsupportedOperationException("evaluation of UnspecifiedValueExp"); //$NON-NLS-1$
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 * 
	 * @return the value of the integer literal as a java.lang.Integer.
	 */
	@Override
    public Object visitIntegerLiteralExp(IntegerLiteralExp<C> il) {
		return il.getIntegerSymbol();
	}
    
    /**
     * Callback for an UnlimitedNaturalLiteralExp visit.
     * 
     * @return the value of the natural literal as a java.lang.Integer.
     */
    @Override
    public Object visitUnlimitedNaturalLiteralExp(
            UnlimitedNaturalLiteralExp<C> literalExp) {
        return literalExp.getIntegerSymbol();
    }

	/**
	 * Callback for a RealLiteralExp visit.
	 * 
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
    public Object visitRealLiteralExp(RealLiteralExp<C> rl) {
		return rl.getRealSymbol();
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * 
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
    public Object visitStringLiteralExp(StringLiteralExp<C> sl) {
		return sl.getStringSymbol();
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * 
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
    public Object visitBooleanLiteralExp(BooleanLiteralExp<C> bl) {
		return bl.getBooleanSymbol();
	}

	@Override
    public Object visitInvalidLiteralExp(InvalidLiteralExp<C> il) {
		// just make up some object to take the place of the OclInvalid literal
		return getOclInvalid();
	}

	@Override
    public Object visitNullLiteralExp(NullLiteralExp<C> il) {
		// the single OclVoid instance is equivalent to Java null
		return null;
	}

	/**
	 * Callback for LetExp visit.
	 */
	@Override
    public Object visitLetExp(LetExp<C, PM> l) {
		// get variable decl for let variable
		Variable<C, PM> vd = l.getVariable();
		String name = (String) vd.accept(getVisitor());

		// evaluate the "in" part of the let
		OCLExpression<C> inExp = l.getIn();
		Object val = inExp.accept(getVisitor());

		// remove the variable-init expression binding from the environment
		getEvaluationEnvironment().remove(name);

		// return the value of the "in"
		return val;
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 */
	@Override
    public Object visitCollectionLiteralExp(CollectionLiteralExp<C> cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		CollectionKind kind = cl.getKind();
		List<CollectionLiteralPart<C>> parts = cl.getPart();
		Collection<Object> result = CollectionUtil.createNewCollection(kind);

		if ((kind == CollectionKind.SEQUENCE_LITERAL) && cl.isSimpleRange()) {
			// literal is of the form: Sequence{first..last}.
			// construct a list with a lazy iterator for it.
			CollectionRange<C> collRange = (CollectionRange<C>) parts.get(0);
			OCLExpression<C> first = collRange.getFirst();
			OCLExpression<C> last = collRange.getLast();

			// evaluate first value
			Integer firstVal = (Integer) first.accept(getVisitor());
			if (firstVal == null) {
				result.add(null);
				return result;
			}
			// evaluate last value
			Integer lastVal = (Integer) last.accept(getVisitor());
			if (lastVal == null) {
				result.add(null);
				return result;
			}

			int firstInt = firstVal.intValue();
			int lastInt = lastVal.intValue();
			if (firstInt > lastInt) {
                return result;
            }

			// construct a lazy integer list for the range
			return new IntegerRangeList(firstInt, lastInt);
		} else {
			// not a sequence or not a simple range
			for (CollectionLiteralPart<C> part : parts) {
				if (part instanceof CollectionItem) {
					// CollectionItem part
					CollectionItem<C> item = (CollectionItem<C>) part;
					OCLExpression<C> itemExp = item.getItem();
					Object itemVal = itemExp.accept(getVisitor());
					if (itemVal != null) {
						// add it to the result set
						result.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange<C> range = (CollectionRange<C>) part;
					OCLExpression<C> first = range.getFirst();
					OCLExpression<C> last = range.getLast();

					// evaluate first value
					Integer firstVal = (Integer) first.accept(getVisitor());
					Integer lastVal = (Integer) last.accept(getVisitor());
					if (!((firstVal == null) || (lastVal == null))) {
						// TODO: enhance IntegerRangeList to support multiple ranges
						// add values between first and last inclusive
						int firstInt = firstVal.intValue();
						int lastInt = lastVal.intValue();
						for (int i = firstInt; i <= lastInt; i++) {
                            result.add(new Integer(i));
                        }
					}
				} // end of collection range

			} // end of parts iterator

		} // end of not-simple range case

		return result;
	} // end of Set, OrderedSet, Bag Literals

	// private static inner class for lazy lists over an integer range
	private static final class IntegerRangeList
		extends AbstractList<Integer> {

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

		@Override
        public int size() {
			return last - first + 1;
		}

		@Override
        public Integer get(int index) {
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

		@Override
        public Iterator<Integer> iterator() {
			// local iterator class that provides
			// hasNext() and next() methods appropriate
			// for this range set
			class IntegerRangeIterator
				implements Iterator<Integer> {

				public IntegerRangeIterator() {
					curr = first;
					initialized = false;
				}

				public Integer next() {
					if (!initialized) {
						curr = first - 1;
						initialized = true;
					}
					if (hasNext()) {
                        return new Integer(++curr);
                    }
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
	@Override
    public Object visitTupleLiteralExp(TupleLiteralExp<C, P> tl) {
		C type = tl.getType();
		List<TupleLiteralPart<C, P>> tp = tl.getPart();
		
		Map<P, Object> propertyValues = new HashMap<P, Object>();
		
		for (TupleLiteralPart<C, P> part : tp) {
			// Set the tuple field with the value of the init expression
			propertyValues.put(part.getAttribute(), part.accept(getVisitor()));
		}

		return getEvaluationEnvironment().createTuple(type, propertyValues);

	}
	
	@Override
    public Object visitTupleLiteralPart(TupleLiteralPart<C, P> tp) {
		return tp.getValue().accept(getVisitor());
	}
	
	/**
	 * Queries whether our evaluation environment has the option for
	 * {@linkplain EvaluationOptions#LAX_NULL_HANDLING lax null handling}
	 * enabled.
	 * 
	 * @since 1.2
	 * @return whether lax null handling is enabled
	 */
	protected boolean isLaxNullHandling() {
	    return EvaluationOptions.getValue(getEvaluationEnvironment(),
	        EvaluationOptions.LAX_NULL_HANDLING);
	}
} //EvaluationVisitorImpl

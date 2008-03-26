/**
 * <copyright> 
 *
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling
 *
 * </copyright>
 *
 * $Id: OCLStandardLibraryUtil.java,v 1.9 2008/03/26 21:17:25 cdamus Exp $
 */
package org.eclipse.ocl.util;

import static org.eclipse.ocl.utilities.PredefinedType.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.StringProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Convenience utilities for working with the types defined by the
 * {@linkplain OCLStandardLibrary OCL Standard Library}.
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public final class OCLStandardLibraryUtil {

    /**
     * The name of the tuple part carrying elements of the source collection
     * in a <tt>product</tt> operation.
     */
    public static final String PRODUCT_FIRST = "first"; //$NON-NLS-1$
    
    /**
     * The name of the tuple part carrying elements of the argument collection
     * in a <tt>product</tt> operation.
     */
    public static final String PRODUCT_SECOND = "second"; //$NON-NLS-1$

	private static final Map<String, Integer> operationCodes = new java.util.HashMap<String, Integer>();
	private static final Map<String, Integer> oclAnyOperationCodes = new java.util.HashMap<String, Integer>();
	
	static {
		operationCodes.put(PLUS_NAME, PLUS);
		operationCodes.put(MINUS_NAME, MINUS);
		operationCodes.put(TIMES_NAME, TIMES);
		operationCodes.put(DIVIDE_NAME, DIVIDE);
		operationCodes.put(AND_NAME, AND);
		operationCodes.put(NOT_NAME, NOT);
		operationCodes.put(OR_NAME, OR);
		operationCodes.put(IMPLIES_NAME, IMPLIES);
		operationCodes.put(ABS_NAME, ABS);
		operationCodes.put(DIV_NAME, DIV);
		operationCodes.put(MOD_NAME, MOD);
		operationCodes.put(MAX_NAME, MAX);
		operationCodes.put(MIN_NAME, MIN);
		operationCodes.put(SIZE_NAME, SIZE);
		operationCodes.put(CONCAT_NAME, CONCAT);
		operationCodes.put(SUBSTRING_NAME, SUBSTRING);
		operationCodes.put(TO_INTEGER_NAME, TO_INTEGER);
		operationCodes.put(TO_REAL_NAME, TO_REAL);
		operationCodes.put(XOR_NAME, XOR);
		operationCodes.put(FLOOR_NAME, FLOOR);
		operationCodes.put(ROUND_NAME, ROUND);
		operationCodes.put(TO_LOWER_NAME, TO_LOWER);
		operationCodes.put(TO_UPPER_NAME, TO_UPPER);
		operationCodes.put(ALL_INSTANCES_NAME, ALL_INSTANCES);
		operationCodes.put(EQUAL_NAME, EQUAL);
		operationCodes.put(NOT_EQUAL_NAME, NOT_EQUAL);
		operationCodes.put(OCL_AS_TYPE_NAME, OCL_AS_TYPE);
		operationCodes.put(OCL_IS_KIND_OF_NAME, OCL_IS_KIND_OF);
		operationCodes.put(OCL_IS_TYPE_OF_NAME, OCL_IS_TYPE_OF);
		operationCodes.put(OCL_IS_UNDEFINED_NAME, OCL_IS_UNDEFINED);
		operationCodes.put(OCL_IS_INVALID_NAME, OCL_IS_INVALID);
		operationCodes.put(LESS_THAN_NAME, LESS_THAN);
		operationCodes.put(GREATER_THAN_NAME, GREATER_THAN);
		operationCodes.put(LESS_THAN_EQUAL_NAME, LESS_THAN_EQUAL);
		operationCodes.put(GREATER_THAN_EQUAL_NAME, GREATER_THAN_EQUAL);
		operationCodes.put(OCL_IS_NEW_NAME, OCL_IS_NEW);
		operationCodes.put(OCL_IS_IN_STATE_NAME, OCL_IS_IN_STATE);
		operationCodes.put(HAS_RETURNED_NAME, HAS_RETURNED);
		operationCodes.put(RESULT_NAME, RESULT);
		operationCodes.put(IS_SIGNAL_SENT_NAME, IS_SIGNAL_SENT);
		operationCodes.put(IS_OPERATION_CALL_NAME, IS_OPERATION_CALL);
	    operationCodes.put(COUNT_NAME, COUNT);
	    operationCodes.put(EXCLUDES_NAME, EXCLUDES);
	    operationCodes.put(EXCLUDES_ALL_NAME, EXCLUDES_ALL);
	    operationCodes.put(INCLUDES_NAME, INCLUDES);
	    operationCodes.put(INCLUDES_ALL_NAME, INCLUDES_ALL);
	    operationCodes.put(IS_EMPTY_NAME, IS_EMPTY);
	    operationCodes.put(NOT_EMPTY_NAME, NOT_EMPTY);
	    operationCodes.put(PRODUCT_NAME, PRODUCT);
	    operationCodes.put(SUM_NAME, SUM);
	    operationCodes.put(AS_BAG_NAME, AS_BAG);
	    operationCodes.put(AS_ORDERED_SET_NAME, AS_ORDERED_SET);
	    operationCodes.put(AS_SEQUENCE_NAME, AS_SEQUENCE);
	    operationCodes.put(AS_SET_NAME, AS_SET);
	    operationCodes.put(EXCLUDING_NAME, EXCLUDING);
	    operationCodes.put(FLATTEN_NAME, FLATTEN);
	    operationCodes.put(INCLUDING_NAME, INCLUDING);
	    operationCodes.put(INTERSECTION_NAME, INTERSECTION);
	    operationCodes.put(UNION_NAME, UNION);
	    operationCodes.put(AT_NAME, AT);
	    operationCodes.put(FIRST_NAME, FIRST);
	    operationCodes.put(INDEX_OF_NAME, INDEX_OF);
	    operationCodes.put(INSERT_AT_NAME, INSERT_AT);
	    operationCodes.put(LAST_NAME, LAST);
	    operationCodes.put(PREPEND_NAME, PREPEND);
	    operationCodes.put(SUB_SEQUENCE_NAME, SUB_SEQUENCE);
	    operationCodes.put(APPEND_NAME, APPEND);
	    operationCodes.put(SUB_ORDERED_SET_NAME, SUB_ORDERED_SET);
	    operationCodes.put(SYMMETRIC_DIFFERENCE_NAME, SYMMETRIC_DIFFERENCE);
		operationCodes.put(EXISTS_NAME, EXISTS);
		operationCodes.put(FOR_ALL_NAME, FOR_ALL);
		operationCodes.put(IS_UNIQUE_NAME, IS_UNIQUE);
		operationCodes.put(ONE_NAME, ONE);
		operationCodes.put(ANY_NAME, ANY);
		operationCodes.put(COLLECT_NAME, COLLECT);
		operationCodes.put(COLLECT_NESTED_NAME, COLLECT_NESTED);
		operationCodes.put(CLOSURE_NAME, CLOSURE);
		operationCodes.put(SELECT_NAME, SELECT);
		operationCodes.put(REJECT_NAME, REJECT);
		operationCodes.put(SORTED_BY_NAME, SORTED_BY);
		
		oclAnyOperationCodes.put(EQUAL_NAME, EQUAL);
		oclAnyOperationCodes.put(NOT_EQUAL_NAME, NOT_EQUAL);
		oclAnyOperationCodes.put(OCL_AS_TYPE_NAME, OCL_AS_TYPE);
		oclAnyOperationCodes.put(OCL_IS_KIND_OF_NAME, OCL_IS_KIND_OF);
		oclAnyOperationCodes.put(OCL_IS_TYPE_OF_NAME, OCL_IS_TYPE_OF);
		oclAnyOperationCodes.put(OCL_IS_UNDEFINED_NAME, OCL_IS_UNDEFINED);
		oclAnyOperationCodes.put(OCL_IS_INVALID_NAME, OCL_IS_INVALID);
		oclAnyOperationCodes.put(LESS_THAN_NAME, LESS_THAN);
		oclAnyOperationCodes.put(GREATER_THAN_NAME, GREATER_THAN);
		oclAnyOperationCodes.put(LESS_THAN_EQUAL_NAME, LESS_THAN_EQUAL);
		oclAnyOperationCodes.put(GREATER_THAN_EQUAL_NAME, GREATER_THAN_EQUAL);
		oclAnyOperationCodes.put(OCL_IS_NEW_NAME, OCL_IS_NEW);
		oclAnyOperationCodes.put(OCL_IS_IN_STATE_NAME, OCL_IS_IN_STATE);
	}
	
    // not instantiable by clients
	private OCLStandardLibraryUtil() {
		super();
	}
	
    /**
     * Obtains the numeric code of the specified pre-defined (by OCL) operaiton.
     * 
     * @param operName the operation name
     * @return the corresponding code (as defined by the {@link PredefinedType}
     *     interface), or <code>0</code> if the operation name is not a
     *     pre-defined operation
     *     
     * @see #getOperationName(int)
     */
	public static int getOperationCode(String operName) {
		Integer code = operationCodes.get(operName);
		
		return code == null? 0 : code;
	}
	
    /**
     * Obtains the numeric code of the specified <tt>OclAny</tt> operaiton.
     * 
     * @param operName the operation name
     * @return the corresponding code (as defined by the {@link PredefinedType}
     *     interface), or <code>0</code> if the operation name is not an
     *     operation of the <tt>OclAny</tt> type
     */
	public static int getOclAnyOperationCode(String operName) {
		Integer code = oclAnyOperationCodes.get(operName);
		
		return code == null? 0 : code;
	}
	
	/**
	 * Returns the operation name corresponding to the opcode.
	 * 
	 * @param opcode an operation code
	 * @return the name corresponding to the opcode, or <code>null</code> if
     *    the code is not one defined by the {@link PredefinedType} interface
     * 
     * @see #getOperationCode(String)
	 */
	public static String getOperationName(int opcode) {
		switch (opcode) {
			case PLUS: return PLUS_NAME;
			case MINUS: return MINUS_NAME;
			case TIMES: return TIMES_NAME;
			case DIVIDE: return DIVIDE_NAME;
			case AND: return AND_NAME;
			case NOT: return NOT_NAME;
			case OR: return OR_NAME;
			case IMPLIES: return IMPLIES_NAME;
			case ABS: return ABS_NAME;
			case DIV: return DIV_NAME;
			case MOD: return MOD_NAME;
			case MAX: return MAX_NAME;
			case MIN: return MIN_NAME;
			case SIZE: return SIZE_NAME;
			case CONCAT: return CONCAT_NAME;
			case SUBSTRING: return SUBSTRING_NAME;
			case TO_INTEGER: return TO_INTEGER_NAME;
			case TO_REAL: return TO_REAL_NAME;
			case XOR: return XOR_NAME;
			case FLOOR: return FLOOR_NAME;
			case ROUND: return ROUND_NAME;
			case TO_LOWER: return TO_LOWER_NAME;
			case TO_UPPER: return TO_UPPER_NAME;
			case ALL_INSTANCES: return ALL_INSTANCES_NAME;
			case EQUAL: return EQUAL_NAME;
			case NOT_EQUAL: return NOT_EQUAL_NAME;
			case OCL_AS_TYPE: return OCL_AS_TYPE_NAME;
			case OCL_IS_KIND_OF: return OCL_IS_KIND_OF_NAME;
			case OCL_IS_TYPE_OF: return OCL_IS_TYPE_OF_NAME;
			case OCL_IS_UNDEFINED: return OCL_IS_UNDEFINED_NAME;
			case OCL_IS_INVALID: return OCL_IS_INVALID_NAME;
			case LESS_THAN: return LESS_THAN_NAME;
			case GREATER_THAN: return GREATER_THAN_NAME;
			case LESS_THAN_EQUAL: return LESS_THAN_EQUAL_NAME;
			case GREATER_THAN_EQUAL: return GREATER_THAN_EQUAL_NAME;
			case OCL_IS_NEW: return OCL_IS_NEW_NAME;
			case OCL_IS_IN_STATE: return OCL_IS_IN_STATE_NAME;
			case HAS_RETURNED: return HAS_RETURNED_NAME;
			case RESULT: return RESULT_NAME;
			case IS_SIGNAL_SENT: return IS_SIGNAL_SENT_NAME;
			case IS_OPERATION_CALL: return IS_OPERATION_CALL_NAME;
		    case COUNT: return COUNT_NAME;
		    case EXCLUDES: return EXCLUDES_NAME;
		    case EXCLUDES_ALL: return EXCLUDES_ALL_NAME;
		    case INCLUDES: return INCLUDES_NAME;
		    case INCLUDES_ALL: return INCLUDES_ALL_NAME;
		    case IS_EMPTY: return IS_EMPTY_NAME;
		    case NOT_EMPTY: return NOT_EMPTY_NAME;
		    case PRODUCT: return PRODUCT_NAME;
		    case SUM: return SUM_NAME;
		    case AS_BAG: return AS_BAG_NAME;
		    case AS_ORDERED_SET: return AS_ORDERED_SET_NAME;
		    case AS_SEQUENCE: return AS_SEQUENCE_NAME;
		    case AS_SET: return AS_SET_NAME;
		    case EXCLUDING: return EXCLUDING_NAME;
		    case FLATTEN: return FLATTEN_NAME;
		    case INCLUDING: return INCLUDING_NAME;
		    case INTERSECTION: return INTERSECTION_NAME;
		    case UNION: return UNION_NAME;
		    case AT: return AT_NAME;
		    case FIRST: return FIRST_NAME;
		    case INDEX_OF: return INDEX_OF_NAME;
		    case INSERT_AT: return INSERT_AT_NAME;
		    case LAST: return LAST_NAME;
		    case PREPEND: return PREPEND_NAME;
		    case SUB_SEQUENCE: return SUB_SEQUENCE_NAME;
		    case APPEND: return APPEND_NAME;
		    case SUB_ORDERED_SET: return SUB_ORDERED_SET_NAME;
		    case SYMMETRIC_DIFFERENCE: return SYMMETRIC_DIFFERENCE_NAME;
			case EXISTS: return EXISTS_NAME;
			case FOR_ALL: return FOR_ALL_NAME;
			case IS_UNIQUE: return IS_UNIQUE_NAME;
			case ONE: return ONE_NAME;
			case ANY: return ANY_NAME;
			case COLLECT: return COLLECT_NAME;
			case COLLECT_NESTED: return COLLECT_NESTED_NAME;
			case CLOSURE: return CLOSURE_NAME;
			case SELECT: return SELECT_NAME;
			case REJECT: return REJECT_NAME;
			case SORTED_BY: return SORTED_BY_NAME;
			default: return ""; //$NON-NLS-1$
		}
	}
	
    /**
     * Obtains the result type of the specified operation from the OCL Standard
     * Library.  Many of the OCL Standard Library operations are either generic
     * themselves or defined by generic types, so the return results depend on
     * the argument and source types.
     * 
     * @param env an OCL environment (indicating the metamodel binding)
     * @param sourceType the type of the operation source (object on which
     *     the operation is called)
     * @param opcode the operation's code
     * @param args the arguments of the operation call, as expressions or
     *     variables
     * @return the result type of the corresponding operation
     * 
     * @throws SemanticException if any of the argument types does not correspond
     *     to the source type and/or expected parameter types of the operation
     * 
     * @see #getOperationCode(String)
     * 
     * @deprecated Use the {@link #getResultTypeOf(Object, Environment, Object, int, List)}
     *    method, instead, which doesn't fail on the first problem
     */
	@Deprecated
    public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getResultTypeOf(
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) throws SemanticException {
		
		StringProblemHandler handler = null;
		ProblemHandler oldHandler = null;
		BasicEnvironment benv = OCLUtil.getAdapter(env, BasicEnvironment.class);
		
		if (benv != null) {
			AbstractParser parser = benv.getParser();
			oldHandler = benv.getProblemHandler();
			handler = new StringProblemHandler(parser);
			
			benv.setProblemHandler(new ProblemHandlerWrapper.Tee(oldHandler, handler));
		}
		
		try {
			C result = getResultTypeOf(null, env, sourceType, opcode, args);
			
			if (result == null) {
				String message = handler.getProblemString();
				throw new SemanticException(message);
			}
			
			return result;
		} finally {
			if (benv != null) {
				benv.setProblemHandler(oldHandler);
			}
		}
	}
	
    /**
     * Obtains the result type of the specified operation from the OCL Standard
     * Library.  Many of the OCL Standard Library operations are either generic
     * themselves or defined by generic types, so the return results depend on
     * the argument and source types.
     * 
     * @param env an OCL environment (indicating the metamodel binding)
     * @param sourceType the type of the operation source (object on which
     *     the operation is called)
     * @param opcode the operation's code
     * @param args the arguments of the operation call, as expressions or
     *     variables
     * @return the result type of the corresponding operation, or null
     * 	   after reporting a problem to env if any of the argument types do not correspond
     *     to the source type and/or expected parameter types of the operation
     * 
     * @see #getOperationCode(String)
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {
		
		if (sourceType instanceof PrimitiveType) {
			return getPrimitiveTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
		} else if (sourceType instanceof CollectionType) {
			if (sourceType instanceof BagType) {
				return getBagTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
			} else if (sourceType instanceof SetType) {
				return getSetTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
			} else if (sourceType instanceof OrderedSetType) {
				return getOrderedSetTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
			} else if (sourceType instanceof SequenceType) {
				return getSequenceTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
			}
			
			return getCollectionTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
		} else if (sourceType instanceof TypeType) {
			return getTypeTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
		} else if (sourceType instanceof MessageType) {
			return getMessageTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
		}
		
		return getAnyTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
	}
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link AnyType}s.
     */
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getAnyTypeResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();
		UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
        
		TypedElement<C> arg;
		C argType;
		
		switch (opcode) {
			case NOT_EQUAL:
			case EQUAL:
				/*
				 * Performs a conformance test for primitives, EClass, EEnum,
				 * TupleType
				 */
				arg = args.get(0);
				argType = arg.getType();
				
				return stdlib.getBoolean();
			case LESS_THAN:
			case GREATER_THAN:
			case LESS_THAN_EQUAL:
			case GREATER_THAN_EQUAL:
				arg = args.get(0);
				argType = arg.getType();
				
				O oper = null;
				try {
					oper = TypeUtil.findOperationMatching(
						env, sourceType,
						getOperationName(opcode),
						args);
					
					if ((oper == null) && ParsingOptions.getValue(env,
					            ParsingOptions.USE_COMPARE_TO_OPERATION)) {
		                // source must either be a DataType that is Comparable, or
		                //    else be a Elass, with an operation:
					    //    int compareTo(object)
		                if (uml.isDataType(sourceType)) {
		                    if (uml.isComparable(sourceType)) {
		                        TypeUtil.checkMutuallyComparable(
		                            problemObject, env, sourceType, argType,
		                            opcode);
		                        
	                            // warn about non-standard Java-ism
	                            warning(env, OCLMessages.NonStd_CompareTo_,
	                                "getAnyTypeResultOf", problemObject); //$NON-NLS-1$
	                            
		                        return stdlib.getBoolean();
		                    }
		                    
		                    String message = OCLMessages.bind(
		                            OCLMessages.SourceEClass_ERROR_,
		                            getOperationName(opcode));
		                    error(env, message, "anyTypeResultTypeOf", problemObject); //$NON-NLS-1$
		                    return null;
		                }
		                
						// Check that the type has a method named "compareTo"
						oper = TypeUtil.findOperationMatching(
							env, sourceType,
							"compareTo", //$NON-NLS-1$
							args);
						
						if (oper != null) {
						    // warn about non-standard Java-ism
						    warning(env, OCLMessages.NonStd_CompareTo_,
						        "getAnyTypeResultOf", problemObject); //$NON-NLS-1$
						}
					}
				} catch (Exception e) {
					String message = OCLMessages.bind(
							OCLMessages.SourceOperationCompareTo_ERROR_,
							getOperationName(opcode));
					error(env, message, "anyTypeResultTypeOf", problemObject); //$NON-NLS-1$
					return null;
				}
				
				if ((oper != null) && "compareTo".equals(uml.getName(oper)) //$NON-NLS-1$
						&& (TypeUtil.resolveType(env, uml.getOCLType(oper)) != stdlib.getInteger())) {
					String message = OCLMessages.ResultCompareToInt_ERROR_;
					error(env, message, "anyTypeResultTypeOf", problemObject); //$NON-NLS-1$
					return null;
				}
			
				return stdlib.getBoolean();

			case OCL_IS_KIND_OF:
			case OCL_IS_TYPE_OF:
			case OCL_IS_NEW:
			case OCL_IS_IN_STATE:
				return stdlib.getBoolean();
			case OCL_AS_TYPE:
				TypeExp<C> typeExp = (TypeExp<C>) args.get(0);
				argType = typeExp.getReferredType();
				
				if (sourceType instanceof CollectionType) {
					String message = OCLMessages.bind(
							OCLMessages.Noncomforming_ERROR_,
							uml.getName(sourceType),
							getOperationName(opcode));
					error(env, message, "anyTypeResultTypeOf", problemObject); //$NON-NLS-1$
					return null;
				}
				// we can require neither a common supertype nor that type2
				// and type1 have any conformance relationship whatsoever
				// because the run-time 'type' may conform to 'arg'
				//				commonSuperType(argEType, type);
				//type1AsType2(type, argEType);
				return argType;
			case OCL_IS_UNDEFINED:
			case OCL_IS_INVALID:
				return stdlib.getBoolean();
		}
		
		// unknown operation (shouldn't get here)
		return null;
	}
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link PrimitiveType}s.
     */
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getPrimitiveTypeResultTypeOf(Object problemObject, 
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();

		C argType;
		
		switch (opcode) {
			
		case PLUS:
		case TIMES:
			argType = args.get(0).getType();
			
			return TypeUtil.commonSuperType(problemObject, env, argType, sourceType);
		case DIVIDE:
			argType = args.get(0).getType();
			
			// assert the relationship between the types
			TypeUtil.commonSuperType(problemObject, env, argType, sourceType);
			return stdlib.getReal();
		case MINUS:
			// unary minus
			if (args == null || args.size() == 0) {
                return sourceType;
            }
			
			argType = args.get(0).getType();
			return TypeUtil.commonSuperType(problemObject, env, argType, sourceType);
		case GREATER_THAN:
		case LESS_THAN:
		case GREATER_THAN_EQUAL:
		case LESS_THAN_EQUAL:
		case IMPLIES:
		case XOR:
		case NOT:
		case AND:
		case OR:
			return stdlib.getBoolean();			
		case MIN:
		case MAX:
		case ABS:
		case DIV:
		case MOD:
		case SUBSTRING:
		case CONCAT:
			return sourceType;
		case FLOOR:
		case TO_INTEGER:
		case SIZE:
		case ROUND:
			return stdlib.getInteger(); 
		case TO_REAL:
			return stdlib.getReal();
		case TO_LOWER:
		case TO_UPPER:
			return stdlib.getString();
		}
		
		// must be an operation defined for all types, then
		return getAnyTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
	}		
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link BagType}s.
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getBagTypeResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();
		OCLFactory oclFactory = env.getOCLFactory();
		
		C argType;
		CollectionType<C, O> otherType;
		C argElementType;
		
		BagType<C, O> bagType = (BagType<C, O>) sourceType;
		C elemType = bagType.getElementType();
		
		switch (opcode) {
			
		case EQUAL:
		case NOT_EQUAL:
			return stdlib.getBoolean();
		case UNION:
			argType = args.get(0).getType(); 
			otherType =	(CollectionType<C, O>) argType;
			
			argElementType = otherType.getElementType();
			return getBagType(env, oclFactory,
					TypeUtil.commonSuperType(problemObject, env, elemType, argElementType));	
		case INCLUDING:
			argType = args.get(0).getType();			 
			return getBagType(env, oclFactory,
					TypeUtil.commonSuperType(problemObject, env, elemType, argType));
		case INTERSECTION:
			argType = args.get(0).getType(); 
			otherType =	(CollectionType<C, O>) argType;
			argElementType = otherType.getElementType();
			
			if (otherType instanceof SetType) {
				return getSetType(env, oclFactory,
						TypeUtil.commonSuperType(problemObject, env, elemType, argElementType));				
			} else {
				return getBagType(env, oclFactory,
						TypeUtil.commonSuperType(problemObject, env, elemType, argElementType));
			}
		case EXCLUDING:
			return sourceType;
		case COUNT:
			return stdlib.getInteger();
		case  FLATTEN:
			if (!(elemType instanceof CollectionType)) {
				return sourceType;
			}
			
			return getBagType(env, oclFactory,
			        CollectionUtil.getFlattenedElementType(bagType));
		case AS_BAG:
			return sourceType;
		case AS_SEQUENCE:
			return getSequenceType(env, oclFactory, elemType);
		case AS_SET:
			return  getSetType(env, oclFactory, elemType);
		case AS_ORDERED_SET:
			return getOrderedSetType(env, oclFactory, elemType);
        case SELECT:
        case REJECT:
        	return sourceType;
        case SORTED_BY:
        	return getSequenceType(env, oclFactory, elemType);
        case COLLECT_NESTED:
        	return getBagType(env, oclFactory, stdlib.getT2());
		}
	
		return getCollectionTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
	}
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link SetType}s.
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getSetTypeResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();
		OCLFactory oclFactory = env.getOCLFactory();
		
		C argType;
		CollectionType<C, O> otherType;
		C argElementType;
		
		SetType<C, O> setType = (SetType<C, O>) sourceType;
		C elemType = setType.getElementType();
		
		switch (opcode) {
			
		case EQUAL:
		case NOT_EQUAL:
			return stdlib.getBoolean();
			
		case UNION:  
			argType = args.get(0).getType(); 
			otherType =	(CollectionType<C, O>) argType;
			argElementType = otherType.getElementType();
			
			C newElementType = TypeUtil.commonSuperType(problemObject, env, elemType, argElementType);
			
			C resultType;
			if (argType instanceof BagType) {
				resultType = getBagType(env, oclFactory, newElementType);
			} else {
				resultType = getSetType(env, oclFactory, newElementType);
			}
			
			return resultType;
			
		case MINUS:
		case SYMMETRIC_DIFFERENCE:
			argType = args.get(0).getType(); 
			otherType =	(CollectionType<C, O>) argType;
			argElementType = otherType.getElementType();
			
			resultType = getSetType(env, oclFactory,
					TypeUtil.commonSuperType(problemObject, env, elemType, argElementType));
			return resultType;
			
		case INCLUDING:
			argType = args.get(0).getType();
			resultType = getSetType(env, oclFactory,
					TypeUtil.commonSuperType(problemObject, env, elemType, argType));
			return resultType;	
			
		case INTERSECTION:
			argType = args.get(0).getType(); 
			otherType =	(CollectionType<C, O>) argType;
			argElementType = otherType.getElementType();
			
			resultType = getSetType(env, oclFactory,
					TypeUtil.commonSuperType(problemObject, env, elemType, argElementType));
            
            // both variants in both set and bag return the source type
			return sourceType;
			
		case EXCLUDING:
			return sourceType;
		case COUNT:
			return stdlib.getInteger();
		case FLATTEN:
			if (!(elemType instanceof CollectionType)) {
				return sourceType;
			}
			
			resultType = getSetType(env, oclFactory,
			        CollectionUtil.getFlattenedElementType(setType));
			
			return resultType;
		case AS_BAG:
			return getBagType(env, oclFactory, elemType);
		case AS_SEQUENCE:
			return getSequenceType(env, oclFactory, elemType);
		case AS_SET:
			return  sourceType;
		case AS_ORDERED_SET:
			return getOrderedSetType(env, oclFactory, elemType);
        case SELECT:
        case REJECT:
        	return sourceType;
        case SORTED_BY:
        	return getOrderedSetType(env, oclFactory, elemType);
        case COLLECT_NESTED:
        	return getBagType(env, oclFactory, stdlib.getT2());
		}
	
		return getCollectionTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
	}
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link OrderedSetType}s.
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getOrderedSetTypeResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();
		OCLFactory oclFactory = env.getOCLFactory();
		
		C argType;
		
		OrderedSetType<C, O> setType = (OrderedSetType<C, O>) sourceType;
		C elemType = setType.getElementType();
		
		switch (opcode) {
			
		case EQUAL:
		case NOT_EQUAL:
			return stdlib.getBoolean();
			
		case INDEX_OF:
			return stdlib.getInteger();
		
		case APPEND:
		case PREPEND:
			argType = args.get(0).getType(); 
			
			return getOrderedSetType(env, oclFactory,
					TypeUtil.commonSuperType(problemObject, env, elemType, argType));
			
		case INSERT_AT:
			argType = args.get(1).getType(); // arg 0 is the index
			
			return getOrderedSetType(env, oclFactory,
					TypeUtil.commonSuperType(problemObject, env, elemType, argType));
			
		case SUB_ORDERED_SET:
			return sourceType;
		
		case AT:
		case FIRST:
		case LAST:
			return elemType;
			
		case AS_SET:
			return getSetType(env, oclFactory, elemType);
		case AS_BAG:
			return getBagType(env, oclFactory, elemType);
		case AS_SEQUENCE:
			return getSequenceType(env, oclFactory, elemType);				
		}
		
		return getSetTypeResultTypeOf(problemObject,
				env,
				getSetType(env, oclFactory, elemType),
				opcode,
				args);
	}
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link SequenceType}s.
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getSequenceTypeResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();
		OCLFactory oclFactory = env.getOCLFactory();
		
		C argType;
		CollectionType<C, O> otherType;
		C argElementType;
		
		SequenceType<C, O> seqType = (SequenceType<C, O>) sourceType;
		C elemType = seqType.getElementType();
		
		switch (opcode) {

			case COUNT:
			case INDEX_OF:
				return stdlib.getInteger();
			case EQUAL:
			case NOT_EQUAL:
				return stdlib.getBoolean();
			case UNION:
				argType = args.get(0).getType(); 
				otherType =	(CollectionType<C, O>) argType;
				argElementType = otherType.getElementType();
				
				return getSequenceType(env, oclFactory,
						TypeUtil.commonSuperType(problemObject, env, elemType, argElementType));
			case INCLUDING:
			case APPEND:
			case PREPEND:
				argType = args.get(0).getType();
				
				return getSequenceType(env, oclFactory,
						TypeUtil.commonSuperType(problemObject, env, elemType, argType));
			case INSERT_AT:
				argType = args.get(1).getType(); // arg 0 is the index
				
				return getSequenceType(env, oclFactory,
						TypeUtil.commonSuperType(problemObject, env, elemType, argType));
			case EXCLUDING:
				return sourceType;
			case FLATTEN:
				if (!(elemType instanceof CollectionType)) {
					return sourceType;
				}
				
				return getSequenceType(env, oclFactory,
				        CollectionUtil.getFlattenedElementType(seqType));
			case AT:
			case FIRST:
			case LAST:
				return elemType;
			case AS_BAG:
				return getBagType(env, oclFactory, elemType);
			case AS_SEQUENCE:
			case SUB_SEQUENCE:
				return sourceType;
			case AS_SET:
				return getSetType(env, oclFactory, elemType);
			case AS_ORDERED_SET:
				return getOrderedSetType(env, oclFactory, elemType);
	        case SELECT:
	        case REJECT:
	        case SORTED_BY:
	        	return sourceType;
	        case COLLECT_NESTED:
	        	return getSequenceType(env, oclFactory, stdlib.getT2());
		}
	
		return getCollectionTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
	}
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the general {@link CollectionType}s.
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getCollectionTypeResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();
		
		C argType;
		CollectionType<C, O> collType = (CollectionType<C, O>) sourceType;
		
        switch (opcode) {
        case SIZE:
        case COUNT:
            return stdlib.getInteger();
        case INCLUDES:
        case EXCLUDES:
        case INCLUDES_ALL:
        case EXCLUDES_ALL:
        case IS_EMPTY:
        case NOT_EMPTY:
        case EQUAL:
        case NOT_EQUAL:
            return stdlib.getBoolean();
        case SUM:
            C type = collType.getElementType();
            if (type != stdlib.getReal() && type != stdlib.getInteger()) {
                String message = OCLMessages.SumOperator_ERROR_;
                error(env, message, "collectionTypeResultTypeOf", problemObject); //$NON-NLS-1$
				return null;
            }
            return type;
        case PRODUCT:
            /*
             * The result type is: Set(Tuple(first:T, second:T2) where T is the
             * elementType of the source, and T2 is the elementType of the argument.
             */
            C t = collType.getElementType();
            argType = args.get(0).getType();
            C t2 = ((CollectionType<C, O>) argType).getElementType();
            
            OCLFactory oclFactory = env.getOCLFactory();
            
            return getSetType(env, oclFactory,
					getTupleType(env, oclFactory, createTupleParts(env, t, t2)));
        case EXISTS:
        case FOR_ALL:
        case IS_UNIQUE:
        case ONE:
        	return stdlib.getBoolean();
        case ANY:
        	return collType.getElementType();
        case COLLECT:
        	return getCollectionType(env, env.getOCLFactory(), stdlib.getT2());
        case CLOSURE:
        	return getSetType(env, env.getOCLFactory(), stdlib.getT2());
        }
        
        String message = OCLMessages.bind(
        		OCLMessages.CollectionType_ERROR_,
                collType.getName(),
                getOperationName(opcode));
        error(env, message, "collectionTypeResultTypeOf", problemObject); //$NON-NLS-1$
        return null;
	}
    
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
    EList<Variable<C, PM>> createTupleParts(
    		Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
    		C firstType, C secondType) {
		
    	EList<Variable<C, PM>> result = new BasicEList<Variable<C, PM>>();
    	
    	UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
    	OCLFactory oclFactory = env.getOCLFactory();
    	
    	Variable<C, PM> var = oclFactory.createVariable();
    	uml.setName(var, PRODUCT_FIRST);
    	uml.setType(var, firstType);
    	result.add(var);
    	
    	var = oclFactory.createVariable();
    	uml.setName(var, PRODUCT_SECOND);
    	uml.setType(var, secondType);
    	result.add(var);
    	
    	return result;
    }
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link TypeType}s.
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getTypeTypeResultTypeOf(Object problemObject, 
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		switch (opcode) {
			case ALL_INSTANCES:
				return getSetType(env, env.getOCLFactory(),
						((TypeType<C, O>) sourceType).getReferredType());
		}
		
		return getAnyTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
	}		
	
    /**
     * Helper for the {@link #getResultTypeOf(Environment, Object, int, List)}
     * dealing with the {@link MessageType}s.
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getMessageTypeResultTypeOf(Object problemObject,
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			C sourceType, int opcode, List<? extends TypedElement<C>> args) {

		OCLStandardLibrary<C> stdlib =
			env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
		switch (opcode) {
			case HAS_RETURNED:
			case IS_SIGNAL_SENT:
			case IS_OPERATION_CALL:
				return stdlib.getBoolean();
			case RESULT:
				MessageType<C, O, P> mtype =
					(MessageType<C, O, P>) sourceType;
				
				return (mtype.getReferredOperation() == null) ? (C) stdlib
                    .getInvalid() : TypeUtil.resolveType(env, uml
                    .getOCLType(mtype.getReferredOperation()));
			}
		
		return getAnyTypeResultTypeOf(problemObject, env, sourceType, opcode, args);
	}		

	
	//
	// Factories of standard library operations
	//
	
	private static final int ANY_OPERATION_COUNT = 9;
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createAnyOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT);
			
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			EQUAL_NAME, stdlib.getOclAny(), "object")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			NOT_EQUAL_NAME, stdlib.getOclAny(), "object")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getT(),
			OCL_AS_TYPE_NAME, stdlib.getOclType(), "typespec")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			OCL_IS_KIND_OF_NAME, stdlib.getOclType(), "typespec"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			OCL_IS_TYPE_OF_NAME, stdlib.getOclType(), "typespec"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml, stdlib.getBoolean(),
			OCL_IS_UNDEFINED_NAME));
		result.add(createUnaryOperation(uml, stdlib.getBoolean(),
			OCL_IS_INVALID_NAME));
		result.add(createUnaryOperation(uml, stdlib.getBoolean(),
			OCL_IS_NEW_NAME));
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			OCL_IS_IN_STATE_NAME, stdlib.getState(), "statespec")); //$NON-NLS-1$
		
		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>OclAny</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>OclAny</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>OclAny</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createAnyTypeOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 4);
		
		result.addAll(createAnyOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_EQUAL_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_EQUAL_NAME, stdlib.getT(), "object"));//$NON-NLS-1$

		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>OclType</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>OclType</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>OclType</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createTypeTypeOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 1);
		
		result.addAll(createAnyOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
		
		result.add(createUnaryOperation(env.getUMLReflection(), stdlib.getSet(),
			ALL_INSTANCES_NAME));

		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>OclMessage</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>OclMessage</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>OclMessage</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createMessageTypeOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 4);
		
		result.addAll(createAnyOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
		result.add(createUnaryOperation(uml, stdlib.getBoolean(),
			HAS_RETURNED_NAME));
		result.add(createUnaryOperation(uml, stdlib.getT(),
			RESULT_NAME));
		result.add(createUnaryOperation(uml, stdlib.getBoolean(),
			IS_SIGNAL_SENT_NAME));
		result.add(createUnaryOperation(uml, stdlib.getBoolean(),
			IS_OPERATION_CALL_NAME));

		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>String</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>String</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>String</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createStringOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 11);
		
		result.addAll(createAnyOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_NAME, stdlib.getString(), "s"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_NAME, stdlib.getString(), "s"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_EQUAL_NAME, stdlib.getString(), "s"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_EQUAL_NAME, stdlib.getString(), "s"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml, stdlib.getInteger(),
			SIZE_NAME));
		result.add(createBinaryOperation(uml, stdlib.getString(),
			CONCAT_NAME, stdlib.getString(), "s"));//$NON-NLS-1$
		result.add(createTernaryOperation(uml, stdlib.getString(),
			SUBSTRING_NAME, stdlib.getInteger(), "lower", stdlib.getInteger(), "upper"));//$NON-NLS-1$ //$NON-NLS-2$
		result.add(createUnaryOperation(uml, stdlib.getInteger(),
			TO_INTEGER_NAME));
		result.add(createUnaryOperation(uml, stdlib.getReal(),
			TO_REAL_NAME));
		result.add(createUnaryOperation(uml, stdlib.getString(),
			TO_LOWER_NAME));
		result.add(createUnaryOperation(uml, stdlib.getString(),
			TO_UPPER_NAME));
		
		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>Real</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Real</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>Real</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createRealOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 14);
		
		result.addAll(createAnyOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_NAME, stdlib.getReal(), "r"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_NAME, stdlib.getReal(), "r"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_EQUAL_NAME, stdlib.getReal(), "r"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_EQUAL_NAME, stdlib.getReal(), "r"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getReal(),
			PLUS_NAME, stdlib.getReal(), "r")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getReal(),
			MINUS_NAME, stdlib.getReal(), "r"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml, stdlib.getReal(),
			MINUS_NAME));
		result.add(createBinaryOperation(uml, stdlib.getReal(),
			TIMES_NAME, stdlib.getReal(), "r"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getReal(),
			DIVIDE_NAME, stdlib.getReal(), "r"));	//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getReal(),
			MIN_NAME, stdlib.getReal(), "r"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getReal(),
			MAX_NAME, stdlib.getReal(), "r")); //$NON-NLS-1$
		result.add(createUnaryOperation(uml, stdlib.getReal(),
			ABS_NAME));
		result.add(createUnaryOperation(uml, stdlib.getInteger(),
			FLOOR_NAME));
		result.add(createUnaryOperation(uml, stdlib.getInteger(),
			ROUND_NAME));
		
		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>Integer</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Integer</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>Integer</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createIntegerOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 20);
		
		result.addAll(createRealOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_NAME, stdlib.getInteger(), "i"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_NAME, stdlib.getInteger(), "i"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			LESS_THAN_EQUAL_NAME, stdlib.getInteger(), "i"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			GREATER_THAN_EQUAL_NAME, stdlib.getInteger(), "i"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getInteger(),
			DIV_NAME, stdlib.getInteger(), "i"));	//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getInteger(),
			MOD_NAME, stdlib.getInteger(), "i")); //$NON-NLS-1$
		
		return result;
	}
    
    /**
     * Utility method creating the operations of the <code>UnlimitedNatural</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Integer</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>UnlimitedNatural</code> operations
     */
    public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
    List<O> createUnlimitedNaturalOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
        List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 20);
        
        result.addAll(createRealOperations(env));
        
        OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

        result.add(createBinaryOperation(uml, stdlib.getBoolean(),
            LESS_THAN_NAME, stdlib.getUnlimitedNatural(), "n"));//$NON-NLS-1$
        result.add(createBinaryOperation(uml, stdlib.getBoolean(),
            GREATER_THAN_NAME, stdlib.getUnlimitedNatural(), "n"));//$NON-NLS-1$
        result.add(createBinaryOperation(uml, stdlib.getBoolean(),
            LESS_THAN_EQUAL_NAME, stdlib.getUnlimitedNatural(), "n"));//$NON-NLS-1$
        result.add(createBinaryOperation(uml, stdlib.getBoolean(),
            GREATER_THAN_EQUAL_NAME, stdlib.getUnlimitedNatural(), "n"));//$NON-NLS-1$
        result.add(createBinaryOperation(uml, stdlib.getInteger(),
            DIV_NAME, stdlib.getUnlimitedNatural(), "n"));   //$NON-NLS-1$
        result.add(createBinaryOperation(uml, stdlib.getInteger(),
            MOD_NAME, stdlib.getUnlimitedNatural(), "n")); //$NON-NLS-1$
        
        return result;
    }
	
    /**
     * Utility method creating the operations of the <code>Boolean</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Boolean</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>Boolean</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createBooleanOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(ANY_OPERATION_COUNT + 5);
		
		result.addAll(createAnyOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

		result.add(createUnaryOperation(uml, stdlib.getBoolean(),
			NOT_NAME));
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			AND_NAME, stdlib.getBoolean(), "b")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			OR_NAME, stdlib.getBoolean(), "b"));	//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			IMPLIES_NAME, stdlib.getBoolean(), "b"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
			XOR_NAME, stdlib.getBoolean(), "b"));//$NON-NLS-1$
		
		return result;
	}
	
    private static final int COLLECTION_OPERATION_COUNT = 10;
    
    /**
     * Utility method creating the operations of the <code>Collection(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Collection(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>Collection(T)</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createCollectionOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(COLLECTION_OPERATION_COUNT);
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

    	result.add(createBinaryOperation(uml,
	            stdlib.getInteger(),
	            COUNT_NAME, stdlib.getT(), "object")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml,
	            stdlib.getBoolean(),
	            EXCLUDES_NAME, stdlib.getT(), "object")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml,
	            stdlib.getBoolean(),
	            EXCLUDES_ALL_NAME, stdlib.getCollection(), "c2"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml,
	            stdlib.getBoolean(),
	            INCLUDES_NAME, stdlib.getT(), "object")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml,
	            stdlib.getBoolean(),
	            INCLUDES_ALL_NAME, stdlib.getCollection(), "c2"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml,
	            stdlib.getBoolean(),
	            IS_EMPTY_NAME));
		result.add(createUnaryOperation(uml,
				stdlib.getBoolean(),
	            NOT_EMPTY_NAME));
		
        OCLFactory oclFactory = env.getOCLFactory();
        C resultType = getSetType(env, oclFactory,
        		getTupleType(env, oclFactory,
        				createTupleParts(env, stdlib.getT(), stdlib.getT2())));
		result.add(createBinaryOperation(uml,
	    		resultType,
	    		PRODUCT_NAME, getCollectionType(env, oclFactory, stdlib.getT2()), "c2"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml,
	            stdlib.getReal(),
	            SUM_NAME));
		result.add(createUnaryOperation(uml,
	            stdlib.getInteger(),
	            SIZE_NAME));
		
		return result;
	}
	
    private static final int SET_OPERATION_COUNT = COLLECTION_OPERATION_COUNT + 15;
    
    /**
     * Utility method creating the operations of the <code>Set(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Set(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>Set(T)</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createSetOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(SET_OPERATION_COUNT);
		
		result.addAll(createCollectionOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				EQUAL_NAME, stdlib.getSet(), "set"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				NOT_EQUAL_NAME, stdlib.getSet(), "set")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBag(),
				UNION_NAME, stdlib.getBag(), "bag")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getSet(),
				UNION_NAME, stdlib.getSet(), "set"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getSet(),
				MINUS_NAME, stdlib.getSet(), "set"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getSet(),
				INTERSECTION_NAME, stdlib.getBag(), "bag"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getSet(),
				INTERSECTION_NAME, stdlib.getSet(), "set"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getSet(),
				INCLUDING_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getSet(),
				EXCLUDING_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getSet(),
				SYMMETRIC_DIFFERENCE_NAME, stdlib.getSet(), "s"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml,
				getSetType(env, env.getOCLFactory(), stdlib.getT2()),
				FLATTEN_NAME));
		result.add(createUnaryOperation(uml, stdlib.getBag(),
				AS_BAG_NAME));
		result.add(createUnaryOperation(uml, stdlib.getSet(),
				AS_SET_NAME));
		result.add(createUnaryOperation(uml, stdlib.getSequence(),
				AS_SEQUENCE_NAME));
		result.add(createUnaryOperation(uml, stdlib.getOrderedSet(),
				AS_ORDERED_SET_NAME));
		
		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>OrderedSet(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>OrderedSet(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>OrderedSet(T)</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createOrderedSetOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(SET_OPERATION_COUNT + 10);
		
		result.addAll(createSetOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				EQUAL_NAME, stdlib.getOrderedSet(), "s"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				NOT_EQUAL_NAME, stdlib.getOrderedSet(), "s"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getOrderedSet(),
				APPEND_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getT(),
				AT_NAME, stdlib.getInteger(), "index"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getInteger(),
				INDEX_OF_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createTernaryOperation(uml, stdlib.getOrderedSet(),
				INSERT_AT_NAME, stdlib.getInteger(), "index", //$NON-NLS-1$
				stdlib.getT(), "object"));	//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getOrderedSet(),
				PREPEND_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createTernaryOperation(uml, stdlib.getOrderedSet(),
				SUB_ORDERED_SET_NAME, stdlib.getInteger(), "lower", //$NON-NLS-1$
				stdlib.getInteger(), "upper"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml, stdlib.getT(),
				FIRST_NAME));
		result.add(createUnaryOperation(uml, stdlib.getT(),
				LAST_NAME));
		
		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>Bag(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Bag(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>Bag(T)</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createBagOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(COLLECTION_OPERATION_COUNT + 13);
		
		result.addAll(createCollectionOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();

		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				EQUAL_NAME, stdlib.getBag(), "bag"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				NOT_EQUAL_NAME, stdlib.getBag(), "bag")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBag(),
				UNION_NAME, stdlib.getBag(), "bag")); //$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBag(),
				UNION_NAME, stdlib.getSet(), "set"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBag(),
				INTERSECTION_NAME, stdlib.getBag(), "bag"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBag(),
				INTERSECTION_NAME, stdlib.getSet(), "set"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBag(),
				INCLUDING_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createBinaryOperation(uml, stdlib.getBag(),
				EXCLUDING_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
		result.add(createUnaryOperation(uml,
				getBagType(env, env.getOCLFactory(), stdlib.getT2()),
				FLATTEN_NAME));
		result.add(createUnaryOperation(uml, stdlib.getBag(),
				AS_BAG_NAME));
		result.add(createUnaryOperation(uml, stdlib.getSet(),
				AS_SET_NAME));
		result.add(createUnaryOperation(uml, stdlib.getSequence(),
				AS_SEQUENCE_NAME));
		result.add(createUnaryOperation(uml, stdlib.getOrderedSet(),
				AS_ORDERED_SET_NAME));
		
		return result;
	}
	
    /**
     * Utility method creating the operations of the <code>Sequence(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Sequence(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the standard
     *     <code>Sequence(T)</code> operations
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createSequenceOperations(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(COLLECTION_OPERATION_COUNT + 18);
		
		result.addAll(createCollectionOperations(env));
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
		result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				EQUAL_NAME, stdlib.getSequence(), "s"));//$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				NOT_EQUAL_NAME, stdlib.getSequence(), "s")); //$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getSequence(),
				UNION_NAME, stdlib.getSequence(), "s")); //$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				APPEND_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				PREPEND_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
			result.add(createTernaryOperation(uml, stdlib.getBoolean(),
				INSERT_AT_NAME, stdlib.getInteger(), "index", //$NON-NLS-1$
				stdlib.getT(), "object"));//$NON-NLS-1$
			result.add(createTernaryOperation(uml, stdlib.getBoolean(),
				SUB_SEQUENCE_NAME, stdlib.getInteger(), "lower", //$NON-NLS-1$
				stdlib.getInteger(), "upper"));//$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getT(),
				AT_NAME, stdlib.getInteger(), "index")); //$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getInteger(),
				INDEX_OF_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				INCLUDING_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
			result.add(createBinaryOperation(uml, stdlib.getBoolean(),
				EXCLUDING_NAME, stdlib.getT(), "object"));//$NON-NLS-1$
			result.add(createUnaryOperation(uml, stdlib.getT(),
				FIRST_NAME));
			result.add(createUnaryOperation(uml, stdlib.getT(),
				LAST_NAME));
			result.add(createUnaryOperation(uml,
					getSequenceType(env, env.getOCLFactory(), stdlib.getT2()),
				FLATTEN_NAME));
			result.add(createUnaryOperation(uml, stdlib.getBag(),
				AS_BAG_NAME));
			result.add(createUnaryOperation(uml, stdlib.getSet(),
				AS_SET_NAME));
			result.add(createUnaryOperation(uml, stdlib.getBoolean(),
				AS_SEQUENCE_NAME));
			result.add(createUnaryOperation(uml, stdlib.getOrderedSet(),
				AS_ORDERED_SET_NAME));
		
		return result;
	}
	
	private static final int COLLECTION_ITERATOR_COUNT = 7;
    
    /**
     * Utility method creating the pre-defined iterators of the <code>Collection(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Collection(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the pre-defined iterators
     *     of the <code>Collection(T)</code> type
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createCollectionIterators(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(COLLECTION_ITERATOR_COUNT);
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
    	result.add(createBinaryOperation(uml, 
                stdlib.getBoolean(),
                EXISTS_NAME,
                stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getBoolean(),
                FOR_ALL_NAME,
                stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getBoolean(),
                IS_UNIQUE_NAME,
                stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getBoolean(),
                ONE_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getT(),
                ANY_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
    			getCollectionType(env, env.getOCLFactory(), stdlib.getT2()),
                COLLECT_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
    			getSetType(env, env.getOCLFactory(), stdlib.getT2()),
                CLOSURE_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$

		return result;
	}	
	
	private static final int SET_ITERATOR_COUNT = COLLECTION_ITERATOR_COUNT + 4;
    
    /**
     * Utility method creating the pre-defined iterators of the <code>Set(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Set(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the pre-defined iterators
     *     of the <code>Set(T)</code> type
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createSetIterators(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(SET_ITERATOR_COUNT);
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
		
		result.addAll(createCollectionIterators(env));
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
    	result.add(createBinaryOperation(uml, 
                stdlib.getSet(),
                SELECT_NAME,
                stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getSet(),
                REJECT_NAME,
                stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getOrderedSet(),
                SORTED_BY_NAME,
                stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
    			getBagType(env, env.getOCLFactory(), stdlib.getT2()),
                COLLECT_NESTED_NAME,
                stdlib.getOclExpression(), "expr")); //$NON-NLS-1$

		return result;
	}	
	
    /**
     * Utility method creating the pre-defined iterators of the <code>OrderedSet(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>OrderedSet(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the pre-defined iterators
     *     of the <code>OrderedSet(T)</code> type
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createOrderedSetIterators(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(SET_ITERATOR_COUNT);
		
		result.addAll(createSetIterators(env));

		return result;
	}	
	
    /**
     * Utility method creating the pre-defined iterators of the <code>Bag(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Bag(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the pre-defined iterators
     *     of the <code>Bag(T)</code> type
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createBagIterators(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(COLLECTION_ITERATOR_COUNT + 4);
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
		
		result.addAll(createCollectionIterators(env));
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
    	result.add(createBinaryOperation(uml, 
                stdlib.getBag(),
                SELECT_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getBag(),
                REJECT_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getSequence(),
                SORTED_BY_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
    			getBagType(env, env.getOCLFactory(), stdlib.getT2()),
                COLLECT_NESTED_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$

		return result;
	}	
	
    /**
     * Utility method creating the pre-defined iterators of the <code>Sequence(T)</code>
     * type of the OCL Standard library.  This is useful for implementors of
     * metamodel bindings ({@link Environment}s) to initialize their
     * implementations of the <code>Sequence(T)</code>.
     * 
     * @param env an OCL environment
     * @return a list of new operations representing the pre-defined iterators
     *     of the <code>Sequence(T)</code> type
     */
	public static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	List<O> createSequenceIterators(Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env) {
		List<O> result = new java.util.ArrayList<O>(COLLECTION_ITERATOR_COUNT + 4);
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        UMLReflection<PK, C, O, P, EL, PM, ?, COA, SSA, CT> uml = env.getUMLReflection();
		
		result.addAll(createCollectionIterators(env));
		
    	result.add(createBinaryOperation(uml, 
                stdlib.getSequence(),
                SELECT_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getSequence(),
                REJECT_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
                stdlib.getSequence(),
                SORTED_BY_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$
    	
    	result.add(createBinaryOperation(uml, 
    			getSequenceType(env, env.getOCLFactory(), stdlib.getT2()),
                COLLECT_NESTED_NAME, stdlib.getOclExpression(), "expr")); //$NON-NLS-1$

		return result;
	}	
	
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	O createUnaryOperation(
			UMLReflection<PK, C, O, P, EL, PM, ST, COA, SSA, CT> uml,
			C resultType, String name) {
		
		List<String> paramNames = Collections.emptyList();
		List<C> paramTypes = Collections.emptyList();
		
		return uml.createOperation(name, resultType, paramNames, paramTypes);
	}

	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	O createBinaryOperation(
			UMLReflection<PK, C, O, P, EL, PM, ST, COA, SSA, CT> uml,
			C resultType, String name,
			C paramType, String paramName) {
		
		List<String> paramNames = Collections.singletonList(paramName);
		List<C> paramTypes = Collections.singletonList(paramType);
		
		return uml.createOperation(name, resultType, paramNames, paramTypes);
	}

	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	O createTernaryOperation(
			UMLReflection<PK, C, O, P, EL, PM, ST, COA, SSA, CT> uml,
			C resultType, String name,
			C param1Type, String param1Name, C param2Type, String param2Name) {
		
		List<String> paramNames = new java.util.ArrayList<String>(2);
		List<C> paramTypes = new java.util.ArrayList<C>(2);
		
		paramNames.add(param1Name);
		paramTypes.add(param1Type);
		paramNames.add(param2Name);
		paramTypes.add(param2Type);
		
		return uml.createOperation(name, resultType, paramNames, paramTypes);
	}

	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getBagType(
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			OCLFactory factory,
			C elementType) {
		return TypeUtil.resolveType(env, (C) factory.createBagType(elementType)); 
	}

	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getSetType(
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			OCLFactory factory,
			C elementType) {
		return TypeUtil.resolveType(env, (C) factory.createSetType(elementType)); 
	}

	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getOrderedSetType(
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			OCLFactory factory,
			C elementType) {
		return TypeUtil.resolveType(env, (C) factory.createOrderedSetType(elementType)); 
	}

	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getSequenceType(
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			OCLFactory factory,
			C elementType) {
		return TypeUtil.resolveType(env, (C) factory.createSequenceType(elementType)); 
	}

	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getCollectionType(
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			OCLFactory factory,
			C elementType) {
		return TypeUtil.resolveType(env, (C) factory.createCollectionType(elementType)); 
	}

	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E>
	C getTupleType(
			Environment<PK, C, O, P, EL, PM, ST, COA, SSA, CT, CLS, E> env,
			OCLFactory factory,
			List<? extends TypedElement<C>> parts) {
		return TypeUtil.resolveType(env, (C) factory.createTupleType(parts)); 
	}
	
	/**
	 * Convenience method invoking <code>getProblemHandler().utilityProblem</code>
	 * with an error severity.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObject optional object associated with the problem
	 */
	private static void error(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env,
			String problemMessage, String problemContext, Object problemObject) {
		OCLUtil.getAdapter(env, BasicEnvironment.class).utilityError(problemMessage,
			problemContext, problemObject);
	}
    
    /**
     * Convenience method invoking <code>getProblemHandler().utilityProblem</code>
     * with a warning severity.
     * @param problemMessage message describing the problem
     * @param problemContext optional message describing the reporting context
     * @param problemObject optional object associated with the problem
     */
    private static void warning(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env,
            String problemMessage, String problemContext, Object problemObject) {
        BasicEnvironment benv = OCLUtil.getAdapter(env, BasicEnvironment.class);
        if (benv != null) {
            CSTNode cstNode = benv.getASTMapping(problemObject);
            int startOffset = (cstNode != null)? cstNode.getStartOffset() : -1;
            int endOffset = (cstNode != null)? cstNode.getEndOffset() : -1;
            benv.getProblemHandler().utilityProblem(
                ProblemHandler.Severity.WARNING, problemMessage,
                problemContext, startOffset, endOffset);
        }
    }
}

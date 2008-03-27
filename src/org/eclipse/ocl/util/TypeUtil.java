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
 * $Id: TypeUtil.java,v 1.11 2008/03/27 14:43:20 cdamus Exp $
 */
package org.eclipse.ocl.util;

import static org.eclipse.ocl.utilities.UMLReflection.SAME_TYPE;
import static org.eclipse.ocl.utilities.UMLReflection.STRICT_SUBTYPE;
import static org.eclipse.ocl.utilities.UMLReflection.STRICT_SUPERTYPE;
import static org.eclipse.ocl.utilities.UMLReflection.SUBTYPE;
import static org.eclipse.ocl.utilities.UMLReflection.UNRELATED_TYPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Static utilities for introspecting OCL types.
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class's methods. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TypeUtil {
	private static final Set<String> RELATIONAL_OPERATORS;
	
	static {
	    RELATIONAL_OPERATORS = new java.util.HashSet<String>();
        RELATIONAL_OPERATORS.add(PredefinedType.LESS_THAN_NAME);
        RELATIONAL_OPERATORS.add(PredefinedType.LESS_THAN_EQUAL_NAME);
        RELATIONAL_OPERATORS.add(PredefinedType.GREATER_THAN_NAME);
        RELATIONAL_OPERATORS.add(PredefinedType.GREATER_THAN_EQUAL_NAME);
	}
	
	/**
	 * Not instantiable
	 */
	private TypeUtil() {
		super();
	}

    /**
     * Queries whether an operation is defined by the <tt>OclAny</tt> type.
     * 
     * @param env the OCL environment
     * @param operation an operation
     * @return <code>true</code> if it is defined by <tt>OclAny</tt>;
     *     <code>false</code>, otherwise
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean isOclAnyOperation(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			O operation) {
		
		return env.getUMLReflection().getOwningClassifier(operation) instanceof AnyType;
	}

	/**
	 * Finds an operation by signature in the specified classifier.
	 * 
     * @param env the OCL environment
	 * @param owner the classifier to search
	 * @param name the name of the operation
	 * @param args a list of arguments to match against the operation signature,
     *     as either expressions or variables
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	O findOperationMatching(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, String name,
			List<? extends TypedElement<C>> args) {

		if (args == null) {
			args = Collections.emptyList();
		}

        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();
		List<O> operations = getOperations(env, owner);
		
		for (O oper : operations) {
			if (uml.getName(oper).equals(name) &&
					matchArgs(env, owner, uml.getParameters(oper), args)) {
                return oper;
            }

		}
		
		// special handling for null and invalid values, whose types conform
		// to all others
		OCLStandardLibrary<C> lib = env.getOCLStandardLibrary();
		if ((owner == lib.getOclVoid()) || (owner == lib.getInvalid())) {
		    return findOperationForVoidOrInvalid(env, owner, name, args);
		}
		
		return null;
	}
	
	/**
	 * The <tt>OclVoid</tt> and <tt>OclInvalid</tt> types are defined as
	 * conforming to all other types.  Therefore, we can try a little harder
	 * to match certain operations that it is useful to support, such as
	 * <tt>{@literal =}</tt> and <tt>{@literal <>}</tt>.
	 * 
     * @param env the OCL environment
     * @param owner the classifier to search (void or invalid)
     * @param name the name of the operation
     * @param args a list of arguments to match against the operation signature,
     *     as either expressions or variables
     * 
     * @return the matching operation, or <code>null</code> if not found
	 */
    private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    O findOperationForVoidOrInvalid(
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
            C owner, String name,
            List<? extends TypedElement<C>> args) {
        
        O result = null;
        
        if (args.size() == 1) {
            C argType = args.get(0).getType();
            
            if (argType != owner) {
                // let us search the type of the argument to determine whether
                // we can find this operation
                result = findOperationMatching(env, argType, name, args);
            }
        }
        
        return result;
    }


	/**
	 * Find a matching signal in the specified list.
	 * 
     * @param env the OCL environment
	 * @param receiver the type that receives the signal
	 * @param signals the signals to search
	 * @param name name of signal to find
	 * @param args list of arguments to match against the signal signature
	 * 
	 * @return the matching signal, or <code>null</code> if not found
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C findSignalMatching(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C receiver, List<C> signals, String name,
			List<? extends TypedElement<C>> args) {

		if (args == null) {
			args = Collections.emptyList();
		}
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

        for (C signal : signals) {
			if (uml.getName(signal).equals(name)
					&& matchArgs(env, receiver, uml.getAttributes(signal), args)) {
				return signal;
			}
		}
		
		return null;
	}
	
	/**
	 * Obtains all of the OCL operations applicable to the specified owner type,
     * including any that were defined in the OCL environment as additional
     * operations.
	 * 
     * @param env the OCL environment
	 * @param owner the operation owner type
	 * 
	 * @return an unmodifiable list of its operations
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	List<O> getOperations(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner) {
		List<O> result;
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		if (owner instanceof TypeType) {
			@SuppressWarnings("unchecked")
			TypeType<C, O> source = (TypeType<C, O>) owner;
			result = new java.util.ArrayList<O>(source.oclOperations());
			
			// also include the static operations of the referred type
			for (O o : getOperations(env, source.getReferredType())) {
				if (uml.isStatic(o)) {
					result.add(o);
				}
			}
			
			result = Collections.unmodifiableList(result);
		} else {
            if (owner instanceof PredefinedType) {
    			@SuppressWarnings("unchecked")
    			PredefinedType<O> source = (PredefinedType<O>) owner;
    			result = new ArrayList<O>(source.oclOperations());
    			
    			if ((source instanceof AnyType) && !ParsingOptions.getValue(env,
    			        ParsingOptions.USE_COMPARE_TO_OPERATION)) {
        			// exclude the OclAny operations for <, <=, >, >= which should
        			// not be defined for OclAny
    			    for (Iterator<O> iter = result.iterator(); iter.hasNext();) {
    			        if (RELATIONAL_OPERATORS.contains(uml.getName(iter.next()))) {
    			            iter.remove();
    			        }
    			    }
    			}
    		} else {
    			// it's a user type.  Try to convert it to an OCL standard type
    			owner = uml.asOCLType(owner);
    			
    			if (owner instanceof PredefinedType) {
    				@SuppressWarnings("unchecked")
    				PredefinedType<O> pt = (PredefinedType<O>) owner;
    				result = new ArrayList<O>(pt.oclOperations());
    			} else {
    				result = new ArrayList<O>();
    				
    				// Include both the AnyType operations (oclIsKindOf, etc)
    				// and the operations of the class itself.
    				
    				C oclAny = env.getOCLStandardLibrary().getOclAny();
    				
    				result.addAll(uml.getOperations(owner));
    				
    				C implictBaseClassifier = getImplicitRootClass(env);
    				if ((implictBaseClassifier != null) && (implictBaseClassifier != owner)) {
     					result.addAll(uml.getOperations(implictBaseClassifier));
    				}
                    
    				result.addAll(getOperations(env, oclAny));
    			}
            }
            
            List<O> additionalOperations = env.getAdditionalOperations(owner);
            if (additionalOperations != null && !additionalOperations.isEmpty()) {
                result.addAll(additionalOperations);
            }
            
            result = Collections.unmodifiableList(result);
		}
		
		return result;
	}
	
	/**
	 * Obtains the implicit root class specified as an option in the environment, if
	 * it is specified and it is a class.
	 * 
	 * @param env the current environment
	 * @return the implicit root class, if any
	 */
	private static <C> C getImplicitRootClass(Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env) {
	    C result = ParsingOptions.getValue(env, ParsingOptions.implicitRootClass(env));
	    
	    // check that, if there is a value for this option, it is a class
	    if ((result != null) && !env.getUMLReflection().isClass(result)) {
	        result = null;
	    }
	    
	    return result;
	}
	
    /**
     * Obtains all of the OCL attributes applicable to the specified owner type,
     * including any that were defined in the OCL environment as additional
     * attributes.
     * 
     * @param env the OCL environment
     * @param owner the attribute owner type
     * 
     * @return an unmodifiable list of its attributes
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	List<P> getAttributes(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner) {
		List<P> result;
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		if (owner instanceof TypeType) {
			@SuppressWarnings("unchecked")
			TypeType<C, O> source = (TypeType<C, O>) owner;
			result = new java.util.ArrayList<P>();
			
			// include the static properties of the referred type
			for (P p : getAttributes(env, source.getReferredType())) {
				if (uml.isStatic(p)) {
					result.add(p);
				}
			}
			
			result = Collections.unmodifiableList(result);
		} else {
            if (owner instanceof PredefinedType) {
                result = new java.util.ArrayList<P>(uml.getAttributes(owner));
            } else {
                // it's a user type.  Try to convert it to an OCL standard type
                owner = uml.asOCLType(owner);
                
                if (owner instanceof PredefinedType) {
                    result = new java.util.ArrayList<P>(uml.getAttributes(owner));
                } else {
                    result = new ArrayList<P>();
                    
                    // Include both the AnyType properties defined by users as
                    // additional attributes and the properties of the class
                    // itself.
                    
                    C oclAny = env.getOCLStandardLibrary().getOclAny();
                    
                    result.addAll(uml.getAttributes(owner));
                    
                    C implictBaseClassifier = getImplicitRootClass(env);
                    if ((implictBaseClassifier != null) && (implictBaseClassifier != owner)) {
                        result.addAll(uml.getAttributes(implictBaseClassifier));
                    }
                    
                    result.addAll(getAttributes(env, oclAny));
                }
            }
            
            List<P> additionalProperties = env.getAdditionalAttributes(owner);
            if (additionalProperties != null && !additionalProperties.isEmpty()) {
                result.addAll(additionalProperties);
            }
            
            result = Collections.unmodifiableList(result);
		}
		
		return result;
	}

	/**
	 * Compares an actual argument list against the signature of an operation
     * or a signal.
	 * 
     * @param env the OCL environment
	 * @param owner the type that owns the operation
	 * @param params the operation parameters or signal attributes to match
     *     against the arguments
	 * @param args a list of {@link OCLExpression}s or {@link Variable}s
	 * 
	 * @return true or false
	 */
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean matchArgs(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, List<?> paramsOrProperties,
			List<? extends TypedElement<C>> args) {
		int argsize;

		if (args == null) {
            argsize = 0;
        } else {
            argsize = args.size();
        }

		if (paramsOrProperties.size() != argsize) {
            return false;
        }
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		int i = 0;
		for (Object paramOrProperty : paramsOrProperties) {
			TypedElement<C> arg = args.get(i++);
			C argType = arg.getType();
			C popType = resolveType(env, uml.getOCLType(paramOrProperty));
			
			// handle parameters of type OclType
			if (popType instanceof TypeType) {
				if (arg instanceof TypeExp) {
					continue;
				}
				return false;
			}
			
			popType = resolveGenericType(env, owner, popType, argType);
			
			if (popType == env.getOCLStandardLibrary().getT()) {
				// this is a collection operation, and the collection is empty
				//   (element type is OclVoid).  Any argument matches in this
				//   case, because any kind of element can be considered to not
				//   be in an empty collection
				continue;
			}
			
			if ((getRelationship(env, argType, popType) & SUBTYPE) == 0) {
				return false;
			}
		}
		return true;
	}

    /**
     * Resolves the generic type of an operation parameter (where it is
     * <tt>T</tt> or <tt>T2</tt>) against the source type of the operation or
     * the type of the actual argument, as appropriate.
     * 
     * @param env the OCL environment
     * @param owner the operation source type
     * @param paramType the operation parameter type
     * @param argType the actual operation argument type
     * 
     * @return the resolved parameter type
     */
	@SuppressWarnings("unchecked")
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveGenericType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, C paramType, C argType) {
		
		C result = paramType;
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
		
		if (result == stdlib.getT()) {
			// substitute the owner type (or owner's element type in
			//   the case of a collection)
			result = owner;
			if (result instanceof CollectionType) {
				result = ((CollectionType<C, O>) result).getElementType();
				
				if (result == stdlib.getOclVoid()) {
					// special case for empty collections, whose element type is OclVoid.
					//   We want any argument to be accepted, and to solely determine
					//   the element type of the resulting collection
					result = stdlib.getT();
				}
			}
		} else if (result instanceof CollectionType) {
			// handle generic collection operation with parameter of
			//    type <collectionKind>(T)
			CollectionType<C, O> collType = (CollectionType<C, O>) result;
			C elemType = collType.getElementType();
			
			if (elemType == stdlib.getT()) {
				C ownerMatch = owner;
				if (ownerMatch instanceof CollectionType) {
					ownerMatch = ((CollectionType<C, O>) ownerMatch).getElementType();
					
					if (ownerMatch == stdlib.getOclVoid()) {
						// special case for empty collections, whose element type is OclVoid.
						//   We want any argument to be accepted, and to solely determine
						//   the element type of the resulting collection
						ownerMatch = stdlib.getT();
					}
				}
				
				result = resolveCollectionType(env, collType.getKind(), ownerMatch);
			} else if (elemType == env.getOCLStandardLibrary().getT2()) {
				// wildard to match any other collection type
				C argMatch = argType;
				if (argMatch instanceof CollectionType) {
					argMatch = ((CollectionType<C, O>) argMatch)
						.getElementType();
					
					if (argMatch == stdlib.getOclVoid()) {
						// special case for empty collections, whose element type is OclVoid.
						//   We want any argument to be accepted, and to solely determine
						//   the element type of the resulting collection.  Note that we
						//   want T, not T2, because it is our wildcard
						argMatch = stdlib.getT();
					}
				}
				
				result = resolveCollectionType(env, collType.getKind(), argMatch);
			}
		}
		
		return result;
	}
	
    /**
     * Resolves the signature of a generic operation (where it has parameters of
     * type and/or <tt>T</tt> or <tt>T2</tt>) against the source type of the
     * operation, as appropriate.
     * 
     * @param env the OCL environment
     * @param owner the operation source type
     * @param oper the generic operation
     * 
     * @return the resolved parameter type
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	O resolveGenericSignature(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, O oper) {
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		String name = uml.getName(oper);
		List<String> paramNames = new java.util.ArrayList<String>();
		List<C> paramTypes = new java.util.ArrayList<C>();
		
		for (PM param : uml.getParameters(oper)) {
			paramNames.add(uml.getName(param));
			paramTypes.add(resolveGenericType(env,
				owner, resolveType(env, uml.getOCLType(param)), env.getOCLStandardLibrary().getT()));
		}
		
		C resultType = getResultType(oper, env, owner, oper);
		
		return uml.createOperation(name, resultType, paramNames, paramTypes);
	}
	
	/**
     * Gets the type of a property, accounting for the fact that we may be
     * navigating to it from an association class (in which the member ends of
     * an association always have multiplicity 1) or not.
     * 
     * @param env the OCL environment
     * @param owner the source of the navigation of the property, which may
     *     be an association class (the interesting scenario)
     * @param property the property to navigate
     * 
     * @return the effective type of the property, which may not be a
     *    collection type despite its declared multiplicity in the association
     *    class case
	 */
	@SuppressWarnings("unchecked")
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C getPropertyType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner,
			P property) {
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		C result = resolveType(env, uml.getOCLType(property));
		
		if (uml.isAssociationClass(owner)
				&& uml.getMemberEnds(owner).contains(property)) {
			
			// from the perspective of the association class, its ends have
			//   multiplicity 1 regardless of their definition (which is from
			//   the perspective of the classifiers at the ends)
			if (result instanceof CollectionType) {
				result = ((CollectionType<C, O>) result).getElementType();
			}
		}
		
		return result;
	}
	
    /**
     * Obtains the result type of the specified operation, which in the case
     * of collection operations sometimes depends on the element type of the
     * source collection.
     * 
     * @param env the OCL environment
     * @param owner the type of the operation call source
     * @param oper the operation
     * 
     * @return the operation's effect result type
     * 
     * @deprecated Use the {@link #getResultType(Object, Environment, Object, Object)}
     *     method, instead
     */
	@Deprecated
    public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C getResultType(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, O oper) {
		return getResultType(null, env, owner, oper);
	}
	
    /**
     * Obtains the result type of the specified operation, which in the case
     * of collection operations sometimes depends on the element type of the
     * source collection.
     * 
     * @param env the OCL environment
     * @param owner the type of the operation call source
     * @param oper the operation
     * 
     * @return the operation's effect result type
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C getResultType(Object problemObject,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, O oper) {
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		if (owner instanceof PredefinedType) {
			int opcode = OCLStandardLibraryUtil.getOperationCode(uml.getName(oper));
			
			List<PM> parameters = uml.getParameters(oper);
			List<OCLExpression<C>> args = new ArrayList<OCLExpression<C>>(
					parameters.size());
			
			for (PM param : parameters) {
				C paramType = resolveType(env, uml.getOCLType(param));
				
				if (paramType instanceof TypeType) {
					// need a TypeExp
					TypeExp<C> exp = env.getOCLFactory().createTypeExp();
					exp.setReferredType(env.getOCLStandardLibrary().getT());
					uml.setType(exp, paramType);
					args.add(exp);
				} else {
					if (paramType instanceof CollectionType) {
						@SuppressWarnings("unchecked")
						CollectionType<C, O> ct = (CollectionType<C, O>) paramType;
						
						if (ct.getElementType() == env.getOCLStandardLibrary().getT2()) {
							// special handling for the Collection(T2) parameter
							//   of the product collection operation
							paramType = resolveCollectionType(env,
									ct.getKind(),
									env.getOCLStandardLibrary().getT());
						}
					}
					
					// unspecified value expression will do
					UnspecifiedValueExp<C> exp =
						env.getOCLFactory().createUnspecifiedValueExp();
					uml.setType(exp, paramType);
					args.add(exp);
				}
			}
			
			try {
				return OCLStandardLibraryUtil.getResultTypeOf(
					problemObject, env, owner, opcode, args);
			} catch (Exception e) {
				// doesn't matter.  Just return the default
			} finally {
			    // dispose arguments created for the parameters
			    ObjectUtil.dispose(args);
			}
		}
		
		return resolveType(env, uml.getOCLType(oper));
	}
	
    /**
     * Casts a value of one type as another type, if compatible.
     * 
     * @param env the OCL environment
     * @param type1 a type
     * @param type2 another type
     * 
     * @return <code>true</code> if the cast is successful
     * 
     * @throws SemanticException if the cast fails (because the types are
     *    not conformant)
     *    
     * @deprecated Use the {@link #compatibleTypeMatch(Environment, Object, Object)}
     *   method, instead, to check whether the cast is acceptable
     */
	@Deprecated
    public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean type1AsType2(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) throws SemanticException {
		
		if (typeCompare(env, type1, type2) != -1) {
			return true;
		}
		
		String message = OCLMessages.bind(
				OCLMessages.CastTypeMismatch_ERROR_,
				getName(env, type1),
				getName(env, type2));
		throw new SemanticException(message);
	}

	/**
	 * Compare two types. Returns true if types are exactly equal, false otherwise.
	 * 
	 * @param type1 a type
	 * @param type2 another type
	 * @return true if the same type 
 	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean exactTypeMatch(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
	
		switch (getRelationship(env, type1, type2)) {
		case SAME_TYPE:
			return true;
		default:
			return false;
		}
	}

	/**
	 * Compare two types. Returns true if types are compatible, false otherwise.
	 * 
	 * @param type1 a type
	 * @param type2 another type
	 * @return true if the same type or type1 is a strict subtype of type2.
 	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean compatibleTypeMatch(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
	
		switch (getRelationship(env, type1, type2)) {
		case SAME_TYPE:
		case STRICT_SUBTYPE:
			return true;
		default:
			return false;
		}
	}

	/**
	 * Compare two types. Returns 0 if types are exactly equal, -1 if type1
	 * conforms to type2 (type1 is a subtype of type2) 1 if type2 conforms to
	 * type1 (type2 is a subtype of type1).
     * Fails if there is no type conformance.
	 * 
	 * @param type1 a type
	 * @param type2 another type
	 * @return the ordering key
     * 
     * @throws IllegalArgumentException if the types are not conformant one way
     *    or the other
     *    
     * @deprecated Use the {@link #getRelationship(Environment, Object, Object)}
     *    method, instead.
	 */
	@Deprecated
    public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	int typeCompare(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
	
		switch (getRelationship(env, type1, type2)) {
		case SAME_TYPE:
			return 0;
		case STRICT_SUBTYPE:
			return -1;
		case STRICT_SUPERTYPE:
			return 1;
		default:
			String message = OCLMessages.bind(
					OCLMessages.TypeMismatch_ERROR_,
					getName(env, type1),
					getName(env, type2));
			IllegalArgumentException error = new IllegalArgumentException(message);
			OCLPlugin.throwing(TypeUtil.class, "typeCompare", error);//$NON-NLS-1$
			throw error;
		}
	}
	
    /**
     * Checks whether two types are mutually comparable in the determination of
     * the applicability of {@literal =} and {@literal <>} operations.
     * 
     * @param env the OCL environment
     * @param type1 a type
     * @param type2 another type
     * @param opcode the operation code
     * 
     * @throws SemanticException if the types are not comparable
     * 
     * @deprecated Use the {@link #checkMutuallyComparable(Object, Environment, Object, Object, int)}
     *    method, instead
     */
	@Deprecated
    public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void checkMutuallyComparable(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2,
			int opcode) throws SemanticException {
		
		// all of the primitive types are considered as mutually comparable
		if (!(type1 instanceof PrimitiveType && type2 instanceof PrimitiveType)) {
			if (commonSuperType(env, type1, type2) == null) {
				String message = OCLMessages.bind(
					OCLMessages.Noncomforming_ERROR_,
					getName(env, type1),
					OCLStandardLibraryUtil.getOperationName(opcode));
				throw new SemanticException(message);
			}
		}
	}
	
    /**
     * Checks whether two types are mutually comparable in the determination of
     * the applicability of {@literal =} and {@literal <>} operations.
     * 
     * @param env the OCL environment
     * @param type1 a type
     * @param type2 another type
     * @param opcode the operation code
     * 
     * @return false if the types are not comparable
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean checkMutuallyComparable(Object problemObject,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2,
			int opcode) {
		
		// all of the primitive types are considered as mutually comparable
		if (!(type1 instanceof PrimitiveType && type2 instanceof PrimitiveType)) {
			if (commonSuperType(problemObject, env, type1, type2) == null) {
				String message = OCLMessages.bind(
					OCLMessages.Noncomforming_ERROR_,
					getName(env, type1),
					OCLStandardLibraryUtil.getOperationName(opcode));
				error(env, message, "checkMutuallyComparable", problemObject); //$NON-NLS-1$
				return false;
			}
		}
		return true;
	}
	
    /**
     * Queries the relationship, according to generalizations, of two types.
     * This operation accounts for the OCL Standard Library types, which the
     * otherwise similar {@link UMLReflection#getRelationship(Object, Object)}
     * method does not.
     * 
     * @param env the OCL environment
     * @param type1 a type
     * @param type2 another type
     * @return the nature of their hierarchical relationship of
     *     <tt>type1</tt> to <tt>type2</tt>, as enumerated in the
     *     {@link UMLReflection} interface
     * 
     * @see UMLReflection#getRelationship(Object, Object)
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	int getRelationship(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
		
		// simplest case is when the types actually are the same
		if (type1 == type2) {
			return SAME_TYPE;
		}
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
		
		// OclVoid makes for easy cases
		if ((type1 == stdlib.getOclVoid()) && (type2 != stdlib.getInvalid())) {
			return STRICT_SUBTYPE;
		} else if ((type2 == stdlib.getOclVoid()) && (type1 != stdlib.getInvalid())) {
			return STRICT_SUPERTYPE;
		}
		
		// so does OclInvalid
		if (type1 == stdlib.getInvalid()) {
			return STRICT_SUBTYPE;
		} else if (type2 == stdlib.getInvalid()) {
			return STRICT_SUPERTYPE;
		}
		
		// and so does OclAny, also
		if (type1 == stdlib.getOclAny()) {
			return (type2 instanceof CollectionType)? UNRELATED_TYPE : STRICT_SUPERTYPE;
		} else if (type2 == stdlib.getOclAny()) {
			return (type1 instanceof CollectionType)? UNRELATED_TYPE : STRICT_SUBTYPE;
		}
		
		// handle primitive types
		if (type1 instanceof PrimitiveType) {
			if ((type1 == stdlib.getInteger())
                    || (type1 == stdlib.getUnlimitedNatural())) {
				if (type2 == stdlib.getReal()) {
					return STRICT_SUBTYPE;
				}
			} else if (type1 == stdlib.getReal()) {
				if ((type2 == stdlib.getInteger())
                        || (type2 == stdlib.getUnlimitedNatural())) {
					return STRICT_SUPERTYPE;
				}
			}
			
			return UNRELATED_TYPE;
		} else if (type2 instanceof PrimitiveType) {
			// tested all possible primitive type conformances in the other case
			return UNRELATED_TYPE;
		}
		
		// handle collection types
		if (type1 instanceof CollectionType) {
	        if (!(type2 instanceof CollectionType)) {
	        	return UNRELATED_TYPE;
	        }
	        
	        @SuppressWarnings("unchecked")
	        CollectionType<C, O> first = (CollectionType<C, O>) type1;
	        @SuppressWarnings("unchecked")
	        CollectionType<C, O> other = (CollectionType<C, O>) type2;
	        
	        int kindRelationship = getRelationship(
	        		first.getKind(),
	        		other.getKind());
	        
	        if (kindRelationship == UNRELATED_TYPE) {
	        	return kindRelationship;
	        }

	        int elementRelationship = getRelationship(
	        	env,
	        	first.getElementType(),
	            other.getElementType());
	        
	        switch (kindRelationship) {
	        case SAME_TYPE:
	        	return elementRelationship;
	        case STRICT_SUBTYPE:
	        	switch (elementRelationship) {
	        	case SAME_TYPE:
	        	case STRICT_SUBTYPE:
	        		return STRICT_SUBTYPE;
	        	default:
	        		return UNRELATED_TYPE;
	        	}
	        case STRICT_SUPERTYPE:
	        	switch (elementRelationship) {
	        	case SAME_TYPE:
	        	case STRICT_SUPERTYPE:
	        		return STRICT_SUPERTYPE;
	        	default:
	        		return UNRELATED_TYPE;
	        	}
	        default:
	        	return UNRELATED_TYPE;
	        }
		}
		
		if (type1 instanceof MessageType && type2 == stdlib.getOclMessage()) {
			return STRICT_SUBTYPE;
		} else if (type2 instanceof MessageType && type1 == stdlib.getOclMessage()) {
			return STRICT_SUPERTYPE;
		}
		
		if (type1 instanceof TypeType && type2 == stdlib.getOclType()) {
			return STRICT_SUBTYPE;
		} else if (type2 instanceof TypeType && type1 == stdlib.getOclType()) {
			return STRICT_SUPERTYPE;
		}
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		if (type1 instanceof TupleType || type2 instanceof TupleType) {
			if (!((type1 instanceof TupleType) && (type2 instanceof TupleType))) {
				return UNRELATED_TYPE;
			}
			
			List<P> props1 = uml.getAttributes(type1);
			List<P> props2 = uml.getAttributes(type2);
			
			if (props1.size() != props2.size()) {
				return UNRELATED_TYPE;
			}

			int result = SAME_TYPE; // assume properties are the same.

			Iterator<P> iter1 = props1.iterator();
			while (iter1.hasNext()) {
				P prop1 = iter1.next();
				boolean found = false;
				
				Iterator<P> iter2 = props2.iterator();
				while (iter2.hasNext()) {
					P prop2 = iter2.next();
					
					if (uml.getName(prop1).equals(uml.getName(prop2))) {
						/*
						 * The feature types must conform in the same direction.
						 */
						int propResult = TypeUtil.getRelationship(
								env,
								resolveType(env, uml.getOCLType(prop1)),
								resolveType(env, uml.getOCLType(prop2)));
						
						if (result == SAME_TYPE) {
                            result = propResult;
                        } else if (result != propResult) {
							return UNRELATED_TYPE;
						}
						found = true;
						break;
					}
				}
				if (!found) {
					return UNRELATED_TYPE;
				}
			}
			
			return result;
		}

		// exhausted the possibilities for pre-defined types
		if (type1 instanceof PredefinedType || type2 instanceof PredefinedType) {
			return UNRELATED_TYPE;
		}
		
		// remaining case is pure model element types.  The environment must
		//    handle this
		
		int result = uml.getRelationship(type1, type2);
		
		if (result == UNRELATED_TYPE) {
		    // try the implicit root class
            C implictBaseClassifier = getImplicitRootClass(env);
            if ((implictBaseClassifier != null) && uml.isClass(type1) && uml.isClass(type2)) {
                if (type1 == implictBaseClassifier) {
                    result = STRICT_SUPERTYPE;
                } else if (type2 == implictBaseClassifier) {
                    result = STRICT_SUBTYPE;
                }
            }
		}
		
		return result;
	}
    
    /**
     * Get-relationship helper comparing collection kinds.
     */
    static int getRelationship(CollectionKind kind1, CollectionKind kind2) {
    	switch (kind1) {
    	case BAG_LITERAL:
    		switch (kind2) {
    		case BAG_LITERAL:
    			return SAME_TYPE;
    		case COLLECTION_LITERAL:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
    	case SET_LITERAL:
    		switch (kind2) {
    		case SET_LITERAL:
    			return SAME_TYPE;
    		case ORDERED_SET_LITERAL:
    			return STRICT_SUPERTYPE;
    		case COLLECTION_LITERAL:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
	   	case ORDERED_SET_LITERAL:
    		switch (kind2) {
    		case ORDERED_SET_LITERAL:
    			return SAME_TYPE;
    		case SET_LITERAL:
    		case COLLECTION_LITERAL:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
	   	case SEQUENCE_LITERAL:
    		switch (kind2) {
    		case SEQUENCE_LITERAL:
    			return SAME_TYPE;
    		case COLLECTION_LITERAL:
    			return STRICT_SUBTYPE;
    		default:
    			return UNRELATED_TYPE;
    		}
	   	default:
    		switch (kind2) {
    		case COLLECTION_LITERAL:
    			return SAME_TYPE;
    		default:
    			return STRICT_SUPERTYPE;
    		}
    	}
    }

	/**
	 * Get the common supertype of two types.
     * This operation accounts for the OCL Standard Library types, which the
     * otherwise similar {@link UMLReflection#getCommonSuperType(Object, Object)}
     * method does not.
	 * 
	 * @param type1 a type
	 * @param type2 another type
	 * @return their common supertype, if any, null if the two types have no common supertype
     * 
     * @throws SemanticException if the two types have no common supertype
     * 
     * @deprecated Use the {@link #commonSuperType(Object, Environment, Object, Object)}
     *     method, instead.
	 */
	@Deprecated
    public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C commonSuperType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) throws SemanticException {
		
		return commonSuperType(null, env, type1, type2);
	}
	
	/**
	 * Get the common supertype of two types.
     * This operation accounts for the OCL Standard Library types, which the
     * otherwise similar {@link UMLReflection#getCommonSuperType(Object, Object)}
     * method does not.
	 * 
	 * @param type1 a type
	 * @param type2 another type
	 * @return their common supertype, if any, null if the two types have no common supertype
     * 
     * @see UMLReflection#getCommonSuperType(Object, Object)
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C commonSuperType(Object problemObject,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
	
		if (ObjectUtil.equal(type1, type2)) {
			return type2;
		}
		
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
		
		// the generic type T represents the dynamic type against which we
		//    are comparing
		if (type1 == stdlib.getT()) {
			return type2;
		} else if (type2 == stdlib.getT()) {
			return type1;
		}
		
		if ((type1 == stdlib.getOclVoid()) || (type1 == stdlib.getInvalid())) {
            return type2;
        }
		if ((type2 == stdlib.getOclVoid()) || (type2 == stdlib.getInvalid())) {
            return type1;
        }
		
		if (type1 == stdlib.getOclAny() && !(type2 instanceof CollectionType)) {
            return type1;
        }
		if (type2 == stdlib.getOclAny() && !(type1 instanceof CollectionType)) {
            return type2;
        }
	
		if ((type1 == stdlib.getInteger() || type1 == stdlib.getUnlimitedNatural())
                && type2 == stdlib.getReal()) {
            return type2;
        }
        if ((type2 == stdlib.getInteger() || type2 == stdlib.getUnlimitedNatural())
                && type1 == stdlib.getReal()) {
            return type1;
        }
	
		if (type1 instanceof CollectionType && type2 instanceof CollectionType) {
	        @SuppressWarnings("unchecked")
			CollectionType<C, O> ct1 = (CollectionType<C, O>) type1;
			
	        @SuppressWarnings("unchecked")
	        CollectionType<C, O> ct2 = (CollectionType<C, O>) type2;
	        
	        CollectionKind commonKind = commonSuperType(ct1.getKind(), ct2.getKind());
	        
	        C resultElementType = commonSuperType(problemObject,
	        	env, ct1.getElementType(), ct2.getElementType());

	        return resolveCollectionType(env, commonKind, resultElementType);
		}
	
		if (type1 instanceof MessageType && type2 instanceof MessageType) {
			return stdlib.getOclMessage();
		}
		
		if (type1 instanceof TypeType && type2 instanceof TypeType) {
			return stdlib.getOclType();
		}
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();

		if (type1 instanceof TupleType || type2 instanceof TupleType) {
			if (!((type1 instanceof TupleType) && (type2 instanceof TupleType))) {
				String message = OCLMessages.bind(
					OCLMessages.TupleTypeMismatch_ERROR_,
					getName(env, type1),
					getName(env, type2));
				error(env, message, "commonSuperType", problemObject); //$NON-NLS-1$
				return null;
			}
			
			List<P> props1 = uml.getAttributes(type1);
			List<P> props2 = uml.getAttributes(type2);
			
			if (props1.size() != props2.size()) {
				String message = OCLMessages.bind(
						OCLMessages.TupleFieldNumMismatch_ERROR_,
						getName(env, type1),
						getName(env, type2));
				error(env, message, "commonSuperType", problemObject); //$NON-NLS-1$
				return null;
			}

			OCLFactory oclFactory = env.getOCLFactory();
			
			EList<Variable<C, PM>> tupleParts = new BasicEList<Variable<C, PM>>();

			for (P prop1 : props1) {
				boolean found = false;
				
				for (P prop2 : props2) {
					if (uml.getName(prop1).equals(uml.getName(prop2))) {
						C resultElementType = commonSuperType(
							problemObject, env,
							resolveType(env, uml.getOCLType(prop1)),
							resolveType(env, uml.getOCLType(prop2)));
						
						found = true;
						
						Variable<C, PM> var = oclFactory.createVariable();
						uml.setName(var, getName(env, prop1));
						uml.setType(var, resultElementType);
						
						tupleParts.add(var);
						break;
					}
				}
				if (!found) {
					String message = OCLMessages.bind(
							OCLMessages.TupleFieldNotFound_ERROR_,
							new Object[] {
									getName(env, type1),
									getName(env, prop1),
									getName(env, type2)});
					error(env, message, "commonSuperType", problemObject); //$NON-NLS-1$
					return null;
				}
			}
			
			return resolveTupleType(env, tupleParts);
		}
		
		// exhausted the possibilities for pre-defined types
		if (type1 instanceof PredefinedType || type2 instanceof PredefinedType) {
			String message = OCLMessages.bind(OCLMessages.TypeMismatch_ERROR_,
					getName(env, type1),
					getName(env, type2));
			error(env, message, "commonSuperType", problemObject); //$NON-NLS-1$
			return null;
		}
		
		// remaining case is pure model element types.  The environment must
		//    handle this
		
		C result = uml.getCommonSuperType(type1, type2);
	
		if (result == null) {
            C implictBaseClassifier = getImplicitRootClass(env);
            if ((implictBaseClassifier != null) && uml.isClass(type1) && uml.isClass(type2)) {
                result = implictBaseClassifier;
            }
		}
		
		if (result == null) {
			String message = OCLMessages.bind(OCLMessages.TypeMismatch_ERROR_,
					getName(env, type1),
					getName(env, type2));
			error(env, message, "commonSuperType", problemObject); //$NON-NLS-1$
			return null;
		}
		
		return result;
	}
    
    /**
     * Common-supertype helper method for collection kinds
     */
    private static CollectionKind commonSuperType(
    		CollectionKind kind1, CollectionKind kind2) {
    	
    	CollectionKind genericCollectionKind = CollectionKind.COLLECTION_LITERAL;
    	
    	switch (kind1) {
    	case BAG_LITERAL:
    	case SEQUENCE_LITERAL:
    		if (kind2 == kind1) {
	    		return kind1;
    		}
    		
    		return genericCollectionKind;
    	case SET_LITERAL:
    		switch (kind2) {
    		case ORDERED_SET_LITERAL:
    		case SET_LITERAL:
    			return kind1;
    		default:
       			return genericCollectionKind;
    		}
    	case ORDERED_SET_LITERAL:
    		switch (kind2) {
    		case ORDERED_SET_LITERAL:
    		case SET_LITERAL:
    			return kind2;
    		default:
       			return genericCollectionKind;
    		}
    	default:
   			return genericCollectionKind;
    	}
    }
	
	/**
	 * Null-safe alternative to {@link ENamedElement#getName()}.
	 * 
	 * @param element a named element that may be <code>null</code>
	 * @return the element's name, or <code>null</code> if the element is <code>null</code>
	 */
	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	String getName(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			Object element) {
		return (element == null)? null : env.getUMLReflection().getName(element);
	}

	/**
	 * Resolves the specified type against the model-based types defined by
	 * the specified environment's type resolver, for consistency with the
	 * environment (especially for persistence).
	 * 
	 * @param env the OCL environment
	 * @param type the type to resolve
	 * 
	 * @return the environment's corresponding type
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type) {
		
	    return (type != null)? env.getTypeResolver().resolve(type) : type;
	}
	
    /**
     * Resolves a <tt>Set</tt> type against the set types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param elementType the element type of the set type to resolve
     * 
     * @return the environment's corresponding type
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveSetType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return resolveCollectionType(env, CollectionKind.SET_LITERAL, elementType);
	}
	
    /**
     * Resolves a <tt>OrderedSet</tt> type against the types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param elementType the element type of the ordered set type to resolve
     * 
     * @return the environment's corresponding type
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveOrderedSetType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return resolveCollectionType(env, CollectionKind.ORDERED_SET_LITERAL, elementType);
	}
	
    /**
     * Resolves a <tt>Bag</tt> type against the baf types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param elementType the element type of the baf type to resolve
     * 
     * @return the environment's corresponding type
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveBagType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return resolveCollectionType(env, CollectionKind.BAG_LITERAL, elementType);
	}
	
    /**
     * Resolves a <tt>Sequence</tt> type against the sequence types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param elementType the element type of the sequence type to resolve
     * 
     * @return the environment's corresponding type
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveSequenceType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C elementType) {
		
		return resolveCollectionType(env, CollectionKind.SEQUENCE_LITERAL, elementType);
	}
	
    /**
     * Resolves a collection type against the collection types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param kind the collection kind to resolve
     * @param elementType the element type of the collection type to resolve
     * 
     * @return the environment's corresponding type
     */
	@SuppressWarnings("unchecked")
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveCollectionType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			CollectionKind kind, C elementType) {
		
		return (C) env.getTypeResolver().resolveCollectionType(kind, elementType);
	}
	
    /**
     * Resolves a tuple type against the tuple types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param parts the expressions or variables describing the parts of the
     *    tuple type to resolve
     * 
     * @return the environment's corresponding type
     */
	@SuppressWarnings("unchecked")
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveTupleType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			EList<? extends TypedElement<C>> parts) {
		return (C) env.getTypeResolver().resolveTupleType(parts);
	}
	
    /**
     * Resolves a tupe-type against the tupe-types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param type the referred type of the type-type to resolve
     * 
     * @return the environment's corresponding type
     */
	@SuppressWarnings("unchecked")
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveTypeType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type) {
		return (C) env.getTypeResolver().resolveTypeType(type);
	}
	
    /**
     * Resolves an operation message type against the message types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param operation the operation referenced by the message type to resolve
     * 
     * @return the environment's corresponding type
     */
	@SuppressWarnings("unchecked")
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveOperationMessageType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			O operation) {
		return (C) env.getTypeResolver().resolveOperationMessageType(operation);
	}
	
    /**
     * Resolves a signal message type against the message types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param signal the signal referenced by the message type to resolve
     * 
     * @return the environment's corresponding type
     */
	@SuppressWarnings("unchecked")
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C resolveSignalMessageType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C signal) {
		return (C) env.getTypeResolver().resolveSignalMessageType(signal);
	}
	
	/**
	 * Convenience method invoking <code>getProblemHandler().utilityProblem</code>
	 * with a <code>ProblemHandler.errorSeverity</code>.
	 * @param problemMessage message describing the problem
	 * @param problemContext optional message describing the reporting context
	 * @param problemObject optional object associated with the problem
	 */
	private static void error(Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env,
			String problemMessage, String problemContext, Object problemObject) {
		OCLUtil.getAdapter(env, BasicEnvironment.class).utilityError(problemMessage,
			problemContext, problemObject);
	}
}

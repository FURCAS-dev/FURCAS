/**
 * <copyright>
 *
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling
 *   Zeligsoft - Bugs 244886, 245619, 233673, 179990, 242236
 *   Stefan Schulze - Bug 245619
 *   Adolfo Sanchez-Barbudo Herrera - Bug 233673
 * 
 * </copyright>
 * 
 * $Id: TypeUtil.java,v 1.20 2010/05/03 09:32:33 ewillink Exp $
 */
package org.eclipse.ocl.util;

import static org.eclipse.ocl.utilities.UMLReflection.SAME_TYPE;
import static org.eclipse.ocl.utilities.UMLReflection.STRICT_SUBTYPE;
import static org.eclipse.ocl.utilities.UMLReflection.STRICT_SUPERTYPE;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.TypeChecker;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.TypeType;
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
		
		return env.getUMLReflection().getOwningClassifier(operation) instanceof AnyType<?>;
	}

	/**
	 * Finds the most specific (re)definition of an operation by signature in the
	 * specified classifier.
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

		return getTypeCheckerAdapter(env).findOperationMatching(owner, name, args);
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

		return getTypeCheckerAdapter(env).findSignalMatching(receiver, signals, name, args);		
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
		
		return getTypeCheckerAdapter(env).getOperations(owner);
	}
	
	/**
	 * Null-safe alternative to {@link ENamedElement#getName()}.
	 * 
	 * @param element a named element that may be <code>null</code>
	 * @return the element's name, or <code>null</code> if the element is <code>null</code>
	 */
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	String getName(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			Object element) {
		return (element == null)? null : env.getUMLReflection().getName(element);
	}

	/**
	 * Finds the most specific (re)definition of an attribute in the specified
	 * classifier.
	 * 
     * @param env the OCL environment
	 * @param owner the classifier to search
	 * @param name the name of the operation
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 * 
	 * @since 1.3
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	P findAttribute(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, String name) {

		return getTypeCheckerAdapter(env).findAttribute(owner, name);
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
		return getTypeCheckerAdapter(env).getAttributes(owner);
	}

	/**
	 * Compares an actual argument list against the signature of an operation
     * or a signal.
	 * 
     * @param env the OCL environment
	 * @param owner the type that owns the operation
	 * @param paramsOrProperties the operation parameters or signal attributes to match
     *     against the arguments
	 * @param args a list of {@link OCLExpression}s or {@link Variable}s
	 * 
	 * @return true or false
	 * 
	 * @since 1.3
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean matchArgs(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, List<?> paramsOrProperties,
			List<? extends TypedElement<C>> args) {
		return getTypeCheckerAdapter(env).matchArgs(owner, paramsOrProperties, args);
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
		
        return getTypeCheckerAdapter(env).resolveGenericSignature(owner, oper);
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
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C getPropertyType(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner,
			P property) {
       return getTypeCheckerAdapter(env).getPropertyType(owner, property);
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
     * @param problemObject the object which could have problems.
     * @param env the OCL environment
     * @param owner the type of the operation call source
     * @param oper the operation
     * 
     * @return the operation's effect result type
	 * @deprecated Use the {@link #getResultType(Object, Environment, Object, Object, List)}
	 *             method, instead, which resolves generic operation signatures
	 *             against actual arguments
	 */
	@Deprecated
	@SuppressWarnings("unchecked")
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C getResultType(Object problemObject,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, O oper) {

		UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = env.getUMLReflection();
		OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
		
		List<PM> parameters = uml.getParameters(oper);
		List<Variable<C, PM>> args = new ArrayList<Variable<C, PM>>(
				parameters.size());

		for (PM param : parameters) {
			C paramType = resolveType(env, uml.getOCLType(param));

			Variable<C, PM> var = env.getOCLFactory().createVariable();
			if (paramType instanceof TypeType<?, ?>) {
				// need the referred type
				TypeType<C, O> typeType = (TypeType<C, O>) paramType;
				if (typeType.getReferredType() == null) {
					var.setType(stdlib.getT()); // case of oclAsType()
				} else {
					var.setType(typeType.getReferredType());
				}
			} else {
				if (paramType instanceof CollectionType<?, ?>) {
					CollectionType<C, O> ct = (CollectionType<C, O>) paramType;

					if (ct.getElementType() == stdlib.getT2()) {
						// special handling for the Collection(T2) parameter
						// of the product collection operation
						paramType = resolveCollectionType(env, ct.getKind(),
							stdlib.getT());
					}
				}

				var.setType(paramType);
			}
			args.add(var);
		}
		
        return getResultType(problemObject, env, owner, oper, args);
	}
	
	/**
	 * Obtains the effective result type of the specified operation, which may
	 * or may not have parameters type by generic type variables. Many of the
	 * OCL Standard Library operations are either generic themselves or defined
	 * by generic types, so the return results depend on the argument and source
	 * types.
	 * 
	 * @param problemObject
	 *            the context object on which to report any problem that we may
	 *            find in computing the result type. Usually this is some
	 *            abstract or concrete syntax tree node
     * @param env the OCL environment
	 * @param owner
	 *            the owner of the operation (type on which the operation is
	 *            called)
	 * @param operation
	 *            the operation signature
	 * @param args
	 *            the arguments of the operation call, which are expressions or
	 *            variables
	 * @return the effective result type of the corresponding operation, or null
	 *         after reporting a problem if any of the argument types do not
	 *         correspond to the source type and/or expected parameter types of
	 *         the operation
	 * 
	 * @since 1.3
	 */
    public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	C getResultType(Object problemObject,
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C owner, O operation,
			List<? extends TypedElement<C>> args) {
    	
		return getTypeCheckerAdapter(env).getResultType(problemObject, owner,
			operation, args);
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
	 * @param env the OCL environment
	 * @param type1 a type
	 * @param type2 another type
	 * @return true if the same type 
 	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean exactTypeMatch(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
	
		return getTypeCheckerAdapter(env).exactTypeMatch(type1, type2);
	}

	/**
	 * Compare two types. Returns true if types are compatible, false otherwise.
	 * 
	 * @param env the OCL environment
	 * @param type1 a type
	 * @param type2 another type
	 * @return true if the same type or type1 is a strict subtype of type2.
 	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	boolean compatibleTypeMatch(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			C type1, C type2) {
	
		return getTypeCheckerAdapter(env).compatibleTypeMatch(type1, type2);
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
		if (!(type1 instanceof PrimitiveType<?> && type2 instanceof PrimitiveType<?>)) {
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
     * @param problemObject the object which could have problems.
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
		
		return getTypeCheckerAdapter(env).checkMutuallyComparable(problemObject, type1, type2, opcode);
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
		
		return getTypeCheckerAdapter(env).getRelationship(type1, type2);
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
	 * @param problemObject the object which could have problems.
	 * @param env the OCL environment
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
	
		return getTypeCheckerAdapter(env).commonSuperType(problemObject, type1, type2);
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
     * Resolves a tuple-type against the tuple-types previously generated
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
	 * Queries whether the specified feature (operation or attribute), as
	 * applied to a particular <tt>owner</tt> classifier, is defined by the
	 * standard library or not (in which case it would, presumably, be
	 * user-defined).
	 * 
	 * @param owner
	 *            a classifier on which a feature is to be accessed
	 * @param feature
	 *            the feature to be accessed
	 * 
	 * @return whether the feature is defined by the standard library
	 * 
	 * @since 1.3
	 */
	public static <C> boolean isStandardLibraryFeature(
			Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env, C owner,
			Object feature) {

		return getTypeCheckerAdapter(env).isStandardLibraryFeature(owner,
			feature);
	}	
		
	@SuppressWarnings("unchecked")
	private static  <C, O, P> TypeChecker<C, O, P> getTypeCheckerAdapter(Environment<?, C, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env) {
		return OCLUtil.getAdapter(env, TypeChecker.class);
	}
}
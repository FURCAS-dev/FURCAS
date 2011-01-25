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
 * $Id: TypeUtil.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import static org.eclipse.ocl.examples.pivot.UMLReflection.SAME_TYPE;
import static org.eclipse.ocl.examples.pivot.UMLReflection.STRICT_SUBTYPE;
import static org.eclipse.ocl.examples.pivot.UMLReflection.STRICT_SUPERTYPE;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

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
	public static boolean isOclAnyOperation(
			Environment env,
			Operation operation) {
		
		return env.getUMLReflection().getOwningClassifier(operation) instanceof AnyType;
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
	public static Operation findOperationMatching(
			Environment env,
			Type owner, String name,
			List<? extends TypedElement> args) {

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
	public static Signal findSignalMatching(
			Environment env,
			Type receiver, List<Signal> signals, String name,
			List<? extends TypedElement> args) {

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
	public static List<Operation> getOperations(
			Environment env,
			Type owner) {
		
		return getTypeCheckerAdapter(env).getOperations(owner);
	}
	
	/**
	 * Null-safe alternative to {@link ENamedElement#getName()}.
	 * 
	 * @param element a named element that may be <code>null</code>
	 * @return the element's name, or <code>null</code> if the element is <code>null</code>
	 */
	private static String getName(
			Environment env,
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
	public static Property findAttribute(
			Environment env,
			Type owner, String name) {

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
	public static List<Property> getAttributes(
			Environment env,
			Type owner) {
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
	public static boolean matchArgs(
			Environment env,
			Type owner, List<?> paramsOrProperties,
			List<? extends TypedElement> args) {
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
	public static Operation resolveGenericSignature(
			Environment env,
			Type owner, Operation oper) {
		
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
	public static Type getPropertyType(
			Environment env,
			Type owner,
			Property property) {
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
    public static Type getResultType(Environment env,
			Type owner, Operation oper) {
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
	public static Type getResultType(Object problemObject,
			Environment env,
			Type owner, Operation oper) {

		UMLReflection uml = env.getUMLReflection();
		StandardLibrary stdlib = env.getOCLStandardLibrary();
		
		List<Parameter> parameters = uml.getParameters(oper);
		List<Variable> args = new ArrayList<Variable>(
				parameters.size());

		for (Parameter param : parameters) {
			Type paramType = resolveType(env, uml.getOCLType(param));

			Variable var = env.getOCLFactory().createVariable();
/*			if (paramType instanceof TypeType) {
				// need the referred type
				TypeType typeType = (TypeType) paramType;
				if (typeType.getReferredType() == null) {
					var.setType(stdlib.getT()); // case of oclAsType()
				} else {
					var.setType(typeType.getReferredType());
				}
			} else { */
				if (paramType instanceof CollectionType) {
					CollectionType ct = (CollectionType) paramType;

					if (ct.getElementType() == stdlib.getT2()) {
						// special handling for the Collection(T2) parameter
						// of the product collection operation
						paramType = resolveCollectionType(env, getKind(ct),
							stdlib.getT());
					}
				}

				var.setType(paramType);
//			}
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
    public static Type getResultType(Object problemObject,
			Environment env,
			Type owner, Operation operation,
			List<? extends TypedElement> args) {
    	
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
    public static boolean type1AsType2(
			Environment env,
			Type type1, Type type2) throws SemanticException {
		
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
	public static boolean exactTypeMatch(
			Environment env,
			Type type1, Type type2) {
	
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
	public static boolean compatibleTypeMatch(
			Environment env,
			Type type1, Type type2) {
	
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
    public static int typeCompare(
			Environment env,
			Type type1, Type type2) {
	
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
			PivotPlugin.throwing(TypeUtil.class, "typeCompare", error);//$NON-NLS-1$
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
     *
	@Deprecated
    public static void checkMutuallyComparable(
			Environment env,
			Type type1, Type type2,
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
	} */
	
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
     *
	public static boolean checkMutuallyComparable(Object problemObject,
			Environment env,
			Type type1, Type type2,
			int opcode) {
		
		return getTypeCheckerAdapter(env).checkMutuallyComparable(problemObject, type1, type2, opcode);
	} */
	
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
	public static int getRelationship(
			Environment env,
			Type type1, Type type2) {
		
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
    public static Type commonSuperType(
			Environment env,
			Type type1, Type type2) throws SemanticException {
		
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
	public static Type commonSuperType(Object problemObject,
			Environment env,
			Type type1, Type type2) {
	
		return getTypeCheckerAdapter(env).commonSuperType(problemObject, type1, type2);
	}
	

/*	public static boolean conformsToClass(org.eclipse.ocl.examples.pivot.Class actualType,
			org.eclipse.ocl.examples.pivot.Class requiredType) {
		if (actualType == requiredType) {
			return true;
		}
		if ((actualType instanceof CollectionType) && (requiredType instanceof CollectionType)) {
			if (actualType.eClass() != requiredType.eClass()) {
				return false;
			}
			return conformsToType(((CollectionType)actualType).getElementType(), ((CollectionType)requiredType).getElementType());
		}
		if ((actualType instanceof TupleType) && (requiredType instanceof TupleType)) {
			List<Property> actualProperties = ((TupleType)actualType).getOwnedAttributes();
			List<Property> requiredProperties = ((TupleType)requiredType).getOwnedAttributes();
			if (actualProperties.size() != requiredProperties.size()) {
				return false;
			}
			for (Property actualProperty : actualProperties) {
				Property requiredProperty = PivotUtil.getNamedElement(requiredProperties, actualProperty.getName());
				if (requiredProperty == null) {
					return false;
				}
				if (!conformsToType(actualProperty.getType(), requiredProperty.getType())) {
					return false;
				}
			}
			return true;
		}
		for (org.eclipse.ocl.examples.pivot.Class superClass : actualType.getSuperClasses()) {
			if (conformsToClass(superClass, requiredType)) {
				return true;
			}
		}
//		List<TemplateBinding> templateBindings = actualType.getTemplateBindings();
//		if (templateBindings.size() > 0) {
//			TemplateableElement template = PivotUtil.getUnspecializedTemplateableElement(actualType);
//			return conformsToClass((org.eclipse.ocl.examples.pivot.Class)template, requiredType);
//		}
		return false;
	}

	public static boolean conformsToType(Type actualType, Type requiredType) {
		if (actualType == requiredType) {
			return true;
		}
		if (!(actualType instanceof org.eclipse.ocl.examples.pivot.Class)) {
			return false;
		}
		if (!(requiredType instanceof org.eclipse.ocl.examples.pivot.Class)) {
			return false;
		}
		return conformsToClass((org.eclipse.ocl.examples.pivot.Class)actualType,
			(org.eclipse.ocl.examples.pivot.Class)requiredType);
	} */

/*	public static List<Class> getCommonClasses(org.eclipse.ocl.examples.pivot.Class leftClass,
		org.eclipse.ocl.examples.pivot.Class rightClass) {
		List<Class> commonClasses = null;
		for (org.eclipse.ocl.examples.pivot.Class superClass : leftClass.getSuperClasses()) {
			List<Class> commonSuperClasses = getCommonClasses(superClass, rightClass);
			if (commonSuperClasses != null) {
				if (commonClasses == null) {
					commonClasses = commonSuperClasses;
				}
				else {
					commonClasses.addAll(commonSuperClasses);
				}
			}
		}
		return commonClasses;
	} */

	public static Type getCommonSuperType(Type leftType, Type rightType) {
        throw new UnsupportedOperationException();
/*		if (conformsToType(leftType, rightType)) {
			return rightType;
		}
		if (conformsToType(rightType, leftType)) {
			return leftType;
		}
		if ((leftType instanceof TupleType) && (rightType instanceof TupleType)) {
			return getCommonTupleType((TupleType)leftType, (TupleType)rightType);
		}
		if (!(leftType instanceof org.eclipse.ocl.examples.pivot.Class)
		 || !(rightType instanceof org.eclipse.ocl.examples.pivot.Class)) {
			return null;
		}
		List<org.eclipse.ocl.examples.pivot.Class> commonClasses = getCommonClasses((org.eclipse.ocl.examples.pivot.Class)leftType, (org.eclipse.ocl.examples.pivot.Class)rightType);
		if (commonClasses == null) {
			return null;
		}
		// FIXME If there are two different common types neither is inherently better
		org.eclipse.ocl.examples.pivot.Class mostConformant = null;
		for (org.eclipse.ocl.examples.pivot.Class commonClass : commonClasses) {
			if (mostConformant == null) {
				mostConformant = commonClass;
			}
			else if (conformsToClass(commonClass, mostConformant)) {
				mostConformant = commonClass;
			}
		}
		return mostConformant; */
	}

	/**
     * Computes the relationship between two types.
     * 
     * @param type1 a type
     * @param type2 another type
     * 
     * @return either {@link #UNRELATED_TYPE}, {@link #STRICT_SUBTYPE},
     *    {@link #STRICT_SUPERTYPE}, or {@link #SAME_TYPE} according to the
     *    relationship between the types
     */
    public static int getTypeRelationship(Type type1, Type type2) {
        throw new UnsupportedOperationException();
/*        if (type1 == type2) {
            return SAME_TYPE;
        }
        
        if ((type1 instanceof org.eclipse.ocl.examples.pivot.Class) && (type2 instanceof org.eclipse.ocl.examples.pivot.Class)) {
            org.eclipse.ocl.examples.pivot.Class class1 = (org.eclipse.ocl.examples.pivot.Class) type1;
            org.eclipse.ocl.examples.pivot.Class class2 = (org.eclipse.ocl.examples.pivot.Class) type2;
            
            if (TypeUtil.conformsToClass(class2, class1)) {
                return STRICT_SUPERTYPE;
            } else if (TypeUtil.conformsToClass(class1, class2)) {
                return STRICT_SUBTYPE;
            }
        }
    
        return UNRELATED_TYPE; */
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
	public static Type resolveType(
			Environment env,
			Type type) {
		
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
	public static Type resolveSetType(
			Environment env,
			Type elementType) {
		
		return resolveCollectionType(env, CollectionKind.SET, elementType);
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
	public static Type resolveOrderedSetType(
			Environment env,
			Type elementType) {
		
		return resolveCollectionType(env, CollectionKind.ORDERED_SET, elementType);
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
	public static Type resolveBagType(
			Environment env,
			Type elementType) {
		
		return resolveCollectionType(env, CollectionKind.BAG, elementType);
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
	public static Type resolveSequenceType(
			Environment env,
			Type elementType) {
		
		return resolveCollectionType(env, CollectionKind.SEQUENCE, elementType);
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
	public static Type resolveCollectionType(
			Environment env,
			CollectionKind kind, Type elementType) {
		return (Type) env.getTypeResolver().resolveCollectionType(kind, elementType);
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
	public static Type resolveTupleType(
			Environment env,
			EList<? extends TypedElement> parts) {
		return (Type) env.getTypeResolver().resolveTupleType(parts);
	}
	
    /**
     * Resolves a tuple-type against the tuple-types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param type the referred type of the type-type to resolve
     * 
     * @return the environment's corresponding type
     *
	@SuppressWarnings("unchecked")
	public static Type resolveTypeType(
			Environment env,
			Type type) {
		return (Type) env.getTypeResolver().resolveTypeType(type);
	} */
	
    /**
     * Resolves an operation message type against the message types previously generated
     * and persisted in the environment.
     * 
     * @param env the OCL environment
     * @param operation the operation referenced by the message type to resolve
     * 
     * @return the environment's corresponding type
     */
	public static Type resolveOperationMessageType(
			Environment env,
			Operation operation) {
		return (Type) env.getTypeResolver().resolveOperationMessageType(operation);
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
	public static Type resolveSignalMessageType(Environment env, Signal signal) {
		return env.getTypeResolver().resolveSignalMessageType(signal);
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
	public static boolean isStandardLibraryFeature(
			Environment env, Type owner,
			Object feature) {

		return getTypeCheckerAdapter(env).isStandardLibraryFeature(owner,
			feature);
	}	
		
	private static TypeChecker getTypeCheckerAdapter(Environment env) {
		return OCLUtil.getAdapter(env, TypeChecker.class);
	}

	public static CollectionKind getKind(CollectionType type) {
		if (type instanceof BagType) {
			return CollectionKind.BAG;
		}
		else if (type instanceof SequenceType) {
			return CollectionKind.SEQUENCE;
		}
		else if (type instanceof OrderedSetType) {
			return CollectionKind.ORDERED_SET;
		}
		else if (type instanceof SetType) {
			return CollectionKind.SET;
		}
		return null;
	}
}
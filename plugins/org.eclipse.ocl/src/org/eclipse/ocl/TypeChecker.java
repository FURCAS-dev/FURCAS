/**
 * Copyright (c) 2008 Open Canarias S.L., Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Open Canarias - Initial API and implementation
 *     Zeligsoft - Bug 233673 - Port other bug fixes to this new API
 *     Zeligsoft - Bug 179990
 * 
 * $Id: TypeChecker.java,v 1.3 2010/05/03 09:32:32 ewillink Exp $
 */
package org.eclipse.ocl;

import java.util.List;

import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <p>
 * This optional interface is to be implemented by clients that want to add type
 * checking capabilities to their {@link Environment}.
 * </p>
 * <p>
 * The {@link AbstractTypeChecker} provides the default implementation for the
 * OCL type system. Rather than implement this interface, it is suggested that,
 * if at al possible, clients extend the {@link AbstractTypeChecker} class,
 * instead.
 * </p>
 * <p>
 * See the {@link Environment} interface for a description of the generic type
 * parameters of this class. See the {@link AbstractTypeChecker} class for
 * classes for implementation details.
 * </p>
 * 
 * @author Adolfo Sanchez-Barbudo Herrera (adolfosbh)
 * 
 * @since 1.3
 * 
 * @see AbstractTypeChecker
 */
public interface TypeChecker<C, O, P> {

	/**
	 * Queries the relationship, according to generalizations, of two types.
	 * This operation accounts for the OCL Standard Library types, which the
	 * otherwise similar {@link UMLReflection#getRelationship(Object, Object)}
	 * method does not.
	 * 
	 * @param type1
	 *            a type
	 * @param type2
	 *            another type
	 * @return the nature of their hierarchical relationship of <tt>type1</tt>
	 *         to <tt>type2</tt>, as enumerated in the {@link UMLReflection}
	 *         interface
	 * 
	 * @see UMLReflection#getRelationship(Object, Object)
	 */
	int getRelationship(C type1, C type2);

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
	 */
	C getResultType(Object problemObject, C owner, O operation,
			List<? extends TypedElement<C>> args);

	/**
	 * Gets the type of a property, accounting for the fact that we may be
	 * navigating to it from an association class (in which the member ends of
	 * an association always have multiplicity 1) or not.
	 * 
	 * @param owner
	 *            the source of the navigation of the property, which may be an
	 *            association class (the interesting scenario)
	 * @param property
	 *            the property to navigate
	 * 
	 * @return the effective type of the property, which may not be a collection
	 *         type despite its declared multiplicity in the association class
	 *         case
	 */
	C getPropertyType(C owner, P property);

	/**
	 * Get the common supertype of two types. This operation accounts for the
	 * OCL Standard Library types, which the otherwise similar
	 * {@link UMLReflection#getCommonSuperType(Object, Object)} method does not.
	 * 
	 * @param problemObject
	 *            the object which could have problems.
	 * @param type1
	 *            a type
	 * @param type2
	 *            another type
	 * @return their common supertype, if any, null if the two types have no
	 *         common supertype
	 * 
	 * @see UMLReflection#getCommonSuperType(Object, Object)
	 */
	C commonSuperType(Object problemObject, C type1, C type2);

	/**
	 * Checks whether two types are mutually comparable in the determination of
	 * the applicability of {@literal =} and {@literal <>} operations.
	 * 
	 * @param problemObject
	 *            the object which could have problems.
	 * @param type1
	 *            a type
	 * @param type2
	 *            another type
	 * @param opcode
	 *            the operation code
	 * 
	 * @return false if the types are not comparable
	 */
	boolean checkMutuallyComparable(Object problemObject, C type1, C type2,
			int opcode);

	/**
	 * Compare two types. Returns true if types are exactly equal, false
	 * otherwise.
	 * 
	 * @param type1
	 *            a type
	 * @param type2
	 *            another type
	 * @return true if the same type
	 */
	boolean exactTypeMatch(C type1, C type2);

	/**
	 * Compare two types. Returns true if types are compatible, false otherwise.
	 * 
	 * @param type1
	 *            a type
	 * @param type2
	 *            another type
	 * @return true if the same type or type1 is a strict subtype of type2.
	 */
	boolean compatibleTypeMatch(C type1, C type2);

	/**
	 * Obtains all of the OCL operations applicable to the specified owner type,
	 * including any that were defined in the OCL environment as additional
	 * operations.
	 * 
	 * @param owner
	 *            the operation owner type
	 * 
	 * @return an unmodifiable list of its operations
	 */
	List<O> getOperations(C owner);

	/**
	 * Obtains all of the OCL attributes applicable to the specified owner type,
	 * including any that were defined in the OCL environment as additional
	 * attributes.
	 * 
	 * @param owner
	 *            the attribute owner type
	 * 
	 * @return an unmodifiable list of its attributes
	 */
	List<P> getAttributes(C owner);

	/**
	 * Resolves the signature of a generic operation (where it has parameters of
	 * type and/or <tt>T</tt> or <tt>T2</tt>) against the source type of the
	 * operation, as appropriate.
	 * 
	 * @param owner
	 *            the operation source type
	 * @param oper
	 *            the generic operation
	 * 
	 * @return the resolved parameter type
	 */
	O resolveGenericSignature(C owner, O oper);

	/**
	 * Find a matching signal in the specified list.
	 * 
	 * @param receiver
	 *            the type that receives the signal
	 * @param signals
	 *            the signals to search
	 * @param name
	 *            name of signal to find
	 * @param args
	 *            list of arguments to match against the signal signature
	 * 
	 * @return the matching signal, or <code>null</code> if not found
	 */
	C findSignalMatching(C receiver, List<C> signals, String name,
			List<? extends TypedElement<C>> args);

	/**
	 * Finds an operation by signature in the specified classifier.
	 * 
	 * @param owner
	 *            the classifier to search
	 * @param name
	 *            the name of the operation
	 * @param args
	 *            a list of arguments to match against the operation signature,
	 *            as either expressions or variables
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */
	O findOperationMatching(C owner, String name,
			List<? extends TypedElement<C>> args);

	/**
	 * Compares an actual argument list against the signature of an operation or
	 * a signal.
	 * 
	 * @param owner
	 *            the type that owns the operation
	 * @param paramsOrProperties
	 *            the operation parameters or signal attributes to match against
	 *            the arguments
	 * @param args
	 *            a list of {@link OCLExpression}s or {@link Variable}s
	 * 
	 * @return true or false
	 */
	boolean matchArgs(C owner, List<?> paramsOrProperties,
			List<? extends TypedElement<C>> args);

	/**
	 * Finds the most specific (re)definition of an attribute in the specified
	 * classifier.
	 * 
	 * @param owner
	 *            the classifier to search
	 * @param name
	 *            the name of the operation
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */
	P findAttribute(C owner, String name);

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
	 */
	boolean isStandardLibraryFeature(C owner, Object feature);
}

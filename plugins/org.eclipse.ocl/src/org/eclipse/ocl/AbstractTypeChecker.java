/**
 * Copyright (c) 2008, 2009 IBM Corporation, Zeligsoft Inc., Open Canarias S.L., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	   IBM - Original org.eclipse.ocl.util.TypeUtil API and implementation
 *     Open Canarias - Bug 233673 Refactoring to support type checking extensibility 
 *     Zeligsoft - Bugs 244886, 245619, 233673, 179990
 *     Stefan Schulze - Bug 245619
 *     Adolfo Sanchez-Barbudo Herrera - Bug 260403.
 *     
 * $Id: AbstractTypeChecker.java,v 1.8 2010/05/03 09:32:32 ewillink Exp $
 */

package org.eclipse.ocl;

import static org.eclipse.ocl.utilities.UMLReflection.SAME_TYPE;
import static org.eclipse.ocl.utilities.UMLReflection.STRICT_SUBTYPE;
import static org.eclipse.ocl.utilities.UMLReflection.STRICT_SUPERTYPE;
import static org.eclipse.ocl.utilities.UMLReflection.SUBTYPE;
import static org.eclipse.ocl.utilities.UMLReflection.UNRELATED_TYPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.Variable;
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
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <p>
 * Implementation of the {@link TypeChecker} interface which offers the default
 * implementation for the type checking system. This class encapsulates the
 * behaviour of the 1.2 release's {@link TypeUtil} class, in an extensible unit.
 * </p>
 * <p>
 * This class is not intended to be extended by clients. They should extend
 * {@link AbstractTypeResolver} instead, so that {@link TypeChecker} can be
 * successfully adapted by {@link AbstractEnvironment}. However, if an already
 * implemented {@link TypeResolver} wants to exploit the type checking system
 * extensibility, it may extend this class.
 * </p>
 * <p>
 * See {@link Environment} for generic parameters description
 * </p>
 * 
 * @author Adolfo Sanchez-Barbudo Herrera (adolfosbh)
 * 
 * @since 1.3
 * 
 * @see AbstractTypeResolver
 * @see TypeUtil
 */
public abstract class AbstractTypeChecker<C, O, P, PM>
		implements TypeChecker<C, O, P> {

	private static final Set<String> RELATIONAL_OPERATORS;

	static {
		RELATIONAL_OPERATORS = new java.util.HashSet<String>();
		RELATIONAL_OPERATORS.add(PredefinedType.LESS_THAN_NAME);
		RELATIONAL_OPERATORS.add(PredefinedType.LESS_THAN_EQUAL_NAME);
		RELATIONAL_OPERATORS.add(PredefinedType.GREATER_THAN_NAME);
		RELATIONAL_OPERATORS.add(PredefinedType.GREATER_THAN_EQUAL_NAME);
	}

	private final Environment<?, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> env;

	private final UMLReflection<?, C, O, P, ?, PM, ?, ?, ?, ?> uml;

	private final OCLFactory oclFactory;

	private final OCLStandardLibrary<C> stdlib;

	/**
	 * Initializes me with my environment.
	 * 
	 * @param env
	 *            my environment
	 */
	public AbstractTypeChecker(
			Environment<?, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> env) {
		super();
		this.env = env;
		uml = env.getUMLReflection();
		oclFactory = env.getOCLFactory();
		stdlib = env.getOCLStandardLibrary();
	}

	/**
	 * Obtains my OCL parsing environment.
	 * 
	 * @return my environment
	 */
	protected Environment<?, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> getEnvironment() {
		return env;
	}

	/**
	 * Obtains the UML introspector that I use to access the subject model.
	 * 
	 * @return my UML introspector
	 */
	protected UMLReflection<?, C, O, P, ?, PM, ?, ?, ?, ?> getUMLReflection() {
		return uml;
	}

	/**
	 * Obtains the OCL factory that I use to instantiate the OCL Abstract
	 * Syntax.
	 * 
	 * @return my OCL factory
	 */
	protected OCLFactory getOCLFactory() {
		return oclFactory;
	}

	public int getRelationship(C type1, C type2) {

		if (type1 != null) {
			type1 = env.getUMLReflection().getOCLType(type1);
		}
		if (type2 != null) {
			type2 = env.getUMLReflection().getOCLType(type2);
		}

		// simplest case is when the types actually are the same
		if (type1 == type2) {
			return SAME_TYPE;
		}

		// OclVoid makes for easy cases
		if ((type1 == stdlib.getOclVoid()) && (type2 != stdlib.getOclInvalid())) {
			return STRICT_SUBTYPE;
		} else if ((type2 == stdlib.getOclVoid())
			&& (type1 != stdlib.getOclInvalid())) {
			return STRICT_SUPERTYPE;
		}

		// so does OclInvalid
		if (type1 == stdlib.getOclInvalid()) {
			return STRICT_SUBTYPE;
		} else if (type2 == stdlib.getOclInvalid()) {
			return STRICT_SUPERTYPE;
		}

		// and so does OclAny, also
		if (type1 == stdlib.getOclAny()) {
			return (type2 instanceof CollectionType<?, ?>)
				? UNRELATED_TYPE
				: STRICT_SUPERTYPE;
		} else if (type2 == stdlib.getOclAny()) {
			return (type1 instanceof CollectionType<?, ?>)
				? UNRELATED_TYPE
				: STRICT_SUBTYPE;
		}

		// handle primitive types
		if (type1 instanceof PrimitiveType<?>) {
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
		} else if (type2 instanceof PrimitiveType<?>) {
			// tested all possible primitive type conformances in the other case
			return UNRELATED_TYPE;
		}

		// handle collection types
		if (type1 instanceof CollectionType<?, ?>) {
			if (!(type2 instanceof CollectionType<?, ?>)) {
				return UNRELATED_TYPE;
			}

			@SuppressWarnings("unchecked")
			CollectionType<C, O> first = (CollectionType<C, O>) type1;
			@SuppressWarnings("unchecked")
			CollectionType<C, O> other = (CollectionType<C, O>) type2;

			int kindRelationship = getRelationship(first.getKind(), other
				.getKind());

			if (kindRelationship == UNRELATED_TYPE) {
				return kindRelationship;
			}

			int elementRelationship = getRelationship(first.getElementType(),
				other.getElementType());

			switch (kindRelationship) {
				case SAME_TYPE :
					return elementRelationship;
				case STRICT_SUBTYPE :
					switch (elementRelationship) {
						case SAME_TYPE :
						case STRICT_SUBTYPE :
							return STRICT_SUBTYPE;
						default :
							return UNRELATED_TYPE;
					}
				case STRICT_SUPERTYPE :
					switch (elementRelationship) {
						case SAME_TYPE :
						case STRICT_SUPERTYPE :
							return STRICT_SUPERTYPE;
						default :
							return UNRELATED_TYPE;
					}
				default :
					return UNRELATED_TYPE;
			}
		}

		if (type1 instanceof MessageType<?, ?, ?> && type2 == stdlib.getOclMessage()) {
			return STRICT_SUBTYPE;
		} else if (type2 instanceof MessageType<?, ?, ?>
			&& type1 == stdlib.getOclMessage()) {
			return STRICT_SUPERTYPE;
		}

		if (type1 instanceof TypeType<?, ?> && type2 == stdlib.getOclType()) {
			return STRICT_SUBTYPE;
		} else if (type2 instanceof TypeType<?, ?> && type1 == stdlib.getOclType()) {
			return STRICT_SUPERTYPE;
		}

		if (type1 instanceof TupleType<?, ?> || type2 instanceof TupleType<?, ?>) {
			if (!((type1 instanceof TupleType<?, ?>) && (type2 instanceof TupleType<?, ?>))) {
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
						int propResult = getRelationship(resolve(uml
							.getOCLType(prop1)), resolve(uml.getOCLType(prop2)));

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
		if (type1 instanceof PredefinedType<?> || type2 instanceof PredefinedType<?>) {
			return UNRELATED_TYPE;
		}

		// remaining case is pure model element types. The environment must
		// handle this

		int result = uml.getRelationship(type1, type2);

		if (result == UNRELATED_TYPE) {
			// try the implicit root class
			C implictBaseClassifier = getImplicitRootClass();
			if ((implictBaseClassifier != null) && uml.isClass(type1)
				&& uml.isClass(type2)) {
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
	protected int getRelationship(CollectionKind kind1, CollectionKind kind2) {
		switch (kind1) {
			case BAG_LITERAL :
				switch (kind2) {
					case BAG_LITERAL :
						return SAME_TYPE;
					case COLLECTION_LITERAL :
						return STRICT_SUBTYPE;
					default :
						return UNRELATED_TYPE;
				}
			case SET_LITERAL :
				switch (kind2) {
					case SET_LITERAL :
						return SAME_TYPE;
					case ORDERED_SET_LITERAL :
						return STRICT_SUPERTYPE;
					case COLLECTION_LITERAL :
						return STRICT_SUBTYPE;
					default :
						return UNRELATED_TYPE;
				}
			case ORDERED_SET_LITERAL :
				switch (kind2) {
					case ORDERED_SET_LITERAL :
						return SAME_TYPE;
					case SET_LITERAL :
					case COLLECTION_LITERAL :
						return STRICT_SUBTYPE;
					default :
						return UNRELATED_TYPE;
				}
			case SEQUENCE_LITERAL :
				switch (kind2) {
					case SEQUENCE_LITERAL :
						return SAME_TYPE;
					case COLLECTION_LITERAL :
						return STRICT_SUBTYPE;
					default :
						return UNRELATED_TYPE;
				}
			default :
				switch (kind2) {
					case COLLECTION_LITERAL :
						return SAME_TYPE;
					default :
						return STRICT_SUPERTYPE;
				}
		}
	}

	public C getResultType(Object problemObject, C owner, O operation,
			List<? extends TypedElement<C>> args) {

		C actualOwner = uml.getOwningClassifier(operation);
		if (isStandardLibraryFeature(actualOwner, operation)) {
			int opcode = OCLStandardLibraryUtil.getOperationCode(uml
				.getName(operation));

			if (opcode > 0) {
				// OCL Standard Library operation. Not customizable
				C result = OCLStandardLibraryUtil.getResultTypeOf(
					problemObject, env, owner, opcode, args);

				if ((result == null) && (owner != actualOwner)) {
					// the actual owner s different from the declared owner.
					// This happens when we re-interpret user-defined types as
					// corresponding OCL-defined types
					result = OCLStandardLibraryUtil.getResultTypeOf(
						problemObject, env, actualOwner, opcode, args);
				}

				return result;
			}
		}

		return resolve(uml.getOCLType(operation));
	}

	@SuppressWarnings("unchecked")
	public C getPropertyType(C owner, P property) {

		C result = resolve(uml.getOCLType(property));

		if (uml.isAssociationClass(owner)
			&& uml.getMemberEnds(owner).contains(property)) {

			// from the perspective of the association class, its ends have
			// multiplicity 1 regardless of their definition (which is from
			// the perspective of the classifiers at the ends)
			if (result instanceof CollectionType<?, ?>) {
				result = ((CollectionType<C, O>) result).getElementType();
			}
		}
		return result;
	}

	/**
	 * Get the common supertype of two types. This operation accounts for the
	 * OCL Standard Library types, which the otherwise similar
	 * {@link UMLReflection#getCommonSuperType(Object, Object)} method does not.
	 * 
	 * @param type1
	 *            a type
	 * @param type2
	 *            another type
	 * @return their common supertype, if any, null if the two types have no
	 *         common supertype
	 * 
	 * @see UMLReflection#getCommonSuperType(Object, Object)
	 */
	@SuppressWarnings("unchecked")
	public C commonSuperType(Object problemObject, C type1, C type2) {

		if (type1 != null) {
			type1 = env.getUMLReflection().asOCLType(type1);
		}
		if (type2 != null) {
			type2 = env.getUMLReflection().asOCLType(type2);
		}

		if (ObjectUtil.equal(type1, type2)) {
			return type2;
		}

		// the generic type T represents the dynamic type against which we
		// are comparing
		if (type1 == stdlib.getT()) {
			return type2;
		} else if (type2 == stdlib.getT()) {
			return type1;
		}

		if ((type1 == stdlib.getOclVoid()) || (type1 == stdlib.getOclInvalid())) {
			return type2;
		}
		if ((type2 == stdlib.getOclVoid()) || (type2 == stdlib.getOclInvalid())) {
			return type1;
		}

		if (type1 == stdlib.getOclAny() && !(type2 instanceof CollectionType<?, ?>)) {
			return type1;
		}
		if (type2 == stdlib.getOclAny() && !(type1 instanceof CollectionType<?, ?>)) {
			return type2;
		}

		if ((type1 == stdlib.getInteger() || type1 == stdlib
			.getUnlimitedNatural())
			&& type2 == stdlib.getReal()) {
			return type2;
		}
		if ((type2 == stdlib.getInteger() || type2 == stdlib
			.getUnlimitedNatural())
			&& type1 == stdlib.getReal()) {
			return type1;
		}

		if (type1 instanceof CollectionType<?, ?> && type2 instanceof CollectionType<?, ?>) {

			CollectionType<C, O> ct1 = (CollectionType<C, O>) type1;

			CollectionType<C, O> ct2 = (CollectionType<C, O>) type2;

			CollectionKind commonKind = commonSuperType(ct1.getKind(), ct2
				.getKind());

			C resultElementType = commonSuperType(problemObject, ct1
				.getElementType(), ct2.getElementType());

			return (C) resolveCollectionType(commonKind, resultElementType);
		}

		if (type1 instanceof MessageType<?, ?, ?> && type2 instanceof MessageType<?, ?, ?>) {
			return stdlib.getOclMessage();
		}

		if (type1 instanceof TypeType<?, ?> && type2 instanceof TypeType<?, ?>) {
			return stdlib.getOclType();
		}

		if (type1 instanceof TupleType<?, ?> || type2 instanceof TupleType<?, ?>) {
			if (!((type1 instanceof TupleType<?, ?>) && (type2 instanceof TupleType<?, ?>))) {
				String message = OCLMessages.bind(
					OCLMessages.TupleTypeMismatch_ERROR_, getName(type1),
					getName(type2));
				error(message, "commonSuperType", problemObject); //$NON-NLS-1$
				return null;
			}

			List<P> props1 = uml.getAttributes(type1);
			List<P> props2 = uml.getAttributes(type2);

			if (props1.size() != props2.size()) {
				String message = OCLMessages.bind(
					OCLMessages.TupleFieldNumMismatch_ERROR_, getName(type1),
					getName(type2));
				error(message, "commonSuperType", problemObject); //$NON-NLS-1$
				return null;
			}

			EList<Variable<C, PM>> tupleParts = new BasicEList<Variable<C, PM>>();

			for (P prop1 : props1) {
				boolean found = false;

				for (P prop2 : props2) {
					if (uml.getName(prop1).equals(uml.getName(prop2))) {
						C resultElementType = commonSuperType(problemObject,
							resolve(uml.getOCLType(prop1)), resolve(uml
								.getOCLType(prop2)));

						found = true;

						Variable<C, PM> var = oclFactory.createVariable();
						uml.setName(var, getName(prop1));
						uml.setType(var, resultElementType);

						tupleParts.add(var);
						break;
					}
				}
				if (!found) {
					String message = OCLMessages.bind(
						OCLMessages.TupleFieldNotFound_ERROR_, new Object[]{
							getName(type1), getName(prop1), getName(type2)});
					error(message, "commonSuperType", problemObject); //$NON-NLS-1$
					return null;
				}
			}

			return (C) resolveTupleType(tupleParts);
		}

		// once exhausted the possibilities for pre-defined types,
		// if one of them is a CollectionType they don't have common super type
		if (type1 instanceof CollectionType<?, ?> || type2 instanceof CollectionType<?, ?>) {
			String message = OCLMessages.bind(OCLMessages.TypeMismatch_ERROR_,
				getName(type1), getName(type2));
			error(message, "commonSuperType", problemObject); //$NON-NLS-1$
			return null;
		}

		// remaining case is pure model element types. The environment must
		// handle this

		C result = uml.getCommonSuperType(type1, type2);

		if (result == null) {
			C implictBaseClassifier = getImplicitRootClass();
			if ((implictBaseClassifier != null) && uml.isClass(type1)
				&& uml.isClass(type2)) {
				result = implictBaseClassifier;
			}
		}

		// if common super type hasn't been found, OclAny is the common
		// supertype
		return (result == null)
			? stdlib.getOclAny()
			: result;
	}

	/**
	 * Common-supertype helper method for collection kinds
	 */
	protected CollectionKind commonSuperType(CollectionKind kind1,
			CollectionKind kind2) {

		CollectionKind genericCollectionKind = CollectionKind.COLLECTION_LITERAL;

		switch (kind1) {
			case BAG_LITERAL :
			case SEQUENCE_LITERAL :
				if (kind2 == kind1) {
					return kind1;
				}

				return genericCollectionKind;
			case SET_LITERAL :
				switch (kind2) {
					case ORDERED_SET_LITERAL :
					case SET_LITERAL :
						return kind1;
					default :
						return genericCollectionKind;
				}
			case ORDERED_SET_LITERAL :
				switch (kind2) {
					case ORDERED_SET_LITERAL :
					case SET_LITERAL :
						return kind2;
					default :
						return genericCollectionKind;
				}
			default :
				return genericCollectionKind;
		}
	}

	public boolean checkMutuallyComparable(Object problemObject, C type1,
			C type2, int opcode) {

		// all of the primitive types are considered as mutually comparable
		if (!(type1 instanceof PrimitiveType<?> && type2 instanceof PrimitiveType<?>)) {
			if (commonSuperType(problemObject, type1, type2) == null) {
				String message = OCLMessages.bind(
					OCLMessages.Noncomforming_ERROR_, getName(type1),
					OCLStandardLibraryUtil.getOperationName(opcode));
				error(message, "checkMutuallyComparable", problemObject); //$NON-NLS-1$
				return false;
			}
		}
		return true;
	}

	public boolean exactTypeMatch(C type1, C type2) {

		switch (getRelationship(type1, type2)) {
			case SAME_TYPE :
				return true;
			default :
				return false;
		}
	}

	public boolean compatibleTypeMatch(C type1, C type2) {

		switch (getRelationship(type1, type2)) {
			case SAME_TYPE :
			case STRICT_SUBTYPE :
				return true;
			default :
				return false;
		}
	}

	public List<O> getOperations(C owner) {
		List<O> result;

		if (owner instanceof TypeType<?, ?>) {
			@SuppressWarnings("unchecked")
			TypeType<C, O> source = (TypeType<C, O>) owner;
			result = new java.util.ArrayList<O>(source.oclOperations());

			// also include the static operations of the referred type
			for (O o : getOperations(source.getReferredType())) {
				if (uml.isStatic(o)) {
					result.add(o);
				}
			}

			result = Collections.unmodifiableList(result);
		} else {
			if (owner instanceof PredefinedType<?>) {
				@SuppressWarnings("unchecked")
				PredefinedType<O> source = (PredefinedType<O>) owner;
				result = new ArrayList<O>(source.oclOperations());

				if ((source instanceof AnyType<?>)
					&& !ParsingOptions.getValue(env,
						ParsingOptions.USE_COMPARE_TO_OPERATION)) {
					// exclude the OclAny operations for <, <=, >, >= which
					// should
					// not be defined for OclAny
					for (Iterator<O> iter = result.iterator(); iter.hasNext();) {
						if (RELATIONAL_OPERATORS.contains(uml.getName(iter
							.next()))) {
							iter.remove();
						}
					}
				}
			} else {
				// it's a user type. Try to convert it to an OCL standard type
				owner = uml.asOCLType(owner);

				if (owner instanceof PredefinedType<?>) {
					@SuppressWarnings("unchecked")
					PredefinedType<O> pt = (PredefinedType<O>) owner;
					result = new ArrayList<O>(pt.oclOperations());
				} else {
					result = new ArrayList<O>();

					// Include both the AnyType operations (oclIsKindOf, etc)
					// and the operations of the class itself.

					C oclAny = stdlib.getOclAny();

					result.addAll(uml.getOperations(owner));

					C implictBaseClassifier = getImplicitRootClass();
					if ((implictBaseClassifier != null)
						&& (implictBaseClassifier != owner)) {
						result.addAll(uml.getOperations(implictBaseClassifier));
					}

					result.addAll(getOperations(oclAny));
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
	public P findAttribute(C owner, String name) {
		UMLReflection<?, C, O, P, ?, PM, ?, ?, ?, ?> uml = env
			.getUMLReflection();
		List<P> attributes = getAttributes(owner);
		List<P> matches = null;

		for (P attr : attributes) {
			if (name.equals(uml.getName(attr))) {
				if (uml.getOwningClassifier(attr) == owner) {
					return attr; // obviously the most specific definition
				}

				if (matches == null) {
					// assume a small number of redefinitions
					matches = new java.util.ArrayList<P>(3);
				}

				matches.add(attr);
			}
		}

		if (matches != null) {
			if (matches.size() == 1) {
				return matches.get(0);
			} else if (!matches.isEmpty()) {
				return mostSpecificRedefinition(matches, uml);
			}
		}

		return null;
	}

	public List<P> getAttributes(C owner) {
		List<P> result;

		if (owner instanceof TypeType<?, ?>) {
			@SuppressWarnings("unchecked")
			TypeType<C, O> source = (TypeType<C, O>) owner;
			result = new java.util.ArrayList<P>();

			// include the static properties of the referred type
			for (P p : getAttributes(source.getReferredType())) {
				if (uml.isStatic(p)) {
					result.add(p);
				}
			}

			result = Collections.unmodifiableList(result);
		} else {
			if (owner instanceof PredefinedType<?>) {
				result = new java.util.ArrayList<P>(uml.getAttributes(owner));
			} else {
				// it's a user type. Try to convert it to an OCL standard type
				owner = uml.asOCLType(owner);

				if (owner instanceof PredefinedType<?>) {
					result = new java.util.ArrayList<P>(uml
						.getAttributes(owner));
				} else {
					result = new ArrayList<P>();

					// Include both the AnyType properties defined by users as
					// additional attributes and the properties of the class
					// itself.

					C oclAny = stdlib.getOclAny();

					result.addAll(uml.getAttributes(owner));

					C implictBaseClassifier = getImplicitRootClass();
					if ((implictBaseClassifier != null)
						&& (implictBaseClassifier != owner)) {
						result.addAll(uml.getAttributes(implictBaseClassifier));
					}

					result.addAll(getAttributes(oclAny));
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

	@SuppressWarnings("unchecked")
	public O resolveGenericSignature(C owner, O oper) {

		String name = uml.getName(oper);
		List<PM> parameters = uml.getParameters(oper);
		List<String> paramNames = new java.util.ArrayList<String>(parameters
			.size());
		List<C> paramTypes = new java.util.ArrayList<C>(parameters.size());
		List<Variable<C, PM>> args = new ArrayList<Variable<C, PM>>(parameters
			.size());

		for (PM param : parameters) {
			paramNames.add(uml.getName(param));
			paramTypes.add(resolveGenericType(owner, resolve(uml
				.getOCLType(param)), stdlib.getT()));

			C paramType = resolve(uml.getOCLType(param));

			Variable<C, PM> var = oclFactory.createVariable();
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
						paramType = (C) resolveCollectionType(ct.getKind(),
							stdlib.getT());
					}
				}

				var.setType(paramType);
			}
			args.add(var);
		}

		C resultType = getResultType(oper, owner, oper, args);

		return uml.createOperation(name, resultType, paramNames, paramTypes);
	}

	/**
	 * Resolves the generic type of an operation parameter (where it is
	 * <tt>T</tt> or <tt>T2</tt>) against the source type of the operation or
	 * the type of the actual argument, as appropriate.
	 * 
	 * @param env
	 *            the OCL environment
	 * @param owner
	 *            the operation source type
	 * @param paramType
	 *            the operation parameter type
	 * @param argType
	 *            the actual operation argument type
	 * 
	 * @return the resolved parameter type
	 */
	@SuppressWarnings("unchecked")
	protected C resolveGenericType(C owner, C paramType, C argType) {

		C result = paramType;

		if (result == stdlib.getT()) {
			// substitute the owner type (or owner's element type in
			// the case of a collection)
			result = owner;
			if (result instanceof CollectionType<?, ?>) {
				result = ((CollectionType<C, O>) result).getElementType();

				if (result == stdlib.getOclVoid()) {
					// special case for empty collections, whose element type is
					// OclVoid.
					// We want any argument to be accepted, and to solely
					// determine
					// the element type of the resulting collection
					result = stdlib.getT();
				}
			}
		} else if (result instanceof CollectionType<?, ?>) {
			// handle generic collection operation with parameter of
			// type <collectionKind>(T)
			CollectionType<C, O> collType = (CollectionType<C, O>) result;
			C elemType = collType.getElementType();

			if (elemType == stdlib.getT()) {
				C ownerMatch = owner;
				if (ownerMatch instanceof CollectionType<?, ?>) {
					ownerMatch = ((CollectionType<C, O>) ownerMatch)
						.getElementType();

					if (ownerMatch == stdlib.getOclVoid()) {
						// special case for empty collections, whose element
						// type is OclVoid.
						// We want any argument to be accepted, and to solely
						// determine
						// the element type of the resulting collection
						ownerMatch = stdlib.getT();
					}
				}

				result = (C) resolveCollectionType(collType.getKind(),
					ownerMatch);
			} else if (elemType == stdlib.getT2()) {
				// wildard to match any other collection type
				C argMatch = argType;
				if (argMatch instanceof CollectionType<?, ?>) {
					argMatch = ((CollectionType<C, O>) argMatch)
						.getElementType();

					if (argMatch == stdlib.getOclVoid()) {
						// special case for empty collections, whose element
						// type is OclVoid.
						// We want any argument to be accepted, and to solely
						// determine
						// the element type of the resulting collection. Note
						// that we
						// want T, not T2, because it is our wildcard
						argMatch = stdlib.getT();
					}
				}

				result = (C) resolveCollectionType(collType.getKind(), argMatch);
			}
		}

		return result;
	}

	public boolean matchArgs(C owner, List<?> paramsOrProperties,
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

		int i = 0;
		for (Object paramOrProperty : paramsOrProperties) {
			@SuppressWarnings("null")
			TypedElement<C> arg = args.get(i++);
			C argType = arg.getType();
			C popType = resolve(uml.getOCLType(paramOrProperty));

			// handle parameters of type OclType
			if (popType instanceof TypeType<?, ?>) {
				if (arg instanceof TypeExp<?>) {
					continue;
				}
				return false;
			}

			popType = resolveGenericType(owner, popType, argType);

			if (popType == stdlib.getT()) {
				// this is a collection operation, and the collection is empty
				// (element type is OclVoid). Any argument matches in this
				// case, because any kind of element can be considered to not
				// be in an empty collection
				continue;
			}

			if ((getRelationship(argType, popType) & SUBTYPE) == 0) {
				return false;
			}
		}
		return true;
	}

	public C findSignalMatching(C receiver, List<C> signals, String name,
			List<? extends TypedElement<C>> args) {

		if (args == null) {
			args = Collections.emptyList();
		}

		for (C signal : signals) {
			if (uml.getName(signal).equals(name)
				&& matchArgs(receiver, uml.getAttributes(signal), args)) {
				return signal;
			}
		}

		return null;
	}

	public O findOperationMatching(C owner, String name,
			List<? extends TypedElement<C>> args) {

		if (args == null) {
			args = Collections.emptyList();
		}

		UMLReflection<?, C, O, P, ?, PM, ?, ?, ?, ?> uml = env
			.getUMLReflection();
		List<O> operations = getOperations(owner);
		List<O> matches = null;

		for (O oper : operations) {
			if (name.equals(uml.getName(oper))
				&& matchArgs(owner, uml.getParameters(oper), args)) {

				if (uml.getOwningClassifier(oper) == owner) {
					return oper; // obviously the most specific definition
				}

				if (matches == null) {
					// assume a small number of redefinitions
					matches = new java.util.ArrayList<O>(3);
				}

				matches.add(oper);
			}
		}

		if (matches != null) {
			if (matches.size() == 1) {
				return matches.get(0);
			} else if (!matches.isEmpty()) {
				return mostSpecificRedefinition(matches, uml);
			}
		}

		// special handling for null and invalid values, whose types conform
		// to all others
		OCLStandardLibrary<C> lib = env.getOCLStandardLibrary();
		if ((owner == lib.getOclVoid()) || (owner == lib.getOclInvalid())) {
			return findOperationForVoidOrInvalid(owner, name, args);
		}

		return null;
	}

	public boolean isStandardLibraryFeature(C owner, Object feature) {
		boolean result = owner instanceof PredefinedType<?>;

		if (result) {
			result = env.getUMLReflection().isOperation(feature)
				? !env.getAdditionalOperations(owner).contains(feature)
				: !env.getAdditionalAttributes(owner).contains(feature);
		}

		return result;
	}

	/**
	 * Finds the most specific redefinition in a given list of features from a
	 * classifier hierarchy.
	 * 
	 * @param features
	 *            the definitions of a feature; must have at least one element
	 * @param uml
	 *            the UML introspector to use in determining the classifiers
	 *            that define the various feature definitions
	 * 
	 * @return the most specific redefinition of the list of features
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if there is not at least one feature in the list
	 */
	private <F> F mostSpecificRedefinition(List<? extends F> features,
			UMLReflection<?, C, ?, ?, ?, ?, ?, ?, ?, ?> uml) {

		Map<C, F> redefinitions = new java.util.HashMap<C, F>();

		for (F next : features) {
			redefinitions.put(uml.getOwningClassifier(next), next);
		}

		List<C> classifiers = new java.util.ArrayList<C>(redefinitions.keySet());

		// remove all classifiers that are ancestors of another classifier
		// in the map
		outer : for (;;) {
			for (C next : classifiers) {
				if (classifiers.removeAll(uml.getAllSupertypes(next))) {
					continue outer; // don't want a concurrent modification
				}
			}

			break outer;
		}

		// there will at least be one remaining
		return redefinitions.get(classifiers.get(0));
	}

	/**
	 * The <tt>OclVoid</tt> and <tt>OclInvalid</tt> types are defined as
	 * conforming to all other types. Therefore, we can try a little harder to
	 * match certain operations that it is useful to support, such as
	 * <tt>{@literal =}</tt> and <tt>{@literal <>}</tt>.
	 * 
	 * @param owner
	 *            the classifier to search (void or invalid)
	 * @param name
	 *            the name of the operation
	 * @param args
	 *            a list of arguments to match against the operation signature,
	 *            as either expressions or variables
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */
	private O findOperationForVoidOrInvalid(C owner, String name,
			List<? extends TypedElement<C>> args) {

		O result = null;

		if (args.size() == 1) {
			C argType = args.get(0).getType();

			if (argType != owner) {
				// let us search the type of the argument to determine whether
				// we can find this operation
				result = findOperationMatching(argType, name, args);
			}
		}

		return result;
	}

	/**
	 * Obtains the implicit root class specified as an option in the
	 * environment, if it is specified and it is a class.
	 * 
	 * @param env
	 *            the current environment
	 * @return the implicit root class, if any
	 */
	private C getImplicitRootClass() {
		C result = ParsingOptions.getValue(env, ParsingOptions
			.implicitRootClass(env));

		// check that, if there is a value for this option, it is a class
		if ((result != null) && !env.getUMLReflection().isClass(result)) {
			result = null;
		}

		return result;
	}

	/**
	 * Convenience method invoking
	 * <code>getProblemHandler().utilityProblem</code> with a
	 * <code>ProblemHandler.errorSeverity</code>.
	 * 
	 * @param problemMessage
	 *            message describing the problem
	 * @param problemContext
	 *            optional message describing the reporting context
	 * @param problemObject
	 *            optional object associated with the problem
	 */
	private void error(String problemMessage, String problemContext,
			Object problemObject) {
		OCLUtil.getAdapter(env, BasicEnvironment.class).utilityError(
			problemMessage, problemContext, problemObject);
	}

	/**
	 * Null-safe alternative to {@link ENamedElement#getName()}.
	 * 
	 * @param element
	 *            a named element that may be <code>null</code>
	 * @return the element's name, or <code>null</code> if the element is
	 *         <code>null</code>
	 */
	private String getName(Object element) {
		return (element == null)
			? null
			: uml.getName(element);
	}

	/**
	 * Resolves the specified signature of tuple parts to a tuple type already
	 * available in the current environment, or else a new one.
	 * 
	 * @param parts
	 *            specification of the tuple type signature
	 * @return the resolved or new tuple type
	 */
	protected abstract TupleType<O, P> resolveTupleType(
			EList<? extends TypedElement<C>> parts);

	/**
	 * Resolves the specified collection type to a collection type already
	 * available in the current environment, or else a new one.
	 * 
	 * @param kind
	 *            the kind of collection type to obtain
	 * @param elementType
	 *            the element type of the requisite collection type
	 * 
	 * @return the resolved or new collection type
	 */
	protected abstract CollectionType<C, O> resolveCollectionType(
			CollectionKind kind, C elementType);

	/**
	 * Resolves the specified template of a demand-created type to one that is
	 * already defined in the current environment, or else a new one or even the
	 * given type (which would usually then be added to the environment).
	 * 
	 * @param type
	 *            the template/prototype/example of a type to resolve in the
	 *            current environment
	 * @return the resolved type
	 */
	protected abstract C resolve(C type);
}

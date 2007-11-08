/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.query.internal.util;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.internal.EMFQueryPlugin;

/**
 * A utility for checking the inheritance relationships between metatypes.
 */
public abstract class TypeRelationChecker {	

	private static final Map<EClass, Map<TypeRelation, Map<EClass, Boolean>>>
	typesRelationsMaps = new WeakHashMap<EClass, Map<TypeRelation,Map<EClass,Boolean>>>();	

	private static Map<EClass, Boolean> getTypeRelationsCacheMap(EClass type,
		TypeRelation relationKind) {
		return getTypeMap(typesRelationsMaps, type, relationKind);
	}

	private static Map<EClass, Boolean> getTypeMap(
		Map<EClass, Map<TypeRelation, Map<EClass, Boolean>>> typesMaps,
		EClass type,
		TypeRelation relationKind) {
		
		Map<EClass, Boolean> map = null;
		Map<TypeRelation, Map<EClass, Boolean>> maps = typesMaps.get(type);
		if (maps == null) {
			maps = new WeakHashMap<TypeRelation, Map<EClass,Boolean>>();
			typesMaps.put(type, maps);
			map = new WeakHashMap<EClass, Boolean>();
			maps.put(relationKind, map);
		} else {
			map = maps.get(relationKind);
			if (map == null) {
				map = new WeakHashMap<EClass, Boolean>();
				maps.put(relationKind, map);
			}
		}
		return map;
	}	

	//.....................................................................
	private EClass type;

	private TypeRelation relationKind;
	private Map<EClass, Boolean> typeRelationsCache;

	private TypeRelationChecker(EClass type, TypeRelation relationKind) {
		if (type == null || relationKind == null) {
			IllegalArgumentException exception = new IllegalArgumentException(
				"passing null ctor argument"); //$NON-NLS-1$
			EMFQueryPlugin.throwing(getClass(), "TypeRelationChecker", //$NON-NLS-1$
				exception);
			throw exception;
		}
		this.type = type;
		this.relationKind = relationKind;		
		typeRelationsCache = getTypeRelationsCacheMap(type, relationKind);
	}

	/**
	 * Retrieves the cache of type relations.
	 * 
	 * @return the cache
	 */
	protected final Map<EClass, Boolean> getRelationsCache() {
		return typeRelationsCache;
	}

	/**
	 * Gets the type that this checker checks.
	 * 
	 * @return the type
	 */
	public final EClass getType() {
		return type;
	}

	/**
	 * Gets the relation kind that the checker checks for on its type.
	 * 
	 * @return the relation kind
	 */
	public final TypeRelation getTypeRelation() {
		return relationKind;
	}

	/**
	 * Checks the specified <code>eClass</code> against the checker's
	 * type, that it matches the checker's relation.
	 * 
	 * @param eClass the type to check
	 * @return whether it relates as required to the checker's type
	 */
	public boolean isTypeRelationOK(EClass eClass) {
		Boolean checked = getRelationsCache().get(eClass);
		if (checked == null) {
			boolean result = checkRelation(eClass);
			getRelationsCache().put(eClass, result);
			return result;
		}
		return checked.booleanValue();
	}

	/**
	 * Implemented by subclasses to perform the relation check.
	 * 
	 * @param eClass the type to check
	 * @return whether it checks OK
	 */
	protected abstract boolean checkRelation(EClass eClass);

	/**
	 * Creates a new type relation checker.
	 * 
	 * @param type the type to check against
	 * @param relationKind the relationship to check for
	 * @return the checker
	 */
	public static TypeRelationChecker getTypeRelationChecker(EClass type,
		TypeRelation relationKind) {
		if (relationKind == TypeRelation.SAMETYPE_LITERAL) {
			return new SameTypeRelationChecker(type);
		} else if (relationKind == TypeRelation.BASETYPE_LITERAL) {
			return new BaseTypeRelationChecker(type);
		} else if (relationKind == TypeRelation.DIRECT_BASETYPE_LITERAL) {
			return new DirectBaseTypeRelationChecker(type);
		} else if (relationKind == TypeRelation.SUBTYPE_LITERAL) {
			return new SubTypeRelationChecker(type);
		} else if (relationKind == TypeRelation.DIRECT_SUBTYPE_LITERAL) {
			return new DirectSubTypeRelationChecker(type);
		} else if (relationKind == TypeRelation.SAMETYPE_OR_DIRECT_SUBTYPE_LITERAL) {
			return new ORedTypeRelationChecker(type, relationKind,
				new TypeRelationChecker[] {new SameTypeRelationChecker(type),
					new DirectSubTypeRelationChecker(type) });
		} else if (relationKind == TypeRelation.SAMETYPE_OR_DIRECT_BASETYPE_LITERAL) {
			return new ORedTypeRelationChecker(type, relationKind,
				new TypeRelationChecker[] {new SameTypeRelationChecker(type),
					new DirectBaseTypeRelationChecker(type) });
		} else if (relationKind == TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL) {
			return new ORedTypeRelationChecker(type, relationKind,
				new TypeRelationChecker[] {new SameTypeRelationChecker(type),
					new SubTypeRelationChecker(type) });
		} else if (relationKind == TypeRelation.SAMETYPE_OR_BASETYPE_LITERAL) {
			return new ORedTypeRelationChecker(type, relationKind,
				new TypeRelationChecker[] {new SameTypeRelationChecker(type),
					new BaseTypeRelationChecker(type) });
		} else if (relationKind == TypeRelation.UNRELATED_TYPE_LITERAL) {
			return new UnrelatedTypeRelationChecker(type);
		} else if (relationKind == TypeRelation.RELATED_TYPE_LITERAL) {
			return new RelatedTypeRelationChecker(type);
		} else {
			//i.e., TypeRelation.UNDEFINED_LITERAL
			IllegalArgumentException ex = new IllegalArgumentException(
				"Invalid TypeRelation"); //$NON-NLS-1$
			EMFQueryPlugin.throwing(TypeRelationChecker.class,
				"getTypeRelationChecker", ex); //$NON-NLS-1$
			throw ex;
		}
	}

	//  //////////////
	private static class BaseTypeRelationChecker
		extends TypeRelationChecker {

		private List<EClass> allSuperTypes;

		BaseTypeRelationChecker(EClass type) {
			super(type, TypeRelation.BASETYPE_LITERAL);
			allSuperTypes = type.getEAllSuperTypes();
		}

		@Override
		protected boolean checkRelation(EClass type) {
			return allSuperTypes.contains(type);
		}
	}

	//  //////////////
	private static class DirectBaseTypeRelationChecker
		extends TypeRelationChecker {

		private List<EClass> directSuperTypes;

		DirectBaseTypeRelationChecker(EClass type) {
			super(type, TypeRelation.DIRECT_BASETYPE_LITERAL);
			directSuperTypes = type.getESuperTypes();
		}

		@Override
		protected boolean checkRelation(EClass type) {
			return directSuperTypes.contains(type);
		}
	}

	//  //////////////
	private static class DirectSubTypeRelationChecker
		extends TypeRelationChecker {

		DirectSubTypeRelationChecker(EClass type) {
			super(type, TypeRelation.DIRECT_SUBTYPE_LITERAL);
		}

		@Override
		protected boolean checkRelation(EClass type) {
			return type.getESuperTypes().contains(getType());
		}
	}

	//  //////////////
	private static class SameTypeRelationChecker
		extends TypeRelationChecker {

		SameTypeRelationChecker(EClass type) {
			super(type, TypeRelation.SAMETYPE_LITERAL);
		}

		@Override
		protected boolean checkRelation(EClass type) {
			return getType().equals(type);
		}
	}

	//  //////////////
	private static class SubTypeRelationChecker
		extends TypeRelationChecker {

		SubTypeRelationChecker(EClass type) {
			super(type, TypeRelation.SUBTYPE_LITERAL);
		}

		@Override
		protected boolean checkRelation(EClass type) {
			return type.getEAllSuperTypes().contains(getType());
		}
	}

	//  //////////////
	private static class ORedTypeRelationChecker
		extends TypeRelationChecker {

		private TypeRelationChecker[] typeRelationCheckers;

		ORedTypeRelationChecker(EClass type, TypeRelation relationKind,
			TypeRelationChecker[] typeRelationCheckers) {
			super(type, relationKind);
			this.typeRelationCheckers = typeRelationCheckers;
		}

		@Override
		protected boolean checkRelation(EClass type) {
			for (int i = 0; i < typeRelationCheckers.length; ++i) {
				if (typeRelationCheckers[i].isTypeRelationOK(type)) {
					return true;
				}
			}
			return false;
		}
	}

	//  //////////////
	private static class RelatedTypeRelationChecker
		extends ORedTypeRelationChecker {

		RelatedTypeRelationChecker(EClass type) {
			super(type, TypeRelation.RELATED_TYPE_LITERAL,
				new TypeRelationChecker[] {new SameTypeRelationChecker(type),
					new BaseTypeRelationChecker(type),
					new SubTypeRelationChecker(type) });
		}
	}

	//  //////////////
	private static class UnrelatedTypeRelationChecker
		extends TypeRelationChecker {

		private RelatedTypeRelationChecker checker;

		UnrelatedTypeRelationChecker(EClass type) {
			super(type, TypeRelation.UNRELATED_TYPE_LITERAL);
			checker = new RelatedTypeRelationChecker(type);
		}

		@Override
		protected boolean checkRelation(EClass type) {
			return !checker.checkRelation(type);
		}
	}

}
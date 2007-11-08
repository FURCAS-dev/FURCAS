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

package org.eclipse.emf.query.conditions.eobjects;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * An enumerator for the kinds of relationships between EClasses/types. It is
 * primarily used by <code>EObjectTypeRelationCondition</code> to check for
 * relations between EObjects
 */
public enum TypeRelation
	implements Enumerator {

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote an
	 * undefined relationship between two types which means the two types could
	 * or could not be related at all.
	 */
	UNDEFINED_LITERAL("UNDEFINED"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote the
	 * presence of a relationship between two types, regardless of the nature of
	 * this relationship, in other words, either type could be a parent of
	 * another, or they could be the same.
	 */
	RELATED_TYPE_LITERAL("RELATED_TYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote the
	 * absence of a relationship between two types, regardless of the nature of
	 * this relationship, in other words, either type should not be a parent of
	 * the other, nor they should be the same.
	 */
	UNRELATED_TYPE_LITERAL("UNRELATED_TYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that two
	 * types are exactly the same.
	 */
	SAMETYPE_LITERAL("SAMETYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is a base type of another.
	 */
	BASETYPE_LITERAL("BASETYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is a sub type of another.
	 */
	SUBTYPE_LITERAL("SUBTYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is a direct super type of another.
	 */
	DIRECT_BASETYPE_LITERAL("DIRECT_BASETYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is a direct sub type of another.
	 */
	DIRECT_SUBTYPE_LITERAL("DIRECT_SUBTYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is either the same or a direct sub type of another.
	 */
	SAMETYPE_OR_DIRECT_SUBTYPE_LITERAL("SAMETYPE_OR_DIRECT_SUBTYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is either the same or a direct base type of another.
	 */
	SAMETYPE_OR_DIRECT_BASETYPE_LITERAL("SAMETYPE_OR_DIRECT_BASETYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is either the same or a sub type of another.
	 */
	SAMETYPE_OR_SUBTYPE_LITERAL("SAMETYPE_OR_SUBTYPE"), //$NON-NLS-1$

	/**
	 * A <code>TypeRelation</code> enumeration literal used to denote that one
	 * type is either the same or a super type of another.
	 */
	SAMETYPE_OR_BASETYPE_LITERAL("SAMETYPE_OR_BASETYPE"); //$NON-NLS-1$

	/**
	 * The integer value of the UNDEFINED_LITERAL <code>TypeRelation</code>
	 * enumeration literal.
	 */
	public static final int UNDEFINED = UNDEFINED_LITERAL.getValue();

	/**
	 * The integer value of the RELATED_TYPE_LITERAL <code>TypeRelation</code>
	 * enumeration literal.
	 */
	public static final int RELATED_TYPE = RELATED_TYPE_LITERAL.getValue();

	/**
	 * The integer value of the UNRELATED_TYPE_LITERAL <code>TypeRelation</code>
	 * enumeration literal.
	 */
	public static final int UNRELATED_TYPE = UNRELATED_TYPE_LITERAL.getValue();

	/**
	 * The integer value of the SAMETYPE_LITERAL <code>TypeRelation</code>
	 * enumeration literal.
	 */
	public static final int SAMETYPE = SAMETYPE_LITERAL.getValue();

	/**
	 * The integer value of the BASETYPE_LITERAL <code>TypeRelation</code>
	 * enumeration literal.
	 */
	public static final int BASETYPE = BASETYPE_LITERAL.getValue();

	/**
	 * The integer value of the SUBTYPE_LITERAL <code>TypeRelation</code>
	 * enumeration literal.
	 */
	public static final int SUBTYPE = SUBTYPE_LITERAL.getValue();

	/**
	 * The integer value of the DIRECT_BASETYPE_LITERAL
	 * <code>TypeRelation</code> enumeration literal.
	 */
	public static final int DIRECT_BASETYPE = DIRECT_BASETYPE_LITERAL
		.getValue();

	/**
	 * The integer value of the DIRECT_SUBTYPE_LITERAL <code>TypeRelation</code>
	 * enumeration literal.
	 */
	public static final int DIRECT_SUBTYPE = DIRECT_SUBTYPE_LITERAL.getValue();

	/**
	 * The integer value of the SAMETYPE_OR_DIRECT_SUBTYPE_LITERAL
	 * <code>TypeRelation</code> enumeration literal.
	 */
	public static final int SAMETYPE_OR_DIRECT_SUBTYPE = SAMETYPE_OR_DIRECT_SUBTYPE_LITERAL
		.getValue();

	/**
	 * The integer value of the SAMETYPE_OR_DIRECT_BASETYPE_LITERAL
	 * <code>TypeRelation</code> enumeration literal.
	 */
	public static final int SAMETYPE_OR_DIRECT_BASETYPE = SAMETYPE_OR_DIRECT_BASETYPE_LITERAL
		.getValue();

	/**
	 * The integer value of the SAMETYPE_OR_SUBTYPE_LITERAL
	 * <code>TypeRelation</code> enumeration literal.
	 */
	public static final int SAMETYPE_OR_SUBTYPE = SAMETYPE_OR_SUBTYPE_LITERAL
		.getValue();

	/**
	 * The integer value of the SAMETYPE_OR_BASETYPE_LITERAL
	 * <code>TypeRelation</code> enumeration literal.
	 */
	public static final int SAMETYPE_OR_BASETYPE = SAMETYPE_OR_BASETYPE_LITERAL
		.getValue();

	private static final List<TypeRelation> values = java.util.Arrays.asList(values());

	/**
	 * An immutable list of the enumeration literals declared by this enumerator
	 */
	public static final List<TypeRelation> VALUES = Collections.unmodifiableList(values);

	private final String name;
	
	private TypeRelation(String name) {
		this.name = name;
	}

	/**
	 * Gets the <code>TypeRelation</code> enumeration literal with the integer
	 * value specified in the argument.
	 * 
	 * @param value
	 *            An integer representing the value of a
	 *            <code>TypeRelation</code> enumeration literal
	 * @return the <code>TypeRelation</code> having this name or
	 *         null if the name is not recognized
	 */
	public static TypeRelation get(int value) {
		if (value >= VALUES.size() || value < 0) {
			return null;
		}
		return VALUES.get(value);
	}

	/**
	 * Gets the <code>TypeRelation</code> enumeration literal with the name
	 * specified in the argument.
	 * 
	 * @param name
	 *            A string representing the name of a <code>TypeRelation</code>
	 *            enumeration literal
	 * @return the <code>TypeRelation</code> having this name or
	 *         <code>null</code> if the name is not recognized
	 */
	public static TypeRelation get(String name) {
		for (TypeRelation next : VALUES) {
			if (next.getName().equals(name)) {
				return next;
			}
		}
		return null;
	}

	/**
	 * Answers how many enumeration literals declared by this enumerator.
	 * 
	 * @return The total count of all enumeration literals declared by this
	 *         enumerator
	 */
	public static int getTotalCount() {
		return VALUES.size();
	}

	public String getLiteral() {
		return getName();
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return ordinal();
	}
}


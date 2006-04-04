/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: CollectionTypeIdentifierEnum.java,v 1.1 2006/04/04 18:09:02 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Collection Type Identifier Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getCollectionTypeIdentifierEnum()
 * @model
 * @generated
 */
public final class CollectionTypeIdentifierEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The '<em><b>Set</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET_LITERAL
	 * @model name="Set"
	 * @generated
	 * @ordered
	 */
	public static final int SET = 1;

	/**
	 * The '<em><b>Bag</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bag</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BAG_LITERAL
	 * @model name="Bag"
	 * @generated
	 * @ordered
	 */
	public static final int BAG = 2;

	/**
	 * The '<em><b>Sequence</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sequence</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE_LITERAL
	 * @model name="Sequence"
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE = 3;

	/**
	 * The '<em><b>Collection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Collection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLLECTION_LITERAL
	 * @model name="Collection"
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION = 4;

	/**
	 * The '<em><b>Ordered Set</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ordered Set</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORDERED_SET_LITERAL
	 * @model name="OrderedSet"
	 * @generated
	 * @ordered
	 */
	public static final int ORDERED_SET = 5;

	/**
	 * The '<em><b>Set</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET
	 * @generated
	 * @ordered
	 */
	public static final CollectionTypeIdentifierEnum SET_LITERAL = new CollectionTypeIdentifierEnum(SET, "Set", "Set"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Bag</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAG
	 * @generated
	 * @ordered
	 */
	public static final CollectionTypeIdentifierEnum BAG_LITERAL = new CollectionTypeIdentifierEnum(BAG, "Bag", "Bag"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Sequence</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE
	 * @generated
	 * @ordered
	 */
	public static final CollectionTypeIdentifierEnum SEQUENCE_LITERAL = new CollectionTypeIdentifierEnum(SEQUENCE, "Sequence", "Sequence"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Collection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLLECTION
	 * @generated
	 * @ordered
	 */
	public static final CollectionTypeIdentifierEnum COLLECTION_LITERAL = new CollectionTypeIdentifierEnum(COLLECTION, "Collection", "Collection"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Ordered Set</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORDERED_SET
	 * @generated
	 * @ordered
	 */
	public static final CollectionTypeIdentifierEnum ORDERED_SET_LITERAL = new CollectionTypeIdentifierEnum(ORDERED_SET, "OrderedSet", "OrderedSet"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Collection Type Identifier Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CollectionTypeIdentifierEnum[] VALUES_ARRAY =
		new CollectionTypeIdentifierEnum[] {
			SET_LITERAL,
			BAG_LITERAL,
			SEQUENCE_LITERAL,
			COLLECTION_LITERAL,
			ORDERED_SET_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Collection Type Identifier Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collection Type Identifier Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionTypeIdentifierEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionTypeIdentifierEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Type Identifier Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionTypeIdentifierEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionTypeIdentifierEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Type Identifier Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionTypeIdentifierEnum get(int value) {
		switch (value) {
			case SET: return SET_LITERAL;
			case BAG: return BAG_LITERAL;
			case SEQUENCE: return SEQUENCE_LITERAL;
			case COLLECTION: return COLLECTION_LITERAL;
			case ORDERED_SET: return ORDERED_SET_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CollectionTypeIdentifierEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CollectionTypeIdentifierEnum

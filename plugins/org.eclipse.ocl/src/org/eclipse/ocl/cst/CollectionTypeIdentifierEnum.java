/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CollectionTypeIdentifierEnum.java,v 1.1 2007/10/11 23:04:55 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Collection Type Identifier Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.cst.CSTPackage#getCollectionTypeIdentifierEnum()
 * @model
 * @generated
 */
public enum CollectionTypeIdentifierEnum implements Enumerator {
	/**
     * The '<em><b>Set</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SET
     * @generated
     * @ordered
     */
	SET_LITERAL(1, "Set", "Set"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Bag</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BAG
     * @generated
     * @ordered
     */
	BAG_LITERAL(2, "Bag", "Bag"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Sequence</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SEQUENCE
     * @generated
     * @ordered
     */
	SEQUENCE_LITERAL(3, "Sequence", "Sequence"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Collection</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #COLLECTION
     * @generated
     * @ordered
     */
	COLLECTION_LITERAL(4, "Collection", "Collection"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Ordered Set</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ORDERED_SET
     * @generated
     * @ordered
     */
	ORDERED_SET_LITERAL(5, "OrderedSet", "OrderedSet"); //$NON-NLS-1$ //$NON-NLS-2$

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
	public static final List<CollectionTypeIdentifierEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

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
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final int value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String name;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private final String literal;

	/**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private CollectionTypeIdentifierEnum(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getValue() {
      return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
      return name;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getLiteral() {
      return literal;
    }

	/**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        return literal;
    }
	
} //CollectionTypeIdentifierEnum

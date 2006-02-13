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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions;

/**
 * @author Edith Schonberg (edith)
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

public final class CollectionKind extends AbstractEnumerator {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

    /**
     * @model name="collection"
     */
    public static final int COLLECTION = 1;

    /**
     * @model name="set"
     */
    public static final int SET = 2;

    /**
     * @model name="bag"
     */
    public static final int BAG = 3;

    /**
     * @model name="sequence"
     */
    public static final int SEQUENCE = 4;

    /**
     * @model name="orderedSet"
     */
    public static final int ORDERED_SET = 5;

    /**
     * The '<em><b>Collection</b></em>' literal object. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of '<em><b>Collection</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #COLLECTION
     * @generated @ordered
     */
    public static final CollectionKind COLLECTION_LITERAL = new CollectionKind(
            COLLECTION, "collection");//$NON-NLS-1$

    /**
     * The '<em><b>Set</b></em>' literal object. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Set</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #SET
     * @generated @ordered
     */
    public static final CollectionKind SET_LITERAL = new CollectionKind(SET,
            "set");//$NON-NLS-1$

    /**
     * The '<em><b>Bag</b></em>' literal object. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Bag</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #BAG
     * @generated @ordered
     */
    public static final CollectionKind BAG_LITERAL = new CollectionKind(BAG,
            "bag");//$NON-NLS-1$

    /**
     * The '<em><b>Sequence</b></em>' literal object. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of '<em><b>Sequence</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #SEQUENCE
     * @generated @ordered
     */
    public static final CollectionKind SEQUENCE_LITERAL = new CollectionKind(
            SEQUENCE, "sequence");//$NON-NLS-1$

    /**
     * The '<em><b>Ordered Set</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ORDERED_SET
     * @generated @ordered
     */

    public static final CollectionKind ORDERED_SET_LITERAL = new CollectionKind(
            ORDERED_SET, "orderedSet");//$NON-NLS-1$

    private static final CollectionKind[] VALUES_ARRAY = new CollectionKind[] {
            COLLECTION_LITERAL, SET_LITERAL, BAG_LITERAL, SEQUENCE_LITERAL,
            ORDERED_SET_LITERAL };

	/**
	 * A public read-only list of all the '<em><b>Collection Kind</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collection Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static CollectionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static CollectionKind get(int value) {
		switch (value) {
			case COLLECTION: return COLLECTION_LITERAL;
			case SET: return SET_LITERAL;
			case BAG: return BAG_LITERAL;
			case SEQUENCE: return SEQUENCE_LITERAL;
			case ORDERED_SET: return ORDERED_SET_LITERAL;
		}
		return null;	
	}

    private CollectionKind(int value, String name) {
        super(value, name);
    }
}


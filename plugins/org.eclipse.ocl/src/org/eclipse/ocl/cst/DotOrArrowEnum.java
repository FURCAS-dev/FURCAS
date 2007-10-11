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
 * $Id: DotOrArrowEnum.java,v 1.1 2007/10/11 23:04:55 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Dot Or Arrow Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.cst.CSTPackage#getDotOrArrowEnum()
 * @model
 * @generated
 */
public enum DotOrArrowEnum implements Enumerator {
	/**
     * The '<em><b>None</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NONE
     * @generated
     * @ordered
     */
	NONE_LITERAL(1, "none", "none"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Dot</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DOT
     * @generated
     * @ordered
     */
	DOT_LITERAL(2, "dot", "dot"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Arrow</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ARROW
     * @generated
     * @ordered
     */
	ARROW_LITERAL(3, "arrow", "arrow"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>None</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>None</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #NONE_LITERAL
     * @model name="none"
     * @generated
     * @ordered
     */
	public static final int NONE = 1;

	/**
     * The '<em><b>Dot</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Dot</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DOT_LITERAL
     * @model name="dot"
     * @generated
     * @ordered
     */
	public static final int DOT = 2;

	/**
     * The '<em><b>Arrow</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Arrow</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ARROW_LITERAL
     * @model name="arrow"
     * @generated
     * @ordered
     */
	public static final int ARROW = 3;

	/**
     * An array of all the '<em><b>Dot Or Arrow Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final DotOrArrowEnum[] VALUES_ARRAY =
		new DotOrArrowEnum[] {
            NONE_LITERAL,
            DOT_LITERAL,
            ARROW_LITERAL,
        };

	/**
     * A public read-only list of all the '<em><b>Dot Or Arrow Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<DotOrArrowEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Dot Or Arrow Enum</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DotOrArrowEnum get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DotOrArrowEnum result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Dot Or Arrow Enum</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DotOrArrowEnum getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DotOrArrowEnum result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Dot Or Arrow Enum</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DotOrArrowEnum get(int value) {
        switch (value) {
            case NONE: return NONE_LITERAL;
            case DOT: return DOT_LITERAL;
            case ARROW: return ARROW_LITERAL;
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
	private DotOrArrowEnum(int value, String name, String literal) {
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
	
} //DotOrArrowEnum

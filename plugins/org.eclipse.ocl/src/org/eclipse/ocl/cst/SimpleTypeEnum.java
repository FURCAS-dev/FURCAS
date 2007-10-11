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
 * $Id: SimpleTypeEnum.java,v 1.1 2007/10/11 23:04:55 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Simple Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.cst.CSTPackage#getSimpleTypeEnum()
 * @model
 * @generated
 */
public enum SimpleTypeEnum implements Enumerator {
	/**
     * The '<em><b>Identifier</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #IDENTIFIER
     * @generated
     * @ordered
     */
	IDENTIFIER_LITERAL(1, "identifier", "identifier"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Self</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SELF
     * @generated
     * @ordered
     */
	SELF_LITERAL(2, "self", "self"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Integer</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INTEGER
     * @generated
     * @ordered
     */
	INTEGER_LITERAL(3, "Integer", "Integer"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>String</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #STRING
     * @generated
     * @ordered
     */
	STRING_LITERAL(4, "String", "String"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Real</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #REAL
     * @generated
     * @ordered
     */
	REAL_LITERAL(5, "Real", "Real"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Boolean</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BOOLEAN
     * @generated
     * @ordered
     */
	BOOLEAN_LITERAL(6, "Boolean", "Boolean"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Ocl Any</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCL_ANY
     * @generated
     * @ordered
     */
	OCL_ANY_LITERAL(7, "OclAny", "OclAny"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Ocl Void</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCL_VOID
     * @generated
     * @ordered
     */
	OCL_VOID_LITERAL(8, "OclVoid", "OclVoid"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Invalid</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INVALID
     * @generated
     * @ordered
     */
	INVALID_LITERAL(9, "Invalid", "Invalid"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Ocl Message</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OCL_MESSAGE
     * @generated
     * @ordered
     */
	OCL_MESSAGE_LITERAL(10, "OclMessage", "OclMessage"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Keyword</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #KEYWORD
     * @generated
     * @ordered
     */
	KEYWORD_LITERAL(11, "keyword", "keyword"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Unlimited Natural</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #UNLIMITED_NATURAL
     * @generated
     * @ordered
     */
	UNLIMITED_NATURAL_LITERAL(12, "UnlimitedNatural", "UnlimitedNatural"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
     * The '<em><b>Identifier</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Identifier</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #IDENTIFIER_LITERAL
     * @model name="identifier"
     * @generated
     * @ordered
     */
	public static final int IDENTIFIER = 1;

	/**
     * The '<em><b>Self</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Self</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SELF_LITERAL
     * @model name="self"
     * @generated
     * @ordered
     */
	public static final int SELF = 2;

	/**
     * The '<em><b>Integer</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INTEGER_LITERAL
     * @model name="Integer"
     * @generated
     * @ordered
     */
	public static final int INTEGER = 3;

	/**
     * The '<em><b>String</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #STRING_LITERAL
     * @model name="String"
     * @generated
     * @ordered
     */
	public static final int STRING = 4;

	/**
     * The '<em><b>Real</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Real</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #REAL_LITERAL
     * @model name="Real"
     * @generated
     * @ordered
     */
	public static final int REAL = 5;

	/**
     * The '<em><b>Boolean</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #BOOLEAN_LITERAL
     * @model name="Boolean"
     * @generated
     * @ordered
     */
	public static final int BOOLEAN = 6;

	/**
     * The '<em><b>Ocl Any</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ocl Any</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCL_ANY_LITERAL
     * @model name="OclAny"
     * @generated
     * @ordered
     */
	public static final int OCL_ANY = 7;

	/**
     * The '<em><b>Ocl Void</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ocl Void</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCL_VOID_LITERAL
     * @model name="OclVoid"
     * @generated
     * @ordered
     */
	public static final int OCL_VOID = 8;

	/**
     * The '<em><b>Invalid</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Invalid</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INVALID_LITERAL
     * @model name="Invalid"
     * @generated
     * @ordered
     */
	public static final int INVALID = 9;

	/**
     * The '<em><b>Ocl Message</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ocl Message</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OCL_MESSAGE_LITERAL
     * @model name="OclMessage"
     * @generated
     * @ordered
     */
	public static final int OCL_MESSAGE = 10;

	/**
     * The '<em><b>Keyword</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Keyword</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #KEYWORD_LITERAL
     * @model name="keyword"
     * @generated
     * @ordered
     */
	public static final int KEYWORD = 11;

	/**
     * The '<em><b>Unlimited Natural</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unlimited Natural</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #UNLIMITED_NATURAL_LITERAL
     * @model name="UnlimitedNatural"
     * @generated
     * @ordered
     */
	public static final int UNLIMITED_NATURAL = 12;

	/**
     * An array of all the '<em><b>Simple Type Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final SimpleTypeEnum[] VALUES_ARRAY =
		new SimpleTypeEnum[] {
            IDENTIFIER_LITERAL,
            SELF_LITERAL,
            INTEGER_LITERAL,
            STRING_LITERAL,
            REAL_LITERAL,
            BOOLEAN_LITERAL,
            OCL_ANY_LITERAL,
            OCL_VOID_LITERAL,
            INVALID_LITERAL,
            OCL_MESSAGE_LITERAL,
            KEYWORD_LITERAL,
            UNLIMITED_NATURAL_LITERAL,
        };

	/**
     * A public read-only list of all the '<em><b>Simple Type Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<SimpleTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Simple Type Enum</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SimpleTypeEnum get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SimpleTypeEnum result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Simple Type Enum</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SimpleTypeEnum getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SimpleTypeEnum result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Simple Type Enum</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SimpleTypeEnum get(int value) {
        switch (value) {
            case IDENTIFIER: return IDENTIFIER_LITERAL;
            case SELF: return SELF_LITERAL;
            case INTEGER: return INTEGER_LITERAL;
            case STRING: return STRING_LITERAL;
            case REAL: return REAL_LITERAL;
            case BOOLEAN: return BOOLEAN_LITERAL;
            case OCL_ANY: return OCL_ANY_LITERAL;
            case OCL_VOID: return OCL_VOID_LITERAL;
            case INVALID: return INVALID_LITERAL;
            case OCL_MESSAGE: return OCL_MESSAGE_LITERAL;
            case KEYWORD: return KEYWORD_LITERAL;
            case UNLIMITED_NATURAL: return UNLIMITED_NATURAL_LITERAL;
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
	private SimpleTypeEnum(int value, String name, String literal) {
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
	
} //SimpleTypeEnum

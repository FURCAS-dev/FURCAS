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
 * $Id: SimpleTypeEnum.java,v 1.2 2006/05/16 15:07:58 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Simple Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getSimpleTypeEnum()
 * @model
 * @generated
 */
public final class SimpleTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

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
	 * The '<em><b>Identifier</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDENTIFIER
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum IDENTIFIER_LITERAL = new SimpleTypeEnum(IDENTIFIER, "identifier", "identifier"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Self</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELF
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum SELF_LITERAL = new SimpleTypeEnum(SELF, "self", "self"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Integer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum INTEGER_LITERAL = new SimpleTypeEnum(INTEGER, "Integer", "Integer"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>String</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum STRING_LITERAL = new SimpleTypeEnum(STRING, "String", "String"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Real</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAL
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum REAL_LITERAL = new SimpleTypeEnum(REAL, "Real", "Real"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum BOOLEAN_LITERAL = new SimpleTypeEnum(BOOLEAN, "Boolean", "Boolean"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Ocl Any</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OCL_ANY
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum OCL_ANY_LITERAL = new SimpleTypeEnum(OCL_ANY, "OclAny", "OclAny"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Ocl Void</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OCL_VOID
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum OCL_VOID_LITERAL = new SimpleTypeEnum(OCL_VOID, "OclVoid", "OclVoid"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Invalid</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INVALID
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum INVALID_LITERAL = new SimpleTypeEnum(INVALID, "Invalid", "Invalid"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Ocl Message</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OCL_MESSAGE
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum OCL_MESSAGE_LITERAL = new SimpleTypeEnum(OCL_MESSAGE, "OclMessage", "OclMessage"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Keyword</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KEYWORD
	 * @generated
	 * @ordered
	 */
	public static final SimpleTypeEnum KEYWORD_LITERAL = new SimpleTypeEnum(KEYWORD, "keyword", "keyword"); //$NON-NLS-1$ //$NON-NLS-2$

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
		};

	/**
	 * A public read-only list of all the '<em><b>Simple Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

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
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SimpleTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //SimpleTypeEnum

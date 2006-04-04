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
 * $Id: PrePostOrBodyEnum.java,v 1.1 2006/04/04 18:09:03 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Pre Post Or Body Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getPrePostOrBodyEnum()
 * @model
 * @generated
 */
public final class PrePostOrBodyEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The '<em><b>Pre</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pre</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRE_LITERAL
	 * @model name="pre"
	 * @generated
	 * @ordered
	 */
	public static final int PRE = 1;

	/**
	 * The '<em><b>Post</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Post</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POST_LITERAL
	 * @model name="post"
	 * @generated
	 * @ordered
	 */
	public static final int POST = 2;

	/**
	 * The '<em><b>Body</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Body</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BODY_LITERAL
	 * @model name="body"
	 * @generated
	 * @ordered
	 */
	public static final int BODY = 3;

	/**
	 * The '<em><b>Pre</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRE
	 * @generated
	 * @ordered
	 */
	public static final PrePostOrBodyEnum PRE_LITERAL = new PrePostOrBodyEnum(PRE, "pre", "pre"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Post</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST
	 * @generated
	 * @ordered
	 */
	public static final PrePostOrBodyEnum POST_LITERAL = new PrePostOrBodyEnum(POST, "post", "post"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Body</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BODY
	 * @generated
	 * @ordered
	 */
	public static final PrePostOrBodyEnum BODY_LITERAL = new PrePostOrBodyEnum(BODY, "body", "body"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Pre Post Or Body Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PrePostOrBodyEnum[] VALUES_ARRAY =
		new PrePostOrBodyEnum[] {
			PRE_LITERAL,
			POST_LITERAL,
			BODY_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Pre Post Or Body Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Pre Post Or Body Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrePostOrBodyEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PrePostOrBodyEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pre Post Or Body Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrePostOrBodyEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PrePostOrBodyEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Pre Post Or Body Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrePostOrBodyEnum get(int value) {
		switch (value) {
			case PRE: return PRE_LITERAL;
			case POST: return POST_LITERAL;
			case BODY: return BODY_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private PrePostOrBodyEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //PrePostOrBodyEnum

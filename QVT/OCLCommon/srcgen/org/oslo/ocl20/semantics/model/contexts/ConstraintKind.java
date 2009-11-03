/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Constraint Kind</b></em>', and utility methods for working with them. <!-- end-user-doc
 * -->
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraintKind()
 * @model
 * @generated
 */
public final class ConstraintKind extends AbstractEnumerator {
	/**
	 * The '<em><b>INIT</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INIT</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INIT = 0;

	/**
	 * The '<em><b>DERIVE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DERIVE</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DERIVE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DERIVE = 1;

	/**
	 * The '<em><b>INV</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INV</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INV_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INV = 2;

	/**
	 * The '<em><b>DEF</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEF</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #DEF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEF = 3;

	/**
	 * The '<em><b>PRE</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRE</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PRE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRE = 4;

	/**
	 * The '<em><b>POST</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POST</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #POST_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POST = 5;

	/**
	 * The '<em><b>BODY</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BODY</b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BODY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BODY = 6;

	/**
	 * The '<em><b>INIT</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #INIT
	 * @generated
	 * @ordered
	 */
	public static final ConstraintKind INIT_LITERAL = new ConstraintKind(INIT, "INIT", "INIT");

	/**
	 * The '<em><b>DERIVE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DERIVE
	 * @generated
	 * @ordered
	 */
	public static final ConstraintKind DERIVE_LITERAL = new ConstraintKind(DERIVE, "DERIVE", "DERIVE");

	/**
	 * The '<em><b>INV</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #INV
	 * @generated
	 * @ordered
	 */
	public static final ConstraintKind INV_LITERAL = new ConstraintKind(INV, "INV", "INV");

	/**
	 * The '<em><b>DEF</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DEF
	 * @generated
	 * @ordered
	 */
	public static final ConstraintKind DEF_LITERAL = new ConstraintKind(DEF, "DEF", "DEF");

	/**
	 * The '<em><b>PRE</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #PRE
	 * @generated
	 * @ordered
	 */
	public static final ConstraintKind PRE_LITERAL = new ConstraintKind(PRE, "PRE", "PRE");

	/**
	 * The '<em><b>POST</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #POST
	 * @generated
	 * @ordered
	 */
	public static final ConstraintKind POST_LITERAL = new ConstraintKind(POST, "POST", "POST");

	/**
	 * The '<em><b>BODY</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #BODY
	 * @generated
	 * @ordered
	 */
	public static final ConstraintKind BODY_LITERAL = new ConstraintKind(BODY, "BODY", "BODY");

	/**
	 * An array of all the '<em><b>Constraint Kind</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final ConstraintKind[] VALUES_ARRAY = new ConstraintKind[] { INIT_LITERAL, DERIVE_LITERAL,
	        INV_LITERAL, DEF_LITERAL, PRE_LITERAL, POST_LITERAL, BODY_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Constraint Kind</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Constraint Kind</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConstraintKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConstraintKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Constraint Kind</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConstraintKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConstraintKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Constraint Kind</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ConstraintKind get(int value) {
		switch (value) {
			case INIT:
				return INIT_LITERAL;
			case DERIVE:
				return DERIVE_LITERAL;
			case INV:
				return INV_LITERAL;
			case DEF:
				return DEF_LITERAL;
			case PRE:
				return PRE_LITERAL;
			case POST:
				return POST_LITERAL;
			case BODY:
				return BODY_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private ConstraintKind(int value, String name, String literal) {
		super(value, name, literal);
	}

} // ConstraintKind

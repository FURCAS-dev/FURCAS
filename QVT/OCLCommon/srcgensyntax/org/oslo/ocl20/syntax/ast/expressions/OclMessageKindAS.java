/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ocl Message Kind AS</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageKindAS()
 * @model
 * @generated
 */
public final class OclMessageKindAS extends AbstractEnumerator {
	/**
	 * The '<em><b>UP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UP = 0;

	/**
	 * The '<em><b>UP UP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UP UP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UP_UP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UP_UP = 1;

	/**
	 * The '<em><b>UP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UP
	 * @generated
	 * @ordered
	 */
	public static final OclMessageKindAS UP_LITERAL = new OclMessageKindAS(UP, "UP", "UP");

	/**
	 * The '<em><b>UP UP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UP_UP
	 * @generated
	 * @ordered
	 */
	public static final OclMessageKindAS UP_UP_LITERAL = new OclMessageKindAS(UP_UP, "UP_UP", "UP_UP");

	/**
	 * An array of all the '<em><b>Ocl Message Kind AS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OclMessageKindAS[] VALUES_ARRAY =
		new OclMessageKindAS[] {
			UP_LITERAL,
			UP_UP_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ocl Message Kind AS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ocl Message Kind AS</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclMessageKindAS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OclMessageKindAS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ocl Message Kind AS</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclMessageKindAS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OclMessageKindAS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ocl Message Kind AS</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclMessageKindAS get(int value) {
		switch (value) {
			case UP: return UP_LITERAL;
			case UP_UP: return UP_UP_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private OclMessageKindAS(int value, String name, String literal) {
		super(value, name, literal);
	}

} //OclMessageKindAS

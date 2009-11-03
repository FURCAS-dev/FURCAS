/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Execution Kind AS</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getExecutionKindAS()
 * @model
 * @generated
 */
public final class ExecutionKindAS extends AbstractEnumerator {
	/**
	 * The '<em><b>CHECK ONLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHECK ONLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHECK_ONLY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHECK_ONLY = 0;

	/**
	 * The '<em><b>ENFORCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENFORCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENFORCE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENFORCE = 1;

	/**
	 * The '<em><b>CHECK ONLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHECK_ONLY
	 * @generated
	 * @ordered
	 */
	public static final ExecutionKindAS CHECK_ONLY_LITERAL = new ExecutionKindAS(CHECK_ONLY, "CHECK_ONLY", "CHECK_ONLY");

	/**
	 * The '<em><b>ENFORCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENFORCE
	 * @generated
	 * @ordered
	 */
	public static final ExecutionKindAS ENFORCE_LITERAL = new ExecutionKindAS(ENFORCE, "ENFORCE", "ENFORCE");

	/**
	 * An array of all the '<em><b>Execution Kind AS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ExecutionKindAS[] VALUES_ARRAY =
		new ExecutionKindAS[] {
			CHECK_ONLY_LITERAL,
			ENFORCE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Execution Kind AS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Execution Kind AS</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionKindAS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionKindAS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution Kind AS</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionKindAS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionKindAS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution Kind AS</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionKindAS get(int value) {
		switch (value) {
			case CHECK_ONLY: return CHECK_ONLY_LITERAL;
			case ENFORCE: return ENFORCE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ExecutionKindAS(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ExecutionKindAS

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Direction Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#getDirectionKind()
 * @model
 * @generated
 */
public enum DirectionKind implements Enumerator {
	/**
	 * The '<em><b>In dir</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_DIR_VALUE
	 * @generated
	 * @ordered
	 */
	IN_DIR(0, "in_dir", "in_dir"),

	/**
	 * The '<em><b>Out dir</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUT_DIR_VALUE
	 * @generated
	 * @ordered
	 */
	OUT_DIR(1, "out_dir", "out_dir"),

	/**
	 * The '<em><b>Inout dir</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INOUT_DIR_VALUE
	 * @generated
	 * @ordered
	 */
	INOUT_DIR(2, "inout_dir", "inout_dir"),

	/**
	 * The '<em><b>Return dir</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_DIR_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_DIR(3, "return_dir", "return_dir");

	/**
	 * The '<em><b>In dir</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>In dir</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IN_DIR
	 * @model name="in_dir"
	 * @generated
	 * @ordered
	 */
	public static final int IN_DIR_VALUE = 0;

	/**
	 * The '<em><b>Out dir</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Out dir</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUT_DIR
	 * @model name="out_dir"
	 * @generated
	 * @ordered
	 */
	public static final int OUT_DIR_VALUE = 1;

	/**
	 * The '<em><b>Inout dir</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inout dir</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INOUT_DIR
	 * @model name="inout_dir"
	 * @generated
	 * @ordered
	 */
	public static final int INOUT_DIR_VALUE = 2;

	/**
	 * The '<em><b>Return dir</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Return dir</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_DIR
	 * @model name="return_dir"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_DIR_VALUE = 3;

	/**
	 * An array of all the '<em><b>Direction Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DirectionKind[] VALUES_ARRAY =
		new DirectionKind[] {
			IN_DIR,
			OUT_DIR,
			INOUT_DIR,
			RETURN_DIR,
		};

	/**
	 * A public read-only list of all the '<em><b>Direction Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DirectionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Direction Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DirectionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DirectionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Direction Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DirectionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DirectionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Direction Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DirectionKind get(int value) {
		switch (value) {
			case IN_DIR_VALUE: return IN_DIR;
			case OUT_DIR_VALUE: return OUT_DIR;
			case INOUT_DIR_VALUE: return INOUT_DIR;
			case RETURN_DIR_VALUE: return RETURN_DIR;
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
	private DirectionKind(int value, String name, String literal) {
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
	
} //DirectionKind

/**
 * <copyright>
 * </copyright>
 *
 * $Id: Format.java,v 1.2 2010/12/23 10:00:01 akrsharma Exp $
 */
package library;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Format</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see library.LibraryPackage#getFormat()
 * @model
 * @generated
 */
public enum Format implements Enumerator {
	/**
	 * The '<em><b>Hardcover</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARDCOVER_VALUE
	 * @generated
	 * @ordered
	 */
	HARDCOVER(0, "hardcover", "hardcover"),  //$NON-NLS-1$//$NON-NLS-2$

	/**
	 * The '<em><b>Softcover</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFTCOVER_VALUE
	 * @generated
	 * @ordered
	 */
	SOFTCOVER(1, "softcover", "softcover");//$NON-NLS-1$//$NON-NLS-2$

	/**
	 * The '<em><b>Hardcover</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hardcover</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HARDCOVER
	 * @model name="hardcover"
	 * @generated
	 * @ordered
	 */
	public static final int HARDCOVER_VALUE = 0;

	/**
	 * The '<em><b>Softcover</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Softcover</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOFTCOVER
	 * @model name="softcover"
	 * @generated
	 * @ordered
	 */
	public static final int SOFTCOVER_VALUE = 1;

	/**
	 * An array of all the '<em><b>Format</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Format[] VALUES_ARRAY =
		new Format[] {
			HARDCOVER,
			SOFTCOVER,
		};

	/**
	 * A public read-only list of all the '<em><b>Format</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Format> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Format</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Format get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Format result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Format</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Format getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Format result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Format</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Format get(int value) {
		switch (value) {
			case HARDCOVER_VALUE: return HARDCOVER;
			case SOFTCOVER_VALUE: return SOFTCOVER;
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
	private Format(int value, String name, String literal) {
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
	
} //Format

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Abap Signature Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see abapmapping.AbapmappingPackage#getAbapSignatureKind()
 * @model
 * @generated
 */
public enum AbapSignatureKind implements Enumerator {
	/**
     * The '<em><b>QUERY</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #QUERY_VALUE
     * @generated
     * @ordered
     */
	QUERY(0, "QUERY", "QUERY"),

	/**
     * The '<em><b>ACTION</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ACTION_VALUE
     * @generated
     * @ordered
     */
	ACTION(1, "ACTION", "ACTION");

	/**
     * The '<em><b>QUERY</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUERY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #QUERY
     * @model
     * @generated
     * @ordered
     */
	public static final int QUERY_VALUE = 0;

	/**
     * The '<em><b>ACTION</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ACTION
     * @model
     * @generated
     * @ordered
     */
	public static final int ACTION_VALUE = 1;

	/**
     * An array of all the '<em><b>Abap Signature Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final AbapSignatureKind[] VALUES_ARRAY =
		new AbapSignatureKind[] {
            QUERY,
            ACTION,
        };

	/**
     * A public read-only list of all the '<em><b>Abap Signature Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<AbapSignatureKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Abap Signature Kind</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapSignatureKind get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            AbapSignatureKind result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Abap Signature Kind</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapSignatureKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            AbapSignatureKind result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Abap Signature Kind</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapSignatureKind get(int value) {
        switch (value) {
            case QUERY_VALUE: return QUERY;
            case ACTION_VALUE: return ACTION;
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
	private AbapSignatureKind(int value, String name, String literal) {
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
	
} //AbapSignatureKind

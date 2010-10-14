/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.xsd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Att Use Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see integration.xsd.XsdPackage#getAttUseType()
 * @model
 * @generated
 */
public enum AttUseType implements Enumerator {
	/**
     * The '<em><b>Fixed Value</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #FIXED_VALUE_VALUE
     * @generated
     * @ordered
     */
	FIXED_VALUE(0, "fixedValue", "fixedValue"),

	/**
     * The '<em><b>Optional</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OPTIONAL_VALUE
     * @generated
     * @ordered
     */
	OPTIONAL(1, "optional", "optional"),

	/**
     * The '<em><b>Prohibited</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #PROHIBITED_VALUE
     * @generated
     * @ordered
     */
	PROHIBITED(2, "prohibited", "prohibited"),

	/**
     * The '<em><b>Required</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #REQUIRED_VALUE
     * @generated
     * @ordered
     */
	REQUIRED(3, "required", "required");

	/**
     * The '<em><b>Fixed Value</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fixed Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #FIXED_VALUE
     * @model name="fixedValue"
     * @generated
     * @ordered
     */
	public static final int FIXED_VALUE_VALUE = 0;

	/**
     * The '<em><b>Optional</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Optional</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OPTIONAL
     * @model name="optional"
     * @generated
     * @ordered
     */
	public static final int OPTIONAL_VALUE = 1;

	/**
     * The '<em><b>Prohibited</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Prohibited</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #PROHIBITED
     * @model name="prohibited"
     * @generated
     * @ordered
     */
	public static final int PROHIBITED_VALUE = 2;

	/**
     * The '<em><b>Required</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Required</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #REQUIRED
     * @model name="required"
     * @generated
     * @ordered
     */
	public static final int REQUIRED_VALUE = 3;

	/**
     * An array of all the '<em><b>Att Use Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final AttUseType[] VALUES_ARRAY =
		new AttUseType[] {
            FIXED_VALUE,
            OPTIONAL,
            PROHIBITED,
            REQUIRED,
        };

	/**
     * A public read-only list of all the '<em><b>Att Use Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<AttUseType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Att Use Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AttUseType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            AttUseType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Att Use Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AttUseType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            AttUseType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Att Use Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AttUseType get(int value) {
        switch (value) {
            case FIXED_VALUE_VALUE: return FIXED_VALUE;
            case OPTIONAL_VALUE: return OPTIONAL;
            case PROHIBITED_VALUE: return PROHIBITED;
            case REQUIRED_VALUE: return REQUIRED;
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
	private AttUseType(int value, String name, String literal) {
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
	
} //AttUseType

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SAM Operator Kind Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMOperatorKindEnum()
 * @model
 * @generated
 */
public enum SAMOperatorKindEnum implements Enumerator {
	/**
     * The '<em><b>OR</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OR_VALUE
     * @generated
     * @ordered
     */
	OR(0, "OR", "OR"),

	/**
     * The '<em><b>AND</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #AND_VALUE
     * @generated
     * @ordered
     */
	AND(1, "AND", "AND");

	/**
     * The '<em><b>OR</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OR
     * @model
     * @generated
     * @ordered
     */
	public static final int OR_VALUE = 0;

	/**
     * The '<em><b>AND</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #AND
     * @model
     * @generated
     * @ordered
     */
	public static final int AND_VALUE = 1;

	/**
     * An array of all the '<em><b>SAM Operator Kind Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final SAMOperatorKindEnum[] VALUES_ARRAY =
		new SAMOperatorKindEnum[] {
            OR,
            AND,
        };

	/**
     * A public read-only list of all the '<em><b>SAM Operator Kind Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<SAMOperatorKindEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>SAM Operator Kind Enum</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SAMOperatorKindEnum get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SAMOperatorKindEnum result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>SAM Operator Kind Enum</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SAMOperatorKindEnum getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SAMOperatorKindEnum result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>SAM Operator Kind Enum</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SAMOperatorKindEnum get(int value) {
        switch (value) {
            case OR_VALUE: return OR;
            case AND_VALUE: return AND;
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
	private SAMOperatorKindEnum(int value, String name, String literal) {
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
	
} //SAMOperatorKindEnum

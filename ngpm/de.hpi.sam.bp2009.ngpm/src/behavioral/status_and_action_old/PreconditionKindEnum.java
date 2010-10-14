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
 * A representation of the literals of the enumeration '<em><b>Precondition Kind Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getPreconditionKindEnum()
 * @model
 * @generated
 */
public enum PreconditionKindEnum implements Enumerator {
	/**
     * The '<em><b>ENABLE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ENABLE_VALUE
     * @generated
     * @ordered
     */
	ENABLE(0, "ENABLE", "ENABLE"),

	/**
     * The '<em><b>REQUIRED</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #REQUIRED_VALUE
     * @generated
     * @ordered
     */
	REQUIRED(1, "REQUIRED", "REQUIRED"),

	/**
     * The '<em><b>INHIBIT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INHIBIT_VALUE
     * @generated
     * @ordered
     */
	INHIBIT(2, "INHIBIT", "INHIBIT"),

	/**
     * The '<em><b>NEUTEAL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NEUTEAL_VALUE
     * @generated
     * @ordered
     */
	NEUTEAL(3, "NEUTEAL", "NEUTEAL");

	/**
     * The '<em><b>ENABLE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ENABLE
     * @model
     * @generated
     * @ordered
     */
	public static final int ENABLE_VALUE = 0;

	/**
     * The '<em><b>REQUIRED</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REQUIRED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #REQUIRED
     * @model
     * @generated
     * @ordered
     */
	public static final int REQUIRED_VALUE = 1;

	/**
     * The '<em><b>INHIBIT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INHIBIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INHIBIT
     * @model
     * @generated
     * @ordered
     */
	public static final int INHIBIT_VALUE = 2;

	/**
     * The '<em><b>NEUTEAL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEUTEAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #NEUTEAL
     * @model
     * @generated
     * @ordered
     */
	public static final int NEUTEAL_VALUE = 3;

	/**
     * An array of all the '<em><b>Precondition Kind Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final PreconditionKindEnum[] VALUES_ARRAY =
		new PreconditionKindEnum[] {
            ENABLE,
            REQUIRED,
            INHIBIT,
            NEUTEAL,
        };

	/**
     * A public read-only list of all the '<em><b>Precondition Kind Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<PreconditionKindEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Precondition Kind Enum</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PreconditionKindEnum get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PreconditionKindEnum result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Precondition Kind Enum</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PreconditionKindEnum getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PreconditionKindEnum result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Precondition Kind Enum</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PreconditionKindEnum get(int value) {
        switch (value) {
            case ENABLE_VALUE: return ENABLE;
            case REQUIRED_VALUE: return REQUIRED;
            case INHIBIT_VALUE: return INHIBIT;
            case NEUTEAL_VALUE: return NEUTEAL;
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
	private PreconditionKindEnum(int value, String name, String literal) {
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
	
} //PreconditionKindEnum

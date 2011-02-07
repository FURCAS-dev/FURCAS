/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectState.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.constraints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Object State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see data.constraints.ConstraintsPackage#getObjectState()
 * @model
 * @generated
 */
public enum ObjectState implements Enumerator {
	/**
     * The '<em><b>INITIAL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INITIAL_VALUE
     * @generated
     * @ordered
     */
	INITIAL(0, "INITIAL", "INITIAL"),

	/**
     * The '<em><b>TRANSIENT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #TRANSIENT_VALUE
     * @generated
     * @ordered
     */
	TRANSIENT(1, "TRANSIENT", "TRANSIENT"),

	/**
     * The '<em><b>SAVED</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SAVED_VALUE
     * @generated
     * @ordered
     */
	SAVED(2, "SAVED", "SAVED"),

	/**
     * The '<em><b>ACTIVE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ACTIVE_VALUE
     * @generated
     * @ordered
     */
	ACTIVE(3, "ACTIVE", "ACTIVE"),

	/**
     * The '<em><b>COMPLIANT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #COMPLIANT_VALUE
     * @generated
     * @ordered
     */
	COMPLIANT(4, "COMPLIANT", "COMPLIANT");

	/**
     * The '<em><b>INITIAL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INITIAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INITIAL
     * @model
     * @generated
     * @ordered
     */
	public static final int INITIAL_VALUE = 0;

	/**
     * The '<em><b>TRANSIENT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSIENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #TRANSIENT
     * @model
     * @generated
     * @ordered
     */
	public static final int TRANSIENT_VALUE = 1;

	/**
     * The '<em><b>SAVED</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAVED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SAVED
     * @model
     * @generated
     * @ordered
     */
	public static final int SAVED_VALUE = 2;

	/**
     * The '<em><b>ACTIVE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ACTIVE
     * @model
     * @generated
     * @ordered
     */
	public static final int ACTIVE_VALUE = 3;

	/**
     * The '<em><b>COMPLIANT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPLIANT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #COMPLIANT
     * @model
     * @generated
     * @ordered
     */
	public static final int COMPLIANT_VALUE = 4;

	/**
     * An array of all the '<em><b>Object State</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final ObjectState[] VALUES_ARRAY =
		new ObjectState[] {
            INITIAL,
            TRANSIENT,
            SAVED,
            ACTIVE,
            COMPLIANT,
        };

	/**
     * A public read-only list of all the '<em><b>Object State</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<ObjectState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Object State</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ObjectState get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ObjectState result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Object State</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ObjectState getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ObjectState result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Object State</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static ObjectState get(int value) {
        switch (value) {
            case INITIAL_VALUE: return INITIAL;
            case TRANSIENT_VALUE: return TRANSIENT;
            case SAVED_VALUE: return SAVED;
            case ACTIVE_VALUE: return ACTIVE;
            case COMPLIANT_VALUE: return COMPLIANT;
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
	private ObjectState(int value, String name, String literal) {
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
	
} //ObjectState

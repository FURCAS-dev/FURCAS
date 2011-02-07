/**
 * <copyright>
 * </copyright>
 *
 * $Id: Severity.java,v 1.1 2011/02/07 16:49:10 auhl Exp $
 */
package data.constraints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Severity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see data.constraints.ConstraintsPackage#getSeverity()
 * @model
 * @generated
 */
public enum Severity implements Enumerator {
	/**
     * The '<em><b>WARNING</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #WARNING_VALUE
     * @generated
     * @ordered
     */
	WARNING(0, "WARNING", "WARNING"),

	/**
     * The '<em><b>ERROR</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ERROR_VALUE
     * @generated
     * @ordered
     */
	ERROR(1, "ERROR", "ERROR"),

	/**
     * The '<em><b>ILLEGAL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ILLEGAL_VALUE
     * @generated
     * @ordered
     */
	ILLEGAL(2, "ILLEGAL", "ILLEGAL");

	/**
     * The '<em><b>WARNING</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WARNING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #WARNING
     * @model
     * @generated
     * @ordered
     */
	public static final int WARNING_VALUE = 0;

	/**
     * The '<em><b>ERROR</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ERROR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ERROR
     * @model
     * @generated
     * @ordered
     */
	public static final int ERROR_VALUE = 1;

	/**
     * The '<em><b>ILLEGAL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ILLEGAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ILLEGAL
     * @model
     * @generated
     * @ordered
     */
	public static final int ILLEGAL_VALUE = 2;

	/**
     * An array of all the '<em><b>Severity</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final Severity[] VALUES_ARRAY =
		new Severity[] {
            WARNING,
            ERROR,
            ILLEGAL,
        };

	/**
     * A public read-only list of all the '<em><b>Severity</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<Severity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Severity</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Severity get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Severity result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Severity</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Severity getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Severity result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Severity</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Severity get(int value) {
        switch (value) {
            case WARNING_VALUE: return WARNING;
            case ERROR_VALUE: return ERROR;
            case ILLEGAL_VALUE: return ILLEGAL;
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
	private Severity(int value, String name, String literal) {
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
	
} //Severity

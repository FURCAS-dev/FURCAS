/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMDerivatorKindEnum.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.status_and_action_old;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SAM Derivator Kind Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage#getSAMDerivatorKindEnum()
 * @model
 * @generated
 */
public enum SAMDerivatorKindEnum implements Enumerator {
	/**
     * The '<em><b>POPULATION</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #POPULATION_VALUE
     * @generated
     * @ordered
     */
	POPULATION(0, "POPULATION", "POPULATION"),

	/**
     * The '<em><b>AGGREGATION</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #AGGREGATION_VALUE
     * @generated
     * @ordered
     */
	AGGREGATION(1, "AGGREGATION", "AGGREGATION"),

	/**
     * The '<em><b>OVERALL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #OVERALL_VALUE
     * @generated
     * @ordered
     */
	OVERALL(2, "OVERALL", "OVERALL");

	/**
     * The '<em><b>POPULATION</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POPULATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #POPULATION
     * @model
     * @generated
     * @ordered
     */
	public static final int POPULATION_VALUE = 0;

	/**
     * The '<em><b>AGGREGATION</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AGGREGATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #AGGREGATION
     * @model
     * @generated
     * @ordered
     */
	public static final int AGGREGATION_VALUE = 1;

	/**
     * The '<em><b>OVERALL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #OVERALL
     * @model
     * @generated
     * @ordered
     */
	public static final int OVERALL_VALUE = 2;

	/**
     * An array of all the '<em><b>SAM Derivator Kind Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final SAMDerivatorKindEnum[] VALUES_ARRAY =
		new SAMDerivatorKindEnum[] {
            POPULATION,
            AGGREGATION,
            OVERALL,
        };

	/**
     * A public read-only list of all the '<em><b>SAM Derivator Kind Enum</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<SAMDerivatorKindEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>SAM Derivator Kind Enum</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SAMDerivatorKindEnum get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SAMDerivatorKindEnum result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>SAM Derivator Kind Enum</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SAMDerivatorKindEnum getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SAMDerivatorKindEnum result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>SAM Derivator Kind Enum</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SAMDerivatorKindEnum get(int value) {
        switch (value) {
            case POPULATION_VALUE: return POPULATION;
            case AGGREGATION_VALUE: return AGGREGATION;
            case OVERALL_VALUE: return OVERALL;
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
	private SAMDerivatorKindEnum(int value, String name, String literal) {
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
	
} //SAMDerivatorKindEnum

/**
 * <copyright>
 * </copyright>
 *
 * $Id: SnapshotSelection.java,v 1.1 2011/02/07 17:21:36 auhl Exp $
 */
package persistence.expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Snapshot Selection</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see persistence.expressions.ExpressionsPackage#getSnapshotSelection()
 * @model
 * @generated
 */
public enum SnapshotSelection implements Enumerator {
	/**
     * The '<em><b>DEFAULT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DEFAULT_VALUE
     * @generated
     * @ordered
     */
	DEFAULT(0, "DEFAULT", "DEFAULT"),

	/**
     * The '<em><b>ALL</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ALL_VALUE
     * @generated
     * @ordered
     */
	ALL(1, "ALL", "ALL"),

	/**
     * The '<em><b>CHANGED</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #CHANGED_VALUE
     * @generated
     * @ordered
     */
	CHANGED(2, "CHANGED", "CHANGED"),

	/**
     * The '<em><b>SPECIFIED</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SPECIFIED_VALUE
     * @generated
     * @ordered
     */
	SPECIFIED(3, "SPECIFIED", "SPECIFIED");

	/**
     * The '<em><b>DEFAULT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DEFAULT
     * @model
     * @generated
     * @ordered
     */
	public static final int DEFAULT_VALUE = 0;

	/**
     * The '<em><b>ALL</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ALL
     * @model
     * @generated
     * @ordered
     */
	public static final int ALL_VALUE = 1;

	/**
     * The '<em><b>CHANGED</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANGED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #CHANGED
     * @model
     * @generated
     * @ordered
     */
	public static final int CHANGED_VALUE = 2;

	/**
     * The '<em><b>SPECIFIED</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPECIFIED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SPECIFIED
     * @model
     * @generated
     * @ordered
     */
	public static final int SPECIFIED_VALUE = 3;

	/**
     * An array of all the '<em><b>Snapshot Selection</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final SnapshotSelection[] VALUES_ARRAY =
		new SnapshotSelection[] {
            DEFAULT,
            ALL,
            CHANGED,
            SPECIFIED,
        };

	/**
     * A public read-only list of all the '<em><b>Snapshot Selection</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<SnapshotSelection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Snapshot Selection</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SnapshotSelection get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SnapshotSelection result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Snapshot Selection</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SnapshotSelection getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SnapshotSelection result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Snapshot Selection</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static SnapshotSelection get(int value) {
        switch (value) {
            case DEFAULT_VALUE: return DEFAULT;
            case ALL_VALUE: return ALL;
            case CHANGED_VALUE: return CHANGED;
            case SPECIFIED_VALUE: return SPECIFIED;
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
	private SnapshotSelection(int value, String name, String literal) {
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
	
} //SnapshotSelection

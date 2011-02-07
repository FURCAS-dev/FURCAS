/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapClassKind.java,v 1.1 2011/02/07 16:43:34 auhl Exp $
 */
package abapmapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Abap Class Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see abapmapping.AbapmappingPackage#getAbapClassKind()
 * @model
 * @generated
 */
public enum AbapClassKind implements Enumerator {
	/**
     * The '<em><b>BO AND ROOT NODE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BO_AND_ROOT_NODE_VALUE
     * @generated
     * @ordered
     */
	BO_AND_ROOT_NODE(0, "BO_AND_ROOT_NODE", "BO_AND_ROOT_NODE"),

	/**
     * The '<em><b>BO NODE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BO_NODE_VALUE
     * @generated
     * @ordered
     */
	BO_NODE(1, "BO_NODE", "BO_NODE"),

	/**
     * The '<em><b>DEPENDENT OBJECT</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DEPENDENT_OBJECT_VALUE
     * @generated
     * @ordered
     */
	DEPENDENT_OBJECT(2, "DEPENDENT_OBJECT", "DEPENDENT_OBJECT"),

	/**
     * The '<em><b>DATA TYPE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #DATA_TYPE_VALUE
     * @generated
     * @ordered
     */
	DATA_TYPE(3, "DATA_TYPE", "DATA_TYPE"),

	/**
     * The '<em><b>ABAP TYPE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ABAP_TYPE_VALUE
     * @generated
     * @ordered
     */
	ABAP_TYPE(4, "ABAP_TYPE", "ABAP_TYPE");

	/**
     * The '<em><b>BO AND ROOT NODE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BO AND ROOT NODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #BO_AND_ROOT_NODE
     * @model
     * @generated
     * @ordered
     */
	public static final int BO_AND_ROOT_NODE_VALUE = 0;

	/**
     * The '<em><b>BO NODE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BO NODE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #BO_NODE
     * @model
     * @generated
     * @ordered
     */
	public static final int BO_NODE_VALUE = 1;

	/**
     * The '<em><b>DEPENDENT OBJECT</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEPENDENT OBJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DEPENDENT_OBJECT
     * @model
     * @generated
     * @ordered
     */
	public static final int DEPENDENT_OBJECT_VALUE = 2;

	/**
     * The '<em><b>DATA TYPE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATA TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #DATA_TYPE
     * @model
     * @generated
     * @ordered
     */
	public static final int DATA_TYPE_VALUE = 3;

	/**
     * The '<em><b>ABAP TYPE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABAP TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #ABAP_TYPE
     * @model
     * @generated
     * @ordered
     */
	public static final int ABAP_TYPE_VALUE = 4;

	/**
     * An array of all the '<em><b>Abap Class Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final AbapClassKind[] VALUES_ARRAY =
		new AbapClassKind[] {
            BO_AND_ROOT_NODE,
            BO_NODE,
            DEPENDENT_OBJECT,
            DATA_TYPE,
            ABAP_TYPE,
        };

	/**
     * A public read-only list of all the '<em><b>Abap Class Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<AbapClassKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Abap Class Kind</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapClassKind get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            AbapClassKind result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Abap Class Kind</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapClassKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            AbapClassKind result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Abap Class Kind</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AbapClassKind get(int value) {
        switch (value) {
            case BO_AND_ROOT_NODE_VALUE: return BO_AND_ROOT_NODE;
            case BO_NODE_VALUE: return BO_NODE;
            case DEPENDENT_OBJECT_VALUE: return DEPENDENT_OBJECT;
            case DATA_TYPE_VALUE: return DATA_TYPE;
            case ABAP_TYPE_VALUE: return ABAP_TYPE;
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
	private AbapClassKind(int value, String name, String literal) {
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
	
} //AbapClassKind

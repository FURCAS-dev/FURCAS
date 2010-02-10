/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>tasks</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierPackage#getTask()
 * @model instanceClass="de.hpi.sam.bp2009.randomModelModifier.Task"
 * @generated
 */
public enum Task implements Enumerator {
	/**
	 * The '<em><b>Class Delete</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASS_DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	CLASS_DELETE(0, "classDelete", "classDelete"),

	/**
	 * The '<em><b>Class Create</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASS_CREATE_VALUE
	 * @generated
	 * @ordered
	 */
	CLASS_CREATE(1, "classCreate", "classCreate"),

	/**
	 * The '<em><b>Reference Delete</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCE_DELETE(2, "referenceDelete", "referenceDelete"),

	/**
	 * The '<em><b>Reference Create</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_CREATE_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCE_CREATE(3, "referenceCreate", "referenceCreate"),

	/**
	 * The '<em><b>Modify Attribute</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODIFY_ATTRIBUTE_VALUE
	 * @generated
	 * @ordered
	 */
	MODIFY_ATTRIBUTE(4, "modifyAttribute", "modifyAttribute");

	/**
	 * The '<em><b>Class Delete</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Class Delete</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASS_DELETE
	 * @model name="classDelete"
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_DELETE_VALUE = 0;

	/**
	 * The '<em><b>Class Create</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Class Create</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASS_CREATE
	 * @model name="classCreate"
	 * @generated
	 * @ordered
	 */
	public static final int CLASS_CREATE_VALUE = 1;

	/**
	 * The '<em><b>Reference Delete</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reference Delete</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_DELETE
	 * @model name="referenceDelete"
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_DELETE_VALUE = 2;

	/**
	 * The '<em><b>Reference Create</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Reference Create</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_CREATE
	 * @model name="referenceCreate"
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_CREATE_VALUE = 3;

	/**
	 * The '<em><b>Modify Attribute</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Modify Attribute</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODIFY_ATTRIBUTE
	 * @model name="modifyAttribute"
	 * @generated
	 * @ordered
	 */
	public static final int MODIFY_ATTRIBUTE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Task</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Task[] VALUES_ARRAY =
		new Task[] {
			CLASS_DELETE,
			CLASS_CREATE,
			REFERENCE_DELETE,
			REFERENCE_CREATE,
			MODIFY_ATTRIBUTE,
		};

	/**
	 * A public read-only list of all the '<em><b>Task</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Task> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Task</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Task get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Task result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Task</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Task getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Task result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Task</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Task get(int value) {
		switch (value) {
			case CLASS_DELETE_VALUE: return CLASS_DELETE;
			case CLASS_CREATE_VALUE: return CLASS_CREATE;
			case REFERENCE_DELETE_VALUE: return REFERENCE_DELETE;
			case REFERENCE_CREATE_VALUE: return REFERENCE_CREATE;
			case MODIFY_ATTRIBUTE_VALUE: return MODIFY_ATTRIBUTE;
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
	private Task(int value, String name, String literal) {
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
	
} //tasks

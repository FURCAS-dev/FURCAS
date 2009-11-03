/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Enumeration Test Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage#getEnumerationTestType()
 * @model
 * @generated
 */
public final class EnumerationTestType extends AbstractEnumerator {
	/**
	 * The '<em><b>Label3</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Label3</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LABEL3_LITERAL
	 * @model name="Label3"
	 * @generated
	 * @ordered
	 */
	public static final int LABEL3 = 0;

	/**
	 * The '<em><b>Label4</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Label4</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LABEL4_LITERAL
	 * @model name="Label4"
	 * @generated
	 * @ordered
	 */
	public static final int LABEL4 = 1;

	/**
	 * The '<em><b>Label1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Label1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LABEL1_LITERAL
	 * @model name="Label1"
	 * @generated
	 * @ordered
	 */
	public static final int LABEL1 = 2;

	/**
	 * The '<em><b>Label2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Label2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LABEL2_LITERAL
	 * @model name="Label2"
	 * @generated
	 * @ordered
	 */
	public static final int LABEL2 = 3;

	/**
	 * The '<em><b>Label3</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LABEL3
	 * @generated
	 * @ordered
	 */
	public static final EnumerationTestType LABEL3_LITERAL = new EnumerationTestType(LABEL3, "Label3", "Label3");

	/**
	 * The '<em><b>Label4</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LABEL4
	 * @generated
	 * @ordered
	 */
	public static final EnumerationTestType LABEL4_LITERAL = new EnumerationTestType(LABEL4, "Label4", "Label4");

	/**
	 * The '<em><b>Label1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LABEL1
	 * @generated
	 * @ordered
	 */
	public static final EnumerationTestType LABEL1_LITERAL = new EnumerationTestType(LABEL1, "Label1", "Label1");

	/**
	 * The '<em><b>Label2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LABEL2
	 * @generated
	 * @ordered
	 */
	public static final EnumerationTestType LABEL2_LITERAL = new EnumerationTestType(LABEL2, "Label2", "Label2");

	/**
	 * An array of all the '<em><b>Enumeration Test Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EnumerationTestType[] VALUES_ARRAY =
		new EnumerationTestType[] {
			LABEL3_LITERAL,
			LABEL4_LITERAL,
			LABEL1_LITERAL,
			LABEL2_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Enumeration Test Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Enumeration Test Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumerationTestType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumerationTestType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enumeration Test Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumerationTestType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EnumerationTestType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Enumeration Test Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EnumerationTestType get(int value) {
		switch (value) {
			case LABEL3: return LABEL3_LITERAL;
			case LABEL4: return LABEL4_LITERAL;
			case LABEL1: return LABEL1_LITERAL;
			case LABEL2: return LABEL2_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EnumerationTestType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //EnumerationTestType

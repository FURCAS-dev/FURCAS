/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Notify Literals</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage#getNotifyLiterals()
 * @model
 * @generated
 */
public enum NotifyLiterals implements Enumerator {
	/**
	 * The '<em><b>START FILTER CREATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_FILTER_CREATION_VALUE
	 * @generated
	 * @ordered
	 */
	START_FILTER_CREATION(0, "START_FILTER_CREATION", "START_FILTER_CREATION"), /**
	 * The '<em><b>END FILTER CREATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_FILTER_CREATION_VALUE
	 * @generated
	 * @ordered
	 */
	END_FILTER_CREATION(1, "END_FILTER_CREATION", "END_FILTER_CREATION"), /**
	 * The '<em><b>START CONTEXT OBJECT ANALYZATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_CONTEXT_OBJECT_ANALYZATION_VALUE
	 * @generated
	 * @ordered
	 */
	START_CONTEXT_OBJECT_ANALYZATION(2, "START_CONTEXT_OBJECT_ANALYZATION", "START_CONTEXT_OBJECT_ANALYZATION"), /**
	 * The '<em><b>END CONTEXT OBJECT ANALYZATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_CONTEXT_OBJECT_ANALYZATION_VALUE
	 * @generated
	 * @ordered
	 */
	END_CONTEXT_OBJECT_ANALYZATION(3, "END_CONTEXT_OBJECT_ANALYZATION", "END_CONTEXT_OBJECT_ANALYZATION");

	/**
	 * The '<em><b>START FILTER CREATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START FILTER CREATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_FILTER_CREATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_FILTER_CREATION_VALUE = 0;

	/**
	 * The '<em><b>END FILTER CREATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END FILTER CREATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END_FILTER_CREATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int END_FILTER_CREATION_VALUE = 1;

	/**
	 * The '<em><b>START CONTEXT OBJECT ANALYZATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START CONTEXT OBJECT ANALYZATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_CONTEXT_OBJECT_ANALYZATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_CONTEXT_OBJECT_ANALYZATION_VALUE = 2;

	/**
	 * The '<em><b>END CONTEXT OBJECT ANALYZATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END CONTEXT OBJECT ANALYZATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END_CONTEXT_OBJECT_ANALYZATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int END_CONTEXT_OBJECT_ANALYZATION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Notify Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NotifyLiterals[] VALUES_ARRAY =
		new NotifyLiterals[] {
			START_FILTER_CREATION,
			END_FILTER_CREATION,
			START_CONTEXT_OBJECT_ANALYZATION,
			END_CONTEXT_OBJECT_ANALYZATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Notify Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<NotifyLiterals> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Notify Literals</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NotifyLiterals get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NotifyLiterals result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Notify Literals</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NotifyLiterals getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NotifyLiterals result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Notify Literals</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NotifyLiterals get(int value) {
		switch (value) {
			case START_FILTER_CREATION_VALUE: return START_FILTER_CREATION;
			case END_FILTER_CREATION_VALUE: return END_FILTER_CREATION;
			case START_CONTEXT_OBJECT_ANALYZATION_VALUE: return START_CONTEXT_OBJECT_ANALYZATION;
			case END_CONTEXT_OBJECT_ANALYZATION_VALUE: return END_CONTEXT_OBJECT_ANALYZATION;
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
	private NotifyLiterals(int value, String name, String literal) {
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
	
} //NotifyLiterals

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Measurable Class Literals</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#getMeasurableClassLiterals()
 * @model
 * @generated
 */
public enum MeasurableClassLiterals implements Enumerator {
	/**
	 * The '<em><b>IMPACT ANALYZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPACT_ANALYZER_VALUE
	 * @generated
	 * @ordered
	 */
	IMPACT_ANALYZER(0, "IMPACT_ANALYZER", "IMPACT_ANALYZER"),

	/**
	 * The '<em><b>EVENT MANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVENT_MANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	EVENT_MANAGER(1, "EVENT_MANAGER", "EVENT_MANAGER"),

	/**
	 * The '<em><b>OCL EVALUATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OCL_EVALUATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OCL_EVALUATOR(2, "OCL_EVALUATOR", "OCL_EVALUATOR");

	/**
	 * The '<em><b>IMPACT ANALYZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMPACT ANALYZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPACT_ANALYZER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMPACT_ANALYZER_VALUE = 0;

	/**
	 * The '<em><b>EVENT MANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EVENT MANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVENT_MANAGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EVENT_MANAGER_VALUE = 1;

	/**
	 * The '<em><b>OCL EVALUATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OCL EVALUATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OCL_EVALUATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OCL_EVALUATOR_VALUE = 2;

	/**
	 * An array of all the '<em><b>Measurable Class Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MeasurableClassLiterals[] VALUES_ARRAY =
		new MeasurableClassLiterals[] {
			IMPACT_ANALYZER,
			EVENT_MANAGER,
			OCL_EVALUATOR,
		};

	/**
	 * A public read-only list of all the '<em><b>Measurable Class Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MeasurableClassLiterals> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Measurable Class Literals</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeasurableClassLiterals get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MeasurableClassLiterals result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Measurable Class Literals</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeasurableClassLiterals getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MeasurableClassLiterals result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Measurable Class Literals</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeasurableClassLiterals get(int value) {
		switch (value) {
			case IMPACT_ANALYZER_VALUE: return IMPACT_ANALYZER;
			case EVENT_MANAGER_VALUE: return EVENT_MANAGER;
			case OCL_EVALUATOR_VALUE: return OCL_EVALUATOR;
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
	private MeasurableClassLiterals(int value, String name, String literal) {
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
	
} //MeasurableClassLiterals

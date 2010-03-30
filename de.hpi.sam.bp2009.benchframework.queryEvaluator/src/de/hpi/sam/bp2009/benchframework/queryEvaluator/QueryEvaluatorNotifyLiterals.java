/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.queryEvaluator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Notify Literals</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorPackage#getQueryEvaluatorNotifyLiterals()
 * @model
 * @generated
 */
public enum QueryEvaluatorNotifyLiterals implements Enumerator {
	/**
	 * The '<em><b>START QUERY EVALUATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_QUERY_EVALUATION_VALUE
	 * @generated
	 * @ordered
	 */
	START_QUERY_EVALUATION(0, "START_QUERY_EVALUATION", "START_QUERY_EVALUATION"),

	/**
	 * The '<em><b>END QUERY EVALUATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_QUERY_EVALUATION_VALUE
	 * @generated
	 * @ordered
	 */
	END_QUERY_EVALUATION(1, "END_QUERY_EVALUATION", "END_QUERY_EVALUATION");

	/**
	 * The '<em><b>START QUERY EVALUATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START QUERY EVALUATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_QUERY_EVALUATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_QUERY_EVALUATION_VALUE = 0;

	/**
	 * The '<em><b>END QUERY EVALUATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END QUERY EVALUATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END_QUERY_EVALUATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int END_QUERY_EVALUATION_VALUE = 1;

	/**
	 * An array of all the '<em><b>Notify Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final QueryEvaluatorNotifyLiterals[] VALUES_ARRAY =
		new QueryEvaluatorNotifyLiterals[] {
			START_QUERY_EVALUATION,
			END_QUERY_EVALUATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Notify Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<QueryEvaluatorNotifyLiterals> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Notify Literals</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueryEvaluatorNotifyLiterals get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QueryEvaluatorNotifyLiterals result = VALUES_ARRAY[i];
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
	public static QueryEvaluatorNotifyLiterals getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QueryEvaluatorNotifyLiterals result = VALUES_ARRAY[i];
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
	public static QueryEvaluatorNotifyLiterals get(int value) {
		switch (value) {
			case START_QUERY_EVALUATION_VALUE: return START_QUERY_EVALUATION;
			case END_QUERY_EVALUATION_VALUE: return END_QUERY_EVALUATION;
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
	private QueryEvaluatorNotifyLiterals(int value, String name, String literal) {
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
	
} //QueryEvaluatorNotifyLiterals

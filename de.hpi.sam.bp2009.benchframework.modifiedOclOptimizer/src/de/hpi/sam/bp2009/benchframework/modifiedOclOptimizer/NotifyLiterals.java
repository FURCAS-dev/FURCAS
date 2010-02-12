/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Notify Literals</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerPackage#getNotifyLiterals()
 * @model
 * @generated
 */
public enum NotifyLiterals implements Enumerator {
	/**
	 * The '<em><b>SEND QUERY TO INTERPRETER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEND_QUERY_TO_INTERPRETER_VALUE
	 * @generated
	 * @ordered
	 */
	SEND_QUERY_TO_INTERPRETER(0, "SEND_QUERY_TO_INTERPRETER", "SEND_QUERY_TO_INTERPRETER"),

	/**
	 * The '<em><b>GET RESULT FROM INTERPRETER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_RESULT_FROM_INTERPRETER_VALUE
	 * @generated
	 * @ordered
	 */
	GET_RESULT_FROM_INTERPRETER(1, "GET_RESULT_FROM_INTERPRETER", "GET_RESULT_FROM_INTERPRETER"),

	/**
	 * The '<em><b>START EVALUATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_EVALUATION_VALUE
	 * @generated
	 * @ordered
	 */
	START_EVALUATION(2, "START_EVALUATION", "START_EVALUATION"),

	/**
	 * The '<em><b>END EVALUATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_EVALUATION_VALUE
	 * @generated
	 * @ordered
	 */
	END_EVALUATION(3, "END_EVALUATION", "END_EVALUATION");

	/**
	 * The '<em><b>SEND QUERY TO INTERPRETER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEND QUERY TO INTERPRETER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEND_QUERY_TO_INTERPRETER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEND_QUERY_TO_INTERPRETER_VALUE = 0;

	/**
	 * The '<em><b>GET RESULT FROM INTERPRETER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GET RESULT FROM INTERPRETER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET_RESULT_FROM_INTERPRETER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GET_RESULT_FROM_INTERPRETER_VALUE = 1;

	/**
	 * The '<em><b>START EVALUATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START EVALUATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_EVALUATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_EVALUATION_VALUE = 2;

	/**
	 * The '<em><b>END EVALUATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END EVALUATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END_EVALUATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int END_EVALUATION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Notify Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NotifyLiterals[] VALUES_ARRAY =
		new NotifyLiterals[] {
			SEND_QUERY_TO_INTERPRETER,
			GET_RESULT_FROM_INTERPRETER,
			START_EVALUATION,
			END_EVALUATION,
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
			case SEND_QUERY_TO_INTERPRETER_VALUE: return SEND_QUERY_TO_INTERPRETER;
			case GET_RESULT_FROM_INTERPRETER_VALUE: return GET_RESULT_FROM_INTERPRETER;
			case START_EVALUATION_VALUE: return START_EVALUATION;
			case END_EVALUATION_VALUE: return END_EVALUATION;
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

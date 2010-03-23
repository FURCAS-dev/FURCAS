/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Operators that need have Start- and Endpoint should subclass this EndOperator with their specific endpoint.
 * Subclasses of Start- and EndOperator are treated special when they occur in a loop for example.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.EndOperator#getStartOperator <em>Start Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEndOperator()
 * @model
 * @generated
 */
public interface EndOperator extends Operator {

	/**
	 * Returns the value of the '<em><b>Start Operator</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.bp2009.benchframework.StartOperator#getEndOperator <em>End Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Operator</em>' reference.
	 * @see #setStartOperator(StartOperator)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getEndOperator_StartOperator()
	 * @see de.hpi.sam.bp2009.benchframework.StartOperator#getEndOperator
	 * @model opposite="endOperator"
	 * @generated
	 */
	StartOperator getStartOperator();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.EndOperator#getStartOperator <em>Start Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Operator</em>' reference.
	 * @see #getStartOperator()
	 * @generated
	 */
	void setStartOperator(StartOperator value);

} // EndOperator

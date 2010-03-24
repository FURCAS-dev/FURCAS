/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Operators that need have Start- and Endpoint should subclass this StartOperator with their specific startpoint.
 * Subclasses of Start- and EndOperator are treated special when they occur in a loop for example.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.StartOperator#getEndOperator <em>End Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getStartOperator()
 * @model abstract="true"
 * @generated
 */
public interface StartOperator extends Operator {

	/**
	 * Returns the value of the '<em><b>End Operator</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.bp2009.benchframework.EndOperator#getStartOperator <em>Start Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Operator</em>' reference.
	 * @see #setEndOperator(EndOperator)
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#getStartOperator_EndOperator()
	 * @see de.hpi.sam.bp2009.benchframework.EndOperator#getStartOperator
	 * @model opposite="startOperator"
	 * @generated
	 */
	EndOperator getEndOperator();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.benchframework.StartOperator#getEndOperator <em>End Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Operator</em>' reference.
	 * @see #getEndOperator()
	 * @generated
	 */
	void setEndOperator(EndOperator value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EndOperator createEndOperator();

} // StartOperator

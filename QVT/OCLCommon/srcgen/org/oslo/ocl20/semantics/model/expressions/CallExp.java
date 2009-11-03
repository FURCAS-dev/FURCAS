/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Call Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.CallExp#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCallExp()
 * @model
 * @generated
 */
public interface CallExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference. It is bidirectional
	 * and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getAppliedProperty
	 * <em>Applied Property</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCallExp_Source()
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getAppliedProperty
	 * @model opposite="appliedProperty" containment="true"
	 * @generated
	 */
	OclExpression getSource();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.model.expressions.CallExp#getSource
	 * <em>Source</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OclExpression value);

} // CallExp

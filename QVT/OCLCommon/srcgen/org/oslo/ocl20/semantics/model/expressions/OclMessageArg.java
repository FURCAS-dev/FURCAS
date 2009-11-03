/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ocl Message Arg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getExpression <em>Expression
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getUnspecified <em>
 * Unspecified</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclMessageArg()
 * @model
 * @generated
 */
public interface OclMessageArg extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclMessageArg_Expression()
	 * @model
	 * @generated
	 */
	OclExpression getExpression();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getExpression
	 * <em>Expression</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Unspecified</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unspecified</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unspecified</em>' reference.
	 * @see #setUnspecified(UnspecifiedValueExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclMessageArg_Unspecified()
	 * @model
	 * @generated
	 */
	UnspecifiedValueExp getUnspecified();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getUnspecified
	 * <em>Unspecified</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Unspecified</em>' reference.
	 * @see #getUnspecified()
	 * @generated
	 */
	void setUnspecified(UnspecifiedValueExp value);

} // OclMessageArg

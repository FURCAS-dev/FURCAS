/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>If Exp</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.IfExp#getElseExpression <em>Else Expression
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.IfExp#getThenExpression <em>Then Expression
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.IfExp#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getIfExp()
 * @model
 * @generated
 */
public interface IfExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Else Expression</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Else Expression</em>' containment reference.
	 * @see #setElseExpression(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getIfExp_ElseExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getElseExpression();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IfExp#getElseExpression
	 * <em>Else Expression</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Else Expression</em>' containment reference.
	 * @see #getElseExpression()
	 * @generated
	 */
	void setElseExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Then Expression</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Then Expression</em>' containment reference.
	 * @see #setThenExpression(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getIfExp_ThenExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getThenExpression();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IfExp#getThenExpression
	 * <em>Then Expression</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Then Expression</em>' containment reference.
	 * @see #getThenExpression()
	 * @generated
	 */
	void setThenExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getIfExp_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getCondition();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.model.expressions.IfExp#getCondition
	 * <em>Condition</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OclExpression value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // IfExp

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ocl Message Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclMessageExp#getArguments <em>Arguments
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclMessageExp#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclMessageExp()
 * @model
 * @generated
 */
public interface OclMessageExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list. The list contents are of
	 * type {@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclMessageExp_Arguments()
	 * @model type="org.oslo.ocl20.semantics.model.expressions.OclMessageArg"
	 * @generated
	 */
	EList getArguments();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclMessageExp_Target()
	 * @model required="true"
	 * @generated
	 */
	OclExpression getTarget();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageExp#getTarget <em>Target</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OclExpression value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // OclMessageExp

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Operation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Operation Call Exp</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getReferredOperation <em>
 * Referred Operation</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getArguments <em>Arguments
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOperationCallExp()
 * @model
 * @generated
 */
public interface OperationCallExp extends ModelPropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referred Operation</em>' reference.
	 * @see #setReferredOperation(Operation)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOperationCallExp_ReferredOperation()
	 * @model required="true"
	 * @generated
	 */
	Operation getReferredOperation();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getReferredOperation
	 * <em>Referred Operation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list. The list
	 * contents are of type {@link org.oslo.ocl20.semantics.model.expressions.OclExpression}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getOperationCallExp
	 * <em>Operation Call Exp</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOperationCallExp_Arguments()
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getOperationCallExp
	 * @model type="org.oslo.ocl20.semantics.model.expressions.OclExpression"
	 *        opposite="operationCallExp" containment="true"
	 * @generated
	 */
	EList getArguments();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // OperationCallExp

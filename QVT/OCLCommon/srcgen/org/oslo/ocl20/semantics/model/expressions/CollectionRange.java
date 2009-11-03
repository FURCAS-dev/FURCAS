/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.CollectionRange#getLast <em>Last</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.CollectionRange#getFirst <em>First</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionRange()
 * @model
 * @generated
 */
public interface CollectionRange extends CollectionLiteralPart {
	/**
	 * Returns the value of the '<em><b>Last</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Last</em>' reference.
	 * @see #setLast(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionRange_Last()
	 * @model required="true"
	 * @generated
	 */
	OclExpression getLast();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionRange#getLast <em>Last</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Last</em>' reference.
	 * @see #getLast()
	 * @generated
	 */
	void setLast(OclExpression value);

	/**
	 * Returns the value of the '<em><b>First</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>First</em>' reference.
	 * @see #setFirst(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionRange_First()
	 * @model required="true"
	 * @generated
	 */
	OclExpression getFirst();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionRange#getFirst <em>First</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>First</em>' reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(OclExpression value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // CollectionRange

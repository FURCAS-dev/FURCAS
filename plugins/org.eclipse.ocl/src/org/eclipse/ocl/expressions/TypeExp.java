/**
 * <copyright>
 * </copyright>
 *
 * $Id: TypeExp.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.TypeExp#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTypeExp()
 * @model
 * @generated
 */
public interface TypeExp<C> extends OCLExpression<C> {
	/**
	 * Returns the value of the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Type</em>' reference.
	 * @see #setReferredType(C)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTypeExp_ReferredType()
	 * @model
	 * @generated
	 */
	C getReferredType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.TypeExp#getReferredType <em>Referred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Type</em>' reference.
	 * @see #getReferredType()
	 * @generated
	 */
	void setReferredType(C value);

} // TypeExp

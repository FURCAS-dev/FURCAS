/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionRange.java,v 1.1 2007/01/25 18:24:33 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionRange#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionRange#getLast <em>Last</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionRange()
 * @model
 * @generated
 */
public interface CollectionRange<C> extends CollectionLiteralPart<C> {
	/**
     * Returns the value of the '<em><b>First</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>First</em>' containment reference.
     * @see #setFirst(OCLExpression<C>)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionRange_First()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<C> getFirst();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.CollectionRange#getFirst <em>First</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>First</em>' containment reference.
     * @see #getFirst()
     * @generated
     */
	void setFirst(OCLExpression<C> value);

	/**
     * Returns the value of the '<em><b>Last</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Last</em>' containment reference.
     * @see #setLast(OCLExpression<C>)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionRange_Last()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<C> getLast();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.CollectionRange#getLast <em>Last</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Last</em>' containment reference.
     * @see #getLast()
     * @generated
     */
	void setLast(OCLExpression<C> value);

} // CollectionRange

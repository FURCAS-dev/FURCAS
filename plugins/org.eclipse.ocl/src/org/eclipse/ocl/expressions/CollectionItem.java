/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollectionItem.java,v 1.1 2007/01/25 18:24:33 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionItem#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionItem()
 * @model
 * @generated
 */
public interface CollectionItem<C> extends CollectionLiteralPart<C> {
	/**
     * Returns the value of the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Item</em>' containment reference.
     * @see #setItem(OCLExpression<C>)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionItem_Item()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<C> getItem();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.CollectionItem#getItem <em>Item</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item</em>' containment reference.
     * @see #getItem()
     * @generated
     */
	void setItem(OCLExpression<C> value);

} // CollectionItem

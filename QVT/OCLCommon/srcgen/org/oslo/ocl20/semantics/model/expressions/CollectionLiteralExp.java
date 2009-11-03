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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Collection Literal Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getKind <em>Kind</em>}
 * </li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getParts <em>Parts
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionLiteralExp()
 * @model
 * @generated
 */
public interface CollectionLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute. The literals are from the
	 * enumeration {@link org.oslo.ocl20.semantics.model.expressions.CollectionKind}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionKind
	 * @see #setKind(CollectionKind)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionLiteralExp_Kind()
	 * @model required="true"
	 * @generated
	 */
	CollectionKind getKind();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getKind <em>Kind</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(CollectionKind value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list. The list
	 * contents are of type {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart}
	 * . It is bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getCollectionLiteralExp
	 * <em>Collection Literal Exp</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionLiteralExp_Parts()
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getCollectionLiteralExp
	 * @model type="org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart"
	 *        opposite="collectionLiteralExp" containment="true"
	 * @generated
	 */
	EList getParts();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // CollectionLiteralExp

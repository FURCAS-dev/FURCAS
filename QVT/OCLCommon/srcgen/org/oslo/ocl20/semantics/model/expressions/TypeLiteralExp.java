/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Type Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp#getLiteralType <em>Literal
 * Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getTypeLiteralExp()
 * @model
 * @generated
 */
public interface TypeLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Literal Type</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Type</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literal Type</em>' reference.
	 * @see #setLiteralType(Classifier)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getTypeLiteralExp_LiteralType()
	 * @model required="true"
	 * @generated
	 */
	Classifier getLiteralType();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp#getLiteralType
	 * <em>Literal Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Literal Type</em>' reference.
	 * @see #getLiteralType()
	 * @generated
	 */
	void setLiteralType(Classifier value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // TypeLiteralExp

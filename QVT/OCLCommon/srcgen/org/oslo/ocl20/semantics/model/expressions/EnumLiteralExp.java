/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.EnumLiteral;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp#getReferredEnumLiteral <em>
 * Referred Enum Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getEnumLiteralExp()
 * @model
 * @generated
 */
public interface EnumLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Referred Enum Literal</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Enum Literal</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referred Enum Literal</em>' reference.
	 * @see #setReferredEnumLiteral(EnumLiteral)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getEnumLiteralExp_ReferredEnumLiteral()
	 * @model required="true"
	 * @generated
	 */
	EnumLiteral getReferredEnumLiteral();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp#getReferredEnumLiteral
	 * <em>Referred Enum Literal</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Referred Enum Literal</em>' reference.
	 * @see #getReferredEnumLiteral()
	 * @generated
	 */
	void setReferredEnumLiteral(EnumLiteral value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // EnumLiteralExp

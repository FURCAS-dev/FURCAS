/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Boolean Literal Exp</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp#isBooleanSymbol <em>
 * Boolean Symbol</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getBooleanLiteralExp()
 * @model
 * @generated
 */
public interface BooleanLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Boolean Symbol</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Symbol</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #setBooleanSymbol(boolean)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getBooleanLiteralExp_BooleanSymbol()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isBooleanSymbol();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp#isBooleanSymbol
	 * <em>Boolean Symbol</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Boolean Symbol</em>' attribute.
	 * @see #isBooleanSymbol()
	 * @generated
	 */
	void setBooleanSymbol(boolean value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // BooleanLiteralExp

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal Exp AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getBooleanLiteralExpAS()
 * @model
 * @generated
 */
public interface BooleanLiteralExpAS extends PrimitiveLiteralExpAS{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Boolean)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getBooleanLiteralExpAS_Value()
	 * @model dataType="org.oslo.ocl20.syntax.ast.Boolean" required="true"
	 * @generated
	 */
	Boolean getValue();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // BooleanLiteralExpAS
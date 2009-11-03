/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Message Arg AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageArgAS()
 * @model
 * @generated
 */
public interface OclMessageArgAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(TypeAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageArgAS_Type()
	 * @model
	 * @generated
	 */
	TypeAS getType();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeAS value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageArgAS_Expression()
	 * @model
	 * @generated
	 */
	OclExpressionAS getExpression();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OclExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // OclMessageArgAS

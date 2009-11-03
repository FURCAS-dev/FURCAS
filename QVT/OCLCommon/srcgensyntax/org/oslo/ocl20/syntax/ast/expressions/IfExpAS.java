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
 * A representation of the model object '<em><b>If Exp AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getIfExpAS()
 * @model
 * @generated
 */
public interface IfExpAS extends OclExpressionAS{
	/**
	 * Returns the value of the '<em><b>Then Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Expression</em>' reference.
	 * @see #setThenExpression(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getIfExpAS_ThenExpression()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getThenExpression();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getThenExpression <em>Then Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Expression</em>' reference.
	 * @see #getThenExpression()
	 * @generated
	 */
	void setThenExpression(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getIfExpAS_Condition()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getCondition();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Else Expression</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIfExpAS <em>If Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Expression</em>' reference.
	 * @see #setElseExpression(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getIfExpAS_ElseExpression()
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIfExpAS
	 * @model opposite="ifExpAS" required="true"
	 * @generated
	 */
	OclExpressionAS getElseExpression();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getElseExpression <em>Else Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Expression</em>' reference.
	 * @see #getElseExpression()
	 * @generated
	 */
	void setElseExpression(OclExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // IfExpAS

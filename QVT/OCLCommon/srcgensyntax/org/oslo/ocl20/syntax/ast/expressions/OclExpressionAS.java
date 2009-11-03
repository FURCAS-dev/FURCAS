/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Expression AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIsMarkedPre <em>Is Marked Pre</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getParent <em>Parent</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIfExpAS <em>If Exp AS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclExpressionAS()
 * @model
 * @generated
 */
public interface OclExpressionAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Marked Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Marked Pre</em>' attribute.
	 * @see #setIsMarkedPre(Boolean)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclExpressionAS_IsMarkedPre()
	 * @model dataType="org.oslo.ocl20.syntax.ast.Boolean" required="true"
	 * @generated
	 */
	Boolean getIsMarkedPre();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIsMarkedPre <em>Is Marked Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Marked Pre</em>' attribute.
	 * @see #getIsMarkedPre()
	 * @generated
	 */
	void setIsMarkedPre(Boolean value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclExpressionAS_Parent()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getParent();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>If Exp AS</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Exp AS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Exp AS</em>' reference.
	 * @see #setIfExpAS(IfExpAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclExpressionAS_IfExpAS()
	 * @see org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getElseExpression
	 * @model opposite="elseExpression" required="true"
	 * @generated
	 */
	IfExpAS getIfExpAS();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIfExpAS <em>If Exp AS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Exp AS</em>' reference.
	 * @see #getIfExpAS()
	 * @generated
	 */
	void setIfExpAS(IfExpAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // OclExpressionAS

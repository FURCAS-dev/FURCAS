/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.LetExpAS#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.LetExpAS#getIn <em>In</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLetExpAS()
 * @model
 * @generated
 */
public interface LetExpAS extends OclExpressionAS{
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLetExpAS_Variables()
	 * @model type="org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS" required="true"
	 * @generated
	 */
	EList getVariables();

	/**
	 * Returns the value of the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference.
	 * @see #setIn(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLetExpAS_In()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getIn();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.LetExpAS#getIn <em>In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(OclExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // LetExpAS

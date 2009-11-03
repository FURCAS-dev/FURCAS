/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getSource <em>Source</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getBody <em>Body</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLoopExpAS()
 * @model abstract="true"
 * @generated
 */
public interface LoopExpAS extends OclExpressionAS{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLoopExpAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' reference.
	 * @see #setResult(VariableDeclarationAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLoopExpAS_Result()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclarationAS getResult();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getResult <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(VariableDeclarationAS value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' reference.
	 * @see #setBody(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLoopExpAS_Body()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getBody();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getBody <em>Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLoopExpAS_Source()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getSource();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getLoopExpAS_Iterator()
	 * @model type="org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS"
	 * @generated
	 */
	EList getIterator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // LoopExpAS

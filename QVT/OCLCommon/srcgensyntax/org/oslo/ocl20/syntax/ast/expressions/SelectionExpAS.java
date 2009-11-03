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
 * A representation of the model object '<em><b>Selection Exp AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getSelectionExpAS()
 * @model abstract="true"
 * @generated
 */
public interface SelectionExpAS extends OclExpressionAS{
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
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getSelectionExpAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getSelectionExpAS_Source()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getSource();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OclExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // SelectionExpAS

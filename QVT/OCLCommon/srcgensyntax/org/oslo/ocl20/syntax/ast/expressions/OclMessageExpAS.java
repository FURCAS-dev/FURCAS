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
 * A representation of the model object '<em><b>Ocl Message Exp AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getKind <em>Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageExpAS()
 * @model
 * @generated
 */
public interface OclMessageExpAS extends OclExpressionAS{
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
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageExpAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS
	 * @see #setKind(OclMessageKindAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageExpAS_Kind()
	 * @model required="true"
	 * @generated
	 */
	OclMessageKindAS getKind();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OclMessageKindAS value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageExpAS_Arguments()
	 * @model type="org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS"
	 * @generated
	 */
	EList getArguments();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getOclMessageExpAS_Target()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getTarget();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OclExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // OclMessageExpAS

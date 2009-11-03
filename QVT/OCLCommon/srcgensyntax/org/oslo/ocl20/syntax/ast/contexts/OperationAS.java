/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getOperationAS()
 * @model
 * @generated
 */
public interface OperationAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' attribute list.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getOperationAS_PathName()
	 * @model
	 * @generated
	 */
	EList getPathName();

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
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getOperationAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getOperationAS_Parameters()
	 * @model type="org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS"
	 * @generated
	 */
	EList getParameters();

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
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getOperationAS_Type()
	 * @model required="true"
	 * @generated
	 */
	TypeAS getType();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.contexts.OperationAS#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // OperationAS

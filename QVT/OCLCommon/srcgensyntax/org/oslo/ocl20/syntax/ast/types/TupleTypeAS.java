/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.types;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Type AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.types.TupleTypeAS#getVariableDeclarationList <em>Variable Declaration List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.types.TypesPackage#getTupleTypeAS()
 * @model
 * @generated
 */
public interface TupleTypeAS extends TypeAS{
	/**
	 * Returns the value of the '<em><b>Variable Declaration List</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Declaration List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Declaration List</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.types.TypesPackage#getTupleTypeAS_VariableDeclarationList()
	 * @model type="org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS"
	 * @generated
	 */
	EList getVariableDeclarationList();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // TupleTypeAS

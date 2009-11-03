/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Level AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TopLevelAS#getImports <em>Imports</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TopLevelAS#getTransformations <em>Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTopLevelAS()
 * @model
 * @generated
 */
public interface TopLevelAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' attribute.
	 * @see #setImports(List)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTopLevelAS_Imports()
	 * @model dataType="org.oslo.ocl20.syntax.ast.List" required="true" many="false"
	 * @generated
	 */
	List getImports();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.TopLevelAS#getImports <em>Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imports</em>' attribute.
	 * @see #getImports()
	 * @generated
	 */
	void setImports(List value);

	/**
	 * Returns the value of the '<em><b>Transformations</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformations</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTopLevelAS_Transformations()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.TransformationAS"
	 * @generated
	 */
	EList getTransformations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // TopLevelAS

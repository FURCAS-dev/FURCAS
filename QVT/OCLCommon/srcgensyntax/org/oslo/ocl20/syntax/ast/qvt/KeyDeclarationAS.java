/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import java.util.List;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Declaration AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getClassId <em>Class Id</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getPropertyIds <em>Property Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getKeyDeclarationAS()
 * @model
 * @generated
 */
public interface KeyDeclarationAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Class Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Id</em>' attribute.
	 * @see #setClassId(List)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getKeyDeclarationAS_ClassId()
	 * @model dataType="org.oslo.ocl20.syntax.ast.List" required="true" many="false"
	 * @generated
	 */
	List getClassId();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getClassId <em>Class Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Id</em>' attribute.
	 * @see #getClassId()
	 * @generated
	 */
	void setClassId(List value);

	/**
	 * Returns the value of the '<em><b>Property Ids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Ids</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Ids</em>' attribute.
	 * @see #setPropertyIds(List)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getKeyDeclarationAS_PropertyIds()
	 * @model dataType="org.oslo.ocl20.syntax.ast.List" required="true" many="false"
	 * @generated
	 */
	List getPropertyIds();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getPropertyIds <em>Property Ids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Ids</em>' attribute.
	 * @see #getPropertyIds()
	 * @generated
	 */
	void setPropertyIds(List value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // KeyDeclarationAS

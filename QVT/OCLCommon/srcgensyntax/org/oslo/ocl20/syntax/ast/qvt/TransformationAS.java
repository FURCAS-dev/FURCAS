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
 * A representation of the model object '<em><b>Transformation AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getKeyDeclarations <em>Key Declarations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getModelDeclarations <em>Model Declarations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTransformationAS()
 * @model
 * @generated
 */
public interface TransformationAS extends Visitable{
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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTransformationAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' attribute.
	 * @see #setExtends(List)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTransformationAS_Extends()
	 * @model dataType="org.oslo.ocl20.syntax.ast.List" required="true" many="false"
	 * @generated
	 */
	List getExtends();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getExtends <em>Extends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' attribute.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(List value);

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.RelationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTransformationAS_Relations()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.RelationAS"
	 * @generated
	 */
	EList getRelations();

	/**
	 * Returns the value of the '<em><b>Model Declarations</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Declarations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Declarations</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTransformationAS_ModelDeclarations()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS"
	 * @generated
	 */
	EList getModelDeclarations();

	/**
	 * Returns the value of the '<em><b>Query</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.QueryAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTransformationAS_Query()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.QueryAS"
	 * @generated
	 */
	EList getQuery();

	/**
	 * Returns the value of the '<em><b>Key Declarations</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Declarations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Declarations</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getTransformationAS_KeyDeclarations()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS"
	 * @generated
	 */
	EList getKeyDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // TransformationAS

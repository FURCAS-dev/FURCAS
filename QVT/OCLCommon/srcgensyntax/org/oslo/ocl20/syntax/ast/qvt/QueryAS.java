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

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

import org.oslo.ocl20.syntax.ast.types.TypeAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getType <em>Type</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getQueryAS()
 * @model
 * @generated
 */
public interface QueryAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Name</em>' attribute.
	 * @see #setPathName(List)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getQueryAS_PathName()
	 * @model dataType="org.oslo.ocl20.syntax.ast.List" required="true" many="false"
	 * @generated
	 */
	List getPathName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getPathName <em>Path Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' attribute.
	 * @see #getPathName()
	 * @generated
	 */
	void setPathName(List value);

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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getQueryAS_Body()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getBody();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getBody <em>Body</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpressionAS value);

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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getQueryAS_Type()
	 * @model required="true"
	 * @generated
	 */
	TypeAS getType();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeAS value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getQueryAS_Parameters()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS"
	 * @generated
	 */
	EList getParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // QueryAS

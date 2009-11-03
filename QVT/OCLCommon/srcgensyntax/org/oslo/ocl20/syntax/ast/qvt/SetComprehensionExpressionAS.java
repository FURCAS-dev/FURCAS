/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Comprehension Expression AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getObjectTemplate <em>Object Template</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getSetComprehensionExpressionAS()
 * @model
 * @generated
 */
public interface SetComprehensionExpressionAS extends Visitable{
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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getSetComprehensionExpressionAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Object Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Template</em>' reference.
	 * @see #setObjectTemplate(ObjectTemplateAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getSetComprehensionExpressionAS_ObjectTemplate()
	 * @model required="true"
	 * @generated
	 */
	ObjectTemplateAS getObjectTemplate();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getObjectTemplate <em>Object Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Template</em>' reference.
	 * @see #getObjectTemplate()
	 * @generated
	 */
	void setObjectTemplate(ObjectTemplateAS value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression</em>' reference.
	 * @see #setOclExpression(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getSetComprehensionExpressionAS_OclExpression()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getOclExpression();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getOclExpression <em>Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression</em>' reference.
	 * @see #getOclExpression()
	 * @generated
	 */
	void setOclExpression(OclExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // SetComprehensionExpressionAS

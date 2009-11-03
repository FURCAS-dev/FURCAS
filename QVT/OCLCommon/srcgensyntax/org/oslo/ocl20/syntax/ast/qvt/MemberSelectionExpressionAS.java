/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Member Selection Expression AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getSecondName <em>Second Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getObjectTemplate <em>Object Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getMemberSelectionExpressionAS()
 * @model
 * @generated
 */
public interface MemberSelectionExpressionAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getMemberSelectionExpressionAS_FirstName()
	 * @model required="true"
	 * @generated
	 */
	String getFirstName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value);

	/**
	 * Returns the value of the '<em><b>Second Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Name</em>' attribute.
	 * @see #setSecondName(String)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getMemberSelectionExpressionAS_SecondName()
	 * @model required="true"
	 * @generated
	 */
	String getSecondName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getSecondName <em>Second Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Name</em>' attribute.
	 * @see #getSecondName()
	 * @generated
	 */
	void setSecondName(String value);

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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getMemberSelectionExpressionAS_ObjectTemplate()
	 * @model required="true"
	 * @generated
	 */
	ObjectTemplateAS getObjectTemplate();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getObjectTemplate <em>Object Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Template</em>' reference.
	 * @see #getObjectTemplate()
	 * @generated
	 */
	void setObjectTemplate(ObjectTemplateAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // MemberSelectionExpressionAS

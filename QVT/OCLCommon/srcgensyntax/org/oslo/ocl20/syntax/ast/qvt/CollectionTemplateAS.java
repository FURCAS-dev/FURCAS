/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Template AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getCollectionKind <em>Collection Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getMemberSelectionExpressions <em>Member Selection Expressions</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getOclExpressions <em>Ocl Expressions</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getSetComprehensionExpression <em>Set Comprehension Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getCollectionTemplateAS()
 * @model
 * @generated
 */
public interface CollectionTemplateAS extends TemplateAS{
	/**
	 * Returns the value of the '<em><b>Collection Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS
	 * @see #setCollectionKind(CollectionKindAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getCollectionTemplateAS_CollectionKind()
	 * @model required="true"
	 * @generated
	 */
	CollectionKindAS getCollectionKind();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getCollectionKind <em>Collection Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS
	 * @see #getCollectionKind()
	 * @generated
	 */
	void setCollectionKind(CollectionKindAS value);

	/**
	 * Returns the value of the '<em><b>Set Comprehension Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Comprehension Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Comprehension Expression</em>' reference.
	 * @see #setSetComprehensionExpression(SetComprehensionExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getCollectionTemplateAS_SetComprehensionExpression()
	 * @model required="true"
	 * @generated
	 */
	SetComprehensionExpressionAS getSetComprehensionExpression();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getSetComprehensionExpression <em>Set Comprehension Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set Comprehension Expression</em>' reference.
	 * @see #getSetComprehensionExpression()
	 * @generated
	 */
	void setSetComprehensionExpression(SetComprehensionExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Ocl Expressions</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expressions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expressions</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getCollectionTemplateAS_OclExpressions()
	 * @model type="org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS"
	 * @generated
	 */
	EList getOclExpressions();

	/**
	 * Returns the value of the '<em><b>Member Selection Expressions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Selection Expressions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Selection Expressions</em>' reference.
	 * @see #setMemberSelectionExpressions(MemberSelectionExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getCollectionTemplateAS_MemberSelectionExpressions()
	 * @model required="true"
	 * @generated
	 */
	MemberSelectionExpressionAS getMemberSelectionExpressions();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getMemberSelectionExpressions <em>Member Selection Expressions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member Selection Expressions</em>' reference.
	 * @see #getMemberSelectionExpressions()
	 * @generated
	 */
	void setMemberSelectionExpressions(MemberSelectionExpressionAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // CollectionTemplateAS

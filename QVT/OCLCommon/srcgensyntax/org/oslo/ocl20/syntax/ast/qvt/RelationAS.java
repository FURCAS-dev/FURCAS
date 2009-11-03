/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getWhere <em>Where</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getVariableDeclarations <em>Variable Declarations</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getDomains <em>Domains</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS()
 * @model
 * @generated
 */
public interface RelationAS extends Visitable{
	/**
	 * Returns the value of the '<em><b>Is Top Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top Level</em>' attribute.
	 * @see #setIsTopLevel(Boolean)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS_IsTopLevel()
	 * @model dataType="org.oslo.ocl20.syntax.ast.Boolean" required="true"
	 * @generated
	 */
	Boolean getIsTopLevel();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getIsTopLevel <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top Level</em>' attribute.
	 * @see #getIsTopLevel()
	 * @generated
	 */
	void setIsTopLevel(Boolean value);

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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Overrides</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overrides</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overrides</em>' attribute.
	 * @see #setOverrides(String)
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS_Overrides()
	 * @model required="true"
	 * @generated
	 */
	String getOverrides();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getOverrides <em>Overrides</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overrides</em>' attribute.
	 * @see #getOverrides()
	 * @generated
	 */
	void setOverrides(String value);

	/**
	 * Returns the value of the '<em><b>Domains</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domains</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domains</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS_Domains()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS"
	 * @generated
	 */
	EList getDomains();

	/**
	 * Returns the value of the '<em><b>Variable Declarations</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Declarations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Declarations</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS_VariableDeclarations()
	 * @model type="org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS"
	 * @generated
	 */
	EList getVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Where</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS_Where()
	 * @model type="org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS"
	 * @generated
	 */
	EList getWhere();

	/**
	 * Returns the value of the '<em><b>When</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' reference list.
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#getRelationAS_When()
	 * @model type="org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS"
	 * @generated
	 */
	EList getWhen();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // RelationAS

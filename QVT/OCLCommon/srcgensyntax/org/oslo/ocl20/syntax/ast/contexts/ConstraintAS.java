/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts;

import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint AS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getName <em>Name</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getKind <em>Kind</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefOperation <em>Def Operation</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefVariable <em>Def Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getConstraintAS()
 * @model
 * @generated
 */
public interface ConstraintAS extends Visitable{
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
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getConstraintAS_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS
	 * @see #setKind(ConstraintKindAS)
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getConstraintAS_Kind()
	 * @model required="true"
	 * @generated
	 */
	ConstraintKindAS getKind();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ConstraintKindAS value);

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' reference.
	 * @see #setBodyExpression(OclExpressionAS)
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getConstraintAS_BodyExpression()
	 * @model required="true"
	 * @generated
	 */
	OclExpressionAS getBodyExpression();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getBodyExpression <em>Body Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(OclExpressionAS value);

	/**
	 * Returns the value of the '<em><b>Def Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Def Operation</em>' reference.
	 * @see #setDefOperation(OperationAS)
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getConstraintAS_DefOperation()
	 * @model
	 * @generated
	 */
	OperationAS getDefOperation();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefOperation <em>Def Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Def Operation</em>' reference.
	 * @see #getDefOperation()
	 * @generated
	 */
	void setDefOperation(OperationAS value);

	/**
	 * Returns the value of the '<em><b>Def Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Def Variable</em>' reference.
	 * @see #setDefVariable(VariableDeclarationAS)
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#getConstraintAS_DefVariable()
	 * @model
	 * @generated
	 */
	VariableDeclarationAS getDefVariable();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.syntax.ast.contexts.ConstraintAS#getDefVariable <em>Def Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Def Variable</em>' reference.
	 * @see #getDefVariable()
	 * @generated
	 */
	void setDefVariable(VariableDeclarationAS value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.syntax.ast.Object" dataDataType="org.oslo.ocl20.syntax.ast.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(Visitor visitor, Object data);

} // ConstraintAS

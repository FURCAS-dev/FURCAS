/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Property;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Constraint</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getName <em>Name</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getKind <em>Kind</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getDefProperty <em>Def Property
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getDefOperation <em>Def Operation
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getContext <em>Context</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getBodyExpression <em>Body
 * Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends SemanticsVisitable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraint_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute. The literals are from the
	 * enumeration {@link org.oslo.ocl20.semantics.model.contexts.ConstraintKind}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.semantics.model.contexts.ConstraintKind
	 * @see #setKind(ConstraintKind)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraint_Kind()
	 * @model required="true"
	 * @generated
	 */
	ConstraintKind getKind();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getKind
	 * <em>Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Kind</em>' attribute.
	 * @see org.oslo.ocl20.semantics.model.contexts.ConstraintKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ConstraintKind value);

	/**
	 * Returns the value of the '<em><b>Def Property</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def Property</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Def Property</em>' reference.
	 * @see #setDefProperty(Property)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraint_DefProperty()
	 * @model
	 * @generated
	 */
	Property getDefProperty();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getDefProperty
	 * <em>Def Property</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Def Property</em>' reference.
	 * @see #getDefProperty()
	 * @generated
	 */
	void setDefProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Def Operation</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def Operation</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Def Operation</em>' reference.
	 * @see #setDefOperation(Operation)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraint_DefOperation()
	 * @model
	 * @generated
	 */
	Operation getDefOperation();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getDefOperation
	 * <em>Def Operation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Def Operation</em>' reference.
	 * @see #getDefOperation()
	 * @generated
	 */
	void setDefOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' container reference. It is bidirectional
	 * and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getConstraint
	 * <em>Constraint</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Context</em>' container reference.
	 * @see #setContext(ContextDeclaration)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraint_Context()
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getConstraint
	 * @model opposite="constraint" required="true" transient="false"
	 * @generated
	 */
	ContextDeclaration getContext();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.model.contexts.Constraint#getContext
	 * <em>Context</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(ContextDeclaration value);

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getConstraint_BodyExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getBodyExpression();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getBodyExpression
	 * <em>Body Expression</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(OclExpression value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Constraint

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Namespace;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Context Declaration</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getReferredNamespace <em>
 * Referred Namespace</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getConstraint <em>
 * Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getContextDeclaration()
 * @model
 * @generated
 */
public interface ContextDeclaration extends SemanticsVisitable {
	/**
	 * Returns the value of the '<em><b>Referred Namespace</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Referred Namespace</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referred Namespace</em>' reference.
	 * @see #setReferredNamespace(Namespace)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getContextDeclaration_ReferredNamespace()
	 * @model required="true"
	 * @generated
	 */
	Namespace getReferredNamespace();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ContextDeclaration#getReferredNamespace
	 * <em>Referred Namespace</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Referred Namespace</em>' reference.
	 * @see #getReferredNamespace()
	 * @generated
	 */
	void setReferredNamespace(Namespace value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list. The list
	 * contents are of type {@link org.oslo.ocl20.semantics.model.contexts.Constraint}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.contexts.Constraint#getContext <em>Context</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getContextDeclaration_Constraint()
	 * @see org.oslo.ocl20.semantics.model.contexts.Constraint#getContext
	 * @model type="org.oslo.ocl20.semantics.model.contexts.Constraint" opposite="context"
	 *        containment="true"
	 * @generated
	 */
	EList getConstraint();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // ContextDeclaration

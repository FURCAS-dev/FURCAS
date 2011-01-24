/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Variable.java,v 1.3 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Variable#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.Variable#isImplicit <em>Implicit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable
		extends VariableDeclaration {

	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable_InitExpression()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	OclExpression getInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Variable#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OclExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getInitExpression()
	 * @generated
	 */
	OclExpression createInitExpression(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getInitExpression()
	 * @generated
	 */
	OclExpression createInitExpression();

	/**
	 * Returns the value of the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Parameter</em>' reference.
	 * @see #setRepresentedParameter(Parameter)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable_RepresentedParameter()
	 * @model ordered="false"
	 * @generated
	 */
	Parameter getRepresentedParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Variable#getRepresentedParameter <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Parameter</em>' reference.
	 * @see #getRepresentedParameter()
	 * @generated
	 */
	void setRepresentedParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Implicit</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit</em>' attribute.
	 * @see #setImplicit(boolean)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getVariable_Implicit()
	 * @model default="false" dataType="org.eclipse.ocl.examples.pivot.Boolean" ordered="false"
	 * @generated
	 */
	boolean isImplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.Variable#isImplicit <em>Implicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit</em>' attribute.
	 * @see #isImplicit()
	 * @generated
	 */
	void setImplicit(boolean value);

} // Variable

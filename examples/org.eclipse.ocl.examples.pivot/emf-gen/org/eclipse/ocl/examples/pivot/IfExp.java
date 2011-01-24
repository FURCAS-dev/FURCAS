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
 * $Id: IfExp.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.IfExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.IfExp#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.IfExp#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp()
 * @model
 * @generated
 */
public interface IfExp
		extends OclExpression {

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp_Condition()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.IfExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OclExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getCondition()
	 * @generated
	 */
	OclExpression createCondition(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getCondition()
	 * @generated
	 */
	OclExpression createCondition();

	/**
	 * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Expression</em>' containment reference.
	 * @see #setThenExpression(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp_ThenExpression()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getThenExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.IfExp#getThenExpression <em>Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Expression</em>' containment reference.
	 * @see #getThenExpression()
	 * @generated
	 */
	void setThenExpression(OclExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getThenExpression()
	 * @generated
	 */
	OclExpression createThenExpression(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getThenExpression()
	 * @generated
	 */
	OclExpression createThenExpression();

	/**
	 * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Expression</em>' containment reference.
	 * @see #setElseExpression(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getIfExp_ElseExpression()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getElseExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.IfExp#getElseExpression <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Expression</em>' containment reference.
	 * @see #getElseExpression()
	 * @generated
	 */
	void setElseExpression(OclExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getElseExpression()
	 * @generated
	 */
	OclExpression createElseExpression(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getElseExpression()
	 * @generated
	 */
	OclExpression createElseExpression();

} // IfExp

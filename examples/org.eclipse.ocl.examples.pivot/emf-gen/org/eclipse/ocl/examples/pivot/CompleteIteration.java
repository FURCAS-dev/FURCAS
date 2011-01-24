/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: CompleteIteration.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteEnvironment <em>Complete Environment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteIterators <em>Complete Iterator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteAccumulators <em>Complete Accumulator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteParameters <em>Complete Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteIteration()
 * @model
 * @generated
 */
public interface CompleteIteration extends Iteration
{
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Iteration)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteIteration_Model()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Iteration getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Iteration value);

	/**
	 * Returns the value of the '<em><b>Complete Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Environment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Environment</em>' reference.
	 * @see #setCompleteEnvironment(CompleteEnvironment)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteIteration_CompleteEnvironment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CompleteEnvironment getCompleteEnvironment();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompleteIteration#getCompleteEnvironment <em>Complete Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complete Environment</em>' reference.
	 * @see #getCompleteEnvironment()
	 * @generated
	 */
	void setCompleteEnvironment(CompleteEnvironment value);

	/**
	 * Returns the value of the '<em><b>Complete Iterator</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Iterator</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Iterator</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteIteration_CompleteIterator()
	 * @model changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Parameter> getCompleteIterators();

	/**
	 * Returns the value of the '<em><b>Complete Accumulator</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Accumulator</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Accumulator</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteIteration_CompleteAccumulator()
	 * @model changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Parameter> getCompleteAccumulators();

	/**
	 * Returns the value of the '<em><b>Complete Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Parameter</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteIteration_CompleteParameter()
	 * @model changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Parameter> getCompleteParameters();

} // CompleteIteration

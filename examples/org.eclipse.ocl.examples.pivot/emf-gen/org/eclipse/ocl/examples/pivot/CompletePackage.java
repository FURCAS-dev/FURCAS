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
 * $Id: CompletePackage.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getCompleteEnvironment <em>Complete Environment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getCompleteTypes <em>Complete Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompletePackage#getCompletePackages <em>Complete Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage()
 * @model
 * @generated
 */
public interface CompletePackage
		extends org.eclipse.ocl.examples.pivot.Package {

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(org.eclipse.ocl.examples.pivot.Package)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_Model()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Package getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(org.eclipse.ocl.examples.pivot.Package value);

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
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_CompleteEnvironment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CompleteEnvironment getCompleteEnvironment();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompletePackage#getCompleteEnvironment <em>Complete Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complete Environment</em>' reference.
	 * @see #getCompleteEnvironment()
	 * @generated
	 */
	void setCompleteEnvironment(CompleteEnvironment value);

	/**
	 * Returns the value of the '<em><b>Complete Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompleteType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Type</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_CompleteType()
	 * @model changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CompleteType> getCompleteTypes();

	/**
	 * Returns the value of the '<em><b>Complete Package</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompletePackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Package</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Package</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompletePackage_CompletePackage()
	 * @model changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<CompletePackage> getCompletePackages();

} // CompletePackage

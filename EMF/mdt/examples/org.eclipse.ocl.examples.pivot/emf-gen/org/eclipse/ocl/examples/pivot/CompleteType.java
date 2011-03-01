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
 * $Id: CompleteType.java,v 1.3 2011/03/01 08:47:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteType#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteType#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteEnvironment <em>Complete Environment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteOperations <em>Complete Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteProperties <em>Complete Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteSuperTypes <em>Complete Super Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteType()
 * @model
 * @generated
 */
public interface CompleteType
		extends org.eclipse.ocl.examples.pivot.Class {

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteType_Model()
	 * @model required="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getModel();

	/**
	 * Returns the value of the '<em><b>Models</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteType_Models()
	 * @model required="true"
	 * @generated
	 */
	EList<Type> getModels();

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
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteType_CompleteEnvironment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CompleteEnvironment getCompleteEnvironment();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CompleteType#getCompleteEnvironment <em>Complete Environment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complete Environment</em>' reference.
	 * @see #getCompleteEnvironment()
	 * @generated
	 */
	void setCompleteEnvironment(CompleteEnvironment value);

	/**
	 * Returns the value of the '<em><b>Complete Operation</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompleteOperation}.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 *   <li>'{@link org.eclipse.ocl.examples.pivot.Class#getOwnedOperations() <em>Owned Operation</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Operation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Operation</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteType_CompleteOperation()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CompleteOperation> getCompleteOperations();

	/**
	 * Returns the value of the '<em><b>Complete Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompleteProperty}.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 *   <li>'{@link org.eclipse.ocl.examples.pivot.Class#getOwnedAttributes() <em>Owned Attribute</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Property</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteType_CompleteProperty()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CompleteProperty> getCompleteProperties();

	/**
	 * Returns the value of the '<em><b>Complete Super Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CompleteType}.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 *   <li>'{@link org.eclipse.ocl.examples.pivot.Class#getSuperClasses() <em>Super Class</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Super Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Super Type</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCompleteType_CompleteSuperType()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CompleteType> getCompleteSuperTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" staticOperationRequired="true" staticOperationOrdered="false"
	 * @generated
	 */
	CompleteOperation getDynamicOperation(CompleteOperation staticOperation);

} // CompleteClass

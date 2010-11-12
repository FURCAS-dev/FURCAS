/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ModelRegistration.java,v 1.2 2010/04/08 06:24:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Registration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getAccessor <em>Accessor</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getSerialization <em>Serialization</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistration()
 * @model
 * @generated
 */
public interface ModelRegistration extends EObject {
	/**
	 * Returns the value of the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessor</em>' attribute.
	 * @see #setAccessor(String)
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistration_Accessor()
	 * @model
	 * @generated
	 */
	String getAccessor();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getAccessor <em>Accessor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessor</em>' attribute.
	 * @see #getAccessor()
	 * @generated
	 */
	void setAccessor(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistration_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Serialization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serialization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serialization</em>' attribute.
	 * @see #setSerialization(String)
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistration_Serialization()
	 * @model
	 * @generated
	 */
	String getSerialization();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getSerialization <em>Serialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serialization</em>' attribute.
	 * @see #getSerialization()
	 * @generated
	 */
	void setSerialization(String value);

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistration_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // ModelRegistration

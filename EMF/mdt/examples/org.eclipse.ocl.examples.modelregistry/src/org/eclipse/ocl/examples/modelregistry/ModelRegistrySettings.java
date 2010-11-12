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
 * $Id: ModelRegistrySettings.java,v 1.2 2010/04/08 06:24:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistrySettings()
 * @model
 * @generated
 */
public interface ModelRegistrySettings extends EObject {
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
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistrySettings_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.modelregistry.ModelRegistry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage#getModelRegistrySettings_Resource()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelRegistry> getResource();

} // ModelRegistrySettings

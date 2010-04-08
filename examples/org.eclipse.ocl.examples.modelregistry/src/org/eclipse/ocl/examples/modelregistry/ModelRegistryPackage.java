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
 * $Id: ModelRegistryPackage.java,v 1.2 2010/04/08 06:24:07 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryFactory
 * @model kind="package"
 * @generated
 */
public interface ModelRegistryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modelregistry";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/1.0/ModelRegistry";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mreg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelRegistryPackage eINSTANCE = org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryImpl <em>Model Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryImpl
	 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryPackageImpl#getModelRegistry()
	 * @generated
	 */
	int MODEL_REGISTRY = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl <em>Model Registration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl
	 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryPackageImpl#getModelRegistration()
	 * @generated
	 */
	int MODEL_REGISTRATION = 0;

	/**
	 * The feature id for the '<em><b>Accessor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRATION__ACCESSOR = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRATION__KIND = 1;

	/**
	 * The feature id for the '<em><b>Serialization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRATION__SERIALIZATION = 2;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRATION__URI = 3;

	/**
	 * The number of structural features of the '<em>Model Registration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRATION_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRY__ENTRY = 1;

	/**
	 * The number of structural features of the '<em>Model Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrySettingsImpl <em>Settings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrySettingsImpl
	 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryPackageImpl#getModelRegistrySettings()
	 * @generated
	 */
	int MODEL_REGISTRY_SETTINGS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRY_SETTINGS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRY_SETTINGS__RESOURCE = 1;

	/**
	 * The number of structural features of the '<em>Settings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_REGISTRY_SETTINGS_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistry <em>Model Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Registry</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistry
	 * @generated
	 */
	EClass getModelRegistry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistry#getName()
	 * @see #getModelRegistry()
	 * @generated
	 */
	EAttribute getModelRegistry_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistry#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistry#getEntry()
	 * @see #getModelRegistry()
	 * @generated
	 */
	EReference getModelRegistry_Entry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration <em>Model Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Registration</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistration
	 * @generated
	 */
	EClass getModelRegistration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getAccessor <em>Accessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accessor</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistration#getAccessor()
	 * @see #getModelRegistration()
	 * @generated
	 */
	EAttribute getModelRegistration_Accessor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistration#getKind()
	 * @see #getModelRegistration()
	 * @generated
	 */
	EAttribute getModelRegistration_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getSerialization <em>Serialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serialization</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistration#getSerialization()
	 * @see #getModelRegistration()
	 * @generated
	 */
	EAttribute getModelRegistration_Serialization();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistration#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistration#getUri()
	 * @see #getModelRegistration()
	 * @generated
	 */
	EAttribute getModelRegistration_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings
	 * @generated
	 */
	EClass getModelRegistrySettings();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings#getName()
	 * @see #getModelRegistrySettings()
	 * @generated
	 */
	EAttribute getModelRegistrySettings_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistrySettings#getResource()
	 * @see #getModelRegistrySettings()
	 * @generated
	 */
	EReference getModelRegistrySettings_Resource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelRegistryFactory getModelRegistryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryImpl <em>Model Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryImpl
		 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryPackageImpl#getModelRegistry()
		 * @generated
		 */
		EClass MODEL_REGISTRY = eINSTANCE.getModelRegistry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REGISTRY__NAME = eINSTANCE.getModelRegistry_Name();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REGISTRY__ENTRY = eINSTANCE.getModelRegistry_Entry();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl <em>Model Registration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl
		 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryPackageImpl#getModelRegistration()
		 * @generated
		 */
		EClass MODEL_REGISTRATION = eINSTANCE.getModelRegistration();

		/**
		 * The meta object literal for the '<em><b>Accessor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REGISTRATION__ACCESSOR = eINSTANCE.getModelRegistration_Accessor();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REGISTRATION__KIND = eINSTANCE.getModelRegistration_Kind();

		/**
		 * The meta object literal for the '<em><b>Serialization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REGISTRATION__SERIALIZATION = eINSTANCE.getModelRegistration_Serialization();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REGISTRATION__URI = eINSTANCE.getModelRegistration_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrySettingsImpl <em>Settings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrySettingsImpl
		 * @see org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryPackageImpl#getModelRegistrySettings()
		 * @generated
		 */
		EClass MODEL_REGISTRY_SETTINGS = eINSTANCE.getModelRegistrySettings();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_REGISTRY_SETTINGS__NAME = eINSTANCE.getModelRegistrySettings_Name();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_REGISTRY_SETTINGS__RESOURCE = eINSTANCE.getModelRegistrySettings_Resource();

	}

} //ModelRegistryPackage

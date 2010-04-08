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
 * $Id: ModelRegistryFactoryImpl.java,v 1.2 2010/04/08 06:24:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.modelregistry.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelRegistryFactoryImpl extends EFactoryImpl implements ModelRegistryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelRegistryFactory init() {
		try {
			ModelRegistryFactory theModelRegistryFactory = (ModelRegistryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/1.0/ModelRegistry"); 
			if (theModelRegistryFactory != null) {
				return theModelRegistryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelRegistryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRegistryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelRegistryPackage.MODEL_REGISTRATION: return createModelRegistration();
			case ModelRegistryPackage.MODEL_REGISTRY: return createModelRegistry();
			case ModelRegistryPackage.MODEL_REGISTRY_SETTINGS: return createModelRegistrySettings();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRegistry createModelRegistry() {
		ModelRegistryImpl modelRegistry = new ModelRegistryImpl();
		return modelRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRegistration createModelRegistration() {
		ModelRegistrationImpl modelRegistration = new ModelRegistrationImpl();
		return modelRegistration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRegistrySettings createModelRegistrySettings() {
		ModelRegistrySettingsImpl modelRegistrySettings = new ModelRegistrySettingsImpl();
		return modelRegistrySettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRegistryPackage getModelRegistryPackage() {
		return (ModelRegistryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelRegistryPackage getPackage() {
		return ModelRegistryPackage.eINSTANCE;
	}

} //ModelRegistryFactoryImpl

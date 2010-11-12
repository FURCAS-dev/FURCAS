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
 * $Id: ModelRegistryFactory.java,v 1.2 2010/04/08 06:24:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage
 * @generated
 */
public interface ModelRegistryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelRegistryFactory eINSTANCE = org.eclipse.ocl.examples.modelregistry.impl.ModelRegistryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Registry</em>'.
	 * @generated
	 */
	ModelRegistry createModelRegistry();

	/**
	 * Returns a new object of class '<em>Model Registration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Registration</em>'.
	 * @generated
	 */
	ModelRegistration createModelRegistration();

	/**
	 * Returns a new object of class '<em>Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Settings</em>'.
	 * @generated
	 */
	ModelRegistrySettings createModelRegistrySettings();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelRegistryPackage getModelRegistryPackage();

} //ModelRegistryFactory

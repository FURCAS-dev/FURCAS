/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NestedOfClusteredFactoryImpl extends EFactoryImpl implements NestedOfClusteredFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NestedOfClusteredFactory init() {
		try {
			NestedOfClusteredFactory theNestedOfClusteredFactory = (NestedOfClusteredFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcases/case007/clustered/nestedOfClustered"); 
			if (theNestedOfClusteredFactory != null) {
				return theNestedOfClusteredFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NestedOfClusteredFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedOfClusteredFactoryImpl() {
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
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_A: return createnestedOfClusteredA();
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_B: return createnestedOfClusteredB();
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B: return createNestedOfClusteredAReferencesNestedOfClusteredB();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public nestedOfClusteredA createnestedOfClusteredA() {
		nestedOfClusteredAImpl nestedOfClusteredA = new nestedOfClusteredAImpl();
		return nestedOfClusteredA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public nestedOfClusteredB createnestedOfClusteredB() {
		nestedOfClusteredBImpl nestedOfClusteredB = new nestedOfClusteredBImpl();
		return nestedOfClusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedOfClusteredAReferencesNestedOfClusteredB createNestedOfClusteredAReferencesNestedOfClusteredB() {
		NestedOfClusteredAReferencesNestedOfClusteredBImpl nestedOfClusteredAReferencesNestedOfClusteredB = new NestedOfClusteredAReferencesNestedOfClusteredBImpl();
		return nestedOfClusteredAReferencesNestedOfClusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedOfClusteredPackage getNestedOfClusteredPackage() {
		return (NestedOfClusteredPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NestedOfClusteredPackage getPackage() {
		return NestedOfClusteredPackage.eINSTANCE;
	}

} //NestedOfClusteredFactoryImpl

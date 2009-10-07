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
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClusteredFactoryImpl extends EFactoryImpl implements ClusteredFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClusteredFactory init() {
		try {
			ClusteredFactory theClusteredFactory = (ClusteredFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcases/case007/clustered"); 
			if (theClusteredFactory != null) {
				return theClusteredFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClusteredFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusteredFactoryImpl() {
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
			case ClusteredPackage.CLUSTERED_A: return createClusteredA();
			case ClusteredPackage.CLUSTERED_B: return createClusteredB();
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B: return createClusteredAReferencesClusteredB();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusteredA createClusteredA() {
		ClusteredAImpl clusteredA = new ClusteredAImpl();
		return clusteredA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusteredB createClusteredB() {
		ClusteredBImpl clusteredB = new ClusteredBImpl();
		return clusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusteredAReferencesClusteredB createClusteredAReferencesClusteredB() {
		ClusteredAReferencesClusteredBImpl clusteredAReferencesClusteredB = new ClusteredAReferencesClusteredBImpl();
		return clusteredAReferencesClusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusteredPackage getClusteredPackage() {
		return (ClusteredPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClusteredPackage getPackage() {
		return ClusteredPackage.eINSTANCE;
	}

} //ClusteredFactoryImpl

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
package org.eclipse.emf.query2.test.mm.testcases.case010.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcases.case010.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Case010FactoryImpl extends EFactoryImpl implements Case010Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Case010Factory init() {
		try {
			Case010Factory theCase010Factory = (Case010Factory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcases/case010"); //$NON-NLS-1$ 
			if (theCase010Factory != null) {
				return theCase010Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Case010FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case010FactoryImpl() {
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
			case Case010Package.A10: return createA10();
			case Case010Package.B10: return createB10();
			case Case010Package.C10: return createC10();
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE: return createNotNavigableToNotNavigable();
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE: return createNotChangeableToNotChangeable();
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE: return createNotChangeableAndNavigableToNotChangeableAndNavigable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 createA10() {
		A10Impl a10 = new A10Impl();
		return a10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 createB10() {
		B10Impl b10 = new B10Impl();
		return b10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C10 createC10() {
		C10Impl c10 = new C10Impl();
		return c10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotNavigableToNotNavigable createNotNavigableToNotNavigable() {
		NotNavigableToNotNavigableImpl notNavigableToNotNavigable = new NotNavigableToNotNavigableImpl();
		return notNavigableToNotNavigable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotChangeableToNotChangeable createNotChangeableToNotChangeable() {
		NotChangeableToNotChangeableImpl notChangeableToNotChangeable = new NotChangeableToNotChangeableImpl();
		return notChangeableToNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotChangeableAndNavigableToNotChangeableAndNavigable createNotChangeableAndNavigableToNotChangeableAndNavigable() {
		NotChangeableAndNavigableToNotChangeableAndNavigableImpl notChangeableAndNavigableToNotChangeableAndNavigable = new NotChangeableAndNavigableToNotChangeableAndNavigableImpl();
		return notChangeableAndNavigableToNotChangeableAndNavigable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case010Package getCase010Package() {
		return (Case010Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Case010Package getPackage() {
		return Case010Package.eINSTANCE;
	}

} //Case010FactoryImpl

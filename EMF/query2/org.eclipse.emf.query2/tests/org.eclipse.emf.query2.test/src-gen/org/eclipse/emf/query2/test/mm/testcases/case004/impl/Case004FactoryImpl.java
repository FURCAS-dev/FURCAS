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
package org.eclipse.emf.query2.test.mm.testcases.case004.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcases.case004.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Case004FactoryImpl extends EFactoryImpl implements Case004Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Case004Factory init() {
		try {
			Case004Factory theCase004Factory = (Case004Factory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcases/case004"); //$NON-NLS-1$ 
			if (theCase004Factory != null) {
				return theCase004Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Case004FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case004FactoryImpl() {
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
			case Case004Package.A4: return createA4();
			case Case004Package.B4_HAS_CONSTANT: return createB4HasConstant();
			case Case004Package.C4: return createC4();
			case Case004Package.D4: return createD4();
			case Case004Package.B4: return createB4();
			case Case004Package.F4: return createF4();
			case Case004Package.A4_SUB: return createA4Sub();
			case Case004Package.D4_SUB: return createD4Sub();
			case Case004Package.C4_SUB: return createC4Sub();
			case Case004Package.F4_SUB: return createF4Sub();
			case Case004Package.HAS_CS: return createhasCs();
			case Case004Package.COMPOSES_CS: return createcomposesCs();
			case Case004Package.COMPOSES_B: return createcomposesB();
			case Case004Package.COMPOSES_CS_ORDERED: return createcomposesCsOrdered();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A4 createA4() {
		A4Impl a4 = new A4Impl();
		return a4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4HasConstant createB4HasConstant() {
		B4HasConstantImpl b4HasConstant = new B4HasConstantImpl();
		return b4HasConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C4 createC4() {
		C4Impl c4 = new C4Impl();
		return c4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D4 createD4() {
		D4Impl d4 = new D4Impl();
		return d4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 createB4() {
		B4Impl b4 = new B4Impl();
		return b4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public F4 createF4() {
		F4Impl f4 = new F4Impl();
		return f4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A4Sub createA4Sub() {
		A4SubImpl a4Sub = new A4SubImpl();
		return a4Sub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D4Sub createD4Sub() {
		D4SubImpl d4Sub = new D4SubImpl();
		return d4Sub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C4Sub createC4Sub() {
		C4SubImpl c4Sub = new C4SubImpl();
		return c4Sub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public F4Sub createF4Sub() {
		F4SubImpl f4Sub = new F4SubImpl();
		return f4Sub;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public hasCs createhasCs() {
		hasCsImpl hasCs = new hasCsImpl();
		return hasCs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public composesCs createcomposesCs() {
		composesCsImpl composesCs = new composesCsImpl();
		return composesCs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public composesB createcomposesB() {
		composesBImpl composesB = new composesBImpl();
		return composesB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public composesCsOrdered createcomposesCsOrdered() {
		composesCsOrderedImpl composesCsOrdered = new composesCsOrderedImpl();
		return composesCsOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case004Package getCase004Package() {
		return (Case004Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Case004Package getPackage() {
		return Case004Package.eINSTANCE;
	}

} //Case004FactoryImpl

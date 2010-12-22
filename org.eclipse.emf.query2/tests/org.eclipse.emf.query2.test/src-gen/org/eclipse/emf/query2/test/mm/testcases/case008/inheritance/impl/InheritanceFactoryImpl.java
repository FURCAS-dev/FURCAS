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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InheritanceFactoryImpl extends EFactoryImpl implements InheritanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InheritanceFactory init() {
		try {
			InheritanceFactory theInheritanceFactory = (InheritanceFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcases/case008/inheritance"); //$NON-NLS-1$ 
			if (theInheritanceFactory != null) {
				return theInheritanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InheritanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritanceFactoryImpl() {
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
			case InheritancePackage.SUPER_STRUCTURE1: return createSuperStructure1();
			case InheritancePackage.SUB_STRUCTURE1: return createSubStructure1();
			case InheritancePackage.SUB_STRUCTURE2: return createSubStructure2();
			case InheritancePackage.SUPER_STRUCTURE2: return createSuperStructure2();
			case InheritancePackage.SUB_STRUCTURE_WITHOUT_FIELDS: return createSubStructureWithoutFields();
			case InheritancePackage.A8_INHERITANCE: return createA8Inheritance();
			case InheritancePackage.B8_INHERITANCE: return createB8Inheritance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperStructure1 createSuperStructure1() {
		SuperStructure1Impl superStructure1 = new SuperStructure1Impl();
		return superStructure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubStructure1 createSubStructure1() {
		SubStructure1Impl subStructure1 = new SubStructure1Impl();
		return subStructure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubStructure2 createSubStructure2() {
		SubStructure2Impl subStructure2 = new SubStructure2Impl();
		return subStructure2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperStructure2 createSuperStructure2() {
		SuperStructure2Impl superStructure2 = new SuperStructure2Impl();
		return superStructure2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubStructureWithoutFields createSubStructureWithoutFields() {
		SubStructureWithoutFieldsImpl subStructureWithoutFields = new SubStructureWithoutFieldsImpl();
		return subStructureWithoutFields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A8Inheritance createA8Inheritance() {
		A8InheritanceImpl a8Inheritance = new A8InheritanceImpl();
		return a8Inheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B8Inheritance createB8Inheritance() {
		B8InheritanceImpl b8Inheritance = new B8InheritanceImpl();
		return b8Inheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritancePackage getInheritancePackage() {
		return (InheritancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InheritancePackage getPackage() {
		return InheritancePackage.eINSTANCE;
	}

} //InheritanceFactoryImpl

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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassbasedtextsFactoryImpl extends EFactoryImpl implements ClassbasedtextsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassbasedtextsFactory init() {
		try {
			ClassbasedtextsFactory theClassbasedtextsFactory = (ClassbasedtextsFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcasesfoundation/case005f/classbasedtexts"); 
			if (theClassbasedtextsFactory != null) {
				return theClassbasedtextsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassbasedtextsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassbasedtextsFactoryImpl() {
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
			case ClassbasedtextsPackage.GENERAL_TEXT: return createGeneralText();
			case ClassbasedtextsPackage.SPECIALIZED_TEXT: return createSpecializedText();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralText createGeneralText() {
		GeneralTextImpl generalText = new GeneralTextImpl();
		return generalText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializedText createSpecializedText() {
		SpecializedTextImpl specializedText = new SpecializedTextImpl();
		return specializedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassbasedtextsPackage getClassbasedtextsPackage() {
		return (ClassbasedtextsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassbasedtextsPackage getPackage() {
		return ClassbasedtextsPackage.eINSTANCE;
	}

} //ClassbasedtextsFactoryImpl

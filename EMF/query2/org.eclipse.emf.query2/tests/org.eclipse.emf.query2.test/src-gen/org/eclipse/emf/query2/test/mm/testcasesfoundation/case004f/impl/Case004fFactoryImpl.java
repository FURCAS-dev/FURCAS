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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Case004fFactoryImpl extends EFactoryImpl implements Case004fFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Case004fFactory init() {
		try {
			Case004fFactory theCase004fFactory = (Case004fFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcasesfoundation/case004f"); //$NON-NLS-1$ 
			if (theCase004fFactory != null) {
				return theCase004fFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Case004fFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case004fFactoryImpl() {
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
			case Case004fPackage.SHORT_TRANSLATABLE_TEXT_F: return createShortTranslatableTextF();
			case Case004fPackage.VERY_SHORT_TRANSLATABLE_TEXT_F: return createVeryShortTranslatableTextF();
			case Case004fPackage.BUTTON_TEXT_F: return createButtonTextF();
			case Case004fPackage.TRANSLATABLE_TEXT_F: return createTranslatableTextF();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortTranslatableTextF createShortTranslatableTextF() {
		ShortTranslatableTextFImpl shortTranslatableTextF = new ShortTranslatableTextFImpl();
		return shortTranslatableTextF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VeryShortTranslatableTextF createVeryShortTranslatableTextF() {
		VeryShortTranslatableTextFImpl veryShortTranslatableTextF = new VeryShortTranslatableTextFImpl();
		return veryShortTranslatableTextF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ButtonTextF createButtonTextF() {
		ButtonTextFImpl buttonTextF = new ButtonTextFImpl();
		return buttonTextF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslatableTextF createTranslatableTextF() {
		TranslatableTextFImpl translatableTextF = new TranslatableTextFImpl();
		return translatableTextF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case004fPackage getCase004fPackage() {
		return (Case004fPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Case004fPackage getPackage() {
		return Case004fPackage.eINSTANCE;
	}

} //Case004fFactoryImpl

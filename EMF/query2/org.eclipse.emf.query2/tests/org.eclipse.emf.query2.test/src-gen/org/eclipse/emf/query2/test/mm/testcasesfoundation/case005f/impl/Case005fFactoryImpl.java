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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Case005fFactoryImpl extends EFactoryImpl implements Case005fFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Case005fFactory init() {
		try {
			Case005fFactory theCase005fFactory = (Case005fFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcasesfoundation/case005f"); //$NON-NLS-1$ 
			if (theCase005fFactory != null) {
				return theCase005fFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Case005fFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case005fFactoryImpl() {
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
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT: return createA5fMigrationAttributeTypeTranslatableText();
			case Case005fPackage.A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT: return createA5fMigrationAttributeTypeText();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A5fMigrationAttributeTypeTranslatableText createA5fMigrationAttributeTypeTranslatableText() {
		A5fMigrationAttributeTypeTranslatableTextImpl a5fMigrationAttributeTypeTranslatableText = new A5fMigrationAttributeTypeTranslatableTextImpl();
		return a5fMigrationAttributeTypeTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A5fMigrationAttributeTypeText createA5fMigrationAttributeTypeText() {
		A5fMigrationAttributeTypeTextImpl a5fMigrationAttributeTypeText = new A5fMigrationAttributeTypeTextImpl();
		return a5fMigrationAttributeTypeText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case005fPackage getCase005fPackage() {
		return (Case005fPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Case005fPackage getPackage() {
		return Case005fPackage.eINSTANCE;
	}

} //Case005fFactoryImpl

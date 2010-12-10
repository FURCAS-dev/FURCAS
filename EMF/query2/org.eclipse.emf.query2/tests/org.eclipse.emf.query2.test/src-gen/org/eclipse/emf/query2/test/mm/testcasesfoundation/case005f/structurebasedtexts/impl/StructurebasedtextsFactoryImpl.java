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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructurebasedtextsFactoryImpl extends EFactoryImpl implements StructurebasedtextsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StructurebasedtextsFactory init() {
		try {
			StructurebasedtextsFactory theStructurebasedtextsFactory = (StructurebasedtextsFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/testcasesfoundation/case005f/structurebasedtexts"); 
			if (theStructurebasedtextsFactory != null) {
				return theStructurebasedtextsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StructurebasedtextsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructurebasedtextsFactoryImpl() {
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
			case StructurebasedtextsPackage.GENERAL_TRANSLATABLE_TEXT: return createGeneralTranslatableText();
			case StructurebasedtextsPackage.SPECIALIZED_TRANSLATABLE_TEXT: return createSpecializedTranslatableText();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralTranslatableText createGeneralTranslatableText() {
		GeneralTranslatableTextImpl generalTranslatableText = new GeneralTranslatableTextImpl();
		return generalTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializedTranslatableText createSpecializedTranslatableText() {
		SpecializedTranslatableTextImpl specializedTranslatableText = new SpecializedTranslatableTextImpl();
		return specializedTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructurebasedtextsPackage getStructurebasedtextsPackage() {
		return (StructurebasedtextsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StructurebasedtextsPackage getPackage() {
		return StructurebasedtextsPackage.eINSTANCE;
	}

} //StructurebasedtextsFactoryImpl

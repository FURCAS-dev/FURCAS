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
package org.eclipse.emf.query2.test.mm.generatedmetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.test.mm.generatedmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratedmetamodelFactoryImpl extends EFactoryImpl implements GeneratedmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratedmetamodelFactory init() {
		try {
			GeneratedmetamodelFactory theGeneratedmetamodelFactory = (GeneratedmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/generatedmetamodel"); 
			if (theGeneratedmetamodelFactory != null) {
				return theGeneratedmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GeneratedmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedmetamodelFactoryImpl() {
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
			case GeneratedmetamodelPackage.STRUCT_IN_STRUCT_TP: return createStructInStructTp();
			case GeneratedmetamodelPackage.STRUCT_TP: return createStructTp();
			case GeneratedmetamodelPackage.MODEL_CLASS0: return createModelClass0();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS0: return createModelSubClass0();
			case GeneratedmetamodelPackage.MODEL_CLASS1: return createModelClass1();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS1: return createModelSubClass1();
			case GeneratedmetamodelPackage.MODEL_CLASS2: return createModelClass2();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS2: return createModelSubClass2();
			case GeneratedmetamodelPackage.MODEL_CLASS3: return createModelClass3();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS3: return createModelSubClass3();
			case GeneratedmetamodelPackage.MODEL_CLASS4: return createModelClass4();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS4: return createModelSubClass4();
			case GeneratedmetamodelPackage.MODEL_CLASS5: return createModelClass5();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS5: return createModelSubClass5();
			case GeneratedmetamodelPackage.MODEL_CLASS6: return createModelClass6();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS6: return createModelSubClass6();
			case GeneratedmetamodelPackage.MODEL_CLASS7: return createModelClass7();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS7: return createModelSubClass7();
			case GeneratedmetamodelPackage.MODEL_CLASS8: return createModelClass8();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS8: return createModelSubClass8();
			case GeneratedmetamodelPackage.MODEL_CLASS9: return createModelClass9();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS9: return createModelSubClass9();
			case GeneratedmetamodelPackage.MODEL_CLASS10: return createModelClass10();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS10: return createModelSubClass10();
			case GeneratedmetamodelPackage.MODEL_CLASS11: return createModelClass11();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS11: return createModelSubClass11();
			case GeneratedmetamodelPackage.MODEL_CLASS12: return createModelClass12();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS12: return createModelSubClass12();
			case GeneratedmetamodelPackage.MODEL_CLASS13: return createModelClass13();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS13: return createModelSubClass13();
			case GeneratedmetamodelPackage.MODEL_CLASS14: return createModelClass14();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS14: return createModelSubClass14();
			case GeneratedmetamodelPackage.MODEL_CLASS15: return createModelClass15();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS15: return createModelSubClass15();
			case GeneratedmetamodelPackage.MODEL_CLASS16: return createModelClass16();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS16: return createModelSubClass16();
			case GeneratedmetamodelPackage.MODEL_CLASS17: return createModelClass17();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS17: return createModelSubClass17();
			case GeneratedmetamodelPackage.MODEL_CLASS18: return createModelClass18();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS18: return createModelSubClass18();
			case GeneratedmetamodelPackage.MODEL_CLASS19: return createModelClass19();
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS19: return createModelSubClass19();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GeneratedmetamodelPackage.ENUM_TP:
				return createEnumTpFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GeneratedmetamodelPackage.ENUM_TP:
				return convertEnumTpToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructInStructTp createStructInStructTp() {
		StructInStructTpImpl structInStructTp = new StructInStructTpImpl();
		return structInStructTp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructTp createStructTp() {
		StructTpImpl structTp = new StructTpImpl();
		return structTp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass0 createModelClass0() {
		ModelClass0Impl modelClass0 = new ModelClass0Impl();
		return modelClass0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass0 createModelSubClass0() {
		ModelSubClass0Impl modelSubClass0 = new ModelSubClass0Impl();
		return modelSubClass0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass1 createModelClass1() {
		ModelClass1Impl modelClass1 = new ModelClass1Impl();
		return modelClass1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass1 createModelSubClass1() {
		ModelSubClass1Impl modelSubClass1 = new ModelSubClass1Impl();
		return modelSubClass1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass2 createModelClass2() {
		ModelClass2Impl modelClass2 = new ModelClass2Impl();
		return modelClass2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass2 createModelSubClass2() {
		ModelSubClass2Impl modelSubClass2 = new ModelSubClass2Impl();
		return modelSubClass2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass3 createModelClass3() {
		ModelClass3Impl modelClass3 = new ModelClass3Impl();
		return modelClass3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass3 createModelSubClass3() {
		ModelSubClass3Impl modelSubClass3 = new ModelSubClass3Impl();
		return modelSubClass3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass4 createModelClass4() {
		ModelClass4Impl modelClass4 = new ModelClass4Impl();
		return modelClass4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass4 createModelSubClass4() {
		ModelSubClass4Impl modelSubClass4 = new ModelSubClass4Impl();
		return modelSubClass4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass5 createModelClass5() {
		ModelClass5Impl modelClass5 = new ModelClass5Impl();
		return modelClass5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass5 createModelSubClass5() {
		ModelSubClass5Impl modelSubClass5 = new ModelSubClass5Impl();
		return modelSubClass5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass6 createModelClass6() {
		ModelClass6Impl modelClass6 = new ModelClass6Impl();
		return modelClass6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass6 createModelSubClass6() {
		ModelSubClass6Impl modelSubClass6 = new ModelSubClass6Impl();
		return modelSubClass6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass7 createModelClass7() {
		ModelClass7Impl modelClass7 = new ModelClass7Impl();
		return modelClass7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass7 createModelSubClass7() {
		ModelSubClass7Impl modelSubClass7 = new ModelSubClass7Impl();
		return modelSubClass7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass8 createModelClass8() {
		ModelClass8Impl modelClass8 = new ModelClass8Impl();
		return modelClass8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass8 createModelSubClass8() {
		ModelSubClass8Impl modelSubClass8 = new ModelSubClass8Impl();
		return modelSubClass8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass9 createModelClass9() {
		ModelClass9Impl modelClass9 = new ModelClass9Impl();
		return modelClass9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass9 createModelSubClass9() {
		ModelSubClass9Impl modelSubClass9 = new ModelSubClass9Impl();
		return modelSubClass9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass10 createModelClass10() {
		ModelClass10Impl modelClass10 = new ModelClass10Impl();
		return modelClass10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass10 createModelSubClass10() {
		ModelSubClass10Impl modelSubClass10 = new ModelSubClass10Impl();
		return modelSubClass10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass11 createModelClass11() {
		ModelClass11Impl modelClass11 = new ModelClass11Impl();
		return modelClass11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass11 createModelSubClass11() {
		ModelSubClass11Impl modelSubClass11 = new ModelSubClass11Impl();
		return modelSubClass11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass12 createModelClass12() {
		ModelClass12Impl modelClass12 = new ModelClass12Impl();
		return modelClass12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass12 createModelSubClass12() {
		ModelSubClass12Impl modelSubClass12 = new ModelSubClass12Impl();
		return modelSubClass12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass13 createModelClass13() {
		ModelClass13Impl modelClass13 = new ModelClass13Impl();
		return modelClass13;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass13 createModelSubClass13() {
		ModelSubClass13Impl modelSubClass13 = new ModelSubClass13Impl();
		return modelSubClass13;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass14 createModelClass14() {
		ModelClass14Impl modelClass14 = new ModelClass14Impl();
		return modelClass14;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass14 createModelSubClass14() {
		ModelSubClass14Impl modelSubClass14 = new ModelSubClass14Impl();
		return modelSubClass14;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass15 createModelClass15() {
		ModelClass15Impl modelClass15 = new ModelClass15Impl();
		return modelClass15;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass15 createModelSubClass15() {
		ModelSubClass15Impl modelSubClass15 = new ModelSubClass15Impl();
		return modelSubClass15;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass16 createModelClass16() {
		ModelClass16Impl modelClass16 = new ModelClass16Impl();
		return modelClass16;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass16 createModelSubClass16() {
		ModelSubClass16Impl modelSubClass16 = new ModelSubClass16Impl();
		return modelSubClass16;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass17 createModelClass17() {
		ModelClass17Impl modelClass17 = new ModelClass17Impl();
		return modelClass17;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass17 createModelSubClass17() {
		ModelSubClass17Impl modelSubClass17 = new ModelSubClass17Impl();
		return modelSubClass17;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass18 createModelClass18() {
		ModelClass18Impl modelClass18 = new ModelClass18Impl();
		return modelClass18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass18 createModelSubClass18() {
		ModelSubClass18Impl modelSubClass18 = new ModelSubClass18Impl();
		return modelSubClass18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelClass19 createModelClass19() {
		ModelClass19Impl modelClass19 = new ModelClass19Impl();
		return modelClass19;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSubClass19 createModelSubClass19() {
		ModelSubClass19Impl modelSubClass19 = new ModelSubClass19Impl();
		return modelSubClass19;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumTp createEnumTpFromString(EDataType eDataType, String initialValue) {
		EnumTp result = EnumTp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumTpToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedmetamodelPackage getGeneratedmetamodelPackage() {
		return (GeneratedmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GeneratedmetamodelPackage getPackage() {
		return GeneratedmetamodelPackage.eINSTANCE;
	}

} //GeneratedmetamodelFactoryImpl

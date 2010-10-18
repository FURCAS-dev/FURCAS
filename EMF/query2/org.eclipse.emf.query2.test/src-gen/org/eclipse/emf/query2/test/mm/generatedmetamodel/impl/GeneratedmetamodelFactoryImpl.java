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
			case GeneratedmetamodelPackage.TEST_CLASS0: return createTestClass0();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS0: return createTestSubClass0();
			case GeneratedmetamodelPackage.TEST_CLASS1: return createTestClass1();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS1: return createTestSubClass1();
			case GeneratedmetamodelPackage.TEST_CLASS2: return createTestClass2();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS2: return createTestSubClass2();
			case GeneratedmetamodelPackage.TEST_CLASS3: return createTestClass3();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS3: return createTestSubClass3();
			case GeneratedmetamodelPackage.TEST_CLASS4: return createTestClass4();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS4: return createTestSubClass4();
			case GeneratedmetamodelPackage.TEST_CLASS5: return createTestClass5();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS5: return createTestSubClass5();
			case GeneratedmetamodelPackage.TEST_CLASS6: return createTestClass6();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS6: return createTestSubClass6();
			case GeneratedmetamodelPackage.TEST_CLASS7: return createTestClass7();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS7: return createTestSubClass7();
			case GeneratedmetamodelPackage.TEST_CLASS8: return createTestClass8();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS8: return createTestSubClass8();
			case GeneratedmetamodelPackage.TEST_CLASS9: return createTestClass9();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS9: return createTestSubClass9();
			case GeneratedmetamodelPackage.TEST_CLASS10: return createTestClass10();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS10: return createTestSubClass10();
			case GeneratedmetamodelPackage.TEST_CLASS11: return createTestClass11();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS11: return createTestSubClass11();
			case GeneratedmetamodelPackage.TEST_CLASS12: return createTestClass12();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS12: return createTestSubClass12();
			case GeneratedmetamodelPackage.TEST_CLASS13: return createTestClass13();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS13: return createTestSubClass13();
			case GeneratedmetamodelPackage.TEST_CLASS14: return createTestClass14();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS14: return createTestSubClass14();
			case GeneratedmetamodelPackage.TEST_CLASS15: return createTestClass15();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS15: return createTestSubClass15();
			case GeneratedmetamodelPackage.TEST_CLASS16: return createTestClass16();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS16: return createTestSubClass16();
			case GeneratedmetamodelPackage.TEST_CLASS17: return createTestClass17();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS17: return createTestSubClass17();
			case GeneratedmetamodelPackage.TEST_CLASS18: return createTestClass18();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS18: return createTestSubClass18();
			case GeneratedmetamodelPackage.TEST_CLASS19: return createTestClass19();
			case GeneratedmetamodelPackage.TEST_SUB_CLASS19: return createTestSubClass19();
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
	public TestClass0 createTestClass0() {
		TestClass0Impl testClass0 = new TestClass0Impl();
		return testClass0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass0 createTestSubClass0() {
		TestSubClass0Impl testSubClass0 = new TestSubClass0Impl();
		return testSubClass0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass1 createTestClass1() {
		TestClass1Impl testClass1 = new TestClass1Impl();
		return testClass1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass1 createTestSubClass1() {
		TestSubClass1Impl testSubClass1 = new TestSubClass1Impl();
		return testSubClass1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass2 createTestClass2() {
		TestClass2Impl testClass2 = new TestClass2Impl();
		return testClass2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass2 createTestSubClass2() {
		TestSubClass2Impl testSubClass2 = new TestSubClass2Impl();
		return testSubClass2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass3 createTestClass3() {
		TestClass3Impl testClass3 = new TestClass3Impl();
		return testClass3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass3 createTestSubClass3() {
		TestSubClass3Impl testSubClass3 = new TestSubClass3Impl();
		return testSubClass3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass4 createTestClass4() {
		TestClass4Impl testClass4 = new TestClass4Impl();
		return testClass4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass4 createTestSubClass4() {
		TestSubClass4Impl testSubClass4 = new TestSubClass4Impl();
		return testSubClass4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass5 createTestClass5() {
		TestClass5Impl testClass5 = new TestClass5Impl();
		return testClass5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass5 createTestSubClass5() {
		TestSubClass5Impl testSubClass5 = new TestSubClass5Impl();
		return testSubClass5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass6 createTestClass6() {
		TestClass6Impl testClass6 = new TestClass6Impl();
		return testClass6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass6 createTestSubClass6() {
		TestSubClass6Impl testSubClass6 = new TestSubClass6Impl();
		return testSubClass6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass7 createTestClass7() {
		TestClass7Impl testClass7 = new TestClass7Impl();
		return testClass7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass7 createTestSubClass7() {
		TestSubClass7Impl testSubClass7 = new TestSubClass7Impl();
		return testSubClass7;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass8 createTestClass8() {
		TestClass8Impl testClass8 = new TestClass8Impl();
		return testClass8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass8 createTestSubClass8() {
		TestSubClass8Impl testSubClass8 = new TestSubClass8Impl();
		return testSubClass8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass9 createTestClass9() {
		TestClass9Impl testClass9 = new TestClass9Impl();
		return testClass9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass9 createTestSubClass9() {
		TestSubClass9Impl testSubClass9 = new TestSubClass9Impl();
		return testSubClass9;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass10 createTestClass10() {
		TestClass10Impl testClass10 = new TestClass10Impl();
		return testClass10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass10 createTestSubClass10() {
		TestSubClass10Impl testSubClass10 = new TestSubClass10Impl();
		return testSubClass10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass11 createTestClass11() {
		TestClass11Impl testClass11 = new TestClass11Impl();
		return testClass11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass11 createTestSubClass11() {
		TestSubClass11Impl testSubClass11 = new TestSubClass11Impl();
		return testSubClass11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass12 createTestClass12() {
		TestClass12Impl testClass12 = new TestClass12Impl();
		return testClass12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass12 createTestSubClass12() {
		TestSubClass12Impl testSubClass12 = new TestSubClass12Impl();
		return testSubClass12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass13 createTestClass13() {
		TestClass13Impl testClass13 = new TestClass13Impl();
		return testClass13;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass13 createTestSubClass13() {
		TestSubClass13Impl testSubClass13 = new TestSubClass13Impl();
		return testSubClass13;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass14 createTestClass14() {
		TestClass14Impl testClass14 = new TestClass14Impl();
		return testClass14;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass14 createTestSubClass14() {
		TestSubClass14Impl testSubClass14 = new TestSubClass14Impl();
		return testSubClass14;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass15 createTestClass15() {
		TestClass15Impl testClass15 = new TestClass15Impl();
		return testClass15;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass15 createTestSubClass15() {
		TestSubClass15Impl testSubClass15 = new TestSubClass15Impl();
		return testSubClass15;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass16 createTestClass16() {
		TestClass16Impl testClass16 = new TestClass16Impl();
		return testClass16;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass16 createTestSubClass16() {
		TestSubClass16Impl testSubClass16 = new TestSubClass16Impl();
		return testSubClass16;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass17 createTestClass17() {
		TestClass17Impl testClass17 = new TestClass17Impl();
		return testClass17;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass17 createTestSubClass17() {
		TestSubClass17Impl testSubClass17 = new TestSubClass17Impl();
		return testSubClass17;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass18 createTestClass18() {
		TestClass18Impl testClass18 = new TestClass18Impl();
		return testClass18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass18 createTestSubClass18() {
		TestSubClass18Impl testSubClass18 = new TestSubClass18Impl();
		return testSubClass18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestClass19 createTestClass19() {
		TestClass19Impl testClass19 = new TestClass19Impl();
		return testClass19;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSubClass19 createTestSubClass19() {
		TestSubClass19Impl testSubClass19 = new TestSubClass19Impl();
		return testSubClass19;
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

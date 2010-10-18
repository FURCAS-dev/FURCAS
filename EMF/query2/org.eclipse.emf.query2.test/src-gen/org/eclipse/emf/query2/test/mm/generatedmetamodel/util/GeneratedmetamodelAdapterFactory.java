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
package org.eclipse.emf.query2.test.mm.generatedmetamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.generatedmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage
 * @generated
 */
public class GeneratedmetamodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratedmetamodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedmetamodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GeneratedmetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratedmetamodelSwitch<Adapter> modelSwitch =
		new GeneratedmetamodelSwitch<Adapter>() {
			@Override
			public Adapter caseStructInStructTp(StructInStructTp object) {
				return createStructInStructTpAdapter();
			}
			@Override
			public Adapter caseStructTp(StructTp object) {
				return createStructTpAdapter();
			}
			@Override
			public Adapter caseTestClass0(TestClass0 object) {
				return createTestClass0Adapter();
			}
			@Override
			public Adapter caseTestSubClass0(TestSubClass0 object) {
				return createTestSubClass0Adapter();
			}
			@Override
			public Adapter caseTestClass1(TestClass1 object) {
				return createTestClass1Adapter();
			}
			@Override
			public Adapter caseTestSubClass1(TestSubClass1 object) {
				return createTestSubClass1Adapter();
			}
			@Override
			public Adapter caseTestClass2(TestClass2 object) {
				return createTestClass2Adapter();
			}
			@Override
			public Adapter caseTestSubClass2(TestSubClass2 object) {
				return createTestSubClass2Adapter();
			}
			@Override
			public Adapter caseTestClass3(TestClass3 object) {
				return createTestClass3Adapter();
			}
			@Override
			public Adapter caseTestSubClass3(TestSubClass3 object) {
				return createTestSubClass3Adapter();
			}
			@Override
			public Adapter caseTestClass4(TestClass4 object) {
				return createTestClass4Adapter();
			}
			@Override
			public Adapter caseTestSubClass4(TestSubClass4 object) {
				return createTestSubClass4Adapter();
			}
			@Override
			public Adapter caseTestClass5(TestClass5 object) {
				return createTestClass5Adapter();
			}
			@Override
			public Adapter caseTestSubClass5(TestSubClass5 object) {
				return createTestSubClass5Adapter();
			}
			@Override
			public Adapter caseTestClass6(TestClass6 object) {
				return createTestClass6Adapter();
			}
			@Override
			public Adapter caseTestSubClass6(TestSubClass6 object) {
				return createTestSubClass6Adapter();
			}
			@Override
			public Adapter caseTestClass7(TestClass7 object) {
				return createTestClass7Adapter();
			}
			@Override
			public Adapter caseTestSubClass7(TestSubClass7 object) {
				return createTestSubClass7Adapter();
			}
			@Override
			public Adapter caseTestClass8(TestClass8 object) {
				return createTestClass8Adapter();
			}
			@Override
			public Adapter caseTestSubClass8(TestSubClass8 object) {
				return createTestSubClass8Adapter();
			}
			@Override
			public Adapter caseTestClass9(TestClass9 object) {
				return createTestClass9Adapter();
			}
			@Override
			public Adapter caseTestSubClass9(TestSubClass9 object) {
				return createTestSubClass9Adapter();
			}
			@Override
			public Adapter caseTestClass10(TestClass10 object) {
				return createTestClass10Adapter();
			}
			@Override
			public Adapter caseTestSubClass10(TestSubClass10 object) {
				return createTestSubClass10Adapter();
			}
			@Override
			public Adapter caseTestClass11(TestClass11 object) {
				return createTestClass11Adapter();
			}
			@Override
			public Adapter caseTestSubClass11(TestSubClass11 object) {
				return createTestSubClass11Adapter();
			}
			@Override
			public Adapter caseTestClass12(TestClass12 object) {
				return createTestClass12Adapter();
			}
			@Override
			public Adapter caseTestSubClass12(TestSubClass12 object) {
				return createTestSubClass12Adapter();
			}
			@Override
			public Adapter caseTestClass13(TestClass13 object) {
				return createTestClass13Adapter();
			}
			@Override
			public Adapter caseTestSubClass13(TestSubClass13 object) {
				return createTestSubClass13Adapter();
			}
			@Override
			public Adapter caseTestClass14(TestClass14 object) {
				return createTestClass14Adapter();
			}
			@Override
			public Adapter caseTestSubClass14(TestSubClass14 object) {
				return createTestSubClass14Adapter();
			}
			@Override
			public Adapter caseTestClass15(TestClass15 object) {
				return createTestClass15Adapter();
			}
			@Override
			public Adapter caseTestSubClass15(TestSubClass15 object) {
				return createTestSubClass15Adapter();
			}
			@Override
			public Adapter caseTestClass16(TestClass16 object) {
				return createTestClass16Adapter();
			}
			@Override
			public Adapter caseTestSubClass16(TestSubClass16 object) {
				return createTestSubClass16Adapter();
			}
			@Override
			public Adapter caseTestClass17(TestClass17 object) {
				return createTestClass17Adapter();
			}
			@Override
			public Adapter caseTestSubClass17(TestSubClass17 object) {
				return createTestSubClass17Adapter();
			}
			@Override
			public Adapter caseTestClass18(TestClass18 object) {
				return createTestClass18Adapter();
			}
			@Override
			public Adapter caseTestSubClass18(TestSubClass18 object) {
				return createTestSubClass18Adapter();
			}
			@Override
			public Adapter caseTestClass19(TestClass19 object) {
				return createTestClass19Adapter();
			}
			@Override
			public Adapter caseTestSubClass19(TestSubClass19 object) {
				return createTestSubClass19Adapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp <em>Struct In Struct Tp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.StructInStructTp
	 * @generated
	 */
	public Adapter createStructInStructTpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp <em>Struct Tp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.StructTp
	 * @generated
	 */
	public Adapter createStructTpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass0 <em>Test Class0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass0
	 * @generated
	 */
	public Adapter createTestClass0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass0 <em>Test Sub Class0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass0
	 * @generated
	 */
	public Adapter createTestSubClass0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass1 <em>Test Class1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass1
	 * @generated
	 */
	public Adapter createTestClass1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass1 <em>Test Sub Class1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass1
	 * @generated
	 */
	public Adapter createTestSubClass1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass2 <em>Test Class2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass2
	 * @generated
	 */
	public Adapter createTestClass2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass2 <em>Test Sub Class2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass2
	 * @generated
	 */
	public Adapter createTestSubClass2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass3 <em>Test Class3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass3
	 * @generated
	 */
	public Adapter createTestClass3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass3 <em>Test Sub Class3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass3
	 * @generated
	 */
	public Adapter createTestSubClass3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass4 <em>Test Class4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass4
	 * @generated
	 */
	public Adapter createTestClass4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass4 <em>Test Sub Class4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass4
	 * @generated
	 */
	public Adapter createTestSubClass4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass5 <em>Test Class5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass5
	 * @generated
	 */
	public Adapter createTestClass5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass5 <em>Test Sub Class5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass5
	 * @generated
	 */
	public Adapter createTestSubClass5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass6 <em>Test Class6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass6
	 * @generated
	 */
	public Adapter createTestClass6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass6 <em>Test Sub Class6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass6
	 * @generated
	 */
	public Adapter createTestSubClass6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass7 <em>Test Class7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass7
	 * @generated
	 */
	public Adapter createTestClass7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass7 <em>Test Sub Class7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass7
	 * @generated
	 */
	public Adapter createTestSubClass7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass8 <em>Test Class8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass8
	 * @generated
	 */
	public Adapter createTestClass8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass8 <em>Test Sub Class8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass8
	 * @generated
	 */
	public Adapter createTestSubClass8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass9 <em>Test Class9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass9
	 * @generated
	 */
	public Adapter createTestClass9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass9 <em>Test Sub Class9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass9
	 * @generated
	 */
	public Adapter createTestSubClass9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass10 <em>Test Class10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass10
	 * @generated
	 */
	public Adapter createTestClass10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass10 <em>Test Sub Class10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass10
	 * @generated
	 */
	public Adapter createTestSubClass10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass11 <em>Test Class11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass11
	 * @generated
	 */
	public Adapter createTestClass11Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass11 <em>Test Sub Class11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass11
	 * @generated
	 */
	public Adapter createTestSubClass11Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass12 <em>Test Class12</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass12
	 * @generated
	 */
	public Adapter createTestClass12Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass12 <em>Test Sub Class12</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass12
	 * @generated
	 */
	public Adapter createTestSubClass12Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass13 <em>Test Class13</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass13
	 * @generated
	 */
	public Adapter createTestClass13Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass13 <em>Test Sub Class13</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass13
	 * @generated
	 */
	public Adapter createTestSubClass13Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass14 <em>Test Class14</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass14
	 * @generated
	 */
	public Adapter createTestClass14Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass14 <em>Test Sub Class14</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass14
	 * @generated
	 */
	public Adapter createTestSubClass14Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass15 <em>Test Class15</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass15
	 * @generated
	 */
	public Adapter createTestClass15Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass15 <em>Test Sub Class15</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass15
	 * @generated
	 */
	public Adapter createTestSubClass15Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass16 <em>Test Class16</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass16
	 * @generated
	 */
	public Adapter createTestClass16Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass16 <em>Test Sub Class16</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass16
	 * @generated
	 */
	public Adapter createTestSubClass16Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass17 <em>Test Class17</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass17
	 * @generated
	 */
	public Adapter createTestClass17Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass17 <em>Test Sub Class17</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass17
	 * @generated
	 */
	public Adapter createTestSubClass17Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass18 <em>Test Class18</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass18
	 * @generated
	 */
	public Adapter createTestClass18Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass18 <em>Test Sub Class18</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass18
	 * @generated
	 */
	public Adapter createTestSubClass18Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass19 <em>Test Class19</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestClass19
	 * @generated
	 */
	public Adapter createTestClass19Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass19 <em>Test Sub Class19</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.TestSubClass19
	 * @generated
	 */
	public Adapter createTestSubClass19Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GeneratedmetamodelAdapterFactory

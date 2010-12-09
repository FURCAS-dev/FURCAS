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
			public Adapter caseModelClass0(ModelClass0 object) {
				return createModelClass0Adapter();
			}
			@Override
			public Adapter caseModelSubClass0(ModelSubClass0 object) {
				return createModelSubClass0Adapter();
			}
			@Override
			public Adapter caseModelClass1(ModelClass1 object) {
				return createModelClass1Adapter();
			}
			@Override
			public Adapter caseModelSubClass1(ModelSubClass1 object) {
				return createModelSubClass1Adapter();
			}
			@Override
			public Adapter caseModelClass2(ModelClass2 object) {
				return createModelClass2Adapter();
			}
			@Override
			public Adapter caseModelSubClass2(ModelSubClass2 object) {
				return createModelSubClass2Adapter();
			}
			@Override
			public Adapter caseModelClass3(ModelClass3 object) {
				return createModelClass3Adapter();
			}
			@Override
			public Adapter caseModelSubClass3(ModelSubClass3 object) {
				return createModelSubClass3Adapter();
			}
			@Override
			public Adapter caseModelClass4(ModelClass4 object) {
				return createModelClass4Adapter();
			}
			@Override
			public Adapter caseModelSubClass4(ModelSubClass4 object) {
				return createModelSubClass4Adapter();
			}
			@Override
			public Adapter caseModelClass5(ModelClass5 object) {
				return createModelClass5Adapter();
			}
			@Override
			public Adapter caseModelSubClass5(ModelSubClass5 object) {
				return createModelSubClass5Adapter();
			}
			@Override
			public Adapter caseModelClass6(ModelClass6 object) {
				return createModelClass6Adapter();
			}
			@Override
			public Adapter caseModelSubClass6(ModelSubClass6 object) {
				return createModelSubClass6Adapter();
			}
			@Override
			public Adapter caseModelClass7(ModelClass7 object) {
				return createModelClass7Adapter();
			}
			@Override
			public Adapter caseModelSubClass7(ModelSubClass7 object) {
				return createModelSubClass7Adapter();
			}
			@Override
			public Adapter caseModelClass8(ModelClass8 object) {
				return createModelClass8Adapter();
			}
			@Override
			public Adapter caseModelSubClass8(ModelSubClass8 object) {
				return createModelSubClass8Adapter();
			}
			@Override
			public Adapter caseModelClass9(ModelClass9 object) {
				return createModelClass9Adapter();
			}
			@Override
			public Adapter caseModelSubClass9(ModelSubClass9 object) {
				return createModelSubClass9Adapter();
			}
			@Override
			public Adapter caseModelClass10(ModelClass10 object) {
				return createModelClass10Adapter();
			}
			@Override
			public Adapter caseModelSubClass10(ModelSubClass10 object) {
				return createModelSubClass10Adapter();
			}
			@Override
			public Adapter caseModelClass11(ModelClass11 object) {
				return createModelClass11Adapter();
			}
			@Override
			public Adapter caseModelSubClass11(ModelSubClass11 object) {
				return createModelSubClass11Adapter();
			}
			@Override
			public Adapter caseModelClass12(ModelClass12 object) {
				return createModelClass12Adapter();
			}
			@Override
			public Adapter caseModelSubClass12(ModelSubClass12 object) {
				return createModelSubClass12Adapter();
			}
			@Override
			public Adapter caseModelClass13(ModelClass13 object) {
				return createModelClass13Adapter();
			}
			@Override
			public Adapter caseModelSubClass13(ModelSubClass13 object) {
				return createModelSubClass13Adapter();
			}
			@Override
			public Adapter caseModelClass14(ModelClass14 object) {
				return createModelClass14Adapter();
			}
			@Override
			public Adapter caseModelSubClass14(ModelSubClass14 object) {
				return createModelSubClass14Adapter();
			}
			@Override
			public Adapter caseModelClass15(ModelClass15 object) {
				return createModelClass15Adapter();
			}
			@Override
			public Adapter caseModelSubClass15(ModelSubClass15 object) {
				return createModelSubClass15Adapter();
			}
			@Override
			public Adapter caseModelClass16(ModelClass16 object) {
				return createModelClass16Adapter();
			}
			@Override
			public Adapter caseModelSubClass16(ModelSubClass16 object) {
				return createModelSubClass16Adapter();
			}
			@Override
			public Adapter caseModelClass17(ModelClass17 object) {
				return createModelClass17Adapter();
			}
			@Override
			public Adapter caseModelSubClass17(ModelSubClass17 object) {
				return createModelSubClass17Adapter();
			}
			@Override
			public Adapter caseModelClass18(ModelClass18 object) {
				return createModelClass18Adapter();
			}
			@Override
			public Adapter caseModelSubClass18(ModelSubClass18 object) {
				return createModelSubClass18Adapter();
			}
			@Override
			public Adapter caseModelClass19(ModelClass19 object) {
				return createModelClass19Adapter();
			}
			@Override
			public Adapter caseModelSubClass19(ModelSubClass19 object) {
				return createModelSubClass19Adapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass0 <em>Model Class0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass0
	 * @generated
	 */
	public Adapter createModelClass0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass0 <em>Model Sub Class0</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass0
	 * @generated
	 */
	public Adapter createModelSubClass0Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass1 <em>Model Class1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass1
	 * @generated
	 */
	public Adapter createModelClass1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass1 <em>Model Sub Class1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass1
	 * @generated
	 */
	public Adapter createModelSubClass1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass2 <em>Model Class2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass2
	 * @generated
	 */
	public Adapter createModelClass2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass2 <em>Model Sub Class2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass2
	 * @generated
	 */
	public Adapter createModelSubClass2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass3 <em>Model Class3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass3
	 * @generated
	 */
	public Adapter createModelClass3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass3 <em>Model Sub Class3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass3
	 * @generated
	 */
	public Adapter createModelSubClass3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass4 <em>Model Class4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass4
	 * @generated
	 */
	public Adapter createModelClass4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass4 <em>Model Sub Class4</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass4
	 * @generated
	 */
	public Adapter createModelSubClass4Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass5 <em>Model Class5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass5
	 * @generated
	 */
	public Adapter createModelClass5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass5 <em>Model Sub Class5</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass5
	 * @generated
	 */
	public Adapter createModelSubClass5Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass6 <em>Model Class6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass6
	 * @generated
	 */
	public Adapter createModelClass6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass6 <em>Model Sub Class6</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass6
	 * @generated
	 */
	public Adapter createModelSubClass6Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass7 <em>Model Class7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass7
	 * @generated
	 */
	public Adapter createModelClass7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass7 <em>Model Sub Class7</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass7
	 * @generated
	 */
	public Adapter createModelSubClass7Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass8 <em>Model Class8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass8
	 * @generated
	 */
	public Adapter createModelClass8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass8 <em>Model Sub Class8</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass8
	 * @generated
	 */
	public Adapter createModelSubClass8Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass9 <em>Model Class9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass9
	 * @generated
	 */
	public Adapter createModelClass9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass9 <em>Model Sub Class9</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass9
	 * @generated
	 */
	public Adapter createModelSubClass9Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass10 <em>Model Class10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass10
	 * @generated
	 */
	public Adapter createModelClass10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass10 <em>Model Sub Class10</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass10
	 * @generated
	 */
	public Adapter createModelSubClass10Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass11 <em>Model Class11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass11
	 * @generated
	 */
	public Adapter createModelClass11Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass11 <em>Model Sub Class11</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass11
	 * @generated
	 */
	public Adapter createModelSubClass11Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass12 <em>Model Class12</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass12
	 * @generated
	 */
	public Adapter createModelClass12Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass12 <em>Model Sub Class12</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass12
	 * @generated
	 */
	public Adapter createModelSubClass12Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass13 <em>Model Class13</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass13
	 * @generated
	 */
	public Adapter createModelClass13Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass13 <em>Model Sub Class13</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass13
	 * @generated
	 */
	public Adapter createModelSubClass13Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass14 <em>Model Class14</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass14
	 * @generated
	 */
	public Adapter createModelClass14Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass14 <em>Model Sub Class14</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass14
	 * @generated
	 */
	public Adapter createModelSubClass14Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass15 <em>Model Class15</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass15
	 * @generated
	 */
	public Adapter createModelClass15Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass15 <em>Model Sub Class15</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass15
	 * @generated
	 */
	public Adapter createModelSubClass15Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass16 <em>Model Class16</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass16
	 * @generated
	 */
	public Adapter createModelClass16Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass16 <em>Model Sub Class16</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass16
	 * @generated
	 */
	public Adapter createModelSubClass16Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass17 <em>Model Class17</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass17
	 * @generated
	 */
	public Adapter createModelClass17Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass17 <em>Model Sub Class17</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass17
	 * @generated
	 */
	public Adapter createModelSubClass17Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass18 <em>Model Class18</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass18
	 * @generated
	 */
	public Adapter createModelClass18Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass18 <em>Model Sub Class18</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass18
	 * @generated
	 */
	public Adapter createModelSubClass18Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass19 <em>Model Class19</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelClass19
	 * @generated
	 */
	public Adapter createModelClass19Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass19 <em>Model Sub Class19</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.ModelSubClass19
	 * @generated
	 */
	public Adapter createModelSubClass19Adapter() {
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

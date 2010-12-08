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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.generatedmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.generatedmetamodel.GeneratedmetamodelPackage
 * @generated
 */
public class GeneratedmetamodelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratedmetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedmetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = GeneratedmetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GeneratedmetamodelPackage.STRUCT_IN_STRUCT_TP: {
				StructInStructTp structInStructTp = (StructInStructTp)theEObject;
				T result = caseStructInStructTp(structInStructTp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.STRUCT_TP: {
				StructTp structTp = (StructTp)theEObject;
				T result = caseStructTp(structTp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS0: {
				TestClass0 testClass0 = (TestClass0)theEObject;
				T result = caseTestClass0(testClass0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS0: {
				TestSubClass0 testSubClass0 = (TestSubClass0)theEObject;
				T result = caseTestSubClass0(testSubClass0);
				if (result == null) result = caseTestClass0(testSubClass0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS1: {
				TestClass1 testClass1 = (TestClass1)theEObject;
				T result = caseTestClass1(testClass1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS1: {
				TestSubClass1 testSubClass1 = (TestSubClass1)theEObject;
				T result = caseTestSubClass1(testSubClass1);
				if (result == null) result = caseTestClass1(testSubClass1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS2: {
				TestClass2 testClass2 = (TestClass2)theEObject;
				T result = caseTestClass2(testClass2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS2: {
				TestSubClass2 testSubClass2 = (TestSubClass2)theEObject;
				T result = caseTestSubClass2(testSubClass2);
				if (result == null) result = caseTestClass2(testSubClass2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS3: {
				TestClass3 testClass3 = (TestClass3)theEObject;
				T result = caseTestClass3(testClass3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS3: {
				TestSubClass3 testSubClass3 = (TestSubClass3)theEObject;
				T result = caseTestSubClass3(testSubClass3);
				if (result == null) result = caseTestClass3(testSubClass3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS4: {
				TestClass4 testClass4 = (TestClass4)theEObject;
				T result = caseTestClass4(testClass4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS4: {
				TestSubClass4 testSubClass4 = (TestSubClass4)theEObject;
				T result = caseTestSubClass4(testSubClass4);
				if (result == null) result = caseTestClass4(testSubClass4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS5: {
				TestClass5 testClass5 = (TestClass5)theEObject;
				T result = caseTestClass5(testClass5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS5: {
				TestSubClass5 testSubClass5 = (TestSubClass5)theEObject;
				T result = caseTestSubClass5(testSubClass5);
				if (result == null) result = caseTestClass5(testSubClass5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS6: {
				TestClass6 testClass6 = (TestClass6)theEObject;
				T result = caseTestClass6(testClass6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS6: {
				TestSubClass6 testSubClass6 = (TestSubClass6)theEObject;
				T result = caseTestSubClass6(testSubClass6);
				if (result == null) result = caseTestClass6(testSubClass6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS7: {
				TestClass7 testClass7 = (TestClass7)theEObject;
				T result = caseTestClass7(testClass7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS7: {
				TestSubClass7 testSubClass7 = (TestSubClass7)theEObject;
				T result = caseTestSubClass7(testSubClass7);
				if (result == null) result = caseTestClass7(testSubClass7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS8: {
				TestClass8 testClass8 = (TestClass8)theEObject;
				T result = caseTestClass8(testClass8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS8: {
				TestSubClass8 testSubClass8 = (TestSubClass8)theEObject;
				T result = caseTestSubClass8(testSubClass8);
				if (result == null) result = caseTestClass8(testSubClass8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS9: {
				TestClass9 testClass9 = (TestClass9)theEObject;
				T result = caseTestClass9(testClass9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS9: {
				TestSubClass9 testSubClass9 = (TestSubClass9)theEObject;
				T result = caseTestSubClass9(testSubClass9);
				if (result == null) result = caseTestClass9(testSubClass9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS10: {
				TestClass10 testClass10 = (TestClass10)theEObject;
				T result = caseTestClass10(testClass10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS10: {
				TestSubClass10 testSubClass10 = (TestSubClass10)theEObject;
				T result = caseTestSubClass10(testSubClass10);
				if (result == null) result = caseTestClass10(testSubClass10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS11: {
				TestClass11 testClass11 = (TestClass11)theEObject;
				T result = caseTestClass11(testClass11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS11: {
				TestSubClass11 testSubClass11 = (TestSubClass11)theEObject;
				T result = caseTestSubClass11(testSubClass11);
				if (result == null) result = caseTestClass11(testSubClass11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS12: {
				TestClass12 testClass12 = (TestClass12)theEObject;
				T result = caseTestClass12(testClass12);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS12: {
				TestSubClass12 testSubClass12 = (TestSubClass12)theEObject;
				T result = caseTestSubClass12(testSubClass12);
				if (result == null) result = caseTestClass12(testSubClass12);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS13: {
				TestClass13 testClass13 = (TestClass13)theEObject;
				T result = caseTestClass13(testClass13);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS13: {
				TestSubClass13 testSubClass13 = (TestSubClass13)theEObject;
				T result = caseTestSubClass13(testSubClass13);
				if (result == null) result = caseTestClass13(testSubClass13);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS14: {
				TestClass14 testClass14 = (TestClass14)theEObject;
				T result = caseTestClass14(testClass14);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS14: {
				TestSubClass14 testSubClass14 = (TestSubClass14)theEObject;
				T result = caseTestSubClass14(testSubClass14);
				if (result == null) result = caseTestClass14(testSubClass14);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS15: {
				TestClass15 testClass15 = (TestClass15)theEObject;
				T result = caseTestClass15(testClass15);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS15: {
				TestSubClass15 testSubClass15 = (TestSubClass15)theEObject;
				T result = caseTestSubClass15(testSubClass15);
				if (result == null) result = caseTestClass15(testSubClass15);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS16: {
				TestClass16 testClass16 = (TestClass16)theEObject;
				T result = caseTestClass16(testClass16);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS16: {
				TestSubClass16 testSubClass16 = (TestSubClass16)theEObject;
				T result = caseTestSubClass16(testSubClass16);
				if (result == null) result = caseTestClass16(testSubClass16);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS17: {
				TestClass17 testClass17 = (TestClass17)theEObject;
				T result = caseTestClass17(testClass17);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS17: {
				TestSubClass17 testSubClass17 = (TestSubClass17)theEObject;
				T result = caseTestSubClass17(testSubClass17);
				if (result == null) result = caseTestClass17(testSubClass17);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS18: {
				TestClass18 testClass18 = (TestClass18)theEObject;
				T result = caseTestClass18(testClass18);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS18: {
				TestSubClass18 testSubClass18 = (TestSubClass18)theEObject;
				T result = caseTestSubClass18(testSubClass18);
				if (result == null) result = caseTestClass18(testSubClass18);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_CLASS19: {
				TestClass19 testClass19 = (TestClass19)theEObject;
				T result = caseTestClass19(testClass19);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.TEST_SUB_CLASS19: {
				TestSubClass19 testSubClass19 = (TestSubClass19)theEObject;
				T result = caseTestSubClass19(testSubClass19);
				if (result == null) result = caseTestClass19(testSubClass19);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct In Struct Tp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct In Struct Tp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructInStructTp(StructInStructTp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Tp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Tp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructTp(StructTp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class0</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class0</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass0(TestClass0 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class0</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class0</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass0(TestSubClass0 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass1(TestClass1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass1(TestSubClass1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass2(TestClass2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass2(TestSubClass2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass3(TestClass3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass3(TestSubClass3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass4(TestClass4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass4(TestSubClass4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass5(TestClass5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass5(TestSubClass5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class6</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class6</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass6(TestClass6 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class6</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class6</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass6(TestSubClass6 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class7</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class7</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass7(TestClass7 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class7</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class7</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass7(TestSubClass7 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass8(TestClass8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass8(TestSubClass8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass9(TestClass9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass9(TestSubClass9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass10(TestClass10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass10(TestSubClass10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass11(TestClass11 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass11(TestSubClass11 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class12</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class12</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass12(TestClass12 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class12</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class12</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass12(TestSubClass12 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class13</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class13</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass13(TestClass13 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class13</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class13</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass13(TestSubClass13 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class14</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class14</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass14(TestClass14 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class14</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class14</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass14(TestSubClass14 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class15</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class15</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass15(TestClass15 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class15</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class15</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass15(TestSubClass15 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class16</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class16</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass16(TestClass16 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class16</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class16</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass16(TestSubClass16 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class17</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class17</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass17(TestClass17 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class17</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class17</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass17(TestSubClass17 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class18</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class18</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass18(TestClass18 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class18</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class18</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass18(TestSubClass18 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Class19</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Class19</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestClass19(TestClass19 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Sub Class19</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Sub Class19</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestSubClass19(TestSubClass19 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //GeneratedmetamodelSwitch

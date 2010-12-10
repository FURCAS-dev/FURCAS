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
			case GeneratedmetamodelPackage.MODEL_CLASS0: {
				ModelClass0 modelClass0 = (ModelClass0)theEObject;
				T result = caseModelClass0(modelClass0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS0: {
				ModelSubClass0 modelSubClass0 = (ModelSubClass0)theEObject;
				T result = caseModelSubClass0(modelSubClass0);
				if (result == null) result = caseModelClass0(modelSubClass0);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS1: {
				ModelClass1 modelClass1 = (ModelClass1)theEObject;
				T result = caseModelClass1(modelClass1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS1: {
				ModelSubClass1 modelSubClass1 = (ModelSubClass1)theEObject;
				T result = caseModelSubClass1(modelSubClass1);
				if (result == null) result = caseModelClass1(modelSubClass1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS2: {
				ModelClass2 modelClass2 = (ModelClass2)theEObject;
				T result = caseModelClass2(modelClass2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS2: {
				ModelSubClass2 modelSubClass2 = (ModelSubClass2)theEObject;
				T result = caseModelSubClass2(modelSubClass2);
				if (result == null) result = caseModelClass2(modelSubClass2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS3: {
				ModelClass3 modelClass3 = (ModelClass3)theEObject;
				T result = caseModelClass3(modelClass3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS3: {
				ModelSubClass3 modelSubClass3 = (ModelSubClass3)theEObject;
				T result = caseModelSubClass3(modelSubClass3);
				if (result == null) result = caseModelClass3(modelSubClass3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS4: {
				ModelClass4 modelClass4 = (ModelClass4)theEObject;
				T result = caseModelClass4(modelClass4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS4: {
				ModelSubClass4 modelSubClass4 = (ModelSubClass4)theEObject;
				T result = caseModelSubClass4(modelSubClass4);
				if (result == null) result = caseModelClass4(modelSubClass4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS5: {
				ModelClass5 modelClass5 = (ModelClass5)theEObject;
				T result = caseModelClass5(modelClass5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS5: {
				ModelSubClass5 modelSubClass5 = (ModelSubClass5)theEObject;
				T result = caseModelSubClass5(modelSubClass5);
				if (result == null) result = caseModelClass5(modelSubClass5);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS6: {
				ModelClass6 modelClass6 = (ModelClass6)theEObject;
				T result = caseModelClass6(modelClass6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS6: {
				ModelSubClass6 modelSubClass6 = (ModelSubClass6)theEObject;
				T result = caseModelSubClass6(modelSubClass6);
				if (result == null) result = caseModelClass6(modelSubClass6);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS7: {
				ModelClass7 modelClass7 = (ModelClass7)theEObject;
				T result = caseModelClass7(modelClass7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS7: {
				ModelSubClass7 modelSubClass7 = (ModelSubClass7)theEObject;
				T result = caseModelSubClass7(modelSubClass7);
				if (result == null) result = caseModelClass7(modelSubClass7);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS8: {
				ModelClass8 modelClass8 = (ModelClass8)theEObject;
				T result = caseModelClass8(modelClass8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS8: {
				ModelSubClass8 modelSubClass8 = (ModelSubClass8)theEObject;
				T result = caseModelSubClass8(modelSubClass8);
				if (result == null) result = caseModelClass8(modelSubClass8);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS9: {
				ModelClass9 modelClass9 = (ModelClass9)theEObject;
				T result = caseModelClass9(modelClass9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS9: {
				ModelSubClass9 modelSubClass9 = (ModelSubClass9)theEObject;
				T result = caseModelSubClass9(modelSubClass9);
				if (result == null) result = caseModelClass9(modelSubClass9);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS10: {
				ModelClass10 modelClass10 = (ModelClass10)theEObject;
				T result = caseModelClass10(modelClass10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS10: {
				ModelSubClass10 modelSubClass10 = (ModelSubClass10)theEObject;
				T result = caseModelSubClass10(modelSubClass10);
				if (result == null) result = caseModelClass10(modelSubClass10);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS11: {
				ModelClass11 modelClass11 = (ModelClass11)theEObject;
				T result = caseModelClass11(modelClass11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS11: {
				ModelSubClass11 modelSubClass11 = (ModelSubClass11)theEObject;
				T result = caseModelSubClass11(modelSubClass11);
				if (result == null) result = caseModelClass11(modelSubClass11);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS12: {
				ModelClass12 modelClass12 = (ModelClass12)theEObject;
				T result = caseModelClass12(modelClass12);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS12: {
				ModelSubClass12 modelSubClass12 = (ModelSubClass12)theEObject;
				T result = caseModelSubClass12(modelSubClass12);
				if (result == null) result = caseModelClass12(modelSubClass12);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS13: {
				ModelClass13 modelClass13 = (ModelClass13)theEObject;
				T result = caseModelClass13(modelClass13);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS13: {
				ModelSubClass13 modelSubClass13 = (ModelSubClass13)theEObject;
				T result = caseModelSubClass13(modelSubClass13);
				if (result == null) result = caseModelClass13(modelSubClass13);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS14: {
				ModelClass14 modelClass14 = (ModelClass14)theEObject;
				T result = caseModelClass14(modelClass14);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS14: {
				ModelSubClass14 modelSubClass14 = (ModelSubClass14)theEObject;
				T result = caseModelSubClass14(modelSubClass14);
				if (result == null) result = caseModelClass14(modelSubClass14);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS15: {
				ModelClass15 modelClass15 = (ModelClass15)theEObject;
				T result = caseModelClass15(modelClass15);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS15: {
				ModelSubClass15 modelSubClass15 = (ModelSubClass15)theEObject;
				T result = caseModelSubClass15(modelSubClass15);
				if (result == null) result = caseModelClass15(modelSubClass15);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS16: {
				ModelClass16 modelClass16 = (ModelClass16)theEObject;
				T result = caseModelClass16(modelClass16);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS16: {
				ModelSubClass16 modelSubClass16 = (ModelSubClass16)theEObject;
				T result = caseModelSubClass16(modelSubClass16);
				if (result == null) result = caseModelClass16(modelSubClass16);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS17: {
				ModelClass17 modelClass17 = (ModelClass17)theEObject;
				T result = caseModelClass17(modelClass17);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS17: {
				ModelSubClass17 modelSubClass17 = (ModelSubClass17)theEObject;
				T result = caseModelSubClass17(modelSubClass17);
				if (result == null) result = caseModelClass17(modelSubClass17);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS18: {
				ModelClass18 modelClass18 = (ModelClass18)theEObject;
				T result = caseModelClass18(modelClass18);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS18: {
				ModelSubClass18 modelSubClass18 = (ModelSubClass18)theEObject;
				T result = caseModelSubClass18(modelSubClass18);
				if (result == null) result = caseModelClass18(modelSubClass18);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_CLASS19: {
				ModelClass19 modelClass19 = (ModelClass19)theEObject;
				T result = caseModelClass19(modelClass19);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratedmetamodelPackage.MODEL_SUB_CLASS19: {
				ModelSubClass19 modelSubClass19 = (ModelSubClass19)theEObject;
				T result = caseModelSubClass19(modelSubClass19);
				if (result == null) result = caseModelClass19(modelSubClass19);
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
	 * Returns the result of interpreting the object as an instance of '<em>Model Class0</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class0</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass0(ModelClass0 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class0</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class0</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass0(ModelSubClass0 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass1(ModelClass1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass1(ModelSubClass1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass2(ModelClass2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass2(ModelSubClass2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass3(ModelClass3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass3(ModelSubClass3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass4(ModelClass4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass4(ModelSubClass4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass5(ModelClass5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class5</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class5</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass5(ModelSubClass5 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class6</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class6</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass6(ModelClass6 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class6</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class6</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass6(ModelSubClass6 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class7</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class7</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass7(ModelClass7 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class7</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class7</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass7(ModelSubClass7 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass8(ModelClass8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class8</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class8</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass8(ModelSubClass8 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass9(ModelClass9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class9</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class9</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass9(ModelSubClass9 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass10(ModelClass10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class10</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class10</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass10(ModelSubClass10 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass11(ModelClass11 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class11</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class11</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass11(ModelSubClass11 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class12</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class12</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass12(ModelClass12 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class12</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class12</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass12(ModelSubClass12 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class13</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class13</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass13(ModelClass13 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class13</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class13</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass13(ModelSubClass13 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class14</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class14</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass14(ModelClass14 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class14</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class14</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass14(ModelSubClass14 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class15</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class15</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass15(ModelClass15 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class15</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class15</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass15(ModelSubClass15 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class16</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class16</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass16(ModelClass16 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class16</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class16</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass16(ModelSubClass16 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class17</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class17</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass17(ModelClass17 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class17</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class17</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass17(ModelSubClass17 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class18</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class18</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass18(ModelClass18 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class18</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class18</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass18(ModelSubClass18 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Class19</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Class19</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelClass19(ModelClass19 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Sub Class19</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Sub Class19</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSubClass19(ModelSubClass19 object) {
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

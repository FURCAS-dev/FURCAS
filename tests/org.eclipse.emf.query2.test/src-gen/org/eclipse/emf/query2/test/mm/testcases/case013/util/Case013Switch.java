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
package org.eclipse.emf.query2.test.mm.testcases.case013.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcases.case013.*;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package
 * @generated
 */
public class Case013Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Case013Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case013Switch() {
		if (modelPackage == null) {
			modelPackage = Case013Package.eINSTANCE;
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
			case Case013Package.A13: {
				A13 a13 = (A13)theEObject;
				T result = caseA13(a13);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case013Package.B13: {
				B13 b13 = (B13)theEObject;
				T result = caseB13(b13);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case013Package.B13_SUB2: {
				B13Sub2 b13Sub2 = (B13Sub2)theEObject;
				T result = caseB13Sub2(b13Sub2);
				if (result == null) result = caseB13(b13Sub2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case013Package.B13_SUB2_SUB: {
				B13Sub2Sub b13Sub2Sub = (B13Sub2Sub)theEObject;
				T result = caseB13Sub2Sub(b13Sub2Sub);
				if (result == null) result = caseB13Sub2(b13Sub2Sub);
				if (result == null) result = caseB13(b13Sub2Sub);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case013Package.B13_SUB1: {
				B13Sub1 b13Sub1 = (B13Sub1)theEObject;
				T result = caseB13Sub1(b13Sub1);
				if (result == null) result = caseB13(b13Sub1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case013Package.B13_SUB1_SUB2: {
				B13Sub1Sub2 b13Sub1Sub2 = (B13Sub1Sub2)theEObject;
				T result = caseB13Sub1Sub2(b13Sub1Sub2);
				if (result == null) result = caseB13Sub1(b13Sub1Sub2);
				if (result == null) result = caseB13Sub2(b13Sub1Sub2);
				if (result == null) result = caseB13(b13Sub1Sub2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case013Package.C13_ABSTRACT: {
				C13Abstract c13Abstract = (C13Abstract)theEObject;
				T result = caseC13Abstract(c13Abstract);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case013Package.C13_SUB: {
				C13Sub c13Sub = (C13Sub)theEObject;
				T result = caseC13Sub(c13Sub);
				if (result == null) result = caseC13Abstract(c13Sub);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A13</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A13</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA13(A13 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B13</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B13</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB13(B13 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B13 Sub2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B13 Sub2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB13Sub2(B13Sub2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B13 Sub2 Sub</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B13 Sub2 Sub</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB13Sub2Sub(B13Sub2Sub object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B13 Sub1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B13 Sub1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB13Sub1(B13Sub1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B13 Sub1 Sub2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B13 Sub1 Sub2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB13Sub1Sub2(B13Sub1Sub2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>C13 Abstract</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>C13 Abstract</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseC13Abstract(C13Abstract object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>C13 Sub</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>C13 Sub</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseC13Sub(C13Sub object) {
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

} //Case013Switch

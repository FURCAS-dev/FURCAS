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
package org.eclipse.emf.query2.test.mm.testcases.case004.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcases.case004.*;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package
 * @generated
 */
public class Case004Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Case004Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case004Switch() {
		if (modelPackage == null) {
			modelPackage = Case004Package.eINSTANCE;
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
			case Case004Package.A4: {
				A4 a4 = (A4)theEObject;
				T result = caseA4(a4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.B4_HAS_CONSTANT: {
				B4HasConstant b4HasConstant = (B4HasConstant)theEObject;
				T result = caseB4HasConstant(b4HasConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.C4: {
				C4 c4 = (C4)theEObject;
				T result = caseC4(c4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.D4: {
				D4 d4 = (D4)theEObject;
				T result = caseD4(d4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.B4: {
				B4 b4 = (B4)theEObject;
				T result = caseB4(b4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.F4: {
				F4 f4 = (F4)theEObject;
				T result = caseF4(f4);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.A4_SUB: {
				A4Sub a4Sub = (A4Sub)theEObject;
				T result = caseA4Sub(a4Sub);
				if (result == null) result = caseA4(a4Sub);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.D4_SUB: {
				D4Sub d4Sub = (D4Sub)theEObject;
				T result = caseD4Sub(d4Sub);
				if (result == null) result = caseD4(d4Sub);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.C4_SUB: {
				C4Sub c4Sub = (C4Sub)theEObject;
				T result = caseC4Sub(c4Sub);
				if (result == null) result = caseC4(c4Sub);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.F4_SUB: {
				F4Sub f4Sub = (F4Sub)theEObject;
				T result = caseF4Sub(f4Sub);
				if (result == null) result = caseF4(f4Sub);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.HAS_CS: {
				hasCs hasCs = (hasCs)theEObject;
				T result = casehasCs(hasCs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.COMPOSES_CS: {
				composesCs composesCs = (composesCs)theEObject;
				T result = casecomposesCs(composesCs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.COMPOSES_B: {
				composesB composesB = (composesB)theEObject;
				T result = casecomposesB(composesB);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Case004Package.COMPOSES_CS_ORDERED: {
				composesCsOrdered composesCsOrdered = (composesCsOrdered)theEObject;
				T result = casecomposesCsOrdered(composesCsOrdered);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA4(A4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B4 Has Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B4 Has Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB4HasConstant(B4HasConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>C4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>C4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseC4(C4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>D4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>D4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseD4(D4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB4(B4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>F4</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>F4</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseF4(F4 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A4 Sub</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A4 Sub</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA4Sub(A4Sub object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>D4 Sub</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>D4 Sub</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseD4Sub(D4Sub object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>C4 Sub</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>C4 Sub</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseC4Sub(C4Sub object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>F4 Sub</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>F4 Sub</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseF4Sub(F4Sub object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>has Cs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>has Cs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casehasCs(hasCs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>composes Cs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>composes Cs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecomposesCs(composesCs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>composes B</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>composes B</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecomposesB(composesB object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>composes Cs Ordered</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>composes Cs Ordered</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casecomposesCsOrdered(composesCsOrdered object) {
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

} //Case004Switch

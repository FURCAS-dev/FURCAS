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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.*;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage
 * @generated
 */
public class InheritanceSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static InheritancePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritanceSwitch() {
		if (modelPackage == null) {
			modelPackage = InheritancePackage.eINSTANCE;
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
			case InheritancePackage.SUPER_STRUCTURE1: {
				SuperStructure1 superStructure1 = (SuperStructure1)theEObject;
				T result = caseSuperStructure1(superStructure1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InheritancePackage.SUB_STRUCTURE1: {
				SubStructure1 subStructure1 = (SubStructure1)theEObject;
				T result = caseSubStructure1(subStructure1);
				if (result == null) result = caseSuperStructure1(subStructure1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InheritancePackage.SUB_STRUCTURE2: {
				SubStructure2 subStructure2 = (SubStructure2)theEObject;
				T result = caseSubStructure2(subStructure2);
				if (result == null) result = caseSuperStructure1(subStructure2);
				if (result == null) result = caseSuperStructure2(subStructure2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InheritancePackage.SUPER_STRUCTURE2: {
				SuperStructure2 superStructure2 = (SuperStructure2)theEObject;
				T result = caseSuperStructure2(superStructure2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InheritancePackage.SUB_STRUCTURE_WITHOUT_FIELDS: {
				SubStructureWithoutFields subStructureWithoutFields = (SubStructureWithoutFields)theEObject;
				T result = caseSubStructureWithoutFields(subStructureWithoutFields);
				if (result == null) result = caseSuperStructure1(subStructureWithoutFields);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InheritancePackage.A8_INHERITANCE: {
				A8Inheritance a8Inheritance = (A8Inheritance)theEObject;
				T result = caseA8Inheritance(a8Inheritance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InheritancePackage.B8_INHERITANCE: {
				B8Inheritance b8Inheritance = (B8Inheritance)theEObject;
				T result = caseB8Inheritance(b8Inheritance);
				if (result == null) result = caseA8Inheritance(b8Inheritance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Structure1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Structure1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperStructure1(SuperStructure1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Structure1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Structure1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubStructure1(SubStructure1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Structure2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Structure2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubStructure2(SubStructure2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Super Structure2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Super Structure2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSuperStructure2(SuperStructure2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Structure Without Fields</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Structure Without Fields</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubStructureWithoutFields(SubStructureWithoutFields object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A8 Inheritance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A8 Inheritance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA8Inheritance(A8Inheritance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B8 Inheritance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B8 Inheritance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB8Inheritance(B8Inheritance object) {
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

} //InheritanceSwitch

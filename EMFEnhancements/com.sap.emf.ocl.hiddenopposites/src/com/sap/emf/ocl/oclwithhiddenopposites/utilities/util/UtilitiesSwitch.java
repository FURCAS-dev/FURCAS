/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.oclwithhiddenopposites.utilities.util;

import com.sap.emf.ocl.oclwithhiddenopposites.utilities.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.utilities.Visitor;

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
 * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesPackage
 * @generated
 */
public class UtilitiesSwitch<T1> {
	/**
         * The cached model package
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected static UtilitiesPackage modelPackage;

	/**
         * Creates an instance of the switch.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public UtilitiesSwitch() {
                if (modelPackage == null) {
                        modelPackage = UtilitiesPackage.eINSTANCE;
                }
        }

	/**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
	public T1 doSwitch(EObject theEObject) {
                return doSwitch(theEObject.eClass(), theEObject);
        }

	/**
         * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the first non-null result returned by a <code>caseXXX</code> call.
         * @generated
         */
	protected T1 doSwitch(EClass theEClass, EObject theEObject) {
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
                switch (classifierID) {
                        case UtilitiesPackage.VISITOR_WITH_HIDDEN_OPPOSITE: {
                                VisitorWithHiddenOpposite<?> visitorWithHiddenOpposite = (VisitorWithHiddenOpposite<?>)theEObject;
                                T1 result = caseVisitorWithHiddenOpposite(visitorWithHiddenOpposite);
                                if (result == null) result = caseVisitor(visitorWithHiddenOpposite);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        default: return defaultCase(theEObject);
                }
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Visitor With Hidden Opposite</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Visitor With Hidden Opposite</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public <T> T1 caseVisitorWithHiddenOpposite(VisitorWithHiddenOpposite<T> object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Visitor</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Visitor</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public <T, C, O, P, EL, PM, S, COA, SSA, CT> T1 caseVisitor(Visitor<T, C, O, P, EL, PM, S, COA, SSA, CT> object) {
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
	public T1 defaultCase(EObject object) {
                return null;
        }

} //UtilitiesSwitch

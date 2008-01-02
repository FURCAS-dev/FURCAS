/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UtilitiesSwitch.java,v 1.6 2008/01/02 20:12:59 cdamus Exp $
 */
package org.eclipse.ocl.utilities.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.ocl.utilities.*;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
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
 * @see org.eclipse.ocl.utilities.UtilitiesPackage
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
            case UtilitiesPackage.AST_NODE: {
                ASTNode astNode = (ASTNode)theEObject;
                T1 result = caseASTNode(astNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UtilitiesPackage.CALLING_AST_NODE: {
                CallingASTNode callingASTNode = (CallingASTNode)theEObject;
                T1 result = caseCallingASTNode(callingASTNode);
                if (result == null) result = caseASTNode(callingASTNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UtilitiesPackage.TYPED_AST_NODE: {
                TypedASTNode typedASTNode = (TypedASTNode)theEObject;
                T1 result = caseTypedASTNode(typedASTNode);
                if (result == null) result = caseASTNode(typedASTNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UtilitiesPackage.VISITABLE: {
                Visitable visitable = (Visitable)theEObject;
                T1 result = caseVisitable(visitable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UtilitiesPackage.VISITOR: {
                Visitor<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> visitor = (Visitor<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)theEObject;
                T1 result = caseVisitor(visitor);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UtilitiesPackage.TYPED_ELEMENT: {
                TypedElement<?> typedElement = (TypedElement<?>)theEObject;
                T1 result = caseTypedElement(typedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UtilitiesPackage.EXPRESSION_IN_OCL: {
                ExpressionInOCL<?, ?> expressionInOCL = (ExpressionInOCL<?, ?>)theEObject;
                T1 result = caseExpressionInOCL(expressionInOCL);
                if (result == null) result = caseVisitable(expressionInOCL);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case UtilitiesPackage.PREDEFINED_TYPE: {
                PredefinedType<?> predefinedType = (PredefinedType<?>)theEObject;
                T1 result = casePredefinedType(predefinedType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 caseASTNode(ASTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Calling AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 caseCallingASTNode(CallingASTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Predefined Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <O> T1 casePredefinedType(PredefinedType<O> object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed AST Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 caseTypedASTNode(TypedASTNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T1 caseVisitable(Visitable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C> T1 caseTypedElement(TypedElement<C> object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public <C, PM> T1 caseExpressionInOCL(ExpressionInOCL<C, PM> object) {
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

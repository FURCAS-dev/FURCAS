/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.expressions.util;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;

import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.NavigationCallExp;
import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;

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
 * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch<T> {
	/**
         * The cached model package
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	protected static ExpressionsPackage modelPackage;

	/**
         * Creates an instance of the switch.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public ExpressionsSwitch() {
                if (modelPackage == null) {
                        modelPackage = ExpressionsPackage.eINSTANCE;
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
                        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP: {
                                OppositePropertyCallExp oppositePropertyCallExp = (OppositePropertyCallExp)theEObject;
                                T result = caseOppositePropertyCallExp(oppositePropertyCallExp);
                                if (result == null) result = caseEcore_NavigationCallExp(oppositePropertyCallExp);
                                if (result == null) result = caseEcore_FeatureCallExp(oppositePropertyCallExp);
                                if (result == null) result = caseNavigationCallExp(oppositePropertyCallExp);
                                if (result == null) result = caseEcore_CallExp(oppositePropertyCallExp);
                                if (result == null) result = caseFeatureCallExp(oppositePropertyCallExp);
                                if (result == null) result = caseEcore_OCLExpression(oppositePropertyCallExp);
                                if (result == null) result = caseCallExp(oppositePropertyCallExp);
                                if (result == null) result = caseETypedElement(oppositePropertyCallExp);
                                if (result == null) result = caseOCLExpression(oppositePropertyCallExp);
                                if (result == null) result = caseCallingASTNode(oppositePropertyCallExp);
                                if (result == null) result = caseENamedElement(oppositePropertyCallExp);
                                if (result == null) result = caseTypedElement(oppositePropertyCallExp);
                                if (result == null) result = caseVisitable(oppositePropertyCallExp);
                                if (result == null) result = caseASTNode(oppositePropertyCallExp);
                                if (result == null) result = caseEModelElement(oppositePropertyCallExp);
                                if (result == null) result = defaultCase(theEObject);
                                return result;
                        }
                        default: return defaultCase(theEObject);
                }
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Opposite Property Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Opposite Property Call Exp</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseOppositePropertyCallExp(OppositePropertyCallExp object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseEModelElement(EModelElement object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseENamedElement(ENamedElement object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>ETyped Element</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>ETyped Element</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseETypedElement(ETypedElement object) {
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
	public <C> T caseTypedElement(TypedElement<C> object) {
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
	public T caseVisitable(Visitable object) {
                return null;
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
	public T caseASTNode(ASTNode object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public <C> T caseOCLExpression(OCLExpression<C> object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseEcore_OCLExpression(org.eclipse.ocl.ecore.OCLExpression object) {
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
	public T caseCallingASTNode(CallingASTNode object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public <C> T caseCallExp(CallExp<C> object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseEcore_CallExp(org.eclipse.ocl.ecore.CallExp object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public <C> T caseFeatureCallExp(FeatureCallExp<C> object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Feature Call Exp</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseEcore_FeatureCallExp(org.eclipse.ocl.ecore.FeatureCallExp object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public <C, P> T caseNavigationCallExp(NavigationCallExp<C, P> object) {
                return null;
        }

	/**
         * Returns the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
         * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
         * @param object the target of the switch.
         * @return the result of interpreting the object as an instance of '<em>Navigation Call Exp</em>'.
         * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
         * @generated
         */
	public T caseEcore_NavigationCallExp(org.eclipse.ocl.ecore.NavigationCallExp object) {
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

} //ExpressionsSwitch

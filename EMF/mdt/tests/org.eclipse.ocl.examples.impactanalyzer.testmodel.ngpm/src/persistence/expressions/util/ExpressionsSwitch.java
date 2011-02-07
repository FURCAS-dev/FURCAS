/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpressionsSwitch.java,v 1.1 2011/02/07 17:21:38 auhl Exp $
 */
package persistence.expressions.util;

import data.classes.InScope;
import data.classes.TypedElement;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ObjectBasedExpression;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import persistence.expressions.*;

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
 * @see persistence.expressions.ExpressionsPackage
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
            case ExpressionsPackage.ALL: {
                All all = (All)theEObject;
                T result = caseAll(all);
                if (result == null) result = caseExpression(all);
                if (result == null) result = caseTypedElement(all);
                if (result == null) result = caseInScope(all);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.COMMIT: {
                Commit commit = (Commit)theEObject;
                T result = caseCommit(commit);
                if (result == null) result = caseExpression(commit);
                if (result == null) result = caseTypedElement(commit);
                if (result == null) result = caseInScope(commit);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ExpressionsPackage.SNAPSHOT: {
                Snapshot snapshot = (Snapshot)theEObject;
                T result = caseSnapshot(snapshot);
                if (result == null) result = caseObjectBasedExpression(snapshot);
                if (result == null) result = caseExpression(snapshot);
                if (result == null) result = caseTypedElement(snapshot);
                if (result == null) result = caseInScope(snapshot);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>All</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>All</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAll(All object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Commit</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Commit</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCommit(Commit object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Snapshot</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Snapshot</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSnapshot(Snapshot object) {
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
	public T caseTypedElement(TypedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>In Scope</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>In Scope</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInScope(InScope object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExpression(Expression object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Object Based Expression</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Object Based Expression</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseObjectBasedExpression(ObjectBasedExpression object) {
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

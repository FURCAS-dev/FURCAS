/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionsSwitch.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package persistence.actions.util;

import behavioral.actions.Statement;
import behavioral.actions.StatementWithArgument;

import data.classes.InScope;

import dataaccess.expressions.WithArgument;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import persistence.actions.*;

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
 * @see persistence.actions.ActionsPackage
 * @generated
 */
public class ActionsSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static ActionsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionsSwitch() {
        if (modelPackage == null) {
            modelPackage = ActionsPackage.eINSTANCE;
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
            case ActionsPackage.STORE: {
                Store store = (Store)theEObject;
                T result = caseStore(store);
                if (result == null) result = caseStatementWithEntityArgument(store);
                if (result == null) result = caseStatementWithArgument(store);
                if (result == null) result = caseStatement(store);
                if (result == null) result = caseWithArgument(store);
                if (result == null) result = caseInScope(store);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.DELETE: {
                Delete delete = (Delete)theEObject;
                T result = caseDelete(delete);
                if (result == null) result = caseStatementWithEntityArgument(delete);
                if (result == null) result = caseStatementWithArgument(delete);
                if (result == null) result = caseStatement(delete);
                if (result == null) result = caseWithArgument(delete);
                if (result == null) result = caseInScope(delete);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.STATEMENT_WITH_ENTITY_ARGUMENT: {
                StatementWithEntityArgument statementWithEntityArgument = (StatementWithEntityArgument)theEObject;
                T result = caseStatementWithEntityArgument(statementWithEntityArgument);
                if (result == null) result = caseStatementWithArgument(statementWithEntityArgument);
                if (result == null) result = caseStatement(statementWithEntityArgument);
                if (result == null) result = caseWithArgument(statementWithEntityArgument);
                if (result == null) result = caseInScope(statementWithEntityArgument);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case ActionsPackage.ROLLBACK: {
                Rollback rollback = (Rollback)theEObject;
                T result = caseRollback(rollback);
                if (result == null) result = caseStatement(rollback);
                if (result == null) result = caseInScope(rollback);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Store</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Store</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStore(Store object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Delete</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Delete</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDelete(Delete object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Statement With Entity Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement With Entity Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatementWithEntityArgument(StatementWithEntityArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Rollback</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rollback</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRollback(Rollback object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatement(Statement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>With Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>With Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseWithArgument(WithArgument object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Statement With Argument</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement With Argument</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatementWithArgument(StatementWithArgument object) {
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

} //ActionsSwitch

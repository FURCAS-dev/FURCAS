/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.util;

import behavioral.status_and_action_old.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see behavioral.status_and_action_old.Status_and_action_oldPackage
 * @generated
 */
public class Status_and_action_oldSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static Status_and_action_oldPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Status_and_action_oldSwitch() {
        if (modelPackage == null) {
            modelPackage = Status_and_action_oldPackage.eINSTANCE;
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
            case Status_and_action_oldPackage.SAM_ACTION: {
                SAMAction samAction = (SAMAction)theEObject;
                T result = caseSAMAction(samAction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE: {
                SAMStatusVariable samStatusVariable = (SAMStatusVariable)theEObject;
                T result = caseSAMStatusVariable(samStatusVariable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_DERIVATOR: {
                SAMDerivator samDerivator = (SAMDerivator)theEObject;
                T result = caseSAMDerivator(samDerivator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_STATUS_VALUE: {
                SAMStatusValue samStatusValue = (SAMStatusValue)theEObject;
                T result = caseSAMStatusValue(samStatusValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA: {
                SAMStatusSchema samStatusSchema = (SAMStatusSchema)theEObject;
                T result = caseSAMStatusSchema(samStatusSchema);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_OPERATOR: {
                SAMOperator samOperator = (SAMOperator)theEObject;
                T result = caseSAMOperator(samOperator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE: {
                SAMSchemaVariable samSchemaVariable = (SAMSchemaVariable)theEObject;
                T result = caseSAMSchemaVariable(samSchemaVariable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE: {
                SAMSchemaValue samSchemaValue = (SAMSchemaValue)theEObject;
                T result = caseSAMSchemaValue(samSchemaValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION: {
                SAMSchemaAction samSchemaAction = (SAMSchemaAction)theEObject;
                T result = caseSAMSchemaAction(samSchemaAction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR: {
                SAMSchemaDerivator samSchemaDerivator = (SAMSchemaDerivator)theEObject;
                T result = caseSAMSchemaDerivator(samSchemaDerivator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Action</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMAction(SAMAction object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Status Variable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Status Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMStatusVariable(SAMStatusVariable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Derivator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Derivator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMDerivator(SAMDerivator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Status Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Status Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMStatusValue(SAMStatusValue object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Status Schema</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Status Schema</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMStatusSchema(SAMStatusSchema object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Operator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Operator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMOperator(SAMOperator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Schema Variable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Schema Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMSchemaVariable(SAMSchemaVariable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Schema Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Schema Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMSchemaValue(SAMSchemaValue object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Schema Action</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Schema Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMSchemaAction(SAMSchemaAction object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>SAM Schema Derivator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SAM Schema Derivator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSAMSchemaDerivator(SAMSchemaDerivator object) {
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

} //Status_and_action_oldSwitch

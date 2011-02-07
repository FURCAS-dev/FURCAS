/**
 * <copyright>
 * </copyright>
 *
 * $Id: DesignSwitch.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.status_and_action.design.util;

import behavioral.status_and_action.design.*;

import java.util.List;

import modelmanagement.NamedElement;

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
 * @see behavioral.status_and_action.design.DesignPackage
 * @generated
 */
public class DesignSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static DesignPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DesignSwitch() {
        if (modelPackage == null) {
            modelPackage = DesignPackage.eINSTANCE;
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
            case DesignPackage.BUSINESS_OBJECT: {
                BusinessObject businessObject = (BusinessObject)theEObject;
                T result = caseBusinessObject(businessObject);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DesignPackage.BUSINESS_OBJECT_NODE: {
                BusinessObjectNode businessObjectNode = (BusinessObjectNode)theEObject;
                T result = caseBusinessObjectNode(businessObjectNode);
                if (result == null) result = caseNamedElement(businessObjectNode);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DesignPackage.STATUS_VARIABLE: {
                StatusVariable statusVariable = (StatusVariable)theEObject;
                T result = caseStatusVariable(statusVariable);
                if (result == null) result = caseAbstractStatusVariable(statusVariable);
                if (result == null) result = caseNamedElement(statusVariable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DesignPackage.STATUS_VALUE: {
                StatusValue statusValue = (StatusValue)theEObject;
                T result = caseStatusValue(statusValue);
                if (result == null) result = caseAbstractStatusValue(statusValue);
                if (result == null) result = caseNamedElement(statusValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DesignPackage.ACTION: {
                Action action = (Action)theEObject;
                T result = caseAction(action);
                if (result == null) result = caseAbstractAction(action);
                if (result == null) result = caseNamedElement(action);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DesignPackage.ABSTRACT_STATUS_VARIABLE: {
                AbstractStatusVariable abstractStatusVariable = (AbstractStatusVariable)theEObject;
                T result = caseAbstractStatusVariable(abstractStatusVariable);
                if (result == null) result = caseNamedElement(abstractStatusVariable);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DesignPackage.ABSTRACT_STATUS_VALUE: {
                AbstractStatusValue abstractStatusValue = (AbstractStatusValue)theEObject;
                T result = caseAbstractStatusValue(abstractStatusValue);
                if (result == null) result = caseNamedElement(abstractStatusValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case DesignPackage.ABSTRACT_ACTION: {
                AbstractAction abstractAction = (AbstractAction)theEObject;
                T result = caseAbstractAction(abstractAction);
                if (result == null) result = caseNamedElement(abstractAction);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Business Object</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Business Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusinessObject(BusinessObject object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Business Object Node</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Business Object Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusinessObjectNode(BusinessObjectNode object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Status Variable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Status Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatusVariable(StatusVariable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Status Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Status Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatusValue(StatusValue object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAction(Action object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Status Variable</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Status Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbstractStatusVariable(AbstractStatusVariable object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Status Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Status Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbstractStatusValue(AbstractStatusValue object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbstractAction(AbstractAction object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedElement(NamedElement object) {
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

} //DesignSwitch

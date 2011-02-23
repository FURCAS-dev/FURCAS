/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssemblySwitch.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.status_and_action.assembly.util;

import behavioral.status_and_action.assembly.*;

import behavioral.status_and_action.design.AbstractAction;
import behavioral.status_and_action.design.AbstractStatusValue;
import behavioral.status_and_action.design.AbstractStatusVariable;
import behavioral.status_and_action.design.Action;
import behavioral.status_and_action.design.StatusValue;
import behavioral.status_and_action.design.StatusVariable;

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
 * @see behavioral.status_and_action.assembly.AssemblyPackage
 * @generated
 */
public class AssemblySwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AssemblyPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssemblySwitch() {
        if (modelPackage == null) {
            modelPackage = AssemblyPackage.eINSTANCE;
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
            case AssemblyPackage.STATUS_SCHEMA: {
                StatusSchema statusSchema = (StatusSchema)theEObject;
                T result = caseStatusSchema(statusSchema);
                if (result == null) result = caseNamedElement(statusSchema);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.CONNECTOR: {
                Connector connector = (Connector)theEObject;
                T result = caseConnector(connector);
                if (result == null) result = caseSchemaElement(connector);
                if (result == null) result = caseNamedElement(connector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.OPERATOR: {
                Operator operator = (Operator)theEObject;
                T result = caseOperator(operator);
                if (result == null) result = caseConnectableElement(operator);
                if (result == null) result = caseSchemaElement(operator);
                if (result == null) result = caseNamedElement(operator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.CONNECTABLE_ELEMENT: {
                ConnectableElement connectableElement = (ConnectableElement)theEObject;
                T result = caseConnectableElement(connectableElement);
                if (result == null) result = caseSchemaElement(connectableElement);
                if (result == null) result = caseNamedElement(connectableElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.ACTION_PROXY: {
                ActionProxy actionProxy = (ActionProxy)theEObject;
                T result = caseActionProxy(actionProxy);
                if (result == null) result = caseAction(actionProxy);
                if (result == null) result = caseConnectableElement(actionProxy);
                if (result == null) result = caseAbstractAction(actionProxy);
                if (result == null) result = caseSchemaElement(actionProxy);
                if (result == null) result = caseNamedElement(actionProxy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.STATUS_VALUE_PROXY: {
                StatusValueProxy statusValueProxy = (StatusValueProxy)theEObject;
                T result = caseStatusValueProxy(statusValueProxy);
                if (result == null) result = caseStatusValue(statusValueProxy);
                if (result == null) result = caseConnectableElement(statusValueProxy);
                if (result == null) result = caseAbstractStatusValue(statusValueProxy);
                if (result == null) result = caseSchemaElement(statusValueProxy);
                if (result == null) result = caseNamedElement(statusValueProxy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.TRANSITION: {
                Transition transition = (Transition)theEObject;
                T result = caseTransition(transition);
                if (result == null) result = caseConnector(transition);
                if (result == null) result = caseSchemaElement(transition);
                if (result == null) result = caseNamedElement(transition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.SYNCHRONISER: {
                Synchroniser synchroniser = (Synchroniser)theEObject;
                T result = caseSynchroniser(synchroniser);
                if (result == null) result = caseConnector(synchroniser);
                if (result == null) result = caseSchemaElement(synchroniser);
                if (result == null) result = caseNamedElement(synchroniser);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.PRECONDITION: {
                Precondition precondition = (Precondition)theEObject;
                T result = casePrecondition(precondition);
                if (result == null) result = caseConnector(precondition);
                if (result == null) result = caseSchemaElement(precondition);
                if (result == null) result = caseNamedElement(precondition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.STATUS_VARIABLE_PROXY: {
                StatusVariableProxy statusVariableProxy = (StatusVariableProxy)theEObject;
                T result = caseStatusVariableProxy(statusVariableProxy);
                if (result == null) result = caseStatusVariable(statusVariableProxy);
                if (result == null) result = caseConnectableElement(statusVariableProxy);
                if (result == null) result = caseAbstractStatusVariable(statusVariableProxy);
                if (result == null) result = caseSchemaElement(statusVariableProxy);
                if (result == null) result = caseNamedElement(statusVariableProxy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.AND_OPERATOR: {
                AndOperator andOperator = (AndOperator)theEObject;
                T result = caseAndOperator(andOperator);
                if (result == null) result = caseOperator(andOperator);
                if (result == null) result = caseConnectableElement(andOperator);
                if (result == null) result = caseSchemaElement(andOperator);
                if (result == null) result = caseNamedElement(andOperator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.OR_OPERATOR: {
                OrOperator orOperator = (OrOperator)theEObject;
                T result = caseOrOperator(orOperator);
                if (result == null) result = caseOperator(orOperator);
                if (result == null) result = caseConnectableElement(orOperator);
                if (result == null) result = caseSchemaElement(orOperator);
                if (result == null) result = caseNamedElement(orOperator);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.REQUIRED_STRATEGY: {
                RequiredStrategy requiredStrategy = (RequiredStrategy)theEObject;
                T result = caseRequiredStrategy(requiredStrategy);
                if (result == null) result = caseStrategy(requiredStrategy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.NEUTRAL_STRATEGY: {
                NeutralStrategy neutralStrategy = (NeutralStrategy)theEObject;
                T result = caseNeutralStrategy(neutralStrategy);
                if (result == null) result = caseStrategy(neutralStrategy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.ENABLING_STRATEGY: {
                EnablingStrategy enablingStrategy = (EnablingStrategy)theEObject;
                T result = caseEnablingStrategy(enablingStrategy);
                if (result == null) result = caseStrategy(enablingStrategy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.INHIBITING_STRATEGY: {
                InhibitingStrategy inhibitingStrategy = (InhibitingStrategy)theEObject;
                T result = caseInhibitingStrategy(inhibitingStrategy);
                if (result == null) result = caseStrategy(inhibitingStrategy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.STRATEGY: {
                Strategy strategy = (Strategy)theEObject;
                T result = caseStrategy(strategy);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AssemblyPackage.SCHEMA_ELEMENT: {
                SchemaElement schemaElement = (SchemaElement)theEObject;
                T result = caseSchemaElement(schemaElement);
                if (result == null) result = caseNamedElement(schemaElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Status Schema</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Status Schema</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatusSchema(StatusSchema object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConnector(Connector object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOperator(Operator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Connectable Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connectable Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConnectableElement(ConnectableElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Action Proxy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Action Proxy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseActionProxy(ActionProxy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Status Value Proxy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Status Value Proxy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatusValueProxy(StatusValueProxy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTransition(Transition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Synchroniser</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Synchroniser</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSynchroniser(Synchroniser object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Precondition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Precondition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePrecondition(Precondition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Status Variable Proxy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Status Variable Proxy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStatusVariableProxy(StatusVariableProxy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>And Operator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>And Operator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAndOperator(AndOperator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Or Operator</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Or Operator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseOrOperator(OrOperator object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Required Strategy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Required Strategy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRequiredStrategy(RequiredStrategy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Neutral Strategy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Neutral Strategy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNeutralStrategy(NeutralStrategy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Enabling Strategy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enabling Strategy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEnablingStrategy(EnablingStrategy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Inhibiting Strategy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Inhibiting Strategy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInhibitingStrategy(InhibitingStrategy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Strategy</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Strategy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseStrategy(Strategy object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Schema Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Schema Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSchemaElement(SchemaElement object) {
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

} //AssemblySwitch

/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessComponentInteraction.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package integration.processintegration;

import behavioral.events.Subscription;

import dataaccess.expressions.MethodCallExpression;

import modelmanagement.processcomponents.ProcessComponent;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Component Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link integration.processintegration.ProcessComponentInteraction#getInitiatorProcessComponent <em>Initiator Process Component</em>}</li>
 *   <li>{@link integration.processintegration.ProcessComponentInteraction#getProcessComponent <em>Process Component</em>}</li>
 *   <li>{@link integration.processintegration.ProcessComponentInteraction#getUses <em>Uses</em>}</li>
 *   <li>{@link integration.processintegration.ProcessComponentInteraction#getMethodCalls <em>Method Calls</em>}</li>
 *   <li>{@link integration.processintegration.ProcessComponentInteraction#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see integration.processintegration.ProcessintegrationPackage#getProcessComponentInteraction()
 * @model
 * @generated
 */
public interface ProcessComponentInteraction extends EObject {
	/**
     * Returns the value of the '<em><b>Initiator Process Component</b></em>' reference.
     * It is bidirectional and its opposite is '{@link modelmanagement.processcomponents.ProcessComponent#getInitiatedInteractions <em>Initiated Interactions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiator Process Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Initiator Process Component</em>' reference.
     * @see #setInitiatorProcessComponent(ProcessComponent)
     * @see integration.processintegration.ProcessintegrationPackage#getProcessComponentInteraction_InitiatorProcessComponent()
     * @see modelmanagement.processcomponents.ProcessComponent#getInitiatedInteractions
     * @model opposite="initiatedInteractions" required="true"
     * @generated
     */
	ProcessComponent getInitiatorProcessComponent();

	/**
     * Sets the value of the '{@link integration.processintegration.ProcessComponentInteraction#getInitiatorProcessComponent <em>Initiator Process Component</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initiator Process Component</em>' reference.
     * @see #getInitiatorProcessComponent()
     * @generated
     */
	void setInitiatorProcessComponent(ProcessComponent value);

	/**
     * Returns the value of the '<em><b>Process Component</b></em>' reference.
     * It is bidirectional and its opposite is '{@link modelmanagement.processcomponents.ProcessComponent#getInteractions <em>Interactions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Process Component</em>' reference.
     * @see #setProcessComponent(ProcessComponent)
     * @see integration.processintegration.ProcessintegrationPackage#getProcessComponentInteraction_ProcessComponent()
     * @see modelmanagement.processcomponents.ProcessComponent#getInteractions
     * @model opposite="interactions" required="true"
     * @generated
     */
	ProcessComponent getProcessComponent();

	/**
     * Sets the value of the '{@link integration.processintegration.ProcessComponentInteraction#getProcessComponent <em>Process Component</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process Component</em>' reference.
     * @see #getProcessComponent()
     * @generated
     */
	void setProcessComponent(ProcessComponent value);

	/**
     * Returns the value of the '<em><b>Uses</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link integration.processintegration.IntegrationScenario#getInteractions <em>Interactions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Uses</em>' container reference.
     * @see #setUses(IntegrationScenario)
     * @see integration.processintegration.ProcessintegrationPackage#getProcessComponentInteraction_Uses()
     * @see integration.processintegration.IntegrationScenario#getInteractions
     * @model opposite="interactions"
     * @generated
     */
	IntegrationScenario getUses();

	/**
     * Sets the value of the '{@link integration.processintegration.ProcessComponentInteraction#getUses <em>Uses</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uses</em>' container reference.
     * @see #getUses()
     * @generated
     */
	void setUses(IntegrationScenario value);

	/**
     * Returns the value of the '<em><b>Method Calls</b></em>' reference list.
     * The list contents are of type {@link dataaccess.expressions.MethodCallExpression}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Calls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Method Calls</em>' reference list.
     * @see integration.processintegration.ProcessintegrationPackage#getProcessComponentInteraction_MethodCalls()
     * @model
     * @generated
     */
	EList<MethodCallExpression> getMethodCalls();

	/**
     * Returns the value of the '<em><b>Subscriptions</b></em>' reference list.
     * The list contents are of type {@link behavioral.events.Subscription}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscriptions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Subscriptions</em>' reference list.
     * @see integration.processintegration.ProcessintegrationPackage#getProcessComponentInteraction_Subscriptions()
     * @model
     * @generated
     */
	EList<Subscription> getSubscriptions();

} // ProcessComponentInteraction

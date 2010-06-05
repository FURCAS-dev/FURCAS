/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.processintegration;

import behavioral.events.Subscription;

import dataaccess.expressions.MethodCallExpression;

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

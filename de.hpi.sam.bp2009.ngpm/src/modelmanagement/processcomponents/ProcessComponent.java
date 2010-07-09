/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.processcomponents;

import behavioral.events.EventProducer;

import data.classes.SapClass;

import integration.processintegration.ProcessComponentInteraction;

import modelmanagement.PackageOwner;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelmanagement.processcomponents.ProcessComponent#getProvidedInterfaces <em>Provided Interfaces</em>}</li>
 *   <li>{@link modelmanagement.processcomponents.ProcessComponent#getEventProducers <em>Event Producers</em>}</li>
 *   <li>{@link modelmanagement.processcomponents.ProcessComponent#getInteractions <em>Interactions</em>}</li>
 *   <li>{@link modelmanagement.processcomponents.ProcessComponent#getInitiatedInteractions <em>Initiated Interactions</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent()
 * @model abstract="true"
 * @generated
 */
public interface ProcessComponent extends PackageOwner {
	/**
	 * Returns the value of the '<em><b>Provided Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link data.classes.SapClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interfaces</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interfaces</em>' containment reference list.
	 * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_ProvidedInterfaces()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SapClass> getProvidedInterfaces();

	/**
	 * Returns the value of the '<em><b>Event Producers</b></em>' containment reference list.
	 * The list contents are of type {@link behavioral.events.EventProducer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Producers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Producers</em>' containment reference list.
	 * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_EventProducers()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EventProducer> getEventProducers();

	/**
	 * Returns the value of the '<em><b>Interactions</b></em>' containment reference list.
	 * The list contents are of type {@link integration.processintegration.ProcessComponentInteraction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interactions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interactions</em>' containment reference list.
	 * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_Interactions()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ProcessComponentInteraction> getInteractions();

	/**
	 * Returns the value of the '<em><b>Initiated Interactions</b></em>' containment reference list.
	 * The list contents are of type {@link integration.processintegration.ProcessComponentInteraction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiated Interactions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiated Interactions</em>' containment reference list.
	 * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_InitiatedInteractions()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ProcessComponentInteraction> getInitiatedInteractions();

} // ProcessComponent

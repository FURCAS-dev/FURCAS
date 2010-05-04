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
public interface ProcessComponent extends PackageOwner
{
  /**
   * Returns the value of the '<em><b>Provided Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Provided Interfaces</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Provided Interfaces</em>' containment reference.
   * @see #setProvidedInterfaces(SapClass)
   * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_ProvidedInterfaces()
   * @model containment="true"
   * @generated
   */
  SapClass getProvidedInterfaces();

  /**
   * Sets the value of the '{@link modelmanagement.processcomponents.ProcessComponent#getProvidedInterfaces <em>Provided Interfaces</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Provided Interfaces</em>' containment reference.
   * @see #getProvidedInterfaces()
   * @generated
   */
  void setProvidedInterfaces(SapClass value);

  /**
   * Returns the value of the '<em><b>Event Producers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event Producers</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event Producers</em>' containment reference.
   * @see #setEventProducers(EventProducer)
   * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_EventProducers()
   * @model containment="true"
   * @generated
   */
  EventProducer getEventProducers();

  /**
   * Sets the value of the '{@link modelmanagement.processcomponents.ProcessComponent#getEventProducers <em>Event Producers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event Producers</em>' containment reference.
   * @see #getEventProducers()
   * @generated
   */
  void setEventProducers(EventProducer value);

  /**
   * Returns the value of the '<em><b>Interactions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interactions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interactions</em>' containment reference.
   * @see #setInteractions(ProcessComponentInteraction)
   * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_Interactions()
   * @model containment="true"
   * @generated
   */
  ProcessComponentInteraction getInteractions();

  /**
   * Sets the value of the '{@link modelmanagement.processcomponents.ProcessComponent#getInteractions <em>Interactions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interactions</em>' containment reference.
   * @see #getInteractions()
   * @generated
   */
  void setInteractions(ProcessComponentInteraction value);

  /**
   * Returns the value of the '<em><b>Initiated Interactions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initiated Interactions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initiated Interactions</em>' containment reference.
   * @see #setInitiatedInteractions(ProcessComponentInteraction)
   * @see modelmanagement.processcomponents.ProcesscomponentsPackage#getProcessComponent_InitiatedInteractions()
   * @model containment="true"
   * @generated
   */
  ProcessComponentInteraction getInitiatedInteractions();

  /**
   * Sets the value of the '{@link modelmanagement.processcomponents.ProcessComponent#getInitiatedInteractions <em>Initiated Interactions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initiated Interactions</em>' containment reference.
   * @see #getInitiatedInteractions()
   * @generated
   */
  void setInitiatedInteractions(ProcessComponentInteraction value);

} // ProcessComponent

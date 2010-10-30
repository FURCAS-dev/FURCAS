/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.events;

import data.classes.SapClass;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subscription</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents an EventConsumer's interest in being notified about occurrences of events produced by one or more EventProducers. The subscription can specify rules that constrain which events the consumer is interested in. It is then the event infrastructure's task to optimize the event forwarding to the consumers appropriately.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.events.Subscription#getProducer <em>Producer</em>}</li>
 *   <li>{@link behavioral.events.Subscription#getFilters <em>Filters</em>}</li>
 *   <li>{@link behavioral.events.Subscription#getSubscribingClass <em>Subscribing Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.events.EventsPackage#getSubscription()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL SubscribingClassMatchProducer='self.producer.notificationSignatures->forAll(ms:data::classes::MethodSignature |\r\n    self.subscribingClass.allSignatures()->exists(s:data::classes::MethodSignature|s.conformsTo(ms)))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SubscribingClassMatchProducer'"
 * @generated
 */
public interface Subscription extends NamedElement {
	/**
     * Returns the value of the '<em><b>Producer</b></em>' reference.
     * It is bidirectional and its opposite is '{@link behavioral.events.EventProducer#getSubscriptions <em>Subscriptions</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Producer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Producer</em>' reference.
     * @see #setProducer(EventProducer)
     * @see behavioral.events.EventsPackage#getSubscription_Producer()
     * @see behavioral.events.EventProducer#getSubscriptions
     * @model opposite="subscriptions" required="true"
     * @generated
     */
	EventProducer getProducer();

	/**
     * Sets the value of the '{@link behavioral.events.Subscription#getProducer <em>Producer</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Producer</em>' reference.
     * @see #getProducer()
     * @generated
     */
	void setProducer(EventProducer value);

	/**
     * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
     * The list contents are of type {@link behavioral.events.EventFilter}.
     * It is bidirectional and its opposite is '{@link behavioral.events.EventFilter#getSubscription <em>Subscription</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Filters</em>' containment reference list.
     * @see behavioral.events.EventsPackage#getSubscription_Filters()
     * @see behavioral.events.EventFilter#getSubscription
     * @model opposite="subscription" containment="true" resolveProxies="true"
     * @generated
     */
	EList<EventFilter> getFilters();

	/**
     * Returns the value of the '<em><b>Subscribing Class</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getSubscription <em>Subscription</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscribing Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Subscribing Class</em>' container reference.
     * @see #setSubscribingClass(SapClass)
     * @see behavioral.events.EventsPackage#getSubscription_SubscribingClass()
     * @see data.classes.SapClass#getSubscription
     * @model opposite="subscription" required="true"
     * @generated
     */
	SapClass getSubscribingClass();

	/**
     * Sets the value of the '{@link behavioral.events.Subscription#getSubscribingClass <em>Subscribing Class</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Subscribing Class</em>' container reference.
     * @see #getSubscribingClass()
     * @generated
     */
	void setSubscribingClass(SapClass value);

} // Subscription

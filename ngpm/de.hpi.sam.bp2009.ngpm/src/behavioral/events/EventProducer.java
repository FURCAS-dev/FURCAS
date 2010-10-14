/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.events;

import data.classes.MethodSignature;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Producer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.events.EventProducer#getSubscriptions <em>Subscriptions</em>}</li>
 *   <li>{@link behavioral.events.EventProducer#getNotificationSignatures <em>Notification Signatures</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.events.EventsPackage#getEventProducer()
 * @model abstract="true"
 * @generated
 */
public interface EventProducer extends EObject {
	/**
     * Returns the value of the '<em><b>Subscriptions</b></em>' reference list.
     * The list contents are of type {@link behavioral.events.Subscription}.
     * It is bidirectional and its opposite is '{@link behavioral.events.Subscription#getProducer <em>Producer</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscriptions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Subscriptions</em>' reference list.
     * @see behavioral.events.EventsPackage#getEventProducer_Subscriptions()
     * @see behavioral.events.Subscription#getProducer
     * @model opposite="producer"
     * @generated
     */
	EList<Subscription> getSubscriptions();

	/**
     * Returns the value of the '<em><b>Notification Signatures</b></em>' containment reference list.
     * The list contents are of type {@link data.classes.MethodSignature}.
     * It is bidirectional and its opposite is '{@link data.classes.MethodSignature#getProducer <em>Producer</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification Signatures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Notification Signatures</em>' containment reference list.
     * @see behavioral.events.EventsPackage#getEventProducer_NotificationSignatures()
     * @see data.classes.MethodSignature#getProducer
     * @model opposite="producer" containment="true" resolveProxies="true"
     * @generated
     */
	EList<MethodSignature> getNotificationSignatures();

} // EventProducer

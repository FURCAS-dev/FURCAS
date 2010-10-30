/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.events;

import behavioral.actions.Block;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * From Holger's slides:
 * 
 * Event Patterns:
 * An event pattern is a decision rule that describes how to match a certain set of events
 * Each match is a (partially ordered) set of events that is an instance of the event pattern constructed by replacing variables in the pattern with values
 * It is similar to mathematical language for logical expressions
 * The main features of an event pattern language are (in order of complexity):
 * Basic event patterns to express patterns that match single event types
 * Content-based event matching in terms of the event type’s attributes
 * Pattern operators for expressing relationships between events
 * Like logical operators, set operators, structural operators (causes, is independent of, before)
 * Context that restricts matches of patterns to specific contexts in which events are observed
 * Context refers to information outside the events
 * Temporal operators to specify the timing of events that match a pattern, or when a pattern should or should not match
 * Like “at”, “after”, “during”
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link behavioral.events.EventFilter#getSubscription <em>Subscription</em>}</li>
 *   <li>{@link behavioral.events.EventFilter#getTest <em>Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see behavioral.events.EventsPackage#getEventFilter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL FilterBlockSignatureMatchNotificationSignature='self.subscription.producer.notificationSignatures->exists(ms:data::classes::MethodSignature |\r\n    ms.conformsTo(self.test.getImplementedSignature()))'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FilterBlockSignatureMatchNotificationSignature'"
 * @generated
 */
public interface EventFilter extends EObject {
	/**
     * Returns the value of the '<em><b>Subscription</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link behavioral.events.Subscription#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscription</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Subscription</em>' container reference.
     * @see #setSubscription(Subscription)
     * @see behavioral.events.EventsPackage#getEventFilter_Subscription()
     * @see behavioral.events.Subscription#getFilters
     * @model opposite="filters" required="true"
     * @generated
     */
	Subscription getSubscription();

	/**
     * Sets the value of the '{@link behavioral.events.EventFilter#getSubscription <em>Subscription</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Subscription</em>' container reference.
     * @see #getSubscription()
     * @generated
     */
	void setSubscription(Subscription value);

	/**
     * Returns the value of the '<em><b>Test</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Test</em>' containment reference.
     * @see #setTest(Block)
     * @see behavioral.events.EventsPackage#getEventFilter_Test()
     * @model containment="true" resolveProxies="true" required="true"
     *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='filter'"
     * @generated
     */
	Block getTest();

	/**
     * Sets the value of the '{@link behavioral.events.EventFilter#getTest <em>Test</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Test</em>' containment reference.
     * @see #getTest()
     * @generated
     */
	void setTest(Block value);

} // EventFilter

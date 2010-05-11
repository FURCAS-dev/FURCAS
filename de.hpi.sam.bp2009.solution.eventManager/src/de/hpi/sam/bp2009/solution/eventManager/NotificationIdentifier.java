/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getNotifierClassURI <em>Notifier Class URI</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getEventType <em>Event Type</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getFeatureURI <em>Feature URI</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getOldValueClassURIs <em>Old Value Class UR Is</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getNewValueClassURIs <em>New Value Class UR Is</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#isTouch <em>Touch</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#isReset <em>Reset</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#isContainment <em>Containment</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier()
 * @model
 * @generated
 */
public interface NotificationIdentifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Notifier Class URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifier Class URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifier Class URI</em>' attribute.
	 * @see #setNotifierClassURI(URI)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_NotifierClassURI()
	 * @model dataType="de.hpi.sam.bp2009.solution.eventManager.URI"
	 * @generated
	 */
	URI getNotifierClassURI();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getNotifierClassURI <em>Notifier Class URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notifier Class URI</em>' attribute.
	 * @see #getNotifierClassURI()
	 * @generated
	 */
	void setNotifierClassURI(URI value);

	/**
	 * Returns the value of the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type</em>' attribute.
	 * @see #setEventType(int)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_EventType()
	 * @model
	 * @generated
	 */
	int getEventType();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getEventType <em>Event Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type</em>' attribute.
	 * @see #getEventType()
	 * @generated
	 */
	void setEventType(int value);

	/**
	 * Returns the value of the '<em><b>Feature URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Class URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature URI</em>' attribute.
	 * @see #setFeatureURI(URI)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_FeatureURI()
	 * @model dataType="de.hpi.sam.bp2009.solution.eventManager.URI"
	 * @generated
	 */
	URI getFeatureURI();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getFeatureURI <em>Feature URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature URI</em>' attribute.
	 * @see #getFeatureURI()
	 * @generated
	 */
	void setFeatureURI(URI value);

	/**
	 * Returns the value of the '<em><b>Old Value Class UR Is</b></em>' attribute.
	 * The default value is <code>"new HashSet<URI>()"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value Class UR Is</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value Class UR Is</em>' attribute.
	 * @see #setOldValueClassURIs(Set)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_OldValueClassURIs()
	 * @model default="new HashSet<URI>()" dataType="de.hpi.sam.bp2009.solution.eventManager.URISet" transient="true" ordered="false"
	 * @generated
	 */
	Set<URI> getOldValueClassURIs();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getOldValueClassURIs <em>Old Value Class UR Is</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value Class UR Is</em>' attribute.
	 * @see #getOldValueClassURIs()
	 * @generated
	 */
	void setOldValueClassURIs(Set<URI> value);

	/**
	 * Returns the value of the '<em><b>New Value Class UR Is</b></em>' attribute.
	 * The default value is <code>"new HashSet<URI>()"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value Class UR Is</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value Class UR Is</em>' attribute.
	 * @see #setNewValueClassURIs(Set)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_NewValueClassURIs()
	 * @model default="new HashSet<URI>()" dataType="de.hpi.sam.bp2009.solution.eventManager.URISet" transient="true" ordered="false"
	 * @generated
	 */
	Set<URI> getNewValueClassURIs();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getNewValueClassURIs <em>New Value Class UR Is</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value Class UR Is</em>' attribute.
	 * @see #getNewValueClassURIs()
	 * @generated
	 */
	void setNewValueClassURIs(Set<URI> value);

	/**
	 * Returns the value of the '<em><b>Touch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Touch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Touch</em>' attribute.
	 * @see #setTouch(boolean)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_Touch()
	 * @model
	 * @generated
	 */
	boolean isTouch();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#isTouch <em>Touch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Touch</em>' attribute.
	 * @see #isTouch()
	 * @generated
	 */
	void setTouch(boolean value);

	/**
	 * Returns the value of the '<em><b>Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset</em>' attribute.
	 * @see #setReset(boolean)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_Reset()
	 * @model
	 * @generated
	 */
	boolean isReset();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#isReset <em>Reset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset</em>' attribute.
	 * @see #isReset()
	 * @generated
	 */
	void setReset(boolean value);

	/**
	 * Returns the value of the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment</em>' attribute.
	 * @see #setContainment(boolean)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getNotificationIdentifier_Containment()
	 * @model
	 * @generated
	 */
	boolean isContainment();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#isContainment <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment</em>' attribute.
	 * @see #isContainment()
	 * @generated
	 */
	void setContainment(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getHash();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	NotificationIdentifier clone();

} // NotificationIdentifier

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Notification Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getHash() <em>Get Hash</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#clone() <em>Clone</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class NotificationIdentifierTest extends TestCase {

	/**
	 * The fixture for this Notification Identifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationIdentifier fixture = null;
	private NotificationIdentifier id1;
	private NotificationIdentifier id2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NotificationIdentifierTest.class);
	}

	/**
	 * Constructs a new Notification Identifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationIdentifierTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Notification Identifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(NotificationIdentifier fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Notification Identifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationIdentifier getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EventManagerFactory.eINSTANCE.createNotificationIdentifier());
		id1 = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		id1.setContainment(true);
		id1.setEventType(Notification.ADD);
		id1.setReset(true);
		id1.getNewValueClassURIs();
		
		id2 = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		id2.setContainment(true);
		id2.setEventType(Notification.ADD);
		id2.setReset(true);
		id2.getNewValueClassURIs();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
		id1 = null;
		id2 = null;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getHash() <em>Get Hash</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#getHash()
	 * @generated NOT
	 */
	public void testGetHash() {
		assertEquals(id1, id2);
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#clone() <em>Clone</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier#clone()
	 * @generated NOT
	 */
	public void testClone() {
		assertEquals(id1, id1.clone());
	}

} //NotificationIdentifierTest

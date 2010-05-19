/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventTypeFilter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event Type Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventTypeFilterTest extends EventFilterTest {

	private int eventType;
	private NotificationIdentifier identifier;
	private NotificationImpl notification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EventTypeFilterTest.class);
	}


	/**
	 * Constructs a new Event Type Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EventTypeFilterTest() {
		super();
	}


	/**
	 * Returns the fixture for this Event Type Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EventTypeFilter getFixture() {
		return (EventTypeFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	public void setUp()   {
		setFixture(EventManagerFactory.eINSTANCE.createEventTypeFilter());
		eventType = Notification.ADD;
		identifier = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		notification = new NotificationImpl(eventType, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	public void tearDown()  {
		setFixture(null);
		eventType = -1;
		identifier = null;
		notification = null;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 * @generated NOT
	 */
	public void testMatchesFor__Notification() {
		getFixture().setEventType(new Integer(eventType));
		assertTrue(getFixture().matchesFor(notification));
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier) <em>Build Notification Identifiers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier)
	 * @generated NOT
	 */
	public void testBuildNotificationIdentifiers__NotificationIdentifier() {
		getFixture().setEventType(new Integer(eventType));
		assertTrue(getFixture().buildNotificationIdentifiers(identifier).size() ==1);
		assertTrue(identifier.getEventType() == eventType);
	}

} //EventTypeFilterTest

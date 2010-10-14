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
import de.hpi.sam.bp2009.solution.eventManager.filters.EventTypeFilter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event Type Filter</b></em>'.
 * <!-- end-user-doc -->
 */
public class EventTypeFilterTest extends EventFilterTest {
	private NotificationImpl notification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(EventTypeFilterTest.class);
	}


	/**
	 * Constructs a new Event Type Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EventTypeFilterTest() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp()   {
		notification = new NotificationImpl(Notification.ADD, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown()  {
		setFixture(null);
		notification = null;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 */
	public void testMatchesFor__Notification() {
		EventTypeFilter filter = EventManagerFactory.eINSTANCE.createEventTypeFilter(Notification.ADD);
		assertTrue(filter.matchesFor(notification));
	}

} //EventTypeFilterTest

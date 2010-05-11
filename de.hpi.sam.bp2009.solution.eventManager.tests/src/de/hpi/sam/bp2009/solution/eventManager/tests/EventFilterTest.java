/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier) <em>Build Notification Identifiers</em>}</li>
 * </ul>
 * </p>
 * @generated NOT
 */
public abstract class EventFilterTest extends BaseDepartmentTest {

	/**
	 * The fixture for this Event Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventFilter fixture = null;

	/**
	 * Sets the fixture for this Event Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EventFilter fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Event Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventFilter getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 * @generated NOT
	 */
	abstract public void testMatchesFor__Notification();

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier) <em>Build Notification Identifiers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#buildNotificationIdentifiers(de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier)
	 * @generated
	 */
	abstract public void testBuildNotificationIdentifiers__NotificationIdentifier();

} //EventFilterTest

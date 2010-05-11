/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Or Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class OrFilterTest extends AndFilterTest {

	public OrFilterTest() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OrFilterTest.class);
	}

	/**
	 * Returns the fixture for this Or Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generatedNOT
	 */
	protected OrFilter getFixtureOR() {
		return (OrFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	public void setUp()   {
		super.setUp();
		setFixture(EventManagerFactory.eINSTANCE.createOrFilter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	public void tearDown()   {
		setFixture(null);
		super.tearDown();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 * @generated NOT
	 */
	public void testMatchesFor__NotificationTwoTrue() {
		getFixtureOR().getFilters().add(trueFilter);
		getFixtureOR().getFilters().add(trueFilter);
		assertTrue("Two true is true", getFixtureOR().matchesFor(null));
	}
	public void testMatchesFor__NotificationTwoFalse() {
		getFixtureOR().getFilters().add(falseFilter);
		getFixtureOR().getFilters().add(falseFilter);
		assertFalse("Two false is false", getFixtureOR().matchesFor(null));
	}
	public void testMatchesFor__Notification() {
		getFixtureOR().getFilters().add(falseFilter);
		getFixtureOR().getFilters().add(trueFilter);
		assertTrue("Two true/false is true", getFixtureOR().matchesFor(null));
	}

	public void testBuildNotificationIdentifiers__NotificationIdentifier() {
		getFixtureOR().getFilters().add(falseFilter);
		getFixtureOR().getFilters().add(trueFilter);
		NotificationIdentifier id = EventManagerFactory.eINSTANCE.createNotificationIdentifier();
		EList<NotificationIdentifier> result = getFixtureOR().buildNotificationIdentifiers(id);
		assertTrue(result.size()== 2);
		assertTrue(result.contains(id));
		id.setEventType(666);
		assertTrue(result.contains(id));

	}

} //OrFilterTest

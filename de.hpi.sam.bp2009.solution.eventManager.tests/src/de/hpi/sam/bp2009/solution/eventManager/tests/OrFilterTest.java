/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Or Filter</b></em>'.
 * <!-- end-user-doc -->
 */
public class OrFilterTest extends AndFilterTest {

	public OrFilterTest() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(OrFilterTest.class);
	}

	/**
	 * Returns the fixture for this Or Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected LogicalOperationFilter getFixtureOR() {
		return (LogicalOperationFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
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
	 */
	@Override
	public void tearDown()   {
		setFixture(null);
		super.tearDown();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification) <em>Matches For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter#matchesFor(org.eclipse.emf.common.notify.Notification)
	 */
	public void testMatchesFor__NotificationTwoTrue() {
		getFixtureOR().getOperands().add(trueFilter);
		getFixtureOR().getOperands().add(trueFilter);
		assertTrue("Two true is true", getFixtureOR().matchesFor(null));
	}
	public void testMatchesFor__NotificationTwoFalse() {
		getFixtureOR().getOperands().add(falseFilter);
		getFixtureOR().getOperands().add(falseFilter);
		assertFalse("Two false is false", getFixtureOR().matchesFor(null));
	}
	public void testMatchesFor__Notification() {
		getFixtureOR().getOperands().add(falseFilter);
		getFixtureOR().getOperands().add(trueFilter);
		assertTrue("Two true/false is true", getFixtureOR().matchesFor(null));
	}

} //OrFilterTest

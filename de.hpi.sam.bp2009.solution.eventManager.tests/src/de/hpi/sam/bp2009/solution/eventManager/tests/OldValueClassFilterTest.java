/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Notification;

import company.CompanyFactory;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Old Value Class Filter</b></em>'.
 * <!-- end-user-doc -->
 */
public class OldValueClassFilterTest extends EventFilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(OldValueClassFilterTest.class);
	}

	/**
	 * Constructs a new Old Value Class Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public OldValueClassFilterTest() {
		super();
	}

	private Notification noti;

	/**
	 * Returns the fixture for this Old Value Class Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected OldValueClassFilter getFixture() {
		return (OldValueClassFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
		setFixture(EventManagerFactory.eINSTANCE.createOldValueClassFilter());
		super.setUp();
		this.createInstances( 1, 5, 1 );

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown() {
		setFixture(null);
		super.tearDown();
	}

	@Override
	public void testMatchesFor__Notification() {
		noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef,CompanyFactory.eINSTANCE.createEmployee());
		noti = NotificationHelper.createReferenceAddNotification(this.aDepartment, this.bossRef,CompanyFactory.eINSTANCE.createEmployee());

		getFixture().setWantedClass(employee);
		assertTrue("No Match to Notification",getFixture().matchesFor(noti));
		this.aDivision.getDepartment().clear();
		noti = NotificationHelper.createReferenceAddNotification(this.aDivision, this.departmentRef,CompanyFactory.eINSTANCE.createDepartment());
		assertFalse(getFixture().matchesFor(noti));

	}

} //OldValueClassFilterTest

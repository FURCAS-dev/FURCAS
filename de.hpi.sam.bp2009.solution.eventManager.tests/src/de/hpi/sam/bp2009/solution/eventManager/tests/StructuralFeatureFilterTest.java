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

import de.hpi.sam.bp2009.solution.eventManager.filters.StructuralFeatureFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.NotificationHelper;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Structural Feature Filter</b></em>'.
 * <!-- end-user-doc -->
 */
public abstract class StructuralFeatureFilterTest extends EventFilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(StructuralFeatureFilterTest.class);
	}


	/**
	 * Constructs a new Structural Feature Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public StructuralFeatureFilterTest() {
		super();
	}


	private Notification noti;


	/**
	 * Returns the fixture for this Structural Feature Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected StructuralFeatureFilter getFixture() {
		return (StructuralFeatureFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp() {
//		setFixture(EventManagerFactory.eINSTANCE.createStructuralFeatureFilter());
		super.setUp();
		this.createInstances( 1, 5, 1 );
		noti = NotificationHelper.createReferenceAddNotification(aDivision, departmentRef, CompanyFactory.eINSTANCE.createDepartment());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown() {
		setFixture(null);
	}


	@Override
	public void testMatchesFor__Notification() {
		getFixture().setFeature(this.departmentRef);
		assertTrue(getFixture().matchesFor(noti));
		getFixture().setFeature(this.directedRef);
		assertFalse(getFixture().matchesFor(noti));
	}


} //StructuralFeatureFilterTest
